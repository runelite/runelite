package net.runelite.client.plugins.cleanermenuentries;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

@PluginDescriptor(name = "Cleaner Menus")
public class CleanerMenuEntriesPlugin extends Plugin {
    @Inject
    private Client client;

    @Subscribe
    public void onMenuOpened(MenuOpened event) {
        //                      target      option                                    one to show| position| number of times shown
        HashMap<String, HashMap<String, AbstractMap.SimpleEntry<AbstractMap.SimpleEntry<MenuEntry, Integer>, Integer>>> repeated = new HashMap<>();

        int count = 0;
        for (MenuEntry menuEntry : event.getMenuEntries()) {
            if (!repeated.containsKey(menuEntry.getTarget())) {
                repeated.put(menuEntry.getTarget(), new HashMap<>());
            }

            if (!repeated.get(menuEntry.getTarget()).containsKey(menuEntry.getOption())) {
                repeated.get(menuEntry.getTarget()).put(menuEntry.getOption(), new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(menuEntry, count), 0));
                count++;
            }


            repeated.get(menuEntry.getTarget()).get(menuEntry.getOption()).setValue(repeated.get(menuEntry.getTarget()).get(menuEntry.getOption()).getValue() + 1);
        }

        MenuEntry[] toShow = new MenuEntry[count];
        repeated.forEach((k1, v1) -> v1.forEach((k2, v2) -> {
            MenuEntry showEntry = v2.getKey().getKey();
            if (v2.getValue() > 1) {
                showEntry.setTarget(showEntry.getTarget() + " (" + v2.getValue() + ")");
            }
            toShow[v2.getKey().getValue()] = showEntry;
        }));
        client.setMenuEntries(toShow);
    }
}
