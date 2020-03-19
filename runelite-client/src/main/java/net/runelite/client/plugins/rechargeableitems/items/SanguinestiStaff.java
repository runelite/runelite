package net.runelite.client.plugins.rechargeableitems.items;

public class SanguinestiStaff extends RechargeableItem
{
	/**
	 * The Sanguinesti Staff charges up to 20000 charges.
	 * Every recharge gives 1 charge which costs 3 Blood Runes.
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
		final int maxCharges = 20000;
		final int bloodRunesPerCharge = 3;

		final int amountOfCharges = maxCharges - currentCharges;
		final int amountOfBloodRunes = amountOfCharges * bloodRunesPerCharge;
		final String template = "%d Blood Runes needed to fully recharge.";

		return formatRechargeMessage(template, amountOfBloodRunes);
	}
}
