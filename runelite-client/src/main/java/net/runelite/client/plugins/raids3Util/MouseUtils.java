package net.runelite.client.plugins.raids3Util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class MouseUtils {
  private static final Logger log = LoggerFactory.getLogger(MouseUtils.class);
  private static final int MOUSE_ENTERED = 504;
  private static final int MOUSE_PRESSED = 501;
  public static final int MOUSE_RELEASED = 502;
  public static final int MOUSE_CLICKED = 500;
  public static final int MOUSE_EXITED = 505;
  public static final int MOUSE_MOVED = 503;
  @Inject
  private Client client;
  @Inject
  private CalculationUtils calc;
  @Inject
  public KeyboardUtils keyboardUtils;
  @Inject
  private ConfigManager configManager;

  private void mouseEvent(int id, Point point) {
    long currentTime = System.currentTimeMillis();
    OneUpUtilityPlugin.mouseEventTimes.add(currentTime);
    MouseEvent e = new MouseEvent(this.client.getCanvas(), id, currentTime, 0, point.getX(), point.getY(), 1, false, 1);
    this.client.getCanvas().dispatchEvent(e);
  }

  public void click(Rectangle rectangle) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      Point point = this.getClickPoint(rectangle);
      this.click(point);
    }
  }

  public void click(Point p) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      OneUpUtilityPlugin.isMouseLocked = true;
      if (this.client.isStretchedEnabled()) {
        Dimension stretched = this.client.getStretchedDimensions();
        Dimension real = this.client.getRealDimensions();
        double width = (double)stretched.width / real.getWidth();
        double height = (double)stretched.height / real.getHeight();
        Point point = new Point((int)((double)p.getX() * width), (int)((double)p.getY() * height));
        this.mouseEvent(503, point);
        this.mouseEvent(501, point);
        this.mouseEvent(502, point);
        this.mouseEvent(500, point);
      } else {
        this.mouseEvent(503, p);
        this.mouseEvent(501, p);
        this.mouseEvent(502, p);
        this.mouseEvent(500, p);
      }
    }
  }

  public void click(Point p, Point returnPoint) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      OneUpUtilityPlugin.isMouseLocked = true;
      if (this.client.isStretchedEnabled()) {
        Dimension stretched = this.client.getStretchedDimensions();
        Dimension real = this.client.getRealDimensions();
        double width = (double)stretched.width / real.getWidth();
        double height = (double)stretched.height / real.getHeight();
        Point point = new Point((int)((double)p.getX() * width), (int)((double)p.getY() * height));
        this.mouseEvent(503, point);
        this.mouseEvent(501, point);
        this.mouseEvent(502, point);
        this.mouseEvent(500, point);
        Thread thread = new Thread(() -> {
          while(OneUpUtilityPlugin.isMouseLocked) {
            try {
              Thread.sleep(10L);
            } catch (InterruptedException var3) {
              var3.printStackTrace();
            }
          }

          System.out.println("Return to original position");
          this.mouseEvent(503, returnPoint);
        });
        thread.start();
      } else {
        this.mouseEvent(503, p);
        this.mouseEvent(501, p);
        this.mouseEvent(502, p);
        this.mouseEvent(500, p);
        Thread thread = new Thread(() -> {
          while(OneUpUtilityPlugin.isMouseLocked) {
            try {
              Thread.sleep(10L);
            } catch (InterruptedException var3) {
              var3.printStackTrace();
            }
          }

          System.out.println("Return to original position");
          this.mouseEvent(503, returnPoint);
        });
        thread.start();
      }
    }
  }

  public void moveMouse(Rectangle rectangle) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      Point point = this.getClickPoint(rectangle);
      this.moveMouse(point);
    }
  }

  public void TurnOnPrayerIfNotOn(Prayer prayer) {
    boolean isPrayerActive = this.client.isPrayerActive(prayer);
    if (!isPrayerActive) {
      this.TogglePrayer(prayer);
    }

  }

  private boolean NoPrayerPoints() {
    return this.client.getBoostedSkillLevel(Skill.PRAYER) == 0;
  }

  public void TogglePrayer(Prayer prayer) {
    if (!this.NoPrayerPoints()) {
      if (!OneUpUtilityPlugin.isMouseLocked) {
        if (!this.IsPrayerOpen()) {
          this.keyboardUtils.pressKey(((OneUpUtilityConfig)this.configManager.getConfig(OneUpUtilityConfig.class)).PrayerTab().getKeyCode());
        } else {
          Widget widget = this.client.getWidget(WidgetInfo.valueOf("PRAYER_" + prayer.name()));
          if (widget != null) {
            Point point = OneUpUtilityPlugin.getRandomPointWithinRec(widget.getCanvasLocation(), widget.getWidth(), widget.getHeight());
            this.click(point);
          }
        }
      }
    }
  }

  public void delayMoveMouse(Point p, int delay) {
    this.click(p);
  }

  public int getRandomIntBetweenRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  private boolean IsMouseInViewport(Point mousePosition) {
    int chatBoxHeight = this.client.getWidget(WidgetInfo.CHATBOX_BUTTONS).getHeight();
    int inventoryWidth = this.client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_PARENT).getWidth();
    return mousePosition.getX() < this.client.getViewportWidth() - inventoryWidth && mousePosition.getY() < this.client.getViewportHeight() - chatBoxHeight;
  }

  public void ClickSceneTile(Point tile) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      for(int i = 0; i < 100; ++i) {
        int tileWidth = this.client.getLocalPlayer().getCanvasTilePoly().getBounds().width;
        int x = this.getRandomIntBetweenRange(tile.getX() * 128 + tileWidth, tile.getX() * 128 + tileWidth * 4);
        int y = this.getRandomIntBetweenRange(tile.getY() * 128 + tileWidth, tile.getY() * 128 + tileWidth * 4);
        LocalPoint randomPoint = new LocalPoint(x, y);
        Point point = Perspective.localToCanvas(this.client, randomPoint, this.client.getPlane());
        if (point != null && this.IsMouseInViewport(point)) {
          this.moveMouse(point, 50, 150);
          return;
        }
      }

    }
  }

  public void LootSceneTile(Point tile) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      int tileWidth = this.client.getLocalPlayer().getCanvasTilePoly().getBounds().width;
      int x = this.getRandomIntBetweenRange(tile.getX() * 128 + tileWidth * 2, tile.getX() * 128 + tileWidth * 3);
      int y = this.getRandomIntBetweenRange(tile.getY() * 128 + tileWidth * 2, tile.getY() * 128 + tileWidth * 3);
      LocalPoint randomPoint = new LocalPoint(x, y);
      Point point = Perspective.localToCanvas(this.client, randomPoint, this.client.getPlane());
      if (point != null) {
        this.moveMouse(point, 50, 150);
      }
    }
  }

  public void ClickSceneTile(WorldPoint tile, int minDelay, int maxDelay) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      int tileWidth = this.client.getLocalPlayer().getCanvasTilePoly().getBounds().width;
      int x = this.getRandomIntBetweenRange(tile.getX() * 128 + tileWidth, tile.getX() * 128 + tileWidth * 4);
      int y = this.getRandomIntBetweenRange(tile.getY() * 128 + tileWidth, tile.getY() * 128 + tileWidth * 4);
      LocalPoint randomPoint = new LocalPoint(x, y);
      Point point = Perspective.localToCanvas(this.client, randomPoint, tile.getPlane());
      if (point != null) {
        this.moveMouse(point, minDelay, maxDelay);
      }
    }
  }

  public void moveMouse(Point p, int delay) {
    this.click(p);
  }

  public void moveMouse(Point p, int minDelay, int maxDelay) {
    this.click(p);
  }

  public void quickMoveMouse(Point p) {
    this.click(p);
  }

  public void moveMouse(Point p) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      OneUpUtilityPlugin.isMouseLocked = true;
      if (this.client.isStretchedEnabled()) {
        Dimension stretched = this.client.getStretchedDimensions();
        Dimension real = this.client.getRealDimensions();
        double width = (double)stretched.width / real.getWidth();
        double height = (double)stretched.height / real.getHeight();
        Point point = new Point((int)((double)p.getX() * width), (int)((double)p.getY() * height));
        this.mouseEvent(504, point);
        this.mouseEvent(505, point);
        this.mouseEvent(503, point);
        this.delayMouseClick(point, (long)this.getRandomIntBetweenRange(50, 150));
      } else {
        this.mouseEvent(504, p);
        this.mouseEvent(505, p);
        this.mouseEvent(503, p);
        this.delayMouseClick(p, (long)this.getRandomIntBetweenRange(50, 150));
      }
    }
  }

  public Point getClickPoint(Rectangle rect) {
    int x = (int)(rect.getX() + (double)this.calc.getRandomIntBetweenRange((int)rect.getWidth() / 6 * -1, (int)rect.getWidth() / 6) + rect.getWidth() / 2.0D);
    int y = (int)(rect.getY() + (double)this.calc.getRandomIntBetweenRange((int)rect.getHeight() / 6 * -1, (int)rect.getHeight() / 6) + rect.getHeight() / 2.0D);
    return new Point(x, y);
  }

  public void delayMouseClick(Point point, long delay) {
    if (delay <= 0L) {
      delay = getRandomIntBetweenRange(10, 30);
    }

    final long finalDelay = delay;  // Final variable for use in lambda

    new Thread(() -> {
      try {
        Thread.sleep(finalDelay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      mouseEvent(501, point);
      mouseEvent(502, point);
      mouseEvent(500, point);
    }).start();
  }


  public void ClickGameObjectIgnoreBounds(Rectangle rectangle) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      try {
        this.moveMouse(rectangle);
      } catch (Exception var3) {
        this.moveMouse(rectangle);
      }

    }
  }

  public boolean ClickNpc(NPC npc) {
    if (OneUpUtilityPlugin.isMouseLocked) {
      return true;
    } else if (npc != null && npc.getConvexHull() != null) {
      Rectangle rec = npc.getConvexHull().getBounds();
      if (rec.x + rec.width <= this.client.getViewportWidth() && rec.y + rec.height <= this.client.getViewportHeight()) {
        try {
          this.moveMouse(rec);
        } catch (Exception var4) {
          this.moveMouse(rec);
        }

        return true;
      } else {
        System.out.println("Out of Bounds");
        return false;
      }
    } else {
      return false;
    }
  }

  public void ClickInvItem(int id) {
    if (!OneUpUtilityPlugin.isMouseLocked) {
      Widget itemWidget = this.GetInvWidgetItem(id);
      Point point = OneUpUtilityPlugin.getRandomPointWithinRec(itemWidget.getCanvasLocation(), itemWidget.getWidth(), itemWidget.getHeight());
      this.delayMoveMouse(point, this.getRandomIntBetweenRange(50, 300));
    }
  }

  public Widget GetInvWidgetItem(int id) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget != null) {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getItemId() == id) {
            return itemWidgets[i];
          }
        }
      }
    }

    return null;
  }

  public void click(Widget widget) {
    Point point = OneUpUtilityPlugin.getRandomPointWithinRec(widget.getCanvasLocation(), widget.getWidth(), widget.getHeight());
    this.delayMoveMouse(point, this.getRandomIntBetweenRange(50, 300));
  }

  public boolean click(GameObject gameObject) {
    if (OneUpUtilityPlugin.isMouseLocked) {
      return false;
    } else {
      Rectangle rec = gameObject.getConvexHull().getBounds();
      if (rec.x + rec.width <= this.client.getViewportWidth() && rec.y + rec.height <= this.client.getViewportHeight()) {
        try {
          this.moveMouse(rec);
        } catch (Exception var4) {
          this.moveMouse(rec);
        }

        return true;
      } else {
        System.out.println("Out of Bounds");
        return false;
      }
    }
  }

  public boolean click2(GameObject gameObject) {
    if (OneUpUtilityPlugin.isMouseLocked) {
      return false;
    } else {
      Rectangle rec = gameObject.getCanvasTilePoly().getBounds();
      if (rec.x + rec.width <= this.client.getViewportWidth() && rec.y + rec.height <= this.client.getViewportHeight()) {
        try {
          this.moveMouse(rec);
        } catch (Exception var4) {
          this.moveMouse(rec);
        }

        return true;
      } else {
        System.out.println("Out of Bounds");
        return false;
      }
    }
  }

  public boolean IsPrayerOpen() {
    Widget widget = this.client.getWidget(541, 9);
    return widget != null && !widget.isHidden();
  }
}