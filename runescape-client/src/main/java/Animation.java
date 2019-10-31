import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("Animation")
public class Animation {
	@ObfuscatedName("a")
	static int[] field1609;
	@ObfuscatedName("t")
	static int[] field1611;
	@ObfuscatedName("n")
	static int[] field1618;
	@ObfuscatedName("q")
	static int[] field1610;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("skeleton")
	Skeleton skeleton;
	@ObfuscatedName("l")
	@Export("transformCount")
	int transformCount;
	@ObfuscatedName("c")
	@Export("transformSkeletonLabels")
	int[] transformSkeletonLabels;
	@ObfuscatedName("o")
	@Export("transformXs")
	int[] transformXs;
	@ObfuscatedName("i")
	@Export("transformYs")
	int[] transformYs;
	@ObfuscatedName("d")
	@Export("transformZs")
	int[] transformZs;
	@ObfuscatedName("m")
	@Export("hasAlphaTransform")
	boolean hasAlphaTransform;

	static {
		field1609 = new int[500];
		field1611 = new int[500];
		field1618 = new int[500];
		field1610 = new int[500];
	}

	@ObfuscatedSignature(
		signature = "([BLee;)V"
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
							field1609[var7] = var10;
							field1611[var7] = 0;
							field1618[var7] = 0;
							field1610[var7] = 0;
							++var7;
							break;
						}
					}
				}

				field1609[var7] = var8;
				short var11 = 0;
				if (this.skeleton.transformTypes[var8] == 3) {
					var11 = 128;
				}

				if ((var9 & 1) != 0) {
					field1611[var7] = var4.readShortSmart();
				} else {
					field1611[var7] = var11;
				}

				if ((var9 & 2) != 0) {
					field1618[var7] = var4.readShortSmart();
				} else {
					field1618[var7] = var11;
				}

				if ((var9 & 4) != 0) {
					field1610[var7] = var4.readShortSmart();
				} else {
					field1610[var7] = var11;
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
				this.transformSkeletonLabels[var8] = field1609[var8];
				this.transformXs[var8] = field1611[var8];
				this.transformYs[var8] = field1618[var8];
				this.transformZs[var8] = field1610[var8];
			}

		}
	}
}
