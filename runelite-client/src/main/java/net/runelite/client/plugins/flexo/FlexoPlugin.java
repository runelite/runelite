package net.runelite.client.plugins.flexo;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.DefaultNoiseProvider;
import com.github.joonasvali.naturalmouse.support.DefaultOvershootManager;
import com.github.joonasvali.naturalmouse.support.DefaultSpeedManager;
import com.github.joonasvali.naturalmouse.support.Flow;
import com.github.joonasvali.naturalmouse.support.SinusoidalDeviationProvider;
import com.github.joonasvali.naturalmouse.util.FlowTemplates;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.flexo.Flexo;
import net.runelite.client.flexo.FlexoUtils;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.stretchedmode.StretchedModeConfig;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "Flexo Config",
        description = "Customizes Flexo, the MouseInput Assistant ;)",
        tags = {"flexo", "null"},
		type = PluginType.UTILITY
)
@Slf4j
public class FlexoPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private ConfigManager configManager;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private FlexoOverlay overlay;

    @Provides
    FlexoConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(FlexoConfig.class);
    }

    @Subscribe
    private void onConfigChanged(ConfigChanged event) {
        if (event.getKey().compareTo("overlayEnabled")==0) {
            if (getConfig(configManager).overlayEnabled()) {
                overlayManager.add(overlay);
            } else {
                overlayManager.remove(overlay);
            }
        }
        updateMouseMotionFactory();
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        Flexo.isStretched = client.isStretchedEnabled();
        Flexo.scale = configManager.getConfig(StretchedModeConfig.class).scalingFactor();
    }

    private void updateMouseMotionFactory() {
        Flexo.minDelay = getConfig(configManager).minDelayAmt();
        MouseMotionFactory factory = new MouseMotionFactory();
        //TODO:Add Options for various flows to allow more personalization
        List<Flow> flows = new ArrayList<>();

        //Always add random
        flows.add(new Flow(FlowTemplates.random()));

        if (getConfig(configManager).getVariatingFlow())
        flows.add(new Flow(FlowTemplates.variatingFlow()));

        if (getConfig(configManager).getSlowStartupFlow())
        flows.add(new Flow(FlowTemplates.slowStartupFlow()));

        if (getConfig(configManager).getSlowStartup2Flow())
        flows.add(new Flow(FlowTemplates.slowStartup2Flow()));

        if (getConfig(configManager).getJaggedFlow())
        flows.add(new Flow(FlowTemplates.jaggedFlow()));

        if (getConfig(configManager).getInterruptedFlow())
        flows.add(new Flow(FlowTemplates.interruptedFlow()));

        if (getConfig(configManager).getInterruptedFlow2())
        flows.add(new Flow(FlowTemplates.interruptedFlow2()));

        if (getConfig(configManager).getStoppingFlow())
        flows.add(new Flow(FlowTemplates.stoppingFlow()));

        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        //TODO:Add options for custom Deviation Provider and Noise Provider
        factory.setDeviationProvider(new SinusoidalDeviationProvider(getConfig(configManager).getDeviationSlope()));
        factory.setNoiseProvider(new DefaultNoiseProvider(Double.valueOf(getConfig(configManager).getNoisinessDivider())));
        factory.getNature().setReactionTimeVariationMs(getConfig(configManager).getReactionTimeVariation());
        manager.setMouseMovementBaseTimeMs(getConfig(configManager).getMouseDragSpeed());

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(getConfig(configManager).getOvershoots());

        factory.setSpeedManager(manager);
        Flexo.currentMouseMotionFactory = factory;
    }

    @Override
    protected void startUp() throws Exception {
        Flexo.isStretched = client.isStretchedEnabled();
        overlayManager.add(overlay);
        updateMouseMotionFactory();
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }
}
