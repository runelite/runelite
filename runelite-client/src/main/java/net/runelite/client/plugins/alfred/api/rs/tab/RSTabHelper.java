package net.runelite.client.plugins.alfred.api.rs.tab;

import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.Utility;

import java.awt.*;

public class RSTabHelper {

    public boolean clickTab(WidgetInfo widgetInfo) {
        Rectangle bounds = Utility.getTabBounds(widgetInfo);
        if (bounds == null) {
            return false;
        }

        Alfred.getMouse().leftClick(bounds);
        return true;
    }

    public boolean clickCombatTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_COMBAT_TAB);
    }

    public boolean clickSkillsTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_STATS_TAB);
    }

    public boolean clickQuestsTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_QUESTS_TAB);
    }

    public boolean clickInventoryTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB);
    }

    public boolean clickEquipmentTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_EQUIPMENT_TAB);
    }

    public boolean clickPrayerTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB);
    }

    public boolean clickMagicTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB);
    }

    public boolean clickClanChatTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_FRIENDS_CHAT_TAB);
    }

    public boolean clickFriendsTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB);
    }

    public boolean clickIgnoreTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_IGNORES_TAB);
    }

    public boolean clickLogoutTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_LOGOUT_TAB);
    }

    public boolean clickOptionsTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_OPTIONS_TAB);
    }

    public boolean clickEmotesTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_EMOTES_TAB);
    }

    public boolean clickMusicTab() {
        return clickTab(WidgetInfo.FIXED_VIEWPORT_MUSIC_TAB);
    }


}
