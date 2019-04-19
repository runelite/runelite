package net.runelite.client.plugins.easy.shop;


import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.easy.util.Swapper;
import net.runelite.client.util.Text;

import javax.inject.Inject;

@PluginDescriptor(
        name = "EasyShop",
        description = "EasyShop.",
        tags = {"EasyShop", "easy"}
)

@Slf4j
public class EasyShopPlugin extends Plugin {

    private Swapper swapper = new Swapper();

    @Inject
    private Client client;

    @Inject
    private EasyShopConfig config;

    @Provides
    EasyShopConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasyShopConfig.class);
    }

    @Override
    public void startUp() {
        log.debug("EasyShop Started.");
    }

    @Override
    public void shutDown() {
        log.debug("EasyShop Stopped.");
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

        swapper.setEntries(client.getMenuEntries());

        if (config.getSwapBuyOne() && !config.getBuyOneItems().equals("")) {
            for (String item : config.getBuyOneItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Buy 1", option, target);
                }
            }
        }

        if (config.getSwapBuyFive() && !config.getBuyFiveItems().equals("")) {
            for (String item : config.getBuyFiveItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Buy 5", option, target);
                }
            }
        }

        if (config.getSwapBuyTen() && !config.getBuyTenItems().equals("")) {
            for (String item : config.getBuyTenItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Buy 10", option, target);
                }
            }
        }

        if (config.getSwapBuyFifty() && !config.getBuyFiftyItems().equals("")) {
            for (String item : config.getBuyFiftyItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Buy 50", option, target);
                }
            }
        }

        if (config.getSwapSellOne() && !config.getSellOneItems().equals("")) {
            for (String item : config.getSellOneItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Sell 1", option, target);
                }
            }
        }

        if (config.getSwapSellFive() && !config.getSellFiveItems().equals("")) {
            for (String item : config.getSellFiveItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Sell 5", option, target);
                }
            }
        }

        if (config.getSwapSellTen() && !config.getSellTenItems().equals("")) {
            for (String item : config.getSellTenItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Sell 10", option, target);
                }
            }
        }

        if (config.getSwapSellFifty() && !config.getSellFiftyItems().equals("")) {
            for (String item : config.getSellFiftyItems().split(",")) {
                if (target.equalsIgnoreCase(item.trim())) {
                    swapper.markForSwap("Sell 50", option, target);
                }
            }
        }

        swapper.startSwap();
        client.setMenuEntries(swapper.getEntries());
    }


}
