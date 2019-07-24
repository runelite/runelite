/*
 * Copyright (c) 2018 AWPH-I
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.lootingbagviewer;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "PvP Looting Bag Viewer",
		description = "Add an overlay showing the contents of your looting bag",
		tags = {"alternate", "items", "overlay", "second"},
		type = PluginType.PVP,
		enabledByDefault = false
)
/**
 * TODO: Remember current looting bag value when client restarts
 * TODO: Write an event for picking up an item (with opened looting bag) and add its price to the current looting bag value
 * TODO: Write something to capture adding items to a looting bag and add its price to the current looting bag value
 */
@Slf4j
@Singleton // WHY IS THIS PLUGIN EVEN MERGED IT'S AGES FROM BEING DONE!?!?!?!?
public class LootingBagViewerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LootingBagViewerOverlay overlay;

	@Inject
	private LootingBagViewerWidgetOverlay widgetOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private LootingBagViewerConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int valueToShow = -1;

	@Provides
	LootingBagViewerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LootingBagViewerConfig.class);
	}

	@Override
	public void startUp()
	{
		addSubscriptions();

		if (config.renderViewer())
		{
			overlayManager.add(overlay);
		}

		if (config.renderLootingBag())
		{
			overlayManager.add(widgetOverlay);
		}
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(widgetOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(WidgetHiddenChanged.class, this, this::onWidgetHiddenChanged);
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getKey().equals("renderViewer"))
		{
			if (Boolean.parseBoolean(configChanged.getNewValue()))
			{
				overlayManager.add(overlay);
			}
			else
			{
				overlayManager.remove(overlay);
			}
		}
		if (configChanged.getKey().equals("renderLootingBag"))
		{
			if (Boolean.parseBoolean(configChanged.getNewValue()))
			{
				overlayManager.add(widgetOverlay);
			}
			else
			{
				overlayManager.remove(widgetOverlay);
			}
		}
	}


	/**
	 * @param widgetHiddenChanged
	 */
	private void onWidgetHiddenChanged(WidgetHiddenChanged widgetHiddenChanged)
	{
		Widget widget = widgetHiddenChanged.getWidget();
		if (widget.getParentId() == 5308416 && !widget.isHidden())
		{
			clientThread.invokeLater(() ->
			{
				Widget value = client.getWidget(81, 6);
				log.debug("val: {}", value.getText());

				if (!Strings.isNullOrEmpty(value.getText()))
				{
					if (value.getText().equals("Value: -")) 
					{
						setValueToShow(-1);
					} 
					else 
					{
						String str = value.getText();
						str = str.replace("Bag value: ", "")
								.replace("Value: ", "")
								.replace(" coins", "")
								.replace(",", "");

						int val = Integer.parseInt(str);
						setValueToShow(Math.round(val) / 1000);
					}
				}
			});
		}
	}

} 
