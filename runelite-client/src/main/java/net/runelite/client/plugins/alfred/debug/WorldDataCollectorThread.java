package net.runelite.client.plugins.alfred.debug;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.walk.RSTile;
import net.runelite.client.plugins.alfred.api.rs.walk.RSWalkableTile;
import net.runelite.client.plugins.alfred.api.rs.walk.WorldMovementFlag;

import java.io.FileWriter;
import java.io.IOException;

public class WorldDataCollectorThread implements Runnable {

    private int num;
    public WorldDataCollectorThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        JsonArray tiles = new JsonArray();
        for (RSTile rsWalkableTile : Alfred.api.walk().getWalkableTiles()) {
            JsonObject tileRow = new JsonObject();

            tileRow.addProperty("x", rsWalkableTile.getWorldLocation().getX());
            tileRow.addProperty("y", rsWalkableTile.getWorldLocation().getY());
            tileRow.addProperty("plane", rsWalkableTile.getWorldLocation().getPlane());
            tileRow.addProperty("isOperable", rsWalkableTile.isOperable());

            JsonArray movementFlags = new JsonArray();
            for (WorldMovementFlag worldMovementFlag : Alfred.api.walk().getMovementFlagsForTile(((RSWalkableTile) rsWalkableTile).getTile())) {
                movementFlags.add(worldMovementFlag.toString());
            }

            tileRow.add("movementFlags", movementFlags);
            tiles.add(tileRow);
        }

        if (tiles.size() > 0) {
            try {
                String path = "/home/griffin/PycharmProjects/runlitebot/tiles/data/";
                String name = System.currentTimeMillis() + ".json";
                FileWriter myWriter = new FileWriter(path + name);
                myWriter.write(tiles.toString());
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + num + " finished");
    }
}
