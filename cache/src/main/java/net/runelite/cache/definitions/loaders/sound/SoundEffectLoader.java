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

import net.runelite.cache.definitions.sound.AudioEnvelopeDefinition;
import net.runelite.cache.definitions.sound.SoundEffectDefinition;
import net.runelite.cache.io.InputStream;

public class SoundEffectLoader
{
	private final AudioEnvelopeLoader audioEnvelopeLoader = new AudioEnvelopeLoader();

	public SoundEffectDefinition load(InputStream in, AudioEnvelopeDefinition audioEnvelope)
	{
		SoundEffectDefinition soundEffect = new SoundEffectDefinition();

		load(soundEffect, audioEnvelope, in);

		return soundEffect;
	}

	private void load(SoundEffectDefinition soundEffect, AudioEnvelopeDefinition audioEnvelope, InputStream in)
	{
		int id = in.readUnsignedByte();
		soundEffect.pairs[0] = id >> 4;
		soundEffect.pairs[1] = id & 15;
		if (id != 0)
		{
			soundEffect.unity[0] = in.readUnsignedShort();
			soundEffect.unity[1] = in.readUnsignedShort();
			int track = in.readUnsignedByte();

			for (int i = 0; i < 2; ++i)
			{
				for (int j = 0; j < soundEffect.pairs[i]; ++j)
				{
					soundEffect.phases[i][0][j] = in.readUnsignedShort();
					soundEffect.magnitudes[i][0][j] = in.readUnsignedShort();
				}
			}

			for (int i = 0; i < 2; ++i)
			{
				for (int j = 0; j < soundEffect.pairs[i]; ++j)
				{
					if ((track & 1 << i * 4 << j) != 0)
					{
						soundEffect.phases[i][1][j] = in.readUnsignedShort();
						soundEffect.magnitudes[i][1][j] = in.readUnsignedShort();
					}
					else
					{
						soundEffect.phases[i][1][j] = soundEffect.phases[i][0][j];
						soundEffect.magnitudes[i][1][j] = soundEffect.magnitudes[i][0][j];
					}
				}
			}

			if (track != 0 || soundEffect.unity[1] != soundEffect.unity[0])
			{
				audioEnvelopeLoader.loadSegments(audioEnvelope, in);
			}
		}
		else
		{
			int[] clean = soundEffect.unity;
			soundEffect.unity[1] = 0;
			clean[0] = 0;
		}
	}
}