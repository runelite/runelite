package net.runelite.mixins;

import net.runelite.api.events.PostItemDefinition;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSItemDefinition;

@Mixin(RSItemDefinition.class)
public abstract class RSItemDefinitionMixin implements RSItemDefinition
{
	private static final int DEFAULT_CUSTOM_SHIFT_CLICK_INDEX = -2;

	@Shadow("client")
	private static RSClient client;

	@Inject
	private int shiftClickActionIndex = DEFAULT_CUSTOM_SHIFT_CLICK_INDEX;

	@Inject
	RSItemDefinitionMixin()
	{
	}

	@Inject
	@Override
	public boolean isStackable()
	{
		return getIsStackable() != 0;
	}

	@Inject
	@Override
	public void setShiftClickActionIndex(int shiftClickActionIndex)
	{
		this.shiftClickActionIndex = shiftClickActionIndex;
	}

	@Copy("getShiftClickIndex")
	abstract int rs$getShiftClickActionIndex();

	@Replace("getShiftClickIndex")
	public int getShiftClickActionIndex()
	{
		return shiftClickActionIndex == DEFAULT_CUSTOM_SHIFT_CLICK_INDEX ? rs$getShiftClickActionIndex() : shiftClickActionIndex;
	}

	@Inject
	@Override
	public void resetShiftClickActionIndex()
	{
		shiftClickActionIndex = DEFAULT_CUSTOM_SHIFT_CLICK_INDEX;
	}

	@Inject
	@MethodHook(value = "post", end = true)
	public void post()
	{
		final PostItemDefinition event = new PostItemDefinition();
		event.setItemDefinition(this);
		client.getCallbacks().post(PostItemDefinition.class, event);
	}
}
