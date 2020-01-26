/*
 * Copyright (c) 2019, dillydill123 <https://github.com/dillydill123>
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

package net.runelite.client.plugins.inventorysetups.ui;

import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.FlatTextField;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ImageUtil;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class InventorySetupPanel extends JPanel
{

	private static final Border NAME_BOTTOM_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
		BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR));

	private static final int H_GAP_BTN = 4;

	private static final ImageIcon BANK_FILTER_ICON;
	private static final ImageIcon BANK_FILTER_HOVER_ICON;
	private static final ImageIcon NO_BANK_FILTER_ICON;
	private static final ImageIcon NO_BANK_FILTER_HOVER_ICON;

	private static final ImageIcon HIGHLIGHT_COLOR_ICON;
	private static final ImageIcon HIGHLIGHT_COLOR_HOVER_ICON;
	private static final ImageIcon NO_HIGHLIGHT_COLOR_ICON;
	private static final ImageIcon NO_HIGHLIGHT_COLOR_HOVER_ICON;

	private static final ImageIcon TOGGLE_HIGHLIGHT_ICON;
	private static final ImageIcon TOGGLE_HIGHLIGHT_HOVER_ICON;
	private static final ImageIcon NO_TOGGLE_HIGHLIGHT_ICON;
	private static final ImageIcon NO_TOGGLE_HIGHLIGHT_HOVER_ICON;

	private static final ImageIcon UNORDERED_HIGHLIGHT_ICON;
	private static final ImageIcon UNORDERED_HIGHLIGHT_HOVER_ICON;
	private static final ImageIcon NO_UNORDERED_HIGHLIGHT_ICON;
	private static final ImageIcon NO_UNORDERED_HIGHLIGHT_HOVER_ICON;

	private static final ImageIcon STACK_DIFFERENCE_ICON;
	private static final ImageIcon STACK_DIFFERENCE_HOVER_ICON;
	private static final ImageIcon NO_STACK_DIFFERENCE_ICON;
	private static final ImageIcon NO_STACK_DIFFERENCE_HOVER_ICON;

	private static final ImageIcon VARIATION_DIFFERENCE_ICON;
	private static final ImageIcon VARIATION_DIFFERENCE_HOVER_ICON;
	private static final ImageIcon NO_VARIATION_DIFFERENCE_ICON;
	private static final ImageIcon NO_VARIATION_DIFFERENCE_HOVER_ICON;

	private static final ImageIcon VIEW_SETUP_ICON;
	private static final ImageIcon VIEW_SETUP_HOVER_ICON;

	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;

	private static final ImageIcon EXPORT_ICON;
	private static final ImageIcon EXPORT_HOVER_ICON;

	static
	{
		final BufferedImage bankFilterImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "filter_icon.png");
		final BufferedImage bankFilterHover = ImageUtil.luminanceOffset(bankFilterImg, -150);
		BANK_FILTER_ICON = new ImageIcon(bankFilterImg);
		BANK_FILTER_HOVER_ICON = new ImageIcon(bankFilterHover);

		NO_BANK_FILTER_ICON = new ImageIcon(bankFilterHover);
		NO_BANK_FILTER_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(bankFilterHover, -100));

		final BufferedImage stackImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "stack_icon.png");
		final BufferedImage stackHover = ImageUtil.luminanceOffset(stackImg, -150);
		STACK_DIFFERENCE_ICON = new ImageIcon(stackImg);
		STACK_DIFFERENCE_HOVER_ICON = new ImageIcon(stackHover);

		NO_STACK_DIFFERENCE_ICON = new ImageIcon(stackHover);
		NO_STACK_DIFFERENCE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(stackHover, -100));

		final BufferedImage variationImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "variation_icon.png");
		final BufferedImage variationHover = ImageUtil.luminanceOffset(variationImg, -150);
		VARIATION_DIFFERENCE_ICON = new ImageIcon(variationImg);
		VARIATION_DIFFERENCE_HOVER_ICON = new ImageIcon(variationHover);

		NO_VARIATION_DIFFERENCE_ICON = new ImageIcon(variationHover);
		NO_VARIATION_DIFFERENCE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(variationHover, -100));

		final BufferedImage unorderedHighlightImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "unordered_highlight_icon.png");
		final BufferedImage unorderedHighlightHover = ImageUtil.luminanceOffset(unorderedHighlightImg, -150);
		UNORDERED_HIGHLIGHT_ICON = new ImageIcon(unorderedHighlightImg);
		UNORDERED_HIGHLIGHT_HOVER_ICON = new ImageIcon(unorderedHighlightHover);

		NO_UNORDERED_HIGHLIGHT_ICON = new ImageIcon(unorderedHighlightHover);
		NO_UNORDERED_HIGHLIGHT_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(unorderedHighlightHover, -100));

		final BufferedImage highlightToggleImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "highlight_icon.png");
		final BufferedImage highlightToggleHover = ImageUtil.luminanceOffset(highlightToggleImg, -150);
		TOGGLE_HIGHLIGHT_ICON = new ImageIcon(highlightToggleImg);
		TOGGLE_HIGHLIGHT_HOVER_ICON = new ImageIcon(highlightToggleHover);

		NO_TOGGLE_HIGHLIGHT_ICON = new ImageIcon(highlightToggleHover);
		NO_TOGGLE_HIGHLIGHT_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(highlightToggleHover, -100));

		final BufferedImage highlightImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "highlight_color_icon.png");
		final BufferedImage highlightHover = ImageUtil.luminanceOffset(highlightImg, -150);
		HIGHLIGHT_COLOR_ICON = new ImageIcon(highlightImg);
		HIGHLIGHT_COLOR_HOVER_ICON = new ImageIcon(highlightHover);

		NO_HIGHLIGHT_COLOR_ICON = new ImageIcon(highlightHover);
		NO_HIGHLIGHT_COLOR_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(highlightHover, -100));

		final BufferedImage viewImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "visible_icon.png");
		final BufferedImage viewImgHover = ImageUtil.luminanceOffset(viewImg, -150);
		VIEW_SETUP_ICON = new ImageIcon(viewImg);
		VIEW_SETUP_HOVER_ICON = new ImageIcon(viewImgHover);

		final BufferedImage exportImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "export_icon.png");
		final BufferedImage exportImgHover = ImageUtil.luminanceOffset(exportImg, -150);
		EXPORT_ICON = new ImageIcon(exportImg);
		EXPORT_HOVER_ICON = new ImageIcon(exportImgHover);

		final BufferedImage deleteImg = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "delete_icon.png");
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.luminanceOffset(deleteImg, -100));
	}

	private final InventorySetupPlugin plugin;
	private final InventorySetupPluginPanel panel;
	private final InventorySetup inventorySetup;
	private final JLabel bankFilterIndicator = new JLabel();
	private final JLabel highlightColorIndicator = new JLabel();
	private final JLabel stackDifferenceIndicator = new JLabel();
	private final JLabel variationDifferenceIndicator = new JLabel();
	private final JLabel unorderedHighlightIndicator = new JLabel();
	private final JLabel highlightIndicator = new JLabel();
	private final JLabel viewSetupLabel = new JLabel();
	private final JLabel exportLabel = new JLabel();
	private final JLabel deleteLabel = new JLabel();
	private final FlatTextField nameInput = new FlatTextField();
	private final JLabel save = new JLabel("Save");
	private final JLabel cancel = new JLabel("Cancel");
	private final JLabel rename = new JLabel("Rename");

	InventorySetupPanel(InventorySetupPlugin plugin, InventorySetupPluginPanel panel, InventorySetup invSetup)
	{
		this.plugin = plugin;
		this.panel = panel;
		this.inventorySetup = invSetup;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel nameWrapper = new JPanel(new BorderLayout());
		nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameWrapper.setBorder(NAME_BOTTOM_BORDER);

		JPanel nameActions = new JPanel(new BorderLayout(3, 0));
		nameActions.setBorder(new EmptyBorder(0, 0, 0, 8));
		nameActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		save.setVisible(false);
		save.setFont(FontManager.getRunescapeSmallFont());
		save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
		save.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				inventorySetup.setName(nameInput.getText());
				plugin.updateJsonConfig();

				nameInput.setEditable(false);
				updateNameActions(false);
				requestFocusInWindow();
				panel.rebuild();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR.darker());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				save.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
			}
		});

		cancel.setVisible(false);
		cancel.setFont(FontManager.getRunescapeSmallFont());
		cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
		cancel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				nameInput.setEditable(false);
				nameInput.setText(inventorySetup.getName());
				updateNameActions(false);
				requestFocusInWindow();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR.darker());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				cancel.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
			}
		});

		rename.setFont(FontManager.getRunescapeSmallFont());
		rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
		rename.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				nameInput.setEditable(true);
				updateNameActions(true);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker().darker());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				rename.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
			}
		});

		nameActions.add(save, BorderLayout.EAST);
		nameActions.add(cancel, BorderLayout.WEST);
		nameActions.add(rename, BorderLayout.CENTER);

		nameInput.setText(inventorySetup.getName());
		nameInput.setBorder(null);
		nameInput.setEditable(false);
		nameInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameInput.setPreferredSize(new Dimension(0, 24));
		nameInput.getTextField().setForeground(Color.WHITE);
		nameInput.getTextField().setBorder(new EmptyBorder(0, 8, 0, 0));

		nameWrapper.add(nameInput, BorderLayout.CENTER);
		nameWrapper.add(nameActions, BorderLayout.EAST);

		JPanel bottomContainer = new JPanel(new BorderLayout());
		bottomContainer.setBorder(new EmptyBorder(8, 0, 8, 0));
		bottomContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		bankFilterIndicator.setToolTipText("Enable bank filtering");
		bankFilterIndicator.setIcon(inventorySetup.isFilterBank() ? BANK_FILTER_ICON : NO_BANK_FILTER_ICON);
		bankFilterIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				inventorySetup.setFilterBank(!inventorySetup.isFilterBank());
				bankFilterIndicator.setToolTipText(inventorySetup.isFilterBank() ? "Disable bank filtering" : "Enable bank filtering");
				updateBankFilterLabel();
				plugin.updateJsonConfig();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				bankFilterIndicator.setIcon(inventorySetup.isFilterBank() ? BANK_FILTER_HOVER_ICON : NO_BANK_FILTER_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				bankFilterIndicator.setIcon(inventorySetup.isFilterBank() ? BANK_FILTER_ICON : NO_BANK_FILTER_ICON);
			}
		});

		stackDifferenceIndicator.setToolTipText("Enable highlighting for stack differences");
		stackDifferenceIndicator.setIcon(inventorySetup.isStackDifference() ? STACK_DIFFERENCE_ICON : NO_STACK_DIFFERENCE_ICON);
		stackDifferenceIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				inventorySetup.setStackDifference(!inventorySetup.isStackDifference());
				stackDifferenceIndicator.setToolTipText(inventorySetup.isStackDifference() ? "Disable highlighting for stack differences" : "Enable highlighting for stack differences");
				updateStackDifferenceLabel();
				plugin.updateJsonConfig();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				stackDifferenceIndicator.setIcon(inventorySetup.isStackDifference() ? STACK_DIFFERENCE_HOVER_ICON : NO_STACK_DIFFERENCE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				stackDifferenceIndicator.setIcon(inventorySetup.isStackDifference() ? STACK_DIFFERENCE_ICON : NO_STACK_DIFFERENCE_ICON);
			}
		});

		variationDifferenceIndicator.setToolTipText("Enable highlighting for variation differences");
		variationDifferenceIndicator.setIcon(inventorySetup.isVariationDifference() ? VARIATION_DIFFERENCE_ICON : NO_VARIATION_DIFFERENCE_ICON);
		variationDifferenceIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				inventorySetup.setVariationDifference(!inventorySetup.isVariationDifference());
				variationDifferenceIndicator.setToolTipText(inventorySetup.isVariationDifference() ? "Disable highlighting for variation differences" : "Enable highlighting for variation differences");
				updateVariationDifferenceLabel();
				plugin.updateJsonConfig();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				variationDifferenceIndicator.setIcon(inventorySetup.isVariationDifference() ? VARIATION_DIFFERENCE_HOVER_ICON : NO_VARIATION_DIFFERENCE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				variationDifferenceIndicator.setIcon(inventorySetup.isVariationDifference() ? VARIATION_DIFFERENCE_ICON : NO_VARIATION_DIFFERENCE_ICON);
			}
		});

		unorderedHighlightIndicator.setToolTipText("Only highlight items that are missing from the inventory and ignore order");
		unorderedHighlightIndicator.setIcon(inventorySetup.isUnorderedHighlight() ? UNORDERED_HIGHLIGHT_ICON : NO_UNORDERED_HIGHLIGHT_ICON);
		unorderedHighlightIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				inventorySetup.setUnorderedHighlight(!inventorySetup.isUnorderedHighlight());
				unorderedHighlightIndicator.setToolTipText(inventorySetup.isUnorderedHighlight() ? "Enable default ordered highlighting" : "Only highlight items that are missing from the inventory and ignore order");
				updateUnorderedHighlightIndicator();
				plugin.updateJsonConfig();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				unorderedHighlightIndicator.setIcon(inventorySetup.isUnorderedHighlight() ? UNORDERED_HIGHLIGHT_HOVER_ICON : NO_UNORDERED_HIGHLIGHT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				unorderedHighlightIndicator.setIcon(inventorySetup.isUnorderedHighlight() ? UNORDERED_HIGHLIGHT_ICON : NO_UNORDERED_HIGHLIGHT_ICON);
			}
		});

		highlightIndicator.setToolTipText("Enable highlighting");
		highlightIndicator.setIcon(inventorySetup.isHighlightDifference() ? TOGGLE_HIGHLIGHT_ICON : NO_TOGGLE_HIGHLIGHT_ICON);
		highlightIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				inventorySetup.setHighlightDifference(!inventorySetup.isHighlightDifference());
				highlightIndicator.setToolTipText(inventorySetup.isHighlightDifference() ? "Disable highlighting" : "Enable highlighting");
				updateToggleHighlightLabel();
				updateHighlightColorLabel();
				plugin.updateJsonConfig();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				highlightIndicator.setIcon(inventorySetup.isHighlightDifference() ? TOGGLE_HIGHLIGHT_HOVER_ICON : NO_TOGGLE_HIGHLIGHT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				highlightIndicator.setIcon(inventorySetup.isHighlightDifference() ? TOGGLE_HIGHLIGHT_ICON : NO_TOGGLE_HIGHLIGHT_ICON);
			}
		});

		highlightColorIndicator.setToolTipText("Edit highlight color");
		highlightColorIndicator.setIcon(inventorySetup.isHighlightDifference() ? HIGHLIGHT_COLOR_ICON : NO_HIGHLIGHT_COLOR_ICON);
		highlightColorIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				openHighlightColorPicker();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				highlightColorIndicator.setIcon(inventorySetup.isHighlightDifference() ? HIGHLIGHT_COLOR_HOVER_ICON : NO_HIGHLIGHT_COLOR_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				highlightColorIndicator.setIcon(inventorySetup.isHighlightDifference() ? HIGHLIGHT_COLOR_ICON : NO_HIGHLIGHT_COLOR_ICON);
			}
		});

		JPanel leftActions = new JPanel(new FlowLayout(FlowLayout.LEFT, H_GAP_BTN, 0));
		leftActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		leftActions.add(bankFilterIndicator);
		leftActions.add(stackDifferenceIndicator);
		leftActions.add(variationDifferenceIndicator);
		leftActions.add(unorderedHighlightIndicator);
		leftActions.add(highlightIndicator);
		leftActions.add(highlightColorIndicator);

		viewSetupLabel.setToolTipText("View setup");
		viewSetupLabel.setIcon(VIEW_SETUP_ICON);
		viewSetupLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				panel.setCurrentInventorySetup(inventorySetup, true);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				viewSetupLabel.setIcon(VIEW_SETUP_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				viewSetupLabel.setIcon(VIEW_SETUP_ICON);
			}
		});

		exportLabel.setToolTipText("Export setup");
		exportLabel.setIcon(EXPORT_ICON);
		exportLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.exportSetup(inventorySetup);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				exportLabel.setIcon(EXPORT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				exportLabel.setIcon(EXPORT_ICON);
			}
		});

		deleteLabel.setToolTipText("Delete setup");
		deleteLabel.setIcon(DELETE_ICON);
		deleteLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.removeInventorySetup(inventorySetup);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_ICON);
			}
		});

		JPanel rightActions = new JPanel(new FlowLayout(FlowLayout.RIGHT, H_GAP_BTN, 0));
		rightActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		rightActions.add(viewSetupLabel);
		rightActions.add(exportLabel);
		rightActions.add(deleteLabel);

		bottomContainer.add(leftActions, BorderLayout.WEST);
		bottomContainer.add(rightActions, BorderLayout.EAST);

		add(nameWrapper, BorderLayout.NORTH);
		add(bottomContainer, BorderLayout.CENTER);

		updateHighlightColorLabel();
		updateStackDifferenceLabel();
		updateVariationDifferenceLabel();
		updateToggleHighlightLabel();

	}

	private void updateNameActions(boolean saveAndCancel)
	{
		save.setVisible(saveAndCancel);
		cancel.setVisible(saveAndCancel);
		rename.setVisible(!saveAndCancel);

		if (saveAndCancel)
		{
			nameInput.getTextField().requestFocusInWindow();
			nameInput.getTextField().selectAll();
		}
	}

	private void updateHighlightColorLabel()
	{
		Color color = inventorySetup.getHighlightColor();
		highlightColorIndicator.setBorder(new MatteBorder(0, 0, 3, 0, color));
		highlightColorIndicator.setIcon(inventorySetup.isHighlightDifference() ? HIGHLIGHT_COLOR_ICON : NO_HIGHLIGHT_COLOR_ICON);
	}

	private void updateBankFilterLabel()
	{
		bankFilterIndicator.setIcon(inventorySetup.isFilterBank() ? BANK_FILTER_ICON : NO_BANK_FILTER_ICON);
	}

	private void updateStackDifferenceLabel()
	{
		stackDifferenceIndicator.setIcon(inventorySetup.isStackDifference() ? STACK_DIFFERENCE_ICON : NO_STACK_DIFFERENCE_ICON);
	}

	private void updateVariationDifferenceLabel()
	{
		variationDifferenceIndicator.setIcon(inventorySetup.isVariationDifference() ? VARIATION_DIFFERENCE_ICON : NO_VARIATION_DIFFERENCE_ICON);
	}

	private void updateUnorderedHighlightIndicator()
	{
		unorderedHighlightIndicator.setIcon(inventorySetup.isUnorderedHighlight() ? UNORDERED_HIGHLIGHT_ICON : NO_UNORDERED_HIGHLIGHT_ICON);
	}

	private void updateToggleHighlightLabel()
	{
		highlightIndicator.setIcon(inventorySetup.isHighlightDifference() ? TOGGLE_HIGHLIGHT_ICON : NO_TOGGLE_HIGHLIGHT_ICON);
	}

	private void openHighlightColorPicker()
	{

		RuneliteColorPicker colorPicker = plugin.getColorPickerManager().create(
			SwingUtilities.windowForComponent(this),
			inventorySetup.getHighlightColor(),
			inventorySetup.getName(),
			false);

		colorPicker.setLocation(getLocationOnScreen());
		colorPicker.setOnColorChange(c ->
		{
			inventorySetup.setHighlightColor(c);
			updateHighlightColorLabel();
		});

		colorPicker.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				plugin.updateJsonConfig();
			}
		});

		colorPicker.setVisible(true);
	}
}
