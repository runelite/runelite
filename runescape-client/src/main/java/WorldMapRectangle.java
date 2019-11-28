import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1021156023
	)
	@Export("width")
	int width;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1442347119
	)
	@Export("height")
	int height;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 611193367
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -782964479
	)
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		signature = "(Lar;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lii;",
		garbageValue = "-3287437"
	)
	@Export("FloorUnderlayDefinition_get")
	public static FloorOverlayDefinition FloorUnderlayDefinition_get(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(Lbg;III)V",
		garbageValue = "-1866889280"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var1).field3533;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field971 = 0;
			}

			if (var3 == 2) {
				var0.field971 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || GrandExchangeOfferAgeComparator.SequenceDefinition_get(var1).field3527 >= GrandExchangeOfferAgeComparator.SequenceDefinition_get(var0.sequence).field3527) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field971 = 0;
			var0.field994 = var0.pathLength;
		}

	}
}
