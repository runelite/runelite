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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import static net.runelite.api.Skill.SLAYER;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
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
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
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
	private List<NPC> highlightedTargets = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private TaskData currentTask = new TaskData(0, 0, 0, 0, 0, null, null, true);

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int expeditiousChargeCount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int slaughterChargeCount;

	@Getter(AccessLevel.PACKAGE)
	private int streak;

	@Getter(AccessLevel.PACKAGE)
	private int points;

	private TaskCounter counter;
	private int cachedXp;
	private Instant infoTimer;
	private boolean loginFlag;
	private List<String> targetNames = new ArrayList<>();

	private SlayerTaskPanel panel = new SlayerTaskPanel(this);
	private NavigationButton navButton;
	private long lastTickMillis = 0;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(targetClickboxOverlay);
		overlayManager.add(targetWeaknessOverlay);
		overlayManager.add(targetMinimapOverlay);

		spriteManager.getSpriteAsync(SpriteID.SKILL_SLAYER, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
				.tooltip("Slayer Tracker")
				.icon(icon)
				.priority(6)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);

		if (config.amount() != -1
			&& !config.taskName().isEmpty())
		{
			points = config.points();
			streak = config.streak();
			setExpeditiousChargeCount(config.expeditious());
			setSlaughterChargeCount(config.slaughter());
			clientThread.invoke(() -> setTask(config.taskName(), config.amount(), config.initialAmount(), true, config.taskLocation()));
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

		chatCommandManager.unregisterCommand(TASK_COMMAND_STRING);
		clientToolbar.removeNavigation(navButton);
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
				highlightedTargets.clear();
				break;
		}
	}

	private void save()
	{
		config.amount(currentTask.getAmount());
		config.initialAmount(currentTask.getInitialAmount());
		config.taskName(currentTask.getTaskName());
		config.taskLocation(currentTask.getTaskLocation());
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
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		highlightedTargets.remove(npc);
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

	@Subscribe
	public void onGameTick(GameTick tick)
	{
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
				setTask(name, amount, amount, true, location);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
			else if (mAssignFirst.find())
			{
				int amount = Integer.parseInt(mAssignFirst.group(2));
				setTask(mAssignFirst.group(1), amount, amount, true);
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
			else if (mAssignBoss.find())
			{
				int amount = Integer.parseInt(mAssignBoss.group(2));
				setTask(mAssignBoss.group(1), amount, amount, true);
				points = Integer.parseInt(mAssignBoss.group(3).replaceAll(",", ""));
				canMatchDialog = false;
				forcedWait = FORCED_WAIT;
			}
			else if (mCurrent.find())
			{
				String name = mCurrent.group("name");
				int amount = Integer.parseInt(mCurrent.group("amount"));
				String location = mCurrent.group("location");
				setTask(name, amount, currentTask.getInitialAmount(), false, location);
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
					final int prevPoints = points;
					points = Integer.parseInt(mPoints.group(1).replaceAll(",", ""));

					if (prevPoints != points)
					{
						removeCounter();
						addCounter();
					}

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

			currentTask.setAmount(currentTask.getAmount() + 1);
			slaughterChargeCount = mSlaughter.find() ? Integer.parseInt(mSlaughter.group(1)) : SLAUGHTER_CHARGE;
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			Matcher mExpeditious = CHAT_BRACELET_EXPEDITIOUS_REGEX.matcher(chatMsg);

			currentTask.setAmount(currentTask.getAmount() - 1);
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
			setTask("", 0, 0, true);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			setTask("", 0, 0, true);
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
			setTask(name, gemAmount, currentTask.getInitialAmount(), false, location);
			return;
		}

		final Matcher bracerProgress = COMBAT_BRACELET_TASK_UPDATE_MESSAGE.matcher(chatMsg);

		if (bracerProgress.find())
		{
			final int taskAmount = Integer.parseInt(bracerProgress.group(1));
			setTask(currentTask.getTaskName(), taskAmount, currentTask.getInitialAmount(), false);

			// Avoid race condition (combat brace message goes through first before XP drop)
			currentTask.setAmount(currentTask.getAmount() + 1);
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

		if (cachedXp == 0)
		{
			// this is the initial xp sent on login
			cachedXp = slayerExp;
			return;
		}

		int delta = slayerExp - cachedXp;
		currentTask.setElapsedXp(currentTask.getElapsedXp() + delta);
		killedOne();
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
		if (currentTask.getAmount() == 0)
		{
			return;
		}

		currentTask.setAmount(currentTask.getAmount() - 1);
		currentTask.setElapsedKills(currentTask.getElapsedKills() + 1);
		if (doubleTroubleExtraKill())
		{
			currentTask.setAmount(currentTask.getAmount() - 1);
			currentTask.setElapsedKills(currentTask.getElapsedKills() + 1);
		}

		config.amount(currentTask.getAmount()); // save changed value
		currentTask.setPaused(false); // no longer paused since xp is gained
		panel.updateCurrentTask(true, currentTask.isPaused(), currentTask, false);

		if (!config.showInfobox())
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
				SlayerUnlock.GROTESQUE_GARDIAN_DOUBLE_COUNT.isEnabled(client);
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

			targetNames.add(currentTask.getTaskName().toLowerCase().replaceAll("s$", ""));
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

	private void setTask(String name, int amt, int initAmt, boolean isNewAssignment)
	{
		setTask(name, amt, initAmt, isNewAssignment, null);
	}

	private void setTask(String name, int amt, int initAmt, boolean isNewAssignment, String location)
	{
		currentTask = new TaskData(isNewAssignment ? 0 : currentTask.getElapsedTime(),
				isNewAssignment ? 0 : currentTask.getElapsedKills(),
				isNewAssignment ? 0 : currentTask.getElapsedXp(),
				amt, initAmt, location, name,
				isNewAssignment ? true : currentTask.isPaused());
		panel.updateCurrentTask(true, currentTask.isPaused(), currentTask, isNewAssignment);
		save();
		removeCounter();
		addCounter();
		infoTimer = Instant.now();

		Task task = Task.getTask(name);
		rebuildTargetNames(task);
		rebuildTargetList();
	}

	public AsyncBufferedImage getImageForTask(Task task)
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
		if (!config.showInfobox() || counter != null || Strings.isNullOrEmpty(currentTask.getTaskName()))
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
		if (!config.taskCommand())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
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

		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
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
				chatClient.submitTask(playerName, capsString(currentTask.getTaskName()), currentTask.getAmount(),
					currentTask.getInitialAmount(), currentTask.getTaskLocation());
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

	//Utils
	private String capsString(String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
