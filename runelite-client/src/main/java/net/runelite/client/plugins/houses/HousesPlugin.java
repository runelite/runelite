package net.runelite.client.plugins.houses;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import javax.inject.Inject;
import java.awt.image.BufferedImage;

@PluginDescriptor(
	name = "Houses Panel",
	description = "Enable the Houses panel",
	loadWhenOutdated = true
)
public class HousesPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		final HousesPanel panel = injector.getInstance(HousesPanel.class);
		panel.init();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "houses_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Houses")
			.icon(icon)
			.priority(10)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}
	@Subscribe
	public void onGameTick(GameTick gameTick) {
		if (client.getGameState() != GameState.LOGGED_IN) {
			return;
		}
	}
	public void isInClan() {
		if (client == null) return;
		if (client.getGameState() != GameState.LOGGED_IN) return;
		for (int i = 0; i < HousesPanel.RimmListModel.getSize(); i++) {
			if (client.getClanMembers().toString().toLowerCase().contains(HousesPanel.RimmListModel.get(i).toString())) {
				HousesPanel.RimmListModel.set(i, HousesPanel.RimmListModel.get(i).toString() + " [07 Altar]");
			}
		}
		for (int i = 0; i < HousesPanel.YanListModel.getSize(); i++) {
			if (client.getClanMembers().toString().toLowerCase().contains(HousesPanel.YanListModel.get(i).toString())) {
				HousesPanel.YanListModel.set(i, HousesPanel.YanListModel.get(i).toString() + " [07 Altar]");
			}

		}
	}
}
