import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
	protected AbstractSocket() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-75"
	)
	@Export("close")
	public abstract void close();

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1827163357"
	)
	@Export("readUnsignedByte")
	public abstract int readUnsignedByte() throws IOException;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1354053248"
	)
	@Export("available")
	public abstract int available() throws IOException;

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-377412375"
	)
	@Export("isAvailable")
	public abstract boolean isAvailable(int var1) throws IOException;

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "2063129771"
	)
	@Export("read")
	public abstract int read(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "9"
	)
	@Export("write")
	public abstract void write(byte[] var1, int var2, int var3) throws IOException;
}
