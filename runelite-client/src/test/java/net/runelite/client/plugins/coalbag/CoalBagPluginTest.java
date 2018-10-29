/*
 * Copyright (c) 2018, Anthony <cvballa3g0@gmail.com>
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
package net.runelite.client.plugins.coalbag;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.runelite.client.plugins.coalbag.CoalBagPlugin.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoalBagPluginTest
{

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private QueryRunner queryRunner;

	@Bind
	private CoalBagConfig config = new CoalBagConfig()
	{
		int amount = 0;

		@Override
		public void amount(int amount)
		{
			this.amount = amount;
		}

		@Override
		public int amount()
		{
			return amount;
		}
	};

	@Inject
	private CoalBagPlugin plugin;

	@Before
	public void before()
	{
		config.amount(0);
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void checkBagUpdateOnChatMessage()
	{

		class Case
		{
			private String msg;
			private int amount;

			private Case(String msg, int amount)
			{
				this.msg = msg;
				this.amount = amount;
			}
		}

		Case[] cases = new Case[]{
				new Case("Hey Dwight", 0),
				new Case("The coal bag contains 12 pieces of coal.", 12),
				new Case("The coal bag contains 11 pieces of coal.", 11),
				new Case("The coal bag contains 11 pieces of coal.", 11),
				new Case("The coal bag contains 12 pieces of coal.............", 11),
				new Case("The coal bag contains 12 pieces of coal", 11),
				new Case("The coal bag is empty.", 0),
				new Case("The coal bag is empty.", 0),
				new Case("The coal bag contains 44 pieces of coal.", 27),
				new Case("The coal bag contains one piece of coal.", 1),
				new Case("The coal bag contains 16 pieces of coal.", 16),
				new Case("The coal bag contains one piece of coal.", 1),
				new Case("The coal bag is empty.", 0),
		};

		for (int i = 0; i < cases.length; i++)
		{
			Case tc = cases[i];
			plugin.onChatMessage(msg(tc.msg));
			assertEquals("failed test case: " + i, tc.amount, plugin.getAmount());
		}
	}

	@Test
	public void checkAmountOnMenuClick()
	{
		class Case
		{
			private String option;
			private int itemCount;
			private int expected;

			private Case(String option, int itemCount, int expected)
			{
				this.option = option;
				this.itemCount = itemCount;
				this.expected = expected;
			}
		}

		config.amount(7); // start with 7
		Case[] cases = new Case[]{
				new Case(FILL_OPTION, 3, 10),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 27, 0),
				new Case(FILL_OPTION, 27, 27),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 10, 17),
				new Case(FILL_OPTION, 27, 27),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 0, 27),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 5, 22),
				new Case(FILL_OPTION, 0, 22),
				new Case(FILL_OPTION, 3, 25),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 24, 1),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 24, 0),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 24, 0),
		};

		for (int i = 0; i < cases.length; i++)
		{
			Case tc = cases[i];
			when(queryRunner.runQuery(any())).thenReturn(wi(tc.itemCount));
			plugin.onMenuOptionClicked(opt(tc.option));
			assertEquals("failed test case: " + i, tc.expected, plugin.getAmount());
		}
	}

	@Test
	public void checkMenuAndChatAmounts()
	{
		class Case
		{
			private String type;
			private String option;
			private String msg;
			private int itemCount;
			private int expected;

			private Case(String msg, int expected)
			{
				type = "msg";
				this.msg = msg;
				this.expected = expected;
			}

			public Case(String option, int itemCount, int expected)
			{
				type = "menu";
				this.option = option;
				this.itemCount = itemCount;
				this.expected = expected;
			}
		}

		Case[] cases = new Case[]{
				new Case("The coal bag is empty.", 0),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 27, 0),
				new Case(FILL_OPTION, 27, 27),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 10, 17),
				new Case(FILL_OPTION, 27, 27),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 5, 22),
				new Case("The coal bag contains 22 pieces of coal.", 22),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 5, 17),
				new Case("The coal bag contains 22 pieces of coal.", 22),
				new Case(EMPTY_OPTION, MAX_INVY_SPACE - 5, 17),
				new Case("The coal bag contains one piece of coal.", 1),
				new Case(FILL_OPTION, 12, 13),
		};

		for (int i = 0; i < cases.length; i++)
		{
			Case tc = cases[i];
			if (tc.type.equalsIgnoreCase("msg"))
			{
				plugin.onChatMessage(msg(tc.msg));
			}
			else
			{
				when(queryRunner.runQuery(any())).thenReturn(wi(tc.itemCount));
				plugin.onMenuOptionClicked(opt(tc.option));
			}

			assertEquals("failed test case: " + i, tc.expected, plugin.getAmount());
		}
	}

	private ChatMessage msg(String msg)
	{
		return new ChatMessage(ChatMessageType.SERVER, "", msg, "");
	}

	private MenuOptionClicked opt(String option)
	{
		MenuOptionClicked moc = new MenuOptionClicked();
		moc.setWidgetId(WidgetInfo.INVENTORY.getId());
		moc.setMenuOption(option);
		return moc;
	}

	private WidgetItem[] wi(int count)
	{
		return new WidgetItem[count];
	}
}