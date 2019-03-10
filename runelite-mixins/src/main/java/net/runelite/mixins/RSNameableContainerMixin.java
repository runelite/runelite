/*
 * Copyright (c) 2018, trimbe <github.com/trimbe>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSNameable;
import net.runelite.rs.api.RSNameableContainer;

@Mixin(RSNameableContainer.class)
public abstract class RSNameableContainerMixin implements RSNameableContainer
{
	/**
	 * Default implementation of rl$add
	 * @param name
	 * @param prevName
	 */
	@Inject
	@Override
	public void rl$add(RSName name, RSName prevName)
	{
	}

	/**
	 * Default implementation of rl$del
	 * @param nameable
	 */
	@Inject
	@Override
	public void rl$remove(RSNameable nameable)
	{
	}

	@Inject
	@MethodHook(value = "add", end = true)
	public void add(RSName name, RSName prevName)
	{
		rl$add(name, prevName);
	}

	@Inject
	@MethodHook("remove")
	public void remove(RSNameable nameable)
	{
		rl$remove(nameable);
	}
}
