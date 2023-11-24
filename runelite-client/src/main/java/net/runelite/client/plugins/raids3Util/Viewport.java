package net.runelite.client.plugins.raids3Util;

import net.runelite.api.Point;
import net.runelite.api.widgets.WidgetInfo;

public enum Viewport {
  RESIZED_BOX(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX, WidgetInfo.RESIZABLE_VIEWPORT_INTERFACE_CONTAINER, new Point(20, -4), new Point(0, -4)),
  RESIZED_BOTTOM(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INTERFACE_CONTAINER, new Point(61, -12), new Point(35, -12)),
  FIXED(WidgetInfo.FIXED_VIEWPORT, WidgetInfo.FIXED_VIEWPORT_INTERFACE_CONTAINER, new Point(20, -4), new Point(0, -4)),
  FIXED_BANK(WidgetInfo.BANK_CONTAINER, WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER, new Point(20, -4), new Point(0, -4));

  private WidgetInfo container;
  private WidgetInfo viewport;
  private Point offsetLeft;
  private Point offsetRight;

  public WidgetInfo getContainer() {
    return this.container;
  }

  public WidgetInfo getViewport() {
    return this.viewport;
  }

  public Point getOffsetLeft() {
    return this.offsetLeft;
  }

  public Point getOffsetRight() {
    return this.offsetRight;
  }

  private Viewport(WidgetInfo container, WidgetInfo viewport, Point offsetLeft, Point offsetRight) {
    this.container = container;
    this.viewport = viewport;
    this.offsetLeft = offsetLeft;
    this.offsetRight = offsetRight;
  }
}