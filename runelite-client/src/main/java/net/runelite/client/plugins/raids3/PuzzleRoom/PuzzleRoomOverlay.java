package net.runelite.client.plugins.raids3.PuzzleRoom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Iterator;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Raids3Plugin;
import net.runelite.client.plugins.raids3.TOA_Rooms;
import net.runelite.client.plugins.raids3Util.OverlayUtility;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

public class PuzzleRoomOverlay extends Overlay {
  private final Raids3Config config;
  private final Raids3Plugin plugin;
  private final ModelOutlineRenderer modelOutlineRenderer;
  private final Client client;

  @Inject
  private PuzzleRoomOverlay(Client client, Raids3Plugin plugin, Raids3Config config, ModelOutlineRenderer modelOutlineRenderer) {
    this.plugin = plugin;
    this.config = config;
    this.client = client;
    this.modelOutlineRenderer = modelOutlineRenderer;
    this.setPosition(OverlayPosition.DYNAMIC);
    this.setLayer(OverlayLayer.ABOVE_SCENE);
    this.setPriority(OverlayPriority.HIGH);
  }

  public Dimension render(Graphics2D graphics) {
    if (this.plugin.currentRoom != TOA_Rooms.PUZZLE_ROOM) {
      return null;
    } else {
      this.renderTarget(graphics);
      return null;
    }
  }

  private void renderTarget(Graphics2D graphics) {
    this.HandleSimonSaysPuzzle(graphics);
    this.HandleFloorNumberPuzzle(graphics);
    this.HandleMemoryTilePuzzle(graphics);
  }

  private void HandleMemoryTilePuzzle(Graphics2D graphics) {
    if (this.plugin.puzzleRoom.memoryTiles.size() != 0) {
      LocalPoint localLocation2;
      Color color;
      for(Iterator var2 = this.plugin.puzzleRoom.memoryTiles.iterator(); var2.hasNext(); this.renderTile(graphics, localLocation2, color, 1.0D, OverlayUtility.MakeTransparent(color, 50))) {
        GroundObject groundObject = (GroundObject)var2.next();
        localLocation2 = LocalPoint.fromScene(groundObject.getLocalLocation().getSceneX(), groundObject.getLocalLocation().getSceneY());
        color = Color.GREEN;
        switch(groundObject.getId()) {
          case 45357:
            color = Color.GREEN;
          case 45358:
          case 45360:
          case 45362:
          default:
            break;
          case 45359:
            color = Color.MAGENTA;
            break;
          case 45361:
            color = Color.YELLOW;
            break;
          case 45363:
            color = Color.RED;
            break;
          case 45364:
            color = Color.BLUE;
        }
      }

    }
  }

  private void HandleSimonSaysPuzzle(Graphics2D graphics) {
    if (this.plugin.puzzleRoom.simonSaysTiles != null && this.plugin.puzzleRoom.simonSaysTiles.size() != 0) {
      if (this.plugin.puzzleRoom.simonSaysTileIndex < this.plugin.puzzleRoom.simonSaysTiles.size()) {
        for(int i = this.plugin.puzzleRoom.simonSaysTiles.size() - 1; i >= this.plugin.puzzleRoom.simonSaysTileIndex; --i) {
          Point point = ((SimonSaysTile)this.plugin.puzzleRoom.simonSaysTiles.get(i)).scenePoint;
          LocalPoint localLocation2 = LocalPoint.fromScene(point.getX(), point.getY());
          Color color = this.config.NextTileColor();
          if (i == this.plugin.puzzleRoom.simonSaysTileIndex) {
            color = this.config.TileColor();
          }

          OverlayUtil.renderTileOverlay(graphics, ((SimonSaysTile)this.plugin.puzzleRoom.simonSaysTiles.get(i)).tileObject, "" + (i + 1), color);
        }

      }
    }
  }

  public void HandleFloorNumberPuzzle(Graphics2D graphics) {
    if (this.plugin.puzzleRoom.floorNumberSymbols != null) {
      Iterator var2 = this.plugin.puzzleRoom.floorNumberSymbols.iterator();

      while(var2.hasNext()) {
        Point point = (Point)var2.next();
        LocalPoint localLocation2 = LocalPoint.fromScene(point.getX(), point.getY());
        this.renderTile(graphics, localLocation2, this.config.TileColor(), 1.0D, OverlayUtility.MakeTransparent(this.config.TileColor(), 50));
      }
    }

  }

  private void renderTile(Graphics2D graphics, LocalPoint dest, Color color, double borderWidth, Color fillColor) {
    if (dest != null) {
      Polygon poly = Perspective.getCanvasTilePoly(this.client, dest);
      if (poly != null) {
        OverlayUtil.renderPolygon(graphics, poly, color, fillColor, new BasicStroke((float)borderWidth));
      }
    }
  }

  private void LabelTile(Graphics2D graphics, LocalPoint localPoint, String text) {
    Point canvasTextLocation = Perspective.getCanvasTextLocation(this.client, graphics, localPoint, text, this.client.getPlane());
    OverlayUtil.renderTextLocation(graphics, canvasTextLocation, text, Color.white);
  }
}
