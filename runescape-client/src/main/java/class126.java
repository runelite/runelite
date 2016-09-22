import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public final class class126 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1663336469
   )
   int field2094;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1298623165
   )
   int field2095;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1362829745
   )
   int field2097;
   @ObfuscatedName("t")
   int[] field2098 = new int[256];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1109404695
   )
   int field2101;
   @ObfuscatedName("pw")
   public static class139 field2103;
   @ObfuscatedName("n")
   int[] field2104 = new int[256];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1191790272"
   )
   public static Object method2807(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2113) {
            try {
               class121 var2 = new class121();
               var2.vmethod2826(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2113 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1660098294"
   )
   final void method2808() {
      this.field2101 += ++this.field2094;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2104[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2095 ^= this.field2095 << 13;
            } else {
               this.field2095 ^= this.field2095 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2095 ^= this.field2095 << 2;
         } else {
            this.field2095 ^= this.field2095 >>> 16;
         }

         this.field2095 += this.field2104[128 + var1 & 255];
         int var3;
         this.field2104[var1] = var3 = this.field2101 + this.field2095 + this.field2104[(var2 & 1020) >> 2];
         this.field2098[var1] = this.field2101 = var2 + this.field2104[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-152779985"
   )
   final void method2809() {
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
         var2 += this.field2098[var1];
         var3 += this.field2098[var1 + 1];
         var4 += this.field2098[var1 + 2];
         var5 += this.field2098[var1 + 3];
         var6 += this.field2098[4 + var1];
         var7 += this.field2098[5 + var1];
         var8 += this.field2098[6 + var1];
         var9 += this.field2098[7 + var1];
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
         this.field2104[var1] = var2;
         this.field2104[var1 + 1] = var3;
         this.field2104[2 + var1] = var4;
         this.field2104[var1 + 3] = var5;
         this.field2104[var1 + 4] = var6;
         this.field2104[5 + var1] = var7;
         this.field2104[6 + var1] = var8;
         this.field2104[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2104[var1];
         var3 += this.field2104[var1 + 1];
         var4 += this.field2104[var1 + 2];
         var5 += this.field2104[3 + var1];
         var6 += this.field2104[4 + var1];
         var7 += this.field2104[var1 + 5];
         var8 += this.field2104[6 + var1];
         var9 += this.field2104[7 + var1];
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
         this.field2104[var1] = var2;
         this.field2104[var1 + 1] = var3;
         this.field2104[2 + var1] = var4;
         this.field2104[var1 + 3] = var5;
         this.field2104[var1 + 4] = var6;
         this.field2104[var1 + 5] = var7;
         this.field2104[var1 + 6] = var8;
         this.field2104[7 + var1] = var9;
      }

      this.method2808();
      this.field2097 = 256;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "451701325"
   )
   final int method2812() {
      if(--this.field2097 + 1 == 0) {
         this.method2808();
         this.field2097 = 255;
      }

      return this.field2098[this.field2097];
   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2098[var2] = var1[var2];
      }

      this.method2809();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)Z",
      garbageValue = "-98"
   )
   public static boolean method2817(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3309(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         ChatMessages.method238(var3);
         return true;
      }
   }
}
