/*
 * Copyright (c) 2018, Tanner <https://github.com/Reasel>
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
package net.runelite.client.plugins.wikilookup;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;
import javax.inject.Inject;

@PluginDescriptor(
	name = "Wiki Lookup",
	enabledByDefault = false
)
public class WikiLookupPlugin extends Plugin
{
	private static final String WIKI = "Wiki";

	@Inject
	private Client client;

	@Inject
	private MenuManager menuManager;

	@Inject
	private WikiLookupInput inputListener;

	@Inject
	private KeyManager keyManager;

	private boolean hotKeyPressed = false;

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onMenuObjectClicked(MenuOptionClicked click)
	{
		if (click.getMenuOption().equals(WIKI))
		{
			String ourLookupName = Text.removeTags(click.getMenuTarget()).replaceAll("\\(.*?\\)", "").replace(' ', '_');
			LinkBrowser.browse("http://oldschoolrunescape.wikia.com/wiki/" + ourLookupName);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!hotKeyPressed)
		{
			return;
		}

		String option = Text.removeTags(event.getOption()).toLowerCase();

		if (event.getType() == MenuAction.EXAMINE_ITEM_GROUND.getId()
			|| event.getType() == MenuAction.EXAMINE_ITEM.getId()
			|| event.getType() == MenuAction.EXAMINE_ITEM_BANK_EQ.getId()
			|| event.getType() == MenuAction.EXAMINE_OBJECT.getId()
			|| event.getType() == MenuAction.EXAMINE_NPC.getId()
			|| event.getType() == MenuAction.WIDGET_DEFAULT.getId()
			|| event.getType() == MenuAction.WIDGET_TYPE_2.getId())
		{
			if ((option.equals("read journal:")
				|| option.equals("cast")
				|| option.equals("activate"))
				|| option.contains("play")
				|| option.equals("examine"))
			{
				addBlankOption("cancel", WIKI, event.getTarget());
			}
			else if (option.contains("open"))
			{
				addBlankOption("cancel", WIKI, event.getOption().replaceFirst("Open ", "").replaceAll("Journal", "") + "Diary");
			}
			else if (option.contains("guide"))
			{
				addBlankOption("cancel", WIKI, event.getOption().replaceFirst("View ", "").replaceFirst(" guide", ""));
			}
		}
	}

	private void changeOption(int actionID, String newOption)
	{
		MenuEntry[] entries = client.getMenuEntries();

		for (int i = 0; i < entries.length; i++)
		{
			if (entries[i].getType() == actionID)
			{
				entries[i].setOption(newOption);
				client.setMenuEntries(entries);
				return;
			}
		}
	}

	private void changeTarget(int actionID, String newTarget)
	{
		MenuEntry[] entries = client.getMenuEntries();

		for (int i = 0; i < entries.length; i++)
		{
			if (entries[i].getType() == actionID)
			{
				entries[i].setTarget(newTarget);
				client.setMenuEntries(entries);
				return;
			}
		}
	}

	private void addBlankOption(String toCopy, String newOption, String newTarget)
	{
		MenuEntry[] entries = client.getMenuEntries();
		MenuEntry[] newEntries = new MenuEntry[entries.length + 1];
		for (int i = 0; i < entries.length; ++i)
		{
			if (Text.removeTags(entries[i].getOption()).toLowerCase().contains(toCopy))
			{
				newEntries[newEntries.length - 1] = entries[i].toBuilder().option(newOption).target(newTarget).build();
			}
			newEntries[i] = entries[i];
		}
		newEntries[newEntries.length - 1].setOption(newOption);
		MenuEntry holder = newEntries[newEntries.length - 1];
		newEntries[newEntries.length - 1] = newEntries[newEntries.length - 2];
		newEntries[newEntries.length - 2] = holder;
		client.setMenuEntries(newEntries);
	}

	public void setHotKeyPressed(boolean state)
	{
		hotKeyPressed = state;
	}
}
