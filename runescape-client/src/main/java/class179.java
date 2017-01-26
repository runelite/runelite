import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class179 implements class158 {
   @ObfuscatedName("g")
   static final class179 field2681 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("x")
   static final class179 field2682 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("q")
   static final class179 field2683 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("d")
   static final class179 field2684 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("k")
   public static final class179 field2685 = new class179("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("p")
   static final class179 field2686 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 138882937
   )
   final int field2687;
   @ObfuscatedName("j")
   public final String field2688;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9241"
   )
   public int vmethod4074() {
      return this.field2687;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2688 = var1;
      this.field2687 = var3;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-82"
   )
   static final String method3265(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
