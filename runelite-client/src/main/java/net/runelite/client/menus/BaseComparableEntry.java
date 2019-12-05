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

import javax.annotation.Nonnull;
import joptsimple.internal.Strings;
import lombok.EqualsAndHashCode;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
public class BaseComparableEntry extends AbstractComparableEntry
{
	/**
	 * If two entries are both suppose to be left click,
	 * the entry with the higher priority will be selected.
	 * This only effects left click priority entries.
	 */

	public BaseComparableEntry(String option, String target, int id, int type, boolean strictOption, boolean strictTarget)
	{
		super.option = option.trim().toLowerCase();
		super.target = Text.standardize(target);
		super.id = id;
		super.type = type;
		super.strictOption = strictOption;
		super.strictTarget = strictTarget;
	}

	public boolean matches(@Nonnull MenuEntry entry)
	{
		String opt = entry.getOption();

		if (strictOption && !StringUtils.equalsIgnoreCase(opt, option) || !strictOption && !StringUtils.containsIgnoreCase(opt, option))
		{
			return false;
		}

		if (strictTarget || !Strings.isNullOrEmpty(target))
		{
			String tgt = Text.standardize(entry.getTarget(), true);

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
			int type = entry.getOpcode();

			return this.type == type;
		}

		return true;
	}
}
