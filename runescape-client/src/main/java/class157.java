import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class157 implements class115 {
   @ObfuscatedName("n")
   public final String field2347;
   @ObfuscatedName("d")
   static final class157 field2348 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("v")
   static final class157 field2349 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("a")
   static final class157 field2350 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("z")
   static final class157 field2351 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("t")
   public static final class157 field2352 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 764877453
   )
   final int field2354;
   @ObfuscatedName("r")
   static final class157 field2355 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("bl")
   static ModIcon field2356;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1565114944"
   )
   public int vmethod3214() {
      return this.field2354;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2347 = var1;
      this.field2354 = var3;
   }
}
