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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.runelite.client.RuneLite;
import net.runelite.client.events.PlayerMenuOptionClicked;
import net.runelite.client.events.PlayerMenuOptionsChanged;

public class MenuManager {
    
        private final RuneLite runeLite;

        private final Map<Integer, PlayerMenuItem> playerMenuItemMap; //Key: menuAction, Value: MenuItem.
        private final List<Integer> usedPlayerMenuIndices;
        
        
        /* 1007 is the highest number the rs client uses for actions. There is no way to see which ones are used, 
         * so im starting from 1500. Its just a number well over their maximum, so if a new action gets added, chances are little
         * it interferes with the actions the MenuManager uses.
         */
        private int menuActionCounter = 1500;

        public MenuManager(RuneLite runeLite)
        {
                this.runeLite = runeLite;
                this.playerMenuItemMap = new HashMap<>();
                this.usedPlayerMenuIndices = new ArrayList<>();
        }

        public boolean addPlayerMenuItem(String menuText, Consumer<String> menuActionCallback)
        {
                int playerMenuIndex = findEmptyPlayerMenuIndex();
                if(playerMenuIndex != 8)
                {
                        int menuAction = menuActionCounter++;
                        
                        PlayerMenuItem menuItem = new PlayerMenuItem();
                        menuItem.setMenuAction(menuActionCallback);
                        menuItem.setPlayerMenuIndex(playerMenuIndex);
                        menuItem.setPlayerMenuName(menuText);
                        menuItem.setMenuType(menuAction);
                        
                        addPlayerMenuItem(playerMenuIndex, menuItem);
                        playerMenuItemMap.put(menuAction, menuItem);
                        usedPlayerMenuIndices.add(playerMenuIndex);
                        
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
                if( usedPlayerMenuIndices.contains(idx) )
                {
                        /** Find the playerMenuItem that was on this index */
                        PlayerMenuItem menuItem = playerMenuItemMap.values().stream().filter(item-> item.getPlayerMenuIndex() == idx).findFirst().get();
                        
                        int newIdx = findEmptyPlayerMenuIndex();
                        if( newIdx != 8 )
                        {
                                menuItem.setPlayerMenuIndex(newIdx);
                                addPlayerMenuItem(newIdx, menuItem);
                        }
                        
                        usedPlayerMenuIndices.add((Integer)newIdx);
                        usedPlayerMenuIndices.remove((Integer)idx);
                }
        }
        
        @Subscribe
        public void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
        {
                /* Only handle this PlayerMenuOptionClick if it was added by the MenuManager. */
                PlayerMenuItem menuItem = playerMenuItemMap.get(event.getMenuAction());
                if( menuItem != null && usedPlayerMenuIndices.contains(menuItem.getPlayerMenuIndex()) )
                {
                        int menuAction = event.getMenuAction();
                        playerMenuItemMap.get(menuAction).getMenuAction().accept(event.getMenuTarget());
                }
        }
        
        private void addPlayerMenuItem( int playerOptionIndex, PlayerMenuItem menuItem )
        {
                RuneLite.getClient().getPlayerOptions()[playerOptionIndex] = menuItem.getPlayerMenuName();
                RuneLite.getClient().getPlayerOptionsPriorities()[playerOptionIndex] = true;
                RuneLite.getClient().getPlayerMenuType()[playerOptionIndex] = menuItem.getMenuType();
        }

        private int findEmptyPlayerMenuIndex()
        {
                int index = 4;
                /*
                 * The index needs to be between 4 and 7,
                 * It can't be the same as the one it's in right now
                 * It has to be a free spot
                 */
                
                while( index < 8 && ( RuneLite.getClient().getPlayerOptions()[index] != null || usedPlayerMenuIndices.contains(index) ) )
                {
                        index ++;
                }
                
                return index;
        }

}
