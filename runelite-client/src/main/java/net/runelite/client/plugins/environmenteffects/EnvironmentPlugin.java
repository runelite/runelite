/*
 * Copyright (c) 2020, Macweese <macweese@pm.me>
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

package net.runelite.client.plugins.environmenteffects;

import java.util.Set;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.image.BufferedImage;

import net.runelite.api.*;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import com.google.inject.Provides;
import com.google.common.collect.ImmutableSet;

import net.runelite.api.coords.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.ItemComposition;
import net.runelite.client.plugins.Plugin;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.overlay.infobox.*;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;

import static net.runelite.api.widgets.WidgetInfo.*;
import static net.runelite.api.widgets.WidgetInfo.SMOKE_SCREEN_OVERLAY;

@PluginDescriptor(
        name = "Environment Effects",
        description = "Customise the visual behaviour of the game environment",
        tags = {"screen", "effects", "display", "visual", "environment", "status", "warning", "infobox"}
)

/**
 * @TODO
 * 1. Find out if there's a variable for blizzard damage
 * 2. Find out if there's a Varbit for Fire pit (Unseasonal warmth)
 * 3. Investigate camera bobbing & shake from fishing trawler & CoX, and implement into plugin if possible
 *
 * code clean up & improve performance
 */
@Slf4j
@Singleton
public class EnvironmentPlugin extends Plugin
{

    private static final Logger logger = LoggerFactory.getLogger(WorldClient.class);

    private static final Set<Integer> SMOKE_MASK = ImmutableSet.of(
            4164,                                   //  FACE MASK
            11864, 11865,                           //  SLAYER HELMET
            19639, 19641,                           //  BLACK SLAYER  SLAYER HELMET
            19643, 19645,                           //  GREEN SLAYER HELMET
            19647, 19469,                           //  RED SLAYER HELMET
            21264, 21266,                           //  PURPLE SLAYER HELMET
            21888, 21890,                           //  TURQUISE SLAYER HELMET
            23073, 23075,                           //  HYDRA SLAYER HELMET
            24370, 24444                            //  TWISTED SLAYER HELMET
    );

    private static final Set<Integer> BLIZZARD_REGION = ImmutableSet.of(
            11322, 11323, 11578, 11579              //  ICE PATH + GWD SURFACE(ENTRANCE)
    );

    private static final Set<Integer> INSECT_REGION = ImmutableSet.of(
            13206, 12950,                           //  DORGESH-KAAN MINE
            9358, 9359, 9360, 9615, 9616, 9871,     //  KRUK'S DUNGEON
            12693, 12949                            //  LUMBRIDGE SWAMP CAVE
    );

    private static final Set<Integer> SMOKE_REGION = ImmutableSet.of(
            9619, 9363,                             //  THERMONUCLEAR SMOKE DUNGEON
            13202, 12946                            //  POLLIVNEACH SMOKE DUNGEON
    );

    private static final Set<Integer> ZAMORAK_REGION = ImmutableSet.of(
            11603                                   //  ZAMORAK GOD WARS CHAMBER
    );

    private static final Set<Integer> MOLE_REGION = ImmutableSet.of(
            6993, 6993                              //  GIANT MOLE LAIR
    );

    private static final Set<Integer> HORROR_REGION = ImmutableSet.of(
            14994, 14995, 15251                     //  MOS LE'HARMLESS CAVE
    );

    @Inject
    private ClientThread clientThread;

    @Inject
    private EnvironmentConfig config;

    @Inject
    private InfoBoxManager infoBoxManager;

    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    private BufferedImage blizzardImage;
    private BufferedImage lightImage;

    private int regionID;

    private WarningBox warningBox = null;

    private boolean renderSmoke;
    private boolean renderSnow;
    private boolean renderNight;
    private boolean renderLight;
    private boolean renderBobbing;
    private boolean renderQuake;

    private Widget event = null;

    @Provides
    EnvironmentConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(EnvironmentConfig.class);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        updateConfig();
    }

    public void updateConfig()
    {
        renderSmoke = config.smokeEffect();
        renderSnow = config.snowEffect();
        renderNight = config.nightVision();
        renderLight = config.zamorakEffect();
/*
        renderBobbing = config.fishingTrawler();
        renderQuake = config.olmShake();
*/
    }

    @Override
    protected void startUp() throws Exception
    {
        onStart();
        clientThread.invokeLater(() ->
        {
            final ItemContainer itemSlot = client.getItemContainer(InventoryID.EQUIPMENT);

            if (itemSlot != null)
            {
                processEquipment(itemSlot.getItems());
            }
        });

    }

    @Override
    protected void shutDown() throws Exception
    {
        infoBoxManager.removeInfoBox(warningBox);
        warningBox= null;
        onTerminate();
    }

    /*
    Pending widgetHiddenChanged won't produce widgetEvent
    Replace with method with less intensive one
     */
    @Subscribe
    public void onGameTick(GameTick gameTick) throws Exception
    {
        WorldPoint localWorld = client.getLocalPlayer().getWorldLocation();
        regionID = localWorld.getRegionID();

        if (snowRegion(regionID) && client.getWidget(SNOW_SCREEN_OVERLAY) != null)
            client.getWidget(SNOW_SCREEN_OVERLAY).setHidden(renderSnow);

        if (insectRegion(regionID))
        {
            if (client.getWidget(DUNGEON_DARKNESS_1) != null)
                client.getWidget(DUNGEON_DARKNESS_1).setHidden(renderNight);

            if (client.getWidget(DUNGEON_DARKNESS_2) != null)
                client.getWidget(DUNGEON_DARKNESS_2).setHidden(renderNight);

            if (client.getWidget(DUNGEON_DARKNESS_3) != null)
                client.getWidget(DUNGEON_DARKNESS_3).setHidden(renderNight);
        }

        if (zamorakRegion(regionID) && client.getWidget(ZAMORAK_DARKNESS_OVERLAY) != null)
            client.getWidget(ZAMORAK_DARKNESS_OVERLAY).setHidden(renderLight);

        if (smokeRegion(regionID) && client.getWidget(SMOKE_SCREEN_OVERLAY) != null)
            client.getWidget(SMOKE_SCREEN_OVERLAY).setHidden(renderSmoke);

        if (smokeRegion(regionID) || snowRegion(regionID) || insectRegion(regionID))
            updateInfobox();
        else removeInfobox();

    }

    /*
    When entering/leaving region with new overlay
    contingency - remove to expedite performance
     */
    @Subscribe
    public void onWidgetHiddenChanged (WidgetHiddenChanged widgetHiddenChanged)
    {
        event = widgetHiddenChanged.getWidget();

        if (renderSnow && event.getId() == SNOW_SCREEN_OVERLAY.getId() && inRegion())
        {
            hideWidget(event, true);
            updateInfobox();
        }

        if (renderSmoke && event.getId() == SMOKE_SCREEN_OVERLAY.getId() && inRegion())
        {
            hideWidget(event, true);
            updateInfobox();
        }

        if (renderLight && event.getId() == ZAMORAK_DARKNESS_OVERLAY.getId() && inRegion())
        {
            hideWidget(event, true);
            updateInfobox();
        }

        if (renderNight && event.getId() == DUNGEON_DARKNESS_1.getId() && inRegion()
                || renderNight && event.getId() == DUNGEON_DARKNESS_2.getId() && inRegion()
                || renderNight && event.getId() == DUNGEON_DARKNESS_3.getId() && inRegion())
        {
            hideWidget(event, true);
            updateInfobox();
        }

    }

    private void onStart()
    {
        updateConfig();
        if (client.getWidget(SNOW_SCREEN_OVERLAY) != null)
            client.getWidget(SNOW_SCREEN_OVERLAY).setHidden(renderSnow);

        if (client.getWidget(DUNGEON_DARKNESS_1) != null)
            client.getWidget(DUNGEON_DARKNESS_1).setHidden(renderNight);

        if (client.getWidget(DUNGEON_DARKNESS_2) != null)
            client.getWidget(DUNGEON_DARKNESS_2).setHidden(renderNight);

        if (client.getWidget(DUNGEON_DARKNESS_3) != null)
            client.getWidget(DUNGEON_DARKNESS_3).setHidden(renderNight);

        if (client.getWidget(ZAMORAK_DARKNESS_OVERLAY) != null)
            client.getWidget(ZAMORAK_DARKNESS_OVERLAY).setHidden(renderLight);

        if (client.getWidget(SMOKE_SCREEN_OVERLAY) != null)
            client.getWidget(SMOKE_SCREEN_OVERLAY).setHidden(renderSmoke);
    }

    private void onTerminate()
    {
        if (client.getWidget(SNOW_SCREEN_OVERLAY) != null)
            client.getWidget(SNOW_SCREEN_OVERLAY).setHidden(false);

        if (client.getWidget(DUNGEON_DARKNESS_1) != null)
            client.getWidget(DUNGEON_DARKNESS_1).setHidden(false);

        if (client.getWidget(DUNGEON_DARKNESS_2) != null)
            client.getWidget(DUNGEON_DARKNESS_2).setHidden(false);

        if (client.getWidget(DUNGEON_DARKNESS_3) != null)
            client.getWidget(DUNGEON_DARKNESS_3).setHidden(false);

        if (client.getWidget(ZAMORAK_DARKNESS_OVERLAY) != null)
            client.getWidget(ZAMORAK_DARKNESS_OVERLAY).setHidden(false);

        if (client.getWidget(SMOKE_SCREEN_OVERLAY) != null)
            client.getWidget(SMOKE_SCREEN_OVERLAY).setHidden(false);
    }

    private void hideWidget(Widget widget, boolean hidden)
    {
        if (widget != null)
            widget.setHidden(true);
    }

    public boolean inRegion()
    {
        WorldPoint localWorld = client.getLocalPlayer().getWorldLocation();
        regionID = localWorld.getRegionID();

        if (insectRegion(regionID))
            return true;

        else if (smokeRegion(regionID))
            return true;

        else if (snowRegion(regionID))
            return true;

        else if (zamorakRegion(regionID))
            return true;

        else return false;

/*     else if (trawlerRegion(regionID))
            return true;

        else if (olmRegion(regionID))
            return true;
*/
    }

    public boolean smokeRegion(int regionID)
    {
        HashSet<Integer> SMOKE_REGIONS = new HashSet<Integer>(SMOKE_REGION);
        return SMOKE_REGIONS.contains(regionID);
    }

    public boolean snowRegion(int regionID)
    {
        HashSet<Integer> BLIZZARD_REGIONS = new HashSet<Integer>(BLIZZARD_REGION);
        return BLIZZARD_REGIONS.contains(regionID);
    }

    public boolean zamorakRegion(int regionID)
    {
        HashSet<Integer> ZAMORAK_REGIONS = new HashSet<Integer>(ZAMORAK_REGION);
        return ZAMORAK_REGIONS.contains(regionID);
    }

    public boolean insectRegion(int regionID)
    {
        HashSet<Integer> INSECT_REGIONS = new HashSet<Integer>();
        INSECT_REGIONS.addAll(INSECT_REGION);

        HashSet<Integer> HORROR_REGIONS = new HashSet<Integer>();
        HORROR_REGIONS.addAll(HORROR_REGION);

        HashSet<Integer> MOLE_REGIONS = new HashSet<Integer>();
        MOLE_REGIONS.addAll(MOLE_REGION);

        return INSECT_REGIONS.contains(regionID) || HORROR_REGIONS.contains(regionID) || MOLE_REGIONS.contains(regionID);
    }

    public boolean hasFaceMask()
    {
        HashSet<Integer> SMOKE_MASKS = new HashSet<Integer>(SMOKE_MASK);
        return SMOKE_MASKS.contains(client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.HEAD));
    }

    public boolean hasLightSource(Client client)
    {
        int dungeonState = client.getVarbitValue(Varbits.DUNGEON.getId());
        return dungeonState != 3;
    }

    // remove
    private void processEquipment(final Item[] items)
    {

        if (items.length < EquipmentInventorySlot.HEAD.getSlotIdx())
        {
            removeInfobox();
            return;
        }
        Item head= items[EquipmentInventorySlot.HEAD.getSlotIdx()];
        ItemComposition comp = itemManager.getItemComposition(head.getId());

        updateInfobox();

    }

    private void updateInfobox()
    {
        removeInfobox();

        if (warningBox == null)
            {
                if (!hasFaceMask() && smokeRegion(regionID))
                {
                    final BufferedImage image = itemManager.getImage(11864);
                    warningBox = new WarningBox(this, "smoke", image);
                    infoBoxManager.addInfoBox(warningBox);
                }

                if (!hasLightSource(client) && insectRegion(regionID))
                {
                    final BufferedImage image = getLightImage();
                    warningBox = new WarningBox(this, "light", image);
                    infoBoxManager.addInfoBox(warningBox);
                }

                if (snowRegion(regionID))
                {
                    final BufferedImage image = getBlizzardImage();
                    warningBox = new WarningBox(this, "snow", image);
                    infoBoxManager.addInfoBox(warningBox);
                }
                return;
            }
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        if (event.getItemContainer() != client.getItemContainer(InventoryID.EQUIPMENT))
        {
            return;
        }

        processEquipment(event.getItemContainer().getItems());
    }

    private void removeInfobox()
    {
        infoBoxManager.removeInfoBox(warningBox);
        warningBox = null;
    }

/*
    Add fire pit
 */

    BufferedImage getBlizzardImage()
    {
        if (blizzardImage != null)
        {
            return blizzardImage;
        }
        blizzardImage = ImageUtil.getResourceStreamFromClass(getClass(), "/util/debuff_snow.png");

        return blizzardImage;
    }

    BufferedImage getLightImage()
    {
        if (lightImage != null)
        {
            return lightImage;
        }
        lightImage = ImageUtil.getResourceStreamFromClass(getClass(), "/util/debuff_insect.png");

        return lightImage;
    }

}

