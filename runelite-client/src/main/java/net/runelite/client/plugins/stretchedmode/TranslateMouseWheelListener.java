/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.stretchedmode;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.input.MouseWheelListener;

public class TranslateMouseWheelListener implements MouseWheelListener
{
	private final Client client;

	@Inject
	private TranslateMouseWheelListener(Client client)
	{
		this.client = client;
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		return translateEvent(event);
	}

	private MouseWheelEvent translateEvent(MouseWheelEvent e)
	{
		Dimension stretchedDimensions = client.getStretchedDimensions();
		Dimension realDimensions = client.getRealDimensions();

		int newX = (int) (e.getX() / (stretchedDimensions.width / realDimensions.getWidth()));
		int newY = (int) (e.getY() / (stretchedDimensions.height / realDimensions.getHeight()));

		return new MouseWheelEvent((Component) e.getSource(), e.getID(), e.getWhen(), e.getModifiers(), newX, newY,
				e.getClickCount(), e.isPopupTrigger(), e.getScrollType(), e.getScrollAmount(), e.getWheelRotation());
	}
}
