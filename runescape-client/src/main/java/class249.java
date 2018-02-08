import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class249 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1929726951
   )
   public static int field3342;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 3952910380756846447L
   )
   public static long field3337;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -630828553
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -625429309
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 611317079
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -283085341
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1320551063
   )
   public static int field3338;
   @ObfuscatedName("b")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Lij;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("n")
   public static byte field3353;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -639126729
   )
   public static int field3354;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -321343373
   )
   public static int field3355;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1177953225
   )
   static int field3357;

   static {
      field3342 = 0;
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
      field3338 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3353 = 0;
      field3354 = 0;
      field3355 = 0;
   }
}
