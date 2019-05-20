package net.runelite.client.menus;

import joptsimple.internal.Strings;
import lombok.Getter;
import net.runelite.api.MenuEntry;
import static net.runelite.client.menus.MenuManager.LEVEL_PATTERN;
import net.runelite.client.util.Text;

class AbstractMenuEntry
{
	@Getter
	private String option;

	@Getter
	private String target;

	@Getter
	private int id;

	@Getter
	private int type;

	@Getter
	private boolean strictOption;

	@Getter
	private boolean strictTarget;

	AbstractMenuEntry(String option, String target)
	{
		this(option, target, -1, -1, true, true);
	}

	AbstractMenuEntry(String option, String target, boolean strictTarget)
	{
		this(option, target, -1, -1, true, strictTarget);
	}

	AbstractMenuEntry(String option, String target, int id, int type, boolean strictOption, boolean strictTarget)
	{
		this.option = option;
		this.target = target;
		this.id = id;
		this.type = type;
		this.strictOption = strictOption;
		this.strictTarget = strictTarget;
	}

	boolean matches(MenuEntry entry)
	{
		String opt = Text.standardize(entry.getOption());

		if (strictOption && !opt.equals(option) || !strictOption && !opt.contains(option))
		{
			return false;
		}

		if (strictTarget || !Strings.isNullOrEmpty(target))
		{
			String tgt = Text.standardize(LEVEL_PATTERN.matcher(entry.getTarget()).replaceAll(""));

			if (strictTarget && !tgt.equals(target) || !strictTarget && !tgt.contains(target))
			{
				return false;
			}
		}

		if (id != -1)
		{
			int id = entry.getIdentifier();

			if (this.id != id)
			{
				return false;
			}
		}

		if (type != -1)
		{
			int type = entry.getType();

			if (this.type != type)
			{
				return false;
			}
		}

		return true;
	}

	boolean equals(AbstractMenuEntry other)
	{
		return target.equals(other.getTarget())
			&& option.equals(other.getOption())
			&& id == other.getId()
			&& type == other.getType()
			&& strictOption == other.isStrictOption()
			&& strictTarget == other.isStrictTarget();
	}
}
