import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static SpritePixels field1387;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1828584981
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -717567387
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   protected final Model getModel() {
      return class81.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILfv;Lfa;I)Z",
      garbageValue = "1955889612"
   )
   static final boolean method1972(int var0, int var1, class178 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class177.field2249[var6][var7] = 99;
      class177.field2250[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class177.field2251[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class177.field2253[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class177.field2251[var11];
         var5 = class177.field2253[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3427(2, var4, var5, var3)) {
            UnitPriceComparator.field297 = var4;
            TotalQuantityComparator.field282 = var5;
            return true;
         }

         int var15 = class177.field2250[var16][var17] + 1;
         if(var16 > 0 && class177.field2249[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17] = 2;
            class177.field2250[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class177.field2249[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17] = 8;
            class177.field2250[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class177.field2249[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class177.field2251[var18] = var4;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16][var17 - 1] = 1;
            class177.field2250[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class177.field2249[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class177.field2251[var18] = var4;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16][var17 + 1] = 4;
            class177.field2250[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class177.field2249[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17 - 1] = 3;
            class177.field2250[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class177.field2249[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17 - 1] = 9;
            class177.field2250[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class177.field2249[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class177.field2251[var18] = var4 - 1;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 - 1][var17 + 1] = 6;
            class177.field2250[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class177.field2249[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class177.field2251[var18] = var4 + 1;
            class177.field2253[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class177.field2249[var16 + 1][var17 + 1] = 12;
            class177.field2250[var16 + 1][var17 + 1] = var15;
         }
      }

      UnitPriceComparator.field297 = var4;
      TotalQuantityComparator.field282 = var5;
      return false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Lla;",
      garbageValue = "-56"
   )
   static SpritePixels method1973() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class332.field3995;
      var0.maxHeight = class332.field3996;
      var0.offsetX = class90.field1360[0];
      var0.offsetY = class153.offsetsY[0];
      var0.width = class332.field3998[0];
      var0.height = GrandExchangeOffer.field294[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = ClassInfo.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class332.field3994[var2[var3] & 255];
      }

      class316.method5605();
      return var0;
   }
}
