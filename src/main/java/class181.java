import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
public class class181 {
   @ObfuscatedName("r")
   int field2928;
   @ObfuscatedName("a")
   class118 field2929 = new class118((byte[])null);
   @ObfuscatedName("f")
   int[] field2930;
   @ObfuscatedName("e")
   int[] field2931;
   @ObfuscatedName("y")
   int[] field2932;
   @ObfuscatedName("s")
   int[] field2933;
   @ObfuscatedName("j")
   long field2936;
   @ObfuscatedName("n")
   static final byte[] field2937 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("g")
   int field2940;

   class181(byte[] var1) {
      this.method3549(var1);
   }

   @ObfuscatedName("a")
   void method3549(byte[] var1) {
      this.field2929.field1980 = var1;
      this.field2929.field1979 = 10;
      int var2 = this.field2929.method2514();
      this.field2928 = this.field2929.method2514();
      this.field2940 = 500000;
      this.field2930 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2929.field1979 += var5) {
         int var4 = this.field2929.method2517();
         var5 = this.field2929.method2517();
         if(var4 == 1297379947) {
            this.field2930[var3] = this.field2929.field1979;
            ++var3;
         }
      }

      this.field2936 = 0L;
      this.field2933 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2933[var3] = this.field2930[var3];
      }

      this.field2932 = new int[var2];
      this.field2931 = new int[var2];
   }

   @ObfuscatedName("r")
   void method3550() {
      this.field2929.field1980 = null;
      this.field2930 = null;
      this.field2933 = null;
      this.field2932 = null;
      this.field2931 = null;
   }

   @ObfuscatedName("f")
   boolean method3551() {
      return this.field2929.field1980 != null;
   }

   @ObfuscatedName("s")
   int method3552() {
      return this.field2933.length;
   }

   @ObfuscatedName("y")
   void method3553(int var1) {
      this.field2929.field1979 = this.field2933[var1];
   }

   @ObfuscatedName("j")
   int method3557(int var1) {
      int var2 = this.method3558(var1);
      return var2;
   }

   @ObfuscatedName("n")
   int method3558(int var1) {
      byte var2 = this.field2929.field1980[this.field2929.field1979];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2931[var1] = var5;
         ++this.field2929.field1979;
      } else {
         var5 = this.field2931[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3562(var1, var5);
      } else {
         int var3 = this.field2929.method2617();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2929.field1980[this.field2929.field1979] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2929.field1979;
               this.field2931[var1] = var4;
               return this.method3562(var1, var4);
            }
         }

         this.field2929.field1979 += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   long method3559(int var1) {
      return this.field2936 + (long)var1 * (long)this.field2940;
   }

   @ObfuscatedName("i")
   int method3561() {
      int var1 = this.field2933.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2933[var4] >= 0 && this.field2932[var4] < var3) {
            var2 = var4;
            var3 = this.field2932[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("l")
   int method3562(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2929.method2579();
         var4 = this.field2929.method2617();
         if(var7 == 47) {
            this.field2929.field1979 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2929.method2516();
            var4 -= 3;
            int var6 = this.field2932[var1];
            this.field2936 += (long)var6 * (long)(this.field2940 - var5);
            this.field2940 = var5;
            this.field2929.field1979 += var4;
            return 2;
         } else {
            this.field2929.field1979 += var4;
            return 3;
         }
      } else {
         byte var3 = field2937[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2929.method2579() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2929.method2579() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   void method3563(long var1) {
      this.field2936 = var1;
      int var3 = this.field2933.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2932[var4] = 0;
         this.field2931[var4] = 0;
         this.field2929.field1979 = this.field2930[var4];
         this.method3585(var4);
         this.field2933[var4] = this.field2929.field1979;
      }

   }

   @ObfuscatedName("e")
   void method3564(int var1) {
      this.field2933[var1] = this.field2929.field1979;
   }

   class181() {
   }

   @ObfuscatedName("v")
   boolean method3582() {
      int var1 = this.field2933.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2933[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("m")
   void method3585(int var1) {
      int var2 = this.field2929.method2617();
      this.field2932[var1] += var2;
   }

   @ObfuscatedName("g")
   void method3594() {
      this.field2929.field1979 = -1;
   }
}
