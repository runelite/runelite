import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public final class class167 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 833379741
   )
   int field2330;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -121983921
   )
   int field2331;
   @ObfuscatedName("w")
   int[] field2332 = new int[256];
   @ObfuscatedName("r")
   int[] field2333 = new int[256];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -678763171
   )
   int field2334;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1434280369
   )
   int field2335;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   final void method3257() {
      this.field2335 += ++this.field2330;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2333[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2334 ^= this.field2334 << 13;
            } else {
               this.field2334 ^= this.field2334 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2334 ^= this.field2334 << 2;
         } else {
            this.field2334 ^= this.field2334 >>> 16;
         }

         this.field2334 += this.field2333[var1 + 128 & 255];
         int var3;
         this.field2333[var1] = var3 = this.field2335 + this.field2334 + this.field2333[(var2 & 1020) >> 2];
         this.field2332[var1] = this.field2335 = this.field2333[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   class167(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2332[var2] = var1[var2];
      }

      this.method3258();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method3258() {
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
         var2 += this.field2332[var1];
         var3 += this.field2332[var1 + 1];
         var4 += this.field2332[var1 + 2];
         var5 += this.field2332[var1 + 3];
         var6 += this.field2332[4 + var1];
         var7 += this.field2332[var1 + 5];
         var8 += this.field2332[6 + var1];
         var9 += this.field2332[var1 + 7];
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
         this.field2333[var1] = var2;
         this.field2333[1 + var1] = var3;
         this.field2333[2 + var1] = var4;
         this.field2333[var1 + 3] = var5;
         this.field2333[var1 + 4] = var6;
         this.field2333[5 + var1] = var7;
         this.field2333[var1 + 6] = var8;
         this.field2333[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2333[var1];
         var3 += this.field2333[1 + var1];
         var4 += this.field2333[2 + var1];
         var5 += this.field2333[3 + var1];
         var6 += this.field2333[var1 + 4];
         var7 += this.field2333[5 + var1];
         var8 += this.field2333[var1 + 6];
         var9 += this.field2333[var1 + 7];
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
         this.field2333[var1] = var2;
         this.field2333[1 + var1] = var3;
         this.field2333[2 + var1] = var4;
         this.field2333[3 + var1] = var5;
         this.field2333[4 + var1] = var6;
         this.field2333[5 + var1] = var7;
         this.field2333[var1 + 6] = var8;
         this.field2333[7 + var1] = var9;
      }

      this.method3257();
      this.field2331 = 256;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1000942429"
   )
   final int method3260() {
      if(--this.field2331 + 1 == 0) {
         this.method3257();
         this.field2331 = 255;
      }

      return this.field2332[this.field2331];
   }
}
