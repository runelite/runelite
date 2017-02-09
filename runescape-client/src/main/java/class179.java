import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class179 implements class165 {
   @ObfuscatedName("y")
   public static final class179 field2670 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1639800459
   )
   final int field2671;
   @ObfuscatedName("r")
   public static final class179 field2672 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("j")
   public static final class179 field2674 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("q")
   public final String field2675;
   @ObfuscatedName("o")
   public static final class179 field2676 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("s")
   static ModIcon field2677;
   @ObfuscatedName("w")
   public static final class179 field2679 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("k")
   public static final class179 field2680 = new class179("runescape", "RuneScape", 0);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-505678853"
   )
   public int vmethod4057() {
      return this.field2671;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2675 = var1;
      this.field2671 = var3;
   }
}
