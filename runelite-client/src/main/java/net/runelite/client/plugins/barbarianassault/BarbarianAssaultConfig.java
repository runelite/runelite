/*
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "swapLadder",
		name = "Swap quick-start",
		description = "Enables swapping of 'Climb-down' and 'Quick-start' in the wave lobby",
		position = 0
	)
	default boolean swapLadder()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Shows time to next call change",
		position = 1
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeIncorrectCalls",
		name = "Remove incorrect calls",
		description = "Removes incorrect 'Tell' menu options from horn",
		position = 2
	)
	default boolean removeIncorrectCalls()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeUnusedMenus",
		name = "Remove unused menus",
		description = "Removes unnecessary menu options" +
			"<br>Example: Attack options are removed when not attacker",
		position = 3
	)
	default boolean removeUnusedMenus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "prayerMetronome",
		name = "Enable prayer metronome",
		description = "Turns on a metronome sync'd to the game's tick rate when any prayer is active",
		position = 4
	)
	default boolean prayerMetronome()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 50
	)
	@ConfigItem(
		keyName = "prayerMetronomeVolume",
		name = "Metronome volume",
		description = "Adjusts the metronome's volume",
		position = 5,
		hidden = true,
		unhide = "prayerMetronome"
	)
	default int prayerMetronomeVolume()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "showDeathTimes",
		name = "Show death times",
		description = "Shows the time all penance monsters of a certain type are killed in the chat box, an info box, or both",
		position = 6
	)
	default boolean showDeathTimes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDeathTimesMode",
		name = "Mode",
		description = "",
		position = 7,
		hidden = true,
		unhide = "showDeathTimes"
	)
	default DeathTimesMode showDeathTimesMode()
	{
		return DeathTimesMode.BOTH;
	}

	@ConfigItem(
		keyName = "waveTimes",
		name = "Show wave and game duration",
		description = "Displays wave duration after each wave and total game time after wave 10",
		position = 8
	)
	default boolean waveTimes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTotalRewards",
		name = "Summarize total reward points",
		description = "Gives summary of advanced points breakdown in chat log",
		position = 9
	)
	default boolean showTotalRewards()
	{
		return true;
	}


	/*///************///*/
	/*///  Attacker  ///*/
	/*///************///*/

	@ConfigSection(
		name = "Attacker",
		description = "",
		position = 10,
		keyName = "attackerSection"
	)
	default boolean attackerSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightArrows",
		name = "Highlight called arrows",
		description = "Highlights arrows called by your teammate",
		position = 0,
		section = "attackerSection"
	)
	default boolean highlightArrows()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightArrowColor",
		name = "Arrow color",
		description = "Configures the color to highlight the called arrows",
		position = 1,
		section = "attackerSection",
		hidden = true,
		unhide = "highlightArrows"
	)
	default Color highlightArrowColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "removeIncorrectAttackStyles",
		name = "Remove incorrect attack styles",
		description = "Hides wrong attack styles for dragon claws and crystal halberd",
		position = 2,
		section = "attackerSection"
	)
	default boolean removeIncorrectAttackStyles()
	{
		return false;
	}

	@ConfigItem(
		keyName = "tagging",
		name = "Enable tagging",
		description = "Highlights the menu entry of an attacker/ranger that has not been tagged.",
		position = 3,
		section = "attackerSection"
	)
	default boolean tagging()
	{
		return false;
	}


	/*///************///*/
	/*///  Defender  ///*/
	/*///************///*/

	@ConfigSection(
		name = "Defender",
		description = "",
		position = 11,
		keyName = "defenderSection"
	)
	default boolean defenderSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightBait",
		name = "Highlight called bait",
		description = "Highlights bait called by your teammate",
		position = 0,
		section = "defenderSection"
	)
	default boolean highlightBait()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightBaitColor",
		name = "Bait color",
		description = "Configures the color to highlight the called bait",
		position = 1,
		section = "defenderSection",
		hidden = true,
		unhide = "highlightBait"
	)
	default Color highlightBaitColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "showDefTimer",
		name = "Show defender tick timer",
		description = "Shows the current cycle tick of runners",
		position = 2,
		section = "defenderSection"
	)
	default boolean showDefTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "deprioritizeBait",
		name = "Deprioritize bait",
		description = "Moves 'Take' menu option for all bait below 'Walk Here'",
		position = 3,
		section = "defenderSection"
	)
	default boolean deprioritizeBait()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removePenanceCave",
		name = "Remove penance cave",
		description = "Removes 'Block' menu option from penance cave",
		position = 4,
		section = "defenderSection"
	)
	default boolean removePenanceCave()
	{
		return true;
	}


	/*///**********///*/
	/*///  Healer  ///*/
	/*///**********///*/

	@ConfigSection(
		name = "Healer",
		description = "",
		position = 12,
		keyName = "healerSection"
	)
	default boolean healerSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highlightPoison",
		name = "Highlight called poison",
		description = "Highlights poison called by your teammate",
		position = 0,
		section = "healerSection"
	)
	default boolean highlightPoison()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightPoisonColor",
		name = "Poison color",
		description = "Configures the color to highlight the called poison",
		position = 1,
		section = "healerSection",
		hidden = true,
		unhide = "highlightPoison"
	)
	default Color highlightPoisonColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "highlightNotification",
		name = "Highlight incorrect notification",
		description = "Highlights incorrect poison chat notification",
		position = 2,
		section = "healerSection"
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
		section = "healerSection",
		hidden = true,
		unhide = "highlightNotification"
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
		section = "healerSection"
	)
	default boolean showHpCountOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTeammateHealthbars",
		name = "Show health bars",
		description = "Displays a health bar where a teammate's remaining health is located",
		position = 5,
		section = "healerSection"
	)
	default boolean showTeammateHealthbars()
	{
		return true;
	}

	@ConfigItem(
		keyName = "healerCodes",
		name = "Show healer codes",
		description = "Overlay to show healer codes",
		position = 6,
		section = "healerSection"
	)
	default boolean healerCodes()
	{
		return false;
	}

	@ConfigItem(
		keyName = "healerMenuOption",
		name = "Show healer menu options",
		description = "Shows tick count in healer menu options",
		position = 7,
		section = "healerSection"
	)
	default boolean healerMenuOption()
	{
		return false;
	}

	@ConfigItem(
		keyName = "shiftOverstock",
		name = "Enable shift overstock",
		description = "Enables overstocking by pressing shift",
		position = 8,
		section = "healerSection"
	)
	default boolean shiftOverstock()
	{
		return true;
	}

	@ConfigItem(
		keyName = "controlHealer",
		name = "Control Healer",
		description = "Hold ctrl to put last healer clicked on top",
		position = 9,
		section = "healerSection"
	)
	default boolean controlHealer()
	{
		return true;
	}


	/*///*************///*/
	/*///  Collector  ///*/
	/*///*************///*/

	@ConfigSection(
		name = "Collector",
		description = "",
		position = 13,
		keyName = "collectorSection"
	)
	default boolean collectorSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapCollectorBag",
		name = "Swap empty",
		description = "Enables swapping of 'Look-in' and 'Empty' on the collector's bag",
		position = 0,
		section = "collectorSection"
	)
	default boolean swapCollectorBag()
	{
		return true;
	}

	@ConfigItem(
		keyName = "swapDestroyEggs",
		name = "Swap destroy",
		description = "Enables swapping of 'Use' and 'Destroy' on collector eggs; this does not affect yellow/omega eggs",
		position = 1,
		section = "collectorSection"
	)
	default boolean swapDestroyEggs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightCollectorEggs",
		name = "Highlight collector eggs",
		description = "Highlight called egg colors",
		position = 2,
		section = "collectorSection"
	)
	default boolean highlightCollectorEggs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "deprioritizeIncorrectEggs",
		name = "Deprioritize incorrect eggs",
		description = "Moves 'Take' menu option for incorrect eggs below 'Walk Here'",
		position = 3,
		section = "collectorSection"
	)
	default boolean deprioritizeIncorrectEggs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showEggCountOverlay",
		name = "Show number of eggs collected",
		description = "Displays current number of eggs collected",
		position = 4,
		section = "collectorSection"
	)
	default boolean showEggCountOverlay()
	{
		return true;
	}
}