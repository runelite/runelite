/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2024, PhraZier <https://github.com/phrazier>
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

package net.runelite.client.plugins.bank;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;

@Singleton
public class GroupStorageSearch
{
	private final Client client;
	private final ClientThread clientThread;

	@Inject
	private GroupStorageSearch(final Client client, final ClientThread clientThread)
	{
		this.client = client;
		this.clientThread = clientThread;
	}

	public void layoutGroupStorage()
	{
		Widget groupStorageContainer = client.getWidget(ComponentID.GROUP_STORAGE_ITEM_CONTAINER);
		if (groupStorageContainer == null)
		{
			return;
		}

		Object[] scriptArgs = groupStorageContainer.getOnInvTransmitListener();
		if (scriptArgs == null)
		{
			return;
		}

		client.createScriptEvent(scriptArgs)
			.setSource(groupStorageContainer)
			.run();
	}

	public void initSearch()
	{
		clientThread.invoke(() ->
		{
			Widget searchButton = client.getWidget(ComponentID.GROUP_STORAGE_SEARCH_BUTTON);
			if (searchButton == null || searchButton.isHidden())
			{
				return;
			}

			Object[] searchToggleArgs = searchButton.getOnOpListener();
			if (searchToggleArgs == null)
			{
				return;
			}

			client.createScriptEvent(searchToggleArgs) // [clientscript,shared_bank_search_toggle]
				.setOp(1)
				.run();
		});
	}
}
