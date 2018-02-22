import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class258 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("NetCache_socket")
   public static class168 NetCache_socket;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -729983657
   )
   public static int field3373;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 3775902982471786285L
   )
   public static long field3358;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 660522085
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 386185521
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("NetCache_pendingWrites")
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -996183721
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1269015831
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1885459699
   )
   public static int field3369;
   @ObfuscatedName("x")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lia;"
   )
   @Export("NetCache_indexCaches")
   public static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("z")
   public static byte field3372;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1440099453
   )
   public static int field3367;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1806129207
   )
   public static int field3374;

   static {
      field3373 = 0;
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
      field3369 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3372 = 0;
      field3367 = 0;
      field3374 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lie;IIB)Z",
      garbageValue = "97"
   )
   static boolean method4705(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         FloorUnderlayDefinition.decodeSprite(var3);
         return true;
      }
   }
}
