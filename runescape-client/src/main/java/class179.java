import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class179 implements class158 {
   @ObfuscatedName("m")
   public static final class179 field2691 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("b")
   public static final class179 field2692 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("o")
   public static final class179 field2693 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("h")
   public static final class179 field2694 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("v")
   public static final class179 field2695 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 771842219
   )
   final int field2696;
   @ObfuscatedName("g")
   public static final class179 field2697 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("l")
   public final String field2700;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int vmethod3989() {
      return this.field2696;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2700 = var1;
      this.field2696 = var3;
   }
}
