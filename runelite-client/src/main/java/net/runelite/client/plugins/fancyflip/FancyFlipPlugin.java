/*
 * Copyright (c) 2025, Codex <codex@openai.com>
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
package net.runelite.client.plugins.fancyflip;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.swing.Timer;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.fancyflip.ledger.LedgerService;
import net.runelite.client.plugins.fancyflip.ui.FancyFlipPanel;
import net.runelite.client.plugins.fancyflip.wealth.WealthService;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import java.awt.image.BufferedImage;
import net.runelite.client.util.ImageUtil;


@Slf4j
@PluginDescriptor(
        name = "FancyFlip",
        description = "Flip assistant with directives and KPIs",
        tags = {"ge","flip","market","profit"}
)
public class FancyFlipPlugin extends Plugin
{
    @Inject private Client client;
    @Inject private ClientToolbar clientToolbar;
    @Inject private FancyFlipConfig config;
    @Inject private ConfigManager configManager;

    private NavigationButton navButton;
    private FancyFlipPanel panel;
    private LedgerService ledger;
    private WealthService wealth;
    private Timer uiTick, wealthTick;

   @Override
protected void startUp()
{
    log.info("FancyFlip starting...");
    try
    {
        panel = new FancyFlipPanel();

        ledger = new LedgerService(config.taxRatePct());
        wealth = new WealthService(client);
        wealth.refreshCommittedGp();

        panel.setSellOnly(config.sellOnly());
        panel.setF2pOnly(config.f2pOnly());
        panel.setBlocklistCsv(config.blocklistCsv());

        panel.addSellOnlyListener(e ->
            configManager.setConfiguration("fancyflip", "sellOnly", panel.isSellOnly()));
        panel.addF2pOnlyListener(e ->
            configManager.setConfiguration("fancyflip", "f2pOnly", panel.isF2pOnly()));
        panel.addBlocklistListener(() ->
            configManager.setConfiguration("fancyflip", "blocklistCsv", panel.getBlocklistCsv()));
        panel.addResetListener(() -> {
            ledger.reset();
            wealth.refreshCommittedGp();
        });

        BufferedImage icon;
        try
        {
            icon = ImageUtil.loadImageResource(
                FancyFlipPlugin.class, "pixel-diamond.png"
            );
            if (icon == null)
            {
                icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            }
        }
        catch (Exception ex)
        {
            log.warn("Icon load failed, using fallback", ex);
            icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        }

        navButton = NavigationButton.builder()
            .tooltip("FancyFlip")
            .icon(icon)          // guaranteed non-null
            .panel(panel)        // non-null
            .priority(5)
            .build();

        clientToolbar.addNavigation(navButton);

        uiTick = new Timer(1000, e -> {
            panel.setProfit(ledger.getProfitGp());
            panel.setRoi(ledger.getSessionRoiPct());
            panel.setFlips(ledger.getFlipsClosed());
            panel.setTax(ledger.getTaxGp());
            panel.setSessionTime(ledger.getSessionTimeHms());
            panel.setHourly(ledger.getHourlyProfitGp());
            panel.setAvgWealth(ledger.getAvgWealthGp());
        });
        uiTick.start();

        wealthTick = new Timer(60_000, e -> {
            ledger.sampleWealth(wealth.getTotalWealth(config.includeBankCoins(), 0));
        });
        wealthTick.start();

        log.info("FancyFlip started.");
    }
    catch (Throwable t)
    {
        log.error("FancyFlip failed to start", t);
    }
}


@Override
protected void shutDown()
{
    try
    {
        if (uiTick != null) uiTick.stop();
        if (wealthTick != null) wealthTick.stop();
        if (navButton != null)
        {
            clientToolbar.removeNavigation(navButton);
        }
    }
    finally
    {
        navButton = null;
        panel = null;
        uiTick = null;
        wealthTick = null;
        ledger = null;
        wealth = null;
        log.info("FancyFlip stopped");
    }
}

    @Subscribe
    public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged e)
    {
        if (wealth != null) wealth.onGrandExchangeOfferChanged(e);
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded e)
    {
        if (wealth != null) wealth.onWidgetLoaded(e);
    }

    @Provides
    FancyFlipConfig provideConfig(ConfigManager cm) { return cm.getConfig(FancyFlipConfig.class); }
}
