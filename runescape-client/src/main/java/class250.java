import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public enum class250 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   field3366(1, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   field3365(2, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   field3367(0, 2);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 809277907
   )
   public final int field3368;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1500728477
   )
   final int field3369;

   class250(int var3, int var4) {
      this.field3368 = var3;
      this.field3369 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field3369;
   }
}
