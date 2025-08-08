package net.runelite.client.plugins.fancyflip;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.swing.Timer;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.fancyflip.ledger.LedgerService;
import net.runelite.client.plugins.fancyflip.ui.FancyFlipPanel;
import net.runelite.client.plugins.fancyflip.wealth.WealthService;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
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

    private boolean sessionStarted = false;

    @Override
    protected void startUp()
    {
        try
        {
            panel = new FancyFlipPanel();

            ledger = new LedgerService(config.taxRatePct());
            wealth = new WealthService(client);
            wealth.refreshCommittedGp();

            // init panel from config
            panel.setSellOnly(config.sellOnly());
            panel.setF2pOnly(config.f2pOnly());
            panel.setBlocklistCsv(config.blocklistCsv());

            // persist panel changes back to config
            panel.addSellOnlyListener(e ->
                configManager.setConfiguration("fancyflip", "sellOnly", panel.isSellOnly()));
            panel.addF2pOnlyListener(e ->
                configManager.setConfiguration("fancyflip", "f2pOnly", panel.isF2pOnly()));
            panel.addBlocklistListener(() ->
                configManager.setConfiguration("fancyflip", "blocklistCsv", panel.getBlocklistCsv()));
            panel.addResetListener(() -> {
                ledger.reset();
                sessionStarted = true;      // user explicitly starts a session
                wealth.refreshCommittedGp();
                sampleWealthNow();
            });

            // load icon (fallback if missing)
            BufferedImage icon;
            try
            {
                icon = ImageUtil.loadImageResource(FancyFlipPlugin.class, "pixel-diamond.png");
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
                .icon(icon)
                .panel(panel)
                .priority(5)
                .build();

            clientToolbar.addNavigation(navButton);

            // 1s UI tick
            uiTick = new Timer(1000, e -> {
                long totalWealth = wealth.getTotalWealth(config.includeBankCoins(), 0);
                panel.setProfit(ledger.getProfitGp());
                panel.setRoi(ledger.getSessionRoiPct());
                panel.setFlips(ledger.getFlipsClosed());
                panel.setTax(ledger.getTaxGp());
                panel.setSessionTime(sessionStarted ? ledger.getSessionTimeHms() : "00:00:00");
                panel.setHourly(ledger.getHourlyProfitGp());
                panel.setCurrentWealth(totalWealth);
                panel.setAvgWealth(sessionStarted ? ledger.getAvgWealthGp() : 0);
            });
            uiTick.start();

            // 60s wealth sample
            wealthTick = new Timer(60_000, e -> {
                if (sessionStarted)
                {
                    ledger.sampleWealth(wealth.getTotalWealth(config.includeBankCoins(), 0));
                }
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
            if (navButton != null) clientToolbar.removeNavigation(navButton);
        }
        finally
        {
            navButton = null;
            panel = null;
            uiTick = null;
            wealthTick = null;
            ledger = null;
            wealth = null;
            sessionStarted = false;
            log.info("FancyFlip stopped");
        }
    }

    // Start session on first successful login
    @Subscribe
    public void onGameStateChanged(GameStateChanged e)
    {
        if (e.getGameState() == GameState.LOGGED_IN && !sessionStarted)
        {
            ledger.reset();          // sets sessionStart = now
            sessionStarted = true;
            sampleWealthNow();       // seed avg wealth immediately
        }
    }

    @Subscribe
    public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged e)
    {
        if (wealth != null)
        {
            wealth.onGrandExchangeOfferChanged(e);
            if (sessionStarted) sampleWealthNow();
        }
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded e)
    {
        if (wealth == null) return;

        // Let WealthService handle snapshots (bank)
        wealth.onWidgetLoaded(e);

        // Sample immediately on bank or inventory open/reload
        int gid = e.getGroupId();
        if (gid == WidgetID.BANK_GROUP_ID || gid == WidgetID.INVENTORY_GROUP_ID)
        {
            if (!sessionStarted)
            {
                // if player opens inv/bank before login event fired, start session here
                ledger.reset();
                sessionStarted = true;
            }
            sampleWealthNow();
        }
    }

    // Helper: take an immediate sample and push key UI fields
    private void sampleWealthNow()
    {
        long total = wealth.getTotalWealth(config.includeBankCoins(), 0);
        ledger.sampleWealth(total);
        panel.setCurrentWealth(total);
        panel.setAvgWealth(ledger.getAvgWealthGp());
        panel.setSessionTime(ledger.getSessionTimeHms());
    }

    @Provides
    FancyFlipConfig provideConfig(ConfigManager cm)
    {
        return cm.getConfig(FancyFlipConfig.class);
    }
}
