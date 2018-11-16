package net.runelite.client.plugins.bosslog;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;

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

    public Bosses[] bossTypes = {Bosses.ZULRAH};
    public List<Boss> bosses = new ArrayList<>();

    @Inject
    private Client client;

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
                logFile.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(logFile));
                bw.write("0");
                bw.close();
            }
            BufferedReader br = new BufferedReader(new FileReader(logFile));
            String st;
            int KC = parseInt(br.readLine());
            List<Item> itemList = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                int id = parseInt(st.substring(0, st.indexOf(' ')));
                int quantity = parseInt(st.substring(st.indexOf(' ')+1));
                itemList.add(new Item(id, quantity, "", 0));
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
            panel.update();
        }
    }

    @Subscribe
    public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
    {
        final NPC npc = npcLootReceived.getNpc();
        final Collection<ItemStack> items = npcLootReceived.getItems();
        final String name = npc.getName();
        final int combat = npc.getCombatLevel();
        for (ItemStack e : items)
        {
            final ItemComposition itemComposition = itemManager.getItemComposition(e.getId());
            System.out.println("elem = " + e.getId() + " " + itemComposition.getName());
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
        {
            return;
        }

        // Check if message is for a pet
        String msg = Text.removeTags(event.getMessage());
        System.out.println(msg);
    }
}
