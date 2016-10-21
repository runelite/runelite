import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public class class185 {
   @ObfuscatedName("c")
   long field2979;
   @ObfuscatedName("n")
   int[] field2980;
   @ObfuscatedName("t")
   int[] field2981;
   @ObfuscatedName("v")
   int[] field2982;
   @ObfuscatedName("f")
   Buffer field2983 = new Buffer((byte[])null);
   @ObfuscatedName("e")
   int field2984;
   @ObfuscatedName("b")
   int[] field2987;
   @ObfuscatedName("w")
   static final byte[] field2988 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("m")
   int field2991;

   class185(byte[] var1) {
      this.method3590(var1);
   }

   @ObfuscatedName("f")
   void method3590(byte[] var1) {
      this.field2983.payload = var1;
      this.field2983.offset = 10;
      int var2 = this.field2983.method2535();
      this.field2984 = this.field2983.method2535();
      this.field2991 = 500000;
      this.field2980 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2983.offset += var5) {
         int var4 = this.field2983.method2538();
         var5 = this.field2983.method2538();
         if(var4 == 1297379947) {
            this.field2980[var3] = this.field2983.offset;
            ++var3;
         }
      }

      this.field2979 = 0L;
      this.field2981 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2981[var3] = this.field2980[var3];
      }

      this.field2982 = new int[var2];
      this.field2987 = new int[var2];
   }

   @ObfuscatedName("e")
   void method3591() {
      this.field2983.payload = null;
      this.field2980 = null;
      this.field2981 = null;
      this.field2982 = null;
      this.field2987 = null;
   }

   @ObfuscatedName("n")
   boolean method3592() {
      return this.field2983.payload != null;
   }

   @ObfuscatedName("v")
   void method3593(int var1) {
      this.field2983.offset = this.field2981[var1];
   }

   @ObfuscatedName("b")
   void method3594(int var1) {
      this.field2981[var1] = this.field2983.offset;
   }

   @ObfuscatedName("k")
   void method3596(int var1) {
      int var2 = this.field2983.method2696();
      this.field2982[var1] += var2;
   }

   @ObfuscatedName("t")
   int method3597() {
      return this.field2981.length;
   }

   @ObfuscatedName("l")
   int method3599(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2983.method2656();
         var4 = this.field2983.method2696();
         if(var7 == 47) {
            this.field2983.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2983.method2537();
            var4 -= 3;
            int var6 = this.field2982[var1];
            this.field2979 += (long)var6 * (long)(this.field2991 - var5);
            this.field2991 = var5;
            this.field2983.offset += var4;
            return 2;
         } else {
            this.field2983.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2988[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2983.method2656() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2983.method2656() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   long method3600(int var1) {
      return this.field2979 + (long)var1 * (long)this.field2991;
   }

   @ObfuscatedName("m")
   void method3601() {
      this.field2983.offset = -1;
   }

   @ObfuscatedName("x")
   void method3603(long var1) {
      this.field2979 = var1;
      int var3 = this.field2981.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2982[var4] = 0;
         this.field2987[var4] = 0;
         this.field2983.offset = this.field2980[var4];
         this.method3596(var4);
         this.field2981[var4] = this.field2983.offset;
      }

   }

   @ObfuscatedName("u")
   boolean method3605() {
      int var1 = this.field2981.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2981[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("w")
   int method3608(int var1) {
      byte var2 = this.field2983.payload[this.field2983.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2987[var1] = var5;
         ++this.field2983.offset;
      } else {
         var5 = this.field2987[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3599(var1, var5);
      } else {
         int var3 = this.field2983.method2696();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2983.payload[this.field2983.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2983.offset;
               this.field2987[var1] = var4;
               return this.method3599(var1, var4);
            }
         }

         this.field2983.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   int method3612(int var1) {
      int var2 = this.method3608(var1);
      return var2;
   }

   @ObfuscatedName("i")
   int method3627() {
      int var1 = this.field2981.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2981[var4] >= 0 && this.field2982[var4] < var3) {
            var2 = var4;
            var3 = this.field2982[var4];
         }
      }

      return var2;
   }

   class185() {
   }
}
