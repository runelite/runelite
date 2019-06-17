import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
public enum class313 implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3834(2, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3825(7, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3826(8, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3830(0, 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3831(4, 4),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3829(1, 5),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3828(6, 6),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3824(5, 7),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   field3832(3, 8);

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -561869045
   )
   final int field3833;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1246567185
   )
   final int field3827;

   private class313(int var3, int var4) {
      this.field3833 = var3;
      this.field3827 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.field3827;
   }
}
