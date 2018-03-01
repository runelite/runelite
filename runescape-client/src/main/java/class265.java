import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public class class265 {
   @ObfuscatedName("p")
   static int[] field3425;
   @ObfuscatedName("d")
   final HashMap field3429;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   Bounds field3426;
   @ObfuscatedName("n")
   int[] field3427;
   @ObfuscatedName("r")
   int[] field3431;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 953935557
   )
   int field3428;

   public class265() {
      this.field3429 = new HashMap();
      this.field3426 = new Bounds(0, 0);
      this.field3427 = new int[2048];
      this.field3431 = new int[2048];
      this.field3428 = 0;
      GrandExchangeEvents.method79();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-96929879"
   )
   void method4823(int var1) {
      int var2 = var1 * 2 + 1;
      double[] var3 = MouseInput.method1012(0.0D, (double)((float)var1 / 3.0F), var1);
      double var4 = var3[var1] * var3[var1];
      int[] var6 = new int[var2 * var2];
      boolean var7 = false;

      for(int var8 = 0; var8 < var2; ++var8) {
         for(int var9 = 0; var9 < var2; ++var9) {
            int var10 = var6[var9 + var8 * var2] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
            if(!var7 && var10 > 0) {
               var7 = true;
            }
         }
      }

      SpritePixels var11 = new SpritePixels(var6, var2, var2);
      this.field3429.put(Integer.valueOf(var1), var11);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lly;",
      garbageValue = "1965773846"
   )
   SpritePixels method4845(int var1) {
      if(!this.field3429.containsKey(Integer.valueOf(var1))) {
         this.method4823(var1);
      }

      return (SpritePixels)this.field3429.get(Integer.valueOf(var1));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1756037973"
   )
   public final void method4824(int var1, int var2) {
      if(this.field3428 < this.field3427.length) {
         this.field3427[this.field3428] = var1;
         this.field3431[this.field3428] = var2;
         ++this.field3428;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-748052701"
   )
   public final void method4825() {
      this.field3428 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILly;FI)V",
      garbageValue = "-772457298"
   )
   public final void method4842(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method4845(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.width, var3.height);
      Bounds var9 = new Bounds(0, 0);
      this.field3426.method5756(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3428; ++var10) {
         var11 = this.field3427[var10];
         var12 = this.field3431[var10];
         int var13 = (int)((float)(var11 - var1) * var4) - var5;
         int var14 = (int)((float)var3.height - (float)(var12 - var2) * var4) - var5;
         this.field3426.method5760(var13, var14);
         this.field3426.method5758(var8, var9);
         this.method4827(var6, var3, var9);
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
               if(var11 > field3425.length) {
                  var11 = field3425.length;
               }

               var12 = field3425[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lly;Lly;Llj;I)V",
      garbageValue = "744078436"
   )
   void method4827(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if(var3.field3937 != 0 && var3.field3936 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3939 == 0) {
            var4 = var1.width - var3.field3937;
         }

         if(var3.field3935 == 0) {
            var5 = var1.height - var3.field3936;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var2.width * var3.field3935 + var3.field3939;

         for(int var8 = 0; var8 < var3.field3936; ++var8) {
            for(int var9 = 0; var9 < var3.field3937; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3937;
            var7 += var2.width - var3.field3937;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lju;",
      garbageValue = "1956872573"
   )
   public static class271 method4847(int var0) {
      class271 var1 = (class271)class271.field3476.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class271.field3475.getConfigData(15, var0);
         var1 = new class271();
         if(var2 != null) {
            var1.method4920(new Buffer(var2));
         }

         class271.field3476.put(var1, (long)var0);
         return var1;
      }
   }
}
