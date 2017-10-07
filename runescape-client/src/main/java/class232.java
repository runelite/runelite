import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public enum class232 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3194("runescape", "RuneScape", 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3193("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3199("game3", "Game 3", 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3192("game4", "Game 4", 3),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3196("game5", "Game 5", 4),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field3197("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 499676761
   )
   final int field3195;
   @ObfuscatedName("r")
   public final String field3198;

   class232(String var3, String var4, int var5) {
      this.field3198 = var3;
      this.field3195 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3195;
   }
}
