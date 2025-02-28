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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
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
@Slf4j
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
				if (!config.onShiftOnly())
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
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && config.disableOnCtrl() && !config.onShiftOnly())
		{
			resetDragDelay();
			ctrlHeld = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT && config.onShiftOnly())
		{
			setDragDelay();
			shiftHeld = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && config.disableOnCtrl() && !config.onShiftOnly())
		{
			setDragDelay();
			ctrlHeld = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT && config.onShiftOnly())
		{
			resetDragDelay();
			shiftHeld = false;
		}
	}

	private boolean isOverriding()
	{
		return (!config.onShiftOnly() || shiftHeld) && !ctrlHeld;
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

			if (config.onShiftOnly())
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
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			shiftHeld = false;
			ctrlHeld = false;
			clientThread.invoke(this::resetDragDelay);
		}
		else if (!config.onShiftOnly())
		{
			clientThread.invoke(this::setDragDelay);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (!isOverriding())
		{
			return;
		}

		if (widgetLoaded.getGroupId() == InterfaceID.BANK ||
			widgetLoaded.getGroupId() == InterfaceID.BANK_INVENTORY)
		{
			setBankDragDelay(config.dragDelay());
		}
		else if (widgetLoaded.getGroupId() == InterfaceID.INVENTORY)
		{
			setInvDragDelay(config.dragDelay());
		}
	}

	@Subscribe
	private void onScriptPostFired(ScriptPostFired ev)
	{
		if (ev.getScriptId() == ScriptID.INVENTORY_DRAWITEM)
		{
			Widget child = client.getScriptActiveWidget();
			if (child.getParentId() == ComponentID.BANK_ITEM_CONTAINER
				|| child.getParentId() == ComponentID.INVENTORY_CONTAINER)
			{
				final int delay = config.dragDelay();
				boolean overriding = isOverriding();
				// disable [clientscript,inventory_antidrag_update] listener
				child.setOnMouseRepeatListener((Object[]) null);
				if (overriding)
				{
					child.setDragDeadTime(delay);
				}
			}
		}
		else if (ev.getScriptId() == ScriptID.RAIDS_STORAGE_PRIVATE_ITEMS)
		{
			if (isOverriding())
			{
				setCoxDragDelay(config.dragDelay());
			}
		}
		else if (ev.getScriptId() == ScriptID.BANK_DEPOSITBOX_INIT)
		{
			if (isOverriding())
			{
				setBankDragDelay(config.dragDelay());
			}
		}
		else if (ev.getScriptId() == ScriptID.SEED_VAULT_BUILD)
		{
			if (isOverriding())
			{
				setSeedVaultDragDelay(config.dragDelay());
			}
		}
	}

	private static void applyDragDelay(Widget widget, int delay)
	{
		if (widget != null)
		{
			for (Widget item : widget.getDynamicChildren())
			{
				item.setDragDeadTime(delay);
			}
		}
	}

	private void setBankDragDelay(int delay)
	{
		final Widget bankItemContainer = client.getWidget(ComponentID.BANK_ITEM_CONTAINER);
		final Widget bankInventoryItemsContainer = client.getWidget(ComponentID.BANK_INVENTORY_ITEM_CONTAINER);
		final Widget bankInventoryEquipmentItemsContainer = client.getWidget(ComponentID.BANK_INVENTORY_EQUIPMENT_ITEM_CONTAINER);
		final Widget bankDepositContainer = client.getWidget(ComponentID.DEPOSIT_BOX_INVENTORY_ITEM_CONTAINER);
		final Widget coxPrivateChest = client.getWidget(ComponentID.CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE_ITEM_CONTAINER);

		applyDragDelay(bankItemContainer, delay);
		applyDragDelay(bankInventoryItemsContainer, delay);
		applyDragDelay(bankInventoryEquipmentItemsContainer, delay);
		applyDragDelay(bankDepositContainer, delay);
		applyDragDelay(coxPrivateChest, delay);
	}

	private void setInvDragDelay(int delay)
	{
		final Widget inventory = client.getWidget(ComponentID.INVENTORY_CONTAINER);
		applyDragDelay(inventory, delay);
	}

	private void setCoxDragDelay(int delay)
	{
		final Widget coxChest = client.getWidget(ComponentID.CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE_ITEM_CONTAINER);
		applyDragDelay(coxChest, delay);
	}

	private void setSeedVaultDragDelay(int delay)
	{
		final Widget seedVaultItems = client.getWidget(ComponentID.SEED_VAULT_ITEM_CONTAINER);
		final Widget seedVaultText = client.getWidget(ComponentID.SEED_VAULT_ITEM_TEXT);
		applyDragDelay(seedVaultItems, delay);
		applyDragDelay(seedVaultText, delay);
	}

	private void setDragDelay()
	{
		final int delay = config.dragDelay();
		log.debug("Set delay to {}", delay);
		client.setInventoryDragDelay(delay);
		setInvDragDelay(delay);
		setBankDragDelay(delay);
		setCoxDragDelay(delay);
		setSeedVaultDragDelay(delay);
	}

	private void resetDragDelay()
	{
		log.debug("Reset delay to {}", DEFAULT_DELAY);
		client.setInventoryDragDelay(DEFAULT_DELAY);
		setInvDragDelay(DEFAULT_DELAY);
		setBankDragDelay(DEFAULT_DELAY);
		setCoxDragDelay(DEFAULT_DELAY);
		setSeedVaultDragDelay(DEFAULT_DELAY);
	}

}
