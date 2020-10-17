package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.Definition;

public abstract class Loader {
	public abstract Definition load(int id, byte[] b);
}
