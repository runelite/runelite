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
package net.runelite.client.ui;

import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SidebarFoldersTest
{
	private static final class PanelA extends PluginPanel
	{
	}

	private static final class PanelB extends PluginPanel
	{
	}

	private static final class PanelC extends PluginPanel
	{
	}

	private static final class PanelD extends PluginPanel
	{
	}

	private static final class PanelZ extends PluginPanel
	{
	}

	@Test
	public void folderSitsAtHighestPriorityChildUntilMoved()
	{
		NavigationButton a = button(new PanelA(), 0, "A");
		NavigationButton b = button(new PanelB(), 1, "B");
		NavigationButton c = button(new PanelC(), 2, "C");
		NavigationButton d = button(new PanelD(), 3, "D");
		List<NavigationButton> loaded = List.of(a, b, c, d);

		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("  Stuff  ", b);
		assertNotNull(group);
		assertEquals("Stuff", group.getName());
		assertTrue(folders.moveToFolder(group, c));

		assertEquals(List.of("A", "folder:Stuff", "B", "C", "D"), labels(folders.buildSlots(loaded)));

		assertTrue(folders.moveFolder(group, 1, loaded));
		assertEquals(List.of("A", "D", "folder:Stuff", "B", "C"), labels(folders.buildSlots(loaded)));

		assertTrue(folders.moveChild(c, -1, loaded));
		assertEquals(List.of("A", "D", "folder:Stuff", "C", "B"), labels(folders.buildSlots(loaded)));
	}

	@Test
	public void collapsedFolderHidesChildren()
	{
		NavigationButton a = button(new PanelA(), 0, "A");
		NavigationButton b = button(new PanelB(), 1, "B");
		List<NavigationButton> loaded = List.of(a, b);

		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", b);
		group.toggleExpanded();

		assertEquals(List.of("A", "folder:Stuff"), labels(folders.buildSlots(loaded)));
	}

	@Test
	public void manualFolderOrderStaysAheadOfLaterPlugins()
	{
		NavigationButton a = button(new PanelA(), 5, "A");
		NavigationButton b = button(new PanelB(), 10, "B");
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", b);

		assertTrue(folders.moveFolder(group, -1, List.of(a, b)));

		NavigationButton z = button(new PanelZ(), 0, "Z");
		assertTrue(folders.reconcile(List.of(a, b, z)));
		assertEquals(List.of("folder:Stuff", "B", "Z", "A"), labels(folders.buildSlots(List.of(a, b, z))));
	}

	@Test
	public void folderIconOnlyAppliesToMembers()
	{
		NavigationButton a = button(new PanelA(), 0, "A");
		NavigationButton b = button(new PanelB(), 1, "B");
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", b);

		assertFalse(folders.setFolderIcon(a));
		assertTrue(folders.setFolderIcon(b));
		assertEquals(SidebarFolders.keyOf(b), group.getIconKey());
		assertFalse(folders.setFolderIcon(b));
		assertTrue(folders.clearFolderIcon(b));
		assertNull(group.getIconKey());

		assertTrue(folders.setFolderIcon(b));
		assertTrue(folders.removeFromFolder(b, List.of(a, b)));
		assertNull(group.getIconKey());
		assertEquals(List.of("A", "B", "folder:Stuff"), labels(folders.buildSlots(List.of(a, b))));
	}

	@Test
	public void deleteFolderRestoresPriorityOrder()
	{
		NavigationButton a = button(new PanelA(), 0, "A");
		NavigationButton b = button(new PanelB(), 1, "B");
		NavigationButton c = button(new PanelC(), 2, "C");
		List<NavigationButton> loaded = List.of(a, b, c);
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", c);
		assertTrue(folders.moveToFolder(group, b));
		folders.deleteFolder(group, loaded);

		assertEquals(List.of("A", "B", "C"), labels(folders.buildSlots(loaded)));
		assertTrue(folders.getGroups().isEmpty());
	}

	@Test
	public void layoutSurvivesJson()
	{
		NavigationButton b = button(new PanelB(), 1, "B");
		NavigationButton c = button(new PanelC(), 2, "C");
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", b);
		assertTrue(folders.moveToFolder(group, c));
		assertTrue(folders.setFolderIcon(c));
		assertTrue(folders.moveChild(c, -1, List.of(b, c)));

		Gson gson = new Gson();
		SidebarFolders loaded = SidebarFolders.fromJson(gson, folders.toJson(gson));
		assertEquals(1, loaded.getGroups().size());
		PluginGroup restored = loaded.getGroups().get(0);
		assertEquals("Stuff", restored.getName());
		assertEquals(SidebarFolders.keyOf(c), restored.getIconKey());
		assertTrue(restored.isChildOrderCustom());
		assertEquals(List.of("folder:Stuff", "C", "B"), labels(loaded.buildSlots(List.of(b, c))));
		assertTrue(SidebarFolders.fromJson(gson, "{").getGroups().isEmpty());
	}

	@Test
	public void folderIconHasGreyBorder()
	{
		BufferedImage source = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
		BufferedImage icon = FolderButton.pluginIcon(source, true);
		assertEquals(16, icon.getWidth());
		assertEquals(16, icon.getHeight());
		assertEquals(ColorScheme.LIGHT_GRAY_COLOR.getRGB(), icon.getRGB(0, 0));

		BufferedImage folder = FolderButton.defaultIcon(false);
		assertEquals(16, folder.getWidth());
		assertEquals(16, folder.getHeight());
	}

	@Test
	public void sidebarIdReplacesSavedClassName()
	{
		NavigationButton saved = button(new PanelB(), 1, "Notes");
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", saved);
		assertTrue(folders.setFolderIcon(saved));
		assertEquals(saved.getPanel().getClass().getName(), group.getChildren().get(0));

		NavigationButton notes = NavigationButton.builder()
			.panel(new PanelB())
			.sidebarId("notes")
			.priority(1)
			.tooltip("Notes")
			.build();

		assertTrue(folders.hasFolderIcon(notes));
		assertTrue(folders.reconcile(List.of(notes)));
		assertEquals(List.of("notes"), group.getChildren());
		assertEquals("notes", group.getIconKey());
		assertEquals(List.of("folder:Stuff", "Notes"), labels(folders.buildSlots(List.of(notes))));
		assertFalse(folders.reconcile(List.of(notes)));
	}

	@Test
	public void resetClearsFolders()
	{
		NavigationButton a = button(new PanelA(), 0, "A");
		SidebarFolders folders = new SidebarFolders();
		PluginGroup group = folders.createFolder("Stuff", a);
		assertTrue(group.isExpanded());

		PluginGroup stale = new PluginGroup();
		stale.setId(group.getId());
		assertTrue(folders.toggleExpanded(stale));
		assertFalse(group.isExpanded());

		folders.reset();
		assertTrue(folders.getGroups().isEmpty());
		assertEquals(List.of("A"), labels(folders.buildSlots(List.of(a))));
	}

	@Test
	public void blankFolderNameIsRejected()
	{
		SidebarFolders folders = new SidebarFolders();
		assertNull(folders.createFolder("   ", button(new PanelA(), 0, "A")));
	}

	private static NavigationButton button(PluginPanel panel, int priority, String tooltip)
	{
		return NavigationButton.builder()
			.panel(panel)
			.priority(priority)
			.tooltip(tooltip)
			.build();
	}

	private static List<String> labels(List<SidebarSlot> slots)
	{
		List<String> labels = new ArrayList<>();
		for (SidebarSlot slot : slots)
		{
			if (slot.isFolder())
			{
				labels.add("folder:" + slot.getFolder().getName());
			}
			else
			{
				labels.add(slot.getButton().getTooltip());
			}
		}
		return labels;
	}
}
