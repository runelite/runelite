import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class182 {
   @ObfuscatedName("g")
   int field2941;
   @ObfuscatedName("p")
   int[] field2944;
   @ObfuscatedName("h")
   int[] field2945;
   @ObfuscatedName("e")
   class119 field2946 = new class119((byte[])null);
   @ObfuscatedName("w")
   int field2947;
   @ObfuscatedName("r")
   long field2948;
   @ObfuscatedName("k")
   static final byte[] field2949 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("s")
   int[] field2951;
   @ObfuscatedName("f")
   int[] field2953;

   @ObfuscatedName("m")
   int method3516(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2946.method2523();
         var4 = this.field2946.method2679();
         if(var7 == 47) {
            this.field2946.field1976 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2946.method2527();
            var4 -= 3;
            int var6 = this.field2944[var1];
            this.field2948 += (long)var6 * (long)(this.field2941 - var5);
            this.field2941 = var5;
            this.field2946.field1976 += var4;
            return 2;
         } else {
            this.field2946.field1976 += var4;
            return 3;
         }
      } else {
         byte var3 = field2949[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2946.method2523() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2946.method2523() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("w")
   void method3519() {
      this.field2946.field1980 = null;
      this.field2953 = null;
      this.field2951 = null;
      this.field2944 = null;
      this.field2945 = null;
   }

   @ObfuscatedName("f")
   boolean method3520() {
      return this.field2946.field1980 != null;
   }

   @ObfuscatedName("s")
   int method3521() {
      return this.field2951.length;
   }

   @ObfuscatedName("p")
   void method3522(int var1) {
      this.field2946.field1976 = this.field2951[var1];
   }

   @ObfuscatedName("k")
   int method3523(int var1) {
      byte var2 = this.field2946.field1980[this.field2946.field1976];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2945[var1] = var5;
         ++this.field2946.field1976;
      } else {
         var5 = this.field2945[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3516(var1, var5);
      } else {
         int var3 = this.field2946.method2679();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2946.field1980[this.field2946.field1976] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2946.field1976;
               this.field2945[var1] = var4;
               return this.method3516(var1, var4);
            }
         }

         this.field2946.field1976 += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   void method3525(int var1) {
      this.field2951[var1] = this.field2946.field1976;
   }

   @ObfuscatedName("r")
   int method3526(int var1) {
      int var2 = this.method3523(var1);
      return var2;
   }

   @ObfuscatedName("n")
   long method3529(int var1) {
      return this.field2948 + (long)var1 * (long)this.field2941;
   }

   @ObfuscatedName("y")
   int method3530() {
      int var1 = this.field2951.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2951[var4] >= 0 && this.field2944[var4] < var3) {
            var2 = var4;
            var3 = this.field2944[var4];
         }
      }

      return var2;
   }

   class182(byte[] var1) {
      this.method3551(var1);
   }

   @ObfuscatedName("i")
   boolean method3533() {
      int var1 = this.field2951.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2951[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class182() {
   }

   @ObfuscatedName("j")
   void method3537(long var1) {
      this.field2948 = var1;
      int var3 = this.field2951.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2944[var4] = 0;
         this.field2945[var4] = 0;
         this.field2946.field1976 = this.field2953[var4];
         this.method3565(var4);
         this.field2951[var4] = this.field2946.field1976;
      }

   }

   @ObfuscatedName("e")
   void method3551(byte[] var1) {
      this.field2946.field1980 = var1;
      this.field2946.field1976 = 10;
      int var2 = this.field2946.method2700();
      this.field2947 = this.field2946.method2700();
      this.field2941 = 500000;
      this.field2953 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2946.field1976 += var5) {
         int var4 = this.field2946.method2528();
         var5 = this.field2946.method2528();
         if(var4 == 1297379947) {
            this.field2953[var3] = this.field2946.field1976;
            ++var3;
         }
      }

      this.field2948 = 0L;
      this.field2951 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2951[var3] = this.field2953[var3];
      }

      this.field2944 = new int[var2];
      this.field2945 = new int[var2];
   }

   @ObfuscatedName("g")
   void method3563() {
      this.field2946.field1976 = -1;
   }

   @ObfuscatedName("a")
   void method3565(int var1) {
      int var2 = this.field2946.method2679();
      this.field2944[var1] += var2;
   }
}
