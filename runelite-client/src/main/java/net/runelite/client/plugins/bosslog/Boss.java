package net.runelite.client.plugins.bosslog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;

import java.util.List;

@Getter
@AllArgsConstructor
public class Boss {
    private final Bosses boss;
    private final int KC;
    private final List<Item> drops;

    public void update(ItemManager itemManager)
    {
        for(Item i : drops)
        {
            ItemComposition itemComposition = itemManager.getItemComposition(i.getId());
            i.setName(itemComposition.getName());
            i.setPrice(itemManager.getItemPrice(i.getId()));
        }
    }

    int getProfit()
    {
        int sum = 0;
        for(Item i : drops)
        {
            sum += i.getPrice()*i.getQuantity();
        }
        return sum;
    }
}
