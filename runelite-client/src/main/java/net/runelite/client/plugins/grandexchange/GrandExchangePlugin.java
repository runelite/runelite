/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, Robbie <https://github.com/rbbi>
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2020, Dennis <me@dennis.dev>
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

package net.runelite.client.plugins.grandexchange;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Shorts;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.GrandExchangeSearched;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.Notifier;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.OSType;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.ge.GrandExchangeTrade;
import net.runelite.http.api.item.ItemStats;
import net.runelite.http.api.worlds.WorldType;
import org.apache.commons.lang3.time.DurationFormatUtils;

@PluginDescriptor(
	name = "Grand Exchange",
	description = "Provide additional and/or easier access to Grand Exchange information",
	tags = {"external", "integration", "notifications", "panel", "prices", "trade"}
)
@Slf4j
public class GrandExchangePlugin extends Plugin
{
	@VisibleForTesting
	static final int GE_SLOTS = 8;
	private static final int GE_LOGIN_BURST_WINDOW = 2; // ticks
	private static final int GE_MAX_EXAMINE_LEN = 100;

	private static final String BUY_LIMIT_GE_TEXT = "Buy limit: ";
	private static final String BUY_LIMIT_KEY = "buylimit";
	private static final Duration BUY_LIMIT_RESET = Duration.ofHours(4);

	static final String SEARCH_GRAND_EXCHANGE = "Search Grand Exchange";

	private static final int MAX_RESULT_COUNT = 250;

	private static final Color FUZZY_HIGHLIGHT_COLOR = new Color(0x800000);

	private static final int MAX_TRADE_HISTORY = 1024;
	private static final int MAX_TRADE_DAYS = 365;

	private NavigationButton button;

	@Setter(AccessLevel.PACKAGE)
	private GrandExchangePanel panel;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Inject
	private GrandExchangeInputListener inputListener;

	@Inject
	private ItemManager itemManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private GrandExchangeConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Gson gson;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ScheduledExecutorService scheduledExecutorService;

	@Inject
	private FuzzySearchScorer fuzzySearchScorer;

	@Inject
	private GrandExchangeClient grandExchangeClient;
	private int lastLoginTick;

	private boolean wasFuzzySearch;

	private String machineUuid;
	private long lastAccount;
	private int tradeSeq;

	private SavedOffer getOffer(int slot)
	{
		String offer = configManager.getRSProfileConfiguration("geoffer", Integer.toString(slot));
		if (offer == null)
		{
			return null;
		}
		return gson.fromJson(offer, SavedOffer.class);
	}

	private void setOffer(int slot, SavedOffer offer)
	{
		configManager.setRSProfileConfiguration("geoffer", Integer.toString(slot), gson.toJson(offer));
	}

	private void deleteOffer(int slot)
	{
		configManager.unsetRSProfileConfiguration("geoffer", Integer.toString(slot));
	}

	private synchronized void saveTrade(Trade trade)
	{
		List<Trade> trades = new ArrayList<>();
		String history = configManager.getRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP, "tradeHistory");
		//CHECKSTYLE:OFF
		final Type type = new TypeToken<List<Trade>>() {}.getType();
		//CHECKSTYLE:ON
		if (history != null)
		{
			try
			{
				List<Trade> t = gson.fromJson(history, type);
				if (t != null)
				{
					trades = t;
				}
			}
			catch (JsonSyntaxException ex)
			{
				log.warn("error updating saved trades", ex);
			}
		}

		Instant ago = Instant.now().minus(MAX_TRADE_DAYS, ChronoUnit.DAYS);
		while (!trades.isEmpty() && (trades.size() >= MAX_TRADE_HISTORY || trades.get(0).time.isBefore(ago)))
		{
			trades.remove(0);
		}

		trades.add(trade);
		configManager.setRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP, "tradeHistory", gson.toJson(trades, type));
	}

	@Provides
	GrandExchangeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GrandExchangeConfig.class);
	}

	@Override
	protected void startUp()
	{
		panel = injector.getInstance(GrandExchangePanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "ge_icon.png");

		button = NavigationButton.builder()
			.tooltip("Grand Exchange")
			.icon(icon)
			.priority(3)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(button);

		if (config.quickLookup())
		{
			mouseManager.registerMouseListener(inputListener);
			keyManager.registerKeyListener(inputListener);
		}

		AccountSession accountSession = sessionManager.getAccountSession();
		if (accountSession != null)
		{
			grandExchangeClient.setUuid(accountSession.getUuid());
		}
		else
		{
			grandExchangeClient.setUuid(null);
		}

		lastLoginTick = -1;

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			final GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
			for (int i = 0; i < offers.length; i++)
			{
				final int slot = i;
				clientThread.invokeLater(() -> updatePanel(slot, offers[slot]));

				updateConfig(i, offers[i]);
			}
		}
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(button);
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
		machineUuid = null;
		lastAccount = -1L;
		tradeSeq = 0;
	}

	void search(final String itemName)
	{
		SwingUtilities.invokeLater(() ->
		{
			panel.showSearch();
			clientToolbar.openPanel(button);
			panel.getSearchPanel().priceLookup(itemName);
		});
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession accountSession = sessionManager.getAccountSession();
		grandExchangeClient.setUuid(accountSession.getUuid());
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		grandExchangeClient.setUuid(null);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(GrandExchangeConfig.CONFIG_GROUP))
		{
			if (event.getKey().equals("quickLookup"))
			{
				if (config.quickLookup())
				{
					mouseManager.registerMouseListener(inputListener);
					keyManager.registerKeyListener(inputListener);
				}
				else
				{
					mouseManager.unregisterMouseListener(inputListener);
					keyManager.unregisterKeyListener(inputListener);
				}
			}
		}
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerEvent)
	{
		final int slot = offerEvent.getSlot();
		final GrandExchangeOffer offer = offerEvent.getOffer();

		if (offer.getState() == GrandExchangeOfferState.EMPTY && client.getGameState() != GameState.LOGGED_IN)
		{
			// Trades are cleared by the client during LOGIN_SCREEN/HOPPING/LOGGING_IN, ignore those so we don't
			// clear the offer config.
			return;
		}

		log.debug("GE offer updated: state: {}, slot: {}, item: {}, qty: {}, lastLoginTick: {}",
			offer.getState(), slot, offer.getItemId(), offer.getQuantitySold(), lastLoginTick);

		updatePanel(slot, offer);

		updateLimitTimer(offer);

		submitTrade(slot, offer);

		updateConfig(slot, offer);
	}

	@VisibleForTesting
	void submitTrade(int slot, GrandExchangeOffer offer)
	{
		GrandExchangeOfferState state = offer.getState();

		if (state != GrandExchangeOfferState.CANCELLED_BUY && state != GrandExchangeOfferState.CANCELLED_SELL && state != GrandExchangeOfferState.BUYING && state != GrandExchangeOfferState.SELLING)
		{
			return;
		}

		SavedOffer savedOffer = getOffer(slot);
		boolean login = client.getTickCount() <= lastLoginTick + GE_LOGIN_BURST_WINDOW;
		if (savedOffer == null && (state == GrandExchangeOfferState.BUYING || state == GrandExchangeOfferState.SELLING) && offer.getQuantitySold() == 0)
		{
			// new offer
			GrandExchangeTrade grandExchangeTrade = new GrandExchangeTrade();
			grandExchangeTrade.setBuy(state == GrandExchangeOfferState.BUYING);
			grandExchangeTrade.setItemId(offer.getItemId());
			grandExchangeTrade.setTotal(offer.getTotalQuantity());
			grandExchangeTrade.setOffer(offer.getPrice());
			grandExchangeTrade.setSlot(slot);
			grandExchangeTrade.setWorldType(getGeWorldType());
			grandExchangeTrade.setLogin(login);
			grandExchangeTrade.setSeq(tradeSeq++);
			grandExchangeTrade.setResetTime(getLimitResetTime(offer.getItemId()));

			log.debug("Submitting new trade: {}", grandExchangeTrade);
			grandExchangeClient.submit(grandExchangeTrade);
			return;
		}

		if (savedOffer == null || savedOffer.getItemId() != offer.getItemId() || savedOffer.getPrice() != offer.getPrice() || savedOffer.getTotalQuantity() != offer.getTotalQuantity())
		{
			// desync
			return;
		}

		if (savedOffer.getState() == offer.getState() && savedOffer.getQuantitySold() == offer.getQuantitySold())
		{
			// no change
			return;
		}

		if (state == GrandExchangeOfferState.CANCELLED_BUY || state == GrandExchangeOfferState.CANCELLED_SELL)
		{
			GrandExchangeTrade grandExchangeTrade = new GrandExchangeTrade();
			grandExchangeTrade.setBuy(state == GrandExchangeOfferState.CANCELLED_BUY);
			grandExchangeTrade.setCancel(true);
			grandExchangeTrade.setItemId(offer.getItemId());
			grandExchangeTrade.setQty(offer.getQuantitySold());
			grandExchangeTrade.setTotal(offer.getTotalQuantity());
			grandExchangeTrade.setSpent(offer.getSpent());
			grandExchangeTrade.setOffer(offer.getPrice());
			grandExchangeTrade.setSlot(slot);
			grandExchangeTrade.setWorldType(getGeWorldType());
			grandExchangeTrade.setLogin(login);
			grandExchangeTrade.setSeq(tradeSeq++);
			grandExchangeTrade.setResetTime(getLimitResetTime(offer.getItemId()));

			log.debug("Submitting cancelled: {}", grandExchangeTrade);
			grandExchangeClient.submit(grandExchangeTrade);
			saveTrade(grandExchangeTrade);
			return;
		}

		final int qty = offer.getQuantitySold() - savedOffer.getQuantitySold();
		final int dspent = offer.getSpent() - savedOffer.getSpent();
		if (qty <= 0 || dspent <= 0)
		{
			return;
		}

		GrandExchangeTrade grandExchangeTrade = new GrandExchangeTrade();
		grandExchangeTrade.setBuy(state == GrandExchangeOfferState.BUYING);
		grandExchangeTrade.setItemId(offer.getItemId());
		grandExchangeTrade.setQty(offer.getQuantitySold());
		grandExchangeTrade.setDqty(qty);
		grandExchangeTrade.setTotal(offer.getTotalQuantity());
		grandExchangeTrade.setDspent(dspent);
		grandExchangeTrade.setSpent(offer.getSpent());
		grandExchangeTrade.setOffer(offer.getPrice());
		grandExchangeTrade.setSlot(slot);
		grandExchangeTrade.setWorldType(getGeWorldType());
		grandExchangeTrade.setLogin(login);
		grandExchangeTrade.setSeq(tradeSeq++);
		grandExchangeTrade.setResetTime(getLimitResetTime(offer.getItemId()));

		log.debug("Submitting trade: {}", grandExchangeTrade);
		grandExchangeClient.submit(grandExchangeTrade);
		saveTrade(grandExchangeTrade);
	}

	private void saveTrade(GrandExchangeTrade trade)
	{
		// Completed trades are either fully completed (qty == total) or partially complete
		// (qty > 0) and cancelled.
		if (trade.getQty() > 0 && (trade.isCancel() || trade.getQty() == trade.getTotal()))
		{
			Trade t = new Trade();
			t.setBuy(trade.isBuy());
			t.setItemId(trade.getItemId());
			t.setQuantity(trade.getQty());
			t.setPrice(trade.getSpent() / trade.getQty());
			t.setTime(Instant.now());

			log.debug("Saving trade: {}", t);
			scheduledExecutorService.execute(() -> saveTrade(t));
		}
	}

	private WorldType getGeWorldType()
	{
		EnumSet<net.runelite.api.WorldType> worldTypes = client.getWorldType();
		if (worldTypes.contains(net.runelite.api.WorldType.SEASONAL))
		{
			return WorldType.SEASONAL;
		}
		else if (worldTypes.contains(net.runelite.api.WorldType.TOURNAMENT_WORLD))
		{
			return WorldType.TOURNAMENT;
		}
		else if (worldTypes.contains(net.runelite.api.WorldType.DEADMAN))
		{
			return WorldType.DEADMAN;
		}
		else if (worldTypes.contains(net.runelite.api.WorldType.FRESH_START_WORLD))
		{
			return WorldType.FRESH_START_WORLD;
		}
		else if (worldTypes.contains(net.runelite.api.WorldType.BETA_WORLD))
		{
			return WorldType.BETA_WORLD;
		}
		else
		{
			return null;
		}
	}

	private void updatePanel(int slot, GrandExchangeOffer offer)
	{
		ItemComposition offerItem = itemManager.getItemComposition(offer.getItemId());
		boolean shouldStack = offerItem.isStackable() || offer.getTotalQuantity() > 1;
		BufferedImage itemImage = itemManager.getImage(offer.getItemId(), offer.getTotalQuantity(), shouldStack);
		SwingUtilities.invokeLater(() -> panel.getOffersPanel().updateOffer(offerItem, itemImage, offer, slot));
	}

	private void updateConfig(int slot, GrandExchangeOffer offer)
	{
		if (offer.getState() == GrandExchangeOfferState.EMPTY)
		{
			deleteOffer(slot);
		}
		else
		{
			SavedOffer savedOffer = new SavedOffer();
			savedOffer.setItemId(offer.getItemId());
			savedOffer.setQuantitySold(offer.getQuantitySold());
			savedOffer.setTotalQuantity(offer.getTotalQuantity());
			savedOffer.setPrice(offer.getPrice());
			savedOffer.setSpent(offer.getSpent());
			savedOffer.setState(offer.getState());
			setOffer(slot, savedOffer);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String message = Text.removeTags(event.getMessage());

		if (message.startsWith("Grand Exchange: Finished"))
		{
			notifier.notify(config.notifyOnOfferComplete(), message);
		}
		else if (message.startsWith("Grand Exchange:"))
		{
			notifier.notify(config.enableNotifications(), message);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			case LOGIN_SCREEN:
				panel.getOffersPanel().resetOffers();
				break;
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
				lastLoginTick = client.getTickCount();
				break;
			case LOGGED_IN:
				grandExchangeClient.setMachineId(getMachineUuid());
				break;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		// At the moment, if the user disables quick lookup, the input listener gets disabled. Thus, isHotKeyPressed()
		// should always return false when quick lookup is disabled.
		// Replace the default option with "Search ..." when holding alt
		if (client.getGameState() != GameState.LOGGED_IN || !hotKeyPressed)
		{
			return;
		}

		final MenuEntry[] entries = client.getMenuEntries();
		final MenuEntry menuEntry = entries[entries.length - 1];
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetUtil.componentToInterface(widgetId);

		switch (groupId)
		{
			case InterfaceID.BANK:
				// Don't show for view tabs and such
				if (widgetId != ComponentID.BANK_ITEM_CONTAINER)
				{
					break;
				}
			case InterfaceID.INVENTORY:
			case InterfaceID.BANK_INVENTORY:
			case InterfaceID.GRAND_EXCHANGE_INVENTORY:
			case InterfaceID.SHOP_INVENTORY:
				menuEntry.setOption(SEARCH_GRAND_EXCHANGE);
				menuEntry.setType(MenuAction.RUNELITE);
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.GE_ITEM_SEARCH && config.highlightSearchMatch())
		{
			highlightSearchMatches();
		}
	}

	private void highlightSearchMatches()
	{
		if (!wasFuzzySearch)
		{
			return;
		}
		String input = client.getVarcStrValue(VarClientStr.INPUT_TEXT).toLowerCase();

		String underlineTag = "<u=" + ColorUtil.colorToHexCode(FUZZY_HIGHLIGHT_COLOR) + ">";

		Widget results = client.getWidget(ComponentID.CHATBOX_GE_SEARCH_RESULTS);
		Widget[] children = results.getDynamicChildren();
		int resultCount = children.length / 3;

		for (int i = 0; i < resultCount; i++)
		{
			Widget itemNameWidget = children[i * 3 + 1];
			String itemName = itemNameWidget.getText(); // preserve case in underlined string
			String itemNameLower = itemName.toLowerCase(); // but match case-insensitive

			int sharedPrefixLen = 0;
			int maxLen = Math.min(input.length(), itemName.length());
			while (sharedPrefixLen < maxLen && input.charAt(sharedPrefixLen) == itemNameLower.charAt(sharedPrefixLen))
			{
				sharedPrefixLen++;
			}

			if (sharedPrefixLen > 0)
			{
				StringBuilder newItemName = new StringBuilder(itemName);
				newItemName.insert(sharedPrefixLen, "</u>");
				newItemName.insert(0, underlineTag);
				itemNameWidget.setText(newItemName.toString());
			}
		}
	}

	@Subscribe(
		// run after the bank tags plugin, and potentially anything
		// else which wants to consume the event and override
		// the search behavior
		priority = -100
	)
	public void onGrandExchangeSearched(GrandExchangeSearched event)
	{
		wasFuzzySearch = false;

		GrandExchangeSearchMode searchMode = config.geSearchMode();
		final String input = client.getVarcStrValue(VarClientStr.INPUT_TEXT);
		if (searchMode == GrandExchangeSearchMode.DEFAULT || input.isEmpty() || event.isConsumed())
		{
			return;
		}

		event.consume();

		client.setGeSearchResultIndex(0);

		int resultCount = 0;
		if (searchMode == GrandExchangeSearchMode.FUZZY_FALLBACK)
		{
			List<Integer> ids = IntStream.range(0, client.getItemCount())
					.mapToObj(itemManager::getItemComposition)
					.filter(item -> item.isTradeable() && item.getNote() == -1
						&& item.getName().toLowerCase().contains(input))
					.limit(MAX_RESULT_COUNT + 1)
					.sorted(Comparator.comparing(ItemComposition::getName))
					.map(ItemComposition::getId)
					.collect(Collectors.toList());
			if (ids.size() > MAX_RESULT_COUNT)
			{
				client.setGeSearchResultCount(-1);
				client.setGeSearchResultIds(null);
			}
			else
			{
				resultCount = ids.size();
				client.setGeSearchResultCount(resultCount);
				client.setGeSearchResultIds(Shorts.toArray(ids));
			}
		}

		if (resultCount == 0)
		{
			ToDoubleFunction<ItemComposition> comparator = fuzzySearchScorer.comparator(input);
			List<Integer> ids = IntStream.range(0, client.getItemCount())
					.mapToObj(itemManager::getItemComposition)
					.filter(item -> item.isTradeable() && item.getNote() == -1)
					.filter(item -> comparator.applyAsDouble(item) > 0)
					.sorted(Comparator.comparingDouble(comparator).reversed()
						.thenComparing(ItemComposition::getName))
					.limit(MAX_RESULT_COUNT)
					.map(ItemComposition::getId)
					.collect(Collectors.toList());

			client.setGeSearchResultCount(ids.size());
			client.setGeSearchResultIds(Shorts.toArray(ids));

			wasFuzzySearch = true;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		switch (event.getEventName())
		{
			case "setGETitle":
				setGeTitle();
				break;
			case "geBuyExamineText":
			case "geSellExamineText":
			{
				boolean buy = "geBuyExamineText".equals(event.getEventName());
				String[] stack = client.getStringStack();
				int sz = client.getStringStackSize();
				String fee = stack[sz - 2];
				String examine = stack[sz - 3];
				String text = setExamineText(examine, fee, buy);
				if (text != null)
				{
					stack[sz - 1] = text;
				}
				break;
			}
		}
	}

	private void setGeTitle()
	{
		if (!config.showTotal())
		{
			return;
		}

		long total = 0;
		GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
		for (GrandExchangeOffer offer : offers)
		{
			if (offer != null)
			{
				total += offer.getPrice() * offer.getTotalQuantity();
			}
		}

		if (total == 0L)
		{
			return;
		}

		StringBuilder titleBuilder = new StringBuilder(" (");

		if (config.showExact())
		{
			titleBuilder.append(QuantityFormatter.formatNumber(total));
		}
		else
		{
			titleBuilder.append(QuantityFormatter.quantityToStackSize(total));
		}

		titleBuilder.append(')');

		// Append to title
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		stringStack[stringStackSize - 1] += titleBuilder.toString();
	}

	private void setLimitResetTime(int itemId)
	{
		Instant lastDateTime = configManager.getRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP,
			BUY_LIMIT_KEY + "." + itemId, Instant.class);
		if (lastDateTime == null || lastDateTime.isBefore(Instant.now()))
		{
			configManager.setRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP, BUY_LIMIT_KEY + "." + itemId,
				Instant.now().plus(BUY_LIMIT_RESET));
		}
	}

	private Instant getLimitResetTime(int itemId)
	{
		Instant lastDateTime = configManager.getRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP,
			BUY_LIMIT_KEY + "." + itemId, Instant.class);
		if (lastDateTime == null)
		{
			return null;
		}

		if (lastDateTime.isBefore(Instant.now()))
		{
			configManager.unsetRSProfileConfiguration(GrandExchangeConfig.CONFIG_GROUP, BUY_LIMIT_KEY + "." + itemId);
			return null;
		}

		return lastDateTime;
	}

	private void updateLimitTimer(GrandExchangeOffer offer)
	{
		if (offer.getState() == GrandExchangeOfferState.BOUGHT ||
			(offer.getQuantitySold() > 0 &&
				offer.getState() == GrandExchangeOfferState.BUYING))
		{
			setLimitResetTime(offer.getItemId());
		}
	}

	private String setExamineText(String examine, String fee, boolean buy)
	{
		final int itemId = client.getVarpValue(VarPlayer.CURRENT_GE_ITEM);
		StringBuilder sb = new StringBuilder();

		if (buy && config.enableGELimits())
		{
			final ItemStats itemStats = itemManager.getItemStats(itemId, false);

			// If we have item buy limit, append it
			if (itemStats != null && itemStats.getGeLimit() > 0)
			{
				sb.append(BUY_LIMIT_GE_TEXT).append(QuantityFormatter.formatNumber(itemStats.getGeLimit()));
			}
		}

		if (buy && config.enableGELimitReset())
		{
			Instant resetTime = getLimitResetTime(itemId);
			if (resetTime != null)
			{
				Duration remaining = Duration.between(Instant.now(), resetTime);
				sb.append(" (").append(DurationFormatUtils.formatDuration(remaining.toMillis(), "H:mm")).append(')');
			}
		}

		if (config.showActivelyTradedPrice() && !client.getWorldType().contains(net.runelite.api.WorldType.DEADMAN))
		{
			final int price = itemManager.getItemPriceWithSource(itemId, true);
			if (price > 0)
			{
				if (sb.length() > 0)
				{
					sb.append(" / ");
				}
				sb.append("Actively traded price: ").append(QuantityFormatter.formatNumber(price));
			}
		}

		if (sb.length() == 0)
		{
			return null;
		}

		if (!fee.isEmpty())
		{
			sb.append("<br>").append(fee);
		}

		// Sell offers include an additional fee text which doesn't fit, so we truncate the examine text
		return (!buy ? shortenExamine(examine) : examine) + "<br>" + sb;
	}

	private static String shortenExamine(String examine)
	{
		int from = 0;
		int idx;
		while (true)
		{
			idx = examine.indexOf(' ', from);
			if (idx == -1)
			{
				return examine;
			}
			if (idx > GE_MAX_EXAMINE_LEN && from > 0)
			{
				break; // use from
			}
			from = idx + 1;
		}

		return examine.substring(0, from - 1) + "...";
	}

	void openGeLink(String name, int itemId)
	{
		final String url = runeLiteConfig.useWikiItemPrices() ?
			"https://prices.runescape.wiki/" + (client.getWorldType().contains(net.runelite.api.WorldType.FRESH_START_WORLD) ? "fsw" : "osrs") + "/item/" + itemId :
			"https://services.runescape.com/m=itemdb_oldschool/"
				+ name.replace(" ", "+")
				+ "/viewitem?obj="
				+ itemId;
		LinkBrowser.browse(url);
	}

	private String getMachineUuid()
	{
		long accountHash = client.getAccountHash();
		if (lastAccount == accountHash)
		{
			return machineUuid;
		}

		lastAccount = accountHash;

		try
		{
			Hasher hasher = Hashing.sha256().newHasher();
			Runtime runtime = Runtime.getRuntime();

			hasher.putByte((byte) OSType.getOSType().ordinal());
			hasher.putByte((byte) runtime.availableProcessors());
			hasher.putUnencodedChars(System.getProperty("os.arch", ""));
			hasher.putUnencodedChars(System.getProperty("os.version", ""));
			hasher.putUnencodedChars(System.getProperty("user.name", ""));

			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements())
			{
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				byte[] hardwareAddress = networkInterface.getHardwareAddress();
				if (hardwareAddress != null)
				{
					hasher.putBytes(hardwareAddress);
				}
			}
			hasher.putLong(accountHash);
			machineUuid = hasher.hash().toString();
			tradeSeq = 0;
			return machineUuid;
		}
		catch (SocketException ex)
		{
			log.debug("unable to generate machine id", ex);
			machineUuid = null;
			tradeSeq = 0;
			return null;
		}
	}
}
