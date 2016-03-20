import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
public final class class122 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -562896659
   )
   int field2012;
   @ObfuscatedName("t")
   public static String[] field2013;
   @ObfuscatedName("j")
   int field2014;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1831822437
   )
   int field2015;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1757377535
   )
   int field2016;
   @ObfuscatedName("g")
   int[] field2017 = new int[256];
   @ObfuscatedName("e")
   int[] field2021 = new int[256];

   @ObfuscatedName("f")
   final void method2774() {
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
         var2 += this.field2021[var1];
         var3 += this.field2021[var1 + 1];
         var4 += this.field2021[2 + var1];
         var5 += this.field2021[3 + var1];
         var6 += this.field2021[4 + var1];
         var7 += this.field2021[var1 + 5];
         var8 += this.field2021[var1 + 6];
         var9 += this.field2021[7 + var1];
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
         this.field2017[var1] = var2;
         this.field2017[1 + var1] = var3;
         this.field2017[2 + var1] = var4;
         this.field2017[3 + var1] = var5;
         this.field2017[4 + var1] = var6;
         this.field2017[5 + var1] = var7;
         this.field2017[var1 + 6] = var8;
         this.field2017[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2017[var1];
         var3 += this.field2017[var1 + 1];
         var4 += this.field2017[var1 + 2];
         var5 += this.field2017[3 + var1];
         var6 += this.field2017[4 + var1];
         var7 += this.field2017[5 + var1];
         var8 += this.field2017[var1 + 6];
         var9 += this.field2017[var1 + 7];
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
         this.field2017[var1] = var2;
         this.field2017[var1 + 1] = var3;
         this.field2017[2 + var1] = var4;
         this.field2017[var1 + 3] = var5;
         this.field2017[var1 + 4] = var6;
         this.field2017[var1 + 5] = var7;
         this.field2017[6 + var1] = var8;
         this.field2017[7 + var1] = var9;
      }

      this.method2775();
      this.field2012 = 256;
   }

   @ObfuscatedName("r")
   final void method2775() {
      this.field2016 += (this.field2014 += 127667623) * -121386473;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2017[var1];
         if(0 == (var1 & 2)) {
            if((var1 & 1) == 0) {
               this.field2015 ^= this.field2015 << 13;
            } else {
               this.field2015 ^= this.field2015 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2015 ^= this.field2015 << 2;
         } else {
            this.field2015 ^= this.field2015 >>> 16;
         }

         this.field2015 += this.field2017[var1 + 128 & 255];
         int var3;
         this.field2017[var1] = var3 = this.field2015 + this.field2017[(var2 & 1020) >> 2] + this.field2016;
         this.field2021[var1] = this.field2016 = this.field2017[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("i")
   static final int method2779(int var0, int var1) {
      int var2 = class37.method766(var0 - 1, var1 - 1) + class37.method766(1 + var0, var1 - 1) + class37.method766(var0 - 1, 1 + var1) + class37.method766(1 + var0, 1 + var1);
      int var3 = class37.method766(var0 - 1, var1) + class37.method766(var0 + 1, var1) + class37.method766(var0, var1 - 1) + class37.method766(var0, 1 + var1);
      int var4 = class37.method766(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   class122(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2021[var2] = var1[var2];
      }

      this.method2774();
   }

   @ObfuscatedName("a")
   final int method2781() {
      if(0 == --this.field2012 + 1) {
         this.method2775();
         this.field2012 = 255;
      }

      return this.field2021[this.field2012];
   }

   @ObfuscatedName("r")
   public static void method2783(Component var0) {
      var0.removeMouseListener(class139.field2136);
      var0.removeMouseMotionListener(class139.field2136);
      var0.removeFocusListener(class139.field2136);
      class139.field2141 = 0;
   }

   @ObfuscatedName("e")
   public static int method2784(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class120.method2749(var0.charAt(var3));
      }

      return var2;
   }
}
