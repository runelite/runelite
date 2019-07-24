package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSUserList<T extends RSUser>
{
	@Import("getSize")
	int getCount();

	@Import("array")
	T[] getNameables();

	@Import("contains")
	boolean isMember(RSUsername var1);

	@Import("getByUsername")
	T findByName(RSUsername name);

	/**
	 * Method called by the container when an element is added
	 * @param name
	 * @param prevName
	 */
	void rl$add(RSUsername name, RSUsername prevName);

	/**
	 * Method called by the container when an element is removed
	 * @param nameable
	 */
	void rl$remove(RSUser nameable);
}
