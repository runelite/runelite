
package net.runelite.client.plugins.cat;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@PluginDescriptor(
        name = "Cat Information"
)

@Slf4j
public class CatPlugin extends Plugin
{

    @Inject
    private Notifier notifier;

    private final String CAT_ATTENTION_MESSAGE_1 = "Your kitten wants attention.";
    private final String CAT_ATTENTION_MESSAGE_2 = "Your kitten really wants attention.";
    private final String CAT_HUNGRY_MESSAGE_1 = "Your kitten is hungry.";
    private final String CAT_HUNGRY_MESSAGE_2 = "Your kitten is very hungry.";
    private final String CAT_RAN_AWAY_MESSAGE = "Your kitten got lonely and ran off.";

    private String[] messages = {CAT_ATTENTION_MESSAGE_1, CAT_ATTENTION_MESSAGE_2, CAT_HUNGRY_MESSAGE_1, CAT_HUNGRY_MESSAGE_2, CAT_RAN_AWAY_MESSAGE};

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {

        if (event.getType() == ChatMessageType.SERVER)
        {
            String message = Text.removeTags(event.getMessage());
            List<String> m = Arrays.asList(messages);

            if (m.contains(message))
            {
                notifier.notify(message);
            }
        }
    }

}