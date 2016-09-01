import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class185 {
   @ObfuscatedName("f")
   static final byte[] field2992 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("r")
   int field2993;
   @ObfuscatedName("i")
   int[] field2994;
   @ObfuscatedName("j")
   int[] field2995;
   @ObfuscatedName("z")
   int[] field2996;
   @ObfuscatedName("b")
   int[] field2997;
   @ObfuscatedName("l")
   int field2998;
   @ObfuscatedName("p")
   long field3000;
   @ObfuscatedName("x")
   Buffer field3001 = new Buffer((byte[])null);

   @ObfuscatedName("x")
   void method3554(byte[] var1) {
      this.field3001.payload = var1;
      this.field3001.offset = 10;
      int var2 = this.field3001.method2551();
      this.field2993 = this.field3001.method2551();
      this.field2998 = 500000;
      this.field2995 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field3001.offset += var5) {
         int var4 = this.field3001.method2561();
         var5 = this.field3001.method2561();
         if(var4 == 1297379947) {
            this.field2995[var3] = this.field3001.offset;
            ++var3;
         }
      }

      this.field3000 = 0L;
      this.field2996 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2996[var3] = this.field2995[var3];
      }

      this.field2994 = new int[var2];
      this.field2997 = new int[var2];
   }

   @ObfuscatedName("j")
   boolean method3556() {
      return this.field3001.payload != null;
   }

   @ObfuscatedName("z")
   int method3557() {
      return this.field2996.length;
   }

   @ObfuscatedName("i")
   void method3558(int var1) {
      this.field3001.offset = this.field2996[var1];
   }

   @ObfuscatedName("m")
   void method3559(int var1) {
      int var2 = this.field3001.method2737();
      this.field2994[var1] += var2;
   }

   @ObfuscatedName("f")
   int method3561(int var1) {
      byte var2 = this.field3001.payload[this.field3001.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2997[var1] = var5;
         ++this.field3001.offset;
      } else {
         var5 = this.field2997[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3563(var1, var5);
      } else {
         int var3 = this.field3001.method2737();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field3001.payload[this.field3001.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field3001.offset;
               this.field2997[var1] = var4;
               return this.method3563(var1, var4);
            }
         }

         this.field3001.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("p")
   int method3562(int var1) {
      int var2 = this.method3561(var1);
      return var2;
   }

   @ObfuscatedName("d")
   int method3563(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field3001.method2556();
         var4 = this.field3001.method2737();
         if(var7 == 47) {
            this.field3001.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field3001.method2560();
            var4 -= 3;
            int var6 = this.field2994[var1];
            this.field3000 += (long)var6 * (long)(this.field2998 - var5);
            this.field2998 = var5;
            this.field3001.offset += var4;
            return 2;
         } else {
            this.field3001.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2992[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field3001.method2556() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field3001.method2556() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   void method3564(int var1) {
      this.field2996[var1] = this.field3001.offset;
   }

   @ObfuscatedName("v")
   long method3565(int var1) {
      return this.field3000 + (long)var1 * (long)this.field2998;
   }

   @ObfuscatedName("q")
   int method3566() {
      int var1 = this.field2996.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2996[var4] >= 0 && this.field2994[var4] < var3) {
            var2 = var4;
            var3 = this.field2994[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("r")
   void method3567() {
      this.field3001.payload = null;
      this.field2995 = null;
      this.field2996 = null;
      this.field2994 = null;
      this.field2997 = null;
   }

   @ObfuscatedName("g")
   void method3568(long var1) {
      this.field3000 = var1;
      int var3 = this.field2996.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2994[var4] = 0;
         this.field2997[var4] = 0;
         this.field3001.offset = this.field2995[var4];
         this.method3559(var4);
         this.field2996[var4] = this.field3001.offset;
      }

   }

   @ObfuscatedName("l")
   void method3576() {
      this.field3001.offset = -1;
   }

   class185() {
   }

   @ObfuscatedName("t")
   boolean method3587() {
      int var1 = this.field2996.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2996[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class185(byte[] var1) {
      this.method3554(var1);
   }
}
