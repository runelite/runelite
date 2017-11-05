package net.runelite.mixins;

import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSGrandExchangeOffer;

@Mixin(RSGrandExchangeOffer.class)
public abstract class RSGrandExchangeOfferMixin implements RSGrandExchangeOffer
{
	@Inject
	@Override
	public GrandExchangeOfferState getState()
	{
		return GrandExchangeOfferState.progressToState(getProgress());
	}
}
