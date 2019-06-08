package net.runelite.api;

import java.util.Collection;

/**
 * A data structure that uses a hash function to compute an index into an
 * array of buckets from which node objects can be quickly obtained.
 */
public interface HashTable<T extends Node>
{
	/**
	 * Gets a node by its hash value.
	 *
	 * @param value the node value
	 * @return the associated node
	 */
	T get(long value);

	/**
	 * Gets a collection of all nodes stored in this table.
	 *
	 * @return the nodes stored
	 */
	Collection<T> getNodes();
}
