package net.runelite.client.plugins.vorkath;

import net.runelite.api.AnimationID;

public enum VorkathAttack
{
    REGULAR(AnimationID.VORKATH_REGULAR_ATTACK),
    TOSS(AnimationID.VORKATH_TOSS),
    POISON(AnimationID.VORKATH_POISON_SPRAY),
    DEATH(AnimationID.VORKATH_DEATH);

    private final int animation;

    VorkathAttack(int animation)
    {
        this.animation = animation;
    }

    public int getAnimation()
    {
        return animation;
    }
}