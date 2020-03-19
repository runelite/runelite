package net.runelite.client.plugins.rechargeableitems.items;

import lombok.Getter;

public class BarrowsEquipment extends RechargeableItem
{
	private double totalPrice;
	private double degradation;
	private double smithLevel;

	public BarrowsEquipment(Type type, int degradation, double smithLevel)
	{
		this.totalPrice = type.getPrice();
		this.degradation = degradation;
		this.smithLevel = smithLevel;
	}

	/**
	 * The Barrows items degrade in combat and start each degradation with 100%.
	 * <p>
	 * Chat message, where x is the current percentage to the next degradation:
	 * [Barrows item]: x% remaining until the next degradation.
	 *
	 * @return String containing the recharge message
	 */
	@Override
	public String getRechargeMessage(String message)
	{
		final double increments = totalPrice / 1000;
		final double percentage = parseNumber(getNumbersFromString(message).get(0));
		double priceToPayNPC = ((100 - percentage) / 100) * (totalPrice / 4) + (degradation * totalPrice / 4);

		// Every even number the maximum price is += 3x60 coins
		// Every odd number the maximum price is += 2x60 coins
		// Since there is no way of knowing which of the values it's gonna be we display the max price.
		if (percentage % 2 == 0)
		{
			priceToPayNPC += (increments * 2);
		}
		else
		{
			priceToPayNPC += increments;
		}

		final double priceAtPOH = (1 - (smithLevel / 200)) * priceToPayNPC;
		final String template = "%d a maximum of Coins at a NPC or %d a maximum of Coins at a POH armour stand";

		return formatRechargeMessage(template, (int) priceToPayNPC, (int) priceAtPOH);
	}

	public enum Type
	{
		HELM(60000),
		BODY(90000),
		LEGS(80000),
		WEAPON(100000);

		@Getter
		private double price;

		Type(double price)
		{
			this.price = price;
		}
	}
}
