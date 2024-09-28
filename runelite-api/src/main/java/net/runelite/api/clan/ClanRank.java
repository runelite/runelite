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
package net.runelite.api.clan;

import lombok.Value;

/**
 * A rank in a clan. The {@link #getRank()} value is -1 to 127 representing the rank.
 * Some constants are defined for named ranks, but most ranks have configurable titles which must be
 * fetched via {@link ClanSettings#titleForRank(ClanRank)}
 *
 * @see #JMOD
 * @see #OWNER
 * @see #DEPUTY_OWNER
 * @see #ADMINISTRATOR
 * @see #GUEST
 */
@Value
public class ClanRank
{
	public static final ClanRank JMOD = new ClanRank(127);
	public static final ClanRank OWNER = new ClanRank(126);
	public static final ClanRank DEPUTY_OWNER = new ClanRank(125);
	public static final ClanRank ADMINISTRATOR = new ClanRank(100);
	public static final ClanRank GUEST = new ClanRank(-1);

	/**
	 * The rank, -1 to 127.
	 */
	private final int rank;
}
