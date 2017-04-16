/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.hiscore;

import com.google.common.eventbus.Subscribe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.events.PlayerMenuOptionClicked;
import net.runelite.client.events.PlayerMenuOptionsChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hiscore extends Plugin implements ActionListener
{
	private static final Logger logger = LoggerFactory.getLogger(Hiscore.class);

	private final NavigationButton navButton = new NavigationButton("Hiscore");
	private final HiscorePanel hiscorePanel = new HiscorePanel();

	private final ClientUI ui = RuneLite.getRunelite().getGui();
        
        private static final Client client = RuneLite.getClient();
        
        private static final int lookupMenuType = 999;
        private static final String lookupMenuText = "Lookup";
        private int lookupMenuIndex = 4;

	public Hiscore()
	{
		navButton.getButton().addActionListener(this);

		try
		{
			ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("hiscore.gif")));
			navButton.getButton().setIcon(icon);
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		ui.getNavigationPanel().addNavigation(navButton);
                
                addLookupOption();
	}

	@Override
	public Overlay getOverlay()
	{
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ui.setPluginPanel(hiscorePanel);
		ui.expand();
	}
        
        @Subscribe
        public void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged optionsChanged){
                int idx = optionsChanged.getIndex();
                /*
                 * If the lookup option is going to be overwritten and there is an empty spot available, change it to the new index.
                 * When no option is available, it does not add the lookup option.
                 *
                 */
                if( lookupMenuIndex == idx )
                {
                        int emptySpot = findEmptySpot();
                        if( emptySpot != -1 )
                        {
                                lookupMenuIndex = emptySpot;
                                addLookupOption();
                        }
                }
        }
        
        private void addLookupOption(){
                client.getPlayerOptions()[lookupMenuIndex] = lookupMenuText;
                client.getPlayerOptionsPriorities()[lookupMenuIndex] = true;
                client.getPlayerMenuType()[lookupMenuIndex] = lookupMenuType;
        }
        
        /* This method finds an empty spot between 4 and 7.
         * The lookup function should always be underneath "Follow" (index 2) and "Trade with" (index 3).
         * Thats why I start with index 4.
         *
         * Returns -1 if no spot is available
         */
        private int findEmptySpot(){
                
                int index = 4;
                /*
                 * The index needs to be between 4 and 7,
                 * It can't be the same as the one it's in right now
                 * It has to be a free spot
                 */
                while(index < 8 && ( index == lookupMenuIndex || client.getPlayerOptions()[index] != null ) )
                {
                        index++;
                }
                
                //If an empty spot was found, return the index, otherwise return -1;
                return index != 8 ? index : -1;
                    
        }
        
        @Subscribe
        public void onLookupMenuClicked(PlayerMenuOptionClicked event)
        {
                if(event.getMenuOption().equals(lookupMenuText))
                {
                        hiscorePanel.lookup(event.getMenuTarget());
                }
        }
}
