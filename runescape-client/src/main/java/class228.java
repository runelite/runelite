import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public enum class228 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3160(6, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3154(5, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3155(1, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3156(0, 3),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3162(2, 4),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3157(4, 5),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3159(7, 6),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   field3158(3, 7);

   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2098498661
   )
   final int field3153;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -956915519
   )
   public final int field3161;

   class228(int var3, int var4) {
      this.field3161 = var3;
      this.field3153 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3153;
   }
}
