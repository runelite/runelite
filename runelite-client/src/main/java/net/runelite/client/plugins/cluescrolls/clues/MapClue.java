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

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;
import static net.runelite.api.ItemID.*;
import static net.runelite.api.ObjectID.*;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.CLUE_SCROLL_IMAGE;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.SPADE_IMAGE;

@Getter
public class MapClue extends ClueScroll implements ObjectClueScroll, LocationClueScroll
{
	private static final Set<MapClue> CLUES = ImmutableSet.of(
		new MapClue(CLUE_SCROLL_EASY_12179, new WorldPoint(3300, 3291, 0)),
		new MapClue(CLUE_SCROLL_EASY_2713, new WorldPoint(3166, 3361, 0)),
		new MapClue(CLUE_SCROLL_EASY_2716, new WorldPoint(3290, 3374, 0)),
		new MapClue(CLUE_SCROLL_EASY_2719, new WorldPoint(3043, 3398, 0)),
		new MapClue(CLUE_SCROLL_EASY_3516, new WorldPoint(2612, 3482, 0)),
		new MapClue(CLUE_SCROLL_EASY_3518, new WorldPoint(3110, 3152, 0)),
		new MapClue(CLUE_SCROLL_EASY_7236, new WorldPoint(2970, 3415, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_3596, new WorldPoint(2907, 3295, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_3598, new WorldPoint(2659, 3488, 0), CRATE_357),
		new MapClue(CLUE_SCROLL_MEDIUM_3599, new WorldPoint(2651, 3231, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_3601, new WorldPoint(2564, 3249, 0), CRATE_354),
		new MapClue(CLUE_SCROLL_MEDIUM_3602, new WorldPoint(2924, 3210, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_7286, new WorldPoint(2536, 3865, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_7288, new WorldPoint(3434, 3265, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_7290, new WorldPoint(2454, 3230, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_7292, new WorldPoint(2578, 3597, 0)),
		new MapClue(CLUE_SCROLL_MEDIUM_7294, new WorldPoint(2666, 3562, 0)),
		new MapClue(CLUE_SCROLL_HARD, new WorldPoint(3309, 3502, 0), CRATE_2620),
		new MapClue(CLUE_SCROLL_HARD_3520, new WorldPoint(2616, 3077, 0)),
		new MapClue(CLUE_SCROLL_HARD_3522, new WorldPoint(2488, 3308, 0)),
		new MapClue(CLUE_SCROLL_HARD_3524, new WorldPoint(3458, 3182, 0), CRATE_18506),
		new MapClue(CLUE_SCROLL_HARD_3525, new WorldPoint(3026, 3629, 0), CRATE_354),
		new MapClue(CLUE_SCROLL_HARD_7239, new WorldPoint(3021, 3912, 0)),
		new MapClue(CLUE_SCROLL_HARD_7241, new WorldPoint(2722, 3338, 0)),
		new MapClue(CLUE_SCROLL_ELITE_12130, new WorldPoint(2449, 3130, 0))
	);

	private int itemId;
	private WorldPoint location;
	private int objectId;

	private MapClue(int itemId, WorldPoint location)
	{
		this(itemId, location, -1);
	}

	private MapClue(int itemId, WorldPoint location, int objectId)
	{
		this.itemId = itemId;
		this.location = location;
		this.objectId = objectId;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.setTitle("Map Clue");

		if (objectId != -1)
		{
			panelComponent.setWidth(150);

			ObjectComposition objectToClick = plugin.getClient().getObjectDefinition(getObjectId());

			String objectName = "N/A";
			if (objectToClick != null)
			{
				objectName = objectToClick.getName();
			}

			panelComponent.getLines().add(new PanelComponent.Line("Travel to the destination"));
			panelComponent.getLines().add(new PanelComponent.Line("and click the " + objectName + "."));
		}
		else
		{
			panelComponent.setWidth(160);

			panelComponent.getLines().add(new PanelComponent.Line("Travel to the destination"));
			panelComponent.getLines().add(new PanelComponent.Line("and dig on the marked tile."));
		}
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
			Region region = plugin.getClient().getRegion();
			Tile[][][] tiles = region.getTiles();

			Tile tile = tiles[plugin.getClient().getPlane()][localLocation.getRegionX()][localLocation.getRegionY()];

			net.runelite.api.Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			for (GameObject gameObject : tile.getGameObjects())
			{
				if (gameObject != null)
				{
					OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), mousePosition,
							CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

					OverlayUtil.renderImageLocation(plugin.getClient(), graphics, localLocation, CLUE_SCROLL_IMAGE, IMAGE_Z_OFFSET);
				}
			}
		}
		else
		{
			OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, SPADE_IMAGE, Color.ORANGE);
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
}
