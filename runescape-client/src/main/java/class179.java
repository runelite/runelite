import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class179 implements class158 {
   @ObfuscatedName("d")
   static final class179 field2671 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("j")
   static final class179 field2672 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("x")
   static final class179 field2673 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("c")
   static final class179 field2674 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("w")
   static final class179 field2675 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("h")
   public static final class179 field2676 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("u")
   public final String field2677;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1910566553
   )
   final int field2678;
   @ObfuscatedName("q")
   public static class144 field2679;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2677 = var1;
      this.field2678 = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int vmethod4085() {
      return this.field2678;
   }
}
