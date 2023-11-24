package net.runelite.client.plugins.raids3Util;

import java.awt.event.MouseEvent;
import javax.inject.Inject;
import net.runelite.client.input.MouseAdapter;

public class MouseClickConsumer2 extends MouseAdapter {
  @Inject
  OneUpUtilityPlugin plugin;

  public MouseEvent mousePressed(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public MouseEvent mouseReleased(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public void UnlockMouse(long delay, MouseEvent event) {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException var4) {
        var4.printStackTrace();
      }

      OneUpUtilityPlugin.mouseEventTimes.remove(event.getWhen());
      OneUpUtilityPlugin.isMouseLocked = false;
    });
    thread.start();
  }

  public MouseEvent mouseDragged(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public MouseEvent mouseClicked(MouseEvent event) {
    if (OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen())) {
      this.UnlockMouse(100L, event);
    } else if (OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public MouseEvent mouseEntered(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public MouseEvent mouseExited(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }

  public MouseEvent mouseMoved(MouseEvent event) {
    if (!OneUpUtilityPlugin.mouseEventTimes.contains(event.getWhen()) && OneUpUtilityPlugin.isMouseLocked) {
      event.consume();
    }

    return event;
  }
}