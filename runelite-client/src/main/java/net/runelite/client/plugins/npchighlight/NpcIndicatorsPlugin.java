/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.npchighlight;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.inject.Provides;
import java.applet.Applet;
import java.awt.Color;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GraphicID;
import net.runelite.api.GraphicsObject;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.NpcUtil;
import net.runelite.client.game.npcoverlay.HighlightedNpc;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatcher;

@PluginDescriptor(
	name = "NPC Indicators",
	description = "Highlight NPCs on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "npcs", "overlay", "respawn", "tags"}
)
@Slf4j
public class NpcIndicatorsPlugin extends Plugin
{
	private static final int MAX_ACTOR_VIEW_RANGE = 15;

	// Option added to NPC menu
	private static final String TAG = "Tag";
	private static final String UNTAG = "Un-tag";

	private static final String TAG_ALL = "Tag-All";
	private static final String UNTAG_ALL = "Un-tag-All";

	private static final String STYLE_HULL = "hull";
	private static final String STYLE_TILE = "tile";
	private static final String STYLE_TRUE_TILE = "truetile";
	private static final String STYLE_SW_TILE = "swtile";
	private static final String STYLE_SW_TRUE_TILE = "swtruetile";
	private static final String STYLE_OUTLINE = "outline";

	@Inject
	private Client client;

	@Inject
	private NpcIndicatorsConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private NpcRespawnOverlay npcRespawnOverlay;

	@Inject
	private ClientThread clientThread;

	@Inject
	private NpcOverlayService npcOverlayService;

	@Inject
	private NpcUtil npcUtil;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ColorPickerManager colorPickerManager;

	/**
	 * NPCs to highlight
	 */
	@Getter(AccessLevel.PACKAGE)
	private final Map<NPC, HighlightedNpc> highlightedNpcs = new HashMap<>();

	/**
	 * Dead NPCs that should be displayed with a respawn indicator if the config is on.
	 */
	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, MemorizedNpc> deadNpcsToDisplay = new HashMap<>();

	/**
	 * The time when the last game tick event ran.
	 */
	@Getter(AccessLevel.PACKAGE)
	private Instant lastTickUpdate;

	/**
	 * Tagged NPCs that have died at some point, which are memorized to
	 * remember when and where they will respawn
	 */
	private final Map<Integer, MemorizedNpc> memorizedNpcs = new HashMap<>();

	/**
	 * Highlight strings from the configuration
	 */
	private List<String> highlights = new ArrayList<>();

	/**
	 * NPC ids marked with the Tag option
	 */
	private final Set<Integer> npcTags = new HashSet<>();

	/**
	 * Tagged NPCs that spawned this tick, which need to be verified that
	 * they actually spawned and didn't just walk into view range.
	 */
	private final List<NPC> spawnedNpcsThisTick = new ArrayList<>();

	/**
	 * Tagged NPCs that despawned this tick, which need to be verified that
	 * they actually spawned and didn't just walk into view range.
	 */
	private final List<NPC> despawnedNpcsThisTick = new ArrayList<>();

	/**
	 * World locations of graphics object which indicate that an
	 * NPC teleported that were played this tick.
	 */
	private final Set<WorldPoint> teleportGraphicsObjectSpawnedThisTick = new HashSet<>();

	/**
	 * The players location on the last game tick.
	 */
	private WorldPoint lastPlayerLocation;

	/**
	 * When hopping worlds, NPCs can spawn without them actually respawning,
	 * so we would not want to mark it as a real spawn in those cases.
	 */
	private boolean skipNextSpawnCheck = false;

	private final Function<NPC, HighlightedNpc> isHighlighted = highlightedNpcs::get;

	@Provides
	NpcIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		npcOverlayService.registerHighlighter(isHighlighted);
		overlayManager.add(npcRespawnOverlay);
		clientThread.invoke(() ->
		{
			skipNextSpawnCheck = true;
			rebuild();
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		npcOverlayService.unregisterHighlighter(isHighlighted);
		overlayManager.remove(npcRespawnOverlay);
		clientThread.invoke(() ->
		{
			deadNpcsToDisplay.clear();
			memorizedNpcs.clear();
			spawnedNpcsThisTick.clear();
			despawnedNpcsThisTick.clear();
			teleportGraphicsObjectSpawnedThisTick.clear();
			npcTags.clear();
			highlightedNpcs.clear();
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING)
		{
			highlightedNpcs.clear();
			deadNpcsToDisplay.clear();
			memorizedNpcs.forEach((id, npc) -> npc.setDiedOnTick(-1));
			lastPlayerLocation = null;
			skipNextSpawnCheck = true;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals(NpcIndicatorsConfig.GROUP))
		{
			return;
		}

		clientThread.invoke(this::rebuild);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final MenuEntry menuEntry = event.getMenuEntry();
		final MenuAction menuAction = menuEntry.getType();
		final NPC npc = menuEntry.getNpc();

		if (npc == null)
		{
			return;
		}

		if (menuAction == MenuAction.EXAMINE_NPC && client.isKeyPressed(KeyCode.KC_SHIFT))
		{
			// Add tag and tag-all options
			if (npc.getName() == null)
			{
				return;
			}

			final String npcName = npc.getName();
			final boolean nameMatch = highlights.stream().anyMatch(npcName::equalsIgnoreCase);
			final boolean idMatch = npcTags.contains(npc.getIndex());
			final boolean wildcardMatch = highlights.stream()
				.filter(highlight -> !highlight.equalsIgnoreCase(npcName))
				.anyMatch(highlight -> WildcardMatcher.matches(highlight, npcName));
			int idx = -1;

			client.createMenuEntry(idx--)
				.setOption(idMatch ? UNTAG : TAG)
				.setTarget(event.getTarget())
				.setIdentifier(event.getIdentifier())
				.setType(MenuAction.RUNELITE)
				.onClick(this::tag);

			// Only add Untag-All option to npcs not highlighted by a wildcard entry, because untag-all will not remove wildcards
			if (!wildcardMatch)
			{
				client.createMenuEntry(idx--)
					.setOption(nameMatch ? UNTAG_ALL : TAG_ALL)
					.setTarget(event.getTarget())
					.setIdentifier(event.getIdentifier())
					.setType(MenuAction.RUNELITE)
					.onClick(this::tag);
			}

			// Add tag options only if the npc is currently tagged
			if (idMatch || nameMatch || wildcardMatch)
			{
				idx = createTagColorMenu(idx, event.getTarget(), npc);
				idx = createTagStyleMenu(idx, event.getTarget(), npc);
			}
		}
		else
		{
			Color color = null;
			if (npcUtil.isDying(npc))
			{
				color = config.deadNpcMenuColor();
			}

			if (color == null && highlightedNpcs.containsKey(npc) && config.highlightMenuNames() && (!npcUtil.isDying(npc) || !config.ignoreDeadNpcs()))
			{
				color = MoreObjects.firstNonNull(getNpcHighlightColor(npc.getId()), config.highlightColor());
			}

			if (color != null)
			{
				final String target = ColorUtil.prependColorTag(Text.removeTags(event.getTarget()), color);
				menuEntry.setTarget(target);
			}
		}
	}

	private int createTagColorMenu(int idx, String target, NPC npc)
	{
		List<Color> colors = getUsedColors();
		// add a few default colors
		for (Color default_ : new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA})
		{
			if (colors.size() < 5 && !colors.contains(default_))
			{
				colors.add(default_);
			}
		}

		MenuEntry parent = client.createMenuEntry(idx--)
			.setOption("Tag color")
			.setTarget(target)
			.setType(MenuAction.RUNELITE_SUBMENU);

		for (final Color c : colors)
		{
			client.createMenuEntry(idx--)
				.setOption(ColorUtil.prependColorTag("Set color", c))
				.setType(MenuAction.RUNELITE)
				.setParent(parent)
				.onClick(e ->
				{
					setNpcHighlightColor(npc.getId(), c);
					clientThread.invokeLater(this::rebuild);
				});
		}

		client.createMenuEntry(idx--)
			.setOption("Pick color")
			.setType(MenuAction.RUNELITE)
			.setParent(parent)
			.onClick(e -> SwingUtilities.invokeLater(() ->
			{
				RuneliteColorPicker colorPicker = colorPickerManager.create(SwingUtilities.windowForComponent((Applet) client),
					Color.WHITE, "Tag Color", false);
				colorPicker.setOnClose(c ->
				{
					setNpcHighlightColor(npc.getId(), c);
					clientThread.invokeLater(this::rebuild);
				});
				colorPicker.setVisible(true);
			}));

		if (getNpcHighlightColor(npc.getId()) != null)
		{
			client.createMenuEntry(idx--)
				.setOption("Reset")
				.setType(MenuAction.RUNELITE)
				.setParent(parent)
				.onClick(e ->
				{
					unsetNpcHighlightColor(npc.getId());
					clientThread.invokeLater(this::rebuild);
				});
		}

		return idx;
	}

	private int createTagStyleMenu(int idx, String target, NPC npc)
	{
		MenuEntry parent = client.createMenuEntry(idx--)
			.setOption("Tag style")
			.setTarget(target)
			.setType(MenuAction.RUNELITE_SUBMENU);

		String[] names = {"Hull", "Tile", "True tile", "South-west tile", "South-west true tile", "Outline"};
		String[] styles = {STYLE_HULL, STYLE_TILE, STYLE_TRUE_TILE, STYLE_SW_TILE, STYLE_SW_TRUE_TILE, STYLE_OUTLINE};
		assert names.length == styles.length;
		for (int i = 0; i < names.length; ++i)
		{
			final String style = styles[i];
			client.createMenuEntry(idx--)
				.setOption(names[i])
				.setType(MenuAction.RUNELITE)
				.setParent(parent)
				.onClick(e ->
				{
					setNpcTagStyle(npc.getId(), style);
					clientThread.invokeLater(this::rebuild);
				});
		}

		if (getNpcTagStyle(npc.getId()) != null)
		{
			client.createMenuEntry(idx--)
				.setOption("Reset")
				.setType(MenuAction.RUNELITE)
				.setParent(parent)
				.onClick(e ->
				{
					unsetNpcTagStyle(npc.getId());
					clientThread.invokeLater(this::rebuild);
				});
		}

		return idx;
	}

	private void tag(MenuEntry entry)
	{
		final int id = entry.getIdentifier();
		final NPC[] cachedNPCs = client.getCachedNPCs();
		final NPC npc = cachedNPCs[id];

		if (npc == null || npc.getName() == null)
		{
			return;
		}

		if (entry.getOption().equals(TAG) || entry.getOption().equals(UNTAG))
		{
			final boolean removed = npcTags.remove(id);

			if (removed)
			{
				if (!highlightMatchesNPCName(npc.getName()))
				{
					highlightedNpcs.remove(npc);
					memorizedNpcs.remove(npc.getIndex());
				}
			}
			else
			{
				if (!client.isInInstancedRegion())
				{
					memorizeNpc(npc);
					npcTags.add(id);
				}
				highlightedNpcs.put(npc, highlightedNpc(npc));
			}

			npcOverlayService.rebuild();
		}
		else
		{
			final String name = npc.getName();
			final List<String> highlightedNpcs = new ArrayList<>(highlights);

			if (!highlightedNpcs.removeIf(name::equalsIgnoreCase))
			{
				highlightedNpcs.add(name);
			}

			// this trips a config change which triggers the overlay rebuild
			config.setNpcToHighlight(Text.toCSV(highlightedNpcs));
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();
		final String npcName = npc.getName();

		if (npcName == null)
		{
			return;
		}

		if (npcTags.contains(npc.getIndex()))
		{
			memorizeNpc(npc);
			highlightedNpcs.put(npc, highlightedNpc(npc));
			spawnedNpcsThisTick.add(npc);
			return;
		}

		if (highlightMatchesNPCName(npcName))
		{
			highlightedNpcs.put(npc, highlightedNpc(npc));
			if (!client.isInInstancedRegion())
			{
				memorizeNpc(npc);
				spawnedNpcsThisTick.add(npc);
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();

		if (memorizedNpcs.containsKey(npc.getIndex()))
		{
			despawnedNpcsThisTick.add(npc);
		}

		highlightedNpcs.remove(npc);
	}

	@Subscribe
	public void onNpcChanged(NpcChanged event)
	{
		final NPC npc = event.getNpc();
		final String npcName = npc.getName();

		highlightedNpcs.remove(npc);

		if (npcName == null)
		{
			return;
		}

		if (npcTags.contains(npc.getIndex())
			|| highlightMatchesNPCName(npcName))
		{
			highlightedNpcs.put(npc, highlightedNpc(npc));
		}
	}

	@Subscribe
	public void onGraphicsObjectCreated(GraphicsObjectCreated event)
	{
		final GraphicsObject go = event.getGraphicsObject();

		if (go.getId() == GraphicID.GREY_BUBBLE_TELEPORT)
		{
			teleportGraphicsObjectSpawnedThisTick.add(WorldPoint.fromLocal(client, go.getLocation()));
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		removeOldHighlightedRespawns();
		validateSpawnedNpcs();
		lastTickUpdate = Instant.now();
		lastPlayerLocation = client.getLocalPlayer().getWorldLocation();
	}

	private static boolean isInViewRange(WorldPoint wp1, WorldPoint wp2)
	{
		int distance = wp1.distanceTo(wp2);
		return distance < MAX_ACTOR_VIEW_RANGE;
	}

	private static WorldPoint getWorldLocationBehind(NPC npc)
	{
		final int orientation = npc.getOrientation() / 256;
		int dx = 0, dy = 0;

		switch (orientation)
		{
			case 0: // South
				dy = -1;
				break;
			case 1: // Southwest
				dx = -1;
				dy = -1;
				break;
			case 2: // West
				dx = -1;
				break;
			case 3: // Northwest
				dx = -1;
				dy = 1;
				break;
			case 4: // North
				dy = 1;
				break;
			case 5: // Northeast
				dx = 1;
				dy = 1;
				break;
			case 6: // East
				dx = 1;
				break;
			case 7: // Southeast
				dx = 1;
				dy = -1;
				break;
		}

		final WorldPoint currWP = npc.getWorldLocation();
		return new WorldPoint(currWP.getX() - dx, currWP.getY() - dy, currWP.getPlane());
	}

	private void memorizeNpc(NPC npc)
	{
		final int npcIndex = npc.getIndex();
		memorizedNpcs.putIfAbsent(npcIndex, new MemorizedNpc(npc));
	}

	private void removeOldHighlightedRespawns()
	{
		deadNpcsToDisplay.values().removeIf(x -> x.getDiedOnTick() + x.getRespawnTime() <= client.getTickCount() + 1);
	}

	@VisibleForTesting
	List<String> getHighlights()
	{
		final String configNpcs = config.getNpcToHighlight();

		if (configNpcs.isEmpty())
		{
			return Collections.emptyList();
		}

		return Text.fromCSV(configNpcs);
	}

	void rebuild()
	{
		highlights = getHighlights();
		highlightedNpcs.clear();

		if (client.getGameState() != GameState.LOGGED_IN &&
			client.getGameState() != GameState.LOADING)
		{
			// NPCs are still in the client after logging out,
			// but we don't want to highlight those.
			return;
		}

		for (NPC npc : client.getNpcs())
		{
			final String npcName = npc.getName();

			if (npcName == null)
			{
				continue;
			}

			if (npcTags.contains(npc.getIndex()))
			{
				highlightedNpcs.put(npc, highlightedNpc(npc));
				continue;
			}

			if (highlightMatchesNPCName(npcName))
			{
				if (!client.isInInstancedRegion())
				{
					memorizeNpc(npc);
				}
				highlightedNpcs.put(npc, highlightedNpc(npc));
				continue;
			}

			// NPC is not highlighted
			memorizedNpcs.remove(npc.getIndex());
		}

		npcOverlayService.rebuild();
	}

	private boolean highlightMatchesNPCName(String npcName)
	{
		for (String highlight : highlights)
		{
			if (WildcardMatcher.matches(highlight, npcName))
			{
				return true;
			}
		}

		return false;
	}

	private void validateSpawnedNpcs()
	{
		if (skipNextSpawnCheck)
		{
			skipNextSpawnCheck = false;
		}
		else
		{
			for (NPC npc : despawnedNpcsThisTick)
			{
				if (!teleportGraphicsObjectSpawnedThisTick.isEmpty())
				{
					if (teleportGraphicsObjectSpawnedThisTick.contains(npc.getWorldLocation()))
					{
						// NPC teleported away, so we don't want to add the respawn timer
						continue;
					}
				}

				if (isInViewRange(client.getLocalPlayer().getWorldLocation(), npc.getWorldLocation()))
				{
					final MemorizedNpc mn = memorizedNpcs.get(npc.getIndex());

					if (mn != null)
					{
						mn.setDiedOnTick(client.getTickCount() + 1); // This runs before tickCounter updates, so we add 1

						if (!mn.getPossibleRespawnLocations().isEmpty())
						{
							log.debug("Starting {} tick countdown for {}", mn.getRespawnTime(), mn.getNpcName());
							deadNpcsToDisplay.put(mn.getNpcIndex(), mn);
						}
					}
				}
			}

			for (NPC npc : spawnedNpcsThisTick)
			{
				if (!teleportGraphicsObjectSpawnedThisTick.isEmpty())
				{
					if (teleportGraphicsObjectSpawnedThisTick.contains(npc.getWorldLocation()) ||
						teleportGraphicsObjectSpawnedThisTick.contains(getWorldLocationBehind(npc)))
					{
						// NPC teleported here, so we don't want to update the respawn timer
						continue;
					}
				}

				if (lastPlayerLocation != null && isInViewRange(lastPlayerLocation, npc.getWorldLocation()))
				{
					final MemorizedNpc mn = memorizedNpcs.get(npc.getIndex());

					if (mn.getDiedOnTick() != -1)
					{
						final int respawnTime = client.getTickCount() + 1 - mn.getDiedOnTick();

						// By killing a monster and leaving the area before seeing it again, an erroneously lengthy
						// respawn time can be recorded. Thus, if the respawn time is already set and is greater than
						// the observed time, assume that the lower observed respawn time is correct.
						if (mn.getRespawnTime() == -1 || respawnTime < mn.getRespawnTime())
						{
							mn.setRespawnTime(respawnTime);
						}

						mn.setDiedOnTick(-1);
					}

					final WorldPoint npcLocation = npc.getWorldLocation();

					// An NPC can move in the same tick as it spawns, so we also have
					// to consider whatever tile is behind the npc
					final WorldPoint possibleOtherNpcLocation = getWorldLocationBehind(npc);

					mn.getPossibleRespawnLocations().removeIf(x ->
						!x.equals(npcLocation) && !x.equals(possibleOtherNpcLocation));

					if (mn.getPossibleRespawnLocations().isEmpty())
					{
						mn.getPossibleRespawnLocations().add(npcLocation);
						mn.getPossibleRespawnLocations().add(possibleOtherNpcLocation);
					}
				}
			}
		}

		spawnedNpcsThisTick.clear();
		despawnedNpcsThisTick.clear();
		teleportGraphicsObjectSpawnedThisTick.clear();
	}

	private HighlightedNpc highlightedNpc(NPC npc)
	{
		final int npcId = npc.getId();

		final String style = getNpcTagStyle(npcId);
		final boolean hull, tile, trueTile, swTile, swTrueTile, outline;
		// if set, value from config overrides global config
		if (style != null)
		{
			hull = STYLE_HULL.equals(style);
			tile = STYLE_TILE.equals(style);
			trueTile = STYLE_TRUE_TILE.equals(style);
			swTile = STYLE_SW_TILE.equals(style);
			swTrueTile = STYLE_SW_TRUE_TILE.equals(style);
			outline = STYLE_OUTLINE.equals(style);
		}
		else
		{
			hull = config.highlightHull();
			tile = config.highlightTile();
			trueTile = config.highlightTrueTile();
			swTile = config.highlightSouthWestTile();
			swTrueTile = config.highlightSouthWestTrueTile();
			outline = config.highlightOutline();
		}

		return HighlightedNpc.builder()
			.npc(npc)
			.highlightColor(MoreObjects.firstNonNull(getNpcHighlightColor(npcId), config.highlightColor()))
			.fillColor(config.fillColor())
			.hull(hull)
			.tile(tile)
			.trueTile(trueTile)
			.swTile(swTile)
			.swTrueTile(swTrueTile)
			.outline(outline)
			.name(config.drawNames())
			.nameOnMinimap(config.drawMinimapNames())
			.borderWidth((float) config.borderWidth())
			.outlineFeather(config.outlineFeather())
			.render(this::render)
			.build();
	}

	private boolean render(NPC n)
	{
		if (npcUtil.isDying(n) && config.ignoreDeadNpcs())
		{
			return false;
		}

		final NPCComposition c = n.getTransformedComposition();
		if (c != null && c.isFollower() && config.ignorePets())
		{
			return false;
		}

		return true;
	}

	private void setNpcHighlightColor(int npcId, Color color)
	{
		configManager.setConfiguration(NpcIndicatorsConfig.GROUP, "highlightcolor_" + npcId, color);
	}

	private void unsetNpcHighlightColor(int npcId)
	{
		configManager.unsetConfiguration(NpcIndicatorsConfig.GROUP, "highlightcolor_" + npcId);
	}

	private Color getNpcHighlightColor(int npcId)
	{
		return configManager.getConfiguration(NpcIndicatorsConfig.GROUP, "highlightcolor_" + npcId, Color.class);
	}

	private void setNpcTagStyle(int npcId, String style)
	{
		configManager.setConfiguration(NpcIndicatorsConfig.GROUP, "tagstyle_" + npcId, style);
	}

	private void unsetNpcTagStyle(int npcId)
	{
		configManager.unsetConfiguration(NpcIndicatorsConfig.GROUP, "tagstyle_" + npcId);
	}

	private String getNpcTagStyle(int npcId)
	{
		return configManager.getConfiguration(NpcIndicatorsConfig.GROUP, "tagstyle_" + npcId);
	}

	/**
	 * get some of the in-use colors from nearby npcs to prepopulate the menu
	 */
	private List<Color> getUsedColors()
	{
		List<Color> colors = new ArrayList<>();
		for (NPC npc : client.getNpcs())
		{
			Color c = getNpcHighlightColor(npc.getId());
			if (c != null && !colors.contains(c))
			{
				colors.add(c);
				if (colors.size() >= 5)
				{
					break;
				}
			}
		}
		return colors;
	}
}
