package net.runelite.client.plugins.interfaceswapper;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
		name = "Interface Swapper"
)
@Slf4j
public class InterfaceSwapperPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private InterfaceSwapperConfig config;

	WidgetInfo[] widgetsMainScreen = {
			WidgetInfo.LEFT_MAIN_SCREEN,
			WidgetInfo.UPPER_MAIN_SCREEN,
			WidgetInfo.MAIN_SCREEN
	};

	WidgetInfo worldMap = WidgetInfo.WORLD_MAP_INTERFACE;
	WidgetInfo chatBox = WidgetInfo.CHAT_BOX;

	WidgetInfo[] widgetsInventory = {
			WidgetInfo.LEFT_UPPER_PILLAR,
			WidgetInfo.LEFT_LOWER_PILLAR,
			WidgetInfo.RIGHT_PILLAR,
			WidgetInfo.LOWER_INVENTORY_BAR,
			WidgetInfo.UPPER_INVENTORY_BAR,
			WidgetInfo.INVENTORY_INTERFACE
	};

	@Provides
	InterfaceSwapperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InterfaceSwapperConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		performSwap();
	}


	//Solution I don't like
	@Subscribe
	public void onGameTick(GameTick event)
	{
		performSwap();
	}

	private void performSwap()
	{
		if (client.getWidget(WidgetInfo.UPPER_MAIN_SCREEN) != null)
		{
			// Restores to default state before checking if
			restoreHorizontalSwap();
			restoreVerticalSwap();

			// Swaps components
			horizontalSwap();
			verticalSwap();
		}
	}

	private void horizontalSwap()
	{
		if (config.horizontalSwap())
		{
			for (WidgetInfo widget : widgetsMainScreen)
			{
				client.getWidget(widget).setRelativeX(client.getWidget(widget).getRelativeX() + client.getWidget(worldMap).getWidth() - 4);
			}
			client.getWidget(chatBox).setRelativeX(client.getWidget(chatBox).getRelativeX() + client.getWidget(worldMap).getWidth() - 4);

			for (WidgetInfo widget : widgetsInventory)
			{
				client.getWidget(widget).setRelativeX(client.getWidget(widget).getRelativeX() - client.getWidget(chatBox).getWidth());
			}
			client.getWidget(worldMap).setRelativeX(client.getWidget(worldMap).getRelativeX() - client.getWidget(chatBox).getWidth());
		}
	}

	private void verticalSwap()
	{
		// Swaps vertical components
		if (config.verticalSwap())
		{
			for (WidgetInfo widget : widgetsMainScreen)
			{
				client.getWidget(widget).setRelativeY(client.getWidget(widget).getRelativeY() + client.getWidget(chatBox).getHeight());
			}
			int mainScreenHeight = client.getWidget(WidgetInfo.UPPER_MAIN_SCREEN).getHeight() + client.getWidget(WidgetInfo.MAIN_SCREEN).getHeight();

			client.getWidget(chatBox).setRelativeY(client.getWidget(chatBox).getRelativeY() - mainScreenHeight);

			int inventoryHeight = client.getWidget(WidgetInfo.INVENTORY_INTERFACE).getHeight() +
					client.getWidget(WidgetInfo.UPPER_INVENTORY_BAR).getHeight() +
					client.getWidget(WidgetInfo.LOWER_INVENTORY_BAR).getHeight();

			for (WidgetInfo widget : widgetsInventory)
			{
				client.getWidget(widget).setRelativeY(client.getWidget(widget).getRelativeY() - client.getWidget(worldMap).getHeight() - 2);
			}
			client.getWidget(worldMap).setRelativeY(client.getWidget(worldMap).getRelativeY() + inventoryHeight - 2);
		}
	}


	// Restores the horizontal swap
	private void restoreHorizontalSwap()
	{
		client.getWidget(WidgetInfo.LEFT_MAIN_SCREEN).setRelativeX(InterfaceDefault.LEFT_MAIN_SCREEN_RELATIVE_X);
		client.getWidget(WidgetInfo.UPPER_MAIN_SCREEN).setRelativeX(InterfaceDefault.UPPER_MAIN_SCREEN_RELATIVE_X);
		client.getWidget(WidgetInfo.MAIN_SCREEN).setRelativeX(InterfaceDefault.MAIN_SCREEN_RELATIVE_X);
		client.getWidget(WidgetInfo.WORLD_MAP_INTERFACE).setRelativeX(InterfaceDefault.WORLD_MAP_INTERFACE_RELATIVE_X);
		client.getWidget(WidgetInfo.CHAT_BOX).setRelativeX(InterfaceDefault.CHAT_BOX_RELATIVE_X);
		client.getWidget(WidgetInfo.LEFT_UPPER_PILLAR).setRelativeX(InterfaceDefault.LEFT_UPPER_PILLAR_RELATIVE_X);
		client.getWidget(WidgetInfo.LEFT_LOWER_PILLAR).setRelativeX(InterfaceDefault.LEFT_LOWER_PILLAR_RELATIVE_X);
		client.getWidget(WidgetInfo.RIGHT_PILLAR).setRelativeX(InterfaceDefault.RIGHT_PILLAR_RELATIVE_X);
		client.getWidget(WidgetInfo.LOWER_INVENTORY_BAR).setRelativeX(InterfaceDefault.LOWER_INVENTORY_BAR_RELATIVE_X);
		client.getWidget(WidgetInfo.UPPER_INVENTORY_BAR).setRelativeX(InterfaceDefault.UPPER_INVENTORY_BAR_RELATIVE_X);
		client.getWidget(WidgetInfo.INVENTORY_INTERFACE).setRelativeX(InterfaceDefault.INVENTORY_RELATIVE_X);
	}

	// Restores the vertical swap
	private void restoreVerticalSwap()
	{
		client.getWidget(WidgetInfo.LEFT_MAIN_SCREEN).setRelativeY(InterfaceDefault.LEFT_MAIN_SCREEN_RELATIVE_Y);
		client.getWidget(WidgetInfo.UPPER_MAIN_SCREEN).setRelativeY(InterfaceDefault.UPPER_MAIN_SCREEN_RELATIVE_Y);
		client.getWidget(WidgetInfo.MAIN_SCREEN).setRelativeY(InterfaceDefault.MAIN_SCREEN_RELATIVE_Y);
		client.getWidget(WidgetInfo.WORLD_MAP_INTERFACE).setRelativeY(InterfaceDefault.WORLD_MAP_INTERFACE_RELATIVE_Y);
		client.getWidget(WidgetInfo.CHAT_BOX).setRelativeY(InterfaceDefault.CHAT_BOX_RELATIVE_Y);
		client.getWidget(WidgetInfo.LEFT_UPPER_PILLAR).setRelativeY(InterfaceDefault.LEFT_UPPER_PILLAR_RELATIVE_Y);
		client.getWidget(WidgetInfo.LEFT_LOWER_PILLAR).setRelativeY(InterfaceDefault.LEFT_LOWER_PILLAR_RELATIVE_Y);
		client.getWidget(WidgetInfo.RIGHT_PILLAR).setRelativeY(InterfaceDefault.RIGHT_PILLAR_RELATIVE_Y);
		client.getWidget(WidgetInfo.LOWER_INVENTORY_BAR).setRelativeY(InterfaceDefault.LOWER_INVENTORY_BAR_RELATIVE_Y);
		client.getWidget(WidgetInfo.UPPER_INVENTORY_BAR).setRelativeY(InterfaceDefault.UPPER_INVENTORY_BAR_RELATIVE_Y);
		client.getWidget(WidgetInfo.INVENTORY_INTERFACE).setRelativeY(InterfaceDefault.INVENTORY_RELATIVE_Y);
	}
}
