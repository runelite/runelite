/*
 * Copyright (c) 2019, Mikhail <mikhail@huizenvlees.nl>
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
package net.runelite.client.plugins.grounditems;

import lombok.Data;

@Data
class FilterItem
{
	static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

	private String pattern;
	private String operator = "";
	private int amount = 0;

	FilterItem(String pattern)
	{
		this.pattern = pattern;
	}

	FilterItem(String pattern, String operator, int amount, String quantifier)
	{
		this.pattern = pattern;
		this.operator = operator;
		this.amount = amount * getQuantifier(quantifier);
	}

	private int getQuantifier(String quantifier)
	{
		switch (quantifier)
		{
			case "k":
			case "K":
				return POWERS_OF_10[3];
			case "m":
			case "M":
				return POWERS_OF_10[6];
			case "b":
			case "B":
				return POWERS_OF_10[9];
			default:
				return POWERS_OF_10[0];
		}
	}

	Boolean checkAmount(int amount)
	{
		switch (operator)
		{
			case ">":
				return amount > this.amount;
			case "<":
				return amount < this.amount;
			case "=":
				return amount == this.amount;
			default:
				return true;
		}
	}
}