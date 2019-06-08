package net.runelite.api;
import java.util.EnumSet;

/**
 * Holds data of a RuneScape world.
 */
public interface World
{
	/**
	 * Gets all applicable world types for this world.
	 *
	 * @return the world types
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
	 * Gets the current number of players logged in the world.
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
	 * Sets the player count of the world.
	 *
	 * @param playerCount the new player count
	 */
	void setPlayerCount(int playerCount);

	/**
	 * Gets the world location value.
	 *
	 * @return the world location
	 */
	int getLocation();

	/**
	 * Sets the world location value.
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
	 * Gets the worlds index.
	 *
	 * @return the index
	 */
	int getIndex();

	/**
	 *  Sets the worlds index.
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
	 * Gets the world number.
	 *
	 * @return the world number
	 */
	int getId();

	/**
	 * Sets the world number.
	 *
	 * @param id the world number
	 */
	void setId(int id);

	/**
	 * Gets the world activity description.
	 * <p>
	 * For example, world 2 would return "Trade - Members".
	 *
	 * @return the world activity
	 */
	String getActivity();

	/**
	 * Sets the world activity description.
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
	 * Gets the address of the world.
	 *
	 * @return the world address
	 */
	String getAddress();

	/**
	 * Sets the address of the world.
	 *
	 * @param address the address
	 */
	void setAddress(String address);
}
