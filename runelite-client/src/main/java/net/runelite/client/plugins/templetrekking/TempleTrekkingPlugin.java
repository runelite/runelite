/*
 * Copyright (c) 2018, Frosty Fridge <https://github.com/frostyfridge>
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
package net.runelite.client.plugins.templetrekking;

import com.google.inject.Provides;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.ObjectID;
import net.runelite.api.Varbits;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Temple Trekking",
	description = "Helpers for the Temple Trek minigame",
	tags = {"minigame", "overlay", "temple trek"},
	type = PluginType.MINIGAME
)
public class TempleTrekkingPlugin extends Plugin
{
	@Getter
	private final Set<GroundObject> bogList = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TempleTrekkingOverlay overlay;

	@Inject
	private TempleTrekkingBogOverlay bogOverlay;

	@Getter
	private boolean inTrek = false;

	@Provides
	TempleTrekkingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TempleTrekkingConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(bogOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(bogOverlay);
		bogList.clear();
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		GroundObject obj = event.getGroundObject();
		if (obj.getId() == ObjectID.BOG)
		{
			bogList.add(obj);
		}
	}

	//onGroundObjectDespawned is having issues handling this, so bogmap removal is here instead.
	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!bogList.isEmpty() && client.getVar(Varbits.TREK_EVENT) == 0)
		{
			bogList.clear();
		}
		if (!inTrek && client.getVar(Varbits.TREK_STARTED) == 1)
		{
			inTrek = true;
		}
		else if (inTrek && client.getVar(Varbits.TREK_STATUS) == 0 && client.getVar(Varbits.TREK_POINTS) == 0)
		{
			inTrek = false;
		}
	}

	protected int getRewardPoints()
	{
		return client.getVar(Varbits.TREK_POINTS);
	}

	protected double getRewardPercentage()
	{
		double percentage = 0.000126945 * getRewardPoints() - 0.0357188951;
		return Math.max(percentage, 0);
	}

}
