package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Arrays;
import java.util.List;

public class TridentOfTheSwamp extends RechargeableItem
{
	private int maxCharges;

	public TridentOfTheSwamp(int maxCharges)
	{
		this.maxCharges = maxCharges;
	}

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
	 * The Trident of the Swamp charges up to 2500 charges.
	 * Every recharge gives 1 charge which costs 1 Zulrah's Scale, 1 Death Rune, 1 Chaos Rune and 5 Fire Runes.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage()
	{
		final int fireRuneCosts = 5;

		final int amountOfCharges = maxCharges - currentAmountOfCharges;
		final int amountOfFireRunes = amountOfCharges * fireRuneCosts;
		final String template = "%1$d Zulrah's Scale, %1$d Death Runes, %1$d Chaos Runes and %2$d Fire Runes needed to fully recharge.";

		return formatRechargeMessage(template, amountOfCharges, amountOfFireRunes);
	}


}
