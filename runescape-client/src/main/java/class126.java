import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public final class class126 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2118039833
   )
   int field2076;
   @ObfuscatedName("s")
   int[] field2078 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1641829967
   )
   int field2079;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 869303103
   )
   int field2080;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 594846913
   )
   int field2081;
   @ObfuscatedName("h")
   int[] field2082 = new int[256];

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Z",
      garbageValue = "-78"
   )
   static final boolean method2917(class176 var0) {
      int var1 = var0.field2811;
      if(var1 == 205) {
         client.field299 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field567.method3635(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field567.method3636(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field567.method3637(false);
         }

         if(var1 == 325) {
            client.field567.method3637(true);
         }

         if(var1 == 326) {
            client.field337.method2903(4);
            client.field567.method3638(client.field337);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1384728952"
   )
   final void method2918() {
      this.field2080 += ++this.field2081;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2078[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2079 ^= this.field2079 << 13;
            } else {
               this.field2079 ^= this.field2079 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2079 ^= this.field2079 << 2;
         } else {
            this.field2079 ^= this.field2079 >>> 16;
         }

         this.field2079 += this.field2078[128 + var1 & 255];
         int var3;
         this.field2078[var1] = var3 = this.field2080 + this.field2079 + this.field2078[(var2 & 1020) >> 2];
         this.field2082[var1] = this.field2080 = var2 + this.field2078[(var3 >> 8 & 1020) >> 2];
      }

   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2082[var2] = var1[var2];
      }

      this.method2928();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZI)V",
      garbageValue = "-1785664698"
   )
   static void method2919(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class175 var8 = (class175)class174.field2771.method3936(var6);
      if(null == var8) {
         var8 = (class175)class174.field2777.method3936(var6);
         if(null == var8) {
            var8 = (class175)class174.field2776.method3936(var6);
            if(null != var8) {
               if(var5) {
                  var8.method4045();
                  class174.field2771.method3940(var8, var6);
                  --class174.field2768;
                  ++class174.field2781;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2778.method3936(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2795 = var0;
               var8.field2792 = var3;
               var8.field2793 = var4;
               if(var5) {
                  class174.field2771.method3940(var8, var6);
                  ++class174.field2781;
               } else {
                  class174.field2772.method4033(var8);
                  class174.field2776.method3940(var8, var6);
                  ++class174.field2768;
               }

            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass27;Lclass27;IZIZI)I",
      garbageValue = "-808653983"
   )
   static int method2926(class27 var0, class27 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class45.method949(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class45.method949(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1847007769"
   )
   final int method2927() {
      if(--this.field2076 + 1 == 0) {
         this.method2918();
         this.field2076 = 255;
      }

      return this.field2082[this.field2076];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "990"
   )
   final void method2928() {
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
         var2 += this.field2082[var1];
         var3 += this.field2082[1 + var1];
         var4 += this.field2082[var1 + 2];
         var5 += this.field2082[var1 + 3];
         var6 += this.field2082[4 + var1];
         var7 += this.field2082[var1 + 5];
         var8 += this.field2082[var1 + 6];
         var9 += this.field2082[7 + var1];
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
         this.field2078[var1] = var2;
         this.field2078[1 + var1] = var3;
         this.field2078[2 + var1] = var4;
         this.field2078[3 + var1] = var5;
         this.field2078[4 + var1] = var6;
         this.field2078[5 + var1] = var7;
         this.field2078[6 + var1] = var8;
         this.field2078[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2078[var1];
         var3 += this.field2078[var1 + 1];
         var4 += this.field2078[2 + var1];
         var5 += this.field2078[3 + var1];
         var6 += this.field2078[4 + var1];
         var7 += this.field2078[var1 + 5];
         var8 += this.field2078[6 + var1];
         var9 += this.field2078[var1 + 7];
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
         this.field2078[var1] = var2;
         this.field2078[1 + var1] = var3;
         this.field2078[2 + var1] = var4;
         this.field2078[var1 + 3] = var5;
         this.field2078[4 + var1] = var6;
         this.field2078[var1 + 5] = var7;
         this.field2078[var1 + 6] = var8;
         this.field2078[7 + var1] = var9;
      }

      this.method2918();
      this.field2076 = 256;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "75"
   )
   public static boolean method2929(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
