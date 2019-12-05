import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class226 {
	@ObfuscatedName("gn")
	@Export("regions")
	static int[] regions;

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-424113908"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3152 != 0 && var3 > AbstractArchive.field3152) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 >= 0 && (AbstractArchive.field3152 == 0 || var6 <= AbstractArchive.field3152)) {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			} else {
				throw new RuntimeException();
			}
		}
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "([BIB)V",
		garbageValue = "-41"
	)
	static void method4200(byte[] var0, int var1) {
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class300.writeRandomDat(var0, var1, Client.randomDatData, 0, 24);
	}
}
