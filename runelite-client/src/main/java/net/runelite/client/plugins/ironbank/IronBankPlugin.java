package net.runelite.client.plugins.ironbank;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;


@PluginDescriptor(
        name = "Iron Bank",
        description = "Share personal bank information with GIM"
)
public class IronBankPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ClientUI clientUI;

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ConfigManager configManager;

    @Inject
    private PluginManager pluginManager;

    private NavigationButton navButton;

    private IronBankSharingPanel ironBankSharingPanel;

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event) {
        if (event.getGroupId() == WidgetID.BANK_GROUP_ID) {
            List<Item> bankItems = getBankItems();
            shareBankItemsWithGroup(bankItems);
        }
    }

    @Override
    protected void startUp() throws Exception {
        ironBankSharingPanel = new IronBankSharingPanel();
        NavigationButton navButton = createNavigationButton();
        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception {
        clientToolbar.removeNavigation(navButton);
    }

    private List<Item> getBankItems() {
        Widget bankItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
        if (bankItemContainer == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(bankItemContainer.getDynamicChildren())
                .map(widget -> new Item(widget.getItemId(), widget.getItemQuantity()))
                .collect(Collectors.toList());
    }

    private void displaySharedBankWindow(List<Item> items) {
        if (ironBankSharingPanel == null) {
            ironBankSharingPanel = new IronBankSharingPanel();
            final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "calc.png");
            navButton = NavigationButton.builder()
                    .tooltip("Group Ironman Bank")
                    .icon(icon)
                    .priority(1)
                    .panel(ironBankSharingPanel)
                    .build();

            clientToolbar.addNavigation(navButton);        }
        ironBankSharingPanel.updateItems(client, items);
    }

    private void shareBankItemsWithGroup(List<Item> items) {
        displaySharedBankWindow(items);
    }

    private NavigationButton createNavigationButton() {
        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "calc.png");

        // Create the navigation button
        NavigationButton navButton = NavigationButton.builder()
                .tooltip("Your Plugin Name")
                .icon(icon)
                .priority(1)
                .panel(ironBankSharingPanel)
                .build();
        return navButton;
    }



}