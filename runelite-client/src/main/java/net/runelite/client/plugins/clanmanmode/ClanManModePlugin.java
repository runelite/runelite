package net.runelite.client.plugins.clanmanmode;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Clan Man Mode",
	description = "Assists in clan PVP scenarios",
	tags = {"highlight", "minimap", "overlay", "players"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
public class ClanManModePlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClanManModeConfig config;

	@Inject
	private ClanManModeOverlay ClanManModeOverlay;

	@Inject
	private ClanManModeTileOverlay ClanManModeTileOverlay;

	@Inject
	private ClanManModeMinimapOverlay ClanManModeMinimapOverlay;

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean highlightAttackable;
	@Getter(AccessLevel.PACKAGE)
	private Color getAttackableColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightAttacked;
	@Getter(AccessLevel.PACKAGE)
	private Color getClanAttackableColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawTiles;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawOverheadPlayerNames;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawMinimapNames;
	@Getter(AccessLevel.PACKAGE)
	private boolean showAttackers;
	@Getter(AccessLevel.PACKAGE)
	private Color getAttackerColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean ShowBold;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideAttackable;
	@Getter(AccessLevel.PACKAGE)
	private int hideTime;
	@Getter(AccessLevel.PACKAGE)
	private boolean CalcSelfCB;
	@Getter(AccessLevel.PACKAGE)
	private boolean PersistentClan;
	@Getter(AccessLevel.PACKAGE)
	private Color getClanMemberColor;

	@Provides
	ClanManModeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanManModeConfig.class);
	}

	int wildernessLevel;
	int clanmin;
	int clanmax;
	int inwildy;
	int ticks;
	final Map<String, Integer> clan = new HashMap<>();

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
		
		overlayManager.add(ClanManModeOverlay);
		overlayManager.add(ClanManModeTileOverlay);
		overlayManager.add(ClanManModeMinimapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(ClanManModeOverlay);
		overlayManager.remove(ClanManModeTileOverlay);
		overlayManager.remove(ClanManModeMinimapOverlay);
		clan.clear();
		ticks = 0;
		wildernessLevel = 0;
		clanmin = 0;
		clanmax = 0;
		inwildy = 0;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"clanmanmode".equals(event.getGroup()))
		{
			return;
		}
		
		updateConfig();
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN || gameStateChanged.getGameState() == GameState.HOPPING)
		{
			ticks = 0;
		}
	}

	private void onGameTick(GameTick event)
	{
		ticks++;
		final Player localPlayer = client.getLocalPlayer();
		if (!clan.containsKey(localPlayer.getName()))
		{
			clan.put(localPlayer.getName(), localPlayer.getCombatLevel());
		}
		WorldPoint a = localPlayer.getWorldLocation();
		int underLevel = ((a.getY() - 9920) / 8) + 1;
		int upperLevel = ((a.getY() - 3520) / 8) + 1;
		wildernessLevel = a.getY() > 6400 ? underLevel : upperLevel;
		inwildy = client.getVar(Varbits.IN_WILDERNESS);
		if (clan.size() > 0)
		{
			clanmin = Collections.min(clan.values());
			clanmax = Collections.max(clan.values());
		}
	}
	
	private void updateConfig()
	{
		this.highlightAttackable = config.highlightAttackable();
		this.getAttackableColor = config.getAttackableColor();
		this.highlightAttacked = config.highlightAttacked();
		this.getClanAttackableColor = config.getClanAttackableColor();
		this.drawTiles = config.drawTiles();
		this.drawOverheadPlayerNames = config.drawOverheadPlayerNames();
		this.drawMinimapNames = config.drawMinimapNames();
		this.showAttackers = config.showAttackers();
		this.getAttackerColor = config.getAttackerColor();
		this.ShowBold = config.ShowBold();
		this.hideAttackable = config.hideAttackable();
		this.hideTime = config.hideTime();
		this.CalcSelfCB = config.CalcSelfCB();
		this.PersistentClan = config.PersistentClan();
		this.getClanMemberColor = config.getClanMemberColor();
	}
}
