/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls;

import com.google.common.base.MoreObjects;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Named;
import joptsimple.internal.Strings;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Point;
import net.runelite.api.Scene;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cluescrolls.clues.AnagramClue;
import net.runelite.client.plugins.cluescrolls.clues.BeginnerMapClue;
import net.runelite.client.plugins.cluescrolls.clues.CipherClue;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.CoordinateClue;
import net.runelite.client.plugins.cluescrolls.clues.CrypticClue;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.plugins.cluescrolls.clues.FairyRingClue;
import net.runelite.client.plugins.cluescrolls.clues.FaloTheBardClue;
import net.runelite.client.plugins.cluescrolls.clues.HotColdClue;
import net.runelite.client.plugins.cluescrolls.clues.LocationClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.LocationsClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.MapClue;
import net.runelite.client.plugins.cluescrolls.clues.MusicClue;
import net.runelite.client.plugins.cluescrolls.clues.NpcClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.ObjectClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.SkillChallengeClue;
import net.runelite.client.plugins.cluescrolls.clues.TextClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.ThreeStepCrypticClue;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Clue Scroll",
	description = "Show answers to clue scroll riddles, anagrams, ciphers, and cryptic clues",
	tags = {"arrow", "hints", "world", "map", "coordinates", "emotes"}
)
@Slf4j
public class ClueScrollPlugin extends Plugin
{
	private static final Color HIGHLIGHT_BORDER_COLOR = Color.ORANGE;
	private static final Color HIGHLIGHT_HOVER_BORDER_COLOR = HIGHLIGHT_BORDER_COLOR.darker();
	private static final Color HIGHLIGHT_FILL_COLOR = new Color(0, 255, 0, 20);
	private static final int[] REGION_MIRRORS = {
		// Prifddinas
		12894, 8755,
		12895, 8756,
		13150, 9011,
		13151, 9012
	};

	@Getter
	private ClueScroll clue;

	@Getter
	private final List<NPC> npcsToMark = new ArrayList<>();

	@Getter
	private final List<TileObject> objectsToMark = new ArrayList<>();

	@Getter
	private Item[] equippedItems;

	@Getter
	private Item[] inventoryItems;

	@Inject
	@Getter
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClueScrollOverlay clueScrollOverlay;

	@Inject
	private ClueScrollEmoteOverlay clueScrollEmoteOverlay;

	@Inject
	private ClueScrollMusicOverlay clueScrollMusicOverlay;

	@Inject
	private ClueScrollWorldOverlay clueScrollWorldOverlay;

	@Inject
	private ClueScrollConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	private BufferedImage emoteImage;
	private BufferedImage mapArrow;
	private Integer clueItemId;
	private boolean worldMapPointsSet = false;

	private final TextComponent textComponent = new TextComponent();

	@Provides
	ClueScrollConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClueScrollConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ClueScrollService.class).to(ClueScrollServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(clueScrollOverlay);
		overlayManager.add(clueScrollEmoteOverlay);
		overlayManager.add(clueScrollWorldOverlay);
		overlayManager.add(clueScrollMusicOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(clueScrollOverlay);
		overlayManager.remove(clueScrollEmoteOverlay);
		overlayManager.remove(clueScrollWorldOverlay);
		overlayManager.remove(clueScrollMusicOverlay);
		npcsToMark.clear();
		inventoryItems = null;
		equippedItems = null;
		resetClue(true);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		if (clue instanceof HotColdClue)
		{
			if (((HotColdClue) clue).update(event.getMessage(), this))
			{
				worldMapPointsSet = false;
			}
		}

		if (clue instanceof SkillChallengeClue)
		{
			String text = Text.removeTags(event.getMessage());
			if (text.equals("Skill challenge completed.") ||
				text.equals("You have completed your master level challenge!") ||
				text.startsWith("You have completed Charlie's task,") ||
				text.equals("You have completed this challenge scroll."))
			{
				((SkillChallengeClue) clue).setChallengeCompleted(true);
			}
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals("Reset")
			&& overlayMenuClicked.getOverlay() == clueScrollOverlay)
		{
			resetClue(true);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(final MenuOptionClicked event)
	{
		if (event.getMenuOption() != null && event.getMenuOption().equals("Read"))
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(event.getId());

			if (itemComposition != null && (itemComposition.getName().startsWith("Clue scroll") || itemComposition.getName().startsWith("Challenge scroll")))
			{
				clueItemId = itemComposition.getId();
				updateClue(MapClue.forItemId(clueItemId));
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			equippedItems = event.getItemContainer().getItems();
			return;
		}

		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		inventoryItems = event.getItemContainer().getItems();

		// Check if item was removed from inventory
		if (clue != null && clueItemId != null)
		{
			final Stream<Item> items = Arrays.stream(event.getItemContainer().getItems());

			// Check if clue was removed from inventory
			if (items.noneMatch(item -> itemManager.getItemComposition(item.getId()).getId() == clueItemId))
			{
				resetClue(true);
			}
		}

		// if three step clue check for clue scroll pieces
		if (clue instanceof ThreeStepCrypticClue)
		{
			if (((ThreeStepCrypticClue) clue).update(client, event, itemManager))
			{
				worldMapPointsSet = false;
				npcsToMark.clear();

				if (config.displayHintArrows())
				{
					client.clearHintArrow();
				}

				checkClueNPCs(clue, client.getCachedNPCs());
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		checkClueNPCs(clue, npc);
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		final boolean removed = npcsToMark.remove(event.getNpc());

		if (removed)
		{
			if (npcsToMark.isEmpty())
			{
				client.clearHintArrow();
			}
			else
			{
				// Always set hint arrow to first seen NPC
				client.setHintArrow(npcsToMark.get(0));
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cluescroll") && !config.displayHintArrows())
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			resetClue(true);
		}
	}

	@Subscribe
	public void onGameTick(final GameTick event)
	{
		objectsToMark.clear();

		if (clue instanceof LocationsClueScroll)
		{
			final WorldPoint[] locations = ((LocationsClueScroll) clue).getLocations();

			if (locations.length > 0)
			{
				addMapPoints(locations);
			}

			if (clue instanceof ObjectClueScroll)
			{
				int[] objectIds = ((ObjectClueScroll) clue).getObjectIds();

				if (objectIds.length > 0)
				{
					for (WorldPoint location : locations)
					{
						if (location != null)
						{
							highlightObjectsForLocation(location, objectIds);
						}
					}
				}
			}
		}

		if (clue instanceof LocationClueScroll)
		{
			final WorldPoint[] locations = ((LocationClueScroll) clue).getLocations();

			for (WorldPoint location : locations)
			{
				// Only set the location hint arrow if we do not already have more accurate location
				if (location.isInScene(client)
					&& config.displayHintArrows()
					&& (client.getHintArrowNpc() == null
					|| !npcsToMark.contains(client.getHintArrowNpc())))
				{
					client.setHintArrow(location);
				}

				addMapPoints(location);

				if (clue instanceof ObjectClueScroll)
				{
					int[] objectIds = ((ObjectClueScroll) clue).getObjectIds();

					if (objectIds.length > 0)
					{
						highlightObjectsForLocation(location, objectIds);
					}
				}
			}
		}

		// Reset clue when receiving a new beginner or master clue
		// These clues use a single item ID, so we cannot detect step changes based on the item ID changing
		final Widget chatDialogClueItem = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);
		if (chatDialogClueItem != null
			&& (chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_BEGINNER || chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_MASTER))
		{
			resetClue(true);
		}

		final Widget clueScrollText = client.getWidget(WidgetInfo.CLUE_SCROLL_TEXT);

		if (clueScrollText != null)
		{
			ClueScroll clueScroll = findClueScroll(clueScrollText.getText());
			updateClue(clueScroll);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() < WidgetID.BEGINNER_CLUE_MAP_CHAMPIONS_GUILD
			|| event.getGroupId() > WidgetID.BEGINNER_CLUE_MAP_WIZARDS_TOWER)
		{
			return;
		}

		updateClue(BeginnerMapClue.forWidgetID(event.getGroupId()));
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (developerMode && commandExecuted.getCommand().equals("clue"))
		{
			String text = Strings.join(commandExecuted.getArguments(), " ");
			ClueScroll clueScroll = findClueScroll(text);
			log.debug("Found clue scroll for '{}': {}", text, clueScroll);
			updateClue(clueScroll);
		}
	}

	public BufferedImage getClueScrollImage()
	{
		return itemManager.getImage(ItemID.CLUE_SCROLL_MASTER);
	}

	public BufferedImage getEmoteImage()
	{
		if (emoteImage != null)
		{
			return emoteImage;
		}

		emoteImage = ImageUtil.getResourceStreamFromClass(getClass(), "emote.png");

		return emoteImage;
	}

	public BufferedImage getSpadeImage()
	{
		return itemManager.getImage(ItemID.SPADE);
	}

	BufferedImage getMapArrow()
	{
		if (mapArrow != null)
		{
			return mapArrow;
		}

		mapArrow = ImageUtil.getResourceStreamFromClass(getClass(), "/util/clue_arrow.png");

		return mapArrow;
	}

	private void resetClue(boolean withItemId)
	{
		if (clue instanceof LocationsClueScroll)
		{
			((LocationsClueScroll) clue).reset();
		}

		if (withItemId)
		{
			clueItemId = null;
		}

		clue = null;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);
		worldMapPointsSet = false;
		npcsToMark.clear();

		if (config.displayHintArrows())
		{
			client.clearHintArrow();
		}
	}

	private ClueScroll findClueScroll(String rawText)
	{
		// Remove line breaks and also the rare occasion where there are double line breaks
		final String text = Text.sanitizeMultilineText(rawText).toLowerCase();

		// Early return if this is same clue as already existing one
		if (clue instanceof TextClueScroll)
		{
			if (((TextClueScroll) clue).getText().equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		if (text.startsWith("i'd like to hear some music."))
		{
			return MusicClue.forText(rawText);
		}

		if (text.contains("degrees") && text.contains("minutes"))
		{
			return coordinatesToWorldPoint(text);
		}

		final AnagramClue anagramClue = AnagramClue.forText(text);
		if (anagramClue != null)
		{
			return anagramClue;
		}

		final CipherClue cipherClue = CipherClue.forText(text);
		if (cipherClue != null)
		{
			return cipherClue;
		}

		final CrypticClue crypticClue = CrypticClue.forText(text);

		if (crypticClue != null)
		{
			return crypticClue;
		}

		final EmoteClue emoteClue = EmoteClue.forText(text);

		if (emoteClue != null)
		{
			return emoteClue;
		}

		final FairyRingClue fairyRingClue = FairyRingClue.forText(text);

		if (fairyRingClue != null)
		{
			return fairyRingClue;
		}

		final FaloTheBardClue faloTheBardClue = FaloTheBardClue.forText(text);

		if (faloTheBardClue != null)
		{
			return faloTheBardClue;
		}

		final HotColdClue hotColdClue = HotColdClue.forText(text);

		if (hotColdClue != null)
		{
			return hotColdClue;
		}

		final SkillChallengeClue skillChallengeClue = SkillChallengeClue.forText(text, rawText);

		if (skillChallengeClue != null)
		{
			return skillChallengeClue;
		}

		// three step cryptic clues need unedited text to check which steps are already done
		final ThreeStepCrypticClue threeStepCrypticClue = ThreeStepCrypticClue.forText(text, rawText);

		if (threeStepCrypticClue != null)
		{
			return threeStepCrypticClue;
		}

		// We have unknown clue, reset
		log.warn("Encountered unhandled clue text: {}", rawText);
		resetClue(true);
		return null;
	}

	/**
	 * Example input: "00 degrees 00 minutes north 07 degrees 13 minutes west"
	 * Note: some clues use "1 degree" instead of "01 degrees"
	 */
	private CoordinateClue coordinatesToWorldPoint(String text)
	{
		String[] splitText = text.split(" ");

		if (splitText.length != 10)
		{
			log.warn("Splitting \"" + text + "\" did not result in an array of 10 cells");
			return null;
		}

		if (!splitText[1].startsWith("degree") || !splitText[3].startsWith("minute"))
		{
			log.warn("\"" + text + "\" is not a well formed coordinate string");
			return null;
		}

		int degY = Integer.parseInt(splitText[0]);
		int minY = Integer.parseInt(splitText[2]);

		if (splitText[4].equals("south"))
		{
			degY *= -1;
			minY *= -1;
		}

		int degX = Integer.parseInt(splitText[5]);
		int minX = Integer.parseInt(splitText[7]);

		if (splitText[9].equals("west"))
		{
			degX *= -1;
			minX *= -1;
		}

		WorldPoint coordinate = coordinatesToWorldPoint(degX, minX, degY, minY);
		// Convert from overworld to real
		WorldPoint mirrorPoint = getMirrorPoint(coordinate, false);
		// Use mirror point as mirrorLocation if there is one
		return new CoordinateClue(text, coordinate, coordinate == mirrorPoint ? null : mirrorPoint);
	}

	/**
	 * This conversion is explained on
	 * https://oldschool.runescape.wiki/w/Treasure_Trails/Guide/Coordinates
	 */
	private WorldPoint coordinatesToWorldPoint(int degX, int minX, int degY, int minY)
	{
		// Center of the Observatory
		int x2 = 2440;
		int y2 = 3161;

		x2 += degX * 32 + Math.round(minX / 1.875);
		y2 += degY * 32 + Math.round(minY / 1.875);

		return new WorldPoint(x2, y2, 0);
	}

	private void addMapPoints(WorldPoint... points)
	{
		if (worldMapPointsSet)
		{
			return;
		}

		worldMapPointsSet = true;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);

		for (final WorldPoint point : points)
		{
			worldMapPointManager.add(new ClueScrollWorldMapPoint(point, this));
		}
	}

	private void highlightObjectsForLocation(final WorldPoint location, final int... objectIds)
	{
		final LocalPoint localLocation = LocalPoint.fromWorld(client, location);

		if (localLocation == null)
		{
			return;
		}

		final Scene scene = client.getScene();
		final Tile[][][] tiles = scene.getTiles();
		final Tile tile = tiles[client.getPlane()][localLocation.getSceneX()][localLocation.getSceneY()];
		objectsToMark.clear();

		for (GameObject object : tile.getGameObjects())
		{
			if (object == null)
			{
				continue;
			}

			for (int id : objectIds)
			{
				if (object.getId() == id)
				{
					objectsToMark.add(object);
					continue;
				}

				// Check impostors
				final ObjectComposition comp = client.getObjectDefinition(object.getId());
				final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

				if (impostor != null && impostor.getId() == id)
				{
					objectsToMark.add(object);
				}
			}
		}
	}

	private void checkClueNPCs(ClueScroll clue, final NPC... npcs)
	{
		if (!(clue instanceof NpcClueScroll))
		{
			return;
		}

		final NpcClueScroll npcClueScroll = (NpcClueScroll) clue;

		if (npcClueScroll.getNpcs() == null || npcClueScroll.getNpcs().length == 0)
		{
			return;
		}

		for (NPC npc : npcs)
		{
			if (npc == null || npc.getName() == null)
			{
				continue;
			}

			for (String npcName : npcClueScroll.getNpcs())
			{
				if (!Objects.equals(npc.getName(), npcName))
				{
					continue;
				}

				npcsToMark.add(npc);
			}
		}

		if (!npcsToMark.isEmpty() && config.displayHintArrows())
		{
			// Always set hint arrow to first seen NPC
			client.setHintArrow(npcsToMark.get(0));
		}
	}

	private void updateClue(final ClueScroll clue)
	{
		if (clue == null || clue == this.clue)
		{
			return;
		}

		resetClue(false);
		checkClueNPCs(clue, client.getCachedNPCs());
		// If we have a clue, save that knowledge
		// so the clue window doesn't have to be open.
		this.clue = clue;
	}

	void highlightWidget(Graphics2D graphics, Widget toHighlight, Widget container, Rectangle padding, String text)
	{
		padding = MoreObjects.firstNonNull(padding, new Rectangle());

		Point canvasLocation = toHighlight.getCanvasLocation();

		if (canvasLocation == null)
		{
			return;
		}

		Point windowLocation = container.getCanvasLocation();

		if (windowLocation.getY() > canvasLocation.getY() + toHighlight.getHeight()
			|| windowLocation.getY() + container.getHeight() < canvasLocation.getY())
		{
			return;
		}

		// Visible area of widget
		Area widgetArea = new Area(
			new Rectangle(
				canvasLocation.getX() - padding.x,
				Math.max(canvasLocation.getY(), windowLocation.getY()) - padding.y,
				toHighlight.getWidth() + padding.x + padding.width,
				Math.min(
					Math.min(windowLocation.getY() + container.getHeight() - canvasLocation.getY(), toHighlight.getHeight()),
					Math.min(canvasLocation.getY() + toHighlight.getHeight() - windowLocation.getY(), toHighlight.getHeight())) + padding.y + padding.height
			));

		OverlayUtil.renderHoverableArea(graphics, widgetArea, client.getMouseCanvasPosition(),
			HIGHLIGHT_FILL_COLOR, HIGHLIGHT_BORDER_COLOR, HIGHLIGHT_HOVER_BORDER_COLOR);

		if (text == null)
		{
			return;
		}

		FontMetrics fontMetrics = graphics.getFontMetrics();

		textComponent.setPosition(new java.awt.Point(
			canvasLocation.getX() + toHighlight.getWidth() / 2 - fontMetrics.stringWidth(text) / 2,
			canvasLocation.getY() + fontMetrics.getHeight()));
		textComponent.setText(text);
		textComponent.render(graphics);
	}

	void scrollToWidget(WidgetInfo list, WidgetInfo scrollbar, Widget ... toHighlight)
	{
		final Widget parent = client.getWidget(list);
		int averageCentralY = 0;
		int nonnullCount = 0;
		for (Widget widget : toHighlight)
		{
			if (widget != null)
			{
				averageCentralY += widget.getRelativeY() + widget.getHeight() / 2;
				nonnullCount += 1;
			}
		}
		if (nonnullCount == 0)
		{
			return;
		}
		averageCentralY /= nonnullCount;
		final int newScroll = Math.max(0, Math.min(parent.getScrollHeight(),
			averageCentralY - parent.getHeight() / 2));

		client.runScript(
			ScriptID.UPDATE_SCROLLBAR,
			scrollbar.getId(),
			list.getId(),
			newScroll
		);
	}

	/**
	 * Translate a coordinate either between overworld and real, or real and overworld
	 *
	 * @param worldPoint
	 * @param toOverworld whether to convert to overworld coordinates, or to real coordinates
	 * @return
	 */
	public static WorldPoint getMirrorPoint(WorldPoint worldPoint, boolean toOverworld)
	{
		int region = worldPoint.getRegionID();
		for (int i = 0; i < REGION_MIRRORS.length; i += 2)
		{
			int real = REGION_MIRRORS[i];
			int overworld = REGION_MIRRORS[i + 1];

			// Test against what we are converting from
			if (region == (toOverworld ? real : overworld))
			{
				return WorldPoint.fromRegion(toOverworld ? overworld : real,
					worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane());
			}
		}
		return worldPoint;
	}
}
