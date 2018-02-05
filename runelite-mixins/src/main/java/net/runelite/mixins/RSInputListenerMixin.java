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

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSKeyFocusListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

@Mixin(RSKeyFocusListener.class)
public abstract class RSInputListenerMixin implements RSKeyFocusListener
{
	@Inject
	public ArrayList<KeyAdapter> onKeyEvents;

	@Inject
	@Override
	public void addOnKeyEvent(KeyAdapter event)
	{
		if (onKeyEvents == null)
		{
			onKeyEvents = new ArrayList<KeyAdapter>();
		}
		this.onKeyEvents.add(event);
	}

	@Inject
	@Override
	public void removeOnKeyEvent(KeyAdapter event)
	{
		if (onKeyEvents == null)
		{
			onKeyEvents = new ArrayList<KeyAdapter>();
		}
		this.onKeyEvents.remove(event);
	}

	@Copy("keyPressed")
	abstract void rs$keyPressed(KeyEvent e);

	@Replace("keyPressed")
	public void rl$keyPressed(KeyEvent e)
	{
		System.out.println("Pressed " + e.getKeyCode() + " " + e.getKeyChar() + " " + e.toString() + " " + onKeyEvents);
		for (KeyAdapter event : onKeyEvents)
		{
			event.keyPressed(e);
		}
		if (false) //insert flag here to skip client input
		{
			return;
		}
		rs$keyPressed(e);
		System.out.println("Pressed Passed");
	}

	@Copy("keyTyped")
	abstract void rs$keyTyped(KeyEvent e);

	@Replace("keyTyped")
	public void rl$keyTyped(KeyEvent e)
	{
		System.out.println("Typed " + e.getKeyCode() + " " + e.getKeyChar() + " " + e.toString());
		for (KeyAdapter event : onKeyEvents)
		{
			event.keyTyped(e);
		}
		if (false) //insert flag here to skip client input
		{
			return;
		}
		rs$keyTyped(e);
		System.out.println("Typed Passed");
	}

	@Copy("keyReleased")
	abstract void rs$keyReleased(KeyEvent e);

	@Replace("keyReleased")
	public void rl$keyReleased(KeyEvent e)
	{
		System.out.println("Released " + e.getKeyCode() + " " + e.getKeyChar() + " " + e.toString());
		for (KeyAdapter event : onKeyEvents)
		{
			event.keyReleased(e);
		}
		if (false) //insert flag here to skip client input
		{
			return;
		}
		rs$keyReleased(e);
		System.out.println("Released Passed");
	}
}
