package net.runelite.client.plugins.myoverlayplugin;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "My Overlay Plugin",
	description = "My plugin with an overlay"
)
public class MyOverlayPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MyOverlay myOverlay;

	@Override
	public void startUp() {
		overlayManager.add(myOverlay);
	}

	@Override
	public void shutDown() {
		overlayManager.remove(myOverlay);
	}

	public int getCookingLevel() {
		return client.getRealSkillLevel(Skill.COOKING);
	}
}
