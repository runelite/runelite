/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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

import net.runelite.api.Client;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.widgets.Widget;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSScript;

import java.util.ArrayList;
import java.util.List;

@Mixin(RSClient.class)
public abstract class ScriptWidgetMixin implements RSClient
{
	@Shadow("clientInstance")
	private static Client client;

	@Inject
	private List<Integer> forceHiddenWidgetIds;

	@Inject
	@Override
	public List<Integer> getForceHiddenWidgetIds()
	{
		if (forceHiddenWidgetIds == null)
		{
			forceHiddenWidgetIds = new ArrayList<Integer>();
		}

		return forceHiddenWidgetIds;
	}

	@Copy("scriptWidgetInstructions")
	private static int rs$scriptWidgetInstructions(int instruction, RSScript script, boolean var2)
	{
		throw new RuntimeException();
	}

	@Replace("scriptWidgetInstructions")
	public static int rl$scriptWidgetInstructions(int instruction, RSScript script, boolean var2)
	{
		boolean matched = false;
		int id = -1;

		if (instruction == 2003)
		{
			int[] intStack = client.getIntStack();
			id = intStack[client.getIntStackSize() - 1];
		}

		int res = rs$scriptWidgetInstructions(instruction, script, var2);

		List<Integer> forceHiddenIds = client.getForceHiddenWidgetIds();

		for (Integer hiddenId : forceHiddenIds)
		{
			if (hiddenId == id)
			{
				Widget toHide = client.getWidget(id >> 16, id & 0xFFFF);

				if (toHide != null)
					toHide.setHidden(true);

				break;
			}
		}

		return res;
	}
}
