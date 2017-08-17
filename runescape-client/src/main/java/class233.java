import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public enum class233 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3184("runescape", "RuneScape", 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3187("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3185("game3", "Game 3", 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3189("game4", "Game 4", 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3186("game5", "Game 5", 4),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3188("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("c")
   public final String field3183;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 593128645
   )
   final int field3190;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;

   class233(String var3, String var4, int var5) {
      this.field3183 = var3;
      this.field3190 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3190;
   }
}
