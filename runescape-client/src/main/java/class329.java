import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public enum class329 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   field3976(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   field3971(1, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   field3972(2, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   field3973(3, 3),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llg;"
   )
   field3974(4, 4);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1446162609
   )
   public final int field3975;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1563006441
   )
   final int field3970;

   class329(int var3, int var4) {
      this.field3975 = var3;
      this.field3970 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field3970;
   }
}
