import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("u")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(S)[B",
		garbageValue = "18982"
	)
	@Export("get")
	byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-1436271820"
	)
	@Export("set")
	public void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1809076627"
	)
	static boolean method4010(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var1)) {
				return true;
			}
		}

		return false;
	}
}
