import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class183 {
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1256959767
   )
   static int field2466;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2461;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2456;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2459;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2458;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2455;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2460;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2457;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2462;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2463;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final class183 field2464;

   static {
      field2461 = new class183(14);
      field2456 = new class183(6);
      field2459 = new class183(2);
      field2458 = new class183(5);
      field2455 = new class183(3);
      field2460 = new class183(4);
      field2457 = new class183(15);
      field2462 = new class183(7);
      field2463 = new class183(4);
      field2464 = new class183(5);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "14"
   )
   class183(int var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lkw;",
      garbageValue = "1673544079"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "31"
   )
   public static void method3434(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      CombatInfo1.method1668(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-711409666"
   )
   static final void method3433() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.hitpoints == 0) {
            if(var0.field1125 >= 0) {
               var2 = var0.field1125;
               var3 = var0.field1121;
               var4 = Spotanim.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method5025(var3);
               if(!var1) {
                  continue;
               }
            }

            class57.method883(var0.level, var0.type, var0.x, var0.y, var0.field1125, var0.field1126, var0.field1121);
            var0.unlink();
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if(var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field1129;
                  var4 = Spotanim.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method5025(var3);
                  if(!var1) {
                     continue;
                  }
               }

               class57.method883(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1129);
               var0.delay = -1;
               if(var0.field1125 == var0.id && var0.field1125 == -1) {
                  var0.unlink();
               } else if(var0.field1125 == var0.id && var0.orientation == var0.field1126 && var0.field1121 == var0.field1129) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
