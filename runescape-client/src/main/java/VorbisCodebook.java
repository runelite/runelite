import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
@Implements("VorbisCodebook")
public class VorbisCodebook {
	@ObfuscatedName("u")
	@Export("dimensions")
	int dimensions;
	@ObfuscatedName("f")
	@Export("entries")
	int entries;
	@ObfuscatedName("b")
	@Export("lengthMap")
	int[] lengthMap;
	@ObfuscatedName("g")
	int[] field1333;
	@ObfuscatedName("z")
	float[][] field1334;
	@ObfuscatedName("p")
	@Export("keys")
	int[] keys;

	VorbisCodebook() {
		VorbisSample.readBits(24);
		this.dimensions = VorbisSample.readBits(16);
		this.entries = VorbisSample.readBits(24);
		this.lengthMap = new int[this.entries];
		boolean var1 = VorbisSample.readBit() != 0;
		int var2;
		int var3;
		int var5;
		if (var1) {
			var2 = 0;

			for (var3 = VorbisSample.readBits(5) + 1; var2 < this.entries; ++var3) {
				int var4 = VorbisSample.readBits(class160.iLog(this.entries - var2));

				for (var5 = 0; var5 < var4; ++var5) {
					this.lengthMap[var2++] = var3;
				}
			}
		} else {
			boolean var14 = VorbisSample.readBit() != 0;

			for (var3 = 0; var3 < this.entries; ++var3) {
				if (var14 && VorbisSample.readBit() == 0) {
					this.lengthMap[var3] = 0;
				} else {
					this.lengthMap[var3] = VorbisSample.readBits(5) + 1;
				}
			}
		}

		this.method2358();
		var2 = VorbisSample.readBits(4);
		if (var2 > 0) {
			float var15 = VorbisSample.float32Unpack(VorbisSample.readBits(32));
			float var16 = VorbisSample.float32Unpack(VorbisSample.readBits(32));
			var5 = VorbisSample.readBits(4) + 1;
			boolean var6 = VorbisSample.readBit() != 0;
			int var7;
			if (var2 == 1) {
				var7 = mapType1QuantValues(this.entries, this.dimensions);
			} else {
				var7 = this.entries * this.dimensions;
			}

			this.field1333 = new int[var7];

			int var8;
			for (var8 = 0; var8 < var7; ++var8) {
				this.field1333[var8] = VorbisSample.readBits(var5);
			}

			this.field1334 = new float[this.entries][this.dimensions];
			float var9;
			int var10;
			int var11;
			if (var2 == 1) {
				for (var8 = 0; var8 < this.entries; ++var8) {
					var9 = 0.0F;
					var10 = 1;

					for (var11 = 0; var11 < this.dimensions; ++var11) {
						int var12 = var8 / var10 % var7;
						float var13 = (float)this.field1333[var12] * var16 + var15 + var9;
						this.field1334[var8][var11] = var13;
						if (var6) {
							var9 = var13;
						}

						var10 *= var7;
					}
				}
			} else {
				for (var8 = 0; var8 < this.entries; ++var8) {
					var9 = 0.0F;
					var10 = var8 * this.dimensions;

					for (var11 = 0; var11 < this.dimensions; ++var11) {
						float var17 = (float)this.field1333[var10] * var16 + var15 + var9;
						this.field1334[var8][var11] = var17;
						if (var6) {
							var9 = var17;
						}

						++var10;
					}
				}
			}
		}

	}

	@ObfuscatedName("f")
	void method2358() {
		int[] var1 = new int[this.entries];
		int[] var2 = new int[33];

		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var10;
		for (var3 = 0; var3 < this.entries; ++var3) {
			var4 = this.lengthMap[var3];
			if (var4 != 0) {
				var5 = 1 << 32 - var4;
				var6 = var2[var4];
				var1[var3] = var6;
				int var12;
				if ((var6 & var5) != 0) {
					var7 = var2[var4 - 1];
				} else {
					var7 = var6 | var5;

					for (var8 = var4 - 1; var8 >= 1; --var8) {
						var12 = var2[var8];
						if (var12 != var6) {
							break;
						}

						var10 = 1 << 32 - var8;
						if ((var12 & var10) != 0) {
							var2[var8] = var2[var8 - 1];
							break;
						}

						var2[var8] = var12 | var10;
					}
				}

				var2[var4] = var7;

				for (var8 = var4 + 1; var8 <= 32; ++var8) {
					var12 = var2[var8];
					if (var12 == var6) {
						var2[var8] = var7;
					}
				}
			}
		}

		this.keys = new int[8];
		int var11 = 0;

		for (var3 = 0; var3 < this.entries; ++var3) {
			var4 = this.lengthMap[var3];
			if (var4 != 0) {
				var5 = var1[var3];
				var6 = 0;

				for (var7 = 0; var7 < var4; ++var7) {
					var8 = Integer.MIN_VALUE >>> var7;
					if ((var5 & var8) != 0) {
						if (this.keys[var6] == 0) {
							this.keys[var6] = var11;
						}

						var6 = this.keys[var6];
					} else {
						++var6;
					}

					if (var6 >= this.keys.length) {
						int[] var9 = new int[this.keys.length * 2];

						for (var10 = 0; var10 < this.keys.length; ++var10) {
							var9[var10] = this.keys[var10];
						}

						this.keys = var9;
					}

					var8 >>>= 1;
				}

				this.keys[var6] = ~var3;
				if (var6 >= var11) {
					var11 = var6 + 1;
				}
			}
		}

	}

	@ObfuscatedName("b")
	int method2356() {
		int var1;
		for (var1 = 0; this.keys[var1] >= 0; var1 = VorbisSample.readBit() != 0 ? this.keys[var1] : var1 + 1) {
		}

		return ~this.keys[var1];
	}

	@ObfuscatedName("g")
	float[] method2357() {
		return this.field1334[this.method2356()];
	}

	@ObfuscatedName("u")
	@Export("mapType1QuantValues")
	static int mapType1QuantValues(int var0, int var1) {
		int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

		while (true) {
			int var4 = var2;
			int var5 = var1;

			int var6;
			for (var6 = 1; var5 > 1; var5 >>= 1) {
				if ((var5 & 1) != 0) {
					var6 *= var4;
				}

				var4 *= var4;
			}

			int var3;
			if (var5 == 1) {
				var3 = var4 * var6;
			} else {
				var3 = var6;
			}

			if (var3 <= var0) {
				return var2;
			}

			--var2;
		}
	}
}
