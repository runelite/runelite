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

package net.runelite.mixins;

import net.runelite.api.GrandExchangeOfferState;
import static net.runelite.api.GrandExchangeOfferState.BOUGHT;
import static net.runelite.api.GrandExchangeOfferState.BUYING;
import static net.runelite.api.GrandExchangeOfferState.CANCELLED_BUY;
import static net.runelite.api.GrandExchangeOfferState.CANCELLED_SELL;
import static net.runelite.api.GrandExchangeOfferState.EMPTY;
import static net.runelite.api.GrandExchangeOfferState.SELLING;
import static net.runelite.api.GrandExchangeOfferState.SOLD;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSGrandExchangeOffer;

@Mixin(RSGrandExchangeOffer.class)
public abstract class RSGrandExchangeOfferMixin implements RSGrandExchangeOffer
{

	/*
		 Internally a GrandExchangeOffer's state is represented as 4 flags
		 packed into the lower half of a byte. They are:
	*/

	//Set for sell offers, unset for buy offers
	private static final int IS_SELLING = 1 << 3; // 0b1000


	/*
	Set for offers that have finished, either because they've
	been filled, or because they were cancelled
	*/
	private static final int COMPLETED = 1 << 2; // 0b0100

	/*
	Set for offers that are actually live
	NB: Insta-buy/sell offers will be simultaneously LIVE and LOCAL
	*/
	private static final int LIVE = 1 << 1; // 0b0010

	//True for just-made, just-cancelled, completely cancelled, and completed offers
	private static final int LOCAL = 1;

	@Inject
	@Override
	public GrandExchangeOfferState getState()
	{
		byte code = getRSState();
		boolean isSelling = (code & IS_SELLING) == IS_SELLING;
		boolean isFinished = (code & COMPLETED) == COMPLETED;


		if (code == 0)
		{
			return EMPTY;
		}
		else if (isFinished && getQuantitySold() < getTotalQuantity())
		{
			return isSelling ? CANCELLED_SELL : CANCELLED_BUY;
		}
		else if (isSelling)
		{
			if (isFinished)
			{
				return SOLD;
			}
			else // if isUnfinished
			{
				return SELLING;
			}
		}
		else // if isBuying
		{
			if (isFinished)
			{
				return BOUGHT;
			}
			else // if isUnfinished
			{
				return BUYING;
			}
		}
	}
}
