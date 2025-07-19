/*
 * Copyright (c) 2017. l2-
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatcommands;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.IconID;
import net.runelite.api.IndexedSprite;
import net.runelite.api.ItemComposition;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.WorldType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatClient;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.ItemManager;
import net.runelite.client.hiscore.HiscoreClient;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.HiscoreSkill;
import net.runelite.client.hiscore.Skill;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.chat.Duels;
import net.runelite.http.api.item.ItemPrice;
import org.apache.commons.text.WordUtils;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final Pattern KILLCOUNT_PATTERN = Pattern.compile("Your (?<pre>completion count for |subdued |completed )?(?:<col=[0-9a-f]{6}>)?(?<boss>.+?)(?:</col>)? (?<post>(?:(?:kill|harvest|lap|completion|success) )?(?:count )?)is: ?<col=[0-9a-f]{6}>(?<kc>[0-9,]+)</col>");
	private static final String TEAM_SIZES = "(?<teamsize>\\d+(?:\\+|-\\d+)? players?|Solo)";
	private static final Pattern RAIDS_PB_PATTERN = Pattern.compile("<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>" + TEAM_SIZES + "</col> Duration:</col> <col=ff0000>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col> \\(new personal best\\)</col>");
	private static final Pattern RAIDS_DURATION_PATTERN = Pattern.compile("<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>" + TEAM_SIZES + "</col> Duration:</col> <col=ff0000>[0-9:.]+</col> Personal best: </col><col=ff0000>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col>");
	private static final Pattern KILL_DURATION_PATTERN = Pattern.compile("(?i)(?:(?:Fight |Lap |Challenge |Corrupted challenge )?duration:|Subdued in|(?<!total )completion time:) <col=[0-9a-f]{6}>[0-9:.]+</col>\\. Personal best: (?:<col=ff0000>)?(?<pb>[0-9:]+(?:\\.[0-9]+)?)");
	private static final Pattern NEW_PB_PATTERN = Pattern.compile("(?i)(?:(?:Fight |Lap |Challenge |Corrupted challenge )?duration:|Subdued in|(?<!total )completion time:) <col=[0-9a-f]{6}>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col> \\(new personal best\\)");
	private static final Pattern DUEL_ARENA_WINS_PATTERN = Pattern.compile("You (were defeated|won)! You have(?: now)? won ([\\d,]+|one) duels?");
	private static final Pattern DUEL_ARENA_LOSSES_PATTERN = Pattern.compile("You have(?: now)? lost ([\\d,]+|one) duels?");
	private static final Pattern ADVENTURE_LOG_TITLE_PATTERN = Pattern.compile("The Exploits of (.+)");
	private static final Pattern ADVENTURE_LOG_PB_PATTERN = Pattern.compile("Fastest (?:kill|run|Room time)(?: - \\(Team size: \\(?" + TEAM_SIZES + "\\)\\)?)?: (?<time>[0-9:]+(?:\\.[0-9]+)?)");
	private static final Pattern HS_PB_PATTERN = Pattern.compile("Floor (?<floor>\\d) time: <col=ff0000>(?<floortime>[0-9:]+(?:\\.[0-9]+)?)</col>(?: \\(new personal best\\)|. Personal best: (?<floorpb>[0-9:]+(?:\\.[0-9]+)?))" +
		"(?:<br>Overall time: <col=ff0000>(?<otime>[0-9:]+(?:\\.[0-9]+)?)</col>(?: \\(new personal best\\)|. Personal best: (?<opb>[0-9:]+(?:\\.[0-9]+)?)))?");
	private static final Pattern HS_KC_FLOOR_PATTERN = Pattern.compile("You have completed Floor (\\d) of the Hallowed Sepulchre! Total completions: <col=ff0000>([0-9,]+)</col>\\.");
	private static final Pattern HS_KC_GHC_PATTERN = Pattern.compile("You have opened the Grand Hallowed Coffin <col=ff0000>([0-9,]+)</col> times?!");
	private static final Pattern COLLECTION_LOG_ITEM_PATTERN = Pattern.compile("New item added to your collection log: (.*)");
	private static final Pattern GUARDIANS_OF_THE_RIFT_PATTERN = Pattern.compile("Amount of Rifts you have closed: <col=ff0000>([0-9,]+)</col>\\.", Pattern.CASE_INSENSITIVE);
	private static final Pattern HUNTER_RUMOUR_KC_PATTERN = Pattern.compile("You have completed <col=[0-9a-f]{6}>([0-9,]+)</col> rumours? for the Hunter Guild\\.");
	private static final Pattern BIRD_EGG_OFFERING_PATTERN = Pattern.compile("You have made <col=ff0000>(?<kc>[\\d,]+|one)</col> offerings?\\.");
	private static final Pattern CHEST_OPENING_PATTERN = Pattern.compile("You have (?<never>never )?opened (the )?(?<chest>crystal chest|Larran's big chest|Larran's small chest|Brimstone chest)( (?<kc>[\\d,]+ times|once))?\\.");

	private static final String TOTAL_LEVEL_COMMAND_STRING = "!total";
	private static final String PRICE_COMMAND_STRING = "!price";
	private static final String LEVEL_COMMAND_STRING = "!lvl";
	private static final String BOUNTY_HUNTER_HUNTER_COMMAND = "!bh";
	private static final String BOUNTY_HUNTER_ROGUE_COMMAND = "!bhrogue";
	private static final String CLUES_COMMAND_STRING = "!clues";
	private static final String LAST_MAN_STANDING_COMMAND = "!lms";
	private static final String KILLCOUNT_COMMAND_STRING = "!kc";
	private static final String CMB_COMMAND_STRING = "!cmb";
	private static final String QP_COMMAND_STRING = "!qp";
	private static final String PB_COMMAND = "!pb";
	private static final String GC_COMMAND_STRING = "!gc";
	private static final String DUEL_ARENA_COMMAND = "!duels";
	private static final String LEAGUE_POINTS_COMMAND = "!lp";
	private static final String SOUL_WARS_ZEAL_COMMAND = "!sw";
	private static final String PET_LIST_COMMAND = "!pets";
	private static final String CA_COMMAND = "!ca";
	private static final String CLOG_COMMAND = "!clog";

	@VisibleForTesting
	static final int ADV_LOG_EXPLOITS_TEXT_INDEX = 1;
	static final int COL_LOG_ENTRY_HEADER_TITLE_INDEX = 0;

	private static final Map<String, String> KILLCOUNT_RENAMES = ImmutableMap.of(
		"Barrows chest", "Barrows Chests"
	);

	private boolean bossLogLoaded;
	private boolean advLogLoaded;
	private boolean scrollInterfaceLoaded;
	private String pohOwner;
	private HiscoreEndpoint hiscoreEndpoint; // hiscore endpoint for current player
	private String lastBossKill;
	private int lastBossTime = -1;
	private double lastPb = -1;
	private String lastTeamSize;
	private int petsIconIdx = -1;
	private int[] pets;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatCommandsConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatKeyboardListener chatKeyboardListener;

	@Inject
	private HiscoreClient hiscoreClient;

	@Inject
	private ChatClient chatClient;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Inject
	private Gson gson;

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(chatKeyboardListener);

		chatCommandManager.registerCommandAsync(TOTAL_LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CMB_COMMAND_STRING, this::combatLevelLookup);
		chatCommandManager.registerCommand(PRICE_COMMAND_STRING, this::itemPriceLookup);
		chatCommandManager.registerCommandAsync(LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(BOUNTY_HUNTER_HUNTER_COMMAND, this::bountyHunterHunterLookup);
		chatCommandManager.registerCommandAsync(BOUNTY_HUNTER_ROGUE_COMMAND, this::bountyHunterRogueLookup);
		chatCommandManager.registerCommandAsync(CLUES_COMMAND_STRING, this::clueLookup);
		chatCommandManager.registerCommandAsync(LAST_MAN_STANDING_COMMAND, this::lastManStandingLookup);
		chatCommandManager.registerCommandAsync(LEAGUE_POINTS_COMMAND, this::leaguePointsLookup);
		chatCommandManager.registerCommandAsync(KILLCOUNT_COMMAND_STRING, this::killCountLookup, this::killCountSubmit);
		chatCommandManager.registerCommandAsync(QP_COMMAND_STRING, this::questPointsLookup, this::questPointsSubmit);
		chatCommandManager.registerCommandAsync(PB_COMMAND, this::personalBestLookup, this::personalBestSubmit);
		chatCommandManager.registerCommandAsync(GC_COMMAND_STRING, this::gambleCountLookup, this::gambleCountSubmit);
		chatCommandManager.registerCommandAsync(DUEL_ARENA_COMMAND, this::duelArenaLookup, this::duelArenaSubmit);
		chatCommandManager.registerCommandAsync(SOUL_WARS_ZEAL_COMMAND, this::soulWarsZealLookup);
		chatCommandManager.registerCommandAsync(PET_LIST_COMMAND, this::petListLookup, this::petListSubmit);
		chatCommandManager.registerCommandAsync(CA_COMMAND, this::caLookup, this::caSubmit);
		chatCommandManager.registerCommandAsync(CLOG_COMMAND, this::clogLookup, this::clogSubmit);

		clientThread.invoke(() ->
		{
			if (client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState())
			{
				if (petsIconIdx == -1)
				{
					loadPets();
				}
			}
		});
	}

	@Override
	public void shutDown()
	{
		pets = null;
		lastBossKill = null;
		lastBossTime = -1;

		keyManager.unregisterKeyListener(chatKeyboardListener);

		chatCommandManager.unregisterCommand(TOTAL_LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CMB_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PRICE_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(BOUNTY_HUNTER_HUNTER_COMMAND);
		chatCommandManager.unregisterCommand(BOUNTY_HUNTER_ROGUE_COMMAND);
		chatCommandManager.unregisterCommand(CLUES_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LAST_MAN_STANDING_COMMAND);
		chatCommandManager.unregisterCommand(LEAGUE_POINTS_COMMAND);
		chatCommandManager.unregisterCommand(KILLCOUNT_COMMAND_STRING);
		chatCommandManager.unregisterCommand(QP_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PB_COMMAND);
		chatCommandManager.unregisterCommand(GC_COMMAND_STRING);
		chatCommandManager.unregisterCommand(DUEL_ARENA_COMMAND);
		chatCommandManager.unregisterCommand(SOUL_WARS_ZEAL_COMMAND);
		chatCommandManager.unregisterCommand(PET_LIST_COMMAND);
		chatCommandManager.unregisterCommand(CA_COMMAND);
		chatCommandManager.unregisterCommand(CLOG_COMMAND);
	}

	@Provides
	ChatCommandsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatCommandsConfig.class);
	}

	private void setKc(String boss, int killcount)
	{
		configManager.setRSProfileConfiguration("killcount", boss.toLowerCase(), killcount);
	}

	private void unsetKc(String boss)
	{
		configManager.unsetRSProfileConfiguration("killcount", boss.toLowerCase());
	}

	private int getKc(String boss)
	{
		Integer killCount = configManager.getRSProfileConfiguration("killcount", boss.toLowerCase(), int.class);
		return killCount == null ? 0 : killCount;
	}

	private void setPb(String boss, double seconds)
	{
		configManager.setRSProfileConfiguration("personalbest", boss.toLowerCase(), seconds);
	}

	private void unsetPb(String boss)
	{
		configManager.unsetRSProfileConfiguration("personalbest", boss.toLowerCase());
	}

	private double getPb(String boss)
	{
		Double personalBest = configManager.getRSProfileConfiguration("personalbest", boss.toLowerCase(), double.class);
		return personalBest == null ? 0 : personalBest;
	}

	private void loadPets()
	{
		assert petsIconIdx == -1;

		// !pets requires off thread pets access, so we just store a copy
		EnumComposition petsEnum = client.getEnum(EnumID.PETS);
		pets = new int[petsEnum.size()];
		for (int i = 0; i < petsEnum.size(); ++i)
		{
			pets[i] = petsEnum.getIntValue(i);
		}

		final IndexedSprite[] modIcons = client.getModIcons();
		assert modIcons != null;

		final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + pets.length);
		petsIconIdx = modIcons.length;

		client.setModIcons(newModIcons);

		for (int i = 0; i < pets.length; i++)
		{
			final int petId = pets[i];

			final AsyncBufferedImage abi = itemManager.getImage(petId);
			final int idx = petsIconIdx + i;
			abi.onLoaded(() ->
			{
				final BufferedImage image = ImageUtil.resizeImage(abi, 18, 16);
				final IndexedSprite sprite = ImageUtil.getImageIndexedSprite(image, client);
				// modicons array might be replaced in between when we assign it and the callback,
				// so fetch modicons again
				client.getModIcons()[idx] = sprite;
			});
		}
	}

	/**
	 * Sets the list of owned pets for the local player
	 *
	 * @param petList The total list of owned pets for the local player
	 */
	private void setPetList(List<Integer> petList)
	{
		if (petList == null)
		{
			return;
		}

		configManager.setRSProfileConfiguration("chatcommands", "pets2",
			gson.toJson(petList));
		configManager.unsetRSProfileConfiguration("chatcommands", "pets"); // old list
	}

	/**
	 * Looks up the list of owned pets for the local player
	 */
	private List<Pet> getPetListOld()
	{
		String petListJson = configManager.getRSProfileConfiguration("chatcommands", "pets",
			String.class);

		List<Pet> petList;
		try
		{
			// CHECKSTYLE:OFF
			petList = gson.fromJson(petListJson, new TypeToken<List<Pet>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonSyntaxException ex)
		{
			return Collections.emptyList();
		}

		return petList != null ? petList : Collections.emptyList();
	}

	private List<Integer> getPetList()
	{
		List<Pet> old = getPetListOld();
		if (!old.isEmpty())
		{
			List<Integer> l = old.stream().map(Pet::getIconID).collect(Collectors.toList());
			setPetList(l);
			return l;
		}

		String petListJson = configManager.getRSProfileConfiguration("chatcommands", "pets2",
			String.class);

		List<Integer> petList;
		try
		{
			// CHECKSTYLE:OFF
			petList = gson.fromJson(petListJson, new TypeToken<List<Integer>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonSyntaxException ex)
		{
			return Collections.emptyList();
		}

		return petList != null ? petList : Collections.emptyList();
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.TRADE
			&& chatMessage.getType() != ChatMessageType.GAMEMESSAGE
			&& chatMessage.getType() != ChatMessageType.SPAM
			&& chatMessage.getType() != ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			return;
		}

		String message = chatMessage.getMessage();
		Matcher matcher = KILLCOUNT_PATTERN.matcher(message);
		if (matcher.find())
		{
			final String boss = matcher.group("boss");
			final int kc = Integer.parseInt(matcher.group("kc").replace(",", ""));
			final String pre = matcher.group("pre");
			final String post = matcher.group("post");

			if (Strings.isNullOrEmpty(pre) && Strings.isNullOrEmpty(post))
			{
				unsetKc(boss);
				return;
			}

			String renamedBoss = KILLCOUNT_RENAMES
				.getOrDefault(boss, boss)
				// The config service doesn't support keys with colons in them
				.replace(":", "");
			if (boss != renamedBoss)
			{
				// Unset old TOB kc
				unsetKc(boss);
				unsetPb(boss);
				unsetKc(boss.replace(":", "."));
				unsetPb(boss.replace(":", "."));
				// Unset old story mode
				unsetKc("Theatre of Blood Story Mode");
				unsetPb("Theatre of Blood Story Mode");
			}

			setKc(renamedBoss, kc);
			// We either already have the pb, or need to remember the boss for the upcoming pb
			if (lastPb > -1)
			{
				log.debug("Got out-of-order personal best for {}: {}", renamedBoss, lastPb);

				if (renamedBoss.contains("Theatre of Blood"))
				{
					// TOB team size isn't sent in the kill message, but can be computed from varbits
					int tobTeamSize = tobTeamSize();
					lastTeamSize = tobTeamSize == 1 ? "Solo" : (tobTeamSize + " players");
				}
				else if (renamedBoss.contains("Tombs of Amascut"))
				{
					// TOA team size isn't sent in the kill message, but can be computed from varbits
					int toaTeamSize = toaTeamSize();
					lastTeamSize = toaTeamSize == 1 ? "Solo" : (toaTeamSize + " players");
				}

				final double pb = getPb(renamedBoss);
				// If a raid with a team size, only update the pb if it is lower than the existing pb
				// so that the pb is the overall lowest of any team size
				if (lastTeamSize == null || pb == 0 || lastPb < pb)
				{
					log.debug("Setting overall pb (old: {})", pb);
					setPb(renamedBoss, lastPb);
				}
				if (lastTeamSize != null)
				{
					log.debug("Setting team size pb: {}", lastTeamSize);
					setPb(renamedBoss + " " + lastTeamSize, lastPb);
				}

				lastPb = -1;
				lastTeamSize = null;
			}
			else
			{
				lastBossKill = renamedBoss;
				lastBossTime = client.getTickCount();
			}
			return;
		}

		matcher = DUEL_ARENA_WINS_PATTERN.matcher(message);
		if (matcher.find())
		{
			final int oldWins = getKc("Duel Arena Wins");
			final int wins = matcher.group(2).equals("one") ? 1 :
				Integer.parseInt(matcher.group(2).replace(",", ""));
			final String result = matcher.group(1);
			int winningStreak = getKc("Duel Arena Win Streak");
			int losingStreak = getKc("Duel Arena Lose Streak");

			if (result.equals("won") && wins > oldWins)
			{
				losingStreak = 0;
				winningStreak += 1;
			}
			else if (result.equals("were defeated"))
			{
				losingStreak += 1;
				winningStreak = 0;
			}
			else
			{
				log.warn("unrecognized duel streak chat message: {}", message);
			}

			setKc("Duel Arena Wins", wins);
			setKc("Duel Arena Win Streak", winningStreak);
			setKc("Duel Arena Lose Streak", losingStreak);
		}

		matcher = DUEL_ARENA_LOSSES_PATTERN.matcher(message);
		if (matcher.find())
		{
			int losses = matcher.group(1).equals("one") ? 1 :
				Integer.parseInt(matcher.group(1).replace(",", ""));

			setKc("Duel Arena Losses", losses);
		}

		matcher = KILL_DURATION_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = NEW_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = RAIDS_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = RAIDS_DURATION_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = HS_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			int floor = Integer.parseInt(matcher.group("floor"));
			String floortime = matcher.group("floortime");
			String floorpb = matcher.group("floorpb");
			String otime = matcher.group("otime");
			String opb = matcher.group("opb");

			String pb = MoreObjects.firstNonNull(floorpb, floortime);
			setPb("Hallowed Sepulchre Floor " + floor, timeStringToSeconds(pb));

			if (otime != null)
			{
				pb = MoreObjects.firstNonNull(opb, otime);
				setPb("Hallowed Sepulchre", timeStringToSeconds(pb));
			}
		}

		matcher = HS_KC_FLOOR_PATTERN.matcher(message);
		if (matcher.find())
		{
			int floor = Integer.parseInt(matcher.group(1));
			int kc = Integer.parseInt(matcher.group(2).replace(",", ""));
			setKc("Hallowed Sepulchre Floor " + floor, kc);
		}

		matcher = HS_KC_GHC_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1).replace(",", ""));
			setKc("Hallowed Sepulchre", kc);
		}

		matcher = HUNTER_RUMOUR_KC_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1).replace(",", ""));
			setKc("Hunter Rumours", kc);
		}

		if (lastBossKill != null && lastBossTime != client.getTickCount())
		{
			lastBossKill = null;
			lastBossTime = -1;
		}

		matcher = COLLECTION_LOG_ITEM_PATTERN.matcher(message);
		if (matcher.find())
		{
			String item = matcher.group(1);
			int petId = findPet(item);

			if (petId != -1)
			{
				final List<Integer> petList = new ArrayList<>(getPetList());
				if (!petList.contains(petId))
				{
					log.debug("New pet added: {}/{}", item, petId);
					petList.add(petId);
					setPetList(petList);
				}
			}
		}

		matcher = GUARDIANS_OF_THE_RIFT_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1).replace(",", ""));
			setKc("Guardians of the Rift", kc);
		}

		matcher = BIRD_EGG_OFFERING_PATTERN.matcher(message);
		if (matcher.find())
		{
			String kcString = matcher.group("kc");
			int kc = kcString.equals("one")
				? 1
				: Integer.parseInt(kcString.replace(",", ""));

			setKc("Bird's egg offerings", kc);
		}

		matcher = CHEST_OPENING_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc;
			if (matcher.group("never") != null)
			{
				kc = 0;
			}
			else
			{
				String kcString = matcher.group("kc");
				kc = kcString.equals("once")
					? 1
					: Integer.parseInt(kcString.split(" ")[0].replace(",", ""));
			}

			String chest = matcher.group("chest");

			setKc(chest, kc);
		}
	}

	@VisibleForTesting
	static double timeStringToSeconds(String timeString)
	{
		String[] s = timeString.split(":");
		if (s.length == 2) // mm:ss
		{
			return Integer.parseInt(s[0]) * 60 + Double.parseDouble(s[1]);
		}
		else if (s.length == 3) // h:mm:ss
		{
			return Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Double.parseDouble(s[2]);
		}
		return Double.parseDouble(timeString);
	}

	@VisibleForTesting
	static String secondsToTimeString(double seconds)
	{
		int hours = (int) (Math.floor(seconds) / 3600);
		int minutes = (int) (Math.floor(seconds / 60) % 60);
		seconds = seconds % 60;

		String timeString = hours > 0 ? String.format("%d:%02d:", hours, minutes) : String.format("%d:", minutes);

		// If the seconds is an integer, it is ambiguous if the pb is a precise
		// pb or not. So we always show it without the trailing .00.
		return timeString + (Math.floor(seconds) == seconds ? String.format("%02d", (int) seconds) : String.format("%05.2f", seconds));
	}

	private void matchPb(Matcher matcher)
	{
		double seconds = timeStringToSeconds(matcher.group("pb"));
		if (lastBossKill != null)
		{
			// Most bosses send boss kill message, and then pb message, so we
			// use the remembered lastBossKill
			log.debug("Got personal best for {}: {}", lastBossKill, seconds);
			setPb(lastBossKill, seconds);
			lastPb = -1;
			lastTeamSize = null;
		}
		else
		{
			// Some bosses send the pb message, and then the kill message!
			lastPb = seconds;
			try
			{
				lastTeamSize = matcher.group("teamsize");
			}
			catch (IllegalArgumentException ex)
			{
				// pattern has no team size
				lastTeamSize = null;
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		if (advLogLoaded)
		{
			advLogLoaded = false;

			Widget adventureLog = client.getWidget(InterfaceID.Menu.LJ_LAYER2);

			if (adventureLog != null)
			{
				Matcher advLogExploitsText = ADVENTURE_LOG_TITLE_PATTERN.matcher(adventureLog.getChild(ADV_LOG_EXPLOITS_TEXT_INDEX).getText());
				if (advLogExploitsText.find())
				{
					pohOwner = advLogExploitsText.group(1);
				}
			}
		}

		if (bossLogLoaded && (pohOwner == null || pohOwner.equals(client.getLocalPlayer().getName())))
		{
			bossLogLoaded = false;

			Widget title = client.getWidget(InterfaceID.KillLog.INTERFACE_TITLE);
			Widget bossMonster = client.getWidget(InterfaceID.KillLog.NAME);
			Widget bossKills = client.getWidget(InterfaceID.KillLog.KILL);

			if (title == null || bossMonster == null || bossKills == null
				|| !"Boss Kill Log".equals(title.getText()))
			{
				return;
			}

			Widget[] bossChildren = bossMonster.getChildren();
			Widget[] killsChildren = bossKills.getChildren();

			for (int i = 0; i < bossChildren.length; ++i)
			{
				Widget boss = bossChildren[i];
				Widget kill = killsChildren[i];

				String bossName = boss.getText().replace(":", "");
				int kc = Integer.parseInt(kill.getText().replace(",", ""));
				if (kc != getKc(longBossName(bossName)))
				{
					setKc(longBossName(bossName), kc);
				}
			}
		}

		// Adventure log - Counters
		if (scrollInterfaceLoaded)
		{
			scrollInterfaceLoaded = false;

			if (client.getLocalPlayer().getName().equals(pohOwner))
			{
				Widget parent = client.getWidget(InterfaceID.Journalscroll.TEXTLAYER);
				// Each line is a separate static child
				Widget[] children = parent.getStaticChildren();
				String[] text = Arrays.stream(children)
					.map(Widget::getText)
					.map(Text::removeTags)
					.toArray(String[]::new);

				for (int i = 0; i < text.length; ++i)
				{
					String boss = longBossName(text[i]);

					for (i = i + 1; i < text.length; ++i)
					{
						String line = text[i];
						if (line.isEmpty())
						{
							break;
						}

						Matcher matcher = ADVENTURE_LOG_PB_PATTERN.matcher(line);
						if (matcher.find())
						{
							final double s = timeStringToSeconds(matcher.group("time"));
							String teamSize = matcher.group("teamsize");
							if (teamSize != null)
							{
								// 3 player -> 3 players
								// 1 player -> Solo
								// Solo -> Solo
								// 2 players -> 2 players
								if (teamSize.equals("1 player"))
								{
									teamSize = "Solo";
								}
								else if (teamSize.endsWith("player"))
								{
									teamSize = teamSize + "s";
								}

								log.debug("Found team-size adventure log PB for {} {}: {}", boss, teamSize, s);
								setPb(boss + " " + teamSize, s);
							}
							else
							{
								log.debug("Found adventure log PB for {}: {}", boss, s);
								setPb(boss, s);
							}
						}
					}
				}
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() != ScriptID.COLLECTION_DRAW_LIST)
		{
			return;
		}

		if (pohOwner == null || pohOwner.equals(client.getLocalPlayer().getName()))
		{
			Widget collectionLogEntryHeader = client.getWidget(InterfaceID.Collection.HEADER_TEXT);
			if (collectionLogEntryHeader != null && collectionLogEntryHeader.getChildren() != null)
			{
				Widget entryTitle = collectionLogEntryHeader.getChild(COL_LOG_ENTRY_HEADER_TITLE_INDEX);
				// Make sure that the player is looking in the All Pets tab of the collection log
				if (entryTitle.getText().equals("All Pets"))
				{
					Widget collectionLogEntryItems = client.getWidget(InterfaceID.Collection.ITEMS_CONTENTS);
					if (collectionLogEntryItems != null && collectionLogEntryItems.getChildren() != null)
					{
						List<Integer> petList = new ArrayList<>();
						for (Widget child : collectionLogEntryItems.getChildren())
						{
							if (child.getOpacity() == 0)
							{
								petList.add(child.getItemId());
							}
						}

						setPetList(petList);
						log.debug("Loaded {} pets", petList.size());
					}
				}
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widget)
	{
		switch (widget.getGroupId())
		{
			case InterfaceID.MENU:
				advLogLoaded = true;
				break;
			case InterfaceID.KILL_LOG:
				bossLogLoaded = true;
				break;
			case InterfaceID.JOURNALSCROLL:
				scrollInterfaceLoaded = true;
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case HOPPING:
				pohOwner = null;
				break;
			case STARTING:
				petsIconIdx = -1;
				pets = null;
				break;
			case LOGIN_SCREEN:
				if (petsIconIdx == -1)
				{
					loadPets();
				}
				break;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		hiscoreEndpoint = getLocalHiscoreEndpointType();
	}

	private boolean killCountSubmit(ChatInput chatInput, String value)
	{
		int idx = value.indexOf(' ');
		final String boss = longBossName(value.substring(idx + 1));

		final int kc = getKc(boss);
		if (kc <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitKc(playerName, boss, kc);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit killcount", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	@VisibleForTesting
	void killCountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.killcount())
		{
			return;
		}

		if (message.length() <= KILLCOUNT_COMMAND_STRING.length())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();
		String search = message.substring(KILLCOUNT_COMMAND_STRING.length() + 1);

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		search = longBossName(search);

		final int kc;
		try
		{
			kc = chatClient.getKc(player, search);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup killcount", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(search)
			.append(ChatColorType.NORMAL)
			.append(" kill count: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", kc))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean duelArenaSubmit(ChatInput chatInput, String value)
	{
		final int wins = getKc("Duel Arena Wins");
		final int losses = getKc("Duel Arena Losses");
		final int winningStreak = getKc("Duel Arena Win Streak");
		final int losingStreak = getKc("Duel Arena Lose Streak");

		if (wins <= 0 && losses <= 0 && winningStreak <= 0 && losingStreak <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitDuels(playerName, wins, losses, winningStreak, losingStreak);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit duels", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void duelArenaLookup(ChatMessage chatMessage, String message)
	{
		if (!config.duels())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type == ChatMessageType.PRIVATECHATOUT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		Duels duels;
		try
		{
			duels = chatClient.getDuels(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup duels", ex);
			return;
		}

		final int wins = duels.getWins();
		final int losses = duels.getLosses();
		final int winningStreak = duels.getWinningStreak();
		final int losingStreak = duels.getLosingStreak();

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Duel Arena wins: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", wins))
			.append(ChatColorType.NORMAL)
			.append("   losses: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", losses))
			.append(ChatColorType.NORMAL)
			.append("   streak: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", winningStreak != 0 ? winningStreak : -losingStreak))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private void questPointsLookup(ChatMessage chatMessage, String message)
	{
		if (!config.qp())
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
			player = Text.sanitize(chatMessage.getName());
		}

		int qp;
		try
		{
			qp = chatClient.getQp(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup quest points", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Quest points: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(qp))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean questPointsSubmit(ChatInput chatInput, String value)
	{
		final int qp = client.getVarpValue(VarPlayerID.QP);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitQp(playerName, qp);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit quest points", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void personalBestLookup(ChatMessage chatMessage, String message)
	{
		if (!config.pb())
		{
			return;
		}

		if (message.length() <= PB_COMMAND.length())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();
		String search = message.substring(PB_COMMAND.length() + 1);

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		search = longBossName(search);

		final double pb;
		try
		{
			pb = chatClient.getPb(player, search);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup personal best", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(search)
			.append(ChatColorType.NORMAL)
			.append(" personal best: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(secondsToTimeString(pb))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean personalBestSubmit(ChatInput chatInput, String value)
	{
		int idx = value.indexOf(' ');
		final String boss = longBossName(value.substring(idx + 1));

		final double pb = getPb(boss);
		if (pb <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitPb(playerName, boss, pb);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit personal best", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void gambleCountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.gc())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type == ChatMessageType.PRIVATECHATOUT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		int gc;
		try
		{
			gc = chatClient.getGc(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup gamble count", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Barbarian Assault High-level gambles: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", gc))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean gambleCountSubmit(ChatInput chatInput, String value)
	{
		final int gc = client.getVarbitValue(VarbitID.BARBASSAULT_GAMBLECOUNT);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitGc(playerName, gc);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit gamble count", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	/**
	 * Looks up the pet list for the player who triggered !pets
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message     The chat message in string format
	 *                    <p>
	 */
	private void petListLookup(ChatMessage chatMessage, String message)
	{
		if (!config.pets())
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
			player = Text.sanitize(chatMessage.getName());
		}

		Set<Integer> playerPetList;
		try
		{
			playerPetList = chatClient.getPetList(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup pet list", ex);

			if (player.equals(client.getLocalPlayer().getName()))
			{
				String response = "Open the 'All Pets' tab in the Collection Log to update your pet list";
				log.debug("Setting response {}", response);
				final MessageNode messageNode = chatMessage.getMessageNode();
				messageNode.setValue(response);
				client.refreshChat();
			}
			return;
		}

		ChatMessageBuilder responseBuilder = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Pets: ")
			.append("(" + playerPetList.size() + ")");

		// Append pets that the player owns
		for (int petIdx = 0; petIdx < pets.length; ++petIdx)
		{
			final int petId = pets[petIdx];
			if (playerPetList.contains(petId))
			{
				responseBuilder.append(" ").img(petsIconIdx + petIdx);
			}
		}

		String response = responseBuilder.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	/**
	 * Submits the pet list for the local player
	 *
	 * @param chatInput The chat message containing the command.
	 * @param value     The chat message
	 */
	private boolean petListSubmit(ChatInput chatInput, String value)
	{
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				List<Integer> petList = getPetList();
				if (!petList.isEmpty())
				{
					chatClient.submitPetList(playerName, petList);
				}
			}
			catch (Exception ex)
			{
				log.warn("unable to submit pet list", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void caLookup(ChatMessage chatMessage, String message)
	{
		if (!config.ca())
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
			player = Text.sanitize(chatMessage.getName());
		}

		int num;
		try
		{
			num = chatClient.getKc(player, "Combat Achievements");
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup combat achievements");
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Combat Achievements: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(num))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean caSubmit(ChatInput chatInput, String value)
	{
		final int tasks = client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_EASY) +
			client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_MEDIUM) +
			client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_HARD) +
			client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_ELITE) +
			client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_MASTER) +
			client.getVarbitValue(VarbitID.CA_TOTAL_TASKS_COMPLETED_GRANDMASTER);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitKc(playerName, "Combat Achievements", tasks);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit combat achievements", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void clogLookup(ChatMessage chatMessage, String message)
	{
		if (!config.clog())
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
			player = Text.sanitize(chatMessage.getName());
		}

		int num;
		try
		{
			num = chatClient.getKc(player, "Collections Logged");
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup clog");
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Collections Logged: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(num))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean clogSubmit(ChatInput chatInput, String value)
	{
		final int clog = client.getVarpValue(VarPlayerID.COLLECTION_COUNT);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitKc(playerName, "Collections Logged", clog);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit clog", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	private void itemPriceLookup(ChatMessage chatMessage, String message)
	{
		if (!config.price())
		{
			return;
		}

		if (message.length() <= PRICE_COMMAND_STRING.length())
		{
			return;
		}

		MessageNode messageNode = chatMessage.getMessageNode();
		String search = message.substring(PRICE_COMMAND_STRING.length() + 1);

		List<ItemPrice> results = itemManager.search(search);

		if (!results.isEmpty())
		{
			ItemPrice item = retrieveFromList(results, search);

			int itemId = item.getId();
			int itemPrice = runeLiteConfig.useWikiItemPrices() ? itemManager.getWikiPrice(item) : item.getPrice();

			final ChatMessageBuilder builder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT)
				.append(item.getName())
				.append(ChatColorType.NORMAL)
				.append(": GE average ")
				.append(ChatColorType.HIGHLIGHT)
				.append(QuantityFormatter.formatNumber(itemPrice));

			ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			final int alchPrice = itemComposition.getHaPrice();
			builder
				.append(ChatColorType.NORMAL)
				.append(" HA value ")
				.append(ChatColorType.HIGHLIGHT)
				.append(QuantityFormatter.formatNumber(alchPrice));

			String response = builder.build();

			log.debug("Setting response {}", response);
			messageNode.setRuneLiteFormatMessage(response);
			client.refreshChat();
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	@VisibleForTesting
	void playerSkillLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lvl())
		{
			return;
		}

		String search;
		if (message.equalsIgnoreCase(TOTAL_LEVEL_COMMAND_STRING))
		{
			search = "total";
		}
		else
		{
			if (message.length() <= LEVEL_COMMAND_STRING.length())
			{
				return;
			}

			search = message.substring(LEVEL_COMMAND_STRING.length() + 1);
		}

		final HiscoreSkill skill = findHiscoreSkill(search);
		if (skill == null)
		{
			return;
		}

		final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);

		try
		{
			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());
			if (result == null)
			{
				log.warn("unable to look up skill {} for {}: not found", skill, search);
				return;
			}

			final Skill hiscoreSkill = result.getSkill(skill);
			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Level ")
				.append(ChatColorType.HIGHLIGHT)
				.append(skill.getName()).append(": ")
				.append(hiscoreSkill.getLevel() > -1 ? String.valueOf(hiscoreSkill.getLevel()) : "unranked")
				.append(ChatColorType.NORMAL);
			if (hiscoreSkill.getExperience() != -1)
			{
				chatMessageBuilder.append(" Experience: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", hiscoreSkill.getExperience()))
					.append(ChatColorType.NORMAL);
			}
			if (hiscoreSkill.getRank() != -1)
			{
				chatMessageBuilder.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", hiscoreSkill.getRank()));
			}

			final String response = chatMessageBuilder.build();
			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("unable to look up skill {} for {}", skill, search, ex);
		}
	}

	private void combatLevelLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lvl())
		{
			return;
		}

		final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);

		try
		{
			HiscoreResult playerStats = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());

			if (playerStats == null)
			{
				log.warn("Error fetching hiscore data: not found");
				return;
			}

			int attack = playerStats.getSkill(HiscoreSkill.ATTACK).getLevel();
			int strength = playerStats.getSkill(HiscoreSkill.STRENGTH).getLevel();
			int defence = playerStats.getSkill(HiscoreSkill.DEFENCE).getLevel();
			int hitpoints = playerStats.getSkill(HiscoreSkill.HITPOINTS).getLevel();
			int ranged = playerStats.getSkill(HiscoreSkill.RANGED).getLevel();
			int prayer = playerStats.getSkill(HiscoreSkill.PRAYER).getLevel();
			int magic = playerStats.getSkill(HiscoreSkill.MAGIC).getLevel();
			int combatLevel = Experience.getCombatLevel(attack, strength, defence, hitpoints, magic, ranged, prayer);

			String response = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Combat Level: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(combatLevel))
				.append(ChatColorType.NORMAL)
				.append(" A: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(attack))
				.append(ChatColorType.NORMAL)
				.append(" S: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(strength))
				.append(ChatColorType.NORMAL)
				.append(" D: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(defence))
				.append(ChatColorType.NORMAL)
				.append(" H: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(hitpoints))
				.append(ChatColorType.NORMAL)
				.append(" R: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(ranged))
				.append(ChatColorType.NORMAL)
				.append(" P: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(prayer))
				.append(ChatColorType.NORMAL)
				.append(" M: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(magic))
				.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("Error fetching hiscore data", ex);
		}
	}

	private void leaguePointsLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lp())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.LEAGUE_POINTS);
	}

	private void bountyHunterHunterLookup(ChatMessage chatMessage, String message)
	{
		if (!config.bh())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.BOUNTY_HUNTER_HUNTER);
	}

	private void bountyHunterRogueLookup(ChatMessage chatMessage, String message)
	{
		if (!config.bhRogue())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.BOUNTY_HUNTER_ROGUE);
	}

	private void lastManStandingLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lms())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.LAST_MAN_STANDING);
	}

	private void soulWarsZealLookup(ChatMessage chatMessage, String message)
	{
		if (!config.sw())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.SOUL_WARS_ZEAL);
	}

	private void minigameLookup(ChatMessage chatMessage, HiscoreSkill minigame)
	{
		try
		{
			final Skill hiscoreSkill;
			final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);

			// League points only exist on the league hiscores
			final HiscoreEndpoint endPoint = minigame == HiscoreSkill.LEAGUE_POINTS ?
				HiscoreEndpoint.LEAGUE :
				lookup.getEndpoint();

			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), endPoint);

			if (result == null)
			{
				log.warn("error looking up {} score: not found", minigame.getName().toLowerCase());
				return;
			}

			switch (minigame)
			{
				case BOUNTY_HUNTER_HUNTER:
				case BOUNTY_HUNTER_ROGUE:
				case LAST_MAN_STANDING:
				case LEAGUE_POINTS:
				case SOUL_WARS_ZEAL:
					hiscoreSkill = result.getSkill(minigame);
					break;
				default:
					log.warn("error looking up {} score: not implemented", minigame.getName().toLowerCase());
					return;
			}

			int score = hiscoreSkill.getLevel();
			if (score == -1)
			{
				return;
			}

			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(minigame.getName())
				.append(" Score: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", score));

			int rank = hiscoreSkill.getRank();
			if (rank != -1)
			{
				chatMessageBuilder.append(ChatColorType.NORMAL)
					.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", rank));
			}

			String response = chatMessageBuilder.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("error looking up {}", minigame.getName().toLowerCase(), ex);
		}
	}

	private void clueLookup(ChatMessage chatMessage, String message)
	{
		if (!config.clue())
		{
			return;
		}

		String search;

		if (message.equalsIgnoreCase(CLUES_COMMAND_STRING))
		{
			search = "total";
		}
		else
		{
			search = message.substring(CLUES_COMMAND_STRING.length() + 1);
		}

		try
		{
			final Skill hiscoreSkill;
			final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);
			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());

			if (result == null)
			{
				log.warn("error looking up clues: not found");
				return;
			}

			String level = search.toLowerCase();

			switch (level)
			{
				case "beginner":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_BEGINNER);
					break;
				case "easy":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_EASY);
					break;
				case "medium":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_MEDIUM);
					break;
				case "hard":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_HARD);
					break;
				case "elite":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_ELITE);
					break;
				case "master":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_MASTER);
					break;
				case "total":
					hiscoreSkill = result.getSkill(HiscoreSkill.CLUE_SCROLL_ALL);
					break;
				default:
					return;
			}

			int quantity = hiscoreSkill.getLevel();
			int rank = hiscoreSkill.getRank();
			if (quantity == -1)
			{
				return;
			}

			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Clue scroll (" + level + ")").append(": ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", quantity));

			if (rank != -1)
			{
				chatMessageBuilder.append(ChatColorType.NORMAL)
					.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", rank));
			}

			String response = chatMessageBuilder.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("error looking up clues", ex);
		}
	}

	/**
	 * Gets correct lookup data for message
	 *
	 * @param chatMessage chat message
	 * @return hiscore lookup data
	 */
	private HiscoreLookup getCorrectLookupFor(final ChatMessage chatMessage)
	{
		Player localPlayer = client.getLocalPlayer();
		final String player = Text.sanitize(chatMessage.getName());

		// If we are sending the message then just use the local hiscore endpoint for the world
		if (chatMessage.getType().equals(ChatMessageType.PRIVATECHATOUT)
			|| player.equals(localPlayer.getName()))
		{
			return new HiscoreLookup(localPlayer.getName(), hiscoreEndpoint);
		}

		if (chatMessage.getType() == ChatMessageType.PUBLICCHAT || chatMessage.getType() == ChatMessageType.MODCHAT)
		{
			// Public chat on a seasonal world is always seasonal or tournament hiscores, regardless of icon
			HiscoreEndpoint endpoint = HiscoreEndpoint.fromWorldTypes(client.getWorldType());
			if (endpoint != HiscoreEndpoint.NORMAL)
			{
				return new HiscoreLookup(player, endpoint);
			}
		}

		// Get ironman status from their icon in chat, this handles leagues too
		HiscoreEndpoint endpoint = getHiscoreEndpointByName(chatMessage.getName());
		return new HiscoreLookup(player, endpoint);
	}

	/**
	 * Compares the names of the items in the list with the original input.
	 * Returns the item if its name is equal to the original input or the
	 * shortest match if no exact match is found.
	 *
	 * @param items         List of items.
	 * @param originalInput String with the original input.
	 * @return Item which has a name equal to the original input.
	 */
	private ItemPrice retrieveFromList(List<ItemPrice> items, String originalInput)
	{
		ItemPrice shortest = null;
		for (ItemPrice item : items)
		{
			if (item.getName().toLowerCase().equals(originalInput.toLowerCase()))
			{
				return item;
			}

			if (shortest == null || item.getName().length() < shortest.getName().length())
			{
				shortest = item;
			}
		}

		// Take a guess
		return shortest;
	}

	/**
	 * Looks up the ironman status of the local player. Does NOT work on other players.
	 *
	 * @return hiscore endpoint
	 */
	private HiscoreEndpoint getLocalHiscoreEndpointType()
	{
		EnumSet<WorldType> worldType = client.getWorldType();
		HiscoreEndpoint endpoint = HiscoreEndpoint.fromWorldTypes(worldType);
		if (endpoint != HiscoreEndpoint.NORMAL)
		{
			// leagues/dmmt or dmm
			return endpoint;
		}

		return toEndPoint(client.getVarbitValue(VarbitID.IRONMAN));
	}

	/**
	 * Returns the ironman status based on the symbol in the name of the player.
	 *
	 * @param name player name
	 * @return hiscore endpoint
	 */
	private static HiscoreEndpoint getHiscoreEndpointByName(final String name)
	{
		if (name.contains(IconID.IRONMAN.toString()))
		{
			return HiscoreEndpoint.IRONMAN;
		}
		else if (name.contains(IconID.ULTIMATE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.ULTIMATE_IRONMAN;
		}
		else if (name.contains(IconID.HARDCORE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.HARDCORE_IRONMAN;
		}
		else if (name.contains(IconID.LEAGUE.toString()))
		{
			return HiscoreEndpoint.LEAGUE;
		}
		else
		{
			return HiscoreEndpoint.NORMAL;
		}
	}

	/**
	 * Converts account type to hiscore endpoint
	 *
	 * @param accountType account type
	 * @return hiscore endpoint
	 */
	private static HiscoreEndpoint toEndPoint(final int accountType)
	{
		switch (accountType)
		{
			case 1:
				return HiscoreEndpoint.IRONMAN;
			case 2:
				return HiscoreEndpoint.ULTIMATE_IRONMAN;
			case 3:
				return HiscoreEndpoint.HARDCORE_IRONMAN;
			default:
				return HiscoreEndpoint.NORMAL;
		}
	}

	@Value
	private static class HiscoreLookup
	{
		private final String name;
		private final HiscoreEndpoint endpoint;
	}

	private static String longBossName(String boss)
	{
		String lowerBoss = boss.toLowerCase();
		if (lowerBoss.endsWith(" (echo)"))
		{
			String actualBoss = lowerBoss.substring(0, lowerBoss.length() - " (echo)".length());
			return longBossName(actualBoss) + " (Echo)";
		}

		switch (lowerBoss)
		{
			case "corp":
				return "Corporeal Beast";

			case "jad":
			case "tzhaar fight cave":
				return "TzTok-Jad";

			case "kq":
				return "Kalphite Queen";

			case "chaos ele":
				return "Chaos Elemental";

			case "dusk":
			case "dawn":
			case "gargs":
			case "ggs":
			case "gg":
				return "Grotesque Guardians";

			case "crazy arch":
				return "Crazy Archaeologist";

			case "deranged arch":
				return "Deranged Archaeologist";

			case "mole":
				return "Giant Mole";

			case "vetion":
				return "Vet'ion";

			case "calvarion":
			case "calv":
				return "Calvar'ion";

			case "vene":
				return "Venenatis";

			case "kbd":
				return "King Black Dragon";

			case "vork":
				return "Vorkath";

			case "sire":
				return "Abyssal Sire";

			case "smoke devil":
			case "thermy":
				return "Thermonuclear Smoke Devil";

			case "cerb":
				return "Cerberus";

			case "zuk":
			case "inferno":
				return "TzKal-Zuk";

			case "hydra":
				return "Alchemical Hydra";

			// gwd
			case "sara":
			case "saradomin":
			case "zilyana":
			case "zily":
				return "Commander Zilyana";
			case "zammy":
			case "zamorak":
			case "kril":
			case "kril tsutsaroth":
				return "K'ril Tsutsaroth";
			case "arma":
			case "kree":
			case "kreearra":
			case "armadyl":
				return "Kree'arra";
			case "bando":
			case "bandos":
			case "graardor":
				return "General Graardor";

			// dks
			case "supreme":
				return "Dagannoth Supreme";
			case "rex":
				return "Dagannoth Rex";
			case "prime":
				return "Dagannoth Prime";

			case "wt":
				return "Wintertodt";
			case "barrows":
				return "Barrows Chests";
			case "herbi":
				return "Herbiboar";

			// Chambers of Xeric
			case "cox":
			case "xeric":
			case "chambers":
			case "olm":
			case "raids":
				return "Chambers of Xeric";
			case "cox 1":
			case "cox solo":
				return "Chambers of Xeric Solo";
			case "cox 2":
			case "cox duo":
				return "Chambers of Xeric 2 players";
			case "cox 3":
				return "Chambers of Xeric 3 players";
			case "cox 4":
				return "Chambers of Xeric 4 players";
			case "cox 5":
				return "Chambers of Xeric 5 players";
			case "cox 6":
				return "Chambers of Xeric 6 players";
			case "cox 7":
				return "Chambers of Xeric 7 players";
			case "cox 8":
				return "Chambers of Xeric 8 players";
			case "cox 9":
				return "Chambers of Xeric 9 players";
			case "cox 10":
				return "Chambers of Xeric 10 players";
			case "cox 11-15":
			case "cox 11":
			case "cox 12":
			case "cox 13":
			case "cox 14":
			case "cox 15":
				return "Chambers of Xeric 11-15 players";
			case "cox 16-23":
			case "cox 16":
			case "cox 17":
			case "cox 18":
			case "cox 19":
			case "cox 20":
			case "cox 21":
			case "cox 22":
			case "cox 23":
				return "Chambers of Xeric 16-23 players";
			case "cox 24":
			case "cox 24+":
				return "Chambers of Xeric 24+ players";

			// Chambers of Xeric Challenge Mode
			case "chambers of xeric: challenge mode":
			case "cox cm":
			case "xeric cm":
			case "chambers cm":
			case "olm cm":
			case "raids cm":
			case "chambers of xeric - challenge mode":
				return "Chambers of Xeric Challenge Mode";
			case "cox cm 1":
			case "cox cm solo":
				return "Chambers of Xeric Challenge Mode Solo";
			case "cox cm 2":
			case "cox cm duo":
				return "Chambers of Xeric Challenge Mode 2 players";
			case "cox cm 3":
				return "Chambers of Xeric Challenge Mode 3 players";
			case "cox cm 4":
				return "Chambers of Xeric Challenge Mode 4 players";
			case "cox cm 5":
				return "Chambers of Xeric Challenge Mode 5 players";
			case "cox cm 6":
				return "Chambers of Xeric Challenge Mode 6 players";
			case "cox cm 7":
				return "Chambers of Xeric Challenge Mode 7 players";
			case "cox cm 8":
				return "Chambers of Xeric Challenge Mode 8 players";
			case "cox cm 9":
				return "Chambers of Xeric Challenge Mode 9 players";
			case "cox cm 10":
				return "Chambers of Xeric Challenge Mode 10 players";
			case "cox cm 11-15":
			case "cox cm 11":
			case "cox cm 12":
			case "cox cm 13":
			case "cox cm 14":
			case "cox cm 15":
				return "Chambers of Xeric Challenge Mode 11-15 players";
			case "cox cm 16-23":
			case "cox cm 16":
			case "cox cm 17":
			case "cox cm 18":
			case "cox cm 19":
			case "cox cm 20":
			case "cox cm 21":
			case "cox cm 22":
			case "cox cm 23":
				return "Chambers of Xeric Challenge Mode 16-23 players";
			case "cox cm 24":
			case "cox cm 24+":
				return "Chambers of Xeric Challenge Mode 24+ players";

			// Theatre of Blood
			case "tob":
			case "theatre":
			case "verzik":
			case "verzik vitur":
			case "raids 2":
				return "Theatre of Blood";
			case "tob 1":
			case "tob solo":
				return "Theatre of Blood Solo";
			case "tob 2":
			case "tob duo":
				return "Theatre of Blood 2 players";
			case "tob 3":
				return "Theatre of Blood 3 players";
			case "tob 4":
				return "Theatre of Blood 4 players";
			case "tob 5":
				return "Theatre of Blood 5 players";

			// Theatre of Blood Entry Mode
			case "theatre of blood: story mode":
			case "tob sm":
			case "tob story mode":
			case "tob story":
			case "theatre of blood: entry mode":
			case "tob em":
			case "tob entry mode":
			case "tob entry":
				return "Theatre of Blood Entry Mode";

			// Theatre of Blood Hard Mode
			case "theatre of blood: hard mode":
			case "tob cm":
			case "tob hm":
			case "tob hard mode":
			case "tob hard":
			case "hmt":
				return "Theatre of Blood Hard Mode";
			case "hmt 1":
			case "hmt solo":
				return "Theatre of Blood Hard Mode Solo";
			case "hmt 2":
			case "hmt duo":
				return "Theatre of Blood Hard Mode 2 players";
			case "hmt 3":
				return "Theatre of Blood Hard Mode 3 players";
			case "hmt 4":
				return "Theatre of Blood Hard Mode 4 players";
			case "hmt 5":
				return "Theatre of Blood Hard Mode 5 players";

			// Tombs of Amascut
			case "toa":
			case "tombs":
			case "amascut":
			case "warden":
			case "wardens":
			case "raids 3":
				return "Tombs of Amascut";
			case "toa 1":
			case "toa solo":
				return "Tombs of Amascut Solo";
			case "toa 2":
			case "toa duo":
				return "Tombs of Amascut 2 players";
			case "toa 3":
				return "Tombs of Amascut 3 players";
			case "toa 4":
				return "Tombs of Amascut 4 players";
			case "toa 5":
				return "Tombs of Amascut 5 players";
			case "toa 6":
				return "Tombs of Amascut 6 players";
			case "toa 7":
				return "Tombs of Amascut 7 players";
			case "toa 8":
				return "Tombs of Amascut 8 players";
			case "toa entry":
			case "tombs of amascut - entry":
			case "toa entry mode":
				return "Tombs of Amascut Entry Mode";
			case "toa entry 1":
			case "toa entry solo":
				return "Tombs of Amascut Entry Mode Solo";
			case "toa entry 2":
			case "toa entry duo":
				return "Tombs of Amascut Entry Mode 2 players";
			case "toa entry 3":
				return "Tombs of Amascut Entry Mode 3 players";
			case "toa entry 4":
				return "Tombs of Amascut Entry Mode 4 players";
			case "toa entry 5":
				return "Tombs of Amascut Entry Mode 5 players";
			case "toa entry 6":
				return "Tombs of Amascut Entry Mode 6 players";
			case "toa entry 7":
				return "Tombs of Amascut Entry Mode 7 players";
			case "toa entry 8":
				return "Tombs of Amascut Entry Mode 8 players";
			case "tombs of amascut: expert mode":
			case "toa expert":
			case "tombs of amascut - expert":
			case "toa expert mode":
				return "Tombs of Amascut Expert Mode";
			case "toa expert 1":
			case "toa expert solo":
				return "Tombs of Amascut Expert Mode Solo";
			case "toa expert 2":
			case "toa expert duo":
				return "Tombs of Amascut Expert Mode 2 players";
			case "toa expert 3":
				return "Tombs of Amascut Expert Mode 3 players";
			case "toa expert 4":
				return "Tombs of Amascut Expert Mode 4 players";
			case "toa expert 5":
				return "Tombs of Amascut Expert Mode 5 players";
			case "toa expert 6":
				return "Tombs of Amascut Expert Mode 6 players";
			case "toa expert 7":
				return "Tombs of Amascut Expert Mode 7 players";
			case "toa expert 8":
				return "Tombs of Amascut Expert Mode 8 players";

			// The Gauntlet
			case "gaunt":
			case "gauntlet":
			case "the gauntlet":
				return "Gauntlet";

			// Corrupted Gauntlet
			case "cgaunt":
			case "cgauntlet":
			case "the corrupted gauntlet":
			case "cg":
				return "Corrupted Gauntlet";

			// The Nightmare
			case "nm":
			case "tnm":
			case "nmare":
			case "the nightmare":
				return "Nightmare";

			// Phosani's Nightmare
			case "pnm":
			case "phosani":
			case "phosanis":
			case "phosani nm":
			case "phosani nightmare":
			case "phosanis nightmare":
				return "Phosani's Nightmare";

			// Hallowed Sepulchre
			case "hs":
			case "sepulchre":
			case "ghc":
				return "Hallowed Sepulchre";
			case "hs1":
			case "hs 1":
				return "Hallowed Sepulchre Floor 1";
			case "hs2":
			case "hs 2":
				return "Hallowed Sepulchre Floor 2";
			case "hs3":
			case "hs 3":
				return "Hallowed Sepulchre Floor 3";
			case "hs4":
			case "hs 4":
				return "Hallowed Sepulchre Floor 4";
			case "hs5":
			case "hs 5":
				return "Hallowed Sepulchre Floor 5";

			// Colossal Wyrm Basic Agility Course
			case "wbac":
			case "cwbac":
			case "wyrmb":
			case "wyrmbasic":
			case "wyrm basic":
			case "colossal basic":
			case "colossal wyrm basic":
				return "Colossal Wyrm Agility Course (Basic)";

			// Colossal Wyrm Advanced Agility Course
			case "waac":
			case "cwaac":
			case "wyrma":
			case "wyrmadvanced":
			case "wyrm advanced":
			case "colossal advanced":
			case "colossal wyrm advanced":
				return "Colossal Wyrm Agility Course (Advanced)";

			// Prifddinas Agility Course
			case "prif":
			case "prifddinas":
				return "Prifddinas Agility Course";

			// Shayzien Basic Agility Course
			case "shayb":
			case "sbac":
			case "shayzienbasic":
			case "shayzien basic":
				return "Shayzien Basic Agility Course";

			// Shayzien Advanced Agility Course
			case "shaya":
			case "saac":
			case "shayadv":
			case "shayadvanced":
			case "shayzien advanced":
				return "Shayzien Advanced Agility Course";

			// Ape Atoll Agility
			case "aa":
			case "ape atoll":
				return "Ape Atoll Agility";

			// Draynor Village Rooftop Course
			case "draynor":
			case "draynor agility":
				return "Draynor Village Rooftop";

			// Al-Kharid Rooftop Course
			case "al kharid":
			case "al kharid agility":
			case "al-kharid":
			case "al-kharid agility":
			case "alkharid":
			case "alkharid agility":
				return "Al Kharid Rooftop";

			// Varrock Rooftop Course
			case "varrock":
			case "varrock agility":
				return "Varrock Rooftop";

			// Canifis Rooftop Course
			case "canifis":
			case "canifis agility":
				return "Canifis Rooftop";

			// Falador Rooftop Course
			case "fally":
			case "fally agility":
			case "falador":
			case "falador agility":
				return "Falador Rooftop";

			// Seers' Village Rooftop Course
			case "seers":
			case "seers agility":
			case "seers village":
			case "seers village agility":
			case "seers'":
			case "seers' agility":
			case "seers' village":
			case "seers' village agility":
			case "seer's":
			case "seer's agility":
			case "seer's village":
			case "seer's village agility":
				return "Seers' Village Rooftop";

			// Pollnivneach Rooftop Course
			case "pollnivneach":
			case "pollnivneach agility":
				return "Pollnivneach Rooftop";

			// Rellekka Rooftop Course
			case "rellekka":
			case "rellekka agility":
				return "Rellekka Rooftop";

			// Ardougne Rooftop Course
			case "ardy":
			case "ardy agility":
			case "ardy rooftop":
			case "ardougne":
			case "ardougne agility":
				return "Ardougne Rooftop";

			// Agility Pyramid
			case "ap":
			case "pyramid":
				return "Agility Pyramid";

			// Barbarian Outpost
			case "barb":
			case "barb outpost":
				return "Barbarian Outpost";

			// Brimhaven Agility Arena
			case "brimhaven":
			case "brimhaven agility":
				return "Agility Arena";

			// Dorgesh-Kaan Agility Course
			case "dorg":
			case "dorgesh kaan":
			case "dorgesh-kaan":
				return "Dorgesh-Kaan Agility";

			// Gnome Stronghold Agility Course
			case "gnome stronghold":
				return "Gnome Stronghold Agility";

			// Penguin Agility
			case "penguin":
				return "Penguin Agility";

			// Werewolf Agility
			case "werewolf":
				return "Werewolf Agility";

			// Skullball
			case "skullball":
				return "Werewolf Skullball";

			// Wilderness Agility Course
			case "wildy":
			case "wildy agility":
				return "Wilderness Agility";

			// Jad challenge
			case "jad 1":
				return "TzHaar-Ket-Rak's First Challenge";
			case "jad 2":
				return "TzHaar-Ket-Rak's Second Challenge";
			case "jad 3":
				return "TzHaar-Ket-Rak's Third Challenge";
			case "jad 4":
				return "TzHaar-Ket-Rak's Fourth Challenge";
			case "jad 5":
				return "TzHaar-Ket-Rak's Fifth Challenge";
			case "jad 6":
				return "TzHaar-Ket-Rak's Sixth Challenge";

			// Guardians of the Rift
			case "gotr":
			case "runetodt":
			case "rifts closed":
				return "Guardians of the Rift";

			// Tempoross
			case "fishingtodt":
			case "fishtodt":
				return "Tempoross";

			// Phantom Muspah
			case "phantom":
			case "muspah":
			case "pm":
				return "Phantom Muspah";

			// Desert Treasure 2 bosses
			case "the leviathan":
			case "levi":
				return "Leviathan";
			case "duke":
				return "Duke Sucellus";
			case "the whisperer":
			case "whisp":
			case "wisp":
				return "Whisperer";
			case "vard":
				return "Vardorvis";

			// dt2 awakened variants
			case "leviathan awakened":
			case "the leviathan awakened":
			case "levi awakened":
				return "Leviathan (awakened)";
			case "duke sucellus awakened":
			case "duke awakened":
				return "Duke Sucellus (awakened)";
			case "whisperer awakened":
			case "the whisperer awakened":
			case "whisp awakened":
			case "wisp awakened":
				return "Whisperer (awakened)";
			case "vardorvis awakened":
			case "vard awakened":
				return "Vardorvis (awakened)";

			// lunar chest variants
			case "lunar chests":
			case "perilous moons":
			case "perilous moon":
			case "moons of peril":
				return "Lunar Chest";

			// hunter rumour variants
			case "hunterrumour":
			case "hunter contract":
			case "hunter contracts":
			case "hunter tasks":
			case "hunter task":
			case "rumours":
			case "rumour":
				return "Hunter Rumours";

			// sol heredit
			case "sol":
			case "colo":
			case "colosseum":
			case "fortis colosseum":
				return "Sol Heredit";

			case "bird egg":
			case "bird eggs":
			case "bird's egg":
			case "bird's eggs":
				return "Bird's egg offerings";

			case "amox":
				return "Amoxliatl";

			case "the hueycoatl":
			case "huey":
				return "Hueycoatl";

			case "crystal chest":
				return "crystal chest";

			case "larran small chest":
			case "larran's small chest":
				return "Larran's small chest";

			case "larran chest":
			case "larran's chest":
			case "larran big chest":
			case "larran's big chest":
				return "Larran's big chest";

			case "brimstone chest":
				return "Brimstone chest";

			default:
				return WordUtils.capitalize(boss);
		}
	}

	private static String longSkillName(String skill)
	{
		switch (skill.toUpperCase())
		{
			case "ATK":
			case "ATT":
				return net.runelite.api.Skill.ATTACK.getName();
			case "DEF":
				return net.runelite.api.Skill.DEFENCE.getName();
			case "STR":
				return net.runelite.api.Skill.STRENGTH.getName();
			case "HEALTH":
			case "HIT":
			case "HITPOINT":
			case "HP":
				return net.runelite.api.Skill.HITPOINTS.getName();
			case "RANGE":
			case "RANGING":
			case "RNG":
				return net.runelite.api.Skill.RANGED.getName();
			case "PRAY":
				return net.runelite.api.Skill.PRAYER.getName();
			case "MAG":
			case "MAGE":
				return net.runelite.api.Skill.MAGIC.getName();
			case "COOK":
				return net.runelite.api.Skill.COOKING.getName();
			case "WC":
			case "WOOD":
			case "WOODCUT":
				return net.runelite.api.Skill.WOODCUTTING.getName();
			case "FLETCH":
				return net.runelite.api.Skill.FLETCHING.getName();
			case "FISH":
				return net.runelite.api.Skill.FISHING.getName();
			case "FM":
			case "FIRE":
				return net.runelite.api.Skill.FIREMAKING.getName();
			case "CRAFT":
				return net.runelite.api.Skill.CRAFTING.getName();
			case "SMITH":
				return net.runelite.api.Skill.SMITHING.getName();
			case "MINE":
				return net.runelite.api.Skill.MINING.getName();
			case "HL":
			case "HERB":
				return net.runelite.api.Skill.HERBLORE.getName();
			case "AGI":
			case "AGIL":
				return net.runelite.api.Skill.AGILITY.getName();
			case "THIEF":
				return net.runelite.api.Skill.THIEVING.getName();
			case "SLAY":
				return net.runelite.api.Skill.SLAYER.getName();
			case "FARM":
				return net.runelite.api.Skill.FARMING.getName();
			case "RC":
			case "RUNE":
			case "RUNECRAFTING":
				return net.runelite.api.Skill.RUNECRAFT.getName();
			case "HUNT":
				return net.runelite.api.Skill.HUNTER.getName();
			case "CON":
			case "CONSTRUCT":
				return net.runelite.api.Skill.CONSTRUCTION.getName();
			case "ALL":
			case "TOTAL":
				return "Overall";
			default:
				return skill;
		}
	}

	private static HiscoreSkill findHiscoreSkill(String search)
	{
		String s = longSkillName(search);
		if (s == search)
		{
			s = longBossName(search);
		}
		for (HiscoreSkill skill : HiscoreSkill.values())
		{
			// longBossName the skill name to normalize from hiscore name
			// to our internal name (removing the colon)
			if (longBossName(skill.getName()).equalsIgnoreCase(s))
			{
				return skill;
			}
		}
		return null;
	}

	private int tobTeamSize()
	{
		return Math.min(client.getVarbitValue(VarbitID.TOB_CLIENT_P0), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOB_CLIENT_P1), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOB_CLIENT_P2), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOB_CLIENT_P3), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOB_CLIENT_P4), 1);
	}

	private int toaTeamSize()
	{
		return Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P0), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P1), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P2), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P3), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P4), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P5), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P6), 1) +
			Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P7), 1);
	}

	private int findPet(String name)
	{
		for (int petId : pets)
		{
			final ItemComposition item = itemManager.getItemComposition(petId);
			if (item.getName().equals(name))
			{
				return item.getId();
			}
		}
		return -1;
	}
}
