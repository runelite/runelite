package net.runelite.client.plugins.xpglobes;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ExperienceChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Steve on 6/17/2017.
 */
public class XpGlobes extends Plugin
{

	private final XpGlobesConfig config = RuneLite.getRunelite().getConfigManager()
			.getConfig(XpGlobesConfig.class);
	private final Overlay overlay = new XpGlobesOverlay(this);
	private final Client client = RuneLite.getClient();
	private XpGlobe[] globeCache = new XpGlobe[23];
	private ArrayList<XpGlobe> xpGlobes = new ArrayList<>();
	private int SECONDS_TO_SHOW_GLOBE = 10;
	private int MAXIMUM_SHOWN_GLOBES = 5;

	@Override
	protected void startUp() throws Exception
	{

	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	private void onExperienceChanged(ExperienceChanged event)
	{
		if (!config.enabled())
		{
			return;
		}

		Skill skill = event.getSkill();
		int currentXp = client.getSkillExperience(skill);
		int currentLevel = Experience.getLevelForXp(currentXp);
		int startingXp = 0;
		if (currentLevel > 1) {
			startingXp = Experience.getXpForLevel(currentLevel);
		}
		int goalXp = Experience.getXpForLevel(currentLevel+1);

		int skillIdx = skill.ordinal();
		XpGlobe cachedGlobe = globeCache[skillIdx];
		if (cachedGlobe != null)
		{
			cachedGlobe.setSkill(skill);
			cachedGlobe.setCurrentXp(currentXp);
			cachedGlobe.setCurrentLevel(currentLevel);
			cachedGlobe.setGoalXp(goalXp);
			cachedGlobe.setTime(new Date().getTime());
			cachedGlobe.setSkillProgressRadius(startingXp, currentXp, goalXp);
		}
		else
		{
			globeCache[skillIdx] = new XpGlobe(skill, currentXp, currentLevel, goalXp, new Date().getTime());
		}

		this.addXpGlobe(globeCache[skillIdx], MAXIMUM_SHOWN_GLOBES);
	}

	public ArrayList<XpGlobe> getXpGlobes()
	{
		return xpGlobes;
	}

	public void addXpGlobe(XpGlobe xpGlobe, int maxLength)
	{
		if (xpGlobes.contains(xpGlobe))
		{
			xpGlobes.remove(xpGlobe);
		}
		if (maxLength == getXpGlobesSize())
		{
			xpGlobes.remove(0);
		}
		xpGlobes.add(xpGlobe);
	}

	public int getXpGlobesSize()
	{
		return xpGlobes.size();
	}

	public void removeExpiredXpGlobes()
	{
		if (!xpGlobes.isEmpty())
		{
			long currentTimeInSeconds = new Date().getTime() / 1000;
			for (int i = 0; i < xpGlobes.size(); i++)
			{
				XpGlobe globe = xpGlobes.get(i);
				long timeCreatedInSeconds = globe.getTime() / 1000;
				if (currentTimeInSeconds - timeCreatedInSeconds > SECONDS_TO_SHOW_GLOBE)
				{
					xpGlobes.remove(globe);
				}
			}
		}
	}

	public XpGlobesConfig getConfig()
	{
		return config;
	}
}
