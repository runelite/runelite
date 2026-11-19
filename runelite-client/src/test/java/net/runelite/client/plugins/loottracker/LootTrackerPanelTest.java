/*
 * Copyright (c) 2026
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
package net.runelite.client.plugins.loottracker;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

public class LootTrackerPanelTest
{
	private LootTrackerPanel panel;
	private LootTrackerPlugin plugin;
	private ItemManager itemManager;
	private IconTextField sourceSearch;
	private IconTextField itemSearch;

	@Before
	public void setUp() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			plugin = mock(LootTrackerPlugin.class);
			itemManager = mock(ItemManager.class);
			when(itemManager.getImage(anyInt(), anyInt(), anyBoolean()))
				.thenAnswer(invocation -> new AsyncBufferedImage(null, 1, 1, BufferedImage.TYPE_INT_ARGB));
			LootTrackerConfig config = mock(LootTrackerConfig.class);
			when(config.priceType()).thenReturn(LootTrackerPriceType.GRAND_EXCHANGE);
			panel = new LootTrackerPanel(plugin, itemManager, config);
			List<IconTextField> searches = components(panel, IconTextField.class);
			sourceSearch = searches.get(0);
			itemSearch = searches.get(1);
			panel.addRecords(Arrays.asList(
				record("Fire giant", item(1, "Rune scimitar"), item(2, "Coins")),
				record("Hill giant", item(2, "Coins")),
				record("Barrows", item(3, "Death rune"))));
		});
	}

	@Test
	public void sourceSearchIsPartialCaseInsensitiveAndTrimmed() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			search("  FIRE  ", "");
			assertSources("Fire giant");
			search("", "");
			assertSources("Fire giant", "Hill giant", "Barrows");
		});
	}

	@Test
	public void itemSearchCombinesWithSourceSearchAndHandlesNoResults() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			search("", "  COIN  ");
			assertSources("Fire giant", "Hill giant");
			search("fire", "coins");
			assertSources("Fire giant");
			search("fire", "death");
			assertSources();
			assertEquals(1, components(panel, PluginErrorPanel.class).size());
			search("", "death");
			assertSources("Barrows");
			assertTrue(components(panel, PluginErrorPanel.class).isEmpty());
		});
	}

	@Test
	public void matchingItemsHaveOrangeBordersAndClearingRemovesThem() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			search("", "rune");
			assertHighlightedItems("Rune scimitar", "Death rune");
			search("fire", "rune");
			assertHighlightedItems("Rune scimitar");
			search("fire", "coins");
			assertHighlightedItems("Coins");
			search("fire", "");
			assertHighlightedItems();
		});
	}

	@Test
	public void typingIsDebouncedAndUsesLatestTextFromBothFields() throws Exception
	{
		CountDownLatch applied = new CountDownLatch(1);
		SwingUtilities.invokeAndWait(() ->
		{
			LootTrackerBox barrows = visibleBoxes().stream()
				.filter(box -> box.matches("Barrows", LootRecordType.NPC)).findFirst().get();
			barrows.addComponentListener(new ComponentAdapter()
			{
				@Override
				public void componentHidden(ComponentEvent event)
				{
					applied.countDown();
				}
			});
			sourceSearch.setText("hill");
			itemSearch.setText("coins");
			sourceSearch.setText("fire");
			itemSearch.setText("scimitar");
			assertSources("Fire giant", "Hill giant", "Barrows");
		});
		assertTrue("Debounced search did not run", applied.await(5, TimeUnit.SECONDS));
		SwingUtilities.invokeAndWait(() ->
		{
			assertSources("Fire giant");
			assertHighlightedItems("Rune scimitar");
		});
	}

	@Test
	public void enterAppliesBothFieldsImmediately() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			sourceSearch.setText("fire");
			itemSearch.setText("coins");
			components(itemSearch, JTextField.class).get(0).postActionEvent();
			assertSources("Fire giant");
			assertHighlightedItems("Coins");
		});
	}

	@Test
	public void searchesReuseComponentsAndPreserveCollapseState() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			List<LootTrackerBox> boxes = components(panel, LootTrackerBox.class);
			List<JPanel> slots = components(panel, JPanel.class);
			List<JLabel> labels = components(panel, JLabel.class);
			List<Icon> icons = new ArrayList<>();
			labels.forEach(label -> icons.add(label.getIcon()));
			LootTrackerBox fireGiant = boxes.stream()
				.filter(box -> box.matches("Fire giant", LootRecordType.NPC)).findFirst().get();
			fireGiant.collapse();
			clearInvocations(itemManager);
			search("fire", "scimitar");
			search("hill", "coins");
			search("", "");
			assertSources("Fire giant", "Hill giant", "Barrows");
			assertEquals(boxes, components(panel, LootTrackerBox.class));
			assertEquals(slots, components(panel, JPanel.class));
			assertEquals(labels, components(panel, JLabel.class));
			for (int i = 0; i < labels.size(); i++)
			{
				assertSame(icons.get(i), labels.get(i).getIcon());
			}
			assertTrue(fireGiant.isCollapsed());
			verifyNoInteractions(itemManager);
		});
	}

	@Test
	public void filteredTotalsRespectIgnoredLootAndVisibilityToggle() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			search("giant", "coins");
			assertTotals(2, 300, 180);
			LootTrackerBox fireGiant = visibleBoxes().stream()
				.filter(box -> box.matches("Fire giant", LootRecordType.NPC)).findFirst().get();
			fireGiant.getRecord().getItems()[1].setIgnored(true);
			panel.rebuild();
			assertSources("Hill giant");
			assertTotals(1, 100, 60);
			search("giant", "");
			assertTotals(2, 200, 120);
			when(plugin.isEventIgnored("Hill giant")).thenReturn(true);
			panel.rebuild();
			assertTotals(1, 100, 60);
			components(panel, JToggleButton.class).stream()
				.filter(button -> !(button instanceof JRadioButton))
				.findFirst().get().doClick();
			assertSources("Fire giant", "Hill giant");
			assertTotals(2, 300, 180);
		});
	}

	@Test
	public void individualKillSearchRespectsDisplayAndCacheLimits() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			panel.clearRecords();
			panel.rebuild();
			for (int i = 0; i < 1024; i++)
			{
				LootTrackerItem drop = i == 0 ? item(7, "Rare drop") : item(2, "Coins");
				panel.add("Fire giant", LootRecordType.NPC, 86, new LootTrackerItem[]{drop}, 1);
			}
			components(panel, JRadioButton.class).stream()
				.filter(button -> "Show each kill separately".equals(button.getToolTipText()))
				.findFirst().get().doClick();
			assertEquals(1024, components(panel, LootTrackerBox.class).size());
			assertEquals(500, visibleBoxes().size());
			assertTotals(1024, 102400, 61440);
			// A matching kill outside the unfiltered display limit remains searchable.
			search("fire", "rare");
			assertSources("Fire giant");
			LootTrackerBox oldest = visibleBoxes().get(0);
			assertHighlightedItems("Rare drop");
			panel.add("Fire giant", LootRecordType.NPC, 86, new LootTrackerItem[]{item(2, "Coins")}, 1);
			assertSources();
			assertEquals(1024, components(panel, LootTrackerBox.class).size());
			assertFalse(components(panel, LootTrackerBox.class).contains(oldest));
			search("fire", "coins");
			assertEquals(500, visibleBoxes().size());
			assertTotals(1024, 102400, 61440);
		});
	}

	@Test
	public void liveLootUpdatesHiddenSourceWithoutRebuildingOtherSources() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			LootTrackerBox hillGiant = visibleBoxes().stream()
				.filter(box -> box.matches("Hill giant", LootRecordType.NPC)).findFirst().get();
			search("", "scimitar");
			assertSources("Fire giant");
			LootTrackerBox fireGiant = visibleBoxes().get(0);
			List<JLabel> fireLabels = components(fireGiant, JLabel.class);
			assertFalse(hillGiant.isVisible());
			panel.add("Hill giant", LootRecordType.NPC, 28, new LootTrackerItem[]{item(1, "Rune scimitar")}, 1);
			assertSources("Fire giant", "Hill giant");
			assertTrue(hillGiant.isVisible());
			assertEquals(fireLabels, components(fireGiant, JLabel.class));
			assertHighlightedItems("Rune scimitar", "Rune scimitar");
		});
	}

	@Test
	public void detailViewRestrictsSearchWithoutRemovingOtherRecords() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			search("fire", "");
			LootTrackerBox box = visibleBoxes().get(0);
			for (Component component : box.getComponentPopupMenu().getComponents())
			{
				if (component instanceof JMenuItem && "View details".equals(((JMenuItem) component).getText()))
				{
					((JMenuItem) component).doClick();
				}
			}
			search("", "death");
			assertSources();
			search("", "");
			assertSources("Fire giant");
			assertTrue(panel.hasRecord(LootRecordType.NPC, "Barrows"));
		});
	}

	private void search(String source, String item)
	{
		sourceSearch.setText(source);
		itemSearch.setText(item);
		components(sourceSearch, JTextField.class).get(0).postActionEvent();
	}

	private void assertHighlightedItems(String... names)
	{
		List<String> highlighted = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		visibleBoxes().forEach(box -> labels.addAll(components(box, JLabel.class)));
		for (JLabel label : labels)
		{
			if (label.getParent() instanceof JPanel && ((JPanel) label.getParent()).getBorder() instanceof LineBorder)
			{
				LineBorder border = (LineBorder) ((JPanel) label.getParent()).getBorder();
				assertEquals(ColorScheme.BRAND_ORANGE, border.getLineColor());
				assertEquals(2, border.getThickness());
				String tooltip = label.getToolTipText();
				highlighted.add(tooltip.substring("<html>".length(), tooltip.indexOf(" x ")));
			}
		}
		List<String> expected = new ArrayList<>(Arrays.asList(names));
		expected.sort(String::compareTo);
		highlighted.sort(String::compareTo);
		assertEquals(expected, highlighted);
	}

	private void assertSources(String... titles)
	{
		List<LootTrackerBox> boxes = visibleBoxes();
		assertEquals(titles.length, boxes.size());
		for (String title : titles)
		{
			assertTrue(boxes.stream().anyMatch(box -> box.matches(title, LootRecordType.NPC)));
		}
	}

	private void assertTotals(long kills, long ge, long ha)
	{
		List<JLabel> labels = components(panel, JLabel.class);
		assertTrue(labels.stream().anyMatch(label -> label.getText().contains("Total count: ")
			&& label.getText().contains(">" + QuantityFormatter.quantityToStackSize(kills) + "</span>")));
		String tooltip = "<html>Total GE price: " + QuantityFormatter.formatNumber(ge)
			+ "<br>Total HA price: " + QuantityFormatter.formatNumber(ha) + "</html>";
		assertTrue(labels.stream().anyMatch(label -> tooltip.equals(label.getToolTipText())));
	}

	private List<LootTrackerBox> visibleBoxes()
	{
		List<LootTrackerBox> result = components(panel, LootTrackerBox.class);
		result.removeIf(box -> !box.isVisible());
		return result;
	}

	private static LootTrackerRecord record(String title, LootTrackerItem... items)
	{
		return new LootTrackerRecord(title, "", LootRecordType.NPC, items, 1);
	}

	private static LootTrackerItem item(int id, String name)
	{
		return new LootTrackerItem(id, name, 1, 100, 60, false);
	}

	private static <T> List<T> components(Container parent, Class<T> type)
	{
		List<T> result = new ArrayList<>();
		for (Component child : parent.getComponents())
		{
			if (type.isInstance(child))
			{
				result.add(type.cast(child));
			}
			if (child instanceof Container)
			{
				result.addAll(components((Container) child, type));
			}
		}
		return result;
	}
}
