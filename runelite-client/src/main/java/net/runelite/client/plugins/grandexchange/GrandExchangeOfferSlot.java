/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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

package net.runelite.client.plugins.grandexchange;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import static net.runelite.api.GrandExchangeOfferState.EMPTY;
import net.runelite.api.ItemComposition;
import net.runelite.client.util.StackFormatter;

@Slf4j
public class GrandExchangeOfferSlot extends JPanel
{
	private static final Color GE_INPROGRESS_ORANGE = new Color(0xd8, 0x80, 0x20).brighter();
	private static final Color GE_FINISHED_GREEN = new Color(0, 0x5f, 0);
	private static final Color GE_CANCELLED_RED = new Color(0x8f, 0, 0);

	private static final String INFO_CARD = "INFO_CARD";
	private static final String EMPTY_CARD = "EMPTY_CARD";

	private final CardLayout cardLayout = new CardLayout();
	private final JLabel itemIcon = new JLabel();
	private final TitledBorder itemName = BorderFactory.createTitledBorder("Nothing");
	private final JLabel offerState = new JLabel("Text so the label has height");
	private final JProgressBar progressBar = new JProgressBar();

	/**
	 * This (sub)panel is used for each GE slot displayed
	 * in the sidebar
	 */
	GrandExchangeOfferSlot()
	{
		buildPanel();
	}

	private void buildPanel()
	{
		setBorder(BorderFactory.createCompoundBorder(
				// Add a margin underneath each slot panel to space them out
				BorderFactory.createEmptyBorder(0, 0, 3, 0),
				itemName
		));

		// The default border color is kind of dark, so we change it to something lighter
		itemName.setBorder(BorderFactory.createLineBorder(getBackground().brighter()));

		progressBar.setStringPainted(true);

		setLayout(cardLayout);

		// Card for when the slot has an offer in it
		JPanel infoCard = new JPanel();
		add(infoCard, INFO_CARD);
		// Add padding to give the icon and progress bar room to breathe
		infoCard.setBorder(BorderFactory.createEmptyBorder(0, 2, 2, 2));

		infoCard.setLayout(new BoxLayout(infoCard, BoxLayout.X_AXIS));
		// Icon on the left
		infoCard.add(itemIcon);

		// Info on the right
		JPanel offerStatePanel = new JPanel();
		offerStatePanel.setLayout(new BoxLayout(offerStatePanel, BoxLayout.Y_AXIS));
		offerStatePanel.add(offerState);
		offerStatePanel.add(progressBar);
		infoCard.add(offerStatePanel);

		// Card for when the slot is empty
		JPanel emptySlotCard = new JPanel();
		add(emptySlotCard, EMPTY_CARD);
		// Counteract the height lost to the text at the top of the TitledBorder
		int itemNameBorderHeight = itemName.getBorderInsets(this).top;
		emptySlotCard.setBorder(BorderFactory.createEmptyBorder(0, 0, (itemNameBorderHeight - 1) / 2, 0));
		// Center the "Empty" label horizontally
		emptySlotCard.setLayout( new BoxLayout(emptySlotCard, BoxLayout.X_AXIS));
		emptySlotCard.add(Box.createHorizontalGlue());
		emptySlotCard.add(new JLabel(getNameForState(EMPTY)), BorderLayout.CENTER);
		emptySlotCard.add(Box.createHorizontalGlue());

		cardLayout.show(this, EMPTY_CARD);
	}

	void updateOffer(ItemComposition offerItem, BufferedImage itemImage, @Nullable GrandExchangeOffer newOffer)
	{
		if (newOffer == null || newOffer.getState() == EMPTY)
		{
			cardLayout.show(this, EMPTY_CARD);
			itemName.setTitle("Nothing");
		}
		else
		{
			cardLayout.show(this, INFO_CARD);

			itemName.setTitle(offerItem.getName());

			boolean shouldStack = offerItem.isStackable() || newOffer.getTotalQuantity() > 1;
			ImageIcon newItemIcon = new ImageIcon(itemImage);
			itemIcon.setIcon(newItemIcon);

			offerState.setText(getNameForState(newOffer.getState())
				+ " at "
				+ StackFormatter.formatNumber(newOffer.getState() == GrandExchangeOfferState.BOUGHT ? (newOffer.getSpent() / newOffer.getTotalQuantity()) : newOffer.getPrice())
				+ (newOffer.getTotalQuantity() > 1 ? " gp ea" : " gp"));

			progressBar.setMaximum(newOffer.getTotalQuantity());
			progressBar.setValue(newOffer.getQuantitySold());
			progressBar.setBackground(getColorForState(newOffer.getState()));
			progressBar.setString(newOffer.getQuantitySold() + "/" + newOffer.getTotalQuantity());
		}
		repaint();
	}

	private String getNameForState(GrandExchangeOfferState state)
	{
		switch (state)
		{
			case CANCELLED_BUY:
				return "Buying cancelled";
			case CANCELLED_SELL:
				return "Selling cancelled";
			case BUYING:
				return "Buying";
			case BOUGHT:
				return "Bought";
			case SELLING:
				return "Selling";
			case SOLD:
				return "Sold";
			case EMPTY:
			default:
				return "Empty";

		}
	}

	private Color getColorForState(GrandExchangeOfferState state)
	{
		switch (state)
		{
			case CANCELLED_BUY:
			case CANCELLED_SELL:
				return GE_CANCELLED_RED;
			case BUYING:
			case SELLING:
				return GE_INPROGRESS_ORANGE;
			case BOUGHT:
			case SOLD:
				return GE_FINISHED_GREEN;
			case EMPTY:
			default:
				return null;
		}
	}

}


