/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.ui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.runelite.api.ItemID;
import net.runelite.client.plugins.droplogger.data.EventOccurrenceCollection;
import net.runelite.client.plugins.droplogger.data.LoggedItem;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.StackFormatter;

public abstract class TabPanel extends JPanel
{
	private static final int MILLISECONDS_PER_HOUR = 3600 * 1000;
	private static final NumberFormat SMALL_NUMBER_FORMATTER = DecimalFormat.getInstance(Locale.US);

	static
	{
		((DecimalFormat)SMALL_NUMBER_FORMATTER).applyPattern("#0.0");
	}

	protected DropLoggerPanel parent;

	Map<Integer, Integer> itemPriceMap;

	TabPanel(DropLoggerPanel parent, Map<Integer, Integer> itemPriceMap)
	{
		this.parent = parent;
		this.itemPriceMap = itemPriceMap;
	}

	public abstract void onLogShouldUpdate();

	private String formatPerHour(long occurences, long durationInMilliseconds)
	{
		double occurencesPerHour = (double)occurences * MILLISECONDS_PER_HOUR / durationInMilliseconds;
		return (occurencesPerHour < 100 ?
			// Use 1 decimal point when there's a small amonut of occurences
			SMALL_NUMBER_FORMATTER.format(occurencesPerHour) :
			StackFormatter.quantityToStackSize((long)occurencesPerHour));
	}

	private String getKillsPerHour(EventOccurrenceCollection event)
	{
		Instant firstInstant = event.getFirstOccurrence();
		Instant lastInstant = event.getLastOccurrence();
		long durationInMilliseconds = Duration.between(firstInstant, lastInstant).toMillis();
		if (durationInMilliseconds <= 0)
		{
			return null;
		}

		// Don't count the first kill as our time calculations only starts
		// after the first kill has already been completed
		return formatPerHour(event.getCount() - 1, durationInMilliseconds);
	}

	void updateLogIconTable(JPanel container, List<EventOccurrenceCollection> events, List<LoggedItem> drops)
	{
		container.removeAll();

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(8, 0, 0, 0);

		if (events == null || events.size() == 0 || drops == null || drops.size() == 0)
		{
			c.insets = new Insets(16, 0, 16, 0);
			String namesStr = "You have not obtained any loot yet.";
			namesStr += "<br/>This panel will update automatically";
			namesStr += "<br/>as soon as there is loot to display.";
			JLabel infoLabel = new JLabel("<html>" + namesStr + "</html>");
			container.add(infoLabel, c);
			c.gridy++;
			return;
		}

		if (events.size() < 5)
		{
			// Add up to 4 events if there aren't many of them
			for (EventOccurrenceCollection event : events)
			{
				JLabel eventLabel = new JLabel(
					StackFormatter.formatNumber(event.getCount()) +
					" x " + event.getEventName());
				container.add(eventLabel, c);
				c.gridy++;
				c.insets = new Insets(0, 0, 0, 0);

				String killsPerHour = getKillsPerHour(event);
				if (killsPerHour != null)
				{
					eventLabel.setToolTipText(killsPerHour + " per hour");
				}
			}
		}
		else
		{
			// Show the 3 most valuable events and mark the rest as "other"
			for (int i = 0; i < 3; i++)
			{
				JLabel eventLabel = new JLabel(
					StackFormatter.formatNumber(events.get(i).getCount()) +
					" x " + events.get(i).getEventName());
				container.add(eventLabel, c);
				c.gridy++;
				c.insets = new Insets(0, 0, 0, 0);

				String killsPerHour = getKillsPerHour(events.get(i));
				if (killsPerHour != null)
				{
					eventLabel.setToolTipText(killsPerHour + " per hour");
				}
			}
			int countRest = 0;
			for (int i = 3; i < events.size(); i++)
			{
				countRest += events.get(i).getCount();
			}
			JLabel otherEventLabel = new JLabel(
				StackFormatter.formatNumber(countRest) + " x Other");
			container.add(otherEventLabel, c);
			c.gridy++;
		}

		c.insets = new Insets(8, 0, 0, 0);

		JPanel iconPanel = new JPanel(new GridLayout(0, 5, 4, 4));
		iconPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		long totalValue = 0;
		for (LoggedItem loggedItem : drops)
		{
			BufferedImage itemImage = loggedItem.getImage();
			JLabel imageLabel = new JLabel(new ImageIcon(itemImage));
			String tooltip = "<html>" +
				StackFormatter.formatNumber(loggedItem.getQuantity()) +
				" x " + loggedItem.getComposition().getName();
			if (loggedItem.getPrice() != null)
			{
				if (loggedItem.getItemId() != ItemID.COINS_995)
				{
					tooltip += "<br/>GE: " + StackFormatter.quantityToStackSize(
						loggedItem.getPrice() * loggedItem.getQuantity()) + " gp";
					if (loggedItem.getQuantity() > 1)
					{
						tooltip += " (" + StackFormatter.quantityToStackSize(
							loggedItem.getPrice()) + " ea)";
					}
				}
				totalValue += loggedItem.getPrice() * loggedItem.getQuantity();
			}
			tooltip += "</html>";
			imageLabel.setToolTipText(tooltip);
			iconPanel.add(imageLabel);
		}
		container.add(iconPanel, c);
		c.gridy++;

		JLabel totalValueLabel = new JLabel("GE Value: " +
			StackFormatter.quantityToStackSize(totalValue));
		container.add(totalValueLabel, c);
		c.gridy++;
		c.insets = new Insets(0, 0, 0, 0);

		// We only count time after the first kill has already been done,
		// so the first kill should not be part of the calculation.
		int timedKills = events.stream().mapToInt(EventOccurrenceCollection::getCount).sum() - 1;
		long timedValue = Math.round((double)totalValue * timedKills / (timedKills + 1));

		Instant firstKill = events.stream()
			.min(Comparator.comparing(EventOccurrenceCollection::getFirstOccurrence))
			.map(EventOccurrenceCollection::getFirstOccurrence).orElse(null);
		Instant lastKill = events.stream()
			.max(Comparator.comparing(EventOccurrenceCollection::getLastOccurrence))
			.map(EventOccurrenceCollection::getLastOccurrence).orElse(null);
		long durationInMilliseconds = Duration.between(firstKill, lastKill).toMillis();
		if (durationInMilliseconds > 0)
		{
			String killsPerHour = formatPerHour(timedKills, durationInMilliseconds);
			JLabel killsPerHourLabel = new JLabel("Kills p/h: " + killsPerHour);
			container.add(killsPerHourLabel, c);
			c.gridy++;

			String profitPerHour = formatPerHour(timedValue, durationInMilliseconds);
			JLabel profitPerHourLabel = new JLabel("Profit p/h: " + profitPerHour + " gp");
			container.add(profitPerHourLabel, c);
			c.gridy++;
		}
	}
}