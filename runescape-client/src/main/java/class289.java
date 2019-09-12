import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public class class289 {
	@ObfuscatedName("c")
	public static char[] field3626;
	@ObfuscatedName("x")
	static char[] field3628;
	@ObfuscatedName("t")
	static char[] field3627;
	@ObfuscatedName("g")
	static int[] field3629;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[[Lhy;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;

	static {
		field3626 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3626[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3626[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3626[var0] = (char)(var0 + 48 - 52);
		}

		field3626[62] = '+';
		field3626[63] = '/';
		field3628 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3628[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3628[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3628[var0] = (char)(var0 + 48 - 52);
		}

		field3628[62] = '*';
		field3628[63] = '-';
		field3627 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3627[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3627[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3627[var0] = (char)(var0 + 48 - 52);
		}

		field3627[62] = '-';
		field3627[63] = '_';
		field3629 = new int[128];

		for (var0 = 0; var0 < field3629.length; ++var0) {
			field3629[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3629[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3629[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3629[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3629;
		field3629[43] = 62;
		var2[42] = 62;
		int[] var1 = field3629;
		field3629[47] = 63;
		var1[45] = 63;
	}
}
