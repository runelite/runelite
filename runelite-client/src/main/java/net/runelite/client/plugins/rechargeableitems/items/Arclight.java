package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Arrays;
import java.util.List;

public class Arclight extends RechargeableItem
{

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

		if (words.contains(wordToFind))
		{
			currentAmountOfCharges = findCurrentChargeValue(words, wordToFind);
		}
	}

	/**
	 * The Arclight charges up to 10000 charges.
	 * Every recharge gives 1000 charges which costs 3 Ancient shards.
	 * This means that if the current amount of charges is over 9000, charging the Arclight will waste potential charges.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage()
	{
		final double maxCharges = 10000;
		final double amountOfChargesPerCharge = 1000;
		final double amountOfShardsPerCharge = 3;

		final double amountToCharge = maxCharges - currentAmountOfCharges;
		final double amountOfChargesPossible = Math.floor(amountToCharge / amountOfChargesPerCharge);
		final double amountOfShardsNeeded = amountOfChargesPossible * amountOfShardsPerCharge;
		final String template = "%d ancient shards to recharge without wasting shards.";

		return formatRechargeMessage(template, (int) amountOfShardsNeeded);
	}
}
