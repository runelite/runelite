import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public final class class160 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1559515937
   )
   int field2124;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2124373957
   )
   int field2125;
   @ObfuscatedName("y")
   int[] field2126 = new int[256];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -501473121
   )
   int field2127;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 728371095
   )
   int field2129;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -683541167
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("p")
   int[] field2134 = new int[256];

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2126[var2] = var1[var2];
      }

      this.method3169();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1967989728"
   )
   final void method3168() {
      this.field2125 += ++this.field2129;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2134[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2127 ^= this.field2127 << 13;
            } else {
               this.field2127 ^= this.field2127 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2127 ^= this.field2127 << 2;
         } else {
            this.field2127 ^= this.field2127 >>> 16;
         }

         this.field2127 += this.field2134[var1 + 128 & 255];
         int var3;
         this.field2134[var1] = var3 = this.field2125 + this.field2127 + this.field2134[(var2 & 1020) >> 2];
         this.field2126[var1] = this.field2125 = var2 + this.field2134[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "11379926"
   )
   final void method3169() {
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
         var2 += this.field2126[var1];
         var3 += this.field2126[1 + var1];
         var4 += this.field2126[var1 + 2];
         var5 += this.field2126[3 + var1];
         var6 += this.field2126[4 + var1];
         var7 += this.field2126[var1 + 5];
         var8 += this.field2126[6 + var1];
         var9 += this.field2126[var1 + 7];
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
         this.field2134[var1] = var2;
         this.field2134[var1 + 1] = var3;
         this.field2134[2 + var1] = var4;
         this.field2134[3 + var1] = var5;
         this.field2134[var1 + 4] = var6;
         this.field2134[5 + var1] = var7;
         this.field2134[6 + var1] = var8;
         this.field2134[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2134[var1];
         var3 += this.field2134[var1 + 1];
         var4 += this.field2134[var1 + 2];
         var5 += this.field2134[3 + var1];
         var6 += this.field2134[var1 + 4];
         var7 += this.field2134[5 + var1];
         var8 += this.field2134[6 + var1];
         var9 += this.field2134[var1 + 7];
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
         this.field2134[var1] = var2;
         this.field2134[1 + var1] = var3;
         this.field2134[2 + var1] = var4;
         this.field2134[3 + var1] = var5;
         this.field2134[4 + var1] = var6;
         this.field2134[var1 + 5] = var7;
         this.field2134[var1 + 6] = var8;
         this.field2134[var1 + 7] = var9;
      }

      this.method3168();
      this.field2124 = 256;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "24534"
   )
   final int method3174() {
      if(--this.field2124 + 1 == 0) {
         this.method3168();
         this.field2124 = 255;
      }

      return this.field2126[this.field2124];
   }
}
