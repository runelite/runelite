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
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import net.runelite.client.util.Filepath;

/**
 * General audio playback manager.
 * RuneLite initializes the shared SDL output on its main thread during startup.
 * That thread then runs the SDL event loop for output maintenance and sound cleanup.
 * Java Sound is used only for file decoding; SDL handles output and format conversion.
 * Not all audio formats are supported. Refer to {@link javax.sound.sampled.AudioFileFormat.Type} for a list of
 * formats supported by the sound system.
 */
@Singleton
public class AudioPlayer
{
	private final SdlAudio output;

	public AudioPlayer()
	{
		this(SdlAudio.getDefault());
	}

	AudioPlayer(SdlAudio output)
	{
		this.output = output;
	}

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
	 * Plays an audio stream loaded from a filepath.
	 *
	 * @param file The file object pointing to the audio data.
	 * @param gain Gain control (in dB) to apply to audio playback.
	 */
	public void play(Filepath file, float gain)
		throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		try (BufferedInputStream stream = new BufferedInputStream(file.openInputStream()))
		{
			play(stream, gain);
		}
	}

	/**
	 * Plays an audio stream loaded from a resource.
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
			AudioFormat source = audio.getFormat();
			AudioFormat pcm = new AudioFormat(source.getSampleRate(), 16, source.getChannels(), true, false);
			if (!AudioSystem.isConversionSupported(pcm, source))
			{
				throw new UnsupportedAudioFileException("Cannot decode audio as signed 16-bit PCM: " + source);
			}
			try (AudioInputStream decoded = AudioSystem.getAudioInputStream(pcm, audio))
			{
				// Clip.open also buffered the entire decoded file. SDL copies it and handles resampling.
				output.play(decoded.readAllBytes(), (int) pcm.getSampleRate(), pcm.getChannels(),
					(float) Math.pow(10, gain / 20));
			}
		}
	}
}
