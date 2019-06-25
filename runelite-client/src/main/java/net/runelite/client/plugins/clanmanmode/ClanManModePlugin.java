package net.runelite.client.plugins.clanmanmode;

import com.google.inject.Provides;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
	Map<String, Integer> clan = new HashMap<>();

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(ClanManModeOverlay);
		overlayManager.add(ClanManModeTileOverlay);
		overlayManager.add(ClanManModeMinimapOverlay);
		client.setHideFriendAttackOptions(config.hideAtkOpt());
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(ClanManModeOverlay);
		overlayManager.remove(ClanManModeTileOverlay);
		overlayManager.remove(ClanManModeMinimapOverlay);
		client.setHideFriendAttackOptions(false);
		clan.clear();
		ticks = 0;
		wildernessLevel = 0;
		clanmin = 0;
		clanmax = 0;
		inwildy = 0;
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!"clanmanmode".equals(event.getGroup()))
		{
			return;
		}

		client.setHideFriendAttackOptions(config.hideAtkOpt());
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN || gameStateChanged.getGameState() == GameState.HOPPING)
		{
			ticks = 0;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
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
}
