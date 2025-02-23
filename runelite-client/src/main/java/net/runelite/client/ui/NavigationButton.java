/*
 * Copyright (c) 2017-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.con>
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import javax.swing.JPanel;
import lombok.Builder;
import lombok.Value;

/**
 * UI navigation button.
 */
@Value
@Builder(toBuilder = true)
public class NavigationButton
{
	static final Comparator<NavigationButton> COMPARATOR = Comparator.comparing(NavigationButton::getPriority)
		.thenComparing(NavigationButton::getTooltip);

	/**
	 * Tooltip to show when hovered.
	 */
	String tooltip;

	/**
	 * Icon of button.
	 */
	BufferedImage icon;

	/**
	 * The order in which the button should be displayed in the side bar (from lower to higher).
	 */
	@Builder.Default
	int priority = 0;

	/**
	 * Plugin panel, used when expanding and contracting sidebar.
	 * This can be null for buttons that perform an onClick action without showing a panel.
	 */
	PluginPanel panel;

	/**
	 * On click action of the button.
	 */
	@Builder.Default
	Runnable onClick = null;

	/**
	 * Map of key-value pairs for setting the popup menu.
	 */
	@Builder.Default
	Map<String, Runnable> popup = Collections.emptyMap();

	public String getTooltip()
	{
		return tooltip;
	}

	public BufferedImage getIcon()
	{
		return icon;
	}

	public int getPriority()
	{
		return priority;
	}

	public PluginPanel getPanel()
	{
		return panel;
	}

	// Static builder method that DevToolsPlugin (and elsewhere) can use.
	public static Builder builder()
	{
		return new Builder();
	}

	// Custom Builder inner class (optional)
	// Remove this inner class if you want Lombok to generate the builder automatically.
	public static class Builder
	{
		private String tooltip;
		private BufferedImage icon;
		private int priority;
		private PluginPanel panel;
		private Runnable onClick = null;
		private Map<String, Runnable> popup = Collections.emptyMap();

		public Builder tooltip(String tooltip)
		{
			this.tooltip = tooltip;
			return this;
		}

		public Builder icon(BufferedImage icon)
		{
			this.icon = icon;
			return this;
		}

		public Builder priority(int priority)
		{
			this.priority = priority;
			return this;
		}

		public Builder panel(PluginPanel panel)
		{
			this.panel = panel;
			return this;
		}

		public Builder onClick(Runnable onClick)
		{
			this.onClick = onClick;
			return this;
		}

		public Builder popup(Map<String, Runnable> popup)
		{
			this.popup = popup;
			return this;
		}

		public NavigationButton build()
		{
			return new NavigationButton(tooltip, icon, priority, panel, onClick, popup);
		}
	}
}
