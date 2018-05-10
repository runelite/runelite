import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3498(2, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3495(0, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3496(1, 2);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1312786803
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1197192137
   )
   final int field3497;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3497 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field3497;
   }
}
