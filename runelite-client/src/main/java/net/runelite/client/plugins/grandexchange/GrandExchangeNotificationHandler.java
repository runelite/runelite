/*
 * Copyright (c) 2018, Ethan <https://github.com/shmeeps>
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

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.ItemComposition;

@Singleton
class GrandExchangeNotificationHandler
{
	@Inject
	private GrandExchangeConfig config;

	private final LinkedList<GrandExchangeNotification> notificationQueue = new LinkedList<>();

	private Instant lastNotificationSent = Instant.now();

	void queueNotification(int slot, ItemComposition offerItem, GrandExchangeOffer newOffer)
	{
		// Get offer data
		int itemId = offerItem.getId();
		int quantitySold = newOffer.getQuantitySold();
		int totalQuantity = newOffer.getTotalQuantity();
		String itemName = offerItem.getName();

		// Ignore empty/cancelled offers, or those with invalid data
		if (newOffer.getState() == GrandExchangeOfferState.EMPTY ||
			newOffer.getState() == GrandExchangeOfferState.CANCELLED_BUY ||
			newOffer.getState() == GrandExchangeOfferState.CANCELLED_SELL ||
			quantitySold == 0 || itemId == 0 || itemId == -1)
		{
			return;
		}

		// Inspect the queue for an existing notification from the same offer slot
		for (GrandExchangeNotification existingNotification : notificationQueue)
		{
			if (existingNotification.getSlot() == slot)
			{
				// Don't replace a "finished" notification with a "in-progress" one
				if (existingNotification.getState() == GrandExchangeOfferState.BOUGHT ||
					existingNotification.getState() == GrandExchangeOfferState.SOLD)
				{
					return;
				}

				// Remove the "in-progress" notification so we can replace it with a "finished" one
				notificationQueue.remove(existingNotification);
				break;
			}
		}

		// If not, just add a new notification to the queue
		notificationQueue.add(new GrandExchangeNotification(slot, quantitySold, totalQuantity, itemName, newOffer.getState()));
	}

	boolean canSendNotification()
	{
		// Can't send a notification if none are in the queue
		if (notificationQueue.isEmpty())
		{
			return false;
		}

		// Make sure we aren't sending notifications too quickly
		long timeSinceLastNotification = Duration.between(this.lastNotificationSent, Instant.now()).toMillis();
		boolean canSendNotification = timeSinceLastNotification > (this.config.notificationDelay() * 1000);

		// Make sure the next notification has been given time to update to a complete status if it instantly bought/sold
		boolean notificationAvailable = Duration.between(notificationQueue.peek().getInsertedOn(), Instant.now()).toMillis() > 600;
		return canSendNotification && notificationAvailable;
	}

	String getNextNotification()
	{
		// Reset the notification timer
		this.lastNotificationSent = Instant.now();

		// Get the next notification, remove it from the queue
		GrandExchangeNotification nextNotification = notificationQueue.pop();

		// Return the notification
		return nextNotification.getNotificationMessage();
	}
}
