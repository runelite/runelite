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

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.MixerProvider;

/**
 * Opt-in WinMM output for endpoints which reject Java Sound's DirectSound buffers. Select with
 * -Djavax.sound.sampled.SourceDataLine=net.runelite.client.audio.WindowsWaveOutProvider The Windows
 * default playback device is used; no system settings are modified.
 */
public final class WindowsWaveOutProvider extends MixerProvider
{
	private static final Mixer.Info INFO =
			new Mixer.Info(
					"Windows WaveOut",
					"RuneLite",
					"Windows default playback device through WinMM",
					"1")
					{
					};
	private static final Line.Info LINE = new Line.Info(SourceDataLine.class);

	@Override
	public Mixer.Info[] getMixerInfo()
	{
		String selected = System.getProperty("javax.sound.sampled.SourceDataLine", "");
		return Platform.isWindows() && selected.split("#", 2)[0].equals(getClass().getName())
				? new Mixer.Info[] {INFO}
				: new Mixer.Info[0];
	}

	@Override
	public Mixer getMixer(Mixer.Info info)
	{
		if (getMixerInfo().length == 0 || (info != null && info != INFO))
			throw new IllegalArgumentException("Unknown WaveOut mixer: " + info);
		return new OutputMixer();
	}

	static boolean supports(AudioFormat f)

	{
		return AudioFormat.Encoding.PCM_SIGNED.equals(f.getEncoding())
				&& !f.isBigEndian()
				&& f.getSampleSizeInBits() == 16
				&& (f.getChannels() == 1 || f.getChannels() == 2)
				&& f.getFrameSize() == f.getChannels() * 2
				&& f.getSampleRate() > 0
				&& f.getSampleRate() <= 192000
				&& f.getSampleRate() == (int) f.getSampleRate()
				&& f.getFrameRate() == f.getSampleRate();
	}

	private static boolean supports(Line.Info info)

	{
		if (info.getLineClass() != SourceDataLine.class) return false;
		if (!(info instanceof DataLine.Info)) return true;
		AudioFormat[] formats = ((DataLine.Info) info).getFormats();
		for (AudioFormat format : formats) if (!supports(format)) return false;
		return true;
	}

	private abstract static class BaseLine implements Line

	{
		final List<LineListener> listeners = new ArrayList<>();
		volatile boolean open;

		@Override
		public boolean isOpen()
		{
			return open;
		}

		@Override
		public Control[] getControls()
		{
			return new Control[0];
		}

		@Override
		public boolean isControlSupported(Control.Type type)
		{
			return false;
		}

		@Override
		public Control getControl(Control.Type type)
		{
			throw new IllegalArgumentException("No controls");
		}

		@Override
		public synchronized void addLineListener(LineListener listener)
		{
			listeners.add(listener);
		}

		@Override
		public synchronized void removeLineListener(LineListener listener)
		{
			listeners.remove(listener);
		}

		void event(LineEvent.Type type, long frame)

		{
			LineListener[] copy;
			synchronized (this)
			{
				copy = listeners.toArray(new LineListener[0]);
			}
			LineEvent event = new LineEvent(this, type, frame);
			for (LineListener listener : copy) listener.update(event);
		}
	}

	private static final class OutputMixer extends BaseLine implements Mixer

	{
		@Override
		public Mixer.Info getMixerInfo()
		{
			return INFO;
		}

		@Override
		public Line.Info getLineInfo()
		{
			return new Line.Info(Mixer.class);
		}

		@Override
		public Line.Info[] getSourceLineInfo()
		{
			return new Line.Info[] {LINE};
		}

		@Override
		public Line.Info[] getTargetLineInfo()
		{
			return new Line.Info[0];
		}

		@Override
		public Line.Info[] getSourceLineInfo(Line.Info info)
		{
			return supports(info) ? getSourceLineInfo() : new Line.Info[0];
		}

		@Override
		public Line.Info[] getTargetLineInfo(Line.Info info)
		{
			return new Line.Info[0];
		}

		@Override
		public boolean isLineSupported(Line.Info info)
		{
			return supports(info);
		}

		@Override
		public Line getLine(Line.Info info)
		{
			if (!supports(info))
				throw new IllegalArgumentException("Unsupported WaveOut line: " + info);
			return new OutputLine();
		}

		@Override
		public int getMaxLines(Line.Info info)
		{
			return supports(info) ? AudioSystem.NOT_SPECIFIED : 0;
		}

		@Override
		public Line[] getSourceLines()
		{
			return new Line[0];
		}

		@Override
		public Line[] getTargetLines()
		{
			return new Line[0];
		}

		@Override
		public boolean isSynchronizationSupported(Line[] lines, boolean maintainSync)
		{
			return false;
		}

		@Override
		public void synchronize(Line[] lines, boolean maintainSync)
		{
			throw new IllegalArgumentException("No synchronization");
		}

		@Override
		public void unsynchronize(Line[] lines)
		{
			throw new IllegalArgumentException("No synchronization");
		}

		@Override
		public void open()
		{
			open = true;
		}

		@Override
		public void close()
		{
			open = false;
		}
	}

	interface WinMM extends StdCallLibrary

	{
		int waveOutOpen(
				PointerByReference handle,
				int device,
				WaveFormat format,
				Pointer callback,
				Pointer instance,
				int flags);

		int waveOutPrepareHeader(Pointer handle, WaveHeader header, int size);

		int waveOutUnprepareHeader(Pointer handle, WaveHeader header, int size);

		int waveOutWrite(Pointer handle, WaveHeader header, int size);

		int waveOutPause(Pointer handle);

		int waveOutRestart(Pointer handle);

		int waveOutReset(Pointer handle);

		int waveOutClose(Pointer handle);

		int waveOutGetPosition(Pointer handle, Pointer time, int size);
	}

	@Structure.FieldOrder({
		"tag",
		"channels",
		"rate",
		"bytesPerSecond",
		"blockAlign",
		"bits",
		"extra"
	})
	public static class WaveFormat extends Structure
	{
		public short tag = 1, channels;
		public int rate, bytesPerSecond;
		public short blockAlign, bits = 16, extra;

		WaveFormat(AudioFormat format)

		{
			super(ALIGN_NONE);
			channels = (short) format.getChannels();
			rate = (int) format.getSampleRate();
			blockAlign = (short) format.getFrameSize();
			bytesPerSecond = rate * blockAlign;
		}
	}

	@Structure.FieldOrder({
		"data",
		"length",
		"recorded",
		"user",
		"flags",
		"loops",
		"next",
		"reserved"
	})
	public static class WaveHeader extends Structure
	{
		public Pointer data;
		public int length, recorded;
		public Pointer user;
		public int flags, loops;
		public Pointer next, reserved;
	}

	private static final class OwnedMemory extends Memory implements AutoCloseable

	{
		OwnedMemory(long size)
		{
			super(size);
		}

		@Override
		public void close()
		{
			dispose();
		}
	}

	static final class OutputLine extends BaseLine implements SourceDataLine

	{
		private final WinMM api;
		private Pointer handle;
		private AudioFormat format;
		private final WaveHeader[] headers = new WaveHeader[8];
		private final OwnedMemory[] buffers = new OwnedMemory[8];
		private final boolean[] queued = new boolean[8];
		private int blockSize;
		private volatile boolean running;
		private long completedBytes;
		private long previousPosition;
		private long generation;

		OutputLine()

		{
			this(Native.load("winmm", WinMM.class));
		}

		OutputLine(WinMM api)

		{
			this.api = api;
		}

		@Override
		public Line.Info getLineInfo()
		{
			return format == null ? LINE : new DataLine.Info(SourceDataLine.class, format);
		}

		@Override
		public void open() throws LineUnavailableException
		{
			open(new AudioFormat(22050, 16, 2, true, false));
		}

		@Override
		public void open(AudioFormat f) throws LineUnavailableException
		{
			open(f, (int) f.getSampleRate() * f.getFrameSize() / 10);
		}

		@Override
		public synchronized void open(AudioFormat f, int size) throws LineUnavailableException
		{
			if (open) throw new IllegalStateException("Line already open");
			if (!supports(f) || size <= 0)
				throw new IllegalArgumentException("Unsupported WaveOut format or buffer size");
			PointerByReference ref = new PointerByReference();
			checkOpen(api.waveOutOpen(ref, -1, new WaveFormat(f), null, null, 0), "waveOutOpen");
			handle = ref.getValue();
			format = f;
			completedBytes = 0;
			previousPosition = 0;
			generation++;
			blockSize =
					Math.max(
							f.getFrameSize(),
							size / headers.length / f.getFrameSize() * f.getFrameSize());
			int prepared = 0;
			try
			{
				checkOpen(api.waveOutPause(handle), "waveOutPause");
				for (int i = 0; i < headers.length; i++)
				{
					buffers[i] = new OwnedMemory(blockSize);
					WaveHeader header = new WaveHeader();
					header.data = buffers[i];
					header.length = blockSize;
					headers[i] = header;
					checkOpen(
							api.waveOutPrepareHeader(handle, header, header.size()),
							"waveOutPrepareHeader");
					prepared++;
					queued[i] = false;
				}
			}
				catch (LineUnavailableException | RuntimeException e)
				{
				api.waveOutReset(handle);
				for (int i = 0; i < prepared; i++)
					api.waveOutUnprepareHeader(handle, headers[i], headers[i].size());
				api.waveOutClose(handle);
				handle = null;
				releaseBuffers();
				throw e;
			}
			open = true;
			event(LineEvent.Type.OPEN, 0);
		}

		private static void checkOpen(int result, String operation)
				throws LineUnavailableException
				{
			if (result != 0)
				throw new LineUnavailableException(operation + " failed with MMRESULT " + result);
		}

		private static void check(int result, String operation)

		{
			if (result != 0)
				throw new IllegalStateException(operation + " failed with MMRESULT " + result);
		}

		private void requireOpen()

		{
			if (!open) throw new IllegalStateException("Line is closed");
		}

		private boolean free(int i)

		{
			if (!queued[i]) return true;
			headers[i].read();
			return (headers[i].flags & 1) != 0; // WHDR_DONE, set by WinMM after playback.
		}

		private boolean waitForPlayback()

		{
			synchronized (this)
			{
				if (!open) return false;
				try
				{
					wait(2);
				} // Release the monitor so stop/flush/close can interrupt a writer.
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
					return false;
				}
				return open;
			}
		}

		@Override
		public int write(byte[] data, int offset, int length)
		{
			if (offset < 0 || length < 0 || offset > data.length - length)
				throw new IndexOutOfBoundsException();
			long writeGeneration;
			synchronized (this)
			{
				requireOpen();
				if (length % format.getFrameSize() != 0)
					throw new IllegalArgumentException("Incomplete PCM frame");
				writeGeneration = generation;
			}
			int written = 0;
			while (written < length)
			{
				synchronized (this)
				{
					if (!open || writeGeneration != generation) return written;
					for (int i = 0; i < headers.length && written < length; i++)
					{
						if (!free(i)) continue;
						int count = Math.min(blockSize, length - written);
						buffers[i].write(0, data, offset + written, count);
						headers[i].length = count;
						check(
								api.waveOutWrite(handle, headers[i], headers[i].size()),
								"waveOutWrite");
						queued[i] = true;
						written += count;
					}
				}
				if (written < length && !waitForPlayback()) break;
			}
			return written;
		}

		@Override
		public synchronized void start()
		{
			requireOpen();
			if (running) return;
			check(api.waveOutRestart(handle), "waveOutRestart");
			running = true;
			notifyAll();
			event(LineEvent.Type.START, getLongFramePosition());
		}

		@Override
		public synchronized void stop()
		{
			if (!open || !running) return;
			check(api.waveOutPause(handle), "waveOutPause");
			running = false;
			generation++;
			notifyAll();
			event(LineEvent.Type.STOP, getLongFramePosition());
		}

		@Override
		public void drain()
		{
			long drainGeneration;
			synchronized (this)
			{
				drainGeneration = generation;
			}
			while (true)
			{
				synchronized (this)
				{
					if (!open || drainGeneration != generation) return;
					boolean pending = false;
					for (int i = 0; i < headers.length; i++) pending |= !free(i);
					if (!pending) return;
				}
				if (!waitForPlayback()) return;
			}
		}

		@Override
		public synchronized void flush()
		{
			if (!open) return;
			long position = positionBytes();
			check(api.waveOutReset(handle), "waveOutReset");
			completedBytes = position;
			previousPosition = 0;
			generation++;
			for (int i = 0; i < queued.length; i++) queued[i] = false;
			if (!running) check(api.waveOutPause(handle), "waveOutPause");
			notifyAll();
		}

		@Override
		public synchronized void close()
		{
			if (!open) return;
			long frame = getLongFramePosition();
			// Reset returns queued buffers before releasing their native storage.
			check(api.waveOutReset(handle), "waveOutReset");
			for (WaveHeader header : headers)
				check(
						api.waveOutUnprepareHeader(handle, header, header.size()),
						"waveOutUnprepareHeader");
			check(api.waveOutClose(handle), "waveOutClose");
			completedBytes = frame * format.getFrameSize();
			previousPosition = 0;
			generation++;
			handle = null;
			open = false;
			running = false;
			releaseBuffers();
			notifyAll();
			event(LineEvent.Type.CLOSE, frame);
		}

		private void releaseBuffers()

		{
			for (int i = 0; i < buffers.length; i++)
			{
				if (buffers[i] != null) buffers[i].close();
				buffers[i] = null;
				headers[i] = null;
				queued[i] = false;
			}
		}

		@Override
		public synchronized int available()
		{
			if (!open) return 0;
			int bytes = 0;
			for (int i = 0; i < headers.length; i++) if (free(i)) bytes += blockSize;
			return bytes;
		}

		@Override
		public AudioFormat getFormat()
		{
			return format;
		}

		@Override
		public int getBufferSize()
		{
			return blockSize * headers.length;
		}

		@Override
		public boolean isRunning()
		{
			return running;
		}

		@Override
		public synchronized boolean isActive()
		{
			return running && available() < getBufferSize();
		}

		private long positionBytes()

		{
			if (!open) return completedBytes;
			try (OwnedMemory time = new OwnedMemory(12))
			{
				time.clear();
				time.setInt(0, 4); // TIME_BYTES
				check(api.waveOutGetPosition(handle, time, 12), "waveOutGetPosition");
				if (time.getInt(0) != 4)
					throw new IllegalStateException("WinMM did not return a byte position");
				long current = Integer.toUnsignedLong(time.getInt(4));
				completedBytes += (current - previousPosition) & 0xffffffffL;
				previousPosition = current;
				return completedBytes;
			}
		}

		@Override
		public synchronized long getLongFramePosition()
		{
			return format == null ? 0 : positionBytes() / format.getFrameSize();
		}

		@Override
		public int getFramePosition()
		{
			return (int) getLongFramePosition();
		}

		@Override
		public long getMicrosecondPosition()
		{
			return format == null
					? 0
					: (long) (getLongFramePosition() * 1000000.0 / format.getSampleRate());
		}

		@Override
		public float getLevel()
		{
			return AudioSystem.NOT_SPECIFIED;
		}
	}
}
