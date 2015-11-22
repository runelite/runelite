package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class181 {
   @ObfuscatedName("h")
   int field2922;
   @ObfuscatedName("l")
   int[] field2923;
   @ObfuscatedName("j")
   class118 field2924 = new class118((byte[])null);
   @ObfuscatedName("f")
   int[] field2925;
   @ObfuscatedName("m")
   int field2926;
   @ObfuscatedName("a")
   int[] field2927;
   @ObfuscatedName("u")
   int[] field2928;
   @ObfuscatedName("t")
   long field2930;
   @ObfuscatedName("k")
   static final byte[] field2931 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};

   class181(byte[] var1) {
      this.method3589(var1);
   }

   @ObfuscatedName("j")
   void method3589(byte[] var1) {
      this.field2924.field1980 = var1;
      this.field2924.field1981 = 10;
      int var2 = this.field2924.method2538();
      this.field2926 = this.field2924.method2538();
      this.field2922 = 500000;
      this.field2925 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2924.field1981 += var5) {
         int var4 = this.field2924.method2541();
         var5 = this.field2924.method2541();
         if(var4 == 1297379947) {
            this.field2925[var3] = this.field2924.field1981;
            ++var3;
         }
      }

      this.field2930 = 0L;
      this.field2923 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2923[var3] = this.field2925[var3];
      }

      this.field2928 = new int[var2];
      this.field2927 = new int[var2];
   }

   @ObfuscatedName("m")
   void method3590() {
      this.field2924.field1980 = null;
      this.field2925 = null;
      this.field2923 = null;
      this.field2928 = null;
      this.field2927 = null;
   }

   @ObfuscatedName("u")
   void method3593(int var1) {
      this.field2924.field1981 = this.field2923[var1];
   }

   @ObfuscatedName("a")
   void method3594(int var1) {
      this.field2923[var1] = this.field2924.field1981;
   }

   @ObfuscatedName("h")
   void method3595() {
      this.field2924.field1981 = -1;
   }

   @ObfuscatedName("i")
   void method3596(int var1) {
      int var2 = this.field2924.method2656();
      this.field2928[var1] += var2;
   }

   @ObfuscatedName("k")
   int method3598(int var1) {
      byte var2 = this.field2924.field1980[this.field2924.field1981];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2927[var1] = var5;
         ++this.field2924.field1981;
      } else {
         var5 = this.field2927[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3638(var1, var5);
      } else {
         int var3 = this.field2924.method2656();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2924.field1980[this.field2924.field1981] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2924.field1981;
               this.field2927[var1] = var4;
               return this.method3638(var1, var4);
            }
         }

         this.field2924.field1981 += var3;
         return 0;
      }
   }

   @ObfuscatedName("e")
   int method3599() {
      int var1 = this.field2923.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2923[var4] >= 0 && this.field2928[var4] < var3) {
            var2 = var4;
            var3 = this.field2928[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("w")
   long method3600(int var1) {
      return this.field2930 + (long)var1 * (long)this.field2922;
   }

   @ObfuscatedName("f")
   boolean method3601() {
      return this.field2924.field1980 != null;
   }

   @ObfuscatedName("p")
   void method3603(long var1) {
      this.field2930 = var1;
      int var3 = this.field2923.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2928[var4] = 0;
         this.field2927[var4] = 0;
         this.field2924.field1981 = this.field2925[var4];
         this.method3596(var4);
         this.field2923[var4] = this.field2924.field1981;
      }

   }

   class181() {
   }

   @ObfuscatedName("t")
   int method3619(int var1) {
      int var2 = this.method3598(var1);
      return var2;
   }

   @ObfuscatedName("l")
   int method3620() {
      return this.field2923.length;
   }

   @ObfuscatedName("z")
   boolean method3633() {
      int var1 = this.field2923.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2923[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("s")
   int method3638(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2924.method2536();
         var4 = this.field2924.method2656();
         if(var7 == 47) {
            this.field2924.field1981 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2924.method2540();
            var4 -= 3;
            int var6 = this.field2928[var1];
            this.field2930 += (long)var6 * (long)(this.field2922 - var5);
            this.field2922 = var5;
            this.field2924.field1981 += var4;
            return 2;
         } else {
            this.field2924.field1981 += var4;
            return 3;
         }
      } else {
         byte var3 = field2931[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2924.method2536() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2924.method2536() << 16;
         }

         return var4;
      }
   }
}
