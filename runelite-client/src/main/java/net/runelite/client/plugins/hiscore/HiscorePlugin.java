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
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.events.MenuEntryAdded;
import net.runelite.client.events.MenuOptionClicked;
import net.runelite.client.events.PlayerMenuOptionClicked;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

@PluginDescriptor(
	name = "Hiscore plugin",
	loadWhenOutdated = true
)
public class HiscorePlugin extends Plugin
{
	private static final String LOOKUP = "Lookup";

	@Inject
	ClientUI ui;
	
	@Inject
	Client client;

	@Inject
	MenuManager menuManager;

	@Inject
	ScheduledExecutorService executor;

	private NavigationButton navButton;
	private HiscorePanel hiscorePanel;

	@Override
	protected void startUp() throws Exception
	{
		hiscorePanel = injector.getInstance(HiscorePanel.class);
		navButton = new NavigationButton(
			"Hiscore",
			ImageIO.read(getClass().getResourceAsStream("hiscore.gif")),
			() -> hiscorePanel);

		ui.getPluginToolbar().addNavigation(navButton);

		menuManager.addPlayerMenuItem(LOOKUP);
	}

	@Subscribe
	public void onLookupMenuClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
		{
			lookup(event.getMenuTarget());
		}
	}
	
	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((event.getOption().equals("Add friend") || event.getOption().equals("Message")) && !event.getTarget().equals(""))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
			
			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
			menuEntry.setOption(LOOKUP);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.RUNELITE);
			
			client.setMenuEntries(menuEntries);
		}
	}
	
	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
		{
			lookup(event.getMenuTarget());
		}
	}
	
	private void lookup(String target)
	{
		executor.execute(() ->
			{
				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						if (!navButton.isSelected())
						{
							navButton.doClick();
						}
					});
				}
				catch (InterruptedException | InvocationTargetException e)
				{
					throw new RuntimeException(e);
				}

				hiscorePanel.lookup(target);
			});
	}
}
