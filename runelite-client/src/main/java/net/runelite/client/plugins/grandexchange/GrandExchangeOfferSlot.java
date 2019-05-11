/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
<<<<<<< HEAD
=======
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
>>>>>>> upstream/master
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
<<<<<<< HEAD
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
=======
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import static net.runelite.api.GrandExchangeOfferState.CANCELLED_BUY;
import static net.runelite.api.GrandExchangeOfferState.CANCELLED_SELL;
import static net.runelite.api.GrandExchangeOfferState.EMPTY;
import net.runelite.api.ItemComposition;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ThinProgressBar;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.StackFormatter;
<<<<<<< HEAD
import net.runelite.client.util.SwingUtil;
>>>>>>> upstream/master
=======
>>>>>>> upstream/master

public class GrandExchangeOfferSlot extends JPanel
{
<<<<<<< HEAD
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
=======
	private static final String FACE_CARD = "FACE_CARD";
	private static final String DETAILS_CARD = "DETAILS_CARD";

	private static final ImageIcon RIGHT_ARROW_ICON;
	private static final ImageIcon LEFT_ARROW_ICON;

	private final JPanel container = new JPanel();
	private final CardLayout cardLayout = new CardLayout();

	private final JLabel itemIcon = new JLabel();
	private final JLabel itemName = new JLabel();
	private final JLabel offerInfo = new JLabel();

	private final JLabel itemPrice = new JLabel();
	private final JLabel offerSpent = new JLabel();

	private final ThinProgressBar progressBar = new ThinProgressBar();

	private boolean showingFace = true;

	static
	{
		final BufferedImage rightArrow = ImageUtil.alphaOffset(ImageUtil.getResourceStreamFromClass(GrandExchangeOfferSlot.class, "/util/arrow_right.png"), 0.25f);
		RIGHT_ARROW_ICON = new ImageIcon(rightArrow);
		LEFT_ARROW_ICON	= new ImageIcon(ImageUtil.flipImage(rightArrow, true, false));
	}
>>>>>>> upstream/master

	/**
	 * This (sub)panel is used for each GE slot displayed
	 * in the sidebar
	 */
	GrandExchangeOfferSlot()
	{
<<<<<<< HEAD
		buildPanel();
	}

	private void buildPanel()
	{
<<<<<<< HEAD
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

=======
=======
>>>>>>> upstream/master
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(7, 0, 0, 0));

		final MouseListener ml = new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				super.mousePressed(mouseEvent);
				switchPanel();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				super.mouseEntered(mouseEvent);
				container.setBackground(ColorScheme.DARKER_GRAY_HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				super.mouseExited(mouseEvent);
				container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			}
		};

		container.setLayout(cardLayout);
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel faceCard = new JPanel();
		faceCard.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		faceCard.setLayout(new BorderLayout());
		faceCard.addMouseListener(ml);

		itemIcon.setVerticalAlignment(JLabel.CENTER);
		itemIcon.setHorizontalAlignment(JLabel.CENTER);
		itemIcon.setPreferredSize(new Dimension(45, 45));

		itemName.setForeground(Color.WHITE);
		itemName.setVerticalAlignment(JLabel.BOTTOM);
		itemName.setFont(FontManager.getRunescapeSmallFont());

		offerInfo.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		offerInfo.setVerticalAlignment(JLabel.TOP);
		offerInfo.setFont(FontManager.getRunescapeSmallFont());

		JLabel switchFaceViewIcon = new JLabel();
		switchFaceViewIcon.setIcon(RIGHT_ARROW_ICON);
		switchFaceViewIcon.setVerticalAlignment(JLabel.CENTER);
		switchFaceViewIcon.setHorizontalAlignment(JLabel.CENTER);
		switchFaceViewIcon.setPreferredSize(new Dimension(30, 45));

		JPanel offerFaceDetails = new JPanel();
		offerFaceDetails.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		offerFaceDetails.setLayout(new GridLayout(2, 1, 0, 2));

		offerFaceDetails.add(itemName);
		offerFaceDetails.add(offerInfo);

		faceCard.add(offerFaceDetails, BorderLayout.CENTER);
		faceCard.add(itemIcon, BorderLayout.WEST);
		faceCard.add(switchFaceViewIcon, BorderLayout.EAST);

		JPanel detailsCard = new JPanel();
		detailsCard.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		detailsCard.setLayout(new BorderLayout());
		detailsCard.setBorder(new EmptyBorder(0, 15, 0, 0));
		detailsCard.addMouseListener(ml);

		itemPrice.setForeground(Color.WHITE);
		itemPrice.setVerticalAlignment(JLabel.BOTTOM);
		itemPrice.setFont(FontManager.getRunescapeSmallFont());

		offerSpent.setForeground(Color.WHITE);
		offerSpent.setVerticalAlignment(JLabel.TOP);
		offerSpent.setFont(FontManager.getRunescapeSmallFont());

		JLabel switchDetailsViewIcon = new JLabel();
		switchDetailsViewIcon.setIcon(LEFT_ARROW_ICON);
		switchDetailsViewIcon.setVerticalAlignment(JLabel.CENTER);
		switchDetailsViewIcon.setHorizontalAlignment(JLabel.CENTER);
		switchDetailsViewIcon.setPreferredSize(new Dimension(30, 45));

		JPanel offerDetails = new JPanel();
		offerDetails.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		offerDetails.setLayout(new GridLayout(2, 1));

		offerDetails.add(itemPrice);
		offerDetails.add(offerSpent);

		detailsCard.add(offerDetails, BorderLayout.CENTER);
		detailsCard.add(switchDetailsViewIcon, BorderLayout.EAST);

		container.add(faceCard, FACE_CARD);
		container.add(detailsCard, DETAILS_CARD);

		cardLayout.show(container, FACE_CARD);

		add(container, BorderLayout.CENTER);
		add(progressBar, BorderLayout.SOUTH);
	}
<<<<<<< HEAD
	
>>>>>>> upstream/master
=======

>>>>>>> upstream/master
	void updateOffer(ItemComposition offerItem, BufferedImage itemImage, @Nullable GrandExchangeOffer newOffer)
	{
		if (newOffer == null || newOffer.getState() == EMPTY)
		{
<<<<<<< HEAD
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

=======
			return;
		}
		else
		{
			cardLayout.show(container, FACE_CARD);

			itemName.setText(offerItem.getName());
			itemIcon.setIcon(new ImageIcon(itemImage));

			boolean buying = newOffer.getState() == GrandExchangeOfferState.BOUGHT
				|| newOffer.getState() == GrandExchangeOfferState.BUYING
				|| newOffer.getState() == GrandExchangeOfferState.CANCELLED_BUY;

			String offerState = (buying ? "Bought " : "Sold ")
				+ StackFormatter.quantityToRSDecimalStack(newOffer.getQuantitySold()) + " / "
				+ StackFormatter.quantityToRSDecimalStack(newOffer.getTotalQuantity());

			offerInfo.setText(offerState);

			itemPrice.setText(htmlLabel("Price each: ", StackFormatter.formatNumber(newOffer.getPrice())));

			String action = buying ? "Spent: " : "Received: ";

			offerSpent.setText(htmlLabel(action, StackFormatter.formatNumber(newOffer.getSpent()) + " / "
				+ StackFormatter.formatNumber(newOffer.getPrice() * newOffer.getTotalQuantity())));

			progressBar.setForeground(getProgressColor(newOffer));
			progressBar.setMaximumValue(newOffer.getTotalQuantity());
			progressBar.setValue(newOffer.getQuantitySold());

			/* Couldn't set the tooltip for the container panel as the children override it, so I'm setting
			 * the tooltips on the children instead. */
			for (Component c : container.getComponents())
			{
				if (c instanceof JPanel)
				{
					JPanel panel = (JPanel) c;
					panel.setToolTipText(htmlTooltip(((int) progressBar.getPercentage()) + "%"));
				}
			}
		}

		revalidate();
		repaint();
	}

	private String htmlTooltip(String value)
	{
		return "<html><body style = 'color:" + ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR) + "'>Progress: <span style = 'color:white'>" + value + "</span></body></html>";
	}

	private String htmlLabel(String key, String value)
	{
		return "<html><body style = 'color:white'>" + key + "<span style = 'color:" + ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR) + "'>" + value + "</span></body></html>";
	}

	private void switchPanel()
	{
		this.showingFace = !this.showingFace;
		cardLayout.show(container, showingFace ? FACE_CARD : DETAILS_CARD);
	}

	private Color getProgressColor(GrandExchangeOffer offer)
	{
		if (offer.getState() == CANCELLED_BUY || offer.getState() == CANCELLED_SELL)
		{
			return ColorScheme.PROGRESS_ERROR_COLOR;
		}

		if (offer.getQuantitySold() == offer.getTotalQuantity())
		{
			return ColorScheme.PROGRESS_COMPLETE_COLOR;
		}

		return ColorScheme.PROGRESS_INPROGRESS_COLOR;
	}
}
>>>>>>> upstream/master

