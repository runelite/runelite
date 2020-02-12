/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2020 ThatGamerBlue
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

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.api.Client;
import static net.runelite.api.Opcodes.INVOKE;
import static net.runelite.api.Opcodes.RETURN;
import static net.runelite.api.Opcodes.RUNELITE_EXECUTE;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSScript;
import net.runelite.rs.api.RSScriptEvent;

@Mixin(RSClient.class)
public abstract class ScriptVMMixin implements RSClient
{
	@Shadow("client")
	private static Client client;

	// This field is set by the ScriptVM raw injector
	@Inject
	private static RSScript currentScript;

	// This field is set by the ScriptVM raw injector
	@Inject
	private static int currentScriptPC;

	@Inject
	private static ScriptPostFired deferredEvent = null;

	@Inject
	private static Stack<Integer> scriptIds = new Stack<>();

	// Call is injected into runScript by the ScriptVM raw injector
	@Inject
	static boolean vmExecuteOpcode(int opcode)
	{
		if (deferredEvent != null)
		{
			client.getCallbacks().post(ScriptPostFired.class, deferredEvent);
			deferredEvent = null;
		}
		if (opcode == RUNELITE_EXECUTE)
		{
			assert currentScript.getInstructions()[currentScriptPC] == RUNELITE_EXECUTE;

			int stringStackSize = client.getStringStackSize();
			String stringOp = client.getStringStack()[--stringStackSize];
			client.setStringStackSize(stringStackSize);

			if ("debug".equals(stringOp))
			{
				int intStackSize = client.getIntStackSize();

				String fmt = client.getStringStack()[--stringStackSize];
				StringBuffer out = new StringBuffer();
				Matcher m = Pattern.compile("%(.)").matcher(fmt);
				for (; m.find(); )
				{
					m.appendReplacement(out, "");
					switch (m.group(1).charAt(0))
					{
						case 'i':
						case 'd':
							out.append(client.getIntStack()[--intStackSize]);
							break;
						case 's':
							out.append(client.getStringStack()[--stringStackSize]);
							break;
						default:
							out.append(m.group(0)).append("=unknown");
					}
				}
				m.appendTail(out);

				client.getLogger().debug(out.toString());

				client.setStringStackSize(stringStackSize);
				client.setIntStackSize(intStackSize);
				return true;
			}

			ScriptCallbackEvent event = new ScriptCallbackEvent();
			event.setScript(currentScript);
			event.setEventName(stringOp);
			client.getCallbacks().post(ScriptCallbackEvent.class, event);
			return true;
		}
		else if (opcode == INVOKE)
		{
			int id = currentScript.getIntOperands()[currentScriptPC];
			scriptIds.push(id);
			ScriptPreFired event = new ScriptPreFired(id);
			event.setScriptEvent(null);
			client.getCallbacks().post(ScriptPreFired.class, event);
		}
		else if (opcode == RETURN)
		{
			if (scriptIds.size() > 1) // let the runScript method handle the final script
			{
				deferredEvent = new ScriptPostFired(scriptIds.pop()); // fire the event when we've left the script
			}
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
		Object[] arguments = event.getArguments();
		if (arguments != null && arguments.length > 0 && arguments[0] instanceof JavaScriptCallback)
		{
			try
			{
				ScriptPreFired preFired = new ScriptPreFired(-1);
				preFired.setScriptEvent(event);
				client.getCallbacks().post(ScriptPreFired.class, preFired);

				((JavaScriptCallback) arguments[0]).run(event);

				ScriptPostFired postFired = new ScriptPostFired(-1);
				client.getCallbacks().post(ScriptPostFired.class, postFired);
			}
			catch (Exception e) // wont catch assertions
			{
				client.getLogger().error("Error in JavaScriptCallback", e);
			}
		}
		else
		{
			try
			{
				try
				{
					scriptIds.push((Integer) event.getArguments()[0]); // this is safe because it will always be the script id

					ScriptPreFired preFired = new ScriptPreFired(scriptIds.peek()); // peek doesn't remove the top item
					preFired.setScriptEvent(event);
					client.getCallbacks().post(ScriptPreFired.class, preFired);
				}
				catch (ClassCastException ignored)
				{
				}

				rs$runScript(event, maxExecutionTime);

				if (!scriptIds.empty())
				{
					ScriptPostFired postFired = new ScriptPostFired(scriptIds.pop()); // hopefully the stack should be dry at this point
					assert scriptIds.empty() : "Script ID stack should be empty! Contains: " + getAllScriptIds();
					client.getCallbacks().post(ScriptPostFired.class, postFired);
				}
			}
			finally
			{
				currentScript = null;
				while (!scriptIds.empty())
				{
					scriptIds.pop(); // make sure the stack is empty, something disastrous happened
				}
			}
		}
	}

	@Inject
	@Override
	public void runScript(Object... args)
	{
		assert isClientThread();
		assert currentScript == null;
		assert args[0] instanceof Integer || args[0] instanceof JavaScriptCallback : "The first argument should always be a ScriptID!";
		RSScriptEvent se = createScriptEvent();
		se.setArguments(args);
		runScript(se, 5000000);
	}

	@Inject
	private static String getAllScriptIds()
	{
		ArrayList<Integer> ids = new ArrayList<>(scriptIds);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Object item : ids)
		{
			if (first)
			{
				first = false;
			}
			else
			{
				sb.append(", ");
			}
			sb.append(item);
		}
		return sb.toString();
	}
}