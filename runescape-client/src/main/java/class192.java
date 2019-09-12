import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public enum class192 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2345("", 0, new class191[]{class191.field2337}),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2338("", 1, new class191[]{class191.field2331, class191.field2337}),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2343("", 2, new class191[]{class191.field2331, class191.field2330, class191.field2337}),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2340("", 3, new class191[]{class191.field2331}),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2339("", 4),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2341("", 5, new class191[]{class191.field2331, class191.field2337}),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2344("", 6, new class191[]{class191.field2337}),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2342("", 8, new class191[]{class191.field2331, class191.field2337}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2346("", 9, new class191[]{class191.field2331, class191.field2330}),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2347("", 10, new class191[]{class191.field2331}),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2348("", 11, new class191[]{class191.field2331}),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2349("", 12, new class191[]{class191.field2331, class191.field2337}),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	field2350("", 13, new class191[]{class191.field2331});

	@ObfuscatedName("px")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1171442601
	)
	@Export("id")
	final int id;
	@ObfuscatedName("p")
	final Set field2352;

	static {
		method3645();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lge;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2352 = new HashSet();
		this.id = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2352.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2352 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1615230293"
	)
	public static void method3650(String var0, String var1, int var2, int var3) throws IOException {
		JagexCache.idxCount = var3;
		ViewportMouse.cacheGamebuild = var2;

		try {
			NetFileRequest.field3101 = System.getProperty("os.name");
		} catch (Exception var17) {
			NetFileRequest.field3101 = "Unknown";
		}

		UserComparator9.field1940 = NetFileRequest.field3101.toLowerCase();

		try {
			Message.userHomeDirectory = System.getProperty("user.home");
			if (Message.userHomeDirectory != null) {
				Message.userHomeDirectory = Message.userHomeDirectory + "/";
			}
		} catch (Exception var16) {
		}

		try {
			if (UserComparator9.field1940.startsWith("win")) {
				if (Message.userHomeDirectory == null) {
					Message.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (Message.userHomeDirectory == null) {
				Message.userHomeDirectory = System.getenv("HOME");
			}

			if (Message.userHomeDirectory != null) {
				Message.userHomeDirectory = Message.userHomeDirectory + "/";
			}
		} catch (Exception var15) {
		}

		if (Message.userHomeDirectory == null) {
			Message.userHomeDirectory = "~/";
		}

		GrandExchangeOfferWorldComparator.field30 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Message.userHomeDirectory, "/tmp/", ""};
		NetFileRequest.field3096 = new String[]{".jagex_cache_" + ViewportMouse.cacheGamebuild, ".file_store_" + ViewportMouse.cacheGamebuild};
		int var12 = 0;

		label101:
		while (var12 < 4) {
			InvDefinition.cacheDir = Entity.getCacheDir(var0, var1, var12);
			if (!InvDefinition.cacheDir.exists()) {
				InvDefinition.cacheDir.mkdirs();
			}

			File[] var5 = InvDefinition.cacheDir.listFiles();
			if (var5 == null) {
				break;
			}

			File[] var6 = var5;
			int var7 = 0;

			while (true) {
				if (var7 >= var6.length) {
					break label101;
				}

				File var8 = var6[var7];

				boolean var9;
				try {
					RandomAccessFile var10 = new RandomAccessFile(var8, "rw");
					int var11 = var10.read();
					var10.seek(0L);
					var10.write(var11);
					var10.seek(0L);
					var10.close();
					var9 = true;
				} catch (Exception var14) {
					var9 = false;
				}

				if (!var9) {
					++var12;
					break;
				}

				++var7;
			}
		}

		File var4 = InvDefinition.cacheDir;
		class16.FileSystem_cacheDir = var4;
		if (!class16.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;
			MenuAction.method2034();
			JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class226.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class226.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			DevicePcmPlayerProvider.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

			for (int var13 = 0; var13 < JagexCache.idxCount; ++var13) {
				DevicePcmPlayerProvider.JagexCache_idxFiles[var13] = new BufferedFile(new AccessFile(class226.getFile("main_file_cache.idx" + var13), "rw", 1048576L), 6000, 0);
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lgt;I)Z",
		garbageValue = "1011116785"
	)
	@Export("setAudioArchives")
	public static boolean setAudioArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		class197.soundEffectsArchive = var2;
		class197.midiPcmStream = var3;
		return true;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgh;",
		garbageValue = "2139380672"
	)
	static class192[] method3645() {
		return new class192[]{field2343, field2338, field2344, field2342, field2348, field2347, field2349, field2345, field2339, field2350, field2341, field2346, field2340};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkt;II)V",
		garbageValue = "2114066034"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		int var3 = 0;
		var0.importIndex();

		byte[] var10000;
		int var4;
		int var5;
		int var6;
		for (var4 = 0; var4 < Players.Players_count; ++var4) {
			var5 = Players.Players_indices[var4];
			if ((Players.field1217[var5] & 1) == 0) {
				if (var3 > 0) {
					--var3;
					var10000 = Players.field1217;
					var10000[var5] = (byte)(var10000[var5] | 2);
				} else {
					var6 = var0.readBits(1);
					if (var6 == 0) {
						var3 = class43.decode(var0);
						var10000 = Players.field1217;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						ArchiveLoader.readPlayerUpdate(var0, var5);
					}
				}
			}
		}

		var0.exportIndex();
		if (var3 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var4 = 0; var4 < Players.Players_count; ++var4) {
				var5 = Players.Players_indices[var4];
				if ((Players.field1217[var5] & 1) != 0) {
					if (var3 > 0) {
						--var3;
						var10000 = Players.field1217;
						var10000[var5] = (byte)(var10000[var5] | 2);
					} else {
						var6 = var0.readBits(1);
						if (var6 == 0) {
							var3 = class43.decode(var0);
							var10000 = Players.field1217;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							ArchiveLoader.readPlayerUpdate(var0, var5);
						}
					}
				}
			}

			var0.exportIndex();
			if (var3 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
					var5 = Players.Players_emptyIndices[var4];
					if ((Players.field1217[var5] & 1) != 0) {
						if (var3 > 0) {
							--var3;
							var10000 = Players.field1217;
							var10000[var5] = (byte)(var10000[var5] | 2);
						} else {
							var6 = var0.readBits(1);
							if (var6 == 0) {
								var3 = class43.decode(var0);
								var10000 = Players.field1217;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else if (Message.updateExternalPlayer(var0, var5)) {
								var10000 = Players.field1217;
								var10000[var5] = (byte)(var10000[var5] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var3 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
						var5 = Players.Players_emptyIndices[var4];
						if ((Players.field1217[var5] & 1) == 0) {
							if (var3 > 0) {
								--var3;
								var10000 = Players.field1217;
								var10000[var5] = (byte)(var10000[var5] | 2);
							} else {
								var6 = var0.readBits(1);
								if (var6 == 0) {
									var3 = class43.decode(var0);
									var10000 = Players.field1217;
									var10000[var5] = (byte)(var10000[var5] | 2);
								} else if (Message.updateExternalPlayer(var0, var5)) {
									var10000 = Players.field1217;
									var10000[var5] = (byte)(var10000[var5] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var3 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						for (var4 = 1; var4 < 2048; ++var4) {
							var10000 = Players.field1217;
							var10000[var4] = (byte)(var10000[var4] >> 1);
							Player var7 = Client.players[var4];
							if (var7 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var4;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var4;
							}
						}

						InterfaceParent.method1123(var0);
						if (var0.offset - var2 != var1) {
							throw new RuntimeException(var0.offset - var2 + " " + var1);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2000673999"
	)
	static void method3648() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromFriend();
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1282270167"
	)
	@Export("SpriteBuffer_clear")
	public static void SpriteBuffer_clear() {
		class325.SpriteBuffer_xOffsets = null;
		SecureRandomCallable.SpriteBuffer_yOffsets = null;
		class325.SpriteBuffer_spriteWidths = null;
		SoundSystem.SpriteBuffer_spriteHeights = null;
		class325.SpriteBuffer_spritePalette = null;
		InvDefinition.SpriteBuffer_pixels = null;
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(IIIS)V",
		garbageValue = "-8359"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(Lhy;IIZB)V",
		garbageValue = "75"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2632 * var0.height / var0.field2556;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.field2556 * var0.width / var0.field2632;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}
