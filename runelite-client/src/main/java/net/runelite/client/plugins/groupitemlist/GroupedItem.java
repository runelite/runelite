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
    GroupedItem(MenuEntry entry) {
        this.entry = entry;
        this.count = 0;
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
    MenuEntry getEntry(GroupItemListConfig.positionOption pos, GroupItemListConfig.styleOption style) {
        if (count > 1) {
            updateTarget(pos, style);
        }
        return entry;
    }

    /**
     * Updates the target of the menu entry to contain the quantity found.
     */
    private void updateTarget(GroupItemListConfig.positionOption pos, GroupItemListConfig.styleOption style) {
        String target = entry.getTarget();
        String quantity = null;

        switch (style) {
            case X_NUM:
                quantity = "x" + count;
                break;
            case SQUARE:
                quantity = "[" + count + "]";
                break;
            case PARENTHESIS:
                quantity = "(" + count + ")";
                break;
        }

        switch (pos) {
            case APPEND:
                target = target + " " + quantity;
                break;
            case PREPEND:
                target = quantity + " " + target;
                break;
        }
        entry.setTarget(target);
    }

    /**
     * Increment count when duplicate entries are found.
     */
    void incrementCount() {
        count += 1;
    }
}
