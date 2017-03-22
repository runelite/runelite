import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1599076157
   )
   int field2116;
   @ObfuscatedName("u")
   @Export("mm")
   int[] mm = new int[256];
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
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("h")
   @Export("randResult")
   int[] randResult = new int[256];

   ISAACCipher(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3102();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1428614722"
   )
   @Export("nextInt")
   final int nextInt() {
      if(--this.valuesRemaining + 1 == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "33053233"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2116 += ++this.field2123;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
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

         this.field2121 += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.field2116 + this.field2121 + this.mm[(var2 & 1020) >> 2];
         this.randResult[var1] = this.field2116 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
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
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[3 + var1];
         var6 += this.randResult[var1 + 4];
         var7 += this.randResult[5 + var1];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
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
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[4 + var1] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[6 + var1] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[1 + var1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[3 + var1];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[6 + var1];
         var9 += this.mm[var1 + 7];
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
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[2 + var1] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[4 + var1] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[7 + var1] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
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
