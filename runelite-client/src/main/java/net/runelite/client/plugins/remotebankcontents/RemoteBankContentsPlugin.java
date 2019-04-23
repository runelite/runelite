package net.runelite.client.plugins.remotebankcontents;

import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Remote Bank Contents",
	description = "View how many of inventory items you have in your bank.",
	tags = {"remotebankcontents", "skilling", "combat", "utility"}
)

public class RemoteBankContentsPlugin extends Plugin
{


	@Getter(AccessLevel.PACKAGE)
	private RemoteBankContentsPanel panel;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private RemoteBankContentsProcess remoteBankContentsProcess;

	@Inject
	private RemoteBankContentsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RemoteBankContentsConfig config;

	@Getter
	private NavigationButton navButton;

	@Inject
	private ClientToolbar clientToolbar;


	@Provides
	RemoteBankContentsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RemoteBankContentsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{

		panel = injector.getInstance(RemoteBankContentsPanel.class);
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "icon.png");


		navButton = NavigationButton.builder()
			.tooltip("Remote Bank Contents")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
		overlayManager.add(overlay);

		remoteBankContentsProcess.setPanel(panel);

		//pass a reference to the remoteBankContentsProcess which has the hashmap in to make sure that both classes use the same hashmap
		overlay.setRemoteBankContentsProcess(remoteBankContentsProcess);


	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		remoteBankContentsProcess.reset();
		panel.reset();


	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		remoteBankContentsProcess.populateBankItemMap();

	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{

		//only run this if the event is opening the bank.
		if (event.getEventName().equals("setBankTitle"))
		{

			//populate the hashmap with all of the items from the bank
			remoteBankContentsProcess.populateBankItemMap();
			remoteBankContentsProcess.setInventorySpace();


		}


	}


	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{

		//only run this if the examine option in the configuration is checked
		if (event.getMenuOption().equals("Examine") && config.examine())
		{
			remoteBankContentsProcess.outputExamine(event);
		}
		else if (event.getMenuOption().contains("Deposit"))
		{
			remoteBankContentsProcess.depositHandler(event);

		}
		else if (event.getMenuOption().contains("Withdraw"))
		{
			remoteBankContentsProcess.withdrawHandler(event);

		}
	}


	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			remoteBankContentsProcess.reset();

		}
	}

}






