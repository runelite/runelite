/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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

import com.google.common.annotations.VisibleForTesting;
import java.awt.Rectangle;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

/**
 * Solution finder for hot-cold style puzzles.
 * <p>
 * These puzzles are established by having some way to test the distance from the solution via "warmth", where being
 * colder means one is farther away from the target, and being warmer means one is closer to it, with the goal being to
 * reach the most warm value to discover the solution point. Hot-cold puzzles in Old School RuneScape are implemented
 * with specific set of solution points, so this solver will filter from a provided set of possible solutions as new
 * signals of temperatures and temperature changes are provided.
 */
@Getter(AccessLevel.PUBLIC)
public class HotColdSolver
{
	private final Set<HotColdLocation> possibleLocations;
	@Nullable
	private WorldPoint lastWorldPoint;

	public HotColdSolver(Set<HotColdLocation> possibleLocations)
	{
		this.possibleLocations = possibleLocations;
	}

	/**
	 * Process a hot-cold update given a {@link WorldPoint} where a check occurred and the resulting temperature and
	 * temperature change discovered at that point. This will filter the set of possible locations which can be the
	 * solution.
	 *
	 * @param worldPoint        The point where a hot-cold check occurred
	 * @param temperature       The temperature of the checked point
	 * @param temperatureChange The change of temperature of the checked point compared to the previously-checked point
	 * @return A set of {@link HotColdLocation}s which are still possible after the filtering occurs. This return value
	 * is the same as would be returned by {@code getPossibleLocations()}.
	 */
	public Set<HotColdLocation> signal(@Nonnull final WorldPoint worldPoint, @Nonnull final HotColdTemperature temperature, @Nullable final HotColdTemperatureChange temperatureChange)
	{
		// when the strange device reads a temperature, that means that the center of the final dig location
		// is a range of squares away from the player's current location (Chebyshev AKA Chess-board distance)
		int maxSquaresAway = temperature.getMaxDistance();
		int minSquaresAway = temperature.getMinDistance();

		// maxDistanceArea encompasses all of the points that are within the max possible distance from the player
		final Rectangle maxDistanceArea = new Rectangle(
			worldPoint.getX() - maxSquaresAway,
			worldPoint.getY() - maxSquaresAway,
			2 * maxSquaresAway + 1,
			2 * maxSquaresAway + 1);
		// minDistanceArea encompasses all of the points that are within the min possible distance from the player
		final Rectangle minDistanceArea = new Rectangle(
			worldPoint.getX() - minSquaresAway,
			worldPoint.getY() - minSquaresAway,
			2 * minSquaresAway + 1,
			2 * minSquaresAway + 1);

		// eliminate from consideration dig spots that lie entirely within the min range or entirely outside of the max range
		possibleLocations.removeIf(entry -> minDistanceArea.contains(entry.getRect()) || !maxDistanceArea.intersects(entry.getRect()));

		// if a previous world point has been recorded, we can consider the warmer/colder result from the strange device
		if (lastWorldPoint != null && temperatureChange != null)
		{
			switch (temperatureChange)
			{
				case COLDER:
					// eliminate spots that are absolutely warmer
					possibleLocations.removeIf(entry -> isFirstPointCloserRect(worldPoint, lastWorldPoint, entry.getRect()));
					break;
				case WARMER:
					// eliminate spots that are absolutely colder
					possibleLocations.removeIf(entry -> isFirstPointCloserRect(lastWorldPoint, worldPoint, entry.getRect()));
					break;
				case SAME:
					// I couldn't figure out a clean implementation for this case
					// not necessary for quickly determining final location
			}
		}

		lastWorldPoint = worldPoint;
		return getPossibleLocations();
	}

	/**
	 * Determines whether the first point passed is closer to each corner of the given rectangle than the second point.
	 *
	 * @param firstPoint  First point to test. Return result will be relating to this point's location.
	 * @param secondPoint Second point to test
	 * @param rect        Rectangle, whose corner points will be compared to the first and second points passed
	 * @return {@code true} if {@code firstPoint} is closer to each of {@code rect}'s four corner points than
	 * {@code secondPoint}, {@code false} otherwise.
	 * @see WorldPoint#distanceTo2D
	 */
	@VisibleForTesting
	private static boolean isFirstPointCloserRect(final WorldPoint firstPoint, final WorldPoint secondPoint, final Rectangle rect)
	{
		final WorldPoint nePoint = new WorldPoint((rect.x + rect.width), (rect.y + rect.height), 0);

		if (!isFirstPointCloser(firstPoint, secondPoint, nePoint))
		{
			return false;
		}

		final WorldPoint sePoint = new WorldPoint((rect.x + rect.width), rect.y, 0);

		if (!isFirstPointCloser(firstPoint, secondPoint, sePoint))
		{
			return false;
		}

		final WorldPoint nwPoint = new WorldPoint(rect.x, (rect.y + rect.height), 0);

		if (!isFirstPointCloser(firstPoint, secondPoint, nwPoint))
		{
			return false;
		}

		final WorldPoint swPoint = new WorldPoint(rect.x, rect.y, 0);
		return (isFirstPointCloser(firstPoint, secondPoint, swPoint));
	}

	/**
	 * Determines whether the first point passed is closer to the given point of comparison than the second point.
	 *
	 * @param firstPoint  First point to test. Return result will be relating to this point's location.
	 * @param secondPoint Second point to test
	 * @param worldPoint  Point to compare to the first and second points passed
	 * @return {@code true} if {@code firstPoint} is closer to {@code worldPoint} than {@code secondPoint},
	 * {@code false} otherwise.
	 * @see WorldPoint#distanceTo2D
	 */
	@VisibleForTesting
	private static boolean isFirstPointCloser(final WorldPoint firstPoint, final WorldPoint secondPoint, final WorldPoint worldPoint)
	{
		return firstPoint.distanceTo2D(worldPoint) < secondPoint.distanceTo2D(worldPoint);
	}
}
