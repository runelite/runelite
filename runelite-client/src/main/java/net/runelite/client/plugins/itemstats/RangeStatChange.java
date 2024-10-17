/*
 * Copyright (c) 2016-2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.itemstats;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A stat change which can result in different magnitudes of change to the stat
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RangeStatChange extends StatChange
{
	/**
	 * Minimum relative change that will occur if the stat boost is applied now.
	 * In this class, {@code relative} is representative of the maximum relative change that will
	 * occur.
	 */
	private int minRelative;

	/**
	 * Minimum theoretical change that can occur before boost cap is enforced.
	 * In this class, {@code theoretical} is representative of the maximum theoretical change that
	 * will occur.
	 */
	private int minTheoretical;

	/**
	 * Minimum absolute total of the stat after applying the boost.
	 * In this class, {@code absolute} is representative of the maximum absolute change that will
	 * occur.
	 */
	private int minAbsolute;

	/**
	 * Returns a human-readable formatted relative boost.
	 * Should be the boost range in the format "±N" (for minimum -N and maximum +N values),
	 * "+MIN~MAX" (for minimum and maximum values of the same sign),
	 * "-MIN~+MAX" (for negative minimum and positive maximum values), or
	 * "+MAX" (for equal minimum and maximum values).
	 *
	 * @return The formatted relative boost amount
	 */
	@Override
	public String getFormattedRelative()
	{
		return concat(minRelative, getRelative());
	}

	/**
	 * Returns a human-readable formatted theoretical boost.
	 * Should be the boost range in the format "±N" (for minimum -N and maximum +N values),
	 * "+MIN~MAX" (for minimum and maximum values of the same sign),
	 * "-MIN~+MAX" (for negative minimum and positive maximum values), or
	 * "+MAX" (for equal minimum and maximum values).
	 *
	 * @return The formatted theoretical boost amount
	 */
	@Override
	public String getFormattedTheoretical()
	{
		return concat(minTheoretical, getTheoretical());
	}

	private static String concat(int changeA, int changeB)
	{
		if (changeA == changeB)
		{
			return formatBoost(changeA);
		}
		else if (changeA * -1 == changeB)
		{
			return "±" + Math.abs(changeA);
		}

		final StringBuilder sb = new StringBuilder();

		sb.append(String.format("%+d", changeA));
		sb.append('~');

		// If they share a operator, strip b's duplicate
		if (changeA < 0 && changeB < 0
			|| changeA >= 0 && changeB >= 0)
		{
			sb.append(Math.abs(changeB));
		}
		else
		{
			sb.append(String.format("%+d", changeB));
		}

		return sb.toString();
	}
}
