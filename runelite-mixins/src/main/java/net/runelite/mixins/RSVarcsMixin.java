package net.runelite.mixins;

import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.client.callback.Hooks;
import net.runelite.rs.api.RSVarcs;

@Mixin(RSVarcs.class)
public abstract class RSVarcsMixin implements RSVarcs
{
	@FieldHook("varCInts")
	@Inject
	public void onVarCIntChanged(int idx)
	{
		Hooks.eventBus.post(new VarClientIntChanged(idx));
	}

	@FieldHook("varCStrings")
	@Inject
	public void onVarCStrChanged(int idx)
	{
		Hooks.eventBus.post(new VarClientStrChanged(idx));
	}
}
