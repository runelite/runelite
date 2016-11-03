import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public final class class126 {
   @ObfuscatedName("j")
   int[] field2078 = new int[256];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -233696135
   )
   int field2081;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1157937713
   )
   int field2082;
   @ObfuscatedName("m")
   int[] field2083 = new int[256];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1948576389
   )
   int field2085;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1728195067
   )
   int field2086;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1320395889"
   )
   final void method2837() {
      this.field2081 += ++this.field2086;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2083[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2085 ^= this.field2085 << 13;
            } else {
               this.field2085 ^= this.field2085 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2085 ^= this.field2085 << 2;
         } else {
            this.field2085 ^= this.field2085 >>> 16;
         }

         this.field2085 += this.field2083[var1 + 128 & 255];
         int var3;
         this.field2083[var1] = var3 = this.field2085 + this.field2083[(var2 & 1020) >> 2] + this.field2081;
         this.field2078[var1] = this.field2081 = var2 + this.field2083[(var3 >> 8 & 1020) >> 2];
      }

   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2078[var2] = var1[var2];
      }

      this.method2842();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   final void method2842() {
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
         var2 += this.field2078[var1];
         var3 += this.field2078[var1 + 1];
         var4 += this.field2078[var1 + 2];
         var5 += this.field2078[3 + var1];
         var6 += this.field2078[var1 + 4];
         var7 += this.field2078[var1 + 5];
         var8 += this.field2078[var1 + 6];
         var9 += this.field2078[7 + var1];
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
         this.field2083[var1] = var2;
         this.field2083[var1 + 1] = var3;
         this.field2083[var1 + 2] = var4;
         this.field2083[3 + var1] = var5;
         this.field2083[4 + var1] = var6;
         this.field2083[var1 + 5] = var7;
         this.field2083[var1 + 6] = var8;
         this.field2083[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2083[var1];
         var3 += this.field2083[var1 + 1];
         var4 += this.field2083[2 + var1];
         var5 += this.field2083[3 + var1];
         var6 += this.field2083[var1 + 4];
         var7 += this.field2083[5 + var1];
         var8 += this.field2083[var1 + 6];
         var9 += this.field2083[7 + var1];
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
         this.field2083[var1] = var2;
         this.field2083[var1 + 1] = var3;
         this.field2083[2 + var1] = var4;
         this.field2083[3 + var1] = var5;
         this.field2083[var1 + 4] = var6;
         this.field2083[5 + var1] = var7;
         this.field2083[var1 + 6] = var8;
         this.field2083[7 + var1] = var9;
      }

      this.method2837();
      this.field2082 = 256;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   final int method2844() {
      if(--this.field2082 + 1 == 0) {
         this.method2837();
         this.field2082 = 255;
      }

      return this.field2078[this.field2082];
   }
}
