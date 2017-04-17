/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
package net.runelite.client.plugins.devtools;

import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.hiscore.HiscorePanel;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DevTools extends Plugin implements ActionListener
{
	private final DevToolsOverlay overlay = new DevToolsOverlay();
	private final DevToolsPanel panel = new DevToolsPanel();
	private final NavigationButton navButton = new NavigationButton("DevTools");
	private final ClientUI ui = RuneLite.getRunelite().getGui();

	static Font font = null;

	public DevTools()
	{
		navButton.getButton().addActionListener(this);
		try
		{
			ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("devtools_icon.png")));
			navButton.getButton().setIcon(icon);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ui.getNavigationPanel().addNavigation(navButton);

		URL fontUrl = getClass().getResource("runescape.ttf");
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (font != null)
		{
			font = font.deriveFont(Font.PLAIN, 16);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ui.setPluginPanel(panel);
		ui.expand();
	}

}
