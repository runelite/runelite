import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class81 {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1420031355
	)
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = 1548225329
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1888089163"
	)
	public static boolean method2086(int var0) {
		return var0 >= WorldMapDecorationType.field2748.id && var0 <= WorldMapDecorationType.field2730.id || var0 == WorldMapDecorationType.field2731.id;
	}

	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-53"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				AbstractWorldMapIcon.client.method991();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field887 = 0;
				Client.field678 = 0;
				Client.timer.method5073(var0);
				if (var0 != 20) {
					Canvas.method872(false);
				}
			}

			if (var0 != 20 && var0 != 40 && PcmPlayer.field1413 != null) {
				PcmPlayer.field1413.close();
				PcmPlayer.field1413 = null;
			}

			if (Client.gameState == 25) {
				Client.field699 = 0;
				Client.field676 = 0;
				Client.field794 = 1;
				Client.field850 = 0;
				Client.field672 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					WorldMapRegion.method505(archive10, WorldMapRegion.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					WorldMapRegion.method505(archive10, WorldMapRegion.archive8, false, 4);
				} else if (Login.field1194) {
					Login.titleboxSprite = null;
					Login.titlebuttonSprite = null;
					StructDefinition.runesSprite = null;
					AbstractByteArrayCopier.leftTitleSprite = null;
					class319.rightTitleSprite = null;
					Decimator.logoSprite = null;
					Login.title_muteSprite = null;
					InterfaceParent.options_buttons_0Sprite = null;
					Varps.options_buttons_2Sprite = null;
					class42.worldSelectBackSprites = null;
					ItemContainer.worldSelectFlagSprites = null;
					class40.worldSelectArrows = null;
					GraphicsObject.worldSelectStars = null;
					class42.field364 = null;
					DynamicObject.loginScreenRunesAnimation.method1828();
					UrlRequest.method3358(2);
					if (NetCache.NetCache_socket != null) {
						try {
							Buffer var1 = new Buffer(4);
							var1.writeByte(2);
							var1.writeMedium(0);
							NetCache.NetCache_socket.write(var1.array, 0, 4);
						} catch (IOException var4) {
							try {
								NetCache.NetCache_socket.close();
							} catch (Exception var3) {
							}

							++NetCache.NetCache_ioExceptions;
							NetCache.NetCache_socket = null;
						}
					}

					Login.field1194 = false;
				}
			} else {
				WorldMapRegion.method505(archive10, WorldMapRegion.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2006396000"
	)
	static final void method2084() {
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.readSoundEffect(SpriteMask.archive4, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					int[] var13 = Client.queuedSoundEffectDelays;
					var13[var0] += var9.calculateDelay();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						int var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - class215.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - class215.localPlayer.y;
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
						RawSound var10 = var9.toRawSound().resample(LoginScreenAnimation.decimator);
						RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
						var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						ClientPacket.pcmStreamMixer.addSubStream(var11);
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

		if (Client.field742) {
			boolean var12;
			if (class197.field2411 != 0) {
				var12 = true;
			} else {
				var12 = FaceNormal.midiPcmStream.isReady();
			}

			if (!var12) {
				if (Client.musicVolume != 0 && Client.currentTrackGroupId != -1) {
					class65.playMusicTrack(AbstractWorldMapData.archive6, Client.currentTrackGroupId, 0, Client.musicVolume, false);
				}

				Client.field742 = false;
			}
		}

	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "667770085"
	)
	static final void method2085() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				class3.updateActorSequence(var3, 1);
			}
		}

	}
}
