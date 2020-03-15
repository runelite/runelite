package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Arrays;
import java.util.List;

public class SanguinestiStaff extends RechargeableItem
{
	/**
	 * Get the current charges from the chat message.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your weapon has x charges.
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
	 * The Sanguinesti Staff charges up to 20000 charges.
	 * Every recharge gives 1 charge which costs 3 Blood Runes.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage()
	{
		final int maxCharges = 20000;
		final int bloodRunesPerCharge = 3;

		final int amountOfCharges = maxCharges - currentAmountOfCharges;
		final int amountOfBloodRunes = amountOfCharges * bloodRunesPerCharge;
		final String template = "%d Blood Runes needed to fully recharge.";

		return formatRechargeMessage(template, amountOfBloodRunes);
	}
}
