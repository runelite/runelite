import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public class class290 {
	@ObfuscatedName("c")
	static char[] field3646;
	@ObfuscatedName("t")
	static char[] field3648;
	@ObfuscatedName("o")
	static char[] field3647;
	@ObfuscatedName("e")
	static int[] field3645;

	static {
		field3646 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3646[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3646[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3646[var0] = (char)(var0 + 48 - 52);
		}

		field3646[62] = '+';
		field3646[63] = '/';
		field3648 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3648[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3648[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3648[var0] = (char)(var0 + 48 - 52);
		}

		field3648[62] = '*';
		field3648[63] = '-';
		field3647 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3647[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3647[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3647[var0] = (char)(var0 + 48 - 52);
		}

		field3647[62] = '-';
		field3647[63] = '_';
		field3645 = new int[128];

		for (var0 = 0; var0 < field3645.length; ++var0) {
			field3645[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3645[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3645[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3645[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3645;
		field3645[43] = 62;
		var2[42] = 62;
		int[] var1 = field3645;
		field3645[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
		garbageValue = "-514037609"
	)
	public static String method5360(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}
}
