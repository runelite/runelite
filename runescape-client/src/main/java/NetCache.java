import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -824273879
	)
	@Export("NetCache_loadTime")
	static int NetCache_loadTime;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("NetCache_socket")
	public static AbstractSocket NetCache_socket;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -8280419898275786329L
	)
	static long field3145;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("NetCache_pendingPriorityWrites")
	static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -971608393
	)
	@Export("NetCache_pendingPriorityWritesCount")
	static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("NetCache_pendingPriorityResponses")
	static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1662423267
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("NetCache_pendingWritesQueue")
	static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1308098009
	)
	@Export("NetCache_pendingWritesCount")
	static int NetCache_pendingWritesCount;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("NetCache_pendingResponses")
	static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1727306885
	)
	@Export("NetCache_pendingResponsesCount")
	static int NetCache_pendingResponsesCount;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	@Export("NetCache_currentResponse")
	static NetFileRequest NetCache_currentResponse;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("NetCache_responseHeaderBuffer")
	static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("NetCache_responseArchiveBuffer")
	static Buffer NetCache_responseArchiveBuffer;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 788483417
	)
	static int field3156;
	@ObfuscatedName("z")
	@Export("NetCache_crc")
	static CRC32 NetCache_crc;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lid;"
	)
	@Export("NetCache_archives")
	static Archive[] NetCache_archives;
	@ObfuscatedName("l")
	static byte field3159;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 2084935355
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -117498157
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = 1642839291
	)
	static int field3162;

	static {
		NetCache_loadTime = 0;
		NetCache_pendingPriorityWrites = new NodeHashTable(4096);
		NetCache_pendingPriorityWritesCount = 0;
		NetCache_pendingPriorityResponses = new NodeHashTable(32);
		NetCache_pendingPriorityResponsesCount = 0;
		NetCache_pendingWritesQueue = new DualNodeDeque();
		NetCache_pendingWrites = new NodeHashTable(4096);
		NetCache_pendingWritesCount = 0;
		NetCache_pendingResponses = new NodeHashTable(4096);
		NetCache_pendingResponsesCount = 0;
		NetCache_responseHeaderBuffer = new Buffer(8);
		field3156 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field3159 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1171318227"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
		garbageValue = "-34"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuShiftClick[Client.menuOptionsCount] = var6;
				++Client.menuOptionsCount;
			}

		}
	}
}
