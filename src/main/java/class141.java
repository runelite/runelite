import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class141 extends class133 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1888728769
   )
   int field2163 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2000724849
   )
   int field2164 = 256;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -235546313
   )
   int field2165 = 1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4172071357151586941L
   )
   long field2166 = class127.method2941();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 921375795
   )
   int field2167;
   @ObfuscatedName("a")
   long[] field2168 = new long[10];

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2168[var1] = this.field2166;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1224087509"
   )
   int vmethod3217(int var1, int var2) {
      int var3 = this.field2164;
      int var4 = this.field2165;
      this.field2164 = 300;
      this.field2165 = 1;
      this.field2166 = class127.method2941();
      if(this.field2168[this.field2167] == 0L) {
         this.field2164 = var3;
         this.field2165 = var4;
      } else if(this.field2166 > this.field2168[this.field2167]) {
         this.field2164 = (int)((long)(var1 * 2560) / (this.field2166 - this.field2168[this.field2167]));
      }

      if(this.field2164 < 25) {
         this.field2164 = 25;
      }

      if(this.field2164 > 256) {
         this.field2164 = 256;
         this.field2165 = (int)((long)var1 - (this.field2166 - this.field2168[this.field2167]) / 10L);
      }

      if(this.field2165 > var1) {
         this.field2165 = var1;
      }

      this.field2168[this.field2167] = this.field2166;
      this.field2167 = (1 + this.field2167) % 10;
      int var5;
      if(this.field2165 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2168[var5]) {
               this.field2168[var5] += (long)this.field2165;
            }
         }
      }

      if(this.field2165 < var2) {
         this.field2165 = var2;
      }

      class4.method55((long)this.field2165);

      for(var5 = 0; this.field2163 < 256; this.field2163 += this.field2164) {
         ++var5;
      }

      this.field2163 &= 255;
      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   public void vmethod3216() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2168[var1] = 0L;
      }

   }
}
