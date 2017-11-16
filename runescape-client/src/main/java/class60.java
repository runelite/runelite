import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public final class class60 {
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 839376519
   )
   static int field696;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static IndexData field697;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;IIB)Lks;",
      garbageValue = "-74"
   )
   static IndexedSprite method971(IndexDataBase var0, int var1, int var2) {
      if(!Sequence.method4738(var0, var1, var2)) {
         return null;
      } else {
         IndexedSprite var4 = new IndexedSprite();
         var4.width = class295.field3846;
         var4.originalHeight = class224.field2850;
         var4.offsetX = WidgetNode.field774[0];
         var4.offsetY = class285.offsetsY[0];
         var4.originalWidth = class295.field3848[0];
         var4.height = class295.field3845[0];
         var4.palette = class278.field3733;
         var4.pixels = class70.spritePixels[0];
         class274.method4876();
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-626520785"
   )
   static void method970() {
      if(class91.field1352 && class91.username != null && class91.username.length() > 0) {
         class91.field1356 = 1;
      } else {
         class91.field1356 = 0;
      }

   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbj;I)V",
      garbageValue = "87626351"
   )
   static final void method967(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = Client.region.method2714(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = Client.region.method2740(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = Client.region.method2716(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = Client.region.method2717(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = Client.region.method2718(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1133 = var2;
      var0.field1138 = var3;
      var0.field1132 = var4;
   }
}
