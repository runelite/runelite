import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class185 {
   @ObfuscatedName("w")
   int field2990;
   @ObfuscatedName("m")
   class122 field2991 = new class122((byte[])null);
   @ObfuscatedName("e")
   int[] field2992;
   @ObfuscatedName("o")
   int[] field2993;
   @ObfuscatedName("g")
   int[] field2994;
   @ObfuscatedName("l")
   int[] field2995;
   @ObfuscatedName("j")
   int field2996;
   @ObfuscatedName("k")
   static final byte[] field2999 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("x")
   long field3000;

   class185() {
   }

   @ObfuscatedName("e")
   boolean method3588() {
      return this.field2991.field2047 != null;
   }

   @ObfuscatedName("o")
   int method3589() {
      return this.field2993.length;
   }

   @ObfuscatedName("g")
   void method3590(int var1) {
      this.field2991.field2045 = this.field2993[var1];
   }

   @ObfuscatedName("m")
   void method3591(byte[] var1) {
      this.field2991.field2047 = var1;
      this.field2991.field2045 = 10;
      int var2 = this.field2991.method2706();
      this.field2990 = this.field2991.method2706();
      this.field2996 = 500000;
      this.field2992 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2991.field2045 += var5) {
         int var4 = this.field2991.method2577();
         var5 = this.field2991.method2577();
         if(var4 == 1297379947) {
            this.field2992[var3] = this.field2991.field2045;
            ++var3;
         }
      }

      this.field3000 = 0L;
      this.field2993 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2993[var3] = this.field2992[var3];
      }

      this.field2994 = new int[var2];
      this.field2995 = new int[var2];
   }

   @ObfuscatedName("j")
   void method3592() {
      this.field2991.field2045 = -1;
   }

   @ObfuscatedName("r")
   void method3593(int var1) {
      int var2 = this.field2991.method2687();
      this.field2994[var1] += var2;
   }

   class185(byte[] var1) {
      this.method3591(var1);
   }

   @ObfuscatedName("v")
   int method3595(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2991.method2556();
         var4 = this.field2991.method2687();
         if(var7 == 47) {
            this.field2991.field2045 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2991.method2576();
            var4 -= 3;
            int var6 = this.field2994[var1];
            this.field3000 += (long)var6 * (long)(this.field2996 - var5);
            this.field2996 = var5;
            this.field2991.field2045 += var4;
            return 2;
         } else {
            this.field2991.field2045 += var4;
            return 3;
         }
      } else {
         byte var3 = field2999[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2991.method2556() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2991.method2556() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   long method3596(int var1) {
      return this.field3000 + (long)var1 * (long)this.field2996;
   }

   @ObfuscatedName("u")
   int method3597() {
      int var1 = this.field2993.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2993[var4] >= 0 && this.field2994[var4] < var3) {
            var2 = var4;
            var3 = this.field2994[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("y")
   boolean method3598() {
      int var1 = this.field2993.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2993[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("p")
   void method3599(long var1) {
      this.field3000 = var1;
      int var3 = this.field2993.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2994[var4] = 0;
         this.field2995[var4] = 0;
         this.field2991.field2045 = this.field2992[var4];
         this.method3593(var4);
         this.field2993[var4] = this.field2991.field2045;
      }

   }

   @ObfuscatedName("w")
   void method3608() {
      this.field2991.field2047 = null;
      this.field2992 = null;
      this.field2993 = null;
      this.field2994 = null;
      this.field2995 = null;
   }

   @ObfuscatedName("x")
   int method3612(int var1) {
      int var2 = this.method3615(var1);
      return var2;
   }

   @ObfuscatedName("k")
   int method3615(int var1) {
      byte var2 = this.field2991.field2047[this.field2991.field2045];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2995[var1] = var5;
         ++this.field2991.field2045;
      } else {
         var5 = this.field2995[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3595(var1, var5);
      } else {
         int var3 = this.field2991.method2687();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2991.field2047[this.field2991.field2045] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2991.field2045;
               this.field2995[var1] = var4;
               return this.method3595(var1, var4);
            }
         }

         this.field2991.field2045 += var3;
         return 0;
      }
   }

   @ObfuscatedName("l")
   void method3627(int var1) {
      this.field2993[var1] = this.field2991.field2045;
   }
}
