package net.runelite.client.plugins.vorkath;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.NPC;

@Data
@Slf4j
public class Vorkath
{
    static final int ATTACKS_PER_SWITCH = 6;
    static final int FIRE_BALL_ATTACKS = 25;

    private NPC vorkath;
    private VorkathAttack lastAttack;
    private Phase currentPhase;
    private Phase nextPhase;
    private Phase lastPhase;
    private int attacksLeft;

    public Vorkath(NPC vorkath)
    {
        this.vorkath = vorkath;
        this.attacksLeft = ATTACKS_PER_SWITCH;
        this.currentPhase = Phase.UNKNOWN;
        this.nextPhase = Phase.UNKNOWN;
        this.lastPhase = Phase.UNKNOWN;
        log.debug("[Vorkath] Created Vorkath: {}", this);
    }

    /**
     * Updates the existing Vorkath object depending on the new phase it is currently on
     *
     * @param newPhase the new phase Vorkath is current on
     */
    void updatePhase(Phase newPhase)
    {
        Phase oldLastPhase = this.lastPhase;
        Phase oldCurrentPhase = this.currentPhase;
        Phase oldNextPhase = this.currentPhase;
        int oldAttacksLeft = this.attacksLeft;

        this.lastPhase = this.currentPhase;
        this.currentPhase = newPhase;
        switch (newPhase)
        {
            case ACID:
                this.nextPhase = Phase.FIRE_BALL;
                break;
            case FIRE_BALL:
                this.nextPhase = Phase.SPAWN;
                break;
            case SPAWN:
                this.nextPhase = Phase.ACID;
                break;
            default:
                this.nextPhase = Phase.UNKNOWN;
                break;
        }

        if (this.currentPhase == Phase.FIRE_BALL)
        {
            this.attacksLeft = FIRE_BALL_ATTACKS;
        }
        else
        {
            this.attacksLeft = ATTACKS_PER_SWITCH;
        }

        log.debug("[Vorkath] Update! Last Phase: {}->{}, Current Phase: {}->{}, Next Phase: {}->{}, Attacks: {}->{}",
                oldLastPhase, this.lastPhase, oldCurrentPhase, this.currentPhase, oldNextPhase, this.nextPhase, oldAttacksLeft, this.attacksLeft);
    }

    enum Phase
    {
        UNKNOWN,
        ACID,
        FIRE_BALL,
        SPAWN
    }
}