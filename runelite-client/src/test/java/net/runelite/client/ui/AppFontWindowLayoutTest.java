/*
 * Copyright (c) 2026, RuneLite contributors
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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import net.runelite.client.config.ExpandResizeType;
import net.runelite.client.config.FontType;
import net.runelite.client.config.RuneLiteConfig;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/** Exercises the real client layout with a mocked native frame, without opening game windows. */
public class AppFontWindowLayoutTest
{
	@Test
	public void fontChangesPreserveWindowLayoutAcrossSizesAndWindowStates() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			try
			{
				for (int pixels : new int[]{1920, 2560})
				{
					for (double scale : new double[]{1, 1.5, 2})
					{
						for (int state : new int[]{Frame.NORMAL, Frame.MAXIMIZED_BOTH})
						{
							for (ExpandResizeType resize : ExpandResizeType.values())
							{
								checkLayout((int) (pixels / scale), (int) (1080 / scale), state, resize);
							}
						}
					}
				}
			}
			catch (ReflectiveOperationException e)
			{
				throw new AssertionError(e);
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}

	private static void checkLayout(int width, int height, int state, ExpandResizeType resize) throws ReflectiveOperationException
	{
		AppFontManager.apply(FontType.REGULAR.getFont());
		ClientUI ui = mock(ClientUI.class);
		RuneLiteConfig config = mock(RuneLiteConfig.class);
		when(config.automaticResizeType()).thenReturn(resize);
		ContainableFrame frame = mock(ContainableFrame.class);
		when(frame.getExtendedState()).thenReturn(state);
		JPanel content = new JPanel();
		when(frame.getBounds()).thenAnswer(invocation -> new Rectangle(content.getSize()));
		when(frame.getPreferredSize()).thenAnswer(invocation -> content.getSize());
		setField(ui, "config", config);
		setField(ui, "frame", frame);
		setField(ui, "content", content);
		Constructor<?> constructor = Class.forName(ClientUI.class.getName() + "$Layout").getDeclaredConstructor(ClientUI.class);
		constructor.setAccessible(true);
		content.setLayout((LayoutManager) constructor.newInstance(ui));
		JPanel game = new JPanel();
		game.setMinimumSize(new Dimension(765, 503));
		JTabbedPane sidebar = new JTabbedPane(JTabbedPane.RIGHT);
		PluginPanel panel = new PluginPanel()
		{
		};
		sidebar.addTab("Test", panel.getWrappedPanel());
		content.add(game);
		content.add(sidebar);
		int originalWidth = panel.getWrappedPanel().getPreferredSize().width;
		for (int size : new int[]{13, 24, 16})
		{
			AppFontManager.apply(size == 16 ? FontType.REGULAR.getFont() : new Font(Font.DIALOG, Font.PLAIN, size));
			content.setSize(width, height);
			content.doLayout();
			assertEquals(game.getWidth(), sidebar.getX());
			assertEquals(content.getWidth(), sidebar.getX() + sidebar.getWidth());
			assertTrue(game.getWidth() >= game.getMinimumSize().width);
			assertTrue(game.getHeight() >= game.getMinimumSize().height);
			assertEquals(sidebar.getPreferredSize().width, sidebar.getWidth());
			if ((resize == ExpandResizeType.KEEP_WINDOW_SIZE || state == Frame.MAXIMIZED_BOTH)
				&& content.getMinimumSize().width <= width)
			{
				assertEquals(width, content.getWidth());
			}
		}
		assertEquals(originalWidth, panel.getWrappedPanel().getPreferredSize().width);
		sidebar.setVisible(false);
		content.setSize(width, height);
		content.doLayout();
		assertEquals(content.getWidth(), game.getWidth());
	}

	private static void setField(ClientUI ui, String name, Object value) throws ReflectiveOperationException
	{
		Field field = ClientUI.class.getDeclaredField(name);
		field.setAccessible(true);
		field.set(ui, value);
	}
}
