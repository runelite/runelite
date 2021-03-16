/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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
package net.runelite.client.plugins.grandexchange;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.ItemComposition;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.PluginErrorPanel;

class GrandExchangeOffersPanel extends JPanel
{
	private static final String ERROR_PANEL = "ERROR_PANEL";
	private static final String OFFERS_PANEL = "OFFERS_PANEL";

	private static final int MAX_OFFERS = 8;

	private final GrandExchangePlugin grandExchangePlugin;

	private final GridBagConstraints constraints = new GridBagConstraints();
	private final CardLayout cardLayout = new CardLayout();

	/*  The offers container, this will hold all the individual ge offers panels */
	private final JPanel offerPanel = new JPanel();

	/*  The center panel, this holds either the error panel or the offers container */
	private final JPanel container = new JPanel(cardLayout);

	private final GrandExchangeOfferSlot[] offerSlotPanels = new GrandExchangeOfferSlot[MAX_OFFERS];

	@Inject
	private GrandExchangeOffersPanel(final GrandExchangePlugin grandExchangePlugin)
	{
		this.grandExchangePlugin = grandExchangePlugin;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		/* This panel wraps the offers panel and limits its height */
		JPanel offersWrapper = new JPanel(new BorderLayout());
		offersWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		offersWrapper.add(offerPanel, BorderLayout.NORTH);

		offerPanel.setLayout(new GridBagLayout());
		offerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		offerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		/* This panel wraps the error panel and limits its height */
		JPanel errorWrapper = new JPanel(new BorderLayout());
		errorWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		/*  The error panel, this displays an error message */
		PluginErrorPanel errorPanel = new PluginErrorPanel();
		errorWrapper.add(errorPanel, BorderLayout.NORTH);

		errorPanel.setBorder(new EmptyBorder(50, 20, 20, 20));
		errorPanel.setContent("No offers detected", "No grand exchange offers were found on your account.");

		container.add(offersWrapper, OFFERS_PANEL);
		container.add(errorWrapper, ERROR_PANEL);

		add(container, BorderLayout.CENTER);

		resetOffers();
	}

	void resetOffers()
	{
		offerPanel.removeAll();
		Arrays.fill(offerSlotPanels, null);
		updateEmptyOffersPanel();
	}

	void updateOffer(ItemComposition item, BufferedImage itemImage, GrandExchangeOffer newOffer, int slot)
	{
		/* If slot was previously filled, and is now empty, remove it from the list */
		if (newOffer == null || newOffer.getState() == GrandExchangeOfferState.EMPTY)
		{
			if (offerSlotPanels[slot] != null)
			{
				offerPanel.remove(offerSlotPanels[slot]);
				offerSlotPanels[slot] = null;
				revalidate();
				repaint();
			}

			removeTopMargin();
			updateEmptyOffersPanel();
			return;
		}

		/* If slot was empty, and is now filled, add it to the list */
		GrandExchangeOfferSlot offerSlot = offerSlotPanels[slot];
		if (offerSlot == null)
		{
			offerSlot = new GrandExchangeOfferSlot(grandExchangePlugin);
			offerSlotPanels[slot] = offerSlot;
			offerPanel.add(offerSlot, constraints);
			constraints.gridy++;
		}

		offerSlot.updateOffer(item, itemImage, newOffer);

		removeTopMargin();

		revalidate();
		repaint();

		updateEmptyOffersPanel();
	}

	/**
	 * Reset the border for the first offer slot.
	 */
	private void removeTopMargin()
	{

		if (offerPanel.getComponentCount() <= 0)
		{
			return;
		}

		JPanel firstItem = (JPanel) offerPanel.getComponent(0);
		firstItem.setBorder(null);
	}

	/**
	 * This method calculates the amount of empty ge offer slots, if all slots are empty,
	 * it shows the error panel.
	 */
	private void updateEmptyOffersPanel()
	{
		int nullCount = 0;
		for (GrandExchangeOfferSlot slot : offerSlotPanels)
		{
			if (slot == null)
			{
				nullCount++;
			}
		}

		if (nullCount == MAX_OFFERS)
		{
			offerPanel.removeAll();
			cardLayout.show(container, ERROR_PANEL);
		}
		else
		{
			cardLayout.show(container, OFFERS_PANEL);
		}

	}
}
