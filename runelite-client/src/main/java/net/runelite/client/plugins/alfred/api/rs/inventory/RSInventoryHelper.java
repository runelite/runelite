package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RSInventoryHelper {

    private final int INVENTORY_CONTAINER_ID = 9764864;

    public boolean isOpen() {
        Alfred.setStatus("Checking if inventory is open");

        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget widget = Alfred.getClient().getWidget(786433);
            if (widget == null) {
                return false;
            }

            return !widget.isHidden() && !widget.isSelfHidden();
        });
    }

    public void open() {
        Alfred.setStatus("Opening inventory");

        if (!isOpen()) {
            Alfred.api.tabs().clickInventoryTab();
            Alfred.sleepUntil(this::isOpen, 100, 2000);
        }
    }

    public int count() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
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

                if (item.getName().length() > 0) {
                    itemCount++;
                }
            }
            return itemCount;
        });
    }

    public boolean isFull() {
        return count() == 28;
    }

    public boolean isEmpty() {
        return count() == 0;
    }

    private boolean clickSlot(int slot, boolean leftClick) {
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
        return clickSlot(slot, true);
    }

    public boolean rightClickSlot(int slot) {
        return clickSlot(slot, false);
    }

    public RSInvetoryItem getItemFromSlot(int slot) {
        int correctSlot = slot - 1;

        Widget item = Alfred.api.widgets().getChildWidget(INVENTORY_CONTAINER_ID, correctSlot);

        if (item == null) {
            return null;
        }

        return new RSInvetoryItem(item);
    }

    private List<RSInvetoryItem> internalGetItems() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            open();

            List<RSInvetoryItem> rsInvetoryItemList = new ArrayList<>();
            Widget inventoryWidget = Alfred.api.widgets().getWidget(INVENTORY_CONTAINER_ID);

            for (Widget item : inventoryWidget.getDynamicChildren()) {
                rsInvetoryItemList.add(new RSInvetoryItem(item));
            }

            return rsInvetoryItemList;
        });
    }

    public List<RSInvetoryItem> getItems() {
        return internalGetItems();
    }

    public List<RSInvetoryItem> getItems(int itemId) {
        return internalGetItems().stream().filter(rsInvetoryItem -> rsInvetoryItem.getId() == itemId).collect(Collectors.toList());
    }

    public List<RSInvetoryItem> getItems(String name) {
        return internalGetItems().stream().filter(rsInvetoryItem -> rsInvetoryItem.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public boolean clickAction(String action) {
        RSMenu rsMenu = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.api.menu().getMenu());

        if (!rsMenu.hasAction(action)) {
            return false;
        }
        return rsMenu.clickAction(action);
    }

    private boolean internalDrop(RSInvetoryItem rsInvetoryItem) {
        if (rsInvetoryItem == null) {
            return false;
        }

        Alfred.getMouse().rightClick(rsInvetoryItem.getBounds());
        Alfred.sleep(200, 600);
        return clickAction("drop");
    }

    private boolean internalDropAll(List<RSInvetoryItem> rsInvetoryItems) {
        for (RSInvetoryItem rsInvetoryItem : rsInvetoryItems) {
            internalDrop(rsInvetoryItem);
            Alfred.sleep(75, 150);
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

        RSInvetoryItem rsInvetoryItem = getItemFromSlot(slot);
        internalDrop(rsInvetoryItem);
        Alfred.sleep(75, 150);
        return true;
    }

    public boolean drop(RSInvetoryItem rsInvetoryItem) {
        return internalDrop(rsInvetoryItem);
    }

    public boolean dropFirst(String name) {
        RSInvetoryItem rsInvetoryItem = getItems(name).stream().findFirst().orElse(null);
        return internalDrop(rsInvetoryItem);
    }

    public boolean dropFirst(int itemId) {
        RSInvetoryItem rsInvetoryItem = getItems(itemId).stream().findFirst().orElse(null);
        return internalDrop(rsInvetoryItem);
    }

    public boolean dropFirst(RSInvetoryItem rsInvetoryItem) {
        return internalDrop(rsInvetoryItem);
    }

    public boolean dropAll(String name) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(name);
        return internalDropAll(rsInvetoryItems);
    }

    public boolean dropAll(int itemId) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(itemId);
        return internalDropAll(rsInvetoryItems);
    }

    public boolean dropAll(RSInvetoryItem rsInvetoryItem) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(rsInvetoryItem.getId());
        return internalDropAll(rsInvetoryItems);
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

    private boolean internalInteract(RSInvetoryItem rsInvetoryItem, String action) {
        if (rsInvetoryItem == null) {
            return false;
        }

        if (!rsInvetoryItem.getInventoryActions().contains(action)) {
            return false;
        }

        Alfred.getMouse().rightClick(rsInvetoryItem.getBounds());
        Alfred.sleep(200, 600);
        return clickAction(action);
    }

    public boolean interactFirst(RSInvetoryItem rsInvetoryItem, String action) {
        return internalInteract(rsInvetoryItem, action);
    }

    public boolean interactFirst(String name, String action) {
        RSInvetoryItem rsInvetoryItem = getItems(name).stream().findFirst().orElse(null);
        return internalInteract(rsInvetoryItem, action);
    }

    public boolean interactFirst(int itemId, String action) {
        RSInvetoryItem rsInvetoryItem = getItems(itemId).stream().findFirst().orElse(null);
        return internalInteract(rsInvetoryItem, action);
    }

    public boolean interactAll(RSInvetoryItem rsInvetoryItem, String action) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(rsInvetoryItem.getId());
        for (RSInvetoryItem item : rsInvetoryItems) {
            internalInteract(item, action);
            Alfred.sleep(75, 150);
        }
        return true;
    }

    public boolean interactAll(String name, String action) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(name);
        for (RSInvetoryItem item : rsInvetoryItems) {
            internalInteract(item, action);
            Alfred.sleep(75, 150);
        }
        return true;
    }

    public boolean interactAll(int itemId, String action) {
        List<RSInvetoryItem> rsInvetoryItems = getItems(itemId);
        for (RSInvetoryItem item : rsInvetoryItems) {
            internalInteract(item, action);
            Alfred.sleep(75, 150);
        }
        return true;
    }

}

