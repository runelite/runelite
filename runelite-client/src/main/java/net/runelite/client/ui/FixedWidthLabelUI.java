/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.text.View;

/**
 * A FixedWidth extension of BasicLabelUI. This implementation
 * is completely static so there's only one instance shared
 * by all JLabel objects.
 *
 * The preferred width is determined by the first non-zero value of:
 * 1) clientProperty (see {@code PROPERTY_KEY})
 * 2) PreferredSize
 * 3) MaximumSize
 * 4) default value (see {@code DEFAULT_WIDTH})
 *
 * If the preferred width is bigger than the required space for the label
 * then the smaller of the two values will be used
 */
public class FixedWidthLabelUI extends BasicLabelUI
{
	private static final String PROPERTY_KEY = "preferredHTMLWidth";
	private static final int DEFAULT_WIDTH = PluginPanel.PANEL_WIDTH;

	protected static FixedWidthLabelUI ui = new FixedWidthLabelUI();

	public static ComponentUI createUI(JComponent c)
	{
		return ui;
	}

	@Override
	public Dimension getPreferredSize(JComponent c)
	{
		final Dimension superResults = super.getPreferredSize(c);
		final View view = (View) c.getClientProperty(BasicHTML.propertyKey);
		if (view == null)
		{
			return superResults;
		}

		int width = DEFAULT_WIDTH;
		final Object preferredWidth = c.getClientProperty(PROPERTY_KEY);
		if (preferredWidth != null)
		{
			width = (int) preferredWidth;
		}
		else if (c.isPreferredSizeSet() && c.getPreferredSize().width > 0)
		{
			width = c.getPreferredSize().width;
		}
		else if (c.isMaximumSizeSet() && c.getMaximumSize().width > 0)
		{
			width = c.getMaximumSize().width;
		}

		view.setSize(Math.min(width, superResults.width), 0.0f);
		final int w = (int) view.getPreferredSpan(View.X_AXIS);
		final int h = (int) view.getPreferredSpan(View.Y_AXIS);

		final Insets insets = c.getInsets();
		return new Dimension(w, h + insets.top + insets.bottom);
	}
}
