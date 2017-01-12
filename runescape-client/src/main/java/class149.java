import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class149 {
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -2112451261
   )
   static int field2024;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "2138352013"
   )
   public static boolean method2743(class182 var0, int var1) {
      byte[] var2 = var0.method3267(var1);
      if(var2 == null) {
         return false;
      } else {
         class164.method3116(var2);
         return true;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "65"
   )
   public static void method2744(class182 var0) {
      Overlay.field3029 = var0;
   }
}
