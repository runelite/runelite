import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public final class class123 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2142036223
   )
   int field2008;
   @ObfuscatedName("y")
   int[] field2009 = new int[256];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -765441211
   )
   int field2010;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -703989701
   )
   int field2011;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1664887603
   )
   int field2013;
   @ObfuscatedName("al")
   static class78[] field2015;
   @ObfuscatedName("r")
   int[] field2017 = new int[256];
   @ObfuscatedName("bf")
   protected static FontMetrics field2018;
   @ObfuscatedName("c")
   static class153 field2020;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "14642"
   )
   final int method2811() {
      if(--this.field2011 + 1 == 0) {
         this.method2814();
         this.field2011 = 255;
      }

      return this.field2009[this.field2011];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2136067462"
   )
   final void method2813() {
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
         var2 += this.field2009[var1];
         var3 += this.field2009[var1 + 1];
         var4 += this.field2009[2 + var1];
         var5 += this.field2009[3 + var1];
         var6 += this.field2009[var1 + 4];
         var7 += this.field2009[var1 + 5];
         var8 += this.field2009[var1 + 6];
         var9 += this.field2009[var1 + 7];
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
         this.field2017[var1 + 3] = var5;
         this.field2017[var1 + 4] = var6;
         this.field2017[var1 + 5] = var7;
         this.field2017[6 + var1] = var8;
         this.field2017[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2017[var1];
         var3 += this.field2017[var1 + 1];
         var4 += this.field2017[var1 + 2];
         var5 += this.field2017[3 + var1];
         var6 += this.field2017[4 + var1];
         var7 += this.field2017[5 + var1];
         var8 += this.field2017[6 + var1];
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
         this.field2017[1 + var1] = var3;
         this.field2017[var1 + 2] = var4;
         this.field2017[var1 + 3] = var5;
         this.field2017[var1 + 4] = var6;
         this.field2017[var1 + 5] = var7;
         this.field2017[var1 + 6] = var8;
         this.field2017[var1 + 7] = var9;
      }

      this.method2814();
      this.field2011 = 256;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "280306711"
   )
   final void method2814() {
      this.field2008 += ++this.field2013;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2017[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2010 ^= this.field2010 << 13;
            } else {
               this.field2010 ^= this.field2010 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2010 ^= this.field2010 << 2;
         } else {
            this.field2010 ^= this.field2010 >>> 16;
         }

         this.field2010 += this.field2017[var1 + 128 & 255];
         int var3;
         this.field2017[var1] = var3 = this.field2010 + this.field2017[(var2 & 1020) >> 2] + this.field2008;
         this.field2009[var1] = this.field2008 = var2 + this.field2017[(var3 >> 8 & 1020) >> 2];
      }

   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2009[var2] = var1[var2];
      }

      this.method2813();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "61"
   )
   static long method2817(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
