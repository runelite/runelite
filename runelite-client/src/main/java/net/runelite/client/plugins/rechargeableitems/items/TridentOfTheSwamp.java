package net.runelite.client.plugins.rechargeableitems.items;

public class TridentOfTheSwamp extends RechargeableItem
{
	private int maxCharges;

	public TridentOfTheSwamp(int maxCharges)
	{
		this.maxCharges = maxCharges;
	}

	/**
	 * The Trident of the Swamp charges up to 2500 or 20000 charges.
	 * Every recharge gives 1 charge which costs 1 Zulrah's Scale, 1 Death Rune, 1 Chaos Rune and 5 Fire Runes.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your weapon has x charges.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage(String message)
	{
		final int currentCharges = parseNumber(getNumbersFromString(message).get(0));
		final int fireRuneCosts = 5;

		final int amountOfCharges = maxCharges - currentCharges;
		final int amountOfFireRunes = amountOfCharges * fireRuneCosts;
		final String template = "%1$d Zulrah's Scale, %1$d Death Runes, %1$d Chaos Runes and %2$d Fire Runes needed to fully recharge.";

		return formatRechargeMessage(template, amountOfCharges, amountOfFireRunes);
	}


}
