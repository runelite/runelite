import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public enum class233 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3201("runescape", "RuneScape", 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3192("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3194("game3", "Game 3", 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3191("game4", "Game 4", 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3195("game5", "Game 5", 4),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   field3197("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -23494321
   )
   final int field3198;
   @ObfuscatedName("q")
   public final String field3199;

   class233(String var3, String var4, int var5) {
      this.field3199 = var3;
      this.field3198 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3198;
   }
}
