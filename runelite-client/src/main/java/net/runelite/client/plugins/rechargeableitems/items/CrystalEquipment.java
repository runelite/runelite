package net.runelite.client.plugins.rechargeableitems.items;

public class CrystalEquipment extends RechargeableItem
{
	/**
	 * All the crystal equipment, weapons and tools charge up to 20000 charges.
	 * Every recharge gives 100 charges which costs 1 Crystal Shard.
	 * <p>
	 * Chat message, where x is the current amount of charges:
	 * Your crystal [weapon name/equipment name] has x charges remaining.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage(String message)
	{
		final int currentCharges = parseNumber(getNumbersFromString(message).get(0));
		final int maxCharges = 20000;
		final int rechargeAmount = 100;

		final double amountOfCharges = maxCharges - currentCharges;
		final double amountOfRecharges = Math.floor(amountOfCharges / rechargeAmount);
		final String template = "%d Crystal Shards needed to fully recharge without wasting charges.";

		return formatRechargeMessage(template, (int) amountOfRecharges);
	}
}
