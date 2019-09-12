import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("Animation")
public class Animation {
	@ObfuscatedName("c")
	static int[] field1603;
	@ObfuscatedName("x")
	static int[] field1612;
	@ObfuscatedName("t")
	static int[] field1604;
	@ObfuscatedName("g")
	static int[] field1602;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("skeleton")
	Skeleton skeleton;
	@ObfuscatedName("u")
	@Export("transformCount")
	int transformCount;
	@ObfuscatedName("j")
	@Export("transformSkeletonLabels")
	int[] transformSkeletonLabels;
	@ObfuscatedName("v")
	@Export("transformXs")
	int[] transformXs;
	@ObfuscatedName("d")
	@Export("transformYs")
	int[] transformYs;
	@ObfuscatedName("z")
	@Export("transformZs")
	int[] transformZs;
	@ObfuscatedName("n")
	@Export("hasAlphaTransform")
	boolean hasAlphaTransform;

	static {
		field1603 = new int[500];
		field1612 = new int[500];
		field1604 = new int[500];
		field1602 = new int[500];
	}

	@ObfuscatedSignature(
		signature = "([BLen;)V"
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
							field1603[var7] = var10;
							field1612[var7] = 0;
							field1604[var7] = 0;
							field1602[var7] = 0;
							++var7;
							break;
						}
					}
				}

				field1603[var7] = var8;
				short var11 = 0;
				if (this.skeleton.transformTypes[var8] == 3) {
					var11 = 128;
				}

				if ((var9 & 1) != 0) {
					field1612[var7] = var4.readShortSmart();
				} else {
					field1612[var7] = var11;
				}

				if ((var9 & 2) != 0) {
					field1604[var7] = var4.readShortSmart();
				} else {
					field1604[var7] = var11;
				}

				if ((var9 & 4) != 0) {
					field1602[var7] = var4.readShortSmart();
				} else {
					field1602[var7] = var11;
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
				this.transformSkeletonLabels[var8] = field1603[var8];
				this.transformXs[var8] = field1612[var8];
				this.transformYs[var8] = field1604[var8];
				this.transformZs[var8] = field1602[var8];
			}

		}
	}
}
