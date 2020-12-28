package net.runelite.client.plugins.vorkath;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.ProjectileID;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public enum VorkathAttack
{
    /**
     * Vorkath's melee attack (see VorkathPlugin#onAnimationChanged)
     */
    SLASH_ATTACK(VorkathAnimationID.VORKATH_SLASH_ATTACK, -1),
    /**
     * Vorkath's dragon breath attack
     */
    FIRE_BREATH(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_DRAGONBREATH),
    /**
     * Vorkath's dragon breath attack causing the player's active prayers to be deactivated
     */
    PRAYER_BREATH(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_PRAYER_DISABLE),
    /**
     * Vorkath's dragon breath attack causing the player to become poisoned with venom
     */
    VENOM_BREATH(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_VENOM),
    /**
     * Vorkath's ranged attack
     */
    SPIKE(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_RANGED),
    /**
     * Vorkath's magic attack
     */
    ICE(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_MAGIC),
    /**
     * Vorkath's aoe fire bomb attack (3x3 from where player was originally standing)
     */
    FIRE_BOMB(VorkathAnimationID.VORKATH_FIRE_BOMB_OR_SPAWN_ATTACK, ProjectileID.VORKATH_BOMB_AOE),
    /**
     * Vorkath's aoe acid attacking, spewing acid across the instance
     */

    ACID(VorkathAnimationID.VORKATH_ACID_ATTACK, ProjectileID.VORKATH_POISON_POOL_AOE),
    /**
     * Vorkath's fire ball attack that is fired during the acid phase, almost every tick for 25(?) attacks total
     */
    FIRE_BALL(VorkathAnimationID.VORKATH_ACID_ATTACK, ProjectileID.VORKATH_TICK_FIRE_AOE),
    /**
     * Vorkath's dragon breath attack causing the player to be frozen during Zombified Spawn phase
     */
    FREEZE_BREATH(VorkathAnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_ICE),
    /**
     * Vorkath's spawning of a Zombified Spawn
     */
    ZOMBIFIED_SPAWN(VorkathAnimationID.VORKATH_FIRE_BOMB_OR_SPAWN_ATTACK, ProjectileID.VORKATH_SPAWN_AOE);

    private static final Map<Integer, VorkathAttack> VORKATH_ATTACKS;
    private static final Map<Integer, VorkathAttack> VORKATH_BASIC_ATTACKS;

    static
    {
        ImmutableMap.Builder<Integer, VorkathAttack> builder = new ImmutableMap.Builder<>();
        for (VorkathAttack vorkathAttack : values())
        {
            builder.put(vorkathAttack.getProjectileID(), vorkathAttack);
        }
        VORKATH_ATTACKS = builder.build();
    }

    static
    {
        ImmutableMap.Builder<Integer, VorkathAttack> builder = new ImmutableMap.Builder<>();
        builder.put(FIRE_BREATH.getProjectileID(), FIRE_BREATH)
                .put(PRAYER_BREATH.getProjectileID(), PRAYER_BREATH)
                .put(VENOM_BREATH.getProjectileID(), VENOM_BREATH)
                .put(SPIKE.getProjectileID(), SPIKE)
                .put(ICE.getProjectileID(), ICE)
                .put(FIRE_BOMB.getProjectileID(), FIRE_BOMB)
                .put(FIRE_BALL.getProjectileID(), FIRE_BALL);
        // FIRE_BOMB and FIRE_BALL are also basic attacks
        // Although SLASH_ATTACK is a basic attack, we're going to handle it differently
        VORKATH_BASIC_ATTACKS = builder.build();
    }

    private final int vorkathAnimationID;
    private final int projectileID;

    /**
     * @param projectileID id of projectile
     * @return {@link VorkathAttack} associated with the specified projectile
     */
    public static VorkathAttack getVorkathAttack(int projectileID)
    {
        return VORKATH_ATTACKS.get(projectileID);
    }

    /**
     * @param projectileID id of projectile
     * @return true if the projectile id matches a {@link VorkathAttack#getProjectileID()} within {@link VorkathAttack#VORKATH_BASIC_ATTACKS},
     * false otherwise
     */
    public static boolean isBasicAttack(int projectileID)
    {
        return VORKATH_BASIC_ATTACKS.get(projectileID) != null;
    }
}