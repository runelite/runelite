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

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import javax.sound.sampled.*;

public class WindowsWaveOutProviderTest

{
	private static final AudioFormat FORMAT = new AudioFormat(22050, 16, 2, true, false);

	@Test
	public void staysDisabledUnlessExplicitlySelected()
	{
		String key = "javax.sound.sampled.SourceDataLine";
		String previous = System.getProperty(key);
		try
		{
			System.clearProperty(key);
			assertEquals(0, new WindowsWaveOutProvider().getMixerInfo().length);
			System.setProperty(key, "#Speakers (Komplete Audio 6)");
			assertEquals(0, new WindowsWaveOutProvider().getMixerInfo().length);
		}
			finally
			{
			if (previous == null) System.clearProperty(key);
			else System.setProperty(key, previous);
		}
	}

	@Test
	public void streamsPcmWithoutReorderingOrDroppingFrames() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		line.open(FORMAT, 32);
		line.start();
		byte[] pcm =
		{
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
			25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40
		};
		assertEquals(32, line.write(pcm, 4, 32));
		assertArrayEquals(
				new byte[]
				{
					5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
					26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36
				},
				nativeAudio.pcm.toByteArray());
		line.drain();
		assertEquals(8, line.getLongFramePosition());
		assertEquals(32, line.available());
		line.close();
		assertFalse(line.isOpen());
		assertEquals(8, line.getLongFramePosition());
		assertEquals(0, nativeAudio.prepared);
		assertEquals(0, nativeAudio.handles);
	}

	@Test
	public void honorsBackpressureAndCloseUnblocksWriter() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		nativeAudio.completeImmediately = false;
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		line.open(FORMAT, 32);
		line.start();
		assertEquals(32, line.write(new byte[32], 0, 32));
		assertEquals(0, line.available());
		assertTrue(line.isActive());
		ExecutorService worker = Executors.newSingleThreadExecutor();
		try
		{
			Future<Integer> write = worker.submit(() -> line.write(new byte[4], 0, 4));
			try
			{
				write.get(50, TimeUnit.MILLISECONDS);
				fail("Full line must apply backpressure");
			}
				catch (TimeoutException expected)
				{
			}
			line.close();
			assertEquals(Integer.valueOf(0), write.get(1, TimeUnit.SECONDS));
			assertEquals(0, nativeAudio.prepared);
			assertEquals(0, nativeAudio.handles);
		}
			finally
			{
			line.close();
			worker.shutdownNow();
		}
	}

	@Test
	public void flushDiscardsQueuedAudioAndPreservesTimeline() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		line.open(FORMAT, 32);
		line.start();
		line.write(new byte[16], 0, 16);
		assertEquals(4, line.getLongFramePosition());
		nativeAudio.completeImmediately = false;
		line.write(new byte[16], 0, 16);
		assertEquals(16, line.available());
		line.stop();
		line.flush();
		assertFalse(line.isRunning());
		assertEquals(32, line.available());
		assertEquals(4, line.getLongFramePosition());
		nativeAudio.completeImmediately = true;
		line.start();
		line.write(new byte[8], 0, 8);
		line.drain();
		assertEquals(6, line.getLongFramePosition());
		line.close();
	}

	@Test
	public void cleansUpWhenPreparingNativeBuffersFails() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		nativeAudio.failPreparation = 3;
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		try
		{
			line.open(FORMAT, 32);
			fail("Preparation failure must propagate");
		}
			catch (LineUnavailableException expected)
			{
			assertTrue(expected.getMessage().contains("MMRESULT 7"));
		}
		assertFalse(line.isOpen());
		assertEquals(0, nativeAudio.handles);
		assertEquals(0, nativeAudio.prepared);
		nativeAudio.failPreparation = -1;
		line.open(FORMAT, 32);
		line.close();
	}

	@Test
	public void rejectsPartialFramesBeforeSubmittingAudio() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		line.open(FORMAT, 32);
		try
		{
			line.write(new byte[3], 0, 3);
			fail("Partial stereo frame accepted");
		}
			catch (IllegalArgumentException expected)
			{
		}
		assertEquals(0, nativeAudio.pcm.size());
		line.close();
	}

	@Test
	public void tracksUnsignedNativePositionAcrossRollover() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		line.open(FORMAT, 32);
		nativeAudio.position = 0xfffffff0L;
		assertEquals(1073741820L, line.getLongFramePosition());
		nativeAudio.position = 16;
		assertEquals(1073741828L, line.getLongFramePosition());
		line.close();
	}

	@Test
	public void rejectsUnsupportedFormatsWithoutOpeningDevice() throws Exception
	{
		FakeWinMM nativeAudio = new FakeWinMM();
		WindowsWaveOutProvider.OutputLine line = new WindowsWaveOutProvider.OutputLine(nativeAudio);
		for (AudioFormat format :
				new AudioFormat[]
				{
					new AudioFormat(22050, 24, 2, true, false),
					new AudioFormat(22050, 16, 2, true, true),
					new AudioFormat(22050, 16, 6, true, false)
				})
				{
			try
			{
				line.open(format, 32);
				fail("Unsupported PCM accepted");
			}
				catch (IllegalArgumentException expected)
				{
			}
		}
		assertEquals(0, nativeAudio.handles);
	}

	private static final class FakeWinMM implements WindowsWaveOutProvider.WinMM

	{
		final ByteArrayOutputStream pcm = new ByteArrayOutputStream();
		final List<WindowsWaveOutProvider.WaveHeader> headers = new ArrayList<>();
		boolean completeImmediately = true;
		int handles, prepared, failPreparation = -1;
		long position;

		public int waveOutOpen(
				PointerByReference out,
				int device,
				WindowsWaveOutProvider.WaveFormat format,
				Pointer callback,
				Pointer instance,
				int flags)
				{
			handles++;
			position = 0;
			out.setValue(new Pointer(1));
			return 0;
		}

		public int waveOutPrepareHeader(
				Pointer handle, WindowsWaveOutProvider.WaveHeader header, int size)
				{
			if (prepared == failPreparation) return 7;
			prepared++;
			headers.add(header);
			header.flags = 2;
			header.write();
			return 0;
		}

		public int waveOutUnprepareHeader(
				Pointer handle, WindowsWaveOutProvider.WaveHeader header, int size)
				{
			prepared--;
			return 0;
		}

		public int waveOutWrite(
				Pointer handle, WindowsWaveOutProvider.WaveHeader header, int size)
				{
			byte[] data = header.data.getByteArray(0, header.length);
			pcm.write(data, 0, data.length);
			header.flags = completeImmediately ? 3 : 2;
			header.write();
			if (completeImmediately) position += header.length;
			return 0;
		}

		public int waveOutPause(Pointer handle)

		{
			return 0;
		}

		public int waveOutRestart(Pointer handle)

		{
			return 0;
		}

		public int waveOutReset(Pointer handle)

		{
			position = 0;
			for (WindowsWaveOutProvider.WaveHeader header : headers)
			{
				header.flags = 3;
				header.write();
			}
			return 0;
		}

		public int waveOutClose(Pointer handle)

		{
			handles--;
			headers.clear();
			return 0;
		}

		public int waveOutGetPosition(Pointer handle, Pointer time, int size)

		{
			time.setInt(4, (int) position);
			return 0;
		}
	}
}
