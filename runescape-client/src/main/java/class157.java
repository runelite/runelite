import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class157 implements class115 {
   @ObfuscatedName("x")
   public static final class157 field2335 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("z")
   public static final class157 field2336 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("i")
   public static final class157 field2337 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("b")
   public static final class157 field2338 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("l")
   public final String field2339;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 913580999
   )
   final int field2340;
   @ObfuscatedName("r")
   public static final class157 field2341 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("j")
   public static final class157 field2342 = new class157("game3", "Game 3", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2339 = var1;
      this.field2340 = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1074689381"
   )
   public int vmethod3206() {
      return this.field2340;
   }
}
