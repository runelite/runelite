package net.runelite.client.plugins.xpglobes;

import net.runelite.api.Skill;

/**
 * Created by Steve on 6/17/2017.
 */
public class XpGlobe
{

	private Skill skill;
	private int currentXp;
	private int currentLevel;
	private int goalXp;
	private long time;
	private double skillProgressRadius;

	public XpGlobe(Skill skill, int currentXp, int currentLevel, int goalXp, long time)
	{
		this.skill = skill;
		this.currentXp = currentXp;
		this.currentLevel = currentLevel;
		this.goalXp = goalXp;
		this.time = time;
	}

	public Skill getSkill()
	{
		return skill;
	}

	public void setSkill(Skill skill)
	{
		this.skill = skill;
	}

	public int getCurrentXp()
	{
		return currentXp;
	}

	public void setCurrentXp(int currentXp)
	{
		this.currentXp = currentXp;
	}

	public int getCurrentLevel()
	{
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel)
	{
		this.currentLevel = currentLevel;
	}

	public int getGoalXp()
	{
		return goalXp;
	}

	public void setGoalXp(int goalXp)
	{
		this.goalXp = goalXp;
	}

	public int getGoalLevel()
	{
		return this.currentLevel++;
	}

	public String getSkillName()
	{
		return skill.getName();
	}

	public double getSkillProgressRadius()
	{
		return skillProgressRadius;
	}

	public void setSkillProgressRadius(int startXp, int currentXp, int goalXp)
	{
		double xpGained = currentXp - startXp;
		double xpGoal = goalXp - startXp;
		this.skillProgressRadius = -(3.6 * ((xpGained / xpGoal) * 100)); //arc goes backwards
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}
}
