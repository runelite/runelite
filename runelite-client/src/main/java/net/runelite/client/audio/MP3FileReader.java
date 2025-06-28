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
import jaco.mp3.resources.Frame;
import jaco.mp3.resources.SoundStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;

public class MP3FileReader extends AudioFileReader
{
	private static final AudioFileFormat.Type TYPE_MP3 = new AudioFileFormat.Type("MP3", "mp3");

	@Override
	public AudioFileFormat getAudioFileFormat(InputStream stream) throws UnsupportedAudioFileException, IOException
	{
		return getFormat(stream);
	}

	@Override
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException
	{
		throw new UnsupportedAudioFileException("MP3FileReader does not support URL");
	}

	@Override
	public AudioFileFormat getAudioFileFormat(File file) throws UnsupportedAudioFileException, IOException
	{
		try (FileInputStream stream = new FileInputStream(file))
		{
			return getFormat(stream);
		}
	}

	@Override
	public AudioInputStream getAudioInputStream(InputStream stream) throws UnsupportedAudioFileException, IOException
	{
		AudioFileFormat format = getFormat(stream);
		return new AudioInputStream(new MP3SampleStream(stream), format.getFormat(), AudioSystem.NOT_SPECIFIED);
	}

	@Override
	public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException
	{
		throw new UnsupportedAudioFileException("MP3FileReader does not support URL");
	}

	@Override
	public AudioInputStream getAudioInputStream(File file) throws UnsupportedAudioFileException, IOException
	{
		return getAudioInputStream(new FileInputStream(file));
	}

	private AudioFileFormat getFormat(InputStream stream) throws UnsupportedAudioFileException, IOException
	{
		stream.mark(stream.available());

		Frame frame;
		try
		{
			SoundStream soundStream = new SoundStream(stream);
			frame = soundStream.readFrame();
		}
		catch (BitstreamException ignored)
		{
			// based on jaco-mp3 source, BitstreamException can be thrown for invalid/corrupted MP3 data, so just treat
			// this as unsupported
			stream.reset();
			throw new UnsupportedAudioFileException("non-mp3 input");
		}

		stream.reset();
		if (frame == null)
		{
			throw new UnsupportedAudioFileException("non-mp3 input");
		}

		int channels = frame.mode() == Frame.SINGLE_CHANNEL ? 1 : 2;
		AudioFormat format = new AudioFormat(frame.frequency(), 16, channels, true, false);

		return new AudioFileFormat(TYPE_MP3, format, AudioSystem.NOT_SPECIFIED);
	}
}
