/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.banktags.tabs;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;

public class BankSearch
{
	// Widget indexes for searching
	private static final int INNER_CONTAINER_IDX = 2;
	private static final int SETTINGS_IDX = 4;
	private static final int ITEM_CONTAINER_IDX = 7;
	private static final int SCROLLBAR_IDX = 8;
	private static final int BOTTOM_BAR_IDX = 9;
	private static final int SEARCH_BUTTON_BACKGROUND_IDX = 15;
	private static final int TITLE_BAR_IDX = 16;
	private static final int ITEM_COUNT_IDX = 17;
	private static final int TAB_BAR_IDX = 18;
	private static final int INCINERATOR_IDX = 19;
	private static final int INCINERATOR_CONFIRM_IDX = 20;
	private static final int HIDDEN_WIDGET_IDX = 21;

	private final Client client;
	private final ClientThread clientThread;

	@Inject
	private BankSearch(
		final Client client,
		final ClientThread clientThread
	)
	{
		this.client = client;
		this.clientThread = clientThread;
	}

	public void search(InputType inputType, String search, Boolean closeInput)
	{
		clientThread.invoke(() ->
		{
			Widget bankContainer = client.getWidget(WidgetInfo.BANK_CONTAINER);
			if (bankContainer == null || bankContainer.isHidden())
			{
				return;
			}

			Object[] widgetIds = bankContainer.getOnLoadListener();

			// In case the widget ids array is incorrect, do not proceed
			if (widgetIds == null || widgetIds.length < 21)
			{
				return;
			}
			// This ensures that any chatbox input (e.g from search) will not remain visible when
			// selecting/changing tab
			if (closeInput)
			{
				client.runScript(ScriptID.RESET_CHATBOX_INPUT);
			}

			client.setVar(VarClientInt.INPUT_TYPE, inputType.getType());
			client.setVar(VarClientStr.INPUT_TEXT, search);

			client.runScript(ScriptID.BANK_LAYOUT,
				WidgetInfo.BANK_CONTAINER.getId(),
				widgetIds[INNER_CONTAINER_IDX],
				widgetIds[SETTINGS_IDX],
				widgetIds[ITEM_CONTAINER_IDX],
				widgetIds[SCROLLBAR_IDX],
				widgetIds[BOTTOM_BAR_IDX],
				widgetIds[TITLE_BAR_IDX],
				widgetIds[ITEM_COUNT_IDX],
				widgetIds[SEARCH_BUTTON_BACKGROUND_IDX],
				widgetIds[TAB_BAR_IDX],
				widgetIds[INCINERATOR_IDX],
				widgetIds[INCINERATOR_CONFIRM_IDX],
				widgetIds[HIDDEN_WIDGET_IDX]);
		});
	}

	public void reset(Boolean closeChat)
	{
		search(InputType.NONE, "", closeChat);
	}
}
