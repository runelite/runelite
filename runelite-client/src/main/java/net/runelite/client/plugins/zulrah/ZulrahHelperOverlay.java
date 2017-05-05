package net.runelite.client.plugins.zulrah;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.zulrah.patterns.*;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import java.awt.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;


/**
 * Created by aria on 5/5/17.
 */
public class ZulrahHelperOverlay extends Overlay {
    private Client client = RuneLite.getClient();

   private int hp = 500;
   private Point startTile;
   private int index = 0;
   private int currentPattern = -1;
   private ZulrahInstance previousInstance;
   private ZulrahInstance currentInstance;
   private ZulrahPattern[] patterns;
   private NPC zulrah = null; //Potential race condition, symptoms might be flickering overlay

    ZulrahHelperOverlay() {
        super(OverlayPosition.DYNAMIC);

        patterns = new ZulrahPattern[4];
        patterns[0] = new ZulrahPatternA(client);
        patterns[1] = new ZulrahPatternB(client);
        patterns[2] = new ZulrahPatternC(client);
        patterns[3] = new ZulrahPatternD(client);
    }

    @Override
    public Dimension render(Graphics2D graphics) {


        if(client.getGameState() != GameState.LOGGED_IN || startTile == null || zulrah == null) return null;

        graphics.setColor(Color.WHITE);
        graphics.drawString(hp + "/500", 5, 40);

        if(currentPattern == -1) {
            graphics.drawString("Unknown", 200, 200);
            graphics.drawString("current: " + currentInstance, 200, 215);
            graphics.drawString("Previous:" + previousInstance, 200, 230);
            graphics.drawString("index: " + index, 200, 245);
        } else {
            patterns[currentPattern].render(graphics, startTile, index);
        }


        return null;
    }

    void update()
    {
        try {
            NPC[] npcs = client.getNpcs();
            zulrah = null;
            for (NPC npc : npcs) {
                if (npc == null) continue;
                if (npc.getName().equals("Zulrah")) {
                    zulrah = npc;
                    break;
                }
            }

            if (zulrah == null)
            {
                if(startTile != null) {
                    startTile = null;
                    System.out.println("SET START TILE TO NULL");
                }
                return;
            }

            hp = zulrah.getHealth();

            // Just entered
            if (startTile == null || zulrah.getLocalLocation().distanceTo(startTile) > 17000) {
                if(startTile != null) {
                    System.out.println("ZULRAH DISATANCE: " + zulrah.getLocalLocation().distanceTo(startTile));
                }
                startTile = zulrah.getLocalLocation();
                startTile = Perspective.localToWorld(client, startTile);
                index = 0;
                currentPattern = -1;
                System.out.println("Start Tile: " + startTile.toString());
                previousInstance = null;
                currentInstance = null;
            }

            ZulrahInstance temp = new ZulrahInstance(zulrah, startTile);

            if (currentInstance == null) {
                System.out.println("currentInstance set to temp");
                currentInstance = temp;
            }

            if (!currentInstance.equals(temp)) {
                previousInstance = currentInstance;
                currentInstance = temp;
                ++index;
            }

            if (currentPattern == -1) {
                int potential = 0;
                int potentialPattern = -1;

                for (int i = 0; i < patterns.length; ++i) {
                    if (patterns[i].accept(index, currentInstance)) {
                        //System.out.println("PATTERN POTENTIAL: " + i);
                        potential++;
                        potentialPattern = i;
                    }
                }
                if (potential == 1) {
                    currentPattern = potentialPattern;
                }
            } else {
                if (patterns[currentPattern].canReset(index)) {
                    if (currentInstance.equals(patterns[currentPattern].get(0))) {
                        currentPattern = -1;
                        index = 0;
                    }
                }
            }

        } catch(NullPointerException e) {
            //I'm so sorry
            e.printStackTrace();;
        }

    }
}
