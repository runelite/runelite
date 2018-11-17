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
    private int KC;
    private final List<Item> drops;

    public void update(ItemManager itemManager)
    {
        for(Item i : drops)
        {
            ItemComposition itemComposition = itemManager.getItemComposition(i.getId());
            i.setName(itemComposition.getName());
            final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : i.getId();
            i.setPrice(itemManager.getItemPrice(realItemId));
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

    void addItem(Item item) {
        for(Item i : drops) {
            if(item.getId() == i.getId()) {
                i.setQuantity(i.getQuantity()+item.getQuantity());
                return;
            }
        }
        drops.add(item);
    }

    void addKC() {
        KC++;
    }
}
