import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3357("runescape", "RuneScape", 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3352("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3353("game3", "Game 3", 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3350("game4", "Game 4", 3),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3354("game5", "Game 5", 4),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3355("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("s")
   @Export("name")
   public final String name;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1374023755
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1173889599"
   )
   public static boolean method4636(char var0) {
      return var0 >= '0' && var0 <= '9';
   }
}
