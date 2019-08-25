/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://runelitepl.us
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
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.WeaponType;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;


@Slf4j
@PluginDescriptor(
	name = "Barbarian Assault",
	description = "Custom barbarian assault plugin, use along with BA Tools",
	tags = {"minigame", "overlay", "timer"},
	type = PluginType.PVM // don't remove this, added this because our barbarian assault plugin is big time modified
)
@Singleton
public class BarbarianAssaultPlugin extends Plugin implements KeyListener
{
	private static final String ENDGAME_REWARD_NEEDLE_TEXT = "<br>5";

	private static final int COLOR_CALL_UPDATED = 16316664;

	private static final int COLOR_CALL_CALLED = 16291864;

	private static final int BA_WAVE_NUM_INDEX = 2;

	private static final ImmutableList<WidgetInfo> attackStyles = ImmutableList.of(WidgetInfo.COMBAT_STYLE_ONE,
		WidgetInfo.COMBAT_STYLE_TWO, WidgetInfo.COMBAT_STYLE_THREE, WidgetInfo.COMBAT_STYLE_FOUR);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BarbarianAssaultConfig config;

	@Inject
	private AboveWidgetsOverlay widgetsOverlay;

	@Inject
	private AboveSceneOverlay sceneOverlay;

	@Inject
	private BarbarianAssaultMenu menu;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private EventBus eventBus;

	@Getter
	private boolean inGame = false;

	@Getter
	private Wave wave = null;

	@Getter
	private Role role = null;

	@Getter
	private Scorecard scorecard = null;

	@Getter
	private Timer gameTimer = null;

	@Getter
	private Timer callTimer = null;

	@Getter
	private int stage = -1;

	@Getter
	private BufferedImage clockImage;

	@Getter
	private Font font = null;

	@Getter
	private final Map<WorldPoint, Integer> redEggs = new HashMap<>();

	@Getter
	private final Map<WorldPoint, Integer> greenEggs = new HashMap<>();

	@Getter
	private final Map<WorldPoint, Integer> blueEggs = new HashMap<>();

	@Getter
	private final Map<WorldPoint, Integer> yellowEggs = new HashMap<>();

	@Getter
	private final Map<Integer, Healer> healers = new HashMap<>();

	@Getter
	private String lastCallText = null;

	@Getter
	private String lastListenText = null;

	// private String lastClickedTell = null;

	private int lastCallColor = -1;

	private int lastInteracted = -1;

	private int lastHealerPoisoned = -1;

	private int tickNum = 0;

	// private int gameTick = -1;

	private int inGameBit = 0;

	private boolean syncd = true;

	private boolean tickReset = false;

	private boolean hornCalled = false;

	private boolean hornListened = false;

	@Getter
	private boolean usingGloryHorn = false;

	private boolean shiftDown = false;

	private boolean controlDown = false;

	private BufferedImage torsoImage, fighterImage, healerImage, rangerImage, runnerImage;

	private final List<TimerBox> deathTimes = new ArrayList<>();

	private final Map<Integer, Projectile> projectiles = new HashMap<>();

	private TimerBox tickCounter;

	private String poisonUsed = null;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	// save config values
	@Getter(AccessLevel.PACKAGE)
	private boolean swapLadder;
	@Getter(AccessLevel.PACKAGE)
	private boolean showTimer;
	@Getter(AccessLevel.PACKAGE)
	private boolean removeIncorrectCalls;
	@Getter(AccessLevel.PACKAGE)
	private boolean removeUnusedMenus;
	private boolean prayerMetronome;
	private int prayerMetronomeVolume;
	private boolean showDeathTimes;
	private DeathTimesMode showDeathTimesMode;
	private boolean waveTimes;
	private boolean showTotalRewards;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightArrows;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightArrowColor;
	private boolean removeIncorrectAttackStyles;
	private boolean tagging;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightBait;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightBaitColor;
	private boolean showDefTimer;
	private boolean deprioritizeBait;
	@Getter(AccessLevel.PACKAGE)
	private boolean removePenanceCave;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightPoison;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightPoisonColor;
	private boolean highlightNotification;
	private Color highlightNotificationColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showHpCountOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean showTeammateHealthbars;
	@Getter(AccessLevel.PACKAGE)
	private boolean healerCodes;
	private boolean healerMenuOption;
	private boolean shiftOverstock;
	private boolean controlHealer;
	@Getter(AccessLevel.PACKAGE)
	private boolean swapCollectorBag;
	@Getter(AccessLevel.PACKAGE)
	private boolean swapDestroyEggs;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightCollectorEggs;
	private boolean deprioritizeIncorrectEggs;
	@Getter(AccessLevel.PACKAGE)
	private boolean showEggCountOverlay;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		font = FontManager.getRunescapeFont().deriveFont(Font.BOLD, 24);
		torsoImage = itemManager.getImage(ItemID.FIGHTER_TORSO);
		clockImage = ImageUtil.getResourceStreamFromClass(getClass(), "clock.png");
		fighterImage = ImageUtil.getResourceStreamFromClass(getClass(), "fighter.png");
		healerImage = ImageUtil.getResourceStreamFromClass(getClass(), "healer.png");
		rangerImage = ImageUtil.getResourceStreamFromClass(getClass(), "ranger.png");
		runnerImage = ImageUtil.getResourceStreamFromClass(getClass(), "runner.png");
		overlayManager.add(widgetsOverlay);
		overlayManager.add(sceneOverlay);
		keyManager.registerKeyListener(this);
		clientThread.invoke(this::validateGame);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(widgetsOverlay);
		overlayManager.remove(sceneOverlay);
		keyManager.unregisterKeyListener(this);
		showRoleSprite();
		font = null;
		torsoImage = null;
		clockImage = null;
		fighterImage = null;
		healerImage = null;
		rangerImage = null;
		runnerImage = null;
		shiftDown = false;
		controlDown = false;
		resetWave();
		wave = null;
		// gameTick = client.getTickCount();
		menu.disableSwaps(true);
		menu.clearHiddenMenus();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(ItemSpawned.class, this, this::onItemSpawned);
		eventBus.subscribe(ItemDespawned.class, this, this::onItemDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(BeforeRender.class, this, this::onBeforeRender);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(ProjectileSpawned.class, this, this::onProjectileSpawned);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			shiftDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			controlDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			shiftDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			controlDown = false;
		}
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		//not client thread be careful
		if (!configChanged.getGroup().equals("barbarianAssault"))
		{
			return;
		}

		updateConfig();

		switch (configChanged.getKey())
		{
			case "showTimer":
				if (!this.showTimer)
				{
					showRoleSprite();
				}
				break;

			case "swapLadder":
			case "swapCollectorBag":
			case "swapDestroyEggs":
				if (Boolean.valueOf(configChanged.getNewValue()))
				{
					menu.enableSwaps();
				}
				else
				{
					menu.disableSwaps(false);
				}
				break;

			case "showDefTimer":
				if (this.showDefTimer && getRole() == Role.DEFENDER)
				{
					addTickTimer();
				}
				else
				{
					removeTickTimer();
				}
				break;

			case "showDeathTimes":
			case "showDeathTimesMode":
				if (this.showDeathTimes
					&& (this.showDeathTimesMode == DeathTimesMode.INFO_BOX
					|| this.showDeathTimesMode == DeathTimesMode.BOTH))
				{
					addAllDeathTimes();
				}
				else
				{
					removeAllDeathTimes(false);
				}
				break;

			case "removePenanceCave":
			case "removeUnusedMenus":
			case "removeWrongPoison":
				clientThread.invoke(() -> menu.validateHiddenMenus(getRole()));
				break;

			case "removeIncorrectAttackStyles":
				if (!this.removeIncorrectAttackStyles)
				{
					clientThread.invoke(this::showAllStyles);
				}
				break;
		}
	}

	private void updateConfig()
	{
		this.swapLadder = config.swapLadder();
		this.showTimer = config.showTimer();
		this.removeIncorrectCalls = config.removeIncorrectCalls();
		this.removeUnusedMenus = config.removeUnusedMenus();
		this.prayerMetronome = config.prayerMetronome();
		this.prayerMetronomeVolume = config.prayerMetronomeVolume();
		this.showDeathTimes = config.showDeathTimes();
		this.showDeathTimesMode = config.showDeathTimesMode();
		this.waveTimes = config.waveTimes();
		this.showTotalRewards = config.showTotalRewards();
		this.highlightArrows = config.highlightArrows();
		this.highlightArrowColor = config.highlightArrowColor();
		this.removeIncorrectAttackStyles = config.removeIncorrectAttackStyles();
		this.tagging = config.tagging();
		this.highlightBait = config.highlightBait();
		this.highlightBaitColor = config.highlightBaitColor();
		this.showDefTimer = config.showDefTimer();
		this.deprioritizeBait = config.deprioritizeBait();
		this.removePenanceCave = config.removePenanceCave();
		this.highlightPoison = config.highlightPoison();
		this.highlightPoisonColor = config.highlightPoisonColor();
		this.highlightNotification = config.highlightNotification();
		this.highlightNotificationColor = config.highlightNotificationColor();
		this.showHpCountOverlay = config.showHpCountOverlay();
		this.showTeammateHealthbars = config.showTeammateHealthbars();
		this.healerCodes = config.healerCodes();
		this.healerMenuOption = config.healerMenuOption();
		this.shiftOverstock = config.shiftOverstock();
		this.controlHealer = config.controlHealer();
		this.swapCollectorBag = config.swapCollectorBag();
		this.swapDestroyEggs = config.swapDestroyEggs();
		this.highlightCollectorEggs = config.highlightCollectorEggs();
		this.deprioritizeIncorrectEggs = config.deprioritizeIncorrectEggs();
		this.showEggCountOverlay = config.showEggCountOverlay();
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			case WidgetID.BA_REWARD_GROUP_ID:
				announceWaveTime();

				Widget rewardWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
				if (rewardWidget == null)
				{
					break;
				}

				Widget pointsWidget = client.getWidget(WidgetInfo.BA_REWARD_TEXT);
				if (!rewardWidget.getText().contains(ENDGAME_REWARD_NEEDLE_TEXT))
				{
					if (this.showTotalRewards && pointsWidget != null)
					{
						// The wave will be null if the plugin is disabled mid game, but
						// the wave points will still be accurate if it is re-enabled
						if (wave == null)
						{
							wave = new Wave(client);
						}

						wave.setAmounts();
						wave.setPoints();

						announce(wave.getSummary());

						// The scorecard will be null if the client is restart mid game
						if (scorecard != null)
						{
							scorecard.addWave(wave);
						}
					}
				}
				else
				{
					announceGameTime();

					if (this.showTotalRewards && scorecard != null && scorecard.getNumberOfWaves() == 9)
					{
						announce(scorecard.getGameSummary());
					}
				}
				break;

			case WidgetID.BA_ATTACKER_GROUP_ID:
				startWave(Role.ATTACKER);
				menu.validateHiddenMenus(Role.ATTACKER);
				break;

			case WidgetID.BA_DEFENDER_GROUP_ID:
				startWave(Role.DEFENDER);
				menu.validateHiddenMenus(Role.DEFENDER);
				break;

			case WidgetID.BA_HEALER_GROUP_ID:
				startWave(Role.HEALER);
				menu.validateHiddenMenus(Role.HEALER);
				break;

			case WidgetID.BA_COLLECTOR_GROUP_ID:
				startWave(Role.COLLECTOR);
				menu.validateHiddenMenus(Role.COLLECTOR);
				break;
		}
	}

	private void onChatMessage(ChatMessage chatMessage)
	{
		if (!chatMessage.getType().equals(ChatMessageType.GAMEMESSAGE))
		{
			return;
		}

		final String message = chatMessage.getMessage();
		if (message.startsWith("---- Wave:"))
		{
			stage = Integer.parseInt(message.split(" ")[BA_WAVE_NUM_INDEX]);
			if (stage == 1)
			{
				scorecard = new Scorecard(this);
				gameTimer = new Timer();
			}
		}
		else if (isInGame())
		{
			if (scorecard != null)
			{
				scorecard.onChatMessage(chatMessage);
			}

			if (message.contains("exploded") && wave != null)
			{
				wave.setWrongEggs(wave.getWrongEggs() + 1);
				wave.setPositiveEggCount(wave.getPositiveEggCount() - 1);
			}
			else if (message.contains("You healed") && wave != null)
			{
				String[] tokens = message.split(" ");
				if (Integer.parseInt(tokens[2]) > 0)
				{
					int health = Integer.parseInt(tokens[2]);
					wave.setHpHealed(wave.getHpHealed() + health);
				}
			}
			else if (message.contains("the wrong type of poisoned food to use") && this.highlightNotification)
			{
				final MessageNode messageNode = chatMessage.getMessageNode();
				final String nodeValue = Text.removeTags(messageNode.getValue());
				messageNode.setValue(ColorUtil.wrapWithColorTag(nodeValue, this.highlightNotificationColor));
				chatMessageManager.update(messageNode);
			}
			else if (message.startsWith("All of the Penance"))
			{
				String[] tokens = message.split(" ");

				int time = wave == null ? -1 : (int)wave.getWaveTimer().getElapsedTime();

				switch (tokens[4])
				{
					case "Fighters":
						addDeathTimes(new TimerBox(fighterImage, this, time));
						break;

					case "Healers":
						addDeathTimes(new TimerBox(healerImage, this, time));
						break;

					case "Rangers":
						addDeathTimes(new TimerBox(rangerImage, this, time));
						break;

					case "Runners":
						addDeathTimes(new TimerBox(runnerImage, this, time));
						break;
				}

				if (this.showDeathTimes && wave != null
					&& (this.showDeathTimesMode == DeathTimesMode.CHAT_BOX
					|| this.showDeathTimesMode == DeathTimesMode.BOTH))
				{
					final MessageNode node = chatMessage.getMessageNode();
					final String nodeValue = Text.removeTags(node.getValue());
					node.setValue(nodeValue + " (<col=ff0000>" + wave.getWaveTimer().getElapsedTime() + "s</col>)");
					chatMessageManager.update(node);
				}
			}
		}
	}

	private void onItemSpawned(ItemSpawned itemSpawned)
	{
		if (!isInGame())
		{
			return;
		}

		Map<WorldPoint, Integer> eggMap = getEggMap(itemSpawned.getItem().getId());
		if (eggMap != null)
		{
			WorldPoint worldPoint = itemSpawned.getTile().getWorldLocation();
			Integer existingQuantity = eggMap.putIfAbsent(worldPoint, 1);
			if (existingQuantity != null)
			{
				eggMap.put(worldPoint, existingQuantity + 1);
			}
		}
	}

	private void onItemDespawned(ItemDespawned itemDespawned)
	{
		if (!isInGame())
		{
			return;
		}

		int itemId = itemDespawned.getItem().getId();

		if (!isItemEgg(itemId))
		{
			return;
		}

		// If an egg despawns due to time and the collector is standing over it,
		// a point will added as if the player picked it up
		Map<WorldPoint, Integer> eggMap = getEggMap(itemId);
		if (eggMap != null)
		{
			WorldPoint worldPoint = itemDespawned.getTile().getWorldLocation();
			if (eggMap.containsKey(worldPoint))
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
		}

		if (getRole() == Role.COLLECTOR
			&& wave != null
			&& itemDespawned.getTile().getWorldLocation().equals(client.getLocalPlayer().getWorldLocation()))
		{
			wave.setPositiveEggCount(wave.getPositiveEggCount() + 1);

			if (wave.getPositiveEggCount() > 60)
			{
				wave.setPositiveEggCount(60);
			}

			wave.setCollectedEggCount(wave.getPositiveEggCount() - wave.getWrongEggs());
		}
	}

	private void onGameTick(GameTick event)
	{
		// Keep in mind isInGame is delayed by a tick when a wave ends
		if (!isInGame() || getRole() == null)
		{
			return;
		}

		tickNum++;

		if (tickNum > 9 || tickReset)
		{
			tickNum = 0;
			tickReset = false;
			projectiles.entrySet().removeIf(projectile -> projectile.getValue().getRemainingCycles() < 1);
		}

		if (tickCounter != null)
		{
			tickCounter.setCount(tickNum);
		}

		if (this.prayerMetronome && isAnyPrayerActive())
		{
			for (int i = 0; i < this.prayerMetronomeVolume; i++)
			{
				client.playSoundEffect(SoundEffectID.GE_INCREMENT_PLOP);
			}
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (!isInGame())
		{
			return;
		}

		NPC npc = event.getNpc();

		if (npc == null)
		{
			return;
		}

		String name = event.getNpc().getName();

		if (name.equals("Penance Healer") && !healers.containsKey(npc.getIndex()))
		{
			healers.put(npc.getIndex(), new Healer(npc, healers.size(), stage));
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (!isInGame())
		{
			return;
		}

		healers.remove(event.getNpc().getIndex());
	}


	// So this is a mess, but it works and the horn of glory doesn't mess up anything.
	// This was almost certainly a waste of time to get working, because almost nobody
	// actually uses the horn of glory. At least now there shouldn't be anyone complaining
	// about the horn of glory breaking anything and everything that should never break.
	private void onBeforeRender(BeforeRender event)
	{
		if (!isInGame())
		{
			return;
		}

		boolean rebuild = false;

		Widget callWidget = getRole() == null ? null : client.getWidget(getRole().getGloryCall());
		if (callWidget == null)
		{
			callWidget = getRole() == null ? null : client.getWidget(getRole().getCall());
		}

		String newCallText = getRole() == null ? lastCallText : getRole().getCall(client);
		int newCallColor = callWidget == null ? lastCallColor : callWidget.getTextColor();

		Widget listenWidget = getRole() == null ? null : client.getWidget(getRole().getGloryListen());
		if (listenWidget == null)
		{
			listenWidget = getRole() == null ? null : client.getWidget(getRole().getListen());
			usingGloryHorn = false;
		}
		else
		{
			usingGloryHorn = true;
		}

		String newListenText = getRole() == null ? lastListenText : getRole().getListen(client);

		if (!Objects.equals(newCallText, lastCallText))
		{
			rebuild = true;
			lastCallText = newCallText;
			callTimer = new Timer();
			tickReset = true;
			hornCalled = false;
			hornListened = false;
			menu.setHornUpdated(false);
			syncd = true;

			if (tickCounter != null)
			{
				tickCounter.setInSync(true);
			}
		}

		if (!Objects.equals(newListenText, lastListenText))
		{
			if (newListenText != null && !newListenText.equals("- - -"))
			{
				hornListened = true;
				rebuild = true;
			}
			else if (hornListened)
			{
				newListenText = lastListenText;

				// If the player uses the horn of glory, the listen text will be taken from there and set to the
				// normal widget when the player exits the interface
				if (listenWidget != null && !usingGloryHorn)
				{
					// Attacker has two widgets for it's listen text, the top widget is the one that is kept track of
					if (getRole() == Role.ATTACKER)
					{
						listenWidget.setText(newListenText);
						client.getWidget(WidgetInfo.BA_ATK_LISTEN_BOTTOM_TEXT).setText(Role.getMissingListen(newListenText));
					}
					else
					{
						listenWidget.setText(newListenText);
					}

				}
			}

			lastListenText = newListenText;
		}

		// Disabled for now, will need to also check either chat or verify a busy animation is not happening
		/*if (newCallColor == COLOR_CALL_CALLED && !Objects.equals(lastClickedTell, lastCallText))
		{
			hornCalled = false;
			rebuild = true;

			if (callWidget != null)
			{
				callWidget.setTextColor(COLOR_CALL_UPDATED);
				lastCallColor = COLOR_CALL_UPDATED;
			}
		}

		else if (newCallColor == COLOR_CALL_UPDATED && Objects.equals(lastClickedTell, lastCallText))
		{
			hornCalled = true;
			rebuild = true;

			if (callWidget != null)
			{
				callWidget.setTextColor(COLOR_CALL_CALLED);
				lastCallColor = COLOR_CALL_CALLED;
			}
		}*/

		// Horn of glory will switch text back to white color before call change
		if (newCallColor != lastCallColor)
		{
			if (newCallColor == COLOR_CALL_CALLED)
			{
				hornCalled = true;
				rebuild = true;
			}
			else if (hornCalled)
			{
				newCallColor = COLOR_CALL_CALLED;
				if (callWidget != null)
				{
					callWidget.setTextColor(newCallColor);
				}
			}

			lastCallColor = newCallColor;
		}

		if (rebuild || menu.isRebuildForced())
		{
			menu.setRebuildForced(false);
			menu.validateHiddenMenus(role);
		}

		// This doesn't have to be done in BeforeRender. And although it is
		// inefficient, it's only being done while in the instance. Will
		// likely be changed in the future
		if (getRole() == Role.ATTACKER && this.removeIncorrectAttackStyles)
		{
			Widget weapon = client.getWidget(WidgetInfo.COMBAT_WEAPON);

			if (weapon != null)
			{
				if ((StringUtils.contains(weapon.getText(), "Crystal halberd") || StringUtils.contains(weapon.getText(), "Dragon claws"))
					&& newListenText != null && !newListenText.equals("- - -"))
				{
					int i = 0;
					for (AttackStyle style : getAttackStyles())
					{
						Widget attackStyle = client.getWidget(attackStyles.get(i));
						if (attackStyle != null && style != null)
						{
							if (StringUtils.startsWith(newListenText, style.getName()))
							{
								attackStyle.setHidden(false);
							}
							else
							{
								attackStyle.setHidden(true);
							}
						}

						i++;
					}
				}
				else
				{
					showAllStyles();
				}
			}
		}
	}

	// onMenuEntryAdded is being used for conditional entry changes that are not
	// easily achievable using MenuManager, all other changes use MenuManager in
	// the BarbarianAssaultMenu/Menus classes
	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!isInGame())
		{
			return;
		}

		final List<MenuEntry> menu = new ArrayList<>();
		final List<MenuEntry> selected = new ArrayList<>();
		final List<MenuEntry> priority = new ArrayList<>();
		MenuEntry walk = null;
		boolean prioritizeWalk = false;

		String listen = lastListenText != null ? StringUtils.remove(lastListenText, "Pois. ").toLowerCase() : "";

		for (MenuEntry entry : client.getMenuEntries())
		{
			String option = Text.removeTags(entry.getOption()).toLowerCase();
			String target = Text.removeTags(entry.getTarget()).toLowerCase();
			int identifier = entry.getIdentifier();

			if (option.equals("walk here"))
			{
				walk = entry;
			}
			else
			{
				switch (getRole())
				{
					case ATTACKER:
						if (this.tagging && option.equals("attack") && (target.startsWith("penance fighter") || target.startsWith("penance ranger")))
						{
							String tag = StringUtils.substringBefore(entry.getTarget(), ")");

							NPC[] npcs = client.getCachedNPCs();

							if (identifier >= 0 && identifier < npcs.length)
							{
								NPC npc = npcs[identifier];
								if (npc != null)
								{
									Projectile projectile = projectiles.get(identifier);
									if (npc.getInteracting() == null && projectile == null)
									{
										entry.setTarget((tag + ") (" + (10 - (tickNum + 1)) + ")").replace("<col=ffff00>", "<col=2bff63>"));
										selected.add(entry);
										continue;
									}
									// TODO add check to see if other attacker is attacking fighter/ranger
									// Possibly just add it to a list when the projectile is spawned
									// Also maybe add order by health option
									else if (npc.getInteracting() == client.getLocalPlayer() || (projectile != null && projectile.getInteracting() == npc))
									{
										entry.setTarget((tag + ") (" + (10 - (tickNum)) + ")").replace("<col=ffff00>", "<col=0000ff>"));
									}
									else
									{
										entry.setTarget((tag + ") (" + (10 - (tickNum)) + ")").replace("<col=ffff00>", "<col=ff0000>"));
									}
								}
							}
						}
						break;

					case COLLECTOR:
						// Take option for yellow eggs should always be the first option
						if (option.equals("take") && target.equals("yellow egg"))
						{
							priority.add(entry);
							continue;
						}
						else if (this.deprioritizeIncorrectEggs
							&& option.equals("take")
							&& (target.equals("blue egg") || target.equals("green egg") || target.equals("red egg")))
						{
							prioritizeWalk = true;

							if (listen.startsWith(target))
							{
								selected.add(entry);
								continue;
							}
						}
						break;

					case DEFENDER:
						// Take option for logs and hammer should always be the first option
						if (option.equals("take")
							&& (target.equals("logs") || target.equals("hammer")))
						{
							priority.add(entry);
							continue;
						}
						else if (this.deprioritizeBait
							&& option.equals("take")
							&& (target.equals("tofu") || target.equals("crackers") || target.equals("worms")))
						{
							prioritizeWalk = true;
						}
						break;

					case HEALER:
						if (this.healerMenuOption && target.contains("penance healer") && healers.containsKey(identifier))
						{
							String tag = StringUtils.substringBefore(entry.getTarget(), " (");
							int time = healers.get(identifier).timeToPoison();

							if (time != -1)
							{
								entry.setTarget(tag + " (" + (healers.get(identifier).timeToPoison()) + ")");
								target = Text.removeTags(entry.getTarget()).toLowerCase();
							}
						}

						if ((target.startsWith("poisoned meat ->") || target.startsWith("poisoned tofu ->") || target.startsWith("poisoned worms ->")))
						{
							// Poison should only be used on healers
							if (this.removeUnusedMenus && !target.contains("penance healer"))
							{
								continue;
							}
							else if (this.controlHealer && controlDown && identifier == lastHealerPoisoned && target.contains("penance healer"))
							{
								selected.add(entry);
								continue;
							}
						}
						else if (this.shiftOverstock && target.equals("healer item machine") && shiftDown)
						{
							if (option.contains(listen))
							{
								selected.add(entry);
								continue;
							}
						}
						else if (this.removeUnusedMenus)
						{
							// Vials that are empty should only be used on spring
							if (target.startsWith("healing vial ->") && !target.endsWith("healer spring"))
							{
								continue;
							}
							// Vials that are full should only be used on players
							else if (target.startsWith("healing vial(4) ->"))
							{
								Player[] players = client.getCachedPlayers();

								if (!(identifier >= 0 && identifier < players.length && players[identifier] != null))
								{
									continue;
								}
							}
							// Vials that are not full or empty can be used on either players or spring
							else if (target.startsWith("healing vial(") && target.contains("->"))
							{
								Player[] players = client.getCachedPlayers();

								if ((!(identifier >= 0 && identifier < players.length && players[identifier] != null))
									&& !target.endsWith("healer spring"))
								{
									continue;
								}
							}
						}
						break;
				}
			}

			menu.add(entry);
		}

		if (prioritizeWalk && walk != null)
		{
			menu.remove(walk);
			menu.add(walk);
		}

		if (!selected.isEmpty())
		{
			menu.addAll(selected);
		}

		if (!priority.isEmpty())
		{
			menu.addAll(priority);
		}

		client.setMenuEntries(menu.toArray(new MenuEntry[0]));
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!isInGame() && getRole() != null)
		{
			return;
		}

		String target = Text.removeTags(event.getTarget()).toLowerCase();

		if (getRole() == Role.HEALER && (target.startsWith("poisoned meat -> penance healer")
			|| target.startsWith("poisoned tofu -> penance healer")
			|| target.startsWith("poisoned worms -> penance healer")))
		{
			lastHealerPoisoned = event.getIdentifier();
			poisonUsed = StringUtils.substringBefore(target.replace("oned", "."), " ->");
		}

		// INW
		/*
		String option = Text.removeTags(event.getMenuOption());
		if (option.startsWith("Tell-"))
		{
			lastClickedTell = getRole().getCallFromTell(option);
		}
		else if (usingGloryHorn && option.equals("Call"))
		{

		}
		*/
	}

	// Interacting changed has a slight delay until after the hitsplat is applied
	private void onInteractingChanged(InteractingChanged event)
	{
		if (!isInGame() || getRole() != Role.HEALER)
		{
			return;
		}

		Actor source = event.getSource();

		if (source != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();

		if (opponent == null)
		{
			if (lastInteracted != -1 && StringUtils.equalsIgnoreCase(poisonUsed, getRole().getListen(client)) && healers.containsKey(lastInteracted))
			{
				Healer healer = healers.get(lastInteracted);
				healer.setFoodRemaining(healer.getFoodRemaining() - 1);
				healer.setTimeLastPoisoned(Instant.now());
			}

			lastInteracted = -1;
			poisonUsed = null;
		}
		else if (StringUtils.equals(opponent.getName(), "Penance Healer"))
		{
			lastInteracted = ((NPC)opponent).getIndex();
		}

	}

	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!isInGame())
		{
			return;
		}

		Actor target = event.getProjectile().getInteracting();
		if (target == null)
		{
			return;
		}

		String name = target.getName();
		if ("Penance Fighter".equals(name) || "Penance Ranger".equals(name))
		{
			projectiles.put(((NPC)target).getIndex(), event.getProjectile());
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		int newInGameBit = client.getVar(Varbits.IN_GAME_BA);

		if (inGameBit != newInGameBit)
		{
			if (newInGameBit == 0)
			{
				resetWave();
				callTimer = null;
				hornCalled = false;
				hornListened = false;
				lastListenText = null;
				lastCallText = null;
				lastCallColor = -1;
				// lastClickedTell = null;
			}
			else
			{
				wave = new Wave(client);
			}

			inGameBit = newInGameBit;
		}
	}

	private void resetWave()
	{
		inGame = false;
		menu.setHornUpdated(false);
		menu.setRebuildForced(false);
		removeTickTimer();
		removeAllDeathTimes(true);
		projectiles.clear();
		clearAllEggMaps();
		healers.clear();
		role = null;
		lastInteracted = -1;
		poisonUsed = null;
		lastHealerPoisoned = -1;
		tickNum = 0;
		showAllStyles();
		usingGloryHorn = false;
		menu.validateHiddenMenus(null);
	}

	private void startWave(Role role)
	{
		inGame = true;
		this.role = role;

		validateWidgets();
	}

	// Role widgets are not accurate if a player is using horn of glory
	private void validateGame()
	{
		Role role = null;

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory != null)
		{
			Collection<WidgetItem> items = inventory.getWidgetItems();

			for (WidgetItem item : items)
			{
				int id = item.getId();
				if (id == ItemID.COLLECTOR_HORN)
				{
					role = Role.COLLECTOR;
				}
				else if (id == ItemID.DEFENDER_HORN)
				{
					role = Role.DEFENDER;
				}
				else if (id == ItemID.ATTACKER_HORN || id == ItemID.ATTACKER_HORN_10517 || id == ItemID.ATTACKER_HORN_10518
					|| id == ItemID.ATTACKER_HORN_10519 || id == ItemID.ATTACKER_HORN_10520)
				{
					role = Role.ATTACKER;
				}
				else if (id == ItemID.HEALER_HORN || id == ItemID.HEALER_HORN_10527 || id == ItemID.HEALER_HORN_10528
					|| id == ItemID.HEALER_HORN_10529 || id == ItemID.HEALER_HORN_10530)
				{
					role = Role.HEALER;
				}
			}
		}

		if (role != null)
		{
			inGame = true;
			this.role = role;

			inGameBit = 1;

			usingGloryHorn = client.getWidget(role.getGloryListen()) != null;

			Widget stage = client.getWidget(role.getWave());

			if (stage != null)
			{
				this.stage = Integer.parseInt(StringUtils.substringAfter(stage.getText(), " "));
			}

			lastCallText = role.getCall(client);
			lastListenText = role.getListen(client);

			if (callTimer != null && callTimer.getElapsedTime() > 30)
			{
				callTimer = null;

			}

			// TODO getTickCount() does not work as expected
			// tickNum = (client.getTickCount() - gameTick) % 10;

			syncd = false;

			if (tickCounter != null)
			{
				tickCounter.setInSync(false);
			}

			// If the horn is currently called, or if the call timer is still in sync
			// the text will be updated to the last called color
			Widget callWidget = getRole() == null ? null : client.getWidget(getRole().getGloryCall());
			if (callWidget == null)
			{
				callWidget = getRole() == null ? null : client.getWidget(getRole().getCall());
			}

			int newCallColor = callWidget == null ? lastCallColor : callWidget.getTextColor();

			if (newCallColor == COLOR_CALL_CALLED)
			{
				lastCallColor = COLOR_CALL_CALLED;
				// lastClickedTell = lastCallText;
			}
			else if (callTimer == null)
			{
				lastCallColor = COLOR_CALL_UPDATED;
				// lastClickedTell = null;
			}

			if (callWidget != null)
			{
				callWidget.setTextColor(lastCallColor);
			}
		}
		else
		{
			inGameBit = 0;
		}

		validateWidgets();

		menu.enableSwaps();
		menu.validateHiddenMenus(getRole());
	}

	private void validateWidgets()
	{
		if (!this.showTimer)
		{
			showRoleSprite();
		}

		if (this.showDefTimer && getRole() == Role.DEFENDER)
		{
			addTickTimer();
		}
		else
		{
			removeTickTimer();
		}

		if (this.showDeathTimes
			&& (this.showDeathTimesMode == DeathTimesMode.INFO_BOX
			|| this.showDeathTimesMode == DeathTimesMode.BOTH))
		{
			addAllDeathTimes();
		}
		else
		{
			removeAllDeathTimes(false);
		}
	}

	private void showAllStyles()
	{
		for (WidgetInfo info : attackStyles)
		{
			Widget style = client.getWidget(info);
			if (style != null)
			{
				style.setHidden(false);
			}
		}
	}

	private void addTickTimer()
	{
		if (!isInGame() || tickCounter != null)
		{
			return;
		}

		tickCounter = new TimerBox(torsoImage, this, tickNum);

		tickCounter.setInSync(syncd);

		tickCounter.setTooltipEnabled(true);

		removeAllDeathTimes(false);

		infoBoxManager.addInfoBox(tickCounter);

		addAllDeathTimes();
	}

	private void removeTickTimer()
	{
		if (tickCounter != null)
		{
			infoBoxManager.removeInfoBox(tickCounter);
			tickCounter = null;
		}
	}

	private void addDeathTimes(TimerBox box)
	{
		if (!isInGame())
		{
			return;
		}

		deathTimes.add(box);

		if (this.showDeathTimes && (this.showDeathTimesMode == DeathTimesMode.INFO_BOX || this.showDeathTimesMode == DeathTimesMode.BOTH))
		{
			infoBoxManager.addInfoBox(box);
		}
	}

	private void addAllDeathTimes()
	{
		if (!isInGame())
		{
			return;
		}

		List<InfoBox> boxes = infoBoxManager.getInfoBoxes();

		for (TimerBox box : deathTimes)
		{
			if (!boxes.contains(box))
			{
				infoBoxManager.addInfoBox(box);
			}
		}
	}

	private void removeAllDeathTimes(boolean clear)
	{
		for (InfoBox box : infoBoxManager.getInfoBoxes().toArray(new InfoBox[0]))
		{
			if (box instanceof TimerBox && box.getImage() != torsoImage)
			{
				infoBoxManager.removeInfoBox(box);
			}
		}
		if (clear)
		{
			deathTimes.clear();
		}
	}

	private void showRoleSprite()
	{
		if (getRole() == null || !isInGame())
		{
			return;
		}

		Widget roleText = client.getWidget(role.getRoleText());
		Widget roleSprite = client.getWidget(role.getRoleSprite());

		if (roleSprite != null)
		{
			roleSprite.setHidden(false);
		}
		if (roleText != null)
		{
			roleText.setText(getRole().name());
		}
	}

	private AttackStyle[] getAttackStyles()
	{
		return WeaponType.getWeaponType(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE)).getAttackStyles();
	}

	private void announceWaveTime()
	{
		if (this.waveTimes && wave != null)
		{
			announceTime("Wave " + getStage() + " duration: ", wave.getWaveTimer().getElapsedTimeFormatted());
		}
	}

	private void announceGameTime()
	{
		if (this.waveTimes && gameTimer != null)
		{
			announceTime("Game finished, duration: ", gameTimer.getElapsedTimeFormatted());
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

	private void announce(final ChatMessageBuilder chatMessage)
	{
		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(chatMessage.build())
			.build());
	}

	long getTimeToChange()
	{
		return 30 - callTimer.getElapsedTime();
	}

	private void clearAllEggMaps()
	{
		redEggs.clear();
		greenEggs.clear();
		blueEggs.clear();
		yellowEggs.clear();
	}

	private Map<WorldPoint, Integer> getEggMap(int itemID)
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
		}

		return null;
	}

	private boolean isItemEgg(int itemId)
	{
		return itemId == ItemID.RED_EGG ||
			itemId == ItemID.GREEN_EGG ||
			itemId == ItemID.BLUE_EGG ||
			itemId == ItemID.YELLOW_EGG;
	}

	private boolean isAnyPrayerActive()
	{
		for (Prayer pray : Prayer.values())
		{
			if (client.isPrayerActive(pray))
			{
				return true;
			}
		}

		return false;
	}
}