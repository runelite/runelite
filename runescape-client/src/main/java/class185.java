import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class185 {
   @ObfuscatedName("a")
   Buffer field2999 = new Buffer((byte[])null);
   @ObfuscatedName("v")
   int[] field3000;
   @ObfuscatedName("r")
   int[] field3001;
   @ObfuscatedName("z")
   int[] field3002;
   @ObfuscatedName("t")
   int[] field3003;
   @ObfuscatedName("g")
   long field3004;
   @ObfuscatedName("d")
   int field3006;
   @ObfuscatedName("m")
   static final byte[] field3007 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("n")
   int field3010;

   class185(byte[] var1) {
      this.method3563(var1);
   }

   @ObfuscatedName("a")
   void method3563(byte[] var1) {
      this.field2999.payload = var1;
      this.field2999.offset = 10;
      int var2 = this.field2999.method2717();
      this.field3006 = this.field2999.method2717();
      this.field3010 = 500000;
      this.field3000 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2999.offset += var5) {
         int var4 = this.field2999.method2533();
         var5 = this.field2999.method2533();
         if(var4 == 1297379947) {
            this.field3000[var3] = this.field2999.offset;
            ++var3;
         }
      }

      this.field3004 = 0L;
      this.field3001 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field3001[var3] = this.field3000[var3];
      }

      this.field3002 = new int[var2];
      this.field3003 = new int[var2];
   }

   @ObfuscatedName("v")
   boolean method3565() {
      return this.field2999.payload != null;
   }

   @ObfuscatedName("z")
   void method3567(int var1) {
      this.field2999.offset = this.field3001[var1];
   }

   @ObfuscatedName("t")
   void method3568(int var1) {
      this.field3001[var1] = this.field2999.offset;
   }

   @ObfuscatedName("n")
   void method3569() {
      this.field2999.offset = -1;
   }

   @ObfuscatedName("i")
   void method3570(int var1) {
      int var2 = this.field2999.method2689();
      this.field3002[var1] += var2;
   }

   @ObfuscatedName("g")
   int method3571(int var1) {
      int var2 = this.method3572(var1);
      return var2;
   }

   @ObfuscatedName("m")
   int method3572(int var1) {
      byte var2 = this.field2999.payload[this.field2999.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field3003[var1] = var5;
         ++this.field2999.offset;
      } else {
         var5 = this.field3003[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3592(var1, var5);
      } else {
         int var3 = this.field2999.method2689();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2999.payload[this.field2999.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2999.offset;
               this.field3003[var1] = var4;
               return this.method3592(var1, var4);
            }
         }

         this.field2999.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("x")
   long method3574(int var1) {
      return this.field3004 + (long)var1 * (long)this.field3010;
   }

   @ObfuscatedName("u")
   int method3575() {
      int var1 = this.field3001.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field3001[var4] >= 0 && this.field3002[var4] < var3) {
            var2 = var4;
            var3 = this.field3002[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("j")
   boolean method3576() {
      int var1 = this.field3001.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field3001[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class185() {
   }

   @ObfuscatedName("r")
   int method3586() {
      return this.field3001.length;
   }

   @ObfuscatedName("q")
   void method3587(long var1) {
      this.field3004 = var1;
      int var3 = this.field3001.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3002[var4] = 0;
         this.field3003[var4] = 0;
         this.field2999.offset = this.field3000[var4];
         this.method3570(var4);
         this.field3001[var4] = this.field2999.offset;
      }

   }

   @ObfuscatedName("k")
   int method3592(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2999.method2528();
         var4 = this.field2999.method2689();
         if(var7 == 47) {
            this.field2999.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2999.method2532();
            var4 -= 3;
            int var6 = this.field3002[var1];
            this.field3004 += (long)var6 * (long)(this.field3010 - var5);
            this.field3010 = var5;
            this.field2999.offset += var4;
            return 2;
         } else {
            this.field2999.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field3007[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2999.method2528() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2999.method2528() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   void method3596() {
      this.field2999.payload = null;
      this.field3000 = null;
      this.field3001 = null;
      this.field3002 = null;
      this.field3003 = null;
   }
}
