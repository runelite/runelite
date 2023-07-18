package net.runelite.client.plugins.alfred.api.rs.combat;

import net.runelite.api.VarPlayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

public class RSCombatHelper {

    public RSCombatHelper() {
    }

    public boolean clickPunch() {
        Alfred.api.tabs().clickCombatTab();
        Alfred.sleep(200, 400);

        Widget punch = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(WidgetInfo.COMBAT_STYLE_ONE));
        if (punch == null) {
            return false;
        }

        Alfred.getMouse().leftClick(punch.getBounds());
        return true;
    }

    public boolean clickKick() {
        Alfred.api.tabs().clickCombatTab();
        Alfred.sleep(200, 400);

        Widget punch = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(WidgetInfo.COMBAT_STYLE_TWO));
        if (punch == null) {
            return false;
        }

        Alfred.getMouse().leftClick(punch.getBounds());
        return true;
    }

    public boolean clickBlock() {
        Alfred.api.tabs().clickCombatTab();
        Alfred.sleep(200, 400);

        Widget punch = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(WidgetInfo.COMBAT_STYLE_FOUR));
        if (punch == null) {
            return false;
        }

        Alfred.getMouse().leftClick(punch.getBounds());
        return true;
    }

    public boolean clickAutoRetaliate() {
        Alfred.api.tabs().clickCombatTab();
        Alfred.sleep(200, 400);

        Widget punch = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE));
        if (punch == null) {
            return false;
        }

        Alfred.getMouse().leftClick(punch.getBounds());
        return true;
    }

    public boolean isPunchSelected() {
        return Alfred.getVarbitPlayerValue(VarPlayer.ATTACK_STYLE) == 0;
    }

    public boolean isKickSelected() {
        return Alfred.getVarbitPlayerValue(VarPlayer.ATTACK_STYLE) == 1;
    }

    public boolean isBlockSelected() {
        return Alfred.getVarbitPlayerValue(VarPlayer.ATTACK_STYLE) == 3;
    }

    public boolean isAutoRetaliateSelected() {
        return Alfred.getVarbitPlayerValue(172) == 0;
    }
}
