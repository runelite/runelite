/*
 * Copyright (c) 2018. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

import net.runelite.api.RLMouseAdapter;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSMouseWheelHandler;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

@Mixin(RSMouseWheelHandler.class)
public abstract class RSMouseWheelHandlerMixin implements RSMouseWheelHandler
{
	@Inject
	private ArrayList<RLMouseAdapter> onMouseWheelMovedEvents;

	@Override
	@Inject
	public ArrayList<RLMouseAdapter> getOnMouseWheelMovedEvents()
	{
		if (onMouseWheelMovedEvents == null)
		{
			onMouseWheelMovedEvents = new ArrayList<RLMouseAdapter>();
		}
		return onMouseWheelMovedEvents;
	}

//	@Copy("mouseWheelMoved")
//	abstract void rs$mouseWheelMoved(MouseWheelEvent var1);
//
//	@Replace("mouseWheelMoved")
//	public void rl$mouseWheelMoved(MouseWheelEvent var1)
//	{
//		boolean skip = false;
//		for (RLMouseAdapter event : onMouseWheelMovedEvents)
//		{
//			event.mouseWheelMoved(var1);
//			if (event.isMouseWheelMovedConsumed())
//			{
//				skip = true;
//			}
//			event.setMouseWheelMovedConsumed(false);
//		}
//		if (skip)
//		{
//			return;
//		}
//		rs$mouseWheelMoved(var1);
//	}
}
