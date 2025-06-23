/*
 * Copyright (c) 2025, Rikten X <riktenx@gmail.com>
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
package net.runelite.client.audio;

import jaco.mp3.resources.BitstreamException;
import jaco.mp3.resources.Decoder;
import jaco.mp3.resources.DecoderException;
import jaco.mp3.resources.Frame;
import jaco.mp3.resources.SampleBuffer;
import jaco.mp3.resources.SoundStream;
import java.io.IOException;
import java.io.InputStream;

class MP3SampleStream extends InputStream
{
	private final SoundStream soundStream;
	private final Decoder decoder;

	private byte[] currentSamples = null;
	private int currentOffset = 0;

	public MP3SampleStream(InputStream stream)
	{
		soundStream = new SoundStream(stream);
		decoder = new Decoder();
	}

	@Override
	public int read() throws IOException
	{
		if (currentSamples == null)
		{
			if (!fillSampleBuffer())
			{
				return -1;
			}
		}

		byte next = currentSamples[currentOffset++];
		if (currentOffset == currentSamples.length)
		{
			currentSamples = null;
			currentOffset = 0;
		}

		return next & 0xff;
	}

	private boolean fillSampleBuffer() throws IOException
	{
		try
		{
			Frame frame = soundStream.readFrame();
			if (frame == null)
			{
				return false;
			}

			SampleBuffer samples = (SampleBuffer) decoder.decodeFrame(frame, soundStream);
			currentSamples = toBytes(samples.getBuffer());
			soundStream.closeFrame();
		}
		catch (BitstreamException | DecoderException e)
		{
			throw new IOException(e);
		}

		return true;
	}

	private static byte[] toBytes(short[] samples)
	{
		byte[] buf = new byte[samples.length * 2];
		int i = 0;

		for (short sample : samples)
		{
			buf[i++] = (byte) sample;
			buf[i++] = (byte) (sample >>> 8);
		}

		return buf;
	}

	@Override
	public void close() throws IOException
	{
		try
		{
			soundStream.close();
		}
		catch (BitstreamException e)
		{
			throw new IOException(e);
		}
	}
}
