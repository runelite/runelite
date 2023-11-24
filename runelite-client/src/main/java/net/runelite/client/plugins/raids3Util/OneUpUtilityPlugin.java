package net.runelite.client.plugins.raids3Util;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
    name = "1Up Utility",
    description = "(*WARNING* LEAVE ON FOR OTHER PLUGINS TO WORK) Please set the correct tab keys.",
    tags = {"1Up", "utility"}
)
public class OneUpUtilityPlugin extends Plugin {
  @Inject
  private OneUpUtilityConfig config;
  @Inject
  private Client client;
  @Inject
  private MouseClickConsumer mouseClickConsumer;
  @Inject
  private MouseManager mouseManager;
  public static List<Long> mouseEventTimes = new ArrayList();
  public static Tile lastClickedTile;
  public static boolean isMouseLocked = false;

  public static Double SceneDistance(NPC guardNPC, Player localPlayer) {
    return Math.sqrt(Math.pow((double)(guardNPC.getLocalLocation().getSceneX() - localPlayer.getLocalLocation().getSceneX()), 2.0D) + Math.pow((double)(guardNPC.getLocalLocation().getSceneY() - localPlayer.getLocalLocation().getSceneY()), 2.0D));
  }

  @Provides
  OneUpUtilityConfig provideConfig(ConfigManager configManager) {
    return (OneUpUtilityConfig)configManager.getConfig(OneUpUtilityConfig.class);
  }

  protected void startUp() throws Exception {
    this.mouseManager.registerMouseListener(this.mouseClickConsumer);
  }

  protected void shutDown() {
    this.mouseManager.unregisterMouseListener(this.mouseClickConsumer);
  }

  @Subscribe
  private void onMenuOptionClicked(MenuOptionClicked event) {
    if (event.getMenuOption().equals("Walk here")) {
      lastClickedTile = this.client.getSelectedSceneTile();
    }

  }

  public static Point getRandomPointWithinRec(Point point, int width, int height) {
    return new Point(getRandomIntBetweenRange(point.getX(), point.getX() + width), getRandomIntBetweenRange(point.getY(), point.getY() + height));
  }

  public static int getRandomIntBetweenRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
}