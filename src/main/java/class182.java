import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class182 {
   @ObfuscatedName("e")
   int[] field2942;
   @ObfuscatedName("m")
   int[] field2943;
   @ObfuscatedName("j")
   class119 field2944 = new class119((byte[])null);
   @ObfuscatedName("x")
   int[] field2945;
   @ObfuscatedName("i")
   int field2947;
   @ObfuscatedName("z")
   int[] field2948;
   @ObfuscatedName("n")
   long field2949;
   @ObfuscatedName("l")
   static final byte[] field2951 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("h")
   int field2954;

   @ObfuscatedName("i")
   void method3486() {
      this.field2944.field1971 = -1;
   }

   class182(byte[] var1) {
      this.method3487(var1);
   }

   @ObfuscatedName("j")
   void method3487(byte[] var1) {
      this.field2944.field1973 = var1;
      this.field2944.field1971 = 10;
      int var2 = this.field2944.method2502();
      this.field2954 = this.field2944.method2502();
      this.field2947 = 500000;
      this.field2943 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2944.field1971 += var5) {
         int var4 = this.field2944.method2505();
         var5 = this.field2944.method2505();
         if(var4 == 1297379947) {
            this.field2943[var3] = this.field2944.field1971;
            ++var3;
         }
      }

      this.field2949 = 0L;
      this.field2948 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2948[var3] = this.field2943[var3];
      }

      this.field2945 = new int[var2];
      this.field2942 = new int[var2];
   }

   @ObfuscatedName("x")
   void method3489(int var1) {
      this.field2944.field1971 = this.field2948[var1];
   }

   @ObfuscatedName("z")
   int method3490() {
      return this.field2948.length;
   }

   @ObfuscatedName("e")
   void method3492(int var1) {
      this.field2948[var1] = this.field2944.field1971;
   }

   @ObfuscatedName("r")
   long method3493(int var1) {
      return this.field2949 + (long)var1 * (long)this.field2947;
   }

   @ObfuscatedName("c")
   void method3494(int var1) {
      int var2 = this.field2944.method2602();
      this.field2945[var1] += var2;
   }

   @ObfuscatedName("m")
   boolean method3496() {
      return this.field2944.field1973 != null;
   }

   @ObfuscatedName("u")
   int method3497(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2944.method2500();
         var4 = this.field2944.method2602();
         if(var7 == 47) {
            this.field2944.field1971 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2944.method2662();
            var4 -= 3;
            int var6 = this.field2945[var1];
            this.field2949 += (long)var6 * (long)(this.field2947 - var5);
            this.field2947 = var5;
            this.field2944.field1971 += var4;
            return 2;
         } else {
            this.field2944.field1971 += var4;
            return 3;
         }
      } else {
         byte var3 = field2951[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2944.method2500() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2944.method2500() << 16;
         }

         return var4;
      }
   }

   class182() {
   }

   @ObfuscatedName("d")
   boolean method3499() {
      int var1 = this.field2948.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2948[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("a")
   int method3510() {
      int var1 = this.field2948.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2948[var4] >= 0 && this.field2945[var4] < var3) {
            var2 = var4;
            var3 = this.field2945[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   void method3514(long var1) {
      this.field2949 = var1;
      int var3 = this.field2948.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2945[var4] = 0;
         this.field2942[var4] = 0;
         this.field2944.field1971 = this.field2943[var4];
         this.method3494(var4);
         this.field2948[var4] = this.field2944.field1971;
      }

   }

   @ObfuscatedName("l")
   int method3515(int var1) {
      byte var2 = this.field2944.field1973[this.field2944.field1971];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2942[var1] = var5;
         ++this.field2944.field1971;
      } else {
         var5 = this.field2942[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3497(var1, var5);
      } else {
         int var3 = this.field2944.method2602();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2944.field1973[this.field2944.field1971] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2944.field1971;
               this.field2942[var1] = var4;
               return this.method3497(var1, var4);
            }
         }

         this.field2944.field1971 += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   void method3527() {
      this.field2944.field1973 = null;
      this.field2943 = null;
      this.field2948 = null;
      this.field2945 = null;
      this.field2942 = null;
   }

   @ObfuscatedName("n")
   int method3534(int var1) {
      int var2 = this.method3515(var1);
      return var2;
   }
}
