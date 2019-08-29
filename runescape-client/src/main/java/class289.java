import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kc")
public class class289 {
	@ObfuscatedName("s")
	static char[] field3631;
	@ObfuscatedName("j")
	static char[] field3630;
	@ObfuscatedName("i")
	static char[] field3632;
	@ObfuscatedName("k")
	static int[] field3633;

	static {
		field3631 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3631[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3631[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3631[var0] = (char)(var0 + 48 - 52);
		}

		field3631[62] = '+';
		field3631[63] = '/';
		field3630 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3630[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3630[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3630[var0] = (char)(var0 + 48 - 52);
		}

		field3630[62] = '*';
		field3630[63] = '-';
		field3632 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3632[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3632[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3632[var0] = (char)(var0 + 48 - 52);
		}

		field3632[62] = '-';
		field3632[63] = '_';
		field3633 = new int[128];

		for (var0 = 0; var0 < field3633.length; ++var0) {
			field3633[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3633[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3633[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3633[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3633;
		field3633[43] = 62;
		var2[42] = 62;
		int[] var1 = field3633;
		field3633[47] = 63;
		var1[45] = 63;
	}
}
