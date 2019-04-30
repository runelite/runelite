package net.runelite.client.plugins.spellbook;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spellbook")
public interface SpellbookConfig extends Config
{
	@ConfigItem(
		keyName = "enableMobile",
		name = "Mobile spellbook",
		description = "Show the mobile spellbook with filtered spells enabled",
		position = 1
	)
	default boolean enableMobile()
	{
		return true;
	}

	@ConfigItem(
		keyName = "dragSpells",
		name = "Change spell location",
		description = "Add menu entry to spellbook which toggles moving spells by dragging. Only works with spells filtered",
		position = 2
	)
	default boolean dragSpells()
	{
		return true;
	}

	@ConfigItem(
		keyName = "size",
		name = "Spell size",
		description = "Size (in px) of spells. Normal mobile size is 40px, use common sense for this setting please",
		position = 3
	)
	default int size()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "filter",
		name = "Unfiltered spells",
		description = "Spells you don't want to filter, seperated with a comma"
	)
	default String filter()
	{
		return "";
	}

	@ConfigItem(
		keyName = "standard",
		name = "",
		description = "",
		hidden = true
	)
	default String standard()
	{
		return "";
	}


	@ConfigItem(
		keyName = "ancient",
		name = "",
		description = "",
		hidden = true
	)
	default String ancient()
	{
		return "";
	}

	@ConfigItem(
		keyName = "lunar",
		name = "",
		description = "",
		hidden = true
	)
	default String lunar()
	{
		return "";
	}

	@ConfigItem(
		keyName = "arceuus",
		name = "",
		description = "",
		hidden = true
	)
	default String arceuus()
	{
		return "";
	}

	@ConfigItem(
		keyName = "canDrag",
		name = "",
		description = "",
		hidden = true
	)
	default boolean canDrag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "canDrag",
		name = "",
		description = "",
		hidden = true
	)
	void canDrag(boolean canDrag);
}
