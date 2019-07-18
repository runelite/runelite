import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "1071129091"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "594076777"
	)
	public abstract void set(byte[] var1);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "([BIILer;[Lfv;I)V",
		garbageValue = "95070993"
	)
	static final void method3933(byte[] var0, int var1, int var2, Scene var3, CollisionMap[] var4) {
		Buffer var5 = new Buffer(var0);
		int var6 = -1;

		while (true) {
			int var7 = var5.method5509();
			if (var7 == 0) {
				return;
			}

			var6 += var7;
			int var8 = 0;

			while (true) {
				int var9 = var5.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var8 += var9 - 1;
				int var10 = var8 & 63;
				int var11 = var8 >> 6 & 63;
				int var12 = var8 >> 12;
				int var13 = var5.readUnsignedByte();
				int var14 = var13 >> 2;
				int var15 = var13 & 3;
				int var16 = var11 + var1;
				int var17 = var10 + var2;
				if (var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
					int var18 = var12;
					if ((Tiles.Tiles_renderFlags[1][var16][var17] & 2) == 2) {
						var18 = var12 - 1;
					}

					CollisionMap var19 = null;
					if (var18 >= 0) {
						var19 = var4[var18];
					}

					GrandExchangeOfferOwnWorldComparator.method1236(var12, var16, var17, var6, var15, var14, var3, var19);
				}
			}
		}
	}
}
