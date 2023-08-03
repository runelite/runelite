package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.client.plugins.alfred.api.rs.account.RSAccountHelper;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBankHelper;
import net.runelite.client.plugins.alfred.api.rs.camera.RSCameraHelper;
import net.runelite.client.plugins.alfred.api.rs.combat.RSCombatHelper;
import net.runelite.client.plugins.alfred.api.rs.equipment.RSEquipmentHelper;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInventoryHelper;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItemHelper;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenuHelper;
import net.runelite.client.plugins.alfred.api.rs.minimap.RSMiniMapHelper;
import net.runelite.client.plugins.alfred.api.rs.npc.RSNpcHelper;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObjectHelper;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayerHelper;
import net.runelite.client.plugins.alfred.api.rs.screen.RSScreenHelper;
import net.runelite.client.plugins.alfred.api.rs.tab.RSTabHelper;
import net.runelite.client.plugins.alfred.api.rs.walk.RSWalkHelper;
import net.runelite.client.plugins.alfred.api.rs.widget.RSWidgetHelper;
import net.runelite.client.plugins.alfred.api.rs.world.RSWorldHelper;

public class BaseAPI {

    private final RSBankHelper rsBankHelper;
    private final RSPlayerHelper rsPlayerHelper;
    private final RSObjectHelper rsObjectHelper;
    private final RSTabHelper rsTabHelper;
    private final RSWorldHelper rsWorldHelper;
    private final RSInventoryHelper rsInventoryHelper;
    private final RSMenuHelper rsMenuHelper;
    private final RSWidgetHelper rsWidgetHelper;
    private final RSCameraHelper rsCameraHelper;
    private final RSNpcHelper rsNpcHelper;
    private final RSScreenHelper rsScreenHelper;
    private final RSMiniMapHelper rsMiniMapHelper;
    private final RSCombatHelper rsCombatHelper;
    private final RSGroundItemHelper rsGroundItemHelper;
    private final RSWalkHelper rsWalkHelper;
    private final RSAccountHelper rsAccountHelper;
    private final RSEquipmentHelper rsEquipmentHelper;

    public BaseAPI() {
        rsBankHelper = new RSBankHelper();
        rsPlayerHelper = new RSPlayerHelper();
        rsObjectHelper = new RSObjectHelper();
        rsTabHelper = new RSTabHelper();
        rsWorldHelper = new RSWorldHelper();
        rsInventoryHelper = new RSInventoryHelper();
        rsMenuHelper = new RSMenuHelper();
        rsWidgetHelper = new RSWidgetHelper();
        rsCameraHelper = new RSCameraHelper();
        rsNpcHelper = new RSNpcHelper();
        rsScreenHelper = new RSScreenHelper();
        rsMiniMapHelper = new RSMiniMapHelper();
        rsCombatHelper = new RSCombatHelper();
        rsGroundItemHelper = new RSGroundItemHelper();
        rsWalkHelper = new RSWalkHelper();
        rsAccountHelper = new RSAccountHelper();
        rsEquipmentHelper = new RSEquipmentHelper();
    }

    public RSBankHelper banks() {
        return rsBankHelper;
    }

    public RSPlayerHelper players() {
        return rsPlayerHelper;
    }

    public RSObjectHelper objects() {
        return rsObjectHelper;
    }

    public RSTabHelper tabs() {
        return rsTabHelper;
    }

    public RSWorldHelper world() {
        return rsWorldHelper;
    }

    public RSInventoryHelper inventory() {
        return rsInventoryHelper;
    }

    public RSMenuHelper menu() {
        return rsMenuHelper;
    }

    public RSWidgetHelper widgets() {
        return rsWidgetHelper;
    }

    public RSCameraHelper camera() {
        return rsCameraHelper;
    }

    public RSNpcHelper npcs() {
        return rsNpcHelper;
    }

    public RSScreenHelper screen() {
        return rsScreenHelper;
    }

    public RSMiniMapHelper miniMap() {
        return rsMiniMapHelper;
    }

    public RSCombatHelper combat() {
        return rsCombatHelper;
    }

    public RSGroundItemHelper items() {
        return rsGroundItemHelper;
    }

    public RSWalkHelper walk() {
        return rsWalkHelper;
    }

    public RSAccountHelper account() {
        return rsAccountHelper;
    }

    public RSEquipmentHelper equipment() {
        return rsEquipmentHelper;
    }
}
