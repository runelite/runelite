/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, alanbaumgartner <https://github.com/alanbaumgartner>
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.menuentryswapperextended;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.plugins.menuentryswapperextended.util.BurningAmuletMode;
import net.runelite.client.plugins.menuentryswapperextended.util.BuyMode;
import net.runelite.client.plugins.menuentryswapperextended.util.CombatBraceletMode;
import net.runelite.client.plugins.menuentryswapperextended.util.ConstructionCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.ConstructionMode;
import net.runelite.client.plugins.menuentryswapperextended.util.CraftingCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.DiaryCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.DigsitePendantMode;
import net.runelite.client.plugins.menuentryswapperextended.util.DuelingRingMode;
import net.runelite.client.plugins.menuentryswapperextended.util.FarmCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.GamesNecklaceMode;
import net.runelite.client.plugins.menuentryswapperextended.util.GloryMode;
import net.runelite.client.plugins.menuentryswapperextended.util.MagicCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.MaxCapeEquippedMode;
import net.runelite.client.plugins.menuentryswapperextended.util.NecklaceOfPassageMode;
import net.runelite.client.plugins.menuentryswapperextended.util.QuestCapeMode;
import net.runelite.client.plugins.menuentryswapperextended.util.RingOfWealthMode;
import net.runelite.client.plugins.menuentryswapperextended.util.SellMode;
import net.runelite.client.plugins.menuentryswapperextended.util.SkillsNecklaceMode;
import net.runelite.client.plugins.menuentryswapperextended.util.XericsTalismanMode;

@ConfigGroup("menuentryswapperextended")
public interface MenuEntrySwapperExtendedConfig extends Config
{
	@ConfigSection(
			name = "Skilling",
			description = "",
			position = 4,
			closedByDefault = true
	)
	String skillingSection = "Skilling";

	@ConfigSection(
			name = "Teleportation",
			description = "",
			position = 5,
			closedByDefault = true
	)
	String teleportationSection = "Teleportation";

	@ConfigSection(
			name = "Right Click Options",
			description = "",
			position = 6,
			closedByDefault = true
	)
	String rightClickOptionsSection = "Right Click Options";


	@ConfigSection(
			name = "PvM",
			description = "",
			position = 7,
			closedByDefault = true
	)
	String pvmSection = "PvM";

	@ConfigSection(
			name = "Custom Swaps",
			description = "Configuration for custom Swaps",
			position = 0,
			closedByDefault = true
	)
	String customSwapsSection = "Custom Swaps";

	@ConfigSection(
			name = "Shift Swaps",
			description = "Configuration for Shift Swaps",
			position = 1,
			closedByDefault = true
	)
	String shiftCustomSwapsSection = "Shift Swaps";

	@ConfigSection(
			name = "Hotkey Swaps",
			description = "Configuration for Hotkey Custom Swaps",
			position = 2,
			closedByDefault = true
	)
	String keyCustomSwapsSection = "Hotkey Swaps";

	@ConfigSection(
			name = "Remove Options",
			description = "Configuration for removing swaps",
			position = 3,
			closedByDefault = true
	)
	String removeSwapsSection = "Remove Options";

	//------------------------------------------------------------//
	// Skilling
	//------------------------------------------------------------//

	@ConfigItem(
			keyName = "getEasyConstruction",
			name = "Easy Construction",
			description = "Makes 'Remove'/'Build' the default option for listed items.",
			position = 0,
			section = skillingSection
	)
	default boolean getEasyConstruction()
	{
		return true;
	}

	@ConfigItem(
			keyName = "getConstructionMode",
			name = "EZ Construction Type",
			description = "",
			position = 1,
			section = skillingSection
	)
	default ConstructionMode getConstructionMode()
	{
		return ConstructionMode.LARDER;
	}

	@ConfigItem(
			keyName = "swapPickpocket",
			name = "Pickpocket",
			description = "Swap Talk-to with Pickpocket on NPC<br>Example: Man, Woman",
			position = 2,
			section = skillingSection
	)
	default boolean swapPickpocket()
	{
		return false;
	}

	@ConfigItem(
		keyName = "swapEmptyPouch",
		name = "Essence Pouch",
		description = "Swap 'Fill' with 'Empty' on rune essence pouches.<br>Only activates near altars.",
		position = 3,
		section = skillingSection
	)
	default boolean swapEmptyPouch()
	{
		return false;
	}

	//------------------------------------------------------------//
	// Teleportation
	//------------------------------------------------------------//

	@ConfigItem(
			keyName = "swapGamesNecklace",
			name = "Games Necklace",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Games Necklace.",
			position = 1,
			section = teleportationSection
	)
	default boolean getGamesNecklace()
	{
		return false;
	}

	@ConfigItem(
			keyName = "gamesNecklaceMode",
			name = "Mode",
			description = "",
			position = 2,
			section = teleportationSection
	)
	default GamesNecklaceMode getGamesNecklaceMode()
	{
		return GamesNecklaceMode.BURTHORPE;
	}

	@ConfigItem(
			keyName = "swapDuelingRing",
			name = "Dueling Ring",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Dueling.",
			position = 3,
			section = teleportationSection
	)
	default boolean getDuelingRing()
	{
		return false;
	}

	@ConfigItem(
			keyName = "duelingRingMode",
			name = "Mode",
			description = "",
			position = 4,
			section = teleportationSection
	)
	default DuelingRingMode getDuelingRingMode()
	{
		return DuelingRingMode.DUEL_ARENA;
	}

	@ConfigItem(
			keyName = "swapGlory",
			name = "Glory",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Amulet of Glory / Amulet of Eternal Glory.",
			position = 5,
			section = teleportationSection
	)
	default boolean getGlory()
	{
		return false;
	}

	@ConfigItem(
			keyName = "gloryMode",
			name = "Mode",
			description = "",
			position = 6,
			section = teleportationSection
	)
	default GloryMode getGloryMode()
	{
		return GloryMode.EDGEVILLE;
	}

	@ConfigItem(
			keyName = "swapSkill",
			name = "Skills Necklace",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Skills Necklace.",
			position = 7,
			section = teleportationSection
	)
	default boolean getSkillsNecklace()
	{
		return false;
	}

	@ConfigItem(
			keyName = "skillsnecklacemode",
			name = "Mode",
			description = "",
			position = 8,
			section = teleportationSection
	)
	default SkillsNecklaceMode getSkillsNecklaceMode()
	{
		return SkillsNecklaceMode.CRAFTING_GUILD;
	}

	@ConfigItem(
			keyName = "swapPassage",
			name = "Passage Necklace",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Necklace of Passage.",
			position = 9,
			section = teleportationSection
	)
	default boolean getNecklaceofPassage()
	{
		return false;
	}

	@ConfigItem(
			keyName = "necklaceofpassagemode",
			name = "Mode",
			description = "",
			position = 10,
			section = teleportationSection
	)
	default NecklaceOfPassageMode getNecklaceofPassageMode()
	{
		return NecklaceOfPassageMode.WIZARDS_TOWER;
	}

	@ConfigItem(
			keyName = "swapDigsite",
			name = "Digsite Pendant",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Digsite Pendant.",
			position = 11,
			section = teleportationSection
	)
	default boolean getDigsitePendant()
	{
		return false;
	}

	@ConfigItem(
			keyName = "digsitependantmode",
			name = "Mode",
			description = "",
			position = 12,
			section = teleportationSection
	)
	default DigsitePendantMode getDigsitePendantMode()
	{
		return DigsitePendantMode.FOSSIL_ISLAND;
	}

	@ConfigItem(
			keyName = "swapCombat",
			name = "Combat Bracelet",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Combat Bracelet.",
			position = 13,
			section = teleportationSection
	)
	default boolean getCombatBracelet()
	{
		return false;
	}

	@ConfigItem(
			keyName = "combatbraceletmode",
			name = "Mode",
			description = "",
			position = 14,
			section = teleportationSection
	)
	default CombatBraceletMode getCombatBraceletMode()
	{
		return CombatBraceletMode.WARRIORS_GUILD;
	}

	@ConfigItem(
			keyName = "swapburning",
			name = "Burning Amulet",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Burning Amulet.",
			position = 15,
			section = teleportationSection
	)
	default boolean getBurningAmulet()
	{
		return false;
	}

	@ConfigItem(
			keyName = "burningamuletmode",
			name = "Mode",
			description = "",
			position = 16,
			section = teleportationSection
	)
	default BurningAmuletMode getBurningAmuletMode()
	{
		return BurningAmuletMode.BANDIT_CAMP;
	}

	@ConfigItem(
			keyName = "swapxeric",
			name = "Xeric's Talisman",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Xeric's Talisman.",
			position = 17,
			section = teleportationSection
	)
	default boolean getXericsTalisman()
	{
		return false;
	}

	@ConfigItem(
			keyName = "xericstalismanmode",
			name = "Mode",
			description = "",
			position = 18,
			section = teleportationSection
	)
	default XericsTalismanMode getXericsTalismanMode()
	{
		return XericsTalismanMode.XERICS_LOOKOUT;
	}

	@ConfigItem(
			keyName = "swapwealth",
			name = "Ring of Wealth",
			description = "Swap the left click 'remove' option with the desired teleport location on a worn Ring of Wealth.",
			position = 19,
			section = teleportationSection
	)
	default boolean getRingofWealth()
	{
		return false;
	}

	@ConfigItem(
			keyName = "ringofwealthmode",
			name = "Mode",
			description = "",
			position = 20,
			section = teleportationSection
	)
	default RingOfWealthMode getRingofWealthMode()
	{
		return RingOfWealthMode.GRAND_EXCHANGE;
	}

	@ConfigItem(
			keyName = "swapConstructionCape",
			name = "Construction Cape",
			description = "Swap the left click option with 'Tele to POH' on a Construction Cape.",
			position = 21,
			section = teleportationSection
	)
	default ConstructionCapeMode getConstructionCapeMode()
	{
		return ConstructionCapeMode.OFF;
	}

	@ConfigItem(
			keyName = "swapCraftingCape",
			name = "Crafting Cape",
			description = "Swap the left click option with 'teleport' on a Crafting Cape.",
			position = 22,
			section = teleportationSection
	)
	default CraftingCapeMode getCraftingCapeMode()
	{
		return CraftingCapeMode.OFF;
	}

	@ConfigItem(
				keyName = "swapDiaryCape",
				name = "Diary Cape",
				description = "Swap the left click option with 'teleport' on a Diary Cape.",
				position = 23,
				section = teleportationSection
		)
	default DiaryCapeMode getDiaryCapeMode()
		{
			return DiaryCapeMode.OFF;
	}

	@ConfigItem(
			keyName = "swapFarmingCape",
			name = "Farming Cape",
			description = "Swap the left click option with 'teleport' on a Farming Cape.",
			position = 24,
			section = teleportationSection
	)
	default FarmCapeMode getFarmingCapeMode()
	{
		return FarmCapeMode.OFF;
	}

	@ConfigItem(
			keyName = "swapQuestCape",
			name = "Quest Cape",
			description = "Swap the left click option with 'teleport' on a Quest Cape.",
			position = 25,
			section = teleportationSection
	)
	default QuestCapeMode getQuestCapeMode() 
	{
		return QuestCapeMode.OFF;
	}

	@ConfigItem(
			keyName = "magicCapeMode",
			name = "Magic Cape",
			description = "Swap the left click option with 'spellbook' on a Magic Cape.",
			position = 26,
			section = teleportationSection
	)
	default MagicCapeMode getMagicCapeMode()
	{
		return MagicCapeMode.OFF;
	}

	@ConfigItem(
			keyName = "swapMaxCapeEquipped",
			name = "Max Cape",
			description = "Swap the left click 'remove' option with another on a worn Max Cape.",
			position = 27,
			section = teleportationSection
	)
	default MaxCapeEquippedMode getMaxCapeEquippedMode()
	{
		return MaxCapeEquippedMode.OFF;
	}

	//------------------------------------------------------------//
	// Right Click Options
	//------------------------------------------------------------//

	@ConfigItem(
			keyName = "hideTradeWith",
			name = "Hide 'Trade With'",
			description = "Hides the 'Trade with' option from the right click menu.",
			position = 0,
			section = rightClickOptionsSection
	)
	default boolean hideTradeWith()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideEmpty",
			name = "Hide 'Empty'",
			description = "Hides the 'Empty' option from the right click menu for potions.",
			position = 1,
			section = rightClickOptionsSection
	)
	default boolean hideEmpty()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideExamine",
			name = "Hide 'Examine'",
			description = "Hides the 'Examine' option from the right click menu.",
			position = 2,
			section = rightClickOptionsSection
	)
	default boolean hideExamine()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideDestroy",
			name = "Hide 'Destroy' Rune Pouch",
			description = "Hides the 'Destroy' option from rune pouch.",
			position = 3,
			section = rightClickOptionsSection
	)
	default boolean hideDestroy()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideLootImpJars",
			name = "Hide 'Loot' Impling Jars",
			description = "Hides the 'Loot' option from impling jars if you have the type of clue.",
			position = 4,
			section = rightClickOptionsSection
	)
	default boolean hideLootImpJars()
	{
		return false;
	}

	@ConfigItem(
			keyName = "shopBuy",
			name = "Shop Buy",
			description = "Swaps the Buy options with Value on items in shops.",
			position = 5,
			section = rightClickOptionsSection
	)
	default BuyMode shopBuy()
	{
		return BuyMode.OFF;
	}

	@ConfigItem(
			keyName = "shopSell",
			name = "Shop Sell",
			description = "Swaps the Sell options with Value on items in your inventory when selling to shops.",
			position = 6,
			section = rightClickOptionsSection
	)
	default SellMode shopSell()
	{
		return SellMode.OFF;
	}

	//------------------------------------------------------------//
	// PVM
	//------------------------------------------------------------//

	@ConfigItem(
			keyName = "hideAttack",
			name = "Hide Attack On Dead NPCs",
			description = "Hides the 'Attack' option on dead npcs.",
			position = 0,
			section = pvmSection
	)
	default boolean hideAttack()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hideAttackIgnoredNPCs",
			name = "Ignored NPCs",
			description = "NPCs that should not be hidden from being attacked, separated by a comma",
			position = 1,
			section = pvmSection
	)
	default String hideAttackIgnoredNPCs()
	{
		return "vet'ion";
	}

	@ConfigItem(
			keyName = "hideCastRaids",
			name = "Hide Cast On Players In Raids",
			description = "Hides the cast option for players while in raids.",
			position = 2,
			section = pvmSection
	)
	default boolean hideCastRaids()
	{
		return true;
	}

	@ConfigItem(
			keyName = "hideCastIgnoredSpells",
			name = "Ignored Spells",
			description = "Spells that should not be hidden from being cast, separated by a comma",
			position = 3,
			section = pvmSection
	)
	default String hideCastIgnoredSpells()
	{
		return "cure other, energy transfer, heal other, vengeance other";
	}

	@ConfigItem(
			keyName = "hideCastThralls",
			name = "Hide Cast On Thralls",
			description = "Hides the cast option on thralls.",
			position = 4,
			section = pvmSection
	)
	default boolean hideCastThralls()
	{
		return true;
	}

	@ConfigItem(
			keyName = "swapTobBuys",
			name = "Swap ToB Chest 'Buy-1'",
			description = "Swaps the 'Value' option with 'Buy-1' on items in the ToB chest.",
			position = 5,
			section = pvmSection
	)
	default boolean swapTobBuys()
	{
		return false;
	}

	//------------------------------------------------------------//
	// Custom swaps
	//------------------------------------------------------------//

	@ConfigItem(
			name = "Custom Swaps Toggle",
			keyName = "customSwapsToggle",
			description = "Toggles the use of the Custom Swaps",
			section = customSwapsSection,
			position = 3
	)
	default boolean customSwapsToggle()
	{
		return false;
	}

	@ConfigItem(
			name = "Custom Swaps",
			keyName = "customSwaps",
			description = "",
			section = customSwapsSection,
			position = 4
	)
	default String customSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Bank Swaps",
			keyName = "bankCustomSwapsStr",
			description = "",
			section = customSwapsSection,
			position = 5
	)
	default String bankCustomSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Shift Swaps Toggle",
			keyName = "shiftCustomSwapsToggle",
			description = "Toggles the use of the Shift Swaps",
			section = shiftCustomSwapsSection,
			position = 6
	)
	default boolean shiftCustomSwapsToggle()
	{
		return false;
	}

	@ConfigItem(
			name = "Shift Swaps",
			keyName = "shiftCustomSwapsStr",
			description = "",
			section = shiftCustomSwapsSection,
			position = 7
	)
	default String shiftCustomSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Shift Bank Swaps",
			keyName = "bankShiftCustomSwapsStr",
			description = "",
			section = shiftCustomSwapsSection,
			position = 8
	)
	default String bankShiftCustomSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Hotkey Swaps Toggle",
			keyName = "keyCustomSwapsToggle",
			description = "Toggles the use of the Hotkey Swaps",
			section = keyCustomSwapsSection,
			position = 1
	)
	default boolean keyCustomSwapsToggle()
	{
		return false;
	}

	@ConfigItem(
			keyName = "hotkey",
			name = "Set Hotkey",
			description = "Binds the key to hold to enable this section",
			section = keyCustomSwapsSection,
			position = 2
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			name = "Hotkey Swaps",
			keyName = "keyCustomSwapsStr",
			description = "",
			section = keyCustomSwapsSection,
			position = 3
	)
	default String keyCustomSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Hotkey Bank Swaps",
			keyName = "bankKeyCustomSwapsStr",
			description = "",
			section = keyCustomSwapsSection,
			position = 4
	)
	default String bankKeyCustomSwapsString()
	{
		return "";
	}

	@ConfigItem(
			name = "Remove Options Toggle",
			keyName = "removeOptionsToggle",
			description = "Toggles the use of the removing options",
			section = removeSwapsSection,
			position = 9
	)
	default boolean removeOptionsToggle()
	{
		return false;
	}

	@ConfigItem(
			name = "Remove Options",
			keyName = "removeOptionsStr",
			description = "",
			section = removeSwapsSection,
			position = 10
	)
	default String removeOptionsString()
	{
		return "";
	}
}
