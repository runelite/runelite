package net.runelite.client.plugins.alfred.api.rs.menu;

import net.runelite.api.MenuEntry;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RSMenuHelper {


    public RSMenu getMenu() {
        return new RSMenu(getMenuEntries());
    }

    public List<MenuEntry> getMenuEntries() {
        List<MenuEntry> orderedMenuEntries = new ArrayList<>();
        MenuEntry[] menuEntries = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getMenuEntries());

        for (MenuEntry menuEntry : menuEntries) {
            if (menuEntry.getOption().length() > 0) {
                orderedMenuEntries.add(menuEntry);
            }
        }

        Collections.reverse(orderedMenuEntries);
        return orderedMenuEntries;
    }
}
