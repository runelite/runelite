package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.DefaultDefinition;

public class DefaultLoader extends Loader
{
	@Override
	public DefaultDefinition load(int id, byte[] b)
	{
		DefaultDefinition def = new DefaultDefinition();
		def.setId(id);
		def.bytes = b;
		return def;
	}
}
