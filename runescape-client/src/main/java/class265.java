import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public class class265 {
   @ObfuscatedName("p")
   static int[] field3436;
   @ObfuscatedName("t")
   final HashMap field3434;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llb;"
   )
   Bounds field3432;
   @ObfuscatedName("i")
   int[] field3433;
   @ObfuscatedName("a")
   int[] field3431;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -147149945
   )
   int field3435;

   public class265() {
      this.field3434 = new HashMap();
      this.field3432 = new Bounds(0, 0);
      this.field3433 = new int[2048];
      this.field3431 = new int[2048];
      this.field3435 = 0;
      field3436 = new int[2000];
      int var1 = 0;
      int var2 = 240;

      int var4;
      for(byte var3 = 12; var1 < 16; var2 -= var3) {
         var4 = BoundingBox3DDrawMode.method62((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + 0.425F * (float)var1 / 16.0F));
         field3436[var1] = var4;
         ++var1;
      }

      var2 = 48;

      for(int var6 = var2 / 6; var1 < field3436.length; var2 -= var6) {
         var4 = var1 * 2;

         for(int var5 = BoundingBox3DDrawMode.method62((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < field3436.length; ++var1) {
            field3436[var1] = var5;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1186692713"
   )
   void method4734(int var1) {
      int var2 = var1 * 2 + 1;
      double[] var3 = ISAACCipher.method3851(0.0D, (double)((float)var1 / 3.0F), var1);
      double var4 = var3[var1] * var3[var1];
      int[] var6 = new int[var2 * var2];
      boolean var7 = false;

      for(int var8 = 0; var8 < var2; ++var8) {
         for(int var9 = 0; var9 < var2; ++var9) {
            int var10 = var6[var9 + var8 * var2] = (int)(var3[var8] * var3[var9] / var4 * 256.0D);
            if(!var7 && var10 > 0) {
               var7 = true;
            }
         }
      }

      SpritePixels var11 = new SpritePixels(var6, var2, var2);
      this.field3434.put(Integer.valueOf(var1), var11);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lla;",
      garbageValue = "-1551115164"
   )
   SpritePixels method4724(int var1) {
      if(!this.field3434.containsKey(Integer.valueOf(var1))) {
         this.method4734(var1);
      }

      return (SpritePixels)this.field3434.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-83"
   )
   public final void method4739(int var1, int var2) {
      if(this.field3435 < this.field3433.length) {
         this.field3433[this.field3435] = var1;
         this.field3431[this.field3435] = var2;
         ++this.field3435;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-10618027"
   )
   public final void method4726() {
      this.field3435 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILla;FI)V",
      garbageValue = "-1052270597"
   )
   public final void method4727(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method4724(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3432.method5671(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3435; ++var10) {
         var11 = this.field3433[var10];
         var12 = this.field3431[var10];
         int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
         int var14 = (int)((float)var3.height - var4 * (float)(var12 - var2)) - var5;
         this.field3432.method5680(var13, var14);
         this.field3432.method5667(var8, var9);
         this.method4728(var6, var3, var9);
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
               if(var11 > field3436.length) {
                  var11 = field3436.length;
               }

               var12 = field3436[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;Llb;B)V",
      garbageValue = "-57"
   )
   void method4728(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3943 != 0 && var3.field3944 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3941 == 0) {
            var4 = var1.width - var3.field3943;
         }

         if(var3.field3942 == 0) {
            var5 = var1.height - var3.field3944;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var3.field3941 + var2.width * var3.field3942;

         for(int var8 = 0; var8 < var3.field3944; ++var8) {
            for(int var9 = 0; var9 < var3.field3943; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3943;
            var7 += var2.width - var3.field3943;
         }

      }
   }
}
