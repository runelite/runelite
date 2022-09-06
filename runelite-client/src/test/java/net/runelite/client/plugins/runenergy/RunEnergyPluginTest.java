package net.runelite.client.plugins.runenergy;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class RunEnergyPluginTest {

    @Inject
    RunEnergyPlugin runEnergyPlugin;

    @Mock
    @Bind
    ConfigManager configManager;

    @Mock
    @Bind
    RunEnergyConfig runEnergyConfig;

    @Mock
    @Bind
    ChatColorConfig chatColorConfig;

    @Mock
    @Bind
    RuneLiteConfig runeLiteConfig;

    @Mock
    @Bind
    Client client;

    @Before
    public void before()
    {
        Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
    }

    @Test
    public void testChargeMessage()
    {
        String chargeMessage = "You load your Ring of endurance with 1 stamina dose.<br>It now has 669 charges.";
        ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", chargeMessage, "", 0);

        runEnergyPlugin.onChatMessage(chatMessage);
        verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", 669);
    }

    @Test
    public void testCheckMessage()
    {
        String checkMessage = "Your Ring of endurance is charged with 52 stamina doses.";
        ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", checkMessage, "", 0);

        runEnergyPlugin.onChatMessage(chatMessage);
        verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", 52);
    }

    @Test
    public void testPotionMessage()
    {
        String potionMessage = "Your Ring of endurance doubles the duration of your stamina potion's effect.";
        ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", potionMessage, "", 0);

        runEnergyPlugin.onChatMessage(chatMessage);
        verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", -1);
    }
}

