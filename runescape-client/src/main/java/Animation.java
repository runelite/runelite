import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("Animation")
public class Animation {
	@ObfuscatedName("q")
	static int[] field1638;
	@ObfuscatedName("w")
	static int[] field1639;
	@ObfuscatedName("e")
	static int[] field1636;
	@ObfuscatedName("p")
	static int[] field1635;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lej;"
	)
	@Export("skeleton")
	Skeleton skeleton;
	@ObfuscatedName("l")
	@Export("transformCount")
	int transformCount;
	@ObfuscatedName("b")
	@Export("transformSkeletonLabels")
	int[] transformSkeletonLabels;
	@ObfuscatedName("i")
	@Export("transformXs")
	int[] transformXs;
	@ObfuscatedName("c")
	@Export("transformYs")
	int[] transformYs;
	@ObfuscatedName("f")
	@Export("transformZs")
	int[] transformZs;
	@ObfuscatedName("m")
	@Export("hasAlphaTransform")
	boolean hasAlphaTransform;

	static {
		field1638 = new int[500];
		field1639 = new int[500];
		field1636 = new int[500];
		field1635 = new int[500];
	}

	@ObfuscatedSignature(
		signature = "([BLej;)V"
	)
	Animation(byte[] var1, Skeleton var2) {
		this.skeleton = null;
		this.transformCount = -1;
		this.hasAlphaTransform = false;
		this.skeleton = var2;
		Buffer var3 = new Buffer(var1);
		Buffer var4 = new Buffer(var1);
		var3.offset = 2;
		int var5 = var3.readUnsignedByte();
		int var6 = -1;
		int var7 = 0;
		var4.offset = var5 + var3.offset;

		int var8;
		for (var8 = 0; var8 < var5; ++var8) {
			int var9 = var3.readUnsignedByte();
			if (var9 > 0) {
				if (this.skeleton.transformTypes[var8] != 0) {
					for (int var10 = var8 - 1; var10 > var6; --var10) {
						if (this.skeleton.transformTypes[var10] == 0) {
							field1638[var7] = var10;
							field1639[var7] = 0;
							field1636[var7] = 0;
							field1635[var7] = 0;
							++var7;
							break;
						}
					}
				}

				field1638[var7] = var8;
				short var11 = 0;
				if (this.skeleton.transformTypes[var8] == 3) {
					var11 = 128;
				}

				if ((var9 & 1) != 0) {
					field1639[var7] = var4.readShortSmart();
				} else {
					field1639[var7] = var11;
				}

				if ((var9 & 2) != 0) {
					field1636[var7] = var4.readShortSmart();
				} else {
					field1636[var7] = var11;
				}

				if ((var9 & 4) != 0) {
					field1635[var7] = var4.readShortSmart();
				} else {
					field1635[var7] = var11;
				}

				var6 = var8;
				++var7;
				if (this.skeleton.transformTypes[var8] == 5) {
					this.hasAlphaTransform = true;
				}
			}
		}

		if (var1.length != var4.offset) {
			throw new RuntimeException();
		} else {
			this.transformCount = var7;
			this.transformSkeletonLabels = new int[var7];
			this.transformXs = new int[var7];
			this.transformYs = new int[var7];
			this.transformZs = new int[var7];

			for (var8 = 0; var8 < var7; ++var8) {
				this.transformSkeletonLabels[var8] = field1638[var8];
				this.transformXs[var8] = field1639[var8];
				this.transformYs[var8] = field1636[var8];
				this.transformZs[var8] = field1635[var8];
			}

		}
	}
}
