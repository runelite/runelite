package net.runelite.client.plugins.rlbot;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.Skill;

import javax.inject.Inject;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class RLBotOverlay extends OverlayPanel {
    private final Client client;
    private final RLBotPlugin plugin;
    private long lastExpUpdate = 0;
    private int totalExperience = 0;
    private int totalDamageDealt = 0;
    private int npcsKilled = 0;

    @Inject
    private RLBotOverlay(Client client, RLBotPlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.getGameState() == null) {
            return null;
        }

        // Update combat experience
        int currentExp = getCombatExperience();
        if (totalExperience == 0) {
            totalExperience = currentExp;
        } else if (currentExp > totalExperience) {
            if (System.currentTimeMillis() - lastExpUpdate > 1000) { // Update every second
                totalExperience = currentExp;
                lastExpUpdate = System.currentTimeMillis();
            }
        }

        // Title
        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Combat Stats")
            .color(Color.GREEN)
            .build());

        // Combat Status
        if (client.getLocalPlayer() != null && client.getLocalPlayer().getInteracting() != null) {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Status:")
                .right("In Combat")
                .rightColor(Color.RED)
                .build());
        } else {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Status:")
                .right("Idle")
                .rightColor(Color.WHITE)
                .build());
        }

        // Experience Gained
        int expGained = currentExp - totalExperience;
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Combat XP:")
            .right(formatNumber(expGained))
            .build());

        // NPCs Killed
        panelComponent.getChildren().add(LineComponent.builder()
            .left("NPCs Killed:")
            .right(String.valueOf(npcsKilled))
            .build());

        // Damage Dealt
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Damage Dealt:")
            .right(formatNumber(totalDamageDealt))
            .build());

        // Player Health
        if (client.getLocalPlayer() != null) {
            int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
            int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Health:")
                .right(currentHealth + "/" + maxHealth)
                .rightColor(currentHealth < maxHealth * 0.3 ? Color.RED : Color.GREEN)
                .build());
        }

        return super.render(graphics);
    }

    private int getCombatExperience() {
        int total = 0;
        total += client.getSkillExperience(Skill.ATTACK);
        total += client.getSkillExperience(Skill.STRENGTH);
        total += client.getSkillExperience(Skill.DEFENCE);
        total += client.getSkillExperience(Skill.HITPOINTS);
        return total;
    }

    private String formatNumber(int number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    public void incrementNPCKilled() {
        npcsKilled++;
    }

    public void addDamageDealt(int damage) {
        totalDamageDealt += damage;
    }
} 