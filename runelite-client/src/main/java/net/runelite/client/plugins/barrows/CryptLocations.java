/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.barrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

public enum CryptLocations
{

	DHAROCK(new WorldPoint(3572, 3295, 0),
			new WorldPoint(3572, 3296, 0),
			new WorldPoint(3572, 3297, 0),
			new WorldPoint(3572, 3298, 0),
			new WorldPoint(3572, 3299, 0),
			new WorldPoint(3572, 3300, 0),
			new WorldPoint(3573, 3295, 0),
			new WorldPoint(3573, 3296, 0),
			new WorldPoint(3573, 3297, 0),
			new WorldPoint(3573, 3298, 0),
			new WorldPoint(3573, 3299, 0),
			new WorldPoint(3573, 3300, 0),
			new WorldPoint(3574, 3295, 0),
			new WorldPoint(3574, 3296, 0),
			new WorldPoint(3574, 3297, 0),
			new WorldPoint(3574, 3298, 0),
			new WorldPoint(3574, 3299, 0),
			new WorldPoint(3574, 3300, 0),
			new WorldPoint(3575, 3295, 0),
			new WorldPoint(3575, 3296, 0),
			new WorldPoint(3575, 3297, 0),
			new WorldPoint(3575, 3298, 0),
			new WorldPoint(3575, 3299, 0),
			new WorldPoint(3575, 3300, 0),
			new WorldPoint(3576, 3295, 0),
			new WorldPoint(3576, 3296, 0),
			new WorldPoint(3576, 3297, 0),
			new WorldPoint(3576, 3298, 0),
			new WorldPoint(3576, 3299, 0),
			new WorldPoint(3576, 3300, 0),
			new WorldPoint(3577, 3295, 0),
			new WorldPoint(3577, 3296, 0),
			new WorldPoint(3577, 3297, 0),
			new WorldPoint(3577, 3298, 0),
			new WorldPoint(3577, 3299, 0),
			new WorldPoint(3577, 3300, 0)),
	AHRIMS(new WorldPoint(3562, 3286, 0),
			new WorldPoint(3562, 3287, 0),
			new WorldPoint(3562, 3288, 0),
			new WorldPoint(3562, 3289, 0),
			new WorldPoint(3562, 3290, 0),
			new WorldPoint(3562, 3291, 0),
			new WorldPoint(3562, 3292, 0),
			new WorldPoint(3563, 3286, 0),
			new WorldPoint(3563, 3287, 0),
			new WorldPoint(3563, 3288, 0),
			new WorldPoint(3563, 3289, 0),
			new WorldPoint(3563, 3290, 0),
			new WorldPoint(3563, 3291, 0),
			new WorldPoint(3563, 3292, 0),
			new WorldPoint(3564, 3286, 0),
			new WorldPoint(3564, 3287, 0),
			new WorldPoint(3564, 3288, 0),
			new WorldPoint(3564, 3289, 0),
			new WorldPoint(3564, 3290, 0),
			new WorldPoint(3564, 3291, 0),
			new WorldPoint(3564, 3292, 0),
			new WorldPoint(3565, 3286, 0),
			new WorldPoint(3565, 3287, 0),
			new WorldPoint(3565, 3288, 0),
			new WorldPoint(3565, 3289, 0),
			new WorldPoint(3565, 3290, 0),
			new WorldPoint(3565, 3291, 0),
			new WorldPoint(3565, 3292, 0),
			new WorldPoint(3566, 3286, 0),
			new WorldPoint(3566, 3287, 0),
			new WorldPoint(3566, 3288, 0),
			new WorldPoint(3566, 3289, 0),
			new WorldPoint(3566, 3290, 0),
			new WorldPoint(3566, 3291, 0),
			new WorldPoint(3566, 3292, 0),
			new WorldPoint(3567, 3286, 0),
			new WorldPoint(3567, 3287, 0),
			new WorldPoint(3567, 3288, 0),
			new WorldPoint(3567, 3289, 0),
			new WorldPoint(3567, 3290, 0),
			new WorldPoint(3567, 3291, 0),
			new WorldPoint(3567, 3292, 0)),
	GUTHANS(new WorldPoint(3574, 3280, 0),
			new WorldPoint(3574, 3281, 0),
			new WorldPoint(3574, 3282, 0),
			new WorldPoint(3574, 3283, 0),
			new WorldPoint(3574, 3284, 0),
			new WorldPoint(3575, 3280, 0),
			new WorldPoint(3575, 3281, 0),
			new WorldPoint(3575, 3282, 0),
			new WorldPoint(3575, 3283, 0),
			new WorldPoint(3575, 3284, 0),
			new WorldPoint(3576, 3280, 0),
			new WorldPoint(3576, 3281, 0),
			new WorldPoint(3576, 3282, 0),
			new WorldPoint(3576, 3283, 0),
			new WorldPoint(3576, 3284, 0),
			new WorldPoint(3577, 3280, 0),
			new WorldPoint(3577, 3281, 0),
			new WorldPoint(3577, 3282, 0),
			new WorldPoint(3577, 3283, 0),
			new WorldPoint(3577, 3284, 0),
			new WorldPoint(3578, 3280, 0),
			new WorldPoint(3578, 3281, 0),
			new WorldPoint(3578, 3282, 0),
			new WorldPoint(3578, 3283, 0),
			new WorldPoint(3578, 3284, 0),
			new WorldPoint(3579, 3280, 0),
			new WorldPoint(3579, 3281, 0),
			new WorldPoint(3579, 3282, 0),
			new WorldPoint(3579, 3283, 0),
			new WorldPoint(3579, 3284, 0),
			new WorldPoint(3580, 3280, 0),
			new WorldPoint(3580, 3281, 0),
			new WorldPoint(3580, 3282, 0),
			new WorldPoint(3580, 3283, 0),
			new WorldPoint(3580, 3284, 0)),
	TORAGS(new WorldPoint(3552, 3281, 0),
			new WorldPoint(3552, 3282, 0),
			new WorldPoint(3552, 3283, 0),
			new WorldPoint(3552, 3284, 0),
			new WorldPoint(3553, 3281, 0),
			new WorldPoint(3553, 3282, 0),
			new WorldPoint(3553, 3283, 0),
			new WorldPoint(3553, 3284, 0),
			new WorldPoint(3554, 3281, 0),
			new WorldPoint(3554, 3282, 0),
			new WorldPoint(3554, 3283, 0),
			new WorldPoint(3554, 3284, 0),
			new WorldPoint(3555, 3281, 0),
			new WorldPoint(3555, 3282, 0),
			new WorldPoint(3555, 3283, 0),
			new WorldPoint(3555, 3284, 0),
			new WorldPoint(3556, 3281, 0),
			new WorldPoint(3556, 3282, 0),
			new WorldPoint(3556, 3283, 0),
			new WorldPoint(3556, 3284, 0)),
	VERACS(new WorldPoint(3555, 3295, 0),
			new WorldPoint(3555, 3296, 0),
			new WorldPoint(3555, 3297, 0),
			new WorldPoint(3555, 3298, 0),
			new WorldPoint(3555, 3299, 0),
			new WorldPoint(3555, 3300, 0),
			new WorldPoint(3556, 3295, 0),
			new WorldPoint(3556, 3296, 0),
			new WorldPoint(3556, 3297, 0),
			new WorldPoint(3556, 3298, 0),
			new WorldPoint(3556, 3299, 0),
			new WorldPoint(3556, 3300, 0),
			new WorldPoint(3557, 3295, 0),
			new WorldPoint(3557, 3296, 0),
			new WorldPoint(3557, 3297, 0),
			new WorldPoint(3557, 3298, 0),
			new WorldPoint(3557, 3299, 0),
			new WorldPoint(3557, 3300, 0),
			new WorldPoint(3558, 3295, 0),
			new WorldPoint(3558, 3296, 0),
			new WorldPoint(3558, 3297, 0),
			new WorldPoint(3558, 3298, 0),
			new WorldPoint(3558, 3299, 0),
			new WorldPoint(3558, 3300, 0),
			new WorldPoint(3559, 3295, 0),
			new WorldPoint(3559, 3296, 0),
			new WorldPoint(3559, 3297, 0),
			new WorldPoint(3559, 3298, 0),
			new WorldPoint(3559, 3299, 0),
			new WorldPoint(3559, 3300, 0)),
	KARILS(new WorldPoint(3563, 3273, 0),
			new WorldPoint(3563, 3274, 0),
			new WorldPoint(3563, 3275, 0),
			new WorldPoint(3563, 3276, 0),
			new WorldPoint(3563, 3277, 0),
			new WorldPoint(3563, 3278, 0),
			new WorldPoint(3563, 3279, 0),
			new WorldPoint(3564, 3273, 0),
			new WorldPoint(3564, 3274, 0),
			new WorldPoint(3564, 3275, 0),
			new WorldPoint(3564, 3276, 0),
			new WorldPoint(3564, 3277, 0),
			new WorldPoint(3564, 3278, 0),
			new WorldPoint(3564, 3279, 0),
			new WorldPoint(3565, 3273, 0),
			new WorldPoint(3565, 3274, 0),
			new WorldPoint(3565, 3275, 0),
			new WorldPoint(3565, 3276, 0),
			new WorldPoint(3565, 3277, 0),
			new WorldPoint(3565, 3278, 0),
			new WorldPoint(3565, 3279, 0),
			new WorldPoint(3566, 3273, 0),
			new WorldPoint(3566, 3274, 0),
			new WorldPoint(3566, 3275, 0),
			new WorldPoint(3566, 3276, 0),
			new WorldPoint(3566, 3277, 0),
			new WorldPoint(3566, 3278, 0),
			new WorldPoint(3566, 3279, 0),
			new WorldPoint(3567, 3273, 0),
			new WorldPoint(3567, 3274, 0),
			new WorldPoint(3567, 3275, 0),
			new WorldPoint(3567, 3276, 0),
			new WorldPoint(3567, 3277, 0),
			new WorldPoint(3567, 3278, 0),
			new WorldPoint(3567, 3279, 0),
			new WorldPoint(3568, 3273, 0),
			new WorldPoint(3568, 3274, 0),
			new WorldPoint(3568, 3275, 0),
			new WorldPoint(3568, 3276, 0),
			new WorldPoint(3568, 3277, 0),
			new WorldPoint(3568, 3278, 0),
			new WorldPoint(3568, 3279, 0),
			new WorldPoint(3569, 3273, 0),
			new WorldPoint(3569, 3274, 0),
			new WorldPoint(3569, 3275, 0),
			new WorldPoint(3569, 3276, 0),
			new WorldPoint(3569, 3277, 0),
			new WorldPoint(3569, 3278, 0),
			new WorldPoint(3569, 3279, 0));
	@Getter
	private static final List<WorldPoint> cryptLocations = new ArrayList<>();

	static
	{
		for (CryptLocations cryptLocation : values())
		{
			cryptLocations.addAll(Arrays.asList(cryptLocation.spots));
		}
	}

	private final WorldPoint[] spots;

	CryptLocations(WorldPoint... spots)
	{
		this.spots = spots;
	}
}
