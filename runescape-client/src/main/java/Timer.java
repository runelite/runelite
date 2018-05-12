import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("v")
   @Export("tt")
   static int[] tt;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1218447375"
   )
   public abstract void vmethod3346();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2000882213"
   )
   public abstract int vmethod3348(int var1, int var2);
}
