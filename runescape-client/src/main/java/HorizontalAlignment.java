import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3706(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3704(1, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   field3702(2, 2);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1467511525
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -91901173
   )
   final int field3700;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3700 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field3700;
   }
}
