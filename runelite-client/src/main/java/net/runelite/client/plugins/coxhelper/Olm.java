/*package net.runelite.client.plugins.coxhelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.DynamicObject;
import net.runelite.api.coords.WorldPoint;

@Slf4j
@Singleton
@Getter
@Setter
public class Olm
{
    public static final int HEAD_GAMEOBJECT_RISING = 29880;
    public static final int HEAD_GAMEOBJECT_READY = 29881;
    public static final int LEFT_HAND_GAMEOBJECT_RISING = 29883;
    public static final int LEFT_HAND_GAMEOBJECT_READY = 29884;
    public static final int RIGHT_HAND_GAMEOBJECT_RISING = 29886;
    public static final int RIGHT_HAND_GAMEOBJECT_READY = 29887;

    private final Client client;
    private final CoxPlugin plugin;
    private final CoxConfig config;

    private final List<WorldPoint> healPools = new ArrayList<>();
    private final List<WorldPoint> portals = new ArrayList<>();
    private final Set<Victim> victims = new HashSet<>();
    private int portalTicks = 10;

    private boolean active = false; // in fight
    private boolean firstPhase = false;
    private boolean finalPhase = false;
    private PhaseType phaseType = PhaseType.UNKNOWN;

    private GameObject hand = null;
    private OlmAnimation handAnimation = OlmAnimation.UNKNOWN;
    private GameObject head = null;
    private OlmAnimation headAnimation = OlmAnimation.UNKNOWN;

    private int ticksUntilNextAttack = -1;
    private int attackCycle = 1;
    private int specialCycle = 1;

    private boolean crippled = false;
    private int crippleTicks = 45;

    private Prayer prayer = null;
    private long lastPrayTime = 0;

    @Inject
    private Olm(final Client client, final CoxPlugin plugin, final CoxConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    public void startPhase()
    {
        this.firstPhase = !this.active;
        this.active = true;
        this.ticksUntilNextAttack = -1;
        this.attackCycle = 1;
        this.specialCycle = 1;
        this.crippled = false;
        this.crippleTicks = 45;
        this.prayer = null;
        this.lastPrayTime = 0;
        this.headAnimation = OlmAnimation.UNKNOWN;
        this.handAnimation = OlmAnimation.UNKNOWN;
    }

    public void hardRest()
    {
        this.active = false;
        this.firstPhase = false;
        this.finalPhase = false;
        this.phaseType = PhaseType.UNKNOWN;
        this.hand = null;
        this.head = null;
        this.headAnimation = OlmAnimation.UNKNOWN;
        this.handAnimation = OlmAnimation.UNKNOWN;
        this.ticksUntilNextAttack = -1;
        this.attackCycle = 1;
        this.specialCycle = 1;
        this.healPools.clear();
        this.portals.clear();
        this.portalTicks = 10;
        this.victims.clear();
        this.crippled = false;
        this.crippleTicks = 45;
        this.prayer = null;
        this.lastPrayTime = 0;
    }

    void setPrayer(Prayer pray)
    {
        this.prayer = pray;
        this.lastPrayTime = System.currentTimeMillis();
    }

    void cripple()
    {
        this.crippled = true;
        this.crippleTicks = 45;
    }

    void uncripple()
    {
        this.crippled = false;
        this.crippleTicks = 45;
    }

    public void update()
    {
        this.updateVictims();
        this.updateCrippleSticks();
        this.updateSpecials();
        this.incrementTickCycle();
        this.headAnimations();
        this.handAnimations();
    }

    public void incrementTickCycle()
    {
        if (this.ticksUntilNextAttack == 1)
        {
            this.ticksUntilNextAttack = 4;
            this.incrementAttackCycle();
        }
        else if (this.ticksUntilNextAttack != -1)
        {
            this.ticksUntilNextAttack--;
        }
    }

    public void incrementAttackCycle()
    {
        if (this.attackCycle == 4)
        {
            this.attackCycle = 1;
            this.incrementSpecialCycle();
        }
        else
        {
            this.attackCycle++;
        }
    }

    public void incrementSpecialCycle()
    {
        if ((this.specialCycle == 3 && !this.finalPhase) || this.specialCycle == 4)
        {
            this.specialCycle = 1;
        }
        else
        {
            this.specialCycle++;
        }
    }

    public void specialSync(OlmAnimation currentAnimation)
    {
        this.ticksUntilNextAttack = 4;
        this.attackCycle = 1;
        switch (currentAnimation)
        {
            case LEFT_HAND_CRYSTALS1:
            case LEFT_HAND_CRYSTALS2:
                this.specialCycle = 2;
                break;
            case LEFT_HAND_LIGHTNING1:
            case LEFT_HAND_LIGHTNING2:
                this.specialCycle = 3;
                break;
            case LEFT_HAND_PORTALS1:
            case LEFT_HAND_PORTALS2:
                this.specialCycle = this.finalPhase ? 4 : 1;
                break;
            case LEFT_HAND_HEAL1:
            case LEFT_HAND_HEAL2:
                this.specialCycle = 1;
                break;
        }
    }

    void updateCrippleSticks()
    {
        if (!this.crippled)
        {
            return;
        }

        this.crippleTicks--;
        if (this.crippleTicks <= 0)
        {
            this.crippled = false;
            this.crippleTicks = 45;
        }
    }

    void updateVictims()
    {
        if (this.victims.size() > 0)
        {
            this.victims.forEach(Victim::updateTicks);
            this.victims.removeIf(victim -> victim.getTicks() <= 0);
        }
    }

    void updateSpecials()
    {
        this.healPools.clear();
        this.portals.clear();
        this.client.clearHintArrow();

        for (GraphicsObject o : this.client.getGraphicsObjects())
        {
            if (o.getId() == GraphicID.OLM_TELEPORT)
            {
                this.portals.add(WorldPoint.fromLocal(this.client, o.getLocation()));
            }
            if (o.getId() == GraphicID.OLM_HEAL)
            {
                this.healPools.add(WorldPoint.fromLocal(this.client, o.getLocation()));
            }
            if (!this.portals.isEmpty())
            {
                this.portalTicks--;
                if (this.portalTicks <= 0)
                {
                    this.client.clearHintArrow();
                    this.portalTicks = 10;
                }
            }
        }
    }

    private void headAnimations()
    {
        if (this.head == null || this.head.getEntity() == null)
        {
            return;
        }

        OlmAnimation currentAnimation = OlmAnimation.fromId(((DynamicObject) this.head.getEntity()).getAnimationID());

        if (currentAnimation == this.headAnimation)
        {
            return;
        }

        switch (currentAnimation)
        {
            case HEAD_RISING_2:
            case HEAD_ENRAGED_RISING_2:
                this.ticksUntilNextAttack = this.firstPhase ? 6 : 8;
                this.attackCycle = 1;
                this.specialCycle = 1;
                break;
            case HEAD_ENRAGED_LEFT:
            case HEAD_ENRAGED_MIDDLE:
            case HEAD_ENRAGED_RIGHT:
                this.finalPhase = true;
                break;
        }

        this.headAnimation = currentAnimation;
    }

    private void handAnimations()
    {
        if (this.hand == null || this.hand.getEntity() == null)
        {
            return;
        }

        OlmAnimation currentAnimation = OlmAnimation.fromId(((DynamicObject) this.hand.getEntity()).getAnimationID());

        if (currentAnimation == this.handAnimation)
        {
            return;
        }

        switch (currentAnimation)
        {
            case LEFT_HAND_CRYSTALS1:
            case LEFT_HAND_CRYSTALS2:
            case LEFT_HAND_LIGHTNING1:
            case LEFT_HAND_LIGHTNING2:
            case LEFT_HAND_PORTALS1:
            case LEFT_HAND_PORTALS2:
            case LEFT_HAND_HEAL1:
            case LEFT_HAND_HEAL2:
                this.specialSync(currentAnimation);
                break;
            case LEFT_HAND_CRIPPLING:
                this.cripple();
                break;
            case LEFT_HAND_UNCRIPPLING1:
            case LEFT_HAND_UNCRIPPLING2:
                this.uncripple();
                break;
        }

        this.handAnimation = currentAnimation;
    }

    public enum PhaseType
    {
        FLAME,
        ACID,
        CRYSTAL,
        UNKNOWN,
    }
}*/