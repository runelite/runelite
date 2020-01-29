import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("c")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("t")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -118774103
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("e")
	static byte[][][] field502;
	@ObfuscatedName("i")
	static byte[][][] field514;
	@ObfuscatedName("g")
	static byte[][][] field507;
	@ObfuscatedName("d")
	static byte[][][] field518;
	@ObfuscatedName("j")
	static int[][] field509;
	@ObfuscatedName("z")
	static final int[] field508;
	@ObfuscatedName("y")
	static final int[] field513;
	@ObfuscatedName("f")
	static final int[] field506;
	@ObfuscatedName("b")
	static final int[] field516;
	@ObfuscatedName("r")
	static final int[] field503;
	@ObfuscatedName("s")
	static final int[] field517;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1347030255
	)
	static int field512;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 563851447
	)
	static int field519;
	@ObfuscatedName("gm")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field508 = new int[]{1, 2, 4, 8};
		field513 = new int[]{16, 32, 64, 128};
		field506 = new int[]{1, 0, -1, 0};
		field516 = new int[]{0, -1, 0, 1};
		field503 = new int[]{1, -1, -1, 1};
		field517 = new int[]{-1, -1, 1, 1};
		field512 = (int)(Math.random() * 17.0D) - 8;
		field519 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II[BII)I",
		garbageValue = "-1076668980"
	)
	@Export("encodeStringCp1252")
	public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
		int var5 = var2 - var1;

		for (int var6 = 0; var6 < var5; ++var6) {
			char var7 = var0.charAt(var6 + var1);
			if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
				var3[var6 + var4] = (byte)var7;
			} else if (var7 == 8364) {
				var3[var6 + var4] = -128;
			} else if (var7 == 8218) {
				var3[var6 + var4] = -126;
			} else if (var7 == 402) {
				var3[var6 + var4] = -125;
			} else if (var7 == 8222) {
				var3[var6 + var4] = -124;
			} else if (var7 == 8230) {
				var3[var6 + var4] = -123;
			} else if (var7 == 8224) {
				var3[var6 + var4] = -122;
			} else if (var7 == 8225) {
				var3[var6 + var4] = -121;
			} else if (var7 == 710) {
				var3[var6 + var4] = -120;
			} else if (var7 == 8240) {
				var3[var6 + var4] = -119;
			} else if (var7 == 352) {
				var3[var6 + var4] = -118;
			} else if (var7 == 8249) {
				var3[var6 + var4] = -117;
			} else if (var7 == 338) {
				var3[var6 + var4] = -116;
			} else if (var7 == 381) {
				var3[var6 + var4] = -114;
			} else if (var7 == 8216) {
				var3[var6 + var4] = -111;
			} else if (var7 == 8217) {
				var3[var6 + var4] = -110;
			} else if (var7 == 8220) {
				var3[var6 + var4] = -109;
			} else if (var7 == 8221) {
				var3[var6 + var4] = -108;
			} else if (var7 == 8226) {
				var3[var6 + var4] = -107;
			} else if (var7 == 8211) {
				var3[var6 + var4] = -106;
			} else if (var7 == 8212) {
				var3[var6 + var4] = -105;
			} else if (var7 == 732) {
				var3[var6 + var4] = -104;
			} else if (var7 == 8482) {
				var3[var6 + var4] = -103;
			} else if (var7 == 353) {
				var3[var6 + var4] = -102;
			} else if (var7 == 8250) {
				var3[var6 + var4] = -101;
			} else if (var7 == 339) {
				var3[var6 + var4] = -100;
			} else if (var7 == 382) {
				var3[var6 + var4] = -98;
			} else if (var7 == 376) {
				var3[var6 + var4] = -97;
			} else {
				var3[var6 + var4] = 63;
			}
		}

		return var5;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "96"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1651271456"
	)
	static final void method1156() {
		for (GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var0.plane == Clock.Client_plane && !var0.isFinished) {
				if (Client.cycle >= var0.cycleStart) {
					var0.advance(Client.field707);
					if (var0.isFinished) {
						var0.remove();
					} else {
						ServerBuild.scene.drawEntity(var0.plane, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
					}
				}
			} else {
				var0.remove();
			}
		}

	}
}
