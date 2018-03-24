import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class37 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class37 field481;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class37 field482;
   @ObfuscatedName("a")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1619473099
   )
   final int field483;

   static {
      field481 = new class37(0);
      field482 = new class37(1);
   }

   class37(int var1) {
      this.field483 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public static void method541() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3398 != 0) {
            IndexStoreActionHandler.field3398 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2088682816"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   static void method538() {
      FileOnDisk var0 = null;

      try {
         var0 = class297.getPreferencesFile("", Client.field852.name, true);
         Buffer var1 = MapIcon.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1373496145"
   )
   static final void method539(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
         GZipDecompressor.method3474(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1129 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
