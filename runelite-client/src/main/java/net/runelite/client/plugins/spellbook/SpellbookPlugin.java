/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.spellbook;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ParamID;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetConfig.DRAG;
import static net.runelite.api.widgets.WidgetConfig.DRAG_ON;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Spellbook",
	description = "Reorder and hide spells"
)
@Slf4j
public class SpellbookPlugin extends Plugin
{
	private static final String LOCK = "Disable spell reordering";
	private static final String UNLOCK = "Enable spell reordering";
	// [proc,magic_spellbook_modifyops] shifts around ops, but seems to only use
	// 1 2 3 4 5 10. So use 6 for Hide/Unhide.
	private static final int HIDE_UNHIDE_OP = 6;

	private static final WidgetMenuOption FIXED_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.FIXED_VIEWPORT_MAGIC_TAB);

	private static final WidgetMenuOption FIXED_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.FIXED_VIEWPORT_MAGIC_TAB);

	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_MAGIC_TAB);

	private static final WidgetMenuOption RESIZABLE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_MAGIC_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MenuManager menuManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ConfigManager configManager;

	private boolean reordering;

	@Provides
	SpellbookConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpellbookConfig.class);
	}

	@Override
	protected void startUp()
	{
		refreshReorderMenus();
		clientThread.invokeLater(this::reinitializeSpellbook);
	}

	@Override
	protected void shutDown()
	{
		clearReoderMenus();
		clientThread.invokeLater(this::reinitializeSpellbook);
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged event)
	{
		clientThread.invokeLater(this::redrawSpellbook);
	}

	@Override
	public void resetConfiguration()
	{
		for (var key : configManager.getConfigurationKeys(SpellbookConfig.GROUP + ".spell_"))
		{
			String[] str = key.split("\\.", 2);
			if (str.length == 2)
			{
				configManager.unsetConfiguration(str[0], str[1]);
			}
		}

		clientThread.invokeLater(this::redrawSpellbook);

		log.debug("Reset spellbook");
	}

	private void clearReoderMenus()
	{
		menuManager.removeManagedCustomMenu(FIXED_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK);
		menuManager.removeManagedCustomMenu(FIXED_MAGIC_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_MAGIC_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK);
	}

	private void refreshReorderMenus()
	{
		clearReoderMenus();
		if (reordering)
		{
			menuManager.addManagedCustomMenu(FIXED_MAGIC_TAB_LOCK, e -> reordering(false));
			menuManager.addManagedCustomMenu(RESIZABLE_MAGIC_TAB_LOCK, e -> reordering(false));
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_LOCK, e -> reordering(false));
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_MAGIC_TAB_UNLOCK, e -> reordering(true));
			menuManager.addManagedCustomMenu(RESIZABLE_MAGIC_TAB_UNLOCK, e -> reordering(true));
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_MAGIC_TAB_UNLOCK, e -> reordering(true));
		}
	}

	private void reordering(boolean state)
	{
		reordering = state;

		var message = reordering ?
			"Spell book reordering is now enabled." :
			"Spell book reordering is now disabled.";

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message)
			.build());

		refreshReorderMenus();

		redrawSpellbook();
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.MAGIC_SPELLBOOK_INITIALISESPELLS)
		{
			int[] stack = client.getIntStack();
			int sz = client.getIntStackSize();
			int spellBookEnum = stack[sz - 12]; // eg 1982, 5285, 1983, 1984, 1985
			clientThread.invokeLater(() -> initializeSpells(spellBookEnum));
		}
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		if (event.isDraggingWidget() && client.getMouseCurrentButton() == 0)
		{
			Widget draggedWidget = client.getDraggedWidget();
			Widget draggedOnWidget = client.getDraggedOnWidget();
			if (draggedWidget == null || draggedOnWidget == null)
			{
				return;
			}

			int draggedGroupId = WidgetUtil.componentToInterface(draggedWidget.getId());
			int draggedOnGroupId = WidgetUtil.componentToInterface(draggedOnWidget.getId());
			if (draggedGroupId != InterfaceID.SPELLBOOK || draggedOnGroupId != InterfaceID.SPELLBOOK)
			{
				return;
			}

			// from ~magic_spellbook_redraw
			int subSpellbookId = client.getEnum(EnumID.SPELLBOOKS_SUB).getIntValue(client.getVarbitValue(Varbits.SPELLBOOK));
			int spellbookId = client.getEnum(subSpellbookId).getIntValue(client.getVarbitValue(Varbits.SPELLBOOK_SUBMENU));

			EnumComposition spellbook = client.getEnum(spellbookId);
			int[] order = calculateSpellbookOrder(spellbookId, spellbook); // in enum indices

			int fromIdx = findSpellIdxForComponent(spellbook, order, draggedWidget);
			int toIdx = findSpellIdxForComponent(spellbook, order, draggedOnWidget);

			ItemComposition fromSpell = client.getItemDefinition(spellbook.getIntValue(order[fromIdx]));
			ItemComposition toSpell = client.getItemDefinition(spellbook.getIntValue(order[toIdx]));

			log.debug("Insert {} ({}) at {} ({}) spellbook {}",
				fromSpell.getStringValue(ParamID.SPELL_NAME), fromIdx,
				toSpell.getStringValue(ParamID.SPELL_NAME), toIdx,
				spellbookId);

			log.debug("Set {} to {}", client.getItemDefinition(spellbook.getIntValue(order[fromIdx])).getStringValue(ParamID.SPELL_NAME), toIdx);
			setPosition(spellbookId, spellbook.getIntValue(order[fromIdx]), toIdx);
			if (fromIdx < toIdx)
			{
				for (int i = fromIdx + 1; i <= toIdx; ++i)
				{
					log.debug("Set {} to {}", client.getItemDefinition(spellbook.getIntValue(order[i])).getStringValue(ParamID.SPELL_NAME), i - 1);
					setPosition(spellbookId, spellbook.getIntValue(order[i]), i - 1);
				}
			}
			else
			{
				for (int i = toIdx; i < fromIdx; ++i)
				{
					log.debug("Set {} to {}", client.getItemDefinition(spellbook.getIntValue(order[i])).getStringValue(ParamID.SPELL_NAME), i + 1);
					setPosition(spellbookId, spellbook.getIntValue(order[i]), i + 1);
				}
			}

			redrawSpellbook();
		}
	}

	private int findSpellIdxForComponent(EnumComposition spellbook, int[] spells, Widget c)
	{
		for (int i = 0; i < spells.length; ++i)
		{
			ItemComposition spellObj = client.getItemDefinition(spellbook.getIntValue(spells[i]));
			Widget w = client.getWidget(spellObj.getIntValue(ParamID.SPELL_BUTTON));
			if (w == c)
			{
				return i;
			}
		}
		return -1;
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"spellbookSort".equals(event.getEventName()))
		{
			return;
		}

		createWarning(reordering);

		// this is called after ~magic_spellbook_redraw has built and sorted the array of visible spells
		// based on the vanilla filtering

		int[] stack = client.getIntStack();
		int size = client.getIntStackSize();

		int spellbookEnumId = stack[size - 3];
		int spellArrayId = stack[size - 2];
		int numSpells = stack[size - 1];

		EnumComposition spellbookEnum = client.getEnum(spellbookEnumId);
		int[] spells = client.getArray(spellArrayId); // enum indices
		int[] newSpells = new int[numSpells];
		int numNewSpells = 0;
		for (int i = 0; i < numSpells; ++i)
		{
			ItemComposition spellObj = client.getItemDefinition(spellbookEnum.getIntValue(spells[i]));
			Widget w = client.getWidget(spellObj.getIntValue(ParamID.SPELL_BUTTON));
			boolean hidden = isHidden(spellbookEnumId, spellObj.getId());

			int widgetConfig = w.getClickMask();
			if (reordering)
			{
				if (hidden)
				{
					w.setOpacity(100);
					w.setAction(HIDE_UNHIDE_OP, "Unhide");
				}
				else
				{
					w.setOpacity(0);
					w.setAction(HIDE_UNHIDE_OP, "Hide");
				}

				newSpells[numNewSpells++] = spells[i];
				widgetConfig |= DRAG | DRAG_ON;
			}
			else
			{
				if (hidden)
				{
					w.setHidden(true);
				}
				else
				{
					newSpells[numNewSpells++] = spells[i];
					w.setOpacity(0);
					w.setAction(HIDE_UNHIDE_OP, null);
				}

				widgetConfig &= ~(DRAG | DRAG_ON);
			}
			w.setClickMask(widgetConfig);
		}

		// Sort newSpells based on their configured order
		int[] order = calculateSpellbookOrder(spellbookEnumId, spellbookEnum);
		int[] indices = new int[order.length];
		for (int i = 0; i < order.length; ++i)
		{
			indices[order[i]] = i;
		}
		newSpells = Arrays.stream(newSpells, 0, numNewSpells)
			.boxed()
			.sorted(Comparator.comparingInt(i -> indices[i]))
			.mapToInt(i -> i)
			.toArray();

		System.arraycopy(newSpells, 0, spells, 0, numNewSpells);
		stack[size - 1] = numSpells = numNewSpells;
	}

	private void createWarning(boolean unlocked)
	{
		Widget w = client.getWidget(ComponentID.SPELLBOOK_PARENT);
		w.deleteAllChildren();

		if (unlocked)
		{
			Widget c = w.createChild(WidgetType.RECTANGLE);
			c.setHeightMode(WidgetSizeMode.MINUS);
			c.setWidthMode(WidgetSizeMode.MINUS);
			c.setTextColor(0xff0000);
			c.setFilled(true);
			c.setOpacity(220);
			c.revalidate();
		}
	}

	private void initializeSpells(int spellbookEnum)
	{
		EnumComposition spellbook = client.getEnum(spellbookEnum);
		for (int i = 0; i < spellbook.size(); ++i)
		{
			int spellObjId = spellbook.getIntValue(i);
			ItemComposition spellObj = client.getItemDefinition(spellObjId);
			int spellComponent = spellObj.getIntValue(ParamID.SPELL_BUTTON);
			Widget w = client.getWidget(spellComponent);

			// spells with no target mask have an existing op listener, capture it to
			// call it later
			Object[] opListener = w.getOnOpListener();
			w.setOnOpListener((JavaScriptCallback) e ->
			{
				if (e.getOp() == HIDE_UNHIDE_OP + 1)
				{
					Widget s = e.getSource();

					// Spells can be shared between spellbooks, so we can't assume spellbookEnum is the current spellbook.
					// from ~magic_spellbook_redraw
					int subSpellbookId = client.getEnum(EnumID.SPELLBOOKS_SUB).getIntValue(client.getVarbitValue(Varbits.SPELLBOOK));
					int spellbookId = client.getEnum(subSpellbookId).getIntValue(client.getVarbitValue(Varbits.SPELLBOOK_SUBMENU));

					boolean hidden = isHidden(spellbookId, spellObjId);
					hidden = !hidden;

					log.debug("Changing {} to hidden: {}", s.getName(), hidden);
					setHidden(spellbookId, spellObjId, hidden);

					s.setOpacity(hidden ? 100 : 0);
					s.setAction(HIDE_UNHIDE_OP, hidden ? "Unhide" : "Hide");
					return;
				}

				if (opListener != null)
				{
					client.runScript(opListener);
				}
			});
		}
	}

	private void reinitializeSpellbook()
	{
		Widget w = client.getWidget(ComponentID.SPELLBOOK_PARENT);
		if (w != null && w.getOnLoadListener() != null)
		{
			client.createScriptEvent(w.getOnLoadListener())
				.setSource(w)
				.run();
		}
	}

	private void redrawSpellbook()
	{
		Widget w = client.getWidget(ComponentID.SPELLBOOK_PARENT);
		if (w != null && w.getOnInvTransmitListener() != null)
		{
			client.createScriptEvent(w.getOnInvTransmitListener())
				.setSource(w)
				.run();
		}
	}

	private int[] calculateSpellbookOrder(int spellbookId, EnumComposition spellbook)
	{
		int[] spells = defaultSpellbookOrder(spellbook);
		int[] indices = new int[spells.length]; // spell to desired index
		for (int i = 0; i < spells.length; ++i)
		{
			int pos = getPosition(spellbookId, spellbook.getIntValue(spells[i]));
			indices[spells[i]] = pos != -1 ? pos : i;
		}

		// sort by desired index
		return Arrays.stream(spells)
			.boxed()
			.sorted(Comparator.comparingInt(i -> indices[i]))
			.mapToInt(i -> i)
			.toArray();
	}

	private int[] defaultSpellbookOrder(EnumComposition spellbook)
	{
		return IntStream.range(0, spellbook.size())
			.boxed()
			.sorted((idx1, idx2) ->
			{
				var i1 = client.getItemDefinition(spellbook.getIntValue(idx1));
				var i2 = client.getItemDefinition(spellbook.getIntValue(idx2));
				int l1 = i1.getIntValue(ParamID.SPELL_LEVELREQ);
				int l2 = i2.getIntValue(ParamID.SPELL_LEVELREQ);
				return Integer.compare(l1, l2);
			})
			.mapToInt(i -> i)
			.toArray();
	}

	private boolean isHidden(int spellbook, int spell)
	{
		Boolean b = configManager.getConfiguration(SpellbookConfig.GROUP, "spell_hidden_book_" + spellbook + "_" + spell, boolean.class);
		return b == Boolean.TRUE;
	}

	private void setHidden(int spellbook, int spell, boolean hidden)
	{
		if (hidden)
		{
			configManager.setConfiguration(SpellbookConfig.GROUP, "spell_hidden_book_" + spellbook + "_" + spell, true);
		}
		else
		{
			configManager.unsetConfiguration(SpellbookConfig.GROUP, "spell_hidden_book_" + spellbook + "_" + spell);
		}
	}

	private int getPosition(int spellbook, int spell)
	{
		Integer pos = configManager.getConfiguration(SpellbookConfig.GROUP, "spell_pos_book_" + spellbook + "_" + spell, int.class);
		return pos == null ? -1 : pos;
	}

	private void setPosition(int spellbook, int spell, int position)
	{
		configManager.setConfiguration(SpellbookConfig.GROUP, "spell_pos_book_" + spellbook + "_" + spell, position);
	}
}
