package net.runelite.client.plugins.olmattackcounter;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.ProjectileID;

public class OlmHead
{
    static final int RANGE_AUTO = 1;
    static final int MAGE_AUTO = 0;

    static final int OLM_HEAD_ACTIVE = 1;
    static final int OLM_INTERMISSION = 0;
    static final int OLM_NOT_SPAWNED = -1;

    static final int AUTO_RATE = 8;
    static final int SKIPPED_CYCLE_RATE = 12;
    static final int EVENT_RATE = 4;

    static final int PHASE_NONE = 0;
    static final int PHASE_ACID = 1;
    static final int PHASE_CRYSTAL = 2;
    static final int PHASE_FLAME = 3;
    static final int PHASE_HEAD = 4;

    public static final int[] ALL_ATTACK_STYLES =
        {
            ProjectileID.OLM_RANGE_AUTO,
            ProjectileID.OLM_MAGE_AUTO,
            ProjectileID.OLM_ACID_SPREAD,
            ProjectileID.OLM_CRYSTAL_BOMB,
            ProjectileID.OLM_BURN,
            ProjectileID.OLM_FLAME_WALL,
            ProjectileID.OLM_MELEE_SMITE,
            ProjectileID.OLM_RANGE_SMITE,
            ProjectileID.OLM_MAGE_SMITE
        };

    @Getter
    private NPC npc;

    @Getter
    @Setter
    private int nextAttackTick;

    @Getter
    @Setter
    private int active;

    @Getter
    @Setter
    private int lastAutoID; // 0 = mage, 1 = range

    @Getter
    @Setter
    private int lastAutoTick;

    @Getter
    @Setter
    private int thisAttackID;

    @Getter
    @Setter
    private int attackSide; // left = 0, right = 1

    @Getter
    @Setter
    private int phase; // -1 == NONE, 1 = ACID, 2 = CRYSTAL, 3 = FLAME, 4 = HEAD


    public OlmHead()
    {
        this.attackSide = -1;
        this.phase = PHASE_NONE;
        this.lastAutoTick = -1;
        this.nextAttackTick = -1;
        this.active = OLM_NOT_SPAWNED;
    }


}
