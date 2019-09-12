import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("sk")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "Led;"
	)
	@Export("urlRequester")
	static UrlRequester urlRequester;
	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2040361911
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1007393083
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -462526133
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1078511921
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIILfj;I)Z",
		garbageValue = "2030512647"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(S)[Lli;",
		garbageValue = "-22640"
	)
	static Sprite[] method3578() {
		Sprite[] var0 = new Sprite[class325.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class325.SpriteBuffer_spriteCount; ++var1) {
			Sprite var2 = var0[var1] = new Sprite();
			var2.width = class325.SpriteBuffer_spriteWidth;
			var2.height = class325.SpriteBuffer_spriteHeight;
			var2.xOffset = class325.SpriteBuffer_xOffsets[var1];
			var2.yOffset = SecureRandomCallable.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class325.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = SoundSystem.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = InvDefinition.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class325.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		class192.SpriteBuffer_clear();
		return var0;
	}
}
