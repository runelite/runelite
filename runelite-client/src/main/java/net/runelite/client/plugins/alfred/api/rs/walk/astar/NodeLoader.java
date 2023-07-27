package net.runelite.client.plugins.alfred.api.rs.walk.astar;

import net.runelite.api.coords.WorldPoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NodeLoader {
    private String path;

    public NodeLoader(String path) {
        this.path = path;
    }

    private List<AStarNode> read() {
        List<AStarNode> nodes = new ArrayList<>();
        String url = "jdbc:sqlite:" + path;

        try {
//            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tiles_tile;");

            while (rs.next()) {
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                int z = rs.getInt("z");
                boolean isOperable = rs.getBoolean("is_operable");
                boolean blocked = rs.getBoolean("blocked");
                boolean blockedMovementNorth = rs.getBoolean("blocked_movement_north");
                boolean blockedMovementSouth = rs.getBoolean("blocked_movement_south");
                boolean blockedMovementEast = rs.getBoolean("blocked_movement_east");
                boolean blockedMovementWest = rs.getBoolean("blocked_movement_west");
                boolean blockedMovementNorthEast = rs.getBoolean("blocked_movement_north_east");
                boolean blockedMovementNorthWest = rs.getBoolean("blocked_movement_north_west");
                boolean blockedMovementSouthEast = rs.getBoolean("blocked_movement_south_east");
                boolean blockedMovementSouthWest = rs.getBoolean("blocked_movement_south_west");
                boolean blockedMovementObject = rs.getBoolean("blocked_movement_object");
                boolean blockedMovementFloorDecoration = rs.getBoolean("blocked_movement_floor_decoration");
                boolean blockedMovementFloor = rs.getBoolean("blocked_movement_floor");
                boolean blockedMovementFull = rs.getBoolean("blocked_movement_full");
                int penalty = rs.getInt("penalty");

                AStarNode node = new AStarNode();
                node.setWorldLocation(new WorldPoint(x, y, z));
                node.setIsOperable(isOperable);
                node.setBlocked(blocked);
                node.setBlockedMovementNorth(blockedMovementNorth);
                node.setBlockedMovementSouth(blockedMovementSouth);
                node.setBlockedMovementEast(blockedMovementEast);
                node.setBlockedMovementWest(blockedMovementWest);
                node.setBlockedMovementNorthEast(blockedMovementNorthEast);
                node.setBlockedMovementNorthWest(blockedMovementNorthWest);
                node.setBlockedMovementSouthEast(blockedMovementSouthEast);
                node.setBlockedMovementSouthWest(blockedMovementSouthWest);
                node.setBlockedMovementObject(blockedMovementObject);
                node.setBlockedMovementFloorDecoration(blockedMovementFloorDecoration);
                node.setBlockedMovementFloor(blockedMovementFloor);
                node.setBlockedMovementFull(blockedMovementFull);
                node.setPenalty(penalty);

                nodes.add(node);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nodes;
    }

    public AStarNode[][] getGrid() {
        List<AStarNode> nodes = read();
        int maxX = nodes.stream().mapToInt(node -> node.getWorldLocation().getX()).max().getAsInt();
        int maxY = nodes.stream().mapToInt(node -> node.getWorldLocation().getY()).max().getAsInt();
        int minX = nodes.stream().mapToInt(node -> node.getWorldLocation().getX()).min().getAsInt();
        int minY = nodes.stream().mapToInt(node -> node.getWorldLocation().getY()).min().getAsInt();

        AStarNode[][] grid = new AStarNode[maxY + 1][maxX + 1];

        for (AStarNode node : nodes) {
            int x = node.getWorldLocation().getX();
            int y = node.getWorldLocation().getY();
            grid[y][x] = node;
        }

        return grid;
    }
}
