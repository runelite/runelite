package net.runelite.api;

import java.util.Arrays;

/**
 * Describes the state of a Grand Exchange offer
 */
public enum GrandExchangeOfferState
{
	/**
	 * An empty slot.
	 */
	EMPTY(-1),
	/**
	 * A buy offer that is currently in progress.
	 */
	BUYING(2),
	/**
	 * A buy offer that has completed.
	 */
	BOUGHT(5),
	/**
	 * A sell offer that is currently in progress.
	 */
	SELLING(10),
	/**
	 * A sell offer that has completed.
	 */
	SOLD(13);

	private final int code;

	GrandExchangeOfferState(int code)
	{
		this.code = code;
	}

	/**
	 * The offer code given by #getProgress();
	 * @return
	 */
	private int getCode()
	{
		return code;
	}

	/**
	 * Returns the OfferState instance associated with the given code.
	 *
	 * @param code The code to search for
	 * @return The respective OfferState instance
	 */
	public static GrandExchangeOfferState progressToState(byte code)
	{
		return Arrays.stream(values())
			.filter(offerState -> offerState.getCode() == code)
			.findFirst()
			.orElse(EMPTY);
	}
}