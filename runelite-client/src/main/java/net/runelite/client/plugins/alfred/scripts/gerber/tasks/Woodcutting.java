package net.runelite.client.plugins.alfred.scripts.gerber.tasks;

import net.runelite.api.Skill;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInvetoryItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.enums.WorldDestinations;
import net.runelite.client.plugins.alfred.scripts.gerber.GerberConfig;

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
                for (RSInvetoryItem item : Alfred.api.inventory().getItems("logs")) {
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
        }

        bank.open();
        Alfred.sleepUntil(bank::isOpen, 100, 5000);
        bank.clickDepositInventory();
        Alfred.sleepUntil(() -> Alfred.api.inventory().isEmpty(), 100, 5000);
        bank.close();
        Alfred.sleepUntil(bank::isClosed, 100, 5000);
    }


}
