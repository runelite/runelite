package net.runelite.client.plugins.bank;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.item.ItemPrice;

@PluginDescriptor(name = "Bank Value")
@Slf4j
public class BankPlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final int ITEM_EMPTY = 6512;
	private static final int ITEM_COINS = 617;

	@Inject
	Client client;
	@Inject
	BankConfig config;
	@Inject
	ItemManager itemManager;
	@Inject
	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	private String strCurrentTab;
	private String[] suffixes = {"", "K", "M", "B", "T", "Q", "W", "T", "F"};

	private ScheduledFuture futureCalculateBank;
	private Future taskWidget;
	private BankRunnable runCalculateBank = new BankRunnable();

	@Provides
	BankConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankConfig.class);
	}

	@Subscribe
	public void checkBankState(ConfigChanged event)
	{
		if (!config.isEnabled() || client.getWidget(WidgetInfo.BANK_ITEM_COUNT) == null) return;

		CancelTasks();

		taskWidget = executor.submit(() -> WaitForWidget(WidgetInfo.BANK_ITEM_COUNT, Double.MAX_VALUE));

		return;
	}

	@Subscribe
	public void onItemChanged(MenuOptionClicked event)
	{
		String strMenuOption = event.getMenuOption();

		if (strMenuOption.contains("Withdraw") || strMenuOption.contains("Deposit") || strMenuOption.contains("View tab") || strMenuOption.contains("View all") || strMenuOption.contains("Bank"))
		{
			CancelTasks();

			double dblTick = System.currentTimeMillis() + 10000;

			taskWidget = executor.scheduleAtFixedRate(() -> WaitForWidget(WidgetInfo.BANK_ITEM_COUNT, dblTick), 0, 1, TimeUnit.SECONDS);
		}

		return;
	}

	private void WaitForWidget(WidgetInfo info, double dblTick)
	{
		if (dblTick < System.currentTimeMillis() || !config.isEnabled())
		{
			taskWidget.cancel(true);
			return;
		}

		Widget w = client.getWidget(info);

		if (w != null)
		{
			taskWidget.cancel(true);
			futureCalculateBank = executor.schedule(runCalculateBank, 1, TimeUnit.SECONDS);
		}
	}

	private void CancelTasks()
	{
		if (taskWidget != null)
		{
			taskWidget.cancel(true);
			taskWidget = null;
		}

		if (futureCalculateBank != null)
		{
			runCalculateBank.abort();
			futureCalculateBank.cancel(false);
			futureCalculateBank = null;
		}
	}

	private int[] getItemPrices(int intID, int quantity)
	{
		if (ITEM_COINS == intID) return new int[]{quantity, quantity};

		ItemComposition itemComposition = itemManager.getItemComposition(intID);

		if (itemComposition == null) return new int[]{0, 0};

		log.warn(itemComposition.getName());

		ItemPrice itemPrice;
		try
		{
			itemPrice = itemManager.getItemPrice(itemComposition.getId());
		} catch (IOException e)
		{
			log.warn("Error looking up item price", e);
			return new int[]{0, 0};
		}

		int itemCompositionPrice = itemComposition.getPrice();

		return new int[]{itemPrice == null ? 0 : itemPrice.getPrice() * quantity, itemCompositionPrice <= 0 ? 0 : Math.round(itemCompositionPrice * HIGH_ALCHEMY_CONSTANT) * quantity};
	}

	private java.util.List<Widget> GetItems()
	{
		java.util.List<Widget> widgetItems = new ArrayList<Widget>();
		Widget widgetItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);

		if (widgetItemContainer == null) return widgetItems;

		Widget[] widgetChildren = widgetItemContainer.getDynamicChildren();

		for (int i = 0; i < widgetChildren.length; i++)
		{
			if (widgetChildren[i].getItemId() == ITEM_EMPTY || widgetChildren[i].getItemId() <= 0 || widgetChildren[i].isHidden())
				continue;

			widgetItems.add(widgetChildren[i]);
		}

		return widgetItems;
	}

	private String formatNumber(double n)
	{
		return formatNumber(n, 0);
	}

	private String formatNumber(double n, int iteration)
	{
		if (n >= 1000)
		{
			return formatNumber(((int) (n / 100D)) / 10D, iteration + 1);
		}
		else
		{
			return ((int) n) + suffixes[iteration];
		}
	}

	public class BankRunnable implements Runnable
	{
		private boolean boolExit = false;

		public void run()
		{
			try
			{
				boolExit = false;

				Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

				if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) return;

				java.util.List<Widget> widgetItems = GetItems();

				if (widgetItems.size() <= 0) return;

				client.getWidget(WidgetInfo.BANK_ITEM_COUNT).setText(widgetItems.size() + "");

				int intGEValue = 0;
				int intHAValue = 0;

				for (Widget widget : widgetItems)
				{
					if (boolExit) return;

					if (widget.getItemQuantity() <= 0 || widget.getItemId() == -1) continue;

					int intPrice[] = getItemPrices(widget.getItemId(), widget.getItemQuantity());

					if (config.includeUntradeable() && intPrice[0] == 0) intPrice[0] = intPrice[1];

					intGEValue += intPrice[0];
					intHAValue += intPrice[1];

					strCurrentTab = config.customName() + " ~" + formatNumber(intGEValue) + " (GE)";

					if (config.showHA()) strCurrentTab += " ~" + formatNumber(intHAValue) + " (HA)";

					widgetBankTitleBar.setText(strCurrentTab);
				}
			} catch (Exception e)
			{

			}
		}

		public void abort()
		{
			boolExit = true;
		}
	}

}
