/*
 * Copyright (c) 2025, Khaled Ahmed
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

package net.runelite.client.plugins.bankwatcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;

class BankWatcherPanel extends PluginPanel
{
	private final BankWatcherService service;
	private final ItemManager itemManager;
	private final ClientThread clientThread;
	private JComboBox<String> filterDropdown;
	private JButton scanButton;
	private JLabel headerLabel;
	private final JPanel itemListPanel;
	private List<BankItem> currentItems;

	@Inject
	public BankWatcherPanel(BankWatcherService service, ItemManager itemManager, ClientThread clientThread)
	{
		this.service = service;
		this.itemManager = itemManager;
		this.clientThread = clientThread;


		setBorder(null);
		setLayout(new DynamicGridLayout(0, 1, 0, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setOpaque(true);


		JPanel topPanel = buildHeader();
		add(topPanel);


		itemListPanel = new JPanel(new DynamicGridLayout(0, 1, 0, 6));
		itemListPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		itemListPanel.setOpaque(true);
		add(itemListPanel);
	}


	@Override
	public void addNotify()
	{
		super.addNotify();

		JScrollPane outer = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, this);
		if (outer != null)
		{

			outer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			outer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


			outer.setBorder(null);
			outer.setBackground(ColorScheme.DARK_GRAY_COLOR);
			JViewport vp = outer.getViewport();
			if (vp != null)
			{
				vp.setBackground(ColorScheme.DARK_GRAY_COLOR);
				vp.setOpaque(true);
			}


			JPanel corner = new JPanel();
			corner.setBackground(ColorScheme.DARK_GRAY_COLOR);
			outer.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, corner);


			JScrollBar vsb = outer.getVerticalScrollBar();
			if (vsb != null)
			{
				vsb.setOpaque(true);
				vsb.setBackground(ColorScheme.DARK_GRAY_COLOR);
				vsb.setUnitIncrement(16);

				vsb.setUI(new BasicScrollBarUI()
				{
					@Override
					protected void configureScrollBarColors()
					{
						super.configureScrollBarColors();
						this.thumbColor = ColorScheme.DARKER_GRAY_COLOR;
						this.trackColor = ColorScheme.DARK_GRAY_COLOR;
					}

					@Override
					protected JButton createDecreaseButton(int orientation)
					{
						return zeroButton();
					}

					@Override
					protected JButton createIncreaseButton(int orientation)
					{
						return zeroButton();
					}

					@Override
					protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
					{
						Graphics2D g2 = (Graphics2D) g.create();
						g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						g2.setColor(ColorScheme.DARK_GRAY_COLOR);
						g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, 8, 8);
						g2.dispose();
					}

					@Override
					protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
					{
						if (thumbBounds.isEmpty() || !scrollbar.isEnabled())
						{
							return;
						}
						Graphics2D g2 = (Graphics2D) g.create();
						g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


						g2.setColor(ColorScheme.DARKER_GRAY_COLOR);
						int arc = 8;
						g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, arc, arc);
						g2.dispose();
					}

					@Override
					protected Dimension getMinimumThumbSize()
					{

						return new Dimension(6, 24);
					}

					@Override
					protected Dimension getMaximumThumbSize()
					{
						return new Dimension(6, Integer.MAX_VALUE);
					}

					private JButton zeroButton()
					{
						JButton b = new JButton();
						b.setPreferredSize(new Dimension(0, 0));
						b.setMinimumSize(new Dimension(0, 0));
						b.setMaximumSize(new Dimension(0, 0));
						b.setBorder(null);
						b.setFocusable(false);
						b.setContentAreaFilled(false);
						return b;
					}
				});

				vsb.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
			}
		}
	}

	private JPanel buildHeader()
	{
		JPanel topPanel = new JPanel(new BorderLayout(6, 0));
		topPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARKER_GRAY_COLOR));

		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 4));
		controlPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel filterLabel = new JLabel("Filter:");
		filterLabel.setForeground(Color.WHITE);

		filterDropdown = new JComboBox<>(new String[]{"All Items", "Top Movers", "Gainers", "Losers"});
		filterDropdown.setFocusable(false);
		filterDropdown.setBackground(Color.WHITE);
		filterDropdown.setForeground(Color.BLACK);

		scanButton = new JButton("Scan Bank");
		scanButton.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		scanButton.setForeground(Color.WHITE);
		scanButton.setFocusPainted(false);
		scanButton.setBorder(BorderFactory.createLineBorder(ColorScheme.SCROLL_TRACK_COLOR));

		updateScanButtonState();

		scanButton.addActionListener(e -> {
			if (!service.canScan())
			{
				JOptionPane.showMessageDialog(this, "You’ve reached the daily scan limit.\nResets at midnight.", "Daily Limit Reached", JOptionPane.INFORMATION_MESSAGE);
				updateScanButtonState();
				return;
			}

			scanButton.setText("Scanning...");
			scanButton.setEnabled(false);

			clientThread.invoke(() -> {
				refreshItems();

				SwingUtilities.invokeLater(() -> {
					scanButton.setText("Scan Bank");
					updateScanButtonState();
				});
			});
		});

		headerLabel = new JLabel("Showing All Items", SwingConstants.CENTER);
		headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 13f));
		headerLabel.setForeground(Color.WHITE);

		controlPanel.add(filterLabel);
		controlPanel.add(filterDropdown);
		controlPanel.add(scanButton);

		topPanel.add(controlPanel, BorderLayout.WEST);
		topPanel.add(headerLabel, BorderLayout.CENTER);


		filterDropdown.addActionListener(e -> applyFilter());

		return topPanel;
	}

	private void updateScanButtonState()
	{
		String statusText = service.getScanStatusText();
		scanButton.setToolTipText(statusText);

		String text = statusText.toLowerCase();
		boolean canScan = !text.contains("limit") && !text.contains("4/4");

		scanButton.setEnabled(canScan);

		if (!canScan)
		{
			scanButton.setToolTipText("Limit Reached");
			scanButton.setEnabled(false);
		}
		else
		{
			scanButton.setText("Scan Bank");
		}
	}


	private void refreshItems()
	{
		currentItems = service.scanBank();
		applyFilter();
	}

	private void applyFilter()
	{
		if (currentItems == null || currentItems.isEmpty())
		{
			itemListPanel.removeAll();
			headerLabel.setText("No items to display");
			revalidate();
			repaint();
			return;
		}

		String selected = (String) filterDropdown.getSelectedItem();
		List<BankItem> filtered = currentItems;

		switch (selected)
		{
			case "Top Movers":
				filtered = currentItems.stream().sorted((a, b) -> Integer.compare(Math.abs(b.getDelta()), Math.abs(a.getDelta()))).limit(25).collect(Collectors.toList());
				headerLabel.setText("Showing Top 25 Movers");
				break;

			case "Gainers":
				filtered = currentItems.stream().filter(i -> i.getDelta() > 0).sorted((a, b) -> Integer.compare(b.getDelta(), a.getDelta())).collect(Collectors.toList());
				headerLabel.setText("Showing Gainers");
				break;

			case "Losers":
				filtered = currentItems.stream().filter(i -> i.getDelta() < 0).sorted((a, b) -> Integer.compare(a.getDelta(), b.getDelta())).collect(Collectors.toList());
				headerLabel.setText("Showing Losers");
				break;

			default:
				headerLabel.setText("Showing All Items");
				break;
		}

		updateItemList(filtered);
	}

	private void updateItemList(List<BankItem> items)
	{
		itemListPanel.removeAll();

		for (BankItem item : items)
		{
			BufferedImage icon = itemManager.getImage(item.getId(), item.getQuantity(), false);
			BankItemPanel panel = new BankItemPanel(item, icon);
			panel.setBackground(Color.BLACK);
			itemListPanel.add(panel);
		}

		itemListPanel.revalidate();
		itemListPanel.repaint();
	}
}