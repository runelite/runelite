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
package net.runelite.client.plugins.cooking;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CookingPluginTest
{
	private static final String[] COOKING_MESSAGES = {
		"You successfully cook a shark.",
		"You successfully cook an anglerfish.",
		"You manage to cook a tuna.",
		"You cook the karambwan. It looks delicious.",
		"You roast a lobster.",
		"You cook a bass.",
		"You successfully bake a tasty garden pie."
	};

	@Inject
	CookingPlugin cookingPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	CookingConfig config;

	@Mock
	@Bind
	CookingOverlay cookingOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testOnChatMessage()
	{
		for (String message : COOKING_MESSAGES)
		{
			ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", message, "", 0);
			cookingPlugin.onChatMessage(chatMessage);
		}

		CookingSession cookingSession = cookingPlugin.getSession();
		assertNotNull(cookingSession);
		assertEquals(COOKING_MESSAGES.length, cookingSession.getCookAmount());
	}

	@Test
	public void testOnSpotAnimationChanged()
	{
		Player player = mock(Player.class);
		when(player.getSpotAnimation()).thenReturn(GraphicID.WINE_MAKE);

		cookingPlugin.setFermentTimer(true);

		when(client.getLocalPlayer()).thenReturn(player);

		SpotAnimationChanged graphicChanged = new SpotAnimationChanged();
		graphicChanged.setActor(player);
		cookingPlugin.onSpotAnimationChanged(graphicChanged);

		verify(infoBoxManager).addInfoBox(any(FermentTimer.class));
	}
}