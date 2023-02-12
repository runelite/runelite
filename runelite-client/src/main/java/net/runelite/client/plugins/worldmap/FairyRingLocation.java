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

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum FairyRingLocation
{
	AIR("AIR", new WorldPoint(2699, 3249, 0)),
	AIQ("AIQ", new WorldPoint(2995, 3112, 0)),
	AJR("AJR", new WorldPoint(2779, 3615, 0)),
	AJS("AJS", new WorldPoint(2499, 3898, 0)),
	AKP("AKP", new WorldPoint(3283, 2704, 0)),
	AKQ("AKQ", new WorldPoint(2318, 3617, 0)),
	AKS("AKS", new WorldPoint(2570, 2958, 0)),
	ALP("ALP", new WorldPoint(2502, 3638, 0)),
	ALQ("ALQ", new WorldPoint(3598, 3496, 0)),
	ALS("ALS", new WorldPoint(2643, 3497, 0)),
	BIP("BIP", new WorldPoint(3409, 3326, 0)),
	BIQ("BIQ", new WorldPoint(3248, 3095, 0)),
	BIS("BIS", new WorldPoint(2635, 3268, 0)),
	BJP("BJP", new WorldPoint(2264, 2976, 0)),
	BJS("BJS", new WorldPoint(2147, 3069, 0)),
	BKP("BKP", new WorldPoint(2384, 3037, 0)),
	BKR("BKR", new WorldPoint(3468, 3433, 0)),
	BLP("BLP", new WorldPoint(2432, 5127, 0)),
	BLR("BLR", new WorldPoint(2739, 3353, 0)),
	CIP("CIP", new WorldPoint(2512, 3886, 0)),
	CIR("CIR", new WorldPoint(1303, 3762, 0)),
	CIQ("CIQ", new WorldPoint(2527, 3129, 0)),
	CJR("CJR", new WorldPoint(2704, 3578, 0)),
	CKR("CKR", new WorldPoint(2800, 3005, 0)),
	CKS("CKS", new WorldPoint(3446, 3472, 0)),
	CLP("CLP", new WorldPoint(3081, 3208, 0)),
	CLS("CLS", new WorldPoint(2681, 3083, 0)),
	DIP("DIP", new WorldPoint(3039, 4757, 0)),
	DIS("DIS", new WorldPoint(3109, 3149, 0)),
	DJP("DJP", new WorldPoint(2657, 3232, 0)),
	DJR("DJR", new WorldPoint(1452, 3659, 0)),
	DKP("DKP", new WorldPoint(2899, 3113, 0)),
	DKR("DKR", new WorldPoint(3126, 3496, 0)),
	DKS("DKS", new WorldPoint(2743, 3721, 0)),
	DLQ("DLQ", new WorldPoint(3422, 3018, 0)),
	DLR("DLR", new WorldPoint(2212, 3101, 0)),
	CIS("CIS", new WorldPoint(1636, 3869, 0)),
	CLR("CLR", new WorldPoint(2737, 2739, 0)),
	ZANARIS("Zanaris", new WorldPoint(2411, 4436, 0));

	private final String code;
	private final WorldPoint location;

	FairyRingLocation(String code, WorldPoint location)
	{
		this.code = code;
		this.location = location;
	}
}
