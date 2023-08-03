package net.runelite.client.plugins.alfred.scripts.gerber.tasks;

import net.runelite.api.Skill;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;
import net.runelite.client.plugins.alfred.api.rs.inventory.RSInventoryItem;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.enums.WorldDestinations;
import net.runelite.client.plugins.alfred.scripts.gerber.GerberConfig;

import java.util.Arrays;
import java.util.Collections;

public class Combat {

    private final GerberConfig config;
    private final WorldArea LUMBRIDGE_CHICKENS_WORLD_AREA = new WorldArea(3225, 3287, 12, 15, 0);
    private final WorldArea LUMBRDIGE_COWS_WORLD_AREA = new WorldArea(3255, 3258, 9, 37, 0);

    private enum ScriptState {
        WAITING, WALKING, FIGHTING, LOOTING,

    }

    private ScriptState scriptState;


    public Combat(GerberConfig gerberConfig) {
        this.config = gerberConfig;
        scriptState = ScriptState.WAITING;
    }

    public void run() {
        while (!Alfred.getPlayTimer().isTimerComplete()) {
            int minimumSkillRequirement = getMinimumSkillRequirement();

            if (minimumSkillRequirement < 10) {
                Alfred.setTaskSubStatus("Fighting Chickens");
                fightChickens();
                scriptState = ScriptState.WAITING;

            } else if (minimumSkillRequirement < 20) {
                Alfred.setTaskSubStatus("Fighting Cows");
                fightCows();
                scriptState = ScriptState.WAITING;

            } else {
                return;
            }

            Alfred.sleep(500);
        }
    }

    private int getMinimumSkillRequirement() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        Integer[] levels = {player.getSkillLevel(Skill.ATTACK), player.getSkillLevel(Skill.STRENGTH), player.getSkillLevel(Skill.DEFENCE)};
        return Collections.min(Arrays.asList(levels));
    }

    private void fightChickens() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (player.isMoving() || player.isInteracting()) {
            return;
        }

        if (scriptState == ScriptState.WAITING) {
            if (!LUMBRIDGE_CHICKENS_WORLD_AREA.contains(player.getWorldLocation())) {
                Alfred.api.walk().walkTo(WorldDestinations.LUMBRIDGE_CHICKENS.getWorldPoint());
            }

            scriptState = ScriptState.FIGHTING;
        }

        if (scriptState == ScriptState.FIGHTING) {
            setCombatStyle();
            Alfred.tasks.npcs().attackNpc("chicken");
            scriptState = ScriptState.LOOTING;
        }

        if (scriptState == ScriptState.LOOTING) {
            if (config.collectItems()) {
                if (Alfred.api.inventory().isFull()) {
                    buryBones();
                    Alfred.sleep(200);
                }

                String[] itemNames = {"feather", "bones"};
                Alfred.tasks.items().lootItems(itemNames, 2);
            }

            scriptState = ScriptState.WAITING;
        }
    }

    private void fightCows() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (player.isMoving() || player.isInteracting()) {
            return;
        }

        if (scriptState == ScriptState.WAITING) {
            if (!LUMBRDIGE_COWS_WORLD_AREA.contains(player.getWorldLocation())) {
                Alfred.api.walk().walkTo(WorldDestinations.LUMBRIDGE_COWS.getWorldPoint());
            }

            scriptState = ScriptState.FIGHTING;
        }

        if (scriptState == ScriptState.FIGHTING) {
            setCombatStyle();
            Alfred.tasks.npcs().attackNpc("cow");
            scriptState = ScriptState.LOOTING;
        }

        if (scriptState == ScriptState.LOOTING) {
            if (config.collectItems()) {
                if (Alfred.api.inventory().isFull()) {
                    buryBones();
                    Alfred.sleep(200);
                }

                if (Alfred.api.inventory().isFull()) {
                    bankInventory();
                    Alfred.sleep(200);
                }

                String[] itemNames = {"cowhide", "bones"};
                Alfred.tasks.items().lootItems(itemNames, 4);
            }

            scriptState = ScriptState.WAITING;
        }
    }

    private void setCombatStyle() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        int attackLevel = player.getSkillLevel(Skill.ATTACK);
        int strengthLevel = player.getSkillLevel(Skill.STRENGTH);
        int defenceLevel = player.getSkillLevel(Skill.DEFENCE);

        if (attackLevel < config.attackLevel()) {
            if (!Alfred.api.combat().isPunchSelected()) {
                Alfred.api.combat().clickPunch();
            }
        } else if (strengthLevel < config.strengthLevel()) {
            if (!Alfred.api.combat().isKickSelected()) {
                Alfred.api.combat().clickKick();
            }
        } else if (defenceLevel < config.defenseLevel()) {
            if (!Alfred.api.combat().isBlockSelected()) {
                Alfred.api.combat().clickBlock();
            }
        }
    }


    private void buryBones() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();
        if (!config.buryBones() || player.getSkillLevel(Skill.PRAYER) >= config.prayerLevel()) {
            return;
        }

        for (RSInventoryItem item : Alfred.api.inventory().getItems("bones")) {
            item.leftClick();
            Alfred.sleep(1000);
            Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 30);
        }
    }

    private void bankInventory() {
        Alfred.api.walk().walkTo(WorldDestinations.VARROCK_EAST_BANK.getWorldPoint());
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
