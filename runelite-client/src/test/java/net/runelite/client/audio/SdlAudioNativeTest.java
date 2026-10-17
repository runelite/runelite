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

import com.sun.jna.Callback;
import com.sun.jna.Function;
import com.sun.jna.Library;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SdlAudioNativeTest
{
	@Test(timeout = 30000)
	public void dispatchesNativeMainThreadWorkWhileIdle() throws Exception
	{
		String classpath = System.getProperty("java.class.path");
		ClassLoader loader = getClass().getClassLoader();
		if (loader instanceof URLClassLoader)
		{
			StringJoiner paths = new StringJoiner(File.pathSeparator);
			for (URL url : ((URLClassLoader) loader).getURLs())
			{
				paths.add(Paths.get(url.toURI()).toString());
			}
			classpath = paths.toString();
		}
		String java = Paths.get(System.getProperty("java.home"), "bin", Platform.isWindows() ? "java.exe" : "java").toString();
		ProcessBuilder builder = new ProcessBuilder(java, "-cp", classpath, Probe.class.getName()).redirectErrorStream(true);
		// A separate Java main honors SDL's thread contract without depending on physical audio hardware.
		builder.environment().put("SDL_AUDIO_DRIVER", "dummy");
		Process process = builder.start();
		try
		{
			assertTrue("SDL event-loop probe timed out", process.waitFor(20, TimeUnit.SECONDS));
			String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
			assertEquals(output, 0, process.exitValue());
			assertTrue(output, output.contains("Idle main-thread callbacks serviced"));
		}
		finally
		{
			process.destroyForcibly();
		}
	}

	public static class Probe
	{
		public interface MainThreadCallback extends Callback
		{
			void run(Pointer userdata);
		}

		public static void main(String[] args) throws Exception
		{
			Sdl sdl = Sdl.load();
			try (SdlAudio audio = new SdlAudio(() -> sdl))
			{
				audio.initialize();
				Thread initializer = Thread.currentThread();
				Semaphore completed = new Semaphore(0);
				AtomicReference<Thread> callbackThread = new AtomicReference<>();
				MainThreadCallback callback = userdata ->
				{
					callbackThread.set(Thread.currentThread());
					completed.release();
				};
				// Reuse this exact loaded module; loading another extracted copy would test separate SDL state.
				Function runOnMain = ((Library.Handler) Proxy.getInvocationHandler(sdl))
					.getNativeLibrary().getFunction("SDL_RunOnMainThread");
				FutureTask<Void> enqueue = new FutureTask<>(() ->
				{
					post(runOnMain, callback);
					return null;
				});
				new Thread(enqueue, "SDL callback producer").start();
				enqueue.get(5, TimeUnit.SECONDS);
				if (completed.availablePermits() != 0)
				{
					throw new AssertionError("Callback ran before the main thread pumped events");
				}
				FutureTask<Void> stop = new FutureTask<>(() ->
				{
					try
					{
						awaitCallback(completed, callbackThread, initializer);
						post(runOnMain, callback);
						awaitCallback(completed, callbackThread, initializer);
					}
					finally
					{
						audio.close();
					}
					return null;
				});
				new Thread(stop, "SDL callback observer").start();
				audio.runEventLoop();
				stop.get(5, TimeUnit.SECONDS);
				Reference.reachabilityFence(callback);
				System.out.println("Idle main-thread callbacks serviced; event loop stopped after shutdown");
			}
		}

		private static void post(Function function, MainThreadCallback callback)
		{
			if ((Byte) function.invoke(byte.class, new Object[]{callback, null, (byte) 0}) == 0)
			{
				throw new AssertionError("Unable to enqueue SDL main-thread callback");
			}
		}

		private static void awaitCallback(Semaphore completed, AtomicReference<Thread> callbackThread, Thread initializer)
			throws InterruptedException
		{
			if (!completed.tryAcquire(5, TimeUnit.SECONDS) || callbackThread.get() != initializer)
			{
				throw new AssertionError("Idle SDL callback did not run on the initialization thread");
			}
		}
	}
}
