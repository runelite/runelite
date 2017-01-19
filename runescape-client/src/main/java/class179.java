import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class179 implements class158 {
   @ObfuscatedName("k")
   public final String field2688;
   @ObfuscatedName("c")
   public static final class179 field2689 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("f")
   public static final class179 field2690 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("a")
   public static final class179 field2691 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("s")
   public static final class179 field2692 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("g")
   public static final class179 field2693 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("gj")
   static Widget field2694;
   @ObfuscatedName("h")
   public static final class179 field2696 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1065666681
   )
   final int field2698;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2688 = var1;
      this.field2698 = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17064"
   )
   public int vmethod3916() {
      return this.field2698;
   }
}
