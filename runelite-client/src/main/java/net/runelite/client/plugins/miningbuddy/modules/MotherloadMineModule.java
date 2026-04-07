package net.runelite.client.plugins.miningbuddy.modules;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.miningbuddy.MiningBuddyConfig;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MotherloadMineModule
{
    // Ore vein IDs — active
    private static final Set<Integer> ORE_VEIN_IDS = Set.of(26661, 26662, 26663, 26664);

    // Sack ID
    private static final int SACK_ID = 26688;

    // Bank deposit box ID
    private static final int DEPOSIT_BOX_ID = 25937;

    // Deposit box interface group ID
    private static final int DEPOSIT_BOX_GROUP_ID = 192;

    // Deposit inventory button widget ID
    private static final int DEPOSIT_INV_WIDGET_ID = 12582943;

    // Max inventory slots
    private static final int MAX_INVENTORY_SLOTS = 28;

    @Inject private Client client;
    @Inject private ClientThread clientThread;
    @Inject private MiningBuddyConfig config;

    private final Random random = new Random();
    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    // State
    private boolean miningActive = false;
    private boolean depositActive = false;
    private boolean waitingForDeposit = false;
    private WallObject currentVein = null;
    private final List<WallObject> availableVeins = new ArrayList<>();

    public void startUp()
    {
        resetState();
        clientThread.invokeLater(this::scanExistingVeins);
        log.debug("Motherload Mine module started");
    }

    public void shutDown()
    {
        resetState();
        log.debug("Motherload Mine module stopped");
    }

    private void resetState()
    {
        miningActive = false;
        depositActive = false;
        waitingForDeposit = false;
        currentVein = null;
        availableVeins.clear();
    }

    // ── Scan existing veins on startup ────────────────────────────────────
    private void scanExistingVeins()
    {
        Tile[][][] tiles = client.getScene().getTiles();
        int plane = client.getPlane();

        for (int x = 0; x < tiles[plane].length; x++)
        {
            for (int y = 0; y < tiles[plane][x].length; y++)
            {
                Tile tile = tiles[plane][x][y];
                if (tile == null)
                {
                    continue;
                }

                WallObject wall = tile.getWallObject();
                if (wall != null && ORE_VEIN_IDS.contains(wall.getId()))
                {
                    availableVeins.add(wall);
                    log.debug("Existing ore vein found: {}", wall.getId());
                }
            }
        }

        log.debug("Scan complete, found {} ore veins", availableVeins.size());
    }

    // ── Track ore veins ───────────────────────────────────────────────────
    @Subscribe
    public void onWallObjectSpawned(WallObjectSpawned event)
    {
        if (!config.motherloadEnabled())
        {
            return;
        }

        WallObject obj = event.getWallObject();
        if (ORE_VEIN_IDS.contains(obj.getId()))
        {
            availableVeins.add(obj);
            log.debug("Ore vein spawned: {}", obj.getId());
        }
    }

    @Subscribe
    public void onWallObjectDespawned(WallObjectDespawned event)
    {
        if (!config.motherloadEnabled())
        {
            return;
        }

        WallObject obj = event.getWallObject();
        if (ORE_VEIN_IDS.contains(obj.getId()))
        {
            availableVeins.remove(obj);
            log.debug("Ore vein despawned: {} miningActive={}", obj.getId(), miningActive);

            if (obj == currentVein)
            {
                log.debug("Current vein depleted, switching...");
                handleVeinSwitch();
            }
        }
    }

    // ── Detect player clicking ore vein or sack ───────────────────────────
    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        if (!config.motherloadEnabled())
        {
            return;
        }

        int id = event.getId();
        MenuAction action = event.getMenuAction();

        log.debug("MenuClicked: id={} action={} ORE_VEIN_MATCH={} availableVeins={}",
                id, action, ORE_VEIN_IDS.contains(id), availableVeins.size());

        // Player clicked ore vein — activate mining
        if (ORE_VEIN_IDS.contains(id) && action == MenuAction.GAME_OBJECT_FIRST_OPTION)
        {
            if (availableVeins.isEmpty())
            {
                scanExistingVeins();
            }

            WallObject clickedVein = availableVeins.stream()
                    .filter(v -> v.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (clickedVein != null)
            {
                currentVein = clickedVein;
                miningActive = true;
                depositActive = false;
                waitingForDeposit = false;
                log.debug("Player started mining ore vein: {}", id);
            }
            else
            {
                log.debug("Vein not found in list after scan, veins={}", availableVeins.size());
            }
        }

        // Player clicked sack — activate deposit phase
        if (id == SACK_ID && action == MenuAction.GAME_OBJECT_FIRST_OPTION)
        {
            waitingForDeposit = true;
            miningActive = false;
            log.debug("Player clicked sack, waiting for ores in inventory");
        }

        // Player walked away — stop mining
        if (action == MenuAction.WALK && miningActive)
        {
            miningActive = false;
            currentVein = null;
            log.debug("Player walked away, stopping mining");
        }
    }

    // ── Detect inventory changes ──────────────────────────────────────────
    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        if (!config.motherloadEnabled())
        {
            return;
        }

        if (event.getContainerId() != InventoryID.INV)
        {
            return;
        }

        ItemContainer inventory = event.getItemContainer();
        int usedSlots = countUsedSlots(inventory);

        // Inventory full — stop mining
        if (usedSlots >= MAX_INVENTORY_SLOTS && miningActive)
        {
            log.debug("Inventory full, stopping mining");
            miningActive = false;
            currentVein = null;
        }

        // Ores came into inventory after clicking sack — start deposit phase
        if (waitingForDeposit && usedSlots > 0)
        {
            waitingForDeposit = false;
            depositActive = true;
            log.debug("Ores in inventory, starting deposit phase");
            handleDeposit();
        }
    }

    // ── Detect deposit box interface opened ───────────────────────────────
    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event)
    {
        if (!config.motherloadEnabled())
        {
            return;
        }

        if (event.getGroupId() == DEPOSIT_BOX_GROUP_ID)
        {
            log.debug("Deposit box interface opened, scheduling deposit...");
            scheduleDepositAndClose();
        }
    }

    // ── GameTick ──────────────────────────────────────────────────────────
    @Subscribe
    public void onGameTick(GameTick event)
    {
        // Reserved for future use
    }

    // ── Switch to a new ore vein ──────────────────────────────────────────
    private void handleVeinSwitch()
    {
        if (!miningActive)
        {
            return;
        }

        // Check inventory not full
        ItemContainer inventory = client.getItemContainer(InventoryID.INV);
        if (inventory != null && countUsedSlots(inventory) >= MAX_INVENTORY_SLOTS)
        {
            log.debug("Inventory full, not switching vein");
            miningActive = false;
            currentVein = null;
            return;
        }

        // Find next available vein
        WallObject nextVein = availableVeins.stream()
                .filter(v -> v != currentVein)
                .findFirst()
                .orElse(null);

        if (nextVein == null)
        {
            log.debug("No available veins to switch to");
            miningActive = false;
            return;
        }

        currentVein = nextVein;
        WallObject veinToClick = nextVein;

        int delay = 100 + random.nextInt(300);
        scheduler.schedule(() ->
        {
            clientThread.invokeLater(() ->
            {
                client.menuAction(
                        veinToClick.getLocalLocation().getSceneX(),
                        veinToClick.getLocalLocation().getSceneY(),
                        MenuAction.GAME_OBJECT_FIRST_OPTION,
                        veinToClick.getId(),
                        -1,
                        "Mine",
                        "<col=ffff>Ore vein</col>"
                );
                log.debug("Switched to ore vein: {}", veinToClick.getId());
            });
        }, delay, TimeUnit.MILLISECONDS);
    }

    // ── Handle deposit phase — click deposit box ──────────────────────────
    private void handleDeposit()
    {
        GameObject depositBox = findGameObject(DEPOSIT_BOX_ID);
        if (depositBox == null)
        {
            log.debug("Deposit box not found");
            depositActive = false;
            return;
        }

        int delay = 100 + random.nextInt(300);
        GameObject boxToClick = depositBox;

        scheduler.schedule(() ->
        {
            clientThread.invokeLater(() ->
            {
                client.menuAction(
                        boxToClick.getSceneMinLocation().getX(),
                        boxToClick.getSceneMinLocation().getY(),
                        MenuAction.GAME_OBJECT_FIRST_OPTION,
                        boxToClick.getId(),
                        -1,
                        "Deposit",
                        "<col=ffff>Bank deposit box</col>"
                );
                log.debug("Clicked deposit box");
            });
        }, delay, TimeUnit.MILLISECONDS);
    }

    // ── Deposit inventory and close interface ─────────────────────────────
    private void scheduleDepositAndClose()
    {
        int delay = 100 + random.nextInt(300);

        scheduler.schedule(() ->
        {
            clientThread.invokeLater(() ->
            {
                client.menuAction(
                        -1,
                        DEPOSIT_INV_WIDGET_ID,
                        MenuAction.CC_OP,
                        1,
                        -1,
                        "Deposit inventory",
                        ""
                );
                log.debug("Clicked deposit inventory button");

                int closeDelay = 300 + random.nextInt(200);
                scheduler.schedule(() ->
                {
                    clientThread.invokeLater(() ->
                    {
                        client.runScript(168);
                        log.debug("Closed deposit box interface");
                        depositActive = false;
                    });
                }, closeDelay, TimeUnit.MILLISECONDS);
            });
        }, delay, TimeUnit.MILLISECONDS);
    }

    // ── Find a game object by ID in the scene ─────────────────────────────
    private GameObject findGameObject(int id)
    {
        Tile[][][] tiles = client.getScene().getTiles();
        int plane = client.getPlane();

        for (int x = 0; x < tiles[plane].length; x++)
        {
            for (int y = 0; y < tiles[plane][x].length; y++)
            {
                Tile tile = tiles[plane][x][y];
                if (tile == null)
                {
                    continue;
                }

                for (GameObject obj : tile.getGameObjects())
                {
                    if (obj != null && obj.getId() == id)
                    {
                        return obj;
                    }
                }
            }
        }
        return null;
    }

    // ── Count used inventory slots ────────────────────────────────────────
    private int countUsedSlots(ItemContainer inventory)
    {
        int count = 0;
        for (int i = 0; i < inventory.size(); i++)
        {
            if (inventory.getItem(i) != null)
            {
                count++;
            }
        }
        return count;
    }
}