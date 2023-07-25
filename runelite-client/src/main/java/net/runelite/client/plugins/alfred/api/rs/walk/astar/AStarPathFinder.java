package net.runelite.client.plugins.alfred.api.rs.walk.astar;

import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStarPathFinder {
    public static List<AStarNode> path = new ArrayList<>();
    private final AStarNode[][] grid;

    public AStarPathFinder(AStarNode[][] grid) {
        this.grid = grid;
    }

    public List<AStarNode> findPath(WorldPoint startPoint, WorldPoint endPoint) {
        AStarNode startNode = grid[startPoint.getY()][startPoint.getX()];
        AStarNode endNode = grid[endPoint.getY()][endPoint.getX()];

        if (startNode == null || endNode == null) {
            System.out.println("Start or end node is null");
            return new ArrayList<>();
        }

        List<AStarNode> openNodes = new ArrayList<>();
        List<AStarNode> closedNodes = new ArrayList<>();

        openNodes.add(startNode);

        while (!openNodes.isEmpty()) {
            AStarNode currentNode = openNodes.get(0);

            for (AStarNode node : openNodes) {
                if (node.getFCost() < currentNode.getFCost() || node.getFCost() == currentNode.getFCost()) {
                    if (node.getHCost() < currentNode.getHCost()) {
                        currentNode = node;
                    }
                }
            }

            openNodes.remove(currentNode);
            closedNodes.add(currentNode);

            if (currentNode == endNode) {
                path = getPath(startNode, currentNode);
                return path;
            }

            for (AStarNode neighbor : getNeighbors(currentNode)) {
                if (!currentNode.isWalkable(neighbor) || closedNodes.contains(neighbor)) {
                    continue;
                }

                if (neighbor.isBlocked() && !neighbor.getIsOperable()) {
                    continue;
                }

                int newCostToNeighbor = currentNode.getGCost() + getDistance(currentNode, neighbor) + neighbor.getPenalty();
                if (newCostToNeighbor < neighbor.getGCost() || !openNodes.contains(neighbor)) {
                    neighbor.setGCost(newCostToNeighbor);
                    neighbor.setHCost(getDistance(neighbor, endNode));
                    neighbor.setParent(currentNode);

                    if (!openNodes.contains(neighbor)) {
                        openNodes.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    private int getDistance(AStarNode nodeA, AStarNode nodeB) {
        int distanceX = Math.abs(nodeA.getWorldLocation().getX() - nodeB.getWorldLocation().getX());
        int distanceY = Math.abs(nodeA.getWorldLocation().getY() - nodeB.getWorldLocation().getY());

        if (distanceX > distanceY) {
            return 14 * distanceY + 10 * (distanceX - distanceY);
        }

        return 14 * distanceX + 10 * (distanceY - distanceX);
    }


    private List<AStarNode> getNeighbors(AStarNode node) {
        List<AStarNode> neighbors = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                int checkX = node.getWorldLocation().getX() + x;
                int checkY = node.getWorldLocation().getY() + y;

                if (checkX >= 0 && checkX < grid[0].length && checkY >= 0 && checkY < grid.length) {
                    AStarNode neighbor = grid[checkY][checkX];
                    if (neighbor != null) {
                        neighbors.add(grid[checkY][checkX]);
                    }
                }
            }
        }

        return neighbors;
    }

    private List<AStarNode> getPath(AStarNode startNode, AStarNode endNode) {
        List<AStarNode> path = new ArrayList<>();
        AStarNode currentNode = endNode;

        while (currentNode != startNode) {
            path.add(currentNode);
            currentNode = currentNode.getParent();
        }

        Collections.reverse(path);
        return path;
    }
}
