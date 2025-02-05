package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.toolbox.core.VirtualMouse;
import net.runelite.client.ui.ClientToolbar;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@PluginDescriptor(
        name = "Alder Rise Plugin",
        description = "Toolbox - Woodcutting",
        tags = {"toolbox", "leveling", "woodcutting"},
        enabledByDefault = false
)
@Slf4j
public class AlderRisePlugin extends Plugin{

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ConfigManager configManager;

    @Inject
    private RuneLiteConfig runeLiteConfig;

    @Inject
    private ChatColorConfig chatColorConfig;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private Notifier notifier;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private AlderRiseConfig config;

    @Inject
    private AlderRiseOverlay overlay;

    private static final int MIN_UPDATE_INTERVAL_MS = 147;  // Min time interval between checks (100ms)
    private static final int MAX_UPDATE_INTERVAL_MS = 543;

    private VirtualMouse virtualMouse;
    private ExecutorService executorService;
    private Future<?> _task;

    @Provides
    AlderRiseConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AlderRiseConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        log.debug("onGameTick Complete");
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        log.debug("Toolbox - onChatMessage");
    }

    @Subscribe
    public void onPlayerSpawned(PlayerSpawned event)
    {
        log.debug("Toolbox - onPlayerSpawned");
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        log.debug("Toolbox - onItemContainerChanged");
    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event)
    {
        log.debug("Toolbox - onInteractingChanged");
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event)
    {
        log.debug("Toolbox - onAnimationChanged");
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);

        // Start async movement handling
        executorService = Executors.newSingleThreadExecutor();
        _task = executorService.submit(this::run_main_thread);

        log.info("startUp Complete!");
    }

    @Override
    protected void shutDown()
    {
        if (_task != null) {
            _task.cancel(true);
        }
        if (executorService != null) {
            executorService.shutdownNow();
        }

        overlayManager.remove(overlay);
        log.info("shutDown Complete!");
    }

    private void run_main_thread() {

        overlay.setup();

        while (!Thread.currentThread().isInterrupted()) {
            try {
                log.trace("run_main_thread beginning");
                // Simulate smooth mouse movement
                //Point destination = new Point(500, 300); // Example target point
                //List<Point> path = virtualMouse.getPathTo(destination.x, destination.y);
                ///virtualMouse.moveAlongPath(path);

                var _next_delay = _get_flux_capacitor_calculations();

                //overlay._run_update_logic();

                log.debug(String.format("Current Delay before Checking Again {%s}",_next_delay));
                // Sleep for a bit before next movement (this makes it human-like)
                Thread.sleep(_next_delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static final Random random = new Random();

    private int _get_flux_capacitor_calculations(){
        return _get_next_gaussian(MAX_UPDATE_INTERVAL_MS, MIN_UPDATE_INTERVAL_MS);
    }
    private int _get_next_gaussian(int minMs, int maxMs) {
        double mean = Math.log((minMs + maxMs) / 2.0); // Log-normal mean
        double stdDev = 0.5; // Tweak for more randomness

        return (int) Math.exp(mean + stdDev * random.nextGaussian());

    }
}