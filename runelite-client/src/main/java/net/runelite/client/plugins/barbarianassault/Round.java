/*
 * Copyright (c) 2020, BegOsrs <https://github.com/begosrs>
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import net.runelite.client.chat.ChatMessageBuilder;

class Round
{
	static final int STARTING_WAVE = 1;
	static final int ENDING_WAVE = 10;

	private static final String[] SUMMARY_DESCRIPTIONS = {
		"Wrong attacks",
		"Runners passed",
		"Eggs",
		"Hp",
		"Wrong poison",
	};

	@Getter
	private final int startingWave;
	@Getter
	private final Timer timer;
	@Getter
	private final List<Wave> waves;

	// sum of all 4 role points
	private final int[] rolesPoints;

	// sum of amounts and points for each of the events happening during the game:
	// wrong attacks, runners passed, eggs collected, hp healed, wrong poisons used
	private final int[] summaryAmounts;
	private final int[] summaryPoints;

	Round(int startingWave, Timer timer)
	{
		this.startingWave = startingWave;
		this.timer = timer;
		this.waves = new ArrayList<>();
		this.rolesPoints = new int[4];
		this.summaryPoints = new int[5];
		this.summaryAmounts = new int[5];
	}

	void addWave(Wave wave)
	{
		int[] waveRolesPoints = wave.getRolesPoints();
		for (int i = 0; i < rolesPoints.length; i++)
		{
			rolesPoints[i] += waveRolesPoints[i];
		}
		int[] waveAmounts = wave.getAmounts();
		for (int i = 0; i < summaryAmounts.length; i++)
		{
			summaryAmounts[i] += waveAmounts[i];
		}
		int[] wavePoints = wave.getPoints();
		for (int i = 0; i < summaryPoints.length; i++)
		{
			summaryPoints[i] += wavePoints[i];
		}
		waves.add(wave);
	}

	void endRound()
	{
		for (int i = 0; i < rolesPoints.length; i++)
		{
			rolesPoints[i] += 80;
		}
	}

	int getNumberOfWaves()
	{
		return waves.size();
	}

	boolean isComplete()
	{
		return startingWave - 1 + getNumberOfWaves() == Round.ENDING_WAVE;
	}

	ChatMessageBuilder getRoundPoints(boolean colorful)
	{
		ChatMessageBuilder message = new ChatMessageBuilder();
		for (int i = 0; i < Role.values().length; i++)
		{

			if (i != 0)
			{
				message.append(" | ");
			}

			Role role = Role.values()[i];
			String roleName = role.getName();
			Color roleColor = role.getColor();
			String points = String.valueOf(Math.max(0, rolesPoints[i]));
			message.append(roleName + ": ");
			if (colorful)
			{
				message.append(roleColor, points);
			}
			else
			{
				message.append(points);
			}
		}
		return message;
	}

	ChatMessageBuilder getRoundSummary(boolean colorful)
	{
		ChatMessageBuilder message = new ChatMessageBuilder();
		for (int i = 0; i < SUMMARY_DESCRIPTIONS.length; i++)
		{
			if (i != 0)
			{
				message.append(" | ");
			}
			message.append(SUMMARY_DESCRIPTIONS[i]).append(": ").append(String.valueOf(summaryAmounts[i]));
			int pointsCount = summaryPoints[i];
			if (pointsCount != 0)
			{
				message.append(" (");
				if (colorful)
				{
					Color color = pointsCount < 0 ? Color.RED : BarbarianAssaultPlugin.DARK_GREEN;
					message.append(color, (pointsCount > 0 ? "+" : "") + pointsCount);
				}
				else
				{
					message.append((pointsCount > 0 ? "+" : "") + pointsCount);
				}
				message.append(")");
			}
		}
		return message;
	}

}
