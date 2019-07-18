import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
@Implements("VorbisResidue")
public class VorbisResidue {
	@ObfuscatedName("q")
	@Export("residueType")
	int residueType;
	@ObfuscatedName("w")
	@Export("begin")
	int begin;
	@ObfuscatedName("e")
	@Export("end")
	int end;
	@ObfuscatedName("p")
	@Export("partitionSize")
	int partitionSize;
	@ObfuscatedName("k")
	@Export("classifications")
	int classifications;
	@ObfuscatedName("l")
	@Export("classbook")
	int classbook;
	@ObfuscatedName("b")
	@Export("cascade")
	int[] cascade;

	VorbisResidue() {
		this.residueType = VorbisSample.readBits(16);
		this.begin = VorbisSample.readBits(24);
		this.end = VorbisSample.readBits(24);
		this.partitionSize = VorbisSample.readBits(24) + 1;
		this.classifications = VorbisSample.readBits(6) + 1;
		this.classbook = VorbisSample.readBits(8);
		int[] var1 = new int[this.classifications];

		int var2;
		for (var2 = 0; var2 < this.classifications; ++var2) {
			int var3 = 0;
			int var4 = VorbisSample.readBits(3);
			boolean var5 = VorbisSample.readBit() != 0;
			if (var5) {
				var3 = VorbisSample.readBits(5);
			}

			var1[var2] = var3 << 3 | var4;
		}

		this.cascade = new int[this.classifications * 8];

		for (var2 = 0; var2 < this.classifications * 8; ++var2) {
			this.cascade[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? VorbisSample.readBits(8) : -1;
		}

	}

	@ObfuscatedName("q")
	void method2499(float[] var1, int var2, boolean var3) {
		int var4;
		for (var4 = 0; var4 < var2; ++var4) {
			var1[var4] = 0.0F;
		}

		if (!var3) {
			var4 = VorbisSample.VorbisSample_codebooks[this.classbook].dimensions;
			int var5 = this.end - this.begin;
			int var6 = var5 / this.partitionSize;
			int[] var7 = new int[var6];

			for (int var8 = 0; var8 < 8; ++var8) {
				int var9 = 0;

				while (var9 < var6) {
					int var10;
					int var11;
					if (var8 == 0) {
						var10 = VorbisSample.VorbisSample_codebooks[this.classbook].method2325();

						for (var11 = var4 - 1; var11 >= 0; --var11) {
							if (var9 + var11 < var6) {
								var7[var9 + var11] = var10 % this.classifications;
							}

							var10 /= this.classifications;
						}
					}

					for (var10 = 0; var10 < var4; ++var10) {
						var11 = var7[var9];
						int var12 = this.cascade[var8 + var11 * 8];
						if (var12 >= 0) {
							int var13 = var9 * this.partitionSize + this.begin;
							VorbisCodebook var14 = VorbisSample.VorbisSample_codebooks[var12];
							int var15;
							if (this.residueType == 0) {
								var15 = this.partitionSize / var14.dimensions;

								for (int var16 = 0; var16 < var15; ++var16) {
									float[] var17 = var14.method2318();

									for (int var18 = 0; var18 < var14.dimensions; ++var18) {
										var1[var13 + var16 + var18 * var15] += var17[var18];
									}
								}
							} else {
								var15 = 0;

								while (var15 < this.partitionSize) {
									float[] var19 = var14.method2318();

									for (int var20 = 0; var20 < var14.dimensions; ++var20) {
										var1[var13 + var15] += var19[var20];
										++var15;
									}
								}
							}
						}

						++var9;
						if (var9 >= var6) {
							break;
						}
					}
				}
			}

		}
	}
}
