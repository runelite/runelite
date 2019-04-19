package net.runelite.client.plugins.easy.util;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;

public class Swapper {

    private Set<Swappable> swapping;

    @Getter
    @Setter
    private MenuEntry[] entries;

    public Swapper() {
        this.swapping = new HashSet<>();
    }

    public void deprioritizeWalk() {
        MenuEntry menuEntry = entries[entries.length - 1];
        menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
    }

    public void removeIndex(int index) {
        entries = ArrayUtils.remove(entries, index);
    }

    public void markForSwap(String optionA, String optionB, String target) {
        swapping.add(new Swappable(target, optionA, optionB));
    }

    public void startSwap() {
        int index = 0;
        for (MenuEntry entry : entries) {
            String target = Text.removeTags(entry.getTarget()).toLowerCase();
            String option = Text.removeTags(entry.getOption()).toLowerCase();
            for (Swappable swap : swapping) {
                if (swap.getTarget().equalsIgnoreCase(target)) {
                    if (option.equalsIgnoreCase(swap.getOptionOne())) {
                        swap.setIndexOne(index);
                    } else if (option.equalsIgnoreCase(swap.getOptionTwo())) {
                        swap.setIndexTwo(index);
                    }
                }
            }
            index++;
        }

        for (Swappable swap : swapping) {
            if (swap.isReady()) {
                MenuEntry entry = entries[swap.getIndexOne()];
                entries[swap.getIndexOne()] = entries[swap.getIndexTwo()];
                entries[swap.getIndexTwo()] = entry;
            }
        }
        swapping.clear();
    }

}
