import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -779358423
	)
	@Export("SpriteBuffer_spriteHeight")
	public static int SpriteBuffer_spriteHeight;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lda;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.getFile(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-546780661"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}
}
