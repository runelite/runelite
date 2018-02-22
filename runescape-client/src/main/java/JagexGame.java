import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3309("runescape", "RuneScape", 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3305("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3308("game3", "Game 3", 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3307("game4", "Game 4", 3),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3304("game5", "Game 5", 4),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3306("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("l")
   @Export("name")
   public final String name;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 192316533
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
