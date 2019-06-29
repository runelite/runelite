package net.runelite.api;

/**
 * Represents an index in the cache
 */
public interface IndexDataBase
{
	/**
	 * Returns true if any cache overlay in this index is outdated due to hash mismatch
	 */
	boolean isOverlayOutdated();
}
