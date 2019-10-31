import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kh")
public class class289 {
	@ObfuscatedName("a")
	static char[] field3636;
	@ObfuscatedName("t")
	static char[] field3635;
	@ObfuscatedName("n")
	static char[] field3637;
	@ObfuscatedName("q")
	static int[] field3638;

	static {
		field3636 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3636[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3636[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3636[var0] = (char)(var0 + 48 - 52);
		}

		field3636[62] = '+';
		field3636[63] = '/';
		field3635 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3635[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3635[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3635[var0] = (char)(var0 + 48 - 52);
		}

		field3635[62] = '*';
		field3635[63] = '-';
		field3637 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3637[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3637[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3637[var0] = (char)(var0 + 48 - 52);
		}

		field3637[62] = '-';
		field3637[63] = '_';
		field3638 = new int[128];

		for (var0 = 0; var0 < field3638.length; ++var0) {
			field3638[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3638[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3638[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3638[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3638;
		field3638[43] = 62;
		var2[42] = 62;
		int[] var1 = field3638;
		field3638[47] = 63;
		var1[45] = 63;
	}
}
