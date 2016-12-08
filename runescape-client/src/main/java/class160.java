import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class160 {
   @ObfuscatedName("ec")
   static SpritePixels[] field2142;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1657388651
   )
   int field2143;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -423539427
   )
   int field2144;
   @ObfuscatedName("l")
   int[] field2145 = new int[256];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 43823183
   )
   int field2146;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1026546033
   )
   int field2147;
   @ObfuscatedName("v")
   int[] field2148 = new int[256];

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015894959"
   )
   final int method2994() {
      if(--this.field2144 + 1 == 0) {
         this.method3001();
         this.field2144 = 255;
      }

      return this.field2148[this.field2144];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1042588369"
   )
   final void method2995() {
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
         var2 += this.field2148[var1];
         var3 += this.field2148[var1 + 1];
         var4 += this.field2148[2 + var1];
         var5 += this.field2148[var1 + 3];
         var6 += this.field2148[4 + var1];
         var7 += this.field2148[var1 + 5];
         var8 += this.field2148[var1 + 6];
         var9 += this.field2148[var1 + 7];
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
         this.field2145[4 + var1] = var6;
         this.field2145[var1 + 5] = var7;
         this.field2145[6 + var1] = var8;
         this.field2145[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2145[var1];
         var3 += this.field2145[var1 + 1];
         var4 += this.field2145[var1 + 2];
         var5 += this.field2145[3 + var1];
         var6 += this.field2145[var1 + 4];
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
         this.field2145[var1 + 3] = var5;
         this.field2145[var1 + 4] = var6;
         this.field2145[var1 + 5] = var7;
         this.field2145[var1 + 6] = var8;
         this.field2145[var1 + 7] = var9;
      }

      this.method3001();
      this.field2144 = 256;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;S)V",
      garbageValue = "3905"
   )
   public static void method2996(class182 var0) {
      class194.field2851 = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1034281329"
   )
   final void method3001() {
      this.field2147 += ++this.field2143;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2145[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2146 ^= this.field2146 << 13;
            } else {
               this.field2146 ^= this.field2146 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2146 ^= this.field2146 << 2;
         } else {
            this.field2146 ^= this.field2146 >>> 16;
         }

         this.field2146 += this.field2145[var1 + 128 & 255];
         int var3;
         this.field2145[var1] = var3 = this.field2145[(var2 & 1020) >> 2] + this.field2146 + this.field2147;
         this.field2148[var1] = this.field2147 = this.field2145[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2148[var2] = var1[var2];
      }

      this.method2995();
   }
}
