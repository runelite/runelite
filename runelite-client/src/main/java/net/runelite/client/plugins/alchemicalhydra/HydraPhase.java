package net.runelite.client.plugins.alchemicalhydra;

import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.ProjectileID;
import net.runelite.api.SpriteID;

enum HydraPhase
{
	ONE(3, AnimationID.HYDRA_1_1, AnimationID.HYDRA_1_2, ProjectileID.HYDRA_POISON, 0, SpriteID.BIG_ASS_GUTHIX_SPELL),
	TWO(3, AnimationID.HYDRA_2_1, AnimationID.HYDRA_2_2, 0, AnimationID.HYDRA_LIGHTNING, SpriteID.BIG_SPEC_TRANSFER),
	THREE(3, AnimationID.HYDRA_3_1, AnimationID.HYDRA_3_2, 0, AnimationID.HYDRA_FIRE, SpriteID.BIG_SUPERHEAT),
	FOUR(1, AnimationID.HYDRA_4_1, AnimationID.HYDRA_4_2, ProjectileID.HYDRA_POISON, 0, SpriteID.BIG_ASS_GUTHIX_SPELL);

	@Getter
	private int attacksPerSwitch;

	@Getter
	private int deathAnim1;

	@Getter
	private int deathAnim2;

	@Getter
	private int specProjectileId;

	@Getter
	private int specAnimationId;

	@Getter
	private int specImage;

	HydraPhase(int attacksPerSwitch, int deathAnim1, int deathAnim2, int specProjectileId, int specAnimationId, int specImage)
	{
		this.attacksPerSwitch = attacksPerSwitch;
		this.deathAnim1 = deathAnim1;
		this.deathAnim2 = deathAnim2;
		this.specProjectileId = specProjectileId;
		this.specAnimationId = specAnimationId;
		this.specImage = specImage;
	}
}