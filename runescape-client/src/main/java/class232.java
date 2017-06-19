import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public enum class232 implements RSEnum {
   @ObfuscatedName("p")
   field3205("runescape", "RuneScape", 0),
   @ObfuscatedName("m")
   field3199("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("e")
   field3201("game3", "Game 3", 2),
   @ObfuscatedName("t")
   field3202("game4", "Game 4", 3),
   @ObfuscatedName("w")
   field3203("game5", "Game 5", 4),
   @ObfuscatedName("z")
   field3207("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("j")
   public final String field3200;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1150411343
   )
   final int field3206;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1515035611
   )
   @Export("spellTargetFlags")
   static int spellTargetFlags;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3206;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   private class232(String var3, String var4, int var5) {
      this.field3200 = var3;
      this.field3206 = var5;
   }
}
