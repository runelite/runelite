import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("socket")
   static Task socket;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18922"
   )
   public abstract void vmethod2996();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1469616290"
   )
   public abstract int vmethod2993(int var1, int var2);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1847950856"
   )
   public static void method2998() {
      Overlay.overlays.reset();
   }
}
