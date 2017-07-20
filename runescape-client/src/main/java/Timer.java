import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("v")
   static int[] field2225;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2139277964"
   )
   public abstract int vmethod2910(int var1, int var2);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2145399515"
   )
   public abstract void vmethod2909();
}
