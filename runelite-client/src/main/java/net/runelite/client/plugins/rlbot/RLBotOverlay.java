package net.runelite.client.plugins.rlbot;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.EnumMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.RenderingHints;
import java.awt.GradientPaint;

public class RLBotOverlay extends OverlayPanel {
    private final Client client;
    private final RLBotPlugin plugin;
    private final Map<Skill, Integer> lastSkillExp;
    private int sessionExpGained;
    private int totalDamageDealt;
    private int npcsKilled;

    private static final int CURSOR_SIZE = 8;  // Smaller, more subtle cursor
    private static final int MAX_TRAIL_LENGTH = 15;  // Longer trail for smoother appearance
    private static final float TRAIL_ALPHA_STEP = 0.07f;  // More gradual fade
    private static final float TRAIL_WIDTH = 2.0f;  // Thinner trail line
    private final Queue<Point> cursorTrail;

    @Inject
    private RLBotOverlay(Client client, RLBotPlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(OverlayPriority.HIGH);
        this.client = client;
        this.plugin = plugin;
        this.lastSkillExp = new EnumMap<>(Skill.class);
        this.sessionExpGained = 0;
        this.cursorTrail = new LinkedList<>();
        initializeExpTracking();
    }

    private void initializeExpTracking() {
        // Initialize last experience values for combat skills
        Skill[] combatSkills = {
            Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE,
            Skill.RANGED, Skill.MAGIC, Skill.HITPOINTS
        };
        
        for (Skill skill : combatSkills) {
            lastSkillExp.put(skill, client.getSkillExperience(skill));
        }
    }

    private void updateCursorTrail(Point newPos) {
        if (newPos.x != -1 && newPos.y != -1) {
            cursorTrail.offer(new Point(newPos));
            while (cursorTrail.size() > MAX_TRAIL_LENGTH) {
                cursorTrail.poll();
            }
        }
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        // Draw cursor trail if needed
        if (plugin.shouldDrawCursor()) {
            Point cursor = plugin.getCursorPosition();
            updateCursorTrail(cursor);

            // Enable antialiasing for smoother rendering
            graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Draw trail segments with fading alpha
            if (cursorTrail.size() > 1) {
                Point[] points = cursorTrail.toArray(new Point[0]);
                float alpha = 1.0f;
                
                for (int i = points.length - 1; i > 0; i--) {
                    Color trailColor = plugin.getCursorColor();
                    Color fadeColor = new Color(
                        trailColor.getRed(),
                        trailColor.getGreen(),
                        trailColor.getBlue(),
                        (int)(255 * alpha)
                    );
                    
                    // Create gradient for smoother trail
                    GradientPaint gradient = new GradientPaint(
                        points[i].x, points[i].y, fadeColor,
                        points[i-1].x, points[i-1].y, 
                        new Color(fadeColor.getRed(), fadeColor.getGreen(), fadeColor.getBlue(), 0)
                    );
                    
                    graphics.setPaint(gradient);
                    graphics.setStroke(new BasicStroke(TRAIL_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    graphics.drawLine(
                        points[i].x,
                        points[i].y,
                        points[i-1].x,
                        points[i-1].y
                    );
                    
                    alpha = Math.max(0.15f, alpha - TRAIL_ALPHA_STEP);
                }
            }

            // Draw current cursor
            if (cursor.x != -1 && cursor.y != -1) {
                // Draw outer glow
                Color cursorColor = plugin.getCursorColor();
                graphics.setColor(new Color(cursorColor.getRed(), cursorColor.getGreen(), cursorColor.getBlue(), 60));
                graphics.fillOval(
                    cursor.x - CURSOR_SIZE - 2,
                    cursor.y - CURSOR_SIZE - 2,
                    (CURSOR_SIZE + 2) * 2,
                    (CURSOR_SIZE + 2) * 2
                );

                // Draw main cursor dot
                graphics.setColor(cursorColor);
                graphics.fillOval(
                    cursor.x - CURSOR_SIZE/2,
                    cursor.y - CURSOR_SIZE/2,
                    CURSOR_SIZE,
                    CURSOR_SIZE
                );

                // Draw white center
                graphics.setColor(new Color(255, 255, 255, 180));
                graphics.fillOval(
                    cursor.x - CURSOR_SIZE/4,
                    cursor.y - CURSOR_SIZE/4,
                    CURSOR_SIZE/2,
                    CURSOR_SIZE/2
                );
            }
        }

        if (client.getGameState() == null) {
            return null;
        }

        // Update experience tracking
        updateExperienceGained();

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

        // Individual Skill Experience
        Skill[] combatSkills = {
            Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE,
            Skill.RANGED, Skill.MAGIC, Skill.HITPOINTS
        };

        for (Skill skill : combatSkills) {
            int expGained = client.getSkillExperience(skill) - lastSkillExp.get(skill);
            if (expGained > 0) {
                panelComponent.getChildren().add(LineComponent.builder()
                    .left(skill.getName() + " XP:")
                    .right("+" + formatNumber(expGained))
                    .rightColor(Color.YELLOW)
                    .build());
            }
        }

        // Total Combat Experience
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Total XP:")
            .right("+" + formatNumber(sessionExpGained))
            .rightColor(Color.ORANGE)
            .build());

        // NPCs Killed
        panelComponent.getChildren().add(LineComponent.builder()
            .left("NPCs Killed:")
            .right(String.valueOf(npcsKilled))
            .rightColor(Color.CYAN)
            .build());

        // Damage Dealt
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Damage Dealt:")
            .right(formatNumber(totalDamageDealt))
            .rightColor(Color.ORANGE)
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

    public void updateExperienceGained() {
        Skill[] combatSkills = {
            Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE,
            Skill.RANGED, Skill.MAGIC, Skill.HITPOINTS
        };

        int totalGained = 0;
        for (Skill skill : combatSkills) {
            int currentExp = client.getSkillExperience(skill);
            int lastExp = lastSkillExp.getOrDefault(skill, currentExp);
            int gained = currentExp - lastExp;
            if (gained > 0) {
                totalGained += gained;
                lastSkillExp.put(skill, currentExp);
            }
        }
        sessionExpGained += totalGained;
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

    public void resetStats() {
        sessionExpGained = 0;
        totalDamageDealt = 0;
        npcsKilled = 0;
        initializeExpTracking();
    }
} 