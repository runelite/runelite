package net.runelite.client.plugins.ironbank;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


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

    @Inject
    private ItemManager itemManager;

    private NavigationButton navButton;

    private IronBankSharingPanel ironBankSharingPanel;

    private static final Logger log = LoggerFactory.getLogger(IronBankPlugin.class);


    private Path getDataFilePath() {
        return Paths.get(System.getProperty("user.home"), ".runelite", "ironBankSharingData.json");
    }


    private void saveBankItems(List<Item> bankItems) {
        Gson gson = new Gson();
        String serializedBankItems = gson.toJson(bankItems);
        try {
            Files.write(getDataFilePath(), serializedBankItems.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.warn("Failed to save bank items", e);
        }
    }

    private List<Item> loadBankItems() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Item>>() {}.getType();
        Path dataFilePath = getDataFilePath();
        if (!Files.exists(dataFilePath)) {
            return Collections.emptyList();
        }
        try {
            String serializedBankItems = new String(Files.readAllBytes(dataFilePath), StandardCharsets.UTF_8);
            return gson.fromJson(serializedBankItems, listType);
        } catch (IOException e) {
            log.warn("Failed to load bank items", e);
            return Collections.emptyList();
        }
    }



    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event) {
        if (event.getGroupId() == WidgetID.BANK_GROUP_ID) {
            List<Item> bankItems = getBankItems();
            for (Item item : bankItems) {
                ItemComposition itemComposition = client.getItemDefinition(item.getId());
                String itemName = itemComposition.getName();
                int itemId = item.getId();
                int itemQuantity = item.getQuantity();

                System.out.println("Item ID: " + itemId + ", Item Name: " + itemName + ", Quantity: " + itemQuantity);
            }
            saveBankItems(bankItems);
        }
    }

    @Override
    protected void startUp() throws Exception {

        ironBankSharingPanel = new IronBankSharingPanel(itemManager);
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
                .filter(item -> item.getId() >= 0)
                .collect(Collectors.toList());
    }

    private void displaySharedBankWindow() {
        if (ironBankSharingPanel == null) {
            ironBankSharingPanel = new IronBankSharingPanel(itemManager);
            final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "calc.png");
            navButton = NavigationButton.builder()
                    .tooltip("Group Ironman Bank")
                    .icon(icon)
                    .priority(1)
                    .panel(ironBankSharingPanel)
                    .build();

            clientToolbar.addNavigation(navButton);
        }
    }


    private NavigationButton createNavigationButton() {
        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "calc.png");

        List<Item> items = loadBankItems();
        ironBankSharingPanel.updateItems(client, items);
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