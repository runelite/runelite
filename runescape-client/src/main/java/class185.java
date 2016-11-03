import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class185 {
   @ObfuscatedName("u")
   long field2991;
   @ObfuscatedName("q")
   int field2992;
   @ObfuscatedName("f")
   int[] field2993;
   @ObfuscatedName("c")
   int[] field2994;
   @ObfuscatedName("j")
   int[] field2996;
   @ObfuscatedName("m")
   int field2997;
   @ObfuscatedName("v")
   int[] field2998;
   @ObfuscatedName("h")
   static final byte[] field3000 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("k")
   Buffer field3003 = new Buffer((byte[])null);

   class185(byte[] var1) {
      this.method3564(var1);
   }

   @ObfuscatedName("k")
   void method3564(byte[] var1) {
      this.field3003.payload = var1;
      this.field3003.offset = 10;
      int var2 = this.field3003.method2691();
      this.field2992 = this.field3003.method2691();
      this.field2997 = 500000;
      this.field2993 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field3003.offset += var5) {
         int var4 = this.field3003.method2576();
         var5 = this.field3003.method2576();
         if(var4 == 1297379947) {
            this.field2993[var3] = this.field3003.offset;
            ++var3;
         }
      }

      this.field2991 = 0L;
      this.field2994 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2994[var3] = this.field2993[var3];
      }

      this.field2998 = new int[var2];
      this.field2996 = new int[var2];
   }

   @ObfuscatedName("q")
   void method3565() {
      this.field3003.payload = null;
      this.field2993 = null;
      this.field2994 = null;
      this.field2998 = null;
      this.field2996 = null;
   }

   @ObfuscatedName("f")
   boolean method3566() {
      return this.field3003.payload != null;
   }

   @ObfuscatedName("c")
   int method3567() {
      return this.field2994.length;
   }

   @ObfuscatedName("j")
   void method3569(int var1) {
      this.field2994[var1] = this.field3003.offset;
   }

   @ObfuscatedName("m")
   void method3570() {
      this.field3003.offset = -1;
   }

   @ObfuscatedName("y")
   void method3571(int var1) {
      int var2 = this.field3003.method2587();
      this.field2998[var1] += var2;
   }

   @ObfuscatedName("u")
   int method3572(int var1) {
      int var2 = this.method3573(var1);
      return var2;
   }

   @ObfuscatedName("h")
   int method3573(int var1) {
      byte var2 = this.field3003.payload[this.field3003.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2996[var1] = var5;
         ++this.field3003.offset;
      } else {
         var5 = this.field2996[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3602(var1, var5);
      } else {
         int var3 = this.field3003.method2587();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field3003.payload[this.field3003.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field3003.offset;
               this.field2996[var1] = var4;
               return this.method3602(var1, var4);
            }
         }

         this.field3003.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("b")
   long method3575(int var1) {
      return this.field2991 + (long)var1 * (long)this.field2997;
   }

   @ObfuscatedName("p")
   void method3578(long var1) {
      this.field2991 = var1;
      int var3 = this.field2994.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2998[var4] = 0;
         this.field2996[var4] = 0;
         this.field3003.offset = this.field2993[var4];
         this.method3571(var4);
         this.field2994[var4] = this.field3003.offset;
      }

   }

   @ObfuscatedName("e")
   boolean method3584() {
      int var1 = this.field2994.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2994[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("v")
   void method3591(int var1) {
      this.field3003.offset = this.field2994[var1];
   }

   @ObfuscatedName("g")
   int method3592() {
      int var1 = this.field2994.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2994[var4] >= 0 && this.field2998[var4] < var3) {
            var2 = var4;
            var3 = this.field2998[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("l")
   int method3602(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field3003.method2571();
         var4 = this.field3003.method2587();
         if(var7 == 47) {
            this.field3003.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field3003.method2575();
            var4 -= 3;
            int var6 = this.field2998[var1];
            this.field2991 += (long)var6 * (long)(this.field2997 - var5);
            this.field2997 = var5;
            this.field3003.offset += var4;
            return 2;
         } else {
            this.field3003.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field3000[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field3003.method2571() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field3003.method2571() << 16;
         }

         return var4;
      }
   }

   class185() {
   }
}
