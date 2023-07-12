package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSItem;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;

import java.util.ArrayList;
import java.util.List;

public class RSInventoryHelper {

    private final int INVENTORY_CONTAINER_ID = 9764864;

    public Widget getInventoryWidget() {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(INVENTORY_CONTAINER_ID));
    }

    public boolean isOpen() {
        Widget widget = getInventoryWidget();
        return !widget.isHidden() || !widget.isSelfHidden();
    }

    public void open() {
        if (!isOpen()) {
            Alfred.api.tabs().clickInventoryTab();
            Alfred.sleep(300, 600);
        }
    }

    public int count() {
        open();
        Widget inventoryWidget = getInventoryWidget();

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
        Widget inventoryWidget = getInventoryWidget();
        Widget foundWidget = inventoryWidget.getChild(correctSlot);

        if (foundWidget == null) {
            return false;
        }

        if (leftClick) {
            Alfred.getMouse().leftClick(foundWidget.getBounds());
        } else {
            Alfred.getMouse().rightClick(foundWidget.getBounds());
        }

        return true;
    }


    public boolean leftClickSlot(int slot) {
        return clickSlot(slot, true);
    }

    public boolean rightClickSlot(int slot) {
        return clickSlot(slot, false);
    }

    public RSItem getItemFromSlot(int slot) {
        int correctSlot = slot - 1;
        Widget inventoryWidget = getInventoryWidget();
        Widget item = inventoryWidget.getChild(correctSlot);

        if (item == null) {
            return null;
        }

        return new RSItem(item);
    }

    public List<RSItem> getItems(int itemId) {
        Widget inventoryWidget = getInventoryWidget();
        List<RSItem> rsItemList = new ArrayList<>();

        for (Widget item : inventoryWidget.getDynamicChildren()) {
            RSItem rsItem = new RSItem(item);

            if (rsItem.getId() == itemId) {
                rsItemList.add(rsItem);
            }
        }

        return rsItemList;
    }

    public List<RSItem> getItems(String name) {
        Widget inventoryWidget = getInventoryWidget();
        List<RSItem> rsItemList = new ArrayList<>();

        for (Widget item : inventoryWidget.getDynamicChildren()) {
            RSItem rsItem = new RSItem(item);

            if (rsItem.getName().equalsIgnoreCase(name)) {
                rsItemList.add(rsItem);
            }
        }

        return rsItemList;
    }

    public boolean clickAction(String action) {
        RSMenu rsMenu = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.api.menu().getMenu());
        if (!rsMenu.hasAction(action)) {
            return false;
        }
        return rsMenu.clickAction(action);
    }

    private boolean internalDrop(RSItem rsItem) {
        if (rsItem == null) {
            return false;
        }

        Alfred.getMouse().rightClick(rsItem.getBounds());
        Alfred.sleep(200, 600);
        return clickAction("drop");
    }

    private boolean internalDropAll(List<RSItem> rsItems) {
        for (RSItem rsItem : rsItems) {
            internalDrop(rsItem);
            Alfred.sleep(75, 200);
        }
        return true;
    }

    private boolean internalDropSlot(int slot) {
        if (slot < 1 || slot > 28) {
            return false;
        }

        RSItem rsItem = getItemFromSlot(slot);
        internalDrop(rsItem);
        Alfred.sleep(75, 200);
        return true;
    }

    public boolean drop(RSItem rsItem) {
        return internalDrop(rsItem);
    }

    public boolean dropFirst(String name) {
        if (isEmpty()) {
            return true;
        }

        RSItem rsItem = getItems(name).stream().findFirst().orElse(null);
        return internalDrop(rsItem);
    }

    public boolean dropFirst(int itemId) {
        if (isEmpty()) {
            return true;
        }

        RSItem rsItem = getItems(itemId).stream().findFirst().orElse(null);
        return internalDrop(rsItem);
    }

    public boolean dropFirst(RSItem rsItem) {
        if (isEmpty()) {
            return true;
        }

        return internalDrop(rsItem);
    }

    public boolean dropAll(String name) {
        if (isEmpty()) {
            return true;
        }

        List<RSItem> rsItems = getItems(name);
        return internalDropAll(rsItems);
    }

    public boolean dropAll(int itemId) {
        if (isEmpty()) {
            return true;
        }

        List<RSItem> rsItems = getItems(itemId);
        return internalDropAll(rsItems);
    }

    public boolean dropAll(RSItem rsItem) {
        if (isEmpty()) {
            return true;
        }

        List<RSItem> rsItems = getItems(rsItem.getId());
        return internalDropAll(rsItems);
    }

    public boolean dropSlot(int slot) {
        if (isEmpty()) {
            return true;
        }

        return internalDropSlot(slot);
    }

    public boolean dropSlots(int... slots) {
        if (isEmpty()) {
            return true;
        }

        for (int slot : slots) {
            internalDropSlot(slot);
        }
        return true;
    }

    public boolean dropAllBetween(int start, int end) {
        if (isEmpty()) {
            return true;
        }

        for (int i = start; i <= end; i++) {
            internalDropSlot(i);
        }
        return true;
    }
}

