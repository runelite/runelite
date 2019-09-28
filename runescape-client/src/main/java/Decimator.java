import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("Decimator")
public class Decimator {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -222965331
	)
	@Export("inputRate")
	int inputRate;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 747601715
	)
	@Export("outputRate")
	int outputRate;
	@ObfuscatedName("p")
	@Export("table")
	int[][] table;

	public Decimator(int var1, int var2) {
		if (var2 != var1) {
			int var4 = var1;
			int var5 = var2;
			if (var2 > var1) {
				var4 = var2;
				var5 = var1;
			}

			while (var5 != 0) {
				int var6 = var4 % var5;
				var4 = var5;
				var5 = var6;
			}

			var1 /= var4;
			var2 /= var4;
			this.inputRate = var1;
			this.outputRate = var2;
			this.table = new int[var1][14];

			for (int var7 = 0; var7 < var1; ++var7) {
				int[] var8 = this.table[var7];
				double var9 = (double)var7 / (double)var1 + 6.0D;
				int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
				if (var11 < 0) {
					var11 = 0;
				}

				int var12 = (int)Math.ceil(var9 + 7.0D);
				if (var12 > 14) {
					var12 = 14;
				}

				for (double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
					double var15 = 3.141592653589793D * ((double)var11 - var9);
					double var17 = var13;
					if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
						var17 = var13 * (Math.sin(var15) / var15);
					}

					var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
					var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
				}
			}

		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "906746870"
	)
	@Export("resample")
	byte[] resample(byte[] var1) {
		if (this.table != null) {
			int var2 = (int)((long)var1.length * (long)this.outputRate / (long)this.inputRate) + 14;
			int[] var3 = new int[var2];
			int var4 = 0;
			int var5 = 0;

			int var6;
			for (var6 = 0; var6 < var1.length; ++var6) {
				byte var7 = var1[var6];
				int[] var8 = this.table[var5];

				int var9;
				for (var9 = 0; var9 < 14; ++var9) {
					var3[var4 + var9] += var7 * var8[var9];
				}

				var5 += this.outputRate;
				var9 = var5 / this.inputRate;
				var4 += var9;
				var5 -= var9 * this.inputRate;
			}

			var1 = new byte[var2];

			for (var6 = 0; var6 < var2; ++var6) {
				int var10 = var3[var6] + 32768 >> 16;
				if (var10 < -128) {
					var1[var6] = -128;
				} else if (var10 > 127) {
					var1[var6] = 127;
				} else {
					var1[var6] = (byte)var10;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1984702959"
	)
	@Export("scaleRate")
	int scaleRate(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate);
		}

		return var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1527580857"
	)
	@Export("scalePosition")
	int scalePosition(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
		}

		return var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lij;",
		garbageValue = "-1096040565"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "-695758013"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return Tiles.worldMap;
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "851552801"
	)
	static final void method2500() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field758[++Client.field640 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field681[++Client.field633 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2048(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field681[++Client.field633 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2048(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method2048(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field681[++Client.field633 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field758[++Client.field640 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
