package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Arrays;
import java.util.List;

public class TridentOfTheSeas extends RechargeableItem
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
	 * The Trident of the Seas charges up to 2500 charges.
	 * Every recharge gives 1 charge which costs 1 Death Rune, 1 Chaos Rune, 5 Fire Runes and 10 gp.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage()
	{
		final int MAX_CHARGES = 2500;
		final int fireRunesPerCharge = 5;
		final int gpPerCharge = 10;

		final int amountOfCharges = MAX_CHARGES - currentAmountOfCharges;
		final int amountOfFireRunes = amountOfCharges * fireRunesPerCharge;
		final int amountOfGp = amountOfCharges * gpPerCharge;
		final String template = "%1$d Death Runes, %1$d Chaos Runes, %2$d Fire Runes and %3$d gp needed to fully recharge.";

		return formatRechargeMessage(template, amountOfCharges, amountOfFireRunes, amountOfGp);
	}


}
