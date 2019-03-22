/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.ztob;

import java.util.*;
import java.util.Iterator;
import javax.inject.Inject;

import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "xz_Theatre",
        description = "All-in-one plugin for Theatre of Blood",
        tags = {"ToB"},
        enabledByDefault = false
)

public class TheatrePlugin extends Plugin {
    private static final int GRAPHICSOBJECT_ID_MAIDEN = 1579;
    private static final int NPCID_NYLOCAS_PILLAR = 8358;
    private static final int GROUNDOBJECT_ID_BLACKMAZE = 33034;
    private static final int GROUNDOBJECT_ID_REDMAZE = 33035;
    private static final int GROUNDOBJECT_ID_EXHUMED = 32743;
    private static final int ANIMATION_ID_XARPUS = 8059;
    private static final int GRAPHICSOBJECT_ID_YELLOW = 1595;
    private static final int GRAPHICSOBJECT_ID_BLOAT_HAND1 = 1570;
    private static final int GRAPHICSOBJECT_ID_BLOAT_HAND2 = 1571;
    private static final int GRAPHICSOBJECT_ID_BLOAT_HAND3 = 1572;
    private static final int GRAPHICSOBJECT_ID_BLOAT_HAND4 = 1573;
    private static final int GRAPHICSOBJECT_ID_BLOAT_HAND5 = 1576;
    private static final int PROJECTILE_ID_P2RANGE = 1583;
    private static final int PROJECTILE_ID_YELLOW = 1596;
    private static final int ANIMATION_ID_P3_WEB = 8127;
    private static final int ANIMATION_ID_P3_YELLOW = 8126;
    private static final int ANIMATION_ID_P3_MELEE = 8123;
    private static final int ANIMATION_ID_P3_MAGE = 8124;
    private static final int ANIMATION_ID_P3_RANGE = 8125;
    private static final int VERZIK_ID_P3 = NpcID.VERZIK_VITUR_8374;
    private static final int NPC_ID_TORNADO = 8386;
    private static final int PROJECTILE_ID_P3_GREEN = 1598;
    private static final String sotmsg = "A large ball of energy is shot your way...";
    private static final String sotmsg1 = "<col=bf0000>A large ball of energy is shot your way...</col>";

    @Inject
    private ChatMessageManager chatMessageManager;

    @Getter(AccessLevel.PACKAGE)
    private boolean runMaiden;

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Maiden_BloodSpatters = new ArrayList<>();

    private List<NPC> Maiden_Spawns = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Maiden_SpawnLocations = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Maiden_SpawnLocations2 = new ArrayList<>();


    @Getter(AccessLevel.PACKAGE)
    private boolean runBloat;

    @Getter(AccessLevel.PACKAGE)
    private int TickTillEat = 20;

    @Getter(AccessLevel.PACKAGE)
    private NPC Bloat_NPC;

    private int Bloat_downCount;

    @Getter(AccessLevel.PACKAGE)
    private Integer Bloat_State;


    @Getter(AccessLevel.PACKAGE)
    private boolean runNylocas;

    @Getter(AccessLevel.PACKAGE)
    private Map<NPC, Integer> Nylocas_Pillars = new HashMap<>();

    @Getter(AccessLevel.PACKAGE)
    private Map<NPC, Integer> Nylocas_Map = new HashMap<>();


    @Getter(AccessLevel.PACKAGE)
    private boolean runSotetseg;

    @Getter(AccessLevel.PACKAGE)
    private final Map<GroundObject, Tile> RedTiles = new LinkedHashMap<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> RedTilesOverworld = new ArrayList<>();

    private List<WorldPoint> BlackTilesOverworld = new ArrayList<>();

    private List<WorldPoint> BlackTilesUnderworld= new ArrayList<>();

    private List<WorldPoint> RedTilesUnderworld= new ArrayList<>();

    private List<Point> GridPath = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private boolean runXarpus;

    private int Xarpus_previousAnimation;

    @Getter(AccessLevel.PACKAGE)
    private boolean Xarpus_Stare;

    @Getter(AccessLevel.PACKAGE)
    private final Map<GroundObject, Integer> Xarpus_Exhumeds = new HashMap<>();

    @Getter(AccessLevel.PACKAGE)
    private int Xarpus_TicksUntilShoot = 9;

    @Getter(AccessLevel.PACKAGE)
    private NPC Xarpus_NPC;

    @Getter(AccessLevel.PACKAGE)
    private NPC Sotetseg_NPC;

    @Getter(AccessLevel.PACKAGE)
    private boolean runVerzik;

    @Getter(AccessLevel.PACKAGE)
    private final Map<Projectile, WorldPoint> Verzik_RangeProjectiles = new HashMap<>();

    @Getter(AccessLevel.PACKAGE)
    private int P3_TicksUntilAttack = -1;

    @Getter(AccessLevel.PACKAGE)
    private Projectile Verzik_YellowBall;

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Verzik_YellowTiles = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Bloat_Hands = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private NPC Verzik_NPC;

    @Getter(AccessLevel.PACKAGE)
    private NPC Verzik_NPC_P3;

    @Getter(AccessLevel.PACKAGE)
    private NPC Verzik_NPC_P2;

    private int P3_attacksLeft;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private TheatreOverlay overlay;

    @Inject
    private TheatreConfig config;

    @Provides
    TheatreConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(TheatreConfig.class);
    }

    @Override
    protected void startUp() {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned)
    {
        NPC npc = npcSpawned.getNpc();
        switch (npc.getId())
        {
            case NpcID.THE_MAIDEN_OF_SUGADINTI:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8361:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8362:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8363:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8364:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8365:
                runMaiden = true;
                break;
            case NpcID.BLOOD_SPAWN:
                Maiden_Spawns.add(npc);
                break;
            case NpcID.PESTILENT_BLOAT:
                runBloat = true;
                Bloat_NPC = npc;
                break;
            case NPCID_NYLOCAS_PILLAR:
                runNylocas = true;
                if (!Nylocas_Pillars.keySet().contains(npc))
                {
                    Nylocas_Pillars.put(npc, 100);
                }
                break;
            case 8342: case 8343: case 8344: case 8345: case 8346: case 8347:
            case 8348: case 8349: case 8350: case 8351: case 8352: case 8353:
                if (runNylocas)
                {
                    Nylocas_Map.put(npc, 52);
                }
                break;
            case NpcID.SOTETSEG:
            case NpcID.SOTETSEG_8388:
                runSotetseg = true;
                Sotetseg_NPC = npc;
                RedTiles.clear();
                break;
            case NpcID.XARPUS:
            case NpcID.XARPUS_8339:
            case NpcID.XARPUS_8340:
            case NpcID.XARPUS_8341:
                runXarpus = true;
                Xarpus_NPC = npc;
                Xarpus_Stare = false;
                Xarpus_TicksUntilShoot = 9;
                Xarpus_previousAnimation = -1;
                break;
            case NpcID.VERZIK_VITUR_8369:
            case NpcID.VERZIK_VITUR_8370:
            case NpcID.VERZIK_VITUR_8371:
            case NpcID.VERZIK_VITUR_8373:
            case NpcID.VERZIK_VITUR_8375:
                Verzik_NPC = npc;
                runVerzik = true;
                break;

            case NpcID.VERZIK_VITUR_8372:/*p2 spider*/
                Verzik_NPC_P2 = npc;
                runVerzik = true;
                break;

            case NpcID.VERZIK_VITUR_8374:/*p3 spider*/
                P3_TicksUntilAttack = 0;
                P3_attacksLeft = 9;
                Verzik_NPC_P3 = npc;
                runVerzik = true;
                break;
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned) {
        NPC npc = npcDespawned.getNpc();
        switch (npc.getId()) {
            case NpcID.THE_MAIDEN_OF_SUGADINTI:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8361:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8362:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8363:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8364:
            case NpcID.THE_MAIDEN_OF_SUGADINTI_8365:
                runMaiden = false;
                Maiden_Spawns.clear();
                break;
            case NpcID.BLOOD_SPAWN:
                Maiden_Spawns.remove(npc);
                break;
            case NpcID.PESTILENT_BLOAT:
                runBloat = false;
                Bloat_NPC = null;
                break;
            case NPCID_NYLOCAS_PILLAR:
                if (Nylocas_Pillars.keySet().contains(npc))
                {
                    Nylocas_Pillars.remove(npc);
                }
                break;
            case 8342: case 8343: case 8344: case 8345: case 8346: case 8347:
            case 8348: case 8349: case 8350: case 8351: case 8352: case 8353:
                if (Nylocas_Map.keySet().contains(npc))
                {
                    Nylocas_Map.remove(npc);
                }
                break;
            case NpcID.SOTETSEG:
            case NpcID.SOTETSEG_8388:
                RedTiles.clear();
                if (client.getPlane() != 3)
                {
                    runSotetseg = false;
                }
                Sotetseg_NPC = null;
                break;
            case NpcID.XARPUS:
            case NpcID.XARPUS_8339:
            case NpcID.XARPUS_8340:
            case NpcID.XARPUS_8341:
                runXarpus = false;
                Xarpus_NPC = null;
                Xarpus_Stare = false;
                Xarpus_TicksUntilShoot = 9;
                Xarpus_previousAnimation = -1;
                Xarpus_Exhumeds.clear();
                break;
            case NpcID.VERZIK_VITUR_8369:
            case NpcID.VERZIK_VITUR_8370:
            case NpcID.VERZIK_VITUR_8371:/*p2*/

            case NpcID.VERZIK_VITUR_8373:

            case NpcID.VERZIK_VITUR_8375:
                Verzik_NPC = null;
                break;
            case NpcID.VERZIK_VITUR_8372:
                Verzik_NPC_P2 = null;
                break;
            case NpcID.VERZIK_VITUR_8374:/*p3 spider*/
                Verzik_NPC_P3 = null;
                break;

        }

    }

    @Subscribe
    public void onGroundObjectSpawned(GroundObjectSpawned event)
    {
        if (runSotetseg)
        {
            GroundObject o = event.getGroundObject();
            if (o.getId() == GROUNDOBJECT_ID_BLACKMAZE)
            {
                Tile t = event.getTile();
                WorldPoint p = t.getWorldLocation();
                if (t.getPlane() == 0)
                {
                    if (!BlackTilesOverworld.contains(p))
                        BlackTilesOverworld.add(p);
                }
                else
                {
                    if (!BlackTilesUnderworld.contains(p))
                        BlackTilesUnderworld.add(p);
                }
            }

            if (o.getId() == GROUNDOBJECT_ID_REDMAZE)
            {
                Tile t = event.getTile();
                WorldPoint p = t.getWorldLocation();
                if (p.getPlane() == 0)
                {
                    if (!RedTiles.containsValue(t))
                    {
                        RedTiles.put(o,t);
                    }
                }
                else
                {
                    if (!RedTilesUnderworld.contains(p))
                        RedTilesUnderworld.add(p);
                }
            }
        }

        if (runXarpus)
        {
            GroundObject o = event.getGroundObject();
            if (o.getId() == GROUNDOBJECT_ID_EXHUMED)
            {
                Xarpus_Exhumeds.put(o, 18);
            }
        }
    }

    @Subscribe
    public void onProjectileMoved(ProjectileMoved event)
    {
        if (runVerzik)
        {
            Projectile projectile = event.getProjectile();
            if (projectile.getId() == PROJECTILE_ID_P2RANGE)
            {
                WorldPoint p = WorldPoint.fromLocal(client,event.getPosition());
                Verzik_RangeProjectiles.put(projectile, p);
            }
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage)
    {
        MessageNode messageNode = chatMessage.getMessageNode();

        if (messageNode.getValue().toLowerCase().contains(sotmsg.toLowerCase()))
        {
            TickTillEat = 20;
            /*20 ticks*/

        }


    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (runMaiden)
        {
            Maiden_BloodSpatters.clear();
            for (GraphicsObject o : client.getGraphicsObjects())
            {
                if (o.getId() == GRAPHICSOBJECT_ID_MAIDEN)
                {
                    Maiden_BloodSpatters.add(WorldPoint.fromLocal(client, o.getLocation()));
                }
            }

            Maiden_SpawnLocations2.clear();
            Maiden_SpawnLocations2.addAll(Maiden_SpawnLocations);
            Maiden_SpawnLocations.clear();
            for (NPC spawn : Maiden_Spawns)
            {
                Maiden_SpawnLocations.add(spawn.getWorldLocation());
            }
        }

        if (runBloat)
        {

            Bloat_downCount++;

            Bloat_Hands.clear();
            for (GraphicsObject o : client.getGraphicsObjects())
            {
                if (o.getId() == GRAPHICSOBJECT_ID_BLOAT_HAND1 || o.getId() == GRAPHICSOBJECT_ID_BLOAT_HAND2 || o.getId() == GRAPHICSOBJECT_ID_BLOAT_HAND3 || o.getId() == GRAPHICSOBJECT_ID_BLOAT_HAND4|| o.getId() == GRAPHICSOBJECT_ID_BLOAT_HAND5)
                {
                    Bloat_Hands.add(WorldPoint.fromLocal(client, o.getLocation()));
                }
            }


            if (Bloat_NPC.getAnimation() == -1) //1 = up; 2 = down; 3 = warn;
            {
                Bloat_downCount = 0;
                if (Bloat_NPC.getHealth() == 0)
                {
                    Bloat_State = 2;
                }
                else
                    Bloat_State = 1;
            }
            else
            {
                if (25<Bloat_downCount && Bloat_downCount<35)
                {
                    Bloat_State = 3;
                }
                else if (Bloat_downCount < 26)
                {
                    Bloat_State = 2;
                }
                else if (Bloat_NPC.getModelHeight() == 568)
                {
                    Bloat_State = 2;
                }
                else
                    Bloat_State = 1;
            }
        }

        if (runNylocas)
        {
            for (Iterator<NPC> it = Nylocas_Map.keySet().iterator(); it.hasNext();)
            {
                NPC npc = it.next();
                int ticksLeft = Nylocas_Map.get(npc);

                if (ticksLeft < 0)
                {
                    it.remove();
                    continue;
                }
                Nylocas_Map.replace(npc, ticksLeft - 1);
            }

            for (NPC pillar : Nylocas_Pillars.keySet())
            {
                int healthPercent = pillar.getHealthRatio();
                if (healthPercent > -1)
                {
                    Nylocas_Pillars.replace(pillar, healthPercent);
                }
            }
            for (NPC npc : client.getNpcs())
            {
                if (npc.getId() == 8358)
                {
                    runNylocas = true;
                    break;
                }
                runNylocas = false;
            }
        }

        if (runSotetseg)
        {
            TickTillEat--;
            boolean sotetsegFighting = false;
            for (NPC npc : client.getNpcs())
            {
                if (npc.getId() == NpcID.SOTETSEG_8388)
                {
                    BlackTilesUnderworld.clear();
                    BlackTilesOverworld.clear();
                    RedTilesOverworld.clear();
                    RedTilesUnderworld.clear();
                    GridPath.clear();
                    sotetsegFighting = true;
                    RedTiles.clear();
                    break;
                }
            }

            if (!sotetsegFighting)
            {
                if (!BlackTilesUnderworld.isEmpty() && !RedTilesUnderworld.isEmpty() && GridPath.isEmpty())
                {
                    int minX = 99999;
                    int minY = 99999;
                    for (WorldPoint p : BlackTilesUnderworld)
                    {
                        int x = p.getX();
                        int y = p.getY();
                        if (x < minX)
                        {
                            minX = x;
                        }
                        if (y < minY)
                        {
                            minY = y;
                        }
                    }



                    boolean messageSent = false;
                    for (WorldPoint p : RedTilesUnderworld)
                    {
                        WorldPoint pN = new WorldPoint(p.getX(), p.getY() + 1, p.getPlane());
                        WorldPoint pS = new WorldPoint(p.getX(), p.getY() - 1, p.getPlane());
                        WorldPoint pE = new WorldPoint(p.getX() + 1, p.getY(), p.getPlane());
                        WorldPoint pW = new WorldPoint(p.getX() - 1, p.getY(), p.getPlane());

                        if ( !(     (RedTilesUnderworld.contains(pN) && RedTilesUnderworld.contains(pS)) ||
                                (RedTilesUnderworld.contains(pE) && RedTilesUnderworld.contains(pW))        )   )
                        {
                            GridPath.add(new Point(p.getX() - minX, p.getY() - minY));
                            if (!messageSent)
                            {
                                //client.addChatMessage(ChatMessageType.SERVER, "", "Maze path acquired.", null);
                                messageSent = true;
                            }
                        }

                    }
                }

                if (!BlackTilesOverworld.isEmpty() && !GridPath.isEmpty() && RedTilesOverworld.isEmpty())
                {
                    int minX = 99999;
                    int minY = 99999;
                    for (WorldPoint p : BlackTilesOverworld)
                    {
                        int x = p.getX();
                        int y = p.getY();
                        if (x < minX)
                        {
                            minX = x;
                        }
                        if (y < minY)
                        {
                            minY = y;
                        }
                    }
                    for (Point p : GridPath)
                    {
                        RedTilesOverworld.add(new WorldPoint(minX + p.getX(), minY + p.getY(), 0));
                    }
                }
            }
        }

        if (runXarpus)
        {
            for (Iterator<GroundObject> it = Xarpus_Exhumeds.keySet().iterator(); it.hasNext();)
            {
                GroundObject key = it.next();
                Xarpus_Exhumeds.replace(key, Xarpus_Exhumeds.get(key) - 1);
                if (Xarpus_Exhumeds.get(key) < 0)
                {
                    it.remove();
                }
            }
            if (Xarpus_NPC != null )
            {
                //Xarpus_Stare = true;
            }
            if (Xarpus_Stare)
            {
                //dont hit xarpus if it looking at u
            }
            else if (Xarpus_NPC.getId() == NpcID.XARPUS_8340)
            {
                Xarpus_TicksUntilShoot--;
                if (Xarpus_NPC.getAnimation() == ANIMATION_ID_XARPUS && Xarpus_previousAnimation != ANIMATION_ID_XARPUS)
                {
                    Xarpus_TicksUntilShoot = 3;
                }
                Xarpus_previousAnimation = Xarpus_NPC.getAnimation();
            }

        }

        if (runVerzik)
        {
            if (!Verzik_RangeProjectiles.isEmpty())
            {
                for (Iterator<Projectile> it = Verzik_RangeProjectiles.keySet().iterator(); it.hasNext();)
                {
                    Projectile projectile = it.next();
                    if (projectile.getRemainingCycles() < 1)
                    {
                        it.remove();
                    }
                }
            }

            Verzik_YellowBall = null;
            Verzik_YellowTiles.clear();

            for (Projectile projectile : client.getProjectiles())
            {
                if (projectile.getId() == PROJECTILE_ID_YELLOW)
                {
                    Verzik_YellowBall = projectile;
                    break;
                }
            }
            for (GraphicsObject o : client.getGraphicsObjects())
            {
                if (o.getId() == GRAPHICSOBJECT_ID_YELLOW)
                {
                    Verzik_YellowTiles.add(WorldPoint.fromLocal(client, o.getLocation()));
                }
            }

            for (NPC npc : client.getNpcs())
            {
                if (npc.getId() == 8379)
                {
                    runVerzik = true;
                    break;
                }
                runVerzik = false;
            }


            if (Verzik_NPC_P3 != null) {
                boolean tornadosActive = false;
                for (NPC npc : client.getNpcs())
                {
                    if (npc.getId() == NPC_ID_TORNADO)
                    {
                        tornadosActive = true;
                        break;
                    }
                }

                boolean isGreenBall = false;
                for (Projectile projectile : client.getProjectiles())
                {
                    if (projectile.getId() == PROJECTILE_ID_P3_GREEN) {
                        isGreenBall = projectile.getRemainingCycles() > 210;
                        break;
                    }
                }
                P3_TicksUntilAttack--;

                switch (Verzik_NPC_P3.getAnimation()) {
                    case ANIMATION_ID_P3_MAGE:
                        if (P3_TicksUntilAttack < 2) {
                            P3_attacksLeft--;
                            if (tornadosActive) {
                                P3_TicksUntilAttack = 5;
                            } else {
                                P3_TicksUntilAttack = 7;
                            }
                            if (P3_attacksLeft < 1) {
                                P3_TicksUntilAttack = 24;
                            }
                        }
                        break;
                    case ANIMATION_ID_P3_RANGE:
                        if (P3_TicksUntilAttack < 2) {
                            P3_attacksLeft--;
                            if (tornadosActive) {
                                P3_TicksUntilAttack = 5;
                            } else {
                                P3_TicksUntilAttack = 7;
                            }
                            if (P3_attacksLeft < 1) {
                                P3_TicksUntilAttack = 30;
                            }
                            if (isGreenBall) {
                                P3_TicksUntilAttack = 12;
                            }
                        }
                        break;
                    case ANIMATION_ID_P3_MELEE:
                        if (P3_TicksUntilAttack < 2) {
                            P3_attacksLeft--;
                            if (tornadosActive) {
                                P3_TicksUntilAttack = 5;
                            } else {
                                P3_TicksUntilAttack = 7;
                            }
                            if (P3_attacksLeft < 1) {
                                P3_TicksUntilAttack = 24;
                            }
                        }
                        break;
                    case ANIMATION_ID_P3_WEB:
                        P3_attacksLeft = 4;
                        P3_TicksUntilAttack = 11; //
                        break;
                    case ANIMATION_ID_P3_YELLOW:
                        P3_attacksLeft = 14;
                        P3_TicksUntilAttack = 11;
                        break;
                }
            }

        }
    }

}
