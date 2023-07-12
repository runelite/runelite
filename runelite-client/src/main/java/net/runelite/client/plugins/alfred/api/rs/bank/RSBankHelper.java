package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.ObjectID;
import net.runelite.client.plugins.alfred.Alfred;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RSBankHelper {

    public RSBankHelper() {
    }

    public List<RSBank> getNearestBanks() {
        List<RSBank> bankAPIList = new ArrayList<>();
        List<Integer> bankBoothObjectIds = getBankBoothObjectIds();

        Alfred.api.objects().getGameObjects().forEach(gameObject -> {
            if (bankBoothObjectIds.contains(gameObject.getId())) {
                bankAPIList.add(new RSBank(gameObject));
            }
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
}

