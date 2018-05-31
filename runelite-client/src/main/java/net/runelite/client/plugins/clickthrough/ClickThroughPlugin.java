package net.runelite.client.plugins.clickthrough;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperConfig;
import net.runelite.client.plugins.menuentryswapper.ShiftClickInputListener;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@PluginDescriptor(
        name = "Click-through",
        enabledByDefault = false
)

public class ClickThroughPlugin  extends Plugin
{

    private static final String CONFIGURE = "Configure";
    private static final String SAVE = "Save";
    private static final String RESET = "Reset";
    private static final String MENU_TARGET = "<col=ff9040>Shift-click";

    private List<String> clickthroughList = new ArrayList<>();

    @Inject
    private Client client;

    @Inject
    private ClickThroughConfig config;

    @Inject
    private ConfigManager configManager;

    @Inject
    private ItemManager itemManager;

    @Inject
    private KeyManager keyManager;

    @Inject
    private MenuManager menuManager;

    @Provides
    ClickThroughConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ClickThroughConfig.class);
    }

    @Override
    public void startUp() { }

    @Override
    public void shutDown() { }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        clickthroughList = Arrays.asList(config.clickthroughList().split("\\s*,\\s*"));
    }

    @Subscribe
    public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
    {

    }

    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {

    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        if (event.getMenuAction() != MenuAction.RUNELITE || event.getWidgetId() != WidgetInfo.INVENTORY.getId())
        {
            return;
        }

        int itemId = event.getId();

        if (itemId == -1)
        {
            return;
        }

        String option = event.getMenuOption();
        String target = event.getMenuTarget();
        ItemComposition itemComposition = client.getItemDefinition(itemId);

        if (option.equals(RESET) && target.equals(MENU_TARGET))
        {
            unsetSwapConfig(itemId);
            itemComposition.resetShiftClickActionIndex();
            return;
        }

        if (!itemComposition.getName().equals(Text.removeTags(target)))
        {
            return;
        }

        int index = -1;
        boolean valid = false;

        if (option.equals("Use")) //because "Use" is not in inventoryActions
        {
            valid = true;
        }
        else
        {
            String[] inventoryActions = itemComposition.getInventoryActions();

            for (index = 0; index < inventoryActions.length; index++)
            {
                if (option.equals(inventoryActions[index]))
                {
                    valid = true;
                    break;
                }
            }
        }

        if (valid)
        {
            setSwapConfig(itemId, index);
            itemComposition.setShiftClickActionIndex(index);
        }
    }

    private void setSwapConfig(int itemId, int index)
    {
    }

    private void unsetSwapConfig(int itemId)
    {
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event)
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        int itemId = event.getIdentifier();
        String option = Text.removeTags(event.getOption()).toLowerCase();
        String target = Text.removeTags(event.getTarget()).toLowerCase();

        if (config.swapAttack()) {
            for (String s : clickthroughList) {
                if (target.contains(s) && !s.equals("")) {
                    // Keep moving 'Walk here' to the end of the entries (left-click option)
                    MenuEntry[] entries = client.getMenuEntries();
                    int walkIdx = searchIndex(entries, "Walk here", "", false);

                    if (walkIdx > 0 && walkIdx <= entries.length) {
                        MenuEntry walkHere = entries[walkIdx];
                        MenuEntry currentTop = entries[entries.length - 1];

                        entries[walkIdx] = currentTop;
                        entries[entries.length - 1] = walkHere;

                        client.setMenuEntries(entries);
                    }
                }
            }
        }
    }

    private void swap(String optionA, String optionB, String target, boolean strict)
    {
        MenuEntry[] entries = client.getMenuEntries();

        int idxA = searchIndex(entries, optionA, target, strict);
        int idxB = searchIndex(entries, optionB, target, strict);

        if (idxA >= 0 && idxB >= 0)
        {
            MenuEntry entry = entries[idxA];
            entries[idxA] = entries[idxB];
            entries[idxB] = entry;

            client.setMenuEntries(entries);
        }
    }

    private int searchIndex(MenuEntry[] entries, String option, String target, boolean strict)
    {
        for (int i = entries.length - 1; i >= 0; i--)
        {
            MenuEntry entry = entries[i];
            String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
            String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

            if (strict)
            {
                if (entryOption.equals(option) && entryTarget.equals(target))
                {
                    return i;
                }
            }
            else
            {
                if (entryOption.contains(option.toLowerCase()) && entryTarget.equals(target))
                {
                    return i;
                }
            }
        }

        return -1;
    }
}
