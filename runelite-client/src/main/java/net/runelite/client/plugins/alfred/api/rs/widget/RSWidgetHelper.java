package net.runelite.client.plugins.alfred.api.rs.widget;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

//    public Widget findWidget(String text, List<Widget> children, boolean exact) {
//        return Alfred.getClientThread().invokeOnClientThread(() -> {
//            Widget foundWidget = null;
//            if (children == null) {
//                List<Widget> rootWidgets = Arrays.stream(Alfred.getClient().getWidgetRoots()).filter(x -> !x.isHidden()).collect(Collectors.toList());
//                for (Widget rootWidget : rootWidgets) {
//                    if (exact) {
//                        if (rootWidget.getText().toLowerCase().contains(text.toLowerCase()) || rootWidget.getName().toLowerCase().contains(">" + text.toLowerCase() + "<")) {
//                            return rootWidget;
//                        }
//                    } else {
//                        if (rootWidget.getText().toLowerCase().contains(text.toLowerCase()) || rootWidget.getName().toLowerCase().contains(text.toLowerCase())) {
//                            return rootWidget;
//                        }
//                    }
//                    if (rootWidget.getChildren() != null)
//                        return findWidget(text, Arrays.stream(rootWidget.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
//                    if (rootWidget.getNestedChildren().length > 0)
//                        return findWidget(text, Arrays.stream(rootWidget.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
//                    if (rootWidget.getDynamicChildren().length > 0)
//                        return findWidget(text, Arrays.stream(rootWidget.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
//                    if (rootWidget.getStaticChildren().length > 0)
//                        return findWidget(text, Arrays.stream(rootWidget.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
//                }
//            } else if (children.size() > 0) {
//                for (Widget child : children) {
//                    foundWidget = searchChildren(text, child, exact);
//                    if (foundWidget != null) break;
//                }
//            }
//            return foundWidget;
//        });
//    }
//
//    public Widget searchChildren(String text, Widget child, boolean exact) {
//        Widget found = null;
//        if (exact) {
//            if (child.getText().toLowerCase().contains(text.toLowerCase()) || child.getName().toLowerCase().contains(">" + text.toLowerCase() + "<")) {
//                return child;
//            }
//        } else {
//            if (child.getText().toLowerCase().contains(text.toLowerCase()) || child.getName().toLowerCase().contains(text.toLowerCase())) {
//                return child;
//            }
//        }
//
//        if (child.getChildren() != null) {
//            List<Widget> visibleChildWidgets = Arrays.stream(child.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
//            if (visibleChildWidgets.size() > 0)
//                found = findWidget(text, visibleChildWidgets, exact);
//        }
//        if (found != null) return found;
//        if (child.getNestedChildren().length > 0) {
//            List<Widget> visibleChildWidgets = Arrays.stream(child.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
//            if (visibleChildWidgets.size() > 0)
//                found = findWidget(text, visibleChildWidgets, exact);
//        }
//        if (found != null) return found;
//        if (child.getDynamicChildren().length > 0) {
//            List<Widget> visibleChildWidgets = Arrays.stream(child.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
//            if (visibleChildWidgets.size() > 0)
//                found = findWidget(text, visibleChildWidgets, exact);
//        }
//        if (found != null) return found;
//        if (child.getStaticChildren().length > 0) {
//            List<Widget> visibleChildWidgets = Arrays.stream(child.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
//            if (visibleChildWidgets.size() > 0)
//                found = findWidget(text, visibleChildWidgets, exact);
//        }
//        return found;
//    }
//
//    public Widget searchChildren(String text, Widget child) {
//        return searchChildren(text, child, false);
//    }

}
