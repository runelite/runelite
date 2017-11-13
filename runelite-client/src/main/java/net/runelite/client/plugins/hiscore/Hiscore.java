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
package net.runelite.client.plugins.hiscore;

import com.google.common.eventbus.Subscribe;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import net.runelite.client.events.PlayerMenuOptionClicked;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
	name = "Hiscore plugin"
)
public class Hiscore extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(Hiscore.class);

	private static final String LOOKUP = "Lookup";

	@Inject
	ClientUI ui;

	@Inject
	MenuManager menuManager;

	@Inject
	ScheduledExecutorService executor;

	private NavigationButton navButton;
	private HiscorePanel hiscorePanel;

	@Override
	protected void startUp() throws Exception
	{
		navButton = new NavigationButton("Hiscore", () -> hiscorePanel);
		hiscorePanel = injector.getInstance(HiscorePanel.class);

		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hiscore.gif")));
		navButton.getButton().setIcon(icon);

		ui.getPluginToolbar().addNavigation(navButton);

		menuManager.addPlayerMenuItem(LOOKUP);
	}

	@Subscribe
	public void onLookupMenuClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
		{
			executor.execute(() -> hiscorePanel.lookup(event.getMenuTarget()));
		}
	}

}
