package net.runelite.client.plugins.pvpperformancetracker;

import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.HeadIcon;
import org.apache.commons.lang3.ArrayUtils;

public enum AnimationAttackStyle
{
    // None: Common non-attack animations seen during combat. This enum value says they aren't attacking.
    None(null,
        AnimationID.IDLE,
        AnimationID.CONSUMING,
        AnimationID.COMBAT_SHIELD_BLOCK,
        AnimationID.COMBAT_DEFENDER_BLOCK
    ),
    // Melee attack animations
    Melee(HeadIcon.MELEE,
        AnimationID.MELEE_DRAGON_DAGGER_SPEC,
        AnimationID.MELEE_ABYSSAL_WHIP,
        AnimationID.MELEE_ELDER_MAUL
    ),
    // Magic attack/casting animations
    Magic(HeadIcon.MAGIC,
        AnimationID.MAGIC_ANCIENT_BARRAGE
    ),
    // Ranged attack animations
    Ranged(HeadIcon.RANGED,
        AnimationID.RANGED_RUNE_CROSSBOW
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
