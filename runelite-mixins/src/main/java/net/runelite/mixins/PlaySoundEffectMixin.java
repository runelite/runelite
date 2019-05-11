/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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
package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSSoundEffect;

@Mixin(RSClient.class)
public abstract class PlaySoundEffectMixin implements RSClient
{

	@Inject
	@Override
	public void playSoundEffect(int id)
	{
		playSoundEffect(id, 0, 0, 0);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int x, int y, int range)
	{
		int position = ((x & 255) << 16) + ((y & 255) << 8) + (range & 255);

		int[] queuedSoundEffectIDs = getQueuedSoundEffectIDs();
		int[] unknownSoundValues1 = getUnknownSoundValues1();
		int[] queuedSoundEffectDelays = getQueuedSoundEffectDelays();
		RSSoundEffect[] audioEffects = getAudioEffects();
		int[] soundLocations = getSoundLocations();
		int queuedSoundEffectCount = getQueuedSoundEffectCount();

		queuedSoundEffectIDs[queuedSoundEffectCount] = id;
		unknownSoundValues1[queuedSoundEffectCount] = 0;
		queuedSoundEffectDelays[queuedSoundEffectCount] = 0;
		audioEffects[queuedSoundEffectCount] = null;
		soundLocations[queuedSoundEffectCount] = position;

		setQueuedSoundEffectCount(queuedSoundEffectCount + 1);
	}
}
