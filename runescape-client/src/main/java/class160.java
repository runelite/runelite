import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public final class class160 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1599076157
   )
   int field2116;
   @ObfuscatedName("u")
   int[] field2120 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 117178623
   )
   int field2121;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1181532233
   )
   int field2123;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1381468155
   )
   int field2125;
   @ObfuscatedName("h")
   int[] field2127 = new int[256];

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2127[var2] = var1[var2];
      }

      this.method3102();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1428614722"
   )
   final int method3099() {
      if(--this.field2125 + 1 == 0) {
         this.method3100();
         this.field2125 = 255;
      }

      return this.field2127[this.field2125];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "33053233"
   )
   final void method3100() {
      this.field2116 += ++this.field2123;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2120[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2121 ^= this.field2121 << 13;
            } else {
               this.field2121 ^= this.field2121 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2121 ^= this.field2121 << 2;
         } else {
            this.field2121 ^= this.field2121 >>> 16;
         }

         this.field2121 += this.field2120[128 + var1 & 255];
         int var3;
         this.field2120[var1] = var3 = this.field2116 + this.field2121 + this.field2120[(var2 & 1020) >> 2];
         this.field2127[var1] = this.field2116 = this.field2120[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1094994038"
   )
   static boolean method3101(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1641671891"
   )
   final void method3102() {
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
         var2 += this.field2127[var1];
         var3 += this.field2127[var1 + 1];
         var4 += this.field2127[var1 + 2];
         var5 += this.field2127[3 + var1];
         var6 += this.field2127[var1 + 4];
         var7 += this.field2127[5 + var1];
         var8 += this.field2127[var1 + 6];
         var9 += this.field2127[var1 + 7];
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
         this.field2120[var1] = var2;
         this.field2120[var1 + 1] = var3;
         this.field2120[var1 + 2] = var4;
         this.field2120[var1 + 3] = var5;
         this.field2120[4 + var1] = var6;
         this.field2120[var1 + 5] = var7;
         this.field2120[6 + var1] = var8;
         this.field2120[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2120[var1];
         var3 += this.field2120[1 + var1];
         var4 += this.field2120[var1 + 2];
         var5 += this.field2120[3 + var1];
         var6 += this.field2120[var1 + 4];
         var7 += this.field2120[var1 + 5];
         var8 += this.field2120[6 + var1];
         var9 += this.field2120[var1 + 7];
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
         this.field2120[var1] = var2;
         this.field2120[var1 + 1] = var3;
         this.field2120[2 + var1] = var4;
         this.field2120[var1 + 3] = var5;
         this.field2120[4 + var1] = var6;
         this.field2120[var1 + 5] = var7;
         this.field2120[var1 + 6] = var8;
         this.field2120[7 + var1] = var9;
      }

      this.method3100();
      this.field2125 = 256;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2025457465"
   )
   static final void method3110(Actor var0, int var1) {
      class20.method223(var0.x, var0.y, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2136281043"
   )
   public static String method3111(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
