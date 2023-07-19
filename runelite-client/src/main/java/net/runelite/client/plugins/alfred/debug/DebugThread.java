package net.runelite.client.plugins.alfred.debug;


import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.item.RSGroundItem;
import net.runelite.client.plugins.alfred.api.rs.math.Calculations;
import net.runelite.client.plugins.alfred.api.rs.npc.RSNpc;
import net.runelite.client.plugins.alfred.api.rs.player.RSPlayer;
import net.runelite.client.plugins.alfred.api.rs.walk.PathFinder;
import net.runelite.client.plugins.alfred.api.rs.walk.RSTile;
import net.runelite.client.plugins.alfred.device.Keyboard;
import net.runelite.client.plugins.alfred.device.Mouse;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DebugThread extends Thread {

    Mouse mouse = Alfred.getMouse();
    Keyboard keyboard = Alfred.getKeyboard();
    Canvas canvas = Alfred.getClient().getCanvas();

//    public ExecutorService executor = Executors.newFixedThreadPool(100);

    public DebugThread() {
        this.setDaemon(true);
    }


    @Override
    public void run() {
        walkToGEBank();
    }

    public void randomWalk() {
        PathFinder pathFinder = new PathFinder(Alfred.api.walk().getWalkableTiles());
        Alfred.setStatus("Walk randomly in a direction, sleeping for 10 seconds");
        for (int i = 0; i < 10; i++) {
            Alfred.setStatus("Time: " + i);
            Alfred.sleep(1000);
        }


        for (int j = 0; j < 1000; j++) {
            List<RSTile> newTiles = Alfred.api.walk().getWalkableTiles();
            WorldPoint newPoint = pathFinder.getFurthestUnexploredWorldPointFromPlayer(newTiles);
            if (newPoint == null) {
                Alfred.setStatus("No new points to explore, sleeping for 10 seconds");
                for (int i = 0; i < 10; i++) {
                    Alfred.setStatus("Time: " + i);
                    Alfred.sleep(1000);
                }

            } else {

                Alfred.setStatus("Walking to new point: " + newPoint.toString());
                pathFinder.addTiles(newTiles);

                RSPlayer player = Alfred.api.players().getLocalPlayer();
                WorldPoint playerPoint = player.getWorldLocation();

                List<RSTile> pathTiles = pathFinder.getPath(playerPoint, newPoint);

                if (pathTiles != null) {
                    Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 500, 1000 * 10);

                    for (RSTile tile : pathTiles) {
                        int distance = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), tile.getWorldLocation());
                        Point minimapPoint = Alfred.api.miniMap().getWorldPointToScreenPoint(tile.getWorldLocation());

                        if (minimapPoint == null) {
                            continue;
                        }

                        boolean isLastTile = tile.equals(pathTiles.get(pathTiles.size() - 1));

                        if (isLastTile) {
                            Alfred.getMouse().leftClick(minimapPoint);
                            Alfred.sleep(1000);
                            Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 30);

                        } else if (distance < 7) {
                            Alfred.getMouse().leftClick(minimapPoint);
                            Alfred.sleep(1000);
                            Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting() && player.isIdle(), 200, 1000 * 30);

                        } else if (distance >= 7 || tile.isOperable()) {
                            Alfred.getMouse().leftClick(minimapPoint);
                            Alfred.sleep(1000);
                            Alfred.sleepUntil(() -> {
                                int distanceToTarget = (int) Calculations.distanceBetweenPoints(player.getWorldLocation(), tile.getWorldLocation());
                                boolean isStill = !player.isMoving() && !player.isInteracting() && player.isIdle();
                                boolean nearTile = distanceToTarget <= 2;
                                return isStill || nearTile;
                            }, 200, 1000 * 30);
                        }
                    }
                } else {
                    Alfred.setStatus("No path found to new point, sleeping for 10 seconds");
                    for (int i = 0; i < 10; i++) {
                        Alfred.setStatus("Time: " + i);
                        Alfred.sleep(1000);
                    }
                }
            }
        }
    }


//    private void collectWalkableTiles() {
//        Alfred.setStatus("Starting tile collection");
//        int count = 0;
//        while (true) {
//            Runnable worker = new WorldDataCollectorThread(count);
//            executor.execute(worker);
//            Alfred.setStatus("Starting worker: " + count);
//            Alfred.sleep(5000);
//            count++;
//        }
//    }

    private void walkToGEBank() {
        Alfred.setStatus("Starting walker");
        WorldPoint ge = new WorldPoint(3164, 3486, 0);
        WorldPoint geBank = new WorldPoint(3183, 3444, 0);
        WorldPoint lumbridge = new WorldPoint(3122, 3218, 0);
        WorldPoint cows = new WorldPoint(3259, 3267, 0);
        WorldPoint chickens = new WorldPoint(3234, 3294, 0);
        WorldPoint varrockBank = new WorldPoint(3253, 3421, 0);
        WorldPoint edgevilleBank = new WorldPoint(3094, 3495, 0);

//        Alfred.setStatus("Walking to lumbridge");
//        Alfred.api.walk().walkTo(cows);
//        Alfred.sleep(1000);
        Alfred.setStatus("Walking to edgevilleBank");
        Alfred.api.walk().walkTo(edgevilleBank);
    }

    private void chickenKiller() {
        RSPlayer player = Alfred.api.players().getLocalPlayer();

        if (!Alfred.api.combat().isPunchSelected()) {
            Alfred.setStatus("Setting attack to punch");
            Alfred.api.combat().clickPunch();
            Alfred.api.tabs().clickInventoryTab();
        }

        Alfred.setStatus("Dropping any eggs");
        Alfred.api.inventory().dropAll("egg");

        Alfred.setStatus("Dropping any raw chicken");
        Alfred.api.inventory().dropAll("raw chicken");

        Alfred.setStatus("Dropping any bones");
        Alfred.api.inventory().interactAll("bones", "bury");

        while (true) {
            List<RSNpc> chickens = Alfred.api.npcs().getAttackableNpcs("chicken")
                    .stream()
                    .sorted(Comparator.comparingInt(c -> c.getWorldLocation().distanceTo(player.getWorldLocation())))
                    .collect(Collectors.toList());

            RSNpc chicken = chickens.stream().findFirst().orElse(null);

            if (chicken != null) {

                Alfred.setStatus("Looking at chicken");
                Alfred.api.camera().lookAt(chicken.getWorldLocation());
                Alfred.sleep(100);

//                if (Alfred.api.screen().isPointOnScreen(chicken.getWorldLocation())) {
                Alfred.setStatus("Attacking chicken");
                chicken.attack();
                Alfred.sleep(500);

                Alfred.setStatus("Waiting until done attacking chicken");
                Alfred.sleepUntil(() -> !player.isWalking() && !player.isInteracting(), 50, 1000 * 30);
//                }
            }

            Alfred.setStatus("Checking for feathers");
            List<RSGroundItem> items = Alfred.api.items().getItemsFromTiles(15, "feather");

            for (RSGroundItem rsGroundItem : items) {
                Alfred.api.camera().lookAt(rsGroundItem.getWorldLocation());
                Alfred.sleep(100, 150);
                Alfred.setStatus("Taking feather");
                rsGroundItem.clickAction("take");
                Alfred.sleep(500);
                Alfred.sleepUntil(() -> !player.isMoving() && !player.isInteracting(), 50, 1000 * 30);
                Alfred.sleep(1000);
            }

            Alfred.sleep(500);
        }
    }
}