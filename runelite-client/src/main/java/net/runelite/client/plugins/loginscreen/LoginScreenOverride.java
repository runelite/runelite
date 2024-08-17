/*
 * Copyright (c) 2020, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.loginscreen;

import lombok.Getter;

public enum LoginScreenOverride
{
	OFF,
	NORMAL("normal.jpg"),
	OLD("old.jpg"),
	CHRISTMAS("christmas.jpg"),
	CHAMBERS_OF_XERIC("cox.jpg"),
	DARKMEYER("darkmeyer.jpg"),
	DRAGON_SLAYER_2("ds2.jpg"),
	FOSSIL_ISLAND("fossil_island.jpg"),
	HALLOWEEN("halloween.jpg"),
	HALLOWEEN_2019("halloween_2019.jpg"),
	INFERNO("inferno.jpg"),
	KEBOS("kebos.jpg"),
	MONKEY_MADNESS_2("mm2.jpg"),
	PRIFDDINAS("prifddinas.jpg"),
	THEATRE_OF_BLOOD("tob.jpg"),
	A_KINGDOM_DIVIDED("akd.jpg"),
	NEX("nex.jpg"),
	TOMBS_OF_AMASCUT("toa.jpg"),
	VARLAMORE("varlamore.jpg"),
	WHILE_GUTHIX_SLEEPS("wgs.jpg"),
	CUSTOM,
	RANDOM;

	@Getter
	private final String fileName;

	LoginScreenOverride()
	{
		this.fileName = null;
	}

	LoginScreenOverride(String fileName)
	{
		this.fileName = fileName;
	}
}
