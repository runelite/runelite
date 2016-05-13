import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class154 implements class112 {
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 837665201
   )
   static int field2291;
   @ObfuscatedName("o")
   public final String field2292;
   @ObfuscatedName("p")
   public static final class154 field2293 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("x")
   public static final class154 field2294 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("j")
   public static final class154 field2295 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("u")
   public static final class154 field2296 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("d")
   public static final class154 field2297 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 684227889
   )
   final int field2298;
   @ObfuscatedName("s")
   public static final class154 field2299 = new class154("runescape", "RuneScape", 0);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693017402"
   )
   public int vmethod3150() {
      return this.field2298;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2292 = var1;
      this.field2298 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Ljava/lang/String;Ljava/lang/String;S)Lclass224;",
      garbageValue = "17761"
   )
   public static class224 method3143(class167 var0, class167 var1, String var2, String var3) {
      int var4 = var0.method3253(var2);
      int var5 = var0.method3254(var4, var3);
      class224 var6;
      if(!class35.method714(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var7 = var1.method3239(var4, var5);
         class224 var8;
         if(null == var7) {
            var8 = null;
         } else {
            class224 var9 = new class224(var7, class76.field1387, class76.field1390, class76.field1389, class9.field159, class76.field1396, class21.field575);
            class27.method633();
            var8 = var9;
         }

         var6 = var8;
      }

      return var6;
   }
}
