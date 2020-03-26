import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("x")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "1422436059"
	)
	@Export("get")
	byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "0"
	)
	@Export("set")
	public void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}
}
