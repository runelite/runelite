package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class Arclight extends RechargeableItem
{
	private final double MAX_CHARGES = 10000;
	private final double AMOUNT_OF_CHARGES_PER_CHARGE = 1000;
	private final double AMOUNT_OF_SHARDS_PER_CHARGE = 3;
	private int currentAmountOfCharges = 0;

	/**
	 * Get the current charges from the chat message.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your arclight has x charges left.
	 *
	 * @param message Chat message containing the current amount of charges.
	 */
	@Override
	public void setupValues(String message)
	{
		final String wordToFind = "charges";
		List<String> words = Arrays.asList(message.split(" "));

		if (!words.contains(wordToFind))
		{
			return;
		}

		try
		{
			currentAmountOfCharges = Integer.parseInt(words.get(words.indexOf(wordToFind) - 1).trim());
		}
		catch (NumberFormatException e)
		{
			System.err.println(e.getMessage());
		}
	}

	@Override
	public String getRechargeMessage()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		final Formatter formatter = new Formatter(stringBuilder);

		final double amountToCharge = MAX_CHARGES - currentAmountOfCharges;
		final double amountOfChargesPossible = Math.floor(amountToCharge / AMOUNT_OF_CHARGES_PER_CHARGE);
		final double amountOfShardsNeeded = amountOfChargesPossible * AMOUNT_OF_SHARDS_PER_CHARGE;
		final double newValue = currentAmountOfCharges + amountOfChargesPossible * AMOUNT_OF_CHARGES_PER_CHARGE;

		formatter.format("%d ancient shards to recharge without wasting shards. (new value: %d/%d)", (int) amountOfShardsNeeded, (int) newValue, (int) MAX_CHARGES);
		return stringBuilder.toString();
	}
}
