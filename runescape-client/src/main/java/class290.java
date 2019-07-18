import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kk")
public class class290 {
	@ObfuscatedName("q")
	static char[] field3673;
	@ObfuscatedName("w")
	static char[] field3672;
	@ObfuscatedName("e")
	static char[] field3674;
	@ObfuscatedName("p")
	static int[] field3671;

	static {
		field3673 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3673[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3673[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3673[var0] = (char)(var0 + 48 - 52);
		}

		field3673[62] = '+';
		field3673[63] = '/';
		field3672 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3672[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3672[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3672[var0] = (char)(var0 + 48 - 52);
		}

		field3672[62] = '*';
		field3672[63] = '-';
		field3674 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3674[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3674[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3674[var0] = (char)(var0 + 48 - 52);
		}

		field3674[62] = '-';
		field3674[63] = '_';
		field3671 = new int[128];

		for (var0 = 0; var0 < field3671.length; ++var0) {
			field3671[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3671[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3671[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3671[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3671;
		field3671[43] = 62;
		var2[42] = 62;
		int[] var1 = field3671;
		field3671[47] = 63;
		var1[45] = 63;
	}
}
