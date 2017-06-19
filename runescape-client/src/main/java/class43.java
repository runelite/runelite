import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class43 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -648255935
   )
   int field577;
   @ObfuscatedName("e")
   int[][] field578;
   @ObfuscatedName("t")
   int[][] field579;
   @ObfuscatedName("w")
   int[][] field580;
   @ObfuscatedName("z")
   int[][] field581;
   @ObfuscatedName("a")
   static Widget field582;
   @ObfuscatedName("h")
   static int[] field583;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -720564409
   )
   int field584;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;I)V",
      garbageValue = "-256599896"
   )
   void method589(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null && var3 + var1 >= 0 && var3 + var2 >= 0 && var1 - var3 <= this.field577 && var2 - var3 <= this.field584) {
         int var5 = Math.max(0, var1 - var3);
         int var6 = Math.min(this.field577, var3 + var1);
         int var7 = Math.max(0, var2 - var3);
         int var8 = Math.min(this.field584, var3 + var2);

         for(int var9 = var5; var9 < var6; ++var9) {
            for(int var10 = var7; var10 < var8; ++var10) {
               this.field578[var9][var10] += var4.field3356 * 256 / var4.field3353;
               this.field579[var9][var10] += var4.field3350;
               this.field580[var9][var10] += var4.field3352;
               ++this.field581[var9][var10];
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "115"
   )
   int method591(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field577 && var2 < this.field584) {
         if(this.field580[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field578[var1][var2] / this.field581[var1][var2];
            int var4 = this.field579[var1][var2] / this.field581[var1][var2];
            int var5 = this.field580[var1][var2] / this.field581[var1][var2];
            return DynamicObject.method1763((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field577 = var1;
      this.field584 = var2;
      this.field578 = new int[var1][var2];
      this.field579 = new int[var1][var2];
      this.field580 = new int[var1][var2];
      this.field581 = new int[var1][var2];
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "-1844381816"
   )
   static final void method594(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class136.SINE[var7];
         int var9 = class136.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var2 * var9 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class15.field300.method4997(var0 + var14 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class82.method1523(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1288723349"
   )
   static int method596(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)[LModIcon;",
      garbageValue = "-2006986958"
   )
   static ModIcon[] method597(IndexDataBase var0, int var1, int var2) {
      if(!class1.method3(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var3 = new ModIcon[class286.field3796];

         for(int var4 = 0; var4 < class286.field3796; ++var4) {
            ModIcon var5 = var3[var4] = new ModIcon();
            var5.width = class220.field2818;
            var5.originalHeight = class286.field3792;
            var5.offsetX = class286.field3793[var4];
            var5.offsetY = class286.field3794[var4];
            var5.originalWidth = class286.field3791[var4];
            var5.height = class149.field2211[var4];
            var5.palette = class116.field1686;
            var5.pixels = class286.field3797[var4];
         }

         class286.field3793 = null;
         class286.field3794 = null;
         class286.field3791 = null;
         class149.field2211 = null;
         class116.field1686 = null;
         class286.field3797 = (byte[][])((byte[][])null);
         return var3;
      }
   }
}
