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

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevTools extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(DevTools.class);

	private final DevToolsOverlay overlay = new DevToolsOverlay(this);
	private final DevToolsPanel panel = new DevToolsPanel(this);
	private final NavigationButton navButton = new NavigationButton("DevTools");
	private final ClientUI ui = RuneLite.getRunelite().getGui();

	private boolean togglePlayers;
	private boolean toggleNpcs;
	private boolean toggleGroundItems;
	private boolean toggleGroundObjects;
	private boolean toggleGameObjects;
	private boolean toggleWalls;
	private boolean toggleDecor;
	private boolean toggleInventory;

	private Font font;

	public DevTools()
	{
		navButton.getButton().addActionListener(this::setPluginPanel);

		try
		{
			ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("devtools_icon.png")));
			navButton.getButton().setIcon(icon);
		}
		catch (IOException ex)
		{
			logger.warn("Unable to load devtools icon", ex);
		}

		ui.getNavigationPanel().addNavigation(navButton);

		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("runescape.ttf"));

			font = font.deriveFont(Font.PLAIN, 16);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		}
		catch (FontFormatException | IOException ex)
		{
			logger.warn("Unable to load font", ex);
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	private void setPluginPanel(ActionEvent e)
	{
		ui.expand(panel);
	}

	public Font getFont()
	{
		return font;
	}

	public void togglePlayers()
	{
		togglePlayers = !togglePlayers;
	}

	public void toggleNpcs()
	{
		toggleNpcs = !toggleNpcs;
	}

	public void toggleGroundItems()
	{
		toggleGroundItems = !toggleGroundItems;
	}

	public void toggleGroundObjects()
	{
		toggleGroundObjects = !toggleGroundObjects;
	}

	public void toggleGameObjects()
	{
		toggleGameObjects = !toggleGameObjects;
	}

	public void toggleWalls()
	{
		toggleWalls = !toggleWalls;
	}

	public void toggleDecor()
	{
		toggleDecor = !toggleDecor;
	}

	public void toggleInventory()
	{
		toggleInventory = !toggleInventory;
	}

	public boolean isTogglePlayers()
	{
		return togglePlayers;
	}

	public boolean isToggleNpcs()
	{
		return toggleNpcs;
	}

	public boolean isToggleGroundItems()
	{
		return toggleGroundItems;
	}

	public boolean isToggleGroundObjects()
	{
		return toggleGroundObjects;
	}

	public boolean isToggleGameObjects()
	{
		return toggleGameObjects;
	}

	public boolean isToggleWalls()
	{
		return toggleWalls;
	}

	public boolean isToggleDecor()
	{
		return toggleDecor;
	}

	public boolean isToggleInventory()
	{
		return toggleInventory;
	}
}
