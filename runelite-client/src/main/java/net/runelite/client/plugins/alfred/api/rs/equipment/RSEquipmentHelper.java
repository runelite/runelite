package net.runelite.client.plugins.alfred.api.rs.equipment;

import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

public class RSEquipmentHelper {
    //    child 2 empty
//    child 1 equipped
    private final int HELMET_WIDGET_ID = 25362447;
    private final int CAPE_WIDGET_ID = 25362448;
    private final int NECKLACE_WIDGET_ID = 25362449;
    private final int ARROW_WIDGET_ID = 25362457;
    private final int WEAPON_WIDGET_ID = 25362450;
    private final int CHEST_WIDGET_ID = 25362451;
    private final int SHIELD_WIDGET_ID = 25362452;
    private final int LEGS_WIDGET_ID = 25362453;
    private final int GLOVES_WIDGET_ID = 25362454;
    private final int BOOTS_WIDGET_ID = 25362455;
    private final int RING_WIDGET_ID = 25362456;

    private boolean clickSlot(int slot) {
        return Alfred.api.widgets().leftClickWidget(slot);
    }

    private int getEquippedItemId(int slot) {
        if (Alfred.api.tabs().getCurrentTab() != WidgetInfo.FIXED_VIEWPORT_EQUIPMENT_TAB) {
            Alfred.api.tabs().clickEquipmentTab();
        }

        Widget childOne = Alfred.api.widgets().getChildWidget(slot, 1);
        Widget childTwo = Alfred.api.widgets().getChildWidget(slot, 2);

        if (!childTwo.isHidden()) {
            return -1;
        }

        return childOne.getItemId();
    }

    private boolean isEquipped(int slot) {
        return getEquippedItemId(slot) != -1;
    }

    public boolean isHelmetEquipped() {
        return isEquipped(HELMET_WIDGET_ID);
    }

    public boolean isCapeEquipped() {
        return isEquipped(CAPE_WIDGET_ID);
    }

    public boolean isNecklaceEquipped() {
        return isEquipped(NECKLACE_WIDGET_ID);
    }

    public boolean isArrowEquipped() {
        return isEquipped(ARROW_WIDGET_ID);
    }

    public boolean isWeaponEquipped() {
        return isEquipped(WEAPON_WIDGET_ID);
    }

    public boolean isChestEquipped() {
        return isEquipped(CHEST_WIDGET_ID);
    }

    public boolean isShieldEquipped() {
        return isEquipped(SHIELD_WIDGET_ID);
    }

    public boolean isLegsEquipped() {
        return isEquipped(LEGS_WIDGET_ID);
    }

    public boolean isGlovesEquipped() {
        return isEquipped(GLOVES_WIDGET_ID);
    }

    public boolean isBootsEquipped() {
        return isEquipped(BOOTS_WIDGET_ID);
    }

    public boolean isRingEquipped() {
        return isEquipped(RING_WIDGET_ID);
    }

    public int getHelmetId() {
        return getEquippedItemId(HELMET_WIDGET_ID);
    }

    public int getCapeId() {
        return getEquippedItemId(CAPE_WIDGET_ID);
    }

    public int getNecklaceId() {
        return getEquippedItemId(NECKLACE_WIDGET_ID);
    }

    public int getArrowId() {
        return getEquippedItemId(ARROW_WIDGET_ID);
    }

    public int getWeaponId() {
        return getEquippedItemId(WEAPON_WIDGET_ID);
    }

    public int getChestId() {
        return getEquippedItemId(CHEST_WIDGET_ID);
    }

    public int getShieldId() {
        return getEquippedItemId(SHIELD_WIDGET_ID);
    }

    public int getLegsId() {
        return getEquippedItemId(LEGS_WIDGET_ID);
    }

    public int getGlovesId() {
        return getEquippedItemId(GLOVES_WIDGET_ID);
    }

    public int getBootsId() {
        return getEquippedItemId(BOOTS_WIDGET_ID);
    }

    public int getRingId() {
        return getEquippedItemId(RING_WIDGET_ID);
    }

    public boolean clickHelmet() {
        return clickSlot(HELMET_WIDGET_ID);
    }

    public boolean clickCape() {
        return clickSlot(CAPE_WIDGET_ID);
    }

    public boolean clickNecklace() {
        return clickSlot(NECKLACE_WIDGET_ID);
    }

    public boolean clickArrow() {
        return clickSlot(ARROW_WIDGET_ID);
    }

    public boolean clickWeapon() {
        return clickSlot(WEAPON_WIDGET_ID);
    }

    public boolean clickChest() {
        return clickSlot(CHEST_WIDGET_ID);
    }

    public boolean clickShield() {
        return clickSlot(SHIELD_WIDGET_ID);
    }

    public boolean clickLegs() {
        return clickSlot(LEGS_WIDGET_ID);
    }

    public boolean clickGloves() {
        return clickSlot(GLOVES_WIDGET_ID);
    }

    public boolean clickBoots() {
        return clickSlot(BOOTS_WIDGET_ID);
    }

    public boolean clickRing() {
        return clickSlot(RING_WIDGET_ID);
    }

}
