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
		StringBuilder stringBuilder = new StringBuilder();
		Formatter formatter = new Formatter(stringBuilder);

		double amountToCharge = MAX_CHARGES - currentAmountOfCharges;
		double amountOfChargesPossible = Math.floor(amountToCharge / AMOUNT_OF_CHARGES_PER_CHARGE);
		double amountOfShardsNeeded = amountOfChargesPossible * AMOUNT_OF_SHARDS_PER_CHARGE;
		double newValue = currentAmountOfCharges + amountOfChargesPossible * AMOUNT_OF_CHARGES_PER_CHARGE;

		formatter.format("%d ancient shards needed to recharge without wasting shards. (charges: %d)", (int) amountOfShardsNeeded, (int) newValue);
		return stringBuilder.toString();
	}
}
