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

public class OlmHead
{
    static final int EVENT_RATE = 4; //  4 ticks between each event, an event can be an auto attack/melee special
    static final int RANGE_AUTO = 1;
    static final int MAGE_AUTO = 0;

    enum Attack
    {
        MAGE,
        RANGE,
        BURN,
        FIREWALL,
        BOMB,
        FALLINGCRYSTALS,
        ACIDSPRAY,
        ACIDDRIP,
        SMITE,
    }

    @Getter
    private NPC npc;

    @Getter
    @Setter
    private int nextAttackTick;

    @Getter
    @Setter
    private int lastAutoID; // 0 = mage, 1 = range

    @Getter
    @Setter
    private int lastAutoTick;

    @Getter
    @Setter
    private int attackSide; // left = 0, right = 1

    @Getter
    enum phase
    {
        NONE,
        ACID,
        CRYSTAL,
        FLAME,
        HEAD,
    }


    public OlmHead(NPC npc)
    {
        this.npc = npc;
        this.attackSide = -1;
        this.lastAutoID = -1;

    }


}
