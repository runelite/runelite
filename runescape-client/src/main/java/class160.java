import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public final class class160 {
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -378428385
   )
   static int field2132;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1212972729
   )
   int field2133;
   @ObfuscatedName("g")
   int[] field2134 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1745199959
   )
   int field2135;
   @ObfuscatedName("n")
   int[] field2137 = new int[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -32372711
   )
   int field2138;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1306749973
   )
   int field2139;

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2134[var2] = var1[var2];
      }

      this.method3003();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1825872290"
   )
   final void method2994() {
      this.field2139 += ++this.field2133;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2137[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2138 ^= this.field2138 << 13;
            } else {
               this.field2138 ^= this.field2138 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2138 ^= this.field2138 << 2;
         } else {
            this.field2138 ^= this.field2138 >>> 16;
         }

         this.field2138 += this.field2137[var1 + 128 & 255];
         int var3;
         this.field2137[var1] = var3 = this.field2137[(var2 & 1020) >> 2] + this.field2138 + this.field2139;
         this.field2134[var1] = this.field2139 = this.field2137[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   final int method2997() {
      if(--this.field2135 + 1 == 0) {
         this.method2994();
         this.field2135 = 255;
      }

      return this.field2134[this.field2135];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "220"
   )
   final void method3003() {
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
         var2 += this.field2134[var1];
         var3 += this.field2134[var1 + 1];
         var4 += this.field2134[var1 + 2];
         var5 += this.field2134[3 + var1];
         var6 += this.field2134[var1 + 4];
         var7 += this.field2134[var1 + 5];
         var8 += this.field2134[var1 + 6];
         var9 += this.field2134[7 + var1];
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
         this.field2137[var1] = var2;
         this.field2137[1 + var1] = var3;
         this.field2137[2 + var1] = var4;
         this.field2137[var1 + 3] = var5;
         this.field2137[var1 + 4] = var6;
         this.field2137[var1 + 5] = var7;
         this.field2137[6 + var1] = var8;
         this.field2137[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2137[var1];
         var3 += this.field2137[1 + var1];
         var4 += this.field2137[var1 + 2];
         var5 += this.field2137[var1 + 3];
         var6 += this.field2137[4 + var1];
         var7 += this.field2137[5 + var1];
         var8 += this.field2137[var1 + 6];
         var9 += this.field2137[var1 + 7];
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
         this.field2137[var1] = var2;
         this.field2137[1 + var1] = var3;
         this.field2137[var1 + 2] = var4;
         this.field2137[var1 + 3] = var5;
         this.field2137[4 + var1] = var6;
         this.field2137[var1 + 5] = var7;
         this.field2137[6 + var1] = var8;
         this.field2137[var1 + 7] = var9;
      }

      this.method2994();
      this.field2135 = 256;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "895641086"
   )
   public static boolean method3004(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
