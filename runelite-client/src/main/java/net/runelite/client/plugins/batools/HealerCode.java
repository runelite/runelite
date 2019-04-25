/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.batools;

import lombok.Getter;


enum HealerCode
{

	WAVEONE(new int[] {1,1}, new int[] {0,0}, new int[] {0,0}),
	WAVETWO(new int[] {1,1,2}, new int[] {0,0,0}, new int[] {0,0,21}),
	WAVETHREE(new int[] {1,6,2}, new int[] {0,0,0}, new int[] {0,0,0}),
	WAVEFOUR(new int[] {2,5,2,0}, new int[] {0,0,7,10}, new int[] {0,0,0,0}),
	WAVEFIVE(new int[] {2,5,2,3,0}, new int[] {0,0,0,0,7}, new int[] {0,0,21,30,0}),
	WAVESIX(new int[] {3,5,3,1,0,0}, new int[] {0,0,0,2,9,10}, new int[] {18,0,0,0,0,0}),
	WAVESEVEN(new int[] {5,2,1,1,0,0,0}, new int[] {0,0,0,0,6,8,10}, new int[] {27,33,0,0,51,0,0}),
	WAVEEIGHT(new int[] {2,8,1,1,0,0,0}, new int[] {1,0,1,1,3,1,10}, new int[] {36,0,33,39,45,48,0}),
	WAVENINE(new int[] {2,8,1,1,0,0,0,0}, new int[] {1,1,1,1,1,1,1,10}, new int[] {0,21,0,0,0,0,0,0,0}),
	WAVETEN(new int[] {5,2,1,1,0,0,0}, new int[] {0,1,1,1,3,3,10}, new int[] {27,33,0,0,51,0,0});


	@Getter
	private final int[] firstCallFood;
	@Getter
	private final int[] secondCallFood;
	@Getter
	private final int[] spacing;

	HealerCode(int[] firstCallFood, int[] secondCallFood, int[] spacing)
	{
		this.firstCallFood = firstCallFood;
		this.secondCallFood = secondCallFood;
		this.spacing = spacing;
	}
}
