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

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class DrawManager
{
	private final List<Consumer<BufferedImage>> everyFrame = new CopyOnWriteArrayList<>();
	private final Queue<Consumer<BufferedImage>> nextFrame = new ConcurrentLinkedQueue<>();

	public void registerEveryFrameListener(Consumer<BufferedImage> everyFrameListener)
	{
		if (!everyFrame.contains(everyFrameListener))
		{
			everyFrame.add(everyFrameListener);
		}
	}

	public void unregisterEveryFrameListener(Consumer<BufferedImage> everyFrameListener)
	{
		everyFrame.remove(everyFrameListener);
	}

	public void requestNextFrameListener(Consumer<BufferedImage> nextFrameListener)
	{
		nextFrame.add(nextFrameListener);
	}

	public void processDrawComplete(BufferedImage image)
	{
		for (Consumer<BufferedImage> everyFrameListener : everyFrame)
		{
			try
			{
				everyFrameListener.accept(image);
			}
			catch (Exception e)
			{
				log.error("Error in draw consumer", e);
			}
		}

		Consumer<BufferedImage> nextFrameListener = nextFrame.poll();
		while (nextFrameListener != null)
		{
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
