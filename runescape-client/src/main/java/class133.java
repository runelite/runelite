import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public abstract class class133 {
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1286947241
   )
   static int field2086;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   abstract void vmethod3081();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "255"
   )
   abstract int vmethod3083(int var1, int var2);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2095446017"
   )
   public static int method2830(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
