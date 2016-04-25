import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class141 extends class133 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1134353215
   )
   int field2143;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 995934297563021823L
   )
   long field2145 = class77.method1674();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1164464581
   )
   int field2146 = 0;
   @ObfuscatedName("j")
   long[] field2147 = new long[10];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1259058023
   )
   int field2148 = 256;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1256847587
   )
   int field2151 = 1;

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   static final void method2950() {
      for(class16 var0 = (class16)client.field407.method3784(); var0 != null; var0 = (class16)client.field407.method3777()) {
         if(-1 == var0.field233) {
            var0.field232 = 0;
            class3.method33(var0);
         } else {
            var0.method3883();
         }
      }

   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2147[var1] = this.field2145;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3090() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2147[var1] = 0L;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[Lclass130;",
      garbageValue = "127"
   )
   public static class130[] method2958() {
      return new class130[]{class130.field2037, class130.field2036, class130.field2040};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass173;",
      garbageValue = "1644050361"
   )
   public static class173 method2959(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class173.field2735[var1] == null || class173.field2735[var1][var2] == null) {
         boolean var3 = class107.method2374(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2735[var1][var2];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-708326601"
   )
   int vmethod3089(int var1, int var2) {
      int var3 = this.field2148;
      int var4 = this.field2151;
      this.field2148 = 300;
      this.field2151 = 1;
      this.field2145 = class77.method1674();
      if(0L == this.field2147[this.field2143]) {
         this.field2148 = var3;
         this.field2151 = var4;
      } else if(this.field2145 > this.field2147[this.field2143]) {
         this.field2148 = (int)((long)(var1 * 2560) / (this.field2145 - this.field2147[this.field2143]));
      }

      if(this.field2148 < 25) {
         this.field2148 = 25;
      }

      if(this.field2148 > 256) {
         this.field2148 = 256;
         this.field2151 = (int)((long)var1 - (this.field2145 - this.field2147[this.field2143]) / 10L);
      }

      if(this.field2151 > var1) {
         this.field2151 = var1;
      }

      this.field2147[this.field2143] = this.field2145;
      this.field2143 = (1 + this.field2143) % 10;
      int var5;
      if(this.field2151 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2147[var5]) {
               this.field2147[var5] += (long)this.field2151;
            }
         }
      }

      if(this.field2151 < var2) {
         this.field2151 = var2;
      }

      class14.method170((long)this.field2151);

      for(var5 = 0; this.field2146 < 256; this.field2146 += this.field2148) {
         ++var5;
      }

      this.field2146 &= 255;
      return var5;
   }
}
