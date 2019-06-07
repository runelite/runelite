package net.runelite.mixins;

import api.events.VarClientIntChanged;
import api.events.VarClientStrChanged;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSVarcs;

@Mixin(RSVarcs.class)
public abstract class RSVarcsMixin implements RSVarcs
{
	@Shadow("client")
	private static RSClient client;

	@MethodHook(value = "setInt", end = true)
	@Inject
	public void onVarCIntChanged(int id, int value)
	{
		client.getCallbacks().post(new VarClientIntChanged(id));
	}

	@MethodHook(value = "setString", end = true)
	@Inject
	public void onVarCStrChanged(int id, String value)
	{
		client.getCallbacks().post(new VarClientStrChanged(id));
	}
}
