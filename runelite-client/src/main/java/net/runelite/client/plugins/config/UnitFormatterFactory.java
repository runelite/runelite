package net.runelite.client.plugins.config;

import lombok.RequiredArgsConstructor;

import javax.swing.JFormattedTextField;
import java.util.HashMap;
import java.util.Map;

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
