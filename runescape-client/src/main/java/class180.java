import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class180 extends Node {
   @ObfuscatedName("r")
   class184 field2681;
   @ObfuscatedName("y")
   byte[] field2682;
   @ObfuscatedName("o")
   class116 field2683;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1763079821
   )
   int field2685;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "-1663522813"
   )
   static final void method3268(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field563 == 0) {
         var1 = class65.region.method1733(var0.field575, var0.field564, var0.field565);
      }

      if(var0.field563 == 1) {
         var1 = class65.region.method1734(var0.field575, var0.field564, var0.field565);
      }

      if(var0.field563 == 2) {
         var1 = class65.region.method1840(var0.field575, var0.field564, var0.field565);
      }

      if(var0.field563 == 3) {
         var1 = class65.region.method1736(var0.field575, var0.field564, var0.field565);
      }

      if(var1 != 0) {
         int var5 = class65.region.method1737(var0.field575, var0.field564, var0.field565, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field562 = var2;
      var0.field572 = var3;
      var0.field567 = var4;
   }
}
