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
package net.runelite.client.plugins.grandexchange;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.ItemComposition;
import net.runelite.client.config.FontType;
import net.runelite.client.ui.AppFontManager;
import net.runelite.client.ui.PluginPanel;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GrandExchangeOfferFontTest
{
	@Test
	public void populatedOfferLabelsFitAfterConstructionAndLiveResize() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
		{
			try
			{
				AppFontManager.apply(new Font(Font.DIALOG, Font.PLAIN, 24));
				GrandExchangeOfferSlot slot = new GrandExchangeOfferSlot(null);
				AppFontManager.register(slot);
				ItemComposition item = mock(ItemComposition.class);
				when(item.getMembersName()).thenReturn("Rune platebody");
				GrandExchangeOffer offer = mock(GrandExchangeOffer.class);
				when(offer.getState()).thenReturn(GrandExchangeOfferState.BUYING);
				when(offer.getPrice()).thenReturn(38000L);
				when(offer.getQuantitySold()).thenReturn(2);
				when(offer.getTotalQuantity()).thenReturn(10);
				when(offer.getSpent()).thenReturn(76000L);
				slot.updateOffer(item, new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB), offer);
				JPanel cards = (JPanel) ((BorderLayout) slot.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				for (int size : new int[]{24, 13, 30, 16})
				{
					if (size != 24)
					{
						AppFontManager.apply(size == 16 ? FontType.REGULAR.getFont() : new Font(Font.DIALOG, Font.PLAIN, size));
					}
					slot.setSize(PluginPanel.PANEL_WIDTH, slot.getPreferredSize().height);
					layoutTree(slot);
					assertLabelsFit(cards.getComponent(0));
					Component face = cards.getComponent(0);
					face.dispatchEvent(new MouseEvent(face, MouseEvent.MOUSE_PRESSED, 0, 0, 1, 1, 1, false, MouseEvent.BUTTON1));
					layoutTree(slot);
					assertLabelsFit(cards.getComponent(1));
					Component details = cards.getComponent(1);
					details.dispatchEvent(new MouseEvent(details, MouseEvent.MOUSE_PRESSED, 0, 0, 1, 1, 1, false, MouseEvent.BUTTON1));
				}
			}
			finally
			{
				AppFontManager.apply(FontType.REGULAR.getFont());
			}
		});
	}

	private static void layoutTree(Container container)
	{
		container.doLayout();
		for (Component child : container.getComponents())
		{
			if (child instanceof Container)
			{
				layoutTree((Container) child);
			}
		}
	}

	private static void assertLabelsFit(Component component)
	{
		if (component instanceof JLabel && ((JLabel) component).getText() != null)
		{
			JLabel label = (JLabel) component;
			assertTrue(label.getText(), label.getHeight() >= label.getPreferredSize().height);
		}
		if (component instanceof Container)
		{
			for (Component child : ((Container) component).getComponents())
			{
				assertLabelsFit(child);
			}
		}
	}
}
