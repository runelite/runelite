import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
//@Implements("Game")
public class Game implements class178 {
   @ObfuscatedName("g")
   public static final Game field3181;
   @ObfuscatedName("h")
   public static final Game field3182;
   @ObfuscatedName("u")
   public static final Game field3183;
   @ObfuscatedName("q")
   public static final Game field3184;
   @ObfuscatedName("i")
   public static final Game field3186;
   @ObfuscatedName("t")
   //@Export("name")
   public final String name;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1847774459
   )
  // @Export("number")
   final int number;
   @ObfuscatedName("v")
   public static final Game field3189;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   Game(String var1, String var2, int var3) {
      this.name = var1;
      this.number = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.number;
   }

   static {
      field3186 = new Game("runescape", "RuneScape", 0);
      field3182 = new Game("stellardawn", "Stellar Dawn", 1);
      field3183 = new Game("game3", "Game 3", 2);
      field3184 = new Game("game4", "Game 4", 3);
      field3181 = new Game("game5", "Game 5", 4);
      field3189 = new Game("oldscape", "RuneScape 2007", 5);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-82304079"
   )
   public static void method4169(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
