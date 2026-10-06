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

import com.sun.jna.Platform;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.Test;

/** Run explicitly with -Drunelite.audio.testWaveOut=true on a Windows playback device. */
public class WindowsWaveOutIntegrationTest
{
	@Test(timeout = 10000)
	public void streamsThroughJavaSoundSpi() throws Exception
	{
		Assume.assumeTrue(Platform.isWindows() && Boolean.getBoolean("runelite.audio.testWaveOut"));
		String key = "javax.sound.sampled.SourceDataLine";
		String previous = System.getProperty(key);
		assertTrue(WindowsWaveOutProvider.initialize(true, () ->
		{
			throw new LineUnavailableException("Default backend failed");
		}, () -> new WindowsWaveOutProvider.OutputLine()));
		AudioFormat format = new AudioFormat(22050, 16, 2, true, false);
		SourceDataLine line = null;
		try
		{
			line = (SourceDataLine) AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, format, 4096));
			assertTrue(line instanceof WindowsWaveOutProvider.OutputLine);
			line.open();
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
			line.open();
			line.close();
		}
		finally
		{
			if (line != null)
			{
				line.close();
			}
			if (previous == null)
			{
				System.clearProperty(key);
			}
			else
			{
				System.setProperty(key, previous);
			}
		}
	}
	@Test(timeout = 10000)
	public void gameCallPatternHonorsMonoFormatAndBuffer() throws Exception
	{
		Assume.assumeTrue(Platform.isWindows() && Boolean.getBoolean("runelite.audio.testWaveOut"));
		String previous = System.getProperty(WindowsWaveOutProvider.PROPERTY);
		try
		{
			assertTrue(WindowsWaveOutProvider.initialize(true, () ->
			{
				throw new LineUnavailableException("Default backend failed");
			}, () -> new WindowsWaveOutProvider.OutputLine()));
			AudioFormat mono = new AudioFormat(44100, 16, 1, true, false);
			try (SourceDataLine line =
						(SourceDataLine) AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, mono, 2048)))
			{
				line.open();
				assertTrue(line.getFormat().matches(mono));
				assertEquals(2048, line.getBufferSize());
				line.start();
				assertEquals(22050, line.write(new byte[22050], 0, 22050));
				line.drain();
				assertEquals(11025, line.getLongFramePosition());
			}
		}
		finally
		{
			restoreSelection(previous);
		}
	}

	@Test(timeout = 10000)
	public void recoversWhenActualDefaultCannotOpenGameLine() throws Exception
	{
		Assume.assumeTrue(Platform.isWindows() && Boolean.getBoolean("runelite.audio.testWaveOut"));
		String previous = System.getProperty(WindowsWaveOutProvider.PROPERTY);
		AudioFormat format = new AudioFormat(22050, 16, 2, true, false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format, 8192);
		boolean unavailable = false;
		try (SourceDataLine primary = (SourceDataLine) AudioSystem.getLine(info))
		{
			primary.open();
		}
		catch (LineUnavailableException | IllegalArgumentException expected)
		{
			unavailable = true;
		}
		Assume.assumeTrue("The default backend works on this device", unavailable);
		try
		{
			WindowsWaveOutProvider.initialize();
			assertEquals(WindowsWaveOutProvider.class.getName(), System.getProperty(WindowsWaveOutProvider.PROPERTY));
			try (SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info))
			{
				assertTrue(line instanceof WindowsWaveOutProvider.OutputLine);
				line.open();
				assertEquals(8192, line.getBufferSize());
				line.start();
				assertEquals(8192, line.write(new byte[8192], 0, 8192));
				line.drain();
				assertEquals(2048, line.getLongFramePosition());
			}
		}
		finally
		{
			restoreSelection(previous);
		}
	}

	private static void restoreSelection(String previous)
	{
		if (previous == null)
		{
			System.clearProperty(WindowsWaveOutProvider.PROPERTY);
		}
		else
		{
			System.setProperty(WindowsWaveOutProvider.PROPERTY, previous);
		}
	}
}
