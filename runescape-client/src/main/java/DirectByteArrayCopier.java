import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("s")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	DirectByteArrayCopier() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-1040345200"
	)
	@Export("get")
	byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "38240743"
	)
	@Export("set")
	void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "2110102488"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		MilliClock.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "470994563"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}
