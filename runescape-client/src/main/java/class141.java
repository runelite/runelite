import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class141 extends class133 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 403540169
   )
   int field2146 = 256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1258608599
   )
   int field2147 = 1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1090611813
   )
   int field2149 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 738920082387637581L
   )
   long field2150 = class90.method2090();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1045168227
   )
   int field2151;
   @ObfuscatedName("do")
   @Export("mapRegions")
   static int[] field2153;
   @ObfuscatedName("b")
   long[] field2155 = new long[10];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void vmethod3124() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = 0L;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "85"
   )
   int vmethod3123(int var1, int var2) {
      int var3 = this.field2146;
      int var4 = this.field2147;
      this.field2146 = 300;
      this.field2147 = 1;
      this.field2150 = class90.method2090();
      if(0L == this.field2155[this.field2151]) {
         this.field2146 = var3;
         this.field2147 = var4;
      } else if(this.field2150 > this.field2155[this.field2151]) {
         this.field2146 = (int)((long)(2560 * var1) / (this.field2150 - this.field2155[this.field2151]));
      }

      if(this.field2146 < 25) {
         this.field2146 = 25;
      }

      if(this.field2146 > 256) {
         this.field2146 = 256;
         this.field2147 = (int)((long)var1 - (this.field2150 - this.field2155[this.field2151]) / 10L);
      }

      if(this.field2147 > var1) {
         this.field2147 = var1;
      }

      this.field2155[this.field2151] = this.field2150;
      this.field2151 = (1 + this.field2151) % 10;
      int var5;
      if(this.field2147 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2155[var5]) {
               this.field2155[var5] += (long)this.field2147;
            }
         }
      }

      if(this.field2147 < var2) {
         this.field2147 = var2;
      }

      class116.method2459((long)this.field2147);

      for(var5 = 0; this.field2149 < 256; this.field2149 += this.field2146) {
         ++var5;
      }

      this.field2149 &= 255;
      return var5;
   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2155[var1] = this.field2150;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2089048130"
   )
   public static void method3009() {
      class211.field3127 = new class202();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass168;",
      garbageValue = "466008793"
   )
   static class168 method3010(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(class149.field2220 != null) {
         var4 = new class134(var0, class149.field2220, class24.field621[var0], 1000000);
      }

      return new class168(var4, class98.field1644, var0, var1, var2, var3);
   }
}
