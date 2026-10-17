/*
 * Copyright (c) 2026
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

public class AudioPlayerTest
{
	private final SdlAudio output = mock(SdlAudio.class);
	private final AudioPlayer player = new AudioPlayer(output);

	private byte[] encode(AudioFormat format, byte[] pcm, AudioFileFormat.Type type) throws Exception
	{
		ByteArrayOutputStream file = new ByteArrayOutputStream();
		try (AudioInputStream input = new AudioInputStream(new ByteArrayInputStream(pcm), format, pcm.length / format.getFrameSize()))
		{
			AudioSystem.write(input, type, file);
		}
		return file.toByteArray();
	}

	@Test
	public void decodesWavAndConvertsDecibelsToLinearGain() throws Exception
	{
		byte[] pcm = {0, 0, 0, 64, 0, (byte) 192};
		byte[] wav = encode(new AudioFormat(22050, 16, 1, true, false), pcm, AudioFileFormat.Type.WAVE);
		player.play(new ByteArrayInputStream(wav), -6);
		ArgumentCaptor<byte[]> data = ArgumentCaptor.forClass(byte[].class);
		ArgumentCaptor<Float> gain = ArgumentCaptor.forClass(Float.class);
		verify(output).play(data.capture(), eq(22050), eq(1), gain.capture());
		assertArrayEquals(pcm, data.getValue());
		assertEquals(0.501187f, gain.getValue(), 0.000001f);
	}

	@Test
	public void convertsBigEndianAiffToLittleEndianPcm() throws Exception
	{
		byte[] aiff = encode(new AudioFormat(48000, 16, 2, true, true), new byte[]{0x12, 0x34, 0x56, 0x78}, AudioFileFormat.Type.AIFF);
		player.play(new ByteArrayInputStream(aiff), 0);
		ArgumentCaptor<byte[]> data = ArgumentCaptor.forClass(byte[].class);
		verify(output).play(data.capture(), eq(48000), eq(2), eq(1f));
		assertArrayEquals(new byte[]{0x34, 0x12, 0x78, 0x56}, data.getValue());
	}

	@Test
	public void convertsUnsignedEightBitWav() throws Exception
	{
		byte[] wav = encode(new AudioFormat(44100, 8, 1, false, false), new byte[]{0, (byte) 128, (byte) 255}, AudioFileFormat.Type.WAVE);
		player.play(new ByteArrayInputStream(wav), 0);
		ArgumentCaptor<byte[]> data = ArgumentCaptor.forClass(byte[].class);
		verify(output).play(data.capture(), eq(44100), eq(1), eq(1f));
		assertEquals(6, data.getValue().length);
		assertEquals(0, data.getValue()[2]);
		assertEquals(0, data.getValue()[3]);
	}

	@Test(expected = UnsupportedAudioFileException.class)
	public void rejectsUnrecognizedFileBeforeAllocatingNativeResources() throws Exception
	{
		try
		{
			player.play(new ByteArrayInputStream(new byte[20]), 0);
		}
		finally
		{
			verifyNoInteractions(output);
		}
	}
}
