import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public enum class316 implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   field3781(0, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   field3777(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   field3778(2, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   field3779(3, 3),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   field3780(4, 4);

   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 109639589
   )
   public final int field3776;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1972745365
   )
   final int field3783;

   class316(int var3, int var4) {
      this.field3776 = var3;
      this.field3783 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field3783;
   }
}
