import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class100 extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 959359777
   )
   int field1553;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 758723279
   )
   int field1554;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -48747735
   )
   int field1555;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2083681593
   )
   int field1556;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 677869865
   )
   int field1557;
   @ObfuscatedName("d")
   static int[] field1558;
   @ObfuscatedName("h")
   Sequence field1559;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2080307207
   )
   int field1560;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1544042567
   )
   int field1561;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1590290143
   )
   int field1563;
   @ObfuscatedName("ff")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      if(this.field1559 != null) {
         int var12 = Client.gameCycle - this.field1561;
         if(var12 > 100 && this.field1559.frameStep > 0) {
            var12 = 100;
         }

         label69: {
            do {
               do {
                  if(var12 <= this.field1559.frameLenghts[this.field1560]) {
                     break label69;
                  }

                  var12 -= this.field1559.frameLenghts[this.field1560];
                  ++this.field1560;
               } while(this.field1560 < this.field1559.frameIDs.length);

               this.field1560 -= this.field1559.frameStep;
            } while(this.field1560 >= 0 && this.field1560 < this.field1559.frameIDs.length);

            this.field1559 = null;
         }

         this.field1561 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class226.getObjectDefinition(this.field1563);
      if(var1.impostorIds != null) {
         var1 = var1.getImpostor();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field1556 != 1 && this.field1556 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = (var2 >> 1) + this.field1553;
         int var5 = (var2 + 1 >> 1) + this.field1553;
         int var6 = this.field1555 + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.field1555;
         int[][] var8 = class61.tileHeights[this.field1557];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.field1553 << 7);
         int var11 = (var3 << 6) + (this.field1555 << 7);
         return var1.method4532(this.field1554, this.field1556, var8, var10, var9, var11, this.field1559, this.field1560);
      }
   }

   class100(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field1563 = var1;
      this.field1554 = var2;
      this.field1556 = var3;
      this.field1557 = var4;
      this.field1553 = var5;
      this.field1555 = var6;
      if(var7 != -1) {
         this.field1559 = class227.getAnimation(var7);
         this.field1560 = 0;
         this.field1561 = Client.gameCycle - 1;
         if(this.field1559.replyMode == 0 && var9 != null && var9 instanceof class100) {
            class100 var10 = (class100)var9;
            if(this.field1559 == var10.field1559) {
               this.field1560 = var10.field1560;
               this.field1561 = var10.field1561;
               return;
            }
         }

         if(var8 && this.field1559.frameStep != -1) {
            this.field1560 = (int)(Math.random() * (double)this.field1559.frameIDs.length);
            this.field1561 -= (int)(Math.random() * (double)this.field1559.frameLenghts[this.field1560]);
         }
      }

   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1269813310"
   )
   static final void method1855(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field1046 && var0 != FaceNormal.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class1.region.method2704(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class1.region.method2701(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class1.region.method2702(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class1.region.method2703(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class1.region.method2835(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class1.region.method2772(var0, var2, var3);
               var12 = class226.getObjectDefinition(var13);
               if(var12.field3471 != 0) {
                  Client.collisionMaps[var0].method3026(var2, var3, var14, var15, var12.field3450);
               }
            }

            if(var1 == 1) {
               class1.region.method2692(var0, var2, var3);
            }

            if(var1 == 2) {
               class1.region.method2822(var0, var2, var3);
               var12 = class226.getObjectDefinition(var13);
               if(var12.sizeX + var2 > 103 || var3 + var12.sizeX > 103 || var12.sizeY + var2 > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.field3471 != 0) {
                  Client.collisionMaps[var0].method3027(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3450);
               }
            }

            if(var1 == 3) {
               class1.region.method2694(var0, var2, var3);
               var12 = class226.getObjectDefinition(var13);
               if(var12.field3471 == 1) {
                  Client.collisionMaps[var0].method3029(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            CombatInfo1.method1535(var0, var11, var2, var3, var4, var5, var6, class1.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lclass230;",
      garbageValue = "1506539763"
   )
   public static class230[] method1857() {
      return new class230[]{class230.field3167, class230.field3170, class230.field3165, class230.field3168, class230.field3172, class230.field3166};
   }
}
