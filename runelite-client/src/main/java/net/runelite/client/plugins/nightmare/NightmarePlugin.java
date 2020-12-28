package net.runelite.client.plugins.nightmare;

import com.google.inject.Provides;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Nightmare of Ashihama",
        enabledByDefault = false,
        description = "Show what prayer to use and which tiles to avoid",
        tags = {"bosses", "combat", "nm", "overlay", "nightmare", "pve", "pvm", "ashihama","willem","fun"}
)

@Slf4j
@Singleton
public class NightmarePlugin extends Plugin
{
    // Nightmare's attack animations
    private static final int NIGHTMARE_HUSK_SPAWN = 8565;
    private static final int NIGHTMARE_CHARGE_1 = 8597;
    private static final int NIGHTMARE_SHADOW_SPAWN = 8598;
    private static final int NIGHTMARE_CURSE = 8599;
    private static final int NIGHTMARE_QUADRANTS = 8601;
    private static final int NIGHTMARE_SLEEP_DAMAGE = 8604;
    private static final int NIGHTMARE_PARASITE_TOSS = 8605;
    private static final int NIGHTMARE_PARASITE_TOSS2 = 8606;
    private static final int NIGHTMARE_CHARGE_TELEPORT = 8607;
    private static final int NIGHTMARE_CHARGE_2 = 8609;
    private static final int NIGHTMARE_SPAWN = 8611;
    private static final int NIGHTMARE_DEATH = 8612;
    private static final int NIGHTMARE_MELEE_ATTACK = 8594;
    private static final int NIGHTMARE_RANGE_ATTACK = 8596;
    private static final int NIGHTMARE_MAGIC_ATTACK = 8595;
    private static final int NIGHTMARE_PRE_MUSHROOM = 37738;
    private static final int NIGHTMARE_MUSHROOM = 37739;
    private static final int NIGHTMARE_SHADOW = 1767;   // graphics object

    private static final List<Integer> INACTIVE_TOTEMS = Arrays.asList(9434, 9437, 9440, 9443);
    @Getter(AccessLevel.PACKAGE)
    private final Map<Integer, MemorizedTotem> totems = new HashMap<>();
    @Getter(AccessLevel.PACKAGE)
    private final Map<LocalPoint, GameObject> spores = new HashMap<>();
    @Getter(AccessLevel.PACKAGE)
    private final Map<Polygon, Player> huskTarget = new HashMap<>();
    @Getter(AccessLevel.PACKAGE)
    private final Map<Integer, Player> parasiteTargets = new HashMap<>();
    @Inject
    private Client client;
    @Inject
    private NightmareConfig config;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private NightmarePrayerInfoBox prayerInfoBox;
    @Nullable
    @Getter(AccessLevel.PACKAGE)
    private NightmareAttack pendingNightmareAttack;
    @Nullable
    @Getter(AccessLevel.PACKAGE)
    private NPC nm;
    @Getter(AccessLevel.PACKAGE)
    private boolean inFight;

    private boolean cursed;
    private int attacksSinceCurse;

    @Getter(AccessLevel.PACKAGE)
    private int ticksUntilNextAttack = 0;

    @Getter(AccessLevel.PACKAGE)
    private int ticksUntilParasite = 0;

    @Getter(AccessLevel.PACKAGE)
    private boolean nightmareCharging = false;

    @Getter(AccessLevel.PACKAGE)
    private boolean shadowsSpawning = false;

    @Getter(AccessLevel.PACKAGE)
    @Setter
    private boolean flash = false;
    @Inject
    private NightmareOverlay overlay;
    @Inject
    private NightmarePrayerOverlay prayerOverlay;

    public NightmarePlugin()
    {
        inFight = false;
    }

    @Provides
    NightmareConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(NightmareConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
        overlayManager.add(prayerOverlay);
        overlayManager.add(prayerInfoBox);
        reset();
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        overlayManager.remove(prayerOverlay);
        overlayManager.remove(prayerInfoBox);
        reset();
    }

    private void reset()
    {
        inFight = false;
        nm = null;
        pendingNightmareAttack = null;
        nightmareCharging = false;
        shadowsSpawning = false;
        cursed = false;
        flash = false;
        attacksSinceCurse = 0;
        ticksUntilNextAttack = 0;
        ticksUntilParasite = 0;
        totems.clear();
        spores.clear();
        huskTarget.clear();
        parasiteTargets.clear();
    }

    @Subscribe
    private void onGameObjectSpawned(GameObjectSpawned event)
    {
        if (!inFight)
        {
            return;
        }

        GameObject gameObj = event.getGameObject();
        int id = gameObj.getId();
        if (id == NIGHTMARE_MUSHROOM || id == NIGHTMARE_PRE_MUSHROOM)
        {
            spores.put(gameObj.getLocalLocation(), gameObj);
        }
    }

    @Subscribe
    private void onGameObjectDespawned(GameObjectDespawned event)
    {
        if (!inFight)
        {
            return;
        }

        GameObject gameObj = event.getGameObject();
        int id = gameObj.getId();
        if (id == NIGHTMARE_MUSHROOM || id == NIGHTMARE_PRE_MUSHROOM)
        {
            spores.remove(gameObj.getLocalLocation());
        }
    }

    @Subscribe
    private void onProjectileMoved(ProjectileMoved event)
    {
        if (!inFight)
        {
            return;
        }
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event)
    {
        if (!inFight || nm == null)
        {
            return;
        }

        Actor actor = event.getActor();
        if (!(actor instanceof NPC))
        {
            return;
        }

        NPC npc = (NPC) actor;
        int id = npc.getId();
        int animationId = npc.getAnimation();

        if (animationId == NIGHTMARE_MAGIC_ATTACK)
        {
            ticksUntilNextAttack = 7;
            attacksSinceCurse++;
            pendingNightmareAttack = cursed ? NightmareAttack.CURSE_MAGIC : NightmareAttack.MAGIC;
        }
        else if (animationId == NIGHTMARE_MELEE_ATTACK)
        {
            ticksUntilNextAttack = 7;
            attacksSinceCurse++;
            pendingNightmareAttack = cursed ? NightmareAttack.CURSE_MELEE : NightmareAttack.MELEE;
        }
        else if (animationId == NIGHTMARE_RANGE_ATTACK)
        {
            ticksUntilNextAttack = 7;
            attacksSinceCurse++;
            pendingNightmareAttack = cursed ? NightmareAttack.CURSE_RANGE : NightmareAttack.RANGE;
        }
        else if (animationId == NIGHTMARE_CURSE)
        {
            cursed = true;
            attacksSinceCurse = 0;
        }
        else if ((id == 9427 || id == 9430) && animationId == NIGHTMARE_CHARGE_2)
        {
            nightmareCharging = true;
        }
        else if ((id == 9427 || id == 9430) && animationId == NIGHTMARE_CHARGE_1)
        {
            nightmareCharging = false;
        }

        if (animationId != NIGHTMARE_HUSK_SPAWN && (id == 9425 || id == 9428) && !huskTarget.isEmpty())
        {
            huskTarget.clear();
        }

        if (cursed && attacksSinceCurse == 5)
        {
            //curse is removed when she phases, or does 5 attacks
            cursed = false;
            attacksSinceCurse = -1;
        }

        if (animationId == NIGHTMARE_PARASITE_TOSS2)
        {
            ticksUntilParasite = 27;
        }
    }

    @Subscribe
    public void onNpcChanged(NpcChanged event)
    {
        final NPC npc = event.getNpc();

        if (npc == null)
        {
            return;
        }

        //this will trigger once when the fight begins
        if (npc.getId() == 9432)
        {
            //reset everything
            reset();
            nm = npc;
            inFight = true;
        }

        //if ID changes to 9431 (3rd phase) and is cursed, remove the curse
        if (cursed && npc.getId() == 9431)
        {
            cursed = false;
            attacksSinceCurse = -1;
        }

        //if npc is in the totems map, update its phase
        if (totems.containsKey(npc.getIndex()))
        {
            totems.get(npc.getIndex()).updateCurrentPhase(npc.getId());
        }
        else if (INACTIVE_TOTEMS.contains(npc.getId()))
        {
            //else if the totem is not in the totem array and it is an inactive totem, add it to the totem map.
            totems.putIfAbsent(npc.getIndex(), new MemorizedTotem(npc));
        }
    }

    @Subscribe
    private void onChatMessage(ChatMessage event)
    {

        if (!inFight || nm == null || event.getType() != ChatMessageType.GAMEMESSAGE)
        {
            return;
        }

        if (event.getMessage().contains("The Nightmare has impregnated you with a deadly parasite!"))
        {
            flash = true;
        }

    }

    @Subscribe
    private void onGameStateChanged(GameStateChanged event)
    {
        GameState gamestate = event.getGameState();

        //if loading happens while inFight, the user has left the area (either via death or teleporting).
        if (gamestate == GameState.LOADING && inFight)
        {
            reset();
        }
    }

    @Subscribe
    private void onGameTick(final GameTick event)
    {
        if (!inFight || nm == null)
        {
            return;
        }

        //if nightmare's id is 9433, the fight has ended and everything should be reset
        if (nm.getId() == 9433)
        {
            reset();
        }

        ticksUntilNextAttack--;

        if (ticksUntilParasite > 0)
        {
            ticksUntilParasite--;
            if (ticksUntilParasite == 0)
            {
                parasiteTargets.clear();
            }
        }

        if (pendingNightmareAttack != null && ticksUntilNextAttack <= 3)
        {
            pendingNightmareAttack = null;
        }

        if (config.highlightShadows())
        {
            boolean doShadowsExist = false;
            for (GraphicsObject graphicsObject : client.getGraphicsObjects())
            {
                if (graphicsObject.getId() == NIGHTMARE_SHADOW)
                {
                    shadowsSpawning = true;
                    doShadowsExist = true;
                    break;
                }
            }
            if (!doShadowsExist)
            {
                shadowsSpawning = false;
            }
        }
    }

    private boolean isNightmareNpc(int id)
    {
        return id >= 9425 && id <= 9433;
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals("nightmareOfAshihama"))
        {
            return;
        }

        if (event.getKey().equals("mirrorMode"))
        {
            overlay.determineLayer();
            prayerOverlay.determineLayer();
            prayerInfoBox.determineLayer();
            overlayManager.remove(overlay);
            overlayManager.remove(prayerOverlay);
            overlayManager.remove(prayerInfoBox);
            overlayManager.add(overlay);
            overlayManager.add(prayerOverlay);
            overlayManager.add(prayerInfoBox);
        }
    }
}