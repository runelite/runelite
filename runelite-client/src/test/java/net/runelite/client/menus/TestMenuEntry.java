/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.menus;

import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.widgets.Widget;

@EqualsAndHashCode
public class TestMenuEntry implements MenuEntry
{
	private String option;
	private String target;
	private int identifier;
	private int type;
	private int param0;
	private int param1;
	private boolean forceLeftClick;
	@Setter
	private int itemOp = -1;
	@Setter
	private int itemId = -1;
	@Setter
	private Widget widget;
	@Setter
	private Actor actor;
	@Getter
	@Setter
	private int worldViewId;

	@Override
	public String getOption()
	{
		return option;
	}

	@Override
	public MenuEntry setOption(String option)
	{
		this.option = option;
		return this;
	}

	@Override
	public String getTarget()
	{
		return target;
	}

	@Override
	public MenuEntry setTarget(String target)
	{
		this.target = target;
		return this;
	}

	@Override
	public int getIdentifier()
	{
		return this.identifier;
	}

	@Override
	public MenuEntry setIdentifier(int identifier)
	{
		this.identifier = identifier;
		return this;
	}

	@Override
	public MenuEntry setWorldViewId(int wvId)
	{
		this.worldViewId = wvId;
		return this;
	}

	@Override
	public MenuAction getType()
	{
		return MenuAction.of(this.type);
	}

	@Override
	public MenuEntry setType(MenuAction type)
	{
		this.type = type.getId();
		return this;
	}

	@Override
	public int getParam0()
	{
		return this.param0;
	}

	@Override
	public MenuEntry setParam0(int param0)
	{
		this.param0 = param0;
		return this;
	}

	@Override
	public int getParam1()
	{
		return this.param1;
	}

	@Override
	public MenuEntry setParam1(int param1)
	{
		this.param1 = param1;
		return this;
	}

	@Override
	public boolean isForceLeftClick()
	{
		return this.forceLeftClick;
	}

	@Override
	public MenuEntry setForceLeftClick(boolean forceLeftClick)
	{
		this.forceLeftClick = forceLeftClick;
		return this;
	}

	@Override
	public boolean isDeprioritized()
	{
		return type >= MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
	}

	@Override
	public MenuEntry setDeprioritized(boolean deprioritized)
	{
		if (deprioritized)
		{
			if (type < MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET)
			{
				type += MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
			}
		}
		else
		{
			if (type >= MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET)
			{
				type -= MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
			}
		}

		return this;
	}

	@Override
	public MenuEntry onClick(Consumer<MenuEntry> callback)
	{
		return this;
	}

	@Override
	public Consumer<MenuEntry> onClick()
	{
		return null;
	}

	@Override
	public boolean isItemOp()
	{
		return itemOp != -1;
	}

	@Override
	public int getItemOp()
	{
		return itemOp;
	}

	@Override
	public int getItemId()
	{
		return itemId;
	}

	@Override
	public MenuEntry setItemId(int itemId)
	{
		this.itemId = itemId;
		return this;
	}

	@Nullable
	@Override
	public Widget getWidget()
	{
		return widget;
	}

	@Nullable
	@Override
	public NPC getNpc()
	{
		return actor instanceof NPC ? (NPC) actor : null;
	}

	@Nullable
	@Override
	public Player getPlayer()
	{
		return actor instanceof Player ? (Player) actor : null;
	}

	@Nullable
	@Override
	public Actor getActor()
	{
		return actor;
	}

	@Override
	public Menu getSubMenu()
	{
		return null;
	}

	@Override
	public Menu createSubMenu()
	{
		return null;
	}

	@Override
	public void deleteSubMenu()
	{

	}
}
