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
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import static net.runelite.api.Skill.SLAYER;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.SetMessage;
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
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("^(?:You're assigned to kill|You have received a new Slayer assignment from .*:) (?:[Tt]he )?(?<name>.+?)(?: (?:in|on) (?:the )?(?<location>[^;]+))?(?:; only | \\()(?<amount>\\d+)(?: more to go\\.|\\))$");
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_COMPLETE_MESSAGE = Pattern.compile("(?:\\d+,)*\\d+");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final String CHAT_BRACELET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer";
	private static final Pattern CHAT_BRACELET_SLAUGHTER_REGEX = Pattern.compile("Your bracelet of slaughter prevents your slayer count decreasing. It has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your";
	private static final Pattern CHAT_BRACELET_EXPEDITIOUS_REGEX = Pattern.compile("Your expeditious bracelet helps you progress your slayer (?:task )?faster. It has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE = "Your bracelet of slaughter has ";
	private static final Pattern CHAT_BRACELET_SLAUGHTER_CHARGE_REGEX = Pattern.compile("Your bracelet of slaughter has (\\d{1,2}) charge[s]? left.");
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE = "Your expeditious bracelet has ";
	private static final Pattern CHAT_BRACELET_EXPEDITIOUS_CHARGE_REGEX = Pattern.compile("Your expeditious bracelet has (\\d{1,2}) charge[s]? left.");
	private static final Pattern COMBAT_BRACELET_TASK_UPDATE_MESSAGE = Pattern.compile("^You still need to kill (\\d+) monsters to complete your current Slayer assignment");

	//NPC messages
	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*(?:Your new task is to kill|You are to bring balance to)\\s*(?<amount>\\d+) (?<name>.+?)(?: (?:in|on) (?:the )?(?<location>.+))?\\.");
	private static final Pattern NPC_ASSIGN_BOSS_MESSAGE = Pattern.compile("^Excellent. You're now assigned to kill (?:the )?(.*) (\\d+) times.*Your reward point tally is (.*)\\.$");
	private static final Pattern NPC_ASSIGN_FIRST_MESSAGE = Pattern.compile("^We'll start you off hunting (.*), you'll need to kill (\\d*) of them.");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("^You're still (?:hunting|bringing balance to) (?<name>.+)(?: (?:in|on) (?:the )?(?<location>.+), with|; you have) (?<amount>\\d+) to go\\..*");

	//Reward UI
	private static final Pattern REWARD_POINTS = Pattern.compile("Reward points: ((?:\\d+,)*\\d+)");

	private static final int GROTESQUE_GUARDIANS_REGION = 6727;

	private static final int EXPEDITIOUS_CHARGE = 30;
	private static final int SLAUGHTER_CHARGE = 30;

	// Chat Command
	private static final String TASK_COMMAND_STRING = "!task";
	private static final Pattern TASK_STRING_VALIDATION = Pattern.compile("[^a-zA-Z0-9' -]");
	private static final int TASK_STRING_MAX_LENGTH = 50;

	@Inject
	private Client client;

	@Inject
	private SlayerConfig config;

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

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int amount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int lastCertainAmount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int initialAmount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskLocation;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int expeditiousChargeCount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int slaughterChargeCount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private String taskName;

	@Getter(AccessLevel.PACKAGE)
	private int streak;

	@Getter(AccessLevel.PACKAGE)
	private int points;

	private TaskCounter counter;
	private int cachedXp;
	private Instant infoTimer;
	private boolean loginFlag;
	private List<String> targetNames = new ArrayList<>();
	private List<Integer> targetIds = new ArrayList<>();
	private boolean checkAsTokens = true;

	private List<NPCPresence> lingeringPresences = new ArrayList<>();
	private SlayerXpDropLookup slayerXpDropLookup = null;

	private void clearTrackedNPCs()
	{
		highlightedTargets.clear();
		lingeringPresences.clear();
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(targetClickboxOverlay);
		overlayManager.add(targetWeaknessOverlay);
		overlayManager.add(targetMinimapOverlay);

		if (slayerXpDropLookup == null)
		{
			// create this in startup since it needs to pull files during creation
			slayerXpDropLookup = new SlayerXpDropLookup();
		}

		if (client.getGameState() == GameState.LOGGED_IN
			&& config.amount() != -1
			&& !config.taskName().isEmpty())
		{
			points = config.points();
			streak = config.streak();
			setExpeditiousChargeCount(config.expeditious());
			setSlaughterChargeCount(config.slaughter());
			clientThread.invoke(() -> setTask(config.taskName(), config.amount(), config.initialAmount(), config.taskLocation(), config.lastCertainAmount()));
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
		clearTrackedNPCs();

		chatCommandManager.unregisterCommand(TASK_COMMAND_STRING);
	}

	@Provides
	SlayerConfig getConfig(ConfigManager configManager)
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
				cachedXp = 0;
				taskName = "";
				amount = 0;
				lastCertainAmount = 0;
				loginFlag = true;
				clearTrackedNPCs();
				break;
			case LOGGED_IN:
				if (config.amount() != -1
					&& !config.taskName().isEmpty()
					&& loginFlag)
				{
					points = config.points();
					streak = config.streak();
					setExpeditiousChargeCount(config.expeditious());
					setSlaughterChargeCount(config.slaughter());
					setTask(config.taskName(), config.amount(), config.initialAmount(), config.taskLocation(), config.lastCertainAmount());
					loginFlag = false;
				}
				break;
		}
	}

	private void save()
	{
		config.amount(amount);
		config.initialAmount(initialAmount);
		config.taskName(taskName);
		config.taskLocation(taskLocation);
		config.lastCertainAmount(lastCertainAmount);
		config.points(points);
		config.streak(streak);
		config.expeditious(expeditiousChargeCount);
		config.slaughter(slaughterChargeCount);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		if (isTarget(npc))
		{
			highlightedTargets.add(npc);
			NPCPresence newPresence = NPCPresence.buildPresence(npc);
			log.debug("New presence of " + newPresence.toString());
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		boolean contained = highlightedTargets.remove(npc);
		if (contained)
		{
			NPCPresence lingeringPresence = NPCPresence.buildPresence(npc);
			lingeringPresences.add(lingeringPresence);
			log.debug("Presence of " + lingeringPresence.toString() + " now lingering");
		}
	}

	int estimateKillCount(List<NPCPresence> potentialKills, int gains)
	{
		// failsafe to avoid calculating kill count if there were no slayer monsters around that could be killed on task
		// this failsafe *WILL FAIL* if someone decides to lamp their slayer in the middle of a task next to on task creatures
		// but will prevent any other kind of slayer xp from triggering the kill count going down
		// the main problem this causes is a genie random event during a slayer task and the player pops the lamp
		// this will think that some of the monsters around were slain - e.g. lvl 50 slayer pops lamp for 500 xp around a
		// 70 xp per kill slayer monster and now the slayer plugin thinks that 7 more kill count were completed (at 99 slayer
		// the 990 xp drop would really mess with the kc tracker in a noticeable way)
		if (potentialKills.size() < 1)
		{
			return 0;
		}

		StringBuilder debugString = new StringBuilder();
		for (NPCPresence presence : potentialKills)
		{
			debugString.append(presence.toString());
			debugString.append(", ");
		}
		log.debug("Estimating kc of xp drop " + gains + " for presences {" +
				debugString.toString() + "}");

		// first determine potential xp drops given by all npcs that died this tick by grabbing the slayer xp
		// info from the map made out of the data in slayer_xp.json
		List<Double> potentialXpDrops = new ArrayList<>();
		for (NPCPresence potentialDead : potentialKills)
		{
			double xp = slayerXpDropLookup.findXpForNpc(potentialDead);
			if (xp > 0)
			{
				potentialXpDrops.add(xp);
			}
		}

		debugString = new StringBuilder();
		for (Double drop : potentialXpDrops)
		{
			debugString.append(drop);
			debugString.append(", ");
		}
		log.debug("Determined xp drop " + gains + " can be made of {" + debugString.toString()
				+ "}");

		// we can attempt to determine exactly how many npcs died to give this amount of xp
		// by using a solver for the knapsack problem

		// add one to max gains allowed for knapsack optimization
		// since xp is only sent to us as integers but is stored on servers
		// (and therefore gained as) a double
		int fudgedGains = gains + 1;

		// scale the problem up by a factor of 10 since knapsack problem is solved better with integers
		// and xp drops can have a single number after the decimal point
		int tenFudgedGains = fudgedGains * 10;
		List<Integer> potentialXpDropsAsInts = potentialXpDrops.stream()
				.map(xpDrop -> (int) (xpDrop * 10))
				.collect(Collectors.toCollection(ArrayList::new));

		KnapsackSolver solver = new KnapsackSolver();

		int estimatedCount = solver.howMuchFitsInSack(potentialXpDropsAsInts, tenFudgedGains);

		if (estimatedCount > potentialXpDrops.size())
		{
			log.info("capping estimatedCount at " + potentialXpDrops.size() +
				" b/c there were not " + estimatedCount + " nearby potential kills");
			estimatedCount = potentialXpDrops.size();
		}
		if (estimatedCount < 1)
		{
			log.info("capping estimatedCount at a minimum of 1 since player was nearby slayer monsters on task; " +
					"potentially had 50% xp drop due to shared slayer kill");
			estimatedCount = 1;
		}
		log.debug("Expecting kill count to be changed by " + estimatedCount);
		return estimatedCount;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		// update the lingering presence of npcs in the slayer xp consideration list
		Iterator<NPCPresence> presenceIterator = lingeringPresences.iterator();
		while (presenceIterator.hasNext())
		{
			NPCPresence presence = presenceIterator.next();
			presence.tickExistence();
			if (!presence.shouldExist())
			{
				log.debug("Lingering presence of " + presence.toString() + " expired");
				presenceIterator.remove();
			}
		}

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
				setTask(name, amount, amount, location, lastCertainAmount);
			}
			else if (mAssignFirst.find())
			{
				int amount = Integer.parseInt(mAssignFirst.group(2));
				setTask(mAssignFirst.group(1), amount, amount, lastCertainAmount);
			}
			else if (mAssignBoss.find())
			{
				int amount = Integer.parseInt(mAssignBoss.group(2));
				setTask(mAssignBoss.group(1), amount, amount, lastCertainAmount);
				points = Integer.parseInt(mAssignBoss.group(3).replaceAll(",", ""));
			}
			else if (mCurrent.find())
			{
				String name = mCurrent.group("name");
				int amount = Integer.parseInt(mCurrent.group("amount"));
				String location = mCurrent.group("location");
				setTask(name, amount, initialAmount, location, lastCertainAmount);
			}
		}

		Widget braceletBreakWidget = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (braceletBreakWidget != null)
		{
			String braceletText = Text.removeTags(braceletBreakWidget.getText()); //remove color and linebreaks
			if (braceletText.contains("bracelet of slaughter"))
			{
				slaughterChargeCount = SLAUGHTER_CHARGE;
				config.slaughter(slaughterChargeCount);
			}
			else if (braceletText.contains("expeditious bracelet"))
			{
				expeditiousChargeCount = EXPEDITIOUS_CHARGE;
				config.expeditious(expeditiousChargeCount);
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
					points = Integer.parseInt(mPoints.group(1).replaceAll(",", ""));
					break;
				}
			}
		}

		if (infoTimer != null)
		{
			Duration timeSinceInfobox = Duration.between(infoTimer, Instant.now());
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());

			if (timeSinceInfobox.compareTo(statTimeout) >= 0)
			{
				removeCounter();
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks

		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER))
		{
			Matcher mSlaughter = CHAT_BRACELET_SLAUGHTER_REGEX.matcher(chatMsg);

			amount++;
			slaughterChargeCount = mSlaughter.find() ? Integer.parseInt(mSlaughter.group(1)) : SLAUGHTER_CHARGE;
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			Matcher mExpeditious = CHAT_BRACELET_EXPEDITIOUS_REGEX.matcher(chatMsg);

			amount--;
			expeditiousChargeCount = mExpeditious.find() ? Integer.parseInt(mExpeditious.group(1)) : EXPEDITIOUS_CHARGE;
			config.expeditious(expeditiousChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS_CHARGE))
		{
			Matcher mExpeditious = CHAT_BRACELET_EXPEDITIOUS_CHARGE_REGEX.matcher(chatMsg);

			if (!mExpeditious.find())
			{
				return;
			}

			expeditiousChargeCount = Integer.parseInt(mExpeditious.group(1));
			config.expeditious(expeditiousChargeCount);
		}
		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER_CHARGE))
		{
			Matcher mSlaughter = CHAT_BRACELET_SLAUGHTER_CHARGE_REGEX.matcher(chatMsg);
			if (!mSlaughter.find())
			{
				return;
			}

			slaughterChargeCount = Integer.parseInt(mSlaughter.group(1));
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.endsWith("; return to a Slayer master."))
		{
			Matcher mComplete = CHAT_COMPLETE_MESSAGE.matcher(chatMsg);

			List<String> matches = new ArrayList<>();
			while (mComplete.find())
			{
				matches.add(mComplete.group(0).replaceAll(",", ""));
			}

			switch (matches.size())
			{
				case 0:
					streak = 1;
					break;
				case 1:
					streak = Integer.parseInt(matches.get(0));
					break;
				case 3:
					streak = Integer.parseInt(matches.get(0));
					points = Integer.parseInt(matches.get(2));
					break;
				default:
					log.warn("Unreachable default case for message ending in '; return to Slayer master'");
			}

			log.debug("Slayer task completed with " + amount + " remaining");
			log.debug("Last certain amount was " + lastCertainAmount +
				" so error rate is " + amount + " in " + lastCertainAmount);

			setTask("", 0, 0, 0);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			setTask("", 0, 0, 0);
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
			setTask(name, gemAmount, initialAmount, location, gemAmount);
			return;
		}

		final Matcher bracerProgress = COMBAT_BRACELET_TASK_UPDATE_MESSAGE.matcher(chatMsg);

		if (bracerProgress.find())
		{
			final int taskAmount = Integer.parseInt(bracerProgress.group(1));
			setTask(taskName, taskAmount, initialAmount, taskAmount);

			// Avoid race condition (combat brace message goes through first before XP drop)
			amount++;
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() != SLAYER)
		{
			return;
		}

		int slayerExp = client.getSkillExperience(SLAYER);

		if (slayerExp <= cachedXp)
		{
			return;
		}

		if (cachedXp != 0)
		{
			// this is not the initial xp sent on login so these are new xp gains
			int gains = slayerExp - cachedXp;

			log.debug("Slayer xp drop received");

			StringBuilder debugString = new StringBuilder();

			// potential npcs to give xp drop are current highlighted npcs and the lingering presences
			List<NPCPresence> potentialNPCs = new ArrayList<>();
			debugString.append("Lingering presences {");
			for (NPCPresence presence : lingeringPresences)
			{
				potentialNPCs.add(presence);
				debugString.append(presence.toString());
				debugString.append(", ");
			}
			debugString.append("}\nCurrent presences {");
			for (NPC npc : highlightedTargets)
			{
				NPCPresence currentPresence = NPCPresence.buildPresence(npc);
				potentialNPCs.add(currentPresence);
				debugString.append(currentPresence.toString());
				debugString.append(", ");
			}
			debugString.append("}");
			log.debug(debugString.toString());

			int killCount = estimateKillCount(potentialNPCs, gains);
			for (int i = 0; i < killCount; i++)
			{
				killedOne();
			}
		}
		cachedXp = slayerExp;
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("slayer"))
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
	void killedOne()
	{
		if (amount == 0)
		{
			return;
		}

		amount--;
		if (doubleTroubleExtraKill())
		{
			amount--;
		}

		config.amount(amount); // save changed value

		if (!config.showInfobox())
		{
			return;
		}

		// add and update counter, set timer
		addCounter();
		counter.setText(String.valueOf(amount));
		infoTimer = Instant.now();
	}

	private boolean doubleTroubleExtraKill()
	{
		return WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID() == GROTESQUE_GUARDIANS_REGION &&
				SlayerUnlock.GROTESQUE_GARDIAN_DOUBLE_COUNT.isEnabled(client);
	}

	// checks if any contiguous subsequence of seq0 exactly matches the String toMatch
	boolean contiguousSubsequenceMatches(String[] seq0, String toMatch)
	{
		for (int i = 0; i < seq0.length; i++)
		{
			for (int j = i; j < seq0.length; j++)
			{
				String sub0 = "";
				for (int k = i; k <= j; k++)
				{
					sub0 += seq0[k] + " ";
				}
				sub0 = sub0.substring(0, sub0.length() - 1); // remove extra space
				if (sub0.equals(toMatch))
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValidComposition(NPCComposition composition)
	{
		if (composition != null)
		{
			List<String> actions = Arrays.asList(composition.getActions());
			if (actions.contains("Attack") || actions.contains("Pick")) //Pick action is for zygomite-fungi
			{
				return true;
			}
		}

		return false;
	}

	private boolean isTarget(NPC npc)
	{
		if (targetNames.isEmpty() && targetIds.isEmpty())
		{
			return false;
		}

		String name = npc.getName();
		if (name == null)
		{
			return false;
		}

		name = name.toLowerCase();

		// in order to avoid issues like pirates being highlighted on a rats task
		// rather than checking if the name contains any of the targets we do a complete
		// token check which is where we tokenize the name on the space character
		// then we check if any contiguous subsequence (of at least length 1) from the name matches
		// the target.

		// we have a boolean flag that also allows the behavior of just doing a contains check to happen
		// this is done specifically for the tzhaar task because it's much easier to just check if the enemy
		// contains "Tz-" then listing the many many many types of tzhaar.

		for (String target : targetNames)
		{
			if (!checkAsTokens)
			{
				if (name.contains(target) && isValidComposition(npc.getTransformedComposition()))
				{
					return true;
				}
			}
			else
			{
				String[] nameTokens = name.split(" ");
				if (contiguousSubsequenceMatches(nameTokens, target) && isValidComposition(npc.getTransformedComposition()))
				{
					return true;
				}
			}
		}

		int id = npc.getId();
		if (id <= 0)
		{
			return false;
		}

		for (int target : targetIds)
		{
			if (id == target && isValidComposition(npc.getTransformedComposition()))
			{
				return true;
			}
		}

		return false;
	}

	private void rebuildTargetNames(Task task)
	{
		targetNames.clear();

		if (task != null)
		{
			task.getTargetNames().stream()
				.map(String::toLowerCase)
				.forEach(targetNames::add);

			targetNames.add(taskName.toLowerCase().replaceAll("s$", ""));
		}
	}

	private void rebuildTargetIds(Task task)
	{
		targetIds.clear();

		if (task != null)
		{
			task.getNpcIds().stream()
				.forEach(targetIds::add);
		}
	}

	private void rebuildCheckAsTokens(Task task)
	{
		if (task != null)
		{
			checkAsTokens = task.isCheckAsTokens();
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

	private void setTask(String name, int amt, int initAmt, int lastCertainAmt)
	{
		setTask(name, amt, initAmt, null, lastCertainAmt);
	}

	private void setTask(String name, int amt, int initAmt, String location, int lastCertainAmt)
	{
		taskName = name;
		amount = amt;
		initialAmount = initAmt;
		taskLocation = location;
		lastCertainAmount = lastCertainAmt;
		save();
		removeCounter();
		addCounter();
		infoTimer = Instant.now();

		Task task = Task.getTask(name);
		rebuildTargetNames(task);
		rebuildTargetIds(task);
		rebuildCheckAsTokens(task);
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
		counter.setTooltip(String.format(taskTooltip, capsString(taskName), points, streak));

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

	void taskLookup(SetMessage setMessage, String message)
	{
		if (!config.taskCommand())
		{
			return;
		}

		ChatMessageType type = setMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.removeTags(setMessage.getName())
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
			TASK_STRING_VALIDATION.matcher(task.getLocation()).find() || task.getLocation().length() > TASK_STRING_MAX_LENGTH)
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

		final MessageNode messageNode = setMessage.getMessageNode();
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
}
