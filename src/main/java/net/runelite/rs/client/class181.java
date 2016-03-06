import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fl")
public class class181 {
   @ObfuscatedName("i")
   int[] field2937;
   @ObfuscatedName("l")
   int field2938;
   @ObfuscatedName("a")
   int[] field2939;
   @ObfuscatedName("f")
   int[] field2941;
   @ObfuscatedName("m")
   int[] field2942;
   @ObfuscatedName("k")
   static final byte[] field2943 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("j")
   class118 field2944 = new class118((byte[])null);
   @ObfuscatedName("n")
   long field2945;
   @ObfuscatedName("o")
   int field2946;

   class181(byte[] var1) {
      this.method3493(var1);
   }

   @ObfuscatedName("u")
   boolean method3479() {
      int var1 = this.field2937.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2937[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("l")
   void method3480() {
      this.field2944.field1995 = null;
      this.field2939 = null;
      this.field2937 = null;
      this.field2941 = null;
      this.field2942 = null;
   }

   @ObfuscatedName("a")
   boolean method3481() {
      return this.field2944.field1995 != null;
   }

   @ObfuscatedName("i")
   int method3482() {
      return this.field2937.length;
   }

   @ObfuscatedName("f")
   void method3483(int var1) {
      this.field2944.field1998 = this.field2937[var1];
   }

   @ObfuscatedName("m")
   void method3484(int var1) {
      this.field2937[var1] = this.field2944.field1998;
   }

   @ObfuscatedName("o")
   void method3485() {
      this.field2944.field1998 = -1;
   }

   @ObfuscatedName("h")
   void method3486(int var1) {
      int var2 = this.field2944.method2468();
      this.field2941[var1] += var2;
   }

   @ObfuscatedName("k")
   int method3488(int var1) {
      byte var2 = this.field2944.field1995[this.field2944.field1998];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2942[var1] = var5;
         ++this.field2944.field1998;
      } else {
         var5 = this.field2942[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3489(var1, var5);
      } else {
         int var3 = this.field2944.method2468();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2944.field1995[this.field2944.field1998] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2944.field1998;
               this.field2942[var1] = var4;
               return this.method3489(var1, var4);
            }
         }

         this.field2944.field1998 += var3;
         return 0;
      }
   }

   @ObfuscatedName("r")
   int method3489(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2944.method2453();
         var4 = this.field2944.method2468();
         if(var7 == 47) {
            this.field2944.field1998 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2944.method2553();
            var4 -= 3;
            int var6 = this.field2941[var1];
            this.field2945 += (long)var6 * (long)(this.field2946 - var5);
            this.field2946 = var5;
            this.field2944.field1998 += var4;
            return 2;
         } else {
            this.field2944.field1998 += var4;
            return 3;
         }
      } else {
         byte var3 = field2943[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2944.method2453() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2944.method2453() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   long method3490(int var1) {
      return this.field2945 + (long)var1 * (long)this.field2946;
   }

   @ObfuscatedName("q")
   int method3491() {
      int var1 = this.field2937.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2937[var4] >= 0 && this.field2941[var4] < var3) {
            var2 = var4;
            var3 = this.field2941[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("g")
   void method3492(long var1) {
      this.field2945 = var1;
      int var3 = this.field2937.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2941[var4] = 0;
         this.field2942[var4] = 0;
         this.field2944.field1998 = this.field2939[var4];
         this.method3486(var4);
         this.field2937[var4] = this.field2944.field1998;
      }

   }

   @ObfuscatedName("j")
   void method3493(byte[] var1) {
      this.field2944.field1995 = var1;
      this.field2944.field1998 = 10;
      int var2 = this.field2944.method2455();
      this.field2938 = this.field2944.method2455();
      this.field2946 = 500000;
      this.field2939 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2944.field1998 += var5) {
         int var4 = this.field2944.method2458();
         var5 = this.field2944.method2458();
         if(var4 == 1297379947) {
            this.field2939[var3] = this.field2944.field1998;
            ++var3;
         }
      }

      this.field2945 = 0L;
      this.field2937 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2937[var3] = this.field2939[var3];
      }

      this.field2941 = new int[var2];
      this.field2942 = new int[var2];
   }

   @ObfuscatedName("n")
   int method3526(int var1) {
      int var2 = this.method3488(var1);
      return var2;
   }

   class181() {
   }
}
