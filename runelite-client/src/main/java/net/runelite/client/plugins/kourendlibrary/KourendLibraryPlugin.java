/*
 * Copyright (c) 2018 Abex
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

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuOpcode;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Kourend Library",
	description = "Show where the books are found in the Kourend Library",
	tags = {"arceuus", "magic", "runecrafting", "overlay", "panel"}
)
@Slf4j
@Singleton
public class KourendLibraryPlugin extends Plugin
{
	private static final Pattern BOOK_EXTRACTOR = Pattern.compile("'<col=0000ff>(.*)</col>'");
	private static final Pattern TAG_MATCHER = Pattern.compile("(<[^>]*>)");
	final static int REGION = 6459;

	final static boolean debug = false;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private Library library;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KourendLibraryOverlay overlay;

	@Inject
	private KourendLibraryConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private EventBus eventBus;

	private KourendLibraryPanel panel;
	private NavigationButton navButton;
	private boolean buttonAttached = false;
	private WorldPoint lastBookcaseClick = null;
	private WorldPoint lastBookcaseAnimatedOn = null;
	private EnumSet<Book> playerBooks = null;

	private boolean hideButton;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideDuplicateBook;

	@Provides
	KourendLibraryConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KourendLibraryConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		hideButton = config.hideButton();
		hideDuplicateBook = config.hideDuplicateBook();

		Book.fillImages(itemManager);

		panel = injector.getInstance(KourendLibraryPanel.class);
		panel.init();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Kourend Library")
			.priority(6)
			.icon(icon)
			.panel(panel)
			.build();

		overlayManager.add(overlay);

		updatePlayerBooks();

		if (!this.hideButton)
		{
			clientToolbar.addNavigation(navButton);
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlay.setHidden(true);
		overlayManager.remove(overlay);
		clientToolbar.removeNavigation(navButton);
		buttonAttached = false;
		lastBookcaseClick = null;
		lastBookcaseAnimatedOn = null;
		playerBooks = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
	}

	private void onConfigChanged(ConfigChanged ev)
	{
		if (!KourendLibraryConfig.GROUP_KEY.equals(ev.getGroup()))
		{
			return;
		}

		this.hideButton = config.hideButton();
		this.hideDuplicateBook = config.hideDuplicateBook();

		SwingUtilities.invokeLater(() ->
		{
			if (!this.hideButton)
			{
				clientToolbar.addNavigation(navButton);
			}
			else
			{
				Player lp = client.getLocalPlayer();
				boolean inRegion = lp != null && lp.getWorldLocation().getRegionID() == REGION;
				if (inRegion)
				{
					clientToolbar.addNavigation(navButton);
				}
				else
				{
					clientToolbar.removeNavigation(navButton);
				}
			}
		});
	}

	private void onMenuOptionClicked(MenuOptionClicked menuOpt)
	{
		if (MenuOpcode.GAME_OBJECT_FIRST_OPTION == menuOpt.getMenuOpcode() && menuOpt.getTarget().contains("Bookshelf"))
		{
			lastBookcaseClick = WorldPoint.fromScene(client, menuOpt.getParam0(), menuOpt.getParam1(), client.getPlane());
			overlay.setHidden(false);
		}
	}

	private void onAnimationChanged(AnimationChanged anim)
	{
		if (anim.getActor() == client.getLocalPlayer() && anim.getActor().getAnimation() == AnimationID.LOOKING_INTO)
		{
			lastBookcaseAnimatedOn = lastBookcaseClick;
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (lastBookcaseAnimatedOn != null && event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (event.getMessage().equals("You don't find anything useful here."))
			{
				library.mark(lastBookcaseAnimatedOn, null);
				panel.update();
				lastBookcaseAnimatedOn = null;
			}
		}
	}

	private void onGameTick(GameTick tick)
	{
		boolean inRegion = client.getLocalPlayer().getWorldLocation().getRegionID() == REGION;
		if (this.hideButton && inRegion != buttonAttached)
		{
			SwingUtilities.invokeLater(() ->
			{
				if (inRegion)
				{
					clientToolbar.addNavigation(navButton);
				}
				else
				{
					clientToolbar.removeNavigation(navButton);
				}
			});
			buttonAttached = inRegion;
		}

		if (!inRegion)
		{
			return;
		}

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

					overlay.setHidden(false);
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

	private void onItemContainerChanged(ItemContainerChanged itemContainerChangedEvent)
	{
		updatePlayerBooks();
	}

	boolean doesPlayerContainBook(Book book)
	{
		return playerBooks.contains(book);
	}

	private void updatePlayerBooks()
	{
		ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer != null)
		{
			EnumSet<Book> books = EnumSet.noneOf(Book.class);

			for (Item item : itemContainer.getItems())
			{
				Book book = Book.byId(item.getId());

				if (book != null)
				{
					books.add(book);
				}
			}

			playerBooks = books;
		}
	}
}