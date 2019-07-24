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

import net.runelite.api.SoundEffectVolume;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSRawPcmStream;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSRawSound;
import net.runelite.rs.api.RSSoundEffect;
import net.runelite.rs.api.RSPcmStream;

@Mixin(RSClient.class)
public abstract class SoundEffectMixin implements RSClient
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private static int lastSoundEffectCount;

	@Inject
	@Override
	public void playSoundEffect(int id)
	{
		playSoundEffect(id, 0, 0, 0, 0);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int x, int y, int range)
	{
		playSoundEffect(id, x, y, range, 0);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int x, int y, int range, int delay)
	{
		int position = ((x & 255) << 16) + ((y & 255) << 8) + (range & 255);

		int[] queuedSoundEffectIDs = getQueuedSoundEffectIDs();
		int[] queuedSoundEffectLoops = getQueuedSoundEffectLoops();
		int[] queuedSoundEffectDelays = getQueuedSoundEffectDelays();
		RSSoundEffect[] audioEffects = getAudioEffects();
		int[] soundLocations = getSoundLocations();
		int queuedSoundEffectCount = getQueuedSoundEffectCount();

		queuedSoundEffectIDs[queuedSoundEffectCount] = id;
		queuedSoundEffectLoops[queuedSoundEffectCount] = 1;
		queuedSoundEffectDelays[queuedSoundEffectCount] = delay;
		audioEffects[queuedSoundEffectCount] = null;
		soundLocations[queuedSoundEffectCount] = position;

		setQueuedSoundEffectCount(queuedSoundEffectCount + 1);
	}

	@Inject
	@Override
	public void playSoundEffect(int id, int volume)
	{
		RSSoundEffect soundEffect = getTrack(getIndexCache4(), id, 0);
		if (soundEffect == null)
		{
			return;
		}

		// If the current volume is not muted, use it instead
		final int soundEffectVolume = getSoundEffectVolume();
		if (soundEffectVolume != SoundEffectVolume.MUTED)
		{
			volume = soundEffectVolume;
		}

		RSRawSound rawAudioNode = soundEffect.toRawAudioNode().applyResampler(getSoundEffectResampler());
		RSRawPcmStream rawPcmStream = createRawPcmStream(rawAudioNode, 100, volume);
		rawPcmStream.setNumLoops(1);

		getSoundEffectAudioQueue().addSubStream((RSPcmStream) rawPcmStream);
	}

	@FieldHook("soundEffectCount")
	@Inject
	public static void queuedSoundEffectCountChanged(int idx)
	{
		int soundCount = client.getQueuedSoundEffectCount();
		if (soundCount == lastSoundEffectCount + 1)
		{
			int soundIndex = soundCount - 1;
			int packedLocation = client.getSoundLocations()[soundIndex];

			if (packedLocation == 0)
			{
				// Regular sound effect

				SoundEffectPlayed event = new SoundEffectPlayed();
				event.setSoundId(client.getQueuedSoundEffectIDs()[soundIndex]);
				event.setDelay(client.getQueuedSoundEffectDelays()[soundIndex]);
				client.getCallbacks().post(SoundEffectPlayed.class, event);
			}
			else
			{
				// Area sound effect

				int x = (packedLocation >> 16) & 0xFF;
				int y = (packedLocation >> 8) & 0xFF;
				int range = (packedLocation) & 0xFF;

				AreaSoundEffectPlayed event = new AreaSoundEffectPlayed();
				event.setSoundId(client.getQueuedSoundEffectIDs()[soundIndex]);
				event.setSceneX(x);
				event.setSceneY(y);
				event.setRange(range);
				event.setDelay(client.getQueuedSoundEffectDelays()[soundIndex]);
				client.getCallbacks().post(AreaSoundEffectPlayed.class, event);
			}
		}

		lastSoundEffectCount = soundCount;
	}
}
