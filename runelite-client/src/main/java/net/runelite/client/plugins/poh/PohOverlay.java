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
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class PohOverlay extends Overlay
{
	private static final PohIcons[] PORTALS = new PohIcons[]
	{
		PohIcons.LUMBRIDGE, PohIcons.FALADOR, PohIcons.VARROCK, PohIcons.CAMELOT, PohIcons.ARDOUGNE,
		PohIcons.YANILLE, PohIcons.LUNARISLE, PohIcons.WATERBIRTH, PohIcons.FISHINGGUILD,
		PohIcons.SENNTISTEN, PohIcons.KHARYLL, PohIcons.ANNAKARL, PohIcons.KOUREND, PohIcons.MARIM, PohIcons.TROLLSTRONGHOLD, PohIcons.CARRALLANGAR, PohIcons.CATHERBY, PohIcons.GHORROCK

	};

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
	public Dimension render(Graphics2D graphics)
	{
		LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
		plugin.getPohObjects().forEach((object, tile) ->
		{
			LocalPoint location = object.getLocalLocation();
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
		if (config.showPortals())
		{
			Collections.addAll(iconList, PORTALS);
		}
		if (config.showAltar())
		{
			iconList.add(PohIcons.ALTAR);
		}
		if (config.showGlory())
		{
			iconList.add(PohIcons.GLORY);
		}
		if (config.showRepairStand())
		{
			iconList.add(PohIcons.REPAIR);
		}
		if (config.showPools())
		{
			iconList.add(PohIcons.POOLS);
		}
		if (config.showExitPortal())
		{
			iconList.add(PohIcons.EXITPORTAL);
		}
		if (config.showSpellbook())
		{
			iconList.add(PohIcons.SPELLBOOKALTAR);
		}
		if (config.showJewelleryBox())
		{
			iconList.add(PohIcons.JEWELLERYBOX);
		}
		if (config.showMagicTravel())
		{
			iconList.add(PohIcons.MAGICTRAVEL);
		}
		if (config.showPortalNexus())
		{
			iconList.add(PohIcons.PORTALNEXUS);
		}
		if (config.showDigsitePendant())
		{
			iconList.add(PohIcons.DIGSITEPENDANT);
		}
		if (config.showXericsTalisman())
		{
			iconList.add(PohIcons.XERICSTALISMAN);
		}
	}
}
