/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.pestcontrol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.annotations.Component;
import net.runelite.api.gameval.InterfaceID;

@AllArgsConstructor
@Getter
@ToString
enum Portal
{
	PURPLE(InterfaceID.PestStatusOverlay.PEST_STATUS_PORT1, InterfaceID.PestStatusOverlay.PEST_STATUS_PORTTXT1, InterfaceID.PestStatusOverlay.PEST_PORTAL_1_DONE),
	BLUE(InterfaceID.PestStatusOverlay.PEST_STATUS_PORT2, InterfaceID.PestStatusOverlay.PEST_STATUS_PORTTXT2, InterfaceID.PestStatusOverlay.PEST_PORTAL_2_DONE),
	YELLOW(InterfaceID.PestStatusOverlay.PEST_STATUS_PORT3, InterfaceID.PestStatusOverlay.PEST_STATUS_PORTTXT3, InterfaceID.PestStatusOverlay.PEST_PORTAL_3_DONE),
	RED(InterfaceID.PestStatusOverlay.PEST_STATUS_PORT4, InterfaceID.PestStatusOverlay.PEST_STATUS_PORTTXT4, InterfaceID.PestStatusOverlay.PEST_PORTAL_4_DONE);

	@Component
	private final int shield;
	@Component
	private final int hitpoints;
	@Component
	private final int icon;
}
