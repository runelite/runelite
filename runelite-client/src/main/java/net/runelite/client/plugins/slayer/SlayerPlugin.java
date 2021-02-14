/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Integer.max;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import static net.runelite.api.Skill.SLAYER;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.StatChanged;
import net.runelite.api.vars.SlayerUnlock;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;
import net.runelite.http.api.chat.ChatClient;

@PluginDescriptor(
	name = "Slayer",
	description = "Show additional slayer task related information",
	tags = {"combat", "notifications", "overlay", "tasks"}
)
@Slf4j
public class SlayerPlugin extends Plugin
{
	//Chat messages
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("^(?:You're assigned to kill|You have received a new Slayer assignment from .*:) (?:[Tt]he )?(?<name>.+?)(?: (?:in|on|south of) (?:the )?(?<location>[^;]+))?(?:; only | \\()(?<amount>\\d+)(?: more to go\\.|\\))$");
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_COMPLETE_MESSAGE = Pattern.compile("You've completed (?:at least )?(?<tasks>[\\d,]+) (?:Wilderness )?tasks?(?: and received \\d+ points, giving you a total of (?<points>[\\d,]+)| and reached the maximum amount of Slayer points \\((?<points2>[\\d,]+)\\))?");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_CANCEL_MESSAGE_ZUK = "You no longer have a slayer task as you left the Inferno.";
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final String CHAT_BRACELET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer";
	private static final String CHAT_BRACELET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your";
	private static final Pattern COMBAT_BRACELET_TASK_UPDATE_MESSAGE = Pattern.compile("^You still need to kill (\\d+) monsters to complete your current Slayer assignment");

	//NPC messages
	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*(?:Your new task is to kill|You are to bring balance to)\\s*(?<amount>\\d+) (?<name>.+?)(?: (?:in|on|south of) (?:the )?(?<location>.+))?\\.");
	private static final Pattern NPC_ASSIGN_BOSS_MESSAGE = Pattern.compile("^(?:Excellent\\. )?You're now assigned to (?:kill|bring balance to) (?:the )?(.*) (\\d+) times.*Your reward point tally is (.*)\\.$");
	private static final Pattern NPC_ASSIGN_FIRST_MESSAGE = Pattern.compile("^We'll start you off (?:hunting|bringing balance to) (.*), you'll need to kill (\\d*) of them\\.$");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("^You're (?:still(?: meant to be)?|currently assigned to) (?:hunting|bringing balance to|kill|bring balance to|slaying) (?<name>.+?)(?: (?:in|on|south of) (?:the )?(?<location>.+))?(?:, with|; (?:you have|only)) (?<amount>\\d+)(?: more)? to go\\..*");

	//Reward UI
	private static final Pattern REWARD_POINTS = Pattern.compile("Reward points: ((?:\\d+,)*\\d+)");

	private static final int GROTESQUE_GUARDIANS_REGION = 6727;

	// Chat Command
	private static final String TASK_COMMAND_STRING = "!task";
	private static final Pattern TASK_STRING_VALIDATION = Pattern.compile("[^a-zA-Z0-9' -]");
	private static final int TASK_STRING_MAX_LENGTH = 50;

	@Inject
	private Client client;

	@Inject
	private SlayerConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SlayerOverlay overlay;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ClientThread clientThread;

	@Inject
	private TargetClickboxOverlay targetClickboxOverlay;

	@Inject
	private TargetWeaknessOverlay targetWeaknessOverlay;

	@Inject
	private TargetMinimapOverlay targetMinimapOverlay;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private ChatClient chatClient;

	@Getter(AccessLevel.PACKAGE)
	private List<NPC> highlightedTargets = new ArrayList<>();

	private final Set<NPC> taggedNpcs = new HashSet<>();
	private int taggedNpcsDiedPrevTick;
	private int taggedNpcsDiedThisTick;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int amount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int initialAmount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskLocation;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskName;

	private TaskCounter counter;
	private int cachedXp = -1;
	private Instant infoTimer;
	private boolean loginFlag;
	private final List<String> targetNames = new ArrayList<>();

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(targetClickboxOverlay);
		overlayManager.add(targetWeaknessOverlay);
		overlayManager.add(targetMinimapOverlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			cachedXp = client.getSkillExperience(SLAYER);

			migrateConfig();

			if (getIntProfileConfig(SlayerConfig.AMOUNT_KEY) != -1
				&& !getStringProfileConfig(SlayerConfig.TASK_NAME_KEY).isEmpty())
			{
				clientThread.invoke(() -> setTask(getStringProfileConfig(SlayerConfig.TASK_NAME_KEY),
					getIntProfileConfig(SlayerConfig.AMOUNT_KEY),
					getIntProfileConfig(SlayerConfig.INIT_AMOUNT_KEY),
					getStringProfileConfig(SlayerConfig.TASK_LOC_KEY), false));
			}
		}

		chatCommandManager.registerCommandAsync(TASK_COMMAND_STRING, this::taskLookup, this::taskSubmit);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(targetClickboxOverlay);
		overlayManager.remove(targetWeaknessOverlay);
		overlayManager.remove(targetMinimapOverlay);
		removeCounter();
		highlightedTargets.clear();
		taggedNpcs.clear();
		cachedXp = -1;

		chatCommandManager.unregisterCommand(TASK_COMMAND_STRING);
	}

	@Provides
	SlayerConfig provideSlayerConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				cachedXp = -1;
				taskName = "";
				amount = 0;
				loginFlag = true;
				highlightedTargets.clear();
				taggedNpcs.clear();
				break;
			case LOGGED_IN:
				migrateConfig();
				if (getIntProfileConfig(SlayerConfig.AMOUNT_KEY) != -1
					&& !getStringProfileConfig(SlayerConfig.TASK_NAME_KEY).isEmpty()
					&& loginFlag)
				{
					setTask(getStringProfileConfig(SlayerConfig.TASK_NAME_KEY),
						getIntProfileConfig(SlayerConfig.AMOUNT_KEY),
						getIntProfileConfig(SlayerConfig.INIT_AMOUNT_KEY),
						getStringProfileConfig(SlayerConfig.TASK_LOC_KEY), false);
					loginFlag = false;
				}
				break;
		}
	}

	@VisibleForTesting
	int getIntProfileConfig(String key)
	{
		Integer value = configManager.getRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, int.class);
		return value == null ? -1 : value;
	}

	@VisibleForTesting
	String getStringProfileConfig(String key)
	{
		String value = configManager.getRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, String.class);
		return value == null ? "" : value;
	}

	private void setProfileConfig(String key, Object value)
	{
		if (value != null)
		{
			configManager.setRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, value);
		}
		else
		{
			configManager.unsetRSProfileConfiguration(SlayerConfig.GROUP_NAME, key);
		}
	}

	private void save()
	{
		setProfileConfig(SlayerConfig.AMOUNT_KEY, amount);
		setProfileConfig(SlayerConfig.INIT_AMOUNT_KEY, initialAmount);
		setProfileConfig(SlayerConfig.TASK_NAME_KEY, taskName);
		setProfileConfig(SlayerConfig.TASK_LOC_KEY, taskLocation);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		if (isTarget(npc))
		{
			highlightedTargets.add(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		taggedNpcs.remove(npc);
		highlightedTargets.remove(npc);
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog != null)
		{
			String npcText = Text.sanitizeMultilineText(npcDialog.getText()); //remove color and linebreaks
			final Matcher mAssign = NPC_ASSIGN_MESSAGE.matcher(npcText); // amount, name, (location)
			final Matcher mAssignFirst = NPC_ASSIGN_FIRST_MESSAGE.matcher(npcText); // name, number
			final Matcher mAssignBoss = NPC_ASSIGN_BOSS_MESSAGE.matcher(npcText); // name, number, points
			final Matcher mCurrent = NPC_CURRENT_MESSAGE.matcher(npcText); // name, (location), amount

			if (mAssign.find())
			{
				String name = mAssign.group("name");
				int amount = Integer.parseInt(mAssign.group("amount"));
				String location = mAssign.group("location");
				setTask(name, amount, amount, location);
			}
			else if (mAssignFirst.find())
			{
				int amount = Integer.parseInt(mAssignFirst.group(2));
				setTask(mAssignFirst.group(1), amount, amount);
			}
			else if (mAssignBoss.find())
			{
				int amount = Integer.parseInt(mAssignBoss.group(2));
				setTask(mAssignBoss.group(1), amount, amount);
				int points = Integer.parseInt(mAssignBoss.group(3).replaceAll(",", ""));
				setProfileConfig(SlayerConfig.POINTS_KEY, points);
			}
			else if (mCurrent.find())
			{
				String name = mCurrent.group("name");
				int amount = Integer.parseInt(mCurrent.group("amount"));
				String location = mCurrent.group("location");
				setTask(name, amount, initialAmount, location);
			}
		}

		Widget rewardsBarWidget = client.getWidget(WidgetInfo.SLAYER_REWARDS_TOPBAR);
		if (rewardsBarWidget != null)
		{
			for (Widget w : rewardsBarWidget.getDynamicChildren())
			{
				Matcher mPoints = REWARD_POINTS.matcher(w.getText());
				if (mPoints.find())
				{
					final int prevPoints = getIntProfileConfig(SlayerConfig.POINTS_KEY);
					int points = Integer.parseInt(mPoints.group(1).replaceAll(",", ""));

					if (prevPoints != points)
					{
						setProfileConfig(SlayerConfig.POINTS_KEY, points);
						removeCounter();
						addCounter();
					}

					break;
				}
			}
		}

		if (infoTimer != null && config.statTimeout() != 0)
		{
			Duration timeSinceInfobox = Duration.between(infoTimer, Instant.now());
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());

			if (timeSinceInfobox.compareTo(statTimeout) >= 0)
			{
				removeCounter();
			}
		}

		taggedNpcsDiedPrevTick = taggedNpcsDiedThisTick;
		taggedNpcsDiedThisTick = 0;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks

		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER))
		{
			amount++;
		}
		else if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			amount--;
		}

		if (chatMsg.startsWith("You've completed") && (chatMsg.contains("Slayer master") || chatMsg.contains("Slayer Master")))
		{
			Matcher mComplete = CHAT_COMPLETE_MESSAGE.matcher(chatMsg);

			if (mComplete.find())
			{
				String mTasks = mComplete.group("tasks");
				String mPoints = mComplete.group("points");
				if (mPoints == null)
				{
					mPoints = mComplete.group("points2");
				}

				if (mTasks != null)
				{
					int streak = Integer.parseInt(mTasks.replace(",", ""));
					setProfileConfig(SlayerConfig.STREAK_KEY, streak);
				}
				if (mPoints != null)
				{
					int points = Integer.parseInt(mPoints.replace(",", ""));
					setProfileConfig(SlayerConfig.POINTS_KEY, points);
				}
			}

			setTask("", 0, 0);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD) || chatMsg.equals(CHAT_CANCEL_MESSAGE_ZUK))
		{
			setTask("", 0, 0);
			return;
		}

		if (config.showSuperiorNotification() && chatMsg.equals(CHAT_SUPERIOR_MESSAGE))
		{
			notifier.notify(CHAT_SUPERIOR_MESSAGE);
			return;
		}

		Matcher mProgress = CHAT_GEM_PROGRESS_MESSAGE.matcher(chatMsg);

		if (mProgress.find())
		{
			String name = mProgress.group("name");
			int gemAmount = Integer.parseInt(mProgress.group("amount"));
			String location = mProgress.group("location");
			setTask(name, gemAmount, initialAmount, location);
			return;
		}

		final Matcher bracerProgress = COMBAT_BRACELET_TASK_UPDATE_MESSAGE.matcher(chatMsg);

		if (bracerProgress.find())
		{
			final int taskAmount = Integer.parseInt(bracerProgress.group(1));
			setTask(taskName, taskAmount, initialAmount);

			// Avoid race condition (combat brace message goes through first before XP drop)
			amount++;
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() != SLAYER)
		{
			return;
		}

		int slayerExp = statChanged.getXp();

		if (slayerExp <= cachedXp)
		{
			return;
		}

		if (cachedXp == -1)
		{
			// this is the initial xp sent on login
			cachedXp = slayerExp;
			return;
		}

		final int delta = slayerExp - cachedXp;
		cachedXp = slayerExp;

		log.debug("Slayer xp change delta: {}, killed npcs: {}", delta, taggedNpcsDiedPrevTick);

		final Task task = Task.getTask(taskName);
		if (task != null && task.getExpectedKillExp() > 0)
		{
			// Only decrement a kill if the xp drop matches the expected drop. This is just for Tzhaar tasks.
			if (task.getExpectedKillExp() == delta)
			{
				killed(1);
			}
		}
		else
		{
			// This is at least one kill, but if we observe multiple tagged NPCs dieing on the previous tick, count them
			// instead.
			killed(max(taggedNpcsDiedPrevTick, 1));
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Actor actor = hitsplatApplied.getActor();
		Hitsplat hitsplat = hitsplatApplied.getHitsplat();
		if (hitsplat.getHitsplatType() == Hitsplat.HitsplatType.DAMAGE_ME && highlightedTargets.contains(actor))
		{
			// If the actor is in highlightedTargets it must be an NPC and also a task assignment
			taggedNpcs.add((NPC) actor);
		}
	}

	@Subscribe
	public void onActorDeath(ActorDeath actorDeath)
	{
		Actor actor = actorDeath.getActor();
		if (taggedNpcs.contains(actor))
		{
			log.debug("Tagged NPC {} has died", actor.getName());
			++taggedNpcsDiedThisTick;
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(SlayerConfig.GROUP_NAME) || !event.getKey().equals("infobox"))
		{
			return;
		}

		if (config.showInfobox())
		{
			clientThread.invoke(this::addCounter);
		}
		else
		{
			removeCounter();
		}
	}

	@VisibleForTesting
	void killed(int amt)
	{
		if (amount == 0)
		{
			return;
		}

		amount -= amt;
		if (doubleTroubleExtraKill())
		{
			assert amt == 1;
			amount--;
		}

		// save changed value
		setProfileConfig(SlayerConfig.AMOUNT_KEY, amount);

		if (!config.showInfobox())
		{
			return;
		}

		// add and update counter, set timer
		addCounter();
		counter.setCount(amount);
		infoTimer = Instant.now();
	}

	private boolean doubleTroubleExtraKill()
	{
		return WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID() == GROTESQUE_GUARDIANS_REGION &&
			SlayerUnlock.GROTESQUE_GUARDIAN_DOUBLE_COUNT.isEnabled(client);
	}

	private boolean isTarget(NPC npc)
	{
		if (targetNames.isEmpty())
		{
			return false;
		}

		String name = npc.getName();
		if (name == null)
		{
			return false;
		}

		name = name.toLowerCase();

		for (String target : targetNames)
		{
			if (name.contains(target))
			{
				NPCComposition composition = npc.getTransformedComposition();

				if (composition != null)
				{
					List<String> actions = Arrays.asList(composition.getActions());
					if (actions.contains("Attack") || actions.contains("Pick")) //Pick action is for zygomite-fungi
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	private void rebuildTargetNames(Task task)
	{
		targetNames.clear();

		if (task != null)
		{
			Arrays.stream(task.getTargetNames())
				.map(String::toLowerCase)
				.forEach(targetNames::add);

			targetNames.add(taskName.toLowerCase().replaceAll("s$", ""));
		}
	}

	private void rebuildTargetList()
	{
		highlightedTargets.clear();

		for (NPC npc : client.getNpcs())
		{
			if (isTarget(npc))
			{
				highlightedTargets.add(npc);
			}
		}
	}

	private void setTask(String name, int amt, int initAmt)
	{
		setTask(name, amt, initAmt, null);
	}

	private void setTask(String name, int amt, int initAmt, String location)
	{
		setTask(name, amt, initAmt, location, true);
	}

	private void setTask(String name, int amt, int initAmt, String location, boolean addCounter)
	{
		taskName = name;
		amount = amt;
		initialAmount = Math.max(amt, initAmt);
		taskLocation = location;
		save();
		removeCounter();

		if (addCounter)
		{
			infoTimer = Instant.now();
			addCounter();
		}

		Task task = Task.getTask(name);
		rebuildTargetNames(task);
		rebuildTargetList();
	}

	private void addCounter()
	{
		if (!config.showInfobox() || counter != null || Strings.isNullOrEmpty(taskName))
		{
			return;
		}

		Task task = Task.getTask(taskName);
		int itemSpriteId = ItemID.ENCHANTED_GEM;
		if (task != null)
		{
			itemSpriteId = task.getItemSpriteId();
		}

		BufferedImage taskImg = itemManager.getImage(itemSpriteId);
		String taskTooltip = ColorUtil.wrapWithColorTag("%s", new Color(255, 119, 0)) + "</br>";

		if (taskLocation != null && !taskLocation.isEmpty())
		{
			taskTooltip += taskLocation + "</br>";
		}

		taskTooltip += ColorUtil.wrapWithColorTag("Pts:", Color.YELLOW)
			+ " %s</br>"
			+ ColorUtil.wrapWithColorTag("Streak:", Color.YELLOW)
			+ " %s";

		if (initialAmount > 0)
		{
			taskTooltip += "</br>"
				+ ColorUtil.wrapWithColorTag("Start:", Color.YELLOW)
				+ " " + initialAmount;
		}

		counter = new TaskCounter(taskImg, this, amount);
		counter.setTooltip(String.format(taskTooltip, capsString(taskName), getIntProfileConfig(SlayerConfig.POINTS_KEY), getIntProfileConfig(SlayerConfig.STREAK_KEY)));

		infoBoxManager.addInfoBox(counter);
	}

	private void removeCounter()
	{
		if (counter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(counter);
		counter = null;
	}

	void taskLookup(ChatMessage chatMessage, String message)
	{
		if (!config.taskCommand())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.removeTags(chatMessage.getName())
				.replace('\u00A0', ' ');
		}

		net.runelite.http.api.chat.Task task;
		try
		{
			task = chatClient.getTask(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup slayer task", ex);
			return;
		}

		if (TASK_STRING_VALIDATION.matcher(task.getTask()).find() || task.getTask().length() > TASK_STRING_MAX_LENGTH ||
			TASK_STRING_VALIDATION.matcher(task.getLocation()).find() || task.getLocation().length() > TASK_STRING_MAX_LENGTH ||
			Task.getTask(task.getTask()) == null || !Task.LOCATIONS.contains(task.getLocation()))
		{
			log.debug("Validation failed for task name or location: {}", task);
			return;
		}

		int killed = task.getInitialAmount() - task.getAmount();

		StringBuilder sb = new StringBuilder();
		sb.append(task.getTask());
		if (!Strings.isNullOrEmpty(task.getLocation()))
		{
			sb.append(" (").append(task.getLocation()).append(")");
		}
		sb.append(": ");
		if (killed < 0)
		{
			sb.append(task.getAmount()).append(" left");
		}
		else
		{
			sb.append(killed).append('/').append(task.getInitialAmount()).append(" killed");
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Slayer Task: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(sb.toString())
			.build();

		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean taskSubmit(ChatInput chatInput, String value)
	{
		if (Strings.isNullOrEmpty(taskName))
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitTask(playerName, capsString(taskName), amount, initialAmount, taskLocation);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit slayer task", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	//Utils
	private String capsString(String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private void migrateConfig()
	{
		migrateConfigKey(SlayerConfig.TASK_NAME_KEY);
		migrateConfigKey(SlayerConfig.AMOUNT_KEY);
		migrateConfigKey(SlayerConfig.INIT_AMOUNT_KEY);
		migrateConfigKey(SlayerConfig.TASK_LOC_KEY);
		migrateConfigKey(SlayerConfig.STREAK_KEY);
		migrateConfigKey(SlayerConfig.POINTS_KEY);
		configManager.unsetConfiguration(SlayerConfig.GROUP_NAME, "expeditious");
		configManager.unsetConfiguration(SlayerConfig.GROUP_NAME, "slaughter");
		configManager.unsetRSProfileConfiguration(SlayerConfig.GROUP_NAME, "expeditious");
		configManager.unsetRSProfileConfiguration(SlayerConfig.GROUP_NAME, "slaughter");
	}

	private void migrateConfigKey(String key)
	{
		Object value = configManager.getConfiguration(SlayerConfig.GROUP_NAME, key);
		if (value != null)
		{
			configManager.unsetConfiguration(SlayerConfig.GROUP_NAME, key);
			configManager.setRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, value);
		}
	}
}
