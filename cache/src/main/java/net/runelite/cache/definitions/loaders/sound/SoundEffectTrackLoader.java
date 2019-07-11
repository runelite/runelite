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

import net.runelite.cache.definitions.sound.SoundEffectTrackDefinition;
import net.runelite.cache.definitions.sound.InstrumentDefinition;
import net.runelite.cache.io.InputStream;

public class SoundEffectTrackLoader
{
	public SoundEffectTrackDefinition load(byte[] b)
	{
		SoundEffectTrackDefinition soundEffect = new SoundEffectTrackDefinition();
		InputStream in = new InputStream(b);

		load(soundEffect, in);

		return soundEffect;
	}

	private void load(SoundEffectTrackDefinition soundEffect, InputStream in)
	{
		for (int i = 0; i < 10; ++i)
		{
			int volume = in.readUnsignedByte();
			if (volume != 0)
			{
				in.setOffset(in.getOffset() - 1);

				InstrumentLoader instrumentLoader = new InstrumentLoader();
				InstrumentDefinition instrument = instrumentLoader.load(in);

				soundEffect.instruments[i] = instrument;
			}
		}

		soundEffect.start = in.readUnsignedShort();
		soundEffect.end = in.readUnsignedShort();
	}
}