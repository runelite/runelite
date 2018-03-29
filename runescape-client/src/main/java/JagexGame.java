import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3348("runescape", "RuneScape", 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3349("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3354("game3", "Game 3", 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3350("game4", "Game 4", 3),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3351("game5", "Game 5", 4),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   field3352("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static BuildType field3355;
   @ObfuscatedName("z")
   @Export("name")
   public final String name;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1985086691
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
