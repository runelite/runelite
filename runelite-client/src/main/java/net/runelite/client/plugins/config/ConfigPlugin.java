/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.config;

import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigPlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigPlugin.class);

	private final NavigationButton navButton = new NavigationButton("Configuration");
	private final RuneLite runelite = RuneLite.getRunelite();
	private final ClientUI ui = runelite.getGui();

	@Override
	protected void startUp() throws Exception
	{
		navButton.getButton().addActionListener(this::setPluginPanel);

		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("config_icon.png")));
		navButton.getButton().setIcon(icon);

		ui.getNavigationPanel().addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
	}

	private void setPluginPanel(ActionEvent ae)
	{
		ConfigPanel panel = new ConfigPanel();
		panel.init();

		ui.expand(panel);
	}

}
