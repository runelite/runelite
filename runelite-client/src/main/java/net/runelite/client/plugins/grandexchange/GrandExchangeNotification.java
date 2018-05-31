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

import java.time.Instant;
import lombok.Value;
import net.runelite.api.GrandExchangeOfferState;

@Value
class GrandExchangeNotification
{
	private final int slot;
	private final int quantitySold;
	private final int totalQuantity;
	private final String itemName;
	private final GrandExchangeOfferState state;
	private final Instant insertedOn = Instant.now();

	String getNotificationMessage()
	{
		// Send complete or X/Y notification
		switch (this.state)
		{
			case BUYING:
				return String.format("Grand Exchange: Bought %d / %d x %s", quantitySold, totalQuantity, itemName);

			case SELLING:
				return String.format("Grand Exchange: Sold %d / %d x %s", quantitySold, totalQuantity, itemName);

			case BOUGHT:
				return String.format("Grand Exchange: Finished buying %d x %s", totalQuantity, itemName);

			case SOLD:
				return String.format("Grand Exchange: Finished selling %d x %s", totalQuantity, itemName);

			default:
				// Not possible
				return null;
		}
	}
}
