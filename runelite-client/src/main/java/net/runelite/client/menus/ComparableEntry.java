/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.menus;

import joptsimple.internal.Strings;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.MenuEntry;
import static net.runelite.client.menus.MenuManager.LEVEL_PATTERN;
import net.runelite.client.util.Text;

@EqualsAndHashCode
public class ComparableEntry
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

	/**
	 * If two entries are both suppose to be left click,
	 * the entry with the higher priority will be selected.
	 * This only effects left click priority entries.
	 */
	@Getter
	@Setter
	@EqualsAndHashCode.Exclude
	private int priority;

	public ComparableEntry(String option, String target)
	{
		this(option, target, -1, -1, true, true);
	}

	public ComparableEntry(String option, String target, boolean strictTarget)
	{
		this(option, target, -1, -1, true, strictTarget);
	}

	public ComparableEntry(String option, String target, int id, int type, boolean strictOption, boolean strictTarget)
	{
		this.option = Text.standardize(option);
		this.target = Text.standardize(target);
		this.id = id;
		this.type = type;
		this.strictOption = strictOption;
		this.strictTarget = strictTarget;
		this.priority = 0;
	}

	// This is only used for type checking, which is why it has everything but target
	// target sometimes changes to option.
	public ComparableEntry(MenuEntry e)
	{
		this.option = Text.standardize(e.getOption());
		this.id = e.getIdentifier();
		this.type = e.getType();
		this.strictOption = true;
		this.priority = 0;
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
}
