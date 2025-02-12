package net.runelite.client.plugins.toolbox;

import net.runelite.api.Client;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;

import javax.inject.Inject;
import java.util.*;

public class AStarPathfinder {

    @Inject
    private Client client;

    // Node class for A* pathfinding
    private static class Node {
        LocalPoint point;
        int gCost;  // Cost from start to current node
        int hCost;  // Heuristic cost to target
        Node parent;  // To reconstruct path

        Node(LocalPoint point, int gCost, int hCost, Node parent) {
            this.point = point;
            this.gCost = gCost;
            this.hCost = hCost;
            this.parent = parent;
        }

        int fCost() {
            return gCost + hCost;  // f = g + h
        }
    }

    // A* pathfinding algorithm
    public List<LocalPoint> findPath(LocalPoint start, LocalPoint destination) {
        if (start == null || destination == null) {
            return Collections.emptyList();
        }

        int z = client.getPlane();  // Current plane
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        byte[][][] tileSettings = client.getTileSettings();  // Tile settings array

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::fCost));
        Set<LocalPoint> closedList = new HashSet<>();

        Node startNode = new Node(start, 0, heuristic(start, destination), null);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            closedList.add(currentNode.point);

            // If we reached the destination, reconstruct the path
            if (currentNode.point.equals(destination)) {
                return reconstructPath(currentNode);
            }

            // Check neighbors (8 possible directions)
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    // Skip the center tile (we don't want to check the current node itself)
                    if (dx == 0 && dy == 0) continue;

                    int nx = currentNode.point.getX() + dx;
                    int ny = currentNode.point.getY() + dy;

                    // Ensure the new coordinates are within the bounds of the scene
                    if (nx < 0 || ny < 0 || nx >= 104 || ny >= 104) continue;

                    LocalPoint neighbor = new LocalPoint(nx, ny);
                    Tile tile = tiles[z][nx][ny];
                    int tileSetting = tileSettings[z][nx][ny];

                    // Skip if the tile is not walkable or already evaluated
                    if (tile == null || !isWalkable(tileSetting) || closedList.contains(neighbor)) continue;

                    // Calculate g and h costs
                    int gCost = currentNode.gCost + 1;  // Cost to move to the neighbor
                    int hCost = heuristic(neighbor, destination);

                    Node neighborNode = new Node(neighbor, gCost, hCost, currentNode);
                    openList.add(neighborNode);
                }
            }
        }

        return Collections.emptyList();  // No valid path found
    }

    // Check if there's a valid, walkable path (early termination as soon as one is found)
    public boolean hasValidPath(LocalPoint start, LocalPoint destination) {
        if (start == null || destination == null) {
            return false;
        }

        int z = client.getPlane();  // Current plane
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        byte[][][] tileSettings = client.getTileSettings();  // Tile settings array

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::fCost));
        Set<LocalPoint> closedList = new HashSet<>();

        Node startNode = new Node(start, 0, heuristic(start, destination), null);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            closedList.add(currentNode.point);

            // If we reached the destination, return true (valid path found)
            if (currentNode.point.equals(destination)) {
                return true;
            }

            // Check neighbors (8 possible directions)
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    // Skip the center tile (we don't want to check the current node itself)
                    if (dx == 0 && dy == 0) continue;

                    int nx = currentNode.point.getX() + dx;
                    int ny = currentNode.point.getY() + dy;

                    // Ensure the new coordinates are within the bounds of the scene
                    if (nx < 0 || ny < 0 || nx >= 104 || ny >= 104) continue;

                    LocalPoint neighbor = new LocalPoint(nx, ny);
                    Tile tile = tiles[z][nx][ny];
                    int tileSetting = tileSettings[z][nx][ny];

                    // Skip if the tile is not walkable or already evaluated
                    if (tile == null || !isWalkable(tileSetting) || closedList.contains(neighbor)) continue;

                    // Calculate g and h costs
                    int gCost = currentNode.gCost + 1;  // Cost to move to the neighbor
                    int hCost = heuristic(neighbor, destination);

                    Node neighborNode = new Node(neighbor, gCost, hCost, currentNode);
                    openList.add(neighborNode);
                }
            }
        }

        return false;  // No valid path found
    }

    // Heuristic function (Manhattan distance)
    private int heuristic(LocalPoint current, LocalPoint destination) {
        return Math.abs(current.getX() - destination.getX()) + Math.abs(current.getY() - destination.getY());
    }

    // Reconstruct the path from the destination node to the start node
    private List<LocalPoint> reconstructPath(Node destinationNode) {
        List<LocalPoint> path = new ArrayList<>();
        Node currentNode = destinationNode;

        while (currentNode != null) {
            path.add(currentNode.point);
            currentNode = currentNode.parent;
        }

        Collections.reverse(path);  // Reverse the path to get the correct order
        return path;
    }

    // Check if a tile is walkable using the tile settings
    private boolean isWalkable(int tileSetting) {
        // The tileSetting values are typically bitwise flags, check for walkability flags
        // You can modify this as needed based on your tile flags
        // Assuming 0x1280000 is a walkable flag for example (check RuneLite docs for specific values)

        // Example (you may need to adjust the flag check based on the specific walkable flag in RuneLite):
        return (tileSetting & 0x1280000) != 0;
    }
}
