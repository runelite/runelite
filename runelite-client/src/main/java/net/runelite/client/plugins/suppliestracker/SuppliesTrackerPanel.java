/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Dylan White <Whitedylan7@gmail.com>
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
package net.runelite.client.plugins.suppliestracker;

import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;

import javax.inject.Inject;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;


class SuppliesTrackerPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// Handle loot logs
	private final JPanel logsContainer = new JPanel();

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallSuppliesUsedLabel = new JLabel();
	private final JLabel overallCostLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private final ItemManager itemManager;
	private int overallSuppliesUsed;
	private int overallCost;
	private final SuppliesTrackSetAmountRow setAmountRow = new SuppliesTrackSetAmountRow();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	SuppliesTrackerPanel(final ItemManager itemManager)
	{
		this.itemManager = itemManager;
		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		// Create layout panel for wrapping
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
		add(layoutPanel, BorderLayout.NORTH);

		// Create panel that will contain overall data
		overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(true);

		// Add icon and contents
		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
		overallSuppliesUsedLabel.setFont(FontManager.getRunescapeSmallFont());
		overallCostLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallSuppliesUsedLabel);
		overallInfo.add(overallCostLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		setAmountRow.setVisible(false);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			overallSuppliesUsed = 0;
			overallCost = 0;
			updateOverall();
			SuppliesTrackerPlugin.getInstance().clearSupplies();
			logsContainer.removeAll();
			logsContainer.repaint();
		});

		//Create reset menu
		final JMenu addSupply = new JMenu("Add Supply: ");
		final JMenu addPotion = new JMenu("Potion dose");
		final JMenu addFood = new JMenu("Food");
		final JMenu addAmmo = new JMenu("Ammo");
		final JMenu addRune = new JMenu("Runes");

		//Food menu items
		final JMenuItem lobster = new JMenuItem("Lobster");
		final JMenuItem swordfish = new JMenuItem("Swordfish");
		final JMenuItem potatoWithCheese = new JMenuItem("Potato with Cheese");
		final JMenuItem monkfish = new JMenuItem("Monkfish");
		final JMenuItem shark = new JMenuItem("Shark");
		final JMenuItem mantaRay = new JMenuItem("Manta Ray");
		final JMenuItem darkCrab = new JMenuItem("Dark Crab");
		final JMenuItem anglerfish = new JMenuItem("Anglerfish");

		//Potions Menu
		final JMenu combatPotions = new JMenu("Combat Potions");
		final JMenuItem cmbPotion = new JMenuItem("Combat Potion");
		final JMenuItem SuperCmbPotion = new JMenuItem("Super Combat Potion");
		final JMenu atkPotions = new JMenu("Attack Potions");
		final JMenuItem atkPotion = new JMenuItem("Attack Potion");
		final JMenuItem supAtkPotion = new JMenuItem("Super Attack Potion");
		final JMenu strPotions = new JMenu("Strength Potions");
		final JMenuItem strPotion = new JMenuItem("Strength Potion");
		final JMenuItem supStrPotion = new JMenuItem("Super Strength Potion");
		final JMenu defPotions = new JMenu("Defense Potions");
		final JMenuItem defPotion = new JMenuItem("Defense Potion");
		final JMenuItem supDefPotion = new JMenuItem("Super Defense Potion");
		final JMenu magicPotions = new JMenu("Magic Potions");
		final JMenuItem magicPotion = new JMenuItem("Magic Potion");
		final JMenuItem battleMagePotion = new JMenuItem("Battlemage Potion");
		final JMenu rangePotions = new JMenu("Range Potions");
		final JMenuItem rangePotion = new JMenuItem("Ranging Potion");
		final JMenuItem bastionPotion = new JMenuItem("Bastion Potion");
		final JMenu antifirePotions = new JMenu("Antifire Potions");
		final JMenuItem antifirePotion = new JMenuItem("Antifire Potion");
		final JMenuItem exAntifirePotion = new JMenuItem("Extended Antifire Potion");
		final JMenuItem supAntifirePotion = new JMenuItem("Super Antifire Potion");
		final JMenuItem exSupAntifirePotion = new JMenuItem("Extended Super Antifire Potion");
		final JMenu godBrews = new JMenu("God Brews");
		final JMenuItem saraBrew = new JMenuItem("Saradomin Brew");
		final JMenuItem zamBrew = new JMenuItem("Zamorak Brew");

		final JMenu RecovPotions = new JMenu("Recovery Potions");
		final JMenuItem statResPotion = new JMenuItem("Stat Restore Potion");
		final JMenuItem supStatResPotion = new JMenuItem("Super Restore Potion");
		final JMenuItem prayPotion = new JMenuItem("Prayer Potion");
		final JMenuItem sanSerPotion = new JMenuItem("Sanfew Serum");
		final JMenuItem energyPotion = new JMenuItem("Energy Potion");
		final JMenuItem supEnergyPotion = new JMenuItem("Super Energy Potion");
		final JMenuItem stamPotion = new JMenuItem("Stamina Potion");

		final JMenu curePotions = new JMenu("Cure Potions");
		final JMenuItem antiPPotion = new JMenuItem("Antipoison");
		final JMenuItem supAntiPPotion = new JMenuItem("Super Antipoison");
		final JMenuItem antidotePlusPotion = new JMenuItem("Antidote+");
		final JMenuItem antidotePlusPlusPotion = new JMenuItem("Antidote++");
		final JMenuItem antiVPotion = new JMenuItem("Anti-Venom");
		final JMenuItem antiVPlusPotion = new JMenuItem("Anti-Venom+");
		final JMenuItem RelBalmPotion = new JMenuItem("Relicym's Balm");

		//Arrows
		final JMenu arrows = new JMenu("Arrows");
		final JMenuItem bronzeArrow = new JMenuItem("Bronze Arrows");
		final JMenuItem ironArrow = new JMenuItem("Iron Arrows");
		final JMenuItem steelArrow = new JMenuItem("Steel Arrows");
		final JMenuItem mithrilArrow = new JMenuItem("Mithril Arrows");
		final JMenuItem adamantArrow = new JMenuItem("Adamant Arrows");
		final JMenuItem runeArrow = new JMenuItem("Rune Arrows");
		final JMenuItem broadArrow = new JMenuItem("Broad Arrows");
		final JMenuItem amethystArrow = new JMenuItem("Amethyst Arrows");
		final JMenuItem dragonArrow = new JMenuItem("Dragon Arrows");
		//Bolts
		final JMenu bolts = new JMenu("Bolts");
		final JMenu gem_Bolts = new JMenu("Gem Bolts");
		final JMenuItem opal_Bolts = new JMenuItem("Opal Bolts(e)");
		final JMenuItem jade_Bolts = new JMenuItem("Jade Bolts(e)");
		final JMenuItem pearl_Bolts = new JMenuItem("Pearl Bolts(e)");
		final JMenuItem topaz_Bolts = new JMenuItem("Topaz Bolts(e)");
		final JMenuItem sapphire_Bolts = new JMenuItem("Sapphire Bolts(e)");
		final JMenuItem emerald_Bolts = new JMenuItem("Emerald Bolts(e)");
		final JMenuItem ruby_Bolts = new JMenuItem("Ruby Bolts(e)");
		final JMenuItem diamond_Bolts = new JMenuItem("Diamond Bolts(e)");
		final JMenuItem dragonstone_Bolts = new JMenuItem("Dragonstone Bolts(e)");
		final JMenuItem onyx_Bolts = new JMenuItem("Onyx Bolts(e)");
		final JMenuItem bronze_Bolts = new JMenuItem("Bronze Bolts");
		final JMenuItem iron_Bolts = new JMenuItem("Iron Bolts");
		final JMenuItem bone_Bolts = new JMenuItem("Bone Bolts");
		final JMenuItem bolt_Rack = new JMenuItem("Bolt Rack");
		final JMenuItem steel_Bolts = new JMenuItem("Steel Bolts");
		final JMenuItem mithril_Bolts = new JMenuItem("Mithril Bolts");
		final JMenuItem adamant_Bolts = new JMenuItem("Adamant Bolts");
		final JMenuItem rune_Bolts = new JMenuItem("Rune Bolts");
		final JMenuItem broad_Bolts = new JMenuItem("Broad Bolts");
		final JMenu dragon_BoltsMenu = new JMenu("Dragon Bolts");
		final JMenuItem dragon_Bolts = new JMenuItem("Dragon Bolts");
		final JMenu dragon_Gem_Bolts = new JMenu("Dragon Gem Bolts");
		final JMenuItem opal_Dragon_Bolts = new JMenuItem("Opal Dragon Bolts(e)");
		final JMenuItem jade_dragon_Bolts = new JMenuItem("Jade Dragon Bolts(e)");
		final JMenuItem pearl_Dragon_Bolts = new JMenuItem("Pearl Dragon Bolts(e)");
		final JMenuItem topaz_Dragon_Bolts = new JMenuItem("Topaz Dragon Bolts(e)");
		final JMenuItem sapphire_Dragon_Bolts = new JMenuItem("Sapphire Dragon Bolts(e)");
		final JMenuItem emerald_Dragon_Bolts = new JMenuItem("Emerald Dragon Bolts(e)");
		final JMenuItem ruby_Dragon_Bolts = new JMenuItem("Ruby Dragon Bolts(e)");
		final JMenuItem diamond_Dragon_Bolts = new JMenuItem("Diamond Dragon Bolts(e)");
		final JMenuItem dragonstone_Dragon_Bolts = new JMenuItem("Dragonstone Dragon Bolts(e)");
		final JMenuItem onyx_Dragon_Bolts = new JMenuItem("Onyx Dragon Bolts(e)");
		//darts
		final JMenu Darts = new JMenu("Darts");
		final JMenuItem BronzeDarts = new JMenuItem("Bronze Darts");
		final JMenuItem IronDarts = new JMenuItem("Iron Darts");
		final JMenuItem SteelDarts = new JMenuItem("Steel Darts");
		final JMenuItem BlackDarts = new JMenuItem("Black Darts");
		final JMenuItem MithrilDarts = new JMenuItem("Mithril Darts");
		final JMenuItem AdamantDarts = new JMenuItem("Adamant Darts");
		final JMenuItem RuneDarts = new JMenuItem("Rune Darts");
		final JMenuItem DragonDarts = new JMenuItem("Dragon Darts");
		//Javelins
		final JMenu Javelins = new JMenu("Javelins");
		final JMenuItem BronzeJavelins = new JMenuItem("Bronze Javelins");
		final JMenuItem IronJavelins = new JMenuItem("Iron Javelins");
		final JMenuItem SteelJavelins = new JMenuItem("Steel Javelins");
		final JMenuItem MithrilJavelins = new JMenuItem("Mithril Javelins");
		final JMenuItem AdamantJavelins = new JMenuItem("Adamant Javelins");
		final JMenuItem RuneJavelins = new JMenuItem("Rune Javelins");
		final JMenuItem AmethystJavelins = new JMenuItem("Amethyst Javelins");
		final JMenuItem DragonJavelins = new JMenuItem("Dragon Javelins");
		//knives
		final JMenu Knives = new JMenu("Knives");
		final JMenuItem BronzeKnives = new JMenuItem("Bronze Knives");
		final JMenuItem IronKnives = new JMenuItem("Iron Knives");
		final JMenuItem SteelKnives = new JMenuItem("Steel Knives");
		final JMenuItem BlackKnives = new JMenuItem("Black Knives");
		final JMenuItem MithrilKnives = new JMenuItem("Mithril Knives");
		final JMenuItem AdamantKnives = new JMenuItem("Adamant Knives");
		final JMenuItem RuneKnives = new JMenuItem("Rune Knives");
		//Throwing Axes
		final JMenu ThrowingAxes = new JMenu("Throwing Axes");
		final JMenuItem BronzeThrowingAxes = new JMenuItem("Bronze Throwing Axes");
		final JMenuItem IronThrowingAxes = new JMenuItem("Iron Throwing Axes");
		final JMenuItem SteelThrowingAxes = new JMenuItem("Steel Throwing Axes");
		final JMenuItem MithrilThrowingAxes = new JMenuItem("Mithril Throwing Axes");
		final JMenuItem AdamantThrowingAxes = new JMenuItem("Adamant Throwing Axes");
		final JMenuItem RuneThrowingAxes = new JMenuItem("Rune Throwing Axes");
		final JMenuItem DragonThrowingAxes = new JMenuItem("Dragon Throwing Axes");
		//Runes
		final JMenuItem air = new JMenuItem("Air Rune");
		final JMenuItem astral = new JMenuItem("Astral Rune");
		final JMenuItem blood = new JMenuItem("Blood Rune");
		final JMenuItem body = new JMenuItem("Body Rune");
		final JMenuItem chaos = new JMenuItem("Chaos Rune");
		final JMenuItem cosmic = new JMenuItem("Cosmic Rune");
		final JMenuItem death = new JMenuItem("Death Rune");
		final JMenuItem dust = new JMenuItem("Dust Rune");
		final JMenuItem earth = new JMenuItem("Earth Rune");
		final JMenuItem fire = new JMenuItem("Fire Rune");
		final JMenuItem mind = new JMenuItem("Mind Rune");
		final JMenuItem mist = new JMenuItem("Mist Rune");
		final JMenuItem mud = new JMenuItem("Mud Rune");
		final JMenuItem nature = new JMenuItem("Nature Rune");
		final JMenuItem lava = new JMenuItem("Lava Rune");
		final JMenuItem law = new JMenuItem("Law Rune");
		final JMenuItem smoke = new JMenuItem("Smoke Rune");
		final JMenuItem soul = new JMenuItem("Soul Rune");
		final JMenuItem steam = new JMenuItem("Steam Rune");
		final JMenuItem water = new JMenuItem("Water Rune");
		final JMenuItem wrath = new JMenuItem("Wrath Rune");
		final JMenu chins = new JMenu("Chinchompas");
		final JMenuItem chinchompa = new JMenuItem("Grey Chinchompa");
		final JMenuItem redChinchompa = new JMenuItem("Red Chinchompa");
		final JMenuItem blackChinchompa = new JMenuItem("Black Chinchompa");

		//Add menu options
		//Food
		addFood.add(lobster).addActionListener(e ->
		{
			System.out.println(client.isClientThread());
			clientThread.invoke(() ->
			{
				try
				{

					System.out.println("Test1");
					SuppliesTrackerPlugin.getInstance().buildEntries(554);
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});


			clientThread.invokeLater(() ->
			{
				try
				{
					System.out.println("Test2");
					SuppliesTrackerPlugin.getInstance().buildEntries(554);
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});


			/*
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(379);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}*/
		});
		addFood.add(swordfish).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(373);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(potatoWithCheese).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(6705);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(monkfish).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(7946);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(shark).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(385);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(mantaRay).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(391);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(darkCrab).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11936);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addFood.add(anglerfish).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(13441);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		//Potions
		addPotion.add(combatPotions);

		combatPotions.add(cmbPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9739);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		combatPotions.add(SuperCmbPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(12695);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(atkPotions);
		atkPotions.add(atkPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2428);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		atkPotions.add(supAtkPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2436);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(strPotions);
		strPotions.add(strPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(113);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		strPotions.add(supStrPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2440);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(defPotions);
		defPotions.add(defPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2432);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		defPotions.add(supDefPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2442);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(magicPotions);
		magicPotions.add(magicPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(3040);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		magicPotions.add(battleMagePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(22449);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(rangePotions);
		rangePotions.add(rangePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2444);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		rangePotions.add(bastionPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(22461);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(antifirePotions);
		antifirePotions.add(antifirePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2452);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		antifirePotions.add(exAntifirePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11951);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		antifirePotions.add(supAntifirePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21978);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		antifirePotions.add(exSupAntifirePotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(22209);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		combatPotions.add(godBrews);
		godBrews.add(saraBrew).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(6685);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		godBrews.add(zamBrew).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2450);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addPotion.add(RecovPotions);
		RecovPotions.add(statResPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2430);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(supStatResPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(3024);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(prayPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2434);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(sanSerPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(10925);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(energyPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(3008);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(supEnergyPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(3016);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		RecovPotions.add(stamPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(12625);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		addPotion.add(curePotions);
		curePotions.add(antiPPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2446);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(supAntiPPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(2448);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(antidotePlusPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(5943);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(antidotePlusPlusPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(5952);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(antiVPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(12905);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(antiVPlusPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(12913);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		curePotions.add(sanSerPotion);
		curePotions.add(RelBalmPotion).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4842);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		//Arrows
		addAmmo.add(arrows);
		addAmmo.add(chins);
		chins.add(chinchompa).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(10033);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		chins.add(redChinchompa).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(10034);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		chins.add(blackChinchompa).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11959);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(bronzeArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(882);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(ironArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(884);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(steelArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(886);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(mithrilArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(888);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(adamantArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(890);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(runeArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(892);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(broadArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4150);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(amethystArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21326);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		arrows.add(dragonArrow).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11212);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		//Bolts
		addAmmo.add(bolts);
		bolts.add(gem_Bolts);
		gem_Bolts.add(opal_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9236);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(jade_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9237);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(pearl_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9238);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(topaz_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9239);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(sapphire_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9240);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(emerald_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9241);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(ruby_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9242);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(diamond_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9243);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(dragonstone_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9244);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		gem_Bolts.add(onyx_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9245);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		bolts.add(bronze_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(877);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(iron_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9140);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(bone_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(8882);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(bolt_Rack).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4740);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(steel_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9141);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(mithril_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9142);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(adamant_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9143);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(rune_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9144);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(broad_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11875);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		bolts.add(dragon_BoltsMenu);
		dragon_BoltsMenu.add(dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21905);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_BoltsMenu.add(dragon_Gem_Bolts);
		dragon_Gem_Bolts.add(opal_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21932);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(jade_dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21934);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(pearl_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21936);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(topaz_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21938);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(sapphire_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21940);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(emerald_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21942);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(ruby_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21944);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(diamond_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21946);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(dragonstone_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21948);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		dragon_Gem_Bolts.add(onyx_Dragon_Bolts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21950);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		//darts
		addAmmo.add(Darts);
		Darts.add(BronzeDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(806);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(IronDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(807);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(SteelDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(808);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(BlackDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(3093);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(MithrilDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(809);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(AdamantDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(810);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(RuneDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(811);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Darts.add(DragonDarts).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(11230);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		//Javelins
		addAmmo.add(Javelins);
		Javelins.add(BronzeJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(825);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(IronJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(826);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(SteelJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(827);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(MithrilJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(828);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(AdamantJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(829);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(RuneJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(830);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(AmethystJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21318);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		Javelins.add(DragonJavelins).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(19484);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		//Knives
		addAmmo.add(Knives);
		Knives.add(BronzeKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(864);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(IronKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(863);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(SteelKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(865);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(BlackKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(869);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(MithrilKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(866);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(AdamantKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(867);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		Knives.add(RuneKnives).addActionListener(e ->
	{
		try
		{
			SuppliesTrackerPlugin.getInstance().buildEntries(868);
		}
		catch
				(ExecutionException e1)
		{
			e1.printStackTrace();
		}
	});
		//Throwing Axes
		addAmmo.add(ThrowingAxes);
		ThrowingAxes.add(BronzeThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(800);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(IronThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(801);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(SteelThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(802);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(MithrilThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(803);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(AdamantThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(804);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(RuneThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(805);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		ThrowingAxes.add(DragonThrowingAxes).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(20849);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		//Runes
		addRune.add(air).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(556);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(astral).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(9075);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(blood).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(565);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(body).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(559);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(chaos).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(562);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(cosmic).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(564);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(death).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(560);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(dust).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4696);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(earth).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(557);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(fire).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(554);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(mind).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(558);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(mist).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4695);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(mud).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4698);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(nature).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(561);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(lava).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(ItemID.LAVA_RUNE);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(law).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(563);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(smoke).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4697);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(soul).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(566);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(steam).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(4694);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(water).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(555);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});
		addRune.add(wrath).addActionListener(e ->
		{
			try
			{
				SuppliesTrackerPlugin.getInstance().buildEntries(21880);
			}
			catch
					(ExecutionException e1)
			{
				e1.printStackTrace();
			}
		});

		addSupply.add(addAmmo);
		addSupply.add(addFood);
		addSupply.add(addPotion);
		addSupply.add(addRune);

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		popupMenu.add(addSupply);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create Supply Rows wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(setAmountRow);
		layoutPanel.add(logsContainer);


	}


	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	private static String htmlLabel(String key, long value)
	{
		final String valueStr = StackFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	void addRow(HashMap<Integer, SuppliesTrackerItemEntry> supplies) throws ExecutionException
	{
		//Reset
		logsContainer.removeAll();
		overallCost = 0;
		overallSuppliesUsed = 0;

		//Iterate through supplies used and build rows
		for (int itemId: supplies.keySet())
		{
			SuppliesTrackerItemEntry tempSuppleEntry = supplies.get(itemId);
			String name = tempSuppleEntry.getName();
			int originalId = itemId;
			if (name.contains("(4)"))
			{
				name = name.replace("(4)", "(1)");
				itemId = getSingleDose(name);
			}
			else if (name.toLowerCase().contains("pizza") || name.toLowerCase().contains(" pie"))
			{
				itemId = getHalf(itemId);
			}
			else if (name.toLowerCase().contains("cake"))
			{
				itemId = getSlice(itemId);
			}
			long cost = tempSuppleEntry.getPrice();
			int quantity = tempSuppleEntry.getQuantity();
			final SuppliesTrackRow row = new SuppliesTrackRow(itemManager.getImage(itemId, 1, false), name, quantity, cost, originalId);
			logsContainer.add(row);
			overallSuppliesUsed += quantity;
			overallCost += cost;

			//Create delete row menu
			final JMenuItem reset = new JMenuItem("Delete");
			reset.addActionListener((ActionEvent e) ->
			{
				overallCost -= row.totalCost;
				overallSuppliesUsed -= row.quantity;
				SuppliesTrackerPlugin.getInstance().clearItem(row.itemId);
				updateOverall();
				logsContainer.remove(row);
				logsContainer.repaint();
			});

			//Create set amount menu
			final JMenuItem setAmount = new JMenuItem("Set Amount");
			setAmount.addActionListener((ActionEvent e) ->
			{
				setAmountRow(row);
				updateOverall();
			});



			// Create popup menu
			final JPopupMenu popupMenu = new JPopupMenu();
			popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
			popupMenu.add(reset);
			popupMenu.add(setAmount);
			row.setComponentPopupMenu(popupMenu);

		}
		updateOverall();
		logsContainer.validate();
		logsContainer.repaint();



	}

	private void setAmountRow(SuppliesTrackRow row)
	{
		setAmountRow.setVisible(true);
		setAmountRow.amount.setText("0");

		KeyAdapter keyAdapter = new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
					int c = e.getKeyCode();

					if (c == KeyEvent.VK_ENTER)
					{
						SuppliesTrackerPlugin.getInstance().setAmount(row.itemId, Integer.valueOf(setAmountRow.amount.getText().replace(",", "")));
						((JFormattedTextField)e.getSource()).removeKeyListener( this );
						setAmountRow.setVisible(false);
					}

					if (c == KeyEvent.VK_BACK_SPACE && setAmountRow.amount.getText().length() == 1)
					{
						setAmountRow.amount.setText("0");
					}
			}
		};
		setAmountRow.amount.addKeyListener(keyAdapter);
	}

	//Switches full cake ids to get the image for slice
	private int getSlice(int itemId)
	{
		switch (itemId)
		{
			case 1891:
				itemId = 1895;
				break;
			case 1897:
				itemId = 1901;
				break;
		}
		return itemId;
	}

	//Switches full pizza and pie ids to get the image for half
	private int getHalf(int itemId)
	{
		switch (itemId)
		{
			case 2297:
				itemId = 2299;
				break;
			case 2293:
				itemId = 2295;
				break;
			case 2301:
				itemId = 2303;
				break;
			case 2289:
				itemId = 2291;
				break;
			case 2325:
				itemId = 2333;
				break;
			case 7178:
				itemId = 7180;
				break;
			case 7218:
				itemId = 7220;
				break;
			case 7188:
				itemId = 7190;
				break;
			case 19662:
				itemId = 19659;
				break;
			case 21690:
				itemId = 21687;
				break;
			case 7198:
				itemId = 7200;
				break;
			case 7208:
				itemId = 7210;
				break;
			case 2323:
				itemId = 2335;
				break;
			case 2327:
				itemId = 2331;
				break;

		}
		return itemId;
	}

	private int getSingleDose(String name) throws ExecutionException
	{
		int itemId = 0;
		List<net.runelite.http.api.item.Item> items = itemManager.searchForItem(name).getItems();
		for (net.runelite.http.api.item.Item item: items)
		{
			if (item.getName().contains(name))
			{
				itemId = item.getId();
			}
		}
		return itemId;
	}

	private void updateOverall()
	{
		overallSuppliesUsedLabel.setText(htmlLabel("Total Supplies: ", overallSuppliesUsed));
		overallCostLabel.setText(htmlLabel("Total Cost: ", overallCost));
	}
}
