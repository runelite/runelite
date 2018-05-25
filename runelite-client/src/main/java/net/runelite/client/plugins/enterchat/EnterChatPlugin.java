package net.runelite.client.plugins.enterchat;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.event.KeyEvent;

@PluginDescriptor(
	name = "Enter Chat",
	enabledByDefault = false
)
public class EnterChatPlugin extends Plugin
{

	@Inject
	private EnterChatConfig config;
	@Inject
	private KeyManager keyManager;
	@Inject
	private Client client;

	/**
	 * Tracks state of keys while rebinding is active so that we can rebind a key release after deactivating.
	 * Without this check, the button would remain down if you toggled enter chat while holding a remapped button.
	 */
	private boolean[] keys = new boolean[256];

	/**
	 * If enter chat should be active.
	 */
	private boolean active = true;

	@Provides
	EnterChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EnterChatConfig.class);
	}

	public Widget getChatLineWidget()
	{
		return client.getWidget(WidgetInfo.CHATBOX_CHAT_INPUT_LINE);
	}

	public boolean isWidgetVisible(WidgetInfo info)
	{
		Widget widget = client.getWidget(info);
		return widget != null && !widget.isHidden();
	}

	public boolean inputNeeded()
	{
		// TODO add more widgets that use keyboard input
		return isWidgetVisible(WidgetInfo.CHATBOX_TEXT_PROMPT)
			|| isWidgetVisible(WidgetInfo.POH_JEWELRY_INTERFACE)
			|| isWidgetVisible(WidgetInfo.FURNITURE_CREATION_MENU)
			|| isWidgetVisible(WidgetInfo.GENERAL_TELEPORT_SELECTION_SCREEN)
			|| isWidgetVisible(WidgetInfo.DIALOG_PLAYER_CONTINUE)
			|| isWidgetVisible(WidgetInfo.CHATBOX_SELECT_OPTION)
			|| isWidgetVisible(WidgetInfo.DIALOG_NPC_CONTINUE);
	}

	public boolean isActive()
	{
		return active && client.getGameState() == GameState.LOGGED_IN && !inputNeeded();
	}

	public void setActive(boolean b)
	{
		active = b;
		getChatLineWidget().setHidden(active);
	}

	public boolean isPrintableKey(KeyEvent e)
	{
		int c = (int) e.getKeyChar();
		return c >= 32 && c <= 126;
	}

	public int getRebind(KeyEvent e)
	{
		int code = e.getKeyCode();
		int remap = code;
		if (code == config.upArrow().getCode())
		{
			remap = KeyEvent.VK_UP;
		}
		else if (code == config.downArrow().getCode())
		{
			remap = KeyEvent.VK_DOWN;
		}
		else if (code == config.leftArrow().getCode())
		{
			remap = KeyEvent.VK_LEFT;
		}
		else if (code == config.rightArrow().getCode())
		{
			remap = KeyEvent.VK_RIGHT;
		}
		else if (code == config.f1().getCode() || code == config.altF1().getCode())
		{
			remap = KeyEvent.VK_F1;
		}
		else if (code == config.f2().getCode() || code == config.altF2().getCode())
		{
			remap = KeyEvent.VK_F2;
		}
		else if (code == config.f3().getCode() || code == config.altF3().getCode())
		{
			remap = KeyEvent.VK_F3;
		}
		else if (code == config.f4().getCode() || code == config.altF4().getCode())
		{
			remap = KeyEvent.VK_F4;
		}
		else if (code == config.f5().getCode() || code == config.altF5().getCode())
		{
			remap = KeyEvent.VK_F5;
		}
		else if (code == config.f6().getCode() || code == config.altF6().getCode())
		{
			remap = KeyEvent.VK_F6;
		}
		else if (code == config.f7().getCode() || code == config.altF7().getCode())
		{
			remap = KeyEvent.VK_F7;
		}
		else if (code == config.f8().getCode() || code == config.altF8().getCode())
		{
			remap = KeyEvent.VK_F8;
		}
        /*
        else if (code == config.f9().getCode() || code == config.altF9().getCode())
        {
            remap = KeyEvent.VK_F9;
        } else if (code == config.f10().getCode() || code == config.altF10().getCode())
        {
            remap = KeyEvent.VK_F10;
        } else if (code == config.f11().getCode() || code == config.altF11().getCode())
        {
            remap = KeyEvent.VK_F11;
        } else if (code == config.f12().getCode() || code == config.altF12().getCode())
        {
            remap = KeyEvent.VK_F12;
        }
        */
		else if (code == config.escape().getCode() || code == config.altescape().getCode())
		{
			remap = KeyEvent.VK_ESCAPE;
		}
		return remap;
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.CHATBOX_GROUP_ID)
		{
			setActive(active);
		}
	}

	@Override
	protected void startUp()
	{
		keyManager.registerKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				// Toggle the state when the enter key is pressed
				if (e.getKeyChar() == '\n')
				{
					// Make sure the chatline buffer is empty
					String chatBuffer = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);
					if (client.getGameState() == GameState.LOGGED_IN
						&& chatBuffer != null
						&& chatBuffer.length() == 0)
					{
						setActive(!active);
						e.consume();
					}
					return;
				}
				if (isActive() && isPrintableKey(e))
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
				if (isActive())
				{
					// Track state of keys
					keys[e.getKeyCode()] = true;
					// Rebind if necessary
					e.setKeyCode(getRebind(e));
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
				if (isActive())
				{
					// Track state of keys
					keys[e.getKeyCode()] = false;
					// Rebind if necessary
					e.setKeyCode(getRebind(e));
				}
				else if (keys[e.getKeyCode()])
				{
					// Rebind key release of key that was held down when enter chat was toggled
					e.setKeyCode(getRebind(e));
				}
			}
		});
	}

}
