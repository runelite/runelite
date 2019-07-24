import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("NetCache_socket")
	public static AbstractSocket NetCache_socket;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 351053657
	)
	static int field3163;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = 906577835555410159L
	)
	static long field3169;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("NetCache_pendingPriorityWrites")
	static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -975999093
	)
	@Export("NetCache_pendingPriorityWritesCount")
	public static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("NetCache_pendingPriorityResponses")
	static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2100347839
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	public static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lix;"
	)
	@Export("NetCache_pendingWritesQueue")
	static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -478006427
	)
	@Export("NetCache_pendingWritesCount")
	public static int NetCache_pendingWritesCount;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("NetCache_pendingResponses")
	static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 302917267
	)
	@Export("NetCache_pendingResponsesCount")
	public static int NetCache_pendingResponsesCount;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("NetCache_responseHeaderBuffer")
	static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 266827
	)
	static int field3175;
	@ObfuscatedName("j")
	@Export("NetCache_crc")
	static CRC32 NetCache_crc;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Liu;"
	)
	@Export("NetCache_archives")
	static Archive[] NetCache_archives;
	@ObfuscatedName("o")
	static byte field3181;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 779627437
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1542260379
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;

	static {
		field3163 = 0;
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
		field3175 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field3181 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1775821653"
	)
	static void method4312(int var0, int var1) {
		int var2 = WorldMapIcon_1.fontBold12.stringWidth("Choose Option");

		int var3;
		int var4;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			var4 = WorldMapIcon_1.fontBold12.stringWidth(WorldMapLabel.method417(var3));
			if (var4 > var2) {
				var2 = var4;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		var4 = var0 - var2 / 2;
		if (var2 + var4 > GrandExchangeEvent.canvasWidth) {
			var4 = GrandExchangeEvent.canvasWidth - var2;
		}

		if (var4 < 0) {
			var4 = 0;
		}

		int var5 = var1;
		if (var3 + var1 > ParamDefinition.canvasHeight) {
			var5 = ParamDefinition.canvasHeight - var3;
		}

		if (var5 < 0) {
			var5 = 0;
		}

		class247.menuX = var4;
		class30.menuY = var5;
		class42.menuWidth = var2;
		ObjectSound.menuHeight = Client.menuOptionsCount * 15 + 22;
	}
}
