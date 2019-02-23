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

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.function.Consumer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ColorUtil;
import org.pushingpixels.substance.internal.SubstanceSynapse;

public class RuneliteColorPicker extends JDialog
{
	static final String CONFIG_GROUP = "colorpicker";

	private final static int FRAME_WIDTH = 400;
	private final static int FRAME_HEIGHT = 380;
	private final static int TONE_PANEL_SIZE = 160;

	private final static String BLANK_HEX = "#000";

	private final ColorPanel colorPanel = new ColorPanel(TONE_PANEL_SIZE);
	private final HuePanel huePanel = new HuePanel(TONE_PANEL_SIZE);
	private final PreviewPanel afterPanel = new PreviewPanel();

	private final ColorValuePanel redSlider = new ColorValuePanel("Red");
	private final ColorValuePanel greenSlider = new ColorValuePanel("Green");
	private final ColorValuePanel blueSlider = new ColorValuePanel("Blue");
	private final ColorValuePanel alphaSlider = new ColorValuePanel("Opacity");

	private final JTextField hexInput = new JTextField();

	private final boolean alphaHidden;

	@Getter
	private Color selectedColor;

	@Setter
	private Consumer<Color> onColorChange;

	@Setter
	private Consumer<Color> onClose;

	RuneliteColorPicker(Window parent, Color previousColor, String title, boolean alphaHidden,
		final ConfigManager configManager, final ColorPickerManager colorPickerManager)
	{
		super(parent, "RuneLite Color Picker - " + title, ModalityType.MODELESS);

		this.selectedColor = previousColor;
		this.alphaHidden = alphaHidden;

		RecentColors recentColors = new RecentColors(configManager);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setBackground(ColorScheme.PROGRESS_COMPLETE_COLOR);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel content = new JPanel(new BorderLayout());
		content.putClientProperty(SubstanceSynapse.COLORIZATION_FACTOR, 1.0);
		content.setBorder(new EmptyBorder(15, 15, 15, 15));

		JPanel colorSelection = new JPanel(new BorderLayout(15, 0));

		JPanel leftPanel = new JPanel(new BorderLayout(15, 0));
		leftPanel.add(huePanel, BorderLayout.WEST);
		leftPanel.add(colorPanel, BorderLayout.CENTER);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		GridBagConstraints cx = new GridBagConstraints();

		cx.insets = new Insets(0, 0, 0, 0);
		JLabel old = new JLabel("Previous");
		old.setHorizontalAlignment(JLabel.CENTER);

		JLabel next = new JLabel(" Current ");
		next.setHorizontalAlignment(JLabel.CENTER);

		PreviewPanel beforePanel = new PreviewPanel();
		beforePanel.setColor(previousColor);
		afterPanel.setColor(previousColor);

		JPanel hexContainer = new JPanel(new GridBagLayout());

		JLabel hexLabel = new JLabel("#");
		hexInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel label = new JLabel("Hex color");
		label.setVerticalAlignment(JLabel.BOTTOM);

		cx.weightx = 0;
		cx.fill = GridBagConstraints.BOTH;
		cx.insets = new Insets(0, 1, 0, 1);
		hexContainer.add(hexLabel, cx);

		cx.weightx = 1;
		cx.fill = GridBagConstraints.HORIZONTAL;
		cx.gridwidth = GridBagConstraints.REMAINDER;
		hexContainer.add(hexInput, cx);

		cx.fill = GridBagConstraints.BOTH;
		cx.weightx = 1;
		cx.weighty = 1;
		cx.gridy = 0;
		cx.gridx = 0;

		JPanel recentColorsContainer = recentColors.build(c ->
		{
			if (!alphaHidden)
			{
				alphaSlider.update(c.getAlpha());
			}

			colorChange(c);
			updatePanels();
		}, alphaHidden);

		rightPanel.add(recentColorsContainer, cx);

		cx.gridwidth = GridBagConstraints.RELATIVE;
		cx.gridy++;
		rightPanel.add(old, cx);

		cx.gridx++;
		rightPanel.add(next, cx);

		cx.gridx = 0;
		cx.gridy++;
		cx.gridwidth = GridBagConstraints.RELATIVE;
		cx.fill = GridBagConstraints.BOTH;
		rightPanel.add(beforePanel, cx);

		cx.gridx++;
		rightPanel.add(afterPanel, cx);

		cx.gridwidth = GridBagConstraints.REMAINDER;
		cx.gridx = 0;
		cx.gridy++;
		rightPanel.add(label, cx);

		cx.gridy++;
		cx.fill = GridBagConstraints.HORIZONTAL;
		rightPanel.add(hexContainer, cx);

		JPanel slidersContainer = new JPanel(new GridLayout(4, 1, 0, 10));
		slidersContainer.setBorder(new EmptyBorder(15, 0, 0, 0));

		slidersContainer.add(redSlider);
		slidersContainer.add(greenSlider);
		slidersContainer.add(blueSlider);
		slidersContainer.add(alphaSlider);

		if (alphaHidden)
		{
			alphaSlider.setVisible(false);
			setSize(FRAME_WIDTH, FRAME_HEIGHT - 40);
		}

		colorSelection.add(leftPanel, BorderLayout.WEST);
		colorSelection.add(rightPanel, BorderLayout.CENTER);
		colorSelection.add(slidersContainer, BorderLayout.SOUTH);

		content.add(colorSelection, BorderLayout.NORTH);

		setContentPane(content);

		// Reset selected color when clicking the old color
		beforePanel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (!alphaHidden)
				{
					alphaSlider.update(beforePanel.getColor().getAlpha());
				}
				colorChange(beforePanel.getColor());
				updatePanels();
			}
		});

		huePanel.setOnColorChange((y) ->
		{
			colorPanel.setBaseColor(y);
			updateText();
		});

		colorPanel.setOnColorChange(this::colorChange);

		((AbstractDocument) hexInput.getDocument()).setDocumentFilter(new DocumentFilter()
		{
			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
				throws BadLocationException
			{
				str = str.replaceAll("#|0x", "");
				String text = RuneliteColorPicker.getReplacedText(fb, offset, length, str);

				if (!ColorUtil.isHex(text))
				{
					Toolkit.getDefaultToolkit().beep();
					return;
				}

				super.replace(fb, offset, length, str, attrs);
			}
		});
		hexInput.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				updateHex();
			}
		});
		hexInput.addActionListener((ActionEvent e) -> updateHex());

		redSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(i, selectedColor.getGreen(), selectedColor.getBlue()));
			updatePanels();
		});

		greenSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(selectedColor.getRed(), i, selectedColor.getBlue()));
			updatePanels();
		});

		blueSlider.setOnValueChanged(i ->
		{
			colorChange(new Color(selectedColor.getRed(), selectedColor.getGreen(), i));
			updatePanels();
		});

		alphaSlider.setOnValueChanged(i ->
			colorChange(new Color(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue(), i)));

		updatePanels();
		updateText();

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				if (onClose != null)
				{
					onClose.accept(selectedColor);
				}

				if (!Objects.equals(previousColor, selectedColor))
				{
					recentColors.add(selectedColor.getRGB() + "");
				}

				RuneliteColorPicker cp = colorPickerManager.getCurrentPicker();
				if (Objects.equals(cp, RuneliteColorPicker.this))
				{
					colorPickerManager.setCurrentPicker(null);
				}
			}
		});
	}

	private void updatePanels()
	{
		huePanel.select(selectedColor);
		colorPanel.moveToClosestColor(huePanel.getSelectedY(), selectedColor);
	}

	private void updateText()
	{
		String hex = alphaHidden ? ColorUtil.colorToHexCode(this.getSelectedColor()) : ColorUtil.colorToAlphaHexCode(this.getSelectedColor());
		hexInput.setText(hex.toUpperCase());
		afterPanel.setColor(selectedColor);

		redSlider.update(this.selectedColor.getRed());
		greenSlider.update(this.selectedColor.getGreen());
		blueSlider.update(this.selectedColor.getBlue());
		if (!alphaHidden)
		{
			alphaSlider.update(this.selectedColor.getAlpha());
		}
	}

	private void colorChange(Color newColor)
	{
		if (newColor == this.selectedColor)
		{
			return;
		}

		this.selectedColor = newColor;

		// Finally, before firing the color changed event, apply any transparency
		// that might have been edited by the user
		if (this.selectedColor.getAlpha() != this.alphaSlider.getValue())
		{
			this.selectedColor = new Color(
				selectedColor.getRed(),
				selectedColor.getGreen(),
				selectedColor.getBlue(),
				alphaSlider.getValue());
		}

		updateText();

		if (onColorChange != null)
		{
			onColorChange.accept(this.selectedColor);
		}
	}

	/**
	 * Parses the hex input, updating the color with the new values.
	 */
	private void updateHex()
	{
		String hex = hexInput.getText();
		if (Strings.isNullOrEmpty(hex))
		{
			hex = BLANK_HEX;
		}

		Color color = ColorUtil.fromHex(hex);
		if (color == null)
		{
			return;
		}

		if (!alphaHidden && ColorUtil.isAlphaHex(hex))
		{
			alphaSlider.update(color.getAlpha());
		}

		colorChange(color);
		updatePanels();
	}

	/**
	 * Gets the whole string from the passed DocumentFilter replace.
	 */
	static String getReplacedText(DocumentFilter.FilterBypass fb, int offset, int length, String str)
		throws BadLocationException
	{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
		sb.replace(offset, offset + length, str);

		return sb.toString();
	}
}