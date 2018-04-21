/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.chat;

import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varcs;
import net.runelite.api.events.ScriptCallbackEvent;

@Slf4j
@Singleton
public class CommandManager
{
	private static final String CALLBACK_NAME = "runeliteCommand";
	private final Map<String, Consumer<List<String>>> commands = new HashMap<>();
	private final Provider<Client> clientProvider;

	@Inject
	public CommandManager(Provider<Client> clientProvider)
	{
		this.clientProvider = clientProvider;
	}

	public void registerCommand(String command, Consumer<List<String>> action)
	{
		commands.put(command, action);
	}

	public void unregisterCommand(String command)
	{
		commands.remove(command);
	}

	@Subscribe
	private void scriptEvent(ScriptCallbackEvent event)
	{
		if (!CALLBACK_NAME.equals(event.getEventName()))
		{
			return;
		}

		Client client = clientProvider.get();
		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();
		Varcs varcs = client.getVarcs();
		String typedText = varcs.getStrVar(VarClientStr.CHATBOX_TYPED_TEXT);

		//substring 2 because we want to exclude "::"
		List<String> line = new ArrayList<>(Arrays.asList(typedText.substring(2).split(" ")));

		//the command will always be the first entry in the list, and we do not want to pass it on as argument so we remove it
		String command = line.remove(0);

		Consumer<List<String>> action = commands.get(command);

		if (action != null)
		{
			action.accept(line);

			// tell the script theres a runelite command fired
			intStack[intStackSize - 1] = 1;
		}
		else
		{
			// tell the script theres no runelite command fired
			intStack[intStackSize - 1] = 0;
		}

		log.debug("Command fired: " + command + " <" + line + ">");
	}
}
