/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
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
package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerOverlay;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

class ScreenMarkerPanel extends JPanel
{
	private static final String DELETE_TEXT = "Delete";
	private static final String HIDE_TEXT = "Hide";
	private static final String SHOW_TEXT = "Show";

	private final ScreenMarkerPlugin plugin;
	private final ScreenMarkerOverlay marker;
	private JToggleButton visibleToggle;

	ScreenMarkerPanel(ScreenMarkerPlugin plugin, ScreenMarkerOverlay marker)
	{
		this.plugin = plugin;
		this.marker = marker;
		construct();
	}

	private void construct()
	{
		setLayout(new GridLayout(0, 1, 0, 3));
		JPanel container = new JPanel(new FlowLayout());

		JButton deleteButton = new JButton(DELETE_TEXT);
		deleteButton.addActionListener(l -> plugin.deleteMarker(marker));

		boolean selected = !marker.getMarker().isVisible();
		visibleToggle = new JToggleButton(selected ? SHOW_TEXT : HIDE_TEXT, selected);
		visibleToggle.setFocusable(false);
		visibleToggle.addActionListener(l ->
		{
			boolean visible = !visibleToggle.isSelected();
			marker.getMarker().setVisible(visible);
			visibleToggle.setText(visible ? HIDE_TEXT : SHOW_TEXT);
			plugin.updateConfig();
		});

		container.add(new JShadowedLabel(marker.getName()));
		container.add(visibleToggle);
		container.add(deleteButton);

		add(container);
	}
}
