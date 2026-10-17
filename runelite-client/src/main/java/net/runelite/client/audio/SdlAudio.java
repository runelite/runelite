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

import com.sun.jna.Pointer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Supplier;
import javax.sound.sampled.LineUnavailableException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;

/** One default SDL playback device. SDL owns format conversion, mixing and device routing. */
@Slf4j
public final class SdlAudio implements AutoCloseable
{
	private final Supplier<Sdl> loader;
	private final Set<Pointer> clips = new HashSet<>();
	private Sdl sdl;
	private int device;
	private boolean initialized;
	private boolean closed;
	private Thread mainThread;

	private static class Holder
	{
		private static final SdlAudio INSTANCE = new SdlAudio(Sdl::load);
	}

	public static SdlAudio getDefault()
	{
		return Holder.INSTANCE;
	}

	SdlAudio(Supplier<Sdl> loader)
	{
		this.loader = loader;
	}

	/** Must be called on the main thread before client startup, as required by SDL_InitSubSystem. */
	public synchronized void initialize() throws LineUnavailableException
	{
		if (initialized || closed)
		{
			return;
		}
		try
		{
			sdl = loader.get();
		}
		catch (RuntimeException | LinkageError e)
		{
			LineUnavailableException failure = new LineUnavailableException("Unable to load SDL audio");
			failure.initCause(e);
			throw failure;
		}
		sdl.SDL_SetAppMetadata("RuneLite", null, "net.runelite");
		if (sdl.SDL_InitSubSystem(Sdl.INIT_AUDIO) == 0)
		{
			throw unavailable();
		}
		initialized = true;
		mainThread = Thread.currentThread();
		openDevice();
	}

	/** Services SDL's main-thread callbacks until closed. Run on the initialization thread after startup. */
	public synchronized void runEventLoop() throws InterruptedException
	{
		if (!initialized || closed)
		{
			return;
		}
		if (Thread.currentThread() != mainThread)
		{
			throw new IllegalStateException("SDL events must run on the audio initialization thread");
		}
		try
		{
			while (!closed)
			{
				sdl.SDL_PumpEvents();
				// Pumping services queued main-thread work; no consumers need the queued SDL events.
				sdl.SDL_FlushEvents(Sdl.EVENT_FIRST, Sdl.EVENT_LAST);
				reap();
				wait(100); // Release the owner monitor so playback and shutdown can proceed.
			}
		}
		finally
		{
			close();
		}
	}

	private void openDevice() throws LineUnavailableException
	{
		device = sdl.SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null);
		if (device == 0)
		{
			throw unavailable();
		}
	}

	synchronized void play(byte[] pcm, int sampleRate, int channels, float gain) throws LineUnavailableException
	{
		if (!initialized || closed)
		{
			throw new LineUnavailableException("SDL audio is unavailable or has been shut down");
		}
		if (pcm.length == 0)
		{
			return;
		}
		if (device == 0)
		{
			// The default output may have been unavailable at startup. SDL initialization stays on main.
			openDevice();
		}
		Sdl.Spec spec = new Sdl.Spec();
		spec.freq = sampleRate;
		spec.channels = channels;
		Pointer stream = sdl.SDL_CreateAudioStream(spec, null);
		if (stream == null)
		{
			throw unavailable();
		}
		try
		{
			if (sdl.SDL_SetAudioStreamGain(stream, gain) == 0
				|| sdl.SDL_BindAudioStream(device, stream) == 0
				|| sdl.SDL_PutAudioStreamData(stream, pcm, pcm.length) == 0
				|| sdl.SDL_FlushAudioStream(stream) == 0)
			{
				throw unavailable();
			}
			clips.add(stream);
		}
		catch (RuntimeException | LineUnavailableException e)
		{
			sdl.SDL_DestroyAudioStream(stream);
			throw e;
		}
	}

	private LineUnavailableException unavailable()
	{
		return new LineUnavailableException("SDL audio: " + sdl.SDL_GetError());
	}

	private void reap()
	{
		for (Iterator<Pointer> it = clips.iterator(); it.hasNext(); )
		{
			Pointer stream = it.next();
			int queued = sdl.SDL_GetAudioStreamQueued(stream);
			int available = sdl.SDL_GetAudioStreamAvailable(stream);
			if (queued < 0 || available < 0)
			{
				log.warn("Unable to query SDL audio stream: {}", sdl.SDL_GetError());
			}
			else if (queued != 0 || available != 0)
			{
				continue;
			}
			sdl.SDL_DestroyAudioStream(stream);
			it.remove();
		}
	}

	@Subscribe
	public void onClientShutdown(ClientShutdown event)
	{
		close();
	}

	@Override
	public synchronized void close()
	{
		closed = true;
		notifyAll();
		for (Pointer stream : clips)
		{
			sdl.SDL_DestroyAudioStream(stream);
		}
		clips.clear();
		if (device != 0)
		{
			sdl.SDL_CloseAudioDevice(device);
			device = 0;
		}
		if (initialized)
		{
			// QuitSubSystem is not thread safe. The owner monitor serializes all our SDL calls.
			sdl.SDL_QuitSubSystem(Sdl.INIT_AUDIO);
			initialized = false;
		}
	}
}
