/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
import java.util.ArrayList;
import java.util.List;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.plugins.performancetracker.data.ActivityInfo;
import net.runelite.client.plugins.performancetracker.data.stats.CastleWars;
import net.runelite.client.plugins.performancetracker.data.stats.Performance;
import net.runelite.client.plugins.performancetracker.data.stats.TheatreOfBlood;

public class PerformanceTrackerMessages
{
	private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###");

	private static String getCwTeamName(int team)
	{
		switch (team)
		{
			case ActivityInfo.CW.TEAM.SARA:
				return "Saradomin";
			case ActivityInfo.CW.TEAM.ZAM:
				return "Zamorak";
			default:
				return "";
		}
	}

	// Generic message for all rooms
	public static String genericMessage(Performance a)
	{
		// EX: Damage Taken: *, Damage Dealt: *
		return new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Damage dealt: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getDamageDealt()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getHighestHitDealt()))
			.append(ChatColorType.NORMAL)
			.append("), Damage Taken: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getDamageTaken()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(a.getHighestHitTaken()))
			.append(ChatColorType.NORMAL)
			.append(")")
			.build();
	}

	public static String prefixGenericMessage(String message, boolean highlight, Performance a)
	{
		// EX: *Damage Taken: *, Damage Dealt: *
		return new ChatMessageBuilder()
			.append(highlight ? ChatColorType.HIGHLIGHT : ChatColorType.NORMAL)
			.append(message)
			.append(ChatColorType.NORMAL)
			.append(genericMessage(a))
			.build();
	}

	private static String deathCountMessage(String prefix, boolean highlight, Performance a)
	{
		return deathCountMessage(prefix, highlight, a, a.getDeathCount());
	}

	private static String deathCountMessage(String prefix, boolean highlight, Performance a, int deathCount)
	{
		return new ChatMessageBuilder()
			.append(prefixGenericMessage(prefix, highlight, a))
			.append(ChatColorType.NORMAL)
			.append(", Death Count: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(deathCount))
			.build();
	}

	/** Theatre of Blood **/
	public static String tobRoomMessage(Performance current)
	{
		TheatreOfBlood a = (TheatreOfBlood) current;
		return prefixGenericMessage("Room Stats: ", true, a.getRoom());
	}

	public static String tobCurrentMessage(Performance current)
	{
		return deathCountMessage("Current Raid Stats: ", true, current);
	}

	public static List<String> tobTotalMessage(List<Performance> attempts)
	{
		List<String> messages = new ArrayList<>();
		int completions = 0, deathCount = 0;
		double damageTaken = 0, damageDealt = 0;
		for (Performance attempt : attempts)
		{
			if (!(attempt instanceof TheatreOfBlood))
			{
				continue;
			}

			TheatreOfBlood a = (TheatreOfBlood) attempt;
			if (a.isCompleted())
			{
				completions++;
			}
			deathCount += a.getDeathCount();
			damageTaken += a.getDamageTaken();
			damageDealt += a.getDamageDealt();
		}

		// EX: Session Raid Stats: Attempted: *, Completed: *, (*%)
		messages.add(new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Session Raid Stats: ")
			.append(ChatColorType.NORMAL)
			.append("Attempted: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.valueOf(attempts.size()))
			.append(ChatColorType.NORMAL)
			.append(", Completed: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.valueOf(completions))
			.append(", (")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format((completions * 100) / attempts.size()))
			.append("%)")
			.build());

		// Session Raid Stats with death message
		Performance p = new Performance();
		p.addDamageDealt(damageDealt);
		p.addDamageTaken(damageTaken);
		messages.add(deathCountMessage("Session Raid Stats: ", true, p, deathCount));

		return messages;
	}

	/** Castle Wars **/
	public static List<String> castleWarsMessage(CastleWars game)
	{
		List<String> messages = new ArrayList<>();

		int team = game.getTeam();
		int scoreDiff;
		switch (team)
		{
			case ActivityInfo.CW.TEAM.SARA:
				scoreDiff = game.getSaraScore() - game.getZamScore();
				break;
			case ActivityInfo.CW.TEAM.ZAM:
				scoreDiff = game.getSaraScore() - game.getZamScore();
				break;
			default:
				return messages;
		}

		messages.add(new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Castle Wars - Team: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(getCwTeamName(team))
			.append(ChatColorType.NORMAL)
			.append(" - ")
			.append(ChatColorType.HIGHLIGHT)
			.append(scoreDiff == 0 ? "TIE" : scoreDiff > 0 ? "VICTORY" : "DEFEAT")
			.build());

		messages.add(new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Final Score: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(getCwTeamName(ActivityInfo.CW.TEAM.SARA) + ": " + game.getSaraScore())
			.append(ChatColorType.NORMAL)
			.append(" - ")
			.append(ChatColorType.HIGHLIGHT)
			.append(getCwTeamName(ActivityInfo.CW.TEAM.ZAM) + ": " + game.getZamScore())
			.build());

		messages.add(new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Damage dealt: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(game.getDamageDealt()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(game.getHighestHitDealt()))
			.append(ChatColorType.NORMAL)
			.append("), Damage Taken: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(game.getDamageTaken()))
			.append(ChatColorType.NORMAL)
			.append(" (Max: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(game.getHighestHitTaken()))
			.append(ChatColorType.NORMAL)
			.append("), Death Count: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(NUMBER_FORMAT.format(game.getDeathCount()))
			.build());

		return messages;
	}
}
