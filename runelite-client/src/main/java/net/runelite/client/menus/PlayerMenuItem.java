/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.runelite.client.menus;

import java.util.function.Consumer;

/**
 *
 * @author robin
 */
public class PlayerMenuItem {
        
    private int playerMenuIndex;
    private String playerMenuName;
    private Consumer<String> menuAction;
    private int menuType;
    
    public PlayerMenuItem()
    {
    }

    public int getPlayerMenuIndex() {
        return playerMenuIndex;
    }

    public void setPlayerMenuIndex(int playerMenuIndex) {
        this.playerMenuIndex = playerMenuIndex;
    }

    public String getPlayerMenuName() {
        return playerMenuName;
    }

    public void setPlayerMenuName(String playerMenuName) {
        this.playerMenuName = playerMenuName;
    }

    public Consumer<String> getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(Consumer<String> menuAction) {
        this.menuAction = menuAction;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }
    
    
}
