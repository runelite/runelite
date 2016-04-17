import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class182 {
   @ObfuscatedName("w")
   int field2950;
   @ObfuscatedName("d")
   int[] field2951;
   @ObfuscatedName("c")
   int[] field2952;
   @ObfuscatedName("k")
   int[] field2953;
   @ObfuscatedName("y")
   int[] field2955;
   @ObfuscatedName("q")
   long field2957;
   @ObfuscatedName("m")
   static final byte[] field2958 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("r")
   int field2960;
   @ObfuscatedName("a")
   class119 field2961 = new class119((byte[])null);

   class182(byte[] var1) {
      this.method3607(var1);
   }

   @ObfuscatedName("a")
   void method3607(byte[] var1) {
      this.field2961.field1993 = var1;
      this.field2961.field1992 = 10;
      int var2 = this.field2961.method2615();
      this.field2950 = this.field2961.method2615();
      this.field2960 = 500000;
      this.field2951 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2961.field1992 += var5) {
         int var4 = this.field2961.method2618();
         var5 = this.field2961.method2618();
         if(var4 == 1297379947) {
            this.field2951[var3] = this.field2961.field1992;
            ++var3;
         }
      }

      this.field2957 = 0L;
      this.field2952 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2952[var3] = this.field2951[var3];
      }

      this.field2955 = new int[var2];
      this.field2953 = new int[var2];
   }

   @ObfuscatedName("d")
   boolean method3609() {
      return this.field2961.field1993 != null;
   }

   @ObfuscatedName("c")
   int method3610() {
      return this.field2952.length;
   }

   @ObfuscatedName("x")
   long method3611(int var1) {
      return this.field2957 + (long)var1 * (long)this.field2960;
   }

   @ObfuscatedName("k")
   void method3612(int var1) {
      this.field2952[var1] = this.field2961.field1992;
   }

   @ObfuscatedName("w")
   void method3613() {
      this.field2961.field1993 = null;
      this.field2951 = null;
      this.field2952 = null;
      this.field2955 = null;
      this.field2953 = null;
   }

   @ObfuscatedName("p")
   void method3614(int var1) {
      int var2 = this.field2961.method2628();
      this.field2955[var1] += var2;
   }

   @ObfuscatedName("r")
   void method3617() {
      this.field2961.field1992 = -1;
   }

   @ObfuscatedName("z")
   int method3619() {
      int var1 = this.field2952.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2952[var4] >= 0 && this.field2955[var4] < var3) {
            var2 = var4;
            var3 = this.field2955[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("i")
   boolean method3620() {
      int var1 = this.field2952.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2952[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("e")
   int method3628(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2961.method2613();
         var4 = this.field2961.method2628();
         if(var7 == 47) {
            this.field2961.field1992 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2961.method2617();
            var4 -= 3;
            int var6 = this.field2955[var1];
            this.field2957 += (long)var6 * (long)(this.field2960 - var5);
            this.field2960 = var5;
            this.field2961.field1992 += var4;
            return 2;
         } else {
            this.field2961.field1992 += var4;
            return 3;
         }
      } else {
         byte var3 = field2958[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2961.method2613() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2961.method2613() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   int method3638(int var1) {
      byte var2 = this.field2961.field1993[this.field2961.field1992];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2953[var1] = var5;
         ++this.field2961.field1992;
      } else {
         var5 = this.field2953[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3628(var1, var5);
      } else {
         int var3 = this.field2961.method2628();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2961.field1993[this.field2961.field1992] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2961.field1992;
               this.field2953[var1] = var4;
               return this.method3628(var1, var4);
            }
         }

         this.field2961.field1992 += var3;
         return 0;
      }
   }

   class182() {
   }

   @ObfuscatedName("q")
   int method3643(int var1) {
      int var2 = this.method3638(var1);
      return var2;
   }

   @ObfuscatedName("y")
   void method3647(int var1) {
      this.field2961.field1992 = this.field2952[var1];
   }

   @ObfuscatedName("t")
   void method3649(long var1) {
      this.field2957 = var1;
      int var3 = this.field2952.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2955[var4] = 0;
         this.field2953[var4] = 0;
         this.field2961.field1992 = this.field2951[var4];
         this.method3614(var4);
         this.field2952[var4] = this.field2961.field1992;
      }

   }
}
