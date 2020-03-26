import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	field3458(2, 0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(0, 1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	field3453(1, 2);

	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1684971179
	)
	static int field3456;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1294886119
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 834302777
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIB)J",
		garbageValue = "3"
	)
	static long method4777(int var0, int var1, int var2) {
		return (long)(var2 << 16 | var0 << 8 | var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-1597872585"
	)
	public static byte[] method4782(byte[] var0) {
		int var1 = var0.length;
		byte[] var2 = new byte[var1];
		System.arraycopy(var0, 0, var2, 0, var1);
		return var2;
	}
}
