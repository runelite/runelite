import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
public final class class122 {
   @ObfuscatedName("n")
   int field2019;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -895721933
   )
   int field2020;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1288963103
   )
   int field2021;
   @ObfuscatedName("m")
   int[] field2022 = new int[256];
   @ObfuscatedName("o")
   int[] field2023 = new int[256];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1358710615
   )
   int field2025;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = -6916080085384449655L
   )
   static long field2028;

   @ObfuscatedName("l")
   final void method2710() {
      this.field2025 += (this.field2019 += -463473387) * -330124739;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2023[var1];
         if(0 == (var1 & 2)) {
            if(0 == (var1 & 1)) {
               this.field2020 ^= this.field2020 << 13;
            } else {
               this.field2020 ^= this.field2020 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2020 ^= this.field2020 << 2;
         } else {
            this.field2020 ^= this.field2020 >>> 16;
         }

         this.field2020 += this.field2023[128 + var1 & 255];
         int var3;
         this.field2023[var1] = var3 = this.field2023[(var2 & 1020) >> 2] + this.field2020 + this.field2025;
         this.field2022[var1] = this.field2025 = this.field2023[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   class122(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2022[var2] = var1[var2];
      }

      this.method2718();
   }

   @ObfuscatedName("j")
   final int method2717() {
      if(0 == --this.field2021 + 1) {
         this.method2710();
         this.field2021 = 255;
      }

      return this.field2022[this.field2021];
   }

   @ObfuscatedName("a")
   final void method2718() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2022[var1];
         var3 += this.field2022[1 + var1];
         var4 += this.field2022[var1 + 2];
         var5 += this.field2022[3 + var1];
         var6 += this.field2022[4 + var1];
         var7 += this.field2022[5 + var1];
         var8 += this.field2022[var1 + 6];
         var9 += this.field2022[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2023[var1] = var2;
         this.field2023[var1 + 1] = var3;
         this.field2023[2 + var1] = var4;
         this.field2023[3 + var1] = var5;
         this.field2023[4 + var1] = var6;
         this.field2023[5 + var1] = var7;
         this.field2023[var1 + 6] = var8;
         this.field2023[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2023[var1];
         var3 += this.field2023[var1 + 1];
         var4 += this.field2023[var1 + 2];
         var5 += this.field2023[3 + var1];
         var6 += this.field2023[var1 + 4];
         var7 += this.field2023[5 + var1];
         var8 += this.field2023[var1 + 6];
         var9 += this.field2023[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2023[var1] = var2;
         this.field2023[1 + var1] = var3;
         this.field2023[var1 + 2] = var4;
         this.field2023[3 + var1] = var5;
         this.field2023[var1 + 4] = var6;
         this.field2023[var1 + 5] = var7;
         this.field2023[var1 + 6] = var8;
         this.field2023[var1 + 7] = var9;
      }

      this.method2710();
      this.field2021 = 256;
   }

   @ObfuscatedName("l")
   static void method2721(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2721(var0, var1, var2, var5 - 1);
         method2721(var0, var1, var5 + 1, var3);
      }

   }
}
