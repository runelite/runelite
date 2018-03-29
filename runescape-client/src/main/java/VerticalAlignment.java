import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   field3432(2, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   field3435(0, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   field3434(1, 2);

   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1410778253
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1378554303
   )
   final int field3436;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3436 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field3436;
   }
}
