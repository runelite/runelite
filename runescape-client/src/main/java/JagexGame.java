import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3294("runescape", "RuneScape", 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3291("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3289("game3", "Game 3", 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3292("game4", "Game 4", 3),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3293("game5", "Game 5", 4),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3290("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("s")
   @Export("name")
   public final String name;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1209982667
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
