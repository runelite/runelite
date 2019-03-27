/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Credit is due  to SomeoneWithAnInternetConnection and oplosthee
 * for writing the original Runelite Metronome, which inspired this plugin.
 */

package net.runelite.client.plugins.ztickindicator;

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.client.input.KeyListener;

public class TickIndicatorInput implements KeyListener
{
    private static final int HOTKEY = KeyEvent.VK_SHIFT;

    @Inject
    private TickIndicatorPlugin plugin;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case HOTKEY:
                plugin.updateHotkey(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case HOTKEY:
                plugin.updateHotkey(false);
                break;
        }
    }
}
