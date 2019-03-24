/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancetracker;

import java.text.DecimalFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.http.api.ws.messages.party.PartyMemberMessage;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Performance extends PartyMemberMessage
{
	double damageDealt = 0;
	double highestHitDealt = 0;
	double damageTaken = 0;
	double highestHitTaken = 0;
	@Setter
	int lastActivityTick = -1;
	@Setter
	double ticksSpent = 0;

	void addDamageTaken(double a)
	{
		damageTaken += a;
		if (a > highestHitTaken)
		{
			highestHitTaken = a;
		}

	}

	void addDamageDealt(double a)
	{
		damageDealt += a;
		if (a > highestHitDealt)
		{
			highestHitDealt = a;
		}
	}

	void incrementTicksSpent()
	{
		ticksSpent++;
	}

	void reset()
	{
		damageDealt = 0;
		highestHitDealt = 0;
		damageTaken = 0;
		highestHitTaken = 0;
		lastActivityTick = -1;
		ticksSpent = 0;
	}

	/**
	 * Converts the ticks spent to seconds
	 */
	public double getSecondsSpent()
	{
		// Each tick is .6 seconds
		final double tickLength = 0.6;

		return Math.round(getTicksSpent() * tickLength);
	}

	/**
	 * Calculates damage per second to the hundredth decimal place
	 */
	public double getDPS()
	{
		return Math.round((getDamageDealt() / getSecondsSpent()) * 100) / 100.00;
	}

	/**
	 * Converts seconds spent to a more human readable format
	 */
	public String getReadableSecondsSpent()
	{
		final double secondsSpent = getSecondsSpent();
		if (secondsSpent <= 60)
		{
			return String.format("%2.0f", secondsSpent) + "s";
		}

		final double s = secondsSpent % 3600 % 60;
		final double m = Math.floor(secondsSpent % 3600 / 60);
		final double h = Math.floor(secondsSpent / 3600);

		return h < 1 ? String.format("%2.0f:%02.0f", m, s) : String.format("%2.0f:%02.0f:%02.0f", h, m, s);
	}

	/**
	 * Creates the chat message for the performance
	 */
	public String createChatMessage()
	{
		final DecimalFormat numberFormat = new DecimalFormat("#,###");

		// Expected result: Damage Dealt: ## (Max: ##), Damage Taken: ## (Max: ##), Time Spent: ##:## (DPS: ##.##)
		return new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Damage dealt: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(damageDealt))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(highestHitDealt))
			.append(ChatColorType.NORMAL)
			.append("), Damage Taken: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(damageTaken))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(numberFormat.format(highestHitTaken))
			.append(ChatColorType.NORMAL)
			.append("), Time Spent: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(getReadableSecondsSpent())
			.append(ChatColorType.NORMAL)
			.append(" (DPS: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.valueOf(getDPS()))
			.append(ChatColorType.NORMAL)
			.append(")")
			.build();
	}

	/**
	 * Returns the text to display inside overlays
	 */
	public String getOverlayText()
	{
		return "Dealt: " + ((int) damageDealt) + " | Taken: " + ((int) damageTaken);
	}
}
