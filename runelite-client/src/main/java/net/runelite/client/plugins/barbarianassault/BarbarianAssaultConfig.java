/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Shows time to next call change",
		position = 0
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableGameChatColors",
		name = "Chat colors",
		description = "Enable game chat colors on messages announced by this plugin",
		position = 1
	)
	default boolean enableGameChatColors()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeathTimesMode",
		name = "Show death times",
		description = "Shows the time all penance monsters of a certain type are killed in an info box, the chat, or both",
		position = 2
	)
	default DeathTimesMode showDeathTimesMode()
	{
		return DeathTimesMode.INFOBOX_CHAT;
	}

	@ConfigItem(
		keyName = "showDurationMode",
		name = "Show duration",
		description = "Displays duration after each wave and/or round",
		position = 3
	)
	default DurationMode showDurationMode()
	{
		return DurationMode.WAVE_ROUND;
	}

	@ConfigItem(
		keyName = "showRewardPointsMode",
		name = "Reward points",
		description = "Gives summary of reward points in the chat after each wave and/or round",
		position = 4
	)
	default PointsMode showRewardPointsMode()
	{
		return PointsMode.WAVE_ROUND;
	}

	@ConfigItem(
		keyName = "showRewardsBreakdownMode",
		name = "Rewards breakdown",
		description = "Gives summary of advanced points breakdown in the chat",
		position = 5
	)
	default RewardsBreakdownMode showRewardsBreakdownMode()
	{
		return RewardsBreakdownMode.ROUND;
	}

	@ConfigItem(
		keyName = "showEggsOnHopper",
		name = "Show eggs loaded on hopper",
		description = "Displays the amount of loaded eggs on cannon hoppers",
		position = 6
	)
	default boolean showEggsOnHopper()
	{
		return true;
	}

	@ConfigItem(
		keyName = "inventoryHighlightMode",
		name = "Highlight mode",
		description = "Define the mode of all inventory highlights",
		position = 7
	)
	default InventoryHighlightMode inventoryHighlightMode()
	{
		return InventoryHighlightMode.OUTLINE;
	}

	@ConfigSection(
		name = "Attacker",
		description = "Options associated to the Attacker role",
		position = 8,
		closedByDefault = true
	)
	String attackerSection = "attacker";

	@ConfigItem(
		keyName = "highlightArrows",
		name = "Highlight arrows",
		description = "Highlights arrows called by your teammate",
		position = 0,
		section = attackerSection
	)
	default boolean highlightArrows()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightArrowColor",
		name = "Highlight arrow color",
		description = "Configures the color to highlight the called arrows",
		position = 1,
		section = attackerSection
	)
	default Color highlightArrowColor()
	{
		return new Color(0, 255, 0, 175);
	}

	@ConfigItem(
		keyName = "highlightAttackStyle",
		name = "Highlight attack style",
		description = "Highlights the attack style called by your teammate",
		position = 2,
		section = attackerSection
	)
	default boolean highlightAttackStyle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightAttackStyleColor",
		name = "Highlight attack style color",
		description = "Configures the color to highlight the attack style",
		position = 3,
		section = attackerSection
	)
	default Color highlightAttackStyleColor()
	{
		return Color.GREEN;
	}

	@ConfigSection(
		name = "Defender",
		description = "Options associated to the Defender role",
		position = 9,
		closedByDefault = true
	)
	String defenderSection = "defender";

	@ConfigItem(
		keyName = "highlightBait",
		name = "Highlight called bait",
		description = "Highlights bait called by your teammate",
		position = 0,
		section = defenderSection
	)
	default boolean highlightBait()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightBaitColor",
		name = "Called bait color",
		description = "Color to highlight the bait called by your teammate",
		position = 1,
		section = defenderSection
	)
	default Color highlightBaitColor()
	{
		return new Color(0, 255, 0, 175);
	}

	@ConfigItem(
		keyName = "showRunnerTickTimer",
		name = "Show runner tick timer",
		description = "Shows the current cycle tick of runners",
		position = 2,
		section = defenderSection
	)
	default boolean showRunnerTickTimer()
	{
		return true;
	}

	@ConfigSection(
		name = "Collector",
		description = "Options associated to the Collector role",
		position = 10,
		closedByDefault = true
	)
	String collectorSection = "collector";

	@ConfigItem(
		keyName = "showEggCountOverlay",
		name = "Show number of eggs collected",
		description = "Displays current number of eggs collected",
		position = 0,
		section = collectorSection
	)
	default boolean showEggCountOverlay()
	{
		return true;
	}

	@ConfigSection(
		name = "Healer",
		description = "Options associated to the Healer role",
		position = 11,
		closedByDefault = true
	)
	String healerSection = "healer";

	@ConfigItem(
		keyName = "highlightPoison",
		name = "Highlight called poison",
		description = "Highlights poison food called by your teammate",
		position = 0,
		section = healerSection
	)
	default boolean highlightPoison()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightPoisonColor",
		name = "Called poison color",
		description = "Configures the color to highlight the correct poison food",
		position = 1,
		section = healerSection
	)
	default Color highlightPoisonColor()
	{
		return new Color(0, 255, 0, 175);
	}

	@ConfigItem(
		keyName = "highlightNotification",
		name = "Highlight incorrect notification",
		description = "Highlights incorrect poison chat notification",
		position = 2,
		section = healerSection
	)
	default boolean highlightNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightNotificationColor",
		name = "Notification color",
		description = "Configures the color to highlight the notification text",
		position = 3,
		section = healerSection
	)
	default Color highlightNotificationColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "showHpCountOverlay",
		name = "Show number of hitpoints healed",
		description = "Displays current number of hitpoints healed",
		position = 4,
		section = healerSection
	)
	default boolean showHpCountOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTeammateHealthBars",
		name = "Show teammate health bars",
		description = "Displays a health bar where a teammate's remaining health is located",
		position = 5,
		section = healerSection
	)
	default boolean showTeammateHealthBars()
	{
		return true;
	}
}
