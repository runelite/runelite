package net.runelite.client.plugins.raids3;

import com.google.common.base.Predicates;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.plugins.raids3Util.OneUpUtilityPlugin;
import net.runelite.client.util.Text;

public class MenuSwapperUtility {
  private static final String ITEM_KEY_PREFIX = "item_";
  private final ArrayListMultimap<String, Integer> optionIndexes = ArrayListMultimap.create();
  Client client;
  public boolean isOn = false;
  private static final List<MenuAction> NPC_MENU_TYPES;
  private static final List<MenuAction> OBJECT_MENU_TYPES;
  private final Multimap<String, Swap> swaps = LinkedHashMultimap.create();

  public MenuSwapperUtility(Client client) {
    this.client = client;
  }

  private void swap(String option, String swappedOption, Supplier<Boolean> enabled) {
    this.swap(option, (Predicate) Predicates.alwaysTrue(), swappedOption, enabled);
  }

  private void swap(String option, String target, String swappedOption, Supplier<Boolean> enabled) {
    this.swap(option, (Predicate)Predicates.equalTo(target), swappedOption, enabled);
  }

  private void swap(String option, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled) {
    this.swaps.put(option, new Swap(Predicates.alwaysTrue(), targetPredicate, swappedOption, enabled, true));
  }

  private boolean swap(MenuEntry[] menuEntries, String option, String target, int index, boolean strict) {
    int optionIdx = this.findIndex(menuEntries, index, option, target, strict);
    if (optionIdx >= 0) {
      this.swap(this.optionIndexes, menuEntries, optionIdx, index);
      return true;
    } else {
      return false;
    }
  }

  private int findIndex(MenuEntry[] entries, int limit, String option, String target, boolean strict) {
    if (strict) {
      List<Integer> indexes = this.optionIndexes.get(option);

      for(int i = indexes.size() - 1; i >= 0; --i) {
        int idx = (Integer)indexes.get(i);
        MenuEntry entry = entries[idx];
        String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();
        if (idx < limit && entryTarget.equals(target)) {
          return idx;
        }
      }
    } else {
      for(int i = limit - 1; i >= 0; --i) {
        MenuEntry entry = entries[i];
        String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
        String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();
        if (entryOption.contains(option.toLowerCase()) && entryTarget.equals(target)) {
          return i;
        }
      }
    }

    return -1;
  }

  public void onClientTick() {
    if (this.client.getGameState() == GameState.LOGGED_IN && !this.client.isMenuOpen() && this.isOn) {
      if (OneUpUtilityPlugin.isMouseLocked) {
        MenuEntry[] menuEntries = this.client.getMenuEntries();
        int idx = 0;
        this.optionIndexes.clear();
        MenuEntry[] var3 = menuEntries;
        int var4 = menuEntries.length;

        int var5;
        MenuEntry entry;
        for(var5 = 0; var5 < var4; ++var5) {
          entry = var3[var5];
          String option = Text.removeTags(entry.getOption()).toLowerCase();
          this.optionIndexes.put(option, idx++);
        }

        idx = 0;
        var3 = menuEntries;
        var4 = menuEntries.length;

        for(var5 = 0; var5 < var4; ++var5) {
          entry = var3[var5];
          this.swapMenuEntry(menuEntries, idx++, entry);
        }

      }
    }
  }

  private static <T extends Comparable<? super T>> void sortedInsert(List<T> list, T value) {
    int idx = Collections.binarySearch(list, value);
    list.add(idx < 0 ? -idx - 1 : idx, value);
  }

  private void swap(ArrayListMultimap<String, Integer> optionIndexes, MenuEntry[] entries, int index1, int index2) {
    if (index1 != index2) {
      MenuEntry entry1 = entries[index1];
      MenuEntry entry2 = entries[index2];
      entries[index1] = entry2;
      entries[index2] = entry1;
      if (entry1.getType() == MenuAction.CC_OP_LOW_PRIORITY) {
        entry1.setType(MenuAction.CC_OP);
      }

      if (entry2.getType() == MenuAction.CC_OP_LOW_PRIORITY) {
        entry2.setType(MenuAction.CC_OP);
      }

      this.client.setMenuEntries(entries);
      String option1 = Text.removeTags(entry1.getOption()).toLowerCase();
      String option2 = Text.removeTags(entry2.getOption()).toLowerCase();
      List<Integer> list1 = optionIndexes.get(option1);
      List<Integer> list2 = optionIndexes.get(option2);
      list1.remove(index1);
      list2.remove(index2);
      sortedInsert(list1, index2);
      sortedInsert(list2, index1);
    }
  }

  private void swapMenuEntry(MenuEntry[] menuEntries, int index, MenuEntry menuEntry) {
    MenuAction menuAction = menuEntry.getType();
    String option = Text.removeTags(menuEntry.getOption()).toLowerCase();
    String target = Text.removeTags(menuEntry.getTarget()).toLowerCase();
    if (OBJECT_MENU_TYPES.contains(menuAction)) {
      menuEntry.setDeprioritized(true);
    }

    if (NPC_MENU_TYPES.contains(menuAction)) {
      menuEntry.setDeprioritized(true);
    }

    if (menuAction == MenuAction.GROUND_ITEM_FIRST_OPTION || menuAction == MenuAction.GROUND_ITEM_SECOND_OPTION || menuAction == MenuAction.GROUND_ITEM_THIRD_OPTION || menuAction == MenuAction.GROUND_ITEM_FOURTH_OPTION || menuAction == MenuAction.GROUND_ITEM_FIFTH_OPTION) {
      menuEntry.setDeprioritized(true);
    }

    Collection<Swap> swaps = this.swaps.get(option);
    Iterator var8 = swaps.iterator();

    while(var8.hasNext()) {
      Swap swap = (Swap)var8.next();
      if (swap.getTargetPredicate().test(target) && (Boolean)swap.getEnabled().get() && this.swap(menuEntries, swap.getSwappedOption(), target, index, swap.isStrict())) {
        break;
      }
    }

  }

  static {
    NPC_MENU_TYPES = ImmutableList.of(MenuAction.NPC_FIRST_OPTION, MenuAction.NPC_SECOND_OPTION, MenuAction.NPC_THIRD_OPTION, MenuAction.NPC_FOURTH_OPTION, MenuAction.NPC_FIFTH_OPTION);
    OBJECT_MENU_TYPES = ImmutableList.of(MenuAction.GAME_OBJECT_FIRST_OPTION, MenuAction.GAME_OBJECT_SECOND_OPTION, MenuAction.GAME_OBJECT_THIRD_OPTION, MenuAction.GAME_OBJECT_FOURTH_OPTION);
  }
}