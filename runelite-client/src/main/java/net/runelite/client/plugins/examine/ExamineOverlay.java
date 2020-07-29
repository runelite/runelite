package net.runelite.client.plugins.examine;

import net.runelite.api.Point;
import net.runelite.api.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.examinebox.ExamineBox;
import net.runelite.client.ui.overlay.examinebox.ExamineBoxManager;

import javax.inject.Inject;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Deque;
import java.util.List;

import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;

public class ExamineOverlay extends Overlay
{
    private final Client client;
    private final ExaminePlugin examinePlugin;
    private final ExamineBoxManager examineBoxManager;
    private final int EXAMINE_DURATION = 3;
    @Inject
    public ExamineOverlay(Client client, ExaminePlugin examinePlugin, ExamineBoxManager examineBoxManager){
        this.client = client;
        this.examinePlugin = examinePlugin;
        this.examineBoxManager = examineBoxManager;
    }

    void renderInventoryExamine(int widgetId, int actionParam, String message){
        int widgetGroup = TO_GROUP(widgetId);
        int widgetChild = TO_CHILD(widgetId);

        Widget widget = client.getWidget(widgetGroup, widgetChild);
        if(widget!= null){
            WidgetItem widgetItem = widget.getWidgetItem(actionParam);
            if(widgetItem != null){
                Rectangle slotBounds = widgetItem.getCanvasBounds();
                examineBoxManager.setExamineBox(new ExamineBox(message,(int)slotBounds.getX(),(int)slotBounds.getHeight() + (int)slotBounds.getY()));
            }
        }
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Deque<ProcessedExamine> processedExamine = examinePlugin.getProcessedExamine();
        if(!processedExamine.isEmpty()){
            ProcessedExamine examine = processedExamine.peek();
            Duration timeDiff = Duration.between(examine.getCreated(), Instant.now());
            if (timeDiff.compareTo(Duration.ofSeconds(EXAMINE_DURATION)) < 0 && processedExamine.size() == 1)
            {
               ExamineType type = examine.getType();
               switch (type){
                   case NPC:
                       final NPC[] cachedNPCs = client.getCachedNPCs();
                       final NPC npc = cachedNPCs[examine.getId()];
                       Shape objectClickbox = Perspective.getClickbox(client,npc.getModel(),npc.getOrientation(),npc.getLocalLocation());
                       Rectangle box = objectClickbox.getBounds();
                       examineBoxManager.setExamineBox(new ExamineBox(examine.getMessage(),(int)box.getX(),(int)box.getY()));
                       break;
                   case ITEM:
                       renderInventoryExamine(examine.getWidgetId(),examine.getActionParam(),examine.getMessage());
                       break;
                   case ITEM_BANK_EQ:
                       final Widget bankItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
                       if(bankItemContainer!=null){
                           Widget[] bankItemContainerChildren = bankItemContainer.getChildren();
                           if(bankItemContainerChildren!=null){
                               for(Widget child: bankItemContainerChildren){
                                   if (child != null && !child.isSelfHidden() && child.getItemId() > -1 && child.getItemId() == examine.getId())
                                   {
                                       examineBoxManager.setExamineBox(new ExamineBox(examine.getMessage() ,(int)child.getBounds().getX(),(int)child.getBounds().getY()));
                                   }
                               }
                           }

                           Widget w = client.getWidget(TO_GROUP(examine.getWidgetId()), TO_CHILD(examine.getWidgetId()));
                           if(w!= null){
                               Widget widgetItem = w.getChild(examine.getActionParam());
                               if(widgetItem != null){
                                   Rectangle slotBounds = widgetItem.getBounds();
                                   examineBoxManager.setExamineBox(new ExamineBox(examine.getMessage(),(int)slotBounds.getX(),(int)slotBounds.getHeight() + (int)slotBounds.getY()));
                               }
                           }
                       }
                       break;
                   case ITEM_GROUND:
                   case OBJECT:
                       for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
                        for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
                            Scene scene = client.getScene();
                            Tile[][][] tiles = scene.getTiles();
                            int z = client.getPlane();
                            Tile tile = tiles[z][x][y];

                            if(examine.getActionParam() == x && examine.getWidgetId() == y ){
                                switch (type){
                                    case ITEM_GROUND:
                                        List<TileItem> groundItems = tile.getGroundItems();
                                        if(groundItems!=null && !groundItems.isEmpty()){
                                            for(TileItem tileItem: groundItems){
                                                if(tileItem!=null){
                                                    if(examine.getId() == tileItem.getId()){
                                                        Point point = Perspective.localToCanvas(client,tile.getLocalLocation(),tile.getPlane());
                                                        examineBoxManager.setExamineBox(new ExamineBox(examine.getMessage(),point.getX(),point.getY()));
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case OBJECT:

                                    GameObject[] gameObjects = tile.getGameObjects();
                                    if (gameObjects != null) {
                                        for (GameObject gameObject : gameObjects)
                                        {
                                            if (gameObject != null)
                                            {
                                                if(examine.getId() == gameObject.getId()){
                                                    Shape convexHull = gameObject.getConvexHull();
                                                    examineBoxManager.setExamineBox(new ExamineBox(examine.getMessage(),(int)convexHull.getBounds().getX(),(int)convexHull.getBounds().getY()));

                                                }
                                            }
                                        }
                                    }
                                        break;
                                }
                            }

                        }
                      }
                       break;
               }
            } else {
                processedExamine.pop();
            }

        }

        return null;
    }


    private TileObject findTileObject(Tile tile, int id)
    {
        if (tile == null)
        {
            return null;
        }

        final GameObject[] tileGameObjects = tile.getGameObjects();
        final DecorativeObject tileDecorativeObject = tile.getDecorativeObject();
        final WallObject tileWallObject = tile.getWallObject();
        final GroundObject groundObject = tile.getGroundObject();

        if (objectIdEquals(tileWallObject, id))
        {
            return tileWallObject;
        }

        if (objectIdEquals(tileDecorativeObject, id))
        {
            return tileDecorativeObject;
        }

        if (objectIdEquals(groundObject, id))
        {
            return groundObject;
        }

        for (GameObject object : tileGameObjects)
        {
            if (objectIdEquals(object, id))
            {
                return object;
            }
        }

        return null;
    }

    private boolean objectIdEquals(TileObject tileObject, int id)
    {
        if (tileObject == null)
        {
            return false;
        }

        if (tileObject.getId() == id)
        {
            return true;
        }

        // Menu action EXAMINE_OBJECT sends the transformed object id, not the base id, unlike
        // all of the GAME_OBJECT_OPTION actions, so check the id against the impostor ids
        final ObjectComposition comp = client.getObjectDefinition(tileObject.getId());

        if (comp.getImpostorIds() != null)
        {
            for (int impostorId : comp.getImpostorIds())
            {
                if (impostorId == id)
                {
                    return true;
                }
            }
        }

        return false;
    }

}
