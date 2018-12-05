/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import net.runelite.api.HeadIcon;
import static net.runelite.api.HeadIcon.MAGIC;
import static net.runelite.api.HeadIcon.MELEE;
import static net.runelite.api.HeadIcon.RANGED;
import static net.runelite.api.HeadIcon.RANGE_MAGE;
import net.runelite.api.events.NpcActionChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSNPCComposition;

@Mixin(RSNPCComposition.class)
public abstract class RSNpcCompositionMixin implements RSNPCComposition
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public HeadIcon getOverheadIcon()
	{
		switch (getRsOverheadIcon())
		{
			case 0:
				return MELEE;
			case 1:
				return RANGED;
			case 2:
				return MAGIC;
			case 6:
				return RANGE_MAGE;
			default:
				return null;
		}
	}

	@FieldHook("actions")
	@Inject
	public void actionsHook(int idx)
	{
		NpcActionChanged npcActionChanged = new NpcActionChanged();
		npcActionChanged.setNpcComposition(this);
		npcActionChanged.setIdx(idx);
		client.getCallbacks().post(npcActionChanged);
	}
}
