/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.boosts;

import com.google.common.collect.ObjectArrays;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.SkillBoostChange;
import net.runelite.api.events.SkillLevelChange;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boosts"
)
public class BoostsPlugin extends Plugin
{
	private static final Skill[] COMBAT = new Skill[]
	{
		Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.MAGIC
	};

	private static final Skill[] SKILLING = new Skill[]
	{
		Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
		Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER
	};

	@Getter
	private final List<Skill> boostedSkills = new ArrayList<>();
	private final List<Skill> shownSkills = new ArrayList<>();
	private final Map<Skill, BoostIndicator> indicators = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private BoostsOverlay boostsOverlay;

	@Inject
	private BoostsConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SkillIconManager iconManager;

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return boostsOverlay;
	}

	@Override
	protected void startUp()
	{
		updateShownSkills(config.enableSkill());

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			refreshBoostedSkills();
			updateInfoBoxes();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		boostedSkills.clear();
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator);
		indicators.clear();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("enableSkill"))
		{
			updateShownSkills(config.enableSkill());
			refreshBoostedSkills();
			updateInfoBoxes();
		}

		if (event.getKey().equals("displayIndicators"))
		{
			updateInfoBoxes();
		}
	}

	@Subscribe
	public void onSkillLevelChanged(SkillLevelChange event)
	{
		Skill skill = event.getSkill();
		int base = client.getRealSkillLevel(skill);
		int boosted = client.getBoostedSkillLevel(skill);

		if (base == boosted)
		{
			indicators.remove(skill);
		}
		else
		{
			BoostIndicator indicator = indicators.get(skill);

			if (indicator != null)
			{
				int level = client.getRealSkillLevel(skill);

				if (level > indicator.getBaseLevel())
				{
					indicator.setBaseLevel(level);
				}
			}
		}

		refreshBoostedSkills();
		updateInfoBoxes();
	}

	@Subscribe
	public void onSkillBoostChanged(SkillBoostChange event)
	{
		Skill skill = event.getSkill();

		if (!shownSkills.contains(skill))
		{
			return;
		}

		int base = client.getRealSkillLevel(skill);

		if (base == 0)
		{
			return;
		}

		int boosted = client.getBoostedSkillLevel(skill);

		if (boosted == base)
		{
			if (boostedSkills.contains(skill))
			{
				boostedSkills.remove(skill);
				indicators.remove(skill);
			}
		}
		else
		{
			if (!boostedSkills.contains(skill))
			{
				boostedSkills.add(skill);
			}
			else
			{
				BoostIndicator indicator = indicators.get(skill);

				if (indicator != null && indicator.getBoostedLevel() != boosted)
				{
					indicator.setBoostedLevel(boosted);
				}
			}
		}

		updateInfoBoxes();
	}

	private void updateShownSkills(boolean showSkillingSkills)
	{
		shownSkills.clear();

		if (showSkillingSkills)
		{
			shownSkills.addAll(Arrays.asList(ObjectArrays.concat(COMBAT, SKILLING, Skill.class)));
		}
		else
		{
			shownSkills.addAll(Arrays.asList(COMBAT));
		}
	}

	private void refreshBoostedSkills()
	{
		boostedSkills.clear();

		for (Skill skill : shownSkills)
		{
			int boosted = client.getBoostedSkillLevel(skill);
			int base = client.getRealSkillLevel(skill);

			if (boosted != base)
			{
				boostedSkills.add(skill);
			}
		}
	}

	private void updateInfoBoxes()
	{
		if (!config.displayIndicators())
		{
			infoBoxManager.removeIf(t -> t instanceof BoostIndicator);
			indicators.clear();
			return;
		}

		infoBoxManager.removeIf(t -> t instanceof BoostIndicator &&
				(!shownSkills.contains(((BoostIndicator) t).getSkill()) || !boostedSkills.contains(((BoostIndicator) t).getSkill())));

		for (Skill skill : boostedSkills)
		{
			BoostIndicator indicator = indicators.get(skill);

			if (indicator == null)
			{
				int boosted = client.getBoostedSkillLevel(skill);
				int base = client.getRealSkillLevel(skill);

				indicator = new BoostIndicator(skill, iconManager.getSkillImage(skill), config, base, boosted);
				indicators.put(skill, indicator);
			}

			if (!infoBoxManager.getInfoBoxes().contains(indicator))
			{
				infoBoxManager.addInfoBox(indicator);
			}
		}
	}
}
