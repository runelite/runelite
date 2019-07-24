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
import net.runelite.cache.io.InputStream;

public class AudioEnvelopeLoader
{
	public AudioEnvelopeDefinition load(InputStream in)
	{
		AudioEnvelopeDefinition audioEnvelope = new AudioEnvelopeDefinition();

		load(audioEnvelope, in);

		return audioEnvelope;
	}

	private void load(AudioEnvelopeDefinition audioEnvelope, InputStream in)
	{
		audioEnvelope.form = in.readUnsignedByte();
		audioEnvelope.start = in.readInt();
		audioEnvelope.end = in.readInt();
		this.loadSegments(audioEnvelope, in);
	}

	final void loadSegments(AudioEnvelopeDefinition audioEnvelope, InputStream in)
	{
		audioEnvelope.segments = in.readUnsignedByte();
		audioEnvelope.durations = new int[audioEnvelope.segments];
		audioEnvelope.phases = new int[audioEnvelope.segments];

		for (int i = 0; i < audioEnvelope.segments; ++i)
		{
			audioEnvelope.durations[i] = in.readUnsignedShort();
			audioEnvelope.phases[i] = in.readUnsignedShort();
		}

	}
}