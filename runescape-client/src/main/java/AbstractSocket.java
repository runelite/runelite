import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
	protected AbstractSocket() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-119"
	)
	@Export("close")
	public abstract void close();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1784126558"
	)
	@Export("readUnsignedByte")
	public abstract int readUnsignedByte() throws IOException;

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "3"
	)
	@Export("available")
	public abstract int available() throws IOException;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-336706705"
	)
	@Export("isAvailable")
	public abstract boolean isAvailable(int var1) throws IOException;

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-2035668362"
	)
	@Export("read")
	public abstract int read(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "-68"
	)
	@Export("write")
	public abstract void write(byte[] var1, int var2, int var3) throws IOException;
}
