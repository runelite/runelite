import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public enum class228 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3137(2, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3128(6, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3134(7, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3130(0, 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3131(5, 4),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3139(3, 5),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3133(4, 6),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field3132(1, 7);

   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2019839363
   )
   public final int field3135;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2049172391
   )
   final int field3136;

   class228(int var3, int var4) {
      this.field3135 = var3;
      this.field3136 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3136;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public static void method4089() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
