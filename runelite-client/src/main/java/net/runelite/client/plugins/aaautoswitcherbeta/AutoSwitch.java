package net.runelite.client.plugins.aaautoswitcherbeta;

public class AutoSwitch {

    public boolean isTabSwitch = false;

    public boolean isItemSwitch = false;

    public int itemID = -1;
    public String tabName = "";

    public AutoSwitch(String type, int id) {
            isItemSwitch=true;
            itemID = id;
    }
    public AutoSwitch(String type, String name) {
            isTabSwitch = true;
            tabName = name;
    }

}
