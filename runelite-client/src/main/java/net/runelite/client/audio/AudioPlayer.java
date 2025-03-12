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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Singleton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import lombok.extern.slf4j.Slf4j;

/**
 * General audio playback manager.
 * Not all audio formats are supported. Refer to {@link javax.sound.sampled.AudioFileFormat.Type} for a list of
 * formats supported by the sound system.
 */
@Singleton
@Slf4j
public class AudioPlayer
{
	// We RETAIN one line in the "open" state at all times so a gain control persists in output mixing tools.
	private Line prevLine;

	/**
	 * Plays an audio stream loaded from a file object.
	 *
	 * @param file The file object pointing to the audio data.
	 * @param gain Gain control (in dB) to apply to audio playback.
	 */
	public void play(File file, float gain)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file)))
		{
			play(stream, gain);
		}
	}

	/**
	 * Plays an audio stream loaded from a class resource.
	 *
	 * @param c    The class with which to load the resource.
	 * @param path The class resource path.
	 * @param gain Gain control (in dB) to apply to audio playback.
	 */
	public void play(Class<?> c, String path, float gain)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		try (BufferedInputStream stream = new BufferedInputStream(c.getResourceAsStream(path)))
		{
			play(stream, gain);
		}
	}

	/**
	 * Plays an audio stream from the provided input stream.
	 *
	 * @param stream The input stream containing the audio data.
	 * @param gain   Gain control (in dB) to apply to audio playback.
	 */
	public void play(InputStream stream, float gain)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		try (AudioInputStream audio = AudioSystem.getAudioInputStream(stream))
		{
			DataLine line = getSelfClosingLine(audio);

			if (gain != 0)
			{
				trySetGain(line, gain);
			}

			line.start();
		}
	}

	private DataLine getSelfClosingLine(AudioInputStream stream) throws IOException, LineUnavailableException
	{
		// Clip is convenient because it will just buffer the entire stream with open(audio) rather than us having to
		// write() to it.
		Clip clip = AudioSystem.getClip();

		try
		{
			clip.open(stream);
		}
		catch (IOException e)
		{
			clip.close();
			throw e;
		}

		clip.addLineListener(event ->
		{
			if (event.getType() != LineEvent.Type.STOP)
			{
				return;
			}

			synchronized (this) // We cut off the old line, and this one becomes the new "retainer".
			{
				if (prevLine != null)
				{
					prevLine.close();
				}

				prevLine = clip;
			}
		});

		return clip;
	}

	private void trySetGain(DataLine line, float gain)
	{
		try
		{
			FloatControl control = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(gain);
		}
		catch (Exception e)
		{
			log.warn("Failed to set gain: {}", e.getMessage());
		}
	}
}
