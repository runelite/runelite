package net.runelite.client.plugins.pvpperformancetracker;

import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.HeadIcon;
import org.apache.commons.lang3.ArrayUtils;

public enum AnimationAttackStyle
{
    // None: Common non-attack animations. This enum value says they aren't attacking.
    None(null,
        AnimationID.IDLE,
        AnimationID.CONSUMING
    ),
    // Melee attack animations
    Melee(HeadIcon.MELEE,
        1
    ),
    // Magic attack/casting animations
    Magic(HeadIcon.MAGIC,
        2,
        3
    ),
    // Ranged attack animations
    Ranged(HeadIcon.RANGED,
        4,
        5
    );

    @Getter
    private final HeadIcon protection;
    private final int[] animationIds;
    AnimationAttackStyle(HeadIcon protection, int... animationIds)
    {
        this.protection = protection;
        this.animationIds = animationIds;
    }

    public static AnimationAttackStyle styleForAnimation(int animationId)
    {
        // check for common non-attack animationIds before checking known attack ones,
        // since it is more likely that they aren't attacking, so avoid starting by
        // checking large arrays of attack animationIds.
        if (ArrayUtils.contains(None.animationIds, animationId))
        {
            return None;
        }
        else if (ArrayUtils.contains(Melee.animationIds, animationId))
        {
            return Melee;
        }
        else if (ArrayUtils.contains(Magic.animationIds, animationId))
        {
            return Magic;
        }
        else if (ArrayUtils.contains(Ranged.animationIds, animationId))
        {
            return Ranged;
        }
        return None;
    }
}
