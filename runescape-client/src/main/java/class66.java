import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class66 extends class203 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1711917877
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 310243575
   )
   int field761;
   @ObfuscatedName("s")
   String field769;
   @ObfuscatedName("r")
   short field762;

   class66(String var1, int var2) {
      this.field761 = (int)(ChatLineBuffer.currentTimeMs() / 1000L);
      this.field769 = var1;
      this.field762 = (short)var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Lia;",
      garbageValue = "-88"
   )
   public static class250 method1022(int var0) {
      class250 var1 = (class250)class250.field3367.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class250.field3369.getConfigData(19, var0);
         var1 = new class250();
         if(var2 != null) {
            var1.method4302(new Buffer(var2));
         }

         class250.field3367.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;ZI)V",
      garbageValue = "2030763867"
   )
   public static void method1024(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3487 = var1;
      ObjectComposition.field3526 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-230976993"
   )
   static void method1023() {
      if(class12.field256) {
         class91.field1331 = null;
         class273.field3711 = null;
         class91.field1332 = null;
         class243.field3292 = null;
         class230.field2910 = null;
         logoSprite = null;
         class268.titlemuteSprite = null;
         class91.field1351 = null;
         RSCanvas.field617 = null;
         class217.field2676 = null;
         Tile.field1829 = null;
         Frames.field2040 = null;
         class43.field527 = null;
         class20.field307 = null;
         class82.field1265 = null;
         class91.field1330 = null;
         class44.field540 = null;
         Friend.field758 = null;
         class164.field2208 = null;
         class91.field1364 = null;
         class21.field312 = null;
         class86.field1295 = null;
         class96.method1815(2);
         class3.sendConInfo(true);
         class12.field256 = false;
      }
   }
}
