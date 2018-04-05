import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class265 {
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   static JagexGame field3435;
   @ObfuscatedName("o")
   final HashMap field3438;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   Bounds field3437;
   @ObfuscatedName("t")
   int[] field3434;
   @ObfuscatedName("d")
   int[] field3433;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1680279677
   )
   int field3436;

   public class265() {
      this.field3438 = new HashMap();
      this.field3437 = new Bounds(0, 0);
      this.field3434 = new int[2048];
      this.field3433 = new int[2048];
      this.field3436 = 0;
      class190.method3488();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1721178400"
   )
   void method4685(int var1) {
      int var2 = var1 * 2 + 1;
      double var4 = (double)((float)var1 / 3.0F);
      int var6 = var1 * 2 + 1;
      double[] var7 = new double[var6];
      int var8 = -var1;

      for(int var9 = 0; var8 <= var1; ++var9) {
         double var16 = (double)(var8 - 0) / var4;
         double var14 = Math.exp(var16 * -var16 / 2.0D) / Math.sqrt(6.283185307179586D);
         double var12 = var14 / var4;
         var7[var9] = var12;
         ++var8;
      }

      double[] var18 = var7;
      double var19 = var7[var1] * var7[var1];
      int[] var21 = new int[var2 * var2];
      boolean var22 = false;

      for(int var11 = 0; var11 < var2; ++var11) {
         for(int var23 = 0; var23 < var2; ++var23) {
            int var13 = var21[var23 + var11 * var2] = (int)(var18[var23] * var18[var11] / var19 * 256.0D);
            if(!var22 && var13 > 0) {
               var22 = true;
            }
         }
      }

      SpritePixels var24 = new SpritePixels(var21, var2, var2);
      this.field3438.put(Integer.valueOf(var1), var24);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lld;",
      garbageValue = "0"
   )
   SpritePixels method4686(int var1) {
      if(!this.field3438.containsKey(Integer.valueOf(var1))) {
         this.method4685(var1);
      }

      return (SpritePixels)this.field3438.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1271401500"
   )
   public final void method4703(int var1, int var2) {
      if(this.field3436 < this.field3434.length) {
         this.field3434[this.field3436] = var1;
         this.field3433[this.field3436] = var2;
         ++this.field3436;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   public final void method4688() {
      this.field3436 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILld;FI)V",
      garbageValue = "1332011564"
   )
   public final void method4689(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method4686(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3437.method5676(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3436; ++var10) {
         var11 = this.field3434[var10];
         var12 = this.field3433[var10];
         int var13 = (int)((float)(var11 - var1) * var4) - var5;
         int var14 = (int)((float)var3.height - var4 * (float)(var12 - var2)) - var5;
         this.field3437.method5675(var13, var14);
         this.field3437.method5680(var8, var9);
         this.method4690(var6, var3, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < var3.pixels.length; ++var10) {
         if(var3.pixels[var10] == 0) {
            var3.pixels[var10] = -16777216;
         } else {
            var11 = (var3.pixels[var10] + 64 - 1) / 256;
            if(var11 <= 0) {
               var3.pixels[var10] = -16777216;
            } else {
               if(var11 > class95.field1449.length) {
                  var11 = class95.field1449.length;
               }

               var12 = class95.field1449[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lld;Lld;Llx;I)V",
      garbageValue = "-952673466"
   )
   void method4690(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3942 != 0 && var3.field3944 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3943 == 0) {
            var4 = var1.width - var3.field3942;
         }

         if(var3.field3941 == 0) {
            var5 = var1.height - var3.field3944;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var3.field3943 + var2.width * var3.field3941;

         for(int var8 = 0; var8 < var3.field3944; ++var8) {
            for(int var9 = 0; var9 < var3.field3942; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3942;
            var7 += var2.width - var3.field3942;
         }

      }
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "818971986"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class62.tileHeights[var5][var3][var4] + class62.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class62.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lin;I)Lin;",
      garbageValue = "428792013"
   )
   static Widget method4692(Widget var0) {
      int var1 = FriendManager.method1792(GroundObject.getWidgetClickMask(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class44.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
