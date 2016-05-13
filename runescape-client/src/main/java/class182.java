import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class182 {
   @ObfuscatedName("j")
   int field2957;
   @ObfuscatedName("c")
   static final byte[] field2958 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("x")
   int[] field2959;
   @ObfuscatedName("d")
   int[] field2960;
   @ObfuscatedName("u")
   int[] field2961;
   @ObfuscatedName("p")
   int[] field2962;
   @ObfuscatedName("k")
   long field2964;
   @ObfuscatedName("s")
   class119 field2965 = new class119((byte[])null);
   @ObfuscatedName("o")
   int field2968;

   class182(byte[] var1) {
      this.method3533(var1);
   }

   @ObfuscatedName("j")
   void method3514() {
      this.field2965.field2007 = null;
      this.field2962 = null;
      this.field2959 = null;
      this.field2960 = null;
      this.field2961 = null;
   }

   @ObfuscatedName("p")
   boolean method3515() {
      return this.field2965.field2007 != null;
   }

   @ObfuscatedName("d")
   void method3517(int var1) {
      this.field2965.field2005 = this.field2959[var1];
   }

   @ObfuscatedName("o")
   void method3519() {
      this.field2965.field2005 = -1;
   }

   @ObfuscatedName("b")
   void method3520(int var1) {
      int var2 = this.field2965.method2507();
      this.field2960[var1] += var2;
   }

   @ObfuscatedName("k")
   int method3521(int var1) {
      int var2 = this.method3522(var1);
      return var2;
   }

   @ObfuscatedName("c")
   int method3522(int var1) {
      byte var2 = this.field2965.field2007[this.field2965.field2005];
      int var3;
      if(var2 < 0) {
         var3 = var2 & 255;
         this.field2961[var1] = var3;
         ++this.field2965.field2005;
      } else {
         var3 = this.field2961[var1];
      }

      if(var3 != 240 && var3 != 247) {
         return this.method3523(var1, var3);
      } else {
         int var4 = this.field2965.method2507();
         if(var3 == 247 && var4 > 0) {
            int var5 = this.field2965.field2007[this.field2965.field2005] & 255;
            if(var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
               ++this.field2965.field2005;
               this.field2961[var1] = var5;
               return this.method3523(var1, var5);
            }
         }

         this.field2965.field2005 += var4;
         return 0;
      }
   }

   @ObfuscatedName("l")
   int method3523(int var1, int var2) {
      int var3;
      if(var2 == 255) {
         int var7 = this.field2965.method2492();
         var3 = this.field2965.method2507();
         if(var7 == 47) {
            this.field2965.field2005 += var3;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2965.method2513();
            var3 -= 3;
            int var6 = this.field2960[var1];
            this.field2964 += (long)var6 * (long)(this.field2968 - var5);
            this.field2968 = var5;
            this.field2965.field2005 += var3;
            return 2;
         } else {
            this.field2965.field2005 += var3;
            return 3;
         }
      } else {
         byte var4 = field2958[var2 - 128];
         var3 = var2;
         if(var4 >= 1) {
            var3 = var2 | this.field2965.method2492() << 8;
         }

         if(var4 >= 2) {
            var3 |= this.field2965.method2492() << 16;
         }

         return var3;
      }
   }

   @ObfuscatedName("t")
   long method3524(int var1) {
      return this.field2964 + (long)var1 * (long)this.field2968;
   }

   @ObfuscatedName("i")
   int method3525() {
      int var1 = this.field2959.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2959[var4] >= 0 && this.field2960[var4] < var3) {
            var2 = var4;
            var3 = this.field2960[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("r")
   boolean method3526() {
      int var1 = this.field2959.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2959[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("m")
   void method3527(long var1) {
      this.field2964 = var1;
      int var3 = this.field2959.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2960[var4] = 0;
         this.field2961[var4] = 0;
         this.field2965.field2005 = this.field2962[var4];
         this.method3520(var4);
         this.field2959[var4] = this.field2965.field2005;
      }

   }

   @ObfuscatedName("s")
   void method3533(byte[] var1) {
      this.field2965.field2007 = var1;
      this.field2965.field2005 = 10;
      int var2 = this.field2965.method2584();
      this.field2957 = this.field2965.method2584();
      this.field2968 = 500000;
      this.field2962 = new int[var2];

      int var3;
      int var4;
      for(var3 = 0; var3 < var2; this.field2965.field2005 += var4) {
         int var5 = this.field2965.method2497();
         var4 = this.field2965.method2497();
         if(var5 == 1297379947) {
            this.field2962[var3] = this.field2965.field2005;
            ++var3;
         }
      }

      this.field2964 = 0L;
      this.field2959 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2959[var3] = this.field2962[var3];
      }

      this.field2960 = new int[var2];
      this.field2961 = new int[var2];
   }

   class182() {
   }

   @ObfuscatedName("u")
   void method3557(int var1) {
      this.field2959[var1] = this.field2965.field2005;
   }

   @ObfuscatedName("x")
   int method3561() {
      return this.field2959.length;
   }
}
