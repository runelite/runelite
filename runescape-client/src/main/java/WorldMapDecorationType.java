import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2703(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2719(1, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2717(2, 0),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2704(3, 0),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2705(9, 2),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2706(4, 1),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2712(5, 1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2708(6, 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2709(7, 1),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2707(8, 1),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2711(12, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2701(13, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2713(14, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2714(15, 2),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2715(16, 2),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2716(17, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2720(18, 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2718(19, 2),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2702(20, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2710(21, 2),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2721(10, 2),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2722(11, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	field2723(22, 3);

	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -649990391
	)
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IB)Lix;",
		garbageValue = "0"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
		garbageValue = "-18"
	)
	public static String method4270(CharSequence[] var0, int var1, int var2) {
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
