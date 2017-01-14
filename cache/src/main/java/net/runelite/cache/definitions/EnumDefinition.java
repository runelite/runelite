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

package net.runelite.cache.definitions;

public class EnumDefinition
{
	private int id;
	private int[] intVals;
	private char keyType;
	private char valType;
	private String defaultString = "null";
	private int defaultInt;
	private int size;
	private int[] keys;
	private String[] stringVals;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int[] getIntVals()
	{
		return intVals;
	}

	public void setIntVals(int[] intVals)
	{
		this.intVals = intVals;
	}

	public char getKeyType()
	{
		return keyType;
	}

	public void setKeyType(char keyType)
	{
		this.keyType = keyType;
	}

	public char getValType()
	{
		return valType;
	}

	public void setValType(char valType)
	{
		this.valType = valType;
	}

	public String getDefaultString()
	{
		return defaultString;
	}

	public void setDefaultString(String defaultString)
	{
		this.defaultString = defaultString;
	}

	public int getDefaultInt()
	{
		return defaultInt;
	}

	public void setDefaultInt(int defaultInt)
	{
		this.defaultInt = defaultInt;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int[] getKeys()
	{
		return keys;
	}

	public void setKeys(int[] keys)
	{
		this.keys = keys;
	}

	public String[] getStringVals()
	{
		return stringVals;
	}

	public void setStringVals(String[] stringVals)
	{
		this.stringVals = stringVals;
	}
}
