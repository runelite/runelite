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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;

@RequiredArgsConstructor(
	access = AccessLevel.PACKAGE
)
@Getter
class LootRecord
{
	@Setter(AccessLevel.PACKAGE)
	private String item_name;
	@Setter(AccessLevel.PACKAGE)
	private Integer item_id;
	@Setter(AccessLevel.PACKAGE)
	private Integer amount;
	@Setter(AccessLevel.PACKAGE)
	private Integer value;
	@Setter(AccessLevel.PACKAGE)
	private long total;
	@Setter(AccessLevel.PACKAGE)
	private AsyncBufferedImage icon;
	@Setter(AccessLevel.PACKAGE)
	private ItemComposition item;

	LootRecord(String item_name, Integer item_id, Integer amount, Integer value, AsyncBufferedImage icon, ItemComposition item)
	{
		this.item = item;
		this.item_id = item_id;
		this.item_name = item_name;
		this.amount = amount;
		this.icon = icon;
		this.value = value;

		long val = this.value;
		long am = this.amount;
		this.total = val * am;
	}

	void incrementAmount(LootRecord l, Integer amount)
	{
		l.amount = l.amount + amount;
		long val = this.value;
		long am = this.amount;
		l.total = val * am;
	}

	void updateIconAmount(LootRecord l, ItemManager itemManager)
	{
		Boolean stackable = l.item.isStackable() || l.amount > 1;
		l.icon = itemManager.getImage(l.item_id, l.amount, stackable);
	}
}
