package net.runelite.client.plugins.rlbot.gamestate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import net.runelite.client.plugins.rlbot.RLBotScreenshotUtil;

/**
 * Generates game state information for the RLBot plugin.
 */
@RequiredArgsConstructor
public class RLBotGameStateGenerator {
    
    /**
     * The RuneLite client.
     */
    private final Client client;
    
    /**
     * The logger instance.
     */
    private final RLBotLogger logger;
    
    /**
     * The screenshot utility.
     */
    private final RLBotScreenshotUtil screenshotUtil;
    
    /**
     * Generate the game state object.
     *
     * @param callback The callback to handle the generated game state
     */
    public void generateGameState(GameStateCallback callback) {
        try {
            // Capture a screenshot first
            screenshotUtil.captureScreenshot(encodedImage -> {
                try {
                    // Create the JSON game state
                    JsonObject gameState = createGameState(encodedImage);
                    
                    // Call the callback with the game state
                    callback.onGameStateGenerated(gameState);
                } catch (Exception e) {
                    logger.error("Error generating game state: " + e.getMessage());
                }
            });
        } catch (Exception e) {
            logger.error("Error capturing screenshot for game state: " + e.getMessage());
        }
    }
    
    /**
     * Create the game state JSON object.
     *
     * @param encodedImage The base64 encoded screenshot
     * @return The game state JSON object
     */
    private JsonObject createGameState(String encodedImage) {
        JsonObject gameState = new JsonObject();
        
        // Add the screenshot
        gameState.addProperty("screenshot", encodedImage);
        
        // Add player information
        addPlayerInfo(gameState);
        
        // Add skill information
        addSkillInfo(gameState);
        
        // Add NPC information
        addNpcInfo(gameState);
        
        // Add world information
        addWorldInfo(gameState);
        
        return gameState;
    }
    
    /**
     * Add player information to the game state.
     *
     * @param gameState The game state JSON object
     */
    private void addPlayerInfo(JsonObject gameState) {
        JsonObject playerInfo = new JsonObject();
        Player localPlayer = client.getLocalPlayer();
        
        if (localPlayer != null) {
            playerInfo.addProperty("name", localPlayer.getName());
            playerInfo.addProperty("combatLevel", localPlayer.getCombatLevel());
            
            // Add position
            WorldPoint position = localPlayer.getWorldLocation();
            if (position != null) {
                JsonObject positionObj = new JsonObject();
                positionObj.addProperty("x", position.getX());
                positionObj.addProperty("y", position.getY());
                positionObj.addProperty("plane", position.getPlane());
                playerInfo.add("position", positionObj);
            }
            
            // Add animation
            playerInfo.addProperty("animation", localPlayer.getAnimation());
            
            // Add health and prayer
            playerInfo.addProperty("health", client.getBoostedSkillLevel(Skill.HITPOINTS));
            playerInfo.addProperty("maxHealth", client.getRealSkillLevel(Skill.HITPOINTS));
            playerInfo.addProperty("prayer", client.getBoostedSkillLevel(Skill.PRAYER));
            playerInfo.addProperty("maxPrayer", client.getRealSkillLevel(Skill.PRAYER));
        }
        
        gameState.add("player", playerInfo);
    }
    
    /**
     * Add skill information to the game state.
     *
     * @param gameState The game state JSON object
     */
    private void addSkillInfo(JsonObject gameState) {
        JsonObject skillInfo = new JsonObject();
        
        for (Skill skill : Skill.values()) {
            JsonObject skillObj = new JsonObject();
            skillObj.addProperty("level", client.getRealSkillLevel(skill));
            skillObj.addProperty("boostedLevel", client.getBoostedSkillLevel(skill));
            skillObj.addProperty("experience", client.getSkillExperience(skill));
            
            skillInfo.add(skill.getName(), skillObj);
        }
        
        gameState.add("skills", skillInfo);
    }
    
    /**
     * Add NPC information to the game state.
     *
     * @param gameState The game state JSON object
     */
    private void addNpcInfo(JsonObject gameState) {
        JsonArray npcs = new JsonArray();
        List<NPC> npcList = client.getNpcs();
        
        for (NPC npc : npcList) {
            if (npc.getName() == null) {
                continue;
            }
            
            JsonObject npcObj = new JsonObject();
            npcObj.addProperty("name", npc.getName());
            npcObj.addProperty("id", npc.getId());
            npcObj.addProperty("combatLevel", npc.getCombatLevel());
            
            // Add position
            WorldPoint position = npc.getWorldLocation();
            if (position != null) {
                JsonObject positionObj = new JsonObject();
                positionObj.addProperty("x", position.getX());
                positionObj.addProperty("y", position.getY());
                positionObj.addProperty("plane", position.getPlane());
                npcObj.add("position", positionObj);
            }
            
            // Add animation
            npcObj.addProperty("animation", npc.getAnimation());
            
            // Add distance to player
            Player localPlayer = client.getLocalPlayer();
            if (localPlayer != null && position != null) {
                WorldPoint playerPosition = localPlayer.getWorldLocation();
                if (playerPosition != null) {
                    npcObj.addProperty("distance", position.distanceTo(playerPosition));
                }
            }
            
            npcs.add(npcObj);
        }
        
        gameState.add("npcs", npcs);
    }
    
    /**
     * Add world information to the game state.
     *
     * @param gameState The game state JSON object
     */
    private void addWorldInfo(JsonObject gameState) {
        JsonObject worldInfo = new JsonObject();
        
        worldInfo.addProperty("worldId", client.getWorld());
        worldInfo.addProperty("region", client.getLocalPlayer() != null ? client.getLocalPlayer().getWorldLocation().getRegionID() : 0);
        worldInfo.addProperty("plane", client.getPlane());
        
        gameState.add("world", worldInfo);
    }
    
    /**
     * Callback interface for game state generation.
     */
    public interface GameStateCallback {
        /**
         * Called when the game state is generated.
         *
         * @param gameState The game state JSON object
         */
        void onGameStateGenerated(JsonObject gameState);
    }
} 