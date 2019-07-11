/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.definitions.sound;

public class AudioEnvelopeDefinition
{
	public int segments = 2;
	public int[] durations = new int[2];
	public int[] phases = new int[2];
	public int start;
	public int end;
	public int form;
	public int ticks;
	public int phaseIndex;
	public int step;
	public int amplitude;
	public int max;

	public AudioEnvelopeDefinition()
	{
		this.durations[0] = 0;
		this.durations[1] = '\uffff';
		this.phases[0] = 0;
		this.phases[1] = '\uffff';
	}

	public final int step(int var1)
	{
		if (this.max >= this.ticks)
		{
			this.amplitude = this.phases[this.phaseIndex++] << 15;

			if (this.phaseIndex >= this.segments)
			{
				this.phaseIndex = this.segments - 1;
			}

			this.ticks = (int) ((double) this.durations[this.phaseIndex] / 65536.0 * (double) var1);

			if (this.ticks > this.max)
			{
				this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
			}
		}
		this.amplitude += this.step;
		++this.max;

		return this.amplitude - this.step >> 15;
	}

	public final void reset()
	{
		this.ticks = 0;
		this.phaseIndex = 0;
		this.step = 0;
		this.amplitude = 0;
		this.max = 0;
	}
}