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

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSKeyFocusListener;

@Mixin(RSKeyFocusListener.class)
public abstract class RSKeyFocusListenerMixin implements RSKeyFocusListener
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Copy("keyPressed")
	abstract void rs$keyPressed(KeyEvent keyEvent);

	@Copy("keyReleased")
	abstract void rs$keyReleased(KeyEvent keyEvent);

	@Copy("keyTyped")
	abstract void rs$keyTyped(KeyEvent keyEvent);

	@Override
	@Replace("keyPressed")
	public final synchronized void keyPressed(KeyEvent keyEvent)
	{
		client.getCallbacks().keyPressed(keyEvent);
		if (!keyEvent.isConsumed())
		{
			rs$keyPressed(keyEvent);
		}
	}

	@Override
	@Replace("keyReleased")
	public final synchronized void keyReleased(KeyEvent keyEvent)
	{
		client.getCallbacks().keyReleased(keyEvent);
		if (!keyEvent.isConsumed())
		{
			rs$keyReleased(keyEvent);
		}
	}

	@Override
	@Replace("keyTyped")
	public final void keyTyped(KeyEvent keyEvent)
	{
		client.getCallbacks().keyTyped(keyEvent);
		if (!keyEvent.isConsumed())
		{
			rs$keyTyped(keyEvent);
		}
	}

	@Inject
	@MethodHook("focusLost")
	public void onFocusLost(FocusEvent focusEvent)
	{
		final FocusChanged focusChanged = new FocusChanged();
		focusChanged.setFocused(false);
		client.getCallbacks().post(focusChanged);
	}
}