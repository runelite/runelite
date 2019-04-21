package net.runelite.client.plugins.plankmakehelper;

import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
		name = "Plank Make Helper",
		description = "Highlights planks and plank make spell",
		tags = {"overlay", "plankmaking", "lunar", "money", "moneymaking", "gp"},
		type = "utility"
)

public class PlankMakePlugin extends Plugin {

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private PlankMakeOverlay overlay;

	@Override
	protected void startUp() {
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() {
		overlayManager.remove(overlay);
	}

	static boolean isLogAndPlankable(int itemID) {
		switch (itemID) {
			case 6332: //mahogany
			case 1521: //oak
			case 6333: //teak
			case 1511: //plain
				return true;
			default:
				return false;
		}
	}

}
