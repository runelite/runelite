import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class264 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1864691541
   )
   public static int field3417;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1858059941
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1517974733
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("NetCache_pendingWrites")
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1604757179
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1643319933
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("c")
   public static boolean field3422;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -905068247
   )
   public static int field3424;
   @ObfuscatedName("w")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lju;"
   )
   @Export("NetCache_indexCaches")
   public static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("f")
   public static byte field3427;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -580646341
   )
   public static int field3429;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2110903859
   )
   public static int field3413;
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   static SpritePixels[] field3430;

   static {
      field3417 = 0;
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
      field3424 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3427 = 0;
      field3429 = 0;
      field3413 = 0;
   }
}
