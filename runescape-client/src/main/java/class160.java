import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public final class class160 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -695453633
   )
   int field2130;
   @ObfuscatedName("d")
   int[] field2131 = new int[256];
   @ObfuscatedName("k")
   int[] field2132 = new int[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1591947921
   )
   int field2133;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1011150373
   )
   int field2134;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -494242273
   )
   int field2135;

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2131[var2] = var1[var2];
      }

      this.method3068();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1925830734"
   )
   final int method3066() {
      if(--this.field2133 + 1 == 0) {
         this.method3073();
         this.field2133 = 255;
      }

      return this.field2131[this.field2133];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "952084789"
   )
   final void method3068() {
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
         var2 += this.field2131[var1];
         var3 += this.field2131[var1 + 1];
         var4 += this.field2131[var1 + 2];
         var5 += this.field2131[var1 + 3];
         var6 += this.field2131[var1 + 4];
         var7 += this.field2131[var1 + 5];
         var8 += this.field2131[6 + var1];
         var9 += this.field2131[var1 + 7];
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
         this.field2132[var1] = var2;
         this.field2132[var1 + 1] = var3;
         this.field2132[var1 + 2] = var4;
         this.field2132[3 + var1] = var5;
         this.field2132[var1 + 4] = var6;
         this.field2132[var1 + 5] = var7;
         this.field2132[var1 + 6] = var8;
         this.field2132[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2132[var1];
         var3 += this.field2132[var1 + 1];
         var4 += this.field2132[2 + var1];
         var5 += this.field2132[var1 + 3];
         var6 += this.field2132[4 + var1];
         var7 += this.field2132[var1 + 5];
         var8 += this.field2132[var1 + 6];
         var9 += this.field2132[7 + var1];
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
         this.field2132[var1] = var2;
         this.field2132[1 + var1] = var3;
         this.field2132[var1 + 2] = var4;
         this.field2132[3 + var1] = var5;
         this.field2132[var1 + 4] = var6;
         this.field2132[var1 + 5] = var7;
         this.field2132[6 + var1] = var8;
         this.field2132[7 + var1] = var9;
      }

      this.method3073();
      this.field2133 = 256;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1570906728"
   )
   final void method3073() {
      this.field2134 += ++this.field2135;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2132[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2130 ^= this.field2130 << 13;
            } else {
               this.field2130 ^= this.field2130 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2130 ^= this.field2130 << 2;
         } else {
            this.field2130 ^= this.field2130 >>> 16;
         }

         this.field2130 += this.field2132[128 + var1 & 255];
         int var3;
         this.field2132[var1] = var3 = this.field2134 + this.field2132[(var2 & 1020) >> 2] + this.field2130;
         this.field2131[var1] = this.field2134 = var2 + this.field2132[(var3 >> 8 & 1020) >> 2];
      }

   }
}
