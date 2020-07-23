package net.runelite.client.plugins.prayer;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.*;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.concurrent.ScheduledExecutorService;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrayerPluginTest {

    @Inject
    private PrayerPlugin prayerPlugin;

    @Mock
    @Bind
    private Client client;

    @Mock
    @Bind
    private PrayerConfig config;

    @Mock
    @Bind
    private OverlayManager overlayManager;

    @Mock
    @Bind
    private InfoBoxManager infoBoxManager;

    @Mock
    @Bind
    private SpriteManager spriteManager;

    @Mock
    @Bind
    private ScheduledExecutorService executor;

    @Mock
    @Bind
    private ItemManager itemManager;

    @Before
    public void before()
    {
        Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
    }

    @Test
    public void testGetEstimatedTimeRemainingOverOneHour() {

        String expectedString = "1:19:12";

        ItemStats itemStats = new ItemStats(false, true, 1, 8,
                ItemEquipmentStats.builder()
                        .slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
                        .prayer(50)
                        .build());

        ItemContainer itemContainer = mock(ItemContainer.class);

        when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
        when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
        when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
        when(itemContainer.getItems()).thenReturn(new Item[]{ new Item(ItemID.TWISTED_BOW, 1)});
        when(itemManager.getItemStats(anyInt(), anyBoolean())).thenReturn(itemStats);

        prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
        String actualString = prayerPlugin.getEstimatedTimeRemaining(false);

        Assert.assertEquals(expectedString, actualString);
    }


    @Test
    public void testGetEstimatedTimeRemainingUnderOneHour() {

        String expectedString = "29:42";

        ItemContainer itemContainer = mock(ItemContainer.class);

        when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
        when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
        when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
        when(itemContainer.getItems()).thenReturn(new Item[]{});

        prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
        String actualString = prayerPlugin.getEstimatedTimeRemaining(false);

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testGetEstimatedTimeRemainingFormatForOrb() {

        String expectedString = "29m";

        ItemContainer itemContainer = mock(ItemContainer.class);

        when(client.isPrayerActive(Prayer.PRESERVE)).thenReturn(true);
        when(client.getBoostedSkillLevel(Skill.PRAYER)).thenReturn(99);
        when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(itemContainer);
        when(itemContainer.getItems()).thenReturn(new Item[]{});

        prayerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), itemContainer));
        String actualString = prayerPlugin.getEstimatedTimeRemaining(true);

        Assert.assertEquals(expectedString, actualString);
    }
}