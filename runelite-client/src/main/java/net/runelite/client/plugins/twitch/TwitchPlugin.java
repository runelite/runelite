package net.runelite.client.plugins.twitch;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.engio.mbassy.listener.Handler;
import net.runelite.api.ChatMessageType;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.ConfigChanged;
import static net.runelite.client.callback.Hooks.log;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.StringUtils;
import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent;
import org.kitteh.irc.client.library.feature.twitch.TwitchDelaySender;
import org.kitteh.irc.client.library.feature.twitch.TwitchListener;
import org.kitteh.irc.client.library.feature.twitch.event.RoomStateEvent;
import org.apache.commons.lang3.StringUtils.*;
import org.kitteh.irc.client.library.feature.twitch.event.UserNoticeEvent;
import org.kitteh.irc.client.library.feature.twitch.event.UserStateEvent;

@PluginDescriptor(
        name = "Twitch",
        enabledByDefault = false
)

public class TwitchPlugin extends Plugin
{
    @Inject
    private net.runelite.api.Client client;

    @Inject
    private TwitchConfig config;

    @Inject
    private ChatMessageManager chatMessageManager;

    private Client irc;

    private boolean subscribed;

    private boolean mod;

    private boolean broadcaster;

    private boolean subsOnly;

    private boolean emoteOnly;

    private String badges = "";

    @Provides
    TwitchConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TwitchConfig.class);
    }

    @Override
    protected void startUp()
    {
        try {
            twitchShutdown(irc);
        }
        catch (Exception e)
        {
            log.debug("No chat yet");
        }
        irc = twitchSetup(config.oauthToken(), config.channelName(), config.nickName());
    }

    @Override
    protected void shutDown()
    {
        try
        {
            twitchShutdown(irc);
        }
        catch (Exception e)
        {
            log.debug("No chat yet");
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (event.getGroup().equals("twitch"))
        {
            try {
                twitchShutdown(irc);
            }
            catch (Exception e)
            {
                log.debug("No chat yet");
            }
            irc = twitchSetup(config.oauthToken(), config.channelName(), config.nickName());
        }
    }

    public boolean isChatboxTransparent()
    {
        return client.isResized() && client.getVarbitValue(Varbits.TRANSPARENT_CHATBOX.getId()) == 1;
    }

    public Client twitchSetup(String o, String nick, String name)
    {

        Client ircClient = Client.builder()
                .serverHost("irc.chat.twitch.tv").serverPort(443)
                .serverPassword(o)
                .nick(nick)
                .messageSendingQueueSupplier(TwitchDelaySender.getSupplier(false))
                .build();
        TwitchListener listener = new TwitchListener(ircClient);
        ircClient.getEventManager().registerEventListener(listener);
        ircClient.getEventManager().registerEventListener(this);
        ircClient.connect();
        ircClient.addChannel("#" + name);
        return ircClient;
    }

    //Send messages to twitch chat using command "t"
    @Subscribe
    public void onCommand(CommandExecuted m) {
        String [] args = m.getArguments();
        String message = "";
        String command = m.getCommand();

        if (command.equalsIgnoreCase("t"))
        {

            for (String arg : args)
            {
                message = message + arg + " ";
            }

            irc.sendMessage("#" + config.nickName(), message);
            //Echos the message back in in-game chat
            if(irc.getChannels().toString().contains("#" + config.nickName()))
            {
                //If chatbox is transparent, chat is in subs only, user is a sub and they are logged in
                if (isChatboxTransparent() && client.getGameState().equals(GameState.LOGGED_IN ) && (subscribed && subsOnly)) {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + badges + config.channelName() + ": <col=" + Integer.toHexString(config.chatTColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
                }
                //Same as above except with opaque chat
                else if (client.getGameState().equals(GameState.LOGGED_IN ) && (subscribed && subsOnly))
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + badges + config.channelName() + ": <col=" + Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
                }
                //If the user is logged in, the chat is in subs only mode and they are not a subscriber
                else if (client.getGameState().equals(GameState.LOGGED_IN ) && (!subscribed && subsOnly))
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] Notification: <col=ff0000>This channel is in Subscriber only mode!</col>", "Twitch");
                }
                else if(client.getGameState().equals(GameState.LOGGED_IN ) && emoteOnly && (mod || broadcaster))
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + badges + config.channelName() + ": <col=" + Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
                }
                //If the chat is in emote only mode
                else if (client.getGameState().equals(GameState.LOGGED_IN ) && emoteOnly)
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] Notification: <col=ff0000>This channel is in emote only mode!<br><col=ff0000>Function coming soon to a Runelite client near you.</col>", "Twitch");
                }
                //If chat is transparent and there are no room states
                else if(client.getGameState().equals(GameState.LOGGED_IN) && isChatboxTransparent())
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + badges + config.channelName() + ": <col=" + Integer.toHexString(config.chatTColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
                }
                //If chat is opaque and there are no room states
                else if(client.getGameState().equals(GameState.LOGGED_IN))
                {
                    client.addChatMessage(ChatMessageType.TRADE, "",
                            "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + badges +  config.channelName() + ": <col=" + Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
                }
            }
        }
    }

    //Shut off current running irc client
    public void twitchShutdown(Client c) {
        irc.shutdown();
    }

    //Triggers when a message is sent to twitch chat
    @Handler
    public void onMessage(ChannelMessageEvent a) {
        String username = a.getActor().getUserString();

        //Sub length badges
        if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/0"))
        {
            username = "<img=9>" + username;
        }
        else if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/3"))
        {
            username = "<img=8>" + username;
        }
        else if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/6"))
        {
            username = "<img=7>" + username;
        }
        else if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/12"))
        {
            username = "<img=6>" + username;
        }
        else if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/24"))
        {
            username = "<img=5>" + username;
        }
        else if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("subscriber/48"))
        {
            username = "<img=4>" + username;
        }

        //Moderator badge
        if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("moderator/1"))
        {
            username = "<img=26>" + username;
        }

        //Streamer badge
        if (a.getOriginalMessages().get(0).getTag("badges").toString().contains("broadcaster/1"))
        {
            username = "<img=27>" + username;
        }

        //Send the message with color based on if the chat is transparent or not
        String message = a.getMessage();
        if (isChatboxTransparent() && client.getGameState().equals(GameState.LOGGED_IN)) {
            client.addChatMessage(ChatMessageType.TRADE, "",
                    "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + username + ": <col=" + Integer.toHexString(config.chatTColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
        }
        else if (client.getGameState().equals(GameState.LOGGED_IN))
        {
            client.addChatMessage(ChatMessageType.TRADE, "",
                    "<col=ffffff>[</col><col=9070ff>Twitch</col>] " + username + ": <col=" + Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF) + ">" + message + "</col>", "Twitch");
        }
    }

    //User and room information update events
    //Triggers whenever the user's state is updated or they join a room
    @Handler
    public void onUserStateEvent(UserStateEvent u)
    {
        String originalMessage = u.getOriginalMessage().toString();
        System.out.println(originalMessage);
        badges = "";

        //Finding if the user is a subscriber
        if((originalMessage.contains("subscriber=1") || originalMessage.contains("mod=1") || originalMessage.contains("value=broadcaster/1")) && StringUtils.containsIgnoreCase(originalMessage ,"display-name=" + config.channelName()))
        {
            subscribed = true;
            if (originalMessage.contains("subscriber=1"))
            {
                if (originalMessage.contains("subscriber/0"))
                {
                    badges = "<img=9>" + badges;
                }
                else if (originalMessage.contains("subscriber/3"))
                {
                    badges = "<img=8>" + badges;
                }
                else if (originalMessage.contains("subscriber/6"))
                {
                    badges = "<img=7>" + badges;
                }
                else if (originalMessage.contains("subscriber/12"))
                {
                    badges = "<img=6>" + badges;
                }
                else if (originalMessage.contains("subscriber/24"))
                {
                    badges = "<img=5>" + badges;
                }
                else if (originalMessage.contains("subscriber/48"))
                {
                    badges = "<img=4>" + badges;
                }
            }
        }
        else
        {
            subscribed = false;
        }

        //Finding if the user is a moderator or broadcaster which allows them to talk during emote-only
        if(originalMessage.contains("mod=1") && StringUtils.containsIgnoreCase(originalMessage ,"display-name=" + config.channelName()))
        {
            mod = true;
            badges = "<img=26>" + badges;
        }
        else
        {
            mod = false;
        }

        if(originalMessage.contains(("value=broadcaster/1")) && StringUtils.containsIgnoreCase(originalMessage ,"display-name=" + config.channelName()))
        {
            broadcaster = true;
            badges = "<img=27>" + badges;
        }
        else
        {
            broadcaster = false;
        }
    }

    //Triggers when the room state changes. I.E. Sub mode, slow mode, etc.
    @Handler
    public void onRoomStateEvent(RoomStateEvent r)
    {
        String originalMessage = r.getOriginalMessage().toString();
        System.out.println(originalMessage);
        //Checking if the subs-only state has changed
        if (originalMessage.contains("subs-only=1"))
        {
            subsOnly = true;
        }
        else
        {
            subsOnly = false;
        }

        //Checking if the emote-only state has changed
        if(originalMessage.contains("emote-only=1"))
        {
            emoteOnly = true;
        }
        else
        {
            emoteOnly = false;
        }
    }

    //Triggers when a user subscribes/re-subscribes
    @Handler
    public void onUserNoticeEvent(UserNoticeEvent u)
    {
        String originalMessage = u.getOriginalMessage().toString();
        String [] subMessage = originalMessage.split(";");
        String newSubMessage = subMessage[13].replace("\\s", " ").replace("system-msg=", "");

        if(newSubMessage.contains("msg-param-sub-plan-name="))
        {
            newSubMessage = subMessage[14].replace("\\s", " ").replace("system-msg=", "");
        }

        if(config.subNotifs() == true)
        {
            if(isChatboxTransparent() && client.getGameState().equals(GameState.LOGGED_IN))
            {
                client.addChatMessage(ChatMessageType.TRADE, "",
                        "<col=ffffff>[</col><col=9070ff>Twitch</col>] Notification: <col=" + Integer.toHexString(config.subsTColor().getRGB() & 0xFFFFFF) + "><b>" + newSubMessage + "</b></col>", "Twitch");
            }
            else if(client.getGameState().equals(GameState.LOGGED_IN))
            {
                client.addChatMessage(ChatMessageType.TRADE, "",
                        "<col=ffffff>[</col><col=9070ff>Twitch</col>] Notification: <col=" + Integer.toHexString(config.subsOColor().getRGB() & 0xFFFFFF) + ">" + newSubMessage + "</col>", "Twitch");
            }
        }
    }
}
