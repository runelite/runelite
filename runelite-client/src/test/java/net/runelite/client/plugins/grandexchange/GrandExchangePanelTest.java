/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.runelite.client.plugins.grandexchange;

import net.runelite.api.Client;
import static net.runelite.api.GameState.LOGGED_IN;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.ItemComposition;
import net.runelite.client.RuneLite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import static org.mockito.Matchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GrandExchangePanelTest
{
	@Mock(answer = RETURNS_DEEP_STUBS)
	private RuneLite runeLite;

	@Mock
	private Client client;

	@Before
	public void before()
	{
		RuneLite.setRunelite(runeLite);
		RuneLite.setClient(client);
	}

	@Test
	public void testUpdateOffers()
	{
		GrandExchangeOffer[] offers = new GrandExchangeOffer[]
		{
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
			mock(GrandExchangeOffer.class),
		};

		when(client.getGrandExchangeOffers()).thenReturn(offers);
		when(client.getGameState()).thenReturn(LOGGED_IN);
		when(client.getItemDefinition(anyInt())).thenReturn(mock(ItemComposition.class));

		GrandExchangePanel grandExchangePanel = new GrandExchangePanel();
		grandExchangePanel.updateOffers();
	}

}
