import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class265 {
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 1200953897
   )
   static int field3432;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1117451153
   )
   static int field3431;
   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("g")
   final HashMap field3425;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lls;"
   )
   Bounds field3426;
   @ObfuscatedName("b")
   int[] field3427;
   @ObfuscatedName("z")
   int[] field3428;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2044633675
   )
   int field3429;

   public class265() {
      this.field3425 = new HashMap();
      this.field3426 = new Bounds(0, 0);
      this.field3427 = new int[2048];
      this.field3428 = new int[2048];
      this.field3429 = 0;
      class189.field2514 = new int[2000];
      int var1 = 0;
      int var2 = 240;

      int var4;
      for(byte var3 = 12; var1 < 16; var2 -= var3) {
         var4 = GrandExchangeEvents.method83((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)((float)var1 * 0.425F / 16.0F + 0.075F));
         class189.field2514[var1] = var4;
         ++var1;
      }

      var2 = 48;

      for(int var6 = var2 / 6; var1 < class189.field2514.length; var2 -= var6) {
         var4 = var1 * 2;

         for(int var5 = GrandExchangeEvents.method83((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class189.field2514.length; ++var1) {
            class189.field2514[var1] = var5;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1585613931"
   )
   void method4812(int var1) {
      int var2 = var1 * 2 + 1;
      double var4 = (double)((float)var1 / 3.0F);
      int var6 = var1 * 2 + 1;
      double[] var7 = new double[var6];
      int var8 = -var1;

      for(int var9 = 0; var8 <= var1; ++var9) {
         double var16 = (double)(var8 - 0) / var4;
         double var14 = Math.exp(-var16 * var16 / 2.0D) / Math.sqrt(6.283185307179586D);
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
      this.field3425.put(Integer.valueOf(var1), var24);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Llv;",
      garbageValue = "1553568578"
   )
   SpritePixels method4810(int var1) {
      if(!this.field3425.containsKey(Integer.valueOf(var1))) {
         this.method4812(var1);
      }

      return (SpritePixels)this.field3425.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1034061060"
   )
   public final void method4811(int var1, int var2) {
      if(this.field3429 < this.field3427.length) {
         this.field3427[this.field3429] = var1;
         this.field3428[this.field3429] = var2;
         ++this.field3429;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1418800696"
   )
   public final void method4819() {
      this.field3429 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILlv;FB)V",
      garbageValue = "0"
   )
   public final void method4822(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method4810(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3426.method5761(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3429; ++var10) {
         var11 = this.field3427[var10];
         var12 = this.field3428[var10];
         int var13 = (int)((float)(var11 - var1) * var4) - var5;
         int var14 = (int)((float)var3.height - var4 * (float)(var12 - var2)) - var5;
         this.field3426.method5765(var13, var14);
         this.field3426.method5762(var8, var9);
         this.method4813(var6, var3, var9);
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
               if(var11 > class189.field2514.length) {
                  var11 = class189.field2514.length;
               }

               var12 = class189.field2514[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Llv;Llv;Lls;S)V",
      garbageValue = "-25329"
   )
   void method4813(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3946 != 0 && var3.field3944 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3947 == 0) {
            var4 = var1.width - var3.field3946;
         }

         if(var3.field3945 == 0) {
            var5 = var1.height - var3.field3944;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var3.field3947 + var2.width * var3.field3945;

         for(int var8 = 0; var8 < var3.field3944; ++var8) {
            for(int var9 = 0; var9 < var3.field3946; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3946;
            var7 += var2.width - var3.field3946;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)Llv;",
      garbageValue = "690556823"
   )
   public static final SpritePixels method4809(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }
}
