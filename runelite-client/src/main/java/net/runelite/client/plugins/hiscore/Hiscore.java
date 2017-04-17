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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.client.RuneLite;
import net.runelite.client.events.MenuOptionClicked;
import net.runelite.client.events.PlayerMenuOptionClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hiscore extends Plugin implements ActionListener
{
	private static final Logger logger = LoggerFactory.getLogger(Hiscore.class);

	private static final String LOOKUP = "Lookup";

	private final NavigationButton navButton = new NavigationButton("Hiscore");
	private final HiscorePanel hiscorePanel = new HiscorePanel();

	private final RuneLite runeLite = RuneLite.getRunelite();
	private final ClientUI ui = runeLite.getGui();

	public Hiscore()
	{
		navButton.getButton().addActionListener(this);

		try
		{
			ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hiscore.gif")));
			navButton.getButton().setIcon(icon);
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		ui.getNavigationPanel().addNavigation(navButton);

		runeLite.getMenuManager().addPlayerMenuItem(LOOKUP);
	}

	@Override
	public Overlay getOverlay()
	{
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ui.setPluginPanel(hiscorePanel);
		ui.expand();
	}

	@Subscribe
	public void onLookupMenuClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
		{
			ScheduledExecutorService executor = runeLite.getExecutor();
			executor.execute(() -> hiscorePanel.lookup(event.getMenuTarget()));
		}
	}

}
