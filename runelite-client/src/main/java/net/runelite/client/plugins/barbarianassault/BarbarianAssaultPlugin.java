/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.AttackStyleWidget;
import net.runelite.client.plugins.attackstyles.WeaponType;
import net.runelite.client.plugins.grounditems.config.BarbarianAssaultGroundEggsMode;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Barbarian Assault",
	description = "Includes many features to enhance the barbarian assault minigame gameplay experience",
	tags = {"overlay", "b.a.", "barbarian assault", "minigame", "attacker", "defender", "collector", "healer"}
)
public class BarbarianAssaultPlugin extends Plugin
{
	static final Color DARK_GREEN = new Color(0, 153, 0);
	static final Color LIGHT_BLUE = new Color(60, 124, 240);
	static final Color LIGHT_RED = new Color(255, 35, 35);
	private static final int BA_WAVE_NUM_INDEX = 2;
	private static final String END_ROUND_REWARD_NEEDLE_TEXT = "<br>5";

	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;
	@Inject
	private ItemManager itemManager;
	@Inject
	private BarbarianAssaultConfig config;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private InfoBoxManager infoBoxManager;
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TimerOverlay timerOverlay;
	@Inject
	private HealerOverlay healerOverlay;
	@Inject
	private HighlightsOverlay highlightsOverlay;
	@Inject
	private HoppersOverlay hoppersOverlay;
	@Inject
	private DefenderTickTimerOverlay defenderTickTimerOverlay;

	@Getter(AccessLevel.PACKAGE)
	private final Map<EggGroundItem.Key, EggGroundItem> groundEggs = new LinkedHashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private final List<Counter> deathTimes = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private final List<GameObject> hoppers = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private final Map<Egg, Integer> cannonEggs = new HashMap<>(4);
	@Getter(AccessLevel.PACKAGE)
	private BufferedImage clockImage;
	private final Map<String, BufferedImage> npcImages = new HashMap<>(4);
	@Getter
	private int inGameBit;
	@Getter(AccessLevel.PACKAGE)
	private Timer timer;
	@Getter(AccessLevel.PACKAGE)
	private Round round;
	@Getter(AccessLevel.PACKAGE)
	private Wave wave;
	@Getter(AccessLevel.PACKAGE)
	private DefenderTickTimer defenderTickTimer;
	@Getter(AccessLevel.PACKAGE)
	private int currentWave;
	@Getter(AccessLevel.PACKAGE)
	private String lastListen;
	@Getter(AccessLevel.PACKAGE)
	private int lastListenItemId;
	private AttackStyleWidget highlightedAttackStyle;
	private Integer attackStyleTextColor;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(timerOverlay);
		overlayManager.add(healerOverlay);
		overlayManager.add(highlightsOverlay);
		overlayManager.add(hoppersOverlay);
		overlayManager.add(defenderTickTimerOverlay);

		clockImage = ImageUtil.getResourceStreamFromClass(getClass(), "clock.png");
		npcImages.put("fighters", ImageUtil.getResourceStreamFromClass(getClass(), "fighter.png"));
		npcImages.put("rangers", ImageUtil.getResourceStreamFromClass(getClass(), "ranger.png"));
		npcImages.put("healers", ImageUtil.getResourceStreamFromClass(getClass(), "healer.png"));
		npcImages.put("runners", ImageUtil.getResourceStreamFromClass(getClass(), "runner.png"));

		clientThread.invokeLater(() -> updateAttackStyleText(lastListen));
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(timerOverlay);
		overlayManager.remove(healerOverlay);
		overlayManager.remove(highlightsOverlay);
		overlayManager.remove(hoppersOverlay);
		overlayManager.remove(defenderTickTimerOverlay);

		clientThread.invokeLater(this::restoreAttackStyleText);

		displayRoleSprite();
		disableDefenderTickTimer(true);
		removeDeathTimes();

		groundEggs.clear();
		hoppers.clear();

		inGameBit = 0;

		timer = null;
		round = null;
		wave = null;
		currentWave = 0;

		lastListen = null;
		lastListenItemId = 0;

		restoreAttackStyleText();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("barbarianAssault"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "showTimer":
			{
				if (!config.showTimer() && inGameBit == 1)
				{
					displayRoleSprite();
				}
				break;
			}
			case "showHpCountOverlay":
			{
				if (!config.showHpCountOverlay() && inGameBit == 1 && getRole() == Role.HEALER)
				{
					removeCountOverlay(Role.HEALER);
				}
				break;
			}
			case "showEggCountOverlay":
			{
				if (!config.showEggCountOverlay() && inGameBit == 1 && getRole() == Role.COLLECTOR)
				{
					removeCountOverlay(Role.COLLECTOR);
				}
				break;
			}
			case "showRunnerTickTimer":
			{
				if (config.showRunnerTickTimer() && inGameBit == 1 && getRole() == Role.DEFENDER)
				{
					enableDefenderTickTimer(true);
				}
				else
				{
					disableDefenderTickTimer(false);
				}
				break;
			}
			case "showDeathTimesMode":
			{
				final DeathTimesMode deathTimesMode = config.showDeathTimesMode();
				if (deathTimesMode == DeathTimesMode.INFO_BOX || deathTimesMode == DeathTimesMode.INFOBOX_CHAT)
				{
					showDeathTimes();
				}
				else
				{
					hideDeathTimes();
				}
				break;
			}
			case "highlightAttackStyle":
			case "highlightAttackStyleColor":
				clientThread.invokeLater(() -> updateAttackStyleText(lastListen));
				break;
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			case WidgetID.BA_REWARD_GROUP_ID:
			{
				Widget rewardWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
				if (rewardWidget == null)
				{
					break;
				}

				if (!rewardWidget.getText().contains(END_ROUND_REWARD_NEEDLE_TEXT))
				{
					onWaveEnded(false);
				}
				else if (round != null)
				{
					onRoundEnded();
				}
				break;
			}
			case WidgetID.BA_ATTACKER_GROUP_ID:
			{
				startWave(Role.ATTACKER);
				break;
			}
			case WidgetID.BA_DEFENDER_GROUP_ID:
			{
				startWave(Role.DEFENDER);
				final boolean display = config.showRunnerTickTimer();
				enableDefenderTickTimer(display);
				break;
			}
			case WidgetID.BA_HEALER_GROUP_ID:
			{
				startWave(Role.HEALER);
				break;
			}
			case WidgetID.BA_COLLECTOR_GROUP_ID:
			{
				startWave(Role.COLLECTOR);
				break;
			}
		}
	}

	@Subscribe
	private void onChatMessage(ChatMessage chatMessage)
	{
		if (!chatMessage.getType().equals(ChatMessageType.GAMEMESSAGE))
		{
			return;
		}

		final String message = chatMessage.getMessage();
		if (message.startsWith("---- Wave:"))
		{
			currentWave = Integer.parseInt(message.split(" ")[BA_WAVE_NUM_INDEX]);

			if (round == null || currentWave == Round.STARTING_WAVE)
			{
				timer = new Timer();
				round = new Round(currentWave, timer);
			}

			// wave will be set on onWidgetLoaded which happens after onChatMessage.
			// Reset here in case we are restarting the same wave (no onWidgetLoaded happened).
			wave = null;
		}
		else
		{
			if (wave != null && message.contains("exploded"))
			{
				wave.setWrongEggsCount(wave.getWrongEggsCount() + 1);
				wave.setEggsCount(wave.getEggsCount() - 1);
			}
			else if (wave != null && message.contains("You healed "))
			{
				final int health = Integer.parseInt(message.split(" ")[2]);
				wave.setHpHealed(wave.getHpHealed() + health);
			}
			else if (config.highlightNotification() && message.contains("the wrong type of poisoned food to use"))
			{
				final MessageNode messageNode = chatMessage.getMessageNode();
				final String nodeValue = Text.removeTags(messageNode.getValue());
				messageNode.setValue(ColorUtil.wrapWithColorTag(nodeValue, config.highlightNotificationColor()));
				chatMessageManager.update(messageNode);
			}
			else if (wave != null && wave.getTimer() != null && message.startsWith("All of the Penance "))
			{
				final String npc = message.split(" ")[4];
				final int time = (int) wave.getTimer().getWaveTime().getSeconds();
				addDeathTime(npc, time);

				final DeathTimesMode deathTimesMode = config.showDeathTimesMode();
				if (deathTimesMode == DeathTimesMode.CHAT || deathTimesMode == DeathTimesMode.INFOBOX_CHAT)
				{
					final MessageNode node = chatMessage.getMessageNode();
					final String nodeValue = Text.removeTags(node.getValue());

					String timeElapsed = time + "s";
					if (config.enableGameChatColors())
					{
						timeElapsed = ColorUtil.wrapWithColorTag(timeElapsed, Color.RED);
					}

					node.setValue(nodeValue + " " + timeElapsed);
					chatMessageManager.update(node);
				}
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		final int inGame = client.getVar(Varbits.IN_GAME_BA);

		if (inGameBit != inGame)
		{
			if (inGameBit == 1)
			{
				// Use an instance check to determine if this is exiting a game or a tutorial
				// After exiting tutorials there is a small delay before changing IN_GAME_BA back to
				// 0 whereas when in a real wave it changes while still in the instance.
				final DurationMode durationMode = config.showDurationMode();
				if ((durationMode == DurationMode.WAVE || durationMode == DurationMode.WAVE_ROUND)
					&& wave != null && client.isInInstancedRegion())
				{
					announceWaveTime();
				}

				stopWave();
			}
		}

		inGameBit = inGame;

		if (inGameBit != 1)
		{
			return;
		}

		for (Egg egg : Egg.values())
		{
			final int eggsCount = client.getVarbitValue(egg.getVarbits().getId());
			if (eggsCount < 1)
			{
				cannonEggs.remove(egg);
			}
			else
			{
				cannonEggs.put(egg, eggsCount);
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.COMBAT_INTERFACE_SETUP)
		{
			clientThread.invokeLater(() -> updateAttackStyleText(lastListen));
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned gameObjectSpawned)
	{
		// Don't check for inGameBit == 1. Sometimes onGameObjectSpawned is called before onVarbitChanged

		final GameObject gameObject = gameObjectSpawned.getGameObject();
		if (isHopperGameObject(gameObject.getId()))
		{
			hoppers.add(gameObject);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned gameObjectDespawned)
	{
		final GameObject gameObject = gameObjectDespawned.getGameObject();
		hoppers.remove(gameObject);
	}

	@Subscribe
	private void onItemDespawned(ItemDespawned itemDespawned)
	{
		if (inGameBit != 1)
		{
			return;
		}

		final TileItem item = itemDespawned.getItem();
		final Tile tile = itemDespawned.getTile();

		final Role role = getRole();

		if (role == Role.COLLECTOR)
		{
			if (isEggItem(item.getId()))
			{
				removeEggSpawn(item, tile);
			}
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		if (inGameBit != 1)
		{
			return;
		}

		if (wave != null)
		{
			final Role role = wave.getRole();
			if (role != null)
			{
				final String currentListen = role.getListenText(client);
				if (currentListen != null && !currentListen.equals(lastListen))
				{
					clientThread.invoke(() -> updateAttackStyleText(currentListen));
				}

				lastListen = currentListen;
				lastListenItemId = role.getListenItemId(client);
			}
		}

		if (defenderTickTimer != null)
		{
			defenderTickTimer.incrementCount();
		}

	}

	@Subscribe
	private void onItemSpawned(ItemSpawned itemSpawned)
	{
		if (inGameBit != 1)
		{
			return;
		}

		final Role role = getRole();
		if (role == null)
		{
			return;
		}

		final TileItem item = itemSpawned.getItem();
		final Tile tile = itemSpawned.getTile();

		final EggGroundItem.Key groundItemKey = new EggGroundItem.Key(item.getId(), tile.getWorldLocation());
		final EggGroundItem groundItem = buildGroundItem(tile, item);

		if (role == Role.COLLECTOR)
		{
			if (isEggItem(item.getId()))
			{
				addEggSpawn(groundItemKey, groundItem);
			}
		}
	}

	public Color getColorForEggItem(String name, BarbarianAssaultGroundEggsMode groundEggsMode)
	{
		if (getRole() != Role.COLLECTOR || groundEggsMode == BarbarianAssaultGroundEggsMode.DISABLED)
		{
			return null;
		}

		final String eggName = name.toLowerCase();

		if (eggName.startsWith("yellow "))
		{
			return Color.YELLOW;
		}

		final String calledEgg = lastListen == null ? null : lastListen.toLowerCase();

		if (groundEggsMode == BarbarianAssaultGroundEggsMode.CALLED
			&& calledEgg != null && !calledEgg.startsWith(eggName))
		{
			return null;
		}

		if (eggName.startsWith("green "))
		{
			return Color.GREEN;
		}
		else if (eggName.startsWith("red "))
		{
			return LIGHT_RED;
		}
		else if (eggName.startsWith("blue "))
		{
			return LIGHT_BLUE;
		}

		return null;
	}

	Color getColorForItemId(int itemId)
	{
		switch (itemId)
		{
			case ItemID.BULLET_ARROW:
			case ItemID.FIELD_ARROW:
			case ItemID.BLUNT_ARROW:
			case ItemID.BARBED_ARROW:
				return config.highlightArrowColor();
			case ItemID.CRACKERS:
			case ItemID.TOFU:
			case ItemID.WORMS:
				return config.highlightBaitColor();
			case ItemID.GREEN_EGG:
				return Color.GREEN;
			case ItemID.RED_EGG:
				return LIGHT_RED;
			case ItemID.BLUE_EGG:
				return LIGHT_BLUE;
			case ItemID.YELLOW_EGG:
				return Color.YELLOW;
			case ItemID.POISONED_TOFU:
			case ItemID.POISONED_WORMS:
			case ItemID.POISONED_MEAT:
				return config.highlightPoisonColor();
		}
		return null;
	}

	Role getRole()
	{
		return wave == null ? null : wave.getRole();
	}

	private EggGroundItem buildGroundItem(final Tile tile, final TileItem item)
	{
		final int itemId = item.getId();
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;

		return EggGroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
			.height(tile.getItemLayer().getHeight())
			.spawnTime(Instant.now())
			.build();
	}

	private void updateAttackStyleText(String listen)
	{
		restoreAttackStyleText();

		final boolean highlightAttackStyle = config.highlightAttackStyle();

		if (listen == null || getRole() != Role.ATTACKER || !highlightAttackStyle)
		{
			return;
		}

		final int var = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
		final AttackStyle[] styles = WeaponType.getWeaponType(var).getAttackStyles();
		for (int i = 0; i < styles.length; i++)
		{
			final AttackStyle style = styles[i];
			if (style == null || !listen.startsWith(style.getName()))
			{
				continue;
			}

			final Color color = config.highlightAttackStyleColor();

			highlightedAttackStyle = AttackStyleWidget.getAttackStyles()[i];

			final Widget attackStyleTextWidget = client.getWidget(highlightedAttackStyle.getText());
			if (attackStyleTextWidget != null)
			{
				if (attackStyleTextColor == null)
				{
					attackStyleTextColor = attackStyleTextWidget.getTextColor();
				}
				attackStyleTextWidget.setTextColor(Integer.decode(ColorUtil.toHexColor(color)));
			}

		}
	}

	private void restoreAttackStyleText()
	{
		if (highlightedAttackStyle != null && attackStyleTextColor != null)
		{
			final Widget attackStyleTextWidget = client.getWidget(highlightedAttackStyle.getText());
			if (attackStyleTextWidget != null)
			{
				attackStyleTextWidget.setTextColor(attackStyleTextColor);
			}
		}
		highlightedAttackStyle = null;
		attackStyleTextColor = null;
	}

	private void onWaveEnded(boolean roundEnded)
	{
		Wave wave = this.wave;
		if (wave == null)
		{
			wave = new Wave(client, currentWave);
		}

		if (!roundEnded)
		{
			wave.setAmounts();
			wave.setPoints();

			Widget pointsWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
			if (pointsWidget != null)
			{
				final boolean colorful = config.enableGameChatColors();

				final PointsMode pointsMode = config.showRewardPointsMode();
				if (pointsMode == PointsMode.WAVE || pointsMode == PointsMode.WAVE_ROUND)
				{
					ChatMessageBuilder wavePoints = wave.getWavePoints(colorful);
					announce(wavePoints);
				}

				final RewardsBreakdownMode rewardsBreakdownMode = config.showRewardsBreakdownMode();
				if (rewardsBreakdownMode == RewardsBreakdownMode.WAVE || rewardsBreakdownMode == RewardsBreakdownMode.WAVE_ROUND)
				{
					ChatMessageBuilder waveSummary = wave.getWaveSummary(colorful);
					announce(waveSummary);
				}
			}
		}

		if (round != null)
		{
			round.addWave(wave);
		}

		this.wave = null;
		currentWave = 0;
	}

	private void onRoundEnded()
	{
		if (round == null)
		{
			return;
		}

		onWaveEnded(true);

		final DurationMode durationMode = config.showDurationMode();
		if (durationMode == DurationMode.ROUND || durationMode == DurationMode.WAVE_ROUND)
		{
			announceRoundTime();
		}

		if (round.isComplete())
		{
			round.endRound();

			final boolean colorful = config.enableGameChatColors();

			final PointsMode pointsMode = config.showRewardPointsMode();
			if (pointsMode == PointsMode.ROUND || pointsMode == PointsMode.WAVE_ROUND)
			{
				ChatMessageBuilder roundPoints = round.getRoundPoints(colorful);
				announce(roundPoints);
			}

			final RewardsBreakdownMode rewardsBreakdownMode = config.showRewardsBreakdownMode();
			if (rewardsBreakdownMode == RewardsBreakdownMode.ROUND || rewardsBreakdownMode == RewardsBreakdownMode.WAVE_ROUND)
			{
				ChatMessageBuilder roundSummary = round.getRoundSummary(colorful);
				announce(roundSummary);
			}
		}

		round = null;
		timer = null;
	}

	private void startWave(Role role)
	{
		// Prevent changing waves when a wave is already set, as widgets can be
		// loaded multiple times in game from eg. opening and closing the horn
		// of glory.
		if (wave != null)
		{
			return;
		}

		log.debug("Starting wave {} as {} at {}", currentWave, role, timer.getRoundTimeFormatted(false));

		timer.setWaveStartTime();
		wave = new Wave(client, currentWave, role, timer);
	}

	private void displayRoleSprite()
	{
		final Role role = getRole();
		if (role == null)
		{
			return;
		}

		final Widget roleSprite = client.getWidget(role.getRoleSprite());
		if (roleSprite != null)
		{
			roleSprite.setHidden(false);
		}

		final Widget roleText = client.getWidget(role.getRoleText());
		if (roleText != null)
		{
			roleText.setText(role.getName());
		}
	}

	private void removeCountOverlay(Role role)
	{
		final Widget roleText = client.getWidget(role.getRoleText());
		if (roleText != null)
		{
			final String text = roleText.getText().replaceAll("\\(.*\\) ", "");
			roleText.setText(text);
		}
	}

	private void stopWave()
	{
		disableDefenderTickTimer(true);
		removeDeathTimes();
		groundEggs.clear();
		hoppers.clear();
		cannonEggs.clear();
		lastListen = null;
		lastListenItemId = 0;
		restoreAttackStyleText();
	}


	private void announceWaveTime()
	{
		if (wave == null || wave.getTimer() == null)
		{
			return;
		}

		final String time = wave.getTimer().getWaveTimeFormatted();
		final int number = wave.getNumber();

		final StringBuilder message = new StringBuilder();
		message.append("Wave ");
		if (number > 0)
		{
			message.append(number).append(" ");
		}
		message.append("duration: ");

		announceTime(message.toString(), time);
	}

	private void announceRoundTime()
	{
		if (round == null || round.getTimer() == null)
		{
			return;
		}

		final String time = round.getTimer().getRoundTimeFormatted(true);
		final int fromWave = round.getStartingWave();
		final StringBuilder message = new StringBuilder();
		if (fromWave == 1)
		{
			message.append("Game finished, duration: ");
		}
		else
		{
			message.append("Game finished, duration from wave ").append(fromWave).append(": ");
		}
		announceTime(message.toString(), time);
	}


	private void announceTime(String preText, String time)
	{
		ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(preText);
		if (config.enableGameChatColors())
		{
			chatMessageBuilder.append(ChatColorType.HIGHLIGHT);
		}
		chatMessageBuilder = chatMessageBuilder.append(time);

		announce(chatMessageBuilder);
	}

	private void announce(final ChatMessageBuilder chatMessage)
	{
		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(chatMessage.build())
			.build());
	}

	private void enableDefenderTickTimer(boolean display)
	{
		if (defenderTickTimer == null)
		{
			defenderTickTimer = new DefenderTickTimer();
		}
		defenderTickTimer.setDisplaying(display);
	}

	private void disableDefenderTickTimer(boolean remove)
	{
		if (defenderTickTimer != null)
		{
			defenderTickTimer.setDisplaying(false);
		}
		if (remove)
		{
			defenderTickTimer = null;
		}
	}

	private void showDeathTimes()
	{
		List<InfoBox> infoBoxes = infoBoxManager.getInfoBoxes();

		for (Counter counter : deathTimes)
		{
			if (!infoBoxes.contains(counter))
			{
				infoBoxManager.addInfoBox(counter);
			}
		}
	}

	private void hideDeathTimes()
	{
		for (Counter counter : deathTimes)
		{
			infoBoxManager.removeInfoBox(counter);
		}
	}

	private void addDeathTime(String npc, long time)
	{
		final BufferedImage image = npcImages.get(npc.toLowerCase());
		final Counter counter = new Counter(image, this, (int) time);

		deathTimes.add(counter);

		final DeathTimesMode deathTimesMode = config.showDeathTimesMode();
		if (deathTimesMode == DeathTimesMode.INFO_BOX || deathTimesMode == DeathTimesMode.INFOBOX_CHAT)
		{
			infoBoxManager.addInfoBox(counter);
		}
	}

	private void removeDeathTimes()
	{
		hideDeathTimes();
		deathTimes.clear();
	}

	private boolean isEggItem(int itemId)
	{
		return itemId == ItemID.RED_EGG
			|| itemId == ItemID.GREEN_EGG
			|| itemId == ItemID.BLUE_EGG
			|| itemId == ItemID.YELLOW_EGG;
	}

	private boolean isBaitItem(int itemId)
	{
		return itemId == ItemID.TOFU
			|| itemId == ItemID.WORMS
			|| itemId == ItemID.CRACKERS;
	}

	private boolean isLogsOrHammerItem(int itemId)
	{
		return itemId == ItemID.LOGS
			|| itemId == ItemID.HAMMER;
	}

	private boolean isHopperGameObject(int gameObjectId)
	{
		return gameObjectId == ObjectID.EGG_HOPPER
			|| gameObjectId == ObjectID.EGG_HOPPER_20265
			|| gameObjectId == ObjectID.EGG_HOPPER_20266
			|| gameObjectId == ObjectID.EGG_HOPPER_20267;
	}

	public boolean canHighlightGroundItem(int itemId, boolean highlightDefenderBait,
										  boolean highlightDefenderLogsHammer,
										  BarbarianAssaultGroundEggsMode barbarianAssaultGroundEggsMode)
	{
		if (inGameBit == 0)
		{
			return true;
		}

		final Role role = getRole();
		if (role == null)
		{
			return true;
		}

		switch (role)
		{
			case COLLECTOR:
				if (barbarianAssaultGroundEggsMode == BarbarianAssaultGroundEggsMode.DISABLED)
				{
					return false;
				}
				else if (barbarianAssaultGroundEggsMode == BarbarianAssaultGroundEggsMode.ALL)
				{
					return isEggItem(itemId);
				}
				else
				{
					return lastListenItemId == itemId || itemId == ItemID.YELLOW_EGG;
				}
			case DEFENDER:
				if (highlightDefenderBait)
				{
					if (isBaitItem(itemId))
					{
						return true;
					}
				}
				if (highlightDefenderLogsHammer)
				{
					return isLogsOrHammerItem(itemId);
				}
				return false;
		}

		return false;
	}

	private void addEggSpawn(EggGroundItem.Key groundItemKey, EggGroundItem groundItem)
	{
		addItemSpawn(groundItemKey, groundItem, groundEggs);
	}

	private void addItemSpawn(EggGroundItem.Key groundItemKey, EggGroundItem groundItem,
							  Map<EggGroundItem.Key, EggGroundItem> spawnItems)
	{
		EggGroundItem existing = spawnItems.putIfAbsent(groundItemKey, groundItem);
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
		}
	}

	private void removeEggSpawn(TileItem item, Tile tile)
	{
		final EggGroundItem.Key groundItemKey = new EggGroundItem.Key(item.getId(), tile.getWorldLocation());
		final EggGroundItem groundItem = removeItemSpawn(item, groundItemKey, groundEggs);
		if (groundItem == null)
		{
			return;
		}

		final Player player = client.getLocalPlayer();
		if (player == null)
		{
			return;
		}

		final Instant spawnTime = groundItem.getSpawnTime();
		final Instant now = Instant.now();
		if (wave != null && wave.getRole() == Role.COLLECTOR
			&& (spawnTime == null || now.isBefore(spawnTime.plus(Duration.ofMinutes(2))))
			&& groundItem.getLocation().equals(player.getWorldLocation()))
		{
			wave.setEggsCount(wave.getEggsCount() + 1);
		}
	}

	private EggGroundItem removeItemSpawn(TileItem item, EggGroundItem.Key groundItemKey,
										  Map<EggGroundItem.Key, EggGroundItem> spawnItems)
	{
		final EggGroundItem groundItem = spawnItems.get(groundItemKey);
		if (groundItem == null)
		{
			return null;
		}

		if (groundItem.getQuantity() <= item.getQuantity())
		{
			spawnItems.remove(groundItemKey);
		}
		else
		{
			groundItem.setQuantity(groundItem.getQuantity() - item.getQuantity());
			// When picking up an item when multiple stacks appear on the ground,
			// it is not known which item is picked up, so we invalidate the spawn
			// time
			groundItem.setSpawnTime(null);
		}
		return groundItem;
	}
}
