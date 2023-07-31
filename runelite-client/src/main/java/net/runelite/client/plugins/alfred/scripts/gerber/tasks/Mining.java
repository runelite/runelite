package net.runelite.client.plugins.alfred.scripts.gerber.tasks;

import net.runelite.api.Skill;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInvetoryItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.enums.WorldDestinations;
import net.runelite.client.plugins.alfred.scripts.gerber.GerberConfig;

import java.util.Arrays;
import java.util.Collections;

public class Mining {

    private final GerberConfig config;
    private final WorldArea VARROCK_EAST_MINE_WORLD_AREA = new WorldArea(3281, 3361, 9, 9, 0);

    private enum ScriptState {
        WAITING, WALKING, MINING, BANKING

    }

    private ScriptState scriptState;


    public Mining(GerberConfig gerberConfig) {
        this.config = gerberConfig;
        scriptState = ScriptState.WAITING;
    }

    public void run() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        while (!Alfred.getPlayTimer().isTimerComplete()) {
            int minimumSkillRequirement = player.getSkillLevel(Skill.MINING);

            if (minimumSkillRequirement < 10) {
                Alfred.setTaskSubStatus("Mining Copper");
                mineCopper();
                scriptState = ScriptState.WAITING;

            } else {
                return;
            }

            Alfred.sleep(500);
        }
    }

    private void mineCopper() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (player.isMoving() || player.isInteracting()) {
            return;
        }

        if (scriptState == ScriptState.WAITING) {
            if (!VARROCK_EAST_MINE_WORLD_AREA.contains(player.getWorldLocation())) {
                Alfred.api.walk().walkTo(WorldDestinations.VARROCK_SOUTH_EAST_MINE.getWorldPoint());
            }

            scriptState = ScriptState.MINING;
        }

        if (scriptState == ScriptState.MINING) {
            Alfred.tasks.objects().mineOre("copper rocks");
            scriptState = ScriptState.BANKING;
        }

        if (scriptState == ScriptState.BANKING) {
            if (config.collectItems()) {
                if (Alfred.api.inventory().isFull()) {
                    bankInventory();
                    Alfred.sleep(200);
                }
            } else {
                for (RSInvetoryItem item : Alfred.api.inventory().getItems("copper ore")) {
                    int count = Alfred.api.inventory().count();
                    item.drop();
                    Alfred.sleepUntil(() -> Alfred.api.inventory().count() == count - 1, 200, 1000 * 5);
                }
            }

            scriptState = ScriptState.WAITING;
        }
    }


    private void bankInventory() {
        Alfred.api.walk().walkTo(WorldDestinations.VARROCK_EAST_BANK.getWorldPoint());
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
