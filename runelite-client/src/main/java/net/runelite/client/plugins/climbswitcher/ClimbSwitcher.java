/*
 * Copyright (c) 2018, Patrick Beuks (killje) <patrick.beuks@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.climbswitcher;

import com.google.common.eventbus.Subscribe;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
        name = "Climb Switcher",
        description = "Changes climbable's top option to climb-up, or climb-down when holding shift.",
        tags = {"objects"},
        enabledByDefault = false
)
public class ClimbSwitcher extends Plugin implements KeyListener
{

    private boolean shiftPressed = false;

    @Inject
    private Client client;

    @Inject
    private KeyManager keyManager;

    @Override
    public void keyPressed(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shiftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shiftPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void startUp()
    {
        keyManager.registerKeyListener(this);
    }

    @Override
    public void shutDown()
    {
        keyManager.unregisterKeyListener(this);
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event)
    {

        String option = Text.removeTags(event.getOption()).toLowerCase();
        String target = Text.removeTags(event.getTarget()).toLowerCase();

        // Check for climb in the options
        if (option.equals("climb"))
        {

            MenuEntry[] entries = client.getMenuEntries();

            int indexClimb = -1;
            int indexTopEntry = -1;

            // Check for positions of climb-[up|down] and climb 
            // and switches them
            for (int i = entries.length - 1; i >= 0; i--)
            {
                MenuEntry entry = entries[i];
                String entryOption
                        = Text.removeTags(entry.getOption()).toLowerCase();
                String entryTarget
                        = Text.removeTags(entry.getTarget()).toLowerCase();

                String topEntry = "climb-up";
                if (shiftPressed)
                {
                    topEntry = "climb-down";
                }

                if (indexClimb < 0 && entryOption.equals("climb")
                        && target.equals(entryTarget))
                {
                    indexClimb = i;
                }

                if (indexTopEntry < 0 && entryOption.equals(topEntry)
                        && target.equals(entryTarget))
                {
                    indexTopEntry = i;
                }

                if (indexClimb >= 0 && indexTopEntry >= 0)
                {
                    MenuEntry temp = entries[indexClimb];
                    entries[indexClimb] = entries[indexTopEntry];
                    entries[indexTopEntry] = temp;

                    client.setMenuEntries(entries);

                    break;
                }
            }

        }
    }

}
