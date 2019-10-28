package net.runelite.client.game;

import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.EventBus;

@Singleton
public class XpDropManager
{

	private final Map<Skill, Integer> previousSkillExpTable = new EnumMap<>(Skill.class);
	@Getter(AccessLevel.PACKAGE)
	private int damage = 0;
	@Getter(AccessLevel.PACKAGE)
	private int tickShow = 0;
	private int previousExpGained;
	private Client client;
	private EventBus eventBus;

	@Inject
	private XpDropManager(
		final EventBus eventBus,
		final Client client
	)
	{
		this.client = client;
		this.eventBus = eventBus;
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		damage = 0;
		tickShow = 0;
	}

	private void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int xp = client.getSkillExperience(skill);
		Integer previous = previousSkillExpTable.put(skill, xp);
		if (previous != null)
		{
			previousExpGained = xp - previous;
			XpDropEvent xpDropEvent = new XpDropEvent();
			xpDropEvent.setExp(previousExpGained);
			xpDropEvent.setSkill(skill);
			eventBus.post(XpDropEvent.class, xpDropEvent);
		}
	}
}
