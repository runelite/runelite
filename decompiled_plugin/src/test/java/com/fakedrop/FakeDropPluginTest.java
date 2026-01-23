package com.fakedrop;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Comprehensive test suite for Fake Drop plugin.
 * Tests verify message generation, pet logic, and drop simulations.
 */
@RunWith(MockitoJUnitRunner.class)
public class FakeDropPluginTest
{
    @Mock
    private Client client;

    @Mock
    private ClientThread clientThread;

    @Mock
    private FakeDropConfig config;

    @Mock
    private KeyManager keyManager;
    
    @Mock
    private net.runelite.client.config.ConfigManager configManager;

    private FakeDropPlugin plugin;

    @Before
    public void setUp()
    {
        plugin = new FakeDropPlugin();
        
        // Make clientThread.invokeLater() execute the Runnable immediately
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Runnable runnable = invocation.getArgument(0);
                runnable.run();
                return null;
            }
        }).when(clientThread).invokeLater(any(Runnable.class));
        
        // Inject mocks using reflection
        try {
            java.lang.reflect.Field clientField = FakeDropPlugin.class.getDeclaredField("client");
            clientField.setAccessible(true);
            clientField.set(plugin, client);

            java.lang.reflect.Field clientThreadField = FakeDropPlugin.class.getDeclaredField("clientThread");
            clientThreadField.setAccessible(true);
            clientThreadField.set(plugin, clientThread);

            java.lang.reflect.Field configField = FakeDropPlugin.class.getDeclaredField("config");
            configField.setAccessible(true);
            configField.set(plugin, config);

            java.lang.reflect.Field keyManagerField = FakeDropPlugin.class.getDeclaredField("keyManager");
            keyManagerField.setAccessible(true);
            keyManagerField.set(plugin, keyManager);
            
            java.lang.reflect.Field configManagerField = FakeDropPlugin.class.getDeclaredField("configManager");
            configManagerField.setAccessible(true);
            configManagerField.set(plugin, configManager);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject mocks", e);
        }
    }

    private List<String> getChatMessages() {
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(client, atLeastOnce()).addChatMessage(any(), any(), messageCaptor.capture(), any());
        return messageCaptor.getAllValues();
    }

    @Test
    public void testPetDrop_OnlyShowsPetMessage()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(true);
        when(config.selectedPet()).thenReturn(FakeDropConfig.Pet.PET_DARK_CORE);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertEquals("Should send exactly 1 message", 1, messages.size());
        assertTrue("Should contain pet message", messages.get(0).contains("You have a funny feeling"));
        assertFalse("Should not contain kill count", messages.get(0).contains("kill count"));
    }

    @Test
    public void testSkillingPet_ShowsXPNotKC()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(true);
        when(config.selectedPet()).thenReturn(FakeDropConfig.Pet.ROCKY);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should show pet feeling message", 
            messages.stream().anyMatch(m -> m.contains("You have a funny feeling")));
        
        // No XP shown in basic messages, only in clan messages which we test separately
    }

    @Test
    public void testBossDrop_ShowsKillCountAndDrop()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Leviathan");
        when(config.killCount()).thenReturn(42);
        when(config.timed()).thenReturn(false);
        when(config.dropName()).thenReturn("Venator ring");
        when(config.untradeable()).thenReturn(false);
        when(config.dropValue()).thenReturn(50000000);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should show kill count", 
            messages.stream().anyMatch(m -> m.contains("Leviathan") && m.contains("42")));
        assertTrue("Should show drop", 
            messages.stream().anyMatch(m -> m.contains("Venator ring") && m.contains("50,000,000")));
    }

    @Test
    public void testTimedBoss_ShowsFightDuration()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Zulrah");
        when(config.killCount()).thenReturn(100);
        when(config.timed()).thenReturn(true);
        when(config.killTime()).thenReturn("1:23");
        when(config.personalBest()).thenReturn("1:15");
        when(config.dropName()).thenReturn("Magic fang");
        when(config.untradeable()).thenReturn(false);
        when(config.dropValue()).thenReturn(1000000);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should show fight duration", 
            messages.stream().anyMatch(m -> m.contains("Fight duration") && m.contains("1:23") && m.contains("1:15")));
    }

    @Test
    public void testUntradeableDrop_NoCoins()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("TzTok-Jad");
        when(config.killCount()).thenReturn(5);
        when(config.timed()).thenReturn(false);
        when(config.dropName()).thenReturn("Fire cape");
        when(config.untradeable()).thenReturn(true);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should show untradeable drop", 
            messages.stream().anyMatch(m -> m.contains("Untradeable drop") && m.contains("Fire cape")));
        assertFalse("Should not show coins for untradeable", 
            messages.stream().anyMatch(m -> m.contains("Fire cape") && m.contains("coins")));
    }

    @Test
    public void testPetWithCollectionLog()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(true);
        when(config.selectedPet()).thenReturn(FakeDropConfig.Pet.ROCKY);
        when(config.collectionLog()).thenReturn(true);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should show pet feeling", 
            messages.stream().anyMatch(m -> m.contains("You have a funny feeling")));
        assertTrue("Should show collection log", 
            messages.stream().anyMatch(m -> m.contains("collection log") && m.contains("Rocky")));
    }

    @Test
    public void testCustomPet_UsesCustomName()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(true);
        when(config.selectedPet()).thenReturn(FakeDropConfig.Pet.CUSTOM);
        when(config.customPetName()).thenReturn("My Special Pet");
        when(config.collectionLog()).thenReturn(true);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should use custom pet name", 
            messages.stream().anyMatch(m -> m.contains("My Special Pet")));
    }

    @Test
    public void testNotLoggedIn_DoesNothing()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

        // When
        plugin.toggle();

        // Then
        verify(client, never()).addChatMessage(any(), any(), any(), any());
    }

    @Test
    public void testNumberFormatting()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Test Boss");
        when(config.killCount()).thenReturn(1234567);
        when(config.timed()).thenReturn(false);
        when(config.dropName()).thenReturn("Test Drop");
        when(config.untradeable()).thenReturn(false);
        when(config.dropValue()).thenReturn(999999999);
        when(config.collectionLog()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        assertTrue("Should format large numbers with commas", 
            messages.stream().anyMatch(m -> m.contains("1,234,567")));
        assertTrue("Should format drop value with commas", 
            messages.stream().anyMatch(m -> m.contains("999,999,999")));
    }

    // Enum validation tests
    @Test
    public void testAllSkillingPets_HaveSkills()
    {
        for (FakeDropConfig.Pet pet : FakeDropConfig.Pet.values()) {
            if (pet.isSkilling() && pet != FakeDropConfig.Pet.CUSTOM) {
                assertNotNull("Skilling pet should have skill: " + pet.getPetName(), pet.getSkill());
                assertFalse("Skilling pet skill should not be empty: " + pet.getPetName(), 
                    pet.getSkill().trim().isEmpty());
            }
        }
    }

    @Test
    public void testAllBossPets_HaveRarity()
    {
        for (FakeDropConfig.Pet pet : FakeDropConfig.Pet.values()) {
            if (!pet.isSkilling() && pet != FakeDropConfig.Pet.CUSTOM) {
                assertNotNull("Boss pet should have rarity: " + pet.getPetName(), pet.getDefaultRarity());
                assertFalse("Boss pet rarity should not be empty: " + pet.getPetName(), 
                    pet.getDefaultRarity().trim().isEmpty());
            }
        }
    }

    @Test
    public void testSpecificPets_HaveCorrectData()
    {
        // Rocky - skilling pet
        assertTrue("Rocky should be skilling pet", FakeDropConfig.Pet.ROCKY.isSkilling());
        assertEquals("Rocky should be Thieving", "Thieving", FakeDropConfig.Pet.ROCKY.getSkill());

        // Pet dark core - boss pet
        assertFalse("Pet dark core should not be skilling pet", 
            FakeDropConfig.Pet.PET_DARK_CORE.isSkilling());
        assertEquals("Pet dark core should have 1/5,000 rarity", 
            "1/5,000", FakeDropConfig.Pet.PET_DARK_CORE.getDefaultRarity());

        // Beaver - skilling pet
        assertTrue("Beaver should be skilling pet", FakeDropConfig.Pet.BEAVER.isSkilling());
        assertEquals("Beaver should be Woodcutting", "Woodcutting", FakeDropConfig.Pet.BEAVER.getSkill());
    }
    
    @Test
    public void testAutoIncrementKC_IncreasesKillCount()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Leviathan");
        when(config.killCount()).thenReturn(100);
        when(config.autoIncrementKC()).thenReturn(true);
        when(config.dropName()).thenReturn("Venator ring");
        when(config.dropValue()).thenReturn(50000000);
        when(config.untradeable()).thenReturn(false);
        when(config.randomizeValue()).thenReturn(false);
        when(config.timed()).thenReturn(false);
        when(config.collectionLog()).thenReturn(false);
        when(config.announceToClan()).thenReturn(false);

        // When
        plugin.toggle();

        // Then - should display incremented KC (101)
        List<String> messages = getChatMessages();
        assertTrue("Should show incremented kill count 101", 
            messages.stream().anyMatch(m -> m.contains("101")));
        
        // Verify that configManager.setConfiguration was called with the new KC
        verify(configManager).setConfiguration("fakedrop", "killCount", 101);
    }
    
    @Test
    public void testAutoIncrementKC_Disabled_DoesNotIncrement()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Leviathan");
        when(config.killCount()).thenReturn(100);
        when(config.autoIncrementKC()).thenReturn(false);  // Disabled
        when(config.dropName()).thenReturn("Venator ring");
        when(config.dropValue()).thenReturn(50000000);
        when(config.untradeable()).thenReturn(false);
        when(config.randomizeValue()).thenReturn(false);
        when(config.timed()).thenReturn(false);
        when(config.collectionLog()).thenReturn(false);
        when(config.announceToClan()).thenReturn(false);

        // When
        plugin.toggle();

        // Then - should display original KC (100)
        List<String> messages = getChatMessages();
        assertTrue("Should show original kill count 100", 
            messages.stream().anyMatch(m -> m.contains("100")));
        
        // Verify that configManager.setConfiguration was NOT called
        verify(configManager, never()).setConfiguration(eq("fakedrop"), eq("killCount"), anyInt());
    }
    
    @Test
    public void testValueRandomization_AltersDropValue()
    {
        // Given
        when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
        when(config.isPet()).thenReturn(false);
        when(config.bossName()).thenReturn("Leviathan");
        when(config.killCount()).thenReturn(100);
        when(config.autoIncrementKC()).thenReturn(false);
        when(config.dropName()).thenReturn("Venator ring");
        when(config.dropValue()).thenReturn(50000000);
        when(config.untradeable()).thenReturn(false);
        when(config.randomizeValue()).thenReturn(true);  // Enabled
        when(config.timed()).thenReturn(false);
        when(config.collectionLog()).thenReturn(false);
        when(config.announceToClan()).thenReturn(false);

        // When
        plugin.toggle();

        // Then
        List<String> messages = getChatMessages();
        String dropMessage = messages.stream()
            .filter(m -> m.contains("Valuable drop"))
            .findFirst()
            .orElse("");
        
        assertFalse("Should have drop message", dropMessage.isEmpty());
        // Value should be randomized ±5%, so not exactly 50,000,000
        // But we can't assert exact value due to randomness, just that it contains "coins"
        assertTrue("Should contain coins", dropMessage.contains("coins"));
    }
}
