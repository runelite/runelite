/*
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.roguesden;

import com.google.common.collect.Sets;
import java.util.Set;
import static net.runelite.api.ObjectID.*;
import static net.runelite.api.NullObjectID.*;

class Obstacles
{
	public static final Set<Integer> OBSTACLE_IDS_HULL = Sets.newHashSet(
			SPINNING_BLADES_7224,
			CONTORTION_BARS,
			PENDULUM,
			WALL_7249,	/*Wall crushers*/
			WALL_7248,	/*Wall blade*/
			LEDGE_7240,	/*Ledge climb*/
			NULL_7235	/*Wall safe*/
	);

	public static final Set<Integer> OBSTACLE_IDS_TILE = Sets.newHashSet(
			FLOOR,		/*Floor spikes*/
			WALL_7228,	/*Wall spikes*/
			WALL_7229,	/*Wall spears*/
			FLOOR_7245,	/*Pressure pad a*/
			FLOOR_7230,	/*Pressure pad b*/
			BLADE_7252,	/*Floor blade*/
			7239		/*Bridge [Ground object]*/
	);
}
