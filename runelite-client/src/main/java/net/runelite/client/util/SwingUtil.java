/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.util;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import javax.annotation.Nullable;
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.Activatable;

/**
 * Various Swing utilities.
 */
@Slf4j
public class SwingUtil
{
	public static void removeButtonDecorations(AbstractButton button)
	{
		button.putClientProperty(FlatClientProperties.STYLE_CLASS, "iconButton legacyIconButton");
	}

	public static void addModalTooltip(AbstractButton button, String on, String off)
	{
		button.setToolTipText(button.isSelected() ? on : off);
		button.addItemListener(l -> button.setToolTipText(button.isSelected() ? on : off));
	}

	/**
	 * Removes all of a component's children faster than calling removeAll() on it in many cases
	 */
	public static void fastRemoveAll(Container c)
	{
		// If we are not on the EDT this will deadlock, in addition to being totally unsafe
		assert SwingUtilities.isEventDispatchThread();

		// when a component is removed it has to be resized for some reason, but only if it's valid
		// so we make sure to invalidate everything before removing it
		c.invalidate();
		for (int i = 0; i < c.getComponentCount(); i++)
		{
			Component ic = c.getComponent(i);

			// removeAll and removeNotify are both recursive, so we have to recurse before them
			if (ic instanceof Container)
			{
				fastRemoveAll((Container) ic);
			}

			// each removeNotify needs to remove anything from the event queue that is for that widget
			// this however requires taking a lock, and is moderately slow, so we just execute all of
			// those events with a secondary event loop
			pumpPendingEvents();

			// call removeNotify early; this is most of the work in removeAll, and generates events that
			// the next secondaryLoop will pickup
			ic.removeNotify();
		}

		// Actually remove anything
		c.removeAll();
	}

	/**
	 * Run any events currently in the event queue
	 */
	public static void pumpPendingEvents()
	{
		EventQueue eq = Toolkit.getDefaultToolkit().getSystemEventQueue();

		if (eq.peekEvent() != null)
		{
			SecondaryLoop l = eq.createSecondaryLoop();
			SwingUtilities.invokeLater(l::exit);
			l.enter();
		}
	}

	public static void activate(@Nullable Object maybeActivatable)
	{
		if (maybeActivatable instanceof Activatable)
		{
			try
			{
				((Activatable) maybeActivatable).onActivate();
			}
			catch (Exception e)
			{
				log.warn("uncaught exception in activate", e);
			}
		}
	}

	public static void deactivate(@Nullable Object maybeActivatable)
	{
		if (maybeActivatable instanceof Activatable)
		{
			try
			{
				((Activatable) maybeActivatable).onDeactivate();
			}
			catch (Exception e)
			{
				log.warn("uncaught exception in deactivate", e);
			}
		}
	}
}
