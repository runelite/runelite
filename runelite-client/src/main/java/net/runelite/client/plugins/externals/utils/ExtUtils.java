package net.runelite.client.plugins.externals.utils;

import net.runelite.api.Point;
import net.runelite.api.*;
import net.runelite.api.queries.DecorativeObjectQuery;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.queries.GroundObjectQuery;
import net.runelite.api.queries.WallObjectQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@PluginDescriptor(name = "ExtUtils", hidden = true)
@Singleton
public class ExtUtils extends Plugin {
    private static final Logger log = LoggerFactory.getLogger(ExtUtils.class);

    @Inject
    private Client client;

    protected void startUp() {}

    protected void shutDown() {}

    public int[] stringToIntArray(String string) {
        return Arrays.<String>stream(string.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }

    @Nullable
    public GameObject findNearestGameObject(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return null;
        return (GameObject)((GameObjectQuery)(new GameObjectQuery())
                .idEquals(ids))
                .result(this.client)
                .nearestTo((Locatable)this.client.getLocalPlayer());
    }

    @Nullable
    public WallObject findNearestWallObject(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return null;
        return (WallObject)((WallObjectQuery)(new WallObjectQuery())
                .idEquals(ids))
                .result(this.client)
                .nearestTo((Locatable)this.client.getLocalPlayer());
    }

    @Nullable
    public DecorativeObject findNearestDecorObject(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return null;
        return (DecorativeObject)((DecorativeObjectQuery)(new DecorativeObjectQuery())
                .idEquals(ids))
                .result(this.client)
                .nearestTo((Locatable)this.client.getLocalPlayer());
    }

    @Nullable
    public GroundObject findNearestGroundObject(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return null;
        return (GroundObject)((GroundObjectQuery)(new GroundObjectQuery())
                .idEquals(ids))
                .result(this.client)
                .nearestTo((Locatable)this.client.getLocalPlayer());
    }

    public List<GameObject> getGameObjects(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return new ArrayList<>();
        return

                (((GameObjectQuery)(new GameObjectQuery()).idEquals(ids)).result(this.client)).list;
    }

    public List<WallObject> getWallObjects(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return new ArrayList<>();
        return

                (((WallObjectQuery)(new WallObjectQuery()).idEquals(ids)).result(this.client)).list;
    }

    public List<DecorativeObject> getDecorObjects(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return new ArrayList<>();
        return

                (((DecorativeObjectQuery)(new DecorativeObjectQuery()).idEquals(ids)).result(this.client)).list;
    }

    public List<GroundObject> getGroundObjects(int... ids) {
        assert this.client.isClientThread();
        if (this.client.getLocalPlayer() == null)
            return new ArrayList<>();
        return

                (((GroundObjectQuery)(new GroundObjectQuery()).idEquals(ids)).result(this.client)).list;
    }

    @Nullable
    public TileObject findNearestObject(int... ids) {
        GameObject gameObject = findNearestGameObject(ids);
        if (gameObject != null)
            return (TileObject)gameObject;
        WallObject wallObject = findNearestWallObject(ids);
        if (wallObject != null)
            return (TileObject)wallObject;
        DecorativeObject decorativeObject = findNearestDecorObject(ids);
        if (decorativeObject != null)
            return (TileObject)decorativeObject;
        return (TileObject)findNearestGroundObject(ids);
    }

    public List<Widget> getItems(int... itemIDs) {
        assert this.client.isClientThread();
        Widget inventoryWidget = this.client.getWidget(WidgetInfo.INVENTORY);
        if (inventoryWidget == null)
            return new ArrayList<>();
        return (List<Widget>)Arrays.<Widget>stream(inventoryWidget.getDynamicChildren())
                .filter(child -> Arrays.stream(itemIDs).anyMatch(x -> x == x))
                .collect(Collectors.toList());
    }

    public List<Widget> getEquippedItems(int[] itemIds) {
        assert this.client.isClientThread();
        Widget equipmentWidget = this.client.getWidget(WidgetInfo.EQUIPMENT);
        List<Integer> equippedIds = new ArrayList<>();
        for (int i : itemIds)
            equippedIds.add(Integer.valueOf(i));
        List<Widget> equipped = new ArrayList<>();
        if (equipmentWidget.getStaticChildren() != null) {
            for (Widget widgets : equipmentWidget.getStaticChildren()) {
                for (Widget items : widgets.getDynamicChildren()) {
                    if (equippedIds.contains(Integer.valueOf(items.getItemId())))
                        equipped.add(items);
                }
            }
        } else {
            log.error("Children is Null!");
        }
        return equipped;
    }

    public int getTabHotkey(Tab tab) {
        assert this.client.isClientThread();
        int var = this.client.getVarbitValue(this.client.getVarps(), tab.getVarbit());
        int offset = 111;
        switch (var) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return var + 111;
            case 13:
                return 27;
        }
        return -1;
    }

    public WidgetInfo getSpellWidgetInfo(String spell) {
        assert this.client.isClientThread();
        return Spells.getWidget(spell);
    }

    public WidgetInfo getPrayerWidgetInfo(String spell) {
        assert this.client.isClientThread();
        return PrayerMap.getWidget(spell);
    }

    public Widget getSpellWidget(String spell) {
        assert this.client.isClientThread();
        return this.client.getWidget(Spells.getWidget(spell));
    }

    public Widget getPrayerWidget(String spell) {
        assert this.client.isClientThread();
        return this.client.getWidget(PrayerMap.getWidget(spell));
    }

    public void typeString(String string) {
        assert !this.client.isClientThread();
        for (char c : string.toCharArray())
            pressKey(c);
    }

    public void pressKey(char key) {
        keyEvent(401, key);
        keyEvent(402, key);
        keyEvent(400, key);
    }

    private void keyEvent(int id, char key) {
        KeyEvent e = new KeyEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, 0, key);
        this.client.getCanvas().dispatchEvent(e);
    }

    public void click(Rectangle rectangle) {
        assert !this.client.isClientThread();
        Point point = getClickPoint(rectangle);
        click(point);
    }

    public void click(Point p) {
        assert !this.client.isClientThread();
        if (this.client.isStretchedEnabled()) {
            Dimension stretched = this.client.getStretchedDimensions();
            Dimension real = this.client.getRealDimensions();
            double width = stretched.width / real.getWidth();
            double height = stretched.height / real.getHeight();
            Point point = new Point((int)(p.getX() * width), (int)(p.getY() * height));
            mouseEvent(501, point);
            mouseEvent(502, point);
            mouseEvent(500, point);
            return;
        }
        mouseEvent(501, p);
        mouseEvent(502, p);
        mouseEvent(500, p);
    }

    public Point getClickPoint(Rectangle rect) {
        int x = (int)(rect.getX() + getRandomIntBetweenRange((int)rect.getWidth() / 6 * -1, (int)rect.getWidth() / 6) + rect.getWidth() / 2.0D);
        int y = (int)(rect.getY() + getRandomIntBetweenRange((int)rect.getHeight() / 6 * -1, (int)rect.getHeight() / 6) + rect.getHeight() / 2.0D);
        return new Point(x, y);
    }

    public int getRandomIntBetweenRange(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }

    private void mouseEvent(int id, Point point) {
        MouseEvent e = new MouseEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, point.getX(), point.getY(), 1, false, 1);
        this.client.getCanvas().dispatchEvent(e);
    }
}