import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -55243195
   )
   static int field2270;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "437016417"
   )
   public abstract int vmethod3004(int var1, int var2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   public abstract void vmethod3010();
}
