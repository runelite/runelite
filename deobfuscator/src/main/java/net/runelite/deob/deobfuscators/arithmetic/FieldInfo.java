/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.arithmetic;

import static java.lang.Math.abs;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static net.runelite.deob.deobfuscators.arithmetic.DMath.multiply;

class FieldInfo
{
	public final Set<Number> getters = new HashSet<>();
	public final Set<Number> setters = new HashSet<>();
	public final Set<AssociatedConstant> constants = new HashSet<>();

	boolean guessDecreasesConstants(Pair guess)
	{
		if (getters.isEmpty() && setters.isEmpty())
		{
			return false;
		}

		if (guess.getter.longValue() == -1 && guess.setter.longValue() == -1)
		{
			// special case - when guess is -1/-1, checking the abs(total)
			// is not helpful. instead look for both:
			// associated non-constant of value -1
			// no non-constant non-other values (indicative of field being
			// obfuscated still since if it used elsewhere it would have
			// an associated constant)
			//
			// this is really only her to fight:
			// client.java:            field975 = field974;
			// client.java:            field974 = field971;
			// when field974 is only used in combination with field975
			// and is initialized to -1. This causes causes guess()
			// to guess a negated getter which then causes
			// client.java:            field975 = field974 * -1;
			// client.java:            field974 = field971 * -1;
			// And it becomes difficult to prevent both fields being
			// multiplied by -1 on each round. field975 has some other
			// uses.

			// only change if there is a -1 in the non constant
			// and also there is a non constant non other too
			List<Number> value2 = constants.stream()
				.filter(i -> !i.constant)
				.map(i -> i.value)
				.collect(Collectors.toList());

			List<Number> value = constants.stream()
				.filter(i -> !i.other)
				.filter(i -> !i.constant)
				.map(i -> i.value)
				.collect(Collectors.toList());
			return value.isEmpty() && value2.contains(-1);
		}

		// remove possibe getters that are:
		// - a constant - they don't necessarilly decrease when deobfuscated
		// - are multiplied into another field
		// - are both a getter and setter
		Collection<Number> gettersFiltered = getters.stream()
			.filter(number -> isOkay(number))
			.collect(Collectors.toSet());

		Collection<Number> settersFiltered = setters.stream()
			.filter(number -> isOkay(number))
			.collect(Collectors.toSet());

		if (!gettersFiltered.isEmpty())
		{
			long before = gettersFiltered.stream()
				.mapToLong(number -> abs(downsample(number).longValue()))
				.sum();
			long after = gettersFiltered.stream()
				.mapToLong(number -> abs(downsample(multiply(number, guess.setter)).longValue()))
				.sum();

			assert before >= 0;
			assert after >= 0;

			// If the total value of the getters is more, assume
			// the guess is bad. Ideally the values go to 1, so
			// 'after' will be small.
			if (after > before)
			{
				return false;
			}
		}

		if (!settersFiltered.isEmpty())
		{
			long beforeSetter = settersFiltered.stream()
				.mapToLong(number -> abs(downsample(number).longValue()))
				.sum();

			long afterSetter = settersFiltered.stream()
				.mapToLong(number -> abs(downsample(multiply(number, guess.getter)).longValue()))
				.sum();

			assert beforeSetter >= 0;
			assert afterSetter >= 0;

			if (afterSetter > beforeSetter)
			{
				return false;
			}
		}

		return true;
	}

	private boolean isOkay(Number number)
	{
		for (AssociatedConstant c : constants)
		{
			if (c.value.equals(number)
				&& !c.constant
				&& !c.other
				&& !(c.setter && c.getter))
			{
				return true;
			}
		}
		return false;
	}

	// summation of longs probably overflows,
	// so only use the most significant 32 bits
	private Number downsample(Number number)
	{
		if (number instanceof Long)
		{
			long l = (Long) number;
			return l >>> 32;
		}
		return number;
	}
}
