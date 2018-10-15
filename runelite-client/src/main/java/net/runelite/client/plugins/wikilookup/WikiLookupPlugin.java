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
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

@PluginDescriptor(
	name = "Wiki Lookup"
)
public class WikiLookupPlugin extends Plugin implements KeyListener
{
	private static final int HOTKEY = KeyEvent.VK_SHIFT;
	private static final String WIKI = "Wiki";

	@Inject
	private Client client;

	@Inject
	private KeyManager keyManager;

	@Inject
	private WikiLookupConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WikiOrbInterface wikiOrbInterface;

	private boolean hotkeyPressed = false;

	@Provides
	WikiLookupConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WikiLookupConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(this);
		clientThread.invokeLater(wikiOrbInterface::init);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(this);
		clientThread.invokeLater(wikiOrbInterface::destroy);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY && config.boundToShift())
		{
			hotkeyPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == HOTKEY)
		{
			hotkeyPressed = false;
		}
	}

	@Subscribe
	public void onFocusChanged(final FocusChanged event)
	{
		if (!event.isFocused())
		{
			hotkeyPressed = false;
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.MINIMAP_GROUP_ID)
		{
			wikiOrbInterface.init();
		}
	}

	@Subscribe
	public void onMenuObjectClicked(MenuOptionClicked event)
	{
		wikiOrbInterface.setActive(false);

		if (event.getMenuOption().equals(WIKI))
		{
			LinkBrowser.browse("https://oldschool.runescape.wiki/w/" + Text.removeTags(event.getMenuTarget())
				.replaceAll("\\(.*?\\)", "")
				.replace(' ', '_'));
		}
		else
		{
			wikiOrbInterface.handleClick(event);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!hotkeyPressed && !wikiOrbInterface.isActive())
		{
			return;
		}

		final String option = Text.removeTags(event.getOption()).toLowerCase();

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
				addBlankOption(event.getTarget());
			}
			else if (option.contains("open"))
			{
				addBlankOption(event.getOption().replaceFirst("Open ", "").replaceAll("Journal", "") + "Diary");
			}
			else if (option.contains("guide"))
			{
				addBlankOption(event.getOption().replaceFirst("View ", "").replaceFirst(" guide", ""));
			}
		}

		if (!hotkeyPressed && (
			event.getTarget().length() >= 1
				|| option.contains("guide")
				|| option.contains("open")))
		{
			removeOption(option);
		}
	}

	private void removeOption(String option)
	{
		final MenuEntry[] entries = client.getMenuEntries();

		if (entries.length > 1)
		{
			MenuEntry[] newEntries = new MenuEntry[entries.length - 1];

			for (int i = 0; i < entries.length; ++i)
			{
				if (!(Text.removeTags(entries[i].getOption()).toLowerCase().contains(option)))
				{
					newEntries[i] = entries[i];
				}
			}

			client.setMenuEntries(newEntries);
		}
	}

	private void addBlankOption(String newTarget)
	{
		MenuEntry[] entries = client.getMenuEntries();
		MenuEntry[] newEntries = new MenuEntry[entries.length + 1];

		for (int i = 0; i < entries.length; ++i)
		{
			if (Text.removeTags(entries[i].getOption()).toLowerCase().contains("cancel"))
			{
				final MenuEntry blankOption = new MenuEntry();
				blankOption.setOption(WikiLookupPlugin.WIKI);
				blankOption.setTarget(newTarget);
				blankOption.setIdentifier(entries[i].getIdentifier());
				blankOption.setParam1(entries[i].getParam1());
				blankOption.setType(entries[i].getType());
				client.setMenuEntries(ArrayUtils.addAll(entries, blankOption));
				newEntries[newEntries.length - 1] = blankOption;
			}

			newEntries[i] = entries[i];
		}

		newEntries[newEntries.length - 1].setOption(WikiLookupPlugin.WIKI);
		MenuEntry holder = newEntries[newEntries.length - 1];
		newEntries[newEntries.length - 1] = newEntries[newEntries.length - 2];
		newEntries[newEntries.length - 2] = holder;
		client.setMenuEntries(newEntries);
	}
}
