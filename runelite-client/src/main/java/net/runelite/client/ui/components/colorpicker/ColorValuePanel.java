/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ColorUtil;

public class ColorValuePanel extends JPanel
{
	private static final int DEFAULT_VALUE = ColorUtil.MAX_RGB_VALUE;

	private ColorValueSlider slider = new ColorValueSlider();
	private JTextField input = new JTextField();

	private Consumer<Integer> onValueChanged;

	void setOnValueChanged(Consumer<Integer> c)
	{
		onValueChanged = c;
		slider.setOnValueChanged(c);
	}

	ColorValuePanel(String labelText)
	{
		setLayout(new BorderLayout(10, 0));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		input.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		input.setPreferredSize(new Dimension(35, 30));
		input.setBorder(new EmptyBorder(5, 5, 5, 5));
		((AbstractDocument) input.getDocument()).setDocumentFilter(new DocumentFilter()
		{
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
				throws BadLocationException
			{
				try
				{
					String text = RuneliteColorPicker.getReplacedText(fb, offset, length, str);

					int value = Integer.parseInt(text);
					if (value < ColorUtil.MIN_RGB_VALUE || value > ColorUtil.MAX_RGB_VALUE)
					{
						Toolkit.getDefaultToolkit().beep();
						return;
					}

					super.replace(fb, offset, length, str, attrs);
				}
				catch (NumberFormatException e)
				{
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});

		input.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				updateText();
			}
		});

		input.addActionListener(a -> updateText());

		JLabel label = new JLabel(labelText);
		label.setPreferredSize(new Dimension(45, 0));
		label.setForeground(Color.WHITE);

		slider.setBackground(ColorScheme.DARK_GRAY_COLOR);
		slider.setBorder(new EmptyBorder(0, 0, 5, 0));
		slider.setPreferredSize(new Dimension(ColorUtil.MAX_RGB_VALUE + ColorValueSlider.KNOB_WIDTH, 30));

		update(DEFAULT_VALUE);
		add(label, BorderLayout.WEST);
		add(slider, BorderLayout.CENTER);
		add(input, BorderLayout.EAST);
	}

	private void updateText()
	{
		int value = Integer.parseInt(input.getText());

		update(value);
		if (onValueChanged != null)
		{
			onValueChanged.accept(getValue());
		}
	}

	public void update(int value)
	{
		value = ColorUtil.constrainValue(value);

		slider.setValue(value);
		input.setText(value + "");
	}

	public int getValue()
	{
		return slider.getValue();
	}
}
