package net.runelite.client.plugins.alfred.api.rs.inventory;

import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSItem;

import java.util.ArrayList;
import java.util.List;

public class RSInventoryHelper {

    private final int INVENTORY_CONTAINER_ID = 9764864;

    public Widget getInventoryWidget() {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(INVENTORY_CONTAINER_ID));
    }

    private boolean clickSlot(int slot, boolean leftClick) {
        int correctSlot = slot - 1;

        Widget foundWidget = Alfred.getClientThread().invokeOnClientThread(() -> {
            open();
            Widget inventoryWidget = getInventoryWidget();
            return inventoryWidget.getChild(correctSlot);
        });

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

    public int count() {
        open();
        Widget inventoryWidget = getInventoryWidget();

        return Alfred.getClientThread().invokeOnClientThread(() -> {
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

    public boolean leftClickSlot(int slot) {
        return clickSlot(slot, true);
    }

    public boolean rightClickSlot(int slot) {
        return clickSlot(slot, false);
    }

    public boolean drop(String name) {
        if (!isFull()) {
            return true;
        }

        Widget inventoryWidget = getInventoryWidget();
        Widget foundWidget = Alfred.getClientThread().invokeOnClientThread(() -> {
            for (Widget item : inventoryWidget.getDynamicChildren()) {
                RSItem rsItem = new RSItem(item);
//              String cleanedName = item.getName().split(">")[1].split("</")[0].toLowerCase();

                if (rsItem.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }

            return null;
        });

        if (foundWidget == null) {
            return false;
        }

        Alfred.getMouse().move(foundWidget.getBounds());
        Alfred.sleep(100, 200);
        return true;
    }

//    public static boolean drop(String itemName) {
//        if (!Rs2Settings.enableDropShiftSetting()) return false;
//        if (Inventory.isEmpty()) return true;
//        if (!VirtualKeyboard.isKeyPressed(KeyEvent.VK_SHIFT) || !Rs2Menu.hasAction("drop"))
//            VirtualKeyboard.holdShift();
//
//        boolean result = useItemAction(itemName, "drop");
//
//        VirtualKeyboard.releaseShift();
//
//        return result;
//    }

    public RSItem getItemFromSlot(int slot) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            int correctSlot = slot - 1;
            Widget inventoryWidget = getInventoryWidget();
            Widget item = inventoryWidget.getChild(correctSlot);

            if (item == null) {
                return null;
            }

            return new RSItem(item);
        });
    }

    public List<RSItem> getItems(int itemId) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget inventoryWidget = getInventoryWidget();
            List<RSItem> rsItemList = new ArrayList<>();

            for (Widget item : inventoryWidget.getDynamicChildren()) {
                RSItem rsItem = new RSItem(item);

                if (rsItem.getId() == itemId) {
                    rsItemList.add(rsItem);
                }
            }

            return rsItemList;
        });
    }

    public List<RSItem> getItems(String name) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget inventoryWidget = getInventoryWidget();
            List<RSItem> rsItemList = new ArrayList<>();

            for (Widget item : inventoryWidget.getDynamicChildren()) {
                RSItem rsItem = new RSItem(item);

                if (rsItem.getName().equalsIgnoreCase(name)) {
                    rsItemList.add(rsItem);
                }
            }

            return rsItemList;
        });
    }

    public boolean clickAction(String action) {
        MenuEntry menuEntryAction = Alfred.getClientThread().invokeOnClientThread(() -> {
            for (MenuEntry menuEntry : Alfred.getClient().getMenuEntries()) {
                if (menuEntry.getOption().equalsIgnoreCase(action)) {
                    return menuEntry;
                }
            }
            return null;
        });

        if (menuEntryAction == null) {
            System.out.println("No entry");
            return false;
        }

        if (menuEntryAction.getWidget() == null) {
            System.out.println("No widget");
            return false;
        }

        Alfred.getMouse().leftClick(menuEntryAction.getWidget().getBounds());

        return true;
    }
}

