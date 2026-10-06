/*
 * Copyright (c) 2026, Tony Ketcham <tonyketcham@gmail.com>
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

import static org.junit.Assert.*;

import com.sun.jna.Platform;

import org.junit.Assume;
import org.junit.Test;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

/** Run explicitly with -Drunelite.audio.testWaveOut=true on a Windows playback device. */
public class WindowsWaveOutIntegrationTest
{
	@Test(timeout = 10000)
	public void streamsThroughJavaSoundSpi() throws Exception
	{
		Assume.assumeTrue(Platform.isWindows() && Boolean.getBoolean("runelite.audio.testWaveOut"));
		String key = "javax.sound.sampled.SourceDataLine";
		String previous = System.getProperty(key);
		System.setProperty(key, WindowsWaveOutProvider.class.getName());
		AudioFormat format = new AudioFormat(22050, 16, 2, true, false);
		SourceDataLine line = null;
		try
		{
			line = AudioSystem.getSourceDataLine(format);
			assertTrue(line instanceof WindowsWaveOutProvider.OutputLine);
			line.open(format, 4096);
			line.start();
			byte[] silence = new byte[88200];
			assertEquals(88200, line.write(silence, 0, silence.length));
			line.drain();
			assertEquals(22050, line.getLongFramePosition());
			assertEquals(line.getBufferSize(), line.available());
			line.stop();
			line.flush();
			line.start();
			assertEquals(4096, line.write(silence, 0, 4096));
			line.drain();
			assertEquals(23074, line.getLongFramePosition());
			line.close();
			line.open(format, 4096);
			line.close();
		}
			finally
			{
			if (line != null) line.close();
			if (previous == null) System.clearProperty(key);
			else System.setProperty(key, previous);
		}
	}
}
