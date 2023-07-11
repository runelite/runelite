package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.client.plugins.alfred.api.rs.bank.RSBankHelper;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInventoryHelper;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObjectHelper;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayerHelper;
import net.runelite.client.plugins.alfred.api.rs.tab.RSTabHelper;
import net.runelite.client.plugins.alfred.api.rs.world.RSWorldHelper;

public class BaseAPI {

    private final RSBankHelper rsBankHelper;
    private final RSPlayerHelper rsPlayerHelper;
    private final RSObjectHelper rsObjectHelper;
    private final RSTabHelper rsTabHelper;
    private final RSWorldHelper rsWorldHelper;
    private final RSInventoryHelper rsInventoryHelper;

    public BaseAPI() {
        rsBankHelper = new RSBankHelper();
        rsPlayerHelper = new RSPlayerHelper();
        rsObjectHelper = new RSObjectHelper();
        rsTabHelper = new RSTabHelper();
        rsWorldHelper = new RSWorldHelper();
        rsInventoryHelper = new RSInventoryHelper();
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
}
