/*
 * Copyright (c) 2020, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.ui;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFormattedTextField;
import lombok.RequiredArgsConstructor;

final class UnitFormatter extends JFormattedTextField.AbstractFormatter
{
	private final String units;

	UnitFormatter(String units)
	{
		this.units = units;
	}

	@Override
	public Object stringToValue(final String text) throws ParseException
	{
		final String trimmedText;

		// Using the spinner controls causes the value to have the unit on the end, so remove it
		if (text.endsWith(units))
		{
			trimmedText = text.substring(0, text.length() - units.length());
		}
		else
		{
			trimmedText = text;
		}

		try
		{
			return Integer.valueOf(trimmedText);
		}
		catch (NumberFormatException e)
		{
			throw new ParseException(trimmedText + " is not an integer.", 0); // NOPMD: PreserveStackTrace
		}
	}

	@Override
	public String valueToString(final Object value)
	{
		return value + units;
	}
}

@RequiredArgsConstructor
public final class UnitFormatterFactory extends JFormattedTextField.AbstractFormatterFactory
{
	private final String units;
	private final Map<JFormattedTextField, JFormattedTextField.AbstractFormatter> formatters = new HashMap<>();

	@Override
	public JFormattedTextField.AbstractFormatter getFormatter(final JFormattedTextField tf)
	{
		return formatters.computeIfAbsent(tf, (key) -> new UnitFormatter(units));
	}
}
