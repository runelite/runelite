import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class289 {
	@ObfuscatedName("f")
	static char[] field3634;
	@ObfuscatedName("i")
	static char[] field3636;
	@ObfuscatedName("y")
	static char[] field3633;
	@ObfuscatedName("w")
	static int[] field3635;

	static {
		field3634 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3634[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3634[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3634[var0] = (char)(var0 + 48 - 52);
		}

		field3634[62] = '+';
		field3634[63] = '/';
		field3636 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3636[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3636[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3636[var0] = (char)(var0 + 48 - 52);
		}

		field3636[62] = '*';
		field3636[63] = '-';
		field3633 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3633[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3633[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3633[var0] = (char)(var0 + 48 - 52);
		}

		field3633[62] = '-';
		field3633[63] = '_';
		field3635 = new int[128];

		for (var0 = 0; var0 < field3635.length; ++var0) {
			field3635[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3635[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3635[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3635[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3635;
		field3635[43] = 62;
		var2[42] = 62;
		int[] var1 = field3635;
		field3635[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(DDIB)[D",
		garbageValue = "-83"
	)
	public static double[] method5336(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			double var11 = FriendLoginUpdate.method5301(((double)var7 - var0) / var2) / var2;
			var6[var8] = var11;
			++var7;
		}

		return var6;
	}
}
