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
package net.runelite.client.ui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import net.runelite.client.config.FontType;
import net.runelite.client.ui.components.FlatTextField;
import net.runelite.client.ui.laf.RuneLiteLAF;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AppFontManagerTest
{
	@Test
	public void detachedCardsUpdateUnboundSiblingsOfRegisteredLabels() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			RuneLiteLAF.setup();
			JPanel cachedCard = new JPanel();
			JLabel title = new JLabel("No action selected");
			JLabel detail = new JLabel("Select multiple actions");
			FontManager.setUiSmallFont(detail);
			cachedCard.add(title);
			cachedCard.add(detail);
			try
			{
				Font selected = new Font(Font.DIALOG, Font.PLAIN, 24);
				AppFontManager.apply(selected);
				assertEquals(selected, title.getFont());
				assertEquals(selected.deriveFont(22f), detail.getFont());
				AppFontManager.apply(FontType.REGULAR.getFont());
				assertEquals(FontManager.getRunescapeFont(), title.getFont());
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}

	@Test
	public void explicitFontsEqualToTheThemeRemainOwnedByTheirControls() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			RuneLiteLAF.setup();
			JPanel root = new JPanel();
			AppFontManager.register(root);
			JLabel inherited = new JLabel("Theme-owned");
			JLabel original = new JLabel("Explicit original font");
			JLabel equalCopy = new JLabel("Equal but separately assigned font");
			Font originalFont = FontManager.getRunescapeFont();
			Font copiedFont = new Font(UIManager.getFont("defaultFont").getAttributes());
			original.setFont(originalFont);
			equalCopy.setFont(copiedFont);
			root.add(inherited);
			root.add(original);
			root.add(equalCopy);
			assertTrue(inherited.getFont() instanceof FontUIResource);
			assertEquals(inherited.getFont(), originalFont);
			assertEquals(inherited.getFont(), copiedFont);
			try
			{
				Font selected = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
				AppFontManager.apply(selected);
				assertEquals(selected, inherited.getFont());
				assertSame(originalFont, original.getFont());
				assertSame(copiedFont, equalCopy.getFont());

				// A control can opt out after previously following the theme, even at the same size/family.
				Font explicitCurrent = new Font(selected.getAttributes());
				inherited.setFont(explicitCurrent);
				AppFontManager.apply(new Font(Font.SERIF, Font.BOLD, 18));
				AppFontManager.apply(FontType.REGULAR.getFont());
				assertSame(explicitCurrent, inherited.getFont());
				assertSame(originalFont, original.getFont());
				assertSame(copiedFont, equalCopy.getFont());
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}

	@Test
	public void preferredHeightsGrowShrinkAndRestoreFromNaturalSizes() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			RuneLiteLAF.setup();
			JComboBox<String> combo = new JComboBox<>(new String[]{"Keep game size"});
			FlatTextField name = new FlatTextField();
			JSpinner spinner = new JSpinner();
			JPanel details = new JPanel();
			details.setLayout(new BoxLayout(details, BoxLayout.PAGE_AXIS));
			JLabel price = new JLabel("Price");
			JLabel spent = new JLabel("Spent");
			FontManager.setUiSmallFont(price);
			FontManager.setUiSmallFont(spent);
			details.add(price);
			details.add(spent);
			JComponent[] controls = {combo, name, spinner, details};
			int[] widths = {-1, 0, 50, 0};
			int[] defaults = {22, 24, 20, 45};
			for (int i = 0; i < controls.length; i++)
			{
				AppFontManager.bindPreferredHeight(controls[i], widths[i], defaults[i]);
				assertEquals(defaults[i], controls[i].getPreferredSize().height);
			}
			try
			{
				int largeComboHeight = 0;
				for (int size : new int[]{24, 12, 30, 14})
				{
					AppFontManager.apply(new Font(Font.SANS_SERIF, Font.PLAIN, size));
					for (int i = 0; i < controls.length; i++)
					{
						Dimension actual = controls[i].getPreferredSize();
						controls[i].setPreferredSize(null);
						Dimension natural = controls[i].getPreferredSize();
						controls[i].setPreferredSize(actual);
						assertEquals(Math.max(defaults[i], natural.height), actual.height);
						assertEquals(widths[i] < 0 ? natural.width : widths[i], actual.width);
					}
					if (size == 24)
					{
						largeComboHeight = combo.getPreferredSize().height;
						assertTrue(largeComboHeight > 22);
					}
					else if (size == 12)
					{
						assertTrue(combo.getPreferredSize().height < largeComboHeight);
					}
				}
				AppFontManager.apply(FontType.REGULAR.getFont());
				for (int i = 0; i < controls.length; i++)
				{
					assertEquals(defaults[i], controls[i].getPreferredSize().height);
				}
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}
}
