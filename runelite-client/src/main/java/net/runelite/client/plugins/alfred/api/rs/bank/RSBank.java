package net.runelite.client.plugins.alfred.api.rs.bank;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;
import net.runelite.client.plugins.alfred.rpc.annotate.RPCClass;
import net.runelite.client.plugins.alfred.rpc.annotate.RPCMethod;

import java.awt.*;


@Slf4j(topic = "RSBank")
@RPCClass(name = "Bank", description = "Bank Object")
public class RSBank {

    private final GameObject bankObject;

    public RSBank(GameObject gameObject) {
        this.bankObject = gameObject;
    }

    public WorldPoint getWorldLocation() {
        return bankObject.getWorldLocation();
    }

    public Shape getClickbox() {
        return bankObject.getClickbox();
    }

    public boolean isOpen() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget widget = Alfred.getClient().getWidget(786433);
            if (widget == null) {
                return false;
            }

            return !widget.isHidden() && !widget.isSelfHidden();
        });
    }

    @RPCMethod(name = "Open bank", description = "Opens the bank")
    public boolean open() {
        Alfred.setStatus("Opening bank");

        if (getWorldLocation() == null) {
            log.warn("Could not find bank world location");
            return false;
        }

        Alfred.api.camera().lookAt(getWorldLocation());

        if (getClickbox() == null) {
            log.warn("Could not find bank clickbox");
            return false;
        }

        if (getClickbox().getBounds() == null) {
            log.warn("Could not find bank clickbox bounds");
            return false;
        }

        if (isOpen()) {
            return false;
        }

        Alfred.getMouse().rightClick(getClickbox().getBounds());

        boolean foundAction = Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction("bank"), 200, 2000);
        if (!foundAction) {
            log.warn("Could not find bank action");
            return false;
        }

        Alfred.api.menu().getMenu().clickAction("bank");

        boolean openedBank = Alfred.sleepUntil(this::isOpen, 200, 1000 * 10);
        if (!openedBank) {
            log.warn("Could not open bank");
            return false;
        }

        Alfred.setStatus("Opened bank");
        return true;
    }

    @RPCMethod(name = "Close bank", description = "Closes the bank")
    public boolean close() {
        Alfred.setStatus("Closing bank");

        Widget closeWidget = Alfred.api.widgets().getChildWidget(786434, 11);
        if (closeWidget == null) {
            log.warn("Could not find bank close button widget");
            return false;
        }

        Alfred.getMouse().leftClick(closeWidget.getBounds());


        boolean closedBank = Alfred.sleepUntil(() -> !isOpen(), 200, 1000 * 10);
        if (!closedBank) {
            log.warn("Could not close bank");
            return false;
        }

        Alfred.setStatus("Closed bank");
        return true;
    }

    public boolean clickViewAllItems() {
        Widget bankContainerWidget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_TAB_CONTAINER);
        if (bankContainerWidget == null) {
            log.warn("Could not find bank container widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankContainerWidget.getBounds());
        return true;
    }

    public boolean clickSearch() {
        Widget bankSearchWidget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
        if (bankSearchWidget == null) {
            log.warn("Could not find bank search widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankSearchWidget.getBounds());
        return true;
    }

    public boolean clickDepositInventory() {
        Widget bankDepositInventoryWidget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
        if (bankDepositInventoryWidget == null) {
            log.warn("Could not find bank deposit inventory widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankDepositInventoryWidget.getBounds());
        return true;
    }

    public void depositAll(RSGroundItem rsGroundItem) {
        Alfred.api.inventory().getItems(rsGroundItem.getId()).forEach(item -> {
            item.clickAction("deposit-all");
        });
    }

    public void depositAll(String itemName) {
        Alfred.api.inventory().getItems(itemName).forEach(item -> {
            System.out.println(item.getClass().toString());
            item.clickAction("deposit-all");
        });
    }

    public boolean clickDepositEquipment() {
        Widget bankDepositEquipmentWidget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
        if (bankDepositEquipmentWidget == null) {
            log.warn("Could not find bank deposit equipment widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankDepositEquipmentWidget.getBounds());
        return true;
    }

    public boolean clickWithdrawAsItem() {
        Widget bankWithdrawAsItemWidget = Alfred.api.widgets().getWidget(786454);
        if (bankWithdrawAsItemWidget == null) {
            log.warn("Could not find bank withdraw as item widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankWithdrawAsItemWidget.getBounds());
        return true;
    }

    public boolean clickWithdrawAsNote() {
        Widget bankWithdrawAsNoteWidget = Alfred.api.widgets().getWidget(786456);
        if (bankWithdrawAsNoteWidget == null) {
            log.warn("Could not find bank withdraw as note widget");
            return false;
        }

        Alfred.getMouse().leftClick(bankWithdrawAsNoteWidget.getBounds());
        return true;
    }
}
