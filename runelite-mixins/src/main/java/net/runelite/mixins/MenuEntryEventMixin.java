/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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

import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClient;


@Mixin(RSClient.class)
public abstract class MenuEntryEventMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private static int oldMenuEntryCount;

	@FieldHook("menuOptionCount")
	@Inject
	public static void onMenuOptionsChanged(int idx)
	{
		int newCount = client.getMenuOptionCount();

		if (newCount == oldMenuEntryCount + 1)
		{
			MenuEntryAdded event = new MenuEntryAdded(
					client.getMenuOptions()[newCount - 1],
					client.getMenuTargets()[newCount - 1],
					client.getMenuTypes()[newCount - 1],
					client.getMenuIdentifiers()[newCount - 1],
					client.getMenuActionParams0()[newCount - 1],
					client.getMenuActionParams1()[newCount - 1]
			);

			eventBus.post(event);
		}

		oldMenuEntryCount = newCount;
	}
}
