import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class154 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "56"
   )
   public static int method3192(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass116;I)V",
      garbageValue = "210425875"
   )
   public static void method3193(class116 var0) {
      class225.field3230 = var0;
   }
}
