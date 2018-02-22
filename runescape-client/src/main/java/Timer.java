import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static BuildType field2194;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16776960"
   )
   public abstract void vmethod3305();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-13"
   )
   public abstract int vmethod3306(int var1, int var2);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "741779778"
   )
   public static void method3308() {
      class274.field3498.reset();
      class274.field3499.reset();
      class274.field3500.reset();
   }
}
