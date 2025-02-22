package net.runelite.client.plugins.rlbot;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.awt.BasicStroke;

public class RLBotOverlay extends OverlayPanel {
    private static final int CURSOR_SIZE = 12;  // Larger cursor
    private static final int MAX_TRAIL_AGE_MS = 1000;  // Trail points older than 1 second will be removed
    private static final int CURSOR_TRAIL_LENGTH = 10;
    private static final int REWARD_DISPLAY_DURATION = 5000; // milliseconds
    private static final int MAX_REWARDS = 5;
    private static final int LERP_DURATION_MS = 500; // Time to move between points
    private static final int TRAIL_UPDATE_INTERVAL_MS = 50; // Update trail every 50ms
    private final Client client;
    private final RLBotConfig config;
    private String status = "Idle";
    private int npcsKilled = 0;
    private int damageDealt = 0;
    private double totalReward = 0.0;
    private final Map<Skill, Integer> lastSkillExp;
    private int sessionExpGained = 0;
    private final Queue<TimestampedPoint> cursorTrailPoints = new LinkedList<>();
    private Point currentCursorPosition = null;  // Store current cursor position separately
    private Point targetCursorPosition = null;   // Target position for lerping
    private long lerpStartTime = 0;              // When lerp started
    private long lastTrailUpdate = 0;            // Last trail point added
    private final List<RewardDisplay> rewards = new ArrayList<>();

    private static class TimestampedPoint {
        final Point point;
        final long timestamp;

        TimestampedPoint(Point point) {
            this.point = point;
            this.timestamp = System.currentTimeMillis();
        }
    }

    @Inject
    private RLBotOverlay(Client client, RLBotConfig config) {
        super();
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGHEST);
        this.client = client;
        this.config = config;
        this.lastSkillExp = new EnumMap<>(Skill.class);
        initializeExpTracking();
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.showOverlay()) {
            return null;
        }

        // Clear and render panel components
        panelComponent.getChildren().clear();

        // Update lerped cursor position
        long currentTime = System.currentTimeMillis();
        if (targetCursorPosition != null) {
            float t = Math.min(1.0f, (float)(currentTime - lerpStartTime) / LERP_DURATION_MS);
            t = 1.0f - (1.0f - t) * (1.0f - t); // Ease out quad
            Point lerpedPosition = lerpPoint(currentCursorPosition, targetCursorPosition, t);
            currentCursorPosition = lerpedPosition;

            // Add trail points at regular intervals
            if (currentTime - lastTrailUpdate >= TRAIL_UPDATE_INTERVAL_MS) {
                cursorTrailPoints.add(new TimestampedPoint(lerpedPosition));
                while (cursorTrailPoints.size() > CURSOR_TRAIL_LENGTH) {
                    cursorTrailPoints.poll();
                }
                lastTrailUpdate = currentTime;
            }

            // If lerp is complete, clear target
            if (t >= 1.0f) {
                targetCursorPosition = null;
            }
        }

        // Draw cursor trail if enabled
        if (config.showCursor() && currentCursorPosition != null) {
            // Save original graphics state
            Stroke originalStroke = graphics.getStroke();
            Color originalColor = graphics.getColor();
            
            // Remove old trail points
            while (!cursorTrailPoints.isEmpty() && currentTime - cursorTrailPoints.peek().timestamp > MAX_TRAIL_AGE_MS) {
                cursorTrailPoints.poll();
            }
            
            // Draw trail with varying thickness and alpha
            TimestampedPoint[] points = cursorTrailPoints.toArray(new TimestampedPoint[0]);
            for (int i = 1; i < points.length; i++) {
                Point prev = points[i - 1].point;
                Point curr = points[i].point;
                if (prev != null && curr != null) {
                    // Calculate alpha and thickness based on age
                    long age = currentTime - points[i].timestamp;
                    float progress = 1.0f - (float)age / MAX_TRAIL_AGE_MS;
                    int alpha = (int)(192 * progress);
                    float thickness = 3.0f * progress;
                    
                    graphics.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    graphics.setColor(new Color(255, 255, 0, alpha));
                    graphics.drawLine(prev.x, prev.y, curr.x, curr.y);
                }
            }
            
            // Draw current cursor position
            int cursorX = currentCursorPosition.x;
            int cursorY = currentCursorPosition.y;
            
            // Draw outer glow
            graphics.setColor(new Color(255, 255, 0, 64));
            graphics.fillOval(cursorX - CURSOR_SIZE, cursorY - CURSOR_SIZE, 
                            CURSOR_SIZE * 2, CURSOR_SIZE * 2);
            
            // Draw cursor
            graphics.setColor(Color.YELLOW);
            graphics.fillOval(cursorX - CURSOR_SIZE/2, cursorY - CURSOR_SIZE/2, 
                            CURSOR_SIZE, CURSOR_SIZE);
            
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

    public void initializeExpTracking() {
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
        int combatExp = 0;
        StringBuilder expDetails = new StringBuilder();

        // Track experience gains by skill
        for (Skill skill : Skill.values()) {
            int currentExp = client.getSkillExperience(skill);
            Integer lastExp = lastSkillExp.get(skill);
            
            if (lastExp != null) {
                int expGained = currentExp - lastExp;
                if (expGained > 0) {
                    totalExp += expGained;
                    
                    // Track combat experience separately
                    if (isCombatSkill(skill)) {
                        combatExp += expGained;
                        expDetails.append(String.format("%s: +%,d  ", skill.getName(), expGained));
                    }
                    
                    // Add reward based on experience type
                    if (isCombatSkill(skill)) {
                        addReward(expGained * 0.05, skill.getName() + " XP: +" + expGained);
                    } else {
                        addReward(expGained * 0.01, skill.getName() + " XP: +" + expGained);
                    }
                }
            }
            lastSkillExp.put(skill, currentExp);
        }

        if (totalExp > 0) {
            sessionExpGained += totalExp;
            status = expDetails.toString().trim();
            if (status.isEmpty()) {
                status = String.format("Gained %,d total exp", totalExp);
            }
        }
    }

    private boolean isCombatSkill(Skill skill) {
        return skill == Skill.ATTACK || skill == Skill.STRENGTH || 
               skill == Skill.DEFENCE || skill == Skill.RANGED || 
               skill == Skill.MAGIC || skill == Skill.HITPOINTS || 
               skill == Skill.PRAYER;
    }

    public void addCursorPosition(Point point) {
        if (point == null) return;
        
        // Set up lerping from current position to new target
        if (currentCursorPosition == null) {
            currentCursorPosition = point;
        } else {
            targetCursorPosition = point;
            lerpStartTime = System.currentTimeMillis();
        }
    }

    public void addReward(double value, String message) {
        rewards.add(new RewardDisplay(value, message));
        while (rewards.size() > MAX_REWARDS) {
            rewards.remove(0);
        }
    }

    private Point lerpPoint(Point start, Point end, float t) {
        if (start == null || end == null) return end;
        int x = (int) (start.x + (end.x - start.x) * t);
        int y = (int) (start.y + (end.y - start.y) * t);
        return new Point(x, y);
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