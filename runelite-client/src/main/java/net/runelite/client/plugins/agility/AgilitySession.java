/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.agility;

import com.google.common.collect.EvictingQueue;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import java.time.Duration;
import java.time.Instant;

@Getter
@Setter
class AgilitySession
{
	private final Courses course;
	private Instant lastLapCompleted;
	private int totalLaps;
	private int lapsTillGoal;
	private final EvictingQueue<Duration> lastLapTimes = EvictingQueue.create(30);
	private int lapsPerHour;

	AgilitySession(Courses course)
	{
		this.course = course;
	}

	void incrementLapCount(Client client, XpTrackerService xpTrackerService)
	{
		calculateLapsPerHour();

		++totalLaps;

		final int currentExp = client.getSkillExperience(Skill.AGILITY);
		final int goalXp = xpTrackerService.getEndGoalXp(Skill.AGILITY);
		final int goalRemainingXp = goalXp - currentExp;
		double courseTotalExp = course.getTotalXp();
		if (course == Courses.PYRAMID)
		{
			// agility pyramid has a bonus exp drop on the last obstacle that scales with player level and caps at 1000
			// the bonus is not already accounted for in the total exp number in the courses enum
			courseTotalExp += Math.min(300 + 8 * client.getRealSkillLevel(Skill.AGILITY), 1000);
		}

		lapsTillGoal = goalRemainingXp > 0 ? (int) Math.ceil(goalRemainingXp / courseTotalExp) : 0;
	}

	void calculateLapsPerHour()
	{
		Instant now = Instant.now();

		if (lastLapCompleted != null)
		{
			Duration timeSinceLastLap = Duration.between(lastLapCompleted, now);

			if (!timeSinceLastLap.isNegative())
			{
				lastLapTimes.add(timeSinceLastLap);

				Duration sum = Duration.ZERO;
				for (Duration lapTime : lastLapTimes)
				{
					sum = sum.plus(lapTime);
				}

				Duration averageLapTime = sum.dividedBy(lastLapTimes.size());
				lapsPerHour = (int) (Duration.ofHours(1).toMillis() / averageLapTime.toMillis());
			}
		}

		lastLapCompleted = now;
	}
}
