package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.GameObject;
import net.runelite.api.MenuEntry;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.Utility;
import net.runelite.client.plugins.alfred.api.rs.WidgetAPI;

import java.awt.*;

public class RSBank {

    private final GameObject bankObject;

    public RSBank(GameObject gameObject) {
        this.bankObject = gameObject;
    }

//    private static boolean clickWidget(int widgetID) {
//        Rectangle bounds = Utility.getTabBounds(widgetID);
//        if (bounds == null) {
//            return false;
//        }
//
//        Alfred.getMouse().leftClick(bounds);
//        return true;
//    }
//
//    private static boolean clickWidget(WidgetInfo widgetInfo) {
//        Rectangle bounds = Utility.getTabBounds(widgetInfo);
//        if (bounds == null) {
//            return false;
//        }
//
//        Alfred.getMouse().leftClick(bounds);
//        return true;
//    }

    public boolean isOpen() {
        Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
        return widget != null && !widget.isHidden();
    }

    public WorldPoint getWorldLocation() {
        if (bankObject == null) {
            return null;
        }
        return bankObject.getWorldLocation();
    }

    public void open() {
        if (bankObject.getClickbox() == null) {
            return;
        }

        Rectangle bankBounds = bankObject.getClickbox().getBounds();
        if (bankBounds == null) {
            return;
        }
        Alfred.getMouse().rightClick(bankBounds);
        Alfred.sleep(100, 200);

//        Widget widget = WidgetAPI.findWidget("Bank");
//
//        if (widget == null) {
//            System.out.println("Cannot find widget");
//            return;
//        }
//
//        if (widget.isHidden()) {
//            System.out.println("widget is hidden");
//            return;
//        }
//
//        WidgetAPI.clickWidget(widget.getId());

        for (MenuEntry menuEntry : Alfred.getClient().getMenuEntries()) {
            if (!menuEntry.getOption().equals("Bank")) {
                continue;
            }
            System.out.println(String.format("Action: %s, Other %s", menuEntry.getOption(), menuEntry.getTarget()));

            if (menuEntry.getParent() != null) {
                System.out.println(String.format("Parent: %s", menuEntry.getParent().getOption()));
            }

            Alfred.sleep(300, 800);
            if (menuEntry.getWidget() == null) {
                System.out.println("No menu entry widget");
                continue;
            }

            WidgetAPI.clickWidget(menuEntry.getWidget().getId());
            System.out.println("Found widget");
            return;
        }
    }

//    public boolean clickViewAllItems() {
//        return clickWidget(WidgetInfo.BANK_TAB_CONTAINER);
//    }
//
//    public boolean clickSearch() {
//        return clickWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
//    }
//
//    public boolean clickDepositInventory() {
//        return clickWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
//    }
//
//    public boolean clickDepositEquipment() {
//        return clickWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
//    }
//
//    public boolean clickWithdrawAsItem() {
//        return clickWidget(786454);
//    }
//
//    public boolean clickWithdrawAsNote() {
//        return clickWidget(786456);
//    }
//
//    public boolean close() {
//        return clickWidget(786434);
//    }
//
//    public static void test() {
//        int delay = 1000;
//
//        clickViewAllItems();
//        Alfred.sleep(delay);
//
//        clickSearch();
//        Alfred.sleep(delay);
//
//        clickDepositInventory();
//        Alfred.sleep(delay);
//
//        clickDepositEquipment();
//        Alfred.sleep(delay);
//
//        clickWithdrawAsItem();
//        Alfred.sleep(delay);
//
//        clickWithdrawAsNote();
//        Alfred.sleep(delay);
//    }
}
