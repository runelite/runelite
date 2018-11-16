package net.runelite.client.plugins.hotkeys;

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

public class HotkeysListener extends MouseAdapter implements KeyListener
{
	@Inject
	private HotkeysPlugin plugin;

	@Inject
	private HotkeysConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !plugin.chatboxFocused())
		{
			return;
		}

		if (!plugin.isTyping())
		{
			if (config.f1().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F1);
			}
			else if (config.f2().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F2);
			}
			else if (config.f3().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F3);
			}
			else if (config.f4().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F4);
			}
			else if (config.f5().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F5);
			}
			else if (config.f6().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F6);
			}
			else if (config.f7().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F7);
			}
			else if (config.f8().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F8);
			}
			else if (config.f9().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F9);
			}
			else if (config.f10().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F10);
			}
			else if (config.f11().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F11);
			}
			else if (config.f12().matches(e))
			{
				e.setKeyCode(KeyEvent.VK_F12);
			}
				else
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_ENTER:
					case KeyEvent.VK_SLASH:
					case KeyEvent.VK_SPACE:
						plugin.setTyping(true);
						clientThread.invoke(() ->
							plugin.unlockChat());
						break;
				}
			}
		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ENTER:
					plugin.setTyping(false);
					clientThread.invoke(() ->
						plugin.lockChat());
					break;
				case KeyEvent.VK_ESCAPE:
					plugin.setTyping(false);
					clientThread.invoke(() ->
					{
						client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
						plugin.lockChat();
					});
					break;
				case KeyEvent.VK_BACK_SPACE:
					if ((client.getVar(VarClientStr.CHATBOX_TYPED_TEXT).isEmpty()))
					{
						plugin.setTyping(false);
						clientThread.invoke(() -> plugin.lockChat());
					}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
