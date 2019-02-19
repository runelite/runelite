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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
public class KourendLibraryPlugin extends Plugin
{
	private static final Pattern BOOK_EXTRACTOR = Pattern.compile("'<col=0000ff>(.*)</col>'");
	private static final Pattern TAG_MATCHER = Pattern.compile("(<[^>]*>)");

	public final static int REGION = 6459;
	public final static boolean debug = false;

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
	private LibraryHintArrow hintArrow;

	private KourendLibraryPanel panel;
	private NavigationButton navButton;
	private boolean buttonAttached = false;
	private WorldPoint lastBookcaseClick = null;
	private WorldPoint lastBookcaseAnimatedOn = null;
	private int lastPlayerPlane = -1;

	@Provides
	KourendLibraryConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KourendLibraryConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
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

		if (!config.hideButton())
		{
			clientToolbar.addNavigation(navButton);
		}
	}

	@Override
	protected void shutDown()
	{
		overlay.setHidden(true);
		overlayManager.remove(overlay);
		clientToolbar.removeNavigation(navButton);
		buttonAttached = false;
		lastBookcaseClick = null;
		lastBookcaseAnimatedOn = null;
		lastPlayerPlane = -1;
		hintArrow.clear();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged ev)
	{
		if (!KourendLibraryConfig.GROUP_KEY.equals(ev.getGroup()))
		{
			return;
		}

		hintArrow.update();

		updateToolbar();
	}

	private void updateToolbar()
	{
		SwingUtilities.invokeLater(() ->
		{
			if (!config.hideButton())
			{
				clientToolbar.addNavigation(navButton);
			}
			else
			{
				Player player = client.getLocalPlayer();

				boolean inRegion = player != null && player.getWorldLocation().getRegionID() == REGION;

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

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOpt)
	{
		if (MenuAction.GAME_OBJECT_FIRST_OPTION != menuOpt.getMenuAction())
		{
			return;
		}

		if (!menuOpt.getMenuTarget().contains("Bookshelf"))
		{
			return;
		}

		lastBookcaseClick = WorldPoint.fromScene(client, menuOpt.getActionParam(), menuOpt.getWidgetId(), client.getPlane());
		overlay.setHidden(false);
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged anim)
	{
		if (anim.getActor() != client.getLocalPlayer())
		{
			return;
		}

		if (anim.getActor().getAnimation() != AnimationID.LOOKING_INTO)
		{
			return;
		}

		lastBookcaseAnimatedOn = lastBookcaseClick;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (lastBookcaseAnimatedOn == null)
		{
			return;
		}

		if (event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (!event.getMessage().equals("You don't find anything useful here."))
		{
			return;
		}

		library.mark(lastBookcaseAnimatedOn, null);
		panel.update();
		lastBookcaseAnimatedOn = null;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		boolean inRegion = client.getLocalPlayer().getWorldLocation().getRegionID() == REGION;

		updateToolbarNavigation(inRegion);

		if (!inRegion)
		{
			return;
		}

		updateBookcase();
		updateCustomer();
		updatePlayerPlane();
	}

	private void updateToolbarNavigation(boolean inRegion)
	{
		if (!config.hideButton())
		{
			return;
		}

		if (inRegion == buttonAttached)
		{
			return;
		}

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

	private void updateBookcase()
	{
		if (lastBookcaseAnimatedOn == null)
		{
			return;
		}

		Widget find = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);

		if (find == null)
		{
			return;
		}

		Book book = Book.byId(find.getItemId());

		if (book == null)
		{
			return;
		}

		library.mark(lastBookcaseAnimatedOn, book);
		panel.update();
		lastBookcaseAnimatedOn = null;
	}

	private void updateCustomer()
	{
		Widget npcHead = client.getWidget(WidgetInfo.DIALOG_NPC_HEAD_MODEL);

		if (npcHead == null)
		{
			return;
		}

		LibraryCustomer libraryCustomer = LibraryCustomer.getById(npcHead.getModelId());

		if (libraryCustomer == null)
		{
			return;
		}

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
			library.setCustomer(libraryCustomer, book);
			panel.update();
			hintArrow.update();
		}
		else if (text.contains("You can have this other book") || text.contains("please accept a token of my thanks.") || text.contains("Thanks, I'll get on with reading it."))
		{
			library.setCustomer(null, null);
			panel.update();
			hintArrow.clear();
		}
	}

	private void updatePlayerPlane()
	{
		int playerPlane = client.getLocalPlayer().getWorldLocation().getPlane();

		if (lastPlayerPlane != -1 && lastPlayerPlane != playerPlane)
		{
			hintArrow.update();
		}

		lastPlayerPlane = playerPlane;
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		hintArrow.update();
	}
}