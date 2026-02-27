/*
 * Copyright (c) 2025, Car_role
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
package net.runelite.client.plugins.customuianchors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.overlay.OverlayAnchor;
import net.runelite.client.ui.overlay.OverlayAnchorAlignment;
import net.runelite.client.ui.overlay.OverlayAnchorConstraint;
import net.runelite.client.ui.overlay.OverlayAnchorManager;
import net.runelite.client.ui.overlay.OverlayAnchorStacking;

public class CustomUIAnchorsPanel extends PluginPanel
{
	private final OverlayAnchorManager anchorManager;
	private OverlayAnchor selectedAnchor;
	private boolean isUpdatingUI = false;

	private final JPanel anchorListPanel;
	private final JPanel propertiesPanel;

	private JTextField nameField;
	private JSpinner xSpinner;
	private JSpinner ySpinner;
	private JSpinner widthSpinner;
	private JSpinner heightSpinner;
	private JComboBox<OverlayAnchorConstraint> constraintCombo;
	private JComboBox<OverlayAnchorAlignment> alignmentCombo;
	private JComboBox<OverlayAnchorStacking> stackingCombo;

	public CustomUIAnchorsPanel(OverlayAnchorManager anchorManager)
	{
		super(false);
		this.anchorManager = anchorManager;

		// Register callback for when anchors are selected via Alt+Click
		anchorManager.setAnchorSelectedCallback(this::setSelectedAnchor);

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Header with create button
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel titleLabel = new JLabel("Custom UI Anchors");
		titleLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		headerPanel.add(titleLabel, BorderLayout.WEST);

		JButton createButton = new JButton("+ New Anchor");
		createButton.addActionListener(e -> createNewAnchor());
		headerPanel.add(createButton, BorderLayout.EAST);

		add(headerPanel, BorderLayout.NORTH);

		// Main content panel
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Anchor list
		anchorListPanel = new JPanel();
		anchorListPanel.setLayout(new GridBagLayout());
		anchorListPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		anchorListPanel.setBorder(new EmptyBorder(5, 10, 5, 10));

		JScrollPane listScrollPane = new JScrollPane(anchorListPanel);
		listScrollPane.setPreferredSize(new Dimension(0, 150));
		listScrollPane.setBorder(BorderFactory.createTitledBorder("Anchors"));
		contentPanel.add(listScrollPane, BorderLayout.NORTH);

		// Anchor settings panel (hidden until anchor is selected)
		propertiesPanel = new JPanel(new GridBagLayout());
		propertiesPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		propertiesPanel.setBorder(BorderFactory.createTitledBorder("Properties"));
		propertiesPanel.setVisible(false);

		contentPanel.add(propertiesPanel, BorderLayout.CENTER);

		add(contentPanel, BorderLayout.CENTER);

		buildPropertiesPanel();
		refreshAnchorList();
	}

	@Override
	public void onActivate()
	{
		anchorManager.setManagementModeActive(true);
		refreshAnchorList();
	}

	@Override
	public void onDeactivate()
	{
		anchorManager.setManagementModeActive(false);
	}

	private void buildPropertiesPanel()
	{
		propertiesPanel.removeAll();
		propertiesPanel.setBorder(new EmptyBorder(10, 5, 10, 5));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 5, 4, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.3;

		// Name
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setToolTipText("Display name for this anchor");
		propertiesPanel.add(nameLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		nameField = new JTextField(12);
		nameField.setToolTipText("Display name for this anchor");
		nameField.addActionListener(e -> saveChanges());
		propertiesPanel.add(nameField, c);

		// X
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel xLabel = new JLabel("X:");
		xLabel.setToolTipText("Horizontal position from left edge of game window");
		propertiesPanel.add(xLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		xSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
		xSpinner.setToolTipText("Horizontal position from left edge of game window");
		xSpinner.addChangeListener(e -> savePositionChanges());
		propertiesPanel.add(xSpinner, c);

		// Y
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel yLabel = new JLabel("Y:");
		yLabel.setToolTipText("Vertical position from top edge of game window");
		propertiesPanel.add(yLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		ySpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
		ySpinner.setToolTipText("Vertical position from top edge of game window");
		ySpinner.addChangeListener(e -> savePositionChanges());
		propertiesPanel.add(ySpinner, c);

		// Width
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel widthLabel = new JLabel("Width:");
		widthLabel.setToolTipText("Width of the anchor area in pixels");
		propertiesPanel.add(widthLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		widthSpinner = new JSpinner(new SpinnerNumberModel(200, 20, 2000, 10));
		widthSpinner.setToolTipText("Width of the anchor area in pixels");
		widthSpinner.addChangeListener(e -> savePositionChanges());
		propertiesPanel.add(widthSpinner, c);

		// Height
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setToolTipText("Height of the anchor area in pixels");
		propertiesPanel.add(heightLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		heightSpinner = new JSpinner(new SpinnerNumberModel(200, 20, 2000, 10));
		heightSpinner.setToolTipText("Height of the anchor area in pixels");
		heightSpinner.addChangeListener(e -> savePositionChanges());
		propertiesPanel.add(heightSpinner, c);

		// Constraint
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel constraintLabel = new JLabel("Constraint:");
		constraintLabel.setToolTipText("Which corner/edge the anchor stays relative to when the window resizes");
		propertiesPanel.add(constraintLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		constraintCombo = new JComboBox<>(OverlayAnchorConstraint.values());
		constraintCombo.setToolTipText("Which corner/edge the anchor stays relative to when the window resizes");
		constraintCombo.addActionListener(e -> saveChanges());
		propertiesPanel.add(constraintCombo, c);

		// Alignment
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel alignmentLabel = new JLabel("Alignment:");
		alignmentLabel.setToolTipText("Where overlays are positioned within the anchor area");
		propertiesPanel.add(alignmentLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		alignmentCombo = new JComboBox<>(OverlayAnchorAlignment.values());
		alignmentCombo.setToolTipText("Where overlays are positioned within the anchor area");
		alignmentCombo.addActionListener(e -> saveChanges());
		propertiesPanel.add(alignmentCombo, c);

		// Stacking
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0.3;
		JLabel stackingLabel = new JLabel("Stacking:");
		stackingLabel.setToolTipText("How multiple overlays are arranged: vertically, horizontally, or wrapping");
		propertiesPanel.add(stackingLabel, c);
		c.gridx = 1;
		c.weightx = 0.7;
		stackingCombo = new JComboBox<>(OverlayAnchorStacking.values());
		stackingCombo.setToolTipText("How multiple overlays are arranged: vertically, horizontally, or wrapping");
		stackingCombo.addActionListener(e -> saveChanges());
		propertiesPanel.add(stackingCombo, c);

		// Buttons with more spacing
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		c.insets = new Insets(12, 5, 4, 5);
		JButton deleteButton = new JButton("Delete Anchor");
		deleteButton.setToolTipText("Remove this anchor and release all assigned overlays");
		deleteButton.addActionListener(e -> deleteSelectedAnchor());
		propertiesPanel.add(deleteButton, c);

		c.gridy++;
		c.insets = new Insets(4, 5, 4, 5);
		JButton resetPositionButton = new JButton("Reset Position");
		resetPositionButton.setToolTipText("Center the anchor on screen");
		resetPositionButton.addActionListener(e -> resetAnchorPosition());
		propertiesPanel.add(resetPositionButton, c);

		// Add vertical filler to push content to top
		c.gridy++;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		propertiesPanel.add(new JLabel(), c);

		propertiesPanel.revalidate();
		propertiesPanel.repaint();
	}

	private void refreshAnchorList()
	{
		anchorListPanel.removeAll();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(2, 0, 2, 0);

		for (OverlayAnchor anchor : anchorManager.getAnchors())
		{
			JButton anchorButton = new JButton(anchor.getName());
			anchorButton.addActionListener(e -> setSelectedAnchor(anchor));
			if (selectedAnchor != null && selectedAnchor.getId() == anchor.getId())
			{
				anchorButton.setBackground(ColorScheme.BRAND_ORANGE);
			}
			anchorListPanel.add(anchorButton, c);
			c.gridy++;
		}

		// Filler
		c.weighty = 1.0;
		anchorListPanel.add(new JLabel(), c);

		anchorListPanel.revalidate();
		anchorListPanel.repaint();
	}

	public void setSelectedAnchor(OverlayAnchor anchor)
	{
		this.selectedAnchor = anchor;
		refreshPropertiesUI();
		refreshAnchorList();
	}

	private void refreshPropertiesUI()
	{
		isUpdatingUI = true;
		try
		{
			if (selectedAnchor == null)
			{
				// Hide properties panel when no anchor selected
				propertiesPanel.setVisible(false);
				nameField.setText("");
				xSpinner.setValue(0);
				ySpinner.setValue(0);
				widthSpinner.setValue(200);
				heightSpinner.setValue(200);
				return;
			}

			// Show properties panel when anchor is selected
			propertiesPanel.setVisible(true);
			nameField.setText(selectedAnchor.getName());
			xSpinner.setValue(selectedAnchor.getX());
			ySpinner.setValue(selectedAnchor.getY());
			widthSpinner.setValue(selectedAnchor.getWidth());
			heightSpinner.setValue(selectedAnchor.getHeight());
			constraintCombo.setSelectedItem(selectedAnchor.getConstraint());
			alignmentCombo.setSelectedItem(selectedAnchor.getAlignment());
			stackingCombo.setSelectedItem(selectedAnchor.getStacking());
		}
		finally
		{
			isUpdatingUI = false;
		}
	}

	private void saveChanges()
	{
		if (selectedAnchor == null || isUpdatingUI)
		{
			return;
		}

		// Update name and non-position properties
		selectedAnchor.setName(nameField.getText());
		selectedAnchor.setConstraint((OverlayAnchorConstraint) constraintCombo.getSelectedItem());
		selectedAnchor.setAlignment((OverlayAnchorAlignment) alignmentCombo.getSelectedItem());
		selectedAnchor.setStacking((OverlayAnchorStacking) stackingCombo.getSelectedItem());

		// Position/size changes are handled separately by the spinners' change listeners
		// We need to sync spinners with current anchor position first to avoid stale values
		// Only apply position/size if the user explicitly changed the spinner
		// (detected by checking if spinner value differs from what we last set it to)

		anchorManager.updateAnchor(selectedAnchor);
		refreshAnchorList();
	}

	/**
	 * Called when position/size spinners are changed by the user.
	 * Updates the anchor position/size directly.
	 */
	private void savePositionChanges()
	{
		if (selectedAnchor == null || isUpdatingUI)
		{
			return;
		}

		selectedAnchor.setX((Integer) xSpinner.getValue());
		selectedAnchor.setY((Integer) ySpinner.getValue());
		selectedAnchor.setWidth((Integer) widthSpinner.getValue());
		selectedAnchor.setHeight((Integer) heightSpinner.getValue());

		anchorManager.updateAnchor(selectedAnchor);
		refreshAnchorList();
	}

	private void createNewAnchor()
	{
		Dimension canvasSize = anchorManager.getCanvasSize();
		int x = 100;
		int y = 100;
		if (canvasSize != null)
		{
			x = (canvasSize.width - 200) / 2;
			y = (canvasSize.height - 200) / 2;
		}

		OverlayAnchor anchor = anchorManager.createAnchor(
			"Anchor " + (anchorManager.getAnchors().size() + 1),
			x, y, 200, 200
		);
		setSelectedAnchor(anchor);
	}

	private void deleteSelectedAnchor()
	{
		if (selectedAnchor == null)
		{
			return;
		}

		anchorManager.deleteAnchor(selectedAnchor);
		selectedAnchor = null;
		refreshPropertiesUI();
		refreshAnchorList();
	}

	private void resetAnchorPosition()
	{
		if (selectedAnchor == null)
		{
			return;
		}

		Dimension canvasSize = anchorManager.getCanvasSize();
		if (canvasSize == null)
		{
			return;
		}

		int centerX = (canvasSize.width - selectedAnchor.getWidth()) / 2;
		int centerY = (canvasSize.height - selectedAnchor.getHeight()) / 2;

		selectedAnchor.setX(centerX);
		selectedAnchor.setY(centerY);

		anchorManager.updateAnchor(selectedAnchor);
		refreshPropertiesUI();
	}
}
