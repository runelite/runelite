package net.runelite.client.plugins.inventoryvalue;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InventoryValuePluginTest {
    @Mock
    @Bind
    private Client client;

    @Mock
    @Bind
    private ItemManager itemManager;

    @Mock
    @Bind
    private InventoryValueConfig config;

    @Mock
    @Bind
    private OverlayManager overlayManager;

    @Mock
    @Bind
    private ScheduledExecutorService executor;

    @Mock
    private File file;


    @Inject
    InventoryValuePlugin inventoryValuePlugin;

    @Mock
    ItemContainer itemContainer;

    @Mock
    ItemComposition itemComposition;

    Item coins;
    Item testItem;

    String ignoredItemsConfig;
    List<String> ignoredItemsList;
    int itemId;
    int quantity;

    @Before
    public void before() {
        Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
    }

    @Test
    public void testBuildIgnoredItemsList() {
        // split on comma, ignore leading whitespace
        String ignoreItemsString = "foo, bar";
        when(config.ignoreItems()).thenReturn(ignoreItemsString);

        assertEquals(Arrays.asList("foo", "bar"), inventoryValuePlugin.buildIgnoredItemsList());

        // split on comma or semicolon, ignore trailing whitespace
        String ignoreItemsStringWithSemicolon = "foo,bar;baz ";
        when(config.ignoreItems()).thenReturn(ignoreItemsStringWithSemicolon);

        assertEquals(Arrays.asList("foo", "bar", "baz"), inventoryValuePlugin.buildIgnoredItemsList());

        String ignoreItemsStringWithCasing = "FOo, BaR; BAZ";
        when(config.ignoreItems()).thenReturn(ignoreItemsStringWithCasing);

        assertEquals(Arrays.asList("foo", "bar", "baz"), inventoryValuePlugin.buildIgnoredItemsList());
    }

    public void coinsValueTestSetup() {
        itemId = ItemID.COINS_995;
        quantity = 3201;
        coins = new Item(itemId, quantity);
        ignoredItemsList = Collections.emptyList();

        when(itemComposition.getName()).thenReturn("Coins");
        when(itemManager.getItemPrice(itemId)).thenReturn(1);
        when(itemManager.getItemComposition(itemId)).thenReturn(itemComposition);
    }

    @Test
    public void testCoinsIgnoredWhenIgnoreCoinsIsSet() {
        coinsValueTestSetup();

        when(config.ignoreCoins()).thenReturn(true);

        assertEquals(0, inventoryValuePlugin.calculateItemValue(coins, ignoredItemsList));
    }

    @Test
    public void testCoinsNotIgnoredWhenIgnoreCoinsIsNotSet() {
        coinsValueTestSetup();

        when(config.ignoreCoins()).thenReturn(false);

        assertEquals(quantity, inventoryValuePlugin.calculateItemValue(coins, ignoredItemsList));
    }

    public void ignoreItemTestSetup(int itemId, String itemName, int itemValue) {
        quantity = 1;
        testItem = new Item(itemId, quantity);
        ignoredItemsConfig = "Bottomless compost bucket, Leather chaps";
        ignoredItemsList = Arrays.asList("bottomless compost bucket", "leather chaps");

        when(itemComposition.getName()).thenReturn(itemName);
        when(itemManager.getItemPrice(itemId)).thenReturn(itemValue);
        when(itemManager.getItemComposition(itemId)).thenReturn(itemComposition);
    }

    @Test
    public void testItemNotIgnoredWhenNotInIgnoredItems() {
        int testItemValue = 40000000;
        ignoreItemTestSetup(ItemID.SARADOMIN_GODSWORD, "Saradomin godsword", testItemValue);

        assertEquals(testItemValue, inventoryValuePlugin.calculateItemValue(testItem, ignoredItemsList));
    }

    @Test
    public void testItemIgnoredWhenInIgnoredItems() {
        int testItemValue = 300000;
        ignoreItemTestSetup(ItemID.BOTTOMLESS_COMPOST_BUCKET, "Bottomless compost bucket", testItemValue);

        assertEquals(0, inventoryValuePlugin.calculateItemValue(testItem, ignoredItemsList));
    }
}
