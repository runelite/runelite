package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSIgnored;
import net.runelite.rs.api.RSUsername;

@Mixin(RSIgnored.class)
public abstract class RSIgnoredMixin implements RSIgnored
{
	@Override
	@Inject
	public String getName()
	{
		return getRsName().getName();
	}

	@Override
	@Inject
	public String getPrevName()
	{
		RSUsername prevName = getRsPrevName();
		return prevName == null ? null : prevName.getName();
	}
}
