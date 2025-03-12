package net.runelite.client.plugins.rlbot.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Setter;
import net.runelite.client.plugins.rlbot.RLBotConfig;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

/**
 * Overlay for the RLBot plugin.
 * Displays information about the bot's status.
 */
public class RLBotOverlay extends OverlayPanel {
    
    /**
     * The maximum number of actions to display in the history.
     */
    private static final int MAX_ACTION_HISTORY = 5;
    
    /**
     * The duration to display an action in the history.
     */
    private static final Duration ACTION_DISPLAY_DURATION = Duration.ofSeconds(10);
    
    /**
     * The plugin configuration.
     */
    private final RLBotConfig config;
    
    /**
     * The current action being performed.
     */
    @Setter
    private String currentAction;
    
    /**
     * The WebSocket connection status.
     */
    @Setter
    private boolean websocketConnected;
    
    /**
     * The time the bot started.
     */
    private final Instant startTime = Instant.now();
    
    /**
     * The list of recent actions.
     */
    private final List<ActionHistoryEntry> actionHistory = new ArrayList<>();
    
    /**
     * Creates a new RLBotOverlay.
     *
     * @param config The plugin configuration
     */
    @Inject
    public RLBotOverlay(RLBotConfig config) {
        super();
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.LOW);
    }
    
    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.showOverlay()) {
            return null;
        }
        
        panelComponent.getChildren().clear();
        
        // Add title
        panelComponent.getChildren().add(TitleComponent.builder()
            .text("RLBot")
            .color(websocketConnected ? Color.GREEN : Color.RED)
            .build());
        
        // Add connection status
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Connection:")
            .right(websocketConnected ? "Connected" : "Disconnected")
            .rightColor(websocketConnected ? Color.GREEN : Color.RED)
            .build());
        
        // Add uptime
        Duration uptime = Duration.between(startTime, Instant.now());
        long hours = uptime.toHours();
        long minutes = uptime.toMinutesPart();
        long seconds = uptime.toSecondsPart();
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Uptime:")
            .right(String.format("%02d:%02d:%02d", hours, minutes, seconds))
            .build());
        
        // Add current action
        if (currentAction != null && !currentAction.isEmpty()) {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Current action:")
                .right(currentAction)
                .build());
        }
        
        // Add action history
        if (!actionHistory.isEmpty()) {
            panelComponent.getChildren().add(TitleComponent.builder()
                .text("Recent Actions")
                .color(Color.YELLOW)
                .build());
            
            // Clean up old actions
            Instant now = Instant.now();
            actionHistory.removeIf(entry -> Duration.between(entry.timestamp, now).compareTo(ACTION_DISPLAY_DURATION) > 0);
            
            // Add recent actions to the panel
            for (int i = 0; i < actionHistory.size() && i < MAX_ACTION_HISTORY; i++) {
                ActionHistoryEntry entry = actionHistory.get(i);
                panelComponent.getChildren().add(LineComponent.builder()
                    .left(entry.action)
                    .right(formatTimestamp(entry.timestamp))
                    .rightColor(Color.LIGHT_GRAY)
                    .build());
            }
        }
        
        return super.render(graphics);
    }
    
    /**
     * Adds an action to the history.
     *
     * @param action The action to add
     */
    public void addAction(String action) {
        if (action == null || action.isEmpty()) {
            return;
        }
        
        actionHistory.add(0, new ActionHistoryEntry(action, Instant.now()));
        
        // Limit the history size
        while (actionHistory.size() > MAX_ACTION_HISTORY) {
            actionHistory.remove(actionHistory.size() - 1);
        }
    }
    
    /**
     * Formats a timestamp as "mm:ss" ago.
     *
     * @param timestamp The timestamp to format
     * @return The formatted timestamp
     */
    private String formatTimestamp(Instant timestamp) {
        Duration elapsed = Duration.between(timestamp, Instant.now());
        long minutes = elapsed.toMinutes();
        long seconds = elapsed.toSecondsPart();
        
        if (minutes > 0) {
            return String.format("%dm %ds ago", minutes, seconds);
        } else {
            return String.format("%ds ago", seconds);
        }
    }
    
    /**
     * Entry for the action history.
     */
    private static class ActionHistoryEntry {
        private final String action;
        private final Instant timestamp;
        
        private ActionHistoryEntry(String action, Instant timestamp) {
            this.action = action;
            this.timestamp = timestamp;
        }
    }
} 