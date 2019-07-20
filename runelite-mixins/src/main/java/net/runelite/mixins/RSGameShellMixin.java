/*
 * Copyright (c) 2018 Abex
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

import net.runelite.api.events.FocusChanged;
import net.runelite.api.hooks.DrawCallbacks;
import java.awt.event.FocusEvent;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameShell;

@Mixin(RSGameShell.class)
public abstract class RSGameShellMixin implements RSGameShell
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private Thread thread;

	@Inject
	@Override
	public Thread getClientThread()
	{
		return thread;
	}

	@Inject
	@Override
	public boolean isClientThread()
	{
		return thread == Thread.currentThread();
	}

	@Inject
	@MethodHook("run")
	public void onRun()
	{
		thread = Thread.currentThread();
		thread.setName("Client");
	}

	@Inject
	@MethodHook("focusGained")
	public void onFocusGained(FocusEvent focusEvent)
	{
		final FocusChanged focusChanged = new FocusChanged();
		focusChanged.setFocused(true);
		client.getCallbacks().post(FocusChanged.class, focusChanged);
	}

	@Inject
	@MethodHook("post")
	public void onPost(Object canvas)
	{
		DrawCallbacks drawCallbacks = client.getDrawCallbacks();
		if (drawCallbacks != null)
		{
			drawCallbacks.draw();
		}
	}

	@FieldHook("isCanvasInvalid")
	@Inject
	public void onReplaceCanvasNextFrameChanged(int idx)
	{
		// when this is initially called the client instance doesn't exist yet
		if (client != null && client.isGpu() && isReplaceCanvasNextFrame())
		{
			setReplaceCanvasNextFrame(false);
			setResizeCanvasNextFrame(true);
		}
	}

	@Replace("checkHost")
	protected final boolean checkHost()
	{
		//Always allow host.
		return true;
	}
}
