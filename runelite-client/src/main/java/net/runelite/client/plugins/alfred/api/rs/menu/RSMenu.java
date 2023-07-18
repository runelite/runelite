package net.runelite.client.plugins.alfred.api.rs.menu;

import net.runelite.api.MenuEntry;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.ui.FontManager;

import java.awt.*;
import java.util.List;

public class RSMenu {

    private final int MINIMUM_MENU_WIDTH = 103;
    private final int MENU_HEADER_HEIGHT = 19;
    private final int MENU_ENTRY_HEIGHT = 15;
    private final int MENU_BORDER_WIDTH = 2;
    private final List<MenuEntry> menuEntries;

    public RSMenu(List<MenuEntry> menuEntries) {
        this.menuEntries = menuEntries;
    }

    public List<MenuEntry> getMenuEntries() {
        return menuEntries;
    }

    private int getActionMenuWidth() {
        FontMetrics fontMetrics = Alfred.getClient().getCanvas().getFontMetrics(FontManager.getRunescapeBoldFont());
        int entryLength = menuEntries.stream().mapToInt(entry -> fontMetrics.stringWidth(entry.getOption() + " " + entry.getTarget().replaceAll("<.*?>", ""))).max().orElse(0);
        return Math.max(entryLength + (MENU_BORDER_WIDTH * 2), MINIMUM_MENU_WIDTH);
    }

    private int getActionMenuHeight() {
        return MENU_HEADER_HEIGHT + (MENU_ENTRY_HEIGHT * menuEntries.size());
    }

    private int getActionMenuX() {
        return (int) (Alfred.getMouse().getLastMousePosition().getX() - (getActionMenuWidth() / 2));
    }

    private int getActionMenuY() {
        return (int) (Alfred.getMouse().getCurrentMousePosition().getY() + MENU_HEADER_HEIGHT);
    }

    private Rectangle getActionMenuBounds() {
        return new Rectangle(getActionMenuX(), getActionMenuY(), getActionMenuWidth(), getActionMenuHeight());
    }

    public boolean hasAction(String action) {
        Alfred.setStatus("Checking if menu has action: " + action);
        return menuEntries.stream().anyMatch(entry -> entry.getOption().equalsIgnoreCase(action));
    }

    public boolean hasAction(String action, String target) {
        Alfred.setStatus("Checking if menu has action: " + action + " and target: " + target);

        for (MenuEntry entry : menuEntries) {
            String entryTarget = entry.getTarget().replaceAll("<.*?>", "");
            if (entry.getOption().equalsIgnoreCase(action) && entryTarget.equalsIgnoreCase(target)) {
                return true;
            }
        }

        return false;
    }

    public boolean clickAction(String action) {
        Alfred.setStatus("Clicking menu action: " + action);

        MenuEntry menuEntry = menuEntries.stream().filter(entry -> entry.getOption().equalsIgnoreCase(action)).findFirst().orElse(null);
        if (menuEntry == null) {
            return false;
        }

        Rectangle actionMenuBounds = getActionMenuBounds();
        int index = menuEntries.indexOf(menuEntry);

        Rectangle entryBounds = new Rectangle(actionMenuBounds.x, actionMenuBounds.y + (MENU_ENTRY_HEIGHT * index), actionMenuBounds.width, MENU_ENTRY_HEIGHT);
        Alfred.getMouse().leftClick(entryBounds);
        return true;
    }

    public boolean clickAction(String action, String target) {
        Alfred.setStatus("Clicking menu action: " + action + " and target: " + target);

        for (MenuEntry entry : menuEntries) {
            String entryTarget = entry.getTarget().replaceAll("<.*?>", "");

            if (entry.getOption().equalsIgnoreCase(action) && entryTarget.equalsIgnoreCase(target)) {
                Rectangle actionMenuBounds = getActionMenuBounds();
                int index = menuEntries.indexOf(entry);

                Rectangle entryBounds = new Rectangle(actionMenuBounds.x, actionMenuBounds.y + (MENU_ENTRY_HEIGHT * index), actionMenuBounds.width, MENU_ENTRY_HEIGHT);
                Alfred.getMouse().leftClick(entryBounds);
                return true;
            }
        }

        return false;
    }
}
