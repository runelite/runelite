package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSUser;
import net.runelite.rs.api.RSUserList;
import net.runelite.rs.api.RSUsername;

@Mixin(RSUserList.class)
public abstract class RSUserListMixin implements RSUserList
{
	/**
	 * Default implementation of rl$add
	 *
	 * @param name
	 * @param prevName
	 */
	@Inject
	@Override
	public void rl$add(RSUsername name, RSUsername prevName)
	{
	}

	/**
	 * Default implementation of rl$del
	 *
	 * @param nameable
	 */
	@Inject
	@Override
	public void rl$remove(RSUser nameable)
	{
	}

	@Inject
	@MethodHook(value = "addLast", end = true)
	public void add(RSUsername name, RSUsername prevName)
	{
		rl$add(name, prevName);
	}

	@Inject
	@MethodHook("remove")
	public void remove(RSUser nameable)
	{
		rl$remove(nameable);
	}
}
