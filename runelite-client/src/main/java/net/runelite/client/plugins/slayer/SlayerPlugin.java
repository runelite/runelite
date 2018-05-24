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

import com.google.common.collect.ImmutableList;
import static com.google.common.collect.ObjectArrays.concat;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Query;
import static net.runelite.api.Skill.SLAYER;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.EquipmentItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QueryRunner;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Slayer"
)
@Slf4j
public class SlayerPlugin extends Plugin
{
	//Chat messages
	private static final Pattern CHAT_GEM_PROGRESS_MESSAGE = Pattern.compile("You're assigned to kill (.*); only (\\d*) more to go\\.");
	private static final String CHAT_GEM_COMPLETE_MESSAGE = "You need something new to hunt.";
	private static final Pattern CHAT_COMPLETE_MESSAGE = Pattern.compile("[\\d]+(?:,[\\d]+)?");
	private static final String CHAT_CANCEL_MESSAGE = "Your task has been cancelled.";
	private static final String CHAT_CANCEL_MESSAGE_JAD = "You no longer have a slayer task as you left the fight cave.";
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final String CHAT_BRACELET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer";
	private static final String CHAT_BRACELET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your";
	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE = "Your bracelet of slaughter has ";
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE = "Your expeditious bracelet has ";

	//NPC messages
	private static final Pattern NPC_ASSIGN_MESSAGE = Pattern.compile(".*Your new task is to kill (\\d*) (.*)\\.");
	private static final Pattern NPC_CURRENT_MESSAGE = Pattern.compile("You're still hunting (.*), you have (\\d*) to go\\..*");

	//Reward UI
	private static final Pattern REWARD_POINTS = Pattern.compile("Reward points: (\\d*)");

	private static final int EXPEDITIOUS_CHARGE = 30;
	private static final int SLAUGHTER_CHARGE = 30;

	@Inject
	private Client client;

	@Inject
	private SlayerConfig config;

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
	private QueryRunner queryRunner;

	@Inject
	private TargetClickboxOverlay targetClickboxOverlay;

	@Inject
	private TargetMinimapOverlay targetMinimapOverlay;

	@Getter(AccessLevel.PACKAGE)
	private List<NPC> highlightedTargets = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private Collection<WidgetItem> slayerItems = Collections.emptyList();

	private String taskName;
	private int amount;
	private TaskCounter counter;
	private int streak;
	private int points;
	private int cachedXp;
	private Instant infoTimer;
	private boolean loginFlag;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int expeditiousChargeCount;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int slaughterChargeCount;

	@Override
	protected void startUp() throws Exception
	{
		if (client.getGameState() == GameState.LOGGED_IN
			&& config.amount() != -1
			&& !config.taskName().isEmpty())
		{
			setPoints(config.points());
			setStreak(config.streak());
			setExpeditiousChargeCount(config.expeditious());
			setSlaughterChargeCount(config.slaughter());
			clientThread.invokeLater(() -> setTask(config.taskName(), config.amount()));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeCounter();
	}

	@Provides
	SlayerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerConfig.class);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				cachedXp = 0;
				taskName = "";
				amount = 0;
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (config.amount() != -1
					&& !config.taskName().isEmpty()
					&& loginFlag == true)
				{
					setPoints(config.points());
					setStreak(config.streak());
					setExpeditiousChargeCount(config.expeditious());
					setSlaughterChargeCount(config.slaughter());
					setTask(config.taskName(), config.amount());
					loginFlag = false;
				}
				break;
		}
	}

	private void save()
	{
		config.amount(amount);
		config.taskName(taskName);
		config.points(points);
		config.streak(streak);
		config.expeditious(expeditiousChargeCount);
		config.slaughter(slaughterChargeCount);
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		checkInventories();

		Widget NPCDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (NPCDialog != null)
		{
			String NPCText = Text.removeTags(NPCDialog.getText()); //remove color and linebreaks
			Matcher mAssign = NPC_ASSIGN_MESSAGE.matcher(NPCText); //number, name
			Matcher mCurrent = NPC_CURRENT_MESSAGE.matcher(NPCText); //name, number
			boolean found1 = mAssign.find();
			boolean found2 = mCurrent.find();
			if (!found1 && !found2)
			{
				return;
			}

			String taskName = found1 ? mAssign.group(2) : mCurrent.group(1);
			int amount = Integer.parseInt(found1 ? mAssign.group(1) : mCurrent.group(2));

			setTask(taskName, amount);
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
					points = Integer.parseInt(mPoints.group(1));
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

		if (config.highlightTargets())
		{
			highlightedTargets = buildTargetsToHighlight();
		}
		else
		{
			highlightedTargets.clear();
		}
	}

	private void checkInventories()
	{
		Query inventoryQuery = new InventoryWidgetItemQuery();
		WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);

		Query equipmentQuery = new EquipmentItemQuery().slotEquals(WidgetInfo.EQUIPMENT_HELMET, WidgetInfo.EQUIPMENT_RING, WidgetInfo.EQUIPMENT_GLOVES);
		WidgetItem[] equipmentWidgetItems = queryRunner.runQuery(equipmentQuery);

		WidgetItem[] items = concat(inventoryWidgetItems, equipmentWidgetItems, WidgetItem.class);
		slayerItems = ImmutableList.copyOf(items);
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
			amount++;
			slaughterChargeCount = --slaughterChargeCount <= 0 ? SLAUGHTER_CHARGE : slaughterChargeCount;
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS))
		{
			amount--;
			expeditiousChargeCount = --expeditiousChargeCount <= 0 ? EXPEDITIOUS_CHARGE : expeditiousChargeCount;
			config.expeditious(expeditiousChargeCount);
		}

		if (chatMsg.startsWith(CHAT_BRACELET_EXPEDITIOUS_CHARGE))
		{
			expeditiousChargeCount = Integer.parseInt(chatMsg
				.replace(CHAT_BRACELET_EXPEDITIOUS_CHARGE, "")
				.replace(" charges left.", ""));
			config.expeditious(expeditiousChargeCount);
		}
		if (chatMsg.startsWith(CHAT_BRACELET_SLAUGHTER_CHARGE))
		{
			slaughterChargeCount = Integer.parseInt(chatMsg
				.replace(CHAT_BRACELET_SLAUGHTER_CHARGE, "")
				.replace(" charges left.", ""));
			config.slaughter(slaughterChargeCount);
		}

		if (chatMsg.endsWith("; return to a Slayer master."))
		{
			Matcher mComplete = CHAT_COMPLETE_MESSAGE.matcher(chatMsg);

			List<String> matches = new ArrayList<>();
			while (mComplete.find())
			{
				matches.add(mComplete.group(0));
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
					points = Integer.parseInt(matches.get(2).replaceAll(",", ""));
					break;
				default:
					log.warn("Unreachable default case for message ending in '; return to Slayer master'");
			}
			setTask("", 0);
			return;
		}

		if (chatMsg.equals(CHAT_GEM_COMPLETE_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE) || chatMsg.equals(CHAT_CANCEL_MESSAGE_JAD))
		{
			setTask("", 0);
			return;
		}

		if (config.showSuperiorNotification() && chatMsg.equals(CHAT_SUPERIOR_MESSAGE))
		{
			notifier.notify(CHAT_SUPERIOR_MESSAGE);
			return;
		}

		Matcher mProgress = CHAT_GEM_PROGRESS_MESSAGE.matcher(chatMsg);
		if (!mProgress.find())
		{
			return;
		}
		String taskName = mProgress.group(1);
		int amount = Integer.parseInt(mProgress.group(2));

		setTask(taskName, amount);
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
			clientThread.invokeLater(this::addCounter);
		}
		else
		{
			removeCounter();
		}
	}

	private void killedOne()
	{
		if (amount == 0)
		{
			return;
		}

		amount--;
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

	private void setTask(String name, int amt)
	{
		taskName = name.toLowerCase();
		amount = amt;
		save();
		removeCounter();
		addCounter();
		infoTimer = Instant.now();
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
		counter = new TaskCounter(taskImg, this, amount);
		counter.setTooltip(String.format("<col=ff7700>%s</br><col=ffff00>Pts:</col> %s</br><col=ffff00>Streak:</col> %s",
			capsString(taskName), points, streak));

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

	private List<NPC> buildTargetsToHighlight()
	{
		if (Strings.isNullOrEmpty(taskName))
			return Collections.EMPTY_LIST;

		List<NPC> npcs = new ArrayList<>();
		List<String> highlightedNpcs = new ArrayList<>(Arrays.asList(Task.getTask(taskName).getTargetNames()));
		highlightedNpcs.add(taskName.replaceAll("s$", ""));

		for (NPC npc : client.getNpcs())
		{
			NPCComposition composition = getComposition(npc);

			if (composition == null || composition.getName() == null)
				continue;

			String name = npc.getName();
			for (String highlight : highlightedNpcs)
			{
				if (name.toLowerCase().contains(highlight.toLowerCase())
					&& Arrays.asList(composition.getActions()).contains("Attack"))
				{
					npcs.add(npc);
					break;
				}
			}
		}

		return npcs;
	}

	/**
	 * Get npc composition, account for imposters
	 *
	 * @param npc
	 * @return
	 */
	private static NPCComposition getComposition(NPC npc)
	{
		if (npc == null)
			return null;

		NPCComposition composition = npc.getComposition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}

		return composition;
	}

	//Getters
	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, targetClickboxOverlay, targetMinimapOverlay);
	}

	public String getTaskName()
	{
		return taskName;
	}

	void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}

	public int getAmount()
	{
		return amount;
	}

	void setAmount(int amount)
	{
		this.amount = amount;
	}

	public int getStreak()
	{
		return streak;
	}

	void setStreak(int streak)
	{
		this.streak = streak;
	}

	public int getPoints()
	{
		return points;
	}

	void setPoints(int points)
	{
		this.points = points;
	}

	//Utils
	private String capsString(String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
