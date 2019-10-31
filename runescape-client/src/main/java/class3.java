import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class3 implements Enumerated {
	@ObfuscatedName("pc")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	public static final class3 field18;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	public static final class3 field17;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	public static final class3 field13;
	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "Lbe;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1740494527
	)
	final int field12;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1144447827
	)
	public final int field14;
	@ObfuscatedName("l")
	final Class field16;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "La;"
	)
	final class0 field11;

	static {
		field18 = new class3(0, 0, Integer.class, new class1());
		field17 = new class3(1, 1, Long.class, new class2());
		field13 = new class3(2, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;La;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field12 = var1;
		this.field14 = var2;
		this.field16 = var3;
		this.field11 = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field14;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkc;I)Ljava/lang/Object;",
		garbageValue = "2039832756"
	)
	public Object method55(Buffer var1) {
		return this.field11.vmethod74(var1);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Lq;",
		garbageValue = "-1626082833"
	)
	public static class3 method51(Class var0) {
		class3[] var1 = new class3[]{field13, field18, field17};
		class3[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class3 var4 = var2[var3];
			if (var4.field16 == var0) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1591617746"
	)
	static int method68(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkc;I)V",
		garbageValue = "240271857"
	)
	public static void method52(Object var0, Buffer var1) {
		class0 var2 = method59(var0.getClass());
		var2.vmethod89(var0, var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)La;",
		garbageValue = "1094436481"
	)
	static class0 method59(Class var0) {
		class3 var1 = method51(var0);
		if (var1 == null) {
			throw new IllegalArgumentException();
		} else {
			return var1.field11;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "([BIIS)I",
		garbageValue = "31533"
	)
	public static int method50(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}
}
