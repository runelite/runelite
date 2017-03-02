import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class179 implements class158 {
   @ObfuscatedName("n")
   public final String field2683;
   @ObfuscatedName("l")
   public static final class179 field2684 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("i")
   public static final class179 field2685 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("b")
   public static final class179 field2686 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("t")
   public static final class179 field2687 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("h")
   public static final class179 field2688 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -409862269
   )
   final int field2690;
   @ObfuscatedName("bj")
   static ModIcon[] field2691;
   @ObfuscatedName("k")
   public static final class179 field2693 = new class179("game5", "Game 5", 4);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod4183() {
      return this.field2690;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2683 = var1;
      this.field2690 = var3;
   }
}
