import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class180 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 351915711
   )
   int field2699;
   @ObfuscatedName("d")
   byte[] field2700;
   @ObfuscatedName("m")
   class116 field2701;
   @ObfuscatedName("h")
   class184 field2702;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass166;B)I",
      garbageValue = "126"
   )
   static int method3324(class166 var0) {
      int var1 = var0.method3237(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3237(5);
      } else if(var1 == 2) {
         var2 = var0.method3237(8);
      } else {
         var2 = var0.method3237(11);
      }

      return var2;
   }
}
