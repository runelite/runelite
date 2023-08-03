package net.runelite.client.plugins.alfred.api.rs.bank;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInventoryItem;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "RSBankHelper")
public class RSBankHelper {
    private final int WIDGET_REARRANGE_SWAP = 786450;
    private final int WIDGET_REARRANGE_INSERT = 786452;
    private final int VARBIT_WITHDRAW_AS = 3958;

    public List<RSBank> getNearestBanks() {
        List<RSBank> bankAPIList = new ArrayList<>();
        List<Integer> bankBoothObjectIds = getBankBoothObjectIds();

        for (RSObject rsObject : Alfred.api.objects().getObjectsFromTiles()) {
            if (bankBoothObjectIds.contains(rsObject.getId())) {
                bankAPIList.add(new RSBank((GameObject) rsObject.getRsObject()));
            }
        }

        WorldPoint playerLocation = Alfred.getClient().getLocalPlayer().getWorldLocation();
        bankAPIList.sort((o1, o2) -> {
            int distance1 = o1.getWorldLocation().distanceTo(playerLocation);
            int distance2 = o2.getWorldLocation().distanceTo(playerLocation);
            return Integer.compare(distance1, distance2);
        });

        return bankAPIList;
    }


    private List<Integer> getBankBoothObjectIds() {
        List<Integer> bankBoothObjectIds = new ArrayList<>();
        Field[] fields = ObjectID.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType() == int.class) {
                try {
                    if (field.getName().contains("BANK_BOOTH")) {
                        bankBoothObjectIds.add(field.getInt(null));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return bankBoothObjectIds;
    }

    public boolean open(RSBank bank) {
        Alfred.setStatus("Opening bank");

        if (bank.getWorldLocation() == null) {
            log.warn("Could not find bank world location");
            return false;
        }

        Alfred.api.camera().lookAt(bank.getWorldLocation());

        if (bank.getClickbox() == null) {
            log.warn("Could not find bank clickbox");
            return false;
        }

        if (bank.getClickbox().getBounds() == null) {
            log.warn("Could not find bank clickbox bounds");
            return false;
        }

        if (isOpen()) {
            return false;
        }

        Alfred.getMouse().rightClick(bank.getClickbox().getBounds());

        if (!Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction("bank"), 200, 2000)) {
            log.warn("Could not find bank action");
            return false;
        }

        Alfred.api.menu().getMenu().clickAction("bank");
        if (!Alfred.sleepUntil(() -> Alfred.api.banks().isOpen(), 200, 1000 * 10)) {
            log.warn("Could not open bank");
            return false;
        }

        Alfred.setStatus("Opened bank");
        return true;
    }

    public boolean isOpen() {
        Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
        if (widget == null) {
            return false;
        }

        return !widget.isHidden() && !widget.isSelfHidden();
    }

    public boolean isClosed() {
        Widget widget = Alfred.getClient().getWidget(WidgetInfo.BANK_CONTAINER);
        return widget == null;
    }

    public boolean close() {
        Alfred.setStatus("Closing bank");

        Widget widget = Alfred.api.widgets().getChildWidget(786434, 11);
        if (widget == null) {
            log.warn("Could not find bank close button widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());

        if (!Alfred.sleepUntil(() -> !isOpen(), 200, 1000 * 10)) {
            log.warn("Could not close bank");
            return false;
        }

        Alfred.setStatus("Closed bank");
        return true;
    }

    public boolean viewAllItems() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_TAB_CONTAINER);
        if (widget == null) {
            log.warn("Could not find bank container widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean isRearrangeSwapSelected() {
        return Alfred.getClient().getVarbitValue(Varbits.BANK_REARRANGE_MODE) == 0;
    }

    public boolean isRearrangeInsertSelected() {
        return Alfred.getClient().getVarbitValue(Varbits.BANK_REARRANGE_MODE) == 0;
    }

    public boolean rearrangeSwap() {
        Widget widget = Alfred.api.widgets().getWidget(WIDGET_REARRANGE_SWAP);
        if (widget == null) {
            log.warn("Could not find bank withdraw as item widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean rearrangeInsert() {
        Widget widget = Alfred.api.widgets().getWidget(WIDGET_REARRANGE_INSERT);
        if (widget == null) {
            log.warn("Could not find bank withdraw as note widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean isWithdrawAsItemSelected() {
        return Alfred.getClient().getVarbitValue(VARBIT_WITHDRAW_AS) == 0;
    }

    public boolean isWithdrawAsNoteSelected() {
        return Alfred.getClient().getVarbitValue(VARBIT_WITHDRAW_AS) == 1;
    }

    public boolean withdrawAsItem() {
        Widget widget = Alfred.api.widgets().getWidget(786454);
        if (widget == null) {
            log.warn("Could not find bank withdraw as item widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean withdrawAsNote() {
        Widget widget = Alfred.api.widgets().getWidget(786456);
        if (widget == null) {
            log.warn("Could not find bank withdraw as note widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean search() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
        if (widget == null) {
            log.warn("Could not find bank search widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public boolean search(String searchValue) {
        if (!search()) {
            return false;
        }

        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.CHATBOX_TITLE);
        boolean searchBoxShown = Alfred.sleepUntil(() -> {
            if (widget.isHidden() || widget.isSelfHidden()) {
                return false;
            }
            return widget.getText().toLowerCase().contains("show items whose names contain the following text");
        }, 100, 3000);

        if (!searchBoxShown) {
            return false;
        }

        Alfred.getKeyboard().sendKeys(searchValue);
        Alfred.sleep(75, 125);
        Alfred.getKeyboard().pressEnter();
        return true;
    }

    public boolean depositInventory() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
        if (widget == null) {
            log.warn("Could not find bank deposit inventory widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return Alfred.sleepUntil(() -> Alfred.api.inventory().isEmpty(), 100, 2000);
    }

    public boolean depositEquipment() {
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT);
        if (widget == null) {
            log.warn("Could not find bank deposit equipment widget");
            return false;
        }

        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public List<RSInventoryItem> getItems() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget itemContainer = Alfred.api.widgets().getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
            return Arrays.stream(itemContainer.getDynamicChildren()).map(RSInventoryItem::new).collect(Collectors.toList());
        });
    }

    public RSInventoryItem findItem(String name) {
        return getItems().stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public boolean internalDepositAll(RSInventoryItem rsInventoryItem) {
        return rsInventoryItem.interact("deposit-all");
    }

    public boolean depositAll(RSInventoryItem rsInventoryItem) {
        if (rsInventoryItem == null) {
            return false;
        }
        return internalDepositAll(rsInventoryItem);
    }

    public boolean depositAll(String itemName) {
        RSInventoryItem item = Alfred.api.inventory().getItems(itemName).stream().findFirst().orElse(null);
        if (item == null) {
            return false;
        }
        return internalDepositAll(item);
    }

    private boolean internalWithdrawItem(String name, String action) {
        RSInventoryItem foundItem = findItem(name);
        if (foundItem == null) {
            search(name);

            foundItem = findItem(name);
            if (foundItem == null) {
                log.warn("Could not find item in bank");
                return false;
            }
        }
        return foundItem.interact(action);
    }

    public boolean withdrawItem(String name) {
        return internalWithdrawItem(name, "withdraw-1");
    }

    public boolean withdrawX(String name, int amount) {
        internalWithdrawItem(name, "withdraw-x");
        Widget widget = Alfred.api.widgets().getWidget(WidgetInfo.CHATBOX_TITLE);
        boolean searchBoxShown = Alfred.sleepUntil(() -> {
            if (widget.isHidden() || widget.isSelfHidden()) {
                return false;
            }
            return widget.getText().toLowerCase().contains("enter amount");
        }, 100, 3000);

        if (!searchBoxShown) {
            return false;
        }

        Alfred.getKeyboard().sendKeys(Integer.toString(amount));
        Alfred.sleep(75, 125);
        Alfred.getKeyboard().pressEnter();
        return true;
    }

    public boolean withdrawAll(String name) {
        return internalWithdrawItem(name, "withdraw-all");
    }

//    public static boolean scrollTo(Widget widget) {
//        Widget scrollBar = Alfred.api.widgets().getChildWidget(WidgetInfo.BANK_SCROLLBAR, 1);
//        Widget itemContainer = Alfred.api.widgets().getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
//        Widget itemWidget = Alfred.api.widgets().getChildWidget(WidgetInfo.BANK_ITEM_CONTAINER, 62);
//
//
//        log.info(itemWidget.getName());
//        log.info(Integer.toString(itemContainer.getScrollY()));
//        log.info(Integer.toString(itemWidget.getRelativeY() - itemWidget.getBounds().height));
//
//        Alfred.getMouse().move(point);
//
//        do {
//            calc = widget.getRelativeY() - itemContainer.getScrollY();
//
//            if (calc >= 0 && calc < 640) break;
//
//            point = new Point((int) itemContainer.getBounds().getCenterX(), (int) itemContainer.getBounds().getCenterY());
//
//            if (calc > 0) {
//                Alfred.getMouse().scrollDown(point);
//            } else if (calc < 0) {
//                Alfred.getMouse().scrollUp(point);
//            }
//
//            sleep(100, 300);
//            mainWindow = Rs2Widget.getWidget(786445);
//
//        } while (calc <= 0 || calc > 640);
//
//        return true;
//    }

    private boolean internalContainsItem(int itemId) {
        Widget itemContainer = Alfred.api.widgets().getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
        return Arrays.stream(itemContainer.getDynamicChildren()).anyMatch(item -> new RSInventoryItem(item).getId() == itemId);
    }

    private boolean internalContainsItem(String name) {
        Widget itemContainer = Alfred.api.widgets().getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
        return Arrays.stream(itemContainer.getDynamicChildren()).anyMatch(item -> new RSInventoryItem(item).getName().equalsIgnoreCase(name));
    }

    public boolean containsItem(int itemId) {
        return internalContainsItem(itemId);
    }

    public boolean containsItem(RSInventoryItem item) {
        return internalContainsItem(item.getId());
    }

    public boolean containsItem(String name) {
        return internalContainsItem(name);
    }
}

