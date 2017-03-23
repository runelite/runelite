import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class179 implements class158 {
   @ObfuscatedName("i")
   public static final class179 field2704 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("u")
   public static final class179 field2705 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("h")
   public static final class179 field2706 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("o")
   public static final class179 field2708 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("l")
   public final String field2709;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1016414607
   )
   final int field2710;
   @ObfuscatedName("r")
   public static final class179 field2711 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("f")
   public static final class179 field2713 = new class179("runescape", "RuneScape", 0);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1935391427"
   )
   public int vmethod4085() {
      return this.field2710;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2709 = var1;
      this.field2710 = var3;
   }
}
