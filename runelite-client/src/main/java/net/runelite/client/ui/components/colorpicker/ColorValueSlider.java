/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.ui.components.colorpicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lombok.Setter;
import net.runelite.client.ui.ColorScheme;

public class ColorValueSlider extends JPanel
{
	private JSlider slider;
	private JTextField input;

	@Setter
	private Consumer<Integer> onValueChanged;

	// This variable makes sure we only fire the onValueChanged event when
	// the slider is manually edited, otherwise it will fire when force updated.
	// It seems there is no way in swing to verify if a slider movement was manual.
	private boolean forcedUpdate;

	ColorValueSlider(String labelText)
	{
		setLayout(new BorderLayout(10, 0));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		input = new JTextField();
		input.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		input.setPreferredSize(new Dimension(40, 30));
		input.setBorder(new EmptyBorder(5, 5, 5, 5));
		input.addActionListener(a ->
		{
			if (!input.getText().isEmpty() && input.getText().matches("-?(0|[1-9]\\d*)"))
			{
				int value = Integer.parseInt(input.getText());

				update(value);

				if (onValueChanged != null)
				{
					onValueChanged.accept(value);
				}
			}
		});

		JLabel label = new JLabel(labelText);
		label.setPreferredSize(new Dimension(40, 0));
		label.setForeground(Color.WHITE);

		slider = new JSlider();
		slider.setBackground(ColorScheme.DARK_GRAY_COLOR);
		slider.setMinimum(ColorUtils.MIN_RGB_VALUE);
		slider.setMaximum(ColorUtils.MAX_RGB_VALUE);
		slider.setBorder(new EmptyBorder(0, 0, 5, 0));
		slider.setUI(new CustomSliderUI(slider));

		slider.addChangeListener(c ->
		{
			if (!forcedUpdate && onValueChanged != null)
			{
				onValueChanged.accept(slider.getValue());
			}

			update(slider.getValue());
		});

		add(label, BorderLayout.WEST);
		add(slider, BorderLayout.CENTER);
		add(input, BorderLayout.EAST);
	}

	public void update(int value)
	{
		value = ColorUtils.limitRGB(value);

		forcedUpdate = true;
		slider.setValue(value);
		forcedUpdate = false;

		input.setText(value + "");
	}

	public int getValue()
	{
		return slider.getValue();
	}
}
