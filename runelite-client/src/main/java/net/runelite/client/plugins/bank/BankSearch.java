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

package net.runelite.client.plugins.bank;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.apache.commons.lang3.ArrayUtils;

@Singleton
public class BankSearch
{
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

	public void layoutBank()
	{
		Widget bankContainer = client.getWidget(InterfaceID.Bankmain.ITEMS);
		if (bankContainer == null)
		{
			return;
		}

		Object[] scriptArgs = bankContainer.getOnInvTransmitListener();
		if (scriptArgs == null)
		{
			return;
		}

		client.runScript(scriptArgs);
	}

	public void initSearch()
	{
		clientThread.invoke(() ->
		{
			Widget bankContainer = client.getWidget(InterfaceID.Bankmain.ITEMS);
			if (bankContainer == null || bankContainer.isHidden())
			{
				return;
			}

			Object[] bankBuildArgs = bankContainer.getOnInvTransmitListener();
			if (bankBuildArgs == null)
			{
				return;
			}

			// the search toggle script requires 1 as its first argument
			Object[] searchToggleArgs = ArrayUtils.insert(1, bankBuildArgs, 1);
			searchToggleArgs[0] = ScriptID.BANKMAIN_SEARCH_TOGGLE;

			// reset search to clear tab tags and also allow us to initiate a new search while searching
			reset(true);
			client.runScript(searchToggleArgs);
		});
	}

	public void reset(boolean closeChat)
	{
		clientThread.invoke(() ->
		{
			// This ensures that any chatbox input (e.g from search) will not remain visible when
			// selecting/changing tab
			if (closeChat)
			{
				// this clears the input text and type, and resets the chatbox to allow input
				client.runScript(ScriptID.MESSAGE_LAYER_CLOSE, 1, 1, 0);
			}
			else
			{
				client.setVarcIntValue(VarClientID.MESLAYERMODE, InputType.NONE.getType());
				client.setVarcStrValue(VarClientID.MESLAYERINPUT, "");
			}

			layoutBank();
		});
	}
}
