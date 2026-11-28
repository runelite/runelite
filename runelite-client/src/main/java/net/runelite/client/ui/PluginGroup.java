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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * Children are stored as {@link NavigationButton#getSidebarId()} when the plugin sets one,
 * otherwise the panel class name, so the layout can be saved without holding live buttons.
 */

@Getter
@Setter
final class PluginGroup
{
	private String id;
	private String name;
	private boolean expanded;
	private boolean childOrderCustom;
	private String iconKey;
	private List<String> children = new ArrayList<>();

	void addPlugin(String key)
	{
		if (key != null && !children.contains(key))
		{
			children.add(key);
		}
	}

	void removePlugin(String key)
	{
		children.remove(key);
		if (Objects.equals(iconKey, key))
		{
			iconKey = null;
		}
	}

	void toggleExpanded()
	{
		expanded = !expanded;
	}

	void normalize()
	{
		if (id == null || id.isEmpty())
		{
			id = UUID.randomUUID().toString();
		}
		if (name == null || name.trim().isEmpty())
		{
			name = "Folder";
		}
		else
		{
			name = name.trim();
		}
		if (children == null)
		{
			children = new ArrayList<>();
		}
		children.removeIf(Objects::isNull);
		if (iconKey != null && !children.contains(iconKey))
		{
			iconKey = null;
		}
	}
}
