package net.runelite.client.plugins.itemstats;

import com.google.inject.Inject;
import net.runelite.client.input.KeyListener;
import java.awt.event.KeyEvent;

class ItemStatKeyListener implements KeyListener
{
	@Inject
	private ItemStatPlugin plugin;

	@Inject
	private ItemStatConfig config;

	@Override
	public void keyTyped(KeyEvent e)
	{
		//do nothing
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (config.toggleableKey().matches(e))
		{
			plugin.setToggleableDown(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (config.toggleableKey().matches(e))
		{
			plugin.setToggleableDown(false);
		}
	}
}
