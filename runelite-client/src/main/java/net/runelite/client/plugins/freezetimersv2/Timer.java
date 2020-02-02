/*
 * Copyright (c) 2020 ThatGamerBlue
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
package net.runelite.client.plugins.freezetimersv2;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import net.runelite.api.Client;
import java.awt.Color;
import java.awt.image.BufferedImage;

@ToString
@EqualsAndHashCode
public class Timer
{
	private FreezeTimersV2Plugin plugin;
	private Client client;
	@Setter
	private int ticksStart;
	@Setter
	private long startMillis;
	@Setter
	private int ticksLength;
	private int cooldownLength;
	private TimerType type;
	private boolean shutdown = false;

	public Timer(FreezeTimersV2Plugin plugin, PlayerSpellEffect effect)
	{
		this(plugin, effect, false);
	}

	public Timer(FreezeTimersV2Plugin plugin, PlayerSpellEffect effect, boolean half)
	{
		this.plugin = plugin;
		this.client = plugin.getClient();
		this.ticksStart = client.getTickCount();
		this.startMillis = System.currentTimeMillis();
		this.ticksLength = effect == null ? 0 : half ? effect.getTimerLengthTicks() / 2 : effect.getTimerLengthTicks();
		this.cooldownLength = effect == null ? 0 : effect.getType().getImmunityLength();
		this.type = effect == null ? null : effect.getType();
	}

	public boolean isValid()
	{
		return type != null;
	}

	public int getTicksElapsed()
	{
		return client.getTickCount() - ticksStart;
	}

	public TimerState getTimerState()
	{
		int ticksElapsed = getTicksElapsed();
		if (ticksElapsed > ticksLength + cooldownLength)
		{
			return TimerState.INACTIVE;
		}
		else if (ticksElapsed > ticksLength)
		{
			return TimerState.COOLDOWN;
		}
		return TimerState.ACTIVE;
	}

	public void setTimerTypeIfNull(TimerType set)
	{
		if (type == null)
		{
			type = set;
		}
	}

	public long getMillisForRender()
	{
		long millisElapsed = System.currentTimeMillis() - startMillis;
		long millisRemaining = ((ticksLength * 600) + (cooldownLength * 600)) - millisElapsed;
		switch (getTimerState())
		{
			case ACTIVE:
				return millisRemaining - (cooldownLength * 600);
			case COOLDOWN:
				return millisRemaining;
			default:
				return -1;
		}
	}

	public int getTicksForRender()
	{
		int ticksRemaining = (ticksLength + cooldownLength) - getTicksElapsed();
		ticksRemaining++; // so it renders nicely
		switch (getTimerState())
		{
			case ACTIVE:
				return ticksRemaining - cooldownLength;
			case COOLDOWN:
				return ticksRemaining;
			default:
				return -1;
		}
	}

	public BufferedImage getIcon()
	{
		return getTimerState() == TimerState.COOLDOWN ? type.getCooldownIcon() : type.getIcon();
	}

	public Color determineColor()
	{
		if (plugin.getConfig().showIcons())
		{
			return getTimerState() == TimerState.COOLDOWN ? plugin.getConfig().cooldownColor() : plugin.getConfig().timerColor();
		}
		else
		{
			return getTimerState() == TimerState.COOLDOWN ? type.getDefaultColor().darker() : type.getDefaultColor();
		}
	}

	public enum TimerState
	{
		ACTIVE,
		COOLDOWN,
		INACTIVE
	}

}
