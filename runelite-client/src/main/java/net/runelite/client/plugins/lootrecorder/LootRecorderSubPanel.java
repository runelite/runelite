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

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;

@Getter
class LootRecorderSubPanel extends JPanel
{
	private final ArrayList<LootEntry> records;
	private Map<String, LootRecord> uniques;
	private final JLabel icon = new JLabel();
	private final JLabel amount = new JLabel();

	LootRecorderSubPanel(ArrayList<LootEntry> records, ItemManager itemManager)
	{
		this.records = records;
		this.uniques = new HashMap<>();

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		this.records.forEach(rec ->
		{
			// Convert DropEntries records into consolidated entries
			ArrayList<DropEntry> drops = rec.getDrops();
			drops.forEach(de ->
			{
				ItemComposition item = itemManager.getItemComposition(de.getItem_id());
				LootRecord uniq = this.uniques.get(item.getName());
				if (uniq == null)
				{
					// Create new entry
					boolean shouldStack = item.isStackable() || de.getItem_amount() > 1;
					AsyncBufferedImage icon = itemManager.getImage(de.getItem_id(), de.getItem_amount(), shouldStack);
					LootRecord entry = new LootRecord(item.getName(), de.getItem_amount(), item.getId(), item.getPrice(), icon, item);
					this.uniques.put(item.getName(), entry);
				}
				else
				{
					// Update Entry
					uniq.incrementAmount(uniq, de.getItem_amount());
					uniq.updateIconAmount(uniq, itemManager);
				}
			});
		});

		this.uniques.forEach((lr, item) ->
		{
			LootRecordPanel p = new LootRecordPanel(item, c.gridy);
			c.gridy++;


			layout.addLayoutComponent(p, null);
		});
	}
}