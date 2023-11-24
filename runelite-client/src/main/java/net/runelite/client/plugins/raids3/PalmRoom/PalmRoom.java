package net.runelite.client.plugins.raids3.PalmRoom;

import java.awt.Rectangle;
import java.util.Iterator;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.raids3.Raids3Config;
import net.runelite.client.plugins.raids3.Timer;
import net.runelite.client.plugins.raids3Util.MouseUtils;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;
import net.runelite.client.plugins.raids3Util.Utility;

public class PalmRoom {
  Client client;
  MouseUtils mouse;
  Utility utility;
  Raids3Config config;
  NPC palmTree;
  PalmTreeTasks currentTask;
  final int emptyWaterContainerID = 27295;
  final int fullWaterfallID = 45398;
  final int PALM_TREE_ID = 11700;
  int taskIndex = 0;
  String lastMenuOption = "";
  PalmTreeTasks[] taskSequence = new PalmTreeTasks[15];
  Timer mouseTimer = new Timer(50, 350);
  Point waterfall1SafeTile1 = new Point(8, 13);
  Point waterfall1SafeTile2 = new Point(9, 13);
  Point waterfall2SafeTile1 = new Point(-6, 13);
  Point waterfall2SafeTile2 = new Point(-5, 13);
  public int startX = 13;
  boolean isContainerFilled = false;
  boolean isPalmWatered = false;
  GameObject[] waterfallList = new GameObject[4];
  GameObject[] statueList = new GameObject[4];
  ClickType clickType;
  ChatMessageManager chatMessageManager;
  boolean isFillingContainer;
  boolean isStarted;

  public PalmRoom(Client client, MouseUtils mouse, Utility utility, Raids3Config config, ChatMessageManager chatMessageManager) {
    this.clickType = ClickType.Normal;
    this.isFillingContainer = false;
    this.isStarted = false;
    this.client = client;
    this.mouse = mouse;
    this.utility = utility;
    this.config = config;
    this.chatMessageManager = chatMessageManager;
    this.taskSequence[0] = PalmTreeTasks.Enter_Gate;
    this.taskSequence[1] = PalmTreeTasks.Retrieve_Water_Container;
    this.taskSequence[2] = PalmTreeTasks.WATERFALL1_ENTRANCE_TILE;
    this.taskSequence[3] = PalmTreeTasks.WATERFALL1_CLICK;
    this.taskSequence[4] = PalmTreeTasks.WATERFALL1_FILL_WATER;
    this.taskSequence[5] = PalmTreeTasks.LEAVE_WATERFALL1;
    this.taskSequence[6] = PalmTreeTasks.CLICK_PALM;
    this.taskSequence[7] = PalmTreeTasks.WATER_PALM_TREE1;
    this.taskSequence[8] = PalmTreeTasks.WATERFALL2_ENTRANCE_TILE;
    this.taskSequence[9] = PalmTreeTasks.WATERFALL2_CLICK;
    this.taskSequence[10] = PalmTreeTasks.WATERFALL2_FILL_WATER;
    this.taskSequence[11] = PalmTreeTasks.LEAVE_WATERFALL2;
    this.taskSequence[12] = PalmTreeTasks.CLICK_PALM;
    this.taskSequence[13] = PalmTreeTasks.WATER_PALM_TREE2;
    this.taskSequence[14] = PalmTreeTasks.COMPLETE;
    this.currentTask = PalmTreeTasks.Enter_Gate;
  }

  public void Reset() {
    this.currentTask = PalmTreeTasks.Enter_Gate;
    this.palmTree = null;
    this.taskIndex = 0;
    this.isStarted = false;
  }

  public void onBeforeRender() {
    if (this.mouseTimer.isDone()) {
      if (this.palmTree == null) {
        this.palmTree = this.utility.FindNPC(11700);
        if (this.palmTree != null) {
          int xOffset = this.palmTree.getLocalLocation().getSceneX();
          int yOffset = this.palmTree.getLocalLocation().getSceneY();
          this.waterfall1SafeTile1 = new Point(xOffset + 8, yOffset + 13);
          this.waterfall1SafeTile2 = new Point(xOffset + 9, yOffset + 13);
          this.waterfall2SafeTile1 = new Point(xOffset - 6, yOffset + 13);
          this.waterfall2SafeTile2 = new Point(xOffset - 5, yOffset + 13);
          this.startX += xOffset;
        }

      } else if (this.config.AutoPalmRoom()) {
        switch(this.currentTask) {
          case Enter_Gate:
            this.EnterGate();
            break;
          case Retrieve_Water_Container:
            this.RetrieveWaterContainer();
            break;
          case WATERFALL1_ENTRANCE_TILE:
            this.MoveToWaterfall1Entrance();
            break;
          case WATERFALL1_CLICK:
            this.WaterfallClick(this.waterfallList[3]);
            break;
          case WATERFALL1_FILL_WATER:
            this.FillWater(3);
            break;
          case LEAVE_WATERFALL1:
            this.LeaveWaterfall1();
            break;
          case LEAVE_WATERFALL2:
            this.LeaveWaterfall2();
            break;
          case CLICK_PALM:
            this.ClickPalm();
            break;
          case WATER_PALM_TREE1:
          case WATER_PALM_TREE2:
            this.WaterPalmTree();
            break;
          case WATERFALL2_ENTRANCE_TILE:
            this.MoveToWaterfall2Entrance();
            break;
          case WATERFALL2_CLICK:
            this.WaterfallClick(this.waterfallList[2]);
            break;
          case WATERFALL2_FILL_WATER:
            this.FillWater(2);
            break;
          case COMPLETE:
            this.Complete();
        }

      }
    }
  }

  private void ClickPalm() {
    if (this.lastMenuOption.contains("Water")) {
      this.NextTask();
    } else {
      this.mouseTimer.Reset();
      this.mouse.ClickNpc(this.palmTree);
    }
  }

  private void WaterfallClick(GameObject waterfall) {
    if (this.lastMenuOption.contains("Fill")) {
      this.NextTask();
    } else {
      if (this.mouse == null) {
        System.out.println("Mouse is null");
      }

      if (this.utility == null) {
        System.out.println("utility is null");
      }

      if (waterfall == null) {
        System.out.println("waterfall is null");
      }

      this.mouse.ClickGameObjectIgnoreBounds(this.utility.GetSafeBounds(waterfall.getConvexHull().getBounds()));
    }
  }

  private void EnterGate() {
    if (this.isStarted) {
      String chatMessage = (new ChatMessageBuilder()).append(ChatColorType.HIGHLIGHT).append("[1Up_Raids3] Starting Auto Path of Crondis...").build();
      this.chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.FRIENDSCHATNOTIFICATION).runeLiteFormattedMessage(chatMessage).build());
      this.mouseTimer.Reset();
      this.NextTask();
    }

  }

  private void RetrieveWaterContainer() {
    if (this.utility.InvContainsItem(27295)) {
      this.NextTask();
    } else {
      LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
      if (localPoint.getSceneX() >= this.startX || !this.lastMenuOption.contains("Take")) {
        Point offSetVector = new Point(2, 7);
        int refX = this.palmTree.getLocalLocation().getSceneX();
        int refY = this.palmTree.getLocalLocation().getSceneY();
        Point sceneTilePoint = new Point(refX + offSetVector.getX(), refY + offSetVector.getY());
        this.mouseTimer.Reset();
        this.mouse.ClickSceneTile(sceneTilePoint);
      }
    }
  }

  private void MoveToWaterfall1Entrance() {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
    if (localPoint.getSceneY() >= this.waterfall1SafeTile1.getY()) {
      this.NextTask();
    } else {
      this.mouseTimer.Reset();
      this.MoveToTile(this.waterfall1SafeTile1);
    }
  }

  private void MoveToWaterfall2Entrance() {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
    if (localPoint.getSceneY() >= 10 + this.palmTree.getLocalLocation().getSceneY()) {
      this.NextTask();
    } else {
      this.mouseTimer.Reset();
      this.MoveToTile(this.waterfall2SafeTile2);
    }
  }

  private boolean IsTileInProjectilePath(Point safeTile1) {
    Iterator var2 = this.client.getGraphicsObjects().iterator();

    GraphicsObject graphicsObject;
    do {
      if (!var2.hasNext()) {
        return false;
      }

      graphicsObject = (GraphicsObject)var2.next();
    } while(graphicsObject.getLocation().getSceneX() != safeTile1.getX());

    return true;
  }

  private void Complete() {
  }

  private void LeaveWaterfall2() {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
    if (localPoint.getSceneY() <= 15 + this.palmTree.getLocalLocation().getSceneY()) {
      this.NextTask();
    } else {
      this.mouseTimer.Reset();
      this.MoveToTile(this.waterfall2SafeTile2);
    }
  }

  private void LeaveWaterfall1() {
    LocalPoint localPoint = LocalPoint.fromWorld(this.client, this.client.getLocalPlayer().getWorldLocation());
    if (localPoint.getSceneY() <= 14 + this.palmTree.getLocalLocation().getSceneY()) {
      this.NextTask();
    } else {
      this.mouseTimer.Reset();
      this.MoveToTile(this.waterfall1SafeTile1);
    }
  }

  private void LeaveWaterfall(Point targetTile, int row1, int row2) {
    boolean isProjectileInSamePath = false;
    Point playerScenePoint = new Point(this.client.getLocalPlayer().getLocalLocation().getSceneX(), this.client.getLocalPlayer().getLocalLocation().getSceneY());
    if (playerScenePoint.getY() <= targetTile.getY()) {
      this.NextTask();
    } else {
      Iterator var6 = this.client.getGraphicsObjects().iterator();

      while(var6.hasNext()) {
        GraphicsObject projectile = (GraphicsObject)var6.next();
        if (this.client.getLocalDestinationLocation() == null) {
          if (projectile.getLocation().getSceneX() == this.client.getLocalPlayer().getLocalLocation().getSceneX()) {
            isProjectileInSamePath = true;
            break;
          }
        } else if (projectile.getLocation().getSceneX() == this.client.getLocalDestinationLocation().getSceneX()) {
          isProjectileInSamePath = true;
          break;
        }
      }

      if (isProjectileInSamePath) {
        if (this.client.getLocalPlayer().getLocalLocation().getSceneX() == row1) {
          this.MoveToRow(row2);
        } else {
          this.MoveToRow(row1);
        }
      }

    }
  }

  private void MoveToRow(int row) {
    int range = 5;
    int currentY = this.client.getLocalPlayer().getLocalLocation().getSceneY() - 3;
    int yOffset = OneUpUtilityPlugin.getRandomIntBetweenRange(currentY, currentY - range);
    this.mouseTimer.Reset();
    this.mouse.ClickSceneTile(new Point(row, yOffset));
  }

  private void WaterPalmTree() {
    if (this.isPalmWatered) {
      this.isPalmWatered = false;
      this.NextTask();
    } else {
      if (this.clickType != ClickType.UseItemOnObject) {
        if (this.clickType == ClickType.InvItemSelection) {
          this.mouseTimer.Reset();
          this.mouse.ClickNpc(this.palmTree);
        } else {
          this.ClickWaterContainer();
        }
      }

    }
  }

  private void ClickWaterContainer() {
    Widget widget = this.utility.GetInvWidgetItem(27295);
    Point point = this.utility.getRandomPointWithinRec(widget.getCanvasLocation(), widget.getWidth(), widget.getHeight());
    this.mouseTimer.Reset();
    this.mouse.moveMouse(point);
  }

  private void NextTask() {
    ++this.taskIndex;
    this.currentTask = this.taskSequence[this.taskIndex];
  }

  private boolean IsWaterContainerEmpty() {
    return this.utility.InvItemQuantity(27295) > 0;
  }

  private void FillWater(int waterfallIndex) {
    if (this.isContainerFilled) {
      this.isContainerFilled = false;
      this.isFillingContainer = false;
      this.NextTask();
    } else {
      if (this.clickType != ClickType.UseItemOnObject) {
        if (this.clickType == ClickType.InvItemSelection) {
          this.mouseTimer.Reset();
          Point waterfallClickPoint = this.GetSafeWaterfallBoundsPoint(waterfallIndex);
          this.mouse.moveMouse(waterfallClickPoint);
        } else {
          this.ClickWaterContainer();
        }
      }

    }
  }

  private Point GetSafeWaterfallBoundsPoint(int waterfallIndex) {
    Point point = null;

    for(int i = 0; i < 500; ++i) {
      Rectangle waterfallRec = this.waterfallList[waterfallIndex].getConvexHull().getBounds();
      Rectangle resizedWaterfallRec = new Rectangle(waterfallRec.x + waterfallRec.width / 4, waterfallRec.y + waterfallRec.height / 4, waterfallRec.width - waterfallRec.width / 4 * 2, waterfallRec.height - waterfallRec.height / 4 * 2);
      Rectangle waterfallInViewPortBounds = this.utility.GetSafeBounds(resizedWaterfallRec);
      Rectangle statueRec = this.statueList[waterfallIndex].getConvexHull().getBounds();
      Rectangle resizedRec = new Rectangle(statueRec.x - statueRec.width / 15, statueRec.y - statueRec.height / 15, statueRec.width + statueRec.width / 15 * 2, statueRec.height + statueRec.height / 15 * 2);
      point = this.utility.getRandomPointWithinRec(waterfallInViewPortBounds);
      if (point.getX() < resizedRec.x || point.getX() > resizedRec.x + resizedRec.width || point.getY() < resizedRec.y || point.getY() > resizedRec.y + resizedRec.height) {
        return point;
      }
    }

    return null;
  }

  private void MoveToTile(Point tile) {
    this.mouseTimer.Reset();
    LocalPoint localPoint = this.client.getLocalDestinationLocation();
    if (localPoint == null) {
      if (this.client.getLocalPlayer().getLocalLocation().getSceneX() == tile.getX() && this.client.getLocalPlayer().getLocalLocation().getSceneY() == tile.getY()) {
        return;
      }
    } else if (localPoint.getSceneX() == tile.getX() && localPoint.getSceneY() == tile.getY()) {
      return;
    }

    this.mouse.ClickSceneTile(tile);
  }

  public void onMenuOptionClicked(MenuOptionClicked event) {
    if (event.getWidget() != null && event.getWidget().getType() == 5) {
      this.clickType = ClickType.InvItemSelection;
    } else if (event.getMenuOption().equals("Use")) {
      this.clickType = ClickType.UseItemOnObject;
    } else {
      this.clickType = ClickType.Normal;
    }

    this.lastMenuOption = event.getMenuOption();
  }

  public void onGameObjectSpawned(GameObject gameObject) {
    int id = gameObject.getId();
    switch(id) {
      case 45398:
        this.AddWaterfallObject(gameObject);
        break;
      case 45414:
        this.AddStatues(gameObject);
    }

  }

  private void AddStatues(GameObject gameObject) {
    if (gameObject.getWorldLocation().getRegionX() == 39 && gameObject.getWorldLocation().getRegionY() == 7) {
      this.statueList[0] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 25 && gameObject.getWorldLocation().getRegionY() == 7) {
      this.statueList[1] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 25 && gameObject.getWorldLocation().getRegionY() == 56) {
      this.statueList[2] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 39 && gameObject.getWorldLocation().getRegionY() == 56) {
      this.statueList[3] = gameObject;
    }

  }

  private void AddWaterfallObject(GameObject gameObject) {
    if (gameObject.getWorldLocation().getRegionX() == 39 && gameObject.getWorldLocation().getRegionY() == 4) {
      this.waterfallList[0] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 25 && gameObject.getWorldLocation().getRegionY() == 4) {
      this.waterfallList[1] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 25 && gameObject.getWorldLocation().getRegionY() == 60) {
      this.waterfallList[2] = gameObject;
    } else if (gameObject.getWorldLocation().getRegionX() == 39 && gameObject.getWorldLocation().getRegionY() == 60) {
      this.waterfallList[3] = gameObject;
    }

  }

  public void onChatMessage(String message) {
    if (message.contains("fill")) {
      this.isContainerFilled = true;
    } else if (message.contains("water onto the palm")) {
      this.isPalmWatered = true;
    } else if (message.contains("started")) {
      this.isStarted = true;
    }

  }
}