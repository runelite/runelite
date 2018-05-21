/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
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
package net.runelite.client.plugins.screenmarkers.ui;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import lombok.Getter;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerOverlay;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

@Singleton
public class ScreenMarkerPluginPanel extends PluginPanel
{
	private static final String TITLE = "Screen Markers";
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private static final int DEFAULT_BORDER_THICKNESS = 5;
	private static final int DEFAULT_FILL_OPACITY = 75;
	private static final String COLOR_PICKER_TITLE = "Choose a color..";
	private static final String COLOR_TEXT = "Color";
	private static final String FILL_TEXT = "Fill";
	private static final String NEW_TEXT = "New";
	private static final String CANCEL_TEXT = "Cancel";
	private static final Color CANCEL_BUTTON_COLOR = Color.RED.darker();

	@Inject
	private ScreenMarkerPlugin plugin;

	private JButton markerButton;

	@Getter
	private Color selectedColor = DEFAULT_COLOR;

	@Getter
	private Color selectedFillColor = new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), DEFAULT_FILL_OPACITY);

	@Getter
	private int selectedBorderThickness = DEFAULT_BORDER_THICKNESS;

	private boolean creationEnabled = false;

	public void init()
	{
		setLayout(new BorderLayout());
		JPanel northPanel = new JPanel(new GridLayout(0, 2, 0, 3));

		markerButton = new JButton(NEW_TEXT);
		markerButton.setFocusable(false);
		markerButton.addActionListener(l -> startOrCancelCreation());

		northPanel.add(new JShadowedLabel(TITLE));
		northPanel.add(new JLabel());
		northPanel.add(new JShadowedLabel("Border size:"));
		northPanel.add(createBorderThicknessSpinner());
		northPanel.add(new JShadowedLabel("Border color:"));
		northPanel.add(createBorderColorButton());
		northPanel.add(new JShadowedLabel("Fill color:"));
		northPanel.add(createFillColorButton());

		northPanel.add(markerButton);

		JPanel centerPanel = new JPanel();
		JPanel markerView = new JPanel(new GridLayout(0, 1, 0, 3));

		for (final ScreenMarkerOverlay marker : plugin.getScreenMarkers())
		{
			markerView.add(new ScreenMarkerPanel(plugin, marker));
		}

		centerPanel.add(markerView, BorderLayout.NORTH);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}

	public void rebuild()
	{
		removeAll();
		repaint();
		revalidate();
		init();
	}

	private void startOrCancelCreation()
	{
		creationEnabled = !creationEnabled;
		plugin.setMouseListenerEnabled(creationEnabled);
		setMarkerButtonState(creationEnabled);
	}

	public void setCreationEnabled(boolean creationEnabled)
	{
		this.creationEnabled = creationEnabled;
		setMarkerButtonState(creationEnabled);
	}

	private void setMarkerButtonState(boolean selected)
	{
		markerButton.setSelected(selected);
		markerButton.setText(selected ? CANCEL_TEXT : NEW_TEXT);
		markerButton.setBackground(selected ? CANCEL_BUTTON_COLOR : null);
	}

	private JSpinner createBorderThicknessSpinner()
	{
		SpinnerModel model = new SpinnerNumberModel(selectedBorderThickness, 0, Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(model);
		Component editor = spinner.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(5);
		spinner.addChangeListener(ce -> selectedBorderThickness = (Integer) spinner.getValue());
		return spinner;
	}

	private JButton createBorderColorButton()
	{
		JButton colorPicker = new JButton(COLOR_TEXT);
		colorPicker.setFocusable(false);
		colorPicker.setBackground(selectedColor);
		colorPicker.addActionListener(e ->
		{
			final JFrame parent = new JFrame(COLOR_PICKER_TITLE);
			JColorChooser jColorChooser = new JColorChooser(selectedColor);
			jColorChooser.getSelectionModel().addChangeListener(e1 -> colorPicker.setBackground(jColorChooser.getColor()));

			parent.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					selectedColor = jColorChooser.getColor();
				}
			});

			parent.add(jColorChooser);
			parent.pack();
			parent.setLocationRelativeTo(null);
			parent.setVisible(true);
		});

		return colorPicker;
	}

	private JButton createFillColorButton()
	{
		JButton colorPicker = new JButton(FILL_TEXT);
		colorPicker.setFocusable(false);
		colorPicker.setBackground(selectedFillColor);
		colorPicker.addActionListener(e ->
		{
			final JFrame parent = new JFrame(COLOR_PICKER_TITLE);
			JColorChooser jColorChooser = new JColorChooser(selectedFillColor);
			jColorChooser.getSelectionModel().addChangeListener(e1 -> colorPicker.setBackground(jColorChooser.getColor()));

			parent.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					Color color = jColorChooser.getColor();
					selectedFillColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), DEFAULT_FILL_OPACITY);
				}
			});

			parent.add(jColorChooser);
			parent.pack();
			parent.setLocationRelativeTo(null);
			parent.setVisible(true);
		});

		return colorPicker;
	}
}
