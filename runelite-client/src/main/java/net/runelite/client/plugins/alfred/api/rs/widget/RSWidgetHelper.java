package net.runelite.client.plugins.alfred.api.rs.widget;

import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

public class RSWidgetHelper {

    public RSWidgetHelper() {
    }

    private boolean internalClickWidget(Widget widget, boolean rightClick) {
        if (widget.isHidden() || widget.isSelfHidden()) {
            return false;
        }

        if (widget.getBounds() == null) {
            return false;
        }

        if (rightClick) {
            Alfred.getMouse().rightClick(widget.getBounds());
        } else {
            Alfred.getMouse().leftClick(widget.getBounds());
        }
        return true;
    }

    public boolean leftClickWidget(Widget widget) {
        return internalClickWidget(widget, false);
    }

    public boolean leftClickWidget(WidgetInfo widgetInfo) {
        return leftClickWidget(Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widgetInfo)));
    }

    public boolean leftClickWidget(int widgetId) {
        return leftClickWidget(Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widgetId)));
    }

    public boolean rightClickWidget(Widget widget) {
        return internalClickWidget(widget, true);
    }

    public boolean rightClickWidget(WidgetInfo widgetInfo) {
        return rightClickWidget(Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widgetInfo)));
    }

    public boolean rightClickWidget(int widgetId) {
        return rightClickWidget(Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widgetId)));
    }

    public Widget getChildWidget(Widget widget, int childId) {
        return Alfred.getClientThread().invokeOnClientThread(() -> widget.getChild(childId));
    }
}
