package net.runelite.client.plugins.alfred.api.rs.walk;

import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {

    public static List<RSTile> path = new ArrayList<>();

    private final List<RSTile> walkableTiles;

    public PathFinder(List<RSTile> walkableTiles) {
        this.walkableTiles = walkableTiles;
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


}
