/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemContainer;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class BlastFurnaceClickBoxOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final BlastFurnacePlugin plugin;
	private final BlastFurnaceConfig config;

	@Inject
	private BlastFurnaceClickBoxOverlay(Client client, BlastFurnacePlugin plugin, BlastFurnaceConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		int dispenserState = client.getVarbitValue(VarbitID.BLAST_FURNACE_BARS_HOT);

		if (config.showConveyorBelt() && plugin.getConveyorBelt() != null)
		{
			Color color = dispenserState == 1 ? Color.RED : Color.GREEN;
			renderObject(plugin.getConveyorBelt(), graphics, color);
		}

		if (config.showBarDispenser() && plugin.getBarDispenser() != null)
		{
			boolean hasIceGloves = hasIceGloves();
			Color color = dispenserState == 2 && hasIceGloves ? Color.GREEN : (dispenserState == 3 ? Color.GREEN : Color.RED);

			renderObject(plugin.getBarDispenser(), graphics, color);
		}

		return null;
	}

	private boolean hasIceGloves()
	{
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.WORN);
		if (equipmentContainer == null)
		{
			return false;
		}

		return (equipmentContainer.contains(ItemID.ICE_GLOVES) || equipmentContainer.contains(ItemID.SMITHING_UNIFORM_GLOVES_ICE));
	}

	private void renderObject(GameObject object, Graphics2D graphics, Color color)
	{
		LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();

		LocalPoint location = object.getLocalLocation();

		if (localLocation.distanceTo(location) <= MAX_DISTANCE)
		{
			Shape objectClickbox = object.getClickbox();
			if (objectClickbox != null)
			{
				if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
				{
					graphics.setColor(color.darker());
				}
				else
				{
					graphics.setColor(color);
				}
				graphics.draw(objectClickbox);
				graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
				graphics.fill(objectClickbox);
			}
		}
	}
}
