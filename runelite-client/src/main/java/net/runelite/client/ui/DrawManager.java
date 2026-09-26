/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.ui;

import java.awt.Image;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class DrawManager
{
	/**
	 * A listener which receives the pixels of every rendered frame.
	 */
	public interface FrameListener
	{
		/**
		 * Called with the pixels of a rendered frame. Pixels are packed 32-bit
		 * 0xAARRGGBB, row-major, top-down; the contents of the alpha channel are
		 * undefined. The array is reused between frames and may be the renderer's
		 * live buffer: it is only valid until this method returns and must not be
		 * modified; copy it if it is needed later. This is called on the render
		 * thread, so must return quickly. Depending on the renderer, frames may
		 * be delivered a few frames after they are drawn, and frames may be
		 * skipped if the readback is not complete in time.
		 */
		void onFrame(int[] pixels, int width, int height);
	}

	private final List<Runnable> everyFrame = new CopyOnWriteArrayList<>();
	private final Queue<Consumer<Image>> nextFrame = new ConcurrentLinkedQueue<>();
	private final List<FrameListener> frameListeners = new CopyOnWriteArrayList<>();

	public void registerEveryFrameListener(Runnable everyFrameListener)
	{
		if (!everyFrame.contains(everyFrameListener))
		{
			everyFrame.add(everyFrameListener);
		}
	}

	public void unregisterEveryFrameListener(Runnable everyFrameListener)
	{
		everyFrame.remove(everyFrameListener);
	}

	public void requestNextFrameListener(Consumer<Image> nextFrameListener)
	{
		nextFrame.add(nextFrameListener);
	}

	public void registerFrameListener(FrameListener frameListener)
	{
		if (!frameListeners.contains(frameListener))
		{
			frameListeners.add(frameListener);
		}
	}

	public void unregisterFrameListener(FrameListener frameListener)
	{
		frameListeners.remove(frameListener);
	}

	/**
	 * Whether any frame listeners are registered. Renderers may use this to
	 * skip frame readback entirely when nothing is listening.
	 */
	public boolean hasFrameListeners()
	{
		return !frameListeners.isEmpty();
	}

	/**
	 * Deliver a frame to registered frame listeners. Called by the renderer.
	 *
	 * @see FrameListener#onFrame(int[], int, int)
	 */
	public void processFrame(int[] pixels, int width, int height)
	{
		for (FrameListener frameListener : frameListeners)
		{
			try
			{
				frameListener.onFrame(pixels, width, height);
			}
			catch (Exception e)
			{
				log.error("Error in frame listener", e);
			}
		}
	}

	public void processDrawComplete(Supplier<Image> imageSupplier)
	{
		for (Runnable everyFrameListener : everyFrame)
		{
			try
			{
				everyFrameListener.run();
			}
			catch (Exception e)
			{
				log.error("Error in draw consumer", e);
			}
		}

		Consumer<Image> nextFrameListener = nextFrame.poll();
		Image image = null;
		while (nextFrameListener != null)
		{
			if (image == null)
			{
				try
				{
					image = imageSupplier.get();
				}
				catch (Exception ex)
				{
					log.warn("error getting screenshot", ex);
				}
			}

			if (image == null)
			{
				nextFrame.clear();
				break;
			}

			try
			{
				nextFrameListener.accept(image);
			}
			catch (Exception e)
			{
				log.error("Error in draw consumer", e);
			}
			nextFrameListener = nextFrame.poll();
		}
	}
}
