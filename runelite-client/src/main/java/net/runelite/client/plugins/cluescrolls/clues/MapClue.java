/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import static net.runelite.api.ItemID.*;
import net.runelite.api.ObjectComposition;
import static net.runelite.api.ObjectID.CRATE_18506;
import static net.runelite.api.ObjectID.CRATE_2620;
import static net.runelite.api.ObjectID.CRATE_354;
import static net.runelite.api.ObjectID.CRATE_357;
import static net.runelite.api.ObjectID.CRATE_6616;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class MapClue extends ClueScroll implements ObjectClueScroll
{
	public static final String CHAMPIONS_GUILD = "West of the Champions' Guild";
	public static final String VARROCK_EAST_MINE = "Outside Varrock East Mine";
	public static final String STANDING_STONES = "At the standing stones north of Falador";
	public static final String WIZARDS_TOWER_DIS = "On the south side of the Wizard's Tower (DIS)";
	public static final String SOUTH_OF_DRAYNOR_BANK = "South of Draynor Village Bank";

	static final List<MapClue> CLUES = ImmutableList.of(
		new MapClue(CLUE_SCROLL_EASY_12179, new WorldPoint(3300, 3291, 0), "Al Kharid mine"),
		new MapClue(CLUE_SCROLL_EASY_2713, new WorldPoint(3166, 3361, 0), CHAMPIONS_GUILD),
		new MapClue(CLUE_SCROLL_EASY_2716, new WorldPoint(3290, 3374, 0), VARROCK_EAST_MINE),
		new MapClue(CLUE_SCROLL_EASY_2719, new WorldPoint(3043, 3398, 0), STANDING_STONES),
		new MapClue(CLUE_SCROLL_EASY_3516, new WorldPoint(2612, 3482, 0), "Brother Galahad's house, West of McGrubor's Wood."),
		new MapClue(CLUE_SCROLL_EASY_3518, new WorldPoint(3110, 3152, 0), WIZARDS_TOWER_DIS),
		new MapClue(CLUE_SCROLL_EASY_7236, new WorldPoint(2970, 3415, 0), "North of Falador."),
		new MapClue(CLUE_SCROLL_MEDIUM_2827, new WorldPoint(3091, 3227, 0), SOUTH_OF_DRAYNOR_BANK),
		new MapClue(CLUE_SCROLL_MEDIUM_3596, new WorldPoint(2907, 3295, 0), "West of the Crafting Guild"),
		new MapClue(CLUE_SCROLL_MEDIUM_3598, new WorldPoint(2658, 3488, 0), CRATE_357, "The crate in McGrubor's Wood. Fairy ring ALS"),
		new MapClue(CLUE_SCROLL_MEDIUM_3599, new WorldPoint(2651, 3231, 0), "North of the Tower of Life. Fairy ring DJP"),
		new MapClue(CLUE_SCROLL_MEDIUM_3601, new WorldPoint(2565, 3248, 0), CRATE_354, "The crate west of the Clocktower."),
		new MapClue(CLUE_SCROLL_MEDIUM_3602, new WorldPoint(2924, 3210, 0), "Behind the Chemist's house in Rimmington."),
		new MapClue(CLUE_SCROLL_MEDIUM_7286, new WorldPoint(2536, 3865, 0), "Miscellania. Fairy ring CIP"),
		new MapClue(CLUE_SCROLL_MEDIUM_7288, new WorldPoint(3434, 3265, 0), "Mort Myre Swamp, west of Mort'ton. Fairy ring BIP"),
		new MapClue(CLUE_SCROLL_MEDIUM_7290, new WorldPoint(2454, 3230, 0), "At the entrance to the Ourania Cave."),
		new MapClue(CLUE_SCROLL_MEDIUM_7292, new WorldPoint(2578, 3597, 0), "South-east of the Lighthouse. Fairy ring ALP"),
		new MapClue(CLUE_SCROLL_MEDIUM_7294, new WorldPoint(2666, 3562, 0), "Between Seers' Village and Rellekka. South-west of Fairy ring CJR"),
		new MapClue(CLUE_SCROLL_HARD, new WorldPoint(3309, 3503, 0), CRATE_2620, "A crate in the Lumber Yard, north-east of Varrock."),
		new MapClue(CLUE_SCROLL_HARD_3520, new WorldPoint(2615, 3078, 0), "Yanille anvils, south of the bank. You can dig from inside the building."),
		new MapClue(CLUE_SCROLL_HARD_3522, new WorldPoint(2488, 3308, 0), "In the western section of West Ardougne."),
		new MapClue(CLUE_SCROLL_HARD_3524, new WorldPoint(2457, 3182, 0), CRATE_18506, "In a crate by the stairs to the Observatory Dungeon."),
		new MapClue(CLUE_SCROLL_HARD_3525, new WorldPoint(3026, 3628, 0), CRATE_354, "In a crate at the Dark Warriors' Fortress in level 14 Wilderness."),
		new MapClue(CLUE_SCROLL_HARD_7239, new WorldPoint(3021, 3912, 0), "South-east of the Wilderness Agility Course in level 50 Wilderness."),
		new MapClue(CLUE_SCROLL_HARD_7241, new WorldPoint(2722, 3338, 0), "South of the Legends' Guild. Fairy ring BLR"),
		new MapClue(CLUE_SCROLL_ELITE_12130, new WorldPoint(2449, 3130, 0), "South-west of Tree Gnome Village."),
		new MapClue(CLUE_SCROLL_ELITE_19782, new WorldPoint(2953, 9523, 1), "In the Mogre Camp, near Port Khazard. You require a Diving Apparatus and a Fishbowl Helmet"),
		new MapClue(CLUE_SCROLL_ELITE_19783, new WorldPoint(2202, 3062, 0), "Zul-Andra. Fairy ring BJS"),
		new MapClue(CLUE_SCROLL_ELITE_19784, new WorldPoint(1815, 3852, 0), "At the Soul Altar, north-east of the Arceuus essence mine."),
		new MapClue(CLUE_SCROLL_ELITE_19785, new WorldPoint(3538, 3208, 0), "East of Burgh de Rott."),
		new MapClue(CLUE_SCROLL_ELITE_19786, new WorldPoint(2703, 2716, 0), CRATE_6616, "The crate in south-western Ape Atoll"),
		new MapClue(TREASURE_SCROLL_23068, new WorldPoint(3203, 3213, 0), "Behind Lumbridge Castle, just outside the kitchen door"),
		new MapClue(MYSTERIOUS_ORB_23069, new WorldPoint(3108, 3262, 0), "South-west of the wheat field east of Draynor Village.")
	);

	private final int itemId;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	private final int objectId;
	private final String description;

	private MapClue(int itemId, WorldPoint location, int objectId)
	{
		this(itemId, location, objectId, null);
	}

	MapClue(int itemId, WorldPoint location, String description)
	{
		this(itemId, location, -1, description);
	}

	private MapClue(int itemId, WorldPoint location, int objectId, String description)
	{
		this.itemId = itemId;
		this.location = location;
		this.objectId = objectId;
		this.description = description;
		setRequiresSpade(objectId == -1);
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Map Clue").build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Click the clue scroll along the edge of your world map to see your destination.")
			.build());

		if (objectId != -1)
		{
			ObjectComposition objectToClick = plugin.getClient().getObjectDefinition(getObjectId());

			String objectName = "N/A";

			if (objectToClick != null)
			{
				objectName = objectToClick.getName();
			}

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Travel to the destination and click the " + objectName + ".")
				.build());
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Travel to the destination and dig on the marked tile.")
				.build());
		}

		if (description != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(description)
				.build());
		}

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		// Mark game object
		if (objectId != -1)
		{
			net.runelite.api.Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			if (plugin.getObjectsToMark() != null)
			{
				for (TileObject gameObject : plugin.getObjectsToMark())
				{
					OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
						CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

					OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
				}
			}
		}
		// Mark tile
		else
		{
			OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
		}
	}

	public static MapClue forItemId(int itemId)
	{
		for (MapClue clue : CLUES)
		{
			if (clue.itemId == itemId)
			{
				return clue;
			}
		}

		return null;
	}

	@Override
	public int[] getObjectIds()
	{
		return new int[] {objectId};
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{location.hashCode()};
	}
}
