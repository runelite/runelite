package net.runelite.mixins;

import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSVarcs;

@Mixin(RSVarcs.class)
public abstract class RSVarcsMixin implements RSVarcs
{
	@Shadow("client")
	private static RSClient client;

	@MethodHook(value = "setInt", end = true)
	@Inject
	public void onVarCIntChanged(int id, int value)
	{
		VarClientIntChanged event = VarClientIntChanged.INSTANCE;
		event.setIndex(id);
		client.getCallbacks().post(event);
	}

	@MethodHook(value = "setString", end = true)
	@Inject
	public void onVarCStrChanged(int id, String value)
	{
		VarClientStrChanged event = VarClientStrChanged.INSTANCE;
		event.setIndex(id);
		client.getCallbacks().post(event);
	}
}
