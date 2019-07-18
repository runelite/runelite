import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("sx")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2097561189
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1949359765
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1661311189
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 258723163
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -321030007
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = 7136672908246986663L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -77784117
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;IZB)Lek;",
		garbageValue = "103"
	)
	public static Frames method3262(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true;
		int[] var5 = var0.getGroupFileIds(var2);

		for (int var6 = 0; var6 < var5.length; ++var6) {
			byte[] var7 = var0.getFile(var2, var5[var6]);
			if (var7 == null) {
				var4 = false;
			} else {
				int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
				byte[] var9;
				if (var3) {
					var9 = var1.getFile(0, var8);
				} else {
					var9 = var1.getFile(var8, 0);
				}

				if (var9 == null) {
					var4 = false;
				}
			}
		}

		if (!var4) {
			return null;
		} else {
			try {
				return new Frames(var0, var1, var2, var3);
			} catch (Exception var11) {
				return null;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Liv;",
		garbageValue = "-497669049"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumDefinition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
