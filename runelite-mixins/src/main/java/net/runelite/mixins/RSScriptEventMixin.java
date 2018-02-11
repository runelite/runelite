package net.runelite.mixins;

import net.runelite.api.Client;
import net.runelite.api.ExceptionWithScriptStack;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSScriptEvent;

@Mixin(RSScriptEvent.class)
public abstract class RSScriptEventMixin implements RSScriptEvent
{
	@Shadow("scriptEventTracing")
	private static boolean scriptEventTracing;

	@Shadow("clientInstance")
	private static Client client;

	@Inject
	private ExceptionWithScriptStack trace;

	@Inject
	@Override
	public ExceptionWithScriptStack getTrace()
	{
		return trace;
	}

	@Inject
	RSScriptEventMixin()
	{
		if (scriptEventTracing)
		{
			this.trace = new ExceptionWithScriptStack(client);
		}
	}
}
