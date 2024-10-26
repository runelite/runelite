/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.game;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ItemEquipmentStats
{
	int slot;

	@SerializedName("is2h")
	boolean isTwoHanded;

	int astab;
	int aslash;
	int acrush;
	int amagic;
	int arange;

	int dstab;
	int dslash;
	int dcrush;
	int dmagic;
	int drange;

	int str;
	int rstr;
	float mdmg;
	int prayer;
	int aspeed;

	net.runelite.http.api.item.ItemEquipmentStats toHttpApiFormat()
	{
		return net.runelite.http.api.item.ItemEquipmentStats.builder()
			.slot(this.slot)
			.isTwoHanded(this.isTwoHanded)
			.astab(this.astab)
			.aslash(this.aslash)
			.acrush(this.acrush)
			.amagic(this.amagic)
			.arange(this.arange)
			.dstab(this.dstab)
			.dslash(this.dslash)
			.dcrush(this.dcrush)
			.dmagic(this.dmagic)
			.drange(this.drange)
			.str(this.str)
			.rstr(this.rstr)
			.mdmg((int) this.mdmg)
			.prayer(this.prayer)
			.aspeed(this.aspeed)
			.build();
	}
}
