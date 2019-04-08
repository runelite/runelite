package net.runelite.client.plugins.aaaflexo;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.DefaultNoiseProvider;
import com.github.joonasvali.naturalmouse.support.DefaultOvershootManager;
import com.github.joonasvali.naturalmouse.support.DefaultSpeedManager;
import com.github.joonasvali.naturalmouse.support.Flow;
import com.github.joonasvali.naturalmouse.support.SinusoidalDeviationProvider;
import com.github.joonasvali.naturalmouse.util.FlowTemplates;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.flexo.Flexo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PluginDescriptor(
        name = "! Flexo",
        description = "Customizes Flexo, the MouseInput Assistant ;)",
        tags = {"flexo", "null"}
)
@Slf4j
public class FlexoPlugin extends Plugin {


    @Inject
    private ConfigManager configManager;

    @Inject
    private OverlayManager overlayManager;

    @Provides
    FlexoConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(FlexoConfig.class);
    }

    @Subscribe
    private void onConfigChanged(ConfigChanged event) {
        updateMouseMotionFactory();
    }

    private void updateMouseMotionFactory() {
        Flexo.minDelay = getConfig(configManager).minDelayAmt();
        MouseMotionFactory factory = new MouseMotionFactory();
        //TODO:Add Options for various flows to allow more personalization
        List<Flow> flows = new ArrayList<>(Arrays.asList(
                new Flow(FlowTemplates.variatingFlow()),
                new Flow(FlowTemplates.slowStartupFlow()),
                new Flow(FlowTemplates.slowStartup2Flow()),
                new Flow(FlowTemplates.jaggedFlow())
        ));
        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        //TODO:Add options for custom Deviation Provider and Noise Provider
        factory.setDeviationProvider(new SinusoidalDeviationProvider(SinusoidalDeviationProvider.DEFAULT_SLOPE_DIVIDER));
        factory.setNoiseProvider(new DefaultNoiseProvider(DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER));
        factory.getNature().setReactionTimeVariationMs(getConfig(configManager).getReactionTimeVariation());
        manager.setMouseMovementBaseTimeMs(getConfig(configManager).getMouseDragSpeed());

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(getConfig(configManager).getOvershoots());

        factory.setSpeedManager(manager);
        Flexo.currentMouseMotionFactory = factory;
    }

    @Override
    protected void startUp() throws Exception {
        updateMouseMotionFactory();
    }
}
