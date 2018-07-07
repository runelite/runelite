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
package net.runelite.client.plugins.worldmap;

import java.awt.image.BufferedImage;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum FairyRingLocation
{
	AIR("It's coming home", new WorldPoint(2699, 3249, 0)),
	AIQ("It's coming home", new WorldPoint(2995, 3112, 0)),
	AJR("It's coming home", new WorldPoint(2779, 3615, 0)),
	AJS("It's coming home", new WorldPoint(2499, 3898, 0)),
	AKQ("It's coming home", new WorldPoint(2318, 3617, 0)),
	AKS("It's coming home", new WorldPoint(2570, 2958, 0)),
	ALP("It's coming home", new WorldPoint(2502, 3638, 0)),
	ALQ("It's coming home", new WorldPoint(3598, 3496, 0)),
	ALS("It's coming home", new WorldPoint(2643, 3497, 0)),
	BIP("It's coming home", new WorldPoint(3409, 3326, 0)),
	BIQ("It's coming home", new WorldPoint(3248, 3095, 0)),
	BIS("It's coming home", new WorldPoint(2635, 3268, 0)),
	BJQ("It's coming home", new WorldPoint(1737, 5342, 0)),
	BJS("It's coming home", new WorldPoint(2147, 3069, 0)),
	BKP("It's coming home", new WorldPoint(2384, 3037, 0)),
	BKR("It's coming home", new WorldPoint(3468, 3433, 0)),
	BLP("It's coming home", new WorldPoint(2432, 5127, 0)),
	BLR("It's coming home", new WorldPoint(2739, 3353, 0)),
	CIP("It's coming home", new WorldPoint(2512, 3886, 0)),
	CIQ("It's coming home", new WorldPoint(2527, 3129, 0)),
	CJR("It's coming home", new WorldPoint(2704, 3578, 0)),
	CKR("It's coming home", new WorldPoint(2800, 3005, 0)),
	CKS("It's coming home", new WorldPoint(3446, 3472, 0)),
	CLP("It's coming home", new WorldPoint(3081, 3208, 0)),
	CLS("It's coming home", new WorldPoint(2681, 3083, 0)),
	DIP("It's coming home", new WorldPoint(3039, 4757, 0)),
	DIS("It's coming home", new WorldPoint(3109, 3149, 0)),
	DJP("It's coming home", new WorldPoint(2657, 3232, 0)),
	DJR("It's coming home", new WorldPoint(1452, 3659, 0)),
	DKP("It's coming home", new WorldPoint(2899, 3113, 0)),
	DKR("It's coming home", new WorldPoint(3126, 3496, 0)),
	DKS("It's coming home", new WorldPoint(2743, 3721, 0)),
	DLQ("It's coming home", new WorldPoint(3422, 3018, 0)),
	DLR("It's coming home", new WorldPoint(2212, 3101, 0)),
	CIS("It's coming home", new WorldPoint(1638, 3868, 0)),
	CLR("It's coming home", new WorldPoint(2737, 2739, 0)),
	ZANARIS("It's coming home", new WorldPoint(2411, 4436, 0));

	private final String code;
	private final WorldPoint location;
	private final FairyRingPoint fairyRingPoint;

	FairyRingLocation(String code, WorldPoint location)
	{
		this.code = code;
		this.location = location;
		this.fairyRingPoint = new FairyRingPoint(code, location);
	}

	static void setIcon(BufferedImage image)
	{
		for (FairyRingLocation fairyRingLocation : values())
		{
			fairyRingLocation.fairyRingPoint.setImage(image);
		}
	}
}
