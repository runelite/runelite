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
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.LineUnavailableException;
import net.runelite.client.events.ClientShutdown;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

public class SdlAudioTest
{
	private final Sdl sdl = mock(Sdl.class);
	private final ScheduledExecutorService executor = mock(ScheduledExecutorService.class);
	private final ScheduledFuture<?> future = mock(ScheduledFuture.class);
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
		doReturn(future).when(executor).scheduleWithFixedDelay(any(), anyLong(), anyLong(), any());
	}

	private void play() throws LineUnavailableException
	{
		audio.initialize(executor);
		audio.play(pcm, 22050, 2, 0.5f);
	}

	private Runnable reaper()
	{
		ArgumentCaptor<Runnable> runnable = ArgumentCaptor.forClass(Runnable.class);
		verify(executor).scheduleWithFixedDelay(runnable.capture(), eq(100L), eq(100L), eq(TimeUnit.MILLISECONDS));
		return runnable.getValue();
	}

	@Test
	public void sharesOneDeviceAndOneCleanupTask() throws Exception
	{
		play();
		Pointer second = new Pointer(11);
		when(sdl.SDL_CreateAudioStream(any(), isNull())).thenReturn(second);
		when(sdl.SDL_SetAudioStreamGain(eq(second), anyFloat())).thenReturn((byte) 1);
		when(sdl.SDL_BindAudioStream(7, second)).thenReturn((byte) 1);
		when(sdl.SDL_PutAudioStreamData(eq(second), any(), anyInt())).thenReturn((byte) 1);
		when(sdl.SDL_FlushAudioStream(second)).thenReturn((byte) 1);
		audio.initialize(executor);
		audio.play(pcm, 48000, 1, 1);
		verify(sdl).SDL_OpenAudioDevice(Sdl.DEFAULT_PLAYBACK, null);
		reaper();
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

	@Test
	public void waitsForBothInputAndOutputToDrain() throws Exception
	{
		play();
		Runnable reap = reaper();
		when(sdl.SDL_GetAudioStreamQueued(stream)).thenReturn(28, 0, 0);
		when(sdl.SDL_GetAudioStreamAvailable(stream)).thenReturn(0, 64, 0);
		reap.run();
		reap.run();
		verify(sdl, never()).SDL_DestroyAudioStream(any());
		reap.run();
		verify(sdl).SDL_DestroyAudioStream(stream);
		verify(future).cancel(false);
		verify(sdl, never()).SDL_CloseAudioDevice(anyInt());
	}

	@Test
	public void closesFailedStreamQuery() throws Exception
	{
		play();
		when(sdl.SDL_GetAudioStreamQueued(stream)).thenReturn(-1);
		reaper().run();
		verify(sdl).SDL_DestroyAudioStream(stream);
		verify(future).cancel(false);
	}

	@Test
	public void shutdownReleasesStreamsAndDeviceExactlyOnce() throws Exception
	{
		play();
		Runnable reap = reaper();
		audio.onClientShutdown(new ClientShutdown());
		audio.onClientShutdown(new ClientShutdown());
		reap.run(); // A task already waiting for the monitor must not touch freed pointers.
		verify(sdl).SDL_DestroyAudioStream(stream);
		verify(sdl).SDL_CloseAudioDevice(7);
		verify(sdl).SDL_QuitSubSystem(Sdl.INIT_AUDIO);
		verify(future).cancel(false);
		verify(executor, never()).shutdown();
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
			audio.initialize(executor);
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
			audio.initialize(executor);
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
			unavailable.initialize(executor);
			fail("Native load should fail");
		}
		catch (LineUnavailableException e)
		{
			assertSame(cause, e.getCause());
		}
	}

	@Test(expected = LineUnavailableException.class)
	public void streamCreationFailureDoesNotScheduleCleanup() throws Exception
	{
		when(sdl.SDL_CreateAudioStream(any(), isNull())).thenReturn(null);
		try
		{
			play();
		}
		finally
		{
			verifyNoInteractions(executor);
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
			verifyNoInteractions(executor);
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
			verifyNoInteractions(executor);
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
			verifyNoInteractions(executor);
		}
	}

	@Test(expected = RejectedExecutionException.class)
	public void schedulerFailureDestroysStream() throws Exception
	{
		when(executor.scheduleWithFixedDelay(any(), anyLong(), anyLong(), any())).thenThrow(new RejectedExecutionException());
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
		audio.initialize(executor);
		audio.play(new byte[0], 22050, 2, 1);
		verify(sdl, never()).SDL_CreateAudioStream(any(), any());
		verifyNoInteractions(executor);
	}
}
