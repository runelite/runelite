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
package net.runelite.cache.definitions.loaders.sound;

import net.runelite.cache.definitions.sound.InstrumentDefinition;
import net.runelite.cache.definitions.sound.AudioEnvelopeDefinition;
import net.runelite.cache.io.InputStream;

public class InstrumentLoader
{
	private final AudioEnvelopeLoader aeLoader = new AudioEnvelopeLoader();
	private final SoundEffectLoader seLoader = new SoundEffectLoader();

	public InstrumentDefinition load(InputStream in)
	{
		InstrumentDefinition instrument = new InstrumentDefinition();

		load(instrument, in);

		return instrument;
	}

	private void load(InstrumentDefinition instrument, InputStream in)
	{
		instrument.pitch = aeLoader.load(in);
		instrument.volume = aeLoader.load(in);
		int volume = in.readUnsignedByte();
		if (volume != 0)
		{
			in.setOffset(in.getOffset() - 1);
			instrument.pitchModifier = aeLoader.load(in);
			instrument.pitchModifierAmplitude = aeLoader.load(in);
		}

		volume = in.readUnsignedByte();
		if (volume != 0)
		{
			in.setOffset(in.getOffset() - 1);
			instrument.volumeMultiplier = aeLoader.load(in);
			instrument.volumeMultiplierAmplitude = aeLoader.load(in);
		}

		volume = in.readUnsignedByte();
		if (volume != 0)
		{
			in.setOffset(in.getOffset() - 1);
			instrument.release = aeLoader.load(in);
			instrument.field1175 = aeLoader.load(in);
		}

		for (int i = 0; i < 10; ++i)
		{
			int vol = in.readUnsignedShortSmart();
			if (vol == 0)
			{
				break;
			}

			instrument.oscillatorVolume[i] = vol;
			instrument.oscillatorPitch[i] = in.readShortSmart();
			instrument.oscillatorDelays[i] = in.readUnsignedShortSmart();
		}

		instrument.delayTime = in.readUnsignedShortSmart();
		instrument.delayDecay = in.readUnsignedShortSmart();
		instrument.duration = in.readUnsignedShort();
		instrument.offset = in.readUnsignedShort();
		instrument.filterEnvelope = new AudioEnvelopeDefinition();
		instrument.filter = seLoader.load(in, instrument.filterEnvelope);
	}
}