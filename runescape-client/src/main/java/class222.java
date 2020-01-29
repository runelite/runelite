import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class222 {
	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1128427150"
	)
	static final void method4192() {
		int var2;
		int var3;
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.readSoundEffect(Client.archive4, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					int[] var14 = Client.queuedSoundEffectDelays;
					var14[var0] += var9.calculateDelay();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					if (Client.soundLocations[var0] != 0) {
						var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - class192.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - class192.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var5 + var7 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * Client.areaSoundEffectVolume / var3;
					} else {
						var2 = Client.soundEffectVolume;
					}

					if (var2 > 0) {
						RawSound var10 = var9.toRawSound().resample(WorldMapSection1.decimator);
						RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
						var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						class2.pcmStreamMixer.addSubStream(var11);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
					Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
					Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
					Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
					Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
					Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
				}

				--var0;
			}
		}

		if (Client.field881) {
			boolean var12;
			if (class197.field2414 != 0) {
				var12 = true;
			} else {
				var12 = class197.midiPcmStream.isReady();
			}

			if (!var12) {
				if (Client.musicVolume != 0 && Client.currentTrackGroupId != -1) {
					Archive var13 = MouseHandler.archive6;
					var2 = Client.currentTrackGroupId;
					var3 = Client.musicVolume;
					class197.field2414 = 1;
					UserComparator5.musicTrackArchive = var13;
					class197.musicTrackGroupId = var2;
					class83.musicTrackFileId = 0;
					AttackOption.musicTrackVolume = var3;
					KeyHandler.musicTrackBoolean = false;
					class197.field2412 = 10000;
				}

				Client.field881 = false;
			}
		}

	}
}
