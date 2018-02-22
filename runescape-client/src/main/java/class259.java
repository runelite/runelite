import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public enum class259 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3376(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3380(2, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   field3377(1, 2);

   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 2034930875
   )
   static int field3381;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 824928009
   )
   public final int field3378;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1460126287
   )
   final int field3375;

   class259(int var3, int var4) {
      this.field3378 = var3;
      this.field3375 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field3375;
   }
}
