package net.runelite.client.plugins.itemprices;

import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

public class ItemPricesListener implements KeyListener
{
    @Inject
    KeyManager keyManager;

    @Inject
    private ItemPricesPlugin plugin;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    //enables overlay on HOTKEY press (ALT)
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ALT)
        {
            plugin.showPrices = true;
        }
    }

    //disables overlay on HOTKEY release (ALT)
    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ALT)
        {
            plugin.showPrices = false;
        }
    }
}
