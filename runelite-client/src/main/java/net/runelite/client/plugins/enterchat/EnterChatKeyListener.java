package net.runelite.client.plugins.enterchat;

import java.awt.event.KeyEvent;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.input.KeyListener;

public class EnterChatKeyListener implements KeyListener
{
	private EnterChatPlugin plugin;
	private Client client;
	private EnterChatConfig config;

	/**
	 * Tracks state of keys while rebinding is active so that we can rebind a key release after deactivating.
	 * Without this check, the button would remain down if you toggled enter chat while holding a remapped button.
	 */
	private boolean[] keys = new boolean[256];

	public EnterChatKeyListener(EnterChatPlugin plugin, Client client, EnterChatConfig config)
	{
		this.plugin = plugin;
		this.client = client;
		this.config = config;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// Toggle the state when the enter key is pressed
		if (e.getKeyChar() == '\n')
		{
			// Make sure the chatline buffer is empty
			if (client.getGameState() == GameState.LOGGED_IN && plugin.chatLineEmpty())
			{
				plugin.setActive(!plugin.active);
				e.consume();
			}
			return;
		}
		if (plugin.isActive() && plugin.isPrintableKey(e))
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (config.invertShiftCtrl())
		{
			if (e.getKeyCode() == 17)
			{
				e.setKeyCode(16);
				return;
			}
			else if (e.getKeyCode() == 16)
			{
				e.setKeyCode(17);
				return;
			}
		}
		if (plugin.isActive())
		{
			// Track state of keys
			keys[e.getKeyCode()] = true;
			// Rebind if necessary
			e.setKeyCode(plugin.getRebind(e));
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (config.invertShiftCtrl())
		{
			if (e.getKeyCode() == 17)
			{
				e.setKeyCode(16);
				return;
			}
			else if (e.getKeyCode() == 16)
			{
				e.setKeyCode(17);
				return;
			}
		}
		if (plugin.isActive())
		{
			// Track state of keys
			keys[e.getKeyCode()] = false;
			// Rebind if necessary
			e.setKeyCode(plugin.getRebind(e));
		}
		else if (keys[e.getKeyCode()])
		{
			// Rebind key release of key that was held down when enter chat was toggled
			e.setKeyCode(plugin.getRebind(e));
		}
	}
}
