import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
public class class182 {
   @ObfuscatedName("x")
   int[] field2940;
   @ObfuscatedName("b")
   int[] field2941;
   @ObfuscatedName("d")
   int[] field2943;
   @ObfuscatedName("n")
   int field2944;
   @ObfuscatedName("g")
   long field2946;
   @ObfuscatedName("s")
   static final byte[] field2947 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("l")
   int[] field2949;
   @ObfuscatedName("u")
   int field2950;
   @ObfuscatedName("f")
   class119 field2951 = new class119((byte[])null);

   @ObfuscatedName("f")
   void method3568(byte[] var1) {
      this.field2951.field2000 = var1;
      this.field2951.field1998 = 10;
      int var2 = this.field2951.method2556();
      this.field2950 = this.field2951.method2556();
      this.field2944 = 500000;
      this.field2940 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2951.field1998 += var5) {
         int var4 = this.field2951.method2696();
         var5 = this.field2951.method2696();
         if(var4 == 1297379947) {
            this.field2940[var3] = this.field2951.field1998;
            ++var3;
         }
      }

      this.field2946 = 0L;
      this.field2941 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2941[var3] = this.field2940[var3];
      }

      this.field2949 = new int[var2];
      this.field2943 = new int[var2];
   }

   class182(byte[] var1) {
      this.method3568(var1);
   }

   @ObfuscatedName("d")
   void method3572(int var1) {
      this.field2941[var1] = this.field2951.field1998;
   }

   @ObfuscatedName("n")
   void method3573() {
      this.field2951.field1998 = -1;
   }

   @ObfuscatedName("m")
   void method3574(int var1) {
      int var2 = this.field2951.method2569();
      this.field2949[var1] += var2;
   }

   @ObfuscatedName("g")
   int method3575(int var1) {
      int var2 = this.method3579(var1);
      return var2;
   }

   @ObfuscatedName("b")
   int method3576() {
      return this.field2941.length;
   }

   @ObfuscatedName("s")
   int method3579(int var1) {
      byte var2 = this.field2951.field2000[this.field2951.field1998];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2943[var1] = var5;
         ++this.field2951.field1998;
      } else {
         var5 = this.field2943[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3602(var1, var5);
      } else {
         int var3 = this.field2951.method2569();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2951.field2000[this.field2951.field1998] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2951.field1998;
               this.field2943[var1] = var4;
               return this.method3602(var1, var4);
            }
         }

         this.field2951.field1998 += var3;
         return 0;
      }
   }

   @ObfuscatedName("q")
   boolean method3580() {
      int var1 = this.field2941.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2941[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("p")
   void method3581(long var1) {
      this.field2946 = var1;
      int var3 = this.field2941.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2949[var4] = 0;
         this.field2943[var4] = 0;
         this.field2951.field1998 = this.field2940[var4];
         this.method3574(var4);
         this.field2941[var4] = this.field2951.field1998;
      }

   }

   @ObfuscatedName("l")
   void method3582(int var1) {
      this.field2951.field1998 = this.field2941[var1];
   }

   class182() {
   }

   @ObfuscatedName("u")
   void method3594() {
      this.field2951.field2000 = null;
      this.field2940 = null;
      this.field2941 = null;
      this.field2949 = null;
      this.field2943 = null;
   }

   @ObfuscatedName("r")
   int method3602(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2951.method2554();
         var4 = this.field2951.method2569();
         if(var7 == 47) {
            this.field2951.field1998 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2951.method2558();
            var4 -= 3;
            int var6 = this.field2949[var1];
            this.field2946 += (long)var6 * (long)(this.field2944 - var5);
            this.field2944 = var5;
            this.field2951.field1998 += var4;
            return 2;
         } else {
            this.field2951.field1998 += var4;
            return 3;
         }
      } else {
         byte var3 = field2947[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2951.method2554() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2951.method2554() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   long method3604(int var1) {
      return this.field2946 + (long)var1 * (long)this.field2944;
   }

   @ObfuscatedName("o")
   int method3606() {
      int var1 = this.field2941.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2941[var4] >= 0 && this.field2949[var4] < var3) {
            var2 = var4;
            var3 = this.field2949[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("x")
   boolean method3608() {
      return this.field2951.field2000 != null;
   }
}
