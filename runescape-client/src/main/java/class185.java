import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class185 {
   @ObfuscatedName("l")
   int field2979;
   @ObfuscatedName("b")
   int field2980;
   @ObfuscatedName("h")
   int[] field2982;
   @ObfuscatedName("r")
   int[] field2983;
   @ObfuscatedName("a")
   int[] field2984;
   @ObfuscatedName("o")
   long field2987;
   @ObfuscatedName("p")
   static final byte[] field2988 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("e")
   class122 field2990 = new class122((byte[])null);
   @ObfuscatedName("c")
   int[] field2991;

   @ObfuscatedName("c")
   boolean method3620() {
      return this.field2990.field2054 != null;
   }

   @ObfuscatedName("b")
   void method3622() {
      this.field2990.field2061 = -1;
   }

   @ObfuscatedName("l")
   void method3623() {
      this.field2990.field2054 = null;
      this.field2991 = null;
      this.field2982 = null;
      this.field2983 = null;
      this.field2984 = null;
   }

   @ObfuscatedName("r")
   void method3626(int var1) {
      this.field2990.field2061 = this.field2982[var1];
   }

   @ObfuscatedName("a")
   void method3627(int var1) {
      this.field2982[var1] = this.field2990.field2061;
   }

   class185(byte[] var1) {
      this.method3665(var1);
   }

   @ObfuscatedName("u")
   void method3628(int var1) {
      int var2 = this.field2990.method2625();
      this.field2983[var1] += var2;
   }

   @ObfuscatedName("o")
   int method3629(int var1) {
      int var2 = this.method3631(var1);
      return var2;
   }

   @ObfuscatedName("p")
   int method3631(int var1) {
      byte var2 = this.field2990.field2054[this.field2990.field2061];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2984[var1] = var5;
         ++this.field2990.field2061;
      } else {
         var5 = this.field2984[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3646(var1, var5);
      } else {
         int var3 = this.field2990.method2625();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2990.field2054[this.field2990.field2061] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2990.field2061;
               this.field2984[var1] = var4;
               return this.method3646(var1, var4);
            }
         }

         this.field2990.field2061 += var3;
         return 0;
      }
   }

   @ObfuscatedName("q")
   long method3632(int var1) {
      return this.field2987 + (long)var1 * (long)this.field2980;
   }

   @ObfuscatedName("g")
   int method3633() {
      int var1 = this.field2982.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2982[var4] >= 0 && this.field2983[var4] < var3) {
            var2 = var4;
            var3 = this.field2983[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("j")
   boolean method3634() {
      int var1 = this.field2982.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2982[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("w")
   void method3635(long var1) {
      this.field2987 = var1;
      int var3 = this.field2982.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2983[var4] = 0;
         this.field2984[var4] = 0;
         this.field2990.field2061 = this.field2991[var4];
         this.method3628(var4);
         this.field2982[var4] = this.field2990.field2061;
      }

   }

   @ObfuscatedName("h")
   int method3639() {
      return this.field2982.length;
   }

   @ObfuscatedName("i")
   int method3646(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2990.method2610();
         var4 = this.field2990.method2625();
         if(var7 == 47) {
            this.field2990.field2061 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2990.method2703();
            var4 -= 3;
            int var6 = this.field2983[var1];
            this.field2987 += (long)var6 * (long)(this.field2980 - var5);
            this.field2980 = var5;
            this.field2990.field2061 += var4;
            return 2;
         } else {
            this.field2990.field2061 += var4;
            return 3;
         }
      } else {
         byte var3 = field2988[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2990.method2610() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2990.method2610() << 16;
         }

         return var4;
      }
   }

   class185() {
   }

   @ObfuscatedName("e")
   void method3665(byte[] var1) {
      this.field2990.field2054 = var1;
      this.field2990.field2061 = 10;
      int var2 = this.field2990.method2612();
      this.field2979 = this.field2990.method2612();
      this.field2980 = 500000;
      this.field2991 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2990.field2061 += var5) {
         int var4 = this.field2990.method2614();
         var5 = this.field2990.method2614();
         if(var4 == 1297379947) {
            this.field2991[var3] = this.field2990.field2061;
            ++var3;
         }
      }

      this.field2987 = 0L;
      this.field2982 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2982[var3] = this.field2991[var3];
      }

      this.field2983 = new int[var2];
      this.field2984 = new int[var2];
   }
}
