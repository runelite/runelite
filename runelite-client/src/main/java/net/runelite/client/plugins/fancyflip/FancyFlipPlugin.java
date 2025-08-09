package net.runelite.client.plugins.fancyflip;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.callback.ClientThread;
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
    @Inject private ClientThread clientThread;
    @Inject private FancyFlipConfig config;
    @Inject private ConfigManager configManager;

    private NavigationButton navButton;
    private FancyFlipPanel panel;
    private LedgerService ledger;
    private WealthService wealth;
    private Timer uiTick;

    private boolean sessionStarted = false;

    @Override
    protected void startUp()
    {
        try
        {
            panel = new FancyFlipPanel();

            ledger = new LedgerService(config.taxRatePct());
            wealth = new WealthService(client);
            wealth.setLedger(ledger);
            wealth.refreshCommittedGp();

            // init panel from config
            panel.setSellOnly(config.sellOnly());
            panel.setF2pOnly(config.f2pOnly());
            panel.setBlocklistCsv(config.blocklistCsv());

            // persist panel changes to config
            panel.addSellOnlyListener(e ->
                    configManager.setConfiguration("fancyflip", "sellOnly", panel.isSellOnly()));
            panel.addF2pOnlyListener(e ->
                    configManager.setConfiguration("fancyflip", "f2pOnly", panel.isF2pOnly()));
            panel.addBlocklistListener(() ->
                    configManager.setConfiguration("fancyflip", "blocklistCsv", panel.getBlocklistCsv()));
            panel.addResetListener(() -> {
                ledger.reset();
                sessionStarted = true;
                wealth.refreshCommittedGp();
                sampleWealthNow();
            });

            // icon (fallback safe)
            BufferedImage icon;
            try
            {
                icon = ImageUtil.loadImageResource(FancyFlipPlugin.class, "pixel-diamond.png");
                if (icon == null) icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
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

            // 1s UI tick: read on client thread, update on EDT
            uiTick = new Timer(1000, e ->
                    clientThread.invoke(() -> {
                        // Compute Liquidity and Asset Total
                        long liquidity = wealth.getLiquidityGp();
                        long openPosValueGp = 0L; // TODO: sum open SELLs + item valuations when wired
                        long assetTotal = wealth.getAssetTotalGp();

                        SwingUtilities.invokeLater(() -> {
                            panel.setProfit(ledger.getProfitGp());
                            panel.setRoi(ledger.getSessionRoiPct());
                            panel.setFlips(ledger.getFlipsClosed());
                            panel.setTax(ledger.getTaxGp());
                            panel.setHourly(ledger.getHourlyProfitGp());

                            panel.setLiquidity(liquidity);
                            panel.setAssetTotal(assetTotal);

                            panel.setSessionTime(sessionStarted ? ledger.getSessionTimeHms() : "--:--:--");
                        });
                    })
            );
            uiTick.start();

            
            log.info("FancyFlip started.");
        }
        catch (Throwable t)
        {
            log.error("FancyFlip failed to start", t);
        }
    }

    private void ensureSessionStarted()
    {
        if (!sessionStarted)
        {
            ledger.reset(); // sets sessionStart = now
            sessionStarted = true;
        }
    }

    @Override
    protected void shutDown()
    {
        try
        {
            if (uiTick != null) uiTick.stop();
            if (navButton != null) clientToolbar.removeNavigation(navButton);
        }
        finally
        {
            navButton = null;
            panel = null;
            uiTick = null;
            
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
            ensureSessionStarted();
            sampleWealthNow();
        }
    }

    @Subscribe
    public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged e)
    {
        // event is delivered on client thread; keep logic light
        if (wealth != null)
        {
            wealth.onGrandExchangeOfferChanged(e);
            if (sessionStarted) sampleWealthNow();
        }
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded e)
    {
        // event is on client thread
        if (wealth == null) return;

        wealth.onWidgetLoaded(e); // bank snapshot inside

        int gid = e.getGroupId();
        if (gid == WidgetID.BANK_GROUP_ID
                || gid == WidgetID.INVENTORY_GROUP_ID
                || gid == WidgetID.GRAND_EXCHANGE_GROUP_ID) // history is same group
        {
            sampleWealthNow();
        }
    }

    // Immediate sample: compute and push Liquidity & Asset Total
    private void sampleWealthNow()
    {
        ensureSessionStarted();
        clientThread.invoke(() -> {
            long liquidity = wealth.getLiquidityGp();
            long assetTotal = wealth.getAssetTotalGp();
            SwingUtilities.invokeLater(() -> {
                panel.setLiquidity(liquidity);
                panel.setAssetTotal(assetTotal);
                panel.setSessionTime(ledger.getSessionTimeHms());
            });
        });
    }

    @Provides
    FancyFlipConfig provideConfig(ConfigManager cm)
    {
        return cm.getConfig(FancyFlipConfig.class);
    }
}