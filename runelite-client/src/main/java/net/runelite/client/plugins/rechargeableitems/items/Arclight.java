package net.runelite.client.plugins.rechargeableitems.items;

public class Arclight extends RechargeableItem
{
	/**
	 * The Arclight charges up to 10000 charges.
	 * Every recharge gives 1000 charges which costs 3 Ancient shards.
	 * This means that if the current amount of charges is over 9000, charging the Arclight will waste potential charges.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your arclight has x charges left.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage(String message)
	{
		final int currentCharges = parseNumber(getNumbersFromString(message).get(0));
		final double maxCharges = 10000;
		final double amountOfChargesPerCharge = 1000;
		final double amountOfShardsPerCharge = 3;

		final double amountToCharge = maxCharges - currentCharges;
		final double amountOfChargesPossible = Math.floor(amountToCharge / amountOfChargesPerCharge);
		final double amountOfShardsNeeded = amountOfChargesPossible * amountOfShardsPerCharge;
		final String template = "%d ancient shards to recharge without wasting shards.";

		return formatRechargeMessage(template, (int) amountOfShardsNeeded);
	}
}
