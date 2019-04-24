package net.runelite.client.plugins.alchemicalhydra;

import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Prayer;
import net.runelite.api.ProjectileID;

@Singleton
class Hydra
{
	enum AttackStyle
	{
		MAGIC(ProjectileID.HYDRA_MAGIC, Prayer.PROTECT_FROM_MAGIC),
		RANGED(ProjectileID.HYDRA_RANGED, Prayer.PROTECT_FROM_MISSILES);

		@Getter
		private int projId;

		@Getter
		private Prayer prayer;

		AttackStyle(int projId, Prayer prayer)
		{
			this.projId = projId;
			this.prayer = prayer;
		}
	}

	@Getter
	@Setter
	private HydraPhase phase;

	@Getter
	@Setter
	private int attackCount;

	@Getter
	@Setter
	private int nextSwitch;

	@Getter
	@Setter
	private int nextSpecial;

	@Getter
	@Setter
	private AttackStyle nextAttack;

	@Getter
	@Setter
	private AttackStyle lastAttack;

	Hydra()
	{
		this.phase = HydraPhase.ONE;
		this.nextAttack = AttackStyle.MAGIC;
		this.nextSpecial = 3;
		this.nextSwitch = phase.getAttacksPerSwitch();
		this.attackCount = 0;
	}
}
