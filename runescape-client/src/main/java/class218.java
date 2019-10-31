import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class218 {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-975900209"
	)
	public static void method4255() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3132 != 0) {
				ArchiveDiskActionHandler.field3132 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "([BIIIIIIILek;[Lfm;I)V",
		garbageValue = "538821166"
	)
	static final void method4263(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
		Buffer var10 = new Buffer(var0);
		int var11 = -1;

		while (true) {
			int var12 = var10.method5623();
			if (var12 == 0) {
				return;
			}

			var11 += var12;
			int var13 = 0;

			while (true) {
				int var14 = var10.readUShortSmart();
				if (var14 == 0) {
					break;
				}

				var13 += var14 - 1;
				int var15 = var13 & 63;
				int var16 = var13 >> 6 & 63;
				int var17 = var13 >> 12;
				int var18 = var10.readUnsignedByte();
				int var19 = var18 >> 2;
				int var20 = var18 & 3;
				if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
					ObjectDefinition var21 = WorldMapDecorationType.getObjectDefinition(var11);
					int var22 = var2 + FloorDecoration.method3010(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
					int var25 = var16 & 7;
					int var26 = var15 & 7;
					int var28 = var21.sizeX;
					int var29 = var21.sizeY;
					int var30;
					if ((var20 & 1) == 1) {
						var30 = var28;
						var28 = var29;
						var29 = var30;
					}

					int var27 = var7 & 3;
					int var24;
					if (var27 == 0) {
						var24 = var26;
					} else if (var27 == 1) {
						var24 = 7 - var25 - (var28 - 1);
					} else if (var27 == 2) {
						var24 = 7 - var26 - (var29 - 1);
					} else {
						var24 = var25;
					}

					var30 = var24 + var3;
					if (var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
						int var31 = var1;
						if ((Tiles.Tiles_renderFlags[1][var22][var30] & 2) == 2) {
							var31 = var1 - 1;
						}

						CollisionMap var32 = null;
						if (var31 >= 0) {
							var32 = var9[var31];
						}

						class247.method4637(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
					}
				}
			}
		}
	}
}
