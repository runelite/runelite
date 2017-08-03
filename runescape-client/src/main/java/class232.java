import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public enum class232 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3179("runescape", "RuneScape", 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3172("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3173("game3", "Game 3", 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3178("game4", "Game 4", 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3175("game5", "Game 5", 4),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3176("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 914892731
   )
   final int field3174;
   @ObfuscatedName("v")
   public final String field3177;

   class232(String var3, String var4, int var5) {
      this.field3177 = var3;
      this.field3174 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3174;
   }
}
