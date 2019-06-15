package net.runelite.client.plugins.olmattackcounter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.Getter;
import lombok.AccessLevel;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.events.ChatMessage;

@PluginDescriptor(
        name = "Olm Attack Counter",
        description = "Counts olms attacks in a raid",
        tags = {"combat", "pvm", "pve"}
)

public class OlmAttackCounterPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private OlmAttackCounterOverlay overlay;

    @Inject
    private ClientThread clientThread;

    @Getter
    private OlmHead olmHead;

    @Getter(AccessLevel.PACKAGE)
    private OlmSession session;

    private List<Integer> attackStyles = new ArrayList();

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
        session = new OlmSession();
        for (int attack : OlmHead.ALL_ATTACK_STYLES)
        {
            attackStyles.add(attack);
        }
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        session = null;
        attackStyles = null;
    }


    @Subscribe
    public void onGameTick(GameTick gameTick)
    {
        final int currentTick = client.getTickCount();
        // System.out.println("current tick: " + currentTick);

        if (olmHead == null) // intermission, crystal bomb and ceiling crystals have the same ID
        {
            return;
        }

        if (olmHead.getLastAutoTick() != -1 && olmHead.getLastAutoTick() + 8 > currentTick)
        {
            return;
        }



        for (Projectile projectile : client.getProjectiles())
        {
            int projectileId = projectile.getId();

            olmHead.setLastAutoTick(currentTick);

            if (attackStyles.contains(projectileId))
            {
                System.out.println("Olm Attacks!");
                System.out.println("tick:       " + currentTick);

                switch (projectileId)
                {
                    case ProjectileID.OLM_RANGE_AUTO:
                        session.increaseRangeAmount();
                        System.out.println("Ranged Attack");
                        olmHead.setLastAutoID(OlmHead.RANGE_AUTO);
                        break;

                    case ProjectileID.OLM_MAGE_AUTO:
                        session.increaseMageAmount();
                        System.out.println("Mage Attack");
                        olmHead.setLastAutoID(OlmHead.MAGE_AUTO);
                        break;

                    case ProjectileID.OLM_ACID_DRIP:
                        System.out.println("Acid Attack");
                        session.increaseDripAmount();
                        break;

            /*case ProjectileID.OLM_ACID_SPREAD:
                session.increaseSprayAmount();*/

                    case ProjectileID.OLM_FLAME_WALL:
                        System.out.println("Flame Wall");
                        session.increaseWallAmount();
                        break;

                    case ProjectileID.OLM_BURN:
                        System.out.println("Burn Attack");
                        session.increaseBurnAmount();
                        break;

                    case ProjectileID.OLM_CRYSTAL_BOMB:
                        System.out.println("Crystal Bomb");
                        session.increaseBombAmount();
                        break;

                    case ProjectileID.OLM_MAGE_SMITE:
                        System.out.println("Mage Smite");
                        session.increaseSmiteAmount();
                        break;

                    case ProjectileID.OLM_RANGE_SMITE:
                        System.out.println("Range Smite");
                        session.increaseSmiteAmount();
                        break;

                    case ProjectileID.OLM_MELEE_SMITE:
                        System.out.println("Melee Smite");
                        session.increaseSmiteAmount();
                        break;

                    default:
                        break;

                }

                return;
            }
        }

    }

/*
    @Subscribe
    public void onProjectileMoved(ProjectileMoved event)
    {
        Projectile projectile = event.getProjectile();
        int projectileId = projectile.getId();
        switch (projectileId)
        {

            case ProjectileID.OLM_RANGE_AUTO:
                if (olmHead.getLastAutoID() == OlmHead.MAGE_AUTO)
                {
                    session.increaseSwitchAmount();
                }
                session.increaseRangeAmount();
                olmHead.setLastAutoID(OlmHead.RANGE_AUTO);
                break;

            case ProjectileID.OLM_MAGE_AUTO:
               session.increaseMageAmount();
                if (olmHead.getLastAutoID() == OlmHead.RANGE_AUTO)
                {
                    session.increaseSwitchAmount();
                }
                session.increaseMageAmount();
                olmHead.setLastAutoID(OlmHead.MAGE_AUTO);
                break;

            case ProjectileID.OLM_ACID_DRIP:
               session.increaseDripAmount();
                break;

            case ProjectileID.OLM_ACID_SPREAD:
                session.increaseSprayAmount();

            case ProjectileID.OLM_FLAME_WALL:
               session.increaseWallAmount();
                break;

            case ProjectileID.OLM_BURN:
               session.increaseBurnAmount();
                break;

            case ProjectileID.OLM_FALLING_CRYSTALS:
               session.increaseFallAmount();
                break;

            case ProjectileID.OLM_CRYSTAL_BOMB:
               session.increaseBombAmount();
                break;

            case ProjectileID.OLM_MAGE_SMITE:
               session.increaseSmiteAmount();
                break;

            case ProjectileID.OLM_RANGE_SMITE:
               session.increaseSmiteAmount();
                break;

            case ProjectileID.OLM_MELEE_SMITE:
               session.increaseSmiteAmount();
                break;

            default:
                return;

        }
        return;


    }
    */

    @Subscribe
    public void onNpcSpawned(NpcSpawned event)
    {
        NPC npc = event.getNpc();
        if (isOlmHead(npc.getId()))
        {
            System.out.println("Olm Head Spawned");
            System.out.println("Tick Spawned: " + client.getTickCount());
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event)
    {
        NPC npc = event.getNpc();
        System.out.println("NPC despawned: " + npc.getName());
    }


    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        final String message = event.getMessage();

        if (message.startsWith("As you pass through the barrier, a sense of dread washes over you."))
        {
            olmHead = new OlmHead();
            olmHead.setLastAutoID(-1);
            olmHead.setLastAutoTick(-1);
        }

        // Falling crystals
        if (message.startsWith("The Great Olm sounds a cry..."))
        {
            session.increaseFallAmount();
            System.out.println("Falling Crystals");
        }

        // Pools
        if (message.startsWith("The Great Olm prepares to absorb energy from anyone unprotected..."))
        {
            session.increasePoolCount();
            System.out.println("Healing Pool");
        }

        // Head Phase
        if (message.startsWith("The Great Olm is giving its all. This is its final stand."))
        {
            olmHead.setPhase(olmHead.PHASE_HEAD);
            System.out.println("Head Phase");
        }

        if (message.startsWith("The Great Olm rises with the power of") &&
            message.contains("acid"))
        {
            olmHead.setPhase(olmHead.PHASE_ACID);
            session.increaseAcidPhaseCount();
            System.out.println("Acid Phase");
        }

        if (message.startsWith("The Great Olm rises with the power of") &&
            message.contains("crystal"))
        {
            olmHead.setPhase(olmHead.PHASE_CRYSTAL);
            session.increaseCrystalPhaseCount();
            System.out.println("Crystal Phase");
        }

        if (message.startsWith("The Great Olm rises with the power of") &&
            message.contains("flame"))
        {
            olmHead.setPhase(olmHead.PHASE_FLAME);
            session.increaseFlamePhaseCount();
            System.out.println("Flame Phase");
        }
    }



    public static boolean isOlmHead(int npcID)
    {
        return npcID == NpcID.GREAT_OLM;
    }

}
