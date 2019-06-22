/*
 * Copyright (c) 2019, Kyleeld <https://github.com/kyleeld>
 * Copyright (c) 2019, RuneLitePlus <https://runelitepl.us>
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
package net.runelite.client.plugins.inferno;

import java.util.HashMap;
import java.util.Map;

public class InfernoWaveMappings
	{
	static Map<Integer, int[]> waveMapping()
		{
			return new HashMap<Integer, int[]>()
			{
				{
				put(1, new int[]{32, 32, 32, 85});
				put(2, new int[]{32, 32, 32, 85, 85});
				put(3, new int[]{32, 32, 32, 32, 32, 32});
				put(4, new int[]{32, 32, 32, 165});
				put(5, new int[]{32, 32, 32, 85, 165});
				put(6, new int[]{32, 32, 32, 85, 85, 165});
				put(7, new int[]{32, 32, 32, 165, 165});
				put(8, new int[]{32, 32, 32, 32, 32, 32});
				put(9, new int[]{32, 32, 32, 240});
				put(10, new int[]{32, 32, 32, 85, 240});
				put(11, new int[]{32, 32, 32, 85, 85, 240});
				put(12, new int[]{32, 32, 32, 165, 240});
				put(13, new int[]{32, 32, 32, 85, 165, 240});
				put(14, new int[]{32, 32, 32, 85, 85, 165, 240});
				put(15, new int[]{32, 32, 32, 165, 165, 240});
				put(16, new int[]{32, 32, 32, 240, 240});
				put(17, new int[]{32, 32, 32, 32, 32, 32});
				put(18, new int[]{32, 32, 32, 370});
				put(19, new int[]{32, 32, 32, 85, 370});
				put(20, new int[]{32, 32, 32, 85, 85, 370});
				put(21, new int[]{32, 32, 32, 165, 370});
				put(22, new int[]{32, 32, 32, 85, 165, 370});
				put(23, new int[]{32, 32, 32, 85, 85, 165, 370});
				put(24, new int[]{32, 32, 32, 165, 165, 370});
				put(25, new int[]{32, 32, 32, 240, 370});
				put(26, new int[]{32, 32, 32, 85, 240, 370});
				put(27, new int[]{32, 32, 32, 85, 85, 240, 370});
				put(28, new int[]{32, 32, 32, 165, 240, 370});
				put(29, new int[]{32, 32, 32, 85, 165, 240, 370});
				put(30, new int[]{32, 32, 32, 85, 85, 165, 240, 370});
				put(31, new int[]{32, 32, 32, 165, 165, 240, 370});
				put(32, new int[]{32, 32, 32, 240, 240, 370});
				put(33, new int[]{32, 32, 32, 370, 370});
				put(34, new int[]{32, 32, 32, 32, 32, 32});
				put(35, new int[]{32, 32, 32, 490});
				put(36, new int[]{32, 32, 32, 85, 490});
				put(37, new int[]{32, 32, 32, 85, 85, 490});
				put(38, new int[]{32, 32, 32, 165, 490});
				put(39, new int[]{32, 32, 32, 85, 165, 490});
				put(40, new int[]{32, 32, 32, 85, 85, 165, 490});
				put(41, new int[]{32, 32, 32, 165, 165, 490});
				put(42, new int[]{32, 32, 32, 240, 490});
				put(43, new int[]{32, 32, 32, 85, 240, 490});
				put(44, new int[]{32, 32, 32, 85, 85, 240, 490});
				put(45, new int[]{32, 32, 32, 165, 240, 490 });
				put(46, new int[]{32, 32, 32, 85, 165, 240, 490});
				put(47, new int[]{32, 32, 32, 85, 85, 165, 240, 490});
				put(48, new int[]{32, 32, 32, 165, 165, 240, 490});
				put(49, new int[]{32, 32, 32, 240, 240, 490});
				put(50, new int[]{32, 32, 32, 370, 490});
				put(51, new int[]{32, 32, 32, 85, 370, 490});
				put(52, new int[]{32, 32, 32, 85, 85, 370, 490});
				put(53, new int[]{32, 32, 32, 165, 370, 490});
				put(54, new int[]{32, 32, 32, 85, 165, 370, 490});
				put(55, new int[]{32, 32, 32, 85, 85, 165, 370, 490});
				put(56, new int[]{32, 32, 32, 165, 165, 370, 490});
				put(57, new int[]{32, 32, 32, 240, 370, 490});
				put(58, new int[]{32, 32, 32, 85, 240, 370, 490});
				put(59, new int[]{32, 32, 32, 85, 85, 240, 370, 490});
				put(60, new int[]{32, 32, 32, 165, 240, 370, 490});
				put(61, new int[]{32, 32, 32, 85, 165, 240, 370, 490});
				put(62, new int[]{32, 32, 32, 85, 85, 165, 240, 370, 490});
				put(63, new int[]{32, 32, 32, 165, 165, 240, 370, 490});
				put(64, new int[]{32, 32, 32, 85, 240, 240, 370, 490});
				put(65, new int[]{32, 32, 32, 85, 370, 370, 490});
				put(66, new int[]{32, 32, 32, 85, 490, 490});
				put(67, new int[]{900});
				put(68, new int[]{900, 900, 900});
				put(69, new int[]{1400});

				}
			};
		}

	static Map<Integer, String> npcNameMapping()
		{
			return new HashMap<Integer, String>()
			{
				{
				put(32, "Jal-Nib - Level 32");
				put(85, " Jal-MejRah - Level 85");
				put(165, "Jal-Ak - Level 165");
				put(240, "Jal-ImKot - Level 240");
				put(370, "Jal-Xil - Level 370");
				put(490, "Jal-Zek - Level 490");
				put(900, "JalTok-Jad - Level 900");
				put(1400, "TzKal-Zuk - Level 1400");
				}
			};
		}

	static HashMap intArrayToHashmap(int inputArray[])
		{
			HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
			for (int i : inputArray)
				{
				if (elementCountMap.containsKey(i))
					{
					elementCountMap.put(i, elementCountMap.get(i) + 1);
					}
				else
					{
					elementCountMap.put(i, 1);
					}
				}
			return elementCountMap;
		}
	}