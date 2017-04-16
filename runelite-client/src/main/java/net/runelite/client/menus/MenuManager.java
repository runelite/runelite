/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.menus;

import com.google.common.eventbus.Subscribe;
import java.util.HashMap;
import java.util.Map;
import net.runelite.client.RuneLite;
import net.runelite.client.events.PlayerMenuOptionsChanged;

public class MenuManager {
    
        private final RuneLite runeLite;
        
        //Maps the indexes that are being used to the menu option.
        private final Map<Integer, String> playerMenuIndexMap;
        
        /* 1007 is the highest number the rs client uses for actions. There is no way to see which ones are used, 
         * so im starting from 1500. Its just a number well over their maximum, so if a new action gets added, chances are little
         * it interferes with the action the MenuManager uses.
         */
        private static final int MENU_ACTION = 1500;

        public MenuManager(RuneLite runeLite)
        {
                this.runeLite = runeLite;
                this.playerMenuIndexMap = new HashMap<>();
        }

        public boolean addPlayerMenuItem(String menuText)
        {
                int playerMenuIndex = findEmptyPlayerMenuIndex();
                if(playerMenuIndex != 8)
                {       
                        addPlayerMenuItem(playerMenuIndex, menuText);
                        playerMenuIndexMap.put(playerMenuIndex, menuText);
                        
                        return true;
                }
                else
                {
                        return false; //The playerMenuOptions are full, so no option was added
                }
        }
        
        @Subscribe
        public void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged event)
        {
                int idx = event.getIndex();
                if( playerMenuIndexMap.containsKey(idx) )
                {
                        String menuText = playerMenuIndexMap.get(idx);
                        int newIdx = findEmptyPlayerMenuIndex();
                        if( newIdx != 8 )
                        {
                                addPlayerMenuItem(newIdx, menuText);
                                playerMenuIndexMap.put(newIdx, menuText);
                        }
                        playerMenuIndexMap.remove((Integer)idx);
                }
        }
        
        private void addPlayerMenuItem( int playerOptionIndex, String menuText )
        {
                RuneLite.getClient().getPlayerOptions()[playerOptionIndex] = menuText;
                RuneLite.getClient().getPlayerOptionsPriorities()[playerOptionIndex] = true;
                RuneLite.getClient().getPlayerMenuType()[playerOptionIndex] = MENU_ACTION;
        }

        private int findEmptyPlayerMenuIndex()
        {
                int index = 4;
                /*
                 * The index needs to be between 4 and 7,
                 * It can't be the same as the one it's in right now
                 * It has to be a free spot
                 */
                
                while( index < 8 && ( RuneLite.getClient().getPlayerOptions()[index] != null || playerMenuIndexMap.containsKey(index) ) )
                {
                        index ++;
                }
                
                return index;
        }

}
