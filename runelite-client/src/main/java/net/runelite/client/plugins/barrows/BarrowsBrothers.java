/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.WorldArea;

@RequiredArgsConstructor
@Getter
enum BarrowsBrothers
{
	AHRIM("Ahrim", new WorldArea(3562, 3286, 6, 7, 0), Varbits.BARROWS_KILLED_AHRIM),
	DHAROK("Dharok", new WorldArea(3572, 3295, 6, 6, 0), Varbits.BARROWS_KILLED_DHAROK),
	GUTHAN("Guthan", new WorldArea(3574, 3280, 7, 5, 0), Varbits.BARROWS_KILLED_GUTHAN),
	KARIL("Karil", new WorldArea(3563, 3273, 7, 7, 0), Varbits.BARROWS_KILLED_KARIL),
	TORAG("Torag", new WorldArea(3552, 3281, 5, 4, 0), Varbits.BARROWS_KILLED_TORAG),
	VERAC("Verac", new WorldArea(3555, 3295, 5, 6, 0), Varbits.BARROWS_KILLED_VERAC);

	private final String name;
	private final WorldArea location;
	@Getter(onMethod_ = {@Varbit})
	private final int killedVarbit;
}
