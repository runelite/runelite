import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class141 extends class133 {
   @ObfuscatedName("t")
   static class173 field2173;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 462955155
   )
   int field2174 = 256;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8636289768180188325L
   )
   long field2175 = class12.method162();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -681310427
   )
   int field2176 = 1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -846269663
   )
   int field2177 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2099743553
   )
   int field2178;
   @ObfuscatedName("s")
   long[] field2179 = new long[10];

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-650846426"
   )
   int vmethod3106(int var1, int var2) {
      int var3 = this.field2174;
      int var4 = this.field2176;
      this.field2174 = 300;
      this.field2176 = 1;
      this.field2175 = class12.method162();
      if(this.field2179[this.field2178] == 0L) {
         this.field2174 = var3;
         this.field2176 = var4;
      } else if(this.field2175 > this.field2179[this.field2178]) {
         this.field2174 = (int)((long)(2560 * var1) / (this.field2175 - this.field2179[this.field2178]));
      }

      if(this.field2174 < 25) {
         this.field2174 = 25;
      }

      if(this.field2174 > 256) {
         this.field2174 = 256;
         this.field2176 = (int)((long)var1 - (this.field2175 - this.field2179[this.field2178]) / 10L);
      }

      if(this.field2176 > var1) {
         this.field2176 = var1;
      }

      this.field2179[this.field2178] = this.field2175;
      this.field2178 = (this.field2178 + 1) % 10;
      int var5;
      if(this.field2176 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2179[var5]) {
               this.field2179[var5] += (long)this.field2176;
            }
         }
      }

      if(this.field2176 < var2) {
         this.field2176 = var2;
      }

      class116.method2448((long)this.field2176);

      for(var5 = 0; this.field2177 < 256; this.field2177 += this.field2174) {
         ++var5;
      }

      this.field2177 &= 255;
      return var5;
   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2179[var1] = this.field2175;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void vmethod3104() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2179[var1] = 0L;
      }

   }
}
