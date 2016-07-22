import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class144 extends class136 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1665677299
   )
   int field2227 = 256;
   @ObfuscatedName("m")
   long[] field2228 = new long[10];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -8308696712247662829L
   )
   long field2229 = class193.method3805();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1902266877
   )
   int field2230 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1650136989
   )
   int field2232 = 1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 994810529
   )
   int field2234;

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2228[var1] = this.field2229;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1590628949"
   )
   int vmethod3166(int var1, int var2) {
      int var3 = this.field2227;
      int var4 = this.field2232;
      this.field2227 = 300;
      this.field2232 = 1;
      this.field2229 = class193.method3805();
      if(0L == this.field2228[this.field2234]) {
         this.field2227 = var3;
         this.field2232 = var4;
      } else if(this.field2229 > this.field2228[this.field2234]) {
         this.field2227 = (int)((long)(var1 * 2560) / (this.field2229 - this.field2228[this.field2234]));
      }

      if(this.field2227 < 25) {
         this.field2227 = 25;
      }

      if(this.field2227 > 256) {
         this.field2227 = 256;
         this.field2232 = (int)((long)var1 - (this.field2229 - this.field2228[this.field2234]) / 10L);
      }

      if(this.field2232 > var1) {
         this.field2232 = var1;
      }

      this.field2228[this.field2234] = this.field2229;
      this.field2234 = (this.field2234 + 1) % 10;
      int var5;
      if(this.field2232 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2228[var5]) {
               this.field2228[var5] += (long)this.field2232;
            }
         }
      }

      if(this.field2232 < var2) {
         this.field2232 = var2;
      }

      class141.method2993((long)this.field2232);

      for(var5 = 0; this.field2230 < 256; this.field2230 += this.field2227) {
         ++var5;
      }

      this.field2230 &= 255;
      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3165() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2228[var1] = 0L;
      }

   }
}
