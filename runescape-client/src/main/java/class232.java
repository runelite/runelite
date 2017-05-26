import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class232 implements class178 {
   @ObfuscatedName("g")
   public static final class232 field3181;
   @ObfuscatedName("h")
   public static final class232 field3182;
   @ObfuscatedName("u")
   public static final class232 field3183;
   @ObfuscatedName("q")
   public static final class232 field3184;
   @ObfuscatedName("i")
   public static final class232 field3186;
   @ObfuscatedName("t")
   public final String field3187;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1847774459
   )
   final int field3188;
   @ObfuscatedName("v")
   public static final class232 field3189;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class232(String var1, String var2, int var3) {
      this.field3187 = var1;
      this.field3188 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3188;
   }

   static {
      field3186 = new class232("runescape", "RuneScape", 0);
      field3182 = new class232("stellardawn", "Stellar Dawn", 1);
      field3183 = new class232("game3", "Game 3", 2);
      field3184 = new class232("game4", "Game 4", 3);
      field3181 = new class232("game5", "Game 5", 4);
      field3189 = new class232("oldscape", "RuneScape 2007", 5);
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
