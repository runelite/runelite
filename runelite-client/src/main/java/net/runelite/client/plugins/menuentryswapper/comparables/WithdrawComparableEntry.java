package net.runelite.client.plugins.menuentryswapper.comparables;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;
import net.runelite.client.menus.AbstractComparableEntry;

@EqualsAndHashCode(callSuper = true)
public class WithdrawComparableEntry extends AbstractComparableEntry
{
	private static String x;

	private final Amount amount;

	private WithdrawComparableEntry(Amount amount, String item)
	{
		this.amount = amount;
		this.setTarget(Text.standardize(item));
	}

	@Override
	public boolean matches(MenuEntry entry)
	{
		if (BankComparableEntry.isNotBankWidget(entry.getParam1()))
		{
			return false;
		}

		final String option = entry.getOption();

		if (!option.startsWith("Withdraw") && !option.startsWith("Deposit"))
		{
			return false;
		}

		if (amount == Amount.X)
		{
			if (!option.endsWith(x))
			{
				return false;
			}
		}
		else if (!option.endsWith(amount.suffix))
		{
			return false;
		}

		return Text.standardize(entry.getTarget()).contains(this.getTarget());
	}

	@Override
	public int getPriority()
	{
		return 10;
	}

	public static void setX(int amount)
	{
		x = String.valueOf(amount);
	}

	public static void populateArray(AbstractComparableEntry[] array, List<String> items, Amount amount)
	{
		for (int i = 0; i < array.length; i++)
		{
			array[i] = new WithdrawComparableEntry(amount, items.get(i));
		}
	}

	@AllArgsConstructor
	public enum Amount
	{
		ONE("1"),
		FIVE("5"),
		TEN("10"),
		X(null),
		ALL("All");

		private String suffix;
	}
}
