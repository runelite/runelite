import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class182 {
   @ObfuscatedName("v")
   long field2950;
   @ObfuscatedName("x")
   int field2951;
   @ObfuscatedName("w")
   class119 field2952 = new class119((byte[])null);
   @ObfuscatedName("p")
   int[] field2953;
   @ObfuscatedName("t")
   int[] field2954;
   @ObfuscatedName("y")
   int[] field2955;
   @ObfuscatedName("m")
   int field2957;
   @ObfuscatedName("l")
   static final byte[] field2959 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("e")
   int[] field2962;

   @ObfuscatedName("j")
   int method3554() {
      int var1 = this.field2953.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2953[var4] >= 0 && this.field2962[var4] < var3) {
            var2 = var4;
            var3 = this.field2962[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("w")
   void method3555(byte[] var1) {
      this.field2952.field2012 = var1;
      this.field2952.field2011 = 10;
      int var2 = this.field2952.method2508();
      this.field2951 = this.field2952.method2508();
      this.field2957 = 500000;
      this.field2954 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2952.field2011 += var5) {
         int var4 = this.field2952.method2511();
         var5 = this.field2952.method2511();
         if(var4 == 1297379947) {
            this.field2954[var3] = this.field2952.field2011;
            ++var3;
         }
      }

      this.field2950 = 0L;
      this.field2953 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2953[var3] = this.field2954[var3];
      }

      this.field2962 = new int[var2];
      this.field2955 = new int[var2];
   }

   @ObfuscatedName("y")
   void method3556(int var1) {
      this.field2953[var1] = this.field2952.field2011;
   }

   @ObfuscatedName("t")
   boolean method3557() {
      return this.field2952.field2012 != null;
   }

   @ObfuscatedName("p")
   int method3558() {
      return this.field2953.length;
   }

   @ObfuscatedName("e")
   void method3559(int var1) {
      this.field2952.field2011 = this.field2953[var1];
   }

   @ObfuscatedName("m")
   void method3561() {
      this.field2952.field2011 = -1;
   }

   @ObfuscatedName("c")
   void method3562(int var1) {
      int var2 = this.field2952.method2521();
      this.field2962[var1] += var2;
   }

   @ObfuscatedName("v")
   int method3563(int var1) {
      int var2 = this.method3577(var1);
      return var2;
   }

   @ObfuscatedName("z")
   int method3565(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2952.method2506();
         var4 = this.field2952.method2521();
         if(var7 == 47) {
            this.field2952.field2011 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2952.method2510();
            var4 -= 3;
            int var6 = this.field2962[var1];
            this.field2950 += (long)var6 * (long)(this.field2957 - var5);
            this.field2957 = var5;
            this.field2952.field2011 += var4;
            return 2;
         } else {
            this.field2952.field2011 += var4;
            return 3;
         }
      } else {
         byte var3 = field2959[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2952.method2506() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2952.method2506() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   void method3569(long var1) {
      this.field2950 = var1;
      int var3 = this.field2953.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2962[var4] = 0;
         this.field2955[var4] = 0;
         this.field2952.field2011 = this.field2954[var4];
         this.method3562(var4);
         this.field2953[var4] = this.field2952.field2011;
      }

   }

   @ObfuscatedName("q")
   boolean method3570() {
      int var1 = this.field2953.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2953[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("l")
   int method3577(int var1) {
      byte var2 = this.field2952.field2012[this.field2952.field2011];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2955[var1] = var5;
         ++this.field2952.field2011;
      } else {
         var5 = this.field2955[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3565(var1, var5);
      } else {
         int var3 = this.field2952.method2521();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2952.field2012[this.field2952.field2011] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2952.field2011;
               this.field2955[var1] = var4;
               return this.method3565(var1, var4);
            }
         }

         this.field2952.field2011 += var3;
         return 0;
      }
   }

   @ObfuscatedName("x")
   void method3580() {
      this.field2952.field2012 = null;
      this.field2954 = null;
      this.field2953 = null;
      this.field2962 = null;
      this.field2955 = null;
   }

   class182() {
   }

   @ObfuscatedName("s")
   long method3586(int var1) {
      return this.field2950 + (long)var1 * (long)this.field2957;
   }

   class182(byte[] var1) {
      this.method3555(var1);
   }
}
