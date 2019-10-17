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
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import static net.runelite.api.Skill.SLAYER;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcDefinitionChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
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
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.api.util.Text;
import net.runelite.http.api.chat.ChatClient;

@PluginDescriptor(
	name = "Slayer",
	description = "Show additional slayer task related information",
	tags = {"combat", "notifications", "overlay", "tasks"}
)
@PluginDependency(XpTrackerPlugin.class)
@Slf4j
@Singleton
public class SlayerPlugin extends Plugin
{
	//Chat messages
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("^(?:You're assigned to kill|You have received a new Slayer assignment from .*:) (?:[Tt]he )?(?<name>.+?)(?: (?:in|on|south of) (?:the )?(?<location>[^;]+))?(?:; only | \\()(?<amount>\\d+)(?: more to go\\.|\\))$");
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_COMPLETE_MESSAGE = Pattern.compile("(?:\\d+,)*\\d+");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final Pattern COMBAT_BRACELET_TASK_UPDATE_MESSAGE = Pattern.compile("^You still need to kill (\\d+) monsters to complete your current Slayer assignment");

	private static final String CHAT_BRACELET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer";
	private static final String CHAT_BRACELET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your";


	//NPC messages
	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*(?:Your new task is to kill|You are to bring balance to)\\s*(?<amount>\\d+) (?<name>.+?)(?: (?:in|on|south of) (?:the )?(?<location>.+))?\\.");
	private static final Pattern NPC_ASSIGN_BOSS_MESSAGE = Pattern.compile("^Excellent. You're now assigned to kill (?:the )?(.*) (\\d+) times.*Your reward point tally is (.*)\\.$");
	private static final Pattern NPC_ASSIGN_FIRST_MESSAGE = Pattern.compile("^We'll start you off hunting (.*), you'll need to kill (\\d*) of them.");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("^You're still (?:hunting|bringing balance to) (?<name>.+)(?: (?:in|on|south of) (?:the )?(?<location>.+), with|; you have) (?<amount>\\d+) to go\\..*");

	private static final int GROTESQUE_GUARDIANS_REGION = 6727;

	private static final Set<Task> weaknessTasks = ImmutableSet.of(Task.LIZARDS, Task.GARGOYLES,
		Task.GROTESQUE_GUARDIANS, Task.GROTESQUE_GUARDIANS, Task.MUTATED_ZYGOMITES, Task.ROCKSLUGS);

	// Chat Command
	private static final String TASK_COMMAND_STRING = "!task";
	private static final Pattern TASK_STRING_VALIDATION = Pattern.compile("[^a-zA-Z0-9' -]");
	private static final int TASK_STRING_MAX_LENGTH = 50;
	private static final String POINTS_COMMAND_STRING = "!points";

	private static final double DMM_MULTIPLIER_RATIO = 5;

	// Superiors
	@VisibleForTesting
	static final List<String> SUPERIOR_SLAYER_MONSTERS = Arrays.asList(
		"crushing hand",
		"chasm crawler",
		"screaming banshee",
		"screaming twisted banshee",
		"giant rockslug",
		"cockathrice",
		"flaming pyrelord",
		"monstrous basilisk",
		"malevolent mage",
		"insatiable bloodveld",
		"insatiable mutated bloodveld",
		"vitreous jelly",
		"vitreous warped jelly",
		"cave abomination",
		"abhorrent spectre",
		"repugnant spectre",
		"choke devil",
		"king kurask",
		"marble gargoyle",
		"nechryarch",
		"greater abyssal demon",
		"night beast",
		"nuclear smoke devil");

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private SpriteManager spriteManager;

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

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private final Set<NPC> highlightedTargets = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private TaskData currentTask = new TaskData(0, 0, 0, 0, 0, 0, null, null, true);

	@Getter(AccessLevel.PACKAGE)
	private int streak;

	@Getter(AccessLevel.PACKAGE)
	private int points;

	@Getter(AccessLevel.PACKAGE)
	private Task weaknessTask = null;

	private TaskCounter counter;
	private int cachedXp = -1;
	private int cachedPoints;
	private Instant infoTimer;
	private List<String> targetNames = new ArrayList<>();
	private final List<Integer> targetIds = new ArrayList<>();
	private boolean checkAsTokens = true;

	private final List<NPCPresence> lingeringPresences = new ArrayList<>();
	private SlayerXpDropLookup slayerXpDropLookup = null;

	private SlayerTaskPanel panel;
	private NavigationButton navButton;
	private long lastTickMillis = 0;
	private boolean loginTick = false;

	private void clearTrackedNPCs()
	{
		highlightedTargets.clear();
		lingeringPresences.clear();
	}

	private boolean showInfobox;
	@Getter(AccessLevel.PACKAGE)
	private boolean showItemOverlay;
	@Setter(AccessLevel.PACKAGE)
	private boolean showSuperiorNotification;
	private int statTimeout;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightTargets;
	@Getter(AccessLevel.PACKAGE)
	private RenderStyle renderStyle;
	@Getter(AccessLevel.PACKAGE)
	private Color getTargetColor;
	@Getter(AccessLevel.PACKAGE)
	private Color getSuperiorColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawNames;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawMinimapNames;
	@Getter(AccessLevel.PACKAGE)
	private boolean weaknessPrompt;
	@Setter(AccessLevel.PACKAGE)
	private boolean taskCommand;
	private String taskName;
	private String taskLocation;
	@Setter(AccessLevel.PACKAGE)
	private boolean pointsCommand;
	private int amount;
	private int initialAmount;
	private int lastCertainAmount;

	private boolean weaknessOverlayAttached;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		weaknessOverlayAttached = false;

		overlayManager.add(overlay);
		overlayManager.add(targetClickboxOverlay);
		overlayManager.add(targetMinimapOverlay);

		if (slayerXpDropLookup == null)
		{
			// create this in startup since it needs to pull files during creation
			slayerXpDropLookup = new SlayerXpDropLookup();
		}

		panel = new SlayerTaskPanel(this);

		spriteManager.getSpriteAsync(SpriteID.SKILL_SLAYER, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Slayer Tracker")
			.icon(icon)
			.priority(6)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			cachedXp = client.getSkillExperience(SLAYER);
		}

		chatCommandManager.registerCommandAsync(TASK_COMMAND_STRING, this::taskLookup, this::taskSubmit);

		chatCommandManager.registerCommandAsync(POINTS_COMMAND_STRING, this::pointsLookup); //here
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(targetClickboxOverlay);
		overlayManager.remove(targetWeaknessOverlay);
		overlayManager.remove(targetMinimapOverlay);
		removeCounter();
		clearTrackedNPCs();

		chatCommandManager.unregisterCommand(TASK_COMMAND_STRING);
		chatCommandManager.unregisterCommand(POINTS_COMMAND_STRING);
		clientToolbar.removeNavigation(navButton);

		cachedXp = -1;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDefinitionChanged.class, this, this::onNpcDefinitionChanged);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
	}

	@Provides
	SlayerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerConfig.class);
	}

	void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				cachedXp = -1;
				cachedPoints = 0;
				clearTrackedNPCs();
				break;
			case LOGIN_SCREEN:
				loginTick = true;
				currentTask.setPaused(true);
				break;
			case LOGGED_IN:
				if (loginTick && this.amount != -1 && !this.taskName.isEmpty() && currentTask.getTaskName() == null)
				{
					setTask(this.taskName, this.amount, this.initialAmount, true, this.taskLocation, this.lastCertainAmount, false);
				}
		}
	}

	private void save()
	{
		config.amount(currentTask.getAmount());
		this.amount = currentTask.getAmount();

		config.initialAmount(currentTask.getInitialAmount());
		this.initialAmount = currentTask.getInitialAmount();

		config.taskName(currentTask.getTaskName());
		this.taskName = currentTask.getTaskName();

		config.taskLocation(currentTask.getTaskLocation());
		this.taskLocation = currentTask.getTaskLocation();

		config.lastCertainAmount(currentTask.getLastCertainAmount());
		this.lastCertainAmount = currentTask.getLastCertainAmount();

		config.streak(streak);
	}

	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		if (isTarget(npc, targetNames))
		{
			highlightedTargets.add(npc);
		}
	}

	private void onNpcDefinitionChanged(NpcDefinitionChanged event)
	{
		NPC npc = event.getNpc();

		if (isTarget(npc, targetNames))
		{
			highlightedTargets.add(npc);
		}
	}

	private void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		boolean contained = highlightedTargets.remove(npc);
		if (contained)
		{
			NPCPresence lingeringPresence = NPCPresence.buildPresence(npc);
			lingeringPresences.add(lingeringPresence);
		}
	}

	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.getVar(Varbits.SLAYER_REWARD_POINTS) == cachedPoints)
		{
			return;
		}

		setPoints(client.getVar(Varbits.SLAYER_REWARD_POINTS));

		if (!this.showInfobox)
		{
			return;
		}

		addCounter();

		if (counter != null)
		{
			counter.setCount(currentTask.getAmount());
		}
	}

	private int estimateKillCount(List<NPCPresence> potentialKills, int gains)
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

		//StringBuilder debugString = new StringBuilder();
		//for (NPCPresence presence : potentialKills)
		//{
		//	debugString.append(presence.toString());
		//	debugString.append(", ");
		//}
		// log.debug("Estimating kc of xp drop " + gains + " for presences {" + debugString.toString() + "}");

		// first determine potential xp drops given by all npcs that died this tick by grabbing the slayer xp
		// info from the map made out of the data in slayer_xp.json
		List<Double> potentialXpDrops = new ArrayList<>();
		for (NPCPresence potentialDead : potentialKills)
		{
			double xp = slayerXpDropLookup.findXpForNpc(potentialDead);

			// DeadMan mode has an XP modifier
			if (client.getWorldType().contains(WorldType.DEADMAN))
			{
				xp = xp * DMM_MULTIPLIER_RATIO;
			}

			if (xp > 0)
			{
				potentialXpDrops.add(xp);
			}
		}

		//debugString = new StringBuilder();
		//for (Double drop : potentialXpDrops)
		//{
		//	debugString.append(drop);
		//	debugString.append(", ");
		//}
		// log.debug("Determined xp drop " + gains + " can be made of {" + debugString.toString() + "}");

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
			estimatedCount = potentialXpDrops.size();
		}
		if (estimatedCount < 1)
		{
			estimatedCount = 1;
		}
		return estimatedCount;
	}

	// b/c dialog can stay up on screen for multiple ticks in a row we want to make sure we only set a task once
	// for the dialog that appears so we need to basically do a rising edge detection that only allows for a dialog
	// check to be performed if in the previous ticks there was a period of no dialog
	// i.e. once a dialog has been matched dialog cannot be matched again until npc dialog goes away for a tick
	// this will work because in order for a new slayer task to happen the player either has to go complete the assignment
	// (and close npc dialog) or go into the rewards screen which also closes npc dialog
	private boolean canMatchDialog = true;

	// rising edge detection isn't enough for some reason (don't know why) so in addition to a rising edge rather than
	// instantly allowing for another assignment we'll do a 2 tick refractory period
	private static final int FORCED_WAIT = 2;
	private int forcedWait = -1;

	public void onGameTick(GameTick tick)
	{
		loginTick = false;

		// update the lingering presence of npcs in the slayer xp consideration list
		Iterator<NPCPresence> presenceIterator = lingeringPresences.iterator();
		while (presenceIterator.hasNext())
		{
			NPCPresence presence = presenceIterator.next();
			presence.tickExistence();
			if (!presence.shouldExist())
			{
				// log.debug("Lingering presence of " + presence.toString() + " expired");
				presenceIterator.remove();
			}
		}

		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog != null && canMatchDialog)
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
				setTask(name, amount, amount, true, location, 0);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
			else if (mAssignFirst.find())
			{
				int amount = Integer.parseInt(mAssignFirst.group(2));
				setTask(mAssignFirst.group(1), amount, amount, true, 0);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
			else if (mAssignBoss.find())
			{
				int amount = Integer.parseInt(mAssignBoss.group(2));
				setTask(mAssignBoss.group(1), amount, amount, true, 0);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
				points = Integer.parseInt(mAssignBoss.group(3).replaceAll(",", ""));
			}
			else if (mCurrent.find())
			{
				String name = mCurrent.group("name");
				int amount = Integer.parseInt(mCurrent.group("amount"));
				String location = mCurrent.group("location");
				setTask(name, amount, currentTask.getInitialAmount(), false, location, 0);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
		}
		else if (npcDialog == null)
		{
			if (forcedWait <= 0)
			{
				canMatchDialog = true;
			}
			forcedWait--;
		}

		if (infoTimer != null && config.statTimeout() != 0)
		{
			Duration timeSinceInfobox = Duration.between(infoTimer, Instant.now());
			Duration statTimeout = Duration.ofMinutes(this.statTimeout);

			if (timeSinceInfobox.compareTo(statTimeout) >= 0)
			{
				removeCounter();
			}
		}
	}

	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks

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
				case 3:
					streak = Integer.parseInt(matches.get(0));
					break;
				default:
					log.warn("Unreachable default case for message ending in '; return to Slayer master'");
			}

			log.debug("Slayer task completed with " + currentTask.getAmount() + " remaining");
			log.debug("Last certain amount was " + currentTask.getLastCertainAmount() +
				" so error rate is " + currentTask.getAmount() + " in " + currentTask.getLastCertainAmount());

			setTask("", 0, 0, true, 0);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			setTask("", 0, 0, true, 0);
			return;
		}

		if (this.showSuperiorNotification && chatMsg.equals(CHAT_SUPERIOR_MESSAGE))
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
			setTask(name, gemAmount, currentTask.getInitialAmount(), false, location, gemAmount);
			return;
		}

		final Matcher bracerProgress = COMBAT_BRACELET_TASK_UPDATE_MESSAGE.matcher(chatMsg);

		if (bracerProgress.find())
		{
			final int taskAmount = Integer.parseInt(bracerProgress.group(1));
			setTask(currentTask.getTaskName(), taskAmount, currentTask.getInitialAmount(), false, taskAmount);

			// Avoid race condition (combat brace message goes through first before XP drop)
			currentTask.setAmount(currentTask.getAmount() + 1);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER))
		{
			currentTask.setAmount(currentTask.getAmount() + 1);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			currentTask.setAmount(currentTask.getAmount() - 1);
		}
	}

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

		if (cachedXp == -1)
		{
			// this is the initial xp sent on login
			cachedXp = slayerExp;
			return;
		}

		final Task task = Task.getTask(taskName);
		int delta = slayerExp - cachedXp;

		// null tasks are technically valid, it only means they arent explicitly defined in the Task enum
		// allow them through so that if there is a task capture failure the counter will still work
		final int taskKillExp = task != null ? task.getExpectedKillExp() : 0;

		// Only count exp gain as a kill if the task either has no expected exp for a kill, or if the exp gain is equal
		// to the expected exp gain for the task.
		if (taskKillExp == 0 || taskKillExp == slayerExp - cachedXp)
		{
			killedOne(delta);
		}
		else
		{
			// this is not the initial xp sent on login so these are new xp gains
			int gains = slayerExp - cachedXp;

			// potential npcs to give xp drop are current highlighted npcs and the lingering presences
			List<NPCPresence> potentialNPCs = new ArrayList<>(lingeringPresences);
			for (NPC npc : highlightedTargets)
			{
				NPCPresence currentPresence = NPCPresence.buildPresence(npc);
				potentialNPCs.add(currentPresence);
			}

			int killCount = estimateKillCount(potentialNPCs, gains);
			for (int i = 0; i < killCount; i++)
			{
				killedOne(delta);
			}
		}

		cachedXp = slayerExp;
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}
		final Actor interacting = client.getLocalPlayer().getInteracting();
		weaknessTask = null;

		if (!(interacting instanceof NPC))
		{
			return;
		}

		final NPC npc = (NPC) interacting;

		for (Task task : weaknessTasks)
		{
			if (isTarget(npc, buildTargetNames(task)))
			{
				weaknessTask = task;
				return;
			}
		}
	}

	boolean isSuperior(String name)
	{
		return SUPERIOR_SLAYER_MONSTERS.contains(name.toLowerCase());
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("slayer"))
		{
			return;
		}

		updateConfig();

		if (event.getKey().equals("infobox"))
		{
			if (this.showInfobox)
			{
				clientThread.invoke(this::addCounter);
			}
			else
			{
				removeCounter();
			}
		}
	}

	@VisibleForTesting
	private void killedOne(int delta)
	{
		if (currentTask.getAmount() == 0)
		{
			return;
		}

		currentTask.setAmount(currentTask.getAmount() - 1);
		currentTask.setElapsedKills(currentTask.getElapsedKills() + 1);
		currentTask.setElapsedXp(currentTask.getElapsedXp() + delta);
		if (doubleTroubleExtraKill())
		{
			currentTask.setAmount(currentTask.getAmount() - 1);
			currentTask.setElapsedKills(currentTask.getElapsedKills() + 1);
		}

		config.amount(currentTask.getAmount()); // save changed value
		currentTask.setPaused(false); // no longer paused since xp is gained
		if (panel != null)
		{
			panel.updateCurrentTask(true, currentTask.isPaused(), currentTask, false);
		}

		if (!this.showInfobox)
		{
			return;
		}

		// add and update counter, set timer
		addCounter();
		counter.setCount(currentTask.getAmount());
		infoTimer = Instant.now();
	}

	private boolean doubleTroubleExtraKill()
	{
		return WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID() == GROTESQUE_GUARDIANS_REGION &&
			SlayerUnlock.GROTESQUE_GUARDIAN_DOUBLE_COUNT.isEnabled(client);
	}

	// checks if any contiguous subsequence of seq0 exactly matches the String toMatch
	private boolean contiguousSubsequenceMatches(String[] seq0, String toMatch)
	{
		for (int i = 0; i < seq0.length; i++)
		{
			for (int j = i; j < seq0.length; j++)
			{
				StringBuilder sub0Builder = new StringBuilder();
				for (int k = i; k <= j; k++)
				{
					sub0Builder.append(seq0[k]).append(" ");
				}
				String sub0 = sub0Builder.toString();
				sub0 = sub0.substring(0, sub0.length() - 1); // remove extra space
				if (sub0.equals(toMatch))
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValidComposition(NPCDefinition composition)
	{
		if (composition != null)
		{
			List<String> actions = Arrays.asList(composition.getActions());
			//Pick action is for zygomite-fungi
			return actions.contains("Attack") || actions.contains("Pick") || actions.contains("Poke");
		}

		return false;
	}

	private boolean isTarget(NPC npc, List<String> names)
	{
		if (names.isEmpty() && targetIds.isEmpty())
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

		for (String target : names)
		{
			if (!checkAsTokens)
			{
				if (name.contains(target) && isValidComposition(npc.getTransformedDefinition()))
				{
					return true;
				}
			}
			else
			{
				String[] nameTokens = name.split(" ");
				if (contiguousSubsequenceMatches(nameTokens, target) && isValidComposition(npc.getTransformedDefinition()))
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
			if (id == target && isValidComposition(npc.getTransformedDefinition()))
			{
				return true;
			}
		}

		return false;
	}

	private List<String> buildTargetNames(Task task)
	{
		List<String> names = new ArrayList<>();

		if (task != null)
		{
			task.getTargetNames().stream()
				.map(String::toLowerCase)
				.forEach(names::add);

			//TODO
			names.add(task.getName().toLowerCase().replaceAll("s$", ""));
		}

		return names;
	}

	private void rebuildTargetIds(Task task)
	{
		targetIds.clear();

		if (task != null)
		{
			targetIds.addAll(task.getNpcIds());
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
			if (isTarget(npc, targetNames))
			{
				highlightedTargets.add(npc);
			}
		}
	}

	public void setTask(String name, int amt, int initAmt, boolean isNewAssignment, int lastCertainAmt)
	{
		setTask(name, amt, initAmt, isNewAssignment, null, lastCertainAmt);
	}

	private void setTask(String name, int amt, int initAmt, boolean isNewAssignment, String location, int lastCertainAmt)
	{
		setTask(name, amt, initAmt, isNewAssignment, location, lastCertainAmt, true);
	}

	private void setTask(String name, int amt, int initAmt, boolean isNewAssignment, String location, int lastCertainAmt, boolean addCounter)
	{
		currentTask = new TaskData(isNewAssignment ? 0 : currentTask.getElapsedTime(),
			isNewAssignment ? 0 : currentTask.getElapsedKills(),
			isNewAssignment ? 0 : currentTask.getElapsedXp(),
			amt, initAmt, lastCertainAmt, location, name,
			isNewAssignment || currentTask.isPaused());
		if (panel != null)
		{
			panel.updateCurrentTask(true, currentTask.isPaused(), currentTask, isNewAssignment);
		}

		save();
		removeCounter();

		if (addCounter)
		{
			infoTimer = Instant.now();
			addCounter();
		}

		Task task = Task.getTask(name);
		targetNames.clear();
		targetNames = buildTargetNames(task);
		rebuildTargetIds(task);
		rebuildCheckAsTokens(task);
		rebuildTargetList();

		if (task == null)
		{
			return;
		}

		if (!weaknessOverlayAttached && task.getWeaknessItem() != -1 && task.getWeaknessThreshold() != -1)
		{
			overlayManager.add(targetWeaknessOverlay);
			weaknessOverlayAttached = true;
		}
		else if (weaknessOverlayAttached && task.getWeaknessItem() == -1 && task.getWeaknessThreshold() == -1)
		{
			overlayManager.remove(targetWeaknessOverlay);
			weaknessOverlayAttached = false;
		}
	}

	AsyncBufferedImage getImageForTask(Task task)
	{
		int itemSpriteId = ItemID.ENCHANTED_GEM;
		if (task != null)
		{
			itemSpriteId = task.getItemSpriteId();
		}
		return itemManager.getImage(itemSpriteId);
	}

	private void addCounter()
	{
		if (!this.showInfobox || counter != null || currentTask == null || Strings.isNullOrEmpty(currentTask.getTaskName()))
		{
			return;
		}

		Task task = Task.getTask(currentTask.getTaskName());
		AsyncBufferedImage taskImg = getImageForTask(task);
		String taskTooltip = ColorUtil.wrapWithColorTag("%s", new Color(255, 119, 0)) + "</br>";

		if (currentTask.getTaskLocation() != null && !currentTask.getTaskLocation().isEmpty())
		{
			taskTooltip += currentTask.getTaskLocation() + "</br>";
		}

		taskTooltip += ColorUtil.wrapWithColorTag("Pts:", Color.YELLOW)
			+ " %s</br>"
			+ ColorUtil.wrapWithColorTag("Streak:", Color.YELLOW)
			+ " %s";

		if (currentTask.getInitialAmount() > 0)
		{
			taskTooltip += "</br>"
				+ ColorUtil.wrapWithColorTag("Start:", Color.YELLOW)
				+ " " + currentTask.getInitialAmount();
		}

		counter = new TaskCounter(taskImg, this, currentTask.getAmount());
		counter.setTooltip(String.format(taskTooltip, capsString(currentTask.getTaskName()), points, streak));

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
		if (!this.taskCommand)
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

		if (task == null)
		{
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

	private void pointsLookup(ChatMessage chatMessage, String message)
	{
		if (!this.pointsCommand)
		{
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Slayer Points: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(getPoints()))
			.build();

		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	/* package access method for changing the pause state of the time tracker for the current task */
	void setPaused(boolean paused)
	{
		currentTask.setPaused(paused);
		panel.updateCurrentTask(false, currentTask.isPaused(), currentTask, false);
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void tickTaskTimes()
	{
		if (lastTickMillis == 0)
		{
			lastTickMillis = System.currentTimeMillis();
			return;
		}

		final long nowMillis = System.currentTimeMillis();
		final long tickDelta = nowMillis - lastTickMillis;
		lastTickMillis = nowMillis;


		if (currentTask == null)
		{
			return;
		}
		currentTask.tick(tickDelta);

		panel.updateCurrentTask(false, currentTask.isPaused(), currentTask, false);
	}

	private boolean taskSubmit(ChatInput chatInput, String value)
	{
		if (Strings.isNullOrEmpty(currentTask.getTaskName()))
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitTask(playerName, capsString(currentTask.getTaskName()), currentTask.getAmount(), currentTask.getInitialAmount(), currentTask.getTaskLocation());
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
	private static String capsString(String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private void setPoints(int points)
	{
		this.points = points;
		this.cachedPoints = points;
	}

	private void updateConfig()
	{
		this.showInfobox = config.showInfobox();
		this.showItemOverlay = config.showItemOverlay();
		this.showSuperiorNotification = config.showSuperiorNotification();
		this.statTimeout = config.statTimeout();
		this.highlightTargets = config.highlightTargets();
		this.renderStyle = config.renderStyle();
		this.getTargetColor = config.getTargetColor();
		this.getSuperiorColor = config.getSuperiorColor();
		this.drawNames = config.drawNames();
		this.drawMinimapNames = config.drawMinimapNames();
		this.weaknessPrompt = config.weaknessPrompt();
		this.taskCommand = config.taskCommand();
		this.pointsCommand = config.pointsCommand();
		this.taskName = config.taskName();
		this.amount = config.amount();
		this.initialAmount = config.initialAmount();
		this.lastCertainAmount = config.lastCertainAmount();
		this.taskLocation = config.taskLocation();
	}
}
