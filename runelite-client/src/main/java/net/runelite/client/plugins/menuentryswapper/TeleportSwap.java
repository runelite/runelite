/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.menuentryswapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class TeleportSwap
{
	boolean worn;
	boolean held;
	String option;
	List<TeleportSub> subs = new ArrayList<>();

	Set<TeleportSub> shorthands = new TreeSet<>();

	TeleportSwap addSub(String option, Runnable r)
	{
		var sub = new TeleportSub();
		sub.option = option;
		sub.execute = r;
		subs.add(sub);
		return this;
	}

	void clearShorthands()
	{
		shorthands.clear();
	}

	TeleportSwap addOption(String option, Runnable r)
	{
		var sub = new TeleportSub();
		sub.option = option;
		sub.execute = r;
		shorthands.add(sub);
		return this;
	}

	TeleportSwap worn()
	{
		worn = true;
		return this;
	}

	TeleportSwap held()
	{
		held = true;
		return this;
	}
}

class TeleportSub implements Comparable<TeleportSub>
{
	String option;
	Runnable execute;

	@Override
	public int compareTo(TeleportSub other)
	{
		return option.compareTo(other.option);
	}
}
