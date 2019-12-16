import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive19")
	static Archive archive19;
	@ObfuscatedName("hx")
	@ObfuscatedGetter(
		intValue = -1785627297
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("f")
	byte[] field2385;
	@ObfuscatedName("i")
	byte[] field2377;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1329513341
	)
	int field2378;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 12708137
	)
	int field2387;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1693996309
	)
	int field2376;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1410109429
	)
	int field2384;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2019355135
	)
	int field2382;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 27248727
	)
	int field2383;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1172401863
	)
	int field2380;

	MusicPatchNode2() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-69"
	)
	static void method3669() {
		class14.field88 = null;
		Tiles.field498 = null;
		Tiles.field494 = null;
		Tiles.field493 = null;
		Tiles.field501 = null;
		Tiles.field496 = null;
		ArchiveLoader.field512 = null;
		UrlRequest.Tiles_hue = null;
		MenuAction.Tiles_saturation = null;
		PacketBufferNode.Tiles_lightness = null;
		Tiles.Tiles_hueMultiplier = null;
		Varcs.field1244 = null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public static void method3668() {
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkq;J)V"
	)
	static void method3670(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.writeShort((int)var1);
	}
}
