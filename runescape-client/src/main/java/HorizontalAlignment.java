import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3698(2, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3702(0, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3699(1, 2);

   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1600437789
   )
   static int field3697;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1442749709
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1657418347
   )
   final int field3701;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3701 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field3701;
   }
}
