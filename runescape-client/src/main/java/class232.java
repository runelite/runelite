import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public enum class232 implements RSEnum {
   @ObfuscatedName("i")
   field3202("runescape", "RuneScape", 0),
   @ObfuscatedName("w")
   field3198("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("a")
   field3204("game3", "Game 3", 2),
   @ObfuscatedName("t")
   field3200("game4", "Game 4", 3),
   @ObfuscatedName("s")
   field3201("game5", "Game 5", 4),
   @ObfuscatedName("r")
   field3199("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1239787385
   )
   final int field3197;
   @ObfuscatedName("v")
   public final String field3203;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   private class232(String var3, String var4, int var5) {
      this.field3203 = var3;
      this.field3197 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3197;
   }
}
