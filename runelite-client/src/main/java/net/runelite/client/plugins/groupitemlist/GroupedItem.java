package net.runelite.client.plugins.groupitemlist;

import net.runelite.api.MenuEntry;

/**
 * Object used to store a MenuEntry and the quantity. Updates the entry target if necessary
 * e.g Shark to Shark [4].
 */
public class GroupedItem {

    private int count;
    private MenuEntry entry;

    /**
     * Constructor for GroupedItem.
     *
     * @param entry The menu entry to be tracked for duplicates
     */
    public GroupedItem(MenuEntry entry) {
        this.entry = entry;
        this.count = 1;
    }

    /**
     * Getter for the count.
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Getter for the menu entry, updates the target to reflect the quantity if more than 1
     * was found.
     *
     * @return Updated MenuEntry containing quantity
     */
    public MenuEntry getEntry() {
        if (count > 1) {
            updateTarget();
        }
        return entry;
    }

    /**
     * Updates the target of the menu entry to contain the quantity found.
     */
    private void updateTarget() {
        String target = entry.getTarget();
        target = target + " [" + count + "]";
        entry.setTarget(target);
    }

    /**
     * Increment count when duplicate entries are found.
     */
    public void incrementCount() {
        count += 1;
    }
}
