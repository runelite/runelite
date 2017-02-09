import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class167 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1631660567
   )
   int field2298;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -842031461
   )
   int field2300;
   @ObfuscatedName("w")
   int[] field2302 = new int[256];
   @ObfuscatedName("j")
   int[] field2303 = new int[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1922689365
   )
   int field2304;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1585583737
   )
   int field2306;
   @ObfuscatedName("c")
   public static short[][] field2307;
   @ObfuscatedName("co")
   static class110 field2308;

   class167(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2302[var2] = var1[var2];
      }

      this.method3202();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1691281511"
   )
   final void method3201() {
      this.field2300 += ++this.field2306;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2303[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2304 ^= this.field2304 << 13;
            } else {
               this.field2304 ^= this.field2304 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2304 ^= this.field2304 << 2;
         } else {
            this.field2304 ^= this.field2304 >>> 16;
         }

         this.field2304 += this.field2303[var1 + 128 & 255];
         int var3;
         this.field2303[var1] = var3 = this.field2300 + this.field2303[(var2 & 1020) >> 2] + this.field2304;
         this.field2302[var1] = this.field2300 = var2 + this.field2303[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "512612828"
   )
   final void method3202() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2302[var1];
         var3 += this.field2302[1 + var1];
         var4 += this.field2302[2 + var1];
         var5 += this.field2302[3 + var1];
         var6 += this.field2302[4 + var1];
         var7 += this.field2302[var1 + 5];
         var8 += this.field2302[6 + var1];
         var9 += this.field2302[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2303[var1] = var2;
         this.field2303[1 + var1] = var3;
         this.field2303[var1 + 2] = var4;
         this.field2303[3 + var1] = var5;
         this.field2303[4 + var1] = var6;
         this.field2303[var1 + 5] = var7;
         this.field2303[var1 + 6] = var8;
         this.field2303[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2303[var1];
         var3 += this.field2303[1 + var1];
         var4 += this.field2303[var1 + 2];
         var5 += this.field2303[3 + var1];
         var6 += this.field2303[var1 + 4];
         var7 += this.field2303[5 + var1];
         var8 += this.field2303[6 + var1];
         var9 += this.field2303[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2303[var1] = var2;
         this.field2303[1 + var1] = var3;
         this.field2303[var1 + 2] = var4;
         this.field2303[var1 + 3] = var5;
         this.field2303[var1 + 4] = var6;
         this.field2303[5 + var1] = var7;
         this.field2303[6 + var1] = var8;
         this.field2303[7 + var1] = var9;
      }

      this.method3201();
      this.field2298 = 256;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-55"
   )
   final int method3204() {
      if(--this.field2298 + 1 == 0) {
         this.method3201();
         this.field2298 = 255;
      }

      return this.field2302[this.field2298];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "0"
   )
   public static ModIcon method3205(class182 var0, String var1, String var2) {
      int var3 = var0.method3284(var1);
      int var4 = var0.method3285(var3, var2);
      ModIcon var5;
      if(!class63.method1175(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class225.field3212;
         var7.originalHeight = class225.field3213;
         var7.offsetX = class163.field2287[0];
         var7.offsetY = class225.field3214[0];
         var7.originalWidth = class47.field932[0];
         var7.height = class225.field3211[0];
         var7.palette = class225.field3215;
         var7.pixels = class225.field3218[0];
         class221.method4056();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;S)V",
      garbageValue = "25646"
   )
   public static void method3207(class182 var0, class182 var1, class182 var2) {
      class196.field2871 = var0;
      class196.field2850 = var1;
      class196.field2852 = var2;
   }
}
