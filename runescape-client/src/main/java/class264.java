import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public class class264 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("NetCache_socket")
   public static class169 NetCache_socket;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1722172279
   )
   public static int field3403;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 5931005655431114003L
   )
   public static long field3404;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1737823381
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1063033309
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("NetCache_pendingWrites")
   public static HashTable NetCache_pendingWrites;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -87597517
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -531282915
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1286559281
   )
   public static int field3423;
   @ObfuscatedName("v")
   @Export("NetCache_crc")
   static CRC32 NetCache_crc;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("NetCache_reference")
   static Buffer NetCache_reference;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   @Export("NetCache_indexCaches")
   static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("w")
   public static byte field3419;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2023887943
   )
   public static int field3420;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 418238609
   )
   public static int field3415;
   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;

   static {
      field3403 = 0;
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
      field3423 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3419 = 0;
      field3420 = 0;
      field3415 = 0;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1351099264"
   )
   static void method4807() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --var0;
            --Client.menuOptionCount;
         }
      }

      class28.method243();
   }
}
