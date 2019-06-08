import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("NetCache")
public class NetCache {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("NetCache_socket")
   public static AbstractSocket NetCache_socket;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 948359621
   )
   @Export("__iq_f")
   public static int __iq_f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -4580427166942649525L
   )
   @Export("__iq_q")
   public static long __iq_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static NodeHashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1495729287
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static NodeHashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 516430597
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static DualNodeDeque NetCache_pendingWritesQueue;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("NetCache_pendingWrites")
   public static NodeHashTable NetCache_pendingWrites;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1592359229
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("NetCache_pendingResponses")
   public static NodeHashTable NetCache_pendingResponses;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1627751389
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 840549915
   )
   @Export("__iq_j")
   public static int __iq_j;
   @ObfuscatedName("t")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lit;"
   )
   @Export("NetCache_indexCaches")
   public static IndexCache[] NetCache_indexCaches;
   @ObfuscatedName("b")
   @Export("__iq_b")
   public static byte __iq_b;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1404585009
   )
   @Export("NetCache_crcMismatches")
   public static int NetCache_crcMismatches;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1141619871
   )
   @Export("NetCache_ioExceptions")
   public static int NetCache_ioExceptions;

   static {
      __iq_f = 0;
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
      __iq_j = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexCache[256];
      __iq_b = 0;
      NetCache_crcMismatches = 0;
      NetCache_ioExceptions = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lbm;",
      garbageValue = "31"
   )
   static Message method4708(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }
}
