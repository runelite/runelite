/*
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
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
package net.runelite.client.plugins.party;

import java.awt.image.BufferedImage;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.SoundEffectID;
import net.runelite.client.util.ImageUtil;

@Getter
@RequiredArgsConstructor
public enum PartyPingType
{
	/*
	* Danger icon made by iconproject45 from www.flaticon.com
	* Destination icon made by DinosoftLabs from www.flaticon.com
	* Question icon made by Mzipi from www.flaticon.com
	* Request icon made by Smashicons from www.flaticon.com
	* Target icon made by rukanicon from www.flaticon.com
	*/
	@SerializedName("1") DANGER(ImageUtil.loadImageResource(PartyPlugin.class, "ping_danger.png"), SoundEffectID.PRAYER_ACTIVATE_BURST_OF_STRENGTH),
	@SerializedName("2") DESTINATION(ImageUtil.loadImageResource(PartyPlugin.class, "ping_destination.png"), SoundEffectID.TOWN_CRIER_BELL_DING),
	@SerializedName("3") REQUEST(ImageUtil.loadImageResource(PartyPlugin.class, "ping_request.png"), SoundEffectID.PRAYER_ACTIVATE_CLARITY_OF_THOUGHT),
	@SerializedName("4") QUESTION(ImageUtil.loadImageResource(PartyPlugin.class, "ping_question.png"), 4935),

	// target ping as last entry, does not show up in menu and is used as default ping
	@SerializedName("0") TARGET(ImageUtil.loadImageResource(PartyPlugin.class, "ping_target.png"), SoundEffectID.SMITH_ANVIL_TINK);

	private final BufferedImage image;
	private final int soundId;
}
