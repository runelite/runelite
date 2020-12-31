/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.party;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.ws.PartyMember;

class PartyWorldMapPoint extends WorldMapPoint
{
	private static final BufferedImage ARROW = ImageUtil.loadImageResource(PartyWorldMapPoint.class, "/util/clue_arrow.png");

	private BufferedImage partyImage;
	private final PartyMember member;

	PartyWorldMapPoint(WorldPoint worldPoint, PartyMember member)
	{
		super(worldPoint, null);
		this.member = member;
		this.setSnapToEdge(true);
		this.setJumpOnClick(true);
		this.setImagePoint(new Point(
			ARROW.getWidth() / 2,
			ARROW.getHeight()));
	}

	@Override
	public BufferedImage getImage()
	{
		if (partyImage == null && member != null && member.getAvatar() != null)
		{
			partyImage = new BufferedImage(ARROW.getWidth(), ARROW.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g = partyImage.getGraphics();
			g.drawImage(ARROW, 0, 0, null);
			g.drawImage(ImageUtil.resizeImage(member.getAvatar(), 28, 28), 2, 2, null);
		}

		return partyImage;
	}
}
