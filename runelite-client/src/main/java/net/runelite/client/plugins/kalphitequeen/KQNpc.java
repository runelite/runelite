package net.runelite.client.plugins.kalphitequeen;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class KQNpc
{
    static final Set<Integer> NPC_IDS = ImmutableSet.of(NpcID.KALPHITE_QUEEN_963, NpcID.KALPHITE_QUEEN_965);

    private static final int ANIMATION_ID_PHASE1_RANGE = 6240;
    private static final int ANIMATION_ID_PHASE1_MELEE = 6241;
    private static final int ANIMATION_ID_PHASE1_MAGIC = 1172;
    private static final int ANIMATION_ID_PHASE1_MELEE_1185 = 1185;

    private static final int ANIMATION_ID_PHASE2_RANGE = 6234;
    private static final int ANIMATION_ID_PHASE2_MELEE = 6235;
    private static final int ANIMATION_ID_PHASE2_MAGIC = 1170;

    private static final int ANIMATION_TICK_SPEED = 4;

    private static final Set<Integer> ANIMATION_IDS = ImmutableSet.of(
            ANIMATION_ID_PHASE1_MELEE,
            ANIMATION_ID_PHASE1_MELEE_1185,
            ANIMATION_ID_PHASE1_RANGE,
            ANIMATION_ID_PHASE1_MAGIC,
            ANIMATION_ID_PHASE2_RANGE,
            ANIMATION_ID_PHASE2_MELEE,
            ANIMATION_ID_PHASE2_MAGIC
    );

    @Getter
    @EqualsAndHashCode.Include
    private final NPC npc;

    @Getter
    private int ticksUntilNextAnimation;

    KQNpc(final NPC npc)
    {
        this.npc = npc;
        this.ticksUntilNextAnimation = 0;

        if (!NPC_IDS.contains(npc.getId()))
        {
            throw new IllegalArgumentException("Unsupported KQ npc id");
        }
    }

    void updateTicksUntilNextAnimation()
    {
        if (ticksUntilNextAnimation > 0)
        {
            ticksUntilNextAnimation--;
        }

        if (ticksUntilNextAnimation <= 0 && ANIMATION_IDS.contains(npc.getAnimation()))
        {
            ticksUntilNextAnimation = ANIMATION_TICK_SPEED;
        }
    }
}