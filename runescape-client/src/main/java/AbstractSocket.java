import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
	protected AbstractSocket() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1798752769"
	)
	@Export("close")
	public abstract void close();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "547465689"
	)
	@Export("readUnsignedByte")
	public abstract int readUnsignedByte() throws IOException;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "83"
	)
	@Export("available")
	public abstract int available() throws IOException;

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "156087109"
	)
	@Export("isAvailable")
	public abstract boolean isAvailable(int var1) throws IOException;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "100"
	)
	@Export("read")
	public abstract int read(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "638463675"
	)
	@Export("write")
	public abstract void write(byte[] var1, int var2, int var3) throws IOException;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lkk;",
		garbageValue = "2143260840"
	)
	@Export("ChatMode_values")
	static PrivateChatMode[] ChatMode_values() {
		return new PrivateChatMode[]{PrivateChatMode.field3790, PrivateChatMode.field3788, PrivateChatMode.field3793};
	}
}
