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
}
