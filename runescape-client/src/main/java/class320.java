import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ln")
public enum class320 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   field3886(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   field3887(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   field3891(2, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   field3888(3, 3),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   field3889(4, 4);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1410204041
   )
   public final int field3890;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1461071995
   )
   final int field3885;

   class320(int var3, int var4) {
      this.field3890 = var3;
      this.field3885 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field3885;
   }
}
