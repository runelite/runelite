package net.runelite.client.plugins.walkhere;

import net.runelite.client.input.KeyListener;

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.client.input.KeyListener;

public class WalkHereInput implements KeyListener
{

	@Inject
	private WalkHereConfig config;

	@Inject
	private WalkHerePlugin plugin;

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == config.hotkey().getHotkey())
		{
			plugin.shouldClear = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == config.hotkey().getHotkey())
		{
			plugin.shouldClear = false;
		}
	}
}
