/*
 * Copyright (c) 2018 Abex
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

package net.runelite.client.game;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class AsyncBufferedImage extends BufferedImage
{
	private final List<Runnable> listeners = new CopyOnWriteArrayList<>();
	public AsyncBufferedImage(int width, int height, int imageType)
	{
		super(width, height, imageType);
	}

	/**
	 * Call when the buffer has been changed
	 */
	public void changed()
	{
		for (Runnable r : listeners)
		{
			r.run();
		}
	}

	/**
	 * Register a function to be ran when the buffer has changed
	 */
	public void onChanged(Runnable r)
	{
		listeners.add(r);
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addTo(JButton c)
	{
		c.setIcon(makeIcon(c));
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addTo(JLabel c)
	{
		c.setIcon(makeIcon(c));
	}

	private ImageIcon makeIcon(JComponent c)
	{
		listeners.add(c::repaint);
		return new ImageIcon(this);
	}
}
