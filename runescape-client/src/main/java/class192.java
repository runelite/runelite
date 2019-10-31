import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public enum class192 implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2345("", 0, new class191[]{class191.field2335}),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2338("", 1, new class191[]{class191.field2336, class191.field2335}),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2350("", 2, new class191[]{class191.field2336, class191.field2333, class191.field2335}),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2341("", 3, new class191[]{class191.field2336}),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2342("", 4),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2339("", 5, new class191[]{class191.field2336, class191.field2335}),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2344("", 6, new class191[]{class191.field2335}),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2340("", 8, new class191[]{class191.field2336, class191.field2335}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2346("", 9, new class191[]{class191.field2336, class191.field2333}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2347("", 10, new class191[]{class191.field2336}),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2348("", 11, new class191[]{class191.field2336}),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2349("", 12, new class191[]{class191.field2336, class191.field2335}),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgm;"
	)
	field2343("", 13, new class191[]{class191.field2336});

	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 503596415
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive14")
	static Archive archive14;
	@ObfuscatedName("ek")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2067874269
	)
	@Export("id")
	final int id;
	@ObfuscatedName("x")
	final Set field2352;

	static {
		method3812();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgt;)V"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "927636504"
	)
	public static void method3814(String var0, String var1, int var2, int var3) throws IOException {
		JagexCache.idxCount = var3;
		class189.cacheGamebuild = var2;

		try {
			class43.field363 = System.getProperty("os.name");
		} catch (Exception var17) {
			class43.field363 = "Unknown";
		}

		class96.field1299 = class43.field363.toLowerCase();

		try {
			class30.userHomeDirectory = System.getProperty("user.home");
			if (class30.userHomeDirectory != null) {
				class30.userHomeDirectory = class30.userHomeDirectory + "/";
			}
		} catch (Exception var16) {
		}

		try {
			if (class96.field1299.startsWith("win")) {
				if (class30.userHomeDirectory == null) {
					class30.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (class30.userHomeDirectory == null) {
				class30.userHomeDirectory = System.getenv("HOME");
			}

			if (class30.userHomeDirectory != null) {
				class30.userHomeDirectory = class30.userHomeDirectory + "/";
			}
		} catch (Exception var15) {
		}

		if (class30.userHomeDirectory == null) {
			class30.userHomeDirectory = "~/";
		}

		BoundaryObject.field1859 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class30.userHomeDirectory, "/tmp/", ""};
		class312.field3803 = new String[]{".jagex_cache_" + class189.cacheGamebuild, ".file_store_" + class189.cacheGamebuild};
		int var12 = 0;

		label99:
		while (var12 < 4) {
			JagexCache.cacheDir = VertexNormal.getCacheDir(var0, var1, var12);
			if (!JagexCache.cacheDir.exists()) {
				JagexCache.cacheDir.mkdirs();
			}

			File[] var5 = JagexCache.cacheDir.listFiles();
			if (var5 == null) {
				break;
			}

			File[] var6 = var5;
			int var7 = 0;

			while (true) {
				if (var7 >= var6.length) {
					break label99;
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

		File var4 = JagexCache.cacheDir;
		FileSystem.FileSystem_cacheDir = var4;
		if (!FileSystem.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;
			class14.method204();
			JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(PendingSpawn.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(PendingSpawn.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			ArchiveLoader.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

			for (int var13 = 0; var13 < JagexCache.idxCount; ++var13) {
				ArchiveLoader.JagexCache_idxFiles[var13] = new BufferedFile(new AccessFile(PendingSpawn.getFile("main_file_cache.idx" + var13), "rw", 1048576L), 6000, 0);
			}

		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)[Lgm;",
		garbageValue = "14"
	)
	static class192[] method3812() {
		return new class192[]{field2344, field2338, field2339, field2345, field2349, field2346, field2342, field2341, field2348, field2350, field2343, field2340, field2347};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;IZI)I",
		garbageValue = "-1187268982"
	)
	@Export("parseIntCustomRadix")
	public static int parseIntCustomRadix(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						throw new NumberFormatException();
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					throw new NumberFormatException();
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					throw new NumberFormatException();
				}

				var5 = var9;
				var4 = true;
			}

			if (!var4) {
				throw new NumberFormatException();
			} else {
				return var5;
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "11"
	)
	static void method3813(int var0, int var1) {
		int[] var2 = new int[9];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			int var4 = var3 * 32 + 15 + 128;
			int var5 = WorldMapSection0.method285(var4);
			int var6 = Rasterizer3D.Rasterizer3D_sine[var4];
			var5 = PcmPlayer.method2637(var5, var1);
			var2[var3] = var6 * var5 >> 16;
		}

		Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
	}
}
