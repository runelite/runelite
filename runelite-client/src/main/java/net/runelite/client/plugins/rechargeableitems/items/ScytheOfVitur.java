package net.runelite.client.plugins.rechargeableitems.items;

public class ScytheOfVitur extends RechargeableItem
{
	/**
	 * The Scythe of Vitur charges up to 20000 charges.
	 * Every recharge gives 100 charges which costs 1 Vial of Blood and 300 Blood Runes.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your scythe has x charges remaining.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage(String message)
	{
		final int currentCharges = parseNumber(getNumbersFromString(message).get(0));
		final int maxCharges = 20000;
		final int bloodRunesPerCharge = 300;
		final int vialsOfBloodPerCharge = 1;
		final int rechargeAmount = 100;

		final double amountOfCharges = maxCharges - currentCharges;
		final double amountOfRecharges = Math.floor(amountOfCharges / rechargeAmount);
		final int amountOfBloodRunes = (int) amountOfRecharges * bloodRunesPerCharge;
		final int amountOfVialsOfBlood = (int) amountOfRecharges * vialsOfBloodPerCharge;
		final String template = "%d Vials of Blood and %d Blood Runes needed to fully recharge without wasting charges.";

		return formatRechargeMessage(template, amountOfVialsOfBlood, amountOfBloodRunes);
	}
}
