/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.easyscape;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.util.MenuUtil.swap;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;
import javax.inject.Inject;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import static net.runelite.api.MenuAction.WALK;


@PluginDescriptor(
        name = "Easyscape",
        description = "Easyscape.",
        tags = {"Easyscape"},
        enabledByDefault = false,
		type = PluginType.UTILITY
)

@Slf4j
public class EasyscapePlugin extends Plugin {

    private static final int PURO_PURO_REGION_ID = 10307;
    private static final int HOUSE_REGION_ID = 7513;

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
                if (entries[i].getOption().equals("Examine")) {
                    entries = ArrayUtils.remove(entries, i);
                    i--;
                }
            }
            client.setMenuEntries(entries);
        }

        if (config.getRemoveObjects() && !config.getRemovedObjects().equals("")) {
            for (String removed : config.getRemovedObjects().split(",")) {
                removed = removed.trim();
                if (target.contains("->")) {
                    String trimmed = target.split("->")[1].trim();
                    if (trimmed.length() >= removed.length() && trimmed.substring(0, removed.length()).equalsIgnoreCase(removed)) {
                        delete(event.getIdentifier());
                        break;
                    }
                }
                if (target.length() >= removed.length() && target.substring(0, removed.length()).equalsIgnoreCase(removed)) {
                    delete(event.getIdentifier());
                    break;
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
                swap(client, "push-through", option, target);
            }
            else if (option.equalsIgnoreCase("use")) {
                swap(client, "escape", option, target);
            }
        }

        if (config.getEasyConstruction() && !config.getConstructionItems().equals("")) {
            if (event.getType() == WALK.getId()) {
                MenuEntry menuEntry = entries[entries.length - 1];
                menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
                client.setMenuEntries(entries);
            }

            swap(client, "Build", option, target);

            for (int i = entries.length - 1; i >= 0; i--) {
                for (String item : config.getConstructionItems().split(",")) {
                    if (item.trim().equalsIgnoreCase(Text.removeTags(entries[i].getTarget()))) {
                        if (!entries[i].getOption().equalsIgnoreCase("remove")) {
                            entries = ArrayUtils.remove(entries, i);
                            i--;
                        }
                    }
                }
            }

            client.setMenuEntries(entries);
        }

        if (config.getSwapShop() && !config.getSwappedItems().equals("")) {
            for (String item : config.getSwappedItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swap(client, "Buy 50", option, target);
                }
            }
        }

        if (config.getSwapSmithing()) {
            if (option.equalsIgnoreCase("Smith 1")) {
                swap(client, "Smith All", option, target);
            } else if (option.equalsIgnoreCase("Smith 1 Set")) {
                swap(client, "Smith All Sets", option, target);
            }
        }

        if (config.getSwapTanning() && option.equalsIgnoreCase("Tan 1")) {
            swap(client, "Tan All", option, target);
        }

        if (config.getSwapCrafting() && option.equalsIgnoreCase("Make-1")) {
            swap(client, "Make-All", option, target);
        }

        if (config.getSwapSawmill() && target.equalsIgnoreCase("Sawmill operator")) {
            swap(client, "Buy-plank", option, target);
        }

        if (config.getSwapSawmillPlanks() && option.equalsIgnoreCase("Buy 1")) {
            swap(client, "Buy All", option, target);
        }

        if (config.getSwapStairs() && option.equalsIgnoreCase("Climb Stairs")) {
            swap(client, "Climb Up Stairs", option, target);
        }

        if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("Bank Filler")) {
            swap(client, "Clear", option, target);
        }

        if (target.toLowerCase().contains("ardougne cloak") && config.getSwapArdougneCape()) {
            swap(client, "Kandarin Monastery", option, target);
            swap(client, "Monastery Teleport", option, target);
        }

        if (config.getSwapEssencePouch()) {
            if (isEssencePouch(target)) {
                Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
                switch (config.getEssenceMode()) {
                    case RUNECRAFTING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swap(client, "Empty", option, target);
                        } else {
                            swap(client, "Fill", option, target);
                        }
                        break;
                    case ESSENCE_MINING:
                        if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) {
                            swap(client, "Fill", option, target);
                        } else {
                            swap(client, "Empty", option, target);
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
                        swap(client, GamesNecklaceMode.BURTHORPE.toString(), option, target);
                        break;
                    case BARBARIAN_OUTPOST:
                        swap(client, GamesNecklaceMode.BARBARIAN_OUTPOST.toString(), option, target);
                        break;
                    case CORPOREAL_BEAST:
                        swap(client, GamesNecklaceMode.CORPOREAL_BEAST.toString(), option, target);
                        break;
                    case TEARS_OF_GUTHIX:
                        swap(client, GamesNecklaceMode.TEARS_OF_GUTHIX.toString(), option, target);
                        break;
                    case WINTERTODT:
                        swap(client, GamesNecklaceMode.WINTERTODT.toString(), option, target);
                        break;
                    default:
                        break;
                }
            }
        }

        if (config.getDuelingRing()) {
            if (target.toLowerCase().contains("ring of dueling")) {
                switch (config.getDuelingRingMode()) {
                    case DUEL_ARENA:
                        swap(client, DuelingRingMode.DUEL_ARENA.toString(), option, target);
                        break;
                    case CASTLE_WARS:
                        swap(client, DuelingRingMode.CASTLE_WARS.toString(), option, target);
                        break;
                    case CLAN_WARS:
                        swap(client, DuelingRingMode.CLAN_WARS.toString(), option, target);
                        break;
                    default:
                        break;
                }
            }
        }

		if (config.getWealthRing()) {
            if (target.toLowerCase().contains("ring of wealth")) {
                switch (config.getWealthRingMode()) {
                    case MISCELLANIA:
                        swap(client, WealthRingMode.MISCELLANIA.toString(), option, target);
                        break;
                    case GRAND_EXCHANGE:
                        swap(client, WealthRingMode.GRAND_EXCHANGE.toString(), option, target);
                        break;
                    case FALADOR:
                        swap(client, WealthRingMode.FALADOR.toString(), option, target);
                        break;
					case DONDAKAN:
                        swap(client, WealthRingMode.DONDAKAN.toString(), option, target);
                        break;
                    default:
                        break;
                }
            }
        }	

        if (config.getGlory()) {
            if (target.toLowerCase().contains("amulet of glory")) {
                switch (config.getGloryMode()) {
                    case EDGEVILLE:
                        swap(client, GloryMode.EDGEVILLE.toString(), option, target);
                        break;
                    case KARAMJA:
                        swap(client, GloryMode.KARAMJA.toString(), option, target);
                        break;
                    case DRAYNOR_VILLAGE:
                        swap(client, GloryMode.DRAYNOR_VILLAGE.toString(), option, target);
                        break;
                    case AL_KHARID:
                        swap(client, GloryMode.AL_KHARID.toString(), option, target);
                        break;
                    default:
                        break;
                }
            }
        }

        if (target.toLowerCase().contains("crafting cape") && config.getSwapCraftingCape()) {
            swap(client, "Teleport", option, target);

        }

        if (target.toLowerCase().contains("construct. cape") && config.getSwapConstructionCape()) {
            swap(client, "Tele to poh", option, target);

        }
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
