import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class264 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("NetCache_socket")
   public static class169 NetCache_socket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1537397797
   )
   static int field3410;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 6773999145517654069L
   )
   static long field3413;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("NetCache_pendingPriorityWrites")
   static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1331152347
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("NetCache_pendingPriorityResponses")
   static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1149484045
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("NetCache_pendingWritesQueue")
   static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("NetCache_pendingWrites")
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -89930727
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("NetCache_pendingResponses")
   static HashTable NetCache_pendingResponses;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 870374293
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_responseHeaderBuffer")
   static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1308400321
   )
   static int field3416;
   @ObfuscatedName("t")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_reference")
   static Buffer NetCache_reference;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Ljs;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("u")
   static byte field3420;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1090514445
   )
   public static int field3423;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1469293039
   )
   public static int field3422;

   static {
      field3410 = 0;
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
      field3416 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3420 = 0;
      field3423 = 0;
      field3422 = 0;
   }
}
