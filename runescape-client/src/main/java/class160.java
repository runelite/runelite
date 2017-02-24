import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public final class class160 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1308700733
   )
   int field2136;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1523145107
   )
   int field2139;
   @ObfuscatedName("j")
   int[] field2140 = new int[256];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 293286439
   )
   int field2141;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1522595681
   )
   int field2143;
   @ObfuscatedName("n")
   int[] field2145 = new int[256];
   @ObfuscatedName("c")
   static int[] field2146;

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2140[var2] = var1[var2];
      }

      this.method3100();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   final void method3100() {
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
         var2 += this.field2140[var1];
         var3 += this.field2140[var1 + 1];
         var4 += this.field2140[var1 + 2];
         var5 += this.field2140[3 + var1];
         var6 += this.field2140[4 + var1];
         var7 += this.field2140[var1 + 5];
         var8 += this.field2140[var1 + 6];
         var9 += this.field2140[var1 + 7];
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
         this.field2145[var1] = var2;
         this.field2145[var1 + 1] = var3;
         this.field2145[2 + var1] = var4;
         this.field2145[var1 + 3] = var5;
         this.field2145[var1 + 4] = var6;
         this.field2145[var1 + 5] = var7;
         this.field2145[6 + var1] = var8;
         this.field2145[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2145[var1];
         var3 += this.field2145[var1 + 1];
         var4 += this.field2145[var1 + 2];
         var5 += this.field2145[var1 + 3];
         var6 += this.field2145[4 + var1];
         var7 += this.field2145[var1 + 5];
         var8 += this.field2145[6 + var1];
         var9 += this.field2145[var1 + 7];
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
         this.field2145[var1] = var2;
         this.field2145[1 + var1] = var3;
         this.field2145[2 + var1] = var4;
         this.field2145[3 + var1] = var5;
         this.field2145[4 + var1] = var6;
         this.field2145[var1 + 5] = var7;
         this.field2145[var1 + 6] = var8;
         this.field2145[var1 + 7] = var9;
      }

      this.method3102();
      this.field2136 = 256;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-88"
   )
   final int method3101() {
      if(--this.field2136 + 1 == 0) {
         this.method3102();
         this.field2136 = 255;
      }

      return this.field2140[this.field2136];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "899228525"
   )
   final void method3102() {
      this.field2143 += ++this.field2139;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2145[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2141 ^= this.field2141 << 13;
            } else {
               this.field2141 ^= this.field2141 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2141 ^= this.field2141 << 2;
         } else {
            this.field2141 ^= this.field2141 >>> 16;
         }

         this.field2141 += this.field2145[128 + var1 & 255];
         int var3;
         this.field2145[var1] = var3 = this.field2143 + this.field2145[(var2 & 1020) >> 2] + this.field2141;
         this.field2140[var1] = this.field2143 = this.field2145[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-788989254"
   )
   public static boolean method3108(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
