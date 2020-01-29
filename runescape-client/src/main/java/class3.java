import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class3 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	public static final class3 field22;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	public static final class3 field15;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	public static final class3 field16;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -794176661
	)
	final int field17;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 500011769
	)
	public final int field18;
	@ObfuscatedName("g")
	final Class field19;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lc;"
	)
	final class0 field20;

	static {
		field22 = new class3(0, 0, Integer.class, new class1());
		field15 = new class3(1, 1, Long.class, new class2());
		field16 = new class3(2, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lc;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field17 = var1;
		this.field18 = var2;
		this.field19 = var3;
		this.field20 = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field18;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/Object;",
		garbageValue = "1079792403"
	)
	public Object method38(Buffer var1) {
		return this.field20.vmethod53(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Le;",
		garbageValue = "1607211171"
	)
	public static class3 method51(Class var0) {
		class3[] var1 = new class3[]{field15, field22, field16};
		class3[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class3 var4 = var2[var3];
			if (var4.field19 == var0) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkp;B)V",
		garbageValue = "-3"
	)
	public static void method35(Object var0, Buffer var1) {
		class0 var2 = method36(var0.getClass());
		var2.vmethod55(var0, var1);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Lc;",
		garbageValue = "-201332195"
	)
	static class0 method36(Class var0) {
		class3 var1 = method51(var0);
		if (var1 == null) {
			throw new IllegalArgumentException();
		} else {
			return var1.field20;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-95"
	)
	public static void method52() {
		try {
			File var0 = new File(UserComparator4.userHomeDirectory, "random.dat");
			int var2;
			if (var0.exists()) {
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			} else {
				label37:
				for (int var1 = 0; var1 < class42.field373.length; ++var1) {
					for (var2 = 0; var2 < ChatChannel.field1291.length; ++var2) {
						File var3 = new File(ChatChannel.field1291[var2] + class42.field373[var1] + File.separatorChar + "random.dat");
						if (var3.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
							break label37;
						}
					}
				}
			}

			if (JagexCache.JagexCache_randomDat == null) {
				RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
				var2 = var4.read();
				var4.seek(0L);
				var4.write(var2);
				var4.seek(0L);
				var4.close();
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			}
		} catch (IOException var5) {
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "310348252"
	)
	static final int method49(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = UserComparator4.method3450(var3, var5);
		int var8 = UserComparator4.method3450(var3 + 1, var5);
		int var9 = UserComparator4.method3450(var3, var5 + 1);
		int var10 = UserComparator4.method3450(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
		int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var13 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
		int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
		int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
		return var15;
	}
}
