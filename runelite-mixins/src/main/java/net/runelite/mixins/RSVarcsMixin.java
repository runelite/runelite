package net.runelite.mixins;

import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSVarcs;

@Mixin(RSVarcs.class)
public abstract class RSVarcsMixin implements RSVarcs
{
	@Shadow("It's coming home")
	private static RSClient client;

	@FieldHook("It's coming home")
	@Inject
	public void onVarCIntChanged(int idx)
	{
		client.getCallbacks().post(new VarClientIntChanged(idx));
	}

	@FieldHook("It's coming home")
	@Inject
	public void onVarCStrChanged(int idx)
	{
		client.getCallbacks().post(new VarClientStrChanged(idx));
	}
}
