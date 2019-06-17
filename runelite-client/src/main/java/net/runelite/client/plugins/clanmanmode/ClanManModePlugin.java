package net.runelite.client.plugins.clanmanmode;

import com.google.inject.Provides;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Clan Man Mode",
	description = "Assists in clan PVP scenarios",
	tags = {"highlight", "minimap", "overlay", "players"},
	type = PluginType.PVP,
	enabledByDefault = false
)

public class ClanManModePlugin extends Plugin
{

	private static final String WALK_HERE = "WALK HERE";
	private static final String CANCEL = "CANCEL";

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
	private ClanManager clanManager;

	private static final String CAST = "CAST";
	private static final String ATTACK_OPTIONS_ATTACK = "ATTACK";
	public static final HashSet<String> ATTACK_OPTIONS_KEYWORDS = new HashSet<>();
		static
		{
			ATTACK_OPTIONS_KEYWORDS.add(CAST);
			ATTACK_OPTIONS_KEYWORDS.add(ATTACK_OPTIONS_ATTACK);
		}

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
	}

	@Override
	protected void shutDown() throws Exception
	{
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

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		
		Player[] players = client.getCachedPlayers();
		Player player = null;
		int identifier = event.getIdentifier();

		if (identifier >= 0 && identifier < players.length)
		{
			player = players[identifier];
		}

		if (player == null)
		{
			return;
		}

		final String pOptionToReplace = Text.removeTags(event.getOption()).toUpperCase();

		//If the option is already to walk there, or cancel we don't need to swap it with anything
		if (pOptionToReplace.equals(CANCEL) || pOptionToReplace.equals(WALK_HERE))
		{
			return;
		}

		if (config.hideAtkOpt()
				&& ATTACK_OPTIONS_KEYWORDS.contains(pOptionToReplace)
				&&  (player.isFriend() || player.isClanMember()))
		{
			swap(pOptionToReplace);
		}
		else if (!config.hideAtkOpt())
		{
			return;
		}

		final String option = Text.removeTags(event.getOption()).toLowerCase();

		if (option.equals("attack"))
		{
			final Pattern ppattern = Pattern.compile("<col=ffffff>(.+?)<col=");
			final Matcher pmatch = ppattern.matcher(event.getTarget());

			if (pmatch.find() && pmatch.matches())
			{
				if (pmatch.group(1) != null)
				{
					if (clan.containsKey(pmatch.group(1).replace(" ", " ")))
					{
						MenuEntry[] entries = client.getMenuEntries();
						entries = ArrayUtils.removeElement(entries, entries[entries.length - 1]);
						client.setMenuEntries(entries);
					}
				}
			}
		}
	}

	/**
	 * Swaps menu entries if the entries could be found. This places Walk Here where the top level menu option was.
	 * @param pOptionToReplace The String containing the Menu Option that needs to be replaced. IE: "Attack", "Chop Down".
	 */
	private void swap(String pOptionToReplace)
	{
		MenuEntry[] entries = client.getMenuEntries();
		Integer walkHereEntry = searchIndex(entries, WALK_HERE);
		Integer entryToReplace = searchIndex(entries, pOptionToReplace);

		if (walkHereEntry != null
				&& entryToReplace != null)
		{
			MenuEntry walkHereMenuEntry = entries[walkHereEntry];
			entries[walkHereEntry] = entries[entryToReplace];
			entries[entryToReplace] = walkHereMenuEntry;
			client.setMenuEntries(entries);
		}
	}

	/**
	 * Finds the index of the menu that contains the verbiage we are looking for.
	 * @param pMenuEntries The list of {@link MenuEntry}s.
	 * @param pMenuEntryToSearchFor The Option in the menu to search for.
	 * @return The index location or null if it was not found.
	 */
	private Integer searchIndex(MenuEntry[] pMenuEntries, String pMenuEntryToSearchFor)
	{
		Integer indexLocation = 0;

		for (MenuEntry menuEntry : pMenuEntries)
		{
			String entryOption = Text.removeTags(menuEntry.getOption()).toUpperCase();

			if (entryOption.equals(pMenuEntryToSearchFor))
			{
				return indexLocation;
			}
			indexLocation++;
		}
		return null;
	}
}
