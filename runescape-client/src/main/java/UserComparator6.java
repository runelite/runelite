import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fz")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
	@ObfuscatedName("er")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator6(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "660153035"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		}
		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "491873255"
	)
	@Export("JagexCache_init")
	public static void JagexCache_init(String game, String serverBuild, int zero, int idxCount) throws IOException {
		class40.idxCount = idxCount;
		TextureProvider.cacheGamebuild = zero;

		try {
			ScriptEvent.operatingSystem = System.getProperty("os.name");
		} catch (Exception var14) {
			ScriptEvent.operatingSystem = "Unknown";
		}

		GrandExchangeOfferOwnWorldComparator.operatingSystemLC = ScriptEvent.operatingSystem.toLowerCase();

		try {
			PlayerType.userHomeDirectory = System.getProperty("user.home");
			if (PlayerType.userHomeDirectory != null) {
				PlayerType.userHomeDirectory = PlayerType.userHomeDirectory + "/";
			}
		} catch (Exception var13) {
		}

		try {
			if (GrandExchangeOfferOwnWorldComparator.operatingSystemLC.startsWith("win")) {
				if (PlayerType.userHomeDirectory == null) {
					PlayerType.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (PlayerType.userHomeDirectory == null) {
				PlayerType.userHomeDirectory = System.getenv("HOME");
			}

			if (PlayerType.userHomeDirectory != null) {
				PlayerType.userHomeDirectory = PlayerType.userHomeDirectory + "/";
			}
		} catch (Exception var12) {
		}

		if (PlayerType.userHomeDirectory == null) {
			PlayerType.userHomeDirectory = "~/";
		}

		JagexCache.JagexCache_validCacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", PlayerType.userHomeDirectory, "/tmp/", ""};
		LoginPacket.validCacheNames = new String[]{".jagex_cache_" + TextureProvider.cacheGamebuild, ".file_store_" + TextureProvider.cacheGamebuild};

		int var7;
		File var8;
		label135:
		for (int var9 = 0; var9 < 4; var9++) {
			class1.cacheDir = TextureProvider.getCacheDir(game, serverBuild, var9);
			if (!class1.cacheDir.exists()) {
				class1.cacheDir.mkdirs();
			}

			File[] var5 = class1.cacheDir.listFiles();
			if (var5 == null) {
				break;
			}

			File[] var6 = var5;

			for (var7 = 0; var7 < var6.length; var7++) {
				var8 = var6[var7];
				if (!class186.testReadWritePermissions(var8, false)) {
					continue label135;
				}
			}
			break;
		}


		File var4 = class1.cacheDir;
		FileSystem.FileSystem_cacheDir = var4;
		if (!FileSystem.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		}
		FileSystem.FileSystem_hasPermissions = true;

		try {
			File var16 = new File(PlayerType.userHomeDirectory, "random.dat");
			if (var16.exists()) {
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var16, "rw", 25L), 24, 0);
			} else {
				label115:
				for (int var10 = 0; var10 < LoginPacket.validCacheNames.length; ++var10) {
					for (var7 = 0; var7 < JagexCache.JagexCache_validCacheLocations.length; ++var7) {
						var8 = new File(JagexCache.JagexCache_validCacheLocations[var7] + LoginPacket.validCacheNames[var10] + File.separatorChar + "random.dat");
						if (var8.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var8, "rw", 25L), 24, 0);
							break label115;
						}
					}
				}
			}

			if (JagexCache.JagexCache_randomDat == null) {
				RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
				var7 = var17.read();
				var17.seek(0L);
				var17.write(var7);
				var17.seek(0L);
				var17.close();
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var16, "rw", 25L), 24, 0);
			}
		} catch (IOException var15) {
		}

		JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class65.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
		JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class65.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
		JagexCache.JagexCache_idxFiles = new BufferedFile[class40.idxCount];

		for (int var11 = 0; var11 < class40.idxCount; ++var11) {
			JagexCache.JagexCache_idxFiles[var11] = new BufferedFile(new AccessFile(class65.getFile("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "1163617683"
	)
	static int method3436(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = AbstractWorldMapIcon.getWindowedMode();
			return 1;
		}
		int var3;
		if (var0 == ScriptOpcodes.SETWINDOWMODE) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			if (var3 == 1 || var3 == 2) {
				Clock.setWindowedMode(var3);
			}

			return 1;
		}
		if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = WorldMapLabelSize.clientPreferences.windowMode;
			return 1;
		}
		if (var0 == ScriptOpcodes.SETDEFAULTWINDOWMODE) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			if (var3 == 1 || var3 == 2) {
				WorldMapLabelSize.clientPreferences.windowMode = var3;
				ReflectionCheck.savePreferences();
			}

			return 1;
		}
		if (var0 == 5310) {
			--HealthBarUpdate.Interpreter_intStackSize;
			return 1;
		}
		return 2;
	}
}
