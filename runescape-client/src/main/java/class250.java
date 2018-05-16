import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class250 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("NetCache_socket")
   public static class157 NetCache_socket;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -292434043
   )
   public static int field3209;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3418162987922324045L
   )
   public static long field3223;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -957679387
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 832714855
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1476715115
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1943132599
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("s")
   static boolean field3220;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -5873175
   )
   public static int field3221;
   @ObfuscatedName("t")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lic;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("z")
   public static byte field3225;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -423946815
   )
   public static int field3226;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1107669235
   )
   public static int field3227;

   static {
      field3209 = 0;
      NetCache_pendingPriorityWrites = new HashTable(4096);
      NetCache_pendingPriorityWritesCount = 0;
      NetCache_pendingPriorityResponses = new HashTable(32);
      NetCache_pendingPriorityResponsesCount = 0;
      NetCache_pendingWritesQueue = new Node2LinkedList();
      NetCache_pendingWrites = new HashTable(4096);
      NetCache_pendingWritesCount = 0;
      NetCache_pendingResponses = new HashTable(4096);
      NetCache_pendingResponsesCount = 0;
      NetCache_responseHeaderBuffer = new Buffer(8);
      field3221 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3225 = 0;
      field3226 = 0;
      field3227 = 0;
   }
}
