import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public final class class126 {
   @ObfuscatedName("n")
   int[] field2067 = new int[256];
   @ObfuscatedName("u")
   int[] field2069 = new int[256];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1252279655
   )
   int field2070;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 478028863
   )
   int field2071;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -19351587
   )
   int field2072;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -165908653
   )
   int field2073;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2082298304"
   )
   final int method2808() {
      if(--this.field2070 + 1 == 0) {
         this.method2809();
         this.field2070 = 255;
      }

      return this.field2067[this.field2070];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2085455395"
   )
   final void method2809() {
      this.field2071 += ++this.field2072;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2069[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2073 ^= this.field2073 << 13;
            } else {
               this.field2073 ^= this.field2073 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2073 ^= this.field2073 << 2;
         } else {
            this.field2073 ^= this.field2073 >>> 16;
         }

         this.field2073 += this.field2069[var1 + 128 & 255];
         int var3;
         this.field2069[var1] = var3 = this.field2071 + this.field2073 + this.field2069[(var2 & 1020) >> 2];
         this.field2067[var1] = this.field2071 = var2 + this.field2069[(var3 >> 8 & 1020) >> 2];
      }

   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2067[var2] = var1[var2];
      }

      this.method2812();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   final void method2812() {
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
         var2 += this.field2067[var1];
         var3 += this.field2067[1 + var1];
         var4 += this.field2067[var1 + 2];
         var5 += this.field2067[var1 + 3];
         var6 += this.field2067[4 + var1];
         var7 += this.field2067[5 + var1];
         var8 += this.field2067[var1 + 6];
         var9 += this.field2067[7 + var1];
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
         this.field2069[var1] = var2;
         this.field2069[1 + var1] = var3;
         this.field2069[2 + var1] = var4;
         this.field2069[var1 + 3] = var5;
         this.field2069[var1 + 4] = var6;
         this.field2069[var1 + 5] = var7;
         this.field2069[var1 + 6] = var8;
         this.field2069[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2069[var1];
         var3 += this.field2069[1 + var1];
         var4 += this.field2069[var1 + 2];
         var5 += this.field2069[3 + var1];
         var6 += this.field2069[4 + var1];
         var7 += this.field2069[var1 + 5];
         var8 += this.field2069[6 + var1];
         var9 += this.field2069[var1 + 7];
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
         this.field2069[var1] = var2;
         this.field2069[1 + var1] = var3;
         this.field2069[var1 + 2] = var4;
         this.field2069[var1 + 3] = var5;
         this.field2069[4 + var1] = var6;
         this.field2069[5 + var1] = var7;
         this.field2069[var1 + 6] = var8;
         this.field2069[var1 + 7] = var9;
      }

      this.method2809();
      this.field2070 = 256;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;B)V",
      garbageValue = "-122"
   )
   static final void method2818(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var9 + var2][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  class156.method3186(var13, var1, var2 + class173.method3402(var11 & 7, var12 & 7, var7), var3 + class143.method2984(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class156.method3186(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
