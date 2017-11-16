import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public enum class292 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3820(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3818(1, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3819(2, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3821(3, 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3822(4, 4);

   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -670856217
   )
   public final int field3823;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -272370033
   )
   final int field3824;

   class292(int var3, int var4) {
      this.field3823 = var3;
      this.field3824 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3824;
   }
}
