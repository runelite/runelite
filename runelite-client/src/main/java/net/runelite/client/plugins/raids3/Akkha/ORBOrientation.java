package net.runelite.client.plugins.raids3.Akkha;

import net.runelite.api.Point;

public enum ORBOrientation {
  North(new Point(0, 1)),
  North_East(new Point(1, 1)),
  East(new Point(1, 0)),
  South_East(new Point(1, -1)),
  South(new Point(0, -1)),
  South_West(new Point(-1, -1)),
  West(new Point(-1, 0)),
  North_West(new Point(-1, 1));

  private final Point vector;

  private ORBOrientation(Point vector) {
    this.vector = vector;
  }

  public Point getValue() {
    return this.vector;
  }
}