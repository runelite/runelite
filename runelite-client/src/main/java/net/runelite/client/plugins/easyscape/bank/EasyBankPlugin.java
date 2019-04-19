package net.runelite.client.plugins.easy.bank;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
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
        name = "EasyBank",
        description = "EasyBank.",
        tags = {"EasyBank", "easy"}
)

@Slf4j
public class EasyBankPlugin extends Plugin {

    private Swapper swapper = new Swapper();
    private MenuEntry[] entries;

    @Inject
    private Client client;

    @Inject
    private EasyBankConfig config;

    @Provides
    EasyBankConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasyBankConfig.class);
    }

    @Override
    public void startUp() {
        log.debug("EasyBank Started.");
    }

    @Override
    public void shutDown() {
        log.debug("EasyBank Stopped.");
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

        Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

        swapper.setEntries(client.getMenuEntries());

        if (!(widgetBankTitleBar == null) && !widgetBankTitleBar.isHidden()) {

            if (config.getWithdrawOne()) {
                for (String item : config.getWithdrawOneItems().split(",")) {
                    item = item.trim();
                    if (target.equalsIgnoreCase(item)) {
                        swapper.markForSwap("Withdraw-1", option, target);
                        swapper.markForSwap("Deposit-1", option, target);
                    }
                }
            }

            if (config.getWithdrawFive()) {
                for (String item : config.getWithdrawFiveItems().split(",")) {
                    item = item.trim();
                    if (target.equalsIgnoreCase(item)) {
                        swapper.markForSwap("Withdraw-5", option, target);
                        swapper.markForSwap("Deposit-5", option, target);
                    }
                }
            }

            if (config.getWithdrawTen()) {
                for (String item : config.getWithdrawTenItems().split(",")) {
                    item = item.trim();
                    if (target.equalsIgnoreCase(item)) {
                        swapper.markForSwap("Withdraw-10", option, target);
                        swapper.markForSwap("Deposit-10", option, target);
                    }
                }
            }

            if (config.getWithdrawX()) {
                for (String item : config.getWithdrawXItems().split(",")) {
                    item = item.trim();
                    if (target.equalsIgnoreCase(item)) {
                        swapper.markForSwap("Withdraw-" + config.getWithdrawXAmount(), option, target);
                        swapper.markForSwap("Deposit-" + config.getWithdrawXAmount(), option, target);
                    }
                }
            }

            if (config.getWithdrawAll()) {
                for (String item : config.getWithdrawAllItems().split(",")) {
                    item = item.trim();
                    if (target.equalsIgnoreCase(item)) {
                        swapper.markForSwap("Withdraw-All", option, target);
                        swapper.markForSwap("Deposit-All", option, target);
                    }
                }
            }

        }

        swapper.startSwap();
        client.setMenuEntries(swapper.getEntries());
    }

}