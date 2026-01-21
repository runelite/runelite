/*
 * Copyright (c) 2019 Zakru <https://github.com/Zakru>
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
package net.runelite.client.plugins.bankitemnotes;

import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Bank Item Notes",
	description = "Add custom notes to items in bank",
	tags = {"bank", "overlay", "tooltips", "notes"},
	enabledByDefault = false
)
public class BankItemNotesPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "bankitemnotes";
	private static final String KEY_PREFIX = "note_";
	private static final String SET_NOTE_FORMAT = "Set note for %s";

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BankItemNotesOverlay overlay;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Getter
	@Setter
	private String hoveredNote;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());

		if (groupId == WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() && event.getOption().equals("Examine"))
		{
			hoveredNote = getNote(Text.removeTags(event.getTarget()));

			MenuEntry entry = new MenuEntry();
			entry.setOption("Set-note");
			entry.setType(MenuAction.RUNELITE.getId());
			entry.setTarget(event.getTarget());
			entry.setParam0(event.getActionParam0());
			entry.setParam1(event.getActionParam1());

			client.setMenuEntries(ObjectArrays.concat(client.getMenuEntries(), entry));
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (WidgetInfo.TO_GROUP(event.getWidgetId()) == WidgetInfo.BANK_ITEM_CONTAINER.getGroupId())
		{
			if (Strings.isNullOrEmpty(event.getMenuTarget())) return;

			if (event.getMenuOption().equals("Set-note"))
			{
				event.consume();

				//Friends have color tags
				final String sanitizedName = Text.removeTags(event.getMenuTarget());
				final String note = getNote(sanitizedName);

				// Open the new chatbox input dialog
				chatboxPanelManager.openTextInput(String.format(SET_NOTE_FORMAT, sanitizedName))
					.value(Strings.nullToEmpty(note))
					.onDone(content ->
					{
						if (content == null) return;

						content = Text.removeTags(content).trim();
						setNote(sanitizedName, content);
					}).build();
			}
		}
	}

	private String getNote(String name)
	{
		return configManager.getConfiguration(CONFIG_GROUP, KEY_PREFIX + name);
	}

	private void setNote(String name, String content)
	{
		if (Strings.isNullOrEmpty(content))
		{
			configManager.unsetConfiguration(CONFIG_GROUP, KEY_PREFIX + name);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, KEY_PREFIX + name, content);
		}
	}
}
