package net.runelite.client.plugins.menuentryswapperextended.util;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.menuentryswapperextended.MenuEntrySwapperExtendedConfig;
import net.runelite.client.util.WildcardMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class CustomSwaps implements KeyListener
{

	private static final Logger log = LoggerFactory.getLogger(CustomSwaps.class);
	private final MenuEntrySwapperExtendedConfig config;

	@Inject
	private Client client;

	@Inject
	private MenuManager menuManager;

	@Inject
	private KeyManager keyManager;
	private boolean hasLoaded;

	@Inject
	public CustomSwaps(MenuEntrySwapperExtendedConfig config)
	{
		this.config = config;
	}

	static class EntryFromConfig
	{

		private String option;

		private String target;

		private String topOption;

		private String topTarget;

		public void setOption(String option)
		{
			this.option = option;
		}

		public void setTarget(String target)
		{
			this.target = target;
		}

		public void setTopOption(String topOption)
		{
			this.topOption = topOption;
		}

		public void setTopTarget(String topTarget)
		{
			this.topTarget = topTarget;
		}

		public String toString()
		{
			return "EntryFromConfig(option=" + getOption() + ", target=" + getTarget() + ", topOption="
					+ getTopOption() + ", topTarget=" + getTopTarget() + ")";
		}

		public EntryFromConfig(String option, String target, String topOption, String topTarget)
		{
			this.option = option;
			this.target = target;
			this.topOption = topOption;
			this.topTarget = topTarget;
		}

		public String getOption()
		{
			return this.option;
		}

		public String getTarget()
		{
			return this.target;
		}

		public String getTopOption()
		{
			return this.topOption;
		}

		public String getTopTarget()
		{
			return this.topTarget;
		}

		EntryFromConfig(String option, String target)
		{
			this(option, target, null, null);
		}

		public boolean equals(Object other)
		{
			if (!(other instanceof EntryFromConfig))
			{
				return false;
			}
			return (this.option.equals(((EntryFromConfig) other).option) && this.target
					.equals(((EntryFromConfig) other).target) && this.topOption
					.equals(((EntryFromConfig) other).topOption) && this.topTarget
					.equals(((EntryFromConfig) other).topTarget));
		}

		public int hashCode()
		{
			return Objects.hash(this.option, this.target, this.topOption, this.topTarget);
		}
	}


	private static final Set<MenuAction> EXAMINE_TYPES = ImmutableSet
			.of(MenuAction.EXAMINE_ITEM, MenuAction.EXAMINE_ITEM_GROUND, MenuAction.EXAMINE_NPC,
					MenuAction.EXAMINE_OBJECT);

	private static final Splitter SPLITTER = Splitter.on("\n").omitEmptyStrings().trimResults();

	private final ArrayList<EntryFromConfig> customSwaps = new ArrayList<>();

	private final ArrayList<EntryFromConfig> shiftCustomSwaps = new ArrayList<>();

	private final ArrayList<EntryFromConfig> keyCustomSwaps = new ArrayList<>();

	private final ArrayList<EntryFromConfig> removeOptions = new ArrayList<>();

	private final ArrayList<EntryFromConfig> bankCustomSwaps = new ArrayList<>();

	private final ArrayList<EntryFromConfig> shiftBankCustomSwaps = new ArrayList<>();

	private final ArrayList<EntryFromConfig> keyBankCustomSwaps = new ArrayList<>();

	private boolean holdingShift = false;

	private boolean holdingKeybind = false;


	public void startup()
	{
		holdingShift = false;
		holdingKeybind = false;
		keyManager.registerKeyListener(this);
	}

	public void shutdown()
	{
		holdingShift = false;
		holdingKeybind = false;
		keyManager.unregisterKeyListener(this);
		hasLoaded = false;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (!hasLoaded)
			{
				customSwaps.clear();
				parseConfigToList(config.customSwapsString(), customSwaps);
				shiftCustomSwaps.clear();
				parseConfigToList(config.shiftCustomSwapsString(), shiftCustomSwaps);
				keyCustomSwaps.clear();
				parseConfigToList(config.keyCustomSwapsString(), keyCustomSwaps);
				removeOptions.clear();
				parseConfigToList(config.removeOptionsString(), removeOptions);
				bankCustomSwaps.clear();
				parseConfigToList(config.bankCustomSwapsString(), bankCustomSwaps);
				shiftBankCustomSwaps.clear();
				parseConfigToList(config.bankShiftCustomSwapsString(), shiftBankCustomSwaps);
				keyBankCustomSwaps.clear();
				parseConfigToList(config.bankKeyCustomSwapsString(), keyBankCustomSwaps);
				hasLoaded = true;
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("menuentryswapperextended"))
		{
			switch (event.getKey())
			{
				case "customSwaps":
					customSwaps.clear();
					parseConfigToList(config.customSwapsString(), customSwaps);
					break;
				case "shiftCustomSwapsStr":
					shiftCustomSwaps.clear();
					parseConfigToList(config.shiftCustomSwapsString(), shiftCustomSwaps);
					break;
				case "keyCustomSwapsStr":
					keyCustomSwaps.clear();
					parseConfigToList(config.keyCustomSwapsString(), keyCustomSwaps);
					break;
				case "removeOptionsStr":
					removeOptions.clear();
					parseConfigToList(config.removeOptionsString(), removeOptions);
					break;
				case "bankCustomSwapsStr":
					bankCustomSwaps.clear();
					parseConfigToList(config.bankCustomSwapsString(), bankCustomSwaps);
					break;
				case "bankShiftCustomSwapsStr":
					shiftBankCustomSwaps.clear();
					parseConfigToList(config.bankShiftCustomSwapsString(), shiftBankCustomSwaps);
					break;
				case "bankKeyCustomSwapsStr":
					keyBankCustomSwaps.clear();
					parseConfigToList(config.bankKeyCustomSwapsString(), keyBankCustomSwaps);
					break;
			}
		}
	}

	private void parseConfigToList(String value, List<EntryFromConfig> set)
	{
		List<String> strList = SPLITTER.splitToList(value);
		for (String str : strList)
		{
			String[] stringList = str.split(",");
			if (stringList.length <= 1)
			{
				continue;
			}
			String option = stringList[0].toLowerCase().trim();
			String target = stringList[1].toLowerCase().trim();
			String topOption = null;
			String topTarget = null;
			if (stringList.length == 4)
			{
				topOption = stringList[2].toLowerCase().trim();
				topTarget = stringList[3].toLowerCase().trim();
			}
			EntryFromConfig entryFromConfig = new EntryFromConfig(option, target, topOption, topTarget);
			set.add(entryFromConfig);
		}
	}

	private static int topEntryIndex(MenuEntry[] entries)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			int type = entries[i].getType().getId();
			if (!EXAMINE_TYPES.contains(MenuAction.of(type)))
			{
				return i;
			}
		}
		return entries.length - 1;
	}

	private static int indexOfEntry(List<EntryFromConfig> configEntries,
			EntryFromConfig entryFromConfig, MenuEntry[] entries)
	{
		int topEntryIndex = topEntryIndex(entries);
		MenuEntry topEntry = entries[topEntryIndex];
		String target = Text.removeTags(topEntry.getTarget()).toLowerCase();
		String option = Text.removeTags(topEntry.getOption()).toLowerCase();
		for (int i = 0; i < configEntries.size(); i++)
		{
			EntryFromConfig _configEntry = configEntries.get(i);
			if ((_configEntry.option.equals(entryFromConfig.option) || WildcardMatcher
					.matches(_configEntry.option, entryFromConfig.option)) && (_configEntry.target
					.equals(entryFromConfig.target) || WildcardMatcher
					.matches(_configEntry.target, entryFromConfig.target)))
			{
				boolean a = (_configEntry.topOption == null);
				boolean b = (_configEntry.topTarget == null);
				Supplier<Boolean> c = () -> (_configEntry.topOption.equals(option) || WildcardMatcher
						.matches(_configEntry.topOption, option));
				Supplier<Boolean> d = () -> (_configEntry.topTarget.equals(target) || WildcardMatcher
						.matches(_configEntry.topTarget, target));
				if (a || b || (c.get() && d.get()))
				{
					return i;
				}
			}
		}
		return -1;
	}

	private MenuEntry[] filterEntries(MenuEntry[] menuEntries)
	{
		ArrayList<MenuEntry> filtered = new ArrayList<>();
		for (MenuEntry entry : menuEntries)
		{
			String target = Text.standardize(Text.removeTags(entry.getTarget()));
			String option = Text.standardize(Text.removeTags(entry.getOption()));
			EntryFromConfig entryFromConfig = new EntryFromConfig(option, target);
			if (indexOfEntry(removeOptions, entryFromConfig, menuEntries) == -1)
			{
				filtered.add(entry);
			}
		}
		return filtered.toArray(new MenuEntry[0]);
	}

	@Subscribe (priority = -1)
	public void onClientTick(ClientTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || client.isMenuOpen()
				|| !isBankInterfaceClosed())
		{
			return;
		}
		MenuEntry[] menuEntries = client.getMenuEntries();
		if (config.removeOptionsToggle())
		{
			menuEntries = filterEntries(menuEntries);
			client.setMenuEntries(menuEntries);
		}
		int entryIndex = -1;
		int priority = -1;
		for (int i = 0; i < menuEntries.length; i++)
		{
			MenuEntry entry = menuEntries[i];
			String str1 = Text.standardize(Text.removeTags(entry.getTarget()));
			String option = Text.standardize(Text.removeTags(entry.getOption()));
			EntryFromConfig entryFromConfig = new EntryFromConfig(option, str1);
			if (holdingShift && config.shiftCustomSwapsToggle())
			{
				int index = indexOfEntry(shiftCustomSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
			else if (holdingKeybind && config.keyCustomSwapsToggle())
			{
				int index = indexOfEntry(keyCustomSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
			else if (config.customSwapsToggle())
			{
				int index = indexOfEntry(customSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
		}
		if (entryIndex < 0)
		{
			return;
		}
		MenuEntry target = menuEntries[entryIndex];

		if (target.isItemOp() && target.getType() == MenuAction.CC_OP_LOW_PRIORITY)
		{
			target.setType(MenuAction.CC_OP);
		}
		else
		{
			for (MenuEntry menuEntry : menuEntries)
			{
				if (menuEntry.getType().getId() < target.getType().getId())
				{
					menuEntry.setDeprioritized(true);
				}
			}
		}

		MenuEntry first = menuEntries[menuEntries.length - 1];
		menuEntries[menuEntries.length - 1] = menuEntries[entryIndex];
		menuEntries[entryIndex] = first;
		client.setMenuEntries(menuEntries);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (isBankInterfaceClosed() || event.getIdentifier() > 2)
		{
			return;
		}
		MenuEntry[] menuEntries = client.getMenuEntries();
		int entryIndex = -1;
		int priority = -1;
		for (int i = 0; i < menuEntries.length; i++)
		{
			MenuEntry entry = menuEntries[i];
			String str1 = Text.removeTags(entry.getTarget()).toLowerCase();
			String option = Text.removeTags(entry.getOption()).toLowerCase();
			EntryFromConfig entryFromConfig = new EntryFromConfig(option, str1);
			if (holdingShift && config.shiftCustomSwapsToggle())
			{
				int index = indexOfEntry(shiftBankCustomSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
			else if (holdingKeybind && config.keyCustomSwapsToggle())
			{
				int index = indexOfEntry(keyBankCustomSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
			else if (config.customSwapsToggle())
			{
				int index = indexOfEntry(bankCustomSwaps, entryFromConfig, menuEntries);
				if (index > priority)
				{
					entryIndex = i;
					priority = index;
				}
			}
		}
		if (entryIndex < 0)
		{
			return;
		}
		MenuEntry target = menuEntries[entryIndex];
		int opId = target.getIdentifier();
		int actionId = (opId >= 6) ? MenuAction.CC_OP_LOW_PRIORITY.getId() : MenuAction.CC_OP.getId();
		if (event.getType() == MenuAction.CC_OP.getId() && (event
				.getIdentifier() == 1 || event.getIdentifier() == 2))
		{
			specialSwap(actionId, opId);
		}
	}

	private void specialSwap(int actionId, int opId)
	{
		MenuEntry[] menuEntries = client.getMenuEntries();
		for (int i = menuEntries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = menuEntries[i];
			if (entry.getType().getId() == actionId && entry.getIdentifier() == opId)
			{
				entry.setType(MenuAction.CC_OP);
				menuEntries[i] = menuEntries[menuEntries.length - 1];
				menuEntries[menuEntries.length - 1] = entry;
				client.setMenuEntries(menuEntries);
				break;
			}
		}
	}

	public void keyTyped(KeyEvent event)
	{
	}

	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == 16)
		{
			holdingShift = true;
		}
		if (config.hotkey().matches(event))
		{
			holdingKeybind = true;
		}
	}

	public void keyReleased(KeyEvent event)
	{
		if (event.getKeyCode() == 16)
		{
			holdingShift = false;
		}
		if (config.hotkey().matches(event))
		{
			holdingKeybind = false;
		}
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			holdingShift = false;
		}
		if (!event.isFocused())
		{
			holdingKeybind = false;
		}
	}

	private boolean isBankInterfaceClosed()
	{
		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		Widget widgetDepositBox = client.getWidget(WidgetInfo.DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER);
		Widget coxPublicChest = client.getWidget(550, 1);
		Widget coxPrivateChest = client.getWidget(271, 1);
		Widget seedVault = client.getWidget(WidgetInfo.SEED_VAULT_TITLE_CONTAINER);
		Widget runePouch = client.getWidget(WidgetInfo.RUNE_POUCH_ITEM_CONTAINER);
		return (
				(widgetBankTitleBar == null || widgetBankTitleBar.isHidden()) &&
				(widgetDepositBox == null || widgetDepositBox.isHidden()) &&
				(coxPublicChest == null || coxPublicChest.isHidden()) &&
				(coxPrivateChest == null || coxPrivateChest.isHidden()) &&
				(seedVault == null || seedVault.isHidden()) &&
				(runePouch == null || runePouch.isHidden())
		);
	}
}
