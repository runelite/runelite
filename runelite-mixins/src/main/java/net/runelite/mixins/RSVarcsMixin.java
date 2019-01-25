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
	@Shadow("clientInstance")
	private static RSClient client;

	@FieldHook("varCInts")
	@Inject
	public void onVarCIntChanged(int idx)
	{
		VarClientIntChanged event = VarClientIntChanged.INSTANCE;
		event.setIndex(idx);
		client.getCallbacks().post(event);
	}

	@FieldHook("varCStrings")
	@Inject
	public void onVarCStrChanged(int idx)
	{
		VarClientStrChanged event = VarClientStrChanged.INSTANCE;
		event.setIndex(idx);
		client.getCallbacks().post(idx);
	}
}
