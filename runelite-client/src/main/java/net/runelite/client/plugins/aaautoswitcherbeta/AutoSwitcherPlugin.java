/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.aaautoswitcherbeta;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.devtools.WidgetInfoTableModel;
import net.runelite.client.plugins.grounditems.GroundItemInputListener;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
	name = "! Auto Switcher",
	description = "Pretty much just ruins your opponents day",
	tags = {"pvp", "cheese", "pve?", "vSwitcher Killer"}
)
@Slf4j
public class AutoSwitcherPlugin extends Plugin
{

	public String TEXT_PURPUR = "<col=C200D0>";
	public String ADD_ITEM_TO = "Add Item:";
	public String ADD_TAB_TO = "Add tab to";
	public String PRESET_3 = "Preset 3";
	public String PRESET_2 = "Preset 2";
	public String PRESET_1 = "Preset 1";

	public boolean hotKeyPressed = false;

	public int ITEM_PARAM = 9764864;

	//TODO: Need to do a better Storing system for presets but it works for now.
	public String preset1 = "";
	public String preset2 = "";
	public String preset3 = "";

	@Inject
	private Client client;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private AutoSwitcherInputListener inputListener;

    @Inject
    private WidgetInfoTableModel infoTableModel;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AutoSwitcherOverlay overlay;

	@Inject
	public AutoSwitcherConfig config;

	public MenuOpened lastMenuOpened;


	@Provides
	AutoSwitcherConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AutoSwitcherConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		mouseManager.registerMouseListener(inputListener);
		keyManager.registerKeyListener(inputListener);
		initOverlay();
	}

	public void initOverlay() {
		for (Object o : getSwitchesFromPreset(1)) {
			AutoSwitch as = (AutoSwitch) o;
			AutoSwitcherOverlay.preset1Items.add(as.itemID);
		}
		for (Object o : getSwitchesFromPreset(2)) {
			AutoSwitch as = (AutoSwitch) o;
			AutoSwitcherOverlay.preset2Items.add(as.itemID);
		}
		for (Object o : getSwitchesFromPreset(3)) {
			AutoSwitch as = (AutoSwitch) o;
			AutoSwitcherOverlay.preset3Items.add(as.itemID);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
	}

	public void executeScript(int key) {
		try {
			MouseUtil mu = new MouseUtil();
			if (key == KeyEvent.VK_1) {
				System.out.println("Off with their Heads!");
				List switches = getSwitchesFromPreset(1);
				Thread thread = new Thread(){
					public void run(){
						System.out.println("Thread Running");
						for (Object as : switches.toArray()) {
							AutoSwitch news = (AutoSwitch) as;
							if (news.isItemSwitch) {
								System.out.print("Item Switch: ");
								mu.doClick(news.itemID);
								System.out.println(" ID: "+news.itemID);
							}
							if (news.isTabSwitch) {
								System.out.print("Tab Switch: ");
								System.out.println(" ID: "+news.tabName);
							}
						}
					}
				};

				thread.start();
			}
			if (key == KeyEvent.VK_2) {
				System.out.println("Off with their Heads!");
				List switches = getSwitchesFromPreset(2);
				Thread thread = new Thread(){
					public void run(){
						System.out.println("Thread Running");
						for (Object as : switches.toArray()) {
							AutoSwitch news = (AutoSwitch) as;
							if (news.isItemSwitch) {
								System.out.print("Item Switch: ");
								mu.doClick(news.itemID);
								System.out.println(" ID: "+news.itemID);
							}
							if (news.isTabSwitch) {
								System.out.print("Tab Switch: ");
								System.out.println(" ID: "+news.tabName);
							}
						}
					}
				};

				thread.start();
			}
			if (key == KeyEvent.VK_3) {
				System.out.println("Off with their Heads!");
				List switches = getSwitchesFromPreset(3);
				Thread thread = new Thread(){
					public void run(){
						System.out.println("Thread Running");
						for (Object as : switches.toArray()) {
							AutoSwitch news = (AutoSwitch) as;
							if (news.isItemSwitch) {
								System.out.print("Item Switch: ");
								mu.doClick(news.itemID);
								System.out.println(" ID: "+news.itemID);
							}
							if (news.isTabSwitch) {
								System.out.print("Tab Switch: ");
								System.out.println(" ID: "+news.tabName);
							}
						}
					}
				};

				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		debugMenuInfo(event);
		lastMenuOpened = event;

		if (isInventoryMenu(event)) {
			addItemEntries(event);
		} else if (isTabMenu(event)) {
			addTabEntries(event);
		}
	}

	public void setCoreKeyPressed(boolean isPressed) {
		hotKeyPressed = isPressed;
	}

	public boolean isCoreKeyPressed() {
		return hotKeyPressed;
	}

@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		AutoSwitcherOverlay.preset1Items = new ArrayList<>();
		AutoSwitcherOverlay.preset2Items = new ArrayList<>();
		AutoSwitcherOverlay.preset3Items = new ArrayList<>();
		if (config.preset1()!=preset1)
			preset1=config.preset1();
		if (config.preset2()!=preset2)
			preset2=config.preset2();
		if (config.preset3()!=preset3)
			preset3=config.preset3();

		AutoSwitcherOverlay.inventoryItems = new ArrayList<WidgetItem>();
		initOverlay();
	}

	public List getSwitchesFromPreset(int preset) {
		String presetString = "";
		if (preset==1)
			presetString = config.preset1();
		if (preset==2)
			presetString = config.preset2();
		if (preset==3)
			presetString = config.preset3();
		String[] actions = presetString.split(",");
		List switchList = new ArrayList<AutoSwitch>();
		for (String s : actions) {
			if (s.startsWith("T")) {
				AutoSwitch newSwitch = new AutoSwitch("tab", (s.replace("T", "")));
				switchList.add(newSwitch);
				System.out.println(s);
			}
			if (s.startsWith("I")) {
				AutoSwitch newSwitch = new AutoSwitch("item", Integer.valueOf(s.replace("I", "")));
				switchList.add(newSwitch);
				System.out.println(s);
			}
		}
		return switchList;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event) {
		if (event.getMenuOption().startsWith("Add Item:")) {
			if(event.getMenuTarget().endsWith(PRESET_1)) {
				addItemToPreset(event, AutoSwitcherOverlay.preset1Items);
			}
			if(event.getMenuTarget().endsWith(PRESET_2)) {
				addItemToPreset(event, AutoSwitcherOverlay.preset2Items);
			}
			if(event.getMenuTarget().endsWith(PRESET_3)) {
				addItemToPreset(event, AutoSwitcherOverlay.preset3Items);
			}

		}
		if (event.getMenuOption()==ADD_TAB_TO) {
			for (MenuEntry me : lastMenuOpened.getMenuEntries()) {
				System.out.println(me.getOption());
				if (isTabName(me)) {
					config.setPreset1(config.preset1()+",T"+me.getOption());
					return;
				} else {
					System.out.println(me.getOption());
				}
			}

		}
	}

	public boolean isTabName(MenuEntry me) {
		if (me.getOption().compareTo("Combat Options")==0)
			return true;
		if (me.getOption().compareTo("Inventory")==0)
			return true;
		if (me.getOption().compareTo("Worn Equipment")==0)
			return true;
		if (me.getOption().compareTo("Prayer")==0)
			return true;
		if (me.getOption().compareTo("Magic")==0)
			return true;
		if (me.getOption().compareTo("Combat Options")==0)
			return true;
		if (me.getOption().compareTo("Emotes")==0)
			return true;
		if (me.getOption().compareTo("Logout")==0)
			return true;

		System.out.println(me.getOption().compareTo("Magic"));
		return false;
	}

	public void addItemToPreset(MenuOptionClicked event, ArrayList<Integer> preset) {
		String itemIdString = event.getMenuOption().replace("Add Item:", "");
		int itemId = Integer.valueOf(itemIdString);
		preset.add(itemId);
		AutoSwitch autoSwitch = new AutoSwitch("item", itemId);
		if(event.getMenuTarget().endsWith(PRESET_1)) {
			config.setPreset1(config.preset1()+",I"+itemId);
		}
		if(event.getMenuTarget().endsWith(PRESET_2)) {
			config.setPreset2(config.preset2()+",I"+itemId);
		}
		if(event.getMenuTarget().endsWith(PRESET_3)) {
			config.setPreset3(config.preset3()+",I"+itemId);
		}
	}

	public MenuEntry[] addMenuEntry(MenuEntry[] menuEntries, String option, String target) {
		MenuEntry newEntry = new MenuEntry();
		newEntry.setOption(option);
		newEntry.setTarget(TEXT_PURPUR+target);
		return ArrayUtils.add(menuEntries, newEntry);
	}

	public boolean isInventoryMenu(MenuOpened event) {
		for (MenuEntry entry : event.getMenuEntries()) {
			if (entry.getParam1()==ITEM_PARAM)
				return true;
		}
		return false;
	}

	public boolean isTabMenu(MenuOpened event) {
		MenuEntryInfo info = new MenuEntryInfo();
		for (MenuEntry entry : event.getMenuEntries()) {
			if (entry.getParam1()==MenuEntryInfo.COMBAT_OPTIONS_TAB ||
					entry.getParam1()==MenuEntryInfo.EMOTES_TAB ||
					entry.getParam1()==MenuEntryInfo.INVENTORY_TAB ||
					entry.getParam1()==MenuEntryInfo.LOGOUT_TAB ||
					entry.getParam1()==MenuEntryInfo.MAGIC_TAB ||
					entry.getParam1()==MenuEntryInfo.PRAYER_TAB ||
					entry.getParam1()==MenuEntryInfo.WORN_EQUIPMENT_TAB)
				return true;
		}
		return false;
	}

	public int getItemIDFromMenuEntry(MenuEntry[] entries) {
		for (MenuEntry entry : entries) {
			if (entry.getIdentifier()!=0)
			return entry.getIdentifier();
		}
	return -1;
	}

	public void addItemEntries(MenuOpened event) {
		MenuEntry[] entries = event.getMenuEntries();
		entries = addMenuEntry(entries, ADD_ITEM_TO + getItemIDFromMenuEntry(event.getMenuEntries()), PRESET_3);
		entries = addMenuEntry(entries, ADD_ITEM_TO + getItemIDFromMenuEntry(event.getMenuEntries()), PRESET_2);
		entries = addMenuEntry(entries, ADD_ITEM_TO + getItemIDFromMenuEntry(event.getMenuEntries()), PRESET_1);
		client.setMenuEntries(entries);
	}

	public void addTabEntries(MenuOpened event) {
		MenuEntry[] entries = event.getMenuEntries();
		entries = addMenuEntry(entries, ADD_TAB_TO, PRESET_3);
		entries = addMenuEntry(entries, ADD_TAB_TO, PRESET_2);
		entries = addMenuEntry(entries, ADD_TAB_TO, PRESET_1);
		client.setMenuEntries(entries);
	}

	public void debugMenuInfo(MenuOpened event) {
		for (MenuEntry entry : event.getMenuEntries()) {
			System.out.print("Option: " + entry.getOption());
			System.out.print(" - Target: " + entry.getTarget());
			System.out.print(" - param0: " + entry.getParam0());
			System.out.print(" - param1: " + entry.getParam1());
			System.out.print(" - ID: " + entry.getIdentifier());
			System.out.println(" - Type: " + entry.getType());
		}
	}

}
