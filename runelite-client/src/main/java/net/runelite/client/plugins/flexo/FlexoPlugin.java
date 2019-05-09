/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.flexo;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.DefaultNoiseProvider;
import com.github.joonasvali.naturalmouse.support.DefaultOvershootManager;
import com.github.joonasvali.naturalmouse.support.DefaultSpeedManager;
import com.github.joonasvali.naturalmouse.support.Flow;
import com.github.joonasvali.naturalmouse.support.SinusoidalDeviationProvider;
import com.github.joonasvali.naturalmouse.util.FlowTemplates;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.flexo.Flexo;
import net.runelite.client.flexo.FlexoMouse;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.grounditems.GroundItem;
import net.runelite.client.plugins.grounditems.GroundItemsPlugin;
import net.runelite.client.plugins.stretchedmode.StretchedModeConfig;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "Flexo Config",
        description = "Customizes the flexo api",
        tags = {"flexo", "null"},
		type = PluginType.UTILITY
)
public class FlexoPlugin extends Plugin {

    private Flexo flexo;

    {
        try {
            flexo = new Flexo();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Inject
    private Client client;
    
    @Inject
    private ClientUI clientUI;

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
    public void onBeforeRender(BeforeRender event) {
        if (Flexo.client==null)
            Flexo.client = client;
        if (Flexo.clientUI==null)
            Flexo.clientUI = clientUI;
        overlay.clickAreas = new ArrayList<>();
        overlay.clickPoints = new ArrayList<>();
            if (getConfig(configManager).getDebugNPCs()) {
                Flexo.isStretched = client.isStretchedEnabled();
                Flexo.scale = configManager.getConfig(StretchedModeConfig.class).scalingFactor();
                if (flexo != null)
                    for (NPC npc : client.getNpcs()) {
                        if (npc != null)
                            if (npc.getConvexHull() != null) {
                                Rectangle r = FlexoMouse.getClickArea(npc.getConvexHull().getBounds());
                                overlay.clickAreas.add(r);
                                java.awt.Point p = FlexoMouse.getClickPoint(r);
                                overlay.clickPoints.add(p);
                            }
                    }
            }

        if (getConfig(configManager).getDebugPlayers()) {
            Flexo.isStretched = client.isStretchedEnabled();
            Flexo.scale = configManager.getConfig(StretchedModeConfig.class).scalingFactor();
            if (flexo != null)
                for (Player player : client.getPlayers()) {
                    if (player != null)
                        if (player.getConvexHull() != null) {
                            Rectangle r = FlexoMouse.getClickArea(player.getConvexHull().getBounds());
                            overlay.clickAreas.add(r);
                            java.awt.Point p = FlexoMouse.getClickPoint(r);
                            overlay.clickPoints.add(p);
                        }
                }
        }

        //Could still use some improvement
        if (getConfig(configManager).getDebugGroundItems()) {
            Flexo.isStretched = client.isStretchedEnabled();
            Flexo.scale = configManager.getConfig(StretchedModeConfig.class).scalingFactor();
            if (flexo != null)
                if (GroundItemsPlugin.getCollectedGroundItems()!=null)
                for (GroundItem gi : GroundItemsPlugin.getCollectedGroundItems().values()) {
                    if (gi != null)
                        if (Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, gi.getLocation()))!=null) {
                            Rectangle r1 = FlexoMouse.getClickArea(Perspective.getCanvasTilePoly(client, LocalPoint.fromWorld(client, gi.getLocation())).getBounds());
                            Rectangle r2 = FlexoMouse.getClickArea(r1);
                            Rectangle r3 = FlexoMouse.getClickArea(r2);
                            overlay.clickAreas.add(r3);
                            java.awt.Point p = FlexoMouse.getClickPoint(r3);
                            overlay.clickPoints.add(p);
                        }
                }
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {

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
