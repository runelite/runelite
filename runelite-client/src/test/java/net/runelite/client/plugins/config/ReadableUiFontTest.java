/*
 * Copyright (c) 2026, RuneLite contributors
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
package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.runelite.client.config.FontType;
import net.runelite.client.ui.AppFontManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.ui.laf.RuneLiteLAF;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ReadableUiFontTest
{
	@Test
	public void fontsAndRowsRespectUiSizeWithoutChangingGameFonts() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			Font gameFont = FontManager.getRunescapeFont();
			try
			{
				for (int size : new int[]{12, 14, 16, 18, 20})
				{
					assertTrue(RuneLiteLAF.setup(new Font(Font.SANS_SERIF, Font.PLAIN, size)));
					assertEquals(RenderingHints.VALUE_TEXT_ANTIALIAS_GASP, UIManager.get(RenderingHints.KEY_TEXT_ANTIALIASING));
					PluginListItem row = row("Agility");
					row.setSize(row.getPreferredSize());
					row.doLayout();
					JLabel label = (JLabel) ((BorderLayout) row.getLayout()).getLayoutComponent(BorderLayout.CENTER);
					assertEquals(size, label.getFont().getSize());
					assertTrue(label.getHeight() >= label.getFontMetrics(label.getFont()).getHeight());
					assertEquals(Font.SANS_SERIF, label.getFont().getFamily());
					assertSame(gameFont, FontManager.getRunescapeFont());
					ProgressBar progress = new ProgressBar();
					progress.setLeftLabel("Progress");
					progress.setSize(225, progress.getPreferredSize().height);
					progress.doLayout();
					for (Component component : progress.getComponents())
					{
						JLabel progressLabel = (JLabel) component;
						assertEquals(Font.SANS_SERIF, progressLabel.getFont().getFamily());
						assertTrue(progressLabel.getHeight() - progressLabel.getInsets().top
							>= progressLabel.getFontMetrics(progressLabel.getFont()).getHeight());
					}
					assertEquals(FontManager.getUiSmallFont(), new HotkeyButton(null, false).getFont());
				}
				RuneLiteLAF.setup();
				assertEquals(gameFont, UIManager.getFont("defaultFont"));
				assertSame(FontManager.getRunescapeSmallFont(), FontManager.getUiSmallFont());
				assertSame(FontManager.getRunescapeBoldFont(), FontManager.getUiBoldFont());
				assertEquals(RenderingHints.VALUE_TEXT_ANTIALIAS_GASP, UIManager.get(RenderingHints.KEY_TEXT_ANTIALIASING));
				assertEquals(20, row("Agility").getPreferredSize().height);
				assertEquals(16, new ProgressBar().getPreferredSize().height);
				assertEquals(FontManager.getDefaultFont().deriveFont(12.f), new HotkeyButton(null, false).getFont());
			}
			finally
			{
				RuneLiteLAF.setup();
			}
		});
	}

	@Test
	public void existingAndHiddenControlsUpdateAndRestoreWithoutChangingGameFonts() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			RuneLiteLAF.setup();
			JPanel hidden = new JPanel();
			AppFontManager.register(hidden);
			JLabel body = new JLabel("Body");
			JShadowedLabel small = new JShadowedLabel("Small");
			JLabel heading = new JLabel("Heading");
			JLabel explicit = new JLabel("Plugin-owned font");
			Font explicitFont = new Font(Font.MONOSPACED, Font.PLAIN, 11);
			explicit.setFont(explicitFont);
			FontManager.setUiSmallFont(small);
			FontManager.setUiBoldFont(heading);
			hidden.add(body);
			hidden.add(small);
			hidden.add(heading);
			hidden.add(explicit);
			Object shadowUI = small.getUI();
			PluginListItem row = row("Agility");
			ProgressBar progress = new ProgressBar();
			HotkeyButton hotkey = new HotkeyButton(null, false);
			Font gameFont = FontType.REGULAR.getFont();
			try
			{
				for (String family : new String[]{Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED})
				{
					Font selected = new Font(family, Font.ITALIC, 20);
					AppFontManager.apply(selected);
					assertEquals(selected, body.getFont());
					assertEquals(selected.deriveFont(18f), small.getFont());
					assertEquals(selected.deriveFont(Font.BOLD | Font.ITALIC), heading.getFont());
					assertSame(explicitFont, explicit.getFont());
					assertSame(shadowUI, small.getUI());
					assertSame(gameFont, FontType.REGULAR.getFont());
					assertEquals(small.getFont(), hotkey.getFont());
					assertTrue(row.getPreferredSize().height >= body.getPreferredSize().height + 4);
					assertTrue(progress.getPreferredSize().height >= small.getFontMetrics(small.getFont()).getHeight() + 2);
					JLabel newlyCreated = new JLabel("New");
					assertEquals(selected, newlyCreated.getFont());
				}
				AppFontManager.apply(FontType.REGULAR.getFont());
				assertEquals(FontManager.getRunescapeFont(), body.getFont());
				assertSame(FontManager.getRunescapeSmallFont(), small.getFont());
				assertSame(FontManager.getRunescapeBoldFont(), heading.getFont());
				assertEquals(20, row.getPreferredSize().height);
				assertEquals(16, progress.getPreferredSize().height);
				assertEquals(FontManager.getDefaultFont().deriveFont(12f), hotkey.getFont());
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}

	private static PluginListItem row(String name)
	{
		return new PluginListItem(null, new PluginConfigurationDescriptor(name, "Font preview", new String[0], null, null));
	}

}
