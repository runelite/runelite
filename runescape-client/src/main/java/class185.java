import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class185 {
   @ObfuscatedName("d")
   int field2996;
   @ObfuscatedName("h")
   int field2997;
   @ObfuscatedName("e")
   int[] field2998;
   @ObfuscatedName("g")
   int[] field2999;
   @ObfuscatedName("i")
   Buffer field3000 = new Buffer((byte[])null);
   @ObfuscatedName("m")
   long field3004;
   @ObfuscatedName("j")
   static final byte[] field3005 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("u")
   int[] field3008;
   @ObfuscatedName("n")
   int[] field3009;

   @ObfuscatedName("h")
   void method3563() {
      this.field3000.payload = null;
      this.field2998 = null;
      this.field2999 = null;
      this.field3009 = null;
      this.field3008 = null;
   }

   class185(byte[] var1) {
      this.method3565(var1);
   }

   @ObfuscatedName("i")
   void method3565(byte[] var1) {
      this.field3000.payload = var1;
      this.field3000.offset = 10;
      int var2 = this.field3000.method2546();
      this.field2997 = this.field3000.method2546();
      this.field2996 = 500000;
      this.field2998 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field3000.offset += var5) {
         int var4 = this.field3000.method2549();
         var5 = this.field3000.method2549();
         if(var4 == 1297379947) {
            this.field2998[var3] = this.field3000.offset;
            ++var3;
         }
      }

      this.field3004 = 0L;
      this.field2999 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2999[var3] = this.field2998[var3];
      }

      this.field3009 = new int[var2];
      this.field3008 = new int[var2];
   }

   @ObfuscatedName("g")
   int method3567() {
      return this.field2999.length;
   }

   @ObfuscatedName("v")
   boolean method3568() {
      int var1 = this.field2999.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2999[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("u")
   void method3569(int var1) {
      this.field2999[var1] = this.field3000.offset;
   }

   @ObfuscatedName("d")
   void method3570() {
      this.field3000.offset = -1;
   }

   @ObfuscatedName("l")
   void method3571(int var1) {
      int var2 = this.field3000.method2616();
      this.field3009[var1] += var2;
   }

   @ObfuscatedName("m")
   int method3572(int var1) {
      int var2 = this.method3573(var1);
      return var2;
   }

   @ObfuscatedName("j")
   int method3573(int var1) {
      byte var2 = this.field3000.payload[this.field3000.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field3008[var1] = var5;
         ++this.field3000.offset;
      } else {
         var5 = this.field3008[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3574(var1, var5);
      } else {
         int var3 = this.field3000.method2616();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field3000.payload[this.field3000.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field3000.offset;
               this.field3008[var1] = var4;
               return this.method3574(var1, var4);
            }
         }

         this.field3000.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("y")
   int method3574(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field3000.method2544();
         var4 = this.field3000.method2616();
         if(var7 == 47) {
            this.field3000.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field3000.method2548();
            var4 -= 3;
            int var6 = this.field3009[var1];
            this.field3004 += (long)var6 * (long)(this.field2996 - var5);
            this.field2996 = var5;
            this.field3000.offset += var4;
            return 2;
         } else {
            this.field3000.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field3005[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field3000.method2544() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field3000.method2544() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   int method3576() {
      int var1 = this.field2999.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2999[var4] >= 0 && this.field3009[var4] < var3) {
            var2 = var4;
            var3 = this.field3009[var4];
         }
      }

      return var2;
   }

   class185() {
   }

   @ObfuscatedName("r")
   void method3577(long var1) {
      this.field3004 = var1;
      int var3 = this.field2999.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3009[var4] = 0;
         this.field3008[var4] = 0;
         this.field3000.offset = this.field2998[var4];
         this.method3571(var4);
         this.field2999[var4] = this.field3000.offset;
      }

   }

   @ObfuscatedName("s")
   long method3597(int var1) {
      return this.field3004 + (long)var1 * (long)this.field2996;
   }

   @ObfuscatedName("e")
   boolean method3598() {
      return this.field3000.payload != null;
   }

   @ObfuscatedName("n")
   void method3614(int var1) {
      this.field3000.offset = this.field2999[var1];
   }
}
