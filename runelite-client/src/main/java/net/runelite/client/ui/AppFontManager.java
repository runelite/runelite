/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.WeakHashMap;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import net.runelite.client.ui.laf.RuneLiteLAF;

/** Updates app controls without recreating plugins or changing game fonts. */
public final class AppFontManager
{
	private static final String ROLE = "RuneLite.appFontRole";
	private static final String LAYOUT = "RuneLite.appFontLayout";
	private static final Set<JComponent> roots = Collections.newSetFromMap(new WeakHashMap<>());

	private AppFontManager()
	{
	}

	/** Marks only fonts installed by the app theme, not arbitrary UIResource fonts. */
	public static final class ThemeFont extends FontUIResource
	{
		public ThemeFont(Font font)
		{
			super(font);
		}
	}

	public static void register(JComponent component)
	{
		synchronized (roots)
		{
			roots.add(component);
		}
	}

	static void bind(JComponent component, String role)
	{
		component.putClientProperty(ROLE, role);
		register(component);
		component.setFont(fontForRole(role));
	}

	/** The callback is held by the component, not by the weak root registry. */
	public static void onFontChange(JComponent component, Runnable layout)
	{
		component.putClientProperty(LAYOUT, layout);
		register(component);
		layout.run();
	}

	/** Recompute natural height; a previous explicit size must not become the next minimum. */
	public static void bindPreferredHeight(JComponent component, int width, int defaultHeight)
	{
		onFontChange(component, () ->
		{
			component.setPreferredSize(null);
			Dimension natural = component.getPreferredSize();
			int height = UIManager.getBoolean("RuneLite.customAppFont")
				? Math.max(defaultHeight, natural.height) : defaultHeight;
			component.setPreferredSize(new Dimension(width < 0 ? natural.width : width, height));
		});
	}

	private static Font fontForRole(String role)
	{
		switch (role)
		{
			case "small":
				return FontManager.getUiSmallFont();
			case "bold":
				return FontManager.getUiBoldFont();
			case "hotkey":
				return UIManager.getBoolean("RuneLite.customAppFont")
					? FontManager.getUiSmallFont() : FontManager.getDefaultFont().deriveFont(12.f);
			default:
				throw new IllegalArgumentException(role);
		}
	}

	public static void apply(Font font)
	{
		if (!SwingUtilities.isEventDispatchThread())
		{
			throw new IllegalStateException("App fonts must be updated on the Swing event thread");
		}
		if (!RuneLiteLAF.setup(font))
		{
			throw new IllegalStateException("Unable to configure the app font");
		}
		Set<Component> components = Collections.newSetFromMap(new IdentityHashMap<>());
		ArrayList<JComponent> registered;
		synchronized (roots)
		{
			registered = new ArrayList<>(roots);
		}
		for (JComponent root : registered)
		{
			// Bound labels can belong to a cached, detached card. Include its siblings too.
			Component ancestor = root;
			while (ancestor.getParent() != null)
			{
				ancestor = ancestor.getParent();
			}
			collect(ancestor, components);
		}
		for (Window window : Window.getWindows())
		{
			collect(window, components);
		}
		Font replacement = new ThemeFont(UIManager.getFont("defaultFont"));
		for (Component component : components)
		{
			if (!(component instanceof JComponent))
			{
				continue;
			}
			JComponent control = (JComponent) component;
			String role = (String) control.getClientProperty(ROLE);
			if (role != null)
			{
				control.setFont(fontForRole(role));
			}
			else if (control.getFont() instanceof ThemeFont)
			{
				control.setFont(replacement);
			}
		}
		// All label fonts must be assigned before any layout measurements are recomputed.
		for (Component component : components)
		{
			if (component instanceof JComponent)
			{
				JComponent control = (JComponent) component;
				Runnable layout = (Runnable) control.getClientProperty(LAYOUT);
				if (layout != null)
				{
					layout.run();
				}
				control.revalidate();
				control.repaint();
			}
		}
	}

	private static void collect(Component component, Set<Component> components)
	{
		if (!components.add(component))
		{
			return;
		}
		if (component instanceof JComponent && ((JComponent) component).getComponentPopupMenu() != null)
		{
			collect(((JComponent) component).getComponentPopupMenu(), components);
		}
		if (component instanceof JMenu)
		{
			collect(((JMenu) component).getPopupMenu(), components);
		}
		if (component instanceof Container)
		{
			for (Component child : ((Container) component).getComponents())
			{
				collect(child, components);
			}
		}
	}
}
