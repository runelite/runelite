import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class249 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("NetCache_socket")
   public static class159 NetCache_socket;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -347924717
   )
   public static int field3359;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7943551848976075783L
   )
   public static long field3346;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static HashTable NetCache_pendingPriorityWrites;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 676287897
   )
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static HashTable NetCache_pendingPriorityResponses;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1638864385
   )
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static Node2LinkedList NetCache_pendingWritesQueue;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("NetCache_pendingWrites")
   static HashTable NetCache_pendingWrites;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1269568131
   )
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("NetCache_pendingResponses")
   public static HashTable NetCache_pendingResponses;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -831740745
   )
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2132367903
   )
   public static int field3360;
   @ObfuscatedName("m")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lif;"
   )
   @Export("NetCache_indexCaches")
   public static IndexData[] NetCache_indexCaches;
   @ObfuscatedName("j")
   public static byte field3364;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 490659519
   )
   public static int field3361;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 343512447
   )
   public static int field3362;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 2121450547
   )
   static int field3363;

   static {
      field3359 = 0;
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
      field3360 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3364 = 0;
      field3361 = 0;
      field3362 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;I)V",
      garbageValue = "333212983"
   )
   public static void method4458(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3455 = var0;
      CombatInfo2.field3453 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "392798794"
   )
   public static final void method4459(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lbm;B)V",
      garbageValue = "2"
   )
   static final void method4460(Actor var0) {
      if(var0.field1196 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1159 + 1 > class45.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1196 - var0.field1200;
         int var2 = Client.gameCycle - var0.field1200;
         int var3 = var0.field1191 * 128 + var0.field1153 * 64;
         int var4 = var0.field1193 * 128 + var0.field1153 * 64;
         int var5 = var0.field1174 * 128 + var0.field1153 * 64;
         int var6 = var0.field1206 * 128 + var0.field1153 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field1207 = 0;
      var0.orientation = var0.field1197;
      var0.angle = var0.orientation;
   }
}
