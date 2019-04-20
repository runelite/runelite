package net.runelite.client.plugins.pvptools;

import javax.inject.*;

import com.google.inject.Inject;
import net.runelite.client.plugins.*;
import net.runelite.client.plugins.clanchat.*;
import java.util.function.*;
import java.awt.event.*;
import java.util.stream.*;
import java.util.concurrent.*;
import net.runelite.client.config.*;
import com.google.inject.*;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.input.*;
import net.runelite.client.ui.*;
import java.awt.image.*;
import net.runelite.client.eventbus.*;
import org.apache.commons.lang3.*;
import net.runelite.api.events.*;
import net.runelite.client.util.*;
import net.runelite.api.*;
import net.runelite.client.game.*;
import java.util.*;

@PluginDescriptor(
        name = "PvP Tools",
        description = "Enable the PvP Tools panel",
        tags = { "panel", "pvp", "pk", "pklite" },
        type="PVP"
)
public class PvpToolsPlugin extends Plugin
{
    @Inject
    PvpToolsOverlay pvpToolsOverlay;
    boolean fallinHelperEnabled;
    private PvpToolsPanel panel;
    private MissingPlayersJFrame missingPlayersJFrame;
    private CurrentPlayersJFrame currentPlayersJFrame;
    private NavigationButton navButton;
    private boolean attackHotKeyPressed;
    private boolean hideAll;
    @Inject
    private ScheduledExecutorService executorService;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private Client client;
    @Inject
    private ItemManager itemManager;
    private PvpToolsPlugin uhPvpToolsPlugin;
    final ActionListener playersButtonActionListener;
    final ActionListener currentPlayersActionListener;
    @Inject
    private ClientToolbar clientToolbar;
    @Inject
    private KeyManager keyManager;
    @Inject
    private PvpToolsConfig config;
    @Inject
    private PluginManager pluginManager;
    @Inject
    private ClanManager clanManager;
    private ClanChatPlugin clanChatPlugin;
    private final HotkeyListener hotkeyListener;
    private final HotkeyListener attackOptionsHotKeyListener;
    private int[] overheadCount;
    private Comparator<Item> itemPriceComparator;
    private String mtarget;

    public PvpToolsPlugin() {
        this.fallinHelperEnabled = false;
        this.uhPvpToolsPlugin = this;
        this.playersButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (PvpToolsPlugin.this.missingPlayersJFrame != null) {
                    PvpToolsPlugin.this.missingPlayersJFrame.dispose();
                    PvpToolsPlugin.this.missingPlayersJFrame = null;
                    PvpToolsPlugin.this.missingPlayersJFrame = new MissingPlayersJFrame(PvpToolsPlugin.this.client, PvpToolsPlugin.this.uhPvpToolsPlugin, PvpToolsPlugin.this.getMissingMembers());
                }
                else {
                    PvpToolsPlugin.this.missingPlayersJFrame = new MissingPlayersJFrame(PvpToolsPlugin.this.client, PvpToolsPlugin.this.uhPvpToolsPlugin, PvpToolsPlugin.this.getMissingMembers());
                }
            }
        };
        this.currentPlayersActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (PvpToolsPlugin.this.currentPlayersJFrame != null) {
                    PvpToolsPlugin.this.currentPlayersJFrame.dispose();
                    PvpToolsPlugin.this.currentPlayersJFrame = null;
                    PvpToolsPlugin.this.currentPlayersJFrame = new CurrentPlayersJFrame(PvpToolsPlugin.this.client, PvpToolsPlugin.this.uhPvpToolsPlugin, PvpToolsPlugin.this.getCurrentMembers());
                }
                else {
                    PvpToolsPlugin.this.currentPlayersJFrame = new CurrentPlayersJFrame(PvpToolsPlugin.this.client, PvpToolsPlugin.this.uhPvpToolsPlugin, PvpToolsPlugin.this.getCurrentMembers());
                }
            }
        };
        this.hotkeyListener = new HotkeyListener(() -> this.config.hotkey()) {
            @Override
            public void hotkeyPressed() {
                PvpToolsPlugin.this.toggleFallinHelper();
            }
        };
        this.attackOptionsHotKeyListener = new HotkeyListener(() -> this.config.attackOptionsHotkey()) {
            long lastPress = 0L;

            @Override
            public void keyPressed(final KeyEvent e) {
                PvpToolsPlugin.this.attackHotKeyPressed = true;
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                PvpToolsPlugin.this.attackHotKeyPressed = (System.currentTimeMillis() - this.lastPress < 800L);
                this.lastPress = System.currentTimeMillis();
            }
        };
        this.overheadCount = new int[] { 0, 0, 0 };
        this.itemPriceComparator = new Comparator<Item>() {
            @Override
            public int compare(final Item o1, final Item o2) {
                return PvpToolsPlugin.this.itemManager.getItemPrice(PvpToolsPlugin.this.itemManager.getItemComposition(o1.getId()).getPrice()) - PvpToolsPlugin.this.itemManager.getItemPrice(PvpToolsPlugin.this.itemManager.getItemComposition(o2.getId()).getPrice());
            }
        };
    }

    public List getMissingMembers() {
        CopyOnWriteArrayList<Player> ccMembers = ClanChatPlugin.getClanMembers();
        ArrayList<String> missingMembers = new ArrayList<String>();
        for (ClanMember clanMember : this.client.getClanMembers()) {
            List arrayList;
            if (Objects.isNull(clanMember) || (arrayList = ccMembers.stream().map(player -> Text.removeTags(Text.standardize(player.getName()))).collect(Collectors.toList())).contains(Text.removeTags(Text.standardize(clanMember.getUsername()))) || missingMembers.contains(clanMember.getUsername())) continue;
            missingMembers.add("[W" + clanMember.getWorld() + "] - " + clanMember.getUsername());
        }
        return missingMembers;
    }

    public List getCurrentMembers() {
        CopyOnWriteArrayList<Player> ccMembers = ClanChatPlugin.getClanMembers();
        ArrayList<String> currentMembers = new ArrayList<String>();
        for (ClanMember clanMember : this.client.getClanMembers()) {
            List arrayList;
            if (Objects.isNull(clanMember) || !(arrayList = ccMembers.stream().map(player -> Text.removeTags(Text.standardize(player.getName()))).collect(Collectors.toList())).contains(Text.removeTags(Text.standardize(clanMember.getUsername()))) || currentMembers.contains(clanMember.getUsername())) continue;
            currentMembers.add(clanMember.getUsername());
        }
        return currentMembers;
    }

    @Provides
    PvpToolsConfig config(final ConfigManager configManager) {
        return configManager.getConfig(PvpToolsConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        this.overlayManager.add(this.pvpToolsOverlay);
        this.keyManager.registerKeyListener(this.hotkeyListener);
        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(this.getClass(), "skull.png");
        (this.panel = new PvpToolsPanel()).init();
        this.navButton = NavigationButton.builder().tooltip("PvP Tools").icon(icon).priority(5).panel(this.panel).build();
        this.panel.missingPlayers.addActionListener(this.playersButtonActionListener);
        this.panel.currentPlayers.addActionListener(this.currentPlayersActionListener);
        this.clientToolbar.addNavigation(this.navButton);
        this.keyManager.registerKeyListener(this.attackOptionsHotKeyListener);
        if (this.config.missingPlayersEnabled()) {
            this.panel.missingPlayers.setVisible(true);
        }
        if (this.config.currentPlayersEnabled()) {
            this.panel.currentPlayers.setVisible(true);
        }
    }

    @Override
    protected void shutDown() throws Exception {
        this.overlayManager.remove(this.pvpToolsOverlay);
        this.keyManager.unregisterKeyListener(this.hotkeyListener);
        this.keyManager.unregisterKeyListener(this.attackOptionsHotKeyListener);
        this.clientToolbar.removeNavigation(this.navButton);
    }

    @Subscribe
    public void onConfigChanged(final ConfigChanged configChanged) {
        if (configChanged.getGroup().equals("pvptools")) {
            final String key = configChanged.getKey();
            switch (key) {
                case "countPlayers": {
                    if (this.config.countPlayers()) {
                        this.updatePlayers();
                    }
                    if (!this.config.countPlayers()) {
                        this.panel.disablePlayerCount();
                        break;
                    }
                    break;
                }
                case "countOverHeads": {
                    if (this.config.countOverHeads()) {
                        this.countOverHeads();
                    }
                    if (!this.config.countOverHeads()) {
                        this.panel.disablePrayerCount();
                        break;
                    }
                    break;
                }
                case "riskCalculator": {
                    if (this.config.riskCalculatorEnabled()) {
                        this.getCarriedWealth();
                    }
                    if (!this.config.riskCalculatorEnabled()) {
                        this.panel.disableRiskCalculator();
                        break;
                    }
                    break;
                }
                case "missingPlayers": {
                    if (this.config.missingPlayersEnabled()) {
                        this.panel.missingPlayers.setVisible(true);
                        break;
                    }
                    break;
                }
                case "currentPlayers": {
                    if (this.config.currentPlayersEnabled()) {
                        this.panel.currentPlayers.setVisible(true);
                        break;
                    }
                    break;
                }
            }
        }
    }

    @Subscribe
    public void onItemContainerChanged(final ItemContainerChanged event) {
        if (event.getItemContainer().equals(this.client.getItemContainer(InventoryID.INVENTORY)) && this.config.riskCalculatorEnabled()) {
            this.getCarriedWealth();
        }
    }

    @Subscribe
    public void onGameStateChanged(final GameStateChanged event) {
        if (event.getGameState().equals(GameState.LOGGED_IN) && this.config.riskCalculatorEnabled()) {
            this.getCarriedWealth();
        }
        if (event.getGameState().equals(GameState.LOGGED_IN) && this.config.countPlayers()) {
            this.updatePlayers();
        }
    }

    @Subscribe
    public void onPlayerSpawned(final PlayerSpawned event) {
        if (this.config.countPlayers() && PvPUtil.isAttackable(this.client, event.getPlayer())) {
            this.updatePlayers();
        }
        if (this.config.countOverHeads()) {
            this.countOverHeads();
        }
    }

    @Subscribe
    public void onPlayerDespawned(final PlayerDespawned event) {
        if (this.config.countPlayers() && PvPUtil.isAttackable(this.client, event.getPlayer())) {
            this.updatePlayers();
        }
        if (this.config.countOverHeads()) {
            this.countOverHeads();
        }
    }

    @Subscribe
    public void onMenuEntryAdded(final MenuEntryAdded menuEntryAdded) {
        if (!this.attackHotKeyPressed && (this.config.attackOptionsFriend() || this.config.attackOptionsClan() || this.config.levelRangeAttackOptions())) {
            if (this.client.getGameState() != GameState.LOGGED_IN) {
                return;
            }
            final Player[] players = this.client.getCachedPlayers();
            Player player = null;
            final int identifier = menuEntryAdded.getIdentifier();
            if (identifier >= 0 && identifier < players.length) {
                player = players[identifier];
            }
            if (player == null) {
                return;
            }
            final String option = Text.removeTags(menuEntryAdded.getOption()).toLowerCase();
            final String mtarget = Text.removeTags(menuEntryAdded.getTarget()).toLowerCase();
            if ((this.attackHotKeyPressed && this.config.attackOptionsClan()) || this.config.attackOptionsFriend() || this.config.levelRangeAttackOptions()) {
                if (this.config.attackOptionsFriend() && player.isFriend()) {
                    this.moveEntry(mtarget);
                }
                if (this.config.attackOptionsClan() && player.isClanMember()) {
                    this.moveEntry(mtarget);
                }
                if (this.config.levelRangeAttackOptions() && !PvPUtil.isAttackable(this.client, player)) {
                    this.moveEntry(mtarget);
                }
            }
        }
    }

    private void moveEntry(final String mtarget) {
        this.mtarget = mtarget;
        MenuEntry[] menuEntries = this.client.getMenuEntries();
        final MenuEntry lastEntry = menuEntries[menuEntries.length - 1];
        String target = lastEntry.getTarget();
        final int idx = target.indexOf(62);
        if (idx != -1) {
            target = target.substring(idx + 1);
        }
        if (menuEntries[menuEntries.length - 1] != null) {}
        if (lastEntry.getOption().contains("attack".toLowerCase())) {
            menuEntries = ArrayUtils.remove(menuEntries, menuEntries.length - 1);
        }
        if (lastEntry.getOption().equals("Attack")) {
            menuEntries = ArrayUtils.remove(menuEntries, menuEntries.length - 1);
        }
        this.client.setMenuEntries(menuEntries);
    }

    @Subscribe
    public void onFocusChanged(final FocusChanged focusChanged) {
        if (!focusChanged.isFocused()) {
            this.setAttackHotKeyPressed(false);
        }
    }

    private void toggleFallinHelper() {
        if (!this.fallinHelperEnabled) {
            this.client.setIsHidingEntities(true);
            this.client.setPlayersHidden(true);
            this.fallinHelperEnabled = true;
        }
        else {
            this.client.setIsHidingEntities(false);
            this.client.setPlayersHidden(false);
            this.fallinHelperEnabled = false;
        }
    }

    private void updatePrayerNumbers() {
        this.panel.numMageJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Mage: ", String.valueOf(this.overheadCount[0])));
        this.panel.numRangeJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Range: ", String.valueOf(this.overheadCount[1])));
        this.panel.numMeleeJLabel.setText(PvpToolsPanel.htmlLabel("Enemies Praying Melee: ", String.valueOf(this.overheadCount[2])));
        this.panel.numMageJLabel.repaint();
        this.panel.numRangeJLabel.repaint();
        this.panel.numMeleeJLabel.repaint();
    }

    private void updatePlayers() {
        if (this.config.countPlayers()) {
            int cc = 0;
            int other = 0;
            for (final Player p : this.client.getPlayers()) {
                if (Objects.nonNull(p) && PvPUtil.isAttackable(this.client, p)) {
                    if (p.isClanMember()) {
                        ++cc;
                    }
                    else {
                        ++other;
                    }
                }
            }
            this.panel.numOther.setText(PvpToolsPanel.htmlLabel("Other Player Count: ", String.valueOf(other)));
            this.panel.numCC.setText(PvpToolsPanel.htmlLabel("Friendly Player Count: ", String.valueOf(cc)));
            this.panel.numCC.repaint();
            this.panel.numOther.repaint();
        }
    }

    private void countOverHeads() {
        this.overheadCount = new int[] { 0, 0, 0 };
        for (final Player p : this.client.getPlayers()) {
            if (Objects.nonNull(p) && PvPUtil.isAttackable(this.client, p) && !p.isClanMember() && p.getOverheadIcon() != null) {
                switch (p.getOverheadIcon()) {
                    case MAGIC: {
                        final int[] overheadCount = this.overheadCount;
                        final int n = 0;
                        ++overheadCount[n];
                        continue;
                    }
                    case RANGED: {
                        final int[] overheadCount2 = this.overheadCount;
                        final int n2 = 1;
                        ++overheadCount2[n2];
                        continue;
                    }
                    case MELEE: {
                        final int[] overheadCount3 = this.overheadCount;
                        final int n3 = 2;
                        ++overheadCount3[n3];
                        continue;
                    }
                }
            }
        }
        this.updatePrayerNumbers();
    }

    private void getCarriedWealth() {
        if (!this.config.riskCalculatorEnabled()) {
            return;
        }
        if (this.client.getItemContainer(InventoryID.EQUIPMENT) == null) {
            return;
        }
        if (this.client.getItemContainer(InventoryID.INVENTORY).getItems() == null) {
            return;
        }
        final Item[] items = ArrayUtils.addAll(Objects.requireNonNull(this.client.getItemContainer(InventoryID.EQUIPMENT)).getItems(), Objects.requireNonNull(this.client.getItemContainer(InventoryID.INVENTORY)).getItems());
        final TreeMap<Integer, Item> priceMap = new TreeMap<Integer, Item>(Comparator.comparingInt(Integer::intValue));
        int wealth = 0;
        for (final Item i : items) {
            int value = this.itemManager.getItemPrice(i.getId()) * i.getQuantity();
            final ItemComposition itemComposition = this.itemManager.getItemComposition(i.getId());
            if (!itemComposition.isTradeable() && value == 0) {
                value = itemComposition.getPrice() * i.getQuantity();
                priceMap.put(value, i);
            }
            else {
                value = this.itemManager.getItemPrice(i.getId()) * i.getQuantity();
                if (i.getId() > 0 && value > 0) {
                    priceMap.put(value, i);
                }
            }
            wealth += value;
        }
        this.panel.totalRiskLabel.setText(PvpToolsPanel.htmlLabel("Total risk: ", StackFormatter.quantityToRSDecimalStack(wealth)));
        this.panel.totalRiskLabel.repaint();
        int itemLimit = 0;
        if (this.client.getLocalPlayer().getSkullIcon() != null && this.client.getLocalPlayer().getSkullIcon() == SkullIcon.SKULL) {
            itemLimit = 1;
        }
        if (this.client.getLocalPlayer().getSkullIcon() == null) {
            itemLimit = 4;
        }
        AsyncBufferedImage itemImage = null;
        final NavigableMap<Integer, Item> descendingMap = priceMap.descendingMap();
        for (int j = 0; j < itemLimit; ++j) {
            if (j == 0) {
                if (!descendingMap.isEmpty()) {
                    itemImage = this.itemManager.getImage(descendingMap.pollFirstEntry().getValue().getId());
                }
            }
            else if (!descendingMap.isEmpty()) {
                this.itemManager.getItemComposition(priceMap.descendingMap().pollFirstEntry().getValue().getId()).getName();
            }
        }
        this.panel.riskProtectingItem.setText(PvpToolsPanel.htmlLabel("Risk Protecting Item: ", StackFormatter.quantityToRSDecimalStack(descendingMap.keySet().stream().mapToInt(Integer::intValue).sum())));
        this.panel.riskProtectingItem.repaint();
        this.panel.biggestItemLabel.setText("Most Valuable Item: ");
        if (itemImage != null) {
            itemImage.addTo(this.panel.biggestItemLabel);
        }
        this.panel.biggestItemLabel.repaint();
    }

    boolean isAttackHotKeyPressed() {
        return this.attackHotKeyPressed;
    }

    void setAttackHotKeyPressed(final boolean attackHotKeyPressed) {
        this.attackHotKeyPressed = attackHotKeyPressed;
    }

    boolean isHideAll() {
        return this.hideAll;
    }

    void setHideAll(final boolean hideAll) {
        this.hideAll = hideAll;
    }
}
