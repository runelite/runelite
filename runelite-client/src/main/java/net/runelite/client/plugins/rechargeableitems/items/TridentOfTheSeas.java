package net.runelite.client.plugins.rechargeableitems.items;

public class TridentOfTheSeas extends RechargeableItem
{
	private int maxCharges;

	public TridentOfTheSeas(int maxCharges)
	{
		this.maxCharges = maxCharges;
	}

	/**
	 * The Trident of the Seas charges up to 2500 or 20000 charges.
	 * Every recharge gives 1 charge which costs 1 Death Rune, 1 Chaos Rune, 5 Fire Runes and 10 Coins.
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
		final int fireRunesPerCharge = 5;
		final int coinsPerCharge = 10;

		final int amountOfCharges = maxCharges - currentCharges;
		final int amountOfFireRunes = amountOfCharges * fireRunesPerCharge;
		final int amountOfCoins = amountOfCharges * coinsPerCharge;
		final String template = "%1$d Death Runes, %1$d Chaos Runes, %2$d Fire Runes and %3$d Coins needed to fully recharge.";

		return formatRechargeMessage(template, amountOfCharges, amountOfFireRunes, amountOfCoins);
	}
}
