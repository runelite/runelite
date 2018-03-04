import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3357("runescape", "RuneScape", 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3351("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3350("game3", "Game 3", 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3355("game4", "Game 4", 3),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3354("game5", "Game 5", 4),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3352("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("k")
   @Export("name")
   public final String name;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1937627611
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
