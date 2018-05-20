/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.Map;

@Getter
class UniqueItemPanel extends JPanel
{
	private ItemManager itemManager;
	private ArrayList<UniqueItem> items;
	private Map<String, LootRecord> loots;

	UniqueItemPanel(ArrayList<UniqueItem> items, Map<String, LootRecord> loots, ItemManager itemManager)
	{
		this.items = items;
		this.loots = loots;
		this.itemManager = itemManager;

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBorder(new MatteBorder( 0, 0, 1, 0, Color.GRAY));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 50;

		// Add each Item icon to the panel
		this.items.forEach(item ->
			{
				ItemComposition comp = itemManager.getItemComposition(item.getItemID());
				LootRecord it = loots.get(comp.getName());
				boolean shouldStack = comp.isStackable();
				Integer quantity = 0;
				Integer imageID = comp.getId();

				// If we have a loot entry for this item then update the icon accordingly
				if (it != null)
				{
					quantity = it.getAmount();
					shouldStack = shouldStack || it.getAmount() > 1;
				}
				AsyncBufferedImage image = itemManager.getImage(imageID, quantity, shouldStack);
				JLabel icon = new JLabel()
				{
					@Override
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						Graphics2D g2d = (Graphics2D)g;
						if (it != null && it.getAmount() > 0)
						{
							g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
						}
						else
						{
							g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
						}
						g2d.drawImage(image, null, 0, ((c.ipady - image.getHeight()) / 2));
						g2d.dispose();
					}
				};

				this.add(icon, c);
				c.gridx++;
			}
		);
	}
}