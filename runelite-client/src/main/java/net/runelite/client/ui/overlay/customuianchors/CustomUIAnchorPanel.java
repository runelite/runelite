/*
 * Copyright (c) 2024, Car_role
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
package net.runelite.client.ui.overlay.customuianchors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

/**
 * Side panel UI for managing custom UI anchors.
 */
public class CustomUIAnchorPanel extends PluginPanel
{
	private final CustomUIAnchorManager customUIAnchorManager;
	private final DefaultListModel<CustomUIAnchor> listModel = new DefaultListModel<>();
	private final JList<CustomUIAnchor> anchorList;

	private final JPanel propertiesPanel;
	private final JTextField nameField;
	private final JSpinner xSpinner;
	private final JSpinner ySpinner;
	private final JSpinner widthSpinner;
	private final JSpinner heightSpinner;
	private final JComboBox<AnchorConstraint> constraintComboBox;
	private final JComboBox<AnchorAlignment> alignmentComboBox;
	private final JComboBox<AnchorStacking> stackingComboBox;

	private CustomUIAnchor selectedAnchor;
	private boolean isUpdating = false;

	public CustomUIAnchorPanel(CustomUIAnchorManager customUIAnchorManager)
	{
		super();
		this.customUIAnchorManager = customUIAnchorManager;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel listContainer = new JPanel(new BorderLayout());
		listContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		listContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel topControlPanel = new JPanel(new BorderLayout());
		topControlPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel titleLabel = new JLabel("Custom UI Anchors");
		titleLabel.setForeground(Color.WHITE);
		topControlPanel.add(titleLabel, BorderLayout.WEST);

		listContainer.add(topControlPanel, BorderLayout.NORTH);

		anchorList = new JList<>(listModel);
		anchorList.setCellRenderer(new CustomUIAnchorListRenderer());
		anchorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		anchorList.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		anchorList.addListSelectionListener(e ->
		{
			if (!e.getValueIsAdjusting() && !isUpdating)
			{
				setSelectedAnchor(anchorList.getSelectedValue());
			}
		});

		JScrollPane scrollPane = new JScrollPane(anchorList);
		scrollPane.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		scrollPane.setPreferredSize(new Dimension(0, 150));
		listContainer.add(scrollPane, BorderLayout.CENTER);

		JButton addButton = new JButton("Add New Anchor");
		addButton.addActionListener(e ->
		{
			CustomUIAnchor anchor = customUIAnchorManager.createAnchor();
			updateList();
			setSelectedAnchor(anchor);
		});

		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		btnPanel.add(addButton);
		listContainer.add(btnPanel, BorderLayout.SOUTH);

		add(listContainer, BorderLayout.NORTH);

		propertiesPanel = new JPanel();
		propertiesPanel.setLayout(new GridBagLayout());
		propertiesPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		propertiesPanel.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(ColorScheme.MEDIUM_GRAY_COLOR),
			"Properties",
			javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
			javax.swing.border.TitledBorder.DEFAULT_POSITION,
			null,
			Color.WHITE));
		propertiesPanel.setVisible(false);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		propertiesPanel.add(createLabel("Name:"), c);
		c.gridy++;
		nameField = new JTextField();
		nameField.addActionListener(e -> saveChanges());
		nameField.addFocusListener(new java.awt.event.FocusAdapter()
		{
			@Override
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				saveChanges();
			}
		});
		propertiesPanel.add(nameField, c);

		c.gridy++;
		propertiesPanel.add(createLabel("Constraint:"), c);
		c.gridy++;
		constraintComboBox = new JComboBox<>(AnchorConstraint.values());
		constraintComboBox.setToolTipText("Which corner of the game window this anchor attaches to");
		constraintComboBox.addActionListener(e -> saveChanges());
		propertiesPanel.add(constraintComboBox, c);

		c.gridy++;
		propertiesPanel.add(createLabel("Alignment:"), c);
		c.gridy++;
		alignmentComboBox = new JComboBox<>(AnchorAlignment.values());
		alignmentComboBox.setToolTipText("Position of overlays inside this anchor");
		alignmentComboBox.addActionListener(e -> saveChanges());
		propertiesPanel.add(alignmentComboBox, c);

		c.gridy++;
		propertiesPanel.add(createLabel("Stacking:"), c);
		c.gridy++;
		stackingComboBox = new JComboBox<>(AnchorStacking.values());
		stackingComboBox.setToolTipText("How multiple overlays are arranged (e.g. Vertical/Horizontal/Flow)");
		stackingComboBox.addActionListener(e -> saveChanges());
		propertiesPanel.add(stackingComboBox, c);

		c.gridy++;
		JPanel posPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		posPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		xSpinner = createSpinner();
		xSpinner.setToolTipText("Horizontal offset from constraint anchor");
		ySpinner = createSpinner();
		ySpinner.setToolTipText("Vertical offset from constraint anchor");
		posPanel.add(createLabel("X: "));
		posPanel.add(xSpinner);
		posPanel.add(createLabel("  Y: "));
		posPanel.add(ySpinner);
		propertiesPanel.add(posPanel, c);

		c.gridy++;
		JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		sizePanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		widthSpinner = createSpinner();
		widthSpinner.setToolTipText("Width of the anchor");
		heightSpinner = createSpinner();
		heightSpinner.setToolTipText("Height of the anchor");
		sizePanel.add(createLabel("W: "));
		sizePanel.add(widthSpinner);
		sizePanel.add(createLabel("  H: "));
		sizePanel.add(heightSpinner);
		propertiesPanel.add(sizePanel, c);

		c.gridy++;
		JButton deleteButton = new JButton("Delete Anchor");
		deleteButton.setBackground(Color.RED.darker());
		deleteButton.setForeground(Color.WHITE);
		deleteButton.addActionListener(e -> deleteSelectedAnchor());
		propertiesPanel.add(deleteButton, c);

		c.gridy++;
		JButton resetPositionButton = new JButton("Reset Position");
		resetPositionButton.setToolTipText("Center the anchor on screen");
		resetPositionButton.addActionListener(e -> resetAnchorPosition());
		propertiesPanel.add(resetPositionButton, c);

		add(propertiesPanel, BorderLayout.CENTER);

		updateList();
	}

	private JLabel createLabel(String text)
	{
		JLabel label = new JLabel(text);
		label.setForeground(Color.WHITE);
		return label;
	}

	private JSpinner createSpinner()
	{
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, -10000, 10000, 1));
		spinner.setPreferredSize(new Dimension(85, 25));
		spinner.addChangeListener(e -> saveChanges());
		return spinner;
	}

	public void updateList()
	{
		isUpdating = true;
		CustomUIAnchor currentlySelected = selectedAnchor;

		listModel.clear();
		List<CustomUIAnchor> anchors = customUIAnchorManager.getAnchors();
		for (CustomUIAnchor a : anchors)
		{
			listModel.addElement(a);
		}

		if (currentlySelected != null)
		{
			for (int i = 0; i < listModel.size(); i++)
			{
				if (listModel.get(i).getId() == currentlySelected.getId())
				{
					anchorList.setSelectedIndex(i);
					selectedAnchor = listModel.get(i);
					break;
				}
			}
		}

		isUpdating = false;
		refreshPropertiesUI();
	}

	public void setSelectedAnchor(CustomUIAnchor anchor)
	{
		if (isUpdating)
		{
			return;
		}

		this.selectedAnchor = anchor;

		if (anchor != null)
		{
			anchorList.setSelectedValue(anchor, true);
		}
		else
		{
			anchorList.clearSelection();
		}

		refreshPropertiesUI();
	}

	private void refreshPropertiesUI()
	{
		if (selectedAnchor == null)
		{
			propertiesPanel.setVisible(false);
			return;
		}

		isUpdating = true;
		nameField.setText(selectedAnchor.getName());
		xSpinner.setValue(selectedAnchor.getX());
		ySpinner.setValue(selectedAnchor.getY());
		widthSpinner.setValue(selectedAnchor.getWidth());
		heightSpinner.setValue(selectedAnchor.getHeight());
		constraintComboBox.setSelectedItem(selectedAnchor.getConstraint());
		alignmentComboBox.setSelectedItem(
			selectedAnchor.getAlignment() != null ? selectedAnchor.getAlignment() : AnchorAlignment.CENTER);
		stackingComboBox.setSelectedItem(
			selectedAnchor.getStacking() != null ? selectedAnchor.getStacking() : AnchorStacking.VERTICAL);
		isUpdating = false;

		propertiesPanel.setVisible(true);
		revalidate();
		repaint();
	}

	private void saveChanges()
	{
		if (selectedAnchor == null || isUpdating)
		{
			return;
		}

		selectedAnchor.setName(nameField.getText());
		selectedAnchor.setX((Integer) xSpinner.getValue());
		selectedAnchor.setY((Integer) ySpinner.getValue());
		selectedAnchor.setWidth((Integer) widthSpinner.getValue());
		selectedAnchor.setHeight((Integer) heightSpinner.getValue());
		selectedAnchor.setConstraint((AnchorConstraint) constraintComboBox.getSelectedItem());
		selectedAnchor.setAlignment((AnchorAlignment) alignmentComboBox.getSelectedItem());
		selectedAnchor.setStacking((AnchorStacking) stackingComboBox.getSelectedItem());

		customUIAnchorManager.updateAnchor(selectedAnchor);
		anchorList.repaint();
	}

	private void deleteSelectedAnchor()
	{
		if (selectedAnchor != null)
		{
			customUIAnchorManager.deleteAnchor(selectedAnchor);
			setSelectedAnchor(null);
			updateList();
		}
	}

	private void resetAnchorPosition()
	{
		if (selectedAnchor == null)
		{
			return;
		}

		// Get canvas center from manager
		Dimension canvasSize = customUIAnchorManager.getCanvasSize();
		if (canvasSize == null)
		{
			return;
		}

		// Center the anchor on screen
		int centerX = (canvasSize.width - selectedAnchor.getWidth()) / 2;
		int centerY = (canvasSize.height - selectedAnchor.getHeight()) / 2;

		selectedAnchor.setX(centerX);
		selectedAnchor.setY(centerY);

		customUIAnchorManager.updateAnchor(selectedAnchor);
		refreshPropertiesUI();
	}

	private static class CustomUIAnchorListRenderer extends JLabel implements ListCellRenderer<CustomUIAnchor>
	{
		public CustomUIAnchorListRenderer()
		{
			setOpaque(true);
			setBorder(new EmptyBorder(5, 10, 5, 10));
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends CustomUIAnchor> list, CustomUIAnchor value,
			int index, boolean isSelected, boolean cellHasFocus)
		{
			setText(value.getName() + " (ID: " + value.getId() + ")");

			if (isSelected)
			{
				setBackground(ColorScheme.BRAND_ORANGE);
				setForeground(Color.BLACK);
			}
			else
			{
				setBackground(ColorScheme.DARKER_GRAY_COLOR);
				setForeground(Color.WHITE);
			}
			return this;
		}
	}
}
