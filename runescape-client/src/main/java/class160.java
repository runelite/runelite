import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public final class class160 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2117231115
   )
   int field2114;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1925052805
   )
   int field2116;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1683169877
   )
   int field2117;
   @ObfuscatedName("pr")
   static Clipboard field2118;
   @ObfuscatedName("l")
   int[] field2119 = new int[256];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1241589171
   )
   int field2120;
   @ObfuscatedName("d")
   int[] field2122 = new int[256];

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2122[var2] = var1[var2];
      }

      this.method3054();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-114389779"
   )
   final void method3053() {
      this.field2116 += ++this.field2114;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2119[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2120 ^= this.field2120 << 13;
            } else {
               this.field2120 ^= this.field2120 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2120 ^= this.field2120 << 2;
         } else {
            this.field2120 ^= this.field2120 >>> 16;
         }

         this.field2120 += this.field2119[var1 + 128 & 255];
         int var3;
         this.field2119[var1] = var3 = this.field2120 + this.field2119[(var2 & 1020) >> 2] + this.field2116;
         this.field2122[var1] = this.field2116 = this.field2119[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   final void method3054() {
      int var1 = -1640531527;
      int var2 = -1640531527;
      int var3 = -1640531527;
      int var4 = -1640531527;
      int var5 = -1640531527;
      int var6 = -1640531527;
      int var7 = -1640531527;
      int var8 = -1640531527;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.field2122[var9];
         var7 += this.field2122[var9 + 1];
         var6 += this.field2122[var9 + 2];
         var5 += this.field2122[3 + var9];
         var4 += this.field2122[4 + var9];
         var3 += this.field2122[5 + var9];
         var2 += this.field2122[var9 + 6];
         var1 += this.field2122[var9 + 7];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.field2119[var9] = var8;
         this.field2119[1 + var9] = var7;
         this.field2119[var9 + 2] = var6;
         this.field2119[3 + var9] = var5;
         this.field2119[4 + var9] = var4;
         this.field2119[var9 + 5] = var3;
         this.field2119[var9 + 6] = var2;
         this.field2119[7 + var9] = var1;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.field2119[var9];
         var7 += this.field2119[1 + var9];
         var6 += this.field2119[2 + var9];
         var5 += this.field2119[3 + var9];
         var4 += this.field2119[4 + var9];
         var3 += this.field2119[5 + var9];
         var2 += this.field2119[var9 + 6];
         var1 += this.field2119[7 + var9];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.field2119[var9] = var8;
         this.field2119[var9 + 1] = var7;
         this.field2119[var9 + 2] = var6;
         this.field2119[var9 + 3] = var5;
         this.field2119[var9 + 4] = var4;
         this.field2119[5 + var9] = var3;
         this.field2119[var9 + 6] = var2;
         this.field2119[var9 + 7] = var1;
      }

      this.method3053();
      this.field2117 = 256;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-56"
   )
   final int method3063() {
      if(--this.field2117 + 1 == 0) {
         this.method3053();
         this.field2117 = 255;
      }

      return this.field2122[this.field2117];
   }
}
