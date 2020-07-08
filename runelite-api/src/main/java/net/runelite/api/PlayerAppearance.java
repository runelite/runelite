package net.runelite.api;

import net.runelite.api.kit.KitType;

/**
 * Represents the template of a player.
 */
public interface PlayerAppearance
{
    /**
     * Gets an array of IDs related to equipment slots.
     * <p>
     * If the ID for a specific slot is between 256 and 512, subtracting
     * 256 will result in the kit ID. Values above 512 indicate an item
     * and can be converted to the item ID by subtracting 512.
     *
     * @return the equipment IDs
     */
    int[] getEquipmentIds();

    /**
     * Gets the equipment ID of a particular slot.
     *
     * @param type equipment slot
     * @return the equipment ID
     */
    int getEquipmentId(KitType type);

    /**
     * Gets the kit ID of a particular slot.
     *
     * @param type equipment slot
     * @return the kit ID
     */
    int getKitId(KitType type);

    /**
     * Update the cached hash value for player equipment
     * Used to cache the player models based on equipment.
     */
    void setHash();

    void setTransformedNpcId(int id);
}