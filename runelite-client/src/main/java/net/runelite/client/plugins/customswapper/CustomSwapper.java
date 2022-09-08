package net.runelite.client.plugins.customswapper;

import com.google.common.base.Splitter;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.vars.InterfaceTab;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.externals.utils.ExtUtils;
import net.runelite.client.plugins.externals.utils.Tab;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.HotkeyListener;
import org.apache.commons.lang3.tuple.Pair;

import javax.inject.Inject;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@PluginDescriptor(
        name = "Custom Swapper",
        description = "Use plugin in PvP situations for best results",
        tags = {"op", "af", "ganom"}
)
@Slf4j
@SuppressWarnings("unused")
@PluginDependency(ExtUtils.class)
public class CustomSwapper extends Plugin
{
    private static final Splitter NEWLINE_SPLITTER = Splitter
            .on("\n")
            .omitEmptyStrings()
            .trimResults();

    @Inject
    private Client client;

    @Inject
    private KeyManager keyManager;

    @Inject
    private CustomSwapperConfig config;

    @Inject
    private EventBus eventBus;

    @Inject
    private ExtUtils utils;

    private ExecutorService executor;
    private Robot robot;

    @Provides
    CustomSwapperConfig getConfig(ConfigManager manager)
    {
        return manager.getConfig(CustomSwapperConfig.class);
    }

    @Override
    protected void startUp() throws AWTException
    {
        executor = Executors.newFixedThreadPool(1);
        robot = new Robot();
        if (client.getGameState() == GameState.LOGGED_IN)
        {
            keyManager.registerKeyListener(one);
            keyManager.registerKeyListener(two);
            keyManager.registerKeyListener(three);
            keyManager.registerKeyListener(four);
            keyManager.registerKeyListener(five);
            keyManager.registerKeyListener(six);
            keyManager.registerKeyListener(seven);
            keyManager.registerKeyListener(eight);
            keyManager.registerKeyListener(nine);
            keyManager.registerKeyListener(ten);
            keyManager.registerKeyListener(eleven);
            keyManager.registerKeyListener(twelve);
            keyManager.registerKeyListener(thirteen);
            keyManager.registerKeyListener(fourteen);
            keyManager.registerKeyListener(fifteen);
            keyManager.registerKeyListener(sixteen);
            keyManager.registerKeyListener(seventeen);
            keyManager.registerKeyListener(eighteen);
            keyManager.registerKeyListener(nineteen);
            keyManager.registerKeyListener(twenty);
        }
    }

    @Override
    protected void shutDown()
    {
        executor.shutdown();
        keyManager.unregisterKeyListener(one);
        keyManager.unregisterKeyListener(two);
        keyManager.unregisterKeyListener(three);
        keyManager.unregisterKeyListener(four);
        keyManager.unregisterKeyListener(five);
        keyManager.unregisterKeyListener(six);
        keyManager.unregisterKeyListener(seven);
        keyManager.unregisterKeyListener(eight);
        keyManager.unregisterKeyListener(nine);
        keyManager.unregisterKeyListener(ten);
        keyManager.unregisterKeyListener(eleven);
        keyManager.unregisterKeyListener(twelve);
        keyManager.unregisterKeyListener(thirteen);
        keyManager.unregisterKeyListener(fourteen);
        keyManager.unregisterKeyListener(fifteen);
        keyManager.unregisterKeyListener(sixteen);
        keyManager.unregisterKeyListener(seventeen);
        keyManager.unregisterKeyListener(eighteen);
        keyManager.unregisterKeyListener(nineteen);
        keyManager.unregisterKeyListener(twenty);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() != GameState.LOGGED_IN)
        {
            keyManager.unregisterKeyListener(one);
            keyManager.unregisterKeyListener(two);
            keyManager.unregisterKeyListener(three);
            keyManager.unregisterKeyListener(four);
            keyManager.unregisterKeyListener(five);
            keyManager.unregisterKeyListener(six);
            keyManager.unregisterKeyListener(seven);
            keyManager.unregisterKeyListener(eight);
            keyManager.unregisterKeyListener(nine);
            keyManager.unregisterKeyListener(ten);
            keyManager.unregisterKeyListener(eleven);
            keyManager.unregisterKeyListener(twelve);
            keyManager.unregisterKeyListener(thirteen);
            keyManager.unregisterKeyListener(fourteen);
            keyManager.unregisterKeyListener(fifteen);
            keyManager.unregisterKeyListener(sixteen);
            keyManager.unregisterKeyListener(seventeen);
            keyManager.unregisterKeyListener(eighteen);
            keyManager.unregisterKeyListener(nineteen);
            keyManager.unregisterKeyListener(twenty);
            return;
        }
        keyManager.registerKeyListener(one);
        keyManager.registerKeyListener(two);
        keyManager.registerKeyListener(three);
        keyManager.registerKeyListener(four);
        keyManager.registerKeyListener(five);
        keyManager.registerKeyListener(six);
        keyManager.registerKeyListener(seven);
        keyManager.registerKeyListener(eight);
        keyManager.registerKeyListener(nine);
        keyManager.registerKeyListener(ten);
        keyManager.registerKeyListener(eleven);
        keyManager.registerKeyListener(twelve);
        keyManager.registerKeyListener(thirteen);
        keyManager.registerKeyListener(fourteen);
        keyManager.registerKeyListener(fifteen);
        keyManager.registerKeyListener(sixteen);
        keyManager.registerKeyListener(seventeen);
        keyManager.registerKeyListener(eighteen);
        keyManager.registerKeyListener(nineteen);
        keyManager.registerKeyListener(twenty);
    }

    @Subscribe
    public void onCommandExecuted(CommandExecuted event)
    {
        if (event.getCommand().equalsIgnoreCase("copycs"))
        {
            final ItemContainer e = client.getItemContainer(InventoryID.EQUIPMENT);

            if (e == null)
            {
                log.error("CopyCS: Can't find equipment container.");
                return;
            }

            final StringBuilder sb = new StringBuilder();

            for (Item item : e.getItems())
            {
                if (item.getId() == -1 || item.getId() == 0)
                {
                    continue;
                }

                sb.append(item.getId());
                sb.append(":");
                sb.append("Equip");
                sb.append("\n");
            }

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(sb.toString()), null);
        }
    }

    private void decode(String string)
    {
        final Map<String, String> map = new LinkedHashMap<>();
        final List<Pair<Tab, Rectangle>> rectPairs = new ArrayList<>();
        final Iterable<String> tmp = NEWLINE_SPLITTER.split(string);

        for (String s : tmp)
        {
            if (s.startsWith("//"))
            {
                continue;
            }
            String[] split = s.split(":");
            try
            {
                map.put(split[0], split[1]);
            }
            catch (IndexOutOfBoundsException e)
            {
                log.error("Decode: Invalid Syntax in decoder.");
                dispatchError("Invalid Syntax in decoder.");
                return;
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            String param = entry.getKey();
            String command = entry.getValue().toLowerCase();

            switch (command)
            {
                case "equip":
                {
                    final Rectangle rect = invBounds(Integer.parseInt(param));

                    if (rect == null)
                    {
                        log.debug("Equip: Can't find valid bounds for param {}.", param);
                        continue;
                    }

                    rectPairs.add(Pair.of(Tab.INVENTORY, rect));
                }
                break;
                case "clean":
                {
                    final List<Rectangle> rectangleList = listOfBounds(Integer.parseInt(param));

                    if (rectangleList.isEmpty())
                    {
                        log.debug("Clean: Can't find valid bounds for param {}.", param);
                        continue;
                    }

                    for (Rectangle rect : rectangleList)
                    {
                        rectPairs.add(Pair.of(Tab.INVENTORY, rect));
                    }
                }
                break;
                case "remove":
                {
                    final Rectangle rect = equipBounds(Integer.parseInt(param));

                    if (rect == null)
                    {
                        log.debug("Remove: Can't find valid bounds for param {}.", param);
                        continue;
                    }

                    rectPairs.add(Pair.of(Tab.EQUIPMENT, rect));
                }
                break;
                case "prayer":
                {
                    final WidgetInfo info = utils.getPrayerWidgetInfo(param);
                    final Prayer p = Prayer.valueOf(param.toUpperCase().replace(" ", "_"));

                    if (config.enablePrayCheck() && client.isPrayerActive(p))
                    {
                        continue;
                    }

                    if (info == null)
                    {
                        log.debug("Prayer: Can't find valid widget info for param {}.", param);
                        continue;
                    }

                    final Widget widget = client.getWidget(info);

                    if (widget == null)
                    {
                        log.debug("Prayer: Can't find valid widget for param {}.", param);
                        continue;
                    }

                    rectPairs.add(Pair.of(Tab.PRAYER, widget.getBounds()));
                }
                break;
                case "cast":
                {
                    final WidgetInfo info = utils.getSpellWidgetInfo(param);

                    if (info == null)
                    {
                        log.debug("Cast: Can't find valid widget info for param {}.", param);
                        continue;
                    }

                    final Widget widget = client.getWidget(info);

                    if (widget == null)
                    {
                        log.debug("Cast: Can't find valid widget for param {}.", param);
                        continue;
                    }

                    rectPairs.add(Pair.of(Tab.SPELLBOOK, widget.getBounds()));
                }
                break;
                case "enable":
                {
                    final Widget widget = client.getWidget(593, 35);

                    if (widget == null)
                    {
                        log.debug("Spec: Can't find valid widget");
                        continue;
                    }

                    rectPairs.add(Pair.of(Tab.COMBAT, widget.getBounds()));
                }
                break;
            }
        }

        executor.submit(() ->
        {
            for (Pair<Tab, Rectangle> pair : rectPairs)
            {
                int key = utils.getTabHotkey(pair.getLeft());

                if (key == -1 || key == 0)
                {
                    log.error("Unable to find key for tab.");
                    dispatchError("Unable to find " + pair.getLeft().toString() + " hotkey.");
                    break;
                }

                executePair(pair);
                log.debug("Executing click on: {}", pair);

                try
                {
                    Thread.sleep(getMillis());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            if (config.swapBack())
            {
                log.debug("Swapping back to inventory.");
                robot.keyPress(utils.getTabHotkey(Tab.INVENTORY));
            }
        });
    }

    private void executePair(Pair<Tab, Rectangle> pair)
    {
        switch (pair.getLeft())
        {
            case COMBAT:
                if (client.getVar(VarClientInt.INVENTORY_TAB) != InterfaceTab.COMBAT.getId())
                {
                    robot.delay((int) getMillis());
                    robot.keyPress(utils.getTabHotkey(pair.getLeft()));
                    robot.delay((int) getMillis());
                }
                utils.click(pair.getRight());
                break;
            case EQUIPMENT:
                if (client.getVar(VarClientInt.INVENTORY_TAB) != InterfaceTab.EQUIPMENT.getId())
                {
                    robot.delay((int) getMillis());
                    robot.keyPress(utils.getTabHotkey(pair.getLeft()));
                    robot.delay((int) getMillis());
                }
                utils.click(pair.getRight());
                break;
            case INVENTORY:
                if (client.getVar(VarClientInt.INVENTORY_TAB) != InterfaceTab.INVENTORY.getId())
                {
                    robot.delay((int) getMillis());
                    robot.keyPress(utils.getTabHotkey(pair.getLeft()));
                    robot.delay((int) getMillis());
                }
                utils.click(pair.getRight());
                break;
            case PRAYER:
                if (client.getVar(VarClientInt.INVENTORY_TAB) != InterfaceTab.PRAYER.getId())
                {
                    robot.delay((int) getMillis());
                    robot.keyPress(utils.getTabHotkey(pair.getLeft()));
                    robot.delay((int) getMillis());
                }
                utils.click(pair.getRight());
                break;
            case SPELLBOOK:
                if (client.getVar(VarClientInt.INVENTORY_TAB) != InterfaceTab.SPELLBOOK.getId())
                {
                    robot.delay((int) getMillis());
                    robot.keyPress(utils.getTabHotkey(pair.getLeft()));
                    robot.delay((int) getMillis());
                }
                utils.click(pair.getRight());
                break;
        }
    }

    private void dispatchError(String error)
    {
        String str = ColorUtil.wrapWithColorTag("Custom Swapper", Color.MAGENTA)
                + " has encountered an "
                + ColorUtil.wrapWithColorTag("error", Color.RED)
                + ": "
                + error;

        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str, null);
    }

    private Rectangle invBounds(int id)
    {
        final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

        if (inventoryWidget == null)
        {
            return null;
        }

        for (Widget item : inventoryWidget.getDynamicChildren())
        {
            if (item.getItemId() == id)
            {
                return item.getBounds();
            }
        }

        return null;
    }

    private List<Rectangle> listOfBounds(int id)
    {
        final Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
        final List<Rectangle> bounds = new ArrayList<>();

        if (inventoryWidget == null)
        {
            return bounds;
        }

        for (Widget item : inventoryWidget.getDynamicChildren())
        {
            if (item.getItemId() == id)
            {
                bounds.add(item.getBounds());
            }
        }

        return bounds;
    }

    private Rectangle equipBounds(int id)
    {
        final Widget equipmentWidget = client.getWidget(WidgetInfo.EQUIPMENT);

        if (equipmentWidget == null)
        {
            return null;
        }

        if (equipmentWidget.getStaticChildren() == null)
        {
            return null;
        }

        for (Widget widgets : equipmentWidget.getStaticChildren())
        {
            for (Widget items : widgets.getDynamicChildren())
            {
                if (items.getItemId() == id)
                {
                    return items.getBounds();
                }
            }
        }

        return null;
    }

    private long getMillis()
    {
        return (long) (Math.random() * config.randLow() + config.randHigh());
    }

    private final HotkeyListener one = new HotkeyListener(() -> config.customOne())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapOne());
        }
    };

    private final HotkeyListener two = new HotkeyListener(() -> config.customTwo())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapTwo());
        }
    };

    private final HotkeyListener three = new HotkeyListener(() -> config.customThree())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapThree());
        }
    };

    private final HotkeyListener four = new HotkeyListener(() -> config.customFour())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapFour());
        }
    };

    private final HotkeyListener five = new HotkeyListener(() -> config.customFive())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapFive());
        }
    };

    private final HotkeyListener six = new HotkeyListener(() -> config.customSix())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapSix());
        }
    };

    private final HotkeyListener seven = new HotkeyListener(() -> config.customSeven())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapSeven());
        }
    };

    private final HotkeyListener eight = new HotkeyListener(() -> config.customEight())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapEight());
        }
    };

    private final HotkeyListener nine = new HotkeyListener(() -> config.customNine())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapNine());
        }
    };

    private final HotkeyListener ten = new HotkeyListener(() -> config.customTen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapTen());
        }
    };

    private final HotkeyListener eleven = new HotkeyListener(() -> config.customEleven())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapEleven());
        }
    };

    private final HotkeyListener twelve = new HotkeyListener(() -> config.customTwelve())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapTwelve());
        }
    };

    private final HotkeyListener thirteen = new HotkeyListener(() -> config.customThirteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapThirteen());
        }
    };

    private final HotkeyListener fourteen = new HotkeyListener(() -> config.customFourteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapFourteen());
        }
    };

    private final HotkeyListener fifteen = new HotkeyListener(() -> config.customFifteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapFifteen());
        }
    };

    private final HotkeyListener sixteen = new HotkeyListener(() -> config.customSixteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapSixteen());
        }
    };

    private final HotkeyListener seventeen = new HotkeyListener(() -> config.customSeventeen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapSeventeen());
        }
    };

    private final HotkeyListener eighteen = new HotkeyListener(() -> config.customEighteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapEighteen());
        }
    };

    private final HotkeyListener nineteen = new HotkeyListener(() -> config.customNineteen())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapNineteen());
        }
    };

    private final HotkeyListener twenty = new HotkeyListener(() -> config.customTwenty())
    {
        @Override
        public void hotkeyPressed()
        {
            decode(config.customSwapTwenty());
        }
    };
}
