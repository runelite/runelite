import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1433331089
	)
	public static int field2490;
	@ObfuscatedName("f")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-112018699"
	)
	@Export("get")
	public byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "33"
	)
	@Export("set")
	public void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "7"
	)
	public static void method3940(AbstractArchive var0) {
		class286.EnumDefinition_archive = var0;
	}
}
