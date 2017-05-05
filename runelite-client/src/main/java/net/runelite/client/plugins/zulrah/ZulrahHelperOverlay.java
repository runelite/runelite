package net.runelite.client.plugins.zulrah;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import sun.nio.cs.ext.MacGreek;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aria on 5/3/17.
 */
public class ZulrahHelperOverlay extends Overlay{

    private List<List<StageData>> patterns = new LinkedList<>();

    private final Point BOTTOM_LEFT = new Point(7232, 7872);
    private final Point TOP_LEFT = new Point(7232, 8000);
    private final Point TOP_RIGHT = new Point(6208, 7232);
    private final Point BOTTOM_RIGHT = new Point(6208, 8000);
    private final Point MIDDLE = new Point(6720, 6848);

    private final int ID_RANGED = 2042;
    private final int ID_MELEE = 2043;
    private final int ID_MAGIC = 2044;

    private int currentPattern = 0;
    private int currentStage = 0;
    private final Client client = RuneLite.getClient();

    ZulrahHelperOverlay()
    {
        super(OverlayPosition.DYNAMIC);

        // First Pattern
        List<StageData> patternOne = new LinkedList<>();
        patternOne.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, BOTTOM_LEFT));
        patternOne.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, TOP_LEFT));
        patternOne.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternOne.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternOne.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternOne.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternOne.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, null));
        patternOne.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternOne.add(new StageData(ID_RANGED, JadSwitch.RANGEDFIRST, BOTTOM_RIGHT));
        patternOne.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, BOTTOM_LEFT));

        patterns.add(patternOne);

        List<StageData> patternTwo = new LinkedList<>();
        patternTwo.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, BOTTOM_LEFT));
        patternTwo.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, TOP_LEFT));
        patternTwo.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternTwo.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternTwo.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternTwo.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternTwo.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, null));
        patternTwo.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternTwo.add(new StageData(ID_RANGED, JadSwitch.RANGEDFIRST, null));
        patternTwo.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, BOTTOM_RIGHT));

        patterns.add(patternTwo);
        
        List<StageData> patternThree = new LinkedList<>();
        patternThree.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, BOTTOM_LEFT));
        patternThree.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, new Point(7488, 7872)));
        patternThree.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, new Point(6208, 7872)));
        patternThree.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(6208, 7872)));
        patternThree.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, new Point(6720, 6848)));
        patternThree.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(6720, 6848)));
        patternThree.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternThree.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternThree.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(7232, 7232)));
        patternThree.add(new StageData(ID_RANGED, JadSwitch.MAGICFIRST, new Point(7232, 7232)));
        patternThree.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(7232, 7232)));

        patterns.add(patternThree);


        List<StageData> patternFour = new LinkedList<>();
        patternFour.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, BOTTOM_LEFT));
        patternFour.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(7488, 7872)));
        patternFour.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternFour.add(new StageData(ID_MAGIC,JadSwitch.NOSWITCH, TOP_RIGHT));
        patternFour.add(new StageData(ID_MELEE, JadSwitch.NOSWITCH, new Point(7232, 7232)));
        patternFour.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, new Point(7232, 7232)));
        patternFour.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternFour.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, TOP_RIGHT));
        patternFour.add(new StageData(ID_RANGED, JadSwitch.NOSWITCH, new Point(7232, 7232)));
        patternFour.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(7232, 7232)));
        patternFour.add(new StageData(ID_RANGED, JadSwitch.MAGICFIRST, new Point(7232, 7232)));
        patternFour.add(new StageData(ID_MAGIC, JadSwitch.NOSWITCH, new Point(7232, 7232)));

        patterns.add(patternFour);


    }
    @Override
    public Dimension render(Graphics2D graphics) {
        if(client.getGameState() != GameState.LOGGED_IN) return null;

        boolean isInShrine = false;

        for (NPC npc : client.getNpcs())
        {
            if(npc == null) continue;
            int npcId = npc.getId();
            if(npcId >= ID_RANGED && npcId <= ID_MAGIC)
            {
                isInShrine = true;

                if(currentPattern == 0) //No pattern yet
                {
                    List<Integer> possiblePatterns = new LinkedList<>();

                    for(List<StageData> list : patterns)
                    {
                        //No stage assigned yet
                        if(currentStage == 0) {
                            for(List<StageData> list2 : patterns)
                            {
                                StageData tempStageData = list2.get(currentStage);
                                if(list.get(currentStage).id != tempStageData.id) {
                                    currentStage = 1;
                                    break;
                                }
                            }
                        }
                        //Stage matches up and shit
                        if(list.get(currentStage).id == npcId)
                        {
                            //DEBUG
                            System.out.printf("Added pattern: %d Current stage: %d\n", patterns.indexOf(list), currentStage);
                            possiblePatterns.add(patterns.indexOf(list));
                        }
                    }

                    if(possiblePatterns.size() == 1) {
                        //There's only one possible, duh that must be it
                        currentPattern = possiblePatterns.get(0);
                        //DEBUG
                        System.out.printf("Current pattern set to %d because size was only 1.", currentPattern);
                    } else if(possiblePatterns.size() > 1) {
                        boolean same = true;
                        StageData firstStageData = patterns.get(possiblePatterns.get(0)).get(currentStage);
                        for(int possiblePattern : possiblePatterns) {
                            StageData tempStageData = patterns.get(possiblePatterns.get(possiblePattern)).get(currentStage);
                            //DEBUG
                            System.out.printf("temp: %d first: %d\n", tempStageData.id, firstStageData.id);
                            if(tempStageData.id != firstStageData.id) same = false;
                        }
                        if (same) {
                            //Could be possibility of 2, next decider is stage 4 so lets wait for that
                            //DEBUG
                            System.out.printf("Same = true, so we're waiting.\n");
                            drawIndicators(graphics, firstStageData);
                            if(currentStage != 0) {
                                StageData stageData = patterns.get(possiblePatterns.get(0)).get(currentStage + 1);
                                renderTileOverlay(graphics, getTile(stageData.safeSpot), new Color(144,195,212,100));
                            }
                        }
                    } else if(possiblePatterns.size() == 0) {
                        //uh
                        //DEBUG
                        System.out.println("@@@@@ Possible patterns is 0");
                        currentStage++;
                    }
                } else {
                    graphics.setColor(Color.BLACK);
                    graphics.drawString("Pattern: " + (currentPattern + 1), client.getCanvas().getWidth() / 2 - 60, 50);

                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Pattern: " + (currentPattern + 1), client.getCanvas().getWidth() / 2 - 61, 51);

                    graphics.setColor(Color.BLACK);
                    graphics.drawString("Stage: " + (currentStage + 1), client.getCanvas().getWidth() / 2 - 50, 70);

                    graphics.setColor(Color.WHITE);
                    graphics.drawString("Stage: " + (currentStage + 1), client.getCanvas().getWidth() / 2 - 51, 71);


                    List<StageData> stageDatas = patterns.get(currentPattern);
                    if(currentStage >= stageDatas.size())
                    {
                        //Reset the stuff because you didnt kill it in 1 rotation
                        currentStage = currentPattern = 0;
                    } else {
                        if(stageDatas.get(currentStage).id != npcId)
                        {
                            for(int i = currentStage; i < stageDatas.size(); ++i)
                            {
                                if(stageDatas.get(i).id == npcId)
                                {
                                    currentStage = i;
                                    break;
                                }
                            }
                        }
                    }

                    //TODO: Draw stage data - Tile overlays, etc
                    drawIndicators(graphics, stageDatas.get(currentStage));
                    if (currentStage < stageDatas.size() - 1)
                    {
                        StageData stageData = stageDatas.get(currentStage + 1);
                        renderTileOverlay(graphics, stageData.safeSpot, new Color(144, 195, 212, 100));
                        //TODO: Optionally draw "Next Magic/Ranged First" on the tile for jad
                    } else {
                        StageData stageData = stageDatas.get(0);
                        renderTileOverlay(graphics, stageData.safeSpot, new Color(144, 195, 212, 100));

                    }

                }
            }
        }
        Player local = client.getLocalPlayer();
        if (!isInShrine && local.getLocalLocation().distanceTo(TOP_RIGHT) > 1000)
        {
            currentPattern = 0;
            currentStage = 0;
        }


        return null;
    }

    private void drawIndicators(Graphics2D graphics, StageData stageData) {
        renderTileOverlay(graphics, getTile(stageData.safeSpot), Color.RED);

        if(stageData.id == ID_MAGIC)
        {
            graphics.setColor(Color.BLACK);
            graphics.drawString("Use Ranged", client.getCanvas().getWidth() / 2 - 60, client.getCanvas().getHeight() / 2 - 80);

            graphics.setColor(Color.WHITE);
            graphics.drawString("Use Ranged", client.getCanvas().getWidth() / 2 - 61, client.getCanvas().getHeight() / 2 - 81);
        }

        JadSwitch switchStatus = stageData.switchStatus;
        switch (switchStatus)
        {
            case RANGEDFIRST:
                graphics.setColor(Color.BLACK);
                graphics.drawString("Ranged > Magic", client.getCanvas().getWidth() / 2 - 70, client.getCanvas().getHeight() / 2 - 100);

                graphics.setColor(Color.WHITE);
                graphics.drawString("Ranged > Magic", client.getCanvas().getWidth() / 2 - 71, client.getCanvas().getHeight() / 2 - 101);

                break;
            case MAGICFIRST:
                graphics.setColor(Color.BLACK);
                graphics.drawString("Magic > Ranged", client.getCanvas().getWidth() / 2 - 70, client.getCanvas().getHeight() / 2 - 100);
                graphics.setColor(Color.WHITE);
                graphics.drawString("Magic > Ranged", client.getCanvas().getWidth() / 2 - 71, client.getCanvas().getHeight() / 2 - 101);
                break;
            case NOSWITCH:
                switch (stageData.id)
                {
                    case ID_RANGED:
                        graphics.setColor(Color.BLACK);
                        graphics.drawString("Ranged", client.getCanvas().getWidth() / 2 - 43, client.getCanvas().getHeight() / 2 - 100);
                        graphics.setColor(Color.WHITE);
                        graphics.drawString("Ranged", client.getCanvas().getWidth() / 2 - 44, client.getCanvas().getHeight() / 2 - 101);
                        //TODO: Prayers
                        break;
                    case ID_MAGIC:
                        graphics.setColor(Color.BLACK);
                        graphics.drawString("Magic", client.getCanvas().getWidth() / 2 - 43, client.getCanvas().getHeight() / 2 - 100);
                        graphics.setColor(Color.WHITE);
                        graphics.drawString("Magic", client.getCanvas().getWidth() / 2 - 44, client.getCanvas().getHeight() / 2 - 101);

                        //TODO: Prayers
                        break;
                }
                break;
        }
    }

    private Point getTile(Point worldPoint)
    {
        return Perspective.worldToLocal(client, worldPoint);
    }
    private void renderTileOverlay(Graphics2D graphics, Point tile, Color color) {
        Polygon poly =  Perspective.getCanvasTilePoly(client, tile);
        if (poly != null) {
            graphics.setColor(color);
            graphics.setStroke(new BasicStroke(2));
            graphics.drawPolygon(poly);
            graphics.setColor(new Color(0, 0, 0, 50));
            graphics.fillPolygon(poly);
        }
    }
    private class StageData
    {
        int id;
        JadSwitch switchStatus;
        Point safeSpot;

        StageData(int id, JadSwitch switchStatus, Point safeSpot)
        {
            this.id = id;
            this.switchStatus = switchStatus;
            this.safeSpot = safeSpot;
        }
    }

    private enum JadSwitch
    {
        RANGEDFIRST,
        MAGICFIRST,
        NOSWITCH
    }
}
