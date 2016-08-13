import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("g")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("l")
   @Export("name")
   String name;
   @ObfuscatedName("cu")
   static class227 field133;
   @ObfuscatedName("dt")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("bn")
   static class171 field137;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1061965560"
   )
   static void method111(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3936((long)var0);
      if(var1 != null) {
         var1.unlink();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)[LSpritePixels;",
      garbageValue = "128"
   )
   static SpritePixels[] method112() {
      SpritePixels[] var0 = new SpritePixels[class79.field1466];

      for(int var1 = 0; var1 < class79.field1466; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.field1484 = class79.field1454;
         var2.field1483 = class79.field1456;
         var2.field1480 = class79.field1457[var1];
         var2.field1478 = class180.field2962[var1];
         var2.width = class192.field3106[var1];
         var2.height = class79.field1458[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class145.field2236[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class79.field1459[var4[var5] & 255];
         }
      }

      ItemComposition.method1182();
      return var0;
   }
}
