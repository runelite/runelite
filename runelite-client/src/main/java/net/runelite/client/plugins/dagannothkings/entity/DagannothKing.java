package net.runelite.client.plugins.dagannothkings.entity;

import java.awt.Color;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Prayer;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DagannothKing implements Comparable<DagannothKing>
{
    @Getter
    @EqualsAndHashCode.Include
    private final NPC npc;

    @Getter
    private final int npcId;

    @Getter
    private int ticksUntilNextAnimation;

    private final int animationId;

    private final int animationTickSpeed;

    @Getter
    private final AttackStyle attackStyle;

    @Getter
    private final Color color;

    public DagannothKing(final NPC npc)
    {
        this.npc = npc;
        this.npcId = npc.getId();
        this.ticksUntilNextAnimation = 0;

        final Boss boss = Boss.of(npcId);
        this.animationId = boss.animationId;
        this.animationTickSpeed = boss.attackSpeed;
        this.attackStyle = boss.attackStyle;
        this.color = attackStyle.color;
    }
    public static final int DAG_REX = 2853;
    public static final int DAG_PRIME = 2854;
    public static final int DAG_SUPREME = 2855;
    public void updateTicksUntilNextAnimation()
    {
        if (ticksUntilNextAnimation > 0)
        {
            ticksUntilNextAnimation--;
        }

        if (npc.getAnimation() == animationId && ticksUntilNextAnimation == 0)
        {
            ticksUntilNextAnimation = animationTickSpeed;
        }
    }

    public Actor getInteractingActor()
    {
        return npc.getInteracting();
    }

    @Override
    public int compareTo(final DagannothKing dagannothKing)
    {
        if (dagannothKing.ticksUntilNextAnimation == 0)
        {
            return -1;
        }

        return ticksUntilNextAnimation - dagannothKing.ticksUntilNextAnimation;
    }

    @RequiredArgsConstructor
    public enum Boss
    {
        DAGANNOTH_PRIME(NpcID.DAGANNOTH_PRIME, DAG_PRIME, 4, AttackStyle.MAGE),
        DAGANNOTH_REX(NpcID.DAGANNOTH_REX, DAG_REX, 4, AttackStyle.MELEE),
        DAGANNOTH_SUPREME(NpcID.DAGANNOTH_SUPREME, DAG_SUPREME, 4, AttackStyle.RANGE);

        private final int npcId;
        private final int animationId;
        private final int attackSpeed;
        private final AttackStyle attackStyle;

        public static Boss of(final int npcId)
        {
            for (final Boss boss : Boss.values())
            {
                if (boss.npcId == npcId)
                {
                    return boss;
                }
            }

            throw new IllegalArgumentException("Unsupported Boss npcId");
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum AttackStyle
    {
        MAGE(Prayer.PROTECT_FROM_MAGIC, Color.CYAN),
        RANGE(Prayer.PROTECT_FROM_MISSILES, Color.GREEN),
        MELEE(Prayer.PROTECT_FROM_MELEE, Color.RED);

        private final Prayer prayer;
        private final Color color;
    }
}