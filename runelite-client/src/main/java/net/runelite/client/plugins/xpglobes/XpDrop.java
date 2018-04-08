package net.runelite.client.plugins.xpglobes;

import net.runelite.api.Skill;
import java.util.ArrayList;
import java.util.List;

public class XpDrop
{

    private List<Skill> skills = new ArrayList<>();
    private int xp;
    private float x;
    private float y;
    private boolean xPositionInitialized;

    private static final int DROP_DEFAULT_START_Y = 140;

    public XpDrop(Skill skill, int xp)
    {
        this.skills.add(skill);
        this.xp = xp;
        this.x = 0.0f;
        this.xPositionInitialized = false;
        this.y = DROP_DEFAULT_START_Y;
    }

    public void addXpDrop(Skill skill, int xpGained)
    {
        addSkill(skill);
        this.xp += xpGained;
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public void addSkill(Skill skill)
    {
        this.skills.add(skill);
    }

    public int getXp()
    {
        return xp;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public boolean isxPositionInitialized()
    {
        return xPositionInitialized;
    }

    public void setxPositionInitialized(boolean xPositionInitialized)
    {
        this.xPositionInitialized = xPositionInitialized;
    }
}
