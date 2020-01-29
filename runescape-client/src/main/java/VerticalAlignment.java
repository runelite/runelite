import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lic;"
	)
	field3196(2, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lic;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(0, 1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lic;"
	)
	field3198(1, 2);

	@ObfuscatedName("l")
	@Export("ByteArrayPool_altSizeArrayCounts")
	static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1614385539
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 272968923
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)J",
		garbageValue = "1244217494"
	)
	public static long method4424(CharSequence var0) {
		long var1 = 0L;
		int var3 = var0.length();

		for (int var4 = 0; var4 < var3; ++var4) {
			var1 *= 37L;
			char var5 = var0.charAt(var4);
			if (var5 >= 'A' && var5 <= 'Z') {
				var1 += (long)(var5 + 1 - 65);
			} else if (var5 >= 'a' && var5 <= 'z') {
				var1 += (long)(var5 + 1 - 97);
			} else if (var5 >= '0' && var5 <= '9') {
				var1 += (long)(var5 + 27 - 48);
			}

			if (var1 >= 177917621779460413L) {
				break;
			}
		}

		while (var1 % 37L == 0L && 0L != var1) {
			var1 /= 37L;
		}

		return var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1671974094"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return KitDefinition.parseIntCustomRadix(var0, 10, true);
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "116"
	)
	static String method4426(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0] : Client.menuActions[var0];
		}
	}
}
