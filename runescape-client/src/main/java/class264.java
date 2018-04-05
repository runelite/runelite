import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class264 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("NetCache_socket")
   public static class169 NetCache_socket;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 192583571
   )
   static int field3416;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("NetCache_pendingPriorityWrites")
   static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -753694449
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("NetCache_pendingPriorityResponses")
   static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -718188931
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("NetCache_pendingWritesQueue")
   static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("NetCache_pendingWrites")
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -796228285
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("NetCache_pendingResponses")
   static HashTable NetCache_pendingResponses;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1876507379
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("w")
   static boolean field3419;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("NetCache_responseHeaderBuffer")
   static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2070852965
   )
   static int field3426;
   @ObfuscatedName("r")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ljn;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("g")
   static byte field3429;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -282038211
   )
   public static int field3430;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -480880319
   )
   public static int field3431;

   static {
      field3416 = 0;
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
      field3426 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3429 = 0;
      field3430 = 0;
      field3431 = 0;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1312471359"
   )
   static final void method4683(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         OwnWorldComparator.method1247(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1151 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "-180021579"
   )
   static void method4682(byte[] var0, int var1) {
      if(Client.field908 == null) {
         Client.field908 = new byte[24];
      }

      class205.method3828(var0, var1, Client.field908, 0, 24);
   }
}
