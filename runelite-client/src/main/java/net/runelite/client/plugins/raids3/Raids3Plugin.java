package net.runelite.client.plugins.raids3;

import com.google.inject.Provides;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
//import net.runelite.client.plugins.oneupahk.MacroCombatPlugin;
//import net.runelite.client.plugins.oneupahk.MacroProfile;
//import net.runelite.client.plugins.oneupahk.UserMacro;
import net.runelite.client.plugins.raids3.Akkha.Akkha;
import net.runelite.client.plugins.raids3.AttackContainers.GroundAttack;
import net.runelite.client.plugins.raids3.Baba.Baba;
import net.runelite.client.plugins.raids3.BaboonRoom.BaboonRoom;
import net.runelite.client.plugins.raids3.Kephri.Kephri;
import net.runelite.client.plugins.raids3.Warden.Warden;
import net.runelite.client.plugins.raids3.overlays.BeamTickOverlay;
import net.runelite.client.plugins.raids3.overlays.InfoOverlay;
import net.runelite.client.plugins.raids3.overlays.NPCTickOverlay;
import net.runelite.client.plugins.raids3.overlays.PrayerOverlay;
import net.runelite.client.plugins.raids3.overlays.Raids3Overlay;
import net.runelite.client.plugins.raids3.PuzzleRoom.PuzzleRoom;
import net.runelite.client.plugins.raids3.PuzzleRoom.PuzzleRoomOverlay;
import net.runelite.client.plugins.raids3.Warden.Warden;
import net.runelite.client.plugins.raids3.Warden.WardenRoomOverlay;
import net.runelite.client.plugins.raids3.zebak.Zebak;
import net.runelite.client.plugins.raids3Util.KeyboardUtils;
import net.runelite.client.plugins.raids3Util.MouseUtils;
//import net.runelite.client.plugins.raids3Util.MouseUtils2;
import net.runelite.client.plugins.raids3Util.OneUpUtilityConfig;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;
import net.runelite.client.plugins.raids3Util.TabType;
import net.runelite.client.plugins.raids3Util.Utility;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
    name = "1Up Raids3",
    description = "Raids 3 Helper",
    tags = {"highlight", "overlay"},
    enabledByDefault = false
)
public class Raids3Plugin extends Plugin {
  @Inject
  private ChatMessageManager chatMessageManager;
  @Inject
  private Client client;
  @Inject
  public Raids3Config config;
  @Inject
  private OverlayManager overlayManager;
  @Inject
  private Raids3Overlay overlay;
  @Inject
  private PrayerOverlay prayerOverlay;
  @Inject
  private InfoOverlay infoOverlay;
  @Inject
  private WardenRoomOverlay wardenRoomOverlay;
  @Inject
  private PuzzleRoomOverlay puzzleRoomOverlay;
  @Inject
  private NPCTickOverlay npcTickOverlay;
  @Inject
  private BeamTickOverlay beamTickOverlay;
  @Inject
  public KeyboardUtils keyboardUtils;
  @Inject
  private ConfigManager configManager;
  @Inject
  public MouseUtils mouse;
  @Inject
  private ItemManager itemManager;
  @Inject
  private MouseManager mouseManager;
  @Inject
  ClientThread clientThread;
  private final int BABA_GROUND_PROJECTILE1 = 1446;
  private final int BABA_GROUND_PROJECTILE3 = 2111;
  private final int RED_SKULL1 = 2134;
  private final int RED_SKULL2 = 2135;
  private final int baboonBoulderID = 11783;
  private final int wardenObeliskID = 11750;
  private static final int ENERGY_SIPHON = 11772;
  public MenuSwapperUtility menuSwapperUtility;
  public Prayer currentProtectionPrayer = null;
  public TOA_Rooms currentRoom;
  public List<GroundAttack> groundAttacks;
  public List<GroundAttack> explodingOrbGroundAttacks;
  public int mirrorRoomBeamCt;
  public NPC currentNPC;
  public NPC zebakNpc;
  public NPC akkhaNpc;
  public PuzzleRoom puzzleRoom;
  public BaboonRoom baboonRoom;
  public Zebak zebakRoom;
  public Warden wardenRoom;
  public Akkha akkhaRoom;
  public Baba babaRoom;
  public Kephri kephriRoom;
  public NPC babaNPC;
  public boolean npcManagerOn;
  public Utility utility;
  private NPC wardenNPC;
  private double tabWaitTime;
  private double tabStartTime;
  final int teleportCrystalID;
  public GameObject teleportCrystalObject;
  public PrayerPriorityQue prayerQue;
  private Timer prayerTimer;
  public NPC testWardenNPC;

  public Raids3Plugin() {
    this.currentRoom = TOA_Rooms.STARTING_ROOM;
    this.groundAttacks = new ArrayList();
    this.explodingOrbGroundAttacks = new ArrayList();
    this.mirrorRoomBeamCt = -1;
    this.zebakNpc = null;
    this.akkhaNpc = null;
    this.babaNPC = null;
    this.npcManagerOn = false;
    this.tabWaitTime = 0.0D;
    this.tabStartTime = 0.0D;
    this.teleportCrystalID = 45754;
    this.prayerTimer = new Timer(150, 350);
    this.testWardenNPC = null;
  }

  @Provides
  Raids3Config provideConfig(ConfigManager configManager) {
    return (Raids3Config)configManager.getConfig(Raids3Config.class);
  }

  protected void startUp() throws Exception {

    this.overlayManager.add(this.overlay);
    this.overlayManager.add(this.beamTickOverlay);
    this.overlayManager.add(this.infoOverlay);
    this.overlayManager.add(this.prayerOverlay);
    this.overlayManager.add(this.wardenRoomOverlay);
    this.overlayManager.add(this.puzzleRoomOverlay);
    this.overlayManager.add(this.npcTickOverlay);
    this.utility = new Utility(this.client, this.keyboardUtils, this.mouse, this.configManager, this.itemManager);
    this.puzzleRoom = new PuzzleRoom(this.utility);
    this.menuSwapperUtility = new MenuSwapperUtility(this.client);
    this.zebakRoom = new Zebak(this.client, this);
    this.baboonRoom = new BaboonRoom(this.client, this);
    this.wardenRoom = new Warden(this.client, this);
    this.akkhaRoom = new Akkha(this.client, this.utility, this, this.config);
    this.babaRoom = new Baba(this.client, this.utility, this, this.config);
    this.kephriRoom = new Kephri(this.client, this.utility, this, this.config);
    this.prayerQue = new PrayerPriorityQue(this);
  }

  protected void shutDown() throws Exception {
    this.overlayManager.remove(this.overlay);
    this.overlayManager.remove(this.beamTickOverlay);
    this.overlayManager.remove(this.infoOverlay);
    this.overlayManager.remove(this.prayerOverlay);
    this.overlayManager.remove(this.wardenRoomOverlay);
    this.overlayManager.remove(this.puzzleRoomOverlay);
  }

  @Subscribe
  public void onClientTick(ClientTick clientTick) {
    this.menuSwapperUtility.onClientTick();
  }

  @Subscribe
  public void onGameStateChanged(GameStateChanged gameStateChanged) {
  }

  @Subscribe
  public void onNpcChanged(NpcChanged npcChanged) {
    if (this.currentRoom == TOA_Rooms.PUZZLE_ROOM) {
      this.puzzleRoom.OnNpcChanged(npcChanged);
    } else if (this.currentRoom == TOA_Rooms.WARDEN_ROOM) {
      this.wardenRoom.onNPCChanged(npcChanged);
    } else if (this.currentRoom == TOA_Rooms.AKKHA_ROOM && npcChanged.getNpc().getName().equals("Akkha")) {
      this.akkhaRoom.onNpcChanged();
    }

  }

  @Subscribe
  public void onNpcDespawned(NpcDespawned npcDespawned) {
    NPC npc = npcDespawned.getNpc();
    if (npc != null) {
      if (this.currentRoom == TOA_Rooms.KEPHRI_ROOM) {
        this.kephriRoom.OnNpcDespawned(npc);
      } else if (npc.getName().equalsIgnoreCase("Kephri")) {
        this.currentProtectionPrayer = null;
      } else if (npc.getName().equalsIgnoreCase("Zebak")) {
        this.currentProtectionPrayer = null;
      } else if (npc.getName().equalsIgnoreCase("Crondis")) {
        this.currentProtectionPrayer = null;
      } else if (npc.getName().equalsIgnoreCase("Osmumten")) {
        this.currentProtectionPrayer = null;
      } else if (Arrays.stream(this.akkhaRoom.TRAILING_ORB_IDs).anyMatch((s) -> {
        return s == npc.getId();
      })) {
        this.akkhaRoom.explodingOrbs.remove(npc);
        this.DebugLog("Exploding Orbs Ct: " + this.akkhaRoom.explodingOrbs.size());
      }

    }
  }

  @Subscribe
  public void onNpcSpawned(NpcSpawned npcSpawned) {
    NPC npc = npcSpawned.getNpc();
    if (npc != null && npc.getName() != null) {
      if (this.currentRoom == TOA_Rooms.PUZZLE_ROOM) {
        this.puzzleRoom.OnNpcSpawned(npc);
      } else if (this.currentRoom == TOA_Rooms.KEPHRI_ROOM) {
        this.kephriRoom.OnNpcSpawned(npc);
      }

      if (npc.getId() == 11706) {
        this.UpdateRoomStatus(TOA_Rooms.MIRROR_ROOM);
      } else if (npc.getId() == 11700) {
        this.UpdateRoomStatus(TOA_Rooms.PALM_ROOM);
      } else if (npc.getName().equalsIgnoreCase("Ba-Ba")) {
        this.babaNPC = npc;
        this.currentNPC = npc;
        this.UpdateRoomStatus(TOA_Rooms.BABA_ROOM);
      } else if (npc.getId() == 11750) {
        this.UpdateRoomStatus(TOA_Rooms.WARDEN_ROOM);
      } else if (npc.getId() == 11783) {
        this.babaRoom.rollingBoulders.add(npc);
      } else if (npc.getName().equalsIgnoreCase("Akkha")) {
        this.UpdateRoomStatus(TOA_Rooms.AKKHA_ROOM);
        this.akkhaNpc = npc;
        this.currentNPC = npc;
      } else if (npc.getName().equalsIgnoreCase("Zebak")) {
        this.UpdateRoomStatus(TOA_Rooms.ZEBAK_ROOM);
        this.zebakNpc = npc;
        this.currentNPC = npc;
      } else if (npc.getId() == 11761) {
        this.wardenNPC = npc;
        this.currentNPC = npc;
      } else if (npc.getId() == 11772) {
        this.groundAttacks.add(new GroundAttack(this.utility.SceneFromLocal(npc.getLocalLocation()), this.wardenRoom.GetSiphonDespawnSpeed(), Color.RED, false, false));
        this.wardenRoom.TurnOnSiphonPhase();
      } else if (Arrays.stream(this.akkhaRoom.TRAILING_ORB_IDs).anyMatch((s) -> {
        return s == npc.getId();
      })) {
        this.akkhaRoom.explodingOrbs.add(npc);
      } else if (npc.getName().equalsIgnoreCase("Kephri")) {
        this.currentNPC = npc;
        this.UpdateRoomStatus(TOA_Rooms.KEPHRI_ROOM);
      } else if (!npc.getName().equals("Osmumten") && npc.getId() != 11689) {
        if (npc.getName().equalsIgnoreCase("Elidinis' Warden")) {
          this.wardenRoom.elidinisWardenNPC = npc;
        }
      } else {
        this.zebakRoom.Reset();
        this.ResetPrayer();
      }

    }
  }

  private void ResetPrayer() {
    this.currentProtectionPrayer = null;
    this.prayerQue.que.clear();
    this.prayerQue.prayerPriority = null;
  }

  @Subscribe
  public void onBeforeRender(BeforeRender br) {
    if (this.client.getGameState() == GameState.LOGGED_IN) {
      if (this.currentRoom == TOA_Rooms.AKKHA_ROOM) {
        this.akkhaRoom.onBeforeRender();
      } else {
        switch(this.currentRoom) {
          case ZEBAK_ROOM:
            break;
          case WARDEN_ROOM:
            break;
          default:
            return;
        }
        this.currentProtectionPrayer = this.prayerQue.prayerPriority;
        this.prayerQue.HandleQue();
      }
    }
  }

  @Subscribe
  private void onInteractingChanged(InteractingChanged event) {
    if (event.getTarget() != null) {
      try {
        if (this.currentRoom == TOA_Rooms.PUZZLE_ROOM) {
          this.puzzleRoom.lastPillarInteractedWith = (NPC)event.getTarget();
        }
      } catch (Exception var3) {
      }

    }
  }

  @Subscribe
  public void onGameTick(GameTick event) {
    if (!this.npcManagerOn) {
      if (this.client.getGameState() == GameState.LOGGED_IN) {
        if (this.currentRoom == TOA_Rooms.WARDEN_ROOM) {
          this.DebugLog("PrayerQue: " + this.prayerQue.que.size());
        }

        this.prayerQue.onGameTick();
        this.GroundAttacks();
        this.testWardenNPC = this.utility.FindNPC("Tumeken's Warden");
        if (this.zebakNpc != null && this.zebakNpc.isDead()) {
          this.zebakNpc = null;
        }

        switch(this.currentRoom) {
          case ZEBAK_ROOM:
            this.zebakRoom.onGameTick();
            break;
          case WARDEN_ROOM:
            this.wardenRoom.onGameTick();
          case STARTING_ROOM:
          case PATH_ROOM:
          case PALM_ROOM:
          case PUZZLE_ROOM:
          default:
            break;
          case BABOON_ROOM:
            this.baboonRoom.onGameTick();
            break;
          case BABA_ROOM:
            this.babaRoom.onGameTick();
            break;
          case MIRROR_ROOM:
            --this.mirrorRoomBeamCt;
            break;
          case AKKHA_ROOM:
            this.akkhaRoom.onGameTick();
            break;
          case KEPHRI_ROOM:
            this.kephriRoom.onGameTick();
        }

      }
    }
  }

  private void GroundAttacks() {
    Iterator var1 = this.groundAttacks.iterator();

    GroundAttack groundAttack;
    while(var1.hasNext()) {
      groundAttack = (GroundAttack)var1.next();
      groundAttack.onGameTick();
    }

    if (this.groundAttacks.size() > 0) {
      this.groundAttacks.removeIf(GroundAttack::isOver);
    }

    var1 = this.explodingOrbGroundAttacks.iterator();

    while(var1.hasNext()) {
      groundAttack = (GroundAttack)var1.next();
      groundAttack.onGameTick();
    }

    if (this.explodingOrbGroundAttacks.size() > 0) {
      this.explodingOrbGroundAttacks.removeIf(GroundAttack::isOver);
    }

  }

  @Subscribe
  public void onProjectileMoved(ProjectileMoved event) {
    if (!this.npcManagerOn) {
      if (this.currentRoom != TOA_Rooms.AKKHA_ROOM) {
        if (this.currentRoom == TOA_Rooms.KEPHRI_ROOM) {
          this.kephriRoom.onProjectileMoved(event);
        } else if (this.currentRoom == TOA_Rooms.WARDEN_ROOM) {
          this.wardenRoom.onProjectileMoved(event);
        } else if (this.currentRoom == TOA_Rooms.ZEBAK_ROOM) {
          this.zebakRoom.onProjectileMoved(event.getProjectile());
        }

      }
    }
  }

  @Subscribe
  private void onGraphicsObjectCreated(GraphicsObjectCreated event) {
    if (this.currentRoom == TOA_Rooms.BABA_ROOM) {
      this.babaRoom.onGraphicsObjectCreated(event);
    }

    if (this.currentRoom == TOA_Rooms.WARDEN_ROOM) {
      this.wardenRoom.onGraphicsObjectCreated(event.getGraphicsObject());
    }

    switch(event.getGraphicsObject().getId()) {
      case 316:
      case 317:
        if (this.config.HighlightFallingBoulders()) {
          Point scenePoint = this.utility.SceneFromLocal(event.getGraphicsObject().getLocation());
          this.groundAttacks.add(new GroundAttack(scenePoint, 7, this.config.FallingBoulderColor(), true, false));
        }
      case 1446:
      case 2111:
      default:
        break;
      case 2114:
        this.mirrorRoomBeamCt = 9;
        break;
      case 2134:
      case 2135:
        this.baboonRoom.HandleBaboonRedSkull(new Point(event.getGraphicsObject().getLocation().getSceneX(), event.getGraphicsObject().getLocation().getSceneY()));
        break;
      case 2256:
      case 2257:
      case 2259:
        this.akkhaRoom.isMemoryAttackStarting = true;
    }

  }

  @Subscribe
  public void onChatMessage(ChatMessage event) {
    if (event.getType() == ChatMessageType.GAMEMESSAGE) {

      if (this.currentRoom == TOA_Rooms.PUZZLE_ROOM) {
        this.puzzleRoom.OnChatMessage(event.getMessage());
      }

      if (this.currentRoom == TOA_Rooms.BABOON_ROOM) {
        this.baboonRoom.onChatMessage(event.getMessage());
      }

      if (event.getMessage().contains("Warden uses the last of its power to restore")) {
        this.DebugLog("Phase 3");
        this.wardenRoom.StartPhase3();
      }

      if (event.getMessage().contains("You have died.")) {
        this.akkhaRoom.Reset();
        this.puzzleRoom.Reset();
        this.babaRoom.Reset();
        this.zebakRoom.Reset();
        this.ResetPrayer();
      } else if (event.getMessage().contains("Challenge started: Path of Het.")) {
        this.mirrorRoomBeamCt = 9;
      } else if (event.getMessage().contains("Ba-Ba screams and knocks you back!")) {
        ++this.babaRoom.boulderAttackCt;
      } else if (event.getMessage().contains("Challenge complete")) {
        this.baboonRoom.redSkullGameTick = -1;
        this.currentProtectionPrayer = null;
        this.puzzleRoom.Reset();
      }

    }
  }

  @Subscribe
  private void onGroundObjectSpawned(GroundObjectSpawned event) {
    switch(event.getGroundObject().getId()) {
      case 45357:
      case 45359:
      case 45361:
      case 45363:
      case 45364:
        this.puzzleRoom.memoryTiles.add(event.getGroundObject());
      case 45358:
      case 45360:
      case 45362:
      default:
    }
  }

  @Subscribe
  private void onGroundObjectDespawned(GroundObjectDespawned event) {
    switch(event.getGroundObject().getId()) {
      case 45357:
      case 45359:
      case 45361:
      case 45363:
      case 45364:
        this.puzzleRoom.memoryTiles.removeIf((t) -> {
          return t.getLocalLocation().equals(event.getGroundObject().getLocalLocation());
        });
      case 45358:
      case 45360:
      case 45362:
      default:
    }
  }

  @Subscribe
  private void onGameObjectDespawned(GameObjectDespawned event) {
    this.wardenRoom.onGameObjectDespawned(event);
  }

  @Subscribe
  private void onGameObjectSpawned(GameObjectSpawned event) {
    if (!this.npcManagerOn) {
      switch(this.currentRoom) {
        case WARDEN_ROOM:
          this.wardenRoom.onGameObjectSpawned(event);
          break;
        case PUZZLE_ROOM:
          this.puzzleRoom.onGameObjectSpawned(event);
          break;
        case AKKHA_ROOM:
          this.akkhaRoom.onGameObjectSpawned(event);
      }

      switch(event.getGameObject().getId()) {
        case 45205:
          this.UpdateRoomStatus(TOA_Rooms.PUZZLE_ROOM);
          break;
        case 45398:
        case 45496:
          this.UpdateRoomStatus(TOA_Rooms.BABOON_ROOM);
          break;
        case 45754:
          this.teleportCrystalObject = event.getGameObject();
          break;
        case 46068:
          this.UpdateRoomStatus(TOA_Rooms.STARTING_ROOM);
          break;
        case 46167:
          this.UpdateRoomStatus(TOA_Rooms.PATH_ROOM);
      }

    }
  }

  public void UpdateRoomStatus(TOA_Rooms toa_room) {
    this.currentRoom = toa_room;
    switch(toa_room) {
      case STARTING_ROOM:
      case PATH_ROOM:
        this.ResetRaid();
      case BABOON_ROOM:
      case BABA_ROOM:
      case MIRROR_ROOM:
      case PALM_ROOM:
      default:
        break;
      case PUZZLE_ROOM:
        this.puzzleRoom.Reset();
    }

  }

  private void ResetRaid() {
    this.currentProtectionPrayer = null;
    this.wardenRoom.Reset();
    this.puzzleRoom.Reset();
  }

  private boolean NoPrayerPoints() {
    return this.client.getBoostedSkillLevel(Skill.PRAYER) == 0;
  }

  public Point getRandomPointWithinRec(Point point, int width, int height) {
    return new Point(this.getRandomIntBetweenRange(point.getX(), point.getX() + width), this.getRandomIntBetweenRange(point.getY(), point.getY() + height));
  }

  public int getRandomIntBetweenRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public void DebugLog(String message) {
    System.out.println(message);
  }
}