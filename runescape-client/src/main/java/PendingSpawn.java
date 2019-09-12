import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("ar")
	@Export("hasFocus")
	protected static boolean hasFocus;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 912800159
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -639221859
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 458809523
	)
	@Export("type")
	int type;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 87359327
	)
	@Export("x")
	int x;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1751315985
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -470640353
	)
	int field900;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -402504459
	)
	int field903;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1760011819
	)
	@Export("id")
	int id;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -316029459
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2139915221
	)
	int field911;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1581206037
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1067091679
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;III)[Lli;",
		garbageValue = "1975064075"
	)
	@Export("SpriteBuffer_getSpriteArray")
	public static Sprite[] SpriteBuffer_getSpriteArray(AbstractArchive var0, int var1, int var2) {
		byte[] var4 = var0.takeFile(var1, var2);
		boolean var3;
		if (var4 == null) {
			var3 = false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var4);
			var3 = true;
		}

		return !var3 ? null : RouteStrategy.method3578();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1406470873"
	)
	static int method1683(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILhz;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "-2128555897"
	)
	public static void method1681(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.getGroupId(var2);
		int var7 = var1.getFileId(var6, var3);
		class197.field2376 = 1;
		class197.musicTrackArchive = var1;
		class197.musicTrackGroupId = var6;
		class197.musicTrackFileId = var7;
		Canvas.field395 = var4;
		MouseRecorder.musicTrackBoolean = var5;
		ModelData0.field1833 = var0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-789098612"
	)
	public static final void method1682() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}
}
