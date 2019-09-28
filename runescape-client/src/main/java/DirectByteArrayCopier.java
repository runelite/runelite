import java.io.IOException;
import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("l")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("eu")
	static int[] field2482;
	@ObfuscatedName("z")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	DirectByteArrayCopier() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "-37"
	)
	@Export("get")
	byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-793496359"
	)
	@Export("set")
	void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2052817052"
	)
	public static void method3924(boolean var0) {
		if (NetCache.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3);
				var1.writeMedium(0);
				NetCache.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var3) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
			}

		}
	}
}
