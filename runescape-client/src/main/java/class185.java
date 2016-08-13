import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
public class class185 {
   @ObfuscatedName("e")
   int[] field2998;
   @ObfuscatedName("h")
   int[] field2999;
   @ObfuscatedName("s")
   int[] field3000;
   @ObfuscatedName("k")
   int field3001;
   @ObfuscatedName("n")
   long field3003;
   @ObfuscatedName("r")
   int[] field3004;
   @ObfuscatedName("g")
   int field3005;
   @ObfuscatedName("l")
   Buffer field3006 = new Buffer((byte[])null);
   @ObfuscatedName("b")
   static final byte[] field3007 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};

   class185(byte[] var1) {
      this.method3691(var1);
   }

   @ObfuscatedName("l")
   void method3691(byte[] var1) {
      this.field3006.payload = var1;
      this.field3006.offset = 10;
      int var2 = this.field3006.method2635();
      this.field3005 = this.field3006.method2635();
      this.field3001 = 500000;
      this.field3004 = new int[var2];

      int var3;
      int var4;
      for(var3 = 0; var3 < var2; this.field3006.offset += var4) {
         int var5 = this.field3006.method2620();
         var4 = this.field3006.method2620();
         if(var5 == 1297379947) {
            this.field3004[var3] = this.field3006.offset;
            ++var3;
         }
      }

      this.field3003 = 0L;
      this.field2998 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2998[var3] = this.field3004[var3];
      }

      this.field2999 = new int[var2];
      this.field3000 = new int[var2];
   }

   @ObfuscatedName("g")
   void method3692() {
      this.field3006.payload = null;
      this.field3004 = null;
      this.field2998 = null;
      this.field2999 = null;
      this.field3000 = null;
   }

   @ObfuscatedName("r")
   boolean method3693() {
      return this.field3006.payload != null;
   }

   @ObfuscatedName("e")
   int method3694() {
      return this.field2998.length;
   }

   @ObfuscatedName("s")
   void method3695(int var1) {
      this.field2998[var1] = this.field3006.offset;
   }

   @ObfuscatedName("k")
   void method3697() {
      this.field3006.offset = -1;
   }

   @ObfuscatedName("n")
   int method3698(int var1) {
      int var2 = this.method3699(var1);
      return var2;
   }

   @ObfuscatedName("b")
   int method3699(int var1) {
      byte var2 = this.field3006.payload[this.field3006.offset];
      int var3;
      if(var2 < 0) {
         var3 = var2 & 255;
         this.field3000[var1] = var3;
         ++this.field3006.offset;
      } else {
         var3 = this.field3000[var1];
      }

      if(var3 != 240 && var3 != 247) {
         return this.method3700(var1, var3);
      } else {
         int var4 = this.field3006.method2832();
         if(var3 == 247 && var4 > 0) {
            int var5 = this.field3006.payload[this.field3006.offset] & 255;
            if(var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
               ++this.field3006.offset;
               this.field3000[var1] = var5;
               return this.method3700(var1, var5);
            }
         }

         this.field3006.offset += var4;
         return 0;
      }
   }

   @ObfuscatedName("m")
   int method3700(int var1, int var2) {
      int var3;
      if(var2 == 255) {
         int var7 = this.field3006.method2633();
         var3 = this.field3006.method2832();
         if(var7 == 47) {
            this.field3006.offset += var3;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field3006.method2637();
            var3 -= 3;
            int var6 = this.field2999[var1];
            this.field3003 += (long)var6 * (long)(this.field3001 - var5);
            this.field3001 = var5;
            this.field3006.offset += var3;
            return 2;
         } else {
            this.field3006.offset += var3;
            return 3;
         }
      } else {
         byte var4 = field3007[var2 - 128];
         var3 = var2;
         if(var4 >= 1) {
            var3 = var2 | this.field3006.method2633() << 8;
         }

         if(var4 >= 2) {
            var3 |= this.field3006.method2633() << 16;
         }

         return var3;
      }
   }

   @ObfuscatedName("p")
   int method3702() {
      int var1 = this.field2998.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2998[var4] >= 0 && this.field2999[var4] < var3) {
            var2 = var4;
            var3 = this.field2999[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("o")
   void method3704(long var1) {
      this.field3003 = var1;
      int var3 = this.field2998.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2999[var4] = 0;
         this.field3000[var4] = 0;
         this.field3006.offset = this.field3004[var4];
         this.method3705(var4);
         this.field2998[var4] = this.field3006.offset;
      }

   }

   @ObfuscatedName("u")
   void method3705(int var1) {
      int var2 = this.field3006.method2832();
      this.field2999[var1] += var2;
   }

   @ObfuscatedName("q")
   long method3710(int var1) {
      return this.field3003 + (long)var1 * (long)this.field3001;
   }

   class185() {
   }

   @ObfuscatedName("w")
   boolean method3725() {
      int var1 = this.field2998.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2998[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("h")
   void method3732(int var1) {
      this.field3006.offset = this.field2998[var1];
   }
}
