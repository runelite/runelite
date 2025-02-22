package net.runelite.client.plugins.rlbot;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class RLBotOverlay extends OverlayPanel {
    private static final int CURSOR_SIZE = 12;  // Larger cursor
    private static final int MAX_TRAIL_AGE_MS = 1000;  // Trail points older than 1 second will be removed
    private static final int CURSOR_TRAIL_LENGTH = 10;
    private static final int REWARD_DISPLAY_DURATION = 5000; // milliseconds
    private static final int MAX_REWARDS = 5;
    private final Client client;
    private final RLBotConfig config;
    private String status = "Idle";
    private int npcsKilled = 0;
    private int damageDealt = 0;
    private double totalReward = 0.0;
    private final Map<Skill, Integer> lastSkillExp;
    private int sessionExpGained = 0;
    private final Queue<Point> cursorTrailPoints = new LinkedList<>();
    private final List<RewardDisplay> rewards = new ArrayList<>();

    @Inject
    private RLBotOverlay(Client client, RLBotConfig config) {
        super();
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.client = client;
        this.config = config;
        this.lastSkillExp = new EnumMap<>(Skill.class);
        initializeExpTracking();
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();

        // Draw cursor trail if enabled
        if (config.showCursor() && !cursorTrailPoints.isEmpty()) {
            // Save original graphics state
            Stroke originalStroke = graphics.getStroke();
            Color originalColor = graphics.getColor();
            
            // Remove old trail points
            long currentTime = System.currentTimeMillis();
            while (!cursorTrailPoints.isEmpty() && currentTime - cursorTrailPoints.peek().x > MAX_TRAIL_AGE_MS) {
                cursorTrailPoints.poll();
            }
            
            // Draw trail
            Point[] points = cursorTrailPoints.toArray(new Point[0]);
            for (int i = 1; i < points.length; i++) {
                Point prev = points[i - 1];
                Point curr = points[i];
                if (prev != null && curr != null) {
                    graphics.setColor(new Color(255, 255, 0, 128));
                    graphics.drawLine(prev.x, prev.y, curr.x, curr.y);
                }
            }
            
            // Draw current cursor position
            if (points.length > 0) {
                // Draw outer glow
                graphics.setColor(new Color(255, 255, 0, 64));
                graphics.fillOval(points[points.length - 1].x - CURSOR_SIZE, points[points.length - 1].y - CURSOR_SIZE, 
                                CURSOR_SIZE * 2, CURSOR_SIZE * 2);
                
                // Draw cursor
                graphics.setColor(Color.YELLOW);
                graphics.fillOval(points[points.length - 1].x - CURSOR_SIZE/2, points[points.length - 1].y - CURSOR_SIZE/2, 
                                CURSOR_SIZE, CURSOR_SIZE);
            }
            
            // Restore original graphics state
            graphics.setStroke(originalStroke);
            graphics.setColor(originalColor);
        }

        // Add rewards information using LineComponent instead of TableComponent
        panelComponent.getChildren().add(TitleComponent.builder()
            .text("Combat Stats")
            .color(Color.GREEN)
            .build());

        // Status
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Status:")
            .right(status)
            .build());

        // Total XP
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Total XP:")
            .right(String.format("+%,d", sessionExpGained))
            .build());

        // NPCs Killed
        panelComponent.getChildren().add(LineComponent.builder()
            .left("NPCs Killed:")
            .right(String.valueOf(npcsKilled))
            .build());

        // Damage Dealt
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Damage Dealt:")
            .right(String.valueOf(damageDealt))
            .build());

        // Health
        if (client.getLocalPlayer() != null) {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Health:")
                .right(client.getBoostedSkillLevel(Skill.HITPOINTS) + "/" + 
                    client.getRealSkillLevel(Skill.HITPOINTS))
                .build());
        }

        // Total Reward
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Total Reward:")
            .right(String.format("%.2f", totalReward))
            .build());

        // Clean up expired rewards
        long now = System.currentTimeMillis();
        rewards.removeIf(reward -> now - reward.timestamp > REWARD_DISPLAY_DURATION);

        // Add active rewards
        for (RewardDisplay reward : rewards) {
            panelComponent.getChildren().add(LineComponent.builder()
                .left(reward.message)
                .right(String.format("+%.1f", reward.value))
                .build());
        }

        return super.render(graphics);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void incrementNPCKilled() {
        this.npcsKilled++;
    }

    public void addDamageDealt(int damage) {
        this.damageDealt += damage;
    }

    public void reset() {
        status = "Idle";
        npcsKilled = 0;
        damageDealt = 0;
        totalReward = 0.0;
        initializeExpTracking();
    }

    private void initializeExpTracking() {
        if (client.getGameState().ordinal() < 30) {
            return;
        }

        for (Skill skill : Skill.values()) {
            lastSkillExp.put(skill, client.getSkillExperience(skill));
        }
    }

    public void updateExperienceGained() {
        if (client.getGameState().ordinal() < 30) {
            return;
        }

        int totalExp = 0;
        for (Skill skill : Skill.values()) {
            int currentExp = client.getSkillExperience(skill);
            Integer lastExp = lastSkillExp.get(skill);
            if (lastExp != null) {
                int expGained = currentExp - lastExp;
                if (expGained > 0) {
                    totalExp += expGained;
                    // Add small reward for XP gain
                    addReward(0.01 * expGained, skill.getName() + " XP gained: " + expGained);
                }
            }
            lastSkillExp.put(skill, currentExp);
        }
        sessionExpGained += totalExp;
    }

    public void addCursorPosition(Point point) {
        cursorTrailPoints.add(point);
        while (cursorTrailPoints.size() > CURSOR_TRAIL_LENGTH) {
            cursorTrailPoints.poll();
        }
    }

    public void addReward(double value, String message) {
        rewards.add(new RewardDisplay(value, message));
        while (rewards.size() > MAX_REWARDS) {
            rewards.remove(0);
        }
    }

    private static class RewardDisplay {
        final double value;
        final String message;
        final long timestamp;

        RewardDisplay(double value, String message) {
            this.value = value;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }
    }
} 