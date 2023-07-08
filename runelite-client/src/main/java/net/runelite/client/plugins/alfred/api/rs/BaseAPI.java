package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.client.plugins.alfred.api.rs.bank.RSBankHelper;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObjectHelper;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayerHelper;
import net.runelite.client.plugins.alfred.api.rs.tab.RSTabHelper;

public class BaseAPI {

    private final RSBankHelper rsBankHelper;
    private final RSPlayerHelper rsPlayerHelper;

    private final RSObjectHelper rsObjectHelper;
    private final RSTabHelper rsTabHelper;

    public BaseAPI() {
        rsBankHelper = new RSBankHelper();
        rsPlayerHelper = new RSPlayerHelper();
        rsObjectHelper = new RSObjectHelper();
        rsTabHelper = new RSTabHelper();
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

}
