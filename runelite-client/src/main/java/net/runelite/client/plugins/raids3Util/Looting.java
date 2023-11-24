package net.runelite.client.plugins.raids3Util;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class Looting {
  private static final Logger log = LoggerFactory.getLogger(Looting.class);
  @Inject
  MouseUtils mouse;

  public void LootSceneTile(Point SceneTile) {
    this.mouse.ClickSceneTile(SceneTile);
  }
}