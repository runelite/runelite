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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.sound.sampled.LineUnavailableException;
import net.runelite.client.events.ClientShutdown;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SdlAudioTest
{
	private final Sdl sdl = mock(Sdl.class);
	private final SdlAudio audio = new SdlAudio(() -> sdl);
	private final Pointer stream = new Pointer(10);
	private final byte[] pcm = new byte[2048];

	@Before
	public void setup()
	{
		when(sdl.SDL_InitSubSystem(Sdl.INIT_AUDIO)).thenReturn((byte) 1);
		when(sdl.SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null)).thenReturn(7);
		when(sdl.SDL_CreateAudioStream(any(), isNull())).thenReturn(stream);
		when(sdl.SDL_BindAudioStream(7, stream)).thenReturn((byte) 1);
		when(sdl.SDL_SetAudioStreamGain(eq(stream), anyFloat())).thenReturn((byte) 1);
		when(sdl.SDL_PutAudioStreamData(eq(stream), any(), anyInt())).thenReturn((byte) 1);
		when(sdl.SDL_FlushAudioStream(stream)).thenReturn((byte) 1);
	}

	@After
	public void teardown()
	{
		audio.close();
	}

	private void play() throws LineUnavailableException
	{
		audio.initialize();
		audio.play(pcm, 22050, 2, 0.5f);
	}

	private void runUntilDestroyed() throws Exception
	{
		FutureTask<Void> stop = new FutureTask<>(() ->
		{
			try
			{
				verify(sdl, timeout(2000)).SDL_DestroyAudioStream(stream);
			}
			finally
			{
				audio.close();
			}
			return null;
		});
		Thread closer = new Thread(stop);
		closer.start();
		try
		{
			audio.runEventLoop();
			stop.get(3, TimeUnit.SECONDS);
		}
		finally
		{
			audio.close();
			closer.join(3000);
		}
	}

	@Test
	public void sharesOneDeviceForDifferentSourceFormats() throws Exception
	{
		play();
		Pointer second = new Pointer(11);
		when(sdl.SDL_CreateAudioStream(any(), isNull())).thenReturn(second);
		when(sdl.SDL_SetAudioStreamGain(eq(second), anyFloat())).thenReturn((byte) 1);
		when(sdl.SDL_BindAudioStream(7, second)).thenReturn((byte) 1);
		when(sdl.SDL_PutAudioStreamData(eq(second), any(), anyInt())).thenReturn((byte) 1);
		when(sdl.SDL_FlushAudioStream(second)).thenReturn((byte) 1);
		audio.initialize();
		audio.play(pcm, 48000, 1, 1);
		verify(sdl).SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null);
		ArgumentCaptor<Sdl.Spec> format = ArgumentCaptor.forClass(Sdl.Spec.class);
		verify(sdl, times(2)).SDL_CreateAudioStream(format.capture(), isNull());
		assertEquals(Sdl.S16LE, format.getAllValues().get(0).format);
		assertEquals(22050, format.getAllValues().get(0).freq);
		assertEquals(2, format.getAllValues().get(0).channels);
		assertEquals(48000, format.getAllValues().get(1).freq);
		assertEquals(1, format.getAllValues().get(1).channels);
		verify(sdl).SDL_PutAudioStreamData(stream, pcm, pcm.length);
		verify(sdl).SDL_FlushAudioStream(stream);
	}

	@Test(timeout = 5000)
	public void waitsForBothInputAndOutputToDrain() throws Exception
	{
		play();
		when(sdl.SDL_GetAudioStreamQueued(stream)).thenReturn(28, 0, 0);
		when(sdl.SDL_GetAudioStreamAvailable(stream)).thenReturn(0, 64, 0);
		runUntilDestroyed();
		InOrder order = inOrder(sdl);
		for (int i = 0; i < 3; ++i)
		{
			order.verify(sdl).SDL_GetAudioStreamQueued(stream);
			order.verify(sdl).SDL_GetAudioStreamAvailable(stream);
		}
		order.verify(sdl).SDL_DestroyAudioStream(stream);
		verify(sdl).SDL_DestroyAudioStream(stream);
	}

	@Test(timeout = 5000)
	public void closesFailedStreamQuery() throws Exception
	{
		play();
		when(sdl.SDL_GetAudioStreamQueued(stream)).thenReturn(-1);
		runUntilDestroyed();
		verify(sdl).SDL_DestroyAudioStream(stream);
	}

	@Test
	public void shutdownReleasesStreamsAndDeviceExactlyOnce() throws Exception
	{
		play();
		audio.onClientShutdown(new ClientShutdown());
		audio.onClientShutdown(new ClientShutdown());
		audio.runEventLoop();
		verify(sdl).SDL_DestroyAudioStream(stream);
		verify(sdl).SDL_CloseAudioDevice(7);
		verify(sdl).SDL_QuitSubSystem(Sdl.INIT_AUDIO);
		verify(sdl, never()).SDL_PumpEvents();
	}

	@Test(expected = LineUnavailableException.class)
	public void shutdownPreventsFurtherPlayback() throws Exception
	{
		play();
		audio.onClientShutdown(new ClientShutdown());
		audio.play(pcm, 22050, 2, 1);
	}

	@Test(expected = LineUnavailableException.class)
	public void initializationFailureDoesNotOpenDevice() throws Exception
	{
		when(sdl.SDL_InitSubSystem(Sdl.INIT_AUDIO)).thenReturn((byte) 0);
		try
		{
			audio.initialize();
		}
		finally
		{
			verify(sdl, never()).SDL_OpenAudioDevice(anyInt(), any());
			verify(sdl, never()).SDL_QuitSubSystem(anyInt());
		}
	}

	@Test
	public void retriesUnavailableDeviceOnNextPlayback() throws Exception
	{
		when(sdl.SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null)).thenReturn(0, 7);
		try
		{
			audio.initialize();
			fail("First device open should fail");
		}
		catch (LineUnavailableException e)
		{
			verify(sdl, never()).SDL_QuitSubSystem(anyInt());
		}
		audio.play(pcm, 22050, 2, 1);
		verify(sdl, times(2)).SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null);
		verify(sdl).SDL_InitSubSystem(Sdl.INIT_AUDIO);
		verify(sdl).SDL_PutAudioStreamData(stream, pcm, pcm.length);
	}

	@Test
	public void nativeLoadFailureIsReportedAsUnavailable() throws Exception
	{
		UnsatisfiedLinkError cause = new UnsatisfiedLinkError("test");
		SdlAudio unavailable = new SdlAudio(() ->
		{
			throw cause;
		});
		try
		{
			unavailable.initialize();
			fail("Native load should fail");
		}
		catch (LineUnavailableException e)
		{
			assertSame(cause, e.getCause());
		}
	}

	@Test(expected = LineUnavailableException.class)
	public void streamCreationFailureAllocatesNothing() throws Exception
	{
		when(sdl.SDL_CreateAudioStream(any(), isNull())).thenReturn(null);
		try
		{
			play();
		}
		finally
		{
			verify(sdl, never()).SDL_DestroyAudioStream(any());
		}
	}

	@Test(expected = LineUnavailableException.class)
	public void bindFailureDestroysStream() throws Exception
	{
		when(sdl.SDL_BindAudioStream(7, stream)).thenReturn((byte) 0);
		try
		{
			play();
		}
		finally
		{
			verify(sdl).SDL_DestroyAudioStream(stream);
		}
	}

	@Test(expected = LineUnavailableException.class)
	public void putFailureDestroysStream() throws Exception
	{
		when(sdl.SDL_PutAudioStreamData(eq(stream), any(), anyInt())).thenReturn((byte) 0);
		try
		{
			play();
		}
		finally
		{
			verify(sdl).SDL_DestroyAudioStream(stream);
		}
	}

	@Test(expected = LineUnavailableException.class)
	public void flushFailureDestroysStream() throws Exception
	{
		when(sdl.SDL_FlushAudioStream(stream)).thenReturn((byte) 0);
		try
		{
			play();
		}
		finally
		{
			verify(sdl).SDL_DestroyAudioStream(stream);
		}
	}

	@Test
	public void emptyAudioAllocatesNothing() throws Exception
	{
		audio.initialize();
		audio.play(new byte[0], 22050, 2, 1);
		verify(sdl, never()).SDL_CreateAudioStream(any(), any());
	}

	private void runUntilPumpedTwice() throws Exception
	{
		Thread initializer = Thread.currentThread();
		CountDownLatch pumps = new CountDownLatch(2);
		AtomicReference<Thread> pumpingThread = new AtomicReference<>();
		doAnswer(invocation ->
		{
			pumpingThread.set(Thread.currentThread());
			pumps.countDown();
			return null;
		}).when(sdl).SDL_PumpEvents();
		FutureTask<Void> stop = new FutureTask<>(() ->
		{
			try
			{
				assertTrue("Event loop did not run while idle", pumps.await(2, TimeUnit.SECONDS));
				// Proves the loop releases its monitor between pumps, even without existing clips.
				audio.play(pcm, 22050, 2, 1);
			}
			finally
			{
				audio.onClientShutdown(new ClientShutdown());
			}
			return null;
		});
		Thread closer = new Thread(stop);
		closer.start();
		try
		{
			audio.runEventLoop();
			stop.get(3, TimeUnit.SECONDS);
		}
		finally
		{
			audio.close();
			closer.join(3000);
		}
		assertSame(initializer, pumpingThread.get());
		verify(sdl, atLeast(2)).SDL_FlushEvents(Sdl.EVENT_FIRST, Sdl.EVENT_LAST);
		verify(sdl).SDL_DestroyAudioStream(stream);
		verify(sdl).SDL_QuitSubSystem(Sdl.INIT_AUDIO);
		int calls = mockingDetails(sdl).getInvocations().size();
		audio.runEventLoop();
		assertEquals(calls, mockingDetails(sdl).getInvocations().size());
	}

	@Test(timeout = 5000)
	public void servicesIdleEventsAndAllowsPlaybackAndShutdown() throws Exception
	{
		audio.initialize();
		runUntilPumpedTwice();
	}

	@Test(timeout = 5000)
	public void servicesEventsAfterInitialDeviceOpenFails() throws Exception
	{
		when(sdl.SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null)).thenReturn(0, 7);
		try
		{
			audio.initialize();
			fail("First device open should fail");
		}
		catch (LineUnavailableException e)
		{
			verify(sdl, never()).SDL_QuitSubSystem(anyInt());
		}
		runUntilPumpedTwice();
		verify(sdl, times(2)).SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null);
	}

	@Test
	public void failedInitializationDoesNotEnterEventLoop() throws Exception
	{
		when(sdl.SDL_InitSubSystem(Sdl.INIT_AUDIO)).thenReturn((byte) 0);
		try
		{
			audio.initialize();
			fail("Initialization should fail");
		}
		catch (LineUnavailableException e)
		{
			audio.runEventLoop();
			verify(sdl, never()).SDL_PumpEvents();
			verify(sdl, never()).SDL_QuitSubSystem(anyInt());
		}
	}

	@Test
	public void rejectsEventLoopOnAnotherThread() throws Exception
	{
		audio.initialize();
		FutureTask<Void> loop = new FutureTask<>(() ->
		{
			audio.runEventLoop();
			return null;
		});
		Thread other = new Thread(loop);
		other.start();
		try
		{
			loop.get(2, TimeUnit.SECONDS);
			fail("Event loop should reject another thread");
		}
		catch (ExecutionException e)
		{
			assertTrue(e.getCause() instanceof IllegalStateException);
		}
		finally
		{
			other.join(3000);
		}
		verify(sdl, never()).SDL_PumpEvents();
	}

	@Test
	public void interruptedEventLoopClosesAudio() throws Exception
	{
		play();
		doAnswer(invocation ->
		{
			Thread.currentThread().interrupt();
			return null;
		}).when(sdl).SDL_PumpEvents();
		try
		{
			audio.runEventLoop();
			fail("Event loop should propagate interruption");
		}
		catch (InterruptedException e)
		{
			verify(sdl).SDL_DestroyAudioStream(stream);
			verify(sdl).SDL_CloseAudioDevice(7);
			verify(sdl).SDL_QuitSubSystem(Sdl.INIT_AUDIO);
			assertFalse(Thread.currentThread().isInterrupted());
		}
	}
}
