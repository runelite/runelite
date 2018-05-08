/*
 * Copyright (c) 2018 kulers
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
package net.runelite.client.plugins.inventorytagger;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

class TaggedItems
{
	@Getter
	public Color overlayColor;

	@Getter
	public String panelName;

	@Getter
	public Set<Integer> itemIdList = new HashSet<>();

	public TaggedItems(String panelName, Color overlayColor)
	{
		this.overlayColor = overlayColor;
		this.panelName = panelName;
	}

	public void addItem(Integer itemID)
	{
		itemIdList.add(itemID);
	}

	public void removeItem(Integer itemID)
	{
		itemIdList.remove(itemID);
	}

	public String getHexColor()
	{
		return String.format("%02x%02x%02x", overlayColor.getRed(), overlayColor.getGreen(), overlayColor.getBlue());
	}

	public void clearItem()
	{
		itemIdList.clear();
	}

	public boolean containsItem(Integer itemID)
	{
		return this.itemIdList.contains(itemID);
	}
}
