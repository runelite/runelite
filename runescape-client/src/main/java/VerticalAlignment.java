import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3277(0, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3273(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   field3274(2, 2);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2070321655
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1686539261
   )
   @Export("id")
   final int id;

   private VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }
}
