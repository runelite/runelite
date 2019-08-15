/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.tearsofguthix;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Tears Of Guthix",
	description = "Show timers for the Tears Of Guthix streams",
	tags = {"minigame", "overlay", "skilling", "timers", "tog"}
)
@Singleton
public class TearsOfGuthixPlugin extends Plugin
{
	private static final int TOG_REGION = 12948;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TearsOfGuthixOverlay overlay;

	@Inject
	private TearsOfGuthixExperienceOverlay experienceOverlay;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private final Map<DecorativeObject, Instant> streams = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Skill playerLowestSkill = null;

	@Override
	protected void startUp()
	{
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(experienceOverlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(experienceOverlay);
		streams.clear();
		playerLowestSkill = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(DecorativeObjectSpawned.class, this, this::onDecorativeObjectSpawned);
		eventBus.subscribe(DecorativeObjectDespawned.class, this, this::onDecorativeObjectDespawned);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case LOGIN_SCREEN:
			case HOPPING:
				streams.clear();
		}

		if (event.getGameState() == GameState.LOGGED_IN && client.getLocalPlayer() != null)
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == TOG_REGION)
			{
				if (playerLowestSkill != null)
				{
					return;
				}

				if (client.getSkillExperience(Skill.HITPOINTS) > 0)
				{
					playerLowestSkill = getLowestPlayerSkill();
				}
			}
			else
			{
				playerLowestSkill = null;
			}
		}
	}

	private void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject object = event.getDecorativeObject();

		if ((object.getId() == ObjectID.BLUE_TEARS ||
			object.getId() == ObjectID.BLUE_TEARS_6665) &&
			client.getLocalPlayer().getWorldLocation().getRegionID() == TOG_REGION)
		{
			streams.put(event.getDecorativeObject(), Instant.now());
		}
	}

	private void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		if (streams.isEmpty())
		{
			return;
		}

		DecorativeObject object = event.getDecorativeObject();
		streams.remove(object);
	}

	private Skill getLowestPlayerSkill()
	{
		final Skill[] playerSkills = Skill.values();
		Skill lowestExperienceSkill = null;
		int lowestExperienceAmount = Integer.MAX_VALUE;

		for (Skill skill : playerSkills)
		{
			int currentSkillExp = client.getSkillExperience(skill);

			if (currentSkillExp < lowestExperienceAmount)
			{
				lowestExperienceAmount = currentSkillExp;
				lowestExperienceSkill = skill;
			}
		}

		return lowestExperienceSkill;
	}
}
