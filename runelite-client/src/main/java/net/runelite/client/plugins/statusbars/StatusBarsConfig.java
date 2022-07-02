/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.statusbars;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;
import net.runelite.client.plugins.statusbars.config.BarMode;

@ConfigGroup(StatusBarsConfig.GROUP)
public interface StatusBarsConfig extends Config
{
	String GROUP = "statusbars";

	@ConfigSection(
		name = "General",
		description = "General settings",
		position = 0,
		closedByDefault = false
	)
	String generalSettings = "generalSettings";

	@ConfigSection(
		name = "Bar Colors",
		description = "Adjust colors for each type of bar",
		position = 1,
		closedByDefault = true
	)
	String barColors = "barColors";

	@ConfigItem(
		keyName = "enableCounter",
		name = "Show counters",
		description = "Shows current value of the status on the bar",
		section = generalSettings
	)
	default boolean enableCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableSkillIcon",
		name = "Show icons",
		description = "Adds skill icons at the top of the bars.",
		section = generalSettings
	)
	default boolean enableSkillIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableRestorationBars",
		name = "Show restores",
		description = "Visually shows how much will be restored to your status bar.",
		section = generalSettings
	)
	default boolean enableRestorationBars()
	{
		return true;
	}

	@ConfigItem(
		keyName = "leftBarMode",
		name = "Left Bar",
		description = "Configures the left status bar",
		section = generalSettings
	)
	default BarMode leftBarMode()
	{
		return BarMode.HITPOINTS;
	}

	@ConfigItem(
		keyName = "rightBarMode",
		name = "Right Bar",
		description = "Configures the right status bar",
		section = generalSettings
	)
	default BarMode rightBarMode()
	{
		return BarMode.PRAYER;
	}

	@ConfigItem(
		keyName = "hideAfterCombatDelay",
		name = "Hide after combat delay",
		description = "Amount of ticks before hiding status bars after no longer in combat. 0 = always show status bars.",
		section = generalSettings
	)
	@Units(Units.TICKS)
	default int hideAfterCombatDelay()
	{
		return 0;
	}

	@Range(
		min = BarRenderer.MIN_WIDTH,
		max = BarRenderer.MAX_WIDTH
	)
	@ConfigItem(
		keyName = "barWidth",
		name = "Bar Width",
		description = "The width of the status bars in the modern resizeable layout.",
		section = generalSettings
	)
	default int barWidth()
	{
		return BarRenderer.DEFAULT_WIDTH;
	}

	// Begin color settings


	@ConfigItem(
		keyName = "backgroundColor",
		name = "Background color",
		description = "The background color of all bars where not completely filled",
		section = barColors,
		position = 0
	)
	default Color getBackgroundColor()
	{
		return new Color(0, 0, 0, 150);
	}

	@ConfigItem(
		keyName = "healthColor",
		name = "Health bar color",
		description = "The color of the health bar",
		section = barColors,
		position = 1
	)
	default Color getHealthColor()
	{
		return new Color(225, 35, 0, 125);
	}

	@ConfigItem(
		keyName = "healColor",
		name = "Heal color",
		description = "The color of the health bar that displays healing amount",
		section = barColors,
		position = 2
	)
	default Color getHealColor()
	{
		return new Color(255, 112, 6, 150);
	}

	@ConfigItem(
		keyName = "overhealColor",
		name = "Overheal color",
		description = "The color the bar will be when an overheal will occur",
		section = barColors,
		position = 3
	)
	default Color getOverhealColor()
	{
		return new Color(216, 255, 139, 150);
	}

	@ConfigItem(
		keyName = "prayerColor",
		name = "Prayer bar color",
		description = "The color of the prayer bar",
		section = barColors,
		position = 4
	)
	default Color getPrayerColor()
	{
		return new Color(50, 200, 200, 175);
	}

	@ConfigItem(
		keyName = "prayerRestoreColor",
		name = "Prayer restore color",
		description = "The color of the prayer bar that displays prayer restore amount",
		section = barColors,
		position = 5
	)
	default Color getPrayerRestoreColor()
	{
		return new Color(57, 255, 186, 75);
	}

	@ConfigItem(
		keyName = "activePrayerColor",
		name = "Active Prayer bar color",
		description = "The color of the prayer bar while prayers are being used",
		section = barColors,
		position = 6
	)
	default Color getActivePrayerColor()
	{
		return new Color(57, 255, 186, 225);
	}

	@ConfigItem(
		keyName = "energyColor",
		name = "Energy bar color",
		description = "The color of the run energy bar",
		section = barColors,
		position = 7
	)
	default Color getEnergyColor()
	{
		return new Color(199, 174, 0, 220);
	}

	@ConfigItem(
		keyName = "energyRestoreColor",
		name = "Energy restore color",
		description = "The color of the run energy bar that displays energy restore amount",
		section = barColors,
		position = 8
	)
	default Color getEnergyRestoreColor()
	{
		return new Color (199,  118, 0, 218);
	}

	@ConfigItem(
		keyName = "staminaPotColor",
		name = "Stamina pot color",
		description = "The color of the run energy bar while affected by a stamina pot or Ring of Endurance",
		section = barColors,
		position = 9
	)
	default Color getStaminaPotColor()
	{
		return new Color(160, 124, 72, 255);
	}

	@ConfigItem(
		keyName = "specialAttackColor",
		name = "Special attack color",
		description = "The color of the special attack bar",
		section = barColors,
		position = 10
	)
	default Color getSpecialAttackColor()
	{
		return new Color(3, 153, 0, 195);
	}

	@ConfigItem(
		keyName = "poisonedColor",
		name = "Poisoned color",
		description = "The color of the health bar while poisoned",
		section = barColors,
		position = 11
	)
	default Color getPoisonedColor()
	{
		return new Color(0, 145, 0, 150);
	}

	@ConfigItem(
		keyName = "envenomedColor",
		name = "Envenomed color",
		description = "The color of the health bar while envenomed",
		section = barColors,
		position = 12
	)
	default Color getEnvenomedColor()
	{
		return new Color(0, 65, 0, 150);
	}

	@ConfigItem(
		keyName = "diseasedColor",
		name = "Diseased color",
		description = "The color of the health bar while diseased",
		section = barColors,
		position = 13
	)
	default Color getDiseasedColor()
	{
		return new Color(255, 193, 75, 181);
	}

	@ConfigItem(
		keyName = "parasiteColor",
		name = "Parasite color",
		description = "The color of the health bar while afflicted with parasites",
		section = barColors,
		position = 14
	)
	default Color getParasiteColor()
	{
		return new Color(196, 62, 109, 181);
	}
}
