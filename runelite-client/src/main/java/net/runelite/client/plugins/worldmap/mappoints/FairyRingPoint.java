/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.worldmap.mappoints;

import com.google.common.collect.ImmutableSet;
import com.sun.corba.se.pept.transport.InboundConnectionCache;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import javax.imageio.ImageIO;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.worldmap.WorldMapPlugin;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

public class FairyRingPoint extends IconWorldMapPoint
{
	private final static BufferedImage FAIRY_RING_ICON;
	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				final BufferedImage icon = ImageIO.read(WorldMapPlugin.class.getResourceAsStream("fairy_ring_travel.png"));
				//A size of 17 gives us a buffer when triggering tooltips
				final int ICON_BUFFER_SIZE = 17;
				FAIRY_RING_ICON = new BufferedImage(ICON_BUFFER_SIZE, ICON_BUFFER_SIZE, BufferedImage.TYPE_INT_ARGB);
				FAIRY_RING_ICON.getGraphics().drawImage(icon, 1, 1, null);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	//TODO Clear image and fill image methods and toggle

	private static final Set<FairyRingPoint> POINTS = ImmutableSet.of(
		new FairyRingPoint("AIR", new WorldPoint(2699, 3249, 0)),
		new FairyRingPoint("AIQ", new WorldPoint(2995, 3112, 0)),
		new FairyRingPoint("AJR", new WorldPoint(2779, 3615, 0)),
		new FairyRingPoint("AJS", new WorldPoint(2499, 3898, 0)),
		new FairyRingPoint("AKQ", new WorldPoint(2318, 3617, 0)),
		new FairyRingPoint("AKS", new WorldPoint(2570, 2958, 0)),
		new FairyRingPoint("ALP", new WorldPoint(2502, 3638, 0)),
		new FairyRingPoint("ALQ", new WorldPoint(3598, 3496, 0)),
		new FairyRingPoint("ALS", new WorldPoint(2643, 3497, 0)),
		new FairyRingPoint("BIP", new WorldPoint(3409, 3326, 0)),
		new FairyRingPoint("BIQ", new WorldPoint(3248, 3095, 0)),
		new FairyRingPoint("BIS", new WorldPoint(2635, 3268, 0)),
		new FairyRingPoint("BJQ", new WorldPoint(1737, 5342, 0)),
		new FairyRingPoint("BJS", new WorldPoint(2147, 3069, 0)),
		new FairyRingPoint("BKP", new WorldPoint(2384, 3037, 0)),
		new FairyRingPoint("BKR", new WorldPoint(3468, 3433, 0)),
		new FairyRingPoint("BLP", new WorldPoint(2432, 5127, 0)),
		new FairyRingPoint("BLR", new WorldPoint(2739, 3353, 0)),
		new FairyRingPoint("CIP", new WorldPoint(2512, 3886, 0)),
		new FairyRingPoint("CIQ", new WorldPoint(2527, 3129, 0)),
		new FairyRingPoint("CJR", new WorldPoint(2704, 3578, 0)),
		new FairyRingPoint("CKR", new WorldPoint(2800, 3005, 0)),
		new FairyRingPoint("CKS", new WorldPoint(3446, 3472, 0)),
		new FairyRingPoint("CLP", new WorldPoint(3081, 3208, 0)),
		new FairyRingPoint("CLS", new WorldPoint(2681, 3083, 0)),
		new FairyRingPoint("DIP", new WorldPoint(3039, 4757, 0)), //Abyssal sire
		new FairyRingPoint("DIS", new WorldPoint(3109, 3149, 0)),
		new FairyRingPoint("DJP", new WorldPoint(2657, 3232, 0)),
		new FairyRingPoint("DJR", new WorldPoint(1452, 3659, 0)),
		new FairyRingPoint("DKP", new WorldPoint(2899, 3113, 0)),
		new FairyRingPoint("DKR", new WorldPoint(3126, 3496, 0)),
		new FairyRingPoint("DKS", new WorldPoint(2743, 3721, 0)),
		new FairyRingPoint("DLQ", new WorldPoint(3422, 3018, 0)),
		new FairyRingPoint("DLR", new WorldPoint(2212, 3101, 0)),
		new FairyRingPoint("CIS", new WorldPoint(1638, 3868, 0)),
		new FairyRingPoint("CLR", new WorldPoint(2737, 2739, 0)),
		new FairyRingPoint("Zanaris", new WorldPoint(2411, 4436, 0))
	);

	private FairyRingPoint(String tooltip, WorldPoint worldPoint)
	{
		super(worldPoint, FAIRY_RING_ICON, "Fairy Ring - " + tooltip);
	}

	public static Set<? extends WorldMapPoint> getPoints()
	{
		return POINTS;
	}
}
