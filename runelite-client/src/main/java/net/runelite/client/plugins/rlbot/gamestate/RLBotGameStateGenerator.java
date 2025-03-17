package net.runelite.client.plugins.rlbot.gamestate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.TileItem;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import net.runelite.client.plugins.rlbot.RLBotScreenshotUtil;

@RequiredArgsConstructor
public class RLBotGameStateGenerator {

    private final Client client;
    private final RLBotLogger logger;
    private final RLBotScreenshotUtil screenshotUtil;

    /**
     * Asynchronously generates the game state as a Gson JsonObject.
     */
    public CompletableFuture<JsonObject> generateGameStateAsync() {
        CompletableFuture<JsonObject> future = new CompletableFuture<>();
        try {
            screenshotUtil.captureScreenshot(encodedImage -> {
                try {
                    JsonObject gameState = createGameState(encodedImage);
                    future.complete(gameState);
                } catch (Exception e) {
                    logger.error("Error generating game state: " + e.getMessage());
                    future.completeExceptionally(e);
                }
            });
        } catch (Exception e) {
            logger.error("Error capturing screenshot for game state: " + e.getMessage());
            future.completeExceptionally(e);
        }
        return future;
    }

    /**
     * Constructs the game state JSON object.
     */
    private JsonObject createGameState(String encodedImage) {
        JsonObject gameState = new JsonObject();
        // Add screenshot
        gameState.addProperty("screenshot", encodedImage);
        // Add all game state components
        addPlayerInfo(gameState);
        addSkillInfo(gameState);
        addNpcInfo(gameState);
        addWorldInfo(gameState);
        addGameObjectInfo(gameState);
        addGroundItemInfo(gameState);
        addInterfaceInfo(gameState);
        addExplorationInfo(gameState);
        return gameState;
    }

    private void addPlayerInfo(JsonObject gameState) {
        JsonObject playerInfo = new JsonObject();
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer != null) {
            playerInfo.addProperty("name", localPlayer.getName());
            playerInfo.addProperty("combatLevel", localPlayer.getCombatLevel());
            
            // Location
            WorldPoint position = localPlayer.getWorldLocation();
            if (position != null) {
                JsonObject positionObj = new JsonObject();
                positionObj.addProperty("x", position.getX());
                positionObj.addProperty("y", position.getY());
                positionObj.addProperty("plane", position.getPlane());
                playerInfo.add("location", positionObj);
            }

            // Health
            JsonObject healthObj = new JsonObject();
            healthObj.addProperty("current", client.getBoostedSkillLevel(Skill.HITPOINTS));
            healthObj.addProperty("maximum", client.getRealSkillLevel(Skill.HITPOINTS));
            playerInfo.add("health", healthObj);

            // Combat and movement state
            playerInfo.addProperty("inCombat", localPlayer.getInteracting() != null);
            playerInfo.addProperty("isRunning", client.getVarpValue(173) == 1);
            playerInfo.addProperty("runEnergy", client.getEnergy() / 100.0);
            playerInfo.addProperty("prayer", client.getBoostedSkillLevel(Skill.PRAYER));

            playerInfo.addProperty("animation", localPlayer.getAnimation());
        }
        gameState.add("player", playerInfo);
    }

    private void addSkillInfo(JsonObject gameState) {
        JsonObject skillInfo = new JsonObject();
        for (Skill skill : Skill.values()) {
            JsonObject skillObj = new JsonObject();
            skillObj.addProperty("level", client.getBoostedSkillLevel(skill));
            skillObj.addProperty("realLevel", client.getRealSkillLevel(skill));
            skillObj.addProperty("experience", client.getSkillExperience(skill));
            skillInfo.add(skill.getName(), skillObj);
        }
        gameState.add("skills", skillInfo);
    }

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
            
            WorldPoint position = npc.getWorldLocation();
            if (position != null) {
                JsonObject positionObj = new JsonObject();
                positionObj.addProperty("x", position.getX());
                positionObj.addProperty("y", position.getY());
                positionObj.addProperty("plane", position.getPlane());
                npcObj.add("location", positionObj);
            }

            // Add health information if available
            JsonObject healthObj = new JsonObject();
            Integer healthRatio = npc.getHealthRatio();
            healthObj.addProperty("current", healthRatio != null ? healthRatio : -1);
            healthObj.addProperty("maximum", 100); // NPCs use a percentage-based health system
            npcObj.add("health", healthObj);

            npcObj.addProperty("animation", npc.getAnimation());
            npcObj.addProperty("interacting", npc.getInteracting() != null);

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

    private void addGameObjectInfo(JsonObject gameState) {
        JsonArray objects = new JsonArray();
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        
        for (int z = 0; z < tiles.length; z++) {
            for (int x = 0; x < tiles[z].length; x++) {
                for (int y = 0; y < tiles[z][x].length; y++) {
                    Tile tile = tiles[z][x][y];
                    if (tile == null) continue;

                    for (TileObject obj : tile.getGameObjects()) {
                        if (obj == null) continue;

                        ObjectComposition objComp = client.getObjectDefinition(obj.getId());
                        if (objComp == null) continue;

                        JsonObject objInfo = new JsonObject();
                        objInfo.addProperty("id", obj.getId());
                        objInfo.addProperty("name", objComp.getName());

                        JsonObject location = new JsonObject();
                        location.addProperty("x", tile.getWorldLocation().getX());
                        location.addProperty("y", tile.getWorldLocation().getY());
                        location.addProperty("plane", tile.getWorldLocation().getPlane());
                        objInfo.add("location", location);

                        JsonArray actions = new JsonArray();
                        String[] objectActions = objComp.getActions();
                        if (objectActions != null) {
                            for (String action : objectActions) {
                                if (action != null) actions.add(action);
                            }
                        }
                        objInfo.add("actions", actions);

                        objects.add(objInfo);
                    }
                }
            }
        }
        gameState.add("objects", objects);
    }

    private void addGroundItemInfo(JsonObject gameState) {
        JsonArray groundItems = new JsonArray();
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();

        for (int z = 0; z < tiles.length; z++) {
            for (int x = 0; x < tiles[z].length; x++) {
                for (int y = 0; y < tiles[z][x].length; y++) {
                    Tile tile = tiles[z][x][y];
                    if (tile == null) continue;

                    List<TileItem> items = tile.getGroundItems();
                    if (items != null) {
                        for (TileItem item : items) {
                            if (item == null) continue;
                            
                            ItemComposition itemComp = client.getItemDefinition(item.getId());
                            if (itemComp == null) continue;

                            JsonObject itemInfo = new JsonObject();
                            itemInfo.addProperty("id", item.getId());
                            itemInfo.addProperty("name", itemComp.getName());
                            itemInfo.addProperty("quantity", item.getQuantity());

                            JsonObject location = new JsonObject();
                            location.addProperty("x", tile.getWorldLocation().getX());
                            location.addProperty("y", tile.getWorldLocation().getY());
                            location.addProperty("plane", tile.getWorldLocation().getPlane());
                            itemInfo.add("location", location);

                            groundItems.add(itemInfo);
                        }
                    }
                }
            }
        }
        gameState.add("groundItems", groundItems);
    }

    private void addInterfaceInfo(JsonObject gameState) {
        JsonArray interfaces = new JsonArray();
        Widget[] widgets = client.getWidgetRoots();
        if (widgets != null) {
            for (Widget widget : widgets) {
                if (widget == null) continue;
                addWidgetToArray(widget, interfaces);
            }
        }
        gameState.add("interfaces", interfaces);
    }

    private void addWidgetToArray(Widget widget, JsonArray interfaces) {
        JsonObject interfaceInfo = new JsonObject();
        interfaceInfo.addProperty("id", widget.getId());
        interfaceInfo.addProperty("type", getWidgetTypeString(widget.getType()));
        interfaceInfo.addProperty("text", widget.getText());

        JsonArray actions = new JsonArray();
        String[] widgetActions = widget.getActions();
        if (widgetActions != null) {
            for (String action : widgetActions) {
                if (action != null) actions.add(action);
            }
        }
        interfaceInfo.add("actions", actions);
        interfaces.add(interfaceInfo);

        // Recursively add child widgets
        Widget[] children = widget.getChildren();
        if (children != null) {
            for (Widget child : children) {
                if (child != null) {
                    addWidgetToArray(child, interfaces);
                }
            }
        }
    }

    private String getWidgetTypeString(int type) {
        switch (type) {
            case WidgetType.LAYER:
                return "LAYER";
            case WidgetType.RECTANGLE:
                return "RECTANGLE";
            case WidgetType.TEXT:
                return "TEXT";
            case WidgetType.GRAPHIC:
                return "GRAPHIC";
            case WidgetType.MODEL:
                return "MODEL";
            case WidgetType.TEXT_INVENTORY:
                return "TEXT_INVENTORY";
            case WidgetType.IF1_TOOLTIP:
                return "IF1_TOOLTIP";
            case WidgetType.LINE:
                return "LINE";
            default:
                return "UNKNOWN";
        }
    }

    private void addExplorationInfo(JsonObject gameState) {
        JsonObject exploration = new JsonObject();
        Player localPlayer = client.getLocalPlayer();
        
        if (localPlayer != null) {
            WorldPoint location = localPlayer.getWorldLocation();
            JsonObject currentChunk = new JsonObject();
            currentChunk.addProperty("x", location.getX() >> 3);  // Convert to chunk coordinates (divide by 8)
            currentChunk.addProperty("y", location.getY() >> 3);
            exploration.add("currentChunk", currentChunk);
            
            // Note: visitedChunks would need to be tracked separately, 
            // here we're just putting 0 as a placeholder
            exploration.addProperty("visitedChunks", 0);
        }
        
        gameState.add("exploration", exploration);
    }

    private void addWorldInfo(JsonObject gameState) {
        JsonObject worldInfo = new JsonObject();
        worldInfo.addProperty("worldId", client.getWorld());
        worldInfo.addProperty("region", client.getLocalPlayer() != null ? client.getLocalPlayer().getWorldLocation().getRegionID() : 0);
        worldInfo.addProperty("plane", client.getPlane());
        gameState.add("world", worldInfo);
    }
}