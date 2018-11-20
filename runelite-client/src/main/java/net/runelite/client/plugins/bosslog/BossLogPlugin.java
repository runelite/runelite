package net.runelite.client.plugins.bosslog;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Integer.parseInt;

@PluginDescriptor(
        name = "Boss Log",
        description = "Tracks loot from bosses",
        tags = {"drops", "boss", "tracker", "log"},
        enabledByDefault = true //TODO false in final build
)
@Slf4j
public class BossLogPlugin extends Plugin {

    private BossLogPanel panel;
    private NavigationButton navButton;

    public Bosses[] bossTypes = {Bosses.ZULRAH, Bosses.BANDOS};
    public List<Boss> bosses = new ArrayList<>();

    @Inject
    private BossLogConfig config;

    @Provides
    BossLogConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(BossLogConfig.class);
    }

    @Inject
    private ItemManager itemManager;

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private SpriteManager spriteManager;

    @Override
    protected void startUp() throws Exception
    {
        //Load Persistant Data
        //create new file if non-existant
        for(Bosses b : bossTypes)
        {
            File logFile = new File(b.getName()+"_log.txt");
            if(!logFile.exists())
            {
                if(logFile.createNewFile())
                {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(logFile));
                    bw.write("0");
                    bw.newLine();
                    bw.close();
                }
            }
            BufferedReader br = new BufferedReader(new FileReader(logFile));
            String st;
            int KC = parseInt(br.readLine());
            List<Item> itemList = new ArrayList<>();
            while ((st = br.readLine()) != null)
            {
                if(!st.equals(""))
                {
                    int id = parseInt(st.substring(0, st.indexOf(' ')));
                    int quantity = parseInt(st.substring(st.indexOf(' ') + 1));
                    itemList.add(new Item(id, quantity, "", 0));
                }
            }
            br.close();
            bosses.add(new Boss(b, KC, itemList));
        }

        panel = new BossLogPanel(this, itemManager);
        spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, panel::loadHeaderIcon);

        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

        navButton = NavigationButton.builder()
                .tooltip("Boss Log")
                .icon(icon)
                .priority(8)
                .panel(panel)
                .build();

        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown()
    {
        clientToolbar.removeNavigation(navButton);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) throws Exception {
        if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN) {
            SwingUtilities.invokeLater(() -> panel.update());
        }
    }

    @Subscribe
    public void onNpcLootReceived(final NpcLootReceived npcLootReceived) throws IOException
    {
        final NPC npc = npcLootReceived.getNpc();
        final Collection<ItemStack> items = npcLootReceived.getItems();
        for(Boss b : bosses)
        {
            for(int id : b.getBoss().getIds())
            {
                if(id == npc.getId())
                {
                    for (ItemStack e : items)
                    {
                        final ItemComposition itemComposition = itemManager.getItemComposition(e.getId());
                        b.addItem(new Item(e.getId(), e.getQuantity(), itemComposition.getName(), itemManager.getItemPrice(e.getId())));
                    }
                    b.addKC();
                    save();
                    return;
                }
            }
        }
    }

    void save() throws IOException
    {
        SwingUtilities.invokeLater(() -> panel.update());
        for(Boss b : bosses)
        {
            File oldFile = new File(b.getBoss().getName()+"_log.txt");
            if(oldFile.delete()) {
                File logFile = new File(b.getBoss().getName()+"_log.txt");
                logFile.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(logFile));
                bw.write(b.getKC()+""); //Write KC to file
                bw.newLine();
                for(Item i : b.getDrops()) {
                    bw.write(i.getId() + " " + i.getQuantity());
                    bw.newLine();
                }
                bw.close();
            }
        }
    }

    @Subscribe
    public void onSessionOpen(SessionOpen event)
    {
        // update notes
        String data = config.getZulrahDrops();
        System.out.println("Data:" + data);
    }
}
