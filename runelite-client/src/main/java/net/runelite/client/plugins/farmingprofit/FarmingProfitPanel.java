/*
 * Copyright (c) 2018, Mika Kuijpers <github.com/mkuijpers>
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
package net.runelite.client.plugins.farmingprofit;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

@Slf4j
class FarmingProfitPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	private final JPanel runsContainer = new JPanel();
	private final JLabel overallIcon = new JLabel();
	private final JLabel overallProfitLabel = new JLabel();
	private final JLabel overallPatchesLabel = new JLabel();
	private final JLabel overallProductsLabel = new JLabel();
	private final ItemManager itemManager;
	private int overallProfit;
	private int overallPatches;
	private int overallProducts;

	FarmingProfitPanel(ItemManager itemManager)
	{
		this.itemManager = itemManager;

		// Set panel properties
		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		// Create layout panel
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
		add(layoutPanel, BorderLayout.NORTH);

		// Create panel that will contain overall data
		JPanel overallPanel = new JPanel();
		overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());

		// Add icon and contents
		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(3, 1));
		overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
		overallProfitLabel.setFont(FontManager.getRunescapeSmallFont());
		overallPatchesLabel.setFont(FontManager.getRunescapeSmallFont());
		overallProductsLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallProfitLabel, 0);
		overallInfo.add(overallPatchesLabel, 1);
		overallInfo.add(overallProductsLabel, 2);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		// Create reset all popup menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e ->
		{
			overallProducts = 0;
			overallProfit = 0;
			overallPatches = 0;
			updateOverall();
			runsContainer.removeAll();
			runsContainer.repaint();
		});

		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create loot logs wrapper
		runsContainer.setLayout(new BoxLayout(runsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(runsContainer);

		// Update overall variables
		updateOverall();
	}

	void addRun(FarmingProfitRun run)
	{
		final FarmingProfitBox box = new FarmingProfitBox(itemManager, run);

		// Create remove run popup menu
		final JMenuItem reset = new JMenuItem("Remove run");
		reset.addActionListener(e ->
		{
			overallProfit -= run.getProfit();
			overallProducts -= run.getAmount();
			overallPatches -= 1;
			updateOverall();
			runsContainer.remove(box);
			runsContainer.repaint();
		});
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		box.setComponentPopupMenu(popupMenu);

		// Add run box to the runs container
		runsContainer.add(box, 0);
		runsContainer.repaint();

		// Update overall variables
		overallProfit += run.getProfit();
		overallProducts += run.getAmount();
		overallPatches += 1;
		updateOverall();
	}

	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	private static String htmlLabel(String key, long value)
	{
		final String valueStr = StackFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	private void updateOverall()
	{
		overallProfitLabel.setText(htmlLabel("Total profit: ", overallProfit));
		overallPatchesLabel.setText(htmlLabel("Total patches: ", overallPatches));
		overallProductsLabel.setText(htmlLabel("Total products: ", overallProducts));
	}

}
