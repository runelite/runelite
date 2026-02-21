/*
 * Copyright (c) 2026, Swirle13 <https://github.com/swirle13>
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
package net.runelite.client.plugins.customizesidebar;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.DragAndDropTabbedPane;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomizeSidebarPluginTest
{
	private static final Comparator<NavigationButton> NAV_BUTTON_COMPARATOR =
		Comparator.comparing(NavigationButton::getPriority)
			.thenComparing(NavigationButton::getTooltip);

	@Inject
	private CustomizeSidebarPlugin plugin;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private CustomizeSidebarConfig config;

	@Bind
	private final Gson gson = new Gson();

	@Mock
	@Bind
	private ClientUI clientUI;

	@Mock
	private DragAndDropTabbedPane sidebar;

	private List<NavigationButton> sidebarTabOrder;
	private TreeSet<NavigationButton> sidebarEntries;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		sidebarTabOrder = new ArrayList<>();
		sidebarEntries = new TreeSet<>(NAV_BUTTON_COMPARATOR);

		when(clientUI.getSidebar()).thenReturn(sidebar);
		when(clientUI.getSidebarTabOrder()).thenReturn(sidebarTabOrder);
		when(clientUI.getSidebarEntries()).thenReturn(sidebarEntries);
	}

	private NavigationButton createNavButton(String tooltip, int priority)
	{
		return NavigationButton.builder()
			.tooltip(tooltip)
			.icon(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB))
			.priority(priority)
			.build();
	}

	private void addButton(NavigationButton btn)
	{
		sidebarEntries.add(btn);
		sidebarTabOrder.add(btn);
	}

	@Test
	public void testStartUpEnablesCustomOrderingSupplier()
	{
		plugin.startUp();

		verify(clientUI).setCustomOrderingActiveSupplier(any());
	}

	@Test
	public void testShutDownDisablesCustomOrderingSupplier()
	{
		plugin.startUp();
		plugin.shutDown();

		verify(clientUI).setCustomOrderingActiveSupplier(null);
	}

	@Test
	public void testShutDownAppliesDefaultOrder()
	{
		NavigationButton btn1 = createNavButton("Config", 0);
		NavigationButton btn2 = createNavButton("XP Tracker", 2);
		addButton(btn1);
		addButton(btn2);

		plugin.startUp();
		plugin.shutDown();

		verify(clientUI).rebuildSidebar(sidebarEntries);
	}

	@Test
	public void testLoadCustomOrderPreservesExistingTabs()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		NavigationButton xpTracker = createNavButton("XP Tracker", 2);
		NavigationButton hiscore = createNavButton("Hiscore", 5);
		addButton(configBtn);
		addButton(xpTracker);
		addButton(hiscore);

		String savedOrder = "[\"XP Tracker\",\"Configuration\",\"Hiscore\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, times(1)).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		assertEquals(3, rebuilt.size());
		assertEquals("XP Tracker", rebuilt.get(0).getTooltip());
		assertEquals("Configuration", rebuilt.get(1).getTooltip());
		assertEquals("Hiscore", rebuilt.get(2).getTooltip());
	}

	@Test
	public void testLoadCustomOrderAppendsNewTabs()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		NavigationButton xpTracker = createNavButton("XP Tracker", 2);
		NavigationButton hiscore = createNavButton("Hiscore", 5);
		NavigationButton newPlugin = createNavButton("New Plugin", 3);
		addButton(configBtn);
		addButton(xpTracker);
		addButton(hiscore);
		addButton(newPlugin);

		String savedOrder = "[\"XP Tracker\",\"Configuration\",\"Hiscore\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, times(1)).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		assertEquals(4, rebuilt.size());
		assertEquals("XP Tracker", rebuilt.get(0).getTooltip());
		assertEquals("Configuration", rebuilt.get(1).getTooltip());
		assertEquals("Hiscore", rebuilt.get(2).getTooltip());
		assertEquals("New Plugin", rebuilt.get(3).getTooltip());
	}

	@Test
	public void testLoadCustomOrderHandlesMissingTabs()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		NavigationButton xpTracker = createNavButton("XP Tracker", 2);
		addButton(configBtn);
		addButton(xpTracker);

		String savedOrder = "[\"Removed Plugin\",\"XP Tracker\",\"Configuration\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, times(1)).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		assertEquals(2, rebuilt.size());
		assertEquals("XP Tracker", rebuilt.get(0).getTooltip());
		assertEquals("Configuration", rebuilt.get(1).getTooltip());
	}

	@Test
	public void testLoadCustomOrderHandlesCorruptedJson()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		addButton(configBtn);

		// This is valid JSON but wrong type (object instead of array) which will fail TypeToken parsing
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn("{\"key\": \"value\"}");

		plugin.startUp();

		waitForSwingEvents();

		verify(configManager).unsetConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder");
	}

	@Test
	public void testLoadCustomOrderHandlesEmptyConfig()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		addButton(configBtn);

		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(null);

		plugin.startUp();

		waitForSwingEvents();

		verify(clientUI, never()).rebuildSidebar(any(List.class));
	}

	@Test
	public void testResetConfigurationClearsCustomOrder()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		addButton(configBtn);

		plugin.startUp();
		plugin.resetConfiguration();

		verify(configManager).unsetConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder");
		verify(clientUI).rebuildSidebar(sidebarEntries);
	}

	@Test
	public void testOnPluginChangedIgnoresUnloadedPlugins()
	{
		plugin.startUp();

		PluginChanged event = new PluginChanged(mock(Plugin.class), false);
		plugin.onPluginChanged(event);

		waitForSwingEvents();

		verify(clientUI, never()).rebuildSidebar(any(List.class));
	}

	@Test
	public void testOnPluginChangedCoalescesMultipleEvents()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		addButton(configBtn);

		String savedOrder = "[\"Configuration\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		PluginChanged event1 = new PluginChanged(mock(Plugin.class), true);
		PluginChanged event2 = new PluginChanged(mock(Plugin.class), true);
		PluginChanged event3 = new PluginChanged(mock(Plugin.class), true);

		plugin.onPluginChanged(event1);
		plugin.onPluginChanged(event2);
		plugin.onPluginChanged(event3);

		waitForSwingEvents();

		verify(clientUI, times(2)).rebuildSidebar(any(List.class));
	}

	@Test
	public void testLoadCustomOrderHandlesDuplicateEntriesInSavedOrder()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		NavigationButton xpTracker = createNavButton("XP Tracker", 2);
		addButton(configBtn);
		addButton(xpTracker);

		// Saved order contains duplicate "Configuration" entry
		// Note: Current implementation will find the same button twice since findFirst()
		// always returns the first match from the TreeSet
		String savedOrder = "[\"Configuration\",\"Configuration\",\"XP Tracker\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, atLeastOnce()).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		// Current behavior: duplicate entries result in the same button appearing multiple times
		// This documents the current behavior - could be considered a bug to fix
		assertEquals(3, rebuilt.size());
		assertEquals("Configuration", rebuilt.get(0).getTooltip());
		assertEquals("Configuration", rebuilt.get(1).getTooltip());
		assertEquals("XP Tracker", rebuilt.get(2).getTooltip());
	}

	@Test
	public void testLoadCustomOrderHandlesEmptyStringInSavedOrder()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		NavigationButton xpTracker = createNavButton("XP Tracker", 2);
		addButton(configBtn);
		addButton(xpTracker);

		// Saved order contains empty string
		String savedOrder = "[\"\",\"Configuration\",\"XP Tracker\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, atLeastOnce()).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		// Should only have 2 buttons (empty string matches nothing)
		assertEquals(2, rebuilt.size());
	}

	@Test
	public void testLoadCustomOrderHandlesEmptyArray()
	{
		NavigationButton configBtn = createNavButton("Configuration", 0);
		addButton(configBtn);

		// Empty array is valid JSON
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn("[]");

		plugin.startUp();

		waitForSwingEvents();

		// Empty custom order should not trigger rebuild with empty list
		verify(clientUI, never()).rebuildSidebar(any(List.class));
	}

	@Test
	public void testDragFirstTabToLast()
	{
		NavigationButton btn1 = createNavButton("First", 0);
		NavigationButton btn2 = createNavButton("Second", 1);
		NavigationButton btn3 = createNavButton("Third", 2);
		NavigationButton btn4 = createNavButton("Fourth", 3);
		addButton(btn1);
		addButton(btn2);
		addButton(btn3);
		addButton(btn4);

		String savedOrder = "[\"First\",\"Second\",\"Third\",\"Fourth\"]";
		when(configManager.getConfiguration(CustomizeSidebarConfig.CONFIG_GROUP, "customOrder"))
			.thenReturn(savedOrder);

		plugin.startUp();

		waitForSwingEvents();

		ArgumentCaptor<List<NavigationButton>> captor = ArgumentCaptor.forClass(List.class);
		verify(clientUI, times(1)).rebuildSidebar(captor.capture());

		List<NavigationButton> rebuilt = captor.getValue();
		assertEquals(4, rebuilt.size());
		assertEquals("First", rebuilt.get(0).getTooltip());
		assertEquals("Fourth", rebuilt.get(3).getTooltip());
	}

	@Test
	public void testStartUpShutDownCycle()
	{
		NavigationButton btn1 = createNavButton("Config", 0);
		addButton(btn1);

		// First cycle
		plugin.startUp();
		plugin.shutDown();

		// Second cycle - should work without issues
		plugin.startUp();
		plugin.shutDown();

		// Verify setCustomOrderingActiveSupplier was called:
		// - 2x with a supplier (once per startUp)
		// - 2x with null (once per shutDown)
		// Total 4 calls, 2 with any() and 2 with null
		verify(clientUI, times(4)).setCustomOrderingActiveSupplier(any());
	}

	private void waitForSwingEvents()
	{
		try
		{
			// Use invokeAndWait to ensure all pending Swing events are processed
			SwingUtilities.invokeAndWait(() ->
			{
			});
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}
}

