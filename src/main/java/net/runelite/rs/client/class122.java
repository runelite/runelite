package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
public final class class122 {
   @ObfuscatedName("u")
   int[] field2005 = new int[256];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1939473845
   )
   int field2007;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 717033881
   )
   int field2008;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1771407287
   )
   int field2011;
   @ObfuscatedName("t")
   int field2013;
   @ObfuscatedName("h")
   int[] field2014 = new int[256];

   @ObfuscatedName("j")
   final int method2807() {
      if(0 == --this.field2008 + 1) {
         this.method2808();
         this.field2008 = 255;
      }

      return this.field2005[this.field2008];
   }

   @ObfuscatedName("m")
   final void method2808() {
      this.field2007 += (this.field2013 += -2043727055) * 2090550737;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2014[var1];
         if((var1 & 2) == 0) {
            if(0 == (var1 & 1)) {
               this.field2011 ^= this.field2011 << 13;
            } else {
               this.field2011 ^= this.field2011 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2011 ^= this.field2011 << 2;
         } else {
            this.field2011 ^= this.field2011 >>> 16;
         }

         this.field2011 += this.field2014[var1 + 128 & 255];
         int var3;
         this.field2014[var1] = var3 = this.field2014[(var2 & 1020) >> 2] + this.field2011 + this.field2007;
         this.field2005[var1] = this.field2007 = var2 + this.field2014[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("f")
   final void method2809() {
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
         var2 += this.field2005[var1];
         var3 += this.field2005[var1 + 1];
         var4 += this.field2005[2 + var1];
         var5 += this.field2005[3 + var1];
         var6 += this.field2005[4 + var1];
         var7 += this.field2005[var1 + 5];
         var8 += this.field2005[6 + var1];
         var9 += this.field2005[var1 + 7];
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
         this.field2014[var1] = var2;
         this.field2014[var1 + 1] = var3;
         this.field2014[var1 + 2] = var4;
         this.field2014[var1 + 3] = var5;
         this.field2014[var1 + 4] = var6;
         this.field2014[5 + var1] = var7;
         this.field2014[var1 + 6] = var8;
         this.field2014[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2014[var1];
         var3 += this.field2014[1 + var1];
         var4 += this.field2014[2 + var1];
         var5 += this.field2014[var1 + 3];
         var6 += this.field2014[var1 + 4];
         var7 += this.field2014[5 + var1];
         var8 += this.field2014[6 + var1];
         var9 += this.field2014[var1 + 7];
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
         this.field2014[var1] = var2;
         this.field2014[var1 + 1] = var3;
         this.field2014[var1 + 2] = var4;
         this.field2014[var1 + 3] = var5;
         this.field2014[var1 + 4] = var6;
         this.field2014[5 + var1] = var7;
         this.field2014[6 + var1] = var8;
         this.field2014[var1 + 7] = var9;
      }

      this.method2808();
      this.field2008 = 256;
   }

   class122(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2005[var2] = var1[var2];
      }

      this.method2809();
   }

   @ObfuscatedName("f")
   static boolean method2816(String var0, int var1) {
      return class10.method157(var0, var1, "openjs");
   }
}
