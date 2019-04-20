package net.runelite.client.plugins.fkeyremapping;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

class fKeyRemappingListener extends MouseAdapter implements KeyListener
{
    @Inject
    private fKeyRemappingPlugin plugin;

    @Inject
    private fKeyRemappingConfig config;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    private final Map<Integer, Integer> modified = new HashMap<>();

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


            if (config.f1().matches(e))
            {
                modified.put(e.getKeyCode(), KeyEvent.VK_F1);
                e.setKeyCode(KeyEvent.VK_F1);
            }
            else if (config.f2().matches(e))
            {
                modified.put(e.getKeyCode(), KeyEvent.VK_F2);
                e.setKeyCode(KeyEvent.VK_F2);
            }
            else if (config.f3().matches(e))
            {
                modified.put(e.getKeyCode(), KeyEvent.VK_F3);
                e.setKeyCode(KeyEvent.VK_F3);
            }
            else if (config.f4().matches(e))
            {
                modified.put(e.getKeyCode(), KeyEvent.VK_F4);
                e.setKeyCode(KeyEvent.VK_F4);
            }


    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (client.getGameState() != GameState.LOGGED_IN || !plugin.chatboxFocused())
        {
            return;
        }

            modified.remove(e.getKeyCode());

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

    }
}