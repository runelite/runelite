/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
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
package net.runelite.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

/**
 * A component to display an error/info message (to be used on a plugin panel)
 * Example uses are: no ge search results found, no ge offers found.
 */
public class PluginErrorPanel extends JPanel
{
	private final JLabel noResultsTitle = new JShadowedLabel();
	private final JLabel noResultsDescription = new JShadowedLabel();

	public PluginErrorPanel()
	{
		setOpaque(false);
		setBorder(new EmptyBorder(50, 10, 0, 10));
		setLayout(new BorderLayout());

		noResultsTitle.setForeground(Color.WHITE);
		noResultsTitle.setHorizontalAlignment(SwingConstants.CENTER);

		noResultsDescription.setFont(FontManager.getRunescapeSmallFont());
		noResultsDescription.setForeground(Color.GRAY);
		noResultsDescription.setHorizontalAlignment(SwingConstants.CENTER);

		add(noResultsTitle, BorderLayout.NORTH);
		add(noResultsDescription, BorderLayout.CENTER);

		setVisible(false);
	}

	/**
	 * Changes the content of the panel to the given parameters.
	 * The description has to be wrapped in html so that its text can be wrapped.
	 */
	public void setContent(String title, String description)
	{
		noResultsTitle.setText(title);
		noResultsDescription.setText("<html><body style = 'text-align:center'>" + description + "</body></html>");
		setVisible(true);
	}
}