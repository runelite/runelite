package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RSBankHelper {

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
}

