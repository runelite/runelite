import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class157 implements class115 {
   @ObfuscatedName("ap")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("i")
   public static final class157 field2332 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("e")
   public static final class157 field2333 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("g")
   public static final class157 field2334 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 952261903
   )
   static int field2335;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1019954543
   )
   static int field2336;
   @ObfuscatedName("u")
   public static final class157 field2337 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1898782621
   )
   final int field2338;
   @ObfuscatedName("n")
   public static final class157 field2339 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("h")
   public static final class157 field2340 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("d")
   public final String field2341;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1975371437
   )
   static int field2342;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2341 = var1;
      this.field2338 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970198235"
   )
   public int vmethod3197() {
      return this.field2338;
   }
}
