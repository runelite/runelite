/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.zcox;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.util.*;

@PluginDescriptor(
        name = "z_Cox",
        description = "All-in-one plugin for Chambers of Xeric",
        tags = {"CoX"},
        enabledByDefault = false
)

public class CoxPlugin extends Plugin {
    private static final int GAMEOBJECT_ID_PSN = 30032;
    private static final int GRAPHICSOBJECT_ID_CRYSTAL = 1447;
    private static final int GRAPHICSOBJECT_ID_HEAL = 1363;
    private static final int ANIMATION_ID_G1 = 430;

    private boolean needOlm = false;
    @Getter(AccessLevel.PACKAGE)
    private int guardTick = -1;
    @Getter(AccessLevel.PACKAGE)
    private int runGuard = 0;

    int sleepcount = 0;
    @Getter(AccessLevel.PACKAGE)
    private NPC Guard1_NPC;
    @Getter(AccessLevel.PACKAGE)
    private NPC Guard2_NPC;

    @Getter(AccessLevel.PACKAGE)
    private boolean runMutta;


    @Getter(AccessLevel.PACKAGE)
    private NPC Mutta_NPC;

    @Getter(AccessLevel.PACKAGE)
    private NPC Momma_NPC;

    @Getter(AccessLevel.PACKAGE)
    private int OlmPhase = 0;

    @Getter(AccessLevel.PACKAGE)
    private boolean runTekton;

    @Getter(AccessLevel.PACKAGE)
    private NPC Tekton_NPC;

    @Getter(AccessLevel.PACKAGE)
    private boolean runVanguards;

    @Getter(AccessLevel.PACKAGE)
    private NPC meleeVanguard_NPC;


    @Getter(AccessLevel.PACKAGE)
    private NPC mageVanguard_NPC;

    @Getter(AccessLevel.PACKAGE)
    private NPC rangeVanguard_NPC;

    @Getter(AccessLevel.PACKAGE)
    private boolean runOlm;

    @Getter(AccessLevel.PACKAGE)
    private NPC Olm_NPC;

    @Getter(AccessLevel.PACKAGE)
    private NPC OlmMelee_NPC;

    @Getter(AccessLevel.PACKAGE)
    private int Olm_TicksUntilAction = -1;

    @Getter(AccessLevel.PACKAGE)
    private int Olm_ActionCycle = -1; //4:0 = auto 3:0 = null 2:0 = auto 1:0 = spec + actioncycle =4

    @Getter(AccessLevel.PACKAGE)
    private int Olm_NextSpec = -1; // 1= crystals 2=lightnig 3=portals 4= heal hand if p4

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Olm_Crystals = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Olm_Heal = new ArrayList<>();

    @Getter(AccessLevel.PACKAGE)
    private List<WorldPoint> Olm_PSN = new ArrayList<>();

    @Inject
    private ChatMessageManager chatMessageManager;


    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private CoxOverlay overlay;

    @Inject
    private CoxConfig config;

    @Provides
    CoxConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(CoxConfig.class);
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
    public void onChatMessage(ChatMessage chatMessage) {
        MessageNode messageNode = chatMessage.getMessageNode();

        if (messageNode.getValue().toLowerCase().contains("The Great Olm rises with the power of".toLowerCase()) || messageNode.getValue().toLowerCase().contains("!olm".toLowerCase())) {
            System.out.println("finding Olm NPC");
            if (!runOlm) {
                Olm_ActionCycle = -1;
                Olm_TicksUntilAction = 4;
            } else {
                Olm_ActionCycle = -1;
                Olm_TicksUntilAction = 3;
            }
            OlmPhase = 0;
            runOlm = true;
            needOlm = true;
            Olm_NextSpec = -1;
        }

        if (messageNode.getValue().toLowerCase().contains("The Great Olm is giving its all. this is its final stand".toLowerCase())) {
            System.out.println("finding Olm NPC");
            if (!runOlm) {
                Olm_ActionCycle = -1;
                Olm_TicksUntilAction = 4;
            } else {
                Olm_ActionCycle = -1;
                Olm_TicksUntilAction = 3;
            }
            OlmPhase = 1;
            System.out.println("OLM PHASE:" + OlmPhase);
            runOlm = true;
            needOlm = true;
            Olm_NextSpec = -1;
        }
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned) {
        NPC npc = npcSpawned.getNpc();
        switch (npc.getId()) {
            case NpcID.TEKTON:
            case NpcID.TEKTON_7541:
            case NpcID.TEKTON_7542:
            case NpcID.TEKTON_7545:
            case NpcID.TEKTON_ENRAGED:
            case NpcID.TEKTON_ENRAGED_7544:
                runTekton = true;
                Tekton_NPC = npc;
                break;

            case NpcID.MUTTADILE://momadile resting
                Momma_NPC = npc;
                break;
            case NpcID.MUTTADILE_7562:
                runMutta = true;
                Mutta_NPC = npc;
                break;
            case NpcID.MUTTADILE_7563:
                runMutta = true;
                Momma_NPC = npc;
                break;

            //   case NpcID.GREAT_OLM_7554:
            //      System.out.println("Found Olm NPC");
            //      if (!runOlm)
            //        {
            //           Olm_ActionCycle = 4;
            ///            Olm_TicksUntilAction = 4;
            //       } else {
            //            Olm_ActionCycle = 4;
            //           Olm_TicksUntilAction = 3;
            ////         }
            //        OlmPhase++;
            //       System.out.println("OLM PHASE:"+OlmPhase);
            //      runOlm = true;
            //       Olm_NPC = npc;
            //       Olm_NextSpec = 1;
            //        break;
//
            //    case NpcID.GREAT_OLM_LEFT_CLAW:
            //   case NpcID.GREAT_OLM_LEFT_CLAW_7555:
            //       OlmMelee_NPC = npc;
            //       break;
            case NpcID.GUARDIAN:
            case NpcID.GUARDIAN_7570:
                runGuard++;
                if (Guard1_NPC == null) {
                    Guard1_NPC = npc;
                } else {
                    Guard2_NPC = npc;
                }
                break;

            //add vanguards
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned) {
        NPC npc = npcDespawned.getNpc();
        switch (npc.getId()) {
            case NpcID.TEKTON:
            case NpcID.TEKTON_7541:
            case NpcID.TEKTON_7542:
            case NpcID.TEKTON_7545:
            case NpcID.TEKTON_ENRAGED:
            case NpcID.TEKTON_ENRAGED_7544:
                runTekton = false;
                Tekton_NPC = null;
                break;

            case NpcID.MUTTADILE:
                Momma_NPC = null;
                break;
            case NpcID.MUTTADILE_7562:
                Mutta_NPC = null;
                break;

            case NpcID.MUTTADILE_7563:
                runMutta = false;
                Momma_NPC = null;
                break;

            //   case NpcID.GREAT_OLM_7554:
            //      Olm_NPC = null;
            //       break;

            //case NpcID.GREAT_OLM_LEFT_CLAW:
            //  case NpcID.GREAT_OLM_LEFT_CLAW_7555:
          //      OlmMelee_NPC = null;
            //       break;
//
            case NpcID.GUARDIAN:
            case NpcID.GUARDIAN_7570:
                runGuard--;
                if (Guard1_NPC.getId() == npc.getId()) {
                    Guard1_NPC = null;
                } else {
                    Guard2_NPC = null;
                }
                if (runGuard == 0) {
                    guardTick = -1;
                }
                break;
            //add vanguards
        }

    }

    @Subscribe
    public void onGameTick(GameTick event) {

        if (client.getVar(Varbits.IN_RAID) == 0) {
            runOlm = false;
            runGuard = 0;
            runMutta = false;
            runTekton = false;
            needOlm = false;
            OlmPhase = 0;
            sleepcount = 0;
            Olm_Heal.clear();
        } else {

        }
        if (needOlm = true) {
            for (NPC monster : client.getNpcs())
            {
                if (monster.getId() == NpcID.GREAT_OLM) {
                    needOlm = false;
                    Olm_NPC = monster;
                    System.out.println("Found olm Npc");
                    break;
                } else {
                    continue;
                }

            }
        }


        if (runGuard != 0) {
            if (guardTick == -1) {
                if (Guard1_NPC.getAnimation() == ANIMATION_ID_G1) {
                    guardTick = 5;
                }
                if (Guard2_NPC.getAnimation() == ANIMATION_ID_G1) {
                    guardTick = 5;
                }
            } else {
                guardTick--;
            }
            if (guardTick == 0) {
                guardTick = 5;
            }

        }
        if (runOlm) {
            Olm_Crystals.clear();
            Olm_Heal.clear();

            sleepcount--;

            if (Olm_TicksUntilAction == 1) {
                if (Olm_ActionCycle == 1) {
                    Olm_ActionCycle = 4;
                    Olm_TicksUntilAction = 4;
                    if (Olm_NextSpec == 1) {
                        if(OlmPhase == 1) {
                            Olm_NextSpec = 4; // 4 = heal 3= cry 2 = lightn 1 = swap
                        } else {
                            Olm_NextSpec = 3;
                        }

                    } else {
                        Olm_NextSpec--;
                    }



                } else {
                    if(Olm_ActionCycle != -1) {
                        Olm_ActionCycle--;
                    }
                    Olm_TicksUntilAction = 4;
                }

            } else {
                Olm_TicksUntilAction--;
            }

            //for (GameObject i : client.getGameObjects()) {
            //    if (i.getId() == GRAPHICSOBJECT_ID_CRYSTAL) {
            //        WorldPoint newloc;
           //         for (int x = -1; x <= 1; x++) {
            //            for (int y = -1; y <= 1; y++) {
             //               newloc = WorldPoint.fromLocal(client, o.getLocation());

            //                if (config.LargeCrystals()) {
             //                   newloc = newloc.dx(x);
             //                   newloc = newloc.dy(y);
             //               }
             //               Olm_Crystals.add(newloc);
             //           }

             //       }

//
             //   }
             //   if (o.getId() == GRAPHICSOBJECT_ID_HEAL) {
             //       Olm_Heal.add(WorldPoint.fromLocal(client, o.getLocation()));
             //   }
            //}


            for (GraphicsObject o : client.getGraphicsObjects()) {
                if (o.getId() == GRAPHICSOBJECT_ID_CRYSTAL) {
                    WorldPoint newloc;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            newloc = WorldPoint.fromLocal(client, o.getLocation());

                            if (config.LargeCrystals()) {
                                newloc = newloc.dx(x);
                                newloc = newloc.dy(y);
                            }
                            Olm_Crystals.add(newloc);
                        }

                    }


                }

                if(sleepcount <= 0) {
                    if (o.getId() == 1338) {
                        Olm_TicksUntilAction = 1;
                        Olm_NextSpec = 2;
                        Olm_ActionCycle = 4; //spec=1 null=3
                        sleepcount = 5;
                        System.out.println("setting off 1338 id - crystals");
                    }
                    if (o.getId() == 1356) {
                        Olm_TicksUntilAction = 4;
                        Olm_NextSpec = 1;
                        Olm_ActionCycle = 4; //spec=1 null=3
                        sleepcount = 50;
                        System.out.println("setting off 1338 id - lighning");
                    }

                }


                if (o.getId() == GRAPHICSOBJECT_ID_HEAL) {
                    Olm_Heal.add(WorldPoint.fromLocal(client, o.getLocation()));
                }
            }

        }
    }


}
