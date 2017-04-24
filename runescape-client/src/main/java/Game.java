import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("Game")
public class Game implements class158 {
   @ObfuscatedName("i")
   public static final Game field2704 = new Game("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("u")
   public static final Game field2705 = new Game("game3", "Game 3", 2);
   @ObfuscatedName("h")
   public static final Game field2706 = new Game("game4", "Game 4", 3);
   @ObfuscatedName("o")
   //@Export("runescape2007")
   public static final Game runescape2007 = new Game("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("l")
   @Export("name")
   public final String name;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1016414607
   )
   @Export("number")
   final int number;
   @ObfuscatedName("r")
   public static final Game field2711 = new Game("game5", "Game 5", 4);
   @ObfuscatedName("f")
   public static final Game field2713 = new Game("runescape", "RuneScape", 0);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1935391427"
   )
   public int vmethod4085() {
      return this.number;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   Game(String var1, String var2, int var3) {
      this.name = var1;
      this.number = var3;
   }
}
