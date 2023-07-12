package net.runelite.client.plugins.alfred.api.rs;

import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.alfred.Alfred;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WidgetAPI {

    public static boolean clickWidget(String text) {
        Widget widget = findWidget(text, null);
        if (widget != null) {
            Alfred.getMouse().leftClick(widget.getBounds());
            return true;
        }
        return false;
    }

    public static boolean clickWidget(String text, boolean exact) {
        Widget widget = findWidget(text, null, exact);
        if (widget != null) {
            Alfred.getMouse().leftClick(widget.getBounds());
            return true;
        }
        return false;
    }

    public static Widget getWidget(WidgetInfo widget) {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(widget));
    }

    public static Widget getWidget(int id) {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(id));
    }

    public static Widget getWidget(int id, int child) {
        return Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(id, child));
    }

    public static boolean getWidgetChildText(int id, String matchingText) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget widget = Alfred.getClient().getWidget(id);
            if (widget == null) return false;
            if (widget.getChildren().length == 0) return false;
            return Arrays.stream(widget.getChildren()).anyMatch(x -> x.getText().contains(matchingText));
        });
    }

    public static boolean clickWidget(int id) {
        Widget widget = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(id));
        if (widget == null) return false;
        Alfred.getMouse().leftClick(widget.getBounds());
        return true;
    }

    public static boolean clickChildWidget(int id, int childId) {
        Widget widget = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getWidget(id));
        if (widget == null) return false;
        Alfred.getMouse().leftClick(widget.getChild(childId).getBounds());
        return true;
    }

    public static void changeWidgetText(String textToSearch, String newText) {
        do {
            try {
                Widget widget = findWidget(textToSearch, null);
                if (widget == null) break;
                Alfred.getClientThread().invokeOnClientThread(() -> widget.setText(newText));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } while (true);
    }

    public static Widget findWidget(String text, List<Widget> children, boolean exact) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget foundWidget = null;
            if (children == null) {
                List<Widget> rootWidgets = Arrays.stream(Alfred.getClient().getWidgetRoots()).filter(x -> !x.isHidden()).collect(Collectors.toList());
                for (Widget rootWidget : rootWidgets) {
                    if (exact) {
                        if (rootWidget.getText().equalsIgnoreCase(text) || rootWidget.getName().toLowerCase().equals(">" + text.toLowerCase() + "<")) {
                            return rootWidget;
                        }
                    } else {
                        if (rootWidget.getText().toLowerCase().contains(text.toLowerCase()) || rootWidget.getName().toLowerCase().contains(text.toLowerCase())) {
                            return rootWidget;
                        }
                    }
                    if (rootWidget.getChildren() != null)
                        return findWidget(text, Arrays.stream(rootWidget.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
                    if (rootWidget.getNestedChildren().length > 0)
                        return findWidget(text, Arrays.stream(rootWidget.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
                    if (rootWidget.getDynamicChildren().length > 0)
                        return findWidget(text, Arrays.stream(rootWidget.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
                    if (rootWidget.getStaticChildren().length > 0)
                        return findWidget(text, Arrays.stream(rootWidget.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()), exact);
                }
            } else if (children.size() > 0) {
                for (Widget child : children) {
                    foundWidget = searchChildren(text, child, exact);
                    if (foundWidget != null) break;
                }
            }
            return foundWidget;
        });
    }

    public static Widget findWidget(String text) {
        return findWidget(text, null, false);
    }

    public static Widget findWidgetExact(String text) {
        return findWidget(text, null, true);
    }

    public static boolean hasWidget(String text) {
        return findWidget(text, null, false) != null;
    }

//    public static boolean sleepUntilHasWidget(String text) {
//        sleepUntil(() -> findWidget(text, null, false) != null);
//        return true;
//    }

    public static Widget findWidget(String text, List<Widget> children) {
        return findWidget(text, children, false);
    }


    public static Widget searchChildren(String text, Widget child, boolean exact) {
        Widget found = null;
        if (exact) {
            if (child.getText().equalsIgnoreCase(text) || child.getName().toLowerCase().equals(">" + text.toLowerCase() + "<")) {
                return child;
            }
        } else {
            if (child.getText().toLowerCase().contains(text.toLowerCase()) || child.getName().toLowerCase().contains(text.toLowerCase())) {
                return child;
            }
        }

        if (child.getChildren() != null) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(text, visibleChildWidgets, exact);
        }
        if (found != null) return found;
        if (child.getNestedChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(text, visibleChildWidgets, exact);
        }
        if (found != null) return found;
        if (child.getDynamicChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(text, visibleChildWidgets, exact);
        }
        if (found != null) return found;
        if (child.getStaticChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(text, visibleChildWidgets, exact);
        }
        return found;
    }

    public static Widget searchChildren(String text, Widget child) {
        return searchChildren(text, child, false);
    }

    public static Widget findWidget(int spriteId, List<Widget> children) {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            Widget foundWidget = null;
            if (children == null) {
                List<Widget> rootWidgets = Arrays.stream(Alfred.getClient().getWidgetRoots()).filter(x -> !x.isHidden()).collect(Collectors.toList());
                for (Widget rootWidget : rootWidgets) {
                    if (rootWidget.getSpriteId() == spriteId) {
                        return rootWidget;
                    }
                    if (rootWidget.getChildren() != null)
                        return findWidget(spriteId, Arrays.stream(rootWidget.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()));
                    if (rootWidget.getNestedChildren().length > 0)
                        return findWidget(spriteId, Arrays.stream(rootWidget.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()));
                    if (rootWidget.getDynamicChildren().length > 0)
                        return findWidget(spriteId, Arrays.stream(rootWidget.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()));
                    if (rootWidget.getStaticChildren().length > 0)
                        return findWidget(spriteId, Arrays.stream(rootWidget.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList()));
                }
            } else if (children.size() > 0) {
                for (Widget child : children) {
                    foundWidget = searchChildren(spriteId, child);
                    if (foundWidget != null) break;
                }
            }
            return foundWidget;
        });
    }

    public static Widget searchChildren(int spriteId, Widget child) {
        Widget found = null;
        if (child.getSpriteId() == spriteId) {
            return child;
        }
        if (child.getChildren() != null) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(spriteId, visibleChildWidgets);
        }
        if (found != null) return found;
        if (child.getNestedChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getNestedChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(spriteId, visibleChildWidgets);
        }
        if (found != null) return found;
        if (child.getDynamicChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getDynamicChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(spriteId, visibleChildWidgets);
        }
        if (found != null) return found;
        if (child.getStaticChildren().length > 0) {
            List<Widget> visibleChildWidgets = Arrays.stream(child.getStaticChildren()).filter(x -> !x.isHidden()).collect(Collectors.toList());
            if (visibleChildWidgets.size() > 0) found = findWidget(spriteId, visibleChildWidgets);
        }
        return found;
    }

}
