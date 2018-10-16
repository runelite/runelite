/*
 * Copyright (c) 2018, DaveInga <https://github.com/daveinga>
 *
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
package net.runelite.client.plugins.fightcave;

import java.util.HashMap;
import java.util.Map;

public class FightCaveMappings
{
	static Map<Integer, int[]> waveMapping()
	{
		return new HashMap<Integer, int[]>()
		{
			{
				put(1, new int[]{22});
				put(2, new int[]{22, 22});
				put(3, new int[]{45, 221, 221});
				put(4, new int[]{45, 221, 221, 22});
				put(5, new int[]{45, 221, 221, 22, 22});
				put(6, new int[]{45, 221, 221, 45, 221, 221});
				put(7, new int[]{90});
				put(8, new int[]{90, 22});
				put(9, new int[]{90, 22, 22});
				put(10, new int[]{90, 45, 221, 221});
				put(11, new int[]{90, 45, 221, 221, 22});
				put(12, new int[]{90, 45, 221, 221, 22, 22});
				put(13, new int[]{90, 45, 221, 221, 45, 221, 221});
				put(14, new int[]{90, 90});
				put(15, new int[]{180});
				put(16, new int[]{180, 22});
				put(17, new int[]{180, 22, 22});
				put(18, new int[]{180, 45, 221, 221});
				put(19, new int[]{180, 45, 221, 221, 22});
				put(20, new int[]{180, 45, 221, 221, 22, 22});
				put(21, new int[]{180, 45, 221, 221, 45, 221, 221});
				put(22, new int[]{180, 90});
				put(23, new int[]{180, 90, 22});
				put(24, new int[]{180, 90, 22, 22});
				put(25, new int[]{180, 90, 45, 221, 221});
				put(26, new int[]{180, 90, 45, 221, 221, 22});
				put(27, new int[]{180, 90, 45, 221, 221, 22, 22});
				put(28, new int[]{180, 90, 45, 221, 221, 45, 221, 221});
				put(29, new int[]{180, 90, 90});
				put(30, new int[]{180, 180});
				put(31, new int[]{360});
				put(32, new int[]{360, 22});
				put(33, new int[]{360, 22, 22});
				put(34, new int[]{360, 45, 221, 221});
				put(35, new int[]{360, 45, 221, 221, 22});
				put(36, new int[]{360, 45, 221, 221, 22, 22});
				put(37, new int[]{360, 45, 221, 221, 45, 221, 221});
				put(38, new int[]{360, 90});
				put(39, new int[]{360, 90, 22});
				put(40, new int[]{360, 90, 22, 22});
				put(41, new int[]{360, 90, 45, 221, 221});
				put(42, new int[]{360, 90, 45, 221, 221, 22});
				put(43, new int[]{360, 90, 45, 221, 221, 22, 22});
				put(44, new int[]{360, 90, 45, 221, 221, 45, 221, 221});
				put(45, new int[]{360, 90, 90});
				put(46, new int[]{360, 180});
				put(47, new int[]{360, 180, 22});
				put(48, new int[]{360, 180, 22, 22});
				put(49, new int[]{360, 180, 45, 221, 221});
				put(50, new int[]{360, 180, 45, 221, 221, 22});
				put(51, new int[]{360, 180, 45, 221, 221, 22, 22});
				put(52, new int[]{360, 180, 45, 221, 221, 45, 221, 221});
				put(53, new int[]{360, 180, 90});
				put(54, new int[]{360, 180, 90, 22});
				put(55, new int[]{360, 180, 90, 22, 22});
				put(56, new int[]{360, 180, 90, 45, 221, 221});
				put(57, new int[]{360, 180, 90, 45, 221, 221, 22});
				put(58, new int[]{360, 180, 90, 45, 221, 221, 22, 22});
				put(59, new int[]{360, 180, 90, 45, 221, 221, 45, 221, 221});
				put(60, new int[]{360, 180, 90, 90});
				put(61, new int[]{360, 180, 180});
				put(62, new int[]{360, 360});
				put(63, new int[]{702, 108, 108, 108});
			}
		};
	}

	static Map<Integer, String> npcNameMapping()
	{
		return new HashMap<Integer, String>()
		{
			{
				put(22, "Tz-Kih - Level 22");
				put(45, "Tz-Kek - Level 45");
				put(221, "Tz-Kek - Level 22");
				put(90, "Tok-Xil - Level 90");
				put(180, "Yt-MejKot - Level 180");
				put(360, "Ket-Zek - Level 360");
				put(702, "TzTok-Jad - Level 702");
				put(108, "Yt-HurKot - Level 108");
			}
		};
	}
}
