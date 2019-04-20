package net.runelite.client.plugins.menumodifier;

import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

public class MenuModifierInputListener extends MouseAdapter implements KeyListener
{
    private static final int HOTKEY = KeyEvent.VK_CONTROL;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Inject
    private MenuModifierPlugin plugin;

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == HOTKEY)
        {
            plugin.setHotKeyPressed(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == HOTKEY)
        {
            plugin.setHotKeyPressed(false);
        }
    }
}
