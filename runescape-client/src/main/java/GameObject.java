import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1950933673
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1570818829
	)
	@Export("height")
	int height;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1477915037
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1448814329
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1886669661
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -564679873
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -441030449
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -187063391
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1484089673
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -875771859
	)
	int field1912;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1503559581
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		longValue = -3849133574729992117L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 823124257
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lhi;I[B[BB)V",
		garbageValue = "-22"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2623 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2623 = new byte[11][];
			var0.field2624 = new byte[11][];
			var0.field2628 = new int[11];
			var0.field2626 = new int[11];
		}

		var0.field2623[var1] = var2;
		if (var2 != null) {
			var0.field2606 = true;
		} else {
			var0.field2606 = false;

			for (int var4 = 0; var4 < var0.field2623.length; ++var4) {
				if (var0.field2623[var4] != null) {
					var0.field2606 = true;
					break;
				}
			}
		}

		var0.field2624[var1] = var3;
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
		garbageValue = "-59"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		ArchiveDiskAction.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}
}
