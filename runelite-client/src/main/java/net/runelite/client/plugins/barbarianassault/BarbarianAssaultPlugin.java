/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.*;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import lombok.extern.slf4j.Slf4j;

@Slf4j


@PluginDescriptor(
		name = "Barbarian Assault",
		description = "Show a timer to the next call change and game/wave duration in chat.",
		tags = {"minigame", "overlay", "timer"}
)
public class BarbarianAssaultPlugin extends Plugin
{
	private static final int BA_WAVE_NUM_INDEX = 2;
	private static final String START_WAVE = "1";
	private static final String ENDGAME_REWARD_NEEDLE_TEXT = "<br>5";

	@Getter
	private int collectedEggCount = 0;
	@Getter
	private int positiveEggCount = 0;
	@Getter
	private int wrongEggs = 0;
	@Getter
	private int HpHealed = 0;
	@Getter
	private int totalCollectedEggCount = 0;
	@Getter
	private int totalHpHealed = 0;

	private boolean hasAnnounced;

	private int[] amountsList;
	private int[] pointsList;
	private List<Integer> pointsGainedOrLost = new ArrayList<>();

	private String[] descriptions = {"Runners: ",
			"Hitpoints: ",
			"Wrong heal packs: ",
			"Eggs: ",
			"Failed attacks: ",
			"Honour Points: "};

	private String[] totalDescriptions = {"Total Runners: ",
            "; Total Hp Replenished: ",
            "; Total Wrong Heal Packs: ",
            "; Total Eggs: ",
            "; Total Failed attacks: ",
            "; Total Honour Points: "};
	private Font font;
	private Image clockImage;
	private int inGameBit = 0;
	private String currentWave = START_WAVE;
	private GameTimer gameTime;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<WorldPoint, Integer> redEggs;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<WorldPoint, Integer> greenEggs;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<WorldPoint, Integer> blueEggs;

	@Getter(AccessLevel.PACKAGE)
	private HashMap<WorldPoint, Integer> yellowEggs;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarbarianAssaultConfig config;

	@Inject
	private BarbarianAssaultOverlay overlay;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}
	private static final ImmutableList<WidgetInfo> WIDGETS = ImmutableList.of(
			WidgetInfo.BA_RUNNERS_PASSED,
			WidgetInfo.BA_HITPOINTS_REPLENISHED,
			WidgetInfo.BA_WRONG_POISON_PACKS,
			WidgetInfo.BA_EGGS_COLLECTED,
			WidgetInfo.BA_FAILED_ATTACKER_ATTACKS,
			WidgetInfo.BA_HONOUR_POINTS_REWARD
	);
	private static final ImmutableList<WidgetInfo> POINTSWIDGETS = ImmutableList.of(
			WidgetInfo.BA_RUNNERS_PASSED_POINTS,
			WidgetInfo.BA_HITPOINTS_REPLENISHED_POINTS,
			WidgetInfo.BA_WRONG_POISON_PACKS_POINTS,
			WidgetInfo.BA_EGGS_COLLECTED_POINTS,
			WidgetInfo.BA_FAILED_ATTACKER_ATTACKS_POINTS,
			WidgetInfo.BA_HONOUR_POINTS_REWARD
	);
	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		font = FontManager.getRunescapeFont()
				.deriveFont(Font.BOLD, 24);

		clockImage = ImageUtil.getResourceStreamFromClass(getClass(), "clock.png");

		redEggs = new HashMap<>();
		greenEggs = new HashMap<>();
		blueEggs = new HashMap<>();
		yellowEggs = new HashMap<>();
		amountsList = new int[6];
		pointsList = new int[7];
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		gameTime = null;
		currentWave = START_WAVE;
		inGameBit = 0;
		collectedEggCount = 0;
		positiveEggCount = 0;
		wrongEggs = 0;
		HpHealed = 0;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BA_REWARD_GROUP_ID)
		{
			Widget rewardWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
			if (rewardWidget != null && rewardWidget.getText().contains(ENDGAME_REWARD_NEEDLE_TEXT) && gameTime != null)
			{
				if (config.waveTimes())
					announceTime("Game finished, duration: ", gameTime.getTime(false));
				if (config.showTotalRewards())
				{
					String operator = "";
					if (pointsList[6] > 0)
						operator = "+";
					if (pointsList[6] == 0)
						operator = "\u00B1";
					for (int i = 0; i < amountsList.length-1; i++)
					{
					    announceSomething(totalDescriptions[i] + amountsList[i] + "(" + pointsList[i] + ")");
                    }
					announceSomething("; Total Honour Points: " + (80 + amountsList[5]) + "(" + operator + pointsList[6] + ")");
				}
			}
			Widget pointsWidget = client.getWidget(WidgetInfo.BA_RUNNERS_PASSED);
			if (!rewardWidget.getText().contains(ENDGAME_REWARD_NEEDLE_TEXT) && pointsWidget != null
					&& config.showSummaryOfPoints() && !hasAnnounced && client.getVar(Varbits.IN_GAME_BA) == 0)
			{
				announceSomething("Wave Points Summary: " + giveSummaryOfPoints());
				hasAnnounced = true;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (!chatMessage.getType().equals(ChatMessageType.GAMEMESSAGE))
		{
			return;
		}
		int inGame = client.getVar(Varbits.IN_GAME_BA);
		if (inGameBit != inGame)
			return;
		final String message = chatMessage.getMessage().toLowerCase();
		final MessageNode messageNode = chatMessage.getMessageNode();
		final String nodeValue = Text.removeTags(messageNode.getValue());
		String recolored = null;
		if (chatMessage.getMessage().startsWith("---- Wave:"))
		{
			String[] tempMessage = chatMessage.getMessage().split(" ");
			currentWave = tempMessage[BA_WAVE_NUM_INDEX];
			collectedEggCount = 0;
			HpHealed = 0;
			positiveEggCount = 0;
			wrongEggs = 0;
			if (currentWave.equals(START_WAVE))
			{
				gameTime = new GameTimer();
				totalHpHealed = 0;
				totalCollectedEggCount = 0;
				amountsList = new int[]{0,0,0,0,0,0};
				pointsList = new int[]{0,0,0,0,0,0,0};
				pointsGainedOrLost = new ArrayList<>();
			}
			else if (gameTime != null)
			{
				gameTime.setWaveStartTime();
			}
		}
		if (chatMessage.getMessage().contains("exploded"))
		{
			wrongEggs++;
			positiveEggCount--;
		}
		if (chatMessage.getMessage().contains("You healed"))
		{
			String[] tokens = message.split(" ");
			if (Integer.parseInt(tokens[2]) > 0)
			{
				int Hp = Integer.parseInt(tokens[2]);
				HpHealed += Hp;
			}
		}

		if (message.contains("the wrong type of poisoned food to use"))
		{
			recolored = ColorUtil.wrapWithColorTag(nodeValue, config.wrongPoisonFoodTextColor());
		}
		if (recolored != null)
		{
			messageNode.setValue(recolored);
			chatMessageManager.update(messageNode);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getVar(Varbits.IN_GAME_BA) == 0 || client.getLocalPlayer() == null || overlay.getCurrentRound() != null)
		{
			return;
		}
		switch (client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE))
		{
			case ItemID.ATTACKER_ICON:
				overlay.setCurrentRound(new Round(Role.ATTACKER));
				break;
			case ItemID.COLLECTOR_ICON:
				overlay.setCurrentRound(new Round(Role.COLLECTOR));
				break;
			case ItemID.DEFENDER_ICON:
				overlay.setCurrentRound(new Round(Role.DEFENDER));
				break;
			case ItemID.HEALER_ICON:
				overlay.setCurrentRound(new Round(Role.HEALER));
				break;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int inGame = client.getVar(Varbits.IN_GAME_BA);

		if (inGameBit != inGame)
		{
			if (inGameBit == 1)
			{
				overlay.setCurrentRound(null);

				if (config.waveTimes() && gameTime != null)
				{
					announceTime("Wave " + currentWave + " duration: ", gameTime.getTime(true));
				}
			}
			else
			{
				hasAnnounced = false;
			}
		}

		inGameBit = inGame;
	}
	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		int itemId = itemSpawned.getItem().getId();
		WorldPoint worldPoint = itemSpawned.getTile().getWorldLocation();
		HashMap<WorldPoint, Integer> eggMap = getEggMap(itemId);
		if (eggMap !=  null)
		{
			Integer existingQuantity = eggMap.putIfAbsent(worldPoint, 1);
			if (existingQuantity != null)
			{
				eggMap.put(worldPoint, existingQuantity + 1);
			}
		}
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		int itemId = itemDespawned.getItem().getId();
		WorldPoint worldPoint = itemDespawned.getTile().getWorldLocation();
		HashMap<WorldPoint, Integer> eggMap = getEggMap(itemId);

		if (eggMap != null && eggMap.containsKey(worldPoint))
		{
			int quantity = eggMap.get(worldPoint);
			if (quantity > 1)
			{
				eggMap.put(worldPoint, quantity - 1);
			}
			else
			{
				eggMap.remove(worldPoint);
			}
		}
		if (client.getVar(Varbits.IN_GAME_BA) == 0 || !isEgg(itemDespawned.getItem().getId()))
		{
			return;
		}
		if (isUnderPlayer(itemDespawned.getTile()))
		{
			if (client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE) == ItemID.COLLECTOR_ICON)
			{
				positiveEggCount++;
				if (positiveEggCount > 60)
				{
					positiveEggCount = 60;
				}
				collectedEggCount = positiveEggCount - wrongEggs; //true positive - negative egg count
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!config.highlightCollectorEggs())
		{
			return;
		}
		if (overlay.getCurrentRound() == null)
		{
			return;
		}
		if (overlay.getCurrentRound().getRoundRole() != Role.COLLECTOR)
		{
			return;
		}

		String calledEgg = getCollectorHeardCall();
		String target = event.getTarget();
		String option = event.getOption();
		String targetClean = target.substring(target.indexOf('>') + 1);
		String optionClean = option.substring(option.indexOf('>') + 1);

		if ("Take".equals(optionClean))
		{
			Color highlightColor = null;

			if (calledEgg != null && calledEgg.startsWith(targetClean))
			{
				highlightColor = getEggColor(targetClean);
			}
			else if ("Yellow egg".equals(targetClean))
			{
				// Always show yellow egg
				highlightColor = Color.YELLOW;
			}

			if (highlightColor != null)
			{
				MenuEntry[] menuEntries = client.getMenuEntries();
				MenuEntry last = menuEntries[menuEntries.length - 1];
				last.setTarget(ColorUtil.prependColorTag(targetClean, highlightColor));
				client.setMenuEntries(menuEntries);
			}
		}
	}

	private void announceSomething(String something)
	{
		final String chatMessage = new ChatMessageBuilder()
				.append(something)
				.build();
		chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(chatMessage)
				.build());
	}

	private String giveSummaryOfPoints()
	{
		StringBuilder message = new StringBuilder();
		pointsList[5] = 0;
		for (int i = 0; i < WIDGETS.size(); i++)
		{
			Widget w = client.getWidget(WIDGETS.get(i));
			Widget w2 = client.getWidget(POINTSWIDGETS.get(i));
			message.append(descriptions[i]);
			if (w != null && !w.getText().equals("")) {
					amountsList[i] += Integer.parseInt(w.getText());
					message.append(Integer.parseInt(w.getText()));
			} else {
					log.info("widget1 null");
			}
			if (i != 5) {
				if (w2 != null && !w2.getText().equals("")) {
					pointsList[i] += Integer.parseInt(w2.getText());
					pointsList[5] += Integer.parseInt(w2.getText());
					message.append("(" + Integer.parseInt(w2.getText()) + ")");
					message.append("; ");
				} else {
					log.info("widget2 null");
				}
			}
			else
			{
				pointsList[6] += pointsList[5];
				message.append("(" + pointsList[5] + ")");
			}
		}
		return message.toString();
	}

	String getCollectorHeardCall()
	{
		Widget widget = client.getWidget(WidgetInfo.BA_COLL_LISTEN_TEXT);
		String call = null;

		if (widget != null)
		{
			call = widget.getText();
		}

		return call;
	}

	Map<WorldPoint, Integer> getCalledEggMap()
	{
		Map<WorldPoint, Integer> map;
		String calledEgg = getCollectorHeardCall();

		if (calledEgg == null)
		{
			return null;
		}

		switch (calledEgg)
		{
			case "Red eggs":
				map = redEggs;
				break;
			case "Green eggs":
				map = greenEggs;
				break;
			case "Blue eggs":
				map = blueEggs;
				break;
			default:
				map = null;
		}

		return map;
	}

	static Color getEggColor(String str)
	{
		Color color;

		if (str == null)
		{
			return null;
		}

		if (str.startsWith("Red"))
		{
			color = Color.RED;
		}
		else if (str.startsWith("Green"))
		{
			color = Color.GREEN;
		}
		else if (str.startsWith("Blue"))
		{
			color = Color.CYAN;
		}
		else if (str.startsWith("Yellow"))
		{
			color = Color.YELLOW;
		}
		else
		{
			color = null;
		}

		return color;
	}

	private HashMap<WorldPoint, Integer> getEggMap(int itemID)
	{
		switch (itemID)
		{
			case ItemID.RED_EGG:
				return redEggs;
			case ItemID.GREEN_EGG:
				return greenEggs;
			case ItemID.BLUE_EGG:
				return blueEggs;
			case ItemID.YELLOW_EGG:
				return yellowEggs;
			default:
				return null;
		}
	}


	private void announceTime(String preText, String time)
	{
		final String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(preText)
				.append(ChatColorType.HIGHLIGHT)
				.append(time)
				.build();

		chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(chatMessage)
				.build());
	}

	private boolean isEgg(int itemID)
	{
		if (itemID == ItemID.RED_EGG || itemID == ItemID.GREEN_EGG
				|| itemID == ItemID.BLUE_EGG || itemID == ItemID.YELLOW_EGG)
		{
			return true;
		}
		return false;
	}

	private boolean isUnderPlayer(Tile tile)
	{
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return false;
		}

		return (tile.getWorldLocation().equals(local.getWorldLocation()));
	}

	public Font getFont()
	{
		return font;
	}

	public Image getClockImage()
	{
		return clockImage;
	}

	public int getListenItemId(WidgetInfo listenInfo)
	{
		Widget listenWidget = client.getWidget(listenInfo);

		if (listenWidget != null)
		{
			switch (listenWidget.getText())
			{
				case "Tofu":
					return ItemID.TOFU;
				case "Crackers":
					return ItemID.CRACKERS;
				case "Worms":
					return ItemID.WORMS;
				case "Pois. Worms":
					return ItemID.POISONED_WORMS;
				case "Pois. Tofu":
					return ItemID.POISONED_TOFU;
				case "Pois. Meat":
					return ItemID.POISONED_MEAT;
			}
		}

		return -1;
	}
}