package net.runelite.client.plugins.bosslog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslog.enums.Bosses;

import java.util.List;

@Getter
@AllArgsConstructor
public class Boss
{
	private final Bosses boss;
	private int KC;
	private List<BossLogItem> drops;

	public void update(ItemManager itemManager)
	{
		for (BossLogItem i : drops)
		{
			ItemComposition itemComposition = itemManager.getItemComposition(i.getId());
			i.setName(itemComposition.getName());
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : i.getId();
			i.setPrice(itemManager.getItemPrice(realItemId));
		}
		sort();
	}

	private void sort()
	{
		List<BossLogItem> tmp = drops;
		for (int i = 0; i < tmp.size(); i++)
		{
			int iMax = i;
			BossLogItem itemMax =  tmp.get(i);
			BossLogItem tmpI = tmp.get(i);
			for (int j = i + 1; j < tmp.size(); j++)
			{
				if (tmp.get(j).getPrice() * tmp.get(j).getQuantity() > itemMax.getPrice() * itemMax.getQuantity())
				{
					itemMax = tmp.get(j);
					iMax = j;
				}
			}
			if (iMax != i)
			{
				tmp.set(i, tmp.get(iMax));
				tmp.set(iMax, tmpI);
			}
		}
		drops = tmp;
	}

	int getProfit()
	{
		int sum = 0;
		for (BossLogItem i : drops)
		{
			sum += i.getPrice() * i.getQuantity();
		}
		return sum;
	}

	void addItem(BossLogItem item)
	{
		for (BossLogItem i : drops)
		{
			if (item.getId() == i.getId())
			{
				i.setQuantity(i.getQuantity() + item.getQuantity());
				return;
			}
		}
		drops.add(item);
	}

	void addKC()
	{
		KC++;
	}
}
