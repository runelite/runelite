package net.runelite.client.plugins.easyscape;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import static net.runelite.api.MenuAction.WALK;


@PluginDescriptor(
        name = "Easyscape",
        description = "Easyscape.",
        tags = {"Easyscape"},
        enabledByDefault = false
)

@Slf4j
public class EasyscapePlugin extends Plugin {

    private static final int PURO_PURO_REGION_ID = 10307;
    private static final int HOUSE_REGION_ID = 7513;

    private Map<Integer, Integer> idSwap;
    private MenuEntry[] entries;

    @Inject
    private Client client;

    @Inject
    private EasyscapePluginConfig config;

    @Provides
    EasyscapePluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasyscapePluginConfig.class);
    }

    @Override
    public void startUp() {
        log.debug("Easyscape Started.");
        idSwap = new HashMap<>();
    }

    @Override
    public void shutDown() {
        log.debug("Easyscape Stopped.");
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event) {

        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        Widget loginScreenOne = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN);
        Widget loginScreenTwo = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN_MESSAGE_OF_THE_DAY);

        if (loginScreenOne != null || loginScreenTwo != null) {
            return;
        }

        final String option = Text.removeTags(event.getOption()).toLowerCase();
        final String target = Text.removeTags(event.getTarget()).toLowerCase();

        entries = client.getMenuEntries();

        if (config.getRemoveExamine()) {
            for (int i = entries.length - 1; i >= 0; i--) {
                if (entries[i].getOption() == "Examine") {
                    entries = ArrayUtils.remove(entries, i);
                    i--;
                }
            }
            client.setMenuEntries(entries);
        }

        if (config.getRemoveMonster() && !config.getRemovedMonsters().equals("")) {
            if (config.getRemovedMonsters().length() > 0) {
                for (String removed : config.getRemovedMonsters().split(",")) {
                    removed = removed.trim();
                    for (String found : target.split(" ")) {
                        if (found.equalsIgnoreCase(removed) && target.substring(0, removed.length()).equalsIgnoreCase(removed)) {
                            delete(event.getIdentifier());
                            break;
                        }
                    }
                }
            }
        }

        if (config.getSwapPuro() && isPuroPuro()) {
            if (event.getType() == WALK.getId()) {
                MenuEntry menuEntry = entries[entries.length - 1];
                menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
                client.setMenuEntries(entries);
            }
            else if (option.equalsIgnoreCase("examine")) {
                swap("push-through", option, target);
            }
            else if (option.equalsIgnoreCase("use")) {
                swap("escape", option, target);
            }
        }

        if (config.getEasyConstruction()) {
            if (event.getType() == WALK.getId()) {
                MenuEntry menuEntry = entries[entries.length - 1];
                menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
                client.setMenuEntries(entries);
            }

            swap("Build", option, target);

            for (int i = entries.length - 1; i >= 0; i--) {
                if (!config.getConstructionItems().equals("")) {
                    for (String item : config.getConstructionItems().split(",")) {
                        if (item.trim().equalsIgnoreCase(Text.removeTags(entries[i].getTarget()))) {
                            if (!entries[i].getOption().equalsIgnoreCase("remove")) {
                                entries = ArrayUtils.remove(entries, i);
                                i--;
                            }
                        }
                    }
                }
            }

            client.setMenuEntries(entries);
        }

        if (config.getSwapShop()) {
            for (String item : config.getSwappedItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swap("Buy 50", option, target);
                }
            }
        }

        if (config.getSwapSmithing()) {
            if (option.equalsIgnoreCase("Smith 1")) {
                swap("Smith All", option, target);
            } else {
                swap("Smith All Sets", "Smith 1 Set", target);
            }
        }

        if (config.getSwapTanning() && option.equalsIgnoreCase("Tan 1")) {
                swap("Tan All", option, target);
        }

        if (config.getSwapSawmill() && target.equalsIgnoreCase("Sawmill operator")) {
            swap("Buy-plank", option, target);
        }

        if (config.getSwapSawmillPlanks() && option.equalsIgnoreCase("Buy 1")) {
            swap("Buy All", option, target);
        }

        if (config.getSwapStairs() && option.equalsIgnoreCase("Climb Stairs")) {
            swap("Climb Up Stairs", option, target);
        }

        if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("Bank Filler")) {
            swap("Clear", option, target);
        }

        if (target.toLowerCase().contains("ardougne cloak") && config.getSwapArdougneCape()) {
            swap("Kandarin Monastery", option, target);
            swap("Monastery Teleport", option, target);
        }

        if (config.getSwapEssencePouch()) {
            if (isEssencePouch(target)) {
                Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
                switch (config.getEssenceMode()) {
                    case RUNECRAFTING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swap("Empty", option, target);
                        } else {
                            swap("Fill", option, target);
                        }
                        break;
                    case ESSENCE_MINING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swap("Fill", option, target);
                        } else {
                            swap("Empty", option, target);
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        if (config.getGamesNecklace()) {
            if (target.toLowerCase().contains("games necklace")) {
                switch (config.getGamesNecklaceMode()) {
                    case BURTHORPE:
                        swap("Burthorpe", option, target);
                        break;
                    case BARBARIAN_OUTPOST:
                        swap("Barbarian Outpost", option, target);
                        break;
                    case CORPOREAL_BEAST:
                        swap("Corporeal Beast", option, target);
                        break;
                    case TEARS_OF_GUTHIX:
                        swap("Tears of Guthix", option, target);
                        break;
                    case WINTERTODT:
                        swap("Wintertodt Camp", option, target);
                        break;
                    default:
                        break;
                }
            }
        }

        if (config.getDuelingRing()) {
            if (target.toLowerCase().contains("dueling ring")) {
                switch (config.getDuelingRingMode()) {
                    case DUEL_ARENA:
                        swap("Duel Arena", option, target);
                        break;
                    case CASTLE_WARS:
                        swap("Castle Wars", option, target);
                        break;
                    case CLAN_WARS:
                        swap("Clan Wars", option, target);
                        break;
                    default:
                        break;
                }
            }
        }

        idSwap.forEach((k,v) -> performSwap(k,v));
        idSwap.clear();

    }

    private int searchIndex(MenuEntry[] entries, String option, String target) {
        for (int i = entries.length - 1; i >= 0; i--) {
            MenuEntry entry = entries[i];
            String entryOption = Text.removeTags(entry.getOption()).toLowerCase();
            String entryTarget = Text.removeTags(entry.getTarget()).toLowerCase();

            if (entryOption.equalsIgnoreCase(option) && entryTarget.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    private void swap(String optionA, String optionB, String target) {
        int idxA = searchIndex(entries, optionA, target);
        int idxB = searchIndex(entries, optionB, target);

        if (idxA >= 0 && idxB >= 0) {
            idSwap.put(idxA, idxB);
        }
    }

    private void performSwap(int a, int b) {
        MenuEntry entry = entries[a];
        entries[a] = entries[b];
        entries[b] = entry;
        client.setMenuEntries(entries);
    }

    private void delete(int target) {
        for (int i = entries.length - 1; i >= 0; i--) {
            if (entries[i].getIdentifier() == target) {
                entries = ArrayUtils.remove(entries, i);
                i--;
            }
        }
        client.setMenuEntries(entries);
    }

    private boolean isEssencePouch(String target) {
        return (target.equalsIgnoreCase("Small Pouch") || target.equalsIgnoreCase("Medium Pouch") || target.equalsIgnoreCase("Large Pouch") || target.equalsIgnoreCase("Giant Pouch"));
    }

    private boolean isHouse() {
        return client.getMapRegions()[0] == HOUSE_REGION_ID;
    }

    private boolean isPuroPuro() {
        Player player = client.getLocalPlayer();

        if (player == null) {
            return false;
        } else {
            WorldPoint location = player.getWorldLocation();
            return location.getRegionID() == PURO_PURO_REGION_ID;
        }
    }

}