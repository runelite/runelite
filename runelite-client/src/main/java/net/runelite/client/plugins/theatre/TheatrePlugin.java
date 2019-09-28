/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.NpcDefinitionChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.theatre.rooms.BloatHandler;
import net.runelite.client.plugins.theatre.rooms.MaidenHandler;
import net.runelite.client.plugins.theatre.rooms.SotetsegHandler;
import net.runelite.client.plugins.theatre.rooms.VerzikHandler;
import net.runelite.client.plugins.theatre.rooms.nylocas.NyloHandler;
import net.runelite.client.plugins.theatre.rooms.xarpus.XarpusHandler;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Theatre of Blood",
	description = "All-in-one plugin for Theatre of Blood.",
	tags = {"ToB", "Theatre", "Theatre of Blood", "Lyzrd"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
@Slf4j
@Getter
public class TheatrePlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private EventBus eventBus;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private TheatreOverlay overlay;
	@Inject
	private TheatreConfig config;
	@Inject
	private MenuManager menuManager;
	@Inject
	private ItemManager itemManager;
	@Inject
	private ModelOutlineRenderer modelOutline;
	private BloatHandler bloatHandler;
	private MaidenHandler maidenHandler;
	private NyloHandler nyloHandler;
	private SotetsegHandler sotetsegHandler;
	@Setter(AccessLevel.PUBLIC)
	private TheatreRoom room;
	private VerzikHandler verzikHandler;
	private XarpusHandler xarpusHandler;
	private boolean BloatFeetIndicatorRaveEdition;
	private boolean extraTimers;
	private boolean highlightNyloAgros;
	private boolean p1attacks;
	private boolean p2attacks;
	private boolean p3attacks;
	private boolean showBloatHands;
	private boolean showBloatIndicator;
	private boolean showBloatTimer;
	private boolean showCrabTargets;
	private boolean showMaidenBloodSpawns;
	private boolean showMaidenBloodToss;
	private boolean showNylocasAmount;
	private boolean showNyloFreezeHighlights;
	private boolean showNyloPillarHealth;
	private boolean nylocasMenuSwap;
	private boolean showSotetsegAttacks;
	private boolean showSotetsegMaze;
	private boolean showSotetsegSolo;
	private boolean showVerzikAttacks;
	private boolean showVerzikYellows;
	private boolean showXarpusHeals;
	private boolean showXarpusTick;
	private boolean verzikRangeAttacks;
	private boolean VerzikTankTile;
	private Color mazeTileColour;
	private TheatreConfig.NYLOOPTION showNylocasExplosions;

	@Provides
	TheatreConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TheatreConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();
		room = TheatreRoom.UNKNOWN;
		maidenHandler = new MaidenHandler(client, this, modelOutline);
		bloatHandler = new BloatHandler(client, this);
		nyloHandler = new NyloHandler(client, this, menuManager, eventBus);
		sotetsegHandler = new SotetsegHandler(client, this);
		xarpusHandler = new XarpusHandler(client, this);
		verzikHandler = new VerzikHandler(client, this);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		maidenHandler.onStop();
		maidenHandler = null;
		bloatHandler.onStop();
		bloatHandler = null;
		nyloHandler.startTime = 0L;
		nyloHandler.onStop();
		nyloHandler = null;
		sotetsegHandler.onStop();
		sotetsegHandler = null;
		xarpusHandler.onStop();
		xarpusHandler = null;
		verzikHandler.onStop();
		verzikHandler = null;
		room = TheatreRoom.UNKNOWN;
		overlayManager.remove(overlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GroundObjectSpawned.class, this, this::onGroundObjectSpawned);
		eventBus.subscribe(NpcDefinitionChanged.class, this, this::onNpcDefinitionChanged);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(ProjectileMoved.class, this, this::onProjectileMoved);
		eventBus.subscribe(ProjectileSpawned.class, this, this::onProjectileSpawned);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (verzikHandler != null)
		{
			verzikHandler.onAnimationChanged(event);
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onChatMessage(event);
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("Theatre"))
		{
			return;
		}

		if (nyloHandler != null)
		{
			nyloHandler.onConfigChanged();
		}
	}

	private void onGameTick(GameTick event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onGameTick();
		}

		if (bloatHandler != null)
		{
			bloatHandler.onGameTick();
		}

		if (nyloHandler != null)
		{
			nyloHandler.onGameTick();
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onGameTick();
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onGameTick();
		}

		if (verzikHandler != null)
		{
			verzikHandler.onGameTick();
		}
	}

	private void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		if (sotetsegHandler != null)
		{
			sotetsegHandler.onGroundObjectSpawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onGroundObjectSpawned(event);
		}
	}

	private void onNpcDefinitionChanged(NpcDefinitionChanged event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcDefinitionChanged(event);
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcDespawned(event);
		}

		if (bloatHandler != null)
		{
			bloatHandler.onNpcDespawned(event);
		}

		if (nyloHandler != null)
		{
			nyloHandler.onNpcDespawned(event);
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onNpcDespawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onNpcDespawned(event);
		}

	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcSpawned(event);
		}

		if (bloatHandler != null)
		{
			bloatHandler.onNpcSpawned(event);
		}

		if (nyloHandler != null)
		{
			nyloHandler.onNpcSpawned(event);
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onNpcSpawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onNpcSpawned(event);
		}

		if (verzikHandler != null)
		{
			verzikHandler.onNpcSpawned(event);
		}

	}

	private void onProjectileMoved(ProjectileMoved event)
	{
		if (verzikHandler != null)
		{
			verzikHandler.onProjectileMoved(event);
		}
	}

	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (sotetsegHandler != null)
		{
			sotetsegHandler.onProjectileSpawned(event);

		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onSpotAnimationChanged(event);
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (bloatHandler != null)
		{
			bloatHandler.onVarbitChanged(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onVarbitChanged(event);
		}
	}

	private void updateConfig()
	{
		this.showMaidenBloodToss = config.showMaidenBloodToss();
		this.showMaidenBloodSpawns = config.showMaidenBloodSpawns();
		this.showNyloFreezeHighlights = config.showNyloFreezeHighlights();
		this.showBloatIndicator = config.showBloatIndicator();
		this.showBloatHands = config.showBloatHands();
		this.BloatFeetIndicatorRaveEdition = config.BloatFeetIndicatorRaveEdition();
		this.showBloatTimer = config.showBloatTimer();
		this.showNyloPillarHealth = config.showNyloPillarHealth();
		this.nylocasMenuSwap = config.nylocasMenuSwap();
		this.showNylocasExplosions = config.showNylocasExplosions();
		this.showNylocasAmount = config.showNylocasAmount();
		this.highlightNyloAgros = config.highlightNyloAgros();
		this.showSotetsegAttacks = config.showSotetsegAttacks();
		this.showSotetsegMaze = config.showSotetsegMaze();
		this.showSotetsegSolo = config.showSotetsegSolo();
		this.mazeTileColour = config.mazeTileColour();
		this.showXarpusHeals = config.showXarpusHeals();
		this.showXarpusTick = config.showXarpusTick();
		this.showVerzikAttacks = config.showVerzikAttacks();
		this.showVerzikYellows = config.showVerzikYellows();
		this.showCrabTargets = config.showCrabTargets();
		this.VerzikTankTile = config.VerzikTankTile();
		this.verzikRangeAttacks = config.verzikRangeAttacks();
		this.extraTimers = config.extraTimers();
		this.p1attacks = config.p1attacks();
		this.p2attacks = config.p2attacks();
		this.p3attacks = config.p3attacks();
	}
}