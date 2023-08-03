package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RSInventoryHelper {

    private final int INVENTORY_CONTAINER_ID = 9764864;
//    private final int UNKNOWN_WIDGET_ID = 786433;

    public boolean isOpen() {
        return Alfred.api.tabs().getCurrentTab() == WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB;
//        Widget widget = Alfred.api.widgets().getWidget(UNKNOWN_WIDGET_ID);
//        Alfred.api.tabs().getCurrentTab() == WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB;
//        if (widget == null) {
//            return false;
//        }
//
//        return !widget.isHidden() && !widget.isSelfHidden();
    }

    public void open() {
        if (!isOpen()) {
            Alfred.api.tabs().clickInventoryTab();
            Alfred.sleepUntil(this::isOpen, 100, 2000);
        }
    }

    public int count() {
        open();
        Widget inventoryWidget = Alfred.api.widgets().getWidget(INVENTORY_CONTAINER_ID);
        int itemCount = 0;

        for (Widget item : inventoryWidget.getDynamicChildren()) {
            if (item == null) {
                continue;
            }

            if (item.isHidden() || item.isSelfHidden()) {
                continue;
            }

            if (!item.getName().isEmpty()) {
                itemCount++;
            }
        }
        return itemCount;
    }

    public boolean isFull() {
        return count() == 28;
    }

    public boolean isEmpty() {
        return count() == 0;
    }

    private boolean internalClickSlot(int slot, boolean leftClick) {
        int correctSlot = slot - 1;

        open();

        Widget slotWidget = Alfred.api.widgets().getChildWidget(INVENTORY_CONTAINER_ID, correctSlot);
        if (slotWidget == null) {
            return false;
        }

        if (leftClick) {
            Alfred.getMouse().leftClick(slotWidget.getBounds());
        } else {
            Alfred.getMouse().rightClick(slotWidget.getBounds());
        }

        return true;
    }


    public boolean leftClickSlot(int slot) {
        return internalClickSlot(slot, true);
    }

    public boolean rightClickSlot(int slot) {
        return internalClickSlot(slot, false);
    }

    public RSInventoryItem getItemFromSlot(int slot) {
        int correctSlot = slot - 1;

        Widget item = Alfred.api.widgets().getChildWidget(INVENTORY_CONTAINER_ID, correctSlot);

        if (item == null) {
            return null;
        }

        return new RSInventoryItem(item);
    }

    private List<RSInventoryItem> internalGetItems() {
        open();

        List<RSInventoryItem> rsInventoryItemList = new ArrayList<>();
        Widget inventoryWidget = Alfred.api.widgets().getWidget(INVENTORY_CONTAINER_ID);

        for (Widget item : inventoryWidget.getDynamicChildren()) {
            rsInventoryItemList.add(new RSInventoryItem(item));
        }

        return rsInventoryItemList;
    }

    public List<RSInventoryItem> getItems() {
        return internalGetItems();
    }

    public List<RSInventoryItem> getItems(int itemId) {
        return internalGetItems().stream().filter(item -> item.getId() == itemId).collect(Collectors.toList());
    }

    public List<RSInventoryItem> getItems(RSInventoryItem rsInventoryItem) {
        return getItems(rsInventoryItem.getId());
    }

    public List<RSInventoryItem> getItems(String name) {
        return internalGetItems().stream().filter(item -> item.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public boolean containsItem(int itemId) {
        return internalGetItems().stream().anyMatch(item -> item.getId() == itemId);
    }

    public boolean containsItem(RSInventoryItem rsInventoryItem) {
        return containsItem(rsInventoryItem.getId());
    }

    public boolean containsItem(String name) {
        return internalGetItems().stream().anyMatch(item -> item.getName().equalsIgnoreCase(name));
    }

    private boolean internalDrop(RSInventoryItem rsInventoryItem) {
        int currentCount = count();
        boolean success = rsInventoryItem.interact("drop");
        if (!success) {
            return false;
        }
        return Alfred.sleepUntil(() -> count() == currentCount - 1, 100, 5000);
    }

    private boolean internalDropAll(List<RSInventoryItem> rsInventoryItems) {
        for (RSInventoryItem rsInventoryItem : rsInventoryItems) {
            internalDrop(rsInventoryItem);
        }
        return true;
    }

    private boolean internalDropSlot(int slot) {
        if (slot < 1 || slot > 28) {
            return false;
        }

        if (isEmpty()) {
            return true;
        }

        RSInventoryItem rsInventoryItem = getItemFromSlot(slot);
        internalDrop(rsInventoryItem);
        return true;
    }

    public boolean drop(RSInventoryItem rsInventoryItem) {
        return internalDrop(rsInventoryItem);
    }

    public boolean dropFirst(String name) {
        RSInventoryItem rsInventoryItem = getItems(name).stream().findFirst().orElse(null);
        if (rsInventoryItem == null) return false;
        return internalDrop(rsInventoryItem);
    }

    public boolean dropFirst(int itemId) {
        RSInventoryItem rsInventoryItem = getItems(itemId).stream().findFirst().orElse(null);
        if (rsInventoryItem == null) return false;
        return internalDrop(rsInventoryItem);
    }

    public boolean dropAll(String name) {
        List<RSInventoryItem> rsInventoryItems = getItems(name);
        if (rsInventoryItems.isEmpty()) {
            return false;
        }
        return internalDropAll(rsInventoryItems);
    }

    public boolean dropAll(int itemId) {
        return internalDropAll(getItems(itemId));
    }

    public boolean dropAll(RSInventoryItem rsInventoryItem) {
        return internalDropAll(getItems(rsInventoryItem.getId()));
    }

    public boolean dropSlot(int slot) {
        return internalDropSlot(slot);
    }

    public boolean dropSlots(int... slots) {
        for (int slot : slots) {
            internalDropSlot(slot);
        }
        return true;
    }

    public boolean dropAllBetween(int start, int end) {
        for (int i = start; i <= end; i++) {
            internalDropSlot(i);
        }
        return true;
    }

    private boolean internalInteract(RSInventoryItem rsInventoryItem, String action) {
        if (rsInventoryItem == null) {
            return false;
        }

        if (!rsInventoryItem.getInventoryActions().contains(action)) {
            return false;
        }

        return rsInventoryItem.interact(action);
    }


    public boolean interactFirst(RSInventoryItem rsInventoryItem, String action) {
        return internalInteract(rsInventoryItem, action);
    }

    public boolean interactFirst(String name, String action) {
        RSInventoryItem rsInventoryItem = getItems(name).stream().findFirst().orElse(null);
        return internalInteract(rsInventoryItem, action);
    }

    public boolean interactFirst(int itemId, String action) {
        RSInventoryItem rsInventoryItem = getItems(itemId).stream().findFirst().orElse(null);
        return internalInteract(rsInventoryItem, action);
    }

    private boolean internalInteractAll(RSInventoryItem rsInventoryItem, String action) {
        List<RSInventoryItem> rsInventoryItems = getItems(rsInventoryItem.getId());
        for (RSInventoryItem item : rsInventoryItems) {
            internalInteract(item, action);
            Alfred.sleep(75, 150);
        }
        return true;
    }

    public boolean interactAll(RSInventoryItem rsInventoryItem, String action) {
        return internalInteractAll(rsInventoryItem, action);
    }

    public boolean interactAll(String name, String action) {
        RSInventoryItem rsInventoryItem = getItems(name).stream().findFirst().orElse(null);
        if (rsInventoryItem == null) {
            return false;
        }
        return internalInteractAll(rsInventoryItem, action);
    }

    public boolean interactAll(int itemId, String action) {
        RSInventoryItem rsInventoryItem = getItems(itemId).stream().findFirst().orElse(null);
        if (rsInventoryItem == null) {
            return false;
        }
        return internalInteractAll(rsInventoryItem, action);
    }
}

