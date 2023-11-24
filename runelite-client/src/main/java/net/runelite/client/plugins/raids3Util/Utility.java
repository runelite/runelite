package net.runelite.client.plugins.raids3Util;

import com.google.common.collect.ImmutableList;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.ItemLayer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Scene;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import org.apache.commons.lang3.ArrayUtils;

public class Utility {
  private final Client client;
  private final KeyboardUtils keyboardUtils;
  private final MouseUtils mouse;
  private final ConfigManager configManager;
  private final ItemManager itemManager;
  public final List<Integer> IGNORE_FOOD = Arrays.asList(7509, 7510);
  private final List<Integer> DRINK_SET = Arrays.asList(1993, 6691, 6689, 6687, 6685, 20973, 20974, 20975, 20976, 20977, 20978, 20979, 20980, 20981, 20982, 20983, 20984, 4049);
  private static final List<MenuAction> OBJECT_MENU_TYPES;

  public Utility(Client client, KeyboardUtils keyboardUtils, MouseUtils mouseUtils, ConfigManager configManager, ItemManager itemManager) {
    this.client = client;
    this.keyboardUtils = keyboardUtils;
    this.configManager = configManager;
    this.itemManager = itemManager;
    this.mouse = mouseUtils;
  }

  public Point ScenePointTowardsNPC(NPC npc) {
    Point npcSceneTile = new Point(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY());
    int playerSceneX;
    int playerSceneY;
    if (OneUpUtilityPlugin.lastClickedTile != null) {
      System.out.println("Using Last Clicked Tile");
      playerSceneX = OneUpUtilityPlugin.lastClickedTile.getSceneLocation().getX();
      playerSceneY = OneUpUtilityPlugin.lastClickedTile.getSceneLocation().getY();
    } else {
      playerSceneX = this.client.getLocalPlayer().getLocalLocation().getSceneX();
      playerSceneY = this.client.getLocalPlayer().getLocalLocation().getSceneY();
    }

    int xDistance = Math.abs(npcSceneTile.getX() - playerSceneX);
    int yDistance = Math.abs(npcSceneTile.getY() - playerSceneY);
    int randomX;
    if (playerSceneX > npcSceneTile.getX()) {
      randomX = this.getRandomIntBetweenRange(playerSceneX - xDistance, playerSceneX);
    } else {
      randomX = this.getRandomIntBetweenRange(playerSceneX, playerSceneX + xDistance);
    }

    int randomY;
    if (playerSceneY > npcSceneTile.getY()) {
      randomY = this.getRandomIntBetweenRange(playerSceneY - yDistance, playerSceneY);
    } else {
      randomY = this.getRandomIntBetweenRange(playerSceneY, playerSceneY + yDistance);
    }

    return new Point(randomX, randomY);
  }

  public Point WorldPointTowardsTile(WorldPoint worldLocation) {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, worldLocation);
    Point npcSceneTile = new Point(localPoint.getSceneX(), localPoint.getSceneY());
    int playerSceneX;
    int playerSceneY;
    if (this.client.getLocalDestinationLocation() != null) {
      LocalPoint localPoint1 = this.client.getLocalDestinationLocation();
      playerSceneX = localPoint1.getSceneX();
      playerSceneY = localPoint1.getSceneY();
    } else {
      playerSceneX = this.client.getLocalPlayer().getLocalLocation().getSceneX();
      playerSceneY = this.client.getLocalPlayer().getLocalLocation().getSceneY();
    }

    int xDistance = this.Clamp(Math.abs(npcSceneTile.getX() - playerSceneX), 1, 12);
    int yDistance = this.Clamp(Math.abs(npcSceneTile.getY() - playerSceneY), 1, 12);
    int randomX;
    if (playerSceneX > npcSceneTile.getX()) {
      randomX = this.getRandomIntBetweenRange(playerSceneX - xDistance, playerSceneX);
    } else {
      randomX = this.getRandomIntBetweenRange(playerSceneX, playerSceneX + xDistance);
    }

    int randomY;
    if (playerSceneY > npcSceneTile.getY()) {
      randomY = this.getRandomIntBetweenRange(playerSceneY - yDistance, playerSceneY);
    } else {
      randomY = this.getRandomIntBetweenRange(playerSceneY, playerSceneY + yDistance);
    }

    return new Point(randomX, randomY);
  }

  public Point WorldPointTowardsTile(Point tile) {
    Point npcSceneTile = new Point(tile.getX(), tile.getY());
    int playerSceneX;
    int playerSceneY;
    if (OneUpUtilityPlugin.lastClickedTile != null) {
      System.out.println("Using Last Clicked Tile");
      playerSceneX = OneUpUtilityPlugin.lastClickedTile.getSceneLocation().getX();
      playerSceneY = OneUpUtilityPlugin.lastClickedTile.getSceneLocation().getY();
    } else {
      playerSceneX = this.client.getLocalPlayer().getLocalLocation().getSceneX();
      playerSceneY = this.client.getLocalPlayer().getLocalLocation().getSceneY();
    }

    int xDistance = this.Clamp(Math.abs(npcSceneTile.getX() - playerSceneX), 1, 12);
    int yDistance = this.Clamp(Math.abs(npcSceneTile.getY() - playerSceneY), 1, 12);
    int randomX;
    if (playerSceneX > npcSceneTile.getX()) {
      randomX = this.getRandomIntBetweenRange(playerSceneX - xDistance, playerSceneX);
    } else {
      randomX = this.getRandomIntBetweenRange(playerSceneX, playerSceneX + xDistance);
    }

    int randomY;
    if (playerSceneY > npcSceneTile.getY()) {
      randomY = this.getRandomIntBetweenRange(playerSceneY - yDistance, playerSceneY);
    } else {
      randomY = this.getRandomIntBetweenRange(playerSceneY, playerSceneY + yDistance);
    }

    return new Point(randomX, randomY);
  }

  private int Clamp(int val, int min, int max) {
    return Math.max(min, Math.min(max, val));
  }

  public NPC FindNPC(String npcName) {
    List<NPC> npcs = this.client.getNpcs();
    if (npcs == null) {
      return null;
    } else {
      Iterator var3 = npcs.iterator();

      NPC npc;
      do {
        if (!var3.hasNext()) {
          return null;
        }

        npc = (NPC)var3.next();
      } while(npc.isDead() || !npc.getName().toLowerCase().contains(npcName.toLowerCase()));

      return npc;
    }
  }

  public Player GetPlayer(String playerName) {
    List<Player> npcs = this.client.getPlayers();
    if (npcs == null) {
      return null;
    } else {
      Iterator var3 = npcs.iterator();

      Player player;
      do {
        if (!var3.hasNext()) {
          return null;
        }

        player = (Player)var3.next();
      } while(player.isDead() || !player.getName().toLowerCase().contains(playerName.toLowerCase()));

      return player;
    }
  }

  public Tile FindGroundItemTile(int itemID) {
    Scene scene = this.client.getScene();
    Tile[][][] tiles = scene.getTiles();
    int z = this.client.getPlane();

    for(int x = 0; x < 104; ++x) {
      for(int y = 0; y < 104; ++y) {
        Tile tile = tiles[z][x][y];
        if (tile != null) {
          Player player = this.client.getLocalPlayer();
          if (player != null) {
            ItemLayer itemLayer = tile.getItemLayer();
            if (itemLayer != null) {
              for(Object current = itemLayer.getBottom(); current instanceof TileItem; current = ((Node)current).getNext()) {
                TileItem item = (TileItem)current;
                if (item.getId() == itemID) {
                  return tile;
                }
              }
            }
          }
        }
      }
    }

    return null;
  }

  public Tile FindGroundItemTile(int itemID, Point scenePoint) {
    Scene scene = this.client.getScene();
    Tile[][][] tiles = scene.getTiles();
    int z = this.client.getPlane();

    for(int x = 0; x < 104; ++x) {
      for(int y = 0; y < 104; ++y) {
        Tile tile = tiles[z][x][y];
        if (tile != null) {
          Player player = this.client.getLocalPlayer();
          if (player != null) {
            ItemLayer itemLayer = tile.getItemLayer();
            if (itemLayer != null) {
              for(Object current = itemLayer.getBottom(); current instanceof TileItem; current = ((Node)current).getNext()) {
                TileItem item = (TileItem)current;
                if (item.getId() == itemID && scenePoint.getX() == x && scenePoint.getY() == y) {
                  return tile;
                }
              }
            }
          }
        }
      }
    }

    return null;
  }

  public boolean InvContainsItem(int id) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget != null) {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getItemId() == id || itemWidgets[i].getItemId() == id + 1) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public int InvItemQuantity(int id) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    int quantity = 0;
    if (parentWidget != null) {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getItemId() == id || itemWidgets[i].getItemId() == id + 1) {
            quantity += itemWidgets[i].getItemQuantity();
          }
        }
      }
    }

    return quantity;
  }

  public int TileDistance(WorldPoint tile1) {
    WorldPoint worldPoint = new WorldPoint(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY(), 0);
    int tileDistance = tile1.distanceTo(worldPoint);
    return tileDistance;
  }

  public boolean IsGameObjectInRange(GameObject gameObject, int tileRange) {
    Point playerTile = new Point(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY());
    Point gameObjectTile = new Point(gameObject.getLocalLocation().getSceneX(), gameObject.getLocalLocation().getSceneY());
    return playerTile.distanceTo(gameObjectTile) <= tileRange;
  }

  public NPC GetInteractingNpc() {
    String playerName = this.client.getLocalPlayer().getName();
    Iterator var2 = this.client.getNpcs().iterator();

    NPC npc;
    do {
      if (!var2.hasNext()) {
        return null;
      }

      npc = (NPC)var2.next();
    } while(npc.getInteracting() == null || !npc.getInteracting().getName().equals(playerName));

    return npc;
  }

  public boolean IsSceneTileInRange(Point tile, int minDistance) {
    Point playerLocalPoint = new Point(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY());
    Point tileLocalPoint = new Point(tile.getX(), tile.getY());
    int distance = playerLocalPoint.distanceTo(tileLocalPoint);
    return distance <= minDistance;
  }

  public boolean IsPlayerNearNPC(NPC npc, int minDistance) {
    Point playerLocalPoint = new Point(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY());
    Point npcLocalPoint = new Point(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY());
    int distance = playerLocalPoint.distanceTo(npcLocalPoint);
    return distance <= minDistance;
  }

  public boolean IsTileNearNPC(NPC npc, Point selectedTile, int minDistance) {
    Point npcLocalPoint = new Point(npc.getLocalLocation().getSceneX(), npc.getLocalLocation().getSceneY());
    int distance = selectedTile.distanceTo(npcLocalPoint);
    return distance <= minDistance;
  }

  public Point getRandomPointWithinRec(Point point, int width, int height) {
    return new Point(this.getRandomIntBetweenRange(point.getX(), point.getX() + width), this.getRandomIntBetweenRange(point.getY(), point.getY() + height));
  }

  public Point getRandomPointWithinRec(Rectangle rectangle) {
    return this.getRandomPointWithinRec(new Point((int)rectangle.getX(), (int)rectangle.getY()), rectangle.width, rectangle.height);
  }

  public int getRandomIntBetweenRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public boolean MouseInViewPort() {
    return this.client.getSelectedSceneTile() != null && this.client.getSelectedSceneTile().getLocalLocation() != null;
  }

  public boolean IsInvFull() {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return true;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getItemId() == 6512) {
            return false;
          }
        }
      }

      return true;
    }
  }

  public boolean InvContainsFood() {
    Widget eatItem = this.getItemMenu(this.itemManager, "Eat", 33, this.IGNORE_FOOD);
    Widget drinkItem = this.GetInvWidgetItem(this.DRINK_SET);
    return eatItem != null || drinkItem != null;
  }

  private Widget GetInvWidgetItem(List<Integer> drink_set) {
    Widget prayerPotionWidget = null;
    Iterator var3 = drink_set.iterator();

    while(true) {
      Integer id;
      Widget[] itemWidgets;
      do {
        Widget parentWidget;
        do {
          if (!var3.hasNext()) {
            return prayerPotionWidget;
          }

          id = (Integer)var3.next();
          parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
        } while(parentWidget == null);

        itemWidgets = parentWidget.getChildren();
      } while(itemWidgets == null);

      for(int i = 0; i < itemWidgets.length; ++i) {
        if (this.IsPrayerPot(itemWidgets[i].getItemId())) {
          if (prayerPotionWidget == null) {
            prayerPotionWidget = itemWidgets[i];
          }
        } else if (itemWidgets[i].getItemId() == id) {
          return itemWidgets[i];
        }
      }
    }
  }

  private boolean IsPrayerPot(int itemId) {
    switch(itemId) {
      case 139:
      case 141:
      case 143:
      case 2434:
        return true;
      default:
        return false;
    }
  }

  public Collection<Widget> GetWidgetItems() {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    Collection<Widget> items = new ArrayList();
    if (parentWidget != null) {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          items.add(itemWidgets[i]);
        }
      }
    }

    return items;
  }

  public Widget getItemMenu(ItemManager itemManager, String menuOption, int opcode, Collection<Integer> ignoreIDs) {
    Widget inventoryWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (inventoryWidget != null) {
      Collection<Widget> items = this.GetWidgetItems();
      Iterator var7 = items.iterator();

      while(true) {
        Widget item;
        do {
          if (!var7.hasNext()) {
            return null;
          }

          item = (Widget)var7.next();
        } while(ignoreIDs.contains(item.getId()));

        String[] menuActions = itemManager.getItemComposition(item.getItemId()).getInventoryActions();
        String[] var10 = menuActions;
        int var11 = menuActions.length;

        for(int var12 = 0; var12 < var11; ++var12) {
          String action = var10[var12];
          if (action != null && action.equals(menuOption)) {
            return item;
          }
        }
      }
    } else {
      return null;
    }
  }

  private boolean objectIdEquals(TileObject tileObject, int id) {
    if (tileObject == null) {
      return false;
    } else if (tileObject.getId() == id) {
      return true;
    } else {
      ObjectComposition comp = this.client.getObjectDefinition(tileObject.getId());
      if (comp.getImpostorIds() != null) {
        int[] var4 = comp.getImpostorIds();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
          int impostorId = var4[var6];
          if (impostorId == id) {
            return true;
          }
        }
      }

      return false;
    }
  }

  public TileObject findTileObject(Tile tile, int id) {
    if (tile == null) {
      return null;
    } else {
      GameObject[] tileGameObjects = tile.getGameObjects();
      DecorativeObject tileDecorativeObject = tile.getDecorativeObject();
      WallObject tileWallObject = tile.getWallObject();
      GroundObject groundObject = tile.getGroundObject();
      if (this.objectIdEquals(tileWallObject, id)) {
        return tileWallObject;
      } else if (this.objectIdEquals(tileDecorativeObject, id)) {
        return tileDecorativeObject;
      } else if (this.objectIdEquals(groundObject, id)) {
        return groundObject;
      } else {
        GameObject[] var7 = tileGameObjects;
        int var8 = tileGameObjects.length;

        for(int var9 = 0; var9 < var8; ++var9) {
          GameObject object = var7[var9];
          if (this.objectIdEquals(object, id)) {
            return object;
          }
        }

        return null;
      }
    }
  }

  public boolean isEquipped(int id, KitType kitType) {
    if (this.client.getLocalPlayer() == null) {
      return false;
    } else if (this.client.getLocalPlayer().getPlayerComposition() == null) {
      return false;
    } else {
      int equippedID = this.client.getLocalPlayer().getPlayerComposition().getEquipmentId(kitType);
      return equippedID == id;
    }
  }

  public GameObject FindGameObjectContainsText(String text) {
    Scene scene = this.client.getScene();
    Tile[][][] tiles = scene.getTiles();
    int z = this.client.getPlane();

    for(int x = 0; x < 104; ++x) {
      for(int y = 0; y < 104; ++y) {
        Tile tile = tiles[z][x][y];
        if (tile != null) {
          GameObject[] var8 = tile.getGameObjects();
          int var9 = var8.length;

          for(int var10 = 0; var10 < var9; ++var10) {
            GameObject gameObject = var8[var10];
            if (gameObject != null) {
              String objectName = this.client.getObjectDefinition(gameObject.getId()).getName();
              if (objectName != null && !objectName.equals("") && objectName.equalsIgnoreCase(text) && gameObject.getId() > 1000) {
                return gameObject;
              }
            }
          }
        }
      }
    }

    return null;
  }

  private ObjectComposition getObjectComposition(int id) {
    ObjectComposition objectComposition = this.client.getObjectDefinition(id);
    return objectComposition.getImpostorIds() == null ? objectComposition : objectComposition.getImpostor();
  }

  public GameObject FindGameObject(int id) {
    Scene scene = this.client.getScene();
    Tile[][][] tiles = scene.getTiles();
    int z = this.client.getPlane();

    for(int x = 0; x < 104; ++x) {
      for(int y = 0; y < 104; ++y) {
        Tile tile = tiles[z][x][y];
        if (tile != null) {
          GameObject[] var8 = tile.getGameObjects();
          int var9 = var8.length;

          for(int var10 = 0; var10 < var9; ++var10) {
            GameObject gameObject = var8[var10];
            if (gameObject != null && gameObject.getId() == id) {
              return gameObject;
            }
          }
        }
      }
    }

    return null;
  }

  public NPC FindNPC(int id) {
    Iterator var2 = this.client.getNpcs().iterator();

    NPC npc;
    do {
      if (!var2.hasNext()) {
        return null;
      }

      npc = (NPC)var2.next();
    } while(npc.getId() != id);

    return npc;
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

  public Rectangle GetSafeBounds(Rectangle playerBoundsRec) {
    Rectangle viewPortRec;
    if (!this.client.isResized()) {
      viewPortRec = new Rectangle(10, 10, this.client.getViewportWidth() - 10, this.client.getViewportHeight() - 10);
    } else {
      Widget invWidget = this.client.getWidget(WidgetInfo.INVENTORY);
      Widget chatWidget = this.client.getWidget(WidgetInfo.CHATBOX);
      viewPortRec = new Rectangle(10, 10, this.client.getViewportWidth() - invWidget.getWidth() - 40, this.client.getViewportHeight() - chatWidget.getHeight() - 40);
    }

    return viewPortRec.contains(playerBoundsRec) ? playerBoundsRec : viewPortRec.intersection(playerBoundsRec);
  }

  public boolean IsLocalPointInViewport(LocalPoint localPoint) {
    Point canvasPoint = Perspective.localToCanvas(this.client, localPoint, this.client.getPlane());
    Rectangle viewPortRec;
    if (!this.client.isResized()) {
      viewPortRec = new Rectangle(10, 10, this.client.getViewportWidth() - 10, this.client.getViewportHeight() - 10);
    } else {
      Widget invWidget = this.client.getWidget(WidgetInfo.INVENTORY);
      Widget chatWidget = this.client.getWidget(WidgetInfo.CHATBOX);
      viewPortRec = new Rectangle(10, 10, this.client.getViewportWidth() - invWidget.getWidth() - 40, this.client.getViewportHeight() - chatWidget.getHeight() - 40);
    }

    return viewPortRec.contains(new java.awt.Point(canvasPoint.getX(), canvasPoint.getY()));
  }

  public boolean IsTabOpen(TabType tabType) {
    switch(tabType) {
      case Inventory:
        return this.IsInventoryTabOpen();
      case SpellBook:
        return this.IsSpellBookOpen();
      case Spec:
      default:
        return true;
      case Prayer:
        Widget widget = this.client.getWidget(541, 9);
        return widget != null && !widget.isHidden();
    }
  }

  public boolean IsInventoryTabOpen() {
    Widget widget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (widget == null) {
      return false;
    } else {
      return !this.client.getWidget(WidgetInfo.INVENTORY).isHidden();
    }
  }

  public boolean IsSpellBookOpen() {
    return !this.client.getWidget(Spells.high_lvl_alch.getParentID(), Spells.high_lvl_alch.getChildID()).isHidden() || !this.client.getWidget(WidgetInfo.SPELL_EDGEVILLE_HOME_TELEPORT).isHidden() || !this.client.getWidget(WidgetInfo.SPELL_LUMBRIDGE_HOME_TELEPORT).isHidden() || !this.client.getWidget(WidgetInfo.SPELL_LUNAR_HOME_TELEPORT).isHidden();
  }

  public void OpenTab(TabType spellBook) {
    switch(spellBook) {
      case Inventory:
        this.keyboardUtils.pressKey(((OneUpUtilityConfig)this.configManager.getConfig(OneUpUtilityConfig.class)).InventoryTab().getKeyCode());
        break;
      case SpellBook:
        this.keyboardUtils.pressKey(((OneUpUtilityConfig)this.configManager.getConfig(OneUpUtilityConfig.class)).SpellTab().getKeyCode());
        break;
      case Spec:
        this.keyboardUtils.pressKey(((OneUpUtilityConfig)this.configManager.getConfig(OneUpUtilityConfig.class)).SpecTab().getKeyCode());
        break;
      case Prayer:
        this.keyboardUtils.pressKey(((OneUpUtilityConfig)this.configManager.getConfig(OneUpUtilityConfig.class)).PrayerTab().getKeyCode());
    }

  }

  public boolean IsNpcInViewport(NPC targetNPC) {
    if (targetNPC != null && targetNPC.getConvexHull() != null) {
      Rectangle rec = targetNPC.getConvexHull().getBounds();
      return rec.x + rec.width < this.client.getViewportWidth() && rec.y + rec.height < this.client.getViewportHeight();
    } else {
      return false;
    }
  }

  public boolean IsPlayerInViewport(Player player) {
    if (player != null && player.getConvexHull() != null) {
      Rectangle rec = player.getConvexHull().getBounds();
      return rec.x + rec.width < this.client.getViewportWidth() && rec.y + rec.height < this.client.getViewportHeight();
    } else {
      return false;
    }
  }

  public boolean IsPointInViewPort(Point canvasLocation) {
    if (canvasLocation == null) {
      return false;
    } else {
      int chatBoxHeight = this.client.getWidget(WidgetInfo.CHATBOX_BUTTONS).getHeight();
      int inventoryWidth = this.client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_PARENT).getWidth();
      return canvasLocation.getX() < this.client.getViewportWidth() - inventoryWidth && canvasLocation.getY() < this.client.getViewportHeight() - chatBoxHeight;
    }
  }

  public boolean IsMouseInViewport() {
    Point mousPosition = this.client.getMouseCanvasPosition();
    int chatBoxHeight = this.client.getWidget(WidgetInfo.CHATBOX_BUTTONS).getHeight();
    return mousPosition.getX() < this.client.getViewportWidth() && mousPosition.getY() < this.client.getViewportHeight() - chatBoxHeight;
  }

  public boolean IsOutOfAmmo() {
    return true;
  }

  public boolean InvContainsText(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return false;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase())) {
            return true;
          }
        }
      }

      return false;
    }
  }

  public Widget GetInvNotedItemWithText(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return null;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      new ArrayList();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase()) && itemWidgets[i].getItemQuantity() > 1) {
            return itemWidgets[i];
          }
        }
      }

      return null;
    }
  }

  public boolean InvContainsUnotedText(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return false;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      new ArrayList();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase()) && itemWidgets[i].getItemQuantity() == 1) {
            return true;
          }
        }
      }

      return false;
    }
  }

  public boolean InvContainsNotedText(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return false;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      new ArrayList();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase()) && itemWidgets[i].getItemQuantity() > 1) {
            return true;
          }
        }
      }

      return false;
    }
  }

  public List<Widget> GetInvItemsWithNameContaining(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return null;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      List<Widget> itemWidgetList = new ArrayList();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase()) && itemWidgets[i].getItemQuantity() == 1) {
            itemWidgetList.add(itemWidgets[i]);
          }
        }
      }

      return itemWidgetList;
    }
  }

  public Widget GetInvItemWithNameContaining(String text) {
    Widget parentWidget = this.client.getWidget(WidgetInfo.INVENTORY);
    if (parentWidget == null) {
      return null;
    } else {
      Widget[] itemWidgets = parentWidget.getChildren();
      if (itemWidgets != null) {
        for(int i = 0; i < itemWidgets.length; ++i) {
          if (itemWidgets[i].getName().toLowerCase().contains(text.toLowerCase())) {
            return itemWidgets[i];
          }
        }
      }

      return null;
    }
  }

  public int NPCTileSize(NPC targetNPC) {
    NPCComposition composition = targetNPC.getTransformedComposition();
    return composition != null ? composition.getSize() : 0;
  }

  public int GetNPCDistance(NPC targetNPC) {
    int tileSize = this.NPCTileSize(targetNPC);
    if (tileSize == 0) {
      return -1;
    } else {
      LocalPoint playerLocal = this.client.getLocalPlayer().getLocalLocation();
      LocalPoint npcLocal = targetNPC.getLocalLocation();
      Point playerScenePoint = new Point(playerLocal.getSceneX(), playerLocal.getSceneY());
      Point npcScenePoint = new Point(npcLocal.getSceneX(), npcLocal.getSceneY());
      int xDistance = npcScenePoint.getX() - playerScenePoint.getX();
      int yDistance = npcScenePoint.getY() - playerScenePoint.getY();
      if (tileSize == 1) {
        return playerScenePoint.distanceTo(npcScenePoint);
      } else if (playerScenePoint.getX() < npcScenePoint.getX() && xDistance > 1) {
        return playerScenePoint.distanceTo(npcScenePoint) - (tileSize - 1);
      } else {
        return playerScenePoint.getY() < npcScenePoint.getY() && yDistance > 1 ? playerScenePoint.distanceTo(npcScenePoint) - (tileSize - 1) : playerScenePoint.distanceTo(npcScenePoint);
      }
    }
  }

  public void ClickPrayer(Prayer prayer) {
    Widget widget = this.GetPrayerWidget(prayer.name());
    if (widget != null) {
      Point point = this.getRandomPointWithinRec(widget.getCanvasLocation(), widget.getWidth(), widget.getHeight());
      this.mouse.click(point);
    }
  }

  public boolean IsPrayerOn(Prayer prayer) {
    return this.client.isPrayerActive(prayer);
  }

  public boolean IsPlayerInRegion(int regionID) {
    return ArrayUtils.contains(this.client.getMapRegions(), regionID);
  }

  public boolean NoPrayerPoints() {
    return this.client.getBoostedSkillLevel(Skill.PRAYER) == 0;
  }

  public void BlockObjectClicks() {
    if (this.client.getGameState() == GameState.LOGGED_IN && !this.client.isMenuOpen()) {
      MenuEntry[] menuEntries = this.client.getMenuEntries();
      MenuEntry[] var2 = menuEntries;
      int var3 = menuEntries.length;

      for(int var4 = 0; var4 < var3; ++var4) {
        MenuEntry entry = var2[var4];
        this.swapMenuEntry(menuEntries, entry);
      }

    }
  }

  private void swapMenuEntry(MenuEntry[] menuEntries, MenuEntry menuEntry) {
    MenuAction menuAction = menuEntry.getType();
    if (OBJECT_MENU_TYPES.contains(menuAction)) {
      menuEntry.setDeprioritized(true);
    }

  }

  public boolean IsPlayerMovingToLocation(WorldPoint safeShadowTile) {
    LocalPoint playerLocalPoint = this.client.getLocalPlayer().getLocalLocation();
    return playerLocalPoint.getSceneX() == safeShadowTile.getX() && playerLocalPoint.getSceneY() == safeShadowTile.getY();
  }

  public Point SceneFromLocal(LocalPoint location) {
    return new Point(location.getSceneX(), location.getSceneY());
  }

  public Viewport GetClientLayout() {
    Viewport curViewport = null;
    Widget curWidget = null;
    Viewport[] var3 = Viewport.values();
    int var4 = var3.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Viewport viewport = var3[var5];
      Widget viewportWidget = this.client.getWidget(viewport.getViewport());
      if (viewportWidget != null && !viewportWidget.isHidden()) {
        curViewport = viewport;
        break;
      }
    }

    return curViewport == null ? null : curViewport;
  }

  public Widget GetPrayerWidget(String prayerName) {
    prayerName = prayerName.replace('_', ' ');

    for(int i = 9; i <= 37; ++i) {
      Widget widget = this.client.getWidget(541, i);
      if (widget != null && widget.getName().toLowerCase().contains(prayerName.toLowerCase())) {
        return widget;
      }
    }

    return null;
  }

  static {
    OBJECT_MENU_TYPES = ImmutableList.of(MenuAction.GAME_OBJECT_FIRST_OPTION, MenuAction.GAME_OBJECT_SECOND_OPTION, MenuAction.GAME_OBJECT_THIRD_OPTION, MenuAction.GAME_OBJECT_FOURTH_OPTION);
  }
}