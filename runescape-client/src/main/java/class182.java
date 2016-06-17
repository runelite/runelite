import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class182 {
   @ObfuscatedName("g")
   int field2936;
   @ObfuscatedName("j")
   int[] field2937;
   @ObfuscatedName("d")
   int[] field2938;
   @ObfuscatedName("x")
   int[] field2939;
   @ObfuscatedName("y")
   int[] field2940;
   @ObfuscatedName("r")
   int field2941;
   @ObfuscatedName("b")
   class119 field2943 = new class119((byte[])null);
   @ObfuscatedName("u")
   static final byte[] field2944 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("l")
   long field2946;

   class182(byte[] var1) {
      this.method3539(var1);
   }

   @ObfuscatedName("b")
   void method3539(byte[] var1) {
      this.field2943.field1982 = var1;
      this.field2943.field1976 = 10;
      int var2 = this.field2943.method2516();
      this.field2936 = this.field2943.method2516();
      this.field2941 = 500000;
      this.field2937 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2943.field1976 += var5) {
         int var4 = this.field2943.method2519();
         var5 = this.field2943.method2519();
         if(var4 == 1297379947) {
            this.field2937[var3] = this.field2943.field1976;
            ++var3;
         }
      }

      this.field2946 = 0L;
      this.field2938 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2938[var3] = this.field2937[var3];
      }

      this.field2939 = new int[var2];
      this.field2940 = new int[var2];
   }

   @ObfuscatedName("g")
   void method3540() {
      this.field2943.field1982 = null;
      this.field2937 = null;
      this.field2938 = null;
      this.field2939 = null;
      this.field2940 = null;
   }

   @ObfuscatedName("j")
   boolean method3541() {
      return this.field2943.field1982 != null;
   }

   @ObfuscatedName("d")
   int method3542() {
      return this.field2938.length;
   }

   @ObfuscatedName("x")
   void method3543(int var1) {
      this.field2943.field1976 = this.field2938[var1];
   }

   @ObfuscatedName("y")
   void method3544(int var1) {
      this.field2938[var1] = this.field2943.field1976;
   }

   class182() {
   }

   @ObfuscatedName("c")
   void method3545(int var1) {
      int var2 = this.field2943.method2529();
      this.field2939[var1] += var2;
   }

   @ObfuscatedName("l")
   int method3546(int var1) {
      int var2 = this.method3547(var1);
      return var2;
   }

   @ObfuscatedName("u")
   int method3547(int var1) {
      byte var2 = this.field2943.field1982[this.field2943.field1976];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2940[var1] = var5;
         ++this.field2943.field1976;
      } else {
         var5 = this.field2940[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3571(var1, var5);
      } else {
         int var3 = this.field2943.method2529();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2943.field1982[this.field2943.field1976] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2943.field1976;
               this.field2940[var1] = var4;
               return this.method3571(var1, var4);
            }
         }

         this.field2943.field1976 += var3;
         return 0;
      }
   }

   @ObfuscatedName("n")
   long method3549(int var1) {
      return this.field2946 + (long)var1 * (long)this.field2941;
   }

   @ObfuscatedName("w")
   int method3550() {
      int var1 = this.field2938.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2938[var4] >= 0 && this.field2939[var4] < var3) {
            var2 = var4;
            var3 = this.field2939[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("z")
   boolean method3551() {
      int var1 = this.field2938.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2938[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("r")
   void method3552() {
      this.field2943.field1976 = -1;
   }

   @ObfuscatedName("p")
   int method3571(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2943.method2514();
         var4 = this.field2943.method2529();
         if(var7 == 47) {
            this.field2943.field1976 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2943.method2518();
            var4 -= 3;
            int var6 = this.field2939[var1];
            this.field2946 += (long)var6 * (long)(this.field2941 - var5);
            this.field2941 = var5;
            this.field2943.field1976 += var4;
            return 2;
         } else {
            this.field2943.field1976 += var4;
            return 3;
         }
      } else {
         byte var3 = field2944[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2943.method2514() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2943.method2514() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   void method3593(long var1) {
      this.field2946 = var1;
      int var3 = this.field2938.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2939[var4] = 0;
         this.field2940[var4] = 0;
         this.field2943.field1976 = this.field2937[var4];
         this.method3545(var4);
         this.field2938[var4] = this.field2943.field1976;
      }

   }
}
