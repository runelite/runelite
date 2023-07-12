package net.runelite.client.plugins.alfred.api.rs.item;

import net.runelite.api.ItemComposition;
import net.runelite.api.TileItem;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RSItem {

    private final Object item;

    public RSItem(TileItem item) {
        this.item = item;
    }

    public RSItem(Widget item) {
        this.item = item;
    }

    public int getId() {
        if (item instanceof TileItem) {
            return ((TileItem) item).getId();
        } else if (item instanceof Widget) {
            return ((Widget) item).getItemId();
        }
        return -1;
    }

    public int getQuantity() {
        if (item instanceof TileItem) {
            return ((TileItem) item).getQuantity();
        } else if (item instanceof Widget) {
            return ((Widget) item).getItemQuantity();
        }
        return -1;
    }

    public String getName() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getName();
        });
    }

    public String getMembersName() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getMembersName();
        });
    }

    public int getPrice() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getPrice();
        });
    }

    public int getHighAlchemyPrice() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.getHaPrice();
        });
    }

    public boolean isTradeable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isTradeable();
        });
    }

    public boolean isMembers() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isMembers();
        });
    }

    public boolean isStackable() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            return itemComposition.isStackable();
        });
    }

    public List<String> getInventoryActions() {
        return Alfred.getClientThread().invokeOnClientThread(() -> {
            ItemComposition itemComposition = Alfred.getClient().getItemDefinition(this.getId());
            List<String> actions = new ArrayList<>();
            for (String action : itemComposition.getInventoryActions()) {
                if (action != null) {
                    actions.add(action);
                }
            }
            return actions;
        });
    }

    public Rectangle getBounds() {
        if (item instanceof TileItem) {
            throw new UnsupportedOperationException("TileItem does not have bounds");
        } else if (item instanceof Widget) {
            return ((Widget) item).getBounds();
        }
        return null;
    }

    public boolean drop() {
        if (item instanceof TileItem) {
            throw new UnsupportedOperationException("TileItem does not have bounds");
        } else if (item instanceof Widget) {
            Alfred.api.inventory().drop(this);
        }
        return false;
    }

    public boolean leftClick() {
        if (item instanceof TileItem) {
            throw new UnsupportedOperationException("TileItem does not have bounds");
        } else if (item instanceof Widget) {
            Alfred.getMouse().leftClick(this.getBounds());
        }
        return false;
    }

    public boolean rightClick() {
        if (item instanceof TileItem) {
            throw new UnsupportedOperationException("TileItem does not have bounds");
        } else if (item instanceof Widget) {
            Alfred.getMouse().rightClick(this.getBounds());
        }
        return false;
    }

    public boolean clickAction(String action) {
        if (item instanceof TileItem) {
            throw new UnsupportedOperationException("TileItem does not have bounds");
        } else if (item instanceof Widget) {
            if (!rightClick()) {
                return false;
            }
            Alfred.sleep(200, 600);
            Alfred.api.inventory().clickAction(action);
        }
        return false;
    }

}
