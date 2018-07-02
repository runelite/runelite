/*
 * Copyright (c) 2018, Grant <grant.dellar@live.com>
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
package net.runelite.client.plugins.nightmarezone;

import java.sql.Timestamp;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Varbits;

/**
 * Represents a model of the current Nightmare Zone dream points, points per hour, elapsed time/
 * elapsed formatted time.
 */
public class NightmareZoneInfoModel
{
	private final NightmareZoneConfig config;
	private final Client client;

	/**
	 * A Timestamp signifying the start time a Nightmare Zone Dream
	 */
	private Timestamp dreamStartTime;

	/**
	 * Seconds that has elapsed since entering a Nightmare Zone Dream.
	 */
	private int elapsedTimeSeconds;

	/**
	 * Points currently earned in a Nightmare Zone dream
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private int points;

	/**
	 * Expected hourly Nightmare Zone dream points rate
	 */
	@Getter
	private int pointsPerHour;

	/**
	 * Nightmare Zone dream duration time formatted into a user-friendly string. hh/mm/ss.
	 */
	@Getter
	private String formattedElapsedTime;


	@Inject
	NightmareZoneInfoModel(Client client, NightmareZoneConfig config)
	{
		this.client = client;
		this.config = config;
		dreamStartTime = new Timestamp(System.currentTimeMillis());
	}

	public void update()
	{
		int points = client.getVar(Varbits.NMZ_POINTS);

		elapsedTimeSeconds = (int) (System.currentTimeMillis() - dreamStartTime.getTime()) / 1000;

		setPoints(points);
		setPointsPerHour(points);
		setFormattedElapsedTime();
	}

	private void setPointsPerHour(int points)
	{
		pointsPerHour = (int) (3600.0 / (elapsedTimeSeconds) * points);
	}

	private void setFormattedElapsedTime()
	{
		int durationHours = (elapsedTimeSeconds % (24 * 60 * 60)) / (60 * 60);
		int durationMinutes = (elapsedTimeSeconds % (60 * 60)) / 60;
		int durationSeconds = elapsedTimeSeconds % 60;

		if (durationHours > 0)
		{
			formattedElapsedTime = String.format("%02d:%02d:%02d", durationHours, durationMinutes, durationSeconds);
		}
		else if (durationSeconds >= 0)
		{
			formattedElapsedTime = String.format("%02d:%02d", durationMinutes, durationSeconds);
		}
	}
}
