import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public enum class221 implements RSEnum {
   @ObfuscatedName("i")
   field2828(0, 0),
   @ObfuscatedName("w")
   field2830(1, 0),
   @ObfuscatedName("a")
   field2821(2, 0),
   @ObfuscatedName("t")
   field2822(3, 0),
   @ObfuscatedName("s")
   field2823(9, 2),
   @ObfuscatedName("r")
   field2824(4, 1),
   @ObfuscatedName("v")
   field2831(5, 1),
   @ObfuscatedName("y")
   field2836(6, 1),
   @ObfuscatedName("j")
   field2827(7, 1),
   @ObfuscatedName("k")
   field2826(8, 1),
   @ObfuscatedName("e")
   field2829(12, 2),
   @ObfuscatedName("o")
   field2825(13, 2),
   @ObfuscatedName("z")
   field2833(14, 2),
   @ObfuscatedName("l")
   field2832(15, 2),
   @ObfuscatedName("c")
   field2840(16, 2),
   @ObfuscatedName("m")
   field2834(17, 2),
   @ObfuscatedName("b")
   field2835(18, 2),
   @ObfuscatedName("f")
   field2820(19, 2),
   @ObfuscatedName("n")
   field2837(20, 2),
   @ObfuscatedName("u")
   field2838(21, 2),
   @ObfuscatedName("p")
   field2839(10, 2),
   @ObfuscatedName("q")
   field2819(11, 2),
   @ObfuscatedName("d")
   field2841(22, 3);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1708730849
   )
   public final int field2842;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field2842;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var3, int var4) {
      this.field2842 = var3;
   }
}
