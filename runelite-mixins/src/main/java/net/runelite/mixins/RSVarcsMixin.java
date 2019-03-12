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
	@Shadow("clientInstance")
	private static RSClient client;

	@MethodHook(value = "putVarc", end = true)
	@Inject
	public void onVarCIntChanged(int id, int value)
	{
		client.getCallbacks().post(new VarClientIntChanged(id));
	}

	@MethodHook(value = "putVarcStringNew", end = true)
	@Inject
	public void onVarCStrChanged(int id, String value)
	{
		client.getCallbacks().post(new VarClientStrChanged(id));
	}
}
