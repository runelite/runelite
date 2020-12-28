package net.runelite.client.plugins.namechanger;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Name Changer",
        description = "I am the Mod now",
        tags = {"Name","willem","fun"},
        enabledByDefault = false
)
public class NameChangerPlugin extends Plugin
{
    static final String CONFIG_GROUP = "namechange";

    @Inject
    private Client client;

    @Inject
    private NameChangerConfig config;

    @Inject
    private ClientThread clientThread;

    @Provides
    NameChangerConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(NameChangerConfig.class);
    }

    @Override
    protected void startUp()
    {

    }

    @Override
    protected void shutDown()
    {
        clientThread.invokeLater(() -> client.runScript(ScriptID.CHAT_PROMPT_INIT));
    }

    @Subscribe
    private void onBeforeRender(BeforeRender event)
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        if (!config.nameChange().isEmpty())
        {
            updateChatbox();
        }
    }

    private void updateChatbox()
    {
        Widget chatboxTypedText = client.getWidget(WidgetInfo.CHATBOX_INPUT);
        if (chatboxTypedText == null || chatboxTypedText.isHidden())
        {
            return;
        }
        String[] chatbox = chatboxTypedText.getText().split(":", 2);

        chatbox[0] = config.icon().toString() + config.nameChange();

        chatboxTypedText.setText(chatbox[0] + ":" + chatbox[1]);
    }
}