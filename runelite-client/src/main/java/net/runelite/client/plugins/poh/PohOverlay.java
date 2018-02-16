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
package net.runelite.client.plugins.poh;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import static net.runelite.client.plugins.poh.PohIcons.ALTAR;
import static net.runelite.client.plugins.poh.PohIcons.ANNAKARL;
import static net.runelite.client.plugins.poh.PohIcons.ARDOUGNE;
import static net.runelite.client.plugins.poh.PohIcons.CAMELOT;
import static net.runelite.client.plugins.poh.PohIcons.EXITPORTAL;
import static net.runelite.client.plugins.poh.PohIcons.FALADOR;
import static net.runelite.client.plugins.poh.PohIcons.FISHINGGUILD;
import static net.runelite.client.plugins.poh.PohIcons.GLORY;
import static net.runelite.client.plugins.poh.PohIcons.KHARYLL;
import static net.runelite.client.plugins.poh.PohIcons.KOUREND;
import static net.runelite.client.plugins.poh.PohIcons.LUMBRIDGE;
import static net.runelite.client.plugins.poh.PohIcons.LUNARISLE;
import static net.runelite.client.plugins.poh.PohIcons.MARIM;
import static net.runelite.client.plugins.poh.PohIcons.POOLS;
import static net.runelite.client.plugins.poh.PohIcons.REPAIR;
import static net.runelite.client.plugins.poh.PohIcons.SENNTISTEN;
import static net.runelite.client.plugins.poh.PohIcons.VARROCK;
import static net.runelite.client.plugins.poh.PohIcons.WATERBIRTH;
import static net.runelite.client.plugins.poh.PohIcons.YANILLE;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class PohOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	@Getter
	private final List<PohIcons> iconList = new ArrayList<>();

	private final Client client;
	private final PohConfig config;
	private final PohPlugin plugin;

	@Inject
	public PohOverlay(Client client, PohConfig config, PohPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		Point localLocation = client.getLocalPlayer().getLocalLocation();
		plugin.getPohObjects().forEach((object, tile) ->
		{
			Point location = object.getLocalLocation();
			if (tile.getPlane() == client.getPlane() && localLocation.distanceTo(location) <= MAX_DISTANCE)
			{
				PohIcons icon = PohIcons.getIcon(object.getId());

				if (icon != null && iconList.contains(icon))
				{
					net.runelite.api.Point minimapLoc = Perspective.getMiniMapImageLocation(client, object.getLocalLocation(), icon.getImage());

					if (minimapLoc != null)
					{
						graphics.drawImage(icon.getImage(), minimapLoc.getX(), minimapLoc.getY(), null);
					}
				}
			}
		});

		return null;
	}

	public void updateConfig()
	{
		iconList.clear();
		if (config.showLumbridge())
		{
			iconList.add(LUMBRIDGE);
		}
		if (config.showFalador())
		{
			iconList.add(FALADOR);
		}
		if (config.showVarrock())
		{
			iconList.add(VARROCK);
		}
		if (config.showCamelot())
		{
			iconList.add(CAMELOT);
		}
		if (config.showArdougne())
		{
			iconList.add(ARDOUGNE);
		}
		if (config.showYanille())
		{
			iconList.add(YANILLE);
		}
		if (config.showLunarIsle())
		{
			iconList.add(LUNARISLE);
		}
		if (config.showWaterBirth())
		{
			iconList.add(WATERBIRTH);
		}
		if (config.showFishingGuild())
		{
			iconList.add(FISHINGGUILD);
		}
		if (config.showSenntisten())
		{
			iconList.add(SENNTISTEN);
		}
		if (config.showKharyll())
		{
			iconList.add(KHARYLL);
		}
		if (config.showAnnakarl())
		{
			iconList.add(ANNAKARL);
		}
		if (config.showKourend())
		{
			iconList.add(KOUREND);
		}
		if (config.showMarim())
		{
			iconList.add(MARIM);
		}
		if (config.showAltar())
		{
			iconList.add(ALTAR);
		}
		if (config.showGlory())
		{
			iconList.add(GLORY);
		}
		if (config.showRepairStand())
		{
			iconList.add(REPAIR);
		}
		if (config.showPools())
		{
			iconList.add(POOLS);
		}
		if (config.showExitPortal())
		{
			iconList.add(EXITPORTAL);
		}
	}
}
