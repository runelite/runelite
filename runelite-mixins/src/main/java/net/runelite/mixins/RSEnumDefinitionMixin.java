package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSEnumDefinition;

@Mixin(RSEnumDefinition.class)
public abstract class RSEnumDefinitionMixin implements RSEnumDefinition
{
	@Inject
	@Override
	public int getIntValue(int key)
	{
		final int[] keys = getKeys();
		if (keys == null)
		{
			return getDefaultInt();
		}

		for (int i = 0; i < keys.length; ++i)
		{
			if (keys[i] == key)
			{
				final int[] values = getIntVals();
				return values[i];
			}
		}
		return getDefaultInt();
	}

	@Inject
	@Override
	public String getStringValue(int key)
	{
		final int[] keys = getKeys();
		if (keys == null)
		{
			return getDefaultString();
		}

		for (int i = 0; i < keys.length; ++i)
		{
			if (keys[i] == key)
			{
				final String[] values = getStringVals();
				return values[i];
			}
		}
		return getDefaultString();
	}
}
