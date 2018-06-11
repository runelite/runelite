/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Franck Maillot <https://github.com/Franck-M>
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
package net.runelite.client.plugins.kourendlibrary;

import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.MenuAction;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Kourend Library"
)
@Slf4j
public class KourendLibraryPlugin extends Plugin
{
	final static WorldPoint LIBRARY_CENTER = new WorldPoint(1632, 3807, 1);
	final static int OVERLAY_MAXIMUM_DISTANCE = 24;
	final static int ROUGH_ENABLE_DISTANCE = 30;

	private static final Pattern BOOK_EXTRACTOR = Pattern.compile("'<col=0000ff>(.*)</col>'");
	private static final Pattern TAG_MATCHER = Pattern.compile("(<[^>]*>)");

	private KourendLibraryPanel panel;

	private NavigationButton navButton;

	private WorldPoint lastBookcaseClick = null;
	private WorldPoint lastBookcaseAnimatedOn = null;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private Client client;

	@Inject
	private Library library;

	@Inject
	private KourendLibraryConfig config;

	@Inject
	private KourendLibraryOverlay overlay;

	@Inject
	private KourendLibraryMinimapOverlay minimapOverlay;

	@Inject
	private ItemManager itemManager;

	@Provides
	KourendLibraryConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KourendLibraryConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		Book.fillImages(itemManager);

		panel = injector.getInstance(KourendLibraryPanel.class);
		panel.init();

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(Book.class.getResourceAsStream("panel_icon.png"));
		}

		navButton = NavigationButton.builder()
			.tooltip("Kourend Library")
			.priority(6)
			.icon(icon)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		pluginToolbar.removeNavigation(navButton);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, minimapOverlay);
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked menuOpt)
	{
		if (MenuAction.GAME_OBJECT_FIRST_OPTION == menuOpt.getMenuAction() && menuOpt.getMenuTarget().contains("Bookshelf"))
		{
			lastBookcaseClick = WorldPoint.fromRegion(client, menuOpt.getActionParam(), menuOpt.getWidgetId(), client.getPlane());
		}
	}

	@Subscribe
	private void onAnimationChanged(AnimationChanged anim)
	{
		if (anim.getActor() == client.getLocalPlayer() && anim.getActor().getAnimation() == AnimationID.LOOKING_INTO)
		{
			lastBookcaseAnimatedOn = lastBookcaseClick;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (lastBookcaseAnimatedOn != null && event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().equals("You don't find anything useful here."))
			{
				library.mark(lastBookcaseAnimatedOn, null);
				panel.update();
				lastBookcaseAnimatedOn = null;
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		// Check if item was removed from inventory
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			final Item[] items = Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems();
			for (Book b : Book.values())
			{
				if (!b.isDarkManuscript())
				{
					if (Arrays.stream(items).anyMatch(i -> i.getId() == b.getItem()))
					{
						b.setInInventory(true);
					}
					else
					{
						b.setInInventory(false);
					}
				}
			}
		}
	}

	@Subscribe
	void onTick(GameTick tick)
	{
		if (lastBookcaseAnimatedOn != null)
		{
			Widget find = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);
			if (find != null)
			{
				Book book = Book.byId(find.getItemId());
				if (book != null)
				{
					library.mark(lastBookcaseAnimatedOn, book);
					panel.update();
					lastBookcaseAnimatedOn = null;
				}
			}
		}

		Widget npcHead = client.getWidget(WidgetInfo.DIALOG_NPC_HEAD_MODEL);
		if (npcHead != null)
		{
			LibraryCustomer cust = LibraryCustomer.getById(npcHead.getModelId());
			if (cust != null)
			{
				Widget textw = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
				String text = textw.getText();
				Matcher m = BOOK_EXTRACTOR.matcher(text);
				if (m.find())
				{
					String bookName = TAG_MATCHER.matcher(m.group(1).replace("<br>", " ")).replaceAll("");
					Book book = Book.byName(bookName);
					if (book == null)
					{
						log.warn("Book '{}' is not recognised", bookName);
						return;
					}
					library.setCustomer(cust, book);
					panel.update();
				}
				else if (text.contains("You can have this other book") || text.contains("please accept a token of my thanks.") || text.contains("Thanks, I'll get on with reading it."))
				{
					library.setCustomer(null, null);
					panel.update();
				}
			}
		}
	}
}