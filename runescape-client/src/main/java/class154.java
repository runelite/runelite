import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class154 implements class112 {
   @ObfuscatedName("r")
   public static final class154 field2310 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("t")
   public static final class154 field2311 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("g")
   public static final class154 field2312 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("h")
   public static final class154 field2313 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("z")
   public static final class154 field2314 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -969750947
   )
   final int field2315;
   @ObfuscatedName("f")
   public final String field2316;
   @ObfuscatedName("i")
   public static final class154 field2319 = new class154("stellardawn", "Stellar Dawn", 1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int vmethod3145() {
      return this.field2315;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method3130(int var0, boolean var1) {
      return var0 < 0?Integer.toString(var0):class163.method3185(var0, 10, var1);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2316 = var1;
      this.field2315 = var3;
   }
}
