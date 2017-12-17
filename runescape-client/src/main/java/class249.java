import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class249 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("NetCache_socket")
   public static class159 NetCache_socket;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 393490045
   )
   public static int field3344;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1407929151
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 791424375
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -28511567
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1116565755
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2062774323
   )
   public static int field3356;
   @ObfuscatedName("l")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Liu;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("b")
   public static byte field3358;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2044233407
   )
   public static int field3345;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2093659243
   )
   public static int field3360;

   static {
      field3344 = 0;
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
      field3356 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3358 = 0;
      field3345 = 0;
      field3360 = 0;
   }
}
