package net.runelite.client.plugins.remotebankcontents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.Varbits;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.ItemManager;

public class RemoteBankContentsProcess
{

	private final LinkedHashMap<Integer, Integer> items = new LinkedHashMap<>();

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;


	private int inventorySpace;

	@Inject
	RemoteBankContentsProcess(Client client)
	{
		this.client = client;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	/**
	 * Populates the HashMap with the items in the bank. (Key = item ID; Value = quantity)
	 */
	void populateBankItemMap()
	{
		ItemContainer bankItemContainer = client.getItemContainer(InventoryID.BANK);

		if (bankItemContainer != null)
		{
			items.clear();

			Arrays.stream(bankItemContainer.getItems()).forEach(s -> items.put(s.getId(), s.getQuantity()));


		}


	}

	/**
	 * @param id The ID of the item that you would like the name of.
	 * @return The name of the item with the ID provided
	 */
	private String getItemName(int id)
	{
		return itemManager.getItemComposition(id).getName();
	}

	/**
	 * @param id The ID of the item that you would like to know the quantity in the bank of.
	 * @return The quantity in the bank. (More specifically, the value of the id key in the hashmap)
	 */
	int getQuantityInBank(int id)
	{
		return items.get(id) != null ? items.get(id) : 0;
	}

	/**
	 * @return True if the item hashmap has any keys or values in.
	 */
	boolean initialised()
	{
		return items.size() > 0;
	}

	void outputExamine(MenuOptionClicked event)
	{

		int id = event.getId();

		if (!event.getMenuOption().equals("Examine"))
		{
			return;
		}


		if (isUltimateIronman())
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.SERVER).runeLiteFormattedMessage("<col" + ChatColorType.HIGHLIGHT + ">" + "UIM BTW.").build());

		}
		else if (initialised())
		{

			final ChatMessageBuilder message = new ChatMessageBuilder();

				/*Refine message based on quantity and if this necessitates a plural.

				if (quantity == 1) {
					message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + " in your bank.");
				} else {

					//Add s to the end. Need to check if the item ends in S and if it does not add S
					//and if the item ends in Y and add "ies". Also need to check exceptions to this rule.
					message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + "s in your bank.");
				}
                */
			int quantity = getQuantityInBank(id);
			String name = getItemName(id);

			message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + " in your bank.");

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.EXAMINE_ITEM).runeLiteFormattedMessage(message.build()).build());
		}
		else
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.SERVER).runeLiteFormattedMessage("<col" + ChatColorType.HIGHLIGHT + ">" + "Please open your bank to initialise.").build());

		}


	}

	/**
	 * @param id The id of the item that you would like to check the quantity of in the inventory.
	 * @return The quantity of the item with the ID provided in the inventory.
	 */
	private int getQuantityInInventory(int id)
	{

		Item desiredItem = null;
		ItemComposition itemComposition = client.getItemDefinition(id);
		ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		boolean stackable = itemComposition.isStackable();

		if (itemContainer == null)
		{
			return 0;
		}

		if (stackable)
		{

			return Arrays.stream(itemContainer.getItems()).filter(item -> item.getId() == id).findFirst().get().getQuantity();


		}
		else
		{

			return (int) Arrays.stream(itemContainer.getItems()).filter(item -> item.getId() == id).count();

		}


	}

	private boolean isUltimateIronman()
	{
		return client.getAccountType().equals(AccountType.ULTIMATE_IRONMAN);
	}

	public void reset()
	{
		items.clear();
	}

	void depositHandler(MenuOptionClicked event)
	{


		final int widgetId = event.getWidgetId();
		ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);


		if (inventoryContainer != null)
		{
			if (widgetId == WidgetInfo.BANK_ITEM_CONTAINER.getPackedId() || widgetId == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getPackedId())
			{

				ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

				if (inventory != null)
				{
					int positionInInventory = event.getActionParam();
					int id = inventory.getItems()[positionInInventory].getId();
					int quantityInInventory = getQuantityInInventory(id);

					int x = -1;

					if (!event.getMenuOption().equals("Deposit-All") &&
						!event.getMenuOption().equals("Deposit-All-but-1") &&
						!event.getMenuOption().equals("Deposit-1") &&
						!event.getMenuOption().equals("Deposit-5") &&
						!event.getMenuOption().equals("Deposit-10") &&
						!event.getMenuOption().equals("Deposit-X"))
					{


						x = -(Integer.parseInt(event.getMenuOption().split("[a-z]")[6]));

					}


					else if (!event.getMenuOption().equals("Deposit-X"))

					{


					}

					String depositX = "Deposit-" + x;

					if (event.getMenuOption().equals(depositX))
					{
						deposit(id, quantityInInventory, x);
						return;
					}

					{
						switch (event.getMenuOption())
						{
							case "Deposit-All":
								deposit(id, quantityInInventory, quantityInInventory);
								break;
							case "Deposit-All-but-1":
								deposit(id, quantityInInventory, quantityInInventory - 1);
								break;
							case "Deposit-1":
								deposit(id, quantityInInventory, 1);
								break;
							case "Deposit-5":
								deposit(id, quantityInInventory, 5);
								break;
							case "Deposit-10":
								deposit(id, quantityInInventory, 10);
								break;

						}
					}
				}
			}
			else if (widgetId == WidgetInfo.BANK_DEPOSIT_INVENTORY.getPackedId())
			{
				depositInventory();
			}


		}

	}

	private void depositInventory()
	{
		ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);
		HashMap<Integer, Integer> inventoryItems = new LinkedHashMap<>();


		Arrays.stream(inventoryContainer.getItems()).filter(item -> item.getId() != -1).filter(distinctByKey(Item::getId)).forEach(item -> deposit(item.getId(), getQuantityInInventory(item.getId())));


	}

	private void deposit(int id, int quantity)
	{
		replaceItemInBankDeposit(id, quantity);
	}


	private void deposit(int id, int quantityInInventory, int quantity)
	{
		if (quantityInInventory < quantity)
		{
			replaceItemInBankDeposit(id, quantityInInventory);
		}
		else
		{
			replaceItemInBankDeposit(id, quantity);
		}


	}


	private void withdraw(int id, int quantityInBank, int quantity)
	{


		if (quantity >= quantityInBank)
		{
			//if we have enough free spaces do this
			if (inventorySpace > quantityInBank)
			{
				replaceItemInBankWithdraw(id, quantityInBank);
			}
			else if (inventorySpace >= 1 && client.getItemDefinition(id).isStackable())
			{
				replaceItemInBankWithdraw(id, quantityInBank);
			}

			else if (inventorySpace >= 1 && isNotedWithdraw())
			{
				replaceItemInBankWithdraw(id, quantityInBank);
			}
			else
			{
				replaceItemInBankWithdraw(id, inventorySpace);
			}
		}
		else
		{
			if (inventorySpace > quantity)
			{
				replaceItemInBankWithdraw(id, quantity);

			}
			else if (inventorySpace >= 1 && client.getItemDefinition(id).isStackable())
			{
				replaceItemInBankWithdraw(id, quantity);
			}
			else if (inventorySpace >= 1 && isNotedWithdraw())
			{
				replaceItemInBankWithdraw(id, quantity);
			}
			else
			{
				replaceItemInBankWithdraw(id, inventorySpace);
			}

		}


	}


	public boolean isNotedWithdraw()
	{
		return client.getVar(Varbits.BANK_WITHDRAW_OPTION) == 1;
	}

	void setInventorySpace()
	{
		inventorySpace = calculateFreeInventorySpaces();
	}

	void withdrawHandler(MenuOptionClicked event)
	{


		final int widgetId = event.getWidgetId();
		ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

		if (bankInventory != null)
		{
			if (widgetId == WidgetInfo.BANK_ITEM_CONTAINER.getPackedId() || widgetId == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getPackedId())
			{

				int positionInBank = event.getActionParam();
				int id = bankInventory.getItems()[positionInBank].getId();
				int quantityInBank = getQuantityInBank(id);

				int x = -1;

				if (!event.getMenuOption().equals("Withdraw-All") &&
					!event.getMenuOption().equals("Withdraw-All-but-1") &&
					!event.getMenuOption().equals("Withdraw-1") &&
					!event.getMenuOption().equals("Withdraw-5") &&
					!event.getMenuOption().equals("Withdraw-10") &&
					!event.getMenuOption().equals("Withdraw-X"))

				{

					x = -(Integer.parseInt(event.getMenuOption().split("[a-z]")[7]));


				}

				String withdrawX = "Withdraw-" + x;

				if (event.getMenuOption().equals(withdrawX))
				{
					withdraw(id, quantityInBank, x);
					return;
				}

				switch (event.getMenuOption())
				{
					case "Withdraw-All":
						withdraw(id, quantityInBank, quantityInBank);
						break;
					case "Withdraw-All-but-1":
						withdraw(id, quantityInBank, quantityInBank - 1);
						break;
					case "Withdraw-1":
						withdraw(id, quantityInBank, 1);
						break;
					case "Withdraw-5":
						withdraw(id, quantityInBank, 5);
						break;
					case "Withdraw-10":
						withdraw(id, quantityInBank, 10);
						break;

				}


			}


		}

	}

	private void replaceItemInBankDeposit(int id, int quantity)
	{


		if (items.get(id) == null)
		{
			items.put(id, quantity);

		}
		else
		{
			items.replace(id, items.get(id) + quantity);
		}
	}

	private void replaceItemInBankWithdraw(int id, int quantity)
	{
		if (items.get(id) == null)
		{
			items.put(id, quantity);
		}
		else
		{
			items.replace(id, items.get(id) - quantity);
		}
	}


	private int calculateFreeInventorySpaces()
	{
		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
		Widget bankInventoryWidget = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);

		if (inventoryWidget != null || bankInventoryWidget != null)
		{

			ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

			if (inventory != null)
			{
				List<Item> inventoryItems = new ArrayList<>(Arrays.asList(inventory.getItems()));
				inventoryItems.removeIf(item -> item.getId() == -1);

				int numberOfItemsInInventory = inventoryItems.size();

				return 28 - numberOfItemsInInventory;

			}
			else
			{
				return 28;
			}


		}
		else
		{
			return -1;
		}

	}
}



