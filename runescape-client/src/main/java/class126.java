import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public final class class126 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2116127911
   )
   int field2060;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1365822327
   )
   int field2061;
   @ObfuscatedName("p")
   int[] field2063 = new int[256];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 100182039
   )
   int field2064;
   @ObfuscatedName("g")
   int[] field2065 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -501212597
   )
   int field2066;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   final void method2777() {
      this.field2060 += ++this.field2066;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2065[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2064 ^= this.field2064 << 13;
            } else {
               this.field2064 ^= this.field2064 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2064 ^= this.field2064 << 2;
         } else {
            this.field2064 ^= this.field2064 >>> 16;
         }

         this.field2064 += this.field2065[var1 + 128 & 255];
         int var3;
         this.field2065[var1] = var3 = this.field2065[(var2 & 1020) >> 2] + this.field2064 + this.field2060;
         this.field2063[var1] = this.field2060 = var2 + this.field2065[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1281138625"
   )
   final void method2778() {
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
         var2 += this.field2063[var1];
         var3 += this.field2063[1 + var1];
         var4 += this.field2063[var1 + 2];
         var5 += this.field2063[3 + var1];
         var6 += this.field2063[4 + var1];
         var7 += this.field2063[5 + var1];
         var8 += this.field2063[var1 + 6];
         var9 += this.field2063[var1 + 7];
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
         this.field2065[var1] = var2;
         this.field2065[var1 + 1] = var3;
         this.field2065[2 + var1] = var4;
         this.field2065[var1 + 3] = var5;
         this.field2065[var1 + 4] = var6;
         this.field2065[var1 + 5] = var7;
         this.field2065[var1 + 6] = var8;
         this.field2065[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2065[var1];
         var3 += this.field2065[var1 + 1];
         var4 += this.field2065[2 + var1];
         var5 += this.field2065[3 + var1];
         var6 += this.field2065[var1 + 4];
         var7 += this.field2065[5 + var1];
         var8 += this.field2065[var1 + 6];
         var9 += this.field2065[var1 + 7];
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
         this.field2065[var1] = var2;
         this.field2065[1 + var1] = var3;
         this.field2065[2 + var1] = var4;
         this.field2065[3 + var1] = var5;
         this.field2065[4 + var1] = var6;
         this.field2065[var1 + 5] = var7;
         this.field2065[var1 + 6] = var8;
         this.field2065[var1 + 7] = var9;
      }

      this.method2777();
      this.field2061 = 256;
   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2063[var2] = var1[var2];
      }

      this.method2778();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "1003"
   )
   final int method2782() {
      if(--this.field2061 + 1 == 0) {
         this.method2777();
         this.field2061 = 255;
      }

      return this.field2063[this.field2061];
   }

   @ObfuscatedName("z")
   public static String method2787(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2695[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
