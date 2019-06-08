package net.runelite.api;

public interface NPCDefinition
{
	/**
	 * Gets the name of the NPC.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the model IDs that compose this NPC.
	 *
	 * @return the NPCs model IDs
	 */
	int[] getModels();

	/**
	 * Gets an array of possible right-click menu actions that can be
	 * performed on the NPC.
	 *
	 * @return the menu actions
	 */
	String[] getActions();

	/**
	 * Gets whether the NPC can be clicked.
	 *
	 * @return true if the NPC can be clicked, false otherwise
	 */
	boolean isClickable();

	/**
	 * Gets whether the NPC is visible on the mini-map.
	 *
	 * @return the mini-map visible state
	 */
	boolean isMinimapVisible();

	/**
	 * Gets whether the NPC is visible.
	 *
	 * @return the visible state
	 */
	boolean isVisible();

	/**
	 * Gets the ID of the NPC.
	 *
	 * @return the ID of the NPC
	 * @see NpcID
	 */
	int getId();

	/**
	 * Gets the combat level of the NPC.
	 *
	 * @return the combat level, -1 if none
	 */
	int getCombatLevel();

	/**
	 * Gets the configuration data for the NPC.
	 *
	 * @return the configuration data
	 */
	int[] getConfigs();

	/**
	 * Transforms this NPC into a new state, which may have a different ID.
	 *
	 * @return the transformed composition
	 */
	NPCDefinition transform();

	/**
	 * Gets the size of the NPC.
	 *
	 * @return the NPCs size
	 */
	int getSize();

	/**
	 * Gets the displayed overhead icon of the NPC.
	 *
	 * @return the overhead icon
	 */
	HeadIcon getOverheadIcon();
}
