import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1752267901"
   )
   public abstract void vmethod3302();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "112"
   )
   public abstract int vmethod3312(int var1, int var2);
}
