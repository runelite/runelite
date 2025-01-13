/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.runenergy;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.RING_OF_ENDURANCE;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RunEnergyPluginTest
{
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
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	Client client;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(configManager.getRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", Integer.class)).thenReturn(1);
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
	public void testCheck1000()
	{
		String checkMessage = "Your Ring of endurance is charged with 1,000 stamina doses.";
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", checkMessage, "", 0);

		runEnergyPlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", 1000);
	}

	@Test
	public void testPotionMessage()
	{
		String potionMessage = "Your Ring of endurance doubles the duration of your stamina potion's effect.";
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", potionMessage, "", 0);

		runEnergyPlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", 0);
	}

	@Test
	public void testUncharge()
	{
		when(client.getIntStack()).thenReturn(new int[]{1, RING_OF_ENDURANCE});
		when(client.getIntStackSize()).thenReturn(1);
		when(client.getTickCount()).thenReturn(1);

		Widget enduranceWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.DESTROY_ITEM_NAME)).thenReturn(enduranceWidget);
		when(enduranceWidget.getText()).thenReturn("Ring of endurance");

		ScriptCallbackEvent scriptCallbackEvent = new ScriptCallbackEvent();
		scriptCallbackEvent.setEventName("destroyOnOpKey");
		runEnergyPlugin.onScriptCallbackEvent(scriptCallbackEvent);

		verify(configManager).setRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", 0);
	}

	@Test
	public void testEstimatedRuntimeRemaining()
	{
		ItemContainer equipment = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipment);
		when(equipment.count(RING_OF_ENDURANCE)).thenReturn(1);
		when(client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE)).thenReturn(1);
		when(client.getEnergy()).thenReturn(10000);
		when(client.getBoostedSkillLevel(Skill.AGILITY)).thenReturn(99);
		assertEquals("500s", runEnergyPlugin.getEstimatedRunTimeRemaining(true));

		when(client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE)).thenReturn(0);
		when(configManager.getRSProfileConfiguration(RunEnergyConfig.GROUP_NAME, "ringOfEnduranceCharges", Integer.class)).thenReturn(512);
		assertEquals("2:57", runEnergyPlugin.getEstimatedRunTimeRemaining(false));
	}
}