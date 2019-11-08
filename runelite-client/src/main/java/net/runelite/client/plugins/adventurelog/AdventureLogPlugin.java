/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.adventurelog;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.inject.Inject;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.AdventureLogSubmission;
import net.runelite.client.events.LevelUp;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.adventurelog.datatypes.BossKillData;
import net.runelite.client.plugins.adventurelog.datatypes.ClueData;
import net.runelite.client.plugins.adventurelog.datatypes.DiaryCompletionData;
import net.runelite.client.plugins.adventurelog.datatypes.LevelUpData;
import net.runelite.client.plugins.adventurelog.datatypes.MinigameData;
import net.runelite.client.plugins.adventurelog.datatypes.PetData;
import net.runelite.client.plugins.adventurelog.datatypes.QuestCompletionData;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.Text;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.adventurelog.AdventureLogClient;
import net.runelite.http.api.adventurelog.AdventureLogRecord;
import net.runelite.http.api.worlds.WorldType;

@Slf4j
@PluginDescriptor(
	name = "Adventure Log",
	description = "Logs your achievements to be viewed on the website."
)
public class AdventureLogPlugin extends Plugin
{
	private static final String PET_FOLLOWING_MESSAGE = "You have a funny feeling like you're being followed";
	private static final String PET_BACKPACK_MESSAGE = "You feel something weird sneaking into your backpack";
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails.");
	private static final Pattern DIARY_PATTERN = Pattern.compile("Congratulations! You have completed all of the (.+) tasks in the<br>(.+) area. (?:.+)");
	private static final Pattern KILLCOUNT_PATTERN = Pattern.compile("Your (.+) (?:kill|completion|chest) count is: (\\d+)");
	private static final Pattern PEST_CONTROL_PATTERN = Pattern.compile("Congratulations! You managed to destroy all the portals!<br>We've awarded you (\\d+) Void Knight Commendation<br>points. Please also accept these coins as a reward.");
	private static final String QUEEN_DEAD_MESSAGE = "The Queen is dead!";
	private static final Set<Integer> PEST_CONTROL_CHATBOX_MODEL_IDS = ImmutableSet.of(1771, 1772, 1773);
	private static final Set<WorldType> filteredWorldTypes = ImmutableSet.of(WorldType.MEMBERS, WorldType.PVP,
		WorldType.SKILL_TOTAL, WorldType.HIGH_RISK, WorldType.LAST_MAN_STANDING, WorldType.BOUNTY);
	private static final int BOSS_QUEUE_TIME = 6;	// time that should be waited before submitting boss kills

	@Inject
	private SessionManager sessionManager;

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private ClientThread clientThread;

	private AdventureLogClient adventureLogClient;
	private String hashedUsername;
	private boolean shouldCheckQuestWidget;
	private boolean shouldCheckCastleWarsWidget;
	private int shouldCheckPestControlWidget;
	private boolean shouldCheckPetBackpack;
	private boolean shouldCheckPetFollowing;
	private boolean shouldCheckDiary;
	private boolean shouldCheckBarbAssaultWidget;
	private String clueDifficulty;
	private Set<Item> previousPetsInInv;
	private BossKillData currentBossData;
	private EnumSet<WorldType> bossWorldTypes;
	private Instant timeSinceLastBossKill;
	private final List<AdventureLogRecord> queuedLogs = new ArrayList<>();

	@Override
	protected void startUp() throws Exception
	{
		AccountSession accountSession = sessionManager.getAccountSession();
		if (accountSession != null)
		{
			adventureLogClient = new AdventureLogClient(accountSession.getUuid());
		}

		hashUsername();

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() -> previousPetsInInv = getPetsInInv());
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		reset();
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession accountSession = sessionManager.getAccountSession();
		if (accountSession.getUuid() != null)
		{
			adventureLogClient = new AdventureLogClient(accountSession.getUuid());
		}
		else
		{
			adventureLogClient = null;
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		queueCurrentBoss();
		submitLogs();
		adventureLogClient = null;
	}

	@Subscribe
	public void onAdventureLogSubmission(AdventureLogSubmission event)
	{
		if (event instanceof BossKillData)
		{
			if (currentBossData == null)
			{
				currentBossData = (BossKillData) event;
				timeSinceLastBossKill = Instant.now();
				bossWorldTypes = trimWorldType(WorldUtil.runeliteToHttpWorldTypes(client.getWorldType()));
			}
			else
			{
				BossKillData eventBossData = (BossKillData) event;
				EnumSet<WorldType> currentWorldtypes = trimWorldType(WorldUtil.runeliteToHttpWorldTypes(client.getWorldType()));
				if (currentBossData.getMonster().equals(eventBossData.getMonster())
					&& compareWorldTypes(bossWorldTypes, currentWorldtypes))
				{
					currentBossData.incrementAmount();
					timeSinceLastBossKill = Instant.now();
				}
				else
				{
					queueCurrentBoss();

					currentBossData = eventBossData;
					bossWorldTypes = currentWorldtypes;
					timeSinceLastBossKill = Instant.now();
				}
			}
		}
		else
		{
			if (currentBossData != null)
			{
				queueCurrentBoss();
			}

			AdventureLogRecord record = new AdventureLogRecord(
				event,
				trimWorldType(WorldUtil.runeliteToHttpWorldTypes(client.getWorldType()))
			);
			queueLog(record);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN
			&& hashedUsername == null)
		{
			previousPetsInInv = getPetsInInv();
			hashUsername();
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			queueCurrentBoss();
			submitLogs();
			hashedUsername = null;
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			case (WidgetID.QUEST_COMPLETED_GROUP_ID):
				// widget gets loaded prior to the text being set, so wait until the next tick
				shouldCheckQuestWidget = true;
				break;
			case (WidgetID.CLUE_SCROLL_REWARD_GROUP_ID):
				// clue difficulty should be set via ChatMessage for clue scrolls.
				// Clue Scrolls use same InventoryID as Barrows
				if (clueDifficulty == null)
				{
					return;
				}

				ClueData clueData = new ClueData(
					clueDifficulty,
					client.getItemContainer(InventoryID.BARROWS_REWARD).getItems()
				);
				eventBus.post(clueData);
				break;
			case (WidgetID.DIALOG_SPRITE_GROUP_ID):
				shouldCheckCastleWarsWidget = true;
				break;
			case (WidgetID.DIALOG_NPC_GROUP_ID):
				// This widget is loaded twice for whatever reason, this is the cooldown
				if (shouldCheckPestControlWidget == 0)
				{
					shouldCheckPestControlWidget = 3;
					System.out.println("WIDGET LOADED");
				}
				break;
			case (WidgetID.DIALOG_TEXT_GROUP_ID):
				shouldCheckDiary = true;
				break;
			case (WidgetID.BA_REWARD_GROUP_ID):
				shouldCheckBarbAssaultWidget = true;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		checkQuestWidget();
		checkCastleWarsWidget();
		checkPestControlWidget();
		checkDiary();
		checkBarbAssault();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = Text.removeTags(event.getMessage());
		if (message.contains(PET_FOLLOWING_MESSAGE))
		{
			shouldCheckPetFollowing = true;
		}
		else if (message.contains(PET_BACKPACK_MESSAGE))
		{
			shouldCheckPetBackpack = true;
		}

		Matcher matcher = CLUE_SCROLL_PATTERN.matcher(message);
		if (matcher.find())
		{
			clueDifficulty = matcher.group(1).toLowerCase();
		}

		matcher = KILLCOUNT_PATTERN.matcher(message);
		if (matcher.find())
		{
			String name = matcher.group(1);
			int kc = Integer.parseInt(matcher.group(2));
			BossKillData bossKillData = new BossKillData(
				name,
				kc,
				1
			);
			eventBus.post(bossKillData);
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (!shouldCheckPetFollowing
			|| !Pets.isPet(event.getNpc())
			|| event.getNpc().getInteracting() == null
			|| !event.getNpc().getInteracting().equals(client.getLocalPlayer()))
		{
			return;
		}

		shouldCheckPetFollowing = false;

		int petItemId = Pets.getItemId(event.getNpc());

		PetData petData = new PetData(
			petItemId
		);
		eventBus.post(petData);

	}


	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId())
		{
			return;
		}

		Set<Item> currentPets = getPetsInInv();

		if (shouldCheckPetBackpack)
		{
			Set<Item> difference = Sets.difference(currentPets, previousPetsInInv);

			if (difference.size() > 0)
			{
				Item pet = difference.iterator().next();

				PetData petData = new PetData(
					pet.getId()
				);
				eventBus.post(petData);
			}
		}

		shouldCheckPetBackpack = false;
		previousPetsInInv = currentPets;
	}

	@Subscribe
	public void onLevelUp(LevelUp event)
	{
		LevelUpData levelUpData = new LevelUpData(
			event.getSkill(),
			event.getLevel()
		);
		eventBus.post(levelUpData);
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES,
		asynchronous = true
	)
	public void submitLogsTask()
	{
		shouldQueueCurrentBoss();
		submitLogs();
	}

	private void submitLogs()
	{
		synchronized (queuedLogs)
		{
			if (queuedLogs.isEmpty())
			{
				return;
			}

			adventureLogClient.submit(queuedLogs, hashedUsername);
			queuedLogs.clear();
		}
	}

	private void queueCurrentBoss()
	{
		if (currentBossData == null)
		{
			return;
		}

		AdventureLogRecord record = new AdventureLogRecord(
			currentBossData,
			bossWorldTypes
		);
		queueLog(record);

		currentBossData = null;
		bossWorldTypes = null;
		timeSinceLastBossKill = null;
	}

	private void shouldQueueCurrentBoss()
	{
		if (currentBossData == null)
		{
			return;
		}

		Instant now = Instant.now();

		if (Duration.between(timeSinceLastBossKill, now).toMillis() > (BOSS_QUEUE_TIME * 1000))
		{
			queueCurrentBoss();
		}
	}

	private void queueLog(AdventureLogRecord record)
	{
		synchronized (queuedLogs)
		{
			queuedLogs.add(record);
		}
	}

	private void hashUsername()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		HashFunction hf = Hashing.sha512();
		HashCode hc = hf.newHasher().putString(client.getUsername(), Charset.defaultCharset()).hash();
		hashedUsername = hc.toString();
		configManager.setConfiguration("hash", client.getLocalPlayer().getName(), hashedUsername);
	}

	private void reset()
	{
		queueCurrentBoss();
		submitLogs();
		adventureLogClient = null;
		hashedUsername = null;
		previousPetsInInv = null;
	}

	private Set<Item> getPetsInInv()
	{
		Set<Item> currentPets = new HashSet<>();

		if (client.getItemContainer(InventoryID.INVENTORY) == null)
		{
			return currentPets;
		}

		for (Item item : client.getItemContainer(InventoryID.INVENTORY).getItems())
		{
			if (Pets.isPet(item))
			{
				currentPets.add(item);
			}
		}

		return currentPets;
	}

	private void checkBarbAssault()
	{
		if (!shouldCheckBarbAssaultWidget)
		{
			return;
		}

		shouldCheckBarbAssaultWidget = false;

		Widget widget = client.getWidget(WidgetInfo.BA_QUEEN_TEXT);

		if (widget != null
			&& !widget.isHidden()
			&& widget.getText().equals(QUEEN_DEAD_MESSAGE))
		{
			MinigameData minigameData = new MinigameData(
				"Barbarian Assault",
				null
			);
			eventBus.post(minigameData);
		}
	}

	private void checkDiary()
	{
		if (!shouldCheckDiary)
		{
			return;
		}

		shouldCheckDiary = false;

		Widget widget = client.getWidget(WidgetInfo.DIALOG_TEXT);

		if (widget != null)
		{
			String text = widget.getText();
			Matcher matcher = DIARY_PATTERN.matcher(text);
			if (matcher.find())
			{
				String difficulty = matcher.group(1);
				String region = matcher.group(2);
				DiaryCompletionData diaryCompletionData = new DiaryCompletionData(
					difficulty,
					region
				);
				eventBus.post(diaryCompletionData);
			}
		}

	}

	private void checkQuestWidget()
	{
		if (!shouldCheckQuestWidget)
		{
			return;
		}

		shouldCheckQuestWidget = false;

		Widget widget = client.getWidget(WidgetInfo.QUEST_COMPLETED_NAME_TEXT);
		if (widget != null)
		{
			// "You have completed The Corsair Curse!"
			String text = widget.getText();
			String questName = text.substring(19, text.length() - 1);
			QuestCompletionData questCompletionData = new QuestCompletionData(questName);
			eventBus.post(questCompletionData);
		}
	}

	private void checkCastleWarsWidget()
	{
		if (!shouldCheckCastleWarsWidget)
		{
			return;
		}

		shouldCheckCastleWarsWidget = false;

		Widget textWidget = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		Widget modelWidget = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);

		// make sure this is a castle wars widget
		if (modelWidget.getItemId() != ItemID.CASTLE_WARS_TICKET)
		{
			return;
		}

		if (textWidget != null)
		{
			String text = textWidget.getText();
			String[] lines = text.split("<br>");
			MinigameResults result;
			if (lines[0].equals("You lost!"))
			{
				result = MinigameResults.LOSE;
			}
			else if (lines[0].equals("It was a draw!"))
			{
				result = MinigameResults.DRAW;
			}
			else if (lines[0].equals("You won!"))
			{
				result = MinigameResults.WIN;
			}
			else
			{
				return;
			}
			MinigameData minigameData = new MinigameData(
				"Castle wars",
				result
			);
			eventBus.post(minigameData);
		}
	}

	private void checkPestControlWidget()
	{
		if (shouldCheckPestControlWidget == 0)
		{
			return;
		}

		shouldCheckPestControlWidget--;

		if (shouldCheckPestControlWidget != 2)
		{
			return;
		}

		Widget textWidget = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		Widget modelWidget = client.getWidget(WidgetInfo.DIALOG_NPC_HEAD_MODEL);

		// return if widget is not for pestControl
		if (modelWidget != null && !PEST_CONTROL_CHATBOX_MODEL_IDS.contains(modelWidget.getModelId()))
		{
			return;
		}


		if (textWidget != null)
		{
			String text = textWidget.getText();
			Matcher matcher = PEST_CONTROL_PATTERN.matcher(text);
			if (matcher.find())
			{
				String amount = matcher.group(1);
				String difficulty;
				if (amount.equals("5"))
				{
					difficulty = "Veteran";
				}
				else if (amount.equals("4"))
				{
					difficulty = "Intermediate";
				}
				else if (amount.equals("3"))
				{
					difficulty = "Novice";
				}
				else
				{
					return;
				}

				MinigameData minigameData = new MinigameData(
					"Pest Control (" + difficulty + ")",
					null
				);
				eventBus.post(minigameData);
			}

		}
	}

	private EnumSet<WorldType> trimWorldType(EnumSet<WorldType> worldTypes)
	{
		// remove worldtypes we do not care about
		for (WorldType worldType : filteredWorldTypes)
		{
			worldTypes.remove(worldType);
		}

		if (worldTypes.size() == 0)
		{
			return null;
		}
		return worldTypes;
	}

	private boolean compareWorldTypes(EnumSet<WorldType> worldTypes1, EnumSet<WorldType> worldTypes2)
	{
		if (worldTypes1 == null && worldTypes2 == null)
		{
			return true;
		}

		if (worldTypes1 == null || worldTypes2 == null)
		{
			return false;
		}

		return worldTypes1.equals(worldTypes2);
	}
}
