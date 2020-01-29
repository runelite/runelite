/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.tmorph.ui;

import com.google.common.collect.ImmutableSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.kit.KitType;
import static net.runelite.api.kit.KitType.AMULET;
import static net.runelite.api.kit.KitType.BOOTS;
import static net.runelite.api.kit.KitType.CAPE;
import static net.runelite.api.kit.KitType.HANDS;
import static net.runelite.api.kit.KitType.HELMET;
import static net.runelite.api.kit.KitType.LEGS;
import static net.runelite.api.kit.KitType.SHIELD;
import static net.runelite.api.kit.KitType.TORSO;
import static net.runelite.api.kit.KitType.WEAPON;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.database.DatabaseManager;
import static net.runelite.client.database.data.Tables.TMORPH_SETS;
import net.runelite.client.database.data.tables.records.TmorphSetsRecord;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.tmorph.TMorph;
import net.runelite.client.plugins.tmorph.TmorphSet;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxIconEntry;
import net.runelite.client.util.Clipboard;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;

@Slf4j
public class TPanel extends PluginPanel
{
	private static final Set<KitType> BLACKLIST = ImmutableSet.of(KitType.AMMUNITION, KitType.RING, KitType.HEAD, KitType.JAW);

	private final Client client;
	private final DatabaseManager databaseManager;
	private final ItemManager itemManager;
	private final TMorph plugin;
	private final Notifier notifier;

	private final JComboBox<String> selector;
	private final Map<KitType, EquipSlot> equipSlots;
	private final Map<KitType, Integer> kitToId;
	private final Map<String, TmorphSet> setMap;
	private final ExecutorService executor;
	private JPanel equipPanel;

	@Inject
	public TPanel(
		final Client client,
		final DatabaseManager databaseManager,
		final ItemManager itemManager,
		final TMorph plugin,
		final Notifier notifier
	)
	{
		super(false);
		this.client = client;
		this.databaseManager = databaseManager;
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.notifier = notifier;
		this.equipSlots = new LinkedHashMap<>();
		this.kitToId = new HashMap<>();
		this.setMap = new HashMap<>();
		this.selector = new JComboBox<>();
		this.executor = Executors.newSingleThreadExecutor();
		init();
	}

	private void init()
	{
		selector.addItem("Populating fields...");
		selector.setSelectedIndex(0);
		selector.addActionListener((e) ->
		{
			String name = (String) selector.getSelectedItem();
			Result<TmorphSetsRecord> recs = databaseManager.getDsl()
				.selectFrom(TMORPH_SETS)
				.where(TMORPH_SETS.SET_NAME.eq(name))
				.fetch();

			for (TmorphSetsRecord rec : recs)
			{
				for (Map.Entry<KitType, EquipSlot> entry : equipSlots.entrySet())
				{
					int id = rec.getValue(kitToField(entry.getKey()));
					EquipSlot es = entry.getValue();
					es.setSelectedItem(es.getBoxMap().getOrDefault(id, es.getOriginal()));
				}
			}
		});

		final JLabel title = new JLabel();
		title.setText("Tmorph Sets");
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);

		final JPanel titleAndMarkersPanel = new JPanel();
		titleAndMarkersPanel.setLayout(new BorderLayout());
		titleAndMarkersPanel.add(title, BorderLayout.CENTER);

		final JPanel northAnchoredPanel = new JPanel();
		northAnchoredPanel.setLayout(new BoxLayout(northAnchoredPanel, Y_AXIS));
		northAnchoredPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		northAnchoredPanel.add(titleAndMarkersPanel);
		northAnchoredPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		northAnchoredPanel.add(selector);

		final JPanel containerHolder = new JPanel();
		final JPanel containerPanel = new JPanel();

		final JLabel caption = new JLabel();
		caption.setText("Morph Selector");
		caption.setForeground(Color.WHITE);
		caption.setHorizontalAlignment(JLabel.CENTER);
		caption.setVerticalAlignment(JLabel.CENTER);

		final JPanel captionPanel = new JPanel();
		captionPanel.add(caption);

		equipPanel = new JPanel();
		equipPanel.setLayout(new GridLayout(11, 1, 1, 1));
		addSlots();

		containerPanel.setLayout(new BorderLayout());
		containerPanel.add(captionPanel, BorderLayout.NORTH);
		containerPanel.add(equipPanel, BorderLayout.CENTER);

		containerHolder.add(containerPanel);

		final JPanel contentPanel = new JPanel();
		final BoxLayout contentLayout = new BoxLayout(contentPanel, Y_AXIS);
		contentPanel.setLayout(contentLayout);
		contentPanel.add(containerHolder);

		final JPanel contentWrapper = new JPanel(new BorderLayout());
		contentWrapper.add(Box.createGlue(), BorderLayout.CENTER);
		contentWrapper.add(contentPanel, BorderLayout.NORTH);
		final JScrollPane contentWrapperPane = new JScrollPane(contentWrapper);
		contentWrapperPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		add(northAnchoredPanel, BorderLayout.NORTH);
		add(contentWrapperPane, BorderLayout.CENTER);
		executor.submit(this::populateSelector);
	}

	private void populateSelector()
	{
		if (!databaseManager.checkTableExists("TMORPH_SETS"))
		{
			databaseManager.getDsl().createTable(TMORPH_SETS)
				.column(TMORPH_SETS.SET_NAME, SQLDataType.VARCHAR(255).nullable(false))
				.column(TMORPH_SETS.HELMET, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.CAPE, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.AMULET, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.WEAPON, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.TORSO, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.SHIELD, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.LEGS, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.HANDS, SQLDataType.INTEGER.nullable(false))
				.column(TMORPH_SETS.BOOTS, SQLDataType.INTEGER.nullable(false))
				.execute();
		}

		Result<TmorphSetsRecord> recs = databaseManager.getDsl().selectFrom(TMORPH_SETS).fetch();
		setMap.clear();
		selector.removeAllItems();
		selector.addItem("Select your set...");
		selector.setSelectedIndex(0);

		for (Record record : recs)
		{
			TmorphSet tmo = new TmorphSet();
			String name = record.getValue(TMORPH_SETS.SET_NAME);
			tmo.setName(name);
			tmo.setHelmet(record.getValue(TMORPH_SETS.HELMET));
			tmo.setCape(record.getValue(TMORPH_SETS.CAPE));
			tmo.setAmulet(record.getValue(TMORPH_SETS.AMULET));
			tmo.setWeapon(record.getValue(TMORPH_SETS.WEAPON));
			tmo.setTorso(record.getValue(TMORPH_SETS.TORSO));
			tmo.setShield(record.getValue(TMORPH_SETS.SHIELD));
			tmo.setLegs(record.getValue(TMORPH_SETS.LEGS));
			tmo.setHands(record.getValue(TMORPH_SETS.HANDS));
			tmo.setBoots(record.getValue(TMORPH_SETS.BOOTS));
			setMap.put(name, tmo);
			selector.addItem(name);
		}
	}

	private void addSlots()
	{
		int i = 0;

		for (KitType kitType : KitType.values())
		{
			if (BLACKLIST.contains(kitType))
			{
				continue;
			}

			final EquipSlot equip = new EquipSlot(kitType);

			equip.addItemListener((e) ->
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					ComboBoxIconEntry combo = (ComboBoxIconEntry) e.getItem();

					if (combo.getData() == null)
					{
						return;
					}

					ItemDefinition def = (ItemDefinition) combo.getData();
					KitType type = null;

					for (Map.Entry<KitType, EquipSlot> entry : equipSlots.entrySet())
					{
						if (entry.getValue() == e.getSource())
						{
							type = entry.getKey();
							break;
						}
					}

					if (type == null)
					{
						return;
					}

					if (kitToId.containsKey(type))
					{
						kitToId.replace(type, def.getId());
					}
					else
					{
						kitToId.put(type, def.getId());
					}

					if (client.getGameState() == GameState.LOGGED_IN)
					{
						generate(false);
					}
				}
			});

			equipSlots.put(kitType, equip);
			equipPanel.add(equip);
			i++;
		}

		final JButton setButton = new JButton("Set/Copy Active Morph");
		setButton.addActionListener((e) -> plugin.setPanelMorph(generate(true)));
		equipPanel.add(setButton);

		final JButton saveButton = new JButton("Save Active Morph");
		saveButton.addActionListener((e) ->
		{
			final String s = JOptionPane.showInputDialog(saveButton, "What would you like to name the set?");

			if (s == null || s.isEmpty())
			{
				return;
			}

			Result<TmorphSetsRecord> records = databaseManager.getDsl()
				.selectFrom(TMORPH_SETS)
				.where(TMORPH_SETS.SET_NAME.eq(s))
				.fetch();

			boolean exists = records.isNotEmpty();

			if (!exists)
			{
				databaseManager.getDsl().insertInto(TMORPH_SETS)
					.set(TMORPH_SETS.SET_NAME, s)
					.set(TMORPH_SETS.HELMET, kitToId.getOrDefault(HELMET, -1))
					.set(TMORPH_SETS.CAPE, kitToId.getOrDefault(CAPE, -1))
					.set(TMORPH_SETS.AMULET, kitToId.getOrDefault(AMULET, -1))
					.set(TMORPH_SETS.WEAPON, kitToId.getOrDefault(WEAPON, -1))
					.set(TMORPH_SETS.TORSO, kitToId.getOrDefault(TORSO, -1))
					.set(TMORPH_SETS.SHIELD, kitToId.getOrDefault(SHIELD, -1))
					.set(TMORPH_SETS.LEGS, kitToId.getOrDefault(LEGS, -1))
					.set(TMORPH_SETS.HANDS, kitToId.getOrDefault(HANDS, -1))
					.set(TMORPH_SETS.BOOTS, kitToId.getOrDefault(BOOTS, -1))
					.execute();
				executor.submit(this::populateSelector);
			}
			else
			{
				databaseManager.getDsl().update(TMORPH_SETS)
					.set(TMORPH_SETS.HELMET, kitToId.getOrDefault(HELMET, -1))
					.set(TMORPH_SETS.CAPE, kitToId.getOrDefault(CAPE, -1))
					.set(TMORPH_SETS.AMULET, kitToId.getOrDefault(AMULET, -1))
					.set(TMORPH_SETS.WEAPON, kitToId.getOrDefault(WEAPON, -1))
					.set(TMORPH_SETS.TORSO, kitToId.getOrDefault(TORSO, -1))
					.set(TMORPH_SETS.SHIELD, kitToId.getOrDefault(SHIELD, -1))
					.set(TMORPH_SETS.LEGS, kitToId.getOrDefault(LEGS, -1))
					.set(TMORPH_SETS.HANDS, kitToId.getOrDefault(HANDS, -1))
					.set(TMORPH_SETS.BOOTS, kitToId.getOrDefault(BOOTS, -1))
					.where(TMORPH_SETS.SET_NAME.eq(s))
					.execute();
			}
		});
		equipPanel.add(saveButton);
	}

	public void populateSlots()
	{
		for (EquipSlot slot : equipSlots.values())
		{
			slot.populate(client, itemManager);
		}
	}

	public Map<String, String> generate(boolean copy)
	{
		final StringBuilder sb = new StringBuilder();
		final Player player = client.getLocalPlayer();

		if (player == null
			|| player.getPlayerAppearance() == null
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null)
		{
			return new HashMap<>();
		}

		for (KitType kitType : KitType.values())
		{
			if (BLACKLIST.contains(kitType))
			{
				continue;
			}

			final Widget widget = client.getWidget(kitType.getWidgetInfo());

			if (widget == null || widget.getDynamicChildren() == null || widget.getDynamicChildren().length < 1)
			{
				continue;
			}

			final int id = itemManager.canonicalize(widget.getDynamicChildren()[1].getItemId());
			final int kitId = kitToId.getOrDefault(kitType, -1);

			if (kitId == -1)
			{
				continue;
			}

			sb.append(id);
			sb.append(",");
			sb.append(kitId);
			sb.append(":");
			sb.append(kitType.getName());
			sb.append("\n");
		}

		final String s = sb.toString();

		if (copy)
		{
			Clipboard.store(s);
			notifier.notify("Saved to clipboard.");
		}

		return plugin.getNEWLINE_SPLITTER()
			.withKeyValueSeparator(":")
			.split(s);
	}

	private TableField<TmorphSetsRecord, Integer> kitToField(KitType kitType)
	{
		switch (kitType)
		{
			case HELMET:
				return TMORPH_SETS.HELMET;
			case CAPE:
				return TMORPH_SETS.CAPE;
			case AMULET:
				return TMORPH_SETS.AMULET;
			case WEAPON:
				return TMORPH_SETS.WEAPON;
			case TORSO:
				return TMORPH_SETS.TORSO;
			case SHIELD:
				return TMORPH_SETS.SHIELD;
			case LEGS:
				return TMORPH_SETS.LEGS;
			case HANDS:
				return TMORPH_SETS.HANDS;
			case BOOTS:
				return TMORPH_SETS.BOOTS;
			default:
				return null;
		}
	}
}
