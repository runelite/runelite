import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1630504157
	)
	@Export("NetCache_loadTime")
	public static int NetCache_loadTime;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		longValue = 7111206406061673093L
	)
	public static long field3138;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingPriorityWrites")
	public static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1216011111
	)
	@Export("NetCache_pendingPriorityWritesCount")
	public static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingPriorityResponses")
	public static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1365764657
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	public static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lin;"
	)
	@Export("NetCache_pendingWritesQueue")
	public static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2110572147
	)
	@Export("NetCache_pendingWritesCount")
	public static int NetCache_pendingWritesCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingResponses")
	public static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 756706735
	)
	@Export("NetCache_pendingResponsesCount")
	public static int NetCache_pendingResponsesCount;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("NetCache_responseHeaderBuffer")
	public static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("NetCache_responseArchiveBuffer")
	public static Buffer NetCache_responseArchiveBuffer;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -910401727
	)
	public static int field3150;
	@ObfuscatedName("n")
	@Export("NetCache_crc")
	public static CRC32 NetCache_crc;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("NetCache_reference")
	public static Buffer NetCache_reference;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lif;"
	)
	@Export("NetCache_archives")
	public static Archive[] NetCache_archives;
	@ObfuscatedName("h")
	public static byte field3145;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 483863755
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1880063005
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;

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
		field3150 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field3145 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}
}
