import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
public class class289 {
	@ObfuscatedName("u")
	static char[] field3653;
	@ObfuscatedName("f")
	static char[] field3656;
	@ObfuscatedName("b")
	static char[] field3655;
	@ObfuscatedName("g")
	static int[] field3654;

	static {
		field3653 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3653[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3653[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3653[var0] = (char)(var0 + 48 - 52);
		}

		field3653[62] = '+';
		field3653[63] = '/';
		field3656 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3656[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3656[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3656[var0] = (char)(var0 + 48 - 52);
		}

		field3656[62] = '*';
		field3656[63] = '-';
		field3655 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3655[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3655[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3655[var0] = (char)(var0 + 48 - 52);
		}

		field3655[62] = '-';
		field3655[63] = '_';
		field3654 = new int[128];

		for (var0 = 0; var0 < field3654.length; ++var0) {
			field3654[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3654[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3654[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3654[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3654;
		field3654[43] = 62;
		var2[42] = 62;
		int[] var1 = field3654;
		field3654[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;Ljava/lang/String;B)I",
		garbageValue = "61"
	)
	public static int method5388(Buffer var0, String var1) {
		int var2 = var0.offset;
		int var4 = var1.length();
		byte[] var5 = new byte[var4];

		for (int var6 = 0; var6 < var4; ++var6) {
			char var7 = var1.charAt(var6);
			if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
				var5[var6] = (byte)var7;
			} else if (var7 == 8364) {
				var5[var6] = -128;
			} else if (var7 == 8218) {
				var5[var6] = -126;
			} else if (var7 == 402) {
				var5[var6] = -125;
			} else if (var7 == 8222) {
				var5[var6] = -124;
			} else if (var7 == 8230) {
				var5[var6] = -123;
			} else if (var7 == 8224) {
				var5[var6] = -122;
			} else if (var7 == 8225) {
				var5[var6] = -121;
			} else if (var7 == 710) {
				var5[var6] = -120;
			} else if (var7 == 8240) {
				var5[var6] = -119;
			} else if (var7 == 352) {
				var5[var6] = -118;
			} else if (var7 == 8249) {
				var5[var6] = -117;
			} else if (var7 == 338) {
				var5[var6] = -116;
			} else if (var7 == 381) {
				var5[var6] = -114;
			} else if (var7 == 8216) {
				var5[var6] = -111;
			} else if (var7 == 8217) {
				var5[var6] = -110;
			} else if (var7 == 8220) {
				var5[var6] = -109;
			} else if (var7 == 8221) {
				var5[var6] = -108;
			} else if (var7 == 8226) {
				var5[var6] = -107;
			} else if (var7 == 8211) {
				var5[var6] = -106;
			} else if (var7 == 8212) {
				var5[var6] = -105;
			} else if (var7 == 732) {
				var5[var6] = -104;
			} else if (var7 == 8482) {
				var5[var6] = -103;
			} else if (var7 == 353) {
				var5[var6] = -102;
			} else if (var7 == 8250) {
				var5[var6] = -101;
			} else if (var7 == 339) {
				var5[var6] = -100;
			} else if (var7 == 382) {
				var5[var6] = -98;
			} else if (var7 == 376) {
				var5[var6] = -97;
			} else {
				var5[var6] = 63;
			}
		}

		var0.writeSmartByteShort(var5.length);
		var0.offset += class210.huffman.compress(var5, 0, var5.length, var0.array, var0.offset);
		return var0.offset - var2;
	}
}
