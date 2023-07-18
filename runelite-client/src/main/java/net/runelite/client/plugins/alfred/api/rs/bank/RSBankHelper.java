package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.objects.RSObject;
import net.runelite.client.plugins.alfred.rpc.annotate.RPCClass;
import net.runelite.client.plugins.alfred.rpc.annotate.RPCMethod;
import net.runelite.client.plugins.alfred.rpc.annotate.RPCParameter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RPCClass(name = "Bank Helper", description = "Bank Helper")
public class RSBankHelper {

    public RSBankHelper() {
    }

    @RPCMethod(name = "Test function", description = "test function")
    public boolean testFunction(@RPCParameter(name = "thing") int thing) {
        return true;
    }

    @RPCMethod(name = "Get nearest banks", description = "Get nearest banks")
    public List<RSBank> getNearestBanks() {
        Alfred.setStatus("Finding nearest banks");

        List<RSBank> bankAPIList = new ArrayList<>();
        List<Integer> bankBoothObjectIds = getBankBoothObjectIds();

        for (RSObject rsObject : Alfred.api.objects().getObjectsFromTiles()) {
            if (bankBoothObjectIds.contains(rsObject.getId())) {
//                if (gameObject.getClickbox() == null) {
//                    continue;
//                }

//                if (gameObject.getWorldLocation() == null) {
//                    continue;
//                }

                bankAPIList.add(new RSBank((GameObject) rsObject.getRsObject()));
            }
        }

        WorldPoint playerLocation = Alfred.getClient().getLocalPlayer().getWorldLocation();

        bankAPIList.sort((o1, o2) -> {
            int distance1 = o1.getWorldLocation().distanceTo(playerLocation);
            int distance2 = o2.getWorldLocation().distanceTo(playerLocation);
//            double distance1 = Calculations.distanceBetweenPoints(o1.getWorldLocation(), playerLocation);
//            double distance2 = Calculations.distanceBetweenPoints(o2.getWorldLocation(), playerLocation);
//            return Double.compare(distance1, distance2);
            return Integer.compare(distance1, distance2);
        });

        return bankAPIList;
    }


    @RPCMethod(name = "Get bank booth object ids", description = "Get bank booth object ids")
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

