import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public final class class123 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1155960033
   )
   int field2026;
   @ObfuscatedName("d")
   int[] field2027 = new int[256];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 513995173
   )
   int field2028;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 891015341
   )
   int field2029;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 41462679
   )
   int field2031;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -2062186121
   )
   protected static int field2032;
   @ObfuscatedName("n")
   int[] field2037 = new int[256];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1941043192"
   )
   final int method2796() {
      if(--this.field2026 + 1 == 0) {
         this.method2803();
         this.field2026 = 255;
      }

      return this.field2027[this.field2026];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BLclass134;B)V",
      garbageValue = "70"
   )
   static void method2798(int var0, byte[] var1, class134 var2) {
      class169 var3 = new class169();
      var3.field2697 = 0;
      var3.field3115 = (long)var0;
      var3.field2696 = var1;
      var3.field2698 = var2;
      class199 var4 = class170.field2707;
      synchronized(class170.field2707) {
         class170.field2707.method3877(var3);
      }

      Object var9 = class170.field2705;
      synchronized(class170.field2705) {
         if(class170.field2702 == 0) {
            class7.field136.method2903(new class170(), 5);
         }

         class170.field2702 = 600;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1388160341"
   )
   final void method2799() {
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
         var2 += this.field2027[var1];
         var3 += this.field2027[var1 + 1];
         var4 += this.field2027[2 + var1];
         var5 += this.field2027[var1 + 3];
         var6 += this.field2027[var1 + 4];
         var7 += this.field2027[var1 + 5];
         var8 += this.field2027[var1 + 6];
         var9 += this.field2027[7 + var1];
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
         this.field2037[var1] = var2;
         this.field2037[var1 + 1] = var3;
         this.field2037[2 + var1] = var4;
         this.field2037[3 + var1] = var5;
         this.field2037[var1 + 4] = var6;
         this.field2037[5 + var1] = var7;
         this.field2037[6 + var1] = var8;
         this.field2037[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2037[var1];
         var3 += this.field2037[1 + var1];
         var4 += this.field2037[2 + var1];
         var5 += this.field2037[3 + var1];
         var6 += this.field2037[var1 + 4];
         var7 += this.field2037[var1 + 5];
         var8 += this.field2037[var1 + 6];
         var9 += this.field2037[var1 + 7];
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
         this.field2037[var1] = var2;
         this.field2037[var1 + 1] = var3;
         this.field2037[2 + var1] = var4;
         this.field2037[3 + var1] = var5;
         this.field2037[4 + var1] = var6;
         this.field2037[var1 + 5] = var7;
         this.field2037[6 + var1] = var8;
         this.field2037[var1 + 7] = var9;
      }

      this.method2803();
      this.field2026 = 256;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "294251093"
   )
   final void method2803() {
      this.field2028 += ++this.field2031;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2037[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2029 ^= this.field2029 << 13;
            } else {
               this.field2029 ^= this.field2029 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2029 ^= this.field2029 << 2;
         } else {
            this.field2029 ^= this.field2029 >>> 16;
         }

         this.field2029 += this.field2037[128 + var1 & 255];
         int var3;
         this.field2037[var1] = var3 = this.field2037[(var2 & 1020) >> 2] + this.field2029 + this.field2028;
         this.field2027[var1] = this.field2028 = this.field2037[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2027[var2] = var1[var2];
      }

      this.method2799();
   }
}
