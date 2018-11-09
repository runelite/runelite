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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.Setter;

class RuneliteColorPicker extends JFrame
{

	private final static int FRAME_WIDTH = 400;
	private final static int FRAME_HEIGHT = 380;
	private final static int TONE_PANEL_SIZE = 160;

	private final TonePanel tonePanel = new TonePanel(TONE_PANEL_SIZE);
	private final ColorPanel colorPanel = new ColorPanel(TONE_PANEL_SIZE);
	private final JPanel afterPreview = new JPanel();

	private final ColorValueSlider redSlider = new ColorValueSlider("Red");
	private final ColorValueSlider greenSlider = new ColorValueSlider("Green");
	private final ColorValueSlider blueSlider = new ColorValueSlider("Blue");
	private final ColorValueSlider alphaSlider = new ColorValueSlider("Alpha");

	private final JTextField hexInput = new JTextField();
	private final JTextField rgbaInput = new JTextField();

	private Color selectedColor;
	@Setter
	private Consumer<Color> onColorChange;

	RuneliteColorPicker(Color previousColor)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RuneLite Color Picker");
		setResizable(false);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		JPanel content = new JPanel(new BorderLayout());
		content.setBorder(new EmptyBorder(15, 15, 15, 15));
		content.setBackground(new Color(30, 30, 30));

		JPanel colorSelection = new JPanel(new BorderLayout(15, 0));
		colorSelection.setBackground(new Color(30, 30, 30));

		JPanel leftPanel = new JPanel(new BorderLayout(15, 0));
		leftPanel.setBackground(new Color(30, 30, 30));

		leftPanel.add(colorPanel, BorderLayout.WEST);
		leftPanel.add(tonePanel, BorderLayout.CENTER);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBackground(new Color(30, 30, 30));

		JPanel contrastPanel = new JPanel(new GridLayout(1, 2));
		contrastPanel.setBackground(new Color(30, 30, 30));

		JPanel beforePreview = new JPanel();
		beforePreview.setBackground(selectedColor);
		afterPreview.setBackground(selectedColor);

		contrastPanel.add(beforePreview);
		contrastPanel.add(afterPreview);

		JPanel hexContainer = new JPanel(new GridLayout(2, 1, 0, 5));
		hexContainer.setBackground(new Color(30, 30, 30));

		JLabel hexLabel = new JLabel("Hex color:");
		hexLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		hexLabel.setForeground(Color.WHITE);

		hexInput.setBorder(new EmptyBorder(5, 5, 5, 5));
		hexInput.setBackground(new Color(20, 20, 20));
		hexInput.setForeground(Color.WHITE);

		hexContainer.add(hexLabel);
		hexContainer.add(hexInput);

		JPanel rgbContainer = new JPanel(new GridLayout(2, 1, 0, 5));
		rgbContainer.setBackground(new Color(30, 30, 30));

		JLabel rgbLabel = new JLabel("RGBA color:");
		rgbLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		rgbLabel.setForeground(Color.WHITE);

		rgbaInput.setBorder(new EmptyBorder(5, 5, 5, 5));
		rgbaInput.setBackground(new Color(20, 20, 20));
		rgbaInput.setForeground(Color.WHITE);

		rgbContainer.add(rgbLabel);
		rgbContainer.add(rgbaInput);

		rightPanel.add(contrastPanel);
		rightPanel.add(hexContainer);
		rightPanel.add(rgbContainer);

		JPanel slidersContainer = new JPanel(new GridLayout(4, 1, 0, 10));
		slidersContainer.setBorder(new EmptyBorder(15, 0, 0, 0));
		slidersContainer.setBackground(new Color(30, 30, 30));

		slidersContainer.add(redSlider);
		slidersContainer.add(greenSlider);
		slidersContainer.add(blueSlider);
		slidersContainer.add(alphaSlider);

		colorSelection.add(leftPanel, BorderLayout.WEST);
		colorSelection.add(rightPanel, BorderLayout.CENTER);
		colorSelection.add(slidersContainer, BorderLayout.SOUTH);

		content.add(colorSelection, BorderLayout.NORTH);

		setContentPane(content);

		this.selectedColor = previousColor;
		beforePreview.setBackground(previousColor);

		alphaSlider.update(previousColor.getAlpha());

		colorPanel.setOnColorChange((color, forced) ->
		{
			tonePanel.setBaseColor(color, forced);
		});

		tonePanel.setOnColorChange(c ->
		{
			hexInput.setText(ColorUtils.getHex(c));
			rgbaInput.setText(ColorUtils.getRGB(c));
			afterPreview.setBackground(c);

			redSlider.update(c.getRed());
			greenSlider.update(c.getGreen());
			blueSlider.update(c.getBlue());

			colorChange(c);
		});

		rgbaInput.addActionListener(new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				validateRGB();
			}
		});

		hexInput.addActionListener(new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				validateHex();
			}
		});

		redSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(i, selectedColor.getGreen(), selectedColor.getBlue()));
			update();
		});

		greenSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(selectedColor.getRed(), i, selectedColor.getBlue()));
			update();
		});

		blueSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(selectedColor.getRed(), selectedColor.getGreen(), i));
			update();
		});

		alphaSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(
				selectedColor.getRed(),
				selectedColor.getGreen(),
				selectedColor.getBlue(), i));
			rgbaInput.setText(ColorUtils.getRGB(selectedColor));
		});

		update();
		setVisible(true);
	}

	private void update()
	{
		colorPanel.select(selectedColor);
		tonePanel.select(selectedColor);
	}

	private void colorChange(Color newColor)
	{
		this.selectedColor = newColor;

		// Finally, before firing the color changed event, apply any transparency
		// that might have been edited by the user
		if (this.selectedColor.getAlpha() != this.alphaSlider.getValue())
		{
			colorChange(new Color(
				selectedColor.getRed(),
				selectedColor.getGreen(),
				selectedColor.getBlue(),
				alphaSlider.getValue()));
		}

		if (onColorChange != null)
		{
			onColorChange.accept(this.selectedColor);
		}
	}

	/**
	 * Validates the hex input, updating the color with the new values.
	 */
	private void validateHex()
	{
		String colorStr = hexInput.getText();

		if (!colorStr.startsWith("#"))
		{
			colorStr = "#" + colorStr;
		}

		int r = Integer.valueOf(colorStr.substring(1, 3), 16);
		int g = Integer.valueOf(colorStr.substring(3, 5), 16);
		int b = Integer.valueOf(colorStr.substring(5, 7), 16);

		colorChange(new Color(r, g, b));
		update();
	}

	/**
	 * Validates the rgba input, updating the color with the new values.
	 */
	private void validateRGB()
	{
		String colorStr = rgbaInput.getText().replace(" ", "");

		if (!colorStr.contains(","))
		{
			return;
		}

		String[] values = colorStr.split(",");

		if (values.length < 3)
		{
			return;
		}

		for (String s : values)
		{
			if (!s.matches("-?(0|[1-9]\\d*)"))
			{
				return;
			}
		}

		int r = ColorUtils.limitRGB(Integer.parseInt(values[0]));
		int g = ColorUtils.limitRGB(Integer.parseInt(values[1]));
		int b = ColorUtils.limitRGB(Integer.parseInt(values[2]));
		int a = values.length == 3 ? 255 : ColorUtils.limitRGB(Integer.parseInt(values[3]));

		colorChange(new Color(r, g, b, a));
		update();

		// When updating tones, the algorithm will default to 255 alpha because
		// it doesn't take transparency into consideration for calculations
		// to make sure the alpha value is displayed on the slider and rgba input
		// we have to force it post-update
		if (a < 255)
		{
			alphaSlider.update(a);
			rgbaInput.setText(ColorUtils.getRGB(selectedColor));
		}
	}
}