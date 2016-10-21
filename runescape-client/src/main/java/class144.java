import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class144 extends class136 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 573155557
   )
   int field2210 = 256;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -595030631
   )
   int field2212 = 1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -2728706618833020229L
   )
   long field2213 = class11.method139();
   @ObfuscatedName("f")
   long[] field2214 = new long[10];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2135118157
   )
   int field2215;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1503128015
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1665482631
   )
   int field2221 = 0;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1894113900"
   )
   int vmethod3142(int var1, int var2) {
      int var3 = this.field2210;
      int var4 = this.field2212;
      this.field2210 = 300;
      this.field2212 = 1;
      this.field2213 = class11.method139();
      if(this.field2214[this.field2215] == 0L) {
         this.field2210 = var3;
         this.field2212 = var4;
      } else if(this.field2213 > this.field2214[this.field2215]) {
         this.field2210 = (int)((long)(var1 * 2560) / (this.field2213 - this.field2214[this.field2215]));
      }

      if(this.field2210 < 25) {
         this.field2210 = 25;
      }

      if(this.field2210 > 256) {
         this.field2210 = 256;
         this.field2212 = (int)((long)var1 - (this.field2213 - this.field2214[this.field2215]) / 10L);
      }

      if(this.field2212 > var1) {
         this.field2212 = var1;
      }

      this.field2214[this.field2215] = this.field2213;
      this.field2215 = (this.field2215 + 1) % 10;
      int var5;
      if(this.field2212 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2214[var5]) {
               this.field2214[var5] += (long)this.field2212;
            }
         }
      }

      if(this.field2212 < var2) {
         this.field2212 = var2;
      }

      class110.method2407((long)this.field2212);

      for(var5 = 0; this.field2221 < 256; this.field2221 += this.field2210) {
         ++var5;
      }

      this.field2221 &= 255;
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   public void vmethod3141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2214[var1] = 0L;
      }

   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2214[var1] = this.field2213;
      }

   }
}
