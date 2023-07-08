package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.ObjectID;

import java.util.ArrayList;
import java.util.List;

public class RSBankHelper {

    public RSBankHelper() {
    }

    public List<RSBank> getNearest() {
        List<RSBank> bankAPIList = new ArrayList<>();
        GameObjectAPI.getGameObjects().forEach(gameObject -> {
            if (gameObject.getId() == ObjectID.BANK_BOOTH_10583) {
//            if (gameObject.getId() == 10583) {
                bankAPIList.add(new RSBank(gameObject));
            }
        });
        return bankAPIList;
    }}
