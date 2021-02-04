/*
 * Copyright (c) 2020, Zoinkwiz <https://github.com/Zoinkwiz>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.banktags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import lombok.Getter;
import lombok.Setter;

public class CustomBankTabItem
{
	@Getter
	private final int quantity;

	@Getter
	@Setter
	private String text;

	@Getter
	private final ArrayList<Integer> itemIDs;

	public CustomBankTabItem(int quantity, String text, int itemID)
	{
		this.quantity = quantity;
		this.text = text;
		this.itemIDs = new ArrayList<>(Collections.singleton(itemID));
	}

	public CustomBankTabItem(int quantity, String text, ArrayList<Integer> itemIDs)
	{
		this.quantity = quantity;
		this.text = text;
		this.itemIDs = itemIDs;
	}

	public void addItemIDs(Integer... itemIDs)
	{
		this.itemIDs.addAll(Arrays.asList(itemIDs));
	}

	public void addItemIDs(ArrayList<Integer> itemIDs)
	{
		this.itemIDs.addAll(itemIDs);
	}
}
