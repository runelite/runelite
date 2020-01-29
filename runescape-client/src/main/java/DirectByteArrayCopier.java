import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("c")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-571467457"
	)
	@Export("get")
	public byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1471312739"
	)
	@Export("set")
	public void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "19"
	)
	public static void method4006(int var0, int var1) {
		VarbitDefinition var3 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var8 = class287.VarbitDefinition_archive.takeFile(14, var0);
			var3 = new VarbitDefinition();
			if (var8 != null) {
				var3.decode(new Buffer(var8));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var3, (long)var0);
			var2 = var3;
		}

		int var4 = var2.baseVar;
		int var5 = var2.startBit;
		int var6 = var2.endBit;
		int var7 = Varps.Varps_masks[var6 - var5];
		if (var1 < 0 || var1 > var7) {
			var1 = 0;
		}

		var7 <<= var5;
		Varps.Varps_main[var4] = Varps.Varps_main[var4] & ~var7 | var1 << var5 & var7;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-186978734"
	)
	static boolean method4004(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var1)) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-470893406"
	)
	public static int method4012(String var0) {
		return var0.length() + 2;
	}
}
