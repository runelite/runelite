package net.runelite.client.menus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
abstract class ItemComparableEntry extends AbstractComparableEntry
{
	@EqualsAndHashCode.Exclude
	short[] itemIds;
	@EqualsAndHashCode.Exclude
	short itemCount;

	public abstract boolean matches(MenuEntry entry);

	@EqualsAndHashCode(callSuper = true)
	static class InvItemComparableEntry extends ItemComparableEntry
	{
		public InvItemComparableEntry(Client client, String option, String itemName)
		{
			assert client.isClientThread() : "You can only create these on the clientthread";

			this.target = Text.standardize(itemName);
			this.option = option;

			short[] tmp = this.itemIds = new short[16];

			final int itemCount = client.getItemCount();
			short found = 0;

			for (short i = 0; i < itemCount; i++)
			{
				ItemDefinition def = client.getItemDefinition(i);
				if (def.getNote() != -1 || !StringUtils.containsIgnoreCase(def.getName(), target))
				{
					continue;
				}

				boolean notValid = true;
				for (String opt : def.getInventoryActions())
				{
					if (opt != null && StringUtils.containsIgnoreCase(opt, option))
					{
						notValid = false;
						break;
					}
				}

				if (notValid && !"use".equals(this.option))
				{
					continue;
				}

				if (found >= tmp.length)
				{
					short[] rlyTmp = new short[found * 2];
					System.arraycopy(tmp, 0, rlyTmp, 0, found);
					tmp = rlyTmp;
				}

				tmp[found++] = i;
			}

			this.itemIds = new short[itemCount];
			this.itemCount = found;
			System.arraycopy(tmp, 0, this.itemIds, 0, found);
		}

		public boolean matches(MenuEntry entry)
		{
			if (!StringUtils.containsIgnoreCase(entry.getOption(), this.option))
			{
				return false;
			}

			int entryId = entry.getIdentifier();
			for (short i = 0; i < itemCount; i++)
			{
				if (entryId == itemIds[i])
				{
					return true;
				}
			}

			return false;
		}
	}
}
