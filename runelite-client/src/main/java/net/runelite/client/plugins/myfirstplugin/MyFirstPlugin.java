package net.runelite.client.plugins.myfirstplugin;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.StatChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "MyFirstPlugin",
	description = "My first plugin"
)

public class MyFirstPlugin extends Plugin
{

	@Inject
	private Client client;

	@Subscribe
	public void onStatChanged(StatChanged event)
	{
		Skill skill = event.getSkill();
		int xp = client.getSkillExperience(skill);
		int level = client.getRealSkillLevel(skill);
		if (level != 0)
		{
			System.out.println("Gz!!!" + skill.getName() + " at " + xp + " XP at level " + level);
		}
	}

}
