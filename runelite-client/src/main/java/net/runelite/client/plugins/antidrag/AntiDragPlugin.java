/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
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
package net.runelite.client.plugins.antidrag;

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Anti Drag",
	description = "Prevent dragging an item for a specified delay",
	tags = {"antidrag", "delay", "inventory", "items"},
	enabledByDefault = false
)
public class AntiDragPlugin extends Plugin implements KeyListener
{
	static final String CONFIG_GROUP = "antiDrag";

	private static final int DEFAULT_DELAY = 5;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private AntiDragConfig config;

	@Inject
	private KeyManager keyManager;

	private boolean inPvp;
	private boolean shiftHeld;
	private boolean ctrlHeld;

	@Provides
	AntiDragConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AntiDragConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(() ->
			{
				inPvp = client.getVar(Varbits.PVP_SPEC_ORB) == 1;
				if (!config.onShiftOnly() && !inPvp)
				{
					setDragDelay();
				}
			});
		}

		keyManager.registerKeyListener(this);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(this::resetDragDelay);
		keyManager.unregisterKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && config.disableOnCtrl() && !(inPvp || config.onShiftOnly()))
		{
			resetDragDelay();
			ctrlHeld = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT && (inPvp || config.onShiftOnly()))
		{
			setDragDelay();
			shiftHeld = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && config.disableOnCtrl() && !(inPvp || config.onShiftOnly()))
		{
			setDragDelay();
			ctrlHeld = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT && (inPvp || config.onShiftOnly()))
		{
			resetDragDelay();
			shiftHeld = false;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP))
		{
			if (!config.disableOnCtrl())
			{
				ctrlHeld = false;
			}

			if (config.onShiftOnly() || inPvp)
			{
				shiftHeld = false;
				clientThread.invoke(this::resetDragDelay);
			}
			else
			{
				clientThread.invoke(this::setDragDelay);
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		boolean currentStatus = client.getVar(Varbits.PVP_SPEC_ORB) == 1;

		if (currentStatus != inPvp)
		{
			inPvp = currentStatus;

			if (!inPvp && !config.onShiftOnly())
			{
				setDragDelay();
			}
			else
			{
				resetDragDelay();
			}
		}

	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			shiftHeld = false;
			ctrlHeld = false;
			clientThread.invoke(this::resetDragDelay);
		}
		else if (!inPvp && !config.onShiftOnly())
		{
			clientThread.invoke(this::setDragDelay);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if ((widgetLoaded.getGroupId() == WidgetID.BANK_GROUP_ID ||
			widgetLoaded.getGroupId() == WidgetID.BANK_INVENTORY_GROUP_ID ||
			widgetLoaded.getGroupId() == WidgetID.DEPOSIT_BOX_GROUP_ID) && (!config.onShiftOnly() || shiftHeld) && !ctrlHeld)
		{
			setBankDragDelay(config.dragDelay());
		}
	}

	private void setBankDragDelay(int delay)
	{
		final Widget bankItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		final Widget bankInventoryItemsContainer = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
		final Widget bankDepositContainer = client.getWidget(WidgetInfo.DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER);
		if (bankItemContainer != null)
		{
			Widget[] items = bankItemContainer.getDynamicChildren();
			for (Widget item : items)
			{
				item.setDragDeadTime(delay);
			}
		}
		if (bankInventoryItemsContainer != null)
		{
			Widget[] items = bankInventoryItemsContainer.getDynamicChildren();
			for (Widget item : items)
			{
				item.setDragDeadTime(delay);
			}
		}
		if (bankDepositContainer != null)
		{
			Widget[] items = bankDepositContainer.getDynamicChildren();
			for (Widget item : items)
			{
				item.setDragDeadTime(delay);
			}
		}
	}

	private void setDragDelay()
	{
		client.setInventoryDragDelay(config.dragDelay());
		setBankDragDelay(config.dragDelay());
	}

	private void resetDragDelay()
	{
		client.setInventoryDragDelay(DEFAULT_DELAY);
		setBankDragDelay(DEFAULT_DELAY);
	}

}
