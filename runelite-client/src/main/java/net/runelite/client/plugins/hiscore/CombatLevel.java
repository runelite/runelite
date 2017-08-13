package net.runelite.client.plugins.hiscore;

		import net.runelite.http.api.hiscore.HiscoreResult;
		import net.runelite.http.api.hiscore.Skill;

public class CombatLevel
{
	private int attackLevel, strengthLevel, defenceLevel, hitpointsLevel, magicLevel, rangeLevel, prayerLevel;
	private double preciseMeleeCombatLevel;
	private double preciseRangedCombatLevel;
	private double preciseMagicCombatLevel;

	public CombatLevel(int attackLevel, int strengthLevel, int defenceLevel, int hitpointsLevel,
					   int magicLevel, int rangeLevel, int prayerLevel)
	{
		this.attackLevel = attackLevel;
		this.strengthLevel = strengthLevel;
		this.defenceLevel = defenceLevel;
		this.hitpointsLevel = hitpointsLevel;
		this.magicLevel = magicLevel;
		this.rangeLevel = rangeLevel;
		this.prayerLevel = prayerLevel;

		preciseMeleeCombatLevel = calculateMelee();
		preciseRangedCombatLevel = calculateRanged();
		preciseMagicCombatLevel = calculateMagic();
	}

	public CombatLevel(HiscoreResult result)
	{
		this.attackLevel = result.getAttack().getLevel();
		this.strengthLevel = result.getStrength().getLevel();
		this.defenceLevel = result.getDefence().getLevel();
		this.hitpointsLevel = result.getHitpoints().getLevel();
		this.magicLevel = result.getMagic().getLevel();
		this.rangeLevel = result.getRanged().getLevel();
		this.prayerLevel = result.getPrayer().getLevel();

		preciseMeleeCombatLevel = calculateMelee();
		preciseRangedCombatLevel = calculateRanged();
		preciseMagicCombatLevel = calculateMagic();
	}

	public CombatLevel(Skill attack, Skill strength, Skill defence, Skill hitpoints, Skill magic, Skill range, Skill prayer)
	{
		this.attackLevel = attack.getLevel();
		this.strengthLevel = strength.getLevel();
		this.defenceLevel = defence.getLevel();
		this.hitpointsLevel = hitpoints.getLevel();
		this.magicLevel = magic.getLevel();
		this.rangeLevel = range.getLevel();
		this.prayerLevel = prayer.getLevel();

		preciseMeleeCombatLevel = calculateMelee();
		preciseRangedCombatLevel = calculateRanged();
		preciseMagicCombatLevel = calculateMagic();
	}

	private double calculateMelee()
	{
		return 0.25 * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2)) +
				0.325 * (attackLevel + strengthLevel);
	}

	private double calculateRanged()
	{
		return preciseRangedCombatLevel = 0.25 * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2)) +
				0.325 * (Math.floor(rangeLevel / 2));
	}

	private double calculateMagic()
	{
		return preciseMagicCombatLevel = 0.25 * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2)) +
				0.325 * (Math.floor(magicLevel / 2));
	}

	public int getCombatLevel()
	{
		return (int) Math.floor(getPreciseCombatLevel());
	}

	public double getPreciseCombatLevel()
	{
		return Math.max(preciseMeleeCombatLevel, Math.max(preciseRangedCombatLevel, preciseMagicCombatLevel));
	}
}
