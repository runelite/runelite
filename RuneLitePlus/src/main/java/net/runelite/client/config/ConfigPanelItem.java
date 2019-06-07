/*
 * Copyright (c) 2018, Craftiii4 <craftiii4@gmail.com>
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
package net.runelite.client.config;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;

public class ConfigPanelItem
{

	@Getter(AccessLevel.PUBLIC)
	private ConfigPanelItem parent;

	@Getter(AccessLevel.PUBLIC)
	private List<ConfigPanelItem> children;

	@Getter(AccessLevel.PUBLIC)
	private ConfigItemDescriptor item;

	public ConfigPanelItem(ConfigPanelItem parent, ConfigItemDescriptor item)
	{
		this.parent = parent;
		this.children = new ArrayList<>();
		this.item = item;
	}

	public List<ConfigPanelItem> getItemsAsList()
	{
		List<ConfigPanelItem> items = new ArrayList<>();

		items.add(this);

		for (ConfigPanelItem child : children)
		{
			items.addAll(child.getItemsAsList());
		}
		return items;
	}

	public int getDepth()
	{
		return (parent == null ? 0 : parent.getDepth() + 1);
	}

	public boolean addChildIfMatchParent(ConfigItemDescriptor cid)
	{

		if (item != null && item.getItem().keyName().equals(cid.getItem().parent()))
		{
			children.add(new ConfigPanelItem(this, cid));
			return true;
		}
		else
		{
			for (ConfigPanelItem child : children)
			{
				if (child.addChildIfMatchParent(cid))
				{
					return true;
				}
			}
			return false;
		}

	}

}