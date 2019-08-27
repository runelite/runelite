/*
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.cluescrolls.clues.hotcold;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.util.Text;

@AllArgsConstructor
@Getter
public enum HotColdTemperature
{
	ICE_COLD("ice cold", 500, 5000),
	VERY_COLD("very cold", 200, 499),
	COLD("cold", 150, 199),
	WARM("warm", 100, 149),
	HOT("hot", 70, 99),
	VERY_HOT("very hot", 30, 69),
	BEGINNER_INCREDIBLY_HOT("incredibly hot", 4, 29),
	BEGINNER_VISIBLY_SHAKING("visibly shaking", 0, 3),
	MASTER_INCREDIBLY_HOT("incredibly hot", 5, 29),
	MASTER_VISIBLY_SHAKING("visibly shaking", 0, 4);

	public static final Set<HotColdTemperature> BEGINNER_HOT_COLD_TEMPERATURES = Sets.immutableEnumSet(
		ICE_COLD,
		VERY_COLD,
		COLD,
		WARM,
		HOT,
		VERY_HOT,
		BEGINNER_INCREDIBLY_HOT,
		BEGINNER_VISIBLY_SHAKING
	);
	public static final Set<HotColdTemperature> MASTER_HOT_COLD_TEMPERATURES = Sets.immutableEnumSet(
		ICE_COLD,
		VERY_COLD,
		COLD,
		WARM,
		HOT,
		VERY_HOT,
		MASTER_INCREDIBLY_HOT,
		MASTER_VISIBLY_SHAKING
	);

	private final String text;
	private final int minDistance;
	private final int maxDistance;

	private static final String DEVICE_USED_START_TEXT = "The device is ";

	/**
	 * Gets the temperature from a set of temperatures corresponding to the passed string.
	 *
	 * @param temperatureSet A set of temperature values to select from
	 * @param message        A string containing a temperature value
	 * @return The corresponding enum from the given temperature set.
	 *         <p>
	 *         Note that in cases where two temperature values in the given set are equally likely to be the given
	 *         temperature (say, two temperatures with identical text values), the behavior is undefined.
	 */
	@Nullable
	public static HotColdTemperature getFromTemperatureSet(final Set<HotColdTemperature> temperatureSet, final String message)
	{
		if (!message.startsWith(DEVICE_USED_START_TEXT) || temperatureSet == null)
		{
			return null;
		}

		final String messageStart = Text.fromCSV(message).get(0);
		final List<HotColdTemperature> possibleTemperatures = new ArrayList<>();

		for (final HotColdTemperature temperature : temperatureSet)
		{
			if (messageStart.contains(temperature.getText()))
			{
				possibleTemperatures.add(temperature);
			}
		}

		return possibleTemperatures.stream()
			// For messages such as "The device is very cold", this will choose the Enum with text of greatest length so
			// that VERY_COLD would be selected over COLD, though both Enums have matching text for this message.
			.max(Comparator.comparingInt(x -> (x.getText()).length()))
			.orElse(null);
	}
}
