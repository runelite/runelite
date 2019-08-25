/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.plugins.spellbook;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseWheelListener;

@Singleton
class SpellbookMouseListener extends MouseAdapter implements MouseWheelListener
{
	private final SpellbookPlugin plugin;

	SpellbookMouseListener(final SpellbookPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public MouseEvent mouseClicked(final MouseEvent event)
	{
		if (plugin.isNotOnSpellWidget())
		{
			return event;
		}

		if (SwingUtilities.isMiddleMouseButton(event))
		{
			plugin.resetSize();
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mousePressed(final MouseEvent event)
	{
		if (SwingUtilities.isRightMouseButton(event))
		{
			plugin.resetLocation();
			return event;
		}
		else if (SwingUtilities.isLeftMouseButton(event) && !plugin.isNotOnSpellWidget() && !plugin.isDragging())
		{
			plugin.startDragging(event.getPoint());
			event.consume();
		}

		return event;
	}

	@Override
	public MouseEvent mouseReleased(final MouseEvent event)
	{
		if (!SwingUtilities.isLeftMouseButton(event) || !plugin.isDragging())
		{
			return event;
		}

		plugin.completeDragging(event.getPoint());

		event.consume();
		return event;
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(final MouseWheelEvent event)
	{
		if (plugin.isNotOnSpellWidget())
		{
			return event;
		}

		final int direction = event.getWheelRotation();

		if (direction > 0)
		{
			plugin.increaseSize();
		}
		else
		{
			plugin.decreaseSize();
		}

		event.consume();
		return event;
	}
}
