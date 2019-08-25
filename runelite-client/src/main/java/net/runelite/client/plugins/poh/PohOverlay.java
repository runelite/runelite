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
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
public class PohOverlay extends Overlay
{
	private static final PohIcons[] PORTALS = new PohIcons[]
		{
			PohIcons.LUMBRIDGE, PohIcons.FALADOR, PohIcons.VARROCK, PohIcons.CAMELOT, PohIcons.ARDOUGNE,
			PohIcons.YANILLE, PohIcons.LUNARISLE, PohIcons.WATERBIRTH, PohIcons.FISHINGGUILD,
			PohIcons.SENNTISTEN, PohIcons.KHARYLL, PohIcons.ANNAKARL, PohIcons.KOUREND, PohIcons.MARIM, PohIcons.TROLLSTRONGHOLD, PohIcons.CARRALLANGAR, PohIcons.CATHERBY, PohIcons.GHORROCK

		};

	private static final int MAX_DISTANCE = 2350;

	@Getter(AccessLevel.PACKAGE)
	private final List<PohIcons> iconList = new ArrayList<>();

	private final Client client;
	private final PohPlugin plugin;

	@Inject
	public PohOverlay(final Client client, final PohPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
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
		if (plugin.isShowPortals())
		{
			Collections.addAll(iconList, PORTALS);
		}
		if (plugin.isShowAltar())
		{
			iconList.add(PohIcons.ALTAR);
		}
		if (plugin.isShowGlory())
		{
			iconList.add(PohIcons.GLORY);
		}
		if (plugin.isShowRepairStand())
		{
			iconList.add(PohIcons.REPAIR);
		}
		if (plugin.isShowPools())
		{
			iconList.add(PohIcons.POOLS);
		}
		if (plugin.isShowExitPortal())
		{
			iconList.add(PohIcons.EXITPORTAL);
		}
		if (plugin.isShowSpellbook())
		{
			iconList.add(PohIcons.SPELLBOOKALTAR);
		}
		if (plugin.isShowJewelleryBox())
		{
			iconList.add(PohIcons.JEWELLERYBOX);
		}
		if (plugin.isShowMagicTravel())
		{
			iconList.add(PohIcons.MAGICTRAVEL);
		}
		if (plugin.isShowPortalNexus())
		{
			iconList.add(PohIcons.PORTALNEXUS);
		}
		if (plugin.isShowDigsitePendant())
		{
			iconList.add(PohIcons.DIGSITEPENDANT);
		}
		if (plugin.isShowXericsTalisman())
		{
			iconList.add(PohIcons.XERICSTALISMAN);
		}
	}
}
