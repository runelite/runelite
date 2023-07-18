package net.runelite.client.plugins.alfred.api.rs.widget;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

@Slf4j(topic = "RSWidgetHelper")
public class RSWidgetHelper {

    public RSWidgetHelper() {
    }


    private Widget internalGetWidget(int widgetId) {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widgetId));
    }

    public Widget getWidget(WidgetInfo widgetInfo) {
        return internalGetWidget(widgetInfo.getId());
    }

    public Widget getWidget(int widgetId) {
        return internalGetWidget(widgetId);
    }

    private Widget internalGetChildWidget(int widgetId, int childId) {
        Widget parentWidget = internalGetWidget(widgetId);
        if (parentWidget == null) {
            return null;
        }
        return parentWidget.getChild(childId);
    }

    public Widget getChildWidget(WidgetInfo widgetInfo, int childId) {
        return internalGetChildWidget(widgetInfo.getId(), childId);
    }

    public Widget getChildWidget(int widgetId, int childId) {
        return internalGetChildWidget(widgetId, childId);
    }

    private boolean internalClickWidget(Widget widget, boolean rightClick) {
        if (widget == null) {
            return false;
        }

        if (widget.getBounds() == null) {
            return false;
        }

        if (widget.isHidden() || widget.isSelfHidden()) {
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
        return internalClickWidget(getWidget(widgetInfo), false);
    }

    public boolean leftClickWidget(int widgetId) {
        return internalClickWidget(getWidget(widgetId), false);
    }

    public boolean rightClickWidget(Widget widget) {
        return internalClickWidget(widget, true);
    }

    public boolean rightClickWidget(WidgetInfo widgetInfo) {
        return internalClickWidget(getWidget(widgetInfo), true);
    }

    public boolean rightClickWidget(int widgetId) {
        return internalClickWidget(getWidget(widgetId), true);
    }

}
