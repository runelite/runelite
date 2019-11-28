import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
	protected AbstractSocket() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-29"
	)
	@Export("close")
	public abstract void close();

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "27"
	)
	@Export("readUnsignedByte")
	public abstract int readUnsignedByte() throws IOException;

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-53"
	)
	@Export("available")
	public abstract int available() throws IOException;

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1591428004"
	)
	@Export("isAvailable")
	public abstract boolean isAvailable(int var1) throws IOException;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "29"
	)
	@Export("read")
	public abstract int read(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-543253817"
	)
	@Export("write")
	public abstract void write(byte[] var1, int var2, int var3) throws IOException;
}
