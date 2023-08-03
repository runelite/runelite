package net.runelite.client.plugins.alfred.api.rs.tab;

import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSTabHelper {

    public WidgetInfo getCurrentTab() {
        int tabVar = Alfred.getClient().getVarcIntValue(VarClientInt.INVENTORY_TAB);
        switch (tabVar) {
            case 0:
                return WidgetInfo.FIXED_VIEWPORT_COMBAT_TAB;
            case 1:
                return WidgetInfo.FIXED_VIEWPORT_STATS_TAB;
            case 2:
                return WidgetInfo.FIXED_VIEWPORT_QUESTS_TAB;
            case 3:
                return WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB;
            case 4:
                return WidgetInfo.FIXED_VIEWPORT_EQUIPMENT_TAB;
            case 5:
                return WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB;
            case 6:
                return WidgetInfo.FIXED_VIEWPORT_MAGIC_TAB;
            case 7:
                return WidgetInfo.FIXED_VIEWPORT_FRIENDS_CHAT_TAB;
            case 9:
                return WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB;
            case 10:
                return WidgetInfo.FIXED_VIEWPORT_LOGOUT_TAB;
            case 11:
                return WidgetInfo.FIXED_VIEWPORT_OPTIONS_TAB;
            case 12:
                return WidgetInfo.FIXED_VIEWPORT_EMOTES_TAB;
            case 13:
                return WidgetInfo.FIXED_VIEWPORT_MUSIC_TAB;
            default:
                throw new IllegalStateException("Unexpected tab value: " + tabVar);
        }
    }

    private boolean clickTab(WidgetInfo widgetInfo) {
        if (widgetInfo.getId() == getCurrentTab().getId()) {
            return true;
        }

        Alfred.setStatus("Clicking tab: " + widgetInfo.name());

        Rectangle bounds = Alfred.api.widgets().getWidget(widgetInfo).getBounds();
        if (bounds == null) {
            return false;
        }

        Alfred.getMouse().leftClick(bounds);
        return Alfred.sleepUntil(() -> getCurrentTab() == widgetInfo, 100, 3000);
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
