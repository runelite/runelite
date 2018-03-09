/*
 * Copyright (c) 2018 Abex
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
package net.runelite.mixins;

import net.runelite.api.Client;
import net.runelite.api.events.ScriptEvent;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.client.callback.Hooks;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSScript;
import net.runelite.rs.api.RSScriptEvent;

import static net.runelite.api.Opcodes.RUNELITE_EXECUTE;

@Mixin(RSClient.class)
public abstract class ScriptVMMixin implements RSClient
{
	@Shadow("clientInstance")
	private static Client client;

	// This field is set by the ScriptVM raw injector
	@Inject
	private static RSScript currentScript;

	// This field is set by the ScriptVM raw injector
	@Inject
	private static int currentScriptPC;

	// Call is injected into runScript by the ScriptVM raw injector
	@Inject
	static boolean vmExecuteOpcode(int opcode)
	{
		if (opcode == RUNELITE_EXECUTE)
		{
			if (currentScript.getInstructions()[currentScriptPC] != RUNELITE_EXECUTE)
			{
				throw new AssertionError("currentScriptPC is wrong");
			}

			int stringStackSize = client.getStringStackSize();
			String stringOp = client.getStringStack()[--stringStackSize];
			client.setStringStackSize(stringStackSize);

			ScriptEvent event = new ScriptEvent();
			event.setScript(currentScript);
			event.setEventName(stringOp);
			Hooks.eventBus.post(event);
			return true;
		}
		return false;
	}

	@Copy("runScript")
	static void rs$runScript(RSScriptEvent event, int maxExecutionTime)
	{
		throw new RuntimeException();
	}

	@Replace("runScript")
	static void rl$runScript(RSScriptEvent event, int maxExecutionTime)
	{
		try
		{
			rs$runScript(event, maxExecutionTime);
		}
		finally
		{
			currentScript = null;
		}
	}
}
