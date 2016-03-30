import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public final class class123 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -134410521
   )
   int field2028;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 149866977
   )
   int field2030;
   @ObfuscatedName("e")
   int[] field2031 = new int[256];
   @ObfuscatedName("y")
   int[] field2032 = new int[256];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1491587201
   )
   int field2033;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1221222477
   )
   int field2034;
   @ObfuscatedName("pb")
   public static class136 field2036;

   @ObfuscatedName("w")
   final int method2781() {
      if(0 == --this.field2030 + 1) {
         this.method2782();
         this.field2030 = 255;
      }

      return this.field2031[this.field2030];
   }

   @ObfuscatedName("x")
   final void method2782() {
      this.field2028 += ++this.field2034;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2032[var1];
         if(0 == (var1 & 2)) {
            if((var1 & 1) == 0) {
               this.field2033 ^= this.field2033 << 13;
            } else {
               this.field2033 ^= this.field2033 >>> 6;
            }
         } else if(0 == (var1 & 1)) {
            this.field2033 ^= this.field2033 << 2;
         } else {
            this.field2033 ^= this.field2033 >>> 16;
         }

         this.field2033 += this.field2032[var1 + 128 & 255];
         int var3;
         this.field2032[var1] = var3 = this.field2028 + this.field2033 + this.field2032[(var2 & 1020) >> 2];
         this.field2031[var1] = this.field2028 = this.field2032[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2031[var2] = var1[var2];
      }

      this.method2785();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1625695203"
   )
   final void method2785() {
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
         var2 += this.field2031[var1];
         var3 += this.field2031[var1 + 1];
         var4 += this.field2031[2 + var1];
         var5 += this.field2031[3 + var1];
         var6 += this.field2031[4 + var1];
         var7 += this.field2031[5 + var1];
         var8 += this.field2031[6 + var1];
         var9 += this.field2031[7 + var1];
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
         this.field2032[var1] = var2;
         this.field2032[var1 + 1] = var3;
         this.field2032[var1 + 2] = var4;
         this.field2032[var1 + 3] = var5;
         this.field2032[var1 + 4] = var6;
         this.field2032[5 + var1] = var7;
         this.field2032[var1 + 6] = var8;
         this.field2032[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2032[var1];
         var3 += this.field2032[1 + var1];
         var4 += this.field2032[2 + var1];
         var5 += this.field2032[3 + var1];
         var6 += this.field2032[4 + var1];
         var7 += this.field2032[5 + var1];
         var8 += this.field2032[6 + var1];
         var9 += this.field2032[7 + var1];
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
         this.field2032[var1] = var2;
         this.field2032[1 + var1] = var3;
         this.field2032[2 + var1] = var4;
         this.field2032[var1 + 3] = var5;
         this.field2032[4 + var1] = var6;
         this.field2032[5 + var1] = var7;
         this.field2032[6 + var1] = var8;
         this.field2032[7 + var1] = var9;
      }

      this.method2782();
      this.field2030 = 256;
   }
}
