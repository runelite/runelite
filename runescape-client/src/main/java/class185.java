import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class185 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2334;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2332;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2333;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2339;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2336;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2341;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2337;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2331;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2335;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	public static final class185 field2340;
	@ObfuscatedName("lh")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;

	static {
		field2334 = new class185(5);
		field2332 = new class185(4);
		field2333 = new class185(14);
		field2339 = new class185(3);
		field2336 = new class185(15);
		field2341 = new class185(6);
		field2337 = new class185(4);
		field2331 = new class185(7);
		field2335 = new class185(5);
		field2340 = new class185(2);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "5"
	)
	class185(int var1) {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;B)V",
		garbageValue = "3"
	)
	public static void method3665(AbstractArchive var0) {
		VarbitDefinition.VarbitDefinition_archive = var0;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lhf;IB)Llm;",
		garbageValue = "-1"
	)
	public static IndexedSprite method3669(AbstractArchive var0, int var1) {
		byte[] var3 = var0.takeFileFlat(var1);
		boolean var2;
		if (var3 == null) {
			var2 = false;
		} else {
			Buffer.SpriteBuffer_decode(var3);
			var2 = true;
		}

		return !var2 ? null : GrandExchangeOfferAgeComparator.method172();
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "(IIIILln;Lhn;I)V",
		garbageValue = "1250322878"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var3 * var8 + var9 * var2 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6223(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
