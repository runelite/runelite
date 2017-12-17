/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

public class MenuEntry
{
	private String option;
	private String target;
	private int identifier;
	private MenuAction type;
	private int param0;
	private int param1;

	@Override
	public String toString()
	{
		return "MenuEntry{" + "option=" + option + ", target=" + target + ", identifier=" + identifier + ", type=" + type + ", param0=" + param0 + ", param1=" + param1 + '}';
	}

	public String getOption()
	{
		return option;
	}

	public void setOption(String option)
	{
		this.option = option;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public int getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(int identifier)
	{
		this.identifier = identifier;
	}

	public MenuAction getType()
	{
		return type;
	}

	public void setType(MenuAction type)
	{
		this.type = type;
	}

	public int getParam0()
	{
		return param0;
	}

	public void setParam0(int param0)
	{
		this.param0 = param0;
	}

	public int getParam1()
	{
		return param1;
	}

	public void setParam1(int param1)
	{
		this.param1 = param1;
	}

}
