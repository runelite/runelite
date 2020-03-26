import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class217 {
	@ObfuscatedName("dd")
	@Export("mouseCam")
	static boolean mouseCam;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "717184533"
	)
	@Export("currentTimeMillis")
	public static final synchronized long currentTimeMillis() {
		long var0 = System.currentTimeMillis();
		if (var0 < class306.field3698) {
			class306.field3699 += class306.field3698 - var0;
		}

		class306.field3698 = var0;
		return var0 + class306.field3699;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-1231201215"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3143 != 0 && var3 > AbstractArchive.field3143) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 < 0 || AbstractArchive.field3143 != 0 && var6 > AbstractArchive.field3143) {
				throw new RuntimeException();
			} else {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			}
		}
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "(Lhe;II)Ljava/lang/String;",
		garbageValue = "1493859077"
	)
	static String method4036(Widget var0, int var1) {
		int var3 = ScriptEvent.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
