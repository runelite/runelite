/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.examine;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.ItemManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExaminePluginTest
{
	@Inject
	ExaminePlugin examinePlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testGetItemPrice()
	{
		ItemComposition itemComposition = mock(ItemComposition.class);
		when(itemComposition.getMembersName()).thenReturn("Abyssal whip");
		when(itemComposition.getHaPrice()).thenReturn(2);
		when(itemManager.getItemPrice(ItemID.ABYSSAL_WHIP)).thenReturn(3);
		examinePlugin.getItemPrice(ItemID.ABYSSAL_WHIP, itemComposition, 2_000_000_000);

		ArgumentCaptor<QueuedMessage> argumentCaptor = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(argumentCaptor.capture());

		QueuedMessage queuedMessage = argumentCaptor.getValue();
		assertEquals(
			"<colNORMAL>Price of <colHIGHLIGHT>2,000,000,000 x Abyssal whip<colNORMAL>:<colNORMAL> GE average <colHIGHLIGHT>6,000,000,000<colNORMAL> (<colHIGHLIGHT>3<colNORMAL>ea)<colNORMAL> HA value <colHIGHLIGHT>4,000,000,000<colNORMAL> (<colHIGHLIGHT>2<colNORMAL>ea)",
			queuedMessage.getRuneLiteFormattedMessage()
		);
	}
}