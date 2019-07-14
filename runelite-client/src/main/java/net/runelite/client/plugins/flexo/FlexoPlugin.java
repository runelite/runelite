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
import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
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

@PluginDescriptor(
	name = "Flexo Config",
	description = "Customizes the flexo api",
	tags = {"flexo", "null"},
	type = PluginType.EXTERNAL,
	enabledByDefault = false
)

public class FlexoPlugin extends Plugin
{
	private Flexo flexo;

	{
		try
		{
			flexo = new Flexo();
		}
		catch (AWTException e)
		{
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

	@Inject
	private FlexoConfig config;

	@Inject
	private EventBus eventBus;

	@Provides
	FlexoConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FlexoConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	private boolean overlayEnabled;
	@Getter(AccessLevel.PACKAGE)
	private boolean debugNPCs;
	@Getter(AccessLevel.PACKAGE)
	private boolean debugPlayers;
	@Getter(AccessLevel.PACKAGE)
	private boolean debugGroundItems;
	private int minDelayAmt;
	private int getReactionTimeVariation;
	private int getMouseDragSpeed;
	private int getOvershoots;
	private boolean getVariatingFlow;
	private boolean getSlowStartupFlow;
	private boolean getSlowStartup2Flow;
	private boolean getJaggedFlow;
	private boolean getInterruptedFlow;
	private boolean getInterruptedFlow2;
	private boolean getStoppingFlow;
	private int getDeviationSlope;
	private String getNoisinessDivider;
	private int scalingFactor;

	@Getter(AccessLevel.PACKAGE)
	private List<Rectangle> clickAreas = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Point> clickPoints = new ArrayList<>();

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("flexo") || (!event.getGroup().equals("stretchedmode")) )
		{
			return;
		}

		updateConfig();
		updateMouseMotionFactory();
	}

	private void onBeforeRender(BeforeRender event)
	{
		if (Flexo.client == null)
		{
			Flexo.client = client;
		}
		if (Flexo.clientUI == null)
		{
			Flexo.clientUI = clientUI;
		}
		this.clickAreas = new ArrayList<>();
		this.clickPoints = new ArrayList<>();
		if (this.debugNPCs)
		{
			Flexo.isStretched = client.isStretchedEnabled();
			Flexo.scale = this.scalingFactor;
			if (flexo != null)
			{
				for (NPC npc : client.getNpcs())
				{
					if (npc != null && npc.getConvexHull() != null)
					{
						Rectangle r = FlexoMouse.getClickArea(npc.getConvexHull().getBounds());
						this.clickAreas.add(r);
						java.awt.Point p = FlexoMouse.getClickPoint(r);
						this.clickPoints.add(p);
					}
				}
			}
		}

		if (this.debugPlayers)
		{
			Flexo.isStretched = client.isStretchedEnabled();
			Flexo.scale = this.scalingFactor;
			if (flexo != null)
			{
				for (Player player : client.getPlayers())
				{
					if (player != null && player.getConvexHull() != null)
					{
						Rectangle r = FlexoMouse.getClickArea(player.getConvexHull().getBounds());
						this.clickAreas.add(r);
						java.awt.Point p = FlexoMouse.getClickPoint(r);
						this.clickPoints.add(p);
					}
				}
			}
		}

		// Could still use some improvement
		if (this.debugGroundItems)
		{
			Flexo.isStretched = client.isStretchedEnabled();
			Flexo.scale = this.scalingFactor;

			if (flexo != null && GroundItemsPlugin.getCollectedGroundItems() != null)
			{
				for (GroundItem gi : GroundItemsPlugin.getCollectedGroundItems().values())
				{
					if (gi != null)
					{
						LocalPoint lp = LocalPoint.fromWorld(client, gi.getLocation());
						if (lp != null && Perspective.getCanvasTilePoly(client, lp) != null)
						{
							Rectangle r1 = FlexoMouse.getClickArea(Perspective.getCanvasTilePoly(client, lp).getBounds());
							Rectangle r2 = FlexoMouse.getClickArea(r1);
							Rectangle r3 = FlexoMouse.getClickArea(r2);
							this.clickAreas.add(r3);
							java.awt.Point p = FlexoMouse.getClickPoint(r3);
							this.clickPoints.add(p);
						}
					}
				}
			}
		}
	}

	private void updateMouseMotionFactory()
	{
		Flexo.minDelay = this.minDelayAmt;
		MouseMotionFactory factory = new MouseMotionFactory();
		// TODO:Add Options for various flows to allow more personalization
		List<Flow> flows = new ArrayList<>();

		// Always add random
		flows.add(new Flow(FlowTemplates.random()));

		if (this.getVariatingFlow)
		{
			flows.add(new Flow(FlowTemplates.variatingFlow()));
		}

		if (this.getSlowStartupFlow)
		{
			flows.add(new Flow(FlowTemplates.slowStartupFlow()));
		}

		if (this.getSlowStartup2Flow)
		{
			flows.add(new Flow(FlowTemplates.slowStartup2Flow()));
		}

		if (this.getJaggedFlow)
		{
			flows.add(new Flow(FlowTemplates.jaggedFlow()));
		}

		if (this.getInterruptedFlow)
		{
			flows.add(new Flow(FlowTemplates.interruptedFlow()));
		}

		if (this.getInterruptedFlow2)
		{
			flows.add(new Flow(FlowTemplates.interruptedFlow2()));
		}

		if (this.getStoppingFlow)
		{
			flows.add(new Flow(FlowTemplates.stoppingFlow()));
		}

		DefaultSpeedManager manager = new DefaultSpeedManager(flows);
		//TODO:Add options for custom Deviation Provider and Noise Provider
		factory.setDeviationProvider(new SinusoidalDeviationProvider(this.getDeviationSlope));
		factory.setNoiseProvider(new DefaultNoiseProvider(Double.valueOf(this.getNoisinessDivider)));
		factory.getNature().setReactionTimeVariationMs(this.getReactionTimeVariation);
		manager.setMouseMovementBaseTimeMs(this.getMouseDragSpeed);

		DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
		overshootManager.setOvershoots(this.getOvershoots);

		factory.setSpeedManager(manager);
		Flexo.currentMouseMotionFactory = factory;
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		Flexo.isStretched = client.isStretchedEnabled();
		overlayManager.add(overlay);
		updateMouseMotionFactory();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(BeforeRender.class, this, this::onBeforeRender);
	}

	private void updateConfig()
	{
		this.overlayEnabled = config.overlayEnabled();
		this.debugNPCs = config.getDebugNPCs();
		this.debugPlayers = config.getDebugPlayers();
		this.debugGroundItems = config.getDebugGroundItems();
		this.minDelayAmt = config.minDelayAmt();
		this.getReactionTimeVariation = config.getReactionTimeVariation();
		this.getMouseDragSpeed = config.getMouseDragSpeed();
		this.getOvershoots = config.getOvershoots();
		this.getVariatingFlow = config.getVariatingFlow();
		this.getSlowStartupFlow = config.getSlowStartupFlow();
		this.getSlowStartup2Flow = config.getSlowStartup2Flow();
		this.getJaggedFlow = config.getJaggedFlow();
		this.getInterruptedFlow = config.getInterruptedFlow();
		this.getInterruptedFlow2 = config.getInterruptedFlow2();
		this.getStoppingFlow = config.getStoppingFlow();
		this.getDeviationSlope = config.getDeviationSlope();
		this.getNoisinessDivider = config.getNoisinessDivider();
		this.scalingFactor = configManager.getConfig(StretchedModeConfig.class).scalingFactor();
	}
}
