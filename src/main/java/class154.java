import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class154 implements class112 {
   @ObfuscatedName("e")
   static final class154 field2307 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("x")
   static final class154 field2308 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("t")
   static final class154 field2309 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("w")
   static final class154 field2310 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("m")
   public final String field2311;
   @ObfuscatedName("y")
   public static final class154 field2312 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1414156175
   )
   final int field2314;
   @ObfuscatedName("p")
   static final class154 field2315 = new class154("game4", "Game 4", 3);

   @ObfuscatedName("w")
   public int vmethod3196() {
      return this.field2314;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1650202877"
   )
   static final void method3187() {
      int var0 = class32.field751;
      int[] var1 = class32.field757;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field415[var1[var2]];
         if(var3 != null) {
            class40.method873(var3);
         }
      }

   }

   class154(String var1, String var2, int var3) {
      this.field2311 = var1;
      this.field2314 = var3;
   }
}
