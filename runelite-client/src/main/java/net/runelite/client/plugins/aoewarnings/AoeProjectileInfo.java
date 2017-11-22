package net.runelite.client.plugins.aoewarnings;

public enum AoeProjectileInfo
{
	LIZARDMAN_SHAMAN_AOE(1293, 3000, 3),
	ICE_DEMON_RANGED_AOE(1324, 3000, 3),
	ICE_DEMON_ICE_BARRAGE_AOE(366, 3000, 3),//When you don't have pray range on ice demon does an ice barrage
	VASA_AWAKEN_AOE(1327, 4500, 3),//The aoe when vasa first starts
	VASA_RANGED_AOE(1329, 3000, 3),
	TEKTON_METEOR_AOE(660, 4000, 3);

	/**
	 * How long the indicator should last for this AoE warning
	 * This might need to be a bit longer than the projectile actually takes to land as there is a fade effect on the warning
	 */
	private int lifeTimeMillis;
	/**
	 * The id of the projectile to trigger this AoE warning
	 */
	private int id;
	/**
	 * The size of the splash radius of the AoE warning
	 * Ex. Lizardman shaman AoE is a 3x3, so aoeSize = 3
	 */
	private int aoeSize;

	AoeProjectileInfo(int id, int lifeTimeMillis, int aoeSize)
	{
		this.id = id;
		this.lifeTimeMillis = lifeTimeMillis;
		this.aoeSize = aoeSize;
	}

	public static AoeProjectileInfo getById(int id)
	{
		for (AoeProjectileInfo aoeProjectileInfo : AoeProjectileInfo.values())
		{
			if (id == aoeProjectileInfo.getId())
			{
				return aoeProjectileInfo;
			}
		}
		return null;
	}

	public int getLifeTimeMillis()
	{
		return lifeTimeMillis;
	}

	public void setLifeTimeMillis(int lifeTimeMillis)
	{
		this.lifeTimeMillis = lifeTimeMillis;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAoeSize()
	{
		return aoeSize;
	}

	public void setAoeSize(int aoeSize)
	{
		this.aoeSize = aoeSize;
	}
}
