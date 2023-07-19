package net.runelite.client.plugins.alfred.api.rs.walk;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PathFinder {

    public static List<RSTile> path = new ArrayList<>();

    private List<RSTile> walkableTiles;

    public PathFinder(List<RSTile> walkableTiles) {
        this.walkableTiles = walkableTiles;
        readSavedPoints();
    }

    public void addTiles(List<RSTile> tiles) {
        walkableTiles.addAll(tiles);
    }

    private void readSavedPoints() {

        try (Reader reader = Files.newBufferedReader(Path.of("/home/griffin/PycharmProjects/runlitebot/tiles/solved.json"), StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (!element.isJsonObject()) {
                    continue;
                }

                JsonObject item = element.getAsJsonObject();
                int x = item.get("x").getAsInt();
                int y = item.get("y").getAsInt();
                int plane = item.get("plane").getAsInt();
                boolean isOperable = item.get("isOperable").getAsBoolean();
                JsonArray movementFlagsJson = item.get("movementFlags").getAsJsonArray();
                String[] movementFlags = new String[movementFlagsJson.size()];

                for (int i = 0; i < movementFlagsJson.size(); i++) {
                    movementFlags[i] = movementFlagsJson.get(i).getAsString();
                }

                if (walkableTilesContainsCoordinates(x, y, plane)) {
                    continue;
                }

                Set<WorldMovementFlag> movementFlagSet = new HashSet<>();
                for (String movementFlag : movementFlags) {
                    movementFlagSet.add(WorldMovementFlag.valueOf(movementFlag));
                }

                RSLoadedWalkableTile tile = new RSLoadedWalkableTile(x, y, plane, isOperable, movementFlagSet);
                walkableTiles.add(tile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean walkableTilesContainsCoordinates(int x, int y, int plane) {
        for (RSTile walkableTile : walkableTiles) {
            if (walkableTile.getWorldLocation() == null) {
                continue;
            }

            if (walkableTile.getWorldLocation().getX() == x && walkableTile.getWorldLocation().getY() == y && walkableTile.getWorldLocation().getPlane() == plane) {
                return true;
            }
        }
        return false;
    }

    private RSTile getWalkableTileFromWorldPoint(WorldPoint worldPoint) {
        for (RSTile walkableTile : walkableTiles) {
            if (walkableTile.getWorldLocation().equals(worldPoint)) {
                return walkableTile;
            }
        }
        return null;
    }

    public List<RSTile> getPath(WorldPoint start, WorldPoint end) {
        List<RSTile> openNodes = new ArrayList<>();
        List<RSTile> closedNodes = new ArrayList<>();

        RSTile startNode = getWalkableTileFromWorldPoint(start);
        RSTile endNode = getWalkableTileFromWorldPoint(end);

        if (startNode == null || endNode == null) {
            return null;
        }

        openNodes.add(startNode);

        while (!openNodes.isEmpty()) {
            RSTile currentNode = openNodes.get(0);

            for (RSTile node : openNodes) {
                if (node.getFCost() < currentNode.getFCost() || node.getFCost() == currentNode.getFCost()) {
                    if (node.getHCost() < currentNode.getHCost()) {
                        currentNode = node;
                    }
                }
            }

            openNodes.remove(currentNode);
            closedNodes.add(currentNode);

            if (currentNode == endNode) {
                path = getPath(startNode, endNode);
                return path;
            }

            for (RSTile neighbour : currentNode.getNeighbors(walkableTiles)) {
                if (!currentNode.isWalkable(neighbour) || closedNodes.contains(neighbour)) {
                    continue;
                }

                int newCostToNeighbour = currentNode.getGCost() + getDistance(currentNode, neighbour);
                if (newCostToNeighbour < neighbour.getGCost() || !openNodes.contains(neighbour)) {
                    neighbour.setGCost(newCostToNeighbour);
                    neighbour.setHCost(getDistance(neighbour, endNode));
                    neighbour.setParent(currentNode);

                    if (!openNodes.contains(neighbour)) {
                        openNodes.add(neighbour);
                    }
                }
            }
        }

        return new ArrayList<>();
    }


    private List<RSTile> getPath(RSTile startNode, RSTile endNode) {
        List<RSTile> path = new ArrayList<>();
        RSTile currentNode = endNode;

        while (currentNode != startNode) {
            path.add(currentNode);
            currentNode = currentNode.getParent();
        }

        Collections.reverse(path);
        return path;
    }

    private int getDistance(RSTile nodeA, RSTile nodeB) {
        int distanceX = Math.abs(nodeA.getWorldLocation().getX() - nodeB.getWorldLocation().getX());
        int distanceY = Math.abs(nodeA.getWorldLocation().getY() - nodeB.getWorldLocation().getY());

        if (distanceX > distanceY) {
            return 14 * distanceY + 10 * (distanceX - distanceY);
        }

        return 14 * distanceX + 10 * (distanceY - distanceX);
    }

    public WorldPoint getFurthestUnexploredWorldPointFromPlayer(List<RSTile> potentiallyUnexploredTiles) {
        WorldPoint playerLocation = Alfred.api.players().getLocalPlayer().getWorldLocation();
        WorldPoint furthestUnexploredWorldPoint = null;
        int furthestDistance = 0;

        for (RSTile potentiallyUnexploredTile : potentiallyUnexploredTiles) {
            if (potentiallyUnexploredTile.getWorldLocation() == null) {
                continue;
            }

            int x = potentiallyUnexploredTile.getWorldLocation().getX();
            int y = potentiallyUnexploredTile.getWorldLocation().getY();
            int plane = potentiallyUnexploredTile.getWorldLocation().getPlane();

            if (walkableTilesContainsCoordinates(x, y, plane)) {
                continue;
            }

            int distance = potentiallyUnexploredTile.getWorldLocation().distanceTo(playerLocation);
            if (distance > furthestDistance) {
                furthestDistance = distance;
                furthestUnexploredWorldPoint = potentiallyUnexploredTile.getWorldLocation();
            }
        }

        return furthestUnexploredWorldPoint;

    }
}
