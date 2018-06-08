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

public class InstrumentDefinition
{
	public AudioEnvelopeDefinition volume;
	public AudioEnvelopeDefinition pitchModifier;
	public AudioEnvelopeDefinition field1175;
	public int duration = 500;
	public int[] oscillatorDelays = new int[]
	{
		0, 0, 0, 0, 0
	};
	public AudioEnvelopeDefinition release;
	public int[] oscillatorPitch = new int[]
	{
		0, 0, 0, 0, 0
	};
	public int[] oscillatorVolume = new int[]
	{
		0, 0, 0, 0, 0
	};
	public AudioEnvelopeDefinition pitch;
	public SoundEffectDefinition filter;
	public AudioEnvelopeDefinition volumeMultiplier;
	public int delayDecay = 100;
	public AudioEnvelopeDefinition filterEnvelope;
	public int delayTime = 0;
	public int offset = 0;
	public AudioEnvelopeDefinition volumeMultiplierAmplitude;
	public AudioEnvelopeDefinition pitchModifierAmplitude;
}
