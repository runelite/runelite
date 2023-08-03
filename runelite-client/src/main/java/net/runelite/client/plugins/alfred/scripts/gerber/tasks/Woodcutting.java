package net.runelite.client.plugins.alfred.scripts.gerber.tasks;

import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInventoryItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.enums.WorldDestinations;
import net.runelite.client.plugins.alfred.scripts.gerber.GerberConfig;

import java.util.ArrayList;
import java.util.List;

public class Woodcutting {

    private final GerberConfig config;
    private final WorldArea VARROCK_EAST_TREE_WORLD_AREA = new WorldArea(3159, 3388, 13, 25, 0);
    private final WorldPoint VARROCK_EAST_TREE_WORLD_POINT = new WorldPoint(3164, 3402, 0);

    private enum ScriptState {
        WAITING, WALKING, CHOPPING, BANKING

    }

    private ScriptState scriptState;


    public Woodcutting(GerberConfig gerberConfig) {
        this.config = gerberConfig;
        scriptState = ScriptState.WAITING;
    }

    public void run() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        while (!Alfred.getPlayTimer().isTimerComplete()) {
            int minimumSkillRequirement = player.getSkillLevel(Skill.WOODCUTTING);

            if (minimumSkillRequirement < 15) {
                Alfred.setTaskSubStatus("Chopping Trees");
                chopTrees();
                scriptState = ScriptState.WAITING;

            } else {
                return;
            }

            Alfred.sleep(100);
        }
    }

    private List<Integer> getRecommendedAxes() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        int skillLevel = player.getSkillLevel(Skill.WOODCUTTING);
        List<Integer> itemIds = new ArrayList<>();

        if (skillLevel >= 1) {
            itemIds.add(ItemID.BRONZE_AXE);
            itemIds.add(ItemID.IRON_AXE);
        }

        if (skillLevel >= 6) {
            itemIds.add(ItemID.STEEL_AXE);
        }

        if (skillLevel >= 11) {
            itemIds.add(ItemID.BLACK_AXE);
        }

        if (skillLevel >= 21) {
            itemIds.add(ItemID.MITHRIL_AXE);
        }

        if (skillLevel >= 31) {
            itemIds.add(ItemID.ADAMANT_AXE);
        }

//        if (skillLevel >= 35 && player.isMembers()) {
//            itemIds.add(ItemID.BLESSED_AXE);
//        }

        if (skillLevel >= 41) {
            itemIds.add(ItemID.RUNE_AXE);
        }
        return itemIds;
    }


    private void chopTrees() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (player.isMoving() || player.isInteracting()) {
            return;
        }

        if (scriptState == ScriptState.WAITING) {
            if (!VARROCK_EAST_TREE_WORLD_AREA.contains(player.getWorldLocation())) {
                Alfred.api.walk().walkTo(VARROCK_EAST_TREE_WORLD_POINT);
            }

            scriptState = ScriptState.CHOPPING;
        }

        if (scriptState == ScriptState.CHOPPING) {
            Alfred.tasks.objects().chopTree("tree");
            scriptState = ScriptState.BANKING;
        }

        if (scriptState == ScriptState.BANKING) {
            if (config.keepLogs()) {
                if (Alfred.api.inventory().isFull()) {
                    bankInventory();
                    Alfred.sleep(200);
                }
            } else {
                for (RSInventoryItem item : Alfred.api.inventory().getItems("logs")) {
                    int count = Alfred.api.inventory().count();
                    item.drop();
                    Alfred.sleepUntil(() -> Alfred.api.inventory().count() == count - 1, 200, 1000 * 5);
                }
            }

            scriptState = ScriptState.WAITING;
        }
    }

    private void bankInventory() {
        Alfred.api.walk().walkTo(WorldDestinations.VARROCK_WEST_BANK.getWorldPoint());
        RSBank bank = Alfred.api.banks().getNearestBanks().stream().findFirst().orElse(null);

        if (bank == null) {
            System.out.println("HELP");
            return;
        }

        Alfred.api.banks().open(bank);
        Alfred.sleepUntil(() -> Alfred.api.banks().isOpen(), 100, 5000);
        Alfred.api.banks().depositInventory();
        Alfred.sleepUntil(() -> Alfred.api.inventory().isEmpty(), 100, 5000);
        Alfred.api.banks().close();
        Alfred.sleepUntil(() -> Alfred.api.banks().isClosed(), 100, 5000);
    }

}
